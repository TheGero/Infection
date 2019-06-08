import java.util.List;
/**
 * Class representing a regular Human.
 * @author Kacper Lesnianski, Patryk Plociennik
 * @version 1.0
 */
public class Human extends AbstractHuman {
    /**
     * Constructor (calls AbstractHuman constructor).
     * @param parentMap Reference to Map storing Human.
     */
    public Human(Map parentMap) {
        super(parentMap);
    }

    /**
     * Method called on each step of the simulation.
     * Controls all actions of the Human: fleeing or moving randomly.
     * If Human is infected, updates Virus.
     */
    @Override
    public void update()
    {
        if (!isAlive()) return;
        if(!flee())
            move();
        if (isInfected())
            getVirus().update();

    }

    /**
     * This method is required to discriminate between a Doctor and a Human without using instanceof().
     * (Used in class Map).
     * @return true if is a Doctor.
     */
    @Override
    public boolean isDoctor() {
        return false;
    }

    /**
     * Check if there are any infected with visible symptoms nearby
     * and try to get away from them.
     * @return true if spotted an infected Human and ran away.
     */
    private boolean flee() {
        if (isInfected())
            return false;

        int move_speed = 5;

        List<IHuman> humansInRange = getParentMap().getHumansInRange(getCoordinates(), 2);
        for (IHuman h : humansInRange) {
            if (h != this && h.hasVisibleSymptoms()) {
                //Determine direction
                Coordinates c
                        = new Coordinates(h.getCoordinates().getX() - getCoordinates().getX(),
                        h.getCoordinates().getY() - getCoordinates().getY());
                
                if (c.getY() >= 0) {
                    if (c.getX() >= 0) {
                        //MOVE DOWN OR LEFT
                        int dir = RandomNumberGenerator.getIntegerFromRange(2, 3);
                        move(dir, move_speed);
                    } else {
                        int dir = RandomNumberGenerator.getIntegerFromRange(0, 1);
                        //MOVE DOWN OR RIGHT
                        if (dir == 0) move(2, move_speed);
                        else move(4, move_speed);
                    }
                } else {
                    if (c.getX() >= 0) {
                        //MOVE UP OR LEFT
                        int dir = RandomNumberGenerator.getIntegerFromRange(0, 1);
                        if (dir == 0) move(1, move_speed);
                        else move(3, move_speed);
                    } else {
                        //MOVE UP OR RIGHT
                        int dir = RandomNumberGenerator.getIntegerFromRange(0, 1);
                        if (dir == 0) move(1, move_speed);
                        else move(4, move_speed);
                    }
                }

                return true;
            }
        }
        return false;
    }

}
