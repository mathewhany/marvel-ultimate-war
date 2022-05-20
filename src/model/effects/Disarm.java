package model.effects;

import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.DamagingAbility;
import model.world.Champion;

public class Disarm extends Effect {
    public static final String EFFECT_NAME = "Disarm";

    public final Ability PUNCH = new DamagingAbility(
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
        c.addAbility(PUNCH);
    }

    public void remove(Champion c) {
        c.removeAbility(PUNCH);
    }
}
