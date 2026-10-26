import java.time.LocalDate;

public class Loan {
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
    public LocalDate getDueDate(){
        return dueDate;
    }
    public boolean isOverdue(){
        return LocalDate.now().isAfter(getDueDate());
    }
    public String toString(){
        String status = isOverdue() ? "OVERSKREDET!!!" : "Ikke overskredet";
        return String.format("""
                %s
                %s
                Afleveringsfrist: %s
                Status: %s
                """,resource, borrowedBy, getDueDate(), status);
    }
}

