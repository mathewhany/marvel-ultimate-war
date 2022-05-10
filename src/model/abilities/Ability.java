package model.abilities;

import exceptions.UnrecognizedAbilityTypeException;
import exceptions.UnrecognizedEffectException;
import model.effects.Effect;
import utils.Utils;

public class Ability {
    private String name;
    private int manaCost;
    private int baseCooldown;
    private int castRange;
    private int requiredActionPoints;
    private AreaOfEffect castArea;
    private int currentCooldown;

    public Ability(String name, int cost, int baseCoolDown, int castRange, AreaOfEffect area, int required) {
        this.name = name;
        this.manaCost = cost;
        this.baseCooldown = baseCoolDown;
        this.castRange = castRange;
        this.castArea = area;
        this.requiredActionPoints = required;
    }

    public String getName() {
        return name;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getBaseCooldown() {
        return baseCooldown;
    }

    public int getCurrentCooldown() {
        return currentCooldown;
    }

    public void setCurrentCooldown(int currentCooldown) {
        this.currentCooldown = Utils.boundBetween(currentCooldown, 0, baseCooldown);
    }

    public int getCastRange() {
        return castRange;
    }

    public int getRequiredActionPoints() {
        return requiredActionPoints;
    }

    public AreaOfEffect getCastArea() {
        return castArea;
    }
}
