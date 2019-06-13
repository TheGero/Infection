import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

/**
* Tests of class VirusData
*
* @author Kacper Lesnianski, Patryk Plociennik
* @version 1.0
*/
class VirusDataTest {

    /**
     * Testing setting values.
     */
    @Test
    public void valueTest() {
        VirusData d = new VirusData();
        d.spreadChance = 100;
        d.spreadRange = 2;
        d.mutationChance = 5;
        d.lethality = 10;
        d.resistanceToTreatment = 20;

        assertEquals(100, d.spreadChance);
        assertEquals(2, d.spreadRange);
        assertEquals(5, d.mutationChance);
        assertEquals(10, d.lethality);
        assertEquals(20, d.resistanceToTreatment);
    }
    /**
     * Test of the copy constructor.
     * It must create a new object with parameters equal to the parameters of the original object.
     */
    @Test
    public void copyConstructorTest() {
        VirusData d = new VirusData();
        d.spreadChance = 100;
        d.spreadRange = 2;
        d.mutationChance = 5;
        d.lethality = 10;
        d.resistanceToTreatment = 20;

        VirusData d2 = new VirusData(d);

        assertEquals(100, d2.spreadChance);
        assertEquals(2, d2.spreadRange);
        assertEquals(5, d2.mutationChance);
        assertEquals(10, d2.lethality);
        assertEquals(20, d2.resistanceToTreatment);

        assertNotSame(d2, d);
    }
}