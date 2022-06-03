package model.abilities;

import model.world.Damageable;
import utils.Utils;

import java.util.ArrayList;

abstract public class Ability {
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

    abstract public void execute(ArrayList<Damageable> targets) throws CloneNotSupportedException;

    public boolean equals(Object o) {
        if (!(o instanceof Ability)) return false;

        if (this == o) return true;

        Ability otherAbility = (Ability) o;
        return name.equals(otherAbility.getName());
    }

    public String getType() {
        if (this instanceof DamagingAbility) {
            return "Damaging";
        } else if (this instanceof HealingAbility) {
            return "Healing";
        } else if (this instanceof CrowdControlAbility) {
            return "Crowd Control";
        }

        return "Unknown";
    }
}
