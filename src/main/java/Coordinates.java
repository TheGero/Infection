/**
 * Coordinates stores X and Y coordinates of Human and Doctor objects.
 *
 * @author Kacper Leśniański , Patryk Płóciennik
 * @version 1.0
 */
public class Coordinates
{
    private int X;
    private int Y;

    /**
     * Set given values.
     *
     * @param X - X Coordinate.
     * @param Y - Y Coordinate.
     */
    public Coordinates(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    /**
     * Set default values.
     */
    public Coordinates() {
        this(0, 0);
    }

    /**
     * @return X Coordinate value.
     */
    public int getX() {
        return X;
    }

    /**
     * Sets X Coordinate value.
     *
     * @param X - X Coordinate.
     */
    public void setX(int X) {
        this.X = X;
    }

    /**
     * @return Y Coordinate value.
     */
    public int getY() {
        return Y;
    }

    /**
     * Sets Y Coordinate value.
     *
     * @param Y - Y Coordinate.
     */
    public void setY(int Y) {
        this.Y = Y;
    }
}