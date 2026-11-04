import java.util.List;
import java.nio.file.Path;
import java.nio.file.Files;

void main(String[] args) throws Exception {

    if (args.length == 0) {
        IO.println("Angiv en mappe til bibliotekets CSV-filer.");
        return;
    }

    Path libraryDirectory = Path.of(args[0]);
    Files.createDirectories(libraryDirectory);

    LoanPolicy loanPolicy = new StandardLoanPolicy();
    Library library = new Library(loanPolicy);

    LibraryLoader loader = new LibraryLoader(libraryDirectory);

    List<Member> members = loader.loadMembers();
    List<Book> books = loader.loadBooks();
    List<VideoGame> videoGames = loader.loadVideoGame();
    List<AudioBook> audioBooks = loader.loadAudioBook();
    List<Movie> movies = loader.loadMovie();

    for (Member member : members) {
        library.addMember(member);
    }

    for (Book book : books) {
        library.addResource(book);
    }

    for (VideoGame videogame: videoGames) {
        library.addResource(videogame);
    }

    for (AudioBook audiobook : audioBooks){
        library.addResource(audiobook);
    }

    for (Movie movie : movies){
        library.addResource(movie);
    }

    List<Loan> loans = loader.loadLoans(library);
    for (Loan loan : loans) {
        library.addLoan(loan);
    }

    LibrarySaver saver = new LibrarySaver(libraryDirectory);
    ConsoleUI consoleUI = new ConsoleUI(library, saver);
    consoleUI.start();
}

