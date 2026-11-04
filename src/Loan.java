import java.time.LocalDate;

public record Loan(
        Resource resource,
        Member member,
        LocalDate borrowedDate,
        LocalDate dueDate
) implements Comparable<Loan> {

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public int compareTo(Loan other) {
        return this.dueDate.compareTo(other.dueDate);
    }

    @Override
    public String toString() {
        return resource
                + "\nLåner: " + member.name()
                + "\nLånedato: " + borrowedDate
                + "\nAfleveringsfrist: " + getDueDate();
    }
}