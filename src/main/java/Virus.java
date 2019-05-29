import java.util.List;

public class Virus implements IVirus {
    private IHuman host;
    private VirusData data;
    private boolean mutatedLastStep = false;

    public Virus(IHuman host, VirusData data) {
        this.host = host;
        this.data = data;
    }

    public void update() {
        mutate();

        List<IHuman> humans = host.getParentMap().getHumansInRange(host.getCoordinates(), data.spreadRange);
        for (IHuman h : humans) {
            infect(h);
        }

        int r = RandomNumberGenerator.getIntegerFromRange(0, 100);
        if (data.lethality <= r)
            host.kill();

    }

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
        int r = RandomNumberGenerator.getIntegerFromRange(0, 100);
        if (r <= data.spreadChance) {
            Virus v = new Virus(human, data);
            human.infect(v);
        }
    }

    private void mutate() {/*TODO:Implement*/}
}