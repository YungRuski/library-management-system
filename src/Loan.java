import java.time.LocalDate;

public class Loan implements Comparable<Loan> {
    private final Resource resource;
    private final Member borrowedBy;
    private final LocalDate borrowedDate;
    private final LocalDate dueDate;

    public Loan(Resource resource, Member member, LocalDate borrowedDate, LocalDate dueDate) {
        this.resource = resource;
        this.borrowedBy = member;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
    }

    public Resource getResource() {
        return resource;
    }

    public Member getMember() {
        return borrowedBy;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(getDueDate());
    }

    public String toString() {
        String status = isOverdue() ? "OVERSKREDET!!!" : "Ikke overskredet";
        return String.format("""
                %s
                %s
                Lånt: %s (afleveringsfrist: %s)
                Status: %s
                """, resource, borrowedBy, borrowedDate, getDueDate(), status);
    }
    @Override
    public int compareTo(Loan other) {
        return this.getDueDate().compareTo(other.getDueDate());
    }
}

