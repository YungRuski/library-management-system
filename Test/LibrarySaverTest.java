import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
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
        var librarySaver = new LibrarySaver(mapper);
        //Act
        librarySaver.saveMembers(members, Path.of("test-members.csv"));
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
        var librarySaver = new LibrarySaver(mapper);
        //Act
        librarySaver.saveBooks(books, Path.of("test-books.csv"));
        //Assert
        var expected = """
                J.K. Rowling,Harry Potter,9788700631625,350
                George Orwell,1984,9780451524935,328
                """;
        var actual = Files.readString(Path.of("test-books.csv"));
        assertEquals(expected, actual);
    }

    @Test
    void testSaveMovies() throws IOException {
        //Arrange
        var movies = List.of(
                new Movie("5798000794085", "Goodfellas", "Warner Brothers", "Martin Scorsese", 81),
                new Movie("5700000000002", "Interstellar", "Paramount Pictures", "Christopher Nolan", 169));
        LibraryMapper mapper = new LibraryMapper();
        var librarySaver = new LibrarySaver(mapper);
        //Act
        librarySaver.saveMovies(movies, Path.of("test-movies.csv"));
        //Assert
        var expected = """
                Goodfellas,Warner Brothers,5798000794085,Martin Scorsese,81
                Interstellar,Paramount Pictures,5700000000002,Christopher Nolan,169
                """;
        var actual = Files.readString(Path.of("test-movies.csv"));
        assertEquals(expected, actual);
    }

    @Test
    void testSaveAudioBooks() throws IOException {
        //Arrange
        var audioBooks = List.of(
                new AudioBook("9788700631626", "Harry Potter", "J.K. Rowling", 540),
                new AudioBook("9849864359458", "Vagabond Vol. 1", "Tekhiko Inour", 200));
        LibraryMapper mapper = new LibraryMapper();
        var librarySaver = new LibrarySaver(mapper);
        //Act
        librarySaver.saveAudioBooks(audioBooks, Path.of("test-audiobooks.csv"));
        //Assert
        var expected = """
                J.K. Rowling,Harry Potter,9788700631626,540
                Tekhiko Inour,Vagabond Vol. 1,9849864359458,200
                """;
        var actual = Files.readString(Path.of("test-audiobooks.csv"));
        assertEquals(expected, actual);
    }

    @Test
    void testSaveVideoGames() throws IOException {
        //Arrange
        var videoGames = List.of(
                new VideoGame("5700000000003", "Minecraft (Java)", "Mojang", "PC og Mac"),
                new VideoGame("5700000000004", "The Legend of Zelda: Breath of the Wild", "Nintendo", "Nintendo Switch"));
        LibraryMapper mapper = new LibraryMapper();
        var librarySaver = new LibrarySaver(mapper);
        //Act
        librarySaver.saveVideoGames(videoGames, Path.of("test-videogames.csv"));
        //Assert
        var expected = """
                Minecraft (Java),PC og Mac,Mojang,5700000000003
                The Legend of Zelda: Breath of the Wild,Nintendo Switch,Nintendo,5700000000004
                """;
        var actual = Files.readString(Path.of("test-videogames.csv"));
        assertEquals(expected, actual);
    }
    @Test
    void testSaveLoans() throws IOException {
        //Arrange
        Member member = new Member("Jan", 5932);
        Book book = new Book("9788700631625", "Harry Potter", "J.K. Rowling", 350);
        var loans = List.of(
                new Loan(book, member, LocalDate.of(2026,10,1), LocalDate.of(2026,10,15)));
        LibraryMapper mapper = new LibraryMapper();
        var librarySaver = new LibrarySaver(mapper);
        //Act
        librarySaver.saveLoans(loans, Path.of("test-loans.csv"));
        //Assert
        var expected = """
                9788700631625,5932,2026-10-01,2026-10-15
                """;
        var actual = Files.readString(Path.of("test-loans.csv"));
        assertEquals(expected, actual);
    }
}
