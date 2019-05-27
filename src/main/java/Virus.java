public class Virus implements IVirus {
    private IHuman host;
    private VirusData data;
    private boolean mutatedLastStep = false;

    public Virus(IHuman host, VirusData data)
    {
        this.host = host;
        this.data = data;
    }

    public void update() {/*TODO:Implement*/ }
    public VirusData getVirusData() { return data; }

    public int getSymptomsVisibility() {
        int visibilitySum = 0;

        for (Symptom s : data.symptoms) {
            visibilitySum += s.getVisibility();
        }

        return visibilitySum;
    }

    public boolean hasMutatedLastStep() {
        return mutatedLastStep;
    }

    private void infect(IHuman human) {
        /*TODO:Implement*/
    }

    private void mutate() {/*TODO:Implement*/}
}