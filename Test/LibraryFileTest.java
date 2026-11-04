
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryFileTest {

    @TempDir
    Path tempDir;

    @Test
    void libraryDataCanBeSavedAndLoaded() throws Exception {

        LibrarySaver saver = new LibrarySaver(tempDir);
        LibraryLoader loader = new LibraryLoader(tempDir);

        Member member = new Member("Harry Potter", 1);
        Book book = new Book("B1", "Harry Potter", "J.K. Rowling", 350);
        Movie movie = new Movie("M1", "The Matrix", "Warner Bros", "Lana Wachowski", 136);
        AudioBook audioBook = new AudioBook("A1", "The Hobbit", "J.R.R. Tolkien", 680);
        VideoGame videoGame = new VideoGame("V1", "Minecraft", "Mojang", "PC");

        LocalDate borrowedDate = LocalDate.of(2026, 11, 4);
        LocalDate dueDate = LocalDate.of(2026, 11, 18);

        Loan loan = new Loan(book, member, borrowedDate, dueDate);

        // Gem data
        saver.saveMembers(List.of(member));
        saver.saveBooks(List.of(book));
        saver.saveMovie(List.of(movie));
        saver.saveAudioBook(List.of(audioBook));
        saver.saveVideoGame(List.of(videoGame));
        saver.saveLoans(List.of(loan));

        // Indlæs data
        List<Member> loadedMembers = loader.loadMembers();
        List<Book> loadedBooks = loader.loadBooks();
        List<Movie> loadedMovies = loader.loadMovie();
        List<AudioBook> loadedAudioBooks = loader.loadAudioBook();
        List<VideoGame> loadedVideoGames = loader.loadVideoGame();

        // Opret Library med indlæste medlemmer og materialer
        Library library = new Library(new StandardLoanPolicy());

        loadedMembers.forEach(library::addMember);
        loadedBooks.forEach(library::addResource);

        // Indlæs lån
        List<Loan> loadedLoans = loader.loadLoans(library);

        // Kontroller resultatet
        assertEquals(1, loadedMembers.size());
        assertEquals(1, loadedBooks.size());
        assertEquals(1, loadedMovies.size());
        assertEquals(1, loadedAudioBooks.size());
        assertEquals(1, loadedVideoGames.size());
        assertEquals(1, loadedLoans.size());

        assertEquals("Harry Potter", loadedMembers.get(0).name());
        assertEquals("B1", loadedBooks.get(0).getIdentifier());
        assertEquals("M1", loadedMovies.get(0).getIdentifier());
        assertEquals("A1", loadedAudioBooks.get(0).getIdentifier());
        assertEquals("V1", loadedVideoGames.get(0).getIdentifier());

        assertEquals(borrowedDate, loadedLoans.get(0).borrowedDate());
        assertEquals(dueDate, loadedLoans.get(0).dueDate());
    }
}
