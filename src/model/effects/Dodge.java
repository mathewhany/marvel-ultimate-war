package model.effects;

public class Dodge extends Effect {
    public static final String EFFECT_NAME = "Dodge";

    public Dodge(int duration) {
        super(EFFECT_NAME, duration, EffectType.BUFF);
    }
}
