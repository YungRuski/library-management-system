import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void testGetDirector() {
        //Arrange
        Movie movie = new Movie("5798000794085", "Goodfellas", "Warner Brothers", "Martin Scorsese", 81);
        //Act
        String director = movie.getDirector();
        //Assert
        assertEquals("Martin Scorsese", director);
    }
    @Test
    void testGetDirectorIsNotNull() {
        //Arrange
        Movie movie = new Movie("5798000794085", "Goodfellas", "Warner Brothers", "Martin Scorsese", 81);
        //Act
        String director = movie.getDirector();
        //Assert
        assertNotNull(director);
    }
    @Test
    void testGetMovieLength() {
        //Arrange
        Movie movie = new Movie("5798000794085", "Goodfellas", "Warner Brothers", "Martin Scorsese", 81);
        //Act
        int movielength = movie.getMovieLength();
        //Assert
        assertEquals(81, movielength);
    }

}