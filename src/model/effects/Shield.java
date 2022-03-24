package model.effects;

public class Shield extends Effect {
    public static final String EFFECT_NAME = "Shield";

    public Shield(int duration) {
        super(EFFECT_NAME, duration, EffectType.BUFF);
    }
}
