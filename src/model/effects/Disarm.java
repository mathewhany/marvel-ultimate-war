package model.effects;

import model.abilities.AreaOfEffect;
import model.abilities.DamagingAbility;
import model.world.Champion;

public class Disarm extends Effect {
    public static final String EFFECT_NAME = "Disarm";
    public static final DamagingAbility PUNCH = new DamagingAbility(
            "Punch",
            0,
            1,
            1,
            AreaOfEffect.SINGLETARGET,
            1,
            50
    );

    public Disarm(int duration) {
        super(EFFECT_NAME, duration, EffectType.DEBUFF);
    }

    public void apply(Champion c) {
        // TODO: Target cannot use normal attacks
        c.getAbilities().add(PUNCH);
    }

    public void remove(Champion c) {
        // TODO: Target can use normal attacks
        c.getAbilities().remove(PUNCH);
    }
}
