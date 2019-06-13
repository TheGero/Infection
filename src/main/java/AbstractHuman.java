/**
 * AbstractHuman stores fields and methods shared by Human and Doctor classes.
 *
 * @author Kacper Lesnianski, Patryk Plociennik
 * @version 1.0
 */
public abstract class AbstractHuman implements IHuman {
    /**
     * A binary value that represents the state of the Human - dead of alive.
     * Update() method won't perform certain actions if Human is dead.
     */
    private boolean alive;
    /**
     * Reference to Virus that infected Human. If Human is not infected this field is set to null.
     */
    private IVirus virus;
    /**
     * Reference to map Human is stored in.
     */
    private Map parentMap;
    /**
     * Coordinates are used to determine location of Human on the Map.
     */
    private Coordinates coordinates;

    /**
     * Sets default values
     *
     * @param parentMap Reference to Map storing the Human.
     */
    public AbstractHuman(Map parentMap) {
        coordinates = new Coordinates();
        this.parentMap = parentMap;
        alive = true;
        virus = null;
    }

    /**
     * @return true if Human is alive.
     */
    @Override
    public boolean isAlive() {
        return alive;
    }

    /**
     *
     * @return true if Human is infected.
     */
    @Override
    public boolean isInfected() {
        return (virus != null);
    }

    /**
     * This method determines whether symptoms of infection can be spotted by nearby Humans.
     * This is done by generating a random number from 0 to 99
     * and comparing it to the sum of visibility parameter of all Symptoms of Virus.
     * If the random number is smaller, return true.
     * If it is not - return false;
     * @return true if Human has visible symptoms of infection. False if not.
     */
    @Override
    public boolean hasVisibleSymptoms() {
        if (!isInfected()) return false;

        int visSum = virus.getSymptomsVisibility();
        if (visSum >= 100)
            return true;
        else {
            int r = RandomNumberGenerator.getIntegerFromRange(0, 99);
            return r < visSum;
        }
    }

    /**
     * Infects Human with Virus.
     * @param virus Virus to infect Human with.
     */
    @Override
    public void infect(IVirus virus) {
        this.virus = virus;
    }

    /**
     *  Cure from infection. Sets Virus field to null.
     */
    @Override
    public void cure() {
        virus = null;
    }

    /**
     * Kill (set alive to false).
     */
    @Override
    public void kill() {
        alive = false;
    }

    /**
     *
     * @return reference to Map storing the Human.
     */
    @Override
    public Map getParentMap() {
        return parentMap;
    }

    /**
     *
     * @return Coordinates.
     */
    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Sets Coordinates.
     * @param coordinates Coordinates to set.
     */
    @Override
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     *
     * @return reference to Virus(Returns null if not infected).
     */
    @Override
    public IVirus getVirus() {
        return virus;
    }

    /**
     * Move in specified direction.
     * @param direction Direction of move (1-UP, 2-DOWN, 3-LEFT, 4-RIGHT).
     * @param range Range of move.
     */
    public void move(int direction, int range) {
        // 1 = Moving Up
        // 2 = Moving Down
        // 3 = Moving Left
        // 4 = Moving Right
        if (direction == 1) {
            coordinates.setY(coordinates.getY() + range);
        } else if (direction == 2) {
            coordinates.setY(coordinates.getY() - range);
        } else if (direction == 3) {
            coordinates.setX(coordinates.getX() - range);
        } else if (direction == 4) {
            coordinates.setX(coordinates.getX() + range);
        }
        if (coordinates.getY() < 0) {
            coordinates.setY(0);
        } else if (coordinates.getX() < 0) {
            coordinates.setX(0);
        } else if (coordinates.getY() > parentMap.getSize()) {
            coordinates.setY(parentMap.getSize());
        } else if (coordinates.getX() > parentMap.getSize()) {
            coordinates.setX(parentMap.getSize());
        }
    }

    /**
     * Move in random direction.
     */
    public void move() {
        int direction = RandomNumberGenerator.getIntegerFromRange(1,4);
        int range = RandomNumberGenerator.getIntegerFromRange(1, 5);
        move(direction, range);
    }
}