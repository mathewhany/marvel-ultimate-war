package model.effects;

import model.world.Champion;

public class Dodge extends Effect {
    public static final String EFFECT_NAME = "Dodge";

    public Dodge(int duration) {
        super(EFFECT_NAME, duration, EffectType.BUFF);
    }

    public void apply(Champion c) {
        // TODO: Target has a 50% chance of dodging normal attacks.
        c.setSpeed((int) (c.getSpeed() * 1.05));
    }

    public void remove(Champion c) {
        // TODO: Remove target has a 50% chance of dodging normal attacks.
        c.setSpeed((int) (c.getSpeed() / 1.05));
    }
}
