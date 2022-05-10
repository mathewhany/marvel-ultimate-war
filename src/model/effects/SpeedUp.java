package model.effects;

import model.world.Champion;

public class SpeedUp extends Effect {
    public static final String EFFECT_NAME = "SpeedUp";

    private int gainedSpeed;

    public SpeedUp(int duration) {
        super(EFFECT_NAME, duration, EffectType.BUFF);
    }

    public void apply(Champion c) {
        gainedSpeed = (int) (c.getSpeed() * 0.15);
        c.setSpeed(c.getSpeed() + gainedSpeed);

        c.setMaxActionPointsPerTurn(c.getMaxActionPointsPerTurn() + 1);
        c.setCurrentActionPoints(c.getCurrentActionPoints() + 1);
    }

    public void remove(Champion c) {
        c.setSpeed(c.getSpeed() - gainedSpeed);

        c.setMaxActionPointsPerTurn(c.getMaxActionPointsPerTurn() - 1);
        c.setCurrentActionPoints(c.getCurrentActionPoints() - 1);
    }
}
