package engine.csv;

import model.abilities.Ability;
import model.world.Champion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CsvLoader {
    /**
     * Loads abilities from a CSV file into an ArrayList.
     *
     * @param filePath The path of the CSV file to load abilities from.
     */
    public static ArrayList<Ability> loadAbilities(String filePath) throws Exception {
        ArrayList<String[]> fileRows = loadCsvFile(filePath);
        ArrayList<Ability> abilities = new ArrayList<>();

        for (String[] row : fileRows) {
            Ability ability = AbilityFactory.fromCsvRow(row);

            // If something wrong happened while parsing a CSV row the ability will be null.
            if (ability != null) {
                abilities.add(ability);
            }
        }

        return abilities;
    }

    /**
     * Loads champions from a CSV file into a ArrayList.
     *
     * @param filePath The absolute path of the CSV file to load champions from.
     * @param availableAbilities The list of available abilities that a champion can choose from.
     */
    public static ArrayList<Champion> loadChampions(String filePath, ArrayList<Ability> availableAbilities) throws Exception {
        ArrayList<String[]> fileRows = loadCsvFile(filePath);
        ArrayList<Champion> champions = new ArrayList<>();

        for (String[] row : fileRows) {
            Champion champion = ChampionFactory.fromCsvRow(row, availableAbilities);

            // If something wrong happened while parsing the CSV row, the champion will be null.
            if (champion != null) {
                champions.add(champion);
            }
        }

        return champions;
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(CsvLoader.class.getResourceAsStream(path)));
        ArrayList<String[]> lines = new ArrayList<>();

        while (true) {
            String line = reader.readLine();

            if (line == null) { // We have reached the end of the file, so stop the loop.
                break;
            } else {
                lines.add(line.split(","));
            }
        }

        // Closing the file after reading it.
        reader.close();

        return lines;
    }
}
