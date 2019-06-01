import java.util.Random;

import static java.lang.Math.abs;

/**
 * Class used to generate random numbers.
 *
 * @author Kacper Lesnianski, Patryk Plociennik
 * @version 1.0
 */
public class RandomNumberGenerator {
    /**
     * Static method returning an Integer from given range.
     * @param start start of interval of valid values.
     * @param end end of interval of valid values.
     * @return randomly generated integer from given range.
     */
    public static int getIntegerFromRange(int start, int end) {

        if (start > end) throw new IllegalArgumentException();
        if (start == 0 && end == 0)
            return 0;

        Random random = new Random();
        int number;

        //nextInt returns a value between 0 and the specified value
        if (start < 0 && end < 0) {
            number = random.nextInt(abs(start) - abs(end));
        } else if (start < 0 && end > 0) {
            number = random.nextInt(abs(start) + end);
        } else {
            number = random.nextInt(end - start);
        }

        return start + number;
    }
}
