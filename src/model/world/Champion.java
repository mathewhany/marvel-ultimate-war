package model.world;

import model.abilities.Ability;
import model.effects.Effect;
import utils.Utils;

import java.awt.*;
import java.util.ArrayList;

abstract public class Champion implements Damageable, Comparable {
    private String name;
    private int maxHP;
    private int attackRange;
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

    public Champion(String name, int maxHP, int mana, int maxActions, int speed, int attackRange, int attackDamage) {
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.mana = mana;
        this.maxActionPointsPerTurn = maxActions;
        this.currentActionPoints = maxActions;
        this.attackRange = attackRange;
        this.attackDamage = attackDamage;
        this.speed = speed;
        this.abilities = new ArrayList<>();
        this.appliedEffects = new ArrayList<>();
        this.condition = Condition.ACTIVE;
    }

    public ArrayList<Ability> getAbilities() {
        return abilities;
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

    /**
     * Sets the current HP of the champion.
     * Note that the current HP can't be less than 0 or more than the max HP.
     */
    public void setCurrentHP(int currentHP) {
        this.currentHP = Utils.boundBetween(currentHP, 0, maxHP);
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

    /**
     * Sets the current action points of the champion.
     * Note that the current action points can't be less than 0 or more than the max action points.
     */
    public void setCurrentActionPoints(int currentActionPoints) {
        this.currentActionPoints = Utils.boundBetween(currentActionPoints, 0, maxActionPointsPerTurn);
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

    abstract public void useLeaderAbility(ArrayList<Champion> targets);

    public int compareTo(Object o) {
        if (o instanceof Champion) {
            Champion otherChampion = (Champion) o;

            if (this.speed == otherChampion.speed) {
                return name.compareTo(otherChampion.name);
            }

            return otherChampion.speed - this.speed;
        }

        return 0;
    }
}
