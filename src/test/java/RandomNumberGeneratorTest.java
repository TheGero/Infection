import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
* Tests of class RandomNumberGenerator
*
* @author Kacper Lesnianski, Patryk Plociennik
* @version 1.0
*/
class RandomNumberGeneratorTest {

    private int number;

    @Test
    /**
     * Test if values returned by RNG are from the specified interval.
     */
    public void valueFromRangeTest() {
        for (int i = 0; i < 20000; i++) {
            number = RandomNumberGenerator.getIntegerFromRange(0, 10);
            assertTrue(number >= 0 && number <= 10);
            number = RandomNumberGenerator.getIntegerFromRange(-10, 10);
            assertTrue(number >= -10 && number <= 10);
            number = RandomNumberGenerator.getIntegerFromRange(5, 10);
            assertTrue(number >= 5 && number <= 10);
            number = RandomNumberGenerator.getIntegerFromRange(0, 0);
            assertEquals(0, number);
        }
    }

    @Test
    /**
     * Make sure that RNG throws an exception
     *  if start of the interval is bigger than the end of the interval.
     */
    public void endBiggerThanStartFailureTest() {
        assertThrows(IllegalArgumentException.class, () -> RandomNumberGenerator.getIntegerFromRange(5, -5));
        assertThrows(IllegalArgumentException.class, () -> RandomNumberGenerator.getIntegerFromRange(-4, -5));
        assertThrows(IllegalArgumentException.class, () -> RandomNumberGenerator.getIntegerFromRange(3, 1));
        assertThrows(IllegalArgumentException.class, () -> RandomNumberGenerator.getIntegerFromRange(3, 0));
    }
}