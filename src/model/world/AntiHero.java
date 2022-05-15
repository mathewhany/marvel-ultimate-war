package model.world;

import model.effects.Stun;

import java.util.ArrayList;

public class AntiHero extends Champion {
    public AntiHero(String name, int maxHP, int mana, int maxActions, int speed, int attackRange, int attackDamage) {
        super(name, maxHP, mana, maxActions, speed, attackRange, attackDamage);
    }

    public void useLeaderAbility(ArrayList<Champion> targets) {
        for (Champion target : targets) {
            Stun stun = new Stun(2);
            stun.apply(target);
            target.getAppliedEffects().add(stun);
        }
    }
}