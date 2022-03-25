package model.world;

import engine.Game;
import exceptions.UnrecognizedAbilityException;
import exceptions.UnrecognizedChampionTypeException;
import model.abilities.Ability;
import model.effects.Effect;

import java.awt.*;
import java.util.ArrayList;

public class Champion {
    private final String name;
    private final int maxHP;
    private final int attackRange;
    private int currentHP;
    private int mana;
    private int maxActionPointsPerTurn;
    private int currentActionPoints;
    private int attackDamage;
    private int speed;
    private ArrayList<Ability> abilities;
    private ArrayList<Effect> appliedEffects;
    private Condition condition;
    private Point location;

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

    public Champion(String name, int maxHP, int mana, int maxActions, int speed, int attackRange, int attackDamage) {
        this.name = name;
        this.maxHP = maxHP;
        this.mana = mana;
        this.maxActionPointsPerTurn = maxActions;
        this.attackRange = attackRange;
        this.attackDamage = attackDamage;
        this.speed = speed;
        this.abilities = new ArrayList<>();
        this.appliedEffects = new ArrayList<>();
    }

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

    public String getName() {
        return name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMaxActionPointsPerTurn() {
        return maxActionPointsPerTurn;
    }

    public void setMaxActionPointsPerTurn(int maxActionPointsPerTurn) {
        this.maxActionPointsPerTurn = maxActionPointsPerTurn;
    }

    public int getCurrentActionPoints() {
        return currentActionPoints;
    }

    public void setCurrentActionPoints(int currentActionPoints) {
        this.currentActionPoints = currentActionPoints;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public ArrayList<Effect> getAppliedEffects() {
        return appliedEffects;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
