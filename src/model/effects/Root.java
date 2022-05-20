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
        // Note: INACTIVE has a priority over ROOTED.
        // For example, if a champion is INACTIVE then
        // a Root effect is applied to him,
        // his condition will remain INACTIVE.
        if (c.getCondition() == Condition.ACTIVE) {
            c.setCondition(Condition.ROOTED);
        }
    }

    @Override
    public void remove(Champion c) {
        if (c.getCondition() == Condition.INACTIVE) return;

        if (c.hasEffect(Root.EFFECT_NAME)) return;

        c.setCondition(Condition.ACTIVE);
    }
}
