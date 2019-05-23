import java.util.Scanner;

class Main {
    private Simulation sim;
    private VirusData vData;
    private int stepLimit;
    private int mapSize;
    private int humanCount;
    private int doctorCount;

    public static void main(String[] args){
        Main m = new Main();
        m.getDataFromUser();
        //Simulation sim = new Simulation(mapSize, stepLimit, humanCount, doctorCount, virusData);
    }

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
                }
                else if(s.next().equals("r")){
                    value = RandomNumberGenerator.getIntegerFromRange(validStart,validEnd);
                    System.out.println("value set to " + value);
                    return value;
                }
                else{
                    System.out.println("Invalid input, try again");
                }
            }
        }
    }

    private void getDataFromUser(){
        vData = new VirusData();

        System.out.println("<welcome user>");
        System.out.println("Please input the simulation data. (type 'r 'to set random value instead)");
        mapSize = getInt("map size <integer> [0, 2147483647]: ", 1, 2147483647);
        stepLimit = getInt("step limit <integer>: [1,2147483647]: ", 1, 2147483647);
        humanCount = getInt("Population <integer> [1,2147483647]: ", 1, 2147483647);
        doctorCount = getInt("Number of Doctors <integer> [1,2147483647]: ", 1, 2147483647);
        vData.spreadChance = getInt("Virus's spread chance <integer> [0,100]: ", 0, 100);
        vData.spreadRange = getInt("Virus's spread range <integer> [0,5]: ", 0, 5);
        vData.mutationChance = getInt("Virus's mutation chance <integer> [0,100]: ", 0, 100);
        vData.lethality = getInt("Virus's lethality <integer> [0,100]: ", 0, 100);
        vData.resistanceToTreatment = getInt("Virus's resistance to treatment <integer> [0,100]: ", 0, 100);

    }
}
