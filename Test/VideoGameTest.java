import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VideoGameTest {
    VideoGame game;

    @BeforeEach
    void setup(){
        game = new VideoGame("5700000000003", "Minecraft (Java)", "Mojang", "PC og Mac");
    }

    @Test
    void testGetPlatform() {
        //Arrange
        setup();
        //Act
        String platform = game.getPlatform();
        //Assert
        assertEquals("PC og Mac", platform);
    }

    @Test
    void testToString() {

    }
}