package model.effects;

import model.world.Champion;

public class Dodge extends Effect {
    public static final String EFFECT_NAME = "Dodge";
    private int gainedSpeed;

    public Dodge(int duration) {
        super(EFFECT_NAME, duration, EffectType.BUFF);
    }

    public void apply(Champion c) {
        super.apply(c);
        // TODO: Target has a 50% chance of dodging normal attacks.
        gainedSpeed = (int) (c.getSpeed() * 0.05);
        c.setSpeed(c.getSpeed() + gainedSpeed);
    }

    public void remove(Champion c) {
        super.apply(c);
        // TODO: Remove target has a 50% chance of dodging normal attacks.
        c.setSpeed(c.getSpeed() - gainedSpeed);
    }
}
