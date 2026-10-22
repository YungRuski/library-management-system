import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testGetCreator() {
        //Arrange
        Book book = new Book("9788700631625", "Harry Potter", "J.K. Rowling", 350);
        //Act
        String creator = book.getCreator();
        //Assert
        assertEquals("J.K. Rowling", creator);
    }

    @Test
    void testGetCreatorIsNotNull() {
        //Arrange
        Book book = new Book("9788700631625", "Harry Potter", "J.K. Rowling", 350);
        //Act
        String creator = book.getCreator();
        //Assert
        assertNotNull(creator);
    }

    @Test
    void testGetTitle() {
        //Arrange
        Book book = new Book("9788700631625", "Harry Potter", "J.K. Rowling", 350);
        //Act
        String title = book.getTitle();
        //Arrange
        assertEquals("Harry Potter", title);
    }

    @Test
    void testGetIdentifier() {
        //Arrange
        Book book = new Book("9788700631625", "Harry Potter", "J.K. Rowling", 350);
        //Act
        String identifier = book.getIdentifier();
        //Arrange
        assertEquals("9788700631625", identifier);
    }

    @Test
    void testGetPages() {
        //Arrange
        Book book = new Book("9788700631625", "Harry Potter", "J.K. Rowling", 350);
        //Act
        int pages = book.getPages();
        //Assert
        assertEquals(350, pages);
    }


}