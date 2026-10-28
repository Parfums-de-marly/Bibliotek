import java.time.LocalDate;
import java.util.List;

public class AalborgLoanPolicy implements LoanPolicy {


    @Override
    public boolean canLoan(Resource resource, List<Loan> loans, Member member){
        int memberLoanCount = 0;

        for (Loan loan : loans){
            if (loan.member().equals(member) && loan.resource() instanceof Movie || loan.resource() instanceof VideoGame){
                memberLoanCount++;
            }

            if (resource instanceof Movie || resource instanceof VideoGame) {
                return memberLoanCount < 3;
            }

        }
        return true;
    }

    @Override
    public LocalDate calculateDueDate(Resource resource, LocalDate borrowDate) {
        return borrowDate.plusDays(30);
    }



}
