
import java.util.ArrayList;
import java.util.List;

public class VirusData {


    public int spreadRange;
    public int spreadChance;
    public int mutationChance;
    public int lethality;
    public int resistanceToTreatment;
    List<Symptom> symptoms;

    //copy constructor
    VirusData(){
        symptoms = new ArrayList<>();
    }

    public VirusData(VirusData source) {
        this.spreadChance = source.spreadChance;
        this.spreadRange = source.spreadRange;
        this.mutationChance = source.spreadRange;
        this.lethality = source.spreadRange;
        this.resistanceToTreatment = source.spreadRange;

        this.symptoms = new ArrayList<>(source.symptoms);
    }
}
