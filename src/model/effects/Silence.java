package model.effects;

public class Silence extends Effect {
    public static final String EFFECT_NAME = "Silence";

    public Silence(int duration) {
        super(EFFECT_NAME, duration, EffectType.DEBUFF);
    }
}
