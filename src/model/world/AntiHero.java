package model.world;

import model.effects.Stun;

import java.util.ArrayList;

public class AntiHero extends Champion {
    public static final int STUN_DURATION = 2;

    public AntiHero(String name, int maxHP, int mana, int maxActions, int speed, int attackRange, int attackDamage) {
        super(name, maxHP, mana, maxActions, speed, attackRange, attackDamage);
    }

    public void useLeaderAbility(ArrayList<Champion> targets) {
        for (Champion target : targets) {
            target.addEffect(new Stun(STUN_DURATION));
        }
    }

    public boolean isExtraDamage(Champion target) {
        return !(target instanceof AntiHero);
    }
}
