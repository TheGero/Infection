import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests of Virus class
 *
 * @author Kacper Lesnianski, Patryk Plociennik
 * @version 1.0
 */
class VirusTest {
    @Test
    /**
     * Testing if getVirusData returns correct value
     */
    void getVirusData() {
        VirusData d = new VirusData();
        d.spreadChance = 2;
        d.spreadRange = 1;
        d.mutationChance = 3;
        d.lethality = 7;
        d.resistanceToTreatment = 8;

        Virus v = new Virus(null, d);

        assertEquals(v.getVirusData().spreadChance, 2);
        assertEquals(v.getVirusData().spreadRange, 1);
        assertEquals(v.getVirusData().mutationChance, 3);
        assertEquals(v.getVirusData().lethality, 7);
        assertEquals(v.getVirusData().resistanceToTreatment, 8);
        assertEquals(v.getVirusData().symptoms.size(), 0);
    }

    @Test
    /**
     * Testing if getSymptomsVisibility returns correct value
     */
    void getSymptomsVisibility() {
        VirusData d = new VirusData();
        d.symptoms.add(new Symptom(0));

        Virus v = new Virus (null, d);
        assertEquals(v.getSymptomsVisibility(), 0);
        d.symptoms.add(new Symptom(30));
        d.symptoms.add(new Symptom(100));
        v = new Virus(null, d);
        assertEquals(v.getSymptomsVisibility(), 130);
    }

    @Test
    /**
     *  Checks if hasMutatedLastStep works
     */
    void hasMutatedLastStep() {
        VirusData d = new VirusData();
        d.mutationChance = 100;
        Virus v = new Virus(null,d);
        assertFalse(v.hasMutatedLastStep());
        v.update();
        assertTrue(v.hasMutatedLastStep());
    }
}