import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AbstractHuman tests
 *
 * @author Kacper Lesnianski, Patryk Plociennik
 * @version 1.0
 */

class AbstractHumanTest {

    private Map map;
    private Human human;
    private Virus v;
    private VirusData d;

    AbstractHumanTest(){
        d = new VirusData();
        map = new Map(10, 0, 0, 0, d);
    }
    /**
     * Testing if isAlive returns a correct value.
     */
    @Test
    void isAlive() {
        human = new Human(map);
        assertTrue(human.isAlive());
        human.kill();
        assertFalse(human.isAlive());
    }
    /**
     * Testing if isInfected returns a correct value.
     */
    @Test
    void isInfected() {
        human = new Human(map);
        v = new Virus(human, d);
        assertFalse(human.isInfected());
        human.infect(v);
        assertTrue(human.isInfected());
    }
    /**
     * Testing if hasVisibleSymptoms returns a correct value.
     */
    @Test
    void hasVisibleSymptoms() {
        human = new Human(map);
        v = new Virus(human, d);

        assertFalse(human.hasVisibleSymptoms());

        v.getVirusData().symptoms = new ArrayList<Symptom>() {{new Symptom(0);}};
        human.infect(v);
        assertFalse(human.hasVisibleSymptoms());

        v.getVirusData().symptoms.add(new Symptom(100));
        human.infect(v);
        assertTrue(human.hasVisibleSymptoms());
    }
    /**
     * Testing if infecting works
     */
    @Test
    void infect() {
        human = new Human(map);
        v = new Virus(human, d);
        human.infect(v);
        assertTrue(human.isInfected());
    }
    /**
     * Testing if curing works
     */
    @Test
    void cure() {
        human = new Human(map);
        v = new Virus(human, d);
        human.infect(v);
        assertTrue(human.isInfected());
        human.cure();
        assertFalse(human.isInfected());
    }
    /**
     * Testing if killing works
     */
    @Test
    void kill() {
        human = new Human(map);
        human.kill();
        assertFalse(human.isAlive());
    }
    /**
     * Make sure that human is storing the reference to their parent map
     */
    @Test
    void getParentMap() {
        human = new Human(map);
        assertSame(map, human.getParentMap());
    }
    /**
     * Test of Coordinates getter/setter
     */
    @Test
    void getSetCoordinates() {
        human = new Human(map);
        human.setCoordinates(new Coordinates(21,37));
        assertEquals(human.getCoordinates().getX(), 21);
        assertEquals(human.getCoordinates().getY(), 37);
    }
    /**
     * Test of Virus getter (null must be returned if not infected)
     */
    @Test
    void getVirus() {
        human = new Human(map);
        v = new Virus(human, d);
        assertNull(human.getVirus());
        human.infect(v);
        assertNotEquals(human.getVirus(), null);
    }
    /**
     * Testing move method and making sure that human won't go beyond borders of map
     */
    @Test
    void move() {
        human = new Human(map);
        human.setCoordinates(new Coordinates(1,1));
        human.move(4,2);
        human.move(3, 1);
        human.move(1,2);
        human.move(2,1);
        assertEquals(human.getCoordinates().getX(), 2);
        assertEquals(human.getCoordinates().getY(), 2);
        //Making sure that human won't go beyond borders of map
        human.move(2,3);
        assertEquals(human.getCoordinates().getY(), 0);
    }

}