
import java.util.ArrayList;
import java.util.List;

public class VirusData {
    public int spreadRange;
    public int spreadChance;
    public int mutationChance;
    public int lethality;
    public int resistanceToTreatment;
    List<Symptom> symptoms;

    VirusData(){
        symptoms = new ArrayList<>();
    }
}
