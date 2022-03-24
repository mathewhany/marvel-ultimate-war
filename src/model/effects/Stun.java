package model.effects;

public class Stun extends Effect {
    public static final String EFFECT_NAME = "Stun";

    public Stun(int duration) {
        super(EFFECT_NAME, duration, EffectType.BUFF);
    }
}
