package model.effects;

public class Disarm extends Effect {
    public static final String EFFECT_NAME = "Disarm";

    public Disarm(int duration) {
        super(EFFECT_NAME, duration, EffectType.DEBUFF);
    }
}
