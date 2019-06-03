import java.util.List;

/**
 * Class representing a Virus.
 *
 * @author Kacper Lesnianski, Patryk Plociennik
 * @version 1.0
 */
public class Virus implements IVirus {
    private IHuman host;
    private VirusData data;
    private boolean mutatedLastStep = false;

    /**
     * Creates a Virus with given data.
     *
     * @param host reference to Virus's host.
     * @param data Virus's data.
     */
    public Virus(IHuman host, VirusData data) {
        this.host = host;
        this.data = data;
    }

    /**
     * Method called each step of the simulation.
     * Virus tries to mutate, infect nearby Humans,
     * and to kill its host (in this exact order).
     */
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

    /**
     *
     * @return Virus's data
     */
    public VirusData getVirusData() { return data;
    }

    /**
     *
     * @return Sum of visibility parameter of all Symptoms caused by this Virus.
     */
    public int getSymptomsVisibility() {
        int visibilitySum = 0;

        for (Symptom s : data.symptoms) {
            visibilitySum += s.getVisibility();
        }

        return visibilitySum;
    }

    /**
     *
     * @return true if mutated last step.
     */
    public boolean hasMutatedLastStep() {
        return mutatedLastStep;
    }

    /**
     * Virus attempts to infect human with its copy.
     * @param human Human to infect.
     */
    private void infect(IHuman human) {
        int r = RandomNumberGenerator.getIntegerFromRange(0, 100);
        if (r < data.spreadChance) {
            Virus v = new Virus(human, new VirusData(data));
            human.infect(v);
        }
    }

    /**
     * Virus mutates.
     * Random Virus data is generated and added to existing data.
     * There is also a chance to develop new Symptoms.
     * Mutations can affect the Virus both positively and negatively.
     */
    private void mutate() {
        int spreadRange = RandomNumberGenerator.getIntegerFromRange(-1, 1);
        int spreadChance = RandomNumberGenerator.getIntegerFromRange(-5, 5);
        int mutationChance = RandomNumberGenerator.getIntegerFromRange(-2, 2);
        int lethality = RandomNumberGenerator.getIntegerFromRange(-10, 10);
        int resistanceToTreatment = RandomNumberGenerator.getIntegerFromRange(-5, 5);

        //chance to develop a new symptom
        int r = RandomNumberGenerator.getIntegerFromRange(0, 1);
        if (r == 0) {
            Symptom s = new Symptom(RandomNumberGenerator.getIntegerFromRange(1, 100));
            data.symptoms.add(s);
        }
        //chance to remove a symptom
        r = RandomNumberGenerator.getIntegerFromRange(0, 1);
        if (r == 0) {
            if (!data.symptoms.isEmpty())
                data.symptoms.remove(data.symptoms.size() - 1);
        }

        data.spreadRange += spreadRange;
        data.spreadChance += spreadChance;
        data.mutationChance += mutationChance;
        data.lethality += lethality;
        data.resistanceToTreatment += resistanceToTreatment;

        //we don't want these values to exceed valid ranges TODO:maybe move those checks to virusData getters/setters?
        if (data.spreadRange > 5) data.spreadRange = 5;
        if (data.spreadRange < 0) data.spreadRange = 0;
        if (data.spreadChance > 100) data.spreadChance = 100;
        if (data.spreadChance < 0) data.spreadChance = 0;
        if (data.mutationChance > 100) data.mutationChance = 100;
        if (data.mutationChance < 0) data.mutationChance = 0;
        if (data.lethality < 0) data.lethality = 0;
        if (data.lethality > 100) data.lethality = 100;
        if (data.resistanceToTreatment < 0) data.resistanceToTreatment = 0;
        if (data.resistanceToTreatment > 100) data.resistanceToTreatment = 100;
    }
}