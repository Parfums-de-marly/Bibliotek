
public class Book {
        final String author;
        final String title;
        final String ISBN;
        final int id;

    public Book(String author, String title, String ISBN, int id) {
        this.author = author;
        this.title = title;
        this.ISBN = ISBN;
        this.id = id;

    }

    public String toString(){
        return String.format("""
    Author: %s
    Title: %s
    ISBN: %s
    ID: %s
    """, author, title, ISBN, id);
    }

}

