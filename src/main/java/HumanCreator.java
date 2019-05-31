/**
 * HumanCreator creates new Human , Doctor and Virus class objects.
 *
 * @author Kacper Leśniański, Patryk Płóciennik
 * @version 1.0
 */
public class HumanCreator {
    /**
     * creates new Human objects.
     *
     * @param parentMap Reference to Map storing the Human.
     * @return new Human objects.
     */
    public IHuman createHuman(Map parentMap) {
        Human h = new Human(parentMap);
        return h;
    }

    /**
     * creates new Doctor objects.
     *
     * @param parentMap Reference to Map storing the Human.
     * @return new Doctor objects.
     */
    public IHuman createDoctor(Map parentMap) {
        Doctor d = new Doctor(parentMap);
        return d;
    }

    /**
     * creates new Virus objects.
     *
     * @param parentMap Reference to Map storing the Human.
     * @param vData     Reference to VirusData class.
     * @return new Virus object.
     */
    public IHuman createInfected(Map parentMap, VirusData vData) {
        IHuman h = createHuman(parentMap);
        Virus v = new Virus(h, vData);
        h.infect(v);
        return h;
    }
}
