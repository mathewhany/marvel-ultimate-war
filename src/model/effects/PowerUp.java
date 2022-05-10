package model.effects;

import model.world.Champion;

public class PowerUp extends Effect {
    public static final String EFFECT_NAME = "PowerUp";

    public PowerUp(int duration) {
        super(EFFECT_NAME, duration, EffectType.BUFF);
    }

    public void apply(Champion c) {
        super.apply(c);
        // TODO: Apply PowerUp
    }

    public void remove(Champion c) {
        super.apply(c);
        // TODO: Remove PowerUp
    }
}
