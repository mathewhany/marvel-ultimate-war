package model.effects;

import model.world.Champion;

public class Shield extends Effect {
    public static final String EFFECT_NAME = "Shield";

    private int gainedSpeed;

    public Shield(int duration) {
        super(EFFECT_NAME, duration, EffectType.BUFF);
    }

    public void apply(Champion c) {
        // TODO: Block the next attack or damaging ability cast on target.
        // TODO: Once an attack or ability is blocked, the effect should be removed.
        gainedSpeed = (int) (c.getSpeed() * 0.02);
        c.setSpeed(c.getSpeed() + gainedSpeed);
    }

    public void remove(Champion c) {
        c.setSpeed(c.getSpeed() - gainedSpeed);
    }
}
