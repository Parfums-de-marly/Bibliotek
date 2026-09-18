import java.util.List;

public class ConsoleUI {
    private Library library;

    public ConsoleUI(Library library){
        this.library = library;
    }

    private void showMenu(){
        IO.println();
        IO.println("1. Loan");
        IO.println("2. Hand over");
        IO.println("3. Show all loans");
        IO.println("0. End");
        IO.println();
    }

    public void run(){
        boolean running = true;

        while(running){
            showMenu();

            int choice = Integer.parseInt(IO.readln("Input Choice: "));

            switch (choice){
                case 1 -> borrowBook();
                case 2 -> returnBook();
                case 3 -> showLoans();
                case 0 -> running = false;
                default -> IO.println("Invalid input");

            }
        }
    }

    private void borrowBook(){
    int memberId = Integer.parseInt(IO.readln("Input memberId: "));
    int bookId = Integer.parseInt(IO.readln("Input BookId: "));

    if (library.loanBook(bookId, memberId)){
        IO.println("Loan registered");
    } else {
        IO.println("There has been a mistake");
        }
    }

    private void returnBook(){
        int bookId = Integer.parseInt(IO.readln("Input Book ID: "));
        if (library.returnBook(bookId)){
            IO.println("Hand over registered");
        } else {
            IO.println("There has been a mistake");
        }
    }

    private void showLoans(){
        int memberId = Integer.parseInt(IO.readln("Input MemberID: "));
        List<Loan> loans = library.findLoansByMemberId(memberId);

        if (loans.isEmpty()){
            IO.println("No loans");
        } else {
            for (Loan loan : loans){
                IO.println(loan);
            }
        }

    }
}


