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
     * @return SymptomsVisibility value.
     */
    int getSymptomsVisibility();

    /**
     * @return Virus's data.
     */
    VirusData getVirusData();

    /**
     *
     * @return true if Virus has mutated.
     */
    boolean hasMutatedLastStep();
}
