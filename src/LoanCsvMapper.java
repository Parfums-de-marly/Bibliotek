import java.time.LocalDate;

public class LoanCsvMapper {

    public String toCsv(Loan loan) {
        return loan.resource().getIdentifier() + "," + loan.member().id() + "," + loan.borrowedDate() + "," + loan.dueDate();
    }

    public Loan fromCsv(String line, Library library){
        String[] parts = line.split(",");

        Resource resource = library.getResource(parts[0]);
        Member member = library.getMember(Integer.parseInt(parts[1]));
        LocalDate borrowDate = LocalDate.parse(parts[2]);
        LocalDate dueDate = LocalDate.parse(parts[3]);

        return new Loan(resource,member,borrowDate,dueDate);
    }
}
