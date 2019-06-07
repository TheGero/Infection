import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests of Doctor class
 *
 * @author Kacper Lesnianski, Patryk Plociennik
 * @version 1.0
 */
class DoctorTest {

    @Test
    /**
     * Testing isDoctor method
     */
    void isDoctor() {
        Map map = null; //intentional, shouldn't cause crash
        Doctor doctor = new Doctor(map);
        assertTrue(doctor.isDoctor());
    }
}
//TODO Heal method test