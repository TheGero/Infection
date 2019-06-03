import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapTest {

    Map map;

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
    void getHumansInRange() {
        assertEquals(2300, map.getHumansInRange(new Coordinates(1, 1), 1).size());
    }

    @Test
    void getHumansLeft() {
        assertEquals(2300, map.getHumansLeft());
    }

    @Test
    void getDoctorsLeft() {
        assertEquals(200, map.getDoctorsLeft());
    }

    @Test
    void getInfectedLeft() {
        assertEquals(100, map.getInfectedLeft());
    }

    @Test
    void getDeadCount() {
        assertEquals(0, map.getDeadCount());
    }

    @Test
    void getMutationCount() {
        assertEquals(0, map.getMutationCount());
    }

    @Test
    void getSize() {
        assertEquals(1, map.getSize());
    }
}