package utils;

public class Utils {
    /**
     * Gets a random number between start inclusive and end exclusive.
     */
    public static int randomNumber(int start, int end) {
        int width = end - start;

        return start + (int) (Math.random() * width);
    }
}
