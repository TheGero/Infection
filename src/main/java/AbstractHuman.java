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
    public boolean hasVisibleSymptoms() {
        if (!isInfected()) return false;

        int visSum = virus.getSymptomsVisibility();
        if (visSum >= 100)
            return true;
        else {
            int r = RandomNumberGenerator.getIntegerFromRange(0, 100);
            return r <= visSum;
        }
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
        int direction = RandomNumberGenerator.getIntegerFromRange(1,4);
        int range = RandomNumberGenerator.getIntegerFromRange(1,2);
        // 1 = Moving Up
        // 2 = Moving Down
        // 3 = Moving Left
        // 4 = Moving Right
        if (direction == 1) {
            coordinates.setY(coordinates.getY() + range);
        }
        else if (direction == 2) {
            coordinates.setY(coordinates.getY() - range);
        }
        else if (direction == 3) {
            coordinates.setX(coordinates.getX() - range);
        }
        else if (direction == 4) {
            coordinates.setX(coordinates.getX() + range);
        }
        if (coordinates.getY()<0){coordinates.setY(0);}
        else if (coordinates.getX()<0){coordinates.setX(0);}
        else if (coordinates.getY()>parentMap.getSize()){coordinates.setY(parentMap.getSize());}
        else if (coordinates.getX()>parentMap.getSize()){coordinates.setX(parentMap.getSize());}
    }
}