package engine.csv;

import engine.Game;
import exceptions.UnrecognizedAbilityException;
import exceptions.UnrecognizedChampionTypeException;
import model.abilities.Ability;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Hero;
import model.world.Villain;

public class ChampionFactory {
    /**
     * The column numbers where each value is located in the CSV file.
     *
     * Example:
     * CSV_NAME = 1 => the name of the champion is located at the column indexed 1.
     * CSV_SPEED = 5 => the speed of the champion is located at the column indexed 5.
     */
    private static final int CSV_TYPE = 0;
    private static final int CSV_NAME = 1;
    private static final int CSV_MAX_HP = 2;
    private static final int CSV_MANA = 3;
    private static final int CSV_MAX_ACTION_POINTS = 4;
    private static final int CSV_SPEED = 5;
    private static final int CSV_ATTACK_RANGE = 6;
    private static final int CSV_ATTACK_DAMAGE = 7;
    private static final int[] CSV_ABILITY_NAMES = {8, 9, 10}; // Each champion has 3 abilities whose names are located at columns 8, 9, 10

    /**
     * The abbreviations used in the CSV file to indicate the type of champion.
     */
    private static final String CSV_CHAMPION_TYPE_ANTIHERO = "A";
    private static final String CSV_CHAMPION_TYPE_HERO = "H";
    private static final String CSV_CHAMPION_TYPE_VILLAIN = "V";

    /**
     * Takes an array of strings and uses them to construct a Champion object.
     *
     * Example:
     * Input: {"H", "Dr Strange", "0", "6", "15", "34", "40", "16", "The eye of agamotto", "Thousand Hand", "Mirror Dimension"}
     * Output: new Hero("Dr Strange", 0, 6, 15, 34, 40, 16)
     */
    public static Champion fromCsvRow(String[] row) throws UnrecognizedChampionTypeException, UnrecognizedAbilityException {
        String type = row[CSV_TYPE];
        String name = row[CSV_NAME];

        // These should be integers, so convert them from strings to integers.
        int maxHP = Integer.parseInt(row[CSV_MAX_HP]);
        int mana = Integer.parseInt(row[CSV_MANA]);
        int maxActionPoints = Integer.parseInt(row[CSV_MAX_ACTION_POINTS]);
        int attackRange = Integer.parseInt(row[CSV_ATTACK_RANGE]);
        int attackDamage = Integer.parseInt(row[CSV_ATTACK_DAMAGE]);
        int speed = Integer.parseInt(row[CSV_SPEED]);


        Champion champion;

        switch (type) {
            case CSV_CHAMPION_TYPE_ANTIHERO:
                champion = new AntiHero(
                        name,
                        maxHP,
                        mana,
                        maxActionPoints,
                        speed,
                        attackRange,
                        attackDamage
                );
                break;

            case CSV_CHAMPION_TYPE_HERO:
                champion = new Hero(
                        name,
                        maxHP,
                        mana,
                        maxActionPoints,
                        speed,
                        attackRange,
                        attackDamage
                );
                break;

            case CSV_CHAMPION_TYPE_VILLAIN:
                champion = new Villain(
                        name,
                        maxHP,
                        mana,
                        maxActionPoints,
                        speed,
                        attackRange,
                        attackDamage
                );
                break;


            // In case the champion type is not one of the above, then it is an invalid type.
            default:
                throw new UnrecognizedChampionTypeException(type);
        }


        // Search for the abilities names and add the the abilities objects
        // to the champion's list of abilities.
        for (int abilityNameColumn : CSV_ABILITY_NAMES) {
            String abilityName = row[abilityNameColumn];
            Ability ability = Game.getAbilityByName(abilityName);

            if (ability == null) { // The ability was not found
                throw new UnrecognizedAbilityException(abilityName);
            }

            champion.getAbilities().add(ability);
        }

        return champion;
    }
}
