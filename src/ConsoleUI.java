import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ConsoleUI {
    private Library library;
    private LibrarySaver saver;
    private Path path;

    public ConsoleUI(Library library, LibrarySaver saver, Path path) {
        this.library = library;
        this.saver = saver;
        this.path = path;
    }

    public void run() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(IO.readln("Vælg et nummer fra menuen: "));
            switch (choice) {
                case 1 -> borrowResource();
                case 2 -> returnResource();
                case 3 -> {
                    chooseSortingLoan();
                    int sortingChoice = Integer.parseInt(IO.readln("Vælg hvordan du vil sortere lånene: "));
                    switch (sortingChoice) {
                        case 1 -> printLoansSortedByDueDate();
                        case 2 -> printLoansSortedByBorrowedDate();
                        default -> IO.println("Vælg et gyldigt tal fra menuen");
                    }
                }
                case 4 -> {
                    chooseSortingResource();
                    int sortingChoice = Integer.parseInt(IO.readln("Vælg hvordan du vil sortere materialet: "));
                    switch (sortingChoice) {
                        case 1 -> printResourcesSortedByCreator();
                        case 2 -> printResourcesSortedByIdentifier();
                        case 3 -> printResourcesSortedByTitle();
                        default -> IO.println("Vælg et gyldigt tal fra menuen");
                    }
                }
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg. Prøv igen.");
            }

        }
    }

    private void showMenu() {
        IO.println("");
        IO.println("1. Lån");
        IO.println("2. Aflever");
        IO.println("3. Vis alle lån");
        IO.println("4. Vis materiale");
        IO.println("0. Afslut");

    }

    private void chooseSortingResource() {
        IO.println("1. Sorter efter forfatter");
        IO.println("2. Sorter efter identifikationsnummer");
        IO.println("3. Sorter efter titel");
    }

    private void chooseSortingLoan() {
        IO.println("1. Sorter efter afleveringsdato");
        IO.println("2. Sorter efter lånedato");
    }

    private void borrowResource() {
        int memberId = Integer.parseInt(IO.readln("Indtast venligst dit medlemsnummer: "));
        String identifier = IO.readln("Indtast materialets nummer, som du vil låne: ");
        LoanResult resourceLoaned = library.loanResource(memberId, identifier);
        switch (resourceLoaned) {
            case NOT_MEMBER -> IO.println("Du er ikke medlem");
            case NO_RESOURCE -> IO.println("Den ejer vi ikke i vores system");
            case ALREADY_LOANED -> IO.println("Den er desværre allerede udlånt");
            case SUCCESS -> {
                try {
                    saver.saveLoans(library.getLoans(), path);
                    IO.println("Du har lånt: " + library.getResource(identifier));
                } catch (IOException e) {
                    IO.println("Der skete en fejl: " + e.getLocalizedMessage());
                }
            }
            case POLICY_NOT_ALLOWED -> IO.println("Det overholder ikke vores lånepolitik");
        }
    }

    private void returnResource() {
        String identifier = IO.readln("Skriv materialets nummer, som du vil aflevere: ");
        boolean resourceReturned = library.returnResource(identifier);
        if (resourceReturned) {
            try {
                saver.saveLoans(library.getLoans(), path);
                IO.println("-------------");
                IO.println("Du har afleveret materialet tilbage.");
            } catch (IOException e) {
                IO.println("Der skete en fejl: " + e.getLocalizedMessage());
            }
        } else {
            IO.println("Der skete en fejl");
        }
    }

    private void printResourcesSortedByIdentifier() {
        List<Resource> sortedResources = library.getResourcesSortedByIdentifier();
        for (Resource resource : sortedResources) {
            IO.println(resource);
        }
    }

    private void printResourcesSortedByCreator() {
        List<Resource> sortedResources = library.getResourcesSortedByCreator();
        for (Resource resource : sortedResources) {
            IO.println(resource);
        }
    }

    private void printResourcesSortedByTitle() {
        List<Resource> sortedResources = library.getResourcesSortedByTitle();
        for (Resource resource : sortedResources) {
            IO.println(resource);
        }
    }

    private void printLoansSortedByDueDate() {
        int memberId = Integer.parseInt(IO.readln("Indtast dit medlemsnummer, og se dine lån: "));
        List<Loan> memberLoans = library.findLoansByMemberId(memberId);
        memberLoans.sort(null);
        if (memberLoans.isEmpty()) {
            IO.println("-------------");
            IO.println("Du har ingen lån");

        } else {
            for (Loan loan : memberLoans) {
                IO.println(loan.toString());
            }
        }

    }

    private void printLoansSortedByBorrowedDate() {
        int memberId = Integer.parseInt(IO.readln("Indtast dit medlemsnummer, og se dine lån: "));
        List<Loan> memberLoans = library.findLoansByMemberId(memberId);
        memberLoans.sort(new LoanBorrowedDateComparator());
        if (memberLoans.isEmpty()) {
            IO.println("-------------");
            IO.println("Du har ingen lån");

        } else {
            for (Loan loan : memberLoans) {
                IO.println(loan.toString());
            }
        }

    }

}
