package model.effects;

import model.world.Champion;

public class SpeedUp extends Effect {
    public static final String EFFECT_NAME = "SpeedUp";

    public static final double GAIN_SPEED = 0.15;
    public static final int GAIN_MAX_ACTION_POINTS = 1;
    public static final int GAIN_CURRENT_ACTION_POINTS = 1;



    public SpeedUp(int duration) {
        super(EFFECT_NAME, duration, EffectType.BUFF);
    }

    public void apply(Champion c) {
        c.setSpeed((int) (c.getSpeed() * (1 + GAIN_SPEED)));

        c.setMaxActionPointsPerTurn(c.getMaxActionPointsPerTurn() + GAIN_MAX_ACTION_POINTS);
        c.setCurrentActionPoints(c.getCurrentActionPoints() + GAIN_CURRENT_ACTION_POINTS);
    }

    public void remove(Champion c) {
        c.setSpeed((int) (c.getSpeed() / (1 + GAIN_SPEED)));

        c.setCurrentActionPoints(c.getCurrentActionPoints() - GAIN_CURRENT_ACTION_POINTS);
        c.setMaxActionPointsPerTurn(c.getMaxActionPointsPerTurn() - GAIN_MAX_ACTION_POINTS);
    }
}
