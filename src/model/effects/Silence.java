package model.effects;

import model.world.Champion;

public class Silence extends Effect {
    public static final String EFFECT_NAME = "Silence";

    public Silence(int duration) {
        super(EFFECT_NAME, duration, EffectType.DEBUFF);
    }

    public void apply(Champion c) {
        // TODO: Target cannot use abilities
        c.setMaxActionPointsPerTurn(c.getMaxActionPointsPerTurn() + 2);
    }

    public void remove(Champion c) {
        c.setMaxActionPointsPerTurn(c.getMaxActionPointsPerTurn() - 2);
    }
}
