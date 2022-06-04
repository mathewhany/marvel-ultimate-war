package model.world;

import engine.Game;
import model.abilities.Ability;
import model.effects.*;
import utils.Utils;

import java.awt.*;
import java.util.ArrayList;

abstract public class Champion implements Damageable, Comparable {
    private int maxMana;
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

    private Listener listener;

    public Champion(String name, int maxHP, int mana, int maxActions, int speed, int attackRange, int attackDamage) {
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.maxMana = mana;
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
        int oldHp = this.currentHP;
        int newHp = Utils.boundBetween(currentHP, 0, maxHP);

        this.currentHP = newHp;

        if (newHp > oldHp) {
            listener.onHeal(this);
        } else if (newHp < oldHp) {
            listener.onDamage(this);
        }
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana > maxMana) {
            maxMana = mana;
        }

        int oldMana = this.mana;
        int newMana = Utils.aboveZero(mana);
        this.mana = Utils.aboveZero(mana);
        listener.onManaChange(this);
    }

    public int getMaxActionPointsPerTurn() {
        return maxActionPointsPerTurn;
    }

    public void setMaxActionPointsPerTurn(int maxActionPointsPerTurn) {
        this.maxActionPointsPerTurn = Utils.aboveZero(maxActionPointsPerTurn);
    }

    public int getCurrentActionPoints() {
        return currentActionPoints;
    }

    /**
     * Sets the current action points of the champion.
     * Note that the current action points can't be less than 0 or more than the max action points.
     */
    public void setCurrentActionPoints(int currentActionPoints) {
        int oldPoints = this.currentActionPoints;
        int newPoints = Utils.boundBetween(currentActionPoints, 0, maxActionPointsPerTurn);
        this.currentActionPoints = newPoints;
        listener.onActionPointsChange(this);

    }

    public int getAttackRange() {
        return attackRange;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = Utils.aboveZero(attackDamage);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = Utils.aboveZero(speed);
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

    abstract public boolean isExtraDamage(Champion target);

    public int compareTo(Object o) {
        if (!(o instanceof Champion)) {
            throw new IllegalArgumentException("Cannot compare Champion with non-Champion");
        }

        Champion other = (Champion) o;

        if (this.speed != other.speed) {
            return other.speed - this.speed;
        }

        return name.compareTo(other.name);
    }

    public Effect getEffect(String effectName) {
        for (Effect effect : appliedEffects) {
            if (effect.getName().equals(effectName)) {
                return effect;
            }
        }

        return null;
    }

    public boolean hasEffect(String effectName) {
        return getEffect(effectName) != null;
    }

    public void addAbility(Ability ability) {
        this.abilities.add(ability);
    }

    public void removeAbility(Ability ability) {
        this.abilities.remove(ability);
    }

    public void addEffect(Effect effect) {
        appliedEffects.add(effect);
        effect.apply(this);
        listener.onEffectApplied(this, effect);
    }

    public void removeEffect(Effect effect) {
        appliedEffects.remove(effect);
        effect.remove(this);
        listener.onEffectRemoved(this, effect);
    }

    public boolean isDodge() {
        return hasEffect(Dodge.EFFECT_NAME) && Utils.getRandomBoolean();
    }

    public boolean isDisarmed() {
        return hasEffect(Disarm.EFFECT_NAME);
    }

    public boolean hasShield() {
        return hasEffect(Shield.EFFECT_NAME);
    }

    public void removeShield() {
        removeEffect(getEffect(Shield.EFFECT_NAME));
    }

    public void decreaseEffectsDuration() {
        for (Effect effect : appliedEffects) {
            effect.setDuration(effect.getDuration() - 1);
        }
    }

    public void removeExpiredEffects() {
        ArrayList<Effect> effectsToBeRemoved = new ArrayList<>();

        for (Effect effect : appliedEffects) {
            if (effect.getDuration() == 0) {
                effectsToBeRemoved.add(effect);
            }
        }

        for (Effect effect : effectsToBeRemoved) {
            removeEffect(effect);
        }
    }

    public void decreaseAbilitiesCooldown() {
        for (Ability ability : abilities) {
            ability.setCurrentCooldown(ability.getCurrentCooldown() - 1);
        }
    }

    public void resetActionPoints() {
        setCurrentActionPoints(getMaxActionPointsPerTurn());
    }

    public void setListener(Champion.Listener listener) {
        this.listener = listener;
    }

    @Override
    public double getHpPercent() {
        return currentHP * 1.0 / maxHP;
    }

    public double getActionPointsPercent() {
        return currentActionPoints * 1.0 / maxActionPointsPerTurn;
    }

    public double getManaPercent() {
        return mana * 1.0 / maxMana;
    }

    public int getMaxMana() {
        return this.maxMana;
    }

    public String getType() {
        if (this instanceof Hero) {
            return "Hero";
        } else if (this instanceof Villain) {
            return "Villain";
        } else if (this instanceof AntiHero) {
            return "Anti-Hero";
        }

        return "Unknown";
    }

    public interface Listener {
        void onChampionChange(Champion champion);
        void onDamage(Champion champion);
        void onHeal(Champion champion);
        void onManaChange(Champion champion);
        void onActionPointsChange(Champion champion);
        void onEffectApplied(Champion champion, Effect effect);
        void onEffectRemoved(Champion champion, Effect effect);
    }
}
