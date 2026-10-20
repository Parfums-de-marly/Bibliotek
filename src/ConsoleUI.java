public class ConsoleUI {
    private final Library library;

    public ConsoleUI(Library library) {
        this.library = library;
    }

    public void start() {
        boolean running = true;

        while (running) {
            IO.println("\n--- Bibliotekssystem ---");
            IO.println("1. Lån materiale");
            IO.println("2. Aflever materiale");
            IO.println("3. Vis alle lån");
            IO.println("4. Vis alle materialer");
            IO.println("5. Vis lån for medlem");
            IO.println("6. Afslut");
            IO.println("Vælg en mulighed:");

            String choice = IO.readln();

            switch (choice) {
                case "1" -> loanResource();
                case "2" -> returnResource();
                case "3" -> showAllLoans();
                case "4" -> showResources();
                case "5" -> showMemberLoans();
                case "6" -> running = false;
                default -> IO.println("Ugyldigt valg.");
            }
        }
    }

    private void loanResource() {
        IO.println("Indtast materialets ISBN/EAN:");
        String identifier = IO.readln();

        IO.println("Indtast medlemmets ID:");
        int memberId = Integer.parseInt(IO.readln());

        LoanResult result = library.loan(identifier, memberId);

        switch (result) {
            case SUCCESS ->
                    IO.println("Materialet er nu lånt.");

            case MEMBER_NOT_REGISTERED ->
                    IO.println("Medlemmet er ikke registreret.");

            case RESOURCE_NOT_REGISTERED ->
                    IO.println("Materialet findes ikke i biblioteket.");

            case RESOURCE_ALREADY_LOANED ->
                    IO.println("Materialet er allerede udlånt.");
        }
    }

    private void returnResource() {
        IO.println("Indtast materialets ISBN/EAN:");
        String identifier = IO.readln();

        boolean returned = library.returnLoan(identifier);

        if (returned) {
            IO.println("Materialet er afleveret.");
        } else {
            IO.println("Der findes ikke et aktivt lån for materialet.");
        }
    }

    private void showAllLoans() {
        if (library.getLoans().isEmpty()) {
            IO.println("Der er ingen aktive lån.");
            return;
        }

        for (Loan loan : library.getLoans()) {
            IO.println("--------------------");
            IO.println(loan);
        }
    }

    private void showResources() {
        if (library.getResources().isEmpty()) {
            IO.println("Biblioteket har ingen materialer.");
            return;
        }

        for (Resource resource : library.getResources()) {
            IO.println(resource);
        }
    }

    private void showMemberLoans() {
        IO.println("Indtast medlemmets ID:");
        int memberId = Integer.parseInt(IO.readln());

        Member member = library.getMember(memberId);

        if (member == null) {
            IO.println("Medlemmet er ikke registreret.");
            return;
        }

        var memberLoans = library.findLoansByMemberId(memberId);

        if (memberLoans.isEmpty()) {
            IO.println("Medlemmet har ingen aktive lån.");
            return;
        }

        for (Loan loan : memberLoans) {
            IO.println("--------------------");
            IO.println(loan);
        }
    }
}