import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class AudioBookTest {

    @Test
    void testGetAudioLength() {
        //Arrange
        AudioBook audioBook = new AudioBook("9849864359458", "Vagabond Vol. 1", "Tekhiko Inour", 200);
        //Act
        int audiolength = audioBook.getAudioLength();
        //Arrange
        assertEquals(200, audiolength);
    }

    @Test
    void testGetCreator() {
        //Arrange
        AudioBook audioBook = new AudioBook("9849864359458", "Vagabond Vol. 1", "Tekhiko Inour", 200);
        //Act
        String creator = audioBook.getCreator();
        //Arrange
        assertEquals("Tekhiko Inour", creator);
    }
    @Test
    void testGetCreatorIsNotNull() {
        //Arrange
        AudioBook audioBook = new AudioBook("9849864359458", "Vagabond Vol. 1", "Tekhiko Inour", 200);
        //Act
        String creator = audioBook.getCreator();
        //Arrange
        assertNotNull(creator);
    }

}