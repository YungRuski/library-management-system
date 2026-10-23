import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    Library library;
    Member member;
    Member member2;
    Resource resource;
    private ArrayList<Loan> loans;
    @BeforeEach
    void setup() {
        loans = library.getLoans();
        library = new Library();
        member = new Member("Jan", 5932);
        member2 = new Member("Amanda", 9582);
        resource = new Book("9788700631625", "Harry Potter", "J.K. Rowling", 350);
        library.addMember(member);
        library.addMember(member2);
        library.addResource(resource);
    }

    @Test
    void testOfSuccessfulLoan() {
        //Act
        LoanResult result = library.loanResource(5932, "9788700631625");
        //Assert
        assertEquals(LoanResult.SUCCESS, result);
    }

    @Test
    void testOfLoanWithUnknownMember() {
        //Act
        LoanResult result = library.loanResource(9999, "9788700631625");
        //Assert
        assertEquals(LoanResult.NOT_MEMBER, result);
    }

    @Test
    void testLoanWhenResourceDontExist() {
        //Act
        LoanResult result = library.loanResource(5932, "999999999999");
        //Assert
        assertEquals(LoanResult.NO_RESOURCE, result);
    }

    @Test
    void testLoanWhenResourceAlreadyLoaned() {
        //Arrange
        library.loanResource(5932, "9788700631625");
        //Act
        LoanResult result = library.loanResource(9582, "9788700631625");
        //Assert
        assertEquals(LoanResult.ALREADY_LOANED, result);
    }
    @Test
    void testReturnResourceLoan() {
        //Arrange
        library.loanResource(5932, "9788700631625");
        //Act
        boolean result = library.returnResource("9788700631625");
        //Assert
        assertTrue(result);
    }
    @Test
    void testReturnResourceWhenNotLoaned(){
        //Act
        boolean result = library.returnResource("9788700631625");
        //Assert
        assertFalse(result);

    }
    @Test
    void testLoanWhenResourceHasBeenReturned() {
        //Arrange
        library.loanResource(5932, "9788700631625");
        library.returnResource("9788700631625");
        //Act
       LoanResult result = library.loanResource(5932, "9788700631625");
        //Assert
        assertEquals(LoanResult.SUCCESS, result);
    }
    @Test
    void testFailedLoanDoesNotAffectLibrary1() {

        //Act
        library.loanResource(9999, "5700000000003");
        //Assert
        assertEquals(0, loans.size());
    }


    @Test
    void testFailedLoanDoesNotAffectLibrary2() {

        //Act
        library.loanResource(1111, "9999999999999");
        //Assert
        assertEquals(0, loans.size());
    }
    @Test
    void testFailedLoanDoesNotAffectLibrary3() {
        //Assign
        library.loanResource(1111, "5700000000003");
        //Act
        library.loanResource(1111, "5700000000003");
        //Assert
        assertEquals(1, loans.size());
    }

    @Test
    void testFailedReturnDoesNotAffectLibrary1() {
        //Assign
        library.loanResource(1111, "5700000000003");
        //Act
        library.returnResource("9999999999999");
        //Assert
        assertEquals(1, loans.size());
    }
    @Test
    void testFailedReturnDoesNotAffectLibrary2() {

        //Act
        library.returnResource("5700000000003");
        //Assert
        assertEquals(0, loans.size());
    }



}