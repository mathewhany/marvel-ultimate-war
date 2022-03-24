package model.effects;

public class Embrace extends Effect {
    public static final String EFFECT_NAME = "Embrace";

    public Embrace(int duration) {
        super(EFFECT_NAME, duration, EffectType.BUFF);
    }
}
