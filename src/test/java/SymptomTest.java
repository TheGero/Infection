import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
* Tests of class Symptom
*
* @author Kacper Lesnianski, Patryk Plociennik
* @version 1.0
*/
class SymptomTest {

    /**
     * Testing constructor and getter.
     */
    @Test
    void valueTest() {
        Symptom s = new Symptom(5);
        assertEquals(5, s.getVisibility());
    }
}