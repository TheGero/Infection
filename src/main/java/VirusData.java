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

    public int spreadRange;
    public int spreadChance;
    public int mutationChance;
    public int lethality;
    public int resistanceToTreatment;
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
