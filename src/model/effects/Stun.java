package model.effects;

public class Stun extends Effect {
    public Stun(String name, int duration) {
        super(name, duration, EffectType.BUFF);
    }
}
