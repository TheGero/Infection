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
        int r = RandomNumberGenerator.getIntegerFromRange(0, 100);
        if (r < data.mutationChance) {
            mutate();
            mutatedLastStep = true;
        } else {
            mutatedLastStep = false;
        }

        List<IHuman> humans = host.getParentMap().getHumansInRange(host.getCoordinates(), data.spreadRange);
        for (IHuman h : humans) {
            if (h != host && !h.isInfected())
                infect(h);
        }

        r = RandomNumberGenerator.getIntegerFromRange(0, 100);
        if (r < data.lethality)
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
        if (r < data.spreadChance) {
            Virus v = new Virus(human, new VirusData(data));
            human.infect(v);
        }
    }

    private void mutate() {
        int spreadRange = RandomNumberGenerator.getIntegerFromRange(-2, 2);
        int spreadChance = RandomNumberGenerator.getIntegerFromRange(-10, 10);
        int mutationChance = RandomNumberGenerator.getIntegerFromRange(-10, 10);
        int lethality = RandomNumberGenerator.getIntegerFromRange(-2, 2);
        int resistanceToTreatment = RandomNumberGenerator.getIntegerFromRange(-10, 10);

        int r = RandomNumberGenerator.getIntegerFromRange(0, 1);
        if (r == 0) {
            Symptom s = new Symptom(RandomNumberGenerator.getIntegerFromRange(1, 100));
            data.symptoms.add(s);
        }

        data.spreadRange += spreadRange;
        data.spreadChance += spreadChance;
        data.mutationChance += mutationChance;
        data.lethality += lethality;
        data.resistanceToTreatment += resistanceToTreatment;

        //we don't want these values to exceed valid ranges TODO:maybe move those checks to virusData getters/setters?
        if (data.spreadRange > 5) data.spreadRange = 5;
        if (data.spreadRange < 0) data.spreadRange = 0;
        if (data.spreadChance > 100) data.spreadRange = 100;
        if (data.spreadChance < 0) data.spreadRange = 0;
        if (data.mutationChance > 100) data.mutationChance = 100;
        if (data.mutationChance < 0) data.mutationChance = 0;
        if (data.lethality < 0) data.lethality = 0;
        if (data.lethality > 100) data.lethality = 100;
        if (data.resistanceToTreatment < 0) data.resistanceToTreatment = 0;
        if (data.resistanceToTreatment > 100) data.resistanceToTreatment = 100;
    }
}