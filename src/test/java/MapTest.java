import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
* Tests of Map class
*
* @author Kacper Lesnianski, Patryk Plociennik
* @version 1.0
*/
class MapTest {

    Map map;
    /**
     * Creating map object for testing
     */
    MapTest() {
        VirusData d = new VirusData();
        d.spreadChance = 100;
        d.spreadRange = 2;
        d.mutationChance = 5;
        d.lethality = 10;
        d.resistanceToTreatment = 20;

        map = new Map(1, 2000, 200, 100, d);
    }
    /**
     * Testing if getHumansInRange returns the correct value
     */
    @Test
    void getHumansInRange() {
        assertEquals(2300, map.getHumansInRange(new Coordinates(1, 1), 1).size());
    }

    /**
     * Testing if getHumansLeft returns the correct value
     */
    @Test
    void getHumansLeft() {
        assertEquals(2300, map.getHumansLeft());
    }

    /**
     * Testing if getDoctorsLeft returns the correct value
     */
    @Test
    void getDoctorsLeft() {
        assertEquals(200, map.getDoctorsLeft());
    }

    /**
     * Testing if getInfectedLeft returns the correct value
     */
    @Test
    void getInfectedLeft() {
        assertEquals(100, map.getInfectedLeft());
    }

    /**
     * Testing if getDeadCount returns the correct value
     */
    @Test
    void getDeadCount() {
        assertEquals(0, map.getDeadCount());
    }

    /**
     * Testing if getMutationCount returns the correct value
     */
    @Test
    void getMutationCount() {
        assertEquals(0, map.getMutationCount());
    }

    /**
     * Testing if getSize returns the size of the map
     */
    @Test
    void getSize() {
        assertEquals(1, map.getSize());
    }
}