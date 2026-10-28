import java.time.LocalDate;
import java.util.List;

public class BornholmLoanPolicy implements LoanPolicy {

    @Override
    public boolean canLoan(Resource resource, List<Loan> loans, Member member){
        return true;
    }

    @Override
    public LocalDate calculateDueDate(Resource resource, LocalDate borrowDate) {
        if (resource instanceof AudioBook) {
            return borrowDate.plusDays(14);
        } else {
            return borrowDate.plusDays(30);
        }
    }



}
