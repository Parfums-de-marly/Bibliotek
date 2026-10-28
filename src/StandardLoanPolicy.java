import java.time.LocalDate;
import java.util.List;

public class StandardLoanPolicy implements LoanPolicy {

    @Override
    public boolean canLoan(Resource resource, List<Loan> loans, Member member) {
        return true;
    }

    @Override
    public LocalDate calculateDueDate(Resource resource, LocalDate borrowDate){
        return borrowDate.plusDays(30);
    }
}
