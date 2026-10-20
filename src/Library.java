import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

    public Library() {

    }

    public void addBook(Book book) {
        books.add(book);

    }

    public void addMember(Member member) {
        members.add(member);

    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public void printBooks() {
        for (Book book : books) {
            IO.println(book);
        }
    }

    public void printMembers() {
        for (Member member : members) {
            IO.println(member);

        }

    }

    public Book getBook(int bookid) {
        for (Book book : books) {
            if (book.idNr() == bookid) {
                return book;
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

    public boolean loanBook(int membersID, int bookid) {
        Member member = getMember(membersID);
        if (member == null) {
            return false;
        }
        Book book = getBook(bookid);
        if (book == null) {
            return false;
        }
        for (Loan loan : loans){
            if (loan.getBook().idNr() == bookid){
                return false;
            }
        }
        Loan loan = new Loan(book, member, LocalDate.now());
        loans.add(loan);
        return true;
    }

    public boolean returnBook(int bookid){
        for (Loan loan : loans){
            if(loan.getBook().idNr() == bookid){
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

