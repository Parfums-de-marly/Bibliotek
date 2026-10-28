
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest {

    @Test
    void testLoan() {
        Book book = new Book(
                "9783161484100",
                "Harry Potter",
                "J.K. Rowling",
                50
        );

        Member member = new Member("Jens Jensen", 1);
        LocalDate borrowedDate = LocalDate.of(2026, 10, 1);
        LocalDate dueDate = LocalDate.of(2026, 10, 1);

        Loan loan = new Loan(book, member, borrowedDate, dueDate);

        assertSame(book, loan.resource());
        assertEquals(member, loan.member());
        assertEquals(borrowedDate, loan.borrowedDate());
    }

    @Test
    void testDueDate() {
        Book book = new Book(
                "9783161484100",
                "Harry Potter",
                "J.K. Rowling",
                50
        );

        Member member = new Member("Jens Jensen", 1);
        LocalDate borrowedDate = LocalDate.of(2026, 10, 1);
        LocalDate dueDate = LocalDate.of(2026, 10, 1);

        Loan loan = new Loan(book, member, borrowedDate, dueDate);

        assertEquals(
                LocalDate.of(2026, 10, 15),
                loan.getDueDate()
        );
    }
}
