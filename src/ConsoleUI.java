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
                case 1 -> borrowBook();
                case 2 -> returnBook();
                case 3 -> showLoans();
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
        IO.println("0. Afslut");

    }

    private void borrowBook() {
        int memberId = Integer.parseInt(IO.readln("Indtast venligst dit medlemsnummer: "));
        int bookId = Integer.parseInt(IO.readln("Indtast bogens ID nummer, som du vil låne: "));
        boolean bookLoaned = library.loanBook(memberId, bookId);
        if (bookLoaned) {
            IO.println("-------------");
            IO.println("Du har lånt: \n" + library.getBook(bookId));
        } else {
            IO.println("Det lykkedes ikke at låne bogen.");
        }
    }

    private void returnBook() {
        int bookId = Integer.parseInt(IO.readln("Skriv bogens ID nummer, som du vil aflevere: "));
        boolean bookReturned = library.returnBook(bookId);
        if (bookReturned) {
            IO.println("-------------");
            IO.println("Du har afleveret bogen tilbage.");
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

}
