import java.util.Scanner;

class Main {
    private Simulation simulation;
    private VirusData virusData;
    private int stepLimit;
    private int mapSize;
    private int humanCount;
    private int doctorCount;
    private int infectedCount;


    public static void main(String[] args){
        Main m = new Main();
        m.getDataFromUser();
        m.runSimulation();
    }

    /**
     * @param message
     * @param validStart
     * @param validEnd
     * @return integer from given range ( from user or generated randomly)
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
     * diplay starting text message and gets parameters from user
     */
    private void getDataFromUser(){
        virusData = new VirusData();

        System.out.println("<welcome user>");
        System.out.println("Please input the simulation data. (type 'r' to set random value instead)");
        mapSize = getInt("map size <integer> [0, 20000]: ", 1, 20000);
        stepLimit = getInt("step limit <integer>: [1,2000000]: ", 1, 200000);
        humanCount = getInt("Population <integer> [1,2000]: ", 1, 2000);
        doctorCount = getInt("Number of Doctors <integer> [0,2000]: ", 1, 2000);
        infectedCount = getInt("Number of Infected humans <integer>  [1,100]: ", 1,100);
        virusData.spreadChance = getInt("Virus's spread chance <integer> [0,100]: ", 0, 100);
        virusData.spreadRange = getInt("Virus's spread range <integer> [0,10]: ", 0, 10);
        virusData.mutationChance = getInt("Virus's mutation chance <integer> [0,100]: ", 0, 100);
        virusData.lethality = getInt("Virus's lethality <integer> [0,100]: ", 0, 100);
        virusData.resistanceToTreatment = getInt("Virus's resistance to treatment <integer> [0,100]: ", 0, 100);

    }

    /**
     * starts simulation
     */
    private void runSimulation() {
        simulation = new Simulation(mapSize, stepLimit, humanCount, doctorCount,infectedCount, virusData);
        simulation.run();
        simulation.writeResultsToFile();
    }

}
