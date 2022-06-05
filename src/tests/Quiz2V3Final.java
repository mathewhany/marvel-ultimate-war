package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Point;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.junit.Test;

public class Quiz2V3Final {


	//	Exceptions Path
	String abilityExceptionPath = "exceptions.AbilityUseException";
	String gameExceptionPath = "exceptions.GameActionException";
	String notYourTurnExceptionPath =  "exceptions.NotYourTurnException";
	String leaderAbilityAlreadyUsedExceptionPath = "exceptions.LeaderAbilityAlreadyUsedException";
	String unallowedMovementExceptionPath =  "exceptions.UnallowedMovementException";
	String notEnoughResourcesExceptionPath =  "exceptions.NotEnoughResourcesException";
	String invalidTargetExceptionPath =  "exceptions.InvalidTargetException";


	//	Engine Path
	String gamePath = "engine.Game";
	String playerPath = "engine.Player";
	String priorityQueuePath = "engine.PriorityQueue";

	//	Abilities Path
	String healingPath="model.abilities.HealingAbility";
	String dmgPath="model.abilities.DamagingAbility";
	String abilitiesPath="model.abilities.Ability";
	String ccAbilitiesPath="model.abilities.CrowdControlAbility";
	String areaOfEffectPath="model.abilities.AreaOfEffect";

	String shieldPath = "model.effects.Shield";
	String coverPath="model.world.Cover";
	String effectPath = "model.effects.Effect";
	// Champion Path
	String champPath="model.world.Champion";
	String antiHeroPath="model.world.AntiHero";
	String heroPath = "model.world.Hero";
	String villainPath="model.world.Villain";
	String conditionPath="model.world.Condition";
	String directionPath="model.world.Direction";


	String disarmPath = "model.effects.Disarm";
	String effectTypePath = "model.effects.EffectType";
	String embracePath = "model.effects.Embrace";
	String powerUpPath = "model.effects.PowerUp";
	String rootPath = "model.effects.Root";
	String shockPath = "model.effects.Shock";
	String silencePath = "model.effects.Silence";
	String DodgePath = "model.effects.Dodge";
	String speedUpPath = "model.effects.SpeedUp";
	String stunPath = "model.effects.Stun";


	//	Dodge Cases
	//	Only team Target
	//	Within range with dodge
	@Test(timeout=3000)
	public void testCastDamagingAbilityTeamTargetDoesnotAffectEnemeyWithinRange() {
		Object champ=createHero("ironMan",100,10,20,3000,40,50);
		int randAmout=(int) (Math.random() * 20)+20;
		Object ability=createDmgAbility("", 1, 1, 2, "TEAMTARGET", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer= createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team=createSecondPlayerTeam(secondPlayer, false, champ);

		Object game= createGame(firstPlayer,secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0,4);
		setLocationForObject(champ, 0,4);


		Object champ1= team.get(0);
		Object champ2= team.get(1);

		int hp1=(int) (Math.random() * 30)+40;
		int hp2=(int) (Math.random() * 30)+40;
		setObjectHP(champ1, hp1);
		setObjectHP(champ2, hp2);

		//	within	(0,4) (1,4) (0,3)
		addObjectToBoardGame(game, champ1, 0,3);
		setLocationForObject(champ1, 0,3);

		addObjectToBoardGame(game, champ2, 1,4);
		setLocationForObject(champ2, 1,4);




		Object dodge= createDodgeEffect(2);
		addEffectToChamp(champ1,dodge);

		Object dodge2= createDodgeEffect(2);
		addEffectToChamp(champ2,dodge2);


		addChampToTurnOrder(game, champ);

		try {


			Method m2 = game.getClass().getMethod("castAbility",Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertEquals("Casting damaging ability with area of effect TEAMTARGET should not be applied on the opponent team champions within range if they have dodge effect applied on them, current HP", 
					hp1, returnHp(champ1));

			assertEquals("Casting damaging ability with area of effect TEAMTARGET should not be applied on the opponent team champions within range if they have dodge effect applied on them, current HP", 
					hp2, returnHp(champ2));


		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while casting an ability with area of effect TEAMTARGET");

		}
	}
	@Test(timeout=3000)
	public void testCastCCAbilityDeBuffTeamTargetAffectedByDodgeWithinRange() {
		Object champ=createHero("ironMan",100,10,20,3000,40,50);
		Object effect= createStunEffect(2);
		Object ability=createCCAbility("", 1, 1, 2, "TEAMTARGET", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer= createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team=createSecondPlayerTeam(secondPlayer, false, champ);

		Object game= createGame(firstPlayer,secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0,4);
		setLocationForObject(champ, 0,4);


		Object champ1= team.get(0);
		Object champ2= team.get(1);

		int hp1=(int) (Math.random() * 30)+40;
		int hp2=(int) (Math.random() * 30)+40;
		setObjectHP(champ1, hp1);
		setObjectHP(champ2, hp2);

		//	within	(0,3) (1,4) (1,3)
		addObjectToBoardGame(game, champ1, 0,3);
		setLocationForObject(champ1, 0,3);

		addObjectToBoardGame(game, champ2, 1,4);
		setLocationForObject(champ2, 1,4);




		Object dodge= createDodgeEffect(2);
		addEffectToChamp(champ1,dodge);

		Object dodge2= createDodgeEffect(2);
		addEffectToChamp(champ2,dodge2);


		addChampToTurnOrder(game, champ);

		try {


			Method m2 = game.getClass().getMethod("castAbility",Class.forName(abilitiesPath));
			m2.invoke(game, ability);


			Class<?> c = Class.forName(conditionPath);   

			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, "ACTIVE");

			Method m=champ1.getClass().getMethod("getCondition");


			assertEquals("Casting Stun CC ability with area of effect TEAMTARGET should not be applied on the opponent team champions within range if they have dodge effect applied on them, current condition", 
					value, m.invoke(champ1));

			m=champ2.getClass().getMethod("getCondition");
			assertEquals("Casting Stun CC ability with area of effect TEAMTARGET should not be applied on the opponent team champions within range if they have dodge effect applied on them, current condition", 
					value, m.invoke(champ2));


		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while casting an ability with area of effect TEAMTARGET");

		}
	}

	// Within range without dodge	
	@Test(timeout=3000)
	public void testCastDamagingAbilityTeamTargetWithoutDodgeWithinRange() {
		Object champ=createHero("ironMan",100,10,20,3000,40,50);
		int randAmout=(int) (Math.random() * 20)+20;
		Object ability=createDmgAbility("", 1, 1, 2, "TEAMTARGET", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer= createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team=createSecondPlayerTeam(secondPlayer, false, champ);

		Object game= createGame(firstPlayer,secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0,4);
		setLocationForObject(champ, 0,4);


		Object champ1= team.get(0);
		Object champ2= team.get(1);

		int hp1=(int) (Math.random() * 30)+40;
		int hp2=(int) (Math.random() * 30)+40;
		setObjectHP(champ1, hp1);
		setObjectHP(champ2, hp2);

		//	within	(0,3) (1,4) (1,3)
		addObjectToBoardGame(game, champ1, 0,3);
		setLocationForObject(champ1, 0,3);

		addObjectToBoardGame(game, champ2, 1,4);
		setLocationForObject(champ2, 1,4);


		addChampToTurnOrder(game, champ);

		try {


			Method m2 = game.getClass().getMethod("castAbility",Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			int expected= ((hp1-randAmout)<0)? 0:(hp1-randAmout);

			assertEquals("Casting damaging ability with area of effect TEAMTARGET should be applied on the opponent team champions within range if they dont have dodge effect applied on them, current HP", 
					expected, returnHp(champ1));

			expected= ((hp2-randAmout)<0)? 0:(hp2-randAmout);
			assertEquals("Casting damaging ability with area of effect TEAMTARGET should be applied on the opponent team champions within range if they dont have dodge effect applied on them, current HP", 
					expected, returnHp(champ2));


		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while casting an ability with area of effect TEAMTARGET");

		}
	}
	@Test(timeout=3000)
	public void testCastCCAbilityDeBuffTeamTargetWithoutDodgeWithinRange() {
		Object champ=createHero("ironMan",100,10,20,3000,40,50);
		Object effect= createStunEffect(2);
		Object ability=createCCAbility("", 1, 1, 2, "TEAMTARGET", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer= createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team=createSecondPlayerTeam(secondPlayer, false, champ);

		Object game= createGame(firstPlayer,secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0,4);
		setLocationForObject(champ, 0,4);


		Object champ1= team.get(0);
		Object champ2= team.get(1);

		int hp1=(int) (Math.random() * 30)+40;
		int hp2=(int) (Math.random() * 30)+40;
		setObjectHP(champ1, hp1);
		setObjectHP(champ2, hp2);

		//	within	(0,3) (1,4) (1,3)
		addObjectToBoardGame(game, champ1, 0,3);
		setLocationForObject(champ1, 0,3);

		addObjectToBoardGame(game, champ2, 1,4);
		setLocationForObject(champ2, 1,4);



		addChampToTurnOrder(game, champ);

		try {


			Method m2 = game.getClass().getMethod("castAbility",Class.forName(abilitiesPath));
			m2.invoke(game, ability);


			Class<?> c = Class.forName(conditionPath);   

			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, "INACTIVE");

			Method m=champ1.getClass().getMethod("getCondition");


			assertEquals("Casting Stun CC ability with area of effect TEAMTARGET should be applied on the opponent team champions within range if they dont have dodge effect applied on them, current condition", 
					value, m.invoke(champ1));

			m=champ2.getClass().getMethod("getCondition");
			assertEquals("Casting Stun CC ability with area of effect TEAMTARGET should be applied on the opponent team champions within range if they dont have dodge effect applied on them, current condition", 
					value, m.invoke(champ2));


		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while casting an ability with area of effect TEAMTARGET");

		}
	}

	
	

	// Removing Dodge after casting	
	

	//	Healing ability not affected
	@Test(timeout=3000)
	public void testCastHealingAbilityTeamTargetSameTeam2() {
		Object champ=createHero("ironMan",100,10,20,3000,40,50);
		int randAmout= (int) (Math.random() * 20)+20;
		Object ability=createHealingAbility("", 1, 1, 2, "TEAMTARGET", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer= createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team=createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game= createGame(firstPlayer,secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 0);
		setLocationForObject(champ, 0, 0);

		Object champ2= team.get(1);
		//		(0,1) (0,2) (1,1)
		addObjectToBoardGame(game, champ2, 1, 1);
		setLocationForObject(champ2, 1, 1);



		addChampToTurnOrder(game, champ);
		int randHp=(int) (Math.random() * 20)+20;
		setObjectHP(champ, randHp);
		int randomHp= (int) (Math.random() * 20)+20;
		setObjectHP(champ2, randomHp);

		Object dodge1= createDodgeEffect(2);
		Object dodge2= createDodgeEffect(2);

		addEffectToChamp(champ, dodge1);
		addEffectToChamp(champ2, dodge2);

		try {


			Method m2 = game.getClass().getMethod("castAbility",Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			int expected= ((randHp+randAmout) > returnMaxHp(champ))? returnMaxHp(champ):(randHp+randAmout); 
			assertEquals("Casting healing ability with TEAMTARGET should be applied correctly on current champ even if they have dodge effect applied on them, current HP", 
					expected, returnHp(champ));

			expected= ((randomHp+randAmout) > returnMaxHp(champ2))? returnMaxHp(champ2):(randomHp+randAmout); 
			assertEquals("Casting healing ability with TEAMTARGET should be applied correctly on team champions within range even if they have dodge effect applied on them, current HP", 
					expected, returnHp(champ2));


		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while casting healing ability with area of effect TEAMTARGET ");

		}
	}
	//	CC Buff ability not affected
	@Test(timeout=3000)
	public void testCastCCAbilityTeamTargetSameTeam1() {
		Object champ=createHero("ironMan",100,10,20,3000,40,50);
		Object effect= createPowerUpEffect(2);
		Object ability=createCCAbility("", 1, 1, 2, "TEAMTARGET", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer= createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, false, champ);
		ArrayList<Object> team=createSecondPlayerTeam(secondPlayer, true, champ);

		Object game= createGame(firstPlayer,secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 4);
		setLocationForObject(champ, 0,4);

		Object champ2= team.get(1);
		Object champ3= team.get(2);

		//		(2,4) (1,3) 
		addObjectToBoardGame(game, champ2, 2,4);
		setLocationForObject(champ2, 2,4);
		addObjectToBoardGame(game, champ3, 1,3);
		setLocationForObject(champ3, 1,3);

		Object dodge1= createDodgeEffect(2);
		Object dodge2= createDodgeEffect(2);

		addEffectToChamp(champ2, dodge1);
		addEffectToChamp(champ3, dodge2);

		addChampToTurnOrder(game, champ);

		try {


			Method m2 = game.getClass().getMethod("castAbility",Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertTrue("Casting power up CC ability with TEAMTARGET should be applied correctly on team champions within range even if they have dodge effect applied on them", 
					containsEffect(champ2, effect,true));
			assertTrue("Casting power up CC ability with TEAMTARGET should be applied correctly on team champions within range even if they have dodge effect applied on them", 
					containsEffect(champ3, effect,true));


		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while casting power up CC ability with area of effect TEAMTARGET ");

		}
	}

	//	AntiHero Cases
	//only AntiHero  

	//	not affecting the current champion's team 
	@Test(timeout=3000)
	public void testAntiheroLeaderAbilityNotAppliedOnTheirTeam() {
		Object champ=createAntiHero("Deadpool",100,10,20,3000,40,50);

		Object firstPlayer= createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team1=createFirstPlayerTeam(firstPlayer, false, champ);
		ArrayList<Object> team=createSecondPlayerTeam(secondPlayer, true, champ);
		setLeader(secondPlayer, champ);
		setLeader(firstPlayer, team1.get(0));

		Object game= createGame(firstPlayer,secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0,4);
		setLocationForObject(champ, 0,4);


		Object champ1= team.get(0);
		Object champ2= team.get(1);

		int hp1=(int) (Math.random() * 30)+40;
		int hp2=(int) (Math.random() * 30)+40;
		setObjectHP(champ1, hp1);
		setObjectHP(champ2, hp2);

		//	within	(0,3) (1,4) (1,3)
		addObjectToBoardGame(game, champ1, 0,0);
		setLocationForObject(champ1, 0,0);

		addObjectToBoardGame(game, champ2, 4,0);
		setLocationForObject(champ2, 4,0);




		addChampToTurnOrder(game, champ);

		try {


			Method m2 = game.getClass().getMethod("useLeaderAbility");
			m2.invoke(game);


			Class<?> c = Class.forName(conditionPath);   

			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, "ACTIVE");

			Method m=champ1.getClass().getMethod("getCondition");


			assertEquals("Using Anti-hero leader ability should not affect their team, current condition", 
					value, m.invoke(champ1));

			m=champ2.getClass().getMethod("getCondition");
			assertEquals("Using Anti-hero leader ability should not affect their team, current condition", 
					value, m.invoke(champ2));


		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while using antihero leader ability.");

		}
	}

	// affecting the rest of the team	
	@Test(timeout=3000)
	public void testAntiheroLeaderAbilityAppliedOnOpponets() {
		Object champ=createAntiHero("Deadpool",100,10,20,3000,40,50);

		Object firstPlayer= createPlayer("1");
		Object secondPlayer = createPlayer("2");


		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team=createSecondPlayerTeam(secondPlayer, false, champ);
		setLeader(firstPlayer, champ);
		setLeader(secondPlayer, team.get(2));

		Object game= createGame(firstPlayer,secondPlayer);

		clearBoard(game);


		Object champ1= team.get(0);
		Object champ2= team.get(1);

		addChampToTurnOrder(game, champ);

		try {


			Method m2 = game.getClass().getMethod("useLeaderAbility");
			m2.invoke(game);


			Class<?> c = Class.forName(conditionPath);   

			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, "INACTIVE");

			Method m=champ1.getClass().getMethod("getCondition");


			assertEquals("Using Anti-hero leader ability should be applied on the opponent team champions, current condition", 
					value, m.invoke(champ1));

			m=champ2.getClass().getMethod("getCondition");
			assertEquals("Using Anti-hero leader ability should be applied on the opponent team champions, current condition", 
					value, m.invoke(champ2));



		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while using antihero leader ability.");

		}
	}

	//	test hero stun for 2 turns
	@Test(timeout=3000)
	public void testAntiheroLeaderAbilityAppliedOnHero(){
		Object champ=createAntiHero("Deadpool",100,10,20,3000,40,50);

		Object firstPlayer= createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);

		Object leader2= createRandomVillain();

		setLeader(firstPlayer, champ);
		setLeader(secondPlayer, leader2);

		Object hero= createRandomHero();


		Object game= createGame(firstPlayer,secondPlayer);

		clearBoard(game);


		addChampToTurnOrder(game, champ);

		try {

			Method m = secondPlayer.getClass().getMethod("getTeam");

			((ArrayList<Object>)(m.invoke(secondPlayer))).add(hero);
			((ArrayList<Object>)(m.invoke(secondPlayer))).add(leader2);


			Method m2 = game.getClass().getMethod("useLeaderAbility");
			m2.invoke(game);

			Object stun= returnStunEffect(hero);

			assertEquals("Using Anti-hero leader ability should be stun heros for 2 turns, applied effect duration", 
					5, returnDurationOfEffect(stun));




		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while using antihero leader ability.");

		}
	}

	//	test villain stun for 3 turns
	@Test(timeout=3000)
	public void testAntiheroLeaderAbilityAppliedOnVillain() {
		Object champ=createAntiHero("Deadpool",100,10,20,3000,40,50);

		Object firstPlayer= createPlayer("1");
		Object secondPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, true, champ);
		setLeader(firstPlayer, champ);

		Object leader2= createRandomVillain();
		setLeader(secondPlayer, leader2);

		Object villain= createRandomVillain();


		Object game= createGame(firstPlayer,secondPlayer);

		clearBoard(game);


		addChampToTurnOrder(game, champ);

		try {

			Method m = secondPlayer.getClass().getMethod("getTeam");

			((ArrayList<Object>)(m.invoke(secondPlayer))).add(villain);
			((ArrayList<Object>)(m.invoke(secondPlayer))).add(leader2);


			Method m2 = game.getClass().getMethod("useLeaderAbility");
			m2.invoke(game);

			Object stun= returnStunEffect(villain);

			assertEquals("Using Anti-hero leader ability should be stun villain for 3 turns, applied effect duration", 
					4, returnDurationOfEffect(stun));




		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while using antihero leader ability.");

		}
	}

	//	test anti-hero stun for 4 turns
	@Test(timeout=3000)
	public void testAntiheroLeaderAbilityAppliedOnAntihero() {
		Object champ=createAntiHero("Deadpool",100,10,20,3000,40,50);

		Object firstPlayer= createPlayer("1");
		Object secondPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, true, champ);
		setLeader(firstPlayer, champ);

		Object leader2= createRandomVillain();
		setLeader(secondPlayer, leader2);

		Object antihero= createRandomAntiHero();


		Object game= createGame(firstPlayer,secondPlayer);

		clearBoard(game);


		addChampToTurnOrder(game, champ);

		try {

			Method m = secondPlayer.getClass().getMethod("getTeam");

			((ArrayList<Object>)(m.invoke(secondPlayer))).add(antihero);
			((ArrayList<Object>)(m.invoke(secondPlayer))).add(leader2);


			Method m2 = game.getClass().getMethod("useLeaderAbility");
			m2.invoke(game);

			Object stun= returnStunEffect(antihero);

			assertEquals("Using Anti-hero leader ability should be stun antiheros for 4 turns, applied effect duration", 
					3, returnDurationOfEffect(stun));




		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while using antihero leader ability.");

		}
	}

	//	Helper Methods

	private void setLeader(Object player,Object champ) {
		//		setLeader
		Method m;
		try {
			m=  player.getClass().getMethod("setLeader",Class.forName(champPath));
			m.invoke(player,champ);
		} catch (NoSuchMethodException | SecurityException |
				IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while setting player's leader");
		}
	}

	private Object returnStunEffect(Object champ)throws Exception {
		Method m,m2;
		m = champ.getClass().getMethod("getAppliedEffects");
		ArrayList<Object> effects= (ArrayList<Object>)(m.invoke(champ));
		System.out.println(effects.get(0));
		return effects.get(0);

	}


	private int returnDurationOfEffect(Object effect) {
		Method m;
		try {
			m=  effect.getClass().getMethod("getDuration");
			return (int) m.invoke(effect);
		} catch (NoSuchMethodException | SecurityException |
				IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while getting effect's duration");
			return 0;
		}
	}

	private void addEffectToChamp(Object champ,Object effect) {
		try {
			Method m = champ.getClass().getMethod("getAppliedEffects");
			((ArrayList<Object>)(m.invoke(champ))).add(effect);

		} catch (NoSuchMethodException | SecurityException |
				IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}	
	}

	private boolean containsEffect(Object champ,Object effect, boolean checkContains) {
		Method m,m2;
		try {
			m = champ.getClass().getMethod("getAppliedEffects");
			ArrayList<Object> effects= (ArrayList<Object>)(m.invoke(champ));
			//			if(effects.contains(effect))
			//				fail("Casting CC ability should apply a copy of the effect on the valid targets, not the effect itself.");
			boolean found=false;
			for (int i = 0; i < effects.size(); i++) {
				if(effects.get(i).getClass().equals(effect.getClass()))
					found=true;
			}
			m=effect.getClass().getMethod("getName");
			if(!found && checkContains)
				fail("Casting CC ability should apply "+ m.invoke(effect)+ " effect on the valid targets but it's not found in the applied effects");

			boolean foundEqual=false;
			for (int i = 0; i < effects.size(); i++) {

				m=effect.getClass().getMethod("getName");
				m2=effects.get(i).getClass().getMethod("getName");

				if(m.invoke(effect).equals(m2.invoke(effects.get(i))))
				{
					m=effect.getClass().getMethod("getDuration");
					m2=effects.get(i).getClass().getMethod("getDuration");

					if(m.invoke(effect).equals(m2.invoke(effects.get(i))))
					{
						m=effect.getClass().getMethod("getType");
						m2=effects.get(i).getClass().getMethod("getType");
						if(m.invoke(effect).equals(m2.invoke(effects.get(i))))
						{
							foundEqual=true;

						}
					}
				}
			}
			return foundEqual;
		} catch (NoSuchMethodException | SecurityException |
				IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while trying loop over applied effects arraylist");
		}
		return false;
	}


	private void setLocationForObject(Object obj, int x , int y) {
		Method m;
		try {
			m=  obj.getClass().getMethod("setLocation",Point.class);
			m.invoke(obj, new Point(x, y));
		} catch (NoSuchMethodException | SecurityException |
				IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while getting HP");
		}
	}

	private ArrayList<Object> createFirstPlayerTeam(Object firstPlayer, boolean includCurrentChamp,Object champ) {
		Object champ2= createRandomAntiHero();
		Object champ3= createRandomVillain();
		Object champ4= createRandomHero();

		Method m;
		try {
			m = firstPlayer.getClass().getMethod("getTeam");
			if(includCurrentChamp)
				((ArrayList<Object>)(m.invoke(firstPlayer))).add(champ);
			else
				((ArrayList<Object>)(m.invoke(firstPlayer))).add(champ4);
			((ArrayList<Object>)(m.invoke(firstPlayer))).add(champ2);
			((ArrayList<Object>)(m.invoke(firstPlayer))).add(champ3);

			return (ArrayList<Object>)(m.invoke(firstPlayer));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	private ArrayList<Object> createSecondPlayerTeam(Object secondPlayer, boolean includCurrentChamp,Object champ) {
		Object champ4= createRandomAntiHero();
		Object champ5= createRandomVillain();
		Object champ6= createRandomHero();
		Method m;

		try {
			m = secondPlayer.getClass().getMethod("getTeam");
			if(includCurrentChamp)
				((ArrayList<Object>)(m.invoke(secondPlayer))).add(champ);
			else
				((ArrayList<Object>)(m.invoke(secondPlayer))).add(champ4);

			((ArrayList<Object>)(m.invoke(secondPlayer))).add(champ5);
			((ArrayList<Object>)(m.invoke(secondPlayer))).add(champ6);
			return (ArrayList<Object>)(m.invoke(secondPlayer));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private int returnHp(Object obj) {
		Method m;
		try {
			m=  obj.getClass().getMethod("getCurrentHP");
			return (int) m.invoke(obj);
		} catch (NoSuchMethodException | SecurityException |
				IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while getting HP");
			return 0;
		}

	}
	private int returnMaxHp(Object obj) {
		Method m;
		try {
			m=  obj.getClass().getMethod("getMaxHP");
			return (int) m.invoke(obj);
		} catch (NoSuchMethodException | SecurityException |
				IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while getting MaxHP");
			return 0;
		}

	}

	private void setObjectHP(Object obj, int newHp) {
		Method m;
		try {
			m=  obj.getClass().getMethod("setCurrentHP",int.class);
			m.invoke(obj,newHp);
		} catch (NoSuchMethodException | SecurityException |
				IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while setting currentHP");
		}
	}

	private void clearBoard(Object game) {
		Class curr = game.getClass();
		Field f = null;
		try {
			f = curr.getDeclaredField("board");
			f.setAccessible(true);
			f.set(game,new Object[5][5]);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void addAbilityToChampion(Object champ, Object ability) {
		try {
			Method m = champ.getClass().getMethod("getAbilities");
			((ArrayList<Object>)(m.invoke(champ))).add(ability);
		} catch (NoSuchMethodException | SecurityException |
				IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	private void addChampToTurnOrder(Object game,Object champ) {
		Field f1 = null;
		Class curr1 = game.getClass();
		try {
			f1 = curr1.getDeclaredField("turnOrder");
			f1.setAccessible(true);
			f1.get(game);
			curr1 = f1.get(game).getClass();
			Constructor<?> constructorTurnOrder = Class.forName(priorityQueuePath).getConstructor(int.class);
			Object turnOrder = constructorTurnOrder.newInstance(6);
			Method m = turnOrder.getClass().getMethod("insert", Comparable.class);
			m.invoke(turnOrder, champ);
			f1.set(game, turnOrder);

		} catch (NoSuchFieldException | SecurityException 
				| IllegalArgumentException | IllegalAccessException 
				| InstantiationException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred");
		}

	}
	private void addObjectToBoardGame(Object createdGame,Object obj, int x, int y) {
		Method m1;
		try {
			m1 = createdGame.getClass().getMethod("getBoard");
			((Object[][]) m1.invoke(createdGame))[x][y]=obj;
		} catch (NoSuchMethodException | SecurityException 
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred");
		}
	}

	private Object createPlayer(String s) {
		try {
			Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
			Object firstPlayer = constructorFirstPlayer.newInstance(s);
			return firstPlayer;

		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred");
			return null;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred");
			return null;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred");
			return null;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred");
			return null;
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred");
			return null;
		}

	}

	
	private Object createGame(Object firstPlayer,Object secondPlayer) {
		Constructor<?> gameConstructor;
		try {
			gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),Class.forName(playerPath));
			Object createdGame = gameConstructor.newInstance(firstPlayer,secondPlayer);
			return createdGame;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred");
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred");
		}

		return null;
	}

	private Object createHero(String name, int maxHP, int mana, int actions, int speed, int attackRange, int attackDamage) {
		try {
			Constructor<?> constructorHeroChamp = Class.forName(heroPath).getConstructor(String.class, int.class, int.class, int.class,
					int.class, int.class, int.class);
			Object champ = constructorHeroChamp.newInstance(name,maxHP, mana,actions,speed,attackRange,attackDamage);
			return champ;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred");
			return null;
		}



	}

	private Object createRandomHero() {
		try {
			Constructor<?> constructorChamp = Class.forName(heroPath).getConstructor(String.class, int.class, int.class, int.class,
					int.class, int.class, int.class);
			Object champ = constructorChamp.newInstance("ironman", 100, 200, 300, 400, 500, 600);
			return champ;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred");
			return null;
		}
	}
	private Object createAntiHero(String name, int maxHP, int mana, int actions, int speed, int attackRange, int attackDamage) {
		try {
			Constructor<?> constructorChamp = Class.forName(antiHeroPath).getConstructor(String.class, int.class, int.class, int.class,
					int.class, int.class, int.class);
			Object champ = constructorChamp.newInstance(name,maxHP, mana,actions,speed,attackRange,attackDamage);
			return champ;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred");
			return null;
		}



	}

	private Object createRandomAntiHero() {
		try {
			Constructor<?> constructorChamp = Class.forName(antiHeroPath).getConstructor(String.class, int.class, int.class, int.class,
					int.class, int.class, int.class);
			Object champ = constructorChamp.newInstance("Deadpool", 100, 200, 300, 400, 500, 600);
			return champ;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred");
			return null;
		}
	}
	
	private Object createRandomVillain() {
		try {
			Constructor<?> constructorChamp = Class.forName(villainPath).getConstructor(String.class, int.class, int.class, int.class,
					int.class, int.class, int.class);
			Object champ = constructorChamp.newInstance("Thanos",100, 200, 300, 400, 500, 600);
			return champ;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred");
			return null;
		}
	}

	private Object createDodgeEffect(int duration) {
		try {
			Constructor<?> effecrConstructor = Class.forName(DodgePath).getConstructor(int.class);
			Object effect = effecrConstructor.newInstance(duration);
			return effect;
		} catch (NoSuchMethodException | SecurityException |
				ClassNotFoundException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred");
		}
		return null;
	}
	private Object createPowerUpEffect(int duration) {
		try {
			Constructor<?> effecrConstructor = Class.forName(powerUpPath).getConstructor(int.class);
			Object effect = effecrConstructor.newInstance(duration);
			return effect;
		} catch (NoSuchMethodException | SecurityException |
				ClassNotFoundException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred");
		}
		return null;
	}
	private Object createStunEffect(int duration) {
		try {
			Constructor<?> stunEffecrConstructor = Class.forName(stunPath).getConstructor(int.class);
			Object stunEffect = stunEffecrConstructor.newInstance(duration);
			return stunEffect;
		} catch (NoSuchMethodException | SecurityException |
				ClassNotFoundException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred");
		}
		return null;
	}
	
	private Object createHealingAbility(String name,int cost, int baseCoolDown, int castRadius, 
			String areaOfEffect,int required, int healingAmount) {
		try {
			Constructor<?> healingAbilityConst = Class.forName(healingPath).
					getConstructor(String.class,int.class, int.class, int.class,Class.forName(areaOfEffectPath), int.class, int.class);
			Class<?> c = Class.forName(areaOfEffectPath);   

			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, areaOfEffect);
			Object healingAbility = healingAbilityConst.newInstance(name,cost,baseCoolDown, castRadius, 
					value, required, healingAmount);
			return healingAbility;

		} catch (NoSuchMethodException | SecurityException | 
				ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while creating healing ability");
		}
		return null;
	}
	private Object createDmgAbility(String name,int cost, int baseCoolDown, int castRadius, 
			String areaOfEffect,int required, int damageAmount) {
		try {
			Constructor<?> dmgAbilityConstructor = Class.forName(dmgPath).
					getConstructor(String.class,int.class, int.class, int.class,Class.forName(areaOfEffectPath), int.class, int.class);
			Class<?> c = Class.forName(areaOfEffectPath);   

			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, areaOfEffect);
			Object dmgAbility = dmgAbilityConstructor.newInstance(name,cost,baseCoolDown, castRadius, 
					value, required, damageAmount);
			return dmgAbility;

		} catch (NoSuchMethodException | SecurityException | 
				ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while creating damaging ability");
		}
		return null;
	}
	private Object createCCAbility(String name,int cost, int baseCoolDown, int castRadius, 
			String areaOfEffect,int required, Object effect) {
		try {
			Constructor<?> ccAbilityConstructor = Class.forName(ccAbilitiesPath)
					.getConstructor(String.class,int.class, int.class, int.class,
							Class.forName(areaOfEffectPath),int.class,Class.forName(effectPath));

			Class<?> c = Class.forName(areaOfEffectPath);   

			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, areaOfEffect);
			Object ccAbility = ccAbilityConstructor.newInstance(name,cost,baseCoolDown, castRadius, 
					value, required, effect);
			return ccAbility;

		} catch (NoSuchMethodException | SecurityException | 
				ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e) {
			// TODO Auto-generated catch block
			fail(e.getCause().getClass() +" occurred while creating damaging ability");
		}
		return null;
	}


}
