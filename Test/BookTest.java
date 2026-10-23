
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testBook() {
        Book book = new Book(
                "9783161484100",
                "Harry Potter",
                "J.K. Rowling",
                50
        );

        assertEquals("9783161484100", book.getIdentifier());
        assertEquals("Harry Potter", book.getTitle());
        assertEquals("J.K. Rowling", book.getCreator());
        assertEquals(50, book.getPages());
    }
}
