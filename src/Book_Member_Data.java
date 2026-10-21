import java.util.List;

public class Book_Member_Data {

    public static List<Book> getBooks(){
        return List.of(
                new Book("9781492072508", "Think Java", "Allan B. Downey", 499),
                new Book("9788763851664", "Omrids", "Rachel Cusk", 926)
        );
    }

    public static List<VideoGame> getVideoGames() {
        return List.of(
                new VideoGame("5701234567890", "Call of duty", "Sony", "Ps4")
        );
    }

    public static List<AudioBook> getAudioBooks(){
        return List.of(
                new AudioBook("9783161484100", "Mobby dick", "Harry", 20)
        );

    }

    public static List<Member> getMembers(){
        return List.of(
                new Member("Jens Jensen", 111),
                new Member("Karl Karlsen", 222),
                new Member("Nikolai Nikolaisen", 333),
                new Member("Peter Petersen", 444),
                new Member("Anders Andersen", 555)
        );
    }
}