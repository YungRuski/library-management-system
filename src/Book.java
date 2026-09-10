import java.time.LocalDate;

public class Book {
    final String title;
    final String author;
    final String isbn;
    final int idNr;
    Member borrowedBy;
    LocalDate borrowedDate;

    public Book(String title, String author, String isbn, int idNr) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.idNr = idNr;
        this.borrowedBy = null;
        this.borrowedDate = null;
    }

    public boolean isAvailable() {
        return borrowedBy == null;
    }

    public boolean loanBook(Member member) {
        if (isAvailable()) {
            borrowedBy = member;
            borrowedDate = LocalDate.now();
            return true;
        } else {
            return false;
        }
    }

    public void returnBook() {
        borrowedBy = null;
        borrowedDate = null;
    }

    public LocalDate getDueDate() {
        if (!isAvailable()) {
            return borrowedDate.plusDays(14);
        } else {
            return null;
        }
    }

    public String toString() {
        String status = isAvailable() ? "På hylden" : "\nBorrowed by: " + borrowedBy +
                "Afleveringsfrist: " + getDueDate();
        return String.format("""
                Titel: %s
                Forfatter: %s
                ISBN: %s
                ID nr: %s
                %s
                """, title, author, isbn, idNr, status);
    }
}
