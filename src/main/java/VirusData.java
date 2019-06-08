import java.util.ArrayList;
import java.util.List;

/**
 * A "struct" containing various parameters of virus.
 * Used for conveniently moving data between classes.
 *
 * @author Kacper Lesnianski, Patryk Plociennik
 * @version 1.0
 */
public class VirusData {

    /**
     * Maximum range of virus spread.
     */
    public int spreadRange;
    /**
     * Chance (in %) of infecting nearby Humans.
     */
    public int spreadChance;
    /**
     * Chance (in %) of mutation.
     */
    public int mutationChance;
    /**
     * Chance (in %) to kill infected Human
     */
    public int lethality;
    /**
     * Resistance of treatment (in %).
     */
    public int resistanceToTreatment;
    /**
     * Array of symptoms of the infection.
     */
    List<Symptom> symptoms;

    /**
     * Default constructor.
     */
    VirusData(){
        symptoms = new ArrayList<>();
    }

    /**
     * Copy constructor.
     * @param source VirusData object to copy.
     */
    public VirusData(VirusData source) {
        this.spreadChance = source.spreadChance;
        this.spreadRange = source.spreadRange;
        this.mutationChance = source.mutationChance;
        this.lethality = source.lethality;
        this.resistanceToTreatment = source.resistanceToTreatment;

        this.symptoms = new ArrayList<>(source.symptoms);
    }
}
