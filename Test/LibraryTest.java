
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;
    private Book book;
    private Member member;
    private Member anotherMember;

    @BeforeEach
    void setUp() {
        library = new Library(new StandardLoanPolicy());

        book = new Book(
                "9783161484100",
                "Harry Potter",
                "J.K. Rowling",
                50
        );

        member = new Member("Jens Jensen", 1);
        anotherMember = new Member("Karl Karlsen", 2);

        library.addResource(book);
        library.addMember(member);
        library.addMember(anotherMember);
    }

    @Test
    void testSuccessfulLoan() {
        var today = java.time.LocalDate.now();

        LoanResult result = library.loan(book.getIdentifier(), member.id());


        assertEquals(LoanResult.SUCCESS, result);
        assertEquals(1, library.getLoans().size());

        Loan loan = library.getLoans().get(0);

        assertSame(book, loan.resource());
        assertEquals(member, loan.member());
        assertEquals(today, loan.borrowedDate());
    }

    @Test
    void testLoanWithUnknownResource() {
        LoanResult result = library.loan("UKENDT-ID", member.id());

        assertEquals(LoanResult.RESOURCE_NOT_REGISTERED, result);
        assertTrue(library.getLoans().isEmpty());
    }


    @Test
    void testLoanWithUnknownMember() {
        LoanResult result = library.loan(book.getIdentifier(), 999);

        assertEquals(LoanResult.MEMBER_NOT_REGISTERED, result);
        assertTrue(library.getLoans().isEmpty());
    }

    @Test
    void testLoanWhenResourceIsAlreadyLoaned() {
        library.loan(book.getIdentifier(), member.id());
        Loan originalLoan = library.getLoans().get(0);

        LoanResult result = library.loan(book.getIdentifier(), anotherMember.id());

        assertEquals(LoanResult.RESOURCE_ALREADY_LOANED, result);
        assertEquals(1, library.getLoans().size());
        assertSame(originalLoan, library.getLoans().get(0));
    }

    @Test
    void testLoanAgainAfterReturn() {
        assertEquals(LoanResult.SUCCESS, library.loan(book.getIdentifier(), member.id()));

        boolean returned = library.returnLoan(book.getIdentifier(), member.id());
        LoanResult secondResult = library.loan(book.getIdentifier(), anotherMember.id());

        assertTrue(returned);
        assertEquals(LoanResult.SUCCESS, secondResult);
        assertEquals(1, library.getLoans().size());
        assertEquals(
                anotherMember,
                library.getLoans().get(0).member()
        );
    }

    @Test
    void testCannotReturnLoanForWrongMember() {
        library.loan(book.getIdentifier(), member.id());
        Loan originalLoan = library.getLoans().get(0);

        boolean returned = library.returnLoan(book.getIdentifier(), anotherMember.id());

        assertFalse(returned);
        assertEquals(1, library.getLoans().size());
        assertSame(originalLoan, library.getLoans().get(0));
    }

    @Test
    void testCannotReturnResourceWithoutActiveLoan() {
        boolean returned = library.returnLoan(book.getIdentifier(), member.id());

        assertFalse(returned);
        assertTrue(library.getLoans().isEmpty());
    }


    @Test
    void testCannotReturnDifferentResource() {
        library.loan(book.getIdentifier(), member.id());
        Loan originalLoan = library.getLoans().get(0);

        boolean returned = library.returnLoan("FORKERT-ID", member.id());

        assertFalse(returned);
        assertEquals(1, library.getLoans().size());
        assertSame(originalLoan, library.getLoans().get(0));
    }
}
