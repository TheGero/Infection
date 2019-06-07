import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of Human class
 *
 * @author Kacper Lesnianski, Patryk Plociennik
 * @version 1.0
 */
class HumanTest {
    @Test
    /**
     *  Testing isDoctor method
     */
    void isDoctorTest() {
        Map map = null; //intentional, shouldn't cause crash
        Human human = new Human(map);
        assertFalse(human.isDoctor());
    }
}
//TODO Flee method test