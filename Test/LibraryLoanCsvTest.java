
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryLoanCsvTest {

    private final LibraryCsvMapper mapper = new LibraryCsvMapper();

    @Test
    void loanCanBeConvertedToAndFromCsv() {
        Library library = new Library(new StandardLoanPolicy());

        Member member = new Member("Harry Potter", 1);
        Book book = new Book("B1", "Harry Potter", "J.K. Rowling", 350);

        library.addMember(member);
        library.addResource(book);

        LocalDate borrowedDate = LocalDate.of(2026, 11, 4);
        LocalDate dueDate = LocalDate.of(2026, 11, 18);

        Loan loan = new Loan(book, member, borrowedDate, dueDate);

        String csv = mapper.toCsv(loan);

        Loan loadedLoan = mapper.loanFromCsv(csv, library);

        assertEquals(loan.resource(), loadedLoan.resource());
        assertEquals(loan.member(), loadedLoan.member());
        assertEquals(loan.borrowedDate(), loadedLoan.borrowedDate());
        assertEquals(loan.dueDate(), loadedLoan.dueDate());
    }
}
