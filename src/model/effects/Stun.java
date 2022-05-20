package model.effects;

import model.world.Champion;
import model.world.Condition;

public class Stun extends Effect {
    public static final String EFFECT_NAME = "Stun";

    public Stun(int duration) {
        super(EFFECT_NAME, duration, EffectType.DEBUFF);
    }

    public void apply(Champion c) {
        if (c.getCondition() != Condition.KNOCKEDOUT) {
            c.setCondition(Condition.INACTIVE);
        }
    }

    public void remove(Champion c) {
        // Champion has another stun effect, so we don't remove the condition.
        if (c.hasEffect(Stun.EFFECT_NAME)) return;

        // Champion doesn't have a stun effect, but has a root effect,
        // so we remove the stun and apply root
        if (c.hasEffect(Root.EFFECT_NAME)) {
            c.setCondition(Condition.ROOTED);
            return;
        }

        /// Champion doesn't have neither stun or root effect, so we remove the condition.
        c.setCondition(Condition.ACTIVE);
    }
}
