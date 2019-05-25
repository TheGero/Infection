import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Simulation {
    private int stepLimit;
    private int stepCounter;
    private Map map;

    private int[] humanCountArray;
    private int[] doctorCountArray;
    private int[] deadCountArray;
    private int[] mutationCountArray;

    private Simulation() {
    }

    public Simulation(int mapSize, int stepLimit, int humanCount, int doctorCount, VirusData virusData) {
        //map = new Map(mapSize, humanCount, doctorCount, virusData);
        this.stepLimit = stepLimit;
        stepCounter = 0;

        humanCountArray = new int[stepLimit];
        doctorCountArray = new int[stepLimit];
        deadCountArray = new int[stepLimit];
        mutationCountArray = new int[stepLimit];
    }

    public void run() {
        while (stepCounter < stepLimit) {
            step();
            logStep();
        }

        writeResultsToFile();
    }

    private void step() {
        //map.update();
        stepCounter++;
    }

    private void logStep() {
       /* humanCountArray[stepCounter-1] = map.getHumansLeft();
        doctorCountArray[stepCounter-1] = map.getDoctorsLeft();
        deadCountArray[stepCounter-1] = map.getInfectedLeft();
        mutationCountArray[stepCounter-1] = map.getMutationCount();*/

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
            fw.write("Step,\"Humans Left\",\"Doctors Left\",\"Dead\",\"Mutations\"");
        } catch (IOException e) {
            System.out.println("Could not write to file: \" + e.getMessage()");
        }

        for (int i = 0; i < stepLimit; i++) {
            try {
                fw.write((i+1) + ',' + humanCountArray[i] + ',' + doctorCountArray[i] + ',' + deadCountArray[i] + ',' + mutationCountArray[i] + '\n');
            } catch (IOException e) {
                System.out.println("Could not write to file: \" + e.getMessage()");
            }
        }

        try {
            fw.close();
        } catch (IOException e) {
            System.out.println("Exception occured while closing the file: " + e.getMessage());
        }
    }

}
