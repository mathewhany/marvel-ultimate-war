package model.effects;

import model.abilities.Ability;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.world.Champion;

public class PowerUp extends Effect {
    public static final String EFFECT_NAME = "PowerUp";

    public static double GAIN_HEAL_AMOUNT = 0.2;
    public static double GAIN_DAMAGE_AMOUNT = 0.2;

    public PowerUp(int duration) {
        super(EFFECT_NAME, duration, EffectType.BUFF);
    }

    public void apply(Champion c) {
        for (Ability ability : c.getAbilities()) {
            if (ability instanceof DamagingAbility) {
                DamagingAbility damagingAbility = (DamagingAbility) ability;

                int damage = damagingAbility.getDamageAmount();
                int newDamage = (int) (damage * (1 + GAIN_DAMAGE_AMOUNT));

                damagingAbility.setDamageAmount(newDamage);
            } else if (ability instanceof HealingAbility) {
                HealingAbility healingAbility = (HealingAbility) ability;

                int heal = healingAbility.getHealAmount();
                int newHeal = (int) (heal * (1 + GAIN_HEAL_AMOUNT));

                healingAbility.setHealAmount(newHeal);
            }
        }
    }

    public void remove(Champion c) {
        for (Ability ability : c.getAbilities()) {
            if (ability instanceof DamagingAbility) {
                DamagingAbility damagingAbility = (DamagingAbility) ability;

                int damage = damagingAbility.getDamageAmount();
                int newDamage = (int) (damage / (1 + GAIN_DAMAGE_AMOUNT));

                damagingAbility.setDamageAmount(newDamage);
            } else if (ability instanceof HealingAbility) {
                HealingAbility healingAbility = (HealingAbility) ability;

                int heal = healingAbility.getHealAmount();
                int newHeal = (int) (heal / (1 + GAIN_HEAL_AMOUNT));

                healingAbility.setHealAmount(newHeal);
            }
        }
    }
}
