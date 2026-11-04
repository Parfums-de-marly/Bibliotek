import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LibraryLoader {

    private final MemberCsvMapper memberMapper = new MemberCsvMapper();
    private final BookCsvMapper bookMapper = new BookCsvMapper();
    private final MovieCsvMapper movieMapper = new MovieCsvMapper();
    private final AudioBookCsvMapper audioBookMapper = new AudioBookCsvMapper();
    private final VideoGameCsvMapper videoGameMapper = new VideoGameCsvMapper();
    private final LoanCsvMapper loanMapper = new LoanCsvMapper();


    private final Path libraryDirectory;

    public LibraryLoader(Path libraryDirectory) {
        this.libraryDirectory = libraryDirectory;
    }

    public List<Member> loadMembers() throws IOException {
        List<Member> members = new ArrayList<>();
        Path path = libraryDirectory.resolve("member.csv");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            while ((line = reader.readLine()) != null) {
                Member member = memberMapper.fromCsv(line);
                members.add(member);
            }
        }

        return members;
    }

    public List<Book> loadBooks() throws IOException{
        List<Book> books = new ArrayList<>();

        Path path = libraryDirectory.resolve("books.csv");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            while ((line = reader.readLine()) != null) {
                Book book = bookMapper.fromCsv(line);
                books.add(book);
            }
        }

        return books;
    }


    public List<Movie> loadMovie() throws IOException{
        List<Movie> movies = new ArrayList<>();

        Path path = libraryDirectory.resolve("movie.csv");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            while ((line = reader.readLine()) != null) {
                Movie movie = movieMapper.fromCsv(line);
                movies.add(movie);
            }
        }

        return movies;
    }

    public List<AudioBook> loadAudioBook() throws IOException{
        List<AudioBook> audioBooks = new ArrayList<>();

        Path path = libraryDirectory.resolve("audiobook.csv");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            while ((line = reader.readLine()) != null) {
                AudioBook audioBook = audioBookMapper.fromCsv(line);
                audioBooks.add(audioBook);
            }
        }

        return audioBooks;
    }


    public List<VideoGame> loadVideoGame() throws IOException{
        List<VideoGame> videoGames = new ArrayList<>();

        Path path = libraryDirectory.resolve("videogame.csv");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            while ((line = reader.readLine()) != null) {
                VideoGame videoGame = videoGameMapper.fromCsv(line);
                videoGames.add(videoGame);
            }
        }

        return videoGames;
    }

    public List<Loan> loadLoans(Library library) throws IOException {
        List<Loan> loans = new ArrayList<>();
        Path path = libraryDirectory.resolve("loans.csv");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            while ((line = reader.readLine()) != null) {
                Loan loan = loanMapper.fromCsv(line, library);
                loans.add(loan);
            }
        }

        return loans;
    }


    }
