package model.effects;

import model.world.Champion;

public class Dodge extends Effect {
    public static final String EFFECT_NAME = "Dodge";
    public static final double GAIN_SPEED = 0.05;

    public Dodge(int duration) {
        super(EFFECT_NAME, duration, EffectType.BUFF);
    }

    public void apply(Champion c) {
        c.setSpeed((int) (c.getSpeed() * (1 + GAIN_SPEED)));
    }

    public void remove(Champion c) {
        c.setSpeed((int) (c.getSpeed() / (1 + GAIN_SPEED)));
    }
}
