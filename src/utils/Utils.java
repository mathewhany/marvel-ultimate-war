package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Utils {
    /**
     * Gets a random number between start inclusive and end exclusive.
     */
    public static int randomNumber(int start, int end) {
        int width = end - start;

        return start + (int) (Math.random() * width);
    }

    /**
     * Reads contents of CSV file and return them in as an ArrayList
     * where every line is split to an array of strings.
     */
    public static ArrayList<String[]> loadCsvFile(String path) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        ArrayList<String[]> lines = new ArrayList<>();

        while (true) {
            String line = reader.readLine();

            if (line == null) {
                break;
            } else {
                lines.add(line.split(","));
            }
        }

        return lines;
    }

    public static String getRootDirectory() {
        return new File("").getAbsolutePath();
    }
}
