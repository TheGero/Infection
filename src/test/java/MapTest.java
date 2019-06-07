import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
* Tests of class Map
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

    @Test
    /**
     * Testing if getHumansInRange returns the correct value
     */
    void getHumansInRange() {
        assertEquals(2300, map.getHumansInRange(new Coordinates(1, 1), 1).size());
    }

    @Test
    /**
     * Testing if getHumansLeft returns the correct value
     */
    void getHumansLeft() {
        assertEquals(2300, map.getHumansLeft());
    }

    @Test
    /**
     * Testing if getDoctorsLeft returns the correct value
     */
    void getDoctorsLeft() {
        assertEquals(200, map.getDoctorsLeft());
    }

    @Test
    /**
     * Testing if getInfectedLeft returns the correct value
     */
    void getInfectedLeft() {
        assertEquals(100, map.getInfectedLeft());
    }

    @Test
    /**
     * Testing if getDeadCount returns the correct value
     */
    void getDeadCount() {
        assertEquals(0, map.getDeadCount());
    }

    @Test
    /**
     * Testing if getMutationCount returns the correct value
     */
    void getMutationCount() {
        assertEquals(0, map.getMutationCount());
    }

    @Test
    /**
     * Testing if getSize returns the size of the map
     */
    void getSize() {
        assertEquals(1, map.getSize());
    }
}