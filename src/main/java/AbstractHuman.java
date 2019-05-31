/**
 * AbstractHuman stores fields and methods shared by Human and Doctor classes;
 *
 * @author Kacper Leśniański, Patryk Płóciennik
 * @version 1.0
 */
public abstract class AbstractHuman implements IHuman {
    private boolean alive;
    private IVirus virus;
    private Map parentMap;
    private Coordinates coordinates;

    /**
     * Sets default values
     *
     * @param parentMap Reference to Map storing the Human
     */
    public AbstractHuman(Map parentMap) {
        coordinates = new Coordinates();
        this.parentMap = parentMap;
        alive = true;
        virus = null;
    }

    /**
     * @return true if Human is alive
     */
    @Override
    public boolean isAlive() {
        return alive;
    }

    /**
     *
     * @return true if Human is infected
     */
    @Override
    public boolean isInfected() {
        return (virus != null);
    }

    /**
     *
     * @return true if Human has visible symptoms of infection
     */
    @Override
    public boolean hasVisibleSymptoms() {
        if (!isInfected()) return false;

        int visSum = virus.getSymptomsVisibility();
        if (visSum >= 100)
            return true;
        else {
            int r = RandomNumberGenerator.getIntegerFromRange(0, 100);
            return r < visSum;
        }
    }

    /**
     * Infects Human with Virus.
     * @param virus reference to Virus to infect Human with.
     */
    @Override
    public void infect(IVirus virus) {
        this.virus = virus;
    }

    /**
     *  method used by Doctor class objects to cure infected Humans.
     */
    @Override
    public void cure() {
        virus = null;
    }

    /**
     * method used by Virus to kill infected Humans.
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
     * @return reference to Coordinates object in AbstractHuman class.
     */
    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Sets Coordinates of Human.
     * @param coordinates Coordinates to set
     */
    @Override
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     *
     * @return reference to Virus.
     */
    @Override
    public IVirus getVirus() {
        return virus;
    }

    /**
     * Move in specified direction
     * @param direction Direction of move
     * @param range Range of move
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
     * Move in random direction
     */
    public void move() {
        int direction = RandomNumberGenerator.getIntegerFromRange(1,4);
        int range = RandomNumberGenerator.getIntegerFromRange(1, 5);
        move(direction, range);
    }
}