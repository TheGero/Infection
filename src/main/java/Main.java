import java.util.Scanner;

/**
 * The purpose of this class is to get required data from user
 * (or generate them randomly) and start the Simulation.
 *
 * @author Kacper Lesnianski, Patryk Plociennik
 * @version 1.0
 */
class Main {
    /**
     * Simulation we want to run.
     */
    private Simulation simulation;
    /**
     * Data of the first Virus object to create.
     */
    private VirusData virusData;
    /**
     * Maximum number of steps of the simulation.
     */
    private int stepLimit;
    /**
     * Size of the Map (Map is a square, therefore only one number is needed).
     */
    private int mapSize;
    /**
     * Number of regular Humans to place on the Map.
     */
    private int humanCount;
    /**
     * Number of Doctors to place on the map.
     */
    private int doctorCount;
    /**
     * Number of infected Humans to place on the Map.
     */
    private int infectedCount;

    /**
     * Entry point.
     * @param args command line parameters (unused).
     */
    public static void main(String[] args){
        Main m = new Main();
        m.getDataFromUser();
        m.runSimulation();
    }

    /**
     * Get an integer from specified interval from user, or generate it randomly on user's request.
     * @param message Message to display to user.
     * @param validStart Start of valid values interval.
     * @param validEnd End of valid values interval.
     * @return integer from specified interval.
     */
    private int getInt(String message, int validStart, int validEnd){
        int value;
        Scanner s = new Scanner(System.in);

        while(true){
            System.out.print(message);
            if(s.hasNext()) {
                //check if user entered an integer
                if (s.hasNextInt()) {
                    value = s.nextInt();

                    if (value >= validStart && value <= validEnd)
                        return value;

                    System.out.println("Invalid input. Please enter a value from range [" + validStart + ", " + validEnd + "]");
                } else if(s.next().equals("r")){
                    value = RandomNumberGenerator.getIntegerFromRange(validStart,validEnd);
                    System.out.println("value set to " + value);
                    return value;
                } else{
                    System.out.println("Invalid input, try again");
                }
            }
        }
    }

    /**
     * Print welcome message and ask the User for parameters.
     */
    private void getDataFromUser(){
        virusData = new VirusData();

        System.out.println("Infection v 1.0");
        System.out.println("Please input the simulation data. (type 'r' to set random value instead)");
        mapSize = getInt("map size <integer> [0, 20000]: ", 1, 20000);
        stepLimit = getInt("step limit <integer>: [1,2000000]: ", 1, 200000);
        humanCount = getInt("Population <integer> [1,10000]: ", 1, 10000);
        doctorCount = getInt("Number of Doctors <integer> [0,2000]: ", 0, 2000);
        infectedCount = getInt("Number of Infected humans <integer>  [1,100]: ", 1,100);
        virusData.spreadChance = getInt("Virus's spread chance <integer> [0,100]: ", 0, 100);
        virusData.spreadRange = getInt("Virus's spread range <integer> [0,10]: ", 0, 10);
        virusData.mutationChance = getInt("Virus's mutation chance <integer> [0,100]: ", 0, 100);
        virusData.lethality = getInt("Virus's lethality <integer> [0,100]: ", 0, 100);
        virusData.resistanceToTreatment = getInt("Virus's resistance to treatment <integer> [0,100]: ", 0, 100);

    }

    /**
     * Start simulation.
     */
    private void runSimulation() {
        simulation = new Simulation(mapSize, stepLimit, humanCount, doctorCount,infectedCount, virusData);
        simulation.run();
        simulation.writeResultsToFile();
    }

}
