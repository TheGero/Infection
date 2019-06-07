import java.util.List;
/**
 * Class representing a Doctor.
 * @author Kacper Lesnianski, Patryk Plociennik
 * @version 1.0
 */
public class Doctor extends AbstractHuman {
    /**
     * Constructor (calls AbstractHuman constructor).
     * @param parentMap Reference to Map storing Doctor.
     */
    public Doctor(Map parentMap) {
        super(parentMap);
    }

    /**
     * Method called on each step of the simulation.
     * Controls all actions of the Doctor: moving and healing.
     * If Doctor is infected, updates Virus.
     */
    @Override
    public void update() {
        if (!isAlive()) return;

        List<IHuman> humans = getParentMap().getHumansInRange(getCoordinates(), 2);
        for (IHuman h : humans) {
            if (h.hasVisibleSymptoms()) heal(h);
        }

        move();

        if (isInfected())
            getVirus().update();
    }

    /**
     * This method is required to discriminate between a Doctor and a Human without using instanceof().
     * (Used in class Map)
     * @return true if is a Doctor.
     */
    @Override
    public boolean isDoctor() {
        return true;
    }

    /**
     * Attempt to cure patient from infection.
     * @param patient reference to patient
     */
    private void heal(IHuman patient) {
        int r = RandomNumberGenerator.getIntegerFromRange(0, 99);
        int chanceToHeal = 100 - patient.getVirus().getVirusData().resistanceToTreatment;
        if (r < chanceToHeal)
            patient.cure();
    }

}
