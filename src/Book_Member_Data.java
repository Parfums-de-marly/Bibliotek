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
                new VideoGame("570123456763", "Call of duty", "Sony", "Ps4"),
                new VideoGame("570895793030", "Minecraft", "Mojang Studios", "PC")
        );
    }

    public static List<AudioBook> getAudioBooks(){
        return List.of(
                new AudioBook("9783161484100", "Mobby dick", "Harry", 45),
                new AudioBook("9783104783992", "Lord of the rings", "J.R.R. Tolkien", 220)
        );

    }

    public static List<Movie> getMovies(){
        return List.of(
                new Movie("5701234567890", "The Odyssey", "Warner Bros.", "Christopher Nolan", 120),
                new Movie("5709876543210", "Interstellar", "Paramount Pictures", "Christopher Nolan", 169)
        );
    }

    public static List<Member> getMembers(){
        return List.of(
                new Member("Jens Jensen", 1),
                new Member("Karl Karlsen", 2)
        );
    }
}