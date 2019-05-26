public class Virus implements IVirus {
    private IHuman host;
    private VirusData data;

    public Virus(IHuman host, VirusData data)
    {
        this.host = host;
        this.data = data;
    }

    public void update() { }
    public VirusData getVirusData() { return data; }
    // public int getSymptomsVisibility(){ ... return ? }
    // public boolean hasMutatedLastStep(){ ... return ? }
    private void infect(IHuman human) {}
    private void mutate(){}
}