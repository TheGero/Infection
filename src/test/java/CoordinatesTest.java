import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoordinatesTest {

    @Test
    public void test() {
        Coordinates c = new Coordinates(2, 1);
        assertEquals(2, c.getX());
        assertEquals(1, c.getY());
        Coordinates c2 = new Coordinates();
        assertEquals(0, c2.getX());
        assertEquals(0, c2.getY());
        c2.setX(3);
        c2.setY(7);
        assertEquals(3, c2.getX());
        assertEquals(7, c2.getY());
    }
}