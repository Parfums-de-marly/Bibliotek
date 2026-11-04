public class ConsoleUI {
    private final Library library;
    private final LibrarySaver saver;

    public ConsoleUI(Library library, LibrarySaver saver) {
        this.library = library;
        this.saver = saver;
    }

    public void start() {
        boolean running = true;

        while (running) {
            IO.println("\nBibliotek");
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
                case "6" -> {
                    saveLibrary();
                    running = false;
                }
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

        IO.println("Indtast medlemmets ID:");
        int memberId = Integer.parseInt(IO.readln());

        boolean returned = library.returnLoan(identifier, memberId);

        if (returned) {
            IO.println("Materialet er afleveret.");
        } else {
            IO.println("Der findes ikke et aktivt lån for dette materiale og medlem.");
        }
    }

    private void showAllLoans() {
        if (library.getLoans().isEmpty()) {
            IO.println("Der er ingen aktive lån.");
            return;
        }

        for (Loan loan : library.getLoans()) {
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

        IO.println("\nBøger:");
        for (Resource resource : library.getResources()) {
            if (resource instanceof Book) {
                IO.println(resource);
            }
        }

        IO.println("\nLydbøger:");
        for (Resource resource : library.getResources()) {
            if (resource instanceof AudioBook) {
                IO.println(resource);
            }
        }

        IO.println("\nFilm:");
        for (Resource resource : library.getResources()) {
            if (resource instanceof Movie) {
                IO.println(resource);
            }
        }

        IO.println("\nVideospil:");
        for (Resource resource : library.getResources()) {
            if (resource instanceof VideoGame) {
                IO.println(resource);
            }
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
            IO.println(loan);
        }
    }

    private void saveLibrary() {
        try {
            saver.saveMembers(library.getMembers());
            saver.saveBooks(library.getResources().stream().filter(Book.class::isInstance).map(Book.class::cast).toList());
            saver.saveMovie(library.getResources().stream().filter(Movie.class::isInstance).map(Movie.class::cast).toList());
            saver.saveAudioBook(library.getResources().stream().filter(AudioBook.class::isInstance).map(AudioBook.class::cast).toList());
            saver.saveVideoGame(library.getResources().stream().filter(VideoGame.class::isInstance).map(VideoGame.class::cast).toList());
            saver.saveLoans(library.getLoans());
        } catch (Exception e) {
            IO.println("Kunne ikke gemme biblioteket: " + e.getMessage());
        }
    }
}