import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    Member member;

    void setup(){
        member = new Member("Jan", 5932);
    }
    @Test
    void testToString() {
        //Arrange
        setup();
        //Act
        String result = member.toString();
        //Assert
        assertEquals("Jan (Lånenummer: 5932)\n", result);
    }

    @Test
    void name() {
        //Arrange
        setup();
        //Act
        String result = member.name();
        //Assert
        assertEquals("Jan", result);
    }

    @Test
    void memberID() {
        //Arrange
        setup();
        //Act
        int result = member.memberID();
        //Assert
        assertEquals(5932, result);
    }
}