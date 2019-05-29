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

    public void move() {/*TODO:Implement*/}


}