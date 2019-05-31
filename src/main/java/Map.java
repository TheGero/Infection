import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Map
{
    private int size;
    private List<IHuman> humans;
    private HumanCreator hCreator;

    public Map(int size, int humanCount, int doctorCount,int infectedCount, VirusData virusData) {
        this.size=size;
        humans = new ArrayList<>();
        hCreator = new HumanCreator();

        for (int i = 0; i < doctorCount; i++) {
            IHuman h = hCreator.createDoctor(this);
            int x = RandomNumberGenerator.getIntegerFromRange(1, size);
            int y = RandomNumberGenerator.getIntegerFromRange(1, size);
            Coordinates c = new Coordinates(x, y);
            h.setCoordinates(c);
            humans.add(h);
        }
        for (int i = 0; i < humanCount ; i++) {
            IHuman h = hCreator.createHuman(this);
            int x = RandomNumberGenerator.getIntegerFromRange(1, size);
            int y = RandomNumberGenerator.getIntegerFromRange(1, size);
            Coordinates c = new Coordinates(x, y);
            h.setCoordinates(c);
            humans.add(h);
        }
        startInfection(virusData, infectedCount);
    }

    public void update() {
        for (IHuman h : humans) {
            h.update();
        }
    }

    public List<IHuman> getHumansInRange(Coordinates coordinates, int range) {
        List<IHuman> humansInRange = new ArrayList<>();
        for (IHuman h : humans) {
            Coordinates c =
                    new Coordinates(coordinates.getX() - h.getCoordinates().getX(), coordinates.getY() - h.getCoordinates().getY());
            double distance = sqrt(pow(c.getX(), 2) + pow(c.getY(), 2));
            if (distance <= range)
                humansInRange.add(h);
        }
        return humansInRange;
    }

    public int getHumansLeft() {
        int i = 0;
        for (IHuman h : humans) {
            if (h.isAlive()) i++;
        }
        return i;
    }

    public int getDoctorsLeft() {
        int i = 0;
        for (IHuman h : humans) {
            if (h.isAlive() && h.isDoctor()) i++;
        }
        return i;
    }

    public int getInfectedLeft() {
        int i = 0;
        for (IHuman h : humans) {
            if (h.isAlive() && h.isInfected()) i++;
        }
        return i;
    }

    public int getMutationCount() {
        int i = 0;
        for (IHuman h : humans) {
            if (h.isAlive() && h.isInfected() && h.getVirus().hasMutatedLastStep()) i++;
        }
        return i;
    }

    public int getDeadCount() {
        int i = 0;
        for (IHuman h : humans) {
            if (!h.isAlive()) i++;
        }
        return i;
    }

    public int getSize(){return size;}

    private void startInfection(VirusData virusData, int infectedCount) {
        for (int i = 0; i < infectedCount; i++) {
            IHuman h = hCreator.createInfected(this, new VirusData(virusData));
            int x = RandomNumberGenerator.getIntegerFromRange(1, size);
            int y = RandomNumberGenerator.getIntegerFromRange(1, size);
            Coordinates c = new Coordinates(x, y);
            h.setCoordinates(c);
            humans.add(h);
        }
    }
}
