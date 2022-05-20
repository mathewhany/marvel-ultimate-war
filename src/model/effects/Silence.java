package model.effects;

import model.world.Champion;

public class Silence extends Effect {
    public static final String EFFECT_NAME = "Silence";

    public static final int GAIN_MAX_ACTION_POINTS = 2;
    public static final int GAIN_CURRENT_ACTION_POINTS = 2;

    public Silence(int duration) {
        super(EFFECT_NAME, duration, EffectType.DEBUFF);
    }

    public void apply(Champion c) {
        c.setMaxActionPointsPerTurn(c.getMaxActionPointsPerTurn() + GAIN_MAX_ACTION_POINTS);
        c.setCurrentActionPoints(c.getCurrentActionPoints() + GAIN_CURRENT_ACTION_POINTS);
    }

    public void remove(Champion c) {
        c.setMaxActionPointsPerTurn(c.getMaxActionPointsPerTurn() - GAIN_MAX_ACTION_POINTS);
        c.setCurrentActionPoints(c.getCurrentActionPoints() - GAIN_CURRENT_ACTION_POINTS);
    }
}
