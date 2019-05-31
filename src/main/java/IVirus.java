/**
 * An interface Virus objects.
 *
 * @author Kacper Leśniański, Patryk Płóciennik
 * @version 1.0
 */
public interface IVirus {
    /**
     * Update Virus.
     */
    void update();

    /**
     * @return SymptomsVisibility value.
     */
    int getSymptomsVisibility();

    /**
     * @return Virus's data.
     */
    VirusData getVirusData();

    /**
     *
     * @return true if Virus has mutaded.
     */
    boolean hasMutatedLastStep();
}
