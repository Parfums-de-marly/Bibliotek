import java.util.Comparator;

public class LoanDateComparator implements Comparator<Loan> {

    @Override
    public int compare(Loan loan1, Loan loan2) {
        return loan1.borrowedDate()
                .compareTo(loan2.borrowedDate());
    }
}