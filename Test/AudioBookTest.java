import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AudioBookTest {
    AudioBook audioBook;

    @BeforeEach
    void setup(){
        audioBook = new AudioBook("9849864359458", "Vagabond Vol. 1", "Tekhiko Inour", 200);
    }

    @Test
    void testGetAudioLength() {
        //Act
        int audiolength = audioBook.getAudioLength();
        //Arrange
        assertEquals(200, audiolength);
    }

    @Test
    void testGetCreator() {
        //Act
        String creator = audioBook.getCreator();
        //Arrange
        assertEquals("Tekhiko Inour", creator);
    }
    @Test
    void testGetCreatorIsNotNull() {
        //Act
        String creator = audioBook.getCreator();
        //Arrange
        assertNotNull(creator);
    }

}