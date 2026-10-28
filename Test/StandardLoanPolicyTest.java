import org.junit.jupiter.api.Test;
import java.util.List;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StandardLoanPolicyTest {

    @Test
    void canLoanReturnTrue() {
        StandardLoanPolicy policy = new StandardLoanPolicy();

        Book book = new Book("9721487147", "Java", "Et eller andet", 286);
        Member member = new Member("Henrik", 111);
        List<Loan> loans = List.of();

        boolean result = policy.canLoan(book, loans, member);
        assertTrue(result);
    }

    @Test
    void calculateDueDateReturn() {
        StandardLoanPolicy policy = new StandardLoanPolicy();

        Book book = new Book("9721487147", "Java", "Et eller andet", 286);
        LocalDate borrowDate = LocalDate.of(2026, 1, 1);

        LocalDate dueDate = policy.calculateDueDate(book, borrowDate);

        assertEquals(LocalDate.of(2026, 1, 31), dueDate);
    }

}
