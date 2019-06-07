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

    @Test
    /**
     * Testing if createHuman method creates a Human
     */
    void createHuman() {
        IHuman h = hc.createHuman(null);
        assertTrue(h instanceof Human);
    }

    @Test
    /**
     * Testing if createDoctor method creates a Doctor
     */
    void createDoctor() {
        IHuman h = hc.createDoctor(null);
        assertTrue(h instanceof Doctor);
    }

    @Test
    /**
     * Testing if createInfected method creates an infected Human
     */
    void createInfected() {
        IHuman h = hc.createInfected(null, new VirusData());
        assertTrue(h instanceof Human && h.isInfected());
    }
}