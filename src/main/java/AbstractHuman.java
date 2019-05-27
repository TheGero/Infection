public abstract class AbstractHuman implements IHuman
{
    private boolean alive;
    private IVirus virus;
    private Map parentMap;
    private Coordinates coordinates;

    public AbstractHuman(Map parentMap) {
        this.parentMap = parentMap;
        alive = true;
        virus = null;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isInfected() {
        return (virus != null);
    }

    public boolean hasVisibleSymptoms() {/*temporary TODO:Implement*/
        return true;
    }

    public void infect(IVirus virus) {
        this.virus = virus;
    }

    public void cure() {
        virus = null;
    }

    public void kill() {
        alive = false;
    }

    public Map getParentMap() {
        return parentMap;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public IVirus getVirus() {
        return virus;
    }

    public void move() {/*TODO:Implement*/}


}