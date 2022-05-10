package model.effects;

import model.world.Champion;
import model.world.Condition;

public class Root extends Effect {
    public static final String EFFECT_NAME = "Root";

    public Root(int duration) {
        super(EFFECT_NAME, duration, EffectType.DEBUFF);
    }

    @Override
    public void apply(Champion c) {
        c.setCondition(Condition.ROOTED);
    }

    @Override
    public void remove(Champion c) {
        // TODO: Remove Root Effect
    }
}
