package model.effects;

import model.world.Champion;

public class Shield extends Effect {
    public static final String EFFECT_NAME = "Shield";

    public static double GAIN_SPEED = 0.02;

    public Shield(int duration) {
        super(EFFECT_NAME, duration, EffectType.BUFF);
    }

    public void apply(Champion c) {
        c.setSpeed((int) (c.getSpeed() * (1 + GAIN_SPEED)));
    }

    public void remove(Champion c) {
        c.setSpeed((int) (c.getSpeed() / (1 + GAIN_SPEED)));
    }
}
