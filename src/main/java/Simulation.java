import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Simulation {
    private int stepLimit;
    private int stepCounter;
    private Map map;

    private int[] humanCountArray;
    private int[] doctorCountArray;
    private int[] infectedCountArray;
    private int[] deadCountArray;
    private int[] mutationCountArray;

    private Simulation() {
    }

    public Simulation(int mapSize, int stepLimit, int humanCount, int doctorCount,int infectedCount, VirusData virusData) {
        map = new Map(mapSize, humanCount, doctorCount,infectedCount, virusData);
        this.stepLimit = stepLimit;
        stepCounter = 0;

        humanCountArray = new int[stepLimit];
        doctorCountArray = new int[stepLimit];
        infectedCountArray = new int[stepLimit];
        deadCountArray = new int[stepLimit];
        mutationCountArray = new int[stepLimit];
    }

    public void run() {
        while (stepCounter < stepLimit && map.getInfectedLeft() > 0 && map.getHumansLeft() > 0) {
            step();
            logStep();
        }

        writeResultsToFile();
    }

    private void step() {
        map.update();
        stepCounter++;
        System.out.println(stepCounter);
    }

    private void logStep() {
        humanCountArray[stepCounter - 1] = map.getHumansLeft();
        doctorCountArray[stepCounter-1] = map.getDoctorsLeft();
        infectedCountArray[stepCounter - 1] = map.getInfectedLeft();
        deadCountArray[stepCounter - 1] = map.getDeadCount();
        mutationCountArray[stepCounter - 1] = map.getMutationCount();
    }

    public void writeResultsToFile() {
        File file;
        FileWriter fw;
        try {
            file = new File("results.csv");
            fw = new FileWriter(file);
        } catch (IOException e) {
            System.out.println("Could not open file: " + e.getMessage());
            return;
        }

        try {
            fw.write("Step;\"Humans Left\";\"Doctors Left\";\"Infected\";\"Dead\";\"Mutations\"\n");
        } catch (IOException e) {
            System.out.println("Could not write to file: \" + e.getMessage()");
        }

        for (int i = 0; i < stepCounter; i++) {
            try {
                fw.write(Integer.toString(i + 1) + ';' + humanCountArray[i] + ';' + doctorCountArray[i] + ';' + infectedCountArray[i] + ';' + deadCountArray[i] + ';' + mutationCountArray[i] + '\n');
            } catch (IOException e) {
                System.out.println("Could not write to file: \" + e.getMessage()");
            }
        }

        try {
            fw.close();
        } catch (IOException e) {
            System.out.println("Exception occurred while closing the file: " + e.getMessage());
        }
    }

}
