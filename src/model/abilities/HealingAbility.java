package model.abilities;

import model.world.Damageable;
import utils.Utils;

import java.util.ArrayList;

public class HealingAbility extends Ability {
    private int healAmount;

    public HealingAbility(String name, int cost, int baseCoolDown, int castRange, AreaOfEffect area, int required, int healAmount) {
        super(name, cost, baseCoolDown, castRange, area, required);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    public void execute(ArrayList<Damageable> targets) {
        for (Damageable target : targets) {
            target.setCurrentHP(target.getCurrentHP() + getHealAmount());
        }
    }
}
