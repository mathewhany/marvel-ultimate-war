package model.world;

import model.effects.Effect;
import model.effects.EffectType;
import model.effects.Embrace;

import java.util.ArrayList;

public class Hero extends Champion {
    public static final int EMBRACE_DURATION = 2;

    public Hero(String name, int maxHP, int mana, int maxActions, int speed, int attackRange, int attackDamage) {
        super(name, maxHP, mana, maxActions, speed, attackRange, attackDamage);
    }

    public void useLeaderAbility(ArrayList<Champion> targets) {
        for (Champion target : targets) {
            ArrayList<Effect> debuffs = new ArrayList<>();

            for (Effect effect : target.getAppliedEffects()) {
                if (effect.getType() == EffectType.DEBUFF) {
                    debuffs.add(effect);
                }
            }

            for (Effect effect : debuffs) {
                target.removeEffect(effect);
            }

            target.addEffect(new Embrace(EMBRACE_DURATION));
        }
    }

    public boolean isExtraDamage(Champion target) {
        return !(target instanceof Hero);
    }
}