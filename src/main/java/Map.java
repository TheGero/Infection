public class Map
{
    private int size;
    private IHuman[] humans;
    private HumanCreator hFactory;

    public Map(int size, int humanCount,int doctorCount)
    {
        this.size=size;
    }
    public void update() {/*TODO:Implement*/}

    // public IHuman[] getHumansInRange(Coordinates coordinates,int range) {/*TODO:Implement*/}

    // public int getHumansLeft();
    // public int getDoctorsLeft();
    // public int getInfectedLeft();
    public int getSize(){return size;}
    //public int getMutationCount();
    private void startInfection(){/*TODO:Implement*/}

}
