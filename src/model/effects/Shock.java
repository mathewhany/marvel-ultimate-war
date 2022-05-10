package model.effects;

import model.world.Champion;

public class Shock extends Effect {
    public static final String EFFECT_NAME = "Shock";

    public int gainedSpeed;
    public int gainedDamage;

    public Shock(int duration) {
        super(EFFECT_NAME, duration, EffectType.DEBUFF);
    }

    public void apply(Champion c) {
        // I called it gainedSpeed even though it should decrease
        // the speed, because in all other effects I called it gainedSpeed,
        // so to be consistent I will also call it gainedSpeed here.
        gainedSpeed = - (int) (c.getSpeed() * 0.1);
        gainedDamage = - (int) (c.getAttackDamage() * 0.1);

        c.setSpeed(c.getSpeed() + gainedSpeed);
        c.setAttackDamage(c.getAttackDamage() + gainedDamage);
        c.setMaxActionPointsPerTurn(c.getMaxActionPointsPerTurn() - 1);
        c.setCurrentActionPoints(c.getCurrentActionPoints() - 1);
    }

    public void remove(Champion c) {
        c.setSpeed(c.getSpeed() - gainedSpeed);
        c.setAttackDamage(c.getAttackDamage() - gainedDamage);
        c.setMaxActionPointsPerTurn(c.getMaxActionPointsPerTurn() + 1);
        c.setCurrentActionPoints(c.getCurrentActionPoints() + 1);
    }
}
