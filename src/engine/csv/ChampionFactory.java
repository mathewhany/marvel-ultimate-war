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
    private static final int CSV_TYPE = 0;
    private static final int CSV_NAME = 1;
    private static final int CSV_MAX_HP = 2;
    private static final int CSV_MANA = 3;
    private static final int CSV_MAX_ACTION_POINTS = 4;
    private static final int CSV_SPEED = 5;
    private static final int CSV_ATTACK_RANGE = 6;
    private static final int CSV_ATTACK_DAMAGE = 7;
    private static final int[] CSV_ABILITY_NAMES = {8, 9, 10};
    private static final String CSV_CHAMPION_TYPE_ANTIHERO = "A";
    private static final String CSV_CHAMPION_TYPE_HERO = "H";
    private static final String CSV_CHAMPION_TYPE_VILLAIN = "V";

    public static Champion fromCsvRow(String[] row) throws UnrecognizedChampionTypeException, UnrecognizedAbilityException {
        String type = row[CSV_TYPE];
        String name = row[CSV_NAME];
        int maxHP = Integer.parseInt(row[CSV_MAX_HP]);
        int mana = Integer.parseInt(row[CSV_MANA]);
        int maxActionPoints = Integer.parseInt(row[CSV_MAX_ACTION_POINTS]);
        int attackRange = Integer.parseInt(row[CSV_ATTACK_RANGE]);
        int attackDamage = Integer.parseInt(row[CSV_ATTACK_DAMAGE]);
        int speed = Integer.parseInt(row[CSV_SPEED]);

        Champion champion;

        switch (type) {
            case CSV_CHAMPION_TYPE_ANTIHERO:
                champion = new AntiHero(name, maxHP, mana, maxActionPoints, speed, attackRange, attackDamage);
                break;
            case CSV_CHAMPION_TYPE_HERO:
                champion = new Hero(name, maxHP, mana, maxActionPoints, speed, attackRange, attackDamage);
                break;
            case CSV_CHAMPION_TYPE_VILLAIN:
                champion = new Villain(name, maxHP, mana, maxActionPoints, speed, attackRange, attackDamage);
                break;
            default:
                throw new UnrecognizedChampionTypeException(type);
        }

        for (int i = 0; i < CSV_ABILITY_NAMES.length; i++) {
            String abilityName = row[CSV_ABILITY_NAMES[i]];
            Ability ability = Game.getAbilityByName(abilityName);

            if (ability == null) {
                throw new UnrecognizedAbilityException(abilityName);
            }

            champion.getAbilities().add(ability);
        }

        return champion;
    }
}
