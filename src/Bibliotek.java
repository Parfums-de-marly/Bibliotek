import java.util.List;

void main() {
    Library library = new Library();

    List<Book> books = Book_Member_Data.getBooks();
    List<Member> members = Book_Member_Data.getMembers();

    for (Member member : members){
        library.addMember(member);
    }

    for (Book book : books){
        library.addBook(book);
    }

    ConsoleUI consoleUI = new ConsoleUI(library);
    consoleUI.run();
}