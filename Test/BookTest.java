import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class BookTest {
    @Test
    void testGetCreator() {
        Book book = new Book("9783161484100", "Harry Potter", "J.K. Rowling", 50);
        String creator = book.getCreator();
        assertEquals("J.K. Rowling", creator);

    }
}