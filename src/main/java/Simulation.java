import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is responsible for running the simulation
 * and saving data to CSV file.
 *
 * @author Kacper Lesnianski, Patryk Plociennik
 * @version 1.0
 */
public class Simulation {
    /**
     * Maximum number of steps of the simulation.
     */
    private int stepLimit;
    /**
     * An integer that counts steps of the simulation.
     */
    private int stepCounter;
    /**
     * Map used by the simulation.
     */
    private Map map;

    /**
     * Arrays used to store simulation data from each step.
     */
    private int[] humanCountArray;
    private int[] doctorCountArray;
    private int[] infectedCountArray;
    private int[] deadCountArray;
    private int[] mutationCountArray;

    /**
     * Constructor initialises arrays and Map.
     *
     * @param mapSize       size of the Map to create.
     * @param stepLimit     maximum number of steps of the simulation.
     * @param humanCount    number of not infected Humans to create.
     * @param doctorCount   number of Doctors to create.
     * @param infectedCount number of infected Humans to create.
     * @param virusData     data of Virus to infect Humans with.
     */
    public Simulation(int mapSize, int stepLimit, int humanCount, int doctorCount, int infectedCount, VirusData virusData) {
        map = new Map(mapSize, humanCount, doctorCount,infectedCount, virusData);
        this.stepLimit = stepLimit;
        stepCounter = 0;

        humanCountArray = new int[stepLimit];
        doctorCountArray = new int[stepLimit];
        infectedCountArray = new int[stepLimit];
        deadCountArray = new int[stepLimit];
        mutationCountArray = new int[stepLimit];
    }

    /**
     * Run simulation until an ending condition is met.
     * Ending conditions:
     * -step Limit reached
     * -no infected Humans left
     * -no living Humans left
     */
    public void run() {
        while (stepCounter < stepLimit && map.getInfectedLeft() > 0 && map.getHumansLeft() > 0) {
            step();
            logStep();
        }

        writeResultsToFile();
    }

    /**
     * Update map, increment stepCounter and print stepCounter to console.
     */
    private void step() {
        map.update();
        stepCounter++;
        System.out.println("Step: " + stepCounter);
    }

    /**
     * Store simulation data from last step.
     */
    private void logStep() {
        humanCountArray[stepCounter - 1] = map.getHumansLeft();
        doctorCountArray[stepCounter-1] = map.getDoctorsLeft();
        infectedCountArray[stepCounter - 1] = map.getInfectedLeft();
        deadCountArray[stepCounter - 1] = map.getDeadCount();
        mutationCountArray[stepCounter - 1] = map.getMutationCount();
    }

    /**
     * Write simulation data from all steps to CSV file.
     */
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
