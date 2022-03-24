package model.effects;

public class PowerUp extends Effect {
    public static final String EFFECT_NAME = "PowerUp";

    public PowerUp(int duration) {
        super(EFFECT_NAME, duration, EffectType.BUFF);
    }
}
