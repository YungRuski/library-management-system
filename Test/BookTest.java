import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book;
    @BeforeEach
    void setup(){
        book = new Book("9788700631625", "Harry Potter", "J.K. Rowling", 350);
    }

    @Test
    void testGetCreator() {
        //Arrange
        setup();
        //Act
        String creator = book.getCreator();
        //Assert
        assertEquals("J.K. Rowling", creator);
    }

    @Test
    void testGetCreatorIsNotNull() {
        //Arrange
        setup();
        //Act
        String creator = book.getCreator();
        //Assert
        assertNotNull(creator);
    }

    @Test
    void testGetTitle() {
        //Arrange
        setup();
        //Act
        String title = book.getTitle();
        //Arrange
        assertEquals("Harry Potter", title);
    }

    @Test
    void testGetIdentifier() {
        //Arrange
        setup();
        //Act
        String identifier = book.getIdentifier();
        //Arrange
        assertEquals("9788700631625", identifier);
    }

    @Test
    void testGetPages() {
        //Arrange
        setup();
        //Act
        int pages = book.getPages();
        //Assert
        assertEquals(350, pages);
    }


}