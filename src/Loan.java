import java.time.LocalDate;

public record Loan(Book book, Member member, LocalDate borrowedDate) {

    public LocalDate getDueDate(){
        return borrowedDate.plusDays(14);
    }

    /*
    public boolean isOverdue() {
        return LocalDate.now().isAfter(getDueDate());

    }

     */

    public String toString(){
        return book.toString() + "\n" + member.toString() + "\n" + "Afleveringsfrist " + getDueDate();
    }


}
