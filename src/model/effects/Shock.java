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
        c.setSpeed((int) (c.getSpeed() * 0.9));
        c.setAttackDamage((int) (c.getAttackDamage() * 0.9));
        c.setMaxActionPointsPerTurn(c.getMaxActionPointsPerTurn() - 1);
        c.setCurrentActionPoints(c.getCurrentActionPoints() - 1);
    }

    public void remove(Champion c) {
        c.setSpeed((int) (c.getSpeed() / 0.9));
        c.setAttackDamage((int) (c.getAttackDamage() / 0.9));
        c.setMaxActionPointsPerTurn(c.getMaxActionPointsPerTurn() + 1);
        c.setCurrentActionPoints(c.getCurrentActionPoints() + 1);
    }
}
