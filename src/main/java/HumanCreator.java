/**
 * HumanCreator creates new Human , Doctor and Virus objects.
 *
 * @author Kacper Lesnianski, Patryk Plociennik
 * @version 1.0
 */
public class HumanCreator {
    /**
     * Creates new Human object.
     *
     * @param parentMap Reference to Map storing the Human.
     * @return new Human object.
     */
    public IHuman createHuman(Map parentMap) {
        Human h = new Human(parentMap);
        return h;
    }

    /**
     * Creates new Doctor object.
     *
     * @param parentMap Reference to Map storing the Doctor.
     * @return new Doctor object.
     */
    public IHuman createDoctor(Map parentMap) {
        Doctor d = new Doctor(parentMap);
        return d;
    }

    /**
     * Creates new Human object and infects it with a Virus.
     *
     * @param parentMap Reference to Map storing the Human.
     * @param vData     Reference to VirusData class that contains data of Virus to create.
     * @return new Human object infected with new Virus object.
     */
    public IHuman createInfected(Map parentMap, VirusData vData) {
        IHuman h = createHuman(parentMap);
        Virus v = new Virus(h, vData);
        h.infect(v);
        return h;
    }
}
