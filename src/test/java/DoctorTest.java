import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * Tests of Doctor class
 *
 * @author Kacper Lesnianski, Patryk Plociennik
 * @version 1.0
 */
class DoctorTest {
    /**
     * Testing isDoctor method
     */
    @Test
    void isDoctor() {
        //intentional null
        Doctor doctor = new Doctor(null);
        assertTrue(doctor.isDoctor());
    }
}
