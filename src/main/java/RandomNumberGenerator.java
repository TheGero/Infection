import java.util.Random;

import static java.lang.Math.abs;

public class RandomNumberGenerator {
    /**
     * @param start
     * @param end
     * @return returns randomly generated int from given range
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
