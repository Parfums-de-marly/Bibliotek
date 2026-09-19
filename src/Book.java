
public record Book(String author, String title, String ISBN, int id) {

    public String toString(){
        return String.format("""
    Author: %s
    Title: %s
    ISBN: %s
    ID: %s
    """, author, title, ISBN, id);
    }

}

