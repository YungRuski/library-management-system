import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    private ArrayList<Resource> resources = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

    public Library() {

    }

    public void addResource(Resource resource) {
        resources.add(resource);

    }

    public void addMember(Member member) {
        members.add(member);

    }

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Loan> getLoans() {
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

    public boolean loanResource(int membersID, String identifier) {
        Member member = getMember(membersID);
        if (member == null) {
            return false;
        }
        Resource resource = getResource(identifier);
        if (resource == null) {
            return false;
        }
        for (Loan loan : loans){
            if (loan.getResource().getIdentifier().equals(identifier)){
                return false;
            }
        }
        Loan loan = new Loan(resource, member, LocalDate.now());
        loans.add(loan);
        return true;
    }

    public boolean returnResource(String identifier){
        for (Loan loan : loans){
            if(loan.getResource().getIdentifier().equals(identifier)){
                loans.remove(loan);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Loan> findLoansByMemberId(int memberId){
    ArrayList<Loan> memberloans = new ArrayList<>();
        for (Loan loan : loans){
            if(loan.getMember().memberID() == memberId){
                memberloans.add(loan);
            }
        }
        return memberloans;
    }
}

