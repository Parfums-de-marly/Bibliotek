import java.util.List;

void main() {
    Library library = new Library();

    List<Book> books = Book_Member_Data.getBooks();
    List<Member> members = Book_Member_Data.getMembers();
    List<VideoGame> videoGames = Book_Member_Data.getVideoGames();
    List<AudioBook> audioBooks = Book_Member_Data.getAudioBooks();
    List<Movie> movies = Book_Member_Data.getMovies();

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


    ConsoleUI consoleUI = new ConsoleUI(library);
    consoleUI.start();
}