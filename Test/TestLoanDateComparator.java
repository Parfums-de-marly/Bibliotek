import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class TestLoanDateComparator {

    @Test
    void testLoanDateComparator() {
        //arrange
        Resource resource = null;
        Member member = null;
        LocalDate borrowedDate1 = LocalDate.parse("2016-11-11");
        LocalDate borrowedDate2 = LocalDate.parse("2026-09-20");
        LocalDate dueDate1 = LocalDate.parse("2017-11-11");
        LocalDate dueDate2 = LocalDate.parse("2026-10-20");
        List<Loan> loanList = new ArrayList<>();


        Loan loan1 = new Loan(resource,member, borrowedDate1, dueDate1);
        Loan loan2 = new Loan(resource, member, borrowedDate2, dueDate2);
        loanList.add(loan2);
        loanList.add(loan1);

        //act
        Collections.sort(loanList, new LoanDateComparator());

        //assert
        assertEquals(borrowedDate1, loanList.getFirst().borrowedDate());


    }
}
