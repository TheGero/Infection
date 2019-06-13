import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Tests of Human class
 *
 * @author Kacper Lesnianski, Patryk Plociennik
 * @version 1.0
 */
class HumanTest {
    /**
     *  Testing isDoctor method
     */
    @Test
    void isDoctorTest() {
        //intentional null
        Human human = new Human(null);
        assertFalse(human.isDoctor());
    }
}
