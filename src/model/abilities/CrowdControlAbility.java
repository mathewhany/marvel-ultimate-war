package model.abilities;

import model.effects.Effect;
import model.world.Champion;
import model.world.Damageable;

import java.util.ArrayList;

public class CrowdControlAbility extends Ability {
    private Effect effect;

    public CrowdControlAbility(String name, int cost, int baseCoolDown, int castRange, AreaOfEffect area, int required, Effect effect) {
        super(name, cost, baseCoolDown, castRange, area, required);
        this.effect = effect;
    }

    public Effect getEffect() {
        return effect;
    }

    public void execute(ArrayList<Damageable> targets) throws CloneNotSupportedException {
        Effect clone = (Effect) effect.clone();

        for (Damageable target : targets) {
            clone.apply((Champion) target);
        }
    }
}


	
	    	
	    	
	    	
	    	
	    	
	


