import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests of HumanCreator class
 *
 * @author Kacper Lesnianski, Patryk Plociennik
 * @version 1.0
 */
class HumanCreatorTest {

    HumanCreator hc;

    HumanCreatorTest(){
        hc = new HumanCreator();
    }
    /**
     * Testing if createHuman method creates a Human
     */
    @Test
    void createHuman() {
        IHuman h = hc.createHuman(null);
        assertTrue(h instanceof Human);
    }
    /**
     * Testing if createDoctor method creates a Doctor
     */
    @Test
    void createDoctor() {
        IHuman h = hc.createDoctor(null);
        assertTrue(h instanceof Doctor);
    }
    /**
     * Testing if createInfected method creates an infected Human
     */
    @Test
    void createInfected() {
        IHuman h = hc.createInfected(null, new VirusData());
        assertTrue(h instanceof Human && h.isInfected());
    }
}