package model.effects;

import model.abilities.Ability;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.world.Champion;

import java.util.HashMap;

public class PowerUp extends Effect {
    public static final String EFFECT_NAME = "PowerUp";

    public PowerUp(int duration) {
        super(EFFECT_NAME, duration, EffectType.BUFF);
    }

    public void apply(Champion c) {
        // TODO: Apply PowerUp
        for (Ability ability : c.getAbilities()) {
            if (ability instanceof DamagingAbility) {
                DamagingAbility damagingAbility = (DamagingAbility) ability;
                int damage = damagingAbility.getDamageAmount();
                int gainedDamage = (int) (damage * 0.2);
                damagingAbility.setDamageAmount(damage + gainedDamage);
            } else if (ability instanceof HealingAbility) {
                HealingAbility healingAbility = (HealingAbility) ability;
                int heal = healingAbility.getHealAmount();
                int gainedHeal = (int) (heal * 0.2);
                healingAbility.setHealAmount(heal + gainedHeal);
            }
        }
    }

    public void remove(Champion c) {
        for (Ability ability : c.getAbilities()) {
            if (ability instanceof DamagingAbility) {
                DamagingAbility damagingAbility = (DamagingAbility) ability;
                int damage = damagingAbility.getDamageAmount();
                damagingAbility.setDamageAmount((int) (damage / 1.2));
            } else {
                HealingAbility healingAbility = (HealingAbility) ability;
                int heal = healingAbility.getHealAmount();
                healingAbility.setHealAmount((int) (heal / 1.2));
            }
        }
    }
}
