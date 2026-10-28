import java.time.LocalDate;

public record Loan(
        Resource resource,
        Member member,
        LocalDate borrowedDate,
        LocalDate dueDate
) {
    public LocalDate getDueDate() {
        return dueDate;
    }


    @Override
    public String toString() {
        return resource
                + "\nLåner: " + member.name()
                + "\nLånedato: " + borrowedDate
                + "\nAfleveringsfrist: " + getDueDate();
    }
}