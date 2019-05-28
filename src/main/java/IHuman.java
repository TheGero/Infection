public interface IHuman
{
    void update();

    boolean isAlive();

    boolean isInfected();

    boolean isDoctor();

    boolean hasVisibleSymptoms();

    void infect(IVirus virus);

    void cure();

    void kill();

    Map getParentMap();

    Coordinates getCoordinates();

    void setCoordinates(Coordinates coordinates);

    IVirus getVirus();

}
