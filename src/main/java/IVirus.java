/**
 * An interface Virus objects.
 *
 * @author Kacper Lesnianski, Patryk Plociennik
 * @version 1.0
 */
public interface IVirus {
    /**
     * Update Virus.
     */
    void update();

    /**
     * @return Sum of visibility parameters of Virus's Symptoms.
     */
    int getSymptomsVisibility();

    /**
     * @return Virus's data.
     */
    VirusData getVirusData();

    /**
     *
     * @return true if Virus has mutated last step.
     */
    boolean hasMutatedLastStep();
}
