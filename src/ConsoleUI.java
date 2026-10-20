import java.util.ArrayList;

public class ConsoleUI {
    private Library library;

    public ConsoleUI(Library library) {
        this.library = library;
    }

    public void run() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(IO.readln("Vælg et nummer fra menuen: "));
            switch (choice) {
                case 1 -> borrowResource();
                case 2 -> returnResource();
                case 3 -> showLoans();
                case 4 -> printLibrary();
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

    private void borrowResource() {
        int memberId = Integer.parseInt(IO.readln("Indtast venligst dit medlemsnummer: "));
        String identifier = IO.readln("Indtast materialets nummer, som du vil låne: ");
        LoanResult resourceLoaned = library.loanResource(memberId, identifier);
        switch (resourceLoaned) {
            case NOT_MEMBER -> IO.println("Du er ikke medlem");
            case NO_RESOURCE -> IO.println("Den ejer vi ikke i vores system");
            case ALREADY_LOANED -> IO.println("Den er desværre allerede udlånt");
            case SUCCESS -> IO.println("Du har lånt: " + library.getResource(identifier));
        }
    }

    private void returnResource() {
        String identifier = IO.readln("Skriv materialets nummer, som du vil aflevere: ");
        boolean resourceReturned = library.returnResource(identifier);
        if (resourceReturned) {
            IO.println("-------------");
            IO.println("Du har afleveret materialet tilbage.");
        } else {
            IO.println("Der skete en fejl");
        }
    }

    private void showLoans() {
        int memberId = Integer.parseInt(IO.readln("Indtast dit medlemsnummer, og se dine lån: "));
        ArrayList<Loan> memberLoans = library.findLoansByMemberId(memberId);
        if (memberLoans.isEmpty()){
            IO.println("-------------");
            IO.println("Du har ingen lån");

        }else {
            for (Loan loan : memberLoans) {
                IO.println(loan.toString());
            }
        }

    }
    private void printLibrary(){
        library.printResources();
    }

}
