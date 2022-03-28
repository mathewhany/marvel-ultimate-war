package engine.csv;

import engine.Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CsvLoader {
    /**
     * Loads abilities from a CSV file into the availableAbilities variable.
     *
     * @param filePath The path of the CSV file to load abilities from.
     */
    public static void loadAbilities(String filePath) throws Exception {
        ArrayList<String[]> fileRows = loadCsvFile(filePath);

        for (String[] row : fileRows) {
            Game.addAbility(AbilityFactory.fromCsvRow(row));
        }
    }

    /**
     * Loads champions from a CSV file into the availableChampion variable.
     *
     * @param filePath The absolute path of the CSV file to load champions from.
     */
    public static void loadChampions(String filePath) throws Exception {
        ArrayList<String[]> fileRows = loadCsvFile(filePath);

        for (String[] row : fileRows) {
            Game.addChampion(ChampionFactory.fromCsvRow(row));
        }
    }

    /**
     * Reads contents of CSV file and return them in as an ArrayList where every
     * line is split to an array of strings.
     *
     * Example:
     * Let's say you have a file "people.csv" containing:
     * Mathew,12345,Red
     * Rafeek,54321,Blue
     * Nariman,13242,Black
     *
     * Calling the method loadCsvFile("people.csv") returns an ArrayList containing 3 items:
     * {"Mathew", "12345", "Red"} at index 0,
     * {"Rafeek", "54321", "Blue"} at index 1,
     * {"Nariman", 13242", "Black"} at index 2
     */
    public static ArrayList<String[]> loadCsvFile(String path) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        ArrayList<String[]> lines = new ArrayList<>();

        while (true) {
            String line = reader.readLine();

            if (line == null) { // We have reached the end of the file, so stop the loop.
                break;
            } else {
                lines.add(line.split(","));
            }
        }

        return lines;
    }
}
