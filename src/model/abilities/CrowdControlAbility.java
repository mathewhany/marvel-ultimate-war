package model.abilities;

public class CrowdControlAbility extends Ability {
    private AreaOfEffect effect;

    public CrowdControlAbility(String name, int cost, int baseCoolDown, int castRange, AreaOfEffect area, int required, AreaOfEffect effect) {
        super(name, cost, baseCoolDown, castRange, area, required);
        this.effect = effect;
    }

    public AreaOfEffect getEffect() {
        return effect;
    }
}


	
	    	
	    	
	    	
	    	
	    	
	


