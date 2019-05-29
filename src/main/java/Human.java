import java.util.List;

public class Human extends AbstractHuman {
    public Human(Map parentMap) {
        super(parentMap);
    }

    @Override
    public void update() {/*TODO:Implement*/}

    @Override
    public boolean isDoctor() {
        return false;
    }

    //returns true if found threat and ran away
    private boolean flee() {
        if (isInfected())
            return false;

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
                        move(dir, 2);
                    } else {
                        int dir = RandomNumberGenerator.getIntegerFromRange(0, 1);
                        //MOVE DOWN OR RIGHT
                        if (dir == 0) move(2, 2);
                        else move(4, 2);
                    }
                } else {
                    if (c.getX() >= 0) {
                        //MOVE UP OR LEFT
                        int dir = RandomNumberGenerator.getIntegerFromRange(0, 1);
                        if (dir == 0) move(1, 2);
                        else move(3, 2);
                    } else {
                        //MOVE UP OR RIGHT
                        int dir = RandomNumberGenerator.getIntegerFromRange(0, 1);
                        if (dir == 0) move(1, 2);
                        else move(4, 2);
                    }
                }

                return true;
            }
        }
        return false;
    }

}
