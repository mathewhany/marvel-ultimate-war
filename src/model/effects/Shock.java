package model.effects;

public class Shock extends Effect {
    public Shock(String name, int duration) {
        super(name, duration, EffectType.DEBUFF);
    }
}
