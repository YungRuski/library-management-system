import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Resource> resources = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();
    private LoanPolicy policy;

    public Library(LoanPolicy policy) {
        this.policy = policy;
    }

    public void addResource(Resource resource) {
        resources.add(resource);

    }

    public void addMember(Member member) {
        members.add(member);

    }

    public List<Resource> getResources() {
        return resources;
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void printResources() {
        for (Resource resource : resources) {
            IO.println(resource);
        }
    }

    public void printMembers() {
        for (Member member : members) {
            IO.println(member);

        }

    }

    public Resource getResource(String identifier) {
        for (Resource resource : resources) {
            if (resource.getIdentifier().equals(identifier)) {
                return resource;
            }
        }
        return null;
    }

    public Member getMember(int membersID) {
        for (Member member : members) {
            if (member.memberID() == membersID) {
                return member;
            }
        }
        return null;
    }

    public LoanResult loanResource(int membersID, String identifier) {
        Member member = getMember(membersID);
        if (member == null) {
            return LoanResult.NOT_MEMBER;
        }
        Resource resource = getResource(identifier);
        if (resource == null) {
            return LoanResult.NO_RESOURCE;
        }
        for (Loan loan : loans) {
            if (loan.getResource().getIdentifier().equals(identifier)) {
                return LoanResult.ALREADY_LOANED;
            }
        }

        if (policy.canLoan(member, resource, loans)) {
            LocalDate borrowedDate = LocalDate.now();
            LocalDate dueDate = policy.calculateDueDate(borrowedDate, resource);
            Loan loan = new Loan(resource, member, borrowedDate, dueDate);
            loans.add(loan);
            return LoanResult.SUCCESS;
        }
        return LoanResult.POLICY_NOT_ALLOWED;
    }


    public boolean returnResource(String identifier) {
        for (Loan loan : loans) {
            if (loan.getResource().getIdentifier().equals(identifier)) {
                loans.remove(loan);
                return true;
            }
        }
        return false;
    }

    public List<Loan> findLoansByMemberId(int memberId) {
        List<Loan> memberloans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getMember().memberID() == memberId) {
                memberloans.add(loan);
            }
        }
        return memberloans;
    }
}

