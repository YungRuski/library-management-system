import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibrarySaverTest {

    @Test
    void testSaveMembers() throws IOException {
        //Arrange
        var members = List.of(
                new Member("Jan", 5932),
                new Member("Amanda", 9823),
                new Member("Michael", 5613));
        LibraryMapper mapper = new LibraryMapper();
        var librarySaver = new LibrarySaver(Path.of("test-members.csv"), mapper);
        //Act
        librarySaver.saveMembers(members);
        //Assert
        var expected = """
                Jan,5932
                Amanda,9823
                Michael,5613
                """;
        var actual = Files.readString(Path.of("test-members.csv"));
        assertEquals(expected, actual);

    }

    @Test
    void testSaveBooks() throws IOException {
        //Arrange
        var books = List.of(
                new Book("9788700631625", "Harry Potter", "J.K. Rowling", 350),
                new Book("9780451524935", "1984", "George Orwell", 328));
        LibraryMapper mapper = new LibraryMapper();
        var librarySaver = new LibrarySaver(Path.of("test-books.csv"), mapper);
        //Act
        librarySaver.saveBooks(books);
        //Assert
        var expected = """
                J.K. Rowling,Harry Potter,9788700631625,350
                George Orwell,1984,9780451524935,328
                """;
        var actual = Files.readString(Path.of("test-books.csv"));
        assertEquals(expected, actual);
    }
}
