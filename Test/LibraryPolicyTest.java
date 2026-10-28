import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryPolicyTest{
    @Test
    void libraryCallsBothLoanPolicyMethods(){
        TestDoubleLoanPolicy policy = new TestDoubleLoanPolicy();
        Library library = new Library(policy);

        Book book = new Book("9721487147", "Java", "Et eller andet", 286);
        Member member = new Member("Henrik", 111);

        library.addResource(book);
        library.addMember(member);

        library.loan(book.getIdentifier(), member.id());

        assertTrue(policy.canLoanCalled);
        assertTrue(policy.calculateDueDateCalled);

    }
}
