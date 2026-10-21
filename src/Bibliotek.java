import java.util.List;

void main() {
    Library library = new Library();

    List<Book> books = Book_Member_Data.getBooks();
    List<Member> members = Book_Member_Data.getMembers();
    List<VideoGame> VideoGames = Book_Member_Data.getVideoGames();
    List<AudioBook> AudioBooks = Book_Member_Data.getAudioBooks();

    for (Member member : members) {
        library.addMember(member);
    }

    for (Book book : books) {
        library.addResource(book);
    }

    for (VideoGame videogame: VideoGames) {
        library.addResource(videogame);
    }

    for (AudioBook audiobook : AudioBooks){
        library.addResource(audiobook);
    }


    ConsoleUI consoleUI = new ConsoleUI(library);
    consoleUI.start();
}