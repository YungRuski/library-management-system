import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StandardLoanPolicyTest {
    LoanPolicy policy;
    Member member;
    List<Loan> loans;
    List<Resource> resources;

    @BeforeEach
    void setup() {
        policy = new StandardLoanPolicy();
        member = new Member("Jan", 5932);
        loans = new ArrayList<>();
        resources = new ArrayList<>();
        resources.add(new Book("9788700631625", "Harry Potter", "J.K. Rowling", 350));
        resources.add(new VideoGame("5700000000003", "Minecraft (Java)", "Mojang", "PC og Mac"));
        resources.add(new Movie("5798000794085", "Goodfellas", "Warner Brothers", "Martin Scorsese", 81));
        resources.add(new AudioBook("9849864359458", "Vagabond Vol. 1", "Tekhiko Inour", 200));

    }

    @Test
    void testCanLoanAnyResource() {
        //Act
        for(Resource resource : resources){
            boolean result = policy.canLoan(member, resource, loans);
            //Assert
            assertTrue(result);
        }
    }
    @Test
    void testCalculateDueDate() {
        //Arrange
        LocalDate date = LocalDate.of(2026, 10, 1);
        //Act
        LocalDate result = policy.calculateDueDate(date, resources.get(1));
        //Assert
        assertEquals(LocalDate.of(2026, 10, 31), result);
    }

}