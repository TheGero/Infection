import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
* Map creates, stores and updates Humans.
*
 * @author Kacper Lesnianski, Patryk Plociennik
* @version 1.0
*/
public class Map
{
    /**
     * Size of the Map (Map is a square, therefore only one number is needed).
     */
    private int size;
    /**
     * Array of humans on the map.
     */
    private List<IHuman> humans;
    /**
     * Reference to humanCreator.
     */
    private HumanCreator hCreator;

    /**
     * Creates Map, populates it with desired number of Humans, Doctors, and Humans infected by Virus.
     * @param size Size of the map.
     * @param humanCount Number of not infected humans to place on the map.
     * @param doctorCount Number of Doctors to place on the map.
     * @param infectedCount Number of infected Humans to place on the map.
     * @param virusData Data of the Virus.
     */
    public Map(int size, int humanCount, int doctorCount,int infectedCount, VirusData virusData) {
        this.size=size;
        humans = new ArrayList<>();
        hCreator = new HumanCreator();

        for (int i = 0; i < doctorCount; i++) {
            IHuman h = hCreator.createDoctor(this);
            int x = RandomNumberGenerator.getIntegerFromRange(1, size);
            int y = RandomNumberGenerator.getIntegerFromRange(1, size);
            Coordinates c = new Coordinates(x, y);
            h.setCoordinates(c);
            humans.add(h);
        }
        for (int i = 0; i < humanCount ; i++) {
            IHuman h = hCreator.createHuman(this);
            int x = RandomNumberGenerator.getIntegerFromRange(1, size);
            int y = RandomNumberGenerator.getIntegerFromRange(1, size);
            Coordinates c = new Coordinates(x, y);
            h.setCoordinates(c);
            humans.add(h);
        }
        startInfection(virusData, infectedCount);
    }

    /**
     * Calls update() method of every Human on the Map.
     */
    public void update() {
        for (IHuman h : humans) {
            h.update();
        }
    }

    /**
     * Returns List of Humans, whose Euclidean distance from given coordinates is less or equal to range parameter.
     * @param coordinates Point to start measuring from.
     * @param range Maximum range.
     * @return List of Humans whose Euclidean distance from given coordinates is less or equal to range parameter.
     */
    public List<IHuman> getHumansInRange(Coordinates coordinates, int range) {
        List<IHuman> humansInRange = new ArrayList<>();
        for (IHuman h : humans) {
            Coordinates c =
                    new Coordinates(coordinates.getX() - h.getCoordinates().getX(), coordinates.getY() - h.getCoordinates().getY());
            double distance = sqrt(pow(c.getX(), 2) + pow(c.getY(), 2));
            if (distance <= range)
                humansInRange.add(h);
        }
        return humansInRange;
    }

    /**
     *
     * @return Number of living Humans left on the Map.
     */
    public int getHumansLeft() {
        int i = 0;
        for (IHuman h : humans) {
            if (h.isAlive()) i++;
        }
        return i;
    }

    /**
     *
     * @return Number of living Doctors left on the Map.
     */
    public int getDoctorsLeft() {
        int i = 0;
        for (IHuman h : humans) {
            if (h.isAlive() && h.isDoctor()) i++;
        }
        return i;
    }

    /**
     *
     * @return Number of living infected Humans left on the Map.
     */
    public int getInfectedLeft() {
        int i = 0;
        for (IHuman h : humans) {
            if (h.isAlive() && h.isInfected()) i++;
        }
        return i;
    }

    /**
     *
     * @return Number of dead Humans on the Map.
     */
    public int getDeadCount() {
        int i = 0;
        for (IHuman h : humans) {
            if (!h.isAlive()) i++;
        }
        return i;
    }

    /**
     *
     * @return number of Mutations that occurred last step.
     */
    public int getMutationCount() {
        int i = 0;
        for (IHuman h : humans) {
            if (h.isAlive() && h.isInfected() && h.getVirus().hasMutatedLastStep()) i++;
        }
        return i;
    }

    /**
     *
     * @return Size of the Map.
     */
    public int getSize(){return size;}

    /**
     * Puts a specified number of infected Humans on the Map.
     * @param virusData Data of Virus to infect Humans with.
     * @param infectedCount Number of infected Humans to create.
     */
    private void startInfection(VirusData virusData, int infectedCount) {
        for (int i = 0; i < infectedCount; i++) {
            IHuman h = hCreator.createInfected(this, new VirusData(virusData));
            int x = RandomNumberGenerator.getIntegerFromRange(1, size);
            int y = RandomNumberGenerator.getIntegerFromRange(1, size);
            Coordinates c = new Coordinates(x, y);
            h.setCoordinates(c);
            humans.add(h);
        }
    }
}
