import java.time.LocalDate;
import java.util.List;

public class AalborgLoanPolicy implements LoanPolicy {

    @Override
    public boolean canLoan(Member member, Resource resource, List<Loan> loans) {
        int count = 0;
        for (Loan loan : loans) {
            if (member.memberID() == loan.getMember().memberID()) {
                if (loan.getResource() instanceof Movie || loan.getResource() instanceof VideoGame) {
                    count++;
                }
            }
        }
        if (count >= 3 && (resource instanceof Movie || resource instanceof VideoGame)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowedDate, Resource resource) {
        return borrowedDate.plusDays(30);
    }
}
