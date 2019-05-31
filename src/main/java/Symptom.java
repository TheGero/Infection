/**
 * Class representing a Symptom of infection
 *
 * @author Kacper Leśniański, Patryk Płóciennik
 * @version 1.0
 */
public class Symptom {

    private int visibility;

    /**
     * Create Symptom with set visibility
     *
     * @param visibility visibility of Symptom
     */
    public Symptom(int visibility) {
        this.visibility = visibility;
    }

    /**
     *
     * @return visibility of the Symptom
     */
    public int getVisibility() {
        return visibility;
    }
}
