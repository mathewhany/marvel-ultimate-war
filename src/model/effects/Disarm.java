package model.effects;

import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.DamagingAbility;
import model.world.Champion;

public class Disarm extends Effect {
    public static final String EFFECT_NAME = "Disarm";

    public Disarm(int duration) {
        super(EFFECT_NAME, duration, EffectType.DEBUFF);
    }

    public void apply(Champion c) {
        super.apply(c);
        // TODO: Target cannot use normal attacks
        c.getAbilities().add(new DamagingAbility(
                "Punch",
                0,
                1,
                1,
                AreaOfEffect.SINGLETARGET,
                1,
                50
        ));
    }

    public void remove(Champion c) {
        super.apply(c);
        // TODO: Target can use normal attacks
        for (int i = 0; i < c.getAbilities().size(); i++) {
            if (c.getAbilities().get(i).getName().equals("Punch")) {
                c.getAbilities().remove(i);
            }
        }
    }
}
