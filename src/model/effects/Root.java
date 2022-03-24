package model.effects;

public class Root extends Effect {
    public static final String EFFECT_NAME = "Root";

    public Root(int duration) {
        super(EFFECT_NAME, duration, EffectType.DEBUFF);
    }
}
