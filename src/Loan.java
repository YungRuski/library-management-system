import java.time.LocalDate;

public class Loan {
    private final Book book;
    private final Member borrowedBy;
    private final LocalDate borrowedDate;

    public Loan(Book book, Member member, LocalDate borrowedDate) {
        this.book = book;
        this.borrowedBy = member;
        this.borrowedDate = borrowedDate;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return borrowedBy;
    }
    public LocalDate getDueDate(){
        return borrowedDate.plusDays(14);
    }
    public boolean isOverdue(){
        return LocalDate.now().isAfter(getDueDate());
    }
    public String toString(){
        String status = isOverdue() ? "OVERSKREDET!!!" : "nej, tag det roligt";
        return String.format("""
                %s
                %s
                Afleveringsfrist: %s
                Status %s
                """,book, borrowedBy, getDueDate(), status);
    }
}

