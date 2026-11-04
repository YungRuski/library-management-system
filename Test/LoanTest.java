import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


class LoanTest {
    Loan loan;
    Loan loan2;
    Loan loan3;
    Member member;
    Resource resource;
    Resource resource2;
    Resource resource3;
    @BeforeEach
    void setup() {
        member = new Member("Jan", 5932);
        resource = new Book("9788700631625", "Harry Potter", "J.K. Rowling", 350);
        resource2 = new Movie("5798000794085", "Goodfellas", "Warner Brothers", "Martin Scorsese", 81);
        resource3 = new VideoGame("5700000000003", "Minecraft (Java)", "Mojang", "PC og Mac");
        loan = new Loan(resource, member, LocalDate.of(2026, 10, 1), LocalDate.of(2026, 10, 15));
        loan2 = new Loan(resource2, member, LocalDate.of(2026,10,5), LocalDate.of(2026,10,19));
        loan3 = new Loan(resource3, member, LocalDate.of(2026,8,1), LocalDate.of(2026,8,15));
    }


    @Test
    void getResource() {
        //Act
        Resource result = loan.getResource();
        //Assert
        assertEquals(resource, result);
    }

    @Test
    void getMember() {
        //Act
        Member result = loan.getMember();
        //Assert
        assertEquals(member, result);
    }

    @Test
    void getDueDate() {
        //Arrange
        LocalDate expected = LocalDate.of(2026, 10, 15);
        //Act
        LocalDate result = loan.getDueDate();
        //Assert
        assertEquals(expected, result);
    }

    @Test
    void isOverdue() {
        //Arrange
        Loan loan = new Loan(resource, member, LocalDate.now().minusDays(20), LocalDate.now().minusDays(5));
        //Act
        boolean result = loan.isOverdue();
        //Assert
        assertTrue(result);
    }
    @Test
    void isNotOverdue(){
        //Arrange
        Loan loan = new Loan(resource, member, LocalDate.now().minusDays(20), LocalDate.now().plusDays(5));
        //Act
        boolean result = loan.isOverdue();
        //Assert
        assertFalse(result);
    }
    @Test
    void testCompareTo() {
        //Act
        int negativeResult = loan.compareTo(loan2);
        int positiveResult = loan2.compareTo(loan);
        int neutralResult = loan.compareTo(loan);
        //Assert
        assertTrue(negativeResult < 0);
        assertTrue(positiveResult > 0);
        assertEquals(0, neutralResult);
    }
    @Test
    void testLoanWillSortCorrectly() {
        //Arrange
        List<Loan> loans = new ArrayList<>();
        loans.add(loan);
        loans.add(loan2);
        loans.add(loan3);
        //Act
        loans.sort(null);
        //Assert
        assertEquals(loan3, loans.get(0));
        assertEquals(loan, loans.get(1));
        assertEquals(loan2, loans.get(2));

    }

}