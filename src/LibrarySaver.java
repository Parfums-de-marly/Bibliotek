import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;

public class LibrarySaver {

    private final LibraryCsvMapper mapper = new LibraryCsvMapper();
    private final Path libraryDirectory;

    public LibrarySaver(Path libraryDirectory) {
        this.libraryDirectory = libraryDirectory;
    }

    public void saveMembers(List<Member> members) throws IOException {
        writeFile("member.csv", members, mapper::toCsv);
    }

    public void saveBooks(List<Book> books) throws IOException {
        writeFile("books.csv", books, mapper::toCsv);
    }

    public void saveMovie(List<Movie> movies) throws IOException {
        writeFile("movie.csv", movies, mapper::toCsv);
    }

    public void saveAudioBook(List<AudioBook> audioBooks) throws IOException {
        writeFile("audiobook.csv", audioBooks, mapper::toCsv);
    }

    public void saveVideoGame(List<VideoGame> videoGames) throws IOException {
        writeFile("videogame.csv", videoGames, mapper::toCsv);
    }

    public void saveLoans(List<Loan> loans) throws IOException {
        writeFile("loans.csv", loans, mapper::toCsv);
    }

    private <T> void writeFile(String fileName, List<T> objects, Function<T, String> mapperFunction) throws IOException {
        Files.createDirectories(libraryDirectory);

        Path path = libraryDirectory.resolve(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (T object : objects) {
                writer.write(mapperFunction.apply(object));
                writer.newLine();
            }
        }
    }
}