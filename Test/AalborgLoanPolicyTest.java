import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AalborgLoanPolicyTest {
    LoanPolicy policy;
    Member member;
    List<Loan> loans;
    List<Resource> resources;
    @BeforeEach
    void setup() {
        policy = new AalborgLoanPolicy();
        member = new Member("Jan", 5932);
        loans = new ArrayList<>();
        resources = new ArrayList<>();
        resources.add(new Book("9788700631625", "Harry Potter", "J.K. Rowling", 350));
        resources.add(new VideoGame("5700000000003", "Minecraft (Java)", "Mojang", "PC og Mac"));
        resources.add(new VideoGame("5700000000004", "The Legend of Zelda: Breath of the Wild", "Nintendo", "Nintendo Switch"));
        resources.add(new Movie("5798000794085", "Goodfellas", "Warner Brothers", "Martin Scorsese", 81));
        resources.add(new Movie("5700000000002", "Interstellar", "Paramount Pictures", "Christopher Nolan", 169));
        resources.add(new AudioBook("9849864359458", "Vagabond Vol. 1", "Tekhiko Inour", 200));
    }

    @Test
    void testCannotLoanMoreThanThreeMoviesOrVideoGames() {
        //Arrange
        Loan loan1 = new Loan(resources.get(3), member, LocalDate.now(), LocalDate.now().plusDays(30)); //Movie
        Loan loan2 = new Loan(resources.get(4), member, LocalDate.now(), LocalDate.now().plusDays(30)); //Movie
        Loan loan3 = new Loan(resources.get(2), member, LocalDate.now(), LocalDate.now().plusDays(30)); //VideoGame
        loans.add(loan1);
        loans.add(loan2);
        loans.add(loan3);
        //Act
        boolean result = policy.canLoan(member, resources.get(1), loans);
        //Assert
        assertFalse(result);
    }
    @Test
    void testCanLoanOtherResourceWhenAlreadyLoanedThreeMoviesOrVideoGames() {
        //Arrange
        Loan loan1 = new Loan(resources.get(3), member, LocalDate.now(), LocalDate.now().plusDays(30)); //Movie
        Loan loan2 = new Loan(resources.get(4), member, LocalDate.now(), LocalDate.now().plusDays(30)); //Movie
        Loan loan3 = new Loan(resources.get(2), member, LocalDate.now(), LocalDate.now().plusDays(30)); //VideoGame
        loans.add(loan1);
        loans.add(loan2);
        loans.add(loan3);
        //Act
        boolean result = policy.canLoan(member, resources.getFirst(), loans);
        //Assert
        assertTrue(result);
    }
    @Test
    void testCanLoanAThirdMovieOrVideoGame() {
        //Arrange
        Loan loan1 = new Loan(resources.get(3), member, LocalDate.now(), LocalDate.now().plusDays(30)); //Movie
        Loan loan2 = new Loan(resources.get(4), member, LocalDate.now(), LocalDate.now().plusDays(30)); //Movie
        loans.add(loan1);
        loans.add(loan2);
        //Act
        boolean result = policy.canLoan(member, resources.get(2), loans);
        //Assert
        assertTrue(result);
    }
    @Test
    void testCaculateDueDate() {
        //Arrange
        LocalDate date = LocalDate.of(2026, 10, 1);
        //Act
        LocalDate result = policy.calculateDueDate(date, resources.get(1));
        //Assert
        assertEquals(LocalDate.of(2026, 10, 31), result);
    }

}