package model.effects;

import model.world.Champion;

public class SpeedUp extends Effect {
    public static final String EFFECT_NAME = "SpeedUp";

    public SpeedUp(int duration) {
        super(EFFECT_NAME, duration, EffectType.BUFF);
    }

    public void apply(Champion c) {
        c.setSpeed((int) (c.getSpeed() * 1.15));

        c.setMaxActionPointsPerTurn(c.getMaxActionPointsPerTurn() + 1);
        c.setCurrentActionPoints(c.getCurrentActionPoints() + 1);
    }

    public void remove(Champion c) {
        c.setSpeed((int) (c.getSpeed() / 1.15));

        c.setMaxActionPointsPerTurn(c.getMaxActionPointsPerTurn() - 1);
        c.setCurrentActionPoints(c.getCurrentActionPoints() - 1);
    }
}
