import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class LibrarySaver {

    private final MemberCsvMapper memberMapper = new MemberCsvMapper();
    private final BookCsvMapper bookMapper = new BookCsvMapper();
    private final MovieCsvMapper movieMapper = new MovieCsvMapper();
    private final AudioBookCsvMapper audioBookMapper = new AudioBookCsvMapper();
    private final VideoGameCsvMapper videoGameMapper = new VideoGameCsvMapper();
    private final LoanCsvMapper loanMapper = new LoanCsvMapper();


    private final Path libraryDirectory;
    public LibrarySaver(Path libraryDirectory) {
        this.libraryDirectory = libraryDirectory;
    }

    public void saveMembers(List<Member> members) throws IOException {
        Path path = libraryDirectory.resolve("member.csv");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Member member : members) {
                String line = memberMapper.toCsv(member);
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public void saveBooks(List<Book> books) throws IOException {
        Path path = libraryDirectory.resolve("books.csv");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Book book : books) {
                String line = bookMapper.toCsv(book);
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public void saveMovie(List<Movie> movies) throws IOException {
        Path path = libraryDirectory.resolve("movie.csv");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Movie movie : movies) {
                String line = movieMapper.toCsv(movie);
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public void saveAudioBook(List<AudioBook> audioBooks) throws IOException {
        Path path = libraryDirectory.resolve("audiobook.csv");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AudioBook audioBook : audioBooks) {
                String line = audioBookMapper.toCsv(audioBook);
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public void saveVideoGame(List<VideoGame> videoGames) throws IOException {
        Path path = libraryDirectory.resolve("videogame.csv");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (VideoGame videoGame : videoGames) {
                String line = videoGameMapper.toCsv(videoGame);
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public void saveLoans(List<Loan> loans) throws IOException {
        Path path = libraryDirectory.resolve("loans.csv");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Loan loan : loans) {
                String line = loanMapper.toCsv(loan);
                writer.write(line);
                writer.newLine();
            }
        }
    }

}