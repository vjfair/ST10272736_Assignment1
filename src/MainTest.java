import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @org.junit.jupiter.api.Test
    public void studentAge_Valid() {
        int age = 18;
        assertTrue(Main.studentAge_Valid(age));
    }

    @Test
    public void studentAge_Invalid() {
        int age = 16;
        assertFalse(Main.studentAge_Invalid(age));
    }

    @Test
    public void studentAge_InvalidCharacter() {
        String age = "a";
        boolean expected = true;
        assertEquals(expected, Main.studentAge_InvalidCharacter(age));
    }
}