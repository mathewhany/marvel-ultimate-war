package model.effects;

public class Shock extends Effect {
    public static final String EFFECT_NAME = "Shock";

    public Shock(int duration) {
        super(EFFECT_NAME, duration, EffectType.DEBUFF);
    }
}
