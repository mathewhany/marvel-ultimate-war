package model.effects;

import model.world.Champion;

public class Shock extends Effect {
    public static final String EFFECT_NAME = "Shock";

    public static final double LOST_SPEED = 0.1;
    public static final double LOST_ATTACK_DAMAGE = 0.1;
    public static final int LOST_MAX_ACTION_POINTS = 1;
    public static final int LOST_CURRENT_ACTION_POINTS = 1;

    public Shock(int duration) {
        super(EFFECT_NAME, duration, EffectType.DEBUFF);
    }

    public void apply(Champion c) {
        c.setSpeed((int) (c.getSpeed() * (1 - LOST_SPEED)));
        c.setAttackDamage((int) (c.getAttackDamage() * (1 - LOST_ATTACK_DAMAGE)));
        c.setMaxActionPointsPerTurn(c.getMaxActionPointsPerTurn() - LOST_MAX_ACTION_POINTS);
        c.setCurrentActionPoints(c.getCurrentActionPoints() - LOST_CURRENT_ACTION_POINTS);
    }

    public void remove(Champion c) {
        c.setSpeed((int) (c.getSpeed() / (1 - LOST_SPEED)));
        c.setAttackDamage((int) (c.getAttackDamage() / (1 - LOST_ATTACK_DAMAGE)));
        c.setMaxActionPointsPerTurn(c.getMaxActionPointsPerTurn() + LOST_MAX_ACTION_POINTS);
        c.setCurrentActionPoints(c.getCurrentActionPoints() + LOST_CURRENT_ACTION_POINTS);
    }
}
