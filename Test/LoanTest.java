import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;


class LoanTest {
    Loan loan;
    Member member;
    Resource resource;
    @BeforeEach
    void setup() {
        member = new Member("Jan", 5932);
        resource = new Book("9788700631625", "Harry Potter", "J.K. Rowling", 350);
        loan = new Loan(resource, member, LocalDate.of(2026, 10, 1), LocalDate.of(2026, 10, 15));
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
}