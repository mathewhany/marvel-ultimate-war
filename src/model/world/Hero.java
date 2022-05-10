package model.world;

import model.effects.Effect;
import model.effects.EffectType;
import model.effects.Embrace;

import java.util.ArrayList;

public class Hero extends Champion {
    public Hero(String name, int maxHP, int mana, int maxActions, int speed, int attackRange, int attackDamage) {
        super(name, maxHP, mana, maxActions, speed, attackRange, attackDamage);
    }

    public void useLeaderAbility(ArrayList<Champion> targets) {
        for (Champion target : targets) {
            for (Effect effect : target.getAppliedEffects()) {
                if (effect.getType() == EffectType.DEBUFF) {
                    effect.remove(target);
                    target.getAppliedEffects().remove(effect);
                }
            }
            Embrace embrace = new Embrace(2);
            embrace.apply(target);
        }
    }
}