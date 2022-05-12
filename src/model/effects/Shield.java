package model.effects;

import model.world.Champion;

public class Shield extends Effect {
    public static final String EFFECT_NAME = "Shield";

    public Shield(int duration) {
        super(EFFECT_NAME, duration, EffectType.BUFF);
    }

    public void apply(Champion c) {
        // TODO: Block the next attack or damaging ability cast on target.
        // TODO: Once an attack or ability is blocked, the effect should be removed.
        c.setSpeed((int) (c.getSpeed() * 1.02));
    }

    public void remove(Champion c) {
        c.setSpeed((int) (c.getSpeed() / 1.02));
    }
}
