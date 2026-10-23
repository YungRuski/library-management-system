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
        loan = new Loan(resource, member, LocalDate.of(2026, 10, 1));
    }


    @Test
    void getResource() {
        //Arrange
        setup();
        //Act
        Resource resource =
    }

    @Test
    void getMember() {
    }

    @Test
    void getDueDate() {
    }

    @Test
    void isOverdue() {
    }

    @Test
    void testToString() {
    }
}