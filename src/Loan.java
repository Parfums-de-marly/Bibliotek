import java.time.LocalDate;

public record Loan(
        Resource resource,
        Member member,
        LocalDate borrowedDate
) {
    public LocalDate getDueDate() {
        return borrowedDate.plusDays(14);
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(getDueDate());
    }

    @Override
    public String toString() {
        return resource
                + "\nLåner: " + member.name()
                + "\nLånedato: " + borrowedDate
                + "\nAfleveringsfrist: " + getDueDate();
    }
}