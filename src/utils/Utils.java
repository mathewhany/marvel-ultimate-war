package utils;

public class Utils {
    /**
     * Gets a random number between start inclusive and end exclusive.
     */
    public static int randomNumber(int start, int end) {
        int width = end - start;

        return start + (int) (Math.random() * width);
    }

    /**
     * Makes sure the given `value` is between the `min` and `max`,
     * if its bigger than `max` or smaller than `min`, then it returns
     * the `max` or the `min` respectively.
     *
     * For example:
     * - boundBetween(500, 0, 1000) returns 500 because 500 is between 0 and 1000
     * - boundBetween(1500, 0, 1000) returns 1000 because 1500 is bigger than 1000
     * - boundBetween(-10, 0, 1000) returns 0 because -10 is smaller than 0
     */
    public static int boundBetween(int value, int min, int max) {
        if (value > max) {
            return max;
        } else if (value < min) {
            return min;
        } else {
            return value;
        }
    }

//    public static String getRootDirectory() {
//        return new File("").getAbsolutePath();
//    }
}
