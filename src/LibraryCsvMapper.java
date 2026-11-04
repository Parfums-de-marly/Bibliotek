
import java.time.LocalDate;

public class LibraryCsvMapper {

    public String toCsv(Member member) {
        return member.id() + "," + member.name();
    }

    public Member memberFromCsv(String line) {
        String[] parts = line.split(",");

        int id = Integer.parseInt(parts[0]);
        String name = parts[1];

        return new Member(name, id);
    }

    public String toCsv(Book book) {
        return book.getIdentifier() + "," + book.getTitle() + "," + book.getCreator() + "," + book.getPages();
    }

    public Book bookFromCsv(String line) {
        String[] parts = line.split(",");

        String identifier = parts[0];
        String title = parts[1];
        String creator = parts[2];
        int pages = Integer.parseInt(parts[3]);

        return new Book(identifier, title, creator, pages);
    }

    public String toCsv(Movie movie) {
        return movie.getIdentifier() + "," + movie.getTitle() + "," + movie.getStudio() + "," + movie.getDirector() + "," + movie.getDurationMinutes();
    }

    public Movie movieFromCsv(String line) {
        String[] parts = line.split(",");

        String identifier = parts[0];
        String title = parts[1];
        String studio = parts[2];
        String director = parts[3];
        int durationMinutes = Integer.parseInt(parts[4]);

        return new Movie(identifier, title, studio, director, durationMinutes);
    }

    public String toCsv(AudioBook audioBook) {
        return audioBook.getIdentifier() + "," + audioBook.getTitle() + "," + audioBook.getCreator() + "," + audioBook.getDurationMinutes();
    }

    public AudioBook audioBookFromCsv(String line) {
        String[] parts = line.split(",");

        String identifier = parts[0];
        String title = parts[1];
        String creator = parts[2];
        int durationMinutes = Integer.parseInt(parts[3]);

        return new AudioBook(identifier, title, creator, durationMinutes);
    }

    public String toCsv(VideoGame videoGame) {
        return videoGame.getIdentifier() + "," + videoGame.getTitle() + "," + videoGame.getCreator() + "," + videoGame.getPlatform();
    }

    public VideoGame videoGameFromCsv(String line) {
        String[] parts = line.split(",");

        String identifier = parts[0];
        String title = parts[1];
        String creator = parts[2];
        String platform = parts[3];

        return new VideoGame(identifier, title, creator, platform);
    }

    public String toCsv(Loan loan) {
        return loan.member().id() + ","
                + loan.resource().getIdentifier() + ","
                + loan.borrowedDate() + ","
                + loan.dueDate();
    }

    public Loan loanFromCsv(String line, Library library) {
        String[] parts = line.split(",");

        int memberId = Integer.parseInt(parts[0]);
        String identifier = parts[1];

        Member member = library.getMember(memberId);
        Resource resource = library.getResource(identifier);

        LocalDate borrowedDate = LocalDate.parse(parts[2]);
        LocalDate dueDate = LocalDate.parse(parts[3]);

        return new Loan(resource, member, borrowedDate, dueDate);
    }
}
