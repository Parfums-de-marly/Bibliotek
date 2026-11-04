import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LibraryLoader {

    private final LibraryCsvMapper mapper = new LibraryCsvMapper();
    private final Path libraryDirectory;

    public LibraryLoader(Path libraryDirectory) {
        this.libraryDirectory = libraryDirectory;
    }

    public List<Member> loadMembers() throws IOException {
        return readFile("member.csv", mapper::memberFromCsv);
    }

    public List<Book> loadBooks() throws IOException {
        return readFile("books.csv", mapper::bookFromCsv);
    }

    public List<Movie> loadMovie() throws IOException {
        return readFile("movie.csv", mapper::movieFromCsv);
    }

    public List<AudioBook> loadAudioBook() throws IOException {
        return readFile("audiobook.csv", mapper::audioBookFromCsv);
    }

    public List<VideoGame> loadVideoGame() throws IOException {
        return readFile("videogame.csv", mapper::videoGameFromCsv);
    }

    public List<Loan> loadLoans(Library library) throws IOException {
        return readFile("loans.csv",
                line -> mapper.loanFromCsv(line, library));
    }

    private <T> List<T> readFile(String fileName, Function<String, T> mapperFunction) throws IOException {
        List<T> result = new ArrayList<>();
        Path path = libraryDirectory.resolve(fileName);

        if (!Files.exists(path)) {
            return result;
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            while ((line = reader.readLine()) != null) {
                result.add(mapperFunction.apply(line));
            }
        }

        return result;
    }
}