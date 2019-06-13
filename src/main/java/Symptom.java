/**
 * Class representing a Symptom of infection.
 *
 * @author Kacper Lesnianski, Patryk Plociennik
 * @version 1.0
 */
public class Symptom {

    /**
     * Visibility of the symptom.
     */
    private int visibility;

    /**
     * Create Symptom and set visibility.
     *
     * @param visibility visibility of Symptom.
     */
    public Symptom(int visibility) {
        this.visibility = visibility;
    }

    /**
     *
     * @return visibility of the Symptom.
     */
    public int getVisibility() {
        return visibility;
    }
}
