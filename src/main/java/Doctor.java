import java.util.List;

public class Doctor extends AbstractHuman {
    public Doctor(Map parentMap) {
        super(parentMap);
    }

    @Override
    public void update() {
        if (!isAlive()) return;

        List<IHuman> humans = getParentMap().getHumansInRange(getCoordinates(), 2);
        for (IHuman h : humans) {
            if (h.hasVisibleSymptoms()) heal(h);
        }

        if (isInfected())
            getVirus().update();
    }

    @Override
    public boolean isDoctor() {
        return true;
    }

    private void heal(IHuman patient) {
        int r = RandomNumberGenerator.getIntegerFromRange(0, 100);
        int chanceToHeal = 100 - patient.getVirus().getVirusData().resistanceToTreatment;
        if (r < chanceToHeal)
            patient.cure();
    }

}
