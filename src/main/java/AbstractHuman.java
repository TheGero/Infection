public abstract class AbstractHuman implements IHuman {
    private boolean alive;
    private IVirus virus;
    private Map parentMap;
    private Coordinates coordinates;

    public AbstractHuman(Map parentMap) {
        this.parentMap = parentMap;
        alive = true;
        virus = null;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public boolean isInfected() {
        return (virus != null);
    }

    @Override
    public boolean hasVisibleSymptoms() {/*temporary TODO:Implement*/
        return true;
    }

    @Override
    public void infect(IVirus virus) {
        this.virus = virus;
    }

    @Override
    public void cure() {
        virus = null;
    }

    @Override
    public void kill() {
        alive = false;
    }

    @Override
    public Map getParentMap() {
        return parentMap;
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public IVirus getVirus() {
        return virus;
    }

    public void move() {
        int direction = 0;
        direction = RandomNumberGenerator.getIntegerFromRange(1,4);
        // 1 = Moving Up
        // 2 = Moving Down
        // 3 = Moving Left
        // 4 = Moving Right
        if (direction == 1) {
            coordinates.setY(coordinates.getY() + 1);
        }
        else if (direction == 2) {
            coordinates.setY(coordinates.getY() - 1);
        }
        else if (direction == 3) {
            coordinates.setX(coordinates.getX() - 1);
        }
        else if (direction == 4) {
            coordinates.setX(coordinates.getX() + 1);
        }
    }
}