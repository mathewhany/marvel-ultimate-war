package model.world;

import engine.Game;
import exceptions.UnrecognizedAbilityException;
import exceptions.UnrecognizedChampionTypeException;
import model.abilities.Ability;
import model.effects.Effect;

import java.awt.*;
import java.util.ArrayList;

public class Champion {
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

    public void setCurrentHP(int currentHP) {
        this.currentHP = Math.max(Math.min(currentHP, maxHP), 0);
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
        this.currentActionPoints = Math.min(currentActionPoints, maxActionPointsPerTurn);
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

//    public int compareTo(Object o) {
//        if (o instanceof Champion) {
//            Champion otherChampion = (Champion) o;
//            return this.speed - otherChampion.speed;
//        }
//
//        return 0;
//    }
}
