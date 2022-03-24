package model.effects;

public class SpeedUp extends Effect {
    public static final String EFFECT_NAME = "SpeedUp";

    public SpeedUp(int duration) {
        super(EFFECT_NAME, duration, EffectType.BUFF);
    }
}
