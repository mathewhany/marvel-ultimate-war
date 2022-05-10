package model.effects;

import model.world.Champion;
import model.world.Condition;

public class Stun extends Effect {
    public static final String EFFECT_NAME = "Stun";

    private Condition previousCondition;

    public Stun(int duration) {
        super(EFFECT_NAME, duration, EffectType.DEBUFF);
    }

    public void apply(Champion c) {
        previousCondition = c.getCondition();
        c.setCondition(Condition.INACTIVE);

        // TODO: Target is not allowed to play their turn for the duration.
    }

    public void remove(Champion c) {
        if (previousCondition != null) {
            c.setCondition(previousCondition);
        }
    }
}
