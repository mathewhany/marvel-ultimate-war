package tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

public class M2PublicTests {
	String championPath = "model.world.Champion";
	String directionPath = "model.world.Direction";
	String conditionPath = "model.world.Condition";
	String coverPath = "model.world.Cover";
	String antiHeroPath = "model.world.AntiHero";
	String heroPath = "model.world.Hero";
	String villainPath = "model.world.Villain";

	String abilityExceptionPath = "exceptions.AbilityUseException";
	String gameExceptionPath = "exceptions.GameActionException";
	String notYourTurnExceptionPath = "exceptions.NotYourTurnException";
	String leaderAbilityAlreadyUsedExceptionPath = "exceptions.LeaderAbilityAlreadyUsedException";
	String unallowedMovementExceptionPath = "exceptions.UnallowedMovementException";

	String gamePath = "engine.Game";
	String playerPath = "engine.Player";
	String priorityQueuePath = "engine.PriorityQueue";

	String healingPath = "model.abilities.HealingAbility";
	String dmgPath = "model.abilities.DamagingAbility";
	String abilitiesPath = "model.abilities.Ability";
	String ccAbilitiesPath = "model.abilities.CrowdControlAbility";

	String champPath = "model.world.Champion";
	String abilityPath = "model.abilities.Ability";
	String areaOfEffectPath = "model.abilities.AreaOfEffect";
	String crowdControlAbilityPath = "model.abilities.CrowdControlAbility";
	String damagingAbilityPath = "model.abilities.DamagingAbility";
	String healingAbilityPath = "model.abilities.HealingAbility";
	String effectPath = "model.effects.Effect";
	String shieldPath = "model.effects.Shield";
	String DodgePath = "model.effects.Dodge";
	String speedUpPath = "model.effects.SpeedUp";
	String UnallowedMovementException = "exceptions.UnallowedMovementException";
	String ChampionDisarmedException = "exceptions.ChampionDisarmedException";
	String notEnoughResourcesExceptionPath = "exceptions.NotEnoughResourcesException";
	String invalidTargetExceptionPath = "exceptions.InvalidTargetException";
	String disarmPath = "model.effects.Disarm";
	String dodgePath = "model.effects.Disarm";
	String embracePath = "model.effects.Embrace";
	String powerUpPath = "model.effects.PowerUp";
	String rootPath = "model.effects.Root";
	String silencePath = "model.effects.Silence";
	String stunPath = "model.effects.Stun";
	String shockPath = "model.effects" + ".Shock";
	String damageablePath = "model.world.Damageable";
	String effectTypePath = "model.effects.EffectType";
	String leaderNotCurrentExc = "exceptions.LeaderNotCurrentException";
	String leaderAbilityUsedExc = "exceptions.LeaderAbilityAlreadyUsedException";
	String gameActionExceptionPath = "exceptions.GameActionException";
	String itePath = "exceptions.InvalidTargetException";
	String leaderAbilityUsedExceptionPath = "exceptions.LeaderAbilityAlreadyUsedException";
	String championDisarmedExceptionPath = "exceptions.ChampionDisarmedException";

	String invalidTargetException = "exceptions.InvalidTargetException";
	String NotEnoughResourcesException = "exceptions.NotEnoughResourcesException";

	String speedupPath = "model.effects.SpeedUp";

	@Test(timeout = 3000)
	public void testDamageableIsInterface() {
		try {
			testIsInterface(Class.forName(damageablePath));
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.world should contain an interface called Damageable.", false);
		}
	}

	@Test(timeout = 3000)
	public void testGetLocationExistsDamageable() {
		Method m = null;
		try {
			m = Class.forName(damageablePath).getDeclaredMethod("getLocation");
		} catch (NoSuchMethodException e) {
			assertTrue("Interface \"Damageable\" should contain an abstract method called \"getLocation\".", false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.world should contain an interface called \"Damageable\".", false);
		}
		assertFalse("Method \"getLocation\" in interface \"Damageable\" should not be static.",
				Modifier.isStatic(m.getModifiers()));
		assertTrue("Method \"getLocation\" in interface \"Damageable\" should return a \"Point\".",
				m.getReturnType().equals(Point.class));

	}

	@Test(timeout = 3000)
	public void testGetCurrentHPExistsDamageable() {
		Method m = null;
		try {
			m = Class.forName(damageablePath).getDeclaredMethod("getCurrentHP");
		} catch (NoSuchMethodException e) {
			assertTrue("Interface \"Damageable\" should contain an abstract method called \"getCurrentHP\".", false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.world should contain an interface called \"Damageable\".", false);
		}
		assertFalse("Method \"getCurrentHP\" in interface \"Damageable\" should not be static.",
				Modifier.isStatic(m.getModifiers()));
		assertTrue("Method \"getCurrentHP\" in interface \"Damageable\" should return an \"int\".",
				m.getReturnType().equals(int.class));

	}

	@Test(timeout = 3000)
	public void testSetCurrentHPExistsDamageable() {
		Method m = null;
		try {
			m = Class.forName(damageablePath).getDeclaredMethod("setCurrentHP", int.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Interface \"Damageable\" should contain an abstract method called \"setCurrentHP\" that takes an int as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}
		assertFalse("Method \"setCurrentHP\" in interface \"Damageable\" should not be static.",
				Modifier.isStatic(m.getModifiers()));
		assertTrue("Method \"setCurrentHP\" in interface \"Damageable\" should be void.",
				m.getReturnType().equals(void.class));

	}

	@Test(timeout = 3000)
	public void testChampionImplementsDamageable() {
		try {
			testClassImplementsInterface(Class.forName(championPath), Class.forName(damageablePath));
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		}
	}

	@Test(timeout = 3000)
	public void testEffectImplementsCloneable() {
		try {
			testClassImplementsInterface(Class.forName(effectPath), Cloneable.class);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Effect.", false);
		}
	}

	@Test(timeout = 3000)
	public void testCloneExistsEffect() {
		Method m = null;
		try {
			m = Class.forName(effectPath).getDeclaredMethod("clone");
		} catch (NoSuchMethodException e) {
			assertTrue("Class \"Effect\" should override the method called \"clone\".", false);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called \"Effect\".", false);
		}
		assertTrue("Method \"clone\" in class \"Effect\" should return an \"Object\".",
				m.getReturnType().equals(Object.class));
		assertTrue("Method \"clone\" in class \"Effect\" should be public.", Modifier.isPublic(m.getModifiers()));
		boolean found = false;
		if (m.getExceptionTypes().length != 0) {
			for (int i = 0; i < m.getExceptionTypes().length; i++) {
				if (m.getExceptionTypes()[i].getSimpleName().equals("CloneNotSupportedException")) {
					found = true;
				}
			}
			assertTrue(
					"Method \"clone\" in class \"Effect\" should throw the exception called \"java.lang.CloneNotSupportedException\".",
					found);

		} else {
			assertTrue(
					"Method \"clone\" in class \"Effect\" should throw the exception called \"java.lang.CloneNotSupportedException\".",
					false);
		}

	}

	@Test(timeout = 3000)
	public void testCloneEffectLogic() {
		Method m = null;
		Constructor<?> constructorSpeedUp;

		try {
			m = Class.forName(effectPath).getDeclaredMethod("clone");
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called \"Effect\".", false);
		} catch (NoSuchMethodException e) {
			assertTrue("Class \"Effect\" should override the method called \"clone\".", false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

		try {
			constructorSpeedUp = Class.forName(speedUpPath).getConstructor(int.class);
			Object speedUPObject = constructorSpeedUp.newInstance(10);
			Object x1 = m.invoke(speedUPObject);
			Object x2 = m.invoke(speedUPObject);
			assertFalse("Method \"clone\" in class \"Effect\" should call the super.", x1 == x2);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called \"Effect\".", false);
		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"SpeedUp\" can be instantiated", false);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void testApplyExistsEffect() {
		Method m = null;
		try {
			m = Class.forName(effectPath).getDeclaredMethod("apply", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Effect\" should contain a method called \"apply\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Effect.", false);
		}
		assertTrue("Method \"apply\" in class \"Ability\" should be abstract.", Modifier.isAbstract(m.getModifiers()));
		assertTrue("Method \"apply\" in class \"Ability\" should be void.", m.getReturnType().equals(void.class));

	}

	@Test(timeout = 3000)
	public void testApplyExistsInShield() {
		try {
			Class.forName(shieldPath).getDeclaredMethod("apply", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Shield\" should implement the method called \"apply\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Shield.", false);
		}
	}

	@Test(timeout = 3000)
	public void testApplyExistsInSilence() {
		try {
			Class.forName(silencePath).getDeclaredMethod("apply", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Silence\" should implement the method called \"apply\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Silence.", false);
		}
	}

	@Test(timeout = 3000)
	public void testApplyExistsInRoot() {

		try {
			Class.forName(rootPath).getDeclaredMethod("apply", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Root\" should implement the method called \"apply\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Root.", false);
		}
	}

	@Test(timeout = 3000)
	public void testApplyExistsInShock() {
		try {
			Class.forName(shockPath).getDeclaredMethod("apply", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Shock\" should implement the method called \"apply\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Shock.", false);
		}
	}

	@Test(timeout = 3000)
	public void testApplyExistsInStun() {
		try {
			Class.forName(stunPath).getDeclaredMethod("apply", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Stun\" should implement the method called \"apply\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Stun.", false);
		}
	}

	@Test(timeout = 3000)
	public void testRemoveExistsEffect() {
		Method m = null;
		try {
			m = Class.forName(effectPath).getDeclaredMethod("remove", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Effect\" should contain a method called \"remove\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Effect.", false);
		}
		assertTrue("Method \"remove\" in class \"Ability\" should be abstract.", Modifier.isAbstract(m.getModifiers()));
		assertTrue("Method \"remove\" in class \"Ability\" should be void.", m.getReturnType().equals(void.class));

	}

	@Test(timeout = 3000)
	public void testRemoveExistsInEmbrace() {
		try {
			Class.forName(embracePath).getDeclaredMethod("remove", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Embrace\" should implement the method called \"remove\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Embrace.", false);
		}

	}

	@Test(timeout = 3000)
	public void testRemoveExistsInPowerUp() {
		try {
			Class.forName(powerUpPath).getDeclaredMethod("remove", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"PowerUp\" should implement the method called \"remove\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called PowerUp.", false);
		}
	}

	@Test(timeout = 3000)
	public void testRemoveExistsInDodge() {
		try {
			Class.forName(DodgePath).getDeclaredMethod("remove", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Dodge\" should implement the method called \"remove\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Dodge.", false);
		}
	}

	@Test(timeout = 3000)
	public void testRemoveExistsInSpeedUp() {
		try {
			Class.forName(speedUpPath).getDeclaredMethod("remove", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"SpeedUp\" should implement the method called \"remove\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called SpeedUp.", false);
		}
	}

	@Test(timeout = 3000)
	public void testRemoveExistsInDisarm() {
		try {
			Class.forName(disarmPath).getDeclaredMethod("remove", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Disarm\" should implement the method called \"remove\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Disarm.", false);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicShieldNoChange() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorShield;
		int randomMaxHP = (int) (Math.random() * 1000) + 100;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 1000) + 100;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 100) + 20;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 1000) + 100;
		int duration = (int) (Math.random() * 10) + 1;

		try {

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorShield = Class.forName(shieldPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object shieldObject = constructorShield.newInstance(duration);

			ArrayList<Object> empty = new ArrayList<>();

			Method apply = Class.forName(shieldPath).getDeclaredMethod("apply", Class.forName(championPath));
			apply.invoke(shieldObject, championObject);
			Class<?> curr = Class.forName(championPath);

			Field max = curr.getDeclaredField("maxHP");
			Field name = curr.getDeclaredField("name");
			Field maxActionPointsPerTurn = curr.getDeclaredField("maxActionPointsPerTurn");
			Field currentActionPoints = curr.getDeclaredField("currentActionPoints");
			Field attackRange = curr.getDeclaredField("attackRange");
			Field abilities = curr.getDeclaredField("abilities");
			Field appliedEffects = curr.getDeclaredField("appliedEffects");
			Field condition = curr.getDeclaredField("condition");
			Field location = curr.getDeclaredField("location");
			Field currentHP = curr.getDeclaredField("currentHP");
			Field mana = curr.getDeclaredField("mana");
			Field speed = curr.getDeclaredField("speed");
			Field attackDamage = curr.getDeclaredField("attackDamage");

			max.setAccessible(true);
			name.setAccessible(true);
			maxActionPointsPerTurn.setAccessible(true);
			currentActionPoints.setAccessible(true);
			attackRange.setAccessible(true);
			appliedEffects.setAccessible(true);
			condition.setAccessible(true);
			location.setAccessible(true);
			currentHP.setAccessible(true);
			mana.setAccessible(true);
			speed.setAccessible(true);
			attackDamage.setAccessible(true);
			abilities.setAccessible(true);

			assertEquals("The method \"" + "apply" + "\" in class \"" + shieldObject.getClass().getSimpleName()
					+ "\" should not change \"" + "maxHP" + "\".", randomMaxHP, max.get(championObject));
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + shieldObject.getClass().getSimpleName()
							+ "\" should not change \"" + "name" + "\".",
					"Name_" + randomName, name.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + shieldObject.getClass().getSimpleName()
							+ "\" should not change \"" + "maxActionPointsPerTurn" + "\".",
					randomActions, maxActionPointsPerTurn.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + shieldObject.getClass().getSimpleName()
							+ "\" should not change \"" + "currentActionPoints" + "\".",
					randomActions, currentActionPoints.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + shieldObject.getClass().getSimpleName()
							+ "\" should not change \"" + "attackRange" + "\".",
					randomAttackRange, attackRange.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + shieldObject.getClass().getSimpleName()
							+ "\" should not change \"" + "appliedEffects" + "\".",
					empty, appliedEffects.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + shieldObject.getClass().getSimpleName()
							+ "\" should not change \"" + "condition" + "\".",
					Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ACTIVE"), condition.get(championObject));

			assertEquals("The method \"" + "apply" + "\" in class \"" + shieldObject.getClass().getSimpleName()
					+ "\" should not change \"" + "location" + "\".", null, location.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + shieldObject.getClass().getSimpleName()
							+ "\" should not change \"" + "currentHP" + "\".",
					randomMaxHP, currentHP.get(championObject));
			assertEquals("The method \"" + "apply" + "\" in class \"" + shieldObject.getClass().getSimpleName()
					+ "\" should not change \"" + "mana" + "\".", randomMana, mana.get(championObject));
			assertEquals("The method \"" + "apply" + "\" in class \"" + shieldObject.getClass().getSimpleName()
					+ "\" should not change \"" + "abilities" + "\".", empty, abilities.get(championObject));
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + shieldObject.getClass().getSimpleName()
							+ "\" should not change \"" + "attackDamage" + "\".",
					randomAttackDamage, attackDamage.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Shield\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Shield\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicShockNoChange() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorShock;
		int randomMaxHP = (int) (Math.random() * 1000) + 100;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 1000) + 100;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 100) + 20;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 1000) + 100;
		int duration = (int) (Math.random() * 10) + 1;

		try {

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorShock = Class.forName(shockPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object shockObject = constructorShock.newInstance(duration);

			ArrayList<Object> empty = new ArrayList<>();

			Method apply = Class.forName(shockPath).getDeclaredMethod("apply", Class.forName(championPath));
			apply.invoke(shockObject, championObject);
			Class<?> curr = Class.forName(championPath);

			Field max = curr.getDeclaredField("maxHP");
			Field name = curr.getDeclaredField("name");
			Field maxActionPointsPerTurn = curr.getDeclaredField("maxActionPointsPerTurn");
			Field currentActionPoints = curr.getDeclaredField("currentActionPoints");
			Field attackRange = curr.getDeclaredField("attackRange");
			Field abilities = curr.getDeclaredField("abilities");
			Field appliedEffects = curr.getDeclaredField("appliedEffects");
			Field condition = curr.getDeclaredField("condition");
			Field location = curr.getDeclaredField("location");
			Field currentHP = curr.getDeclaredField("currentHP");
			Field mana = curr.getDeclaredField("mana");
			Field speed = curr.getDeclaredField("speed");
			Field attackDamage = curr.getDeclaredField("attackDamage");

			max.setAccessible(true);
			name.setAccessible(true);
			maxActionPointsPerTurn.setAccessible(true);
			currentActionPoints.setAccessible(true);
			attackRange.setAccessible(true);
			appliedEffects.setAccessible(true);
			condition.setAccessible(true);
			location.setAccessible(true);
			currentHP.setAccessible(true);
			mana.setAccessible(true);
			speed.setAccessible(true);
			attackDamage.setAccessible(true);
			abilities.setAccessible(true);

			assertEquals("The method \"" + "apply" + "\" in class \"" + shockObject.getClass().getSimpleName()
					+ "\" should not change \"" + "maxHP" + "\".", randomMaxHP, max.get(championObject));
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + shockObject.getClass().getSimpleName()
							+ "\" should not change \"" + "name" + "\".",
					"Name_" + randomName, name.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + shockObject.getClass().getSimpleName()
							+ "\" should not change \"" + "attackRange" + "\".",
					randomAttackRange, attackRange.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + shockObject.getClass().getSimpleName()
							+ "\" should not change \"" + "appliedEffects" + "\".",
					empty, appliedEffects.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + shockObject.getClass().getSimpleName()
							+ "\" should not change \"" + "condition" + "\".",
					Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ACTIVE"), condition.get(championObject));

			assertEquals("The method \"" + "apply" + "\" in class \"" + shockObject.getClass().getSimpleName()
					+ "\" should not change \"" + "location" + "\".", null, location.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + shockObject.getClass().getSimpleName()
							+ "\" should not change \"" + "currentHP" + "\".",
					randomMaxHP, currentHP.get(championObject));
			assertEquals("The method \"" + "apply" + "\" in class \"" + shockObject.getClass().getSimpleName()
					+ "\" should not change \"" + "mana" + "\".", randomMana, mana.get(championObject));
			assertEquals("The method \"" + "apply" + "\" in class \"" + shockObject.getClass().getSimpleName()
					+ "\" should not change \"" + "abilities" + "\".", empty, abilities.get(championObject));
		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Shock\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Shock\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicSilenceNoChange() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorSilence;
		int randomMaxHP = (int) (Math.random() * 1000) + 100;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 1000) + 100;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 100) + 20;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 1000) + 100;
		int duration = (int) (Math.random() * 10) + 1;

		try {

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorSilence = Class.forName(silencePath).getConstructor(int.class);
			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}
			Object silenceObject = constructorSilence.newInstance(duration);

			ArrayList<Object> empty = new ArrayList<>();

			Method apply = Class.forName(silencePath).getDeclaredMethod("apply", Class.forName(championPath));
			apply.invoke(silenceObject, championObject);
			Class<?> curr = Class.forName(championPath);

			Field max = curr.getDeclaredField("maxHP");
			Field name = curr.getDeclaredField("name");
			Field maxActionPointsPerTurn = curr.getDeclaredField("maxActionPointsPerTurn");
			Field currentActionPoints = curr.getDeclaredField("currentActionPoints");
			Field attackRange = curr.getDeclaredField("attackRange");
			Field abilities = curr.getDeclaredField("abilities");
			Field appliedEffects = curr.getDeclaredField("appliedEffects");
			Field condition = curr.getDeclaredField("condition");
			Field location = curr.getDeclaredField("location");
			Field currentHP = curr.getDeclaredField("currentHP");
			Field mana = curr.getDeclaredField("mana");
			Field speed = curr.getDeclaredField("speed");
			Field attackDamage = curr.getDeclaredField("attackDamage");

			max.setAccessible(true);
			name.setAccessible(true);
			maxActionPointsPerTurn.setAccessible(true);
			currentActionPoints.setAccessible(true);
			attackRange.setAccessible(true);
			appliedEffects.setAccessible(true);
			condition.setAccessible(true);
			location.setAccessible(true);
			currentHP.setAccessible(true);
			mana.setAccessible(true);
			speed.setAccessible(true);
			attackDamage.setAccessible(true);
			abilities.setAccessible(true);

			assertEquals("The method \"" + "apply" + "\" in class \"" + silenceObject.getClass().getSimpleName()
					+ "\" should not change \"" + "maxHP" + "\".", randomMaxHP, max.get(championObject));
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + silenceObject.getClass().getSimpleName()
							+ "\" should not change \"" + "name" + "\".",
					"Name_" + randomName, name.get(championObject));

			assertEquals("The method \"" + "apply" + "\" in class \"" + silenceObject.getClass().getSimpleName()
					+ "\" should not change \"" + "speed" + "\".", randomSpeed, speed.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + silenceObject.getClass().getSimpleName()
							+ "\" should not change \"" + "attackRange" + "\".",
					randomAttackRange, attackRange.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + silenceObject.getClass().getSimpleName()
							+ "\" should not change \"" + "appliedEffects" + "\".",
					empty, appliedEffects.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + silenceObject.getClass().getSimpleName()
							+ "\" should not change \"" + "condition" + "\".",
					Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ACTIVE"), condition.get(championObject));

			assertEquals("The method \"" + "apply" + "\" in class \"" + silenceObject.getClass().getSimpleName()
					+ "\" should not change \"" + "location" + "\".", null, location.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + silenceObject.getClass().getSimpleName()
							+ "\" should not change \"" + "currentHP" + "\".",
					randomMaxHP, currentHP.get(championObject));
			assertEquals("The method \"" + "apply" + "\" in class \"" + silenceObject.getClass().getSimpleName()
					+ "\" should not change \"" + "mana" + "\".", randomMana, mana.get(championObject));
			assertEquals("The method \"" + "apply" + "\" in class \"" + silenceObject.getClass().getSimpleName()
					+ "\" should not change \"" + "abilities" + "\".", empty, abilities.get(championObject));
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + silenceObject.getClass().getSimpleName()
							+ "\" should not change \"" + "attackDamage" + "\".",
					randomAttackDamage, attackDamage.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Silence\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Silence\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicSpeedUpNoChange() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorSpeed;
		int randomMaxHP = (int) (Math.random() * 1000) + 100;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 1000) + 100;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 100) + 20;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 1000) + 100;
		int duration = (int) (Math.random() * 10) + 1;

		try {

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorSpeed = Class.forName(speedUpPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object speedObject = constructorSpeed.newInstance(duration);

			ArrayList<Object> empty = new ArrayList<>();

			Method apply = Class.forName(speedUpPath).getDeclaredMethod("apply", Class.forName(championPath));
			apply.invoke(speedObject, championObject);
			Class<?> curr = Class.forName(championPath);

			Field max = curr.getDeclaredField("maxHP");
			Field name = curr.getDeclaredField("name");
			Field maxActionPointsPerTurn = curr.getDeclaredField("maxActionPointsPerTurn");
			Field currentActionPoints = curr.getDeclaredField("currentActionPoints");
			Field attackRange = curr.getDeclaredField("attackRange");
			Field abilities = curr.getDeclaredField("abilities");
			Field appliedEffects = curr.getDeclaredField("appliedEffects");
			Field condition = curr.getDeclaredField("condition");
			Field location = curr.getDeclaredField("location");
			Field currentHP = curr.getDeclaredField("currentHP");
			Field mana = curr.getDeclaredField("mana");
			Field speed = curr.getDeclaredField("speed");
			Field attackDamage = curr.getDeclaredField("attackDamage");

			max.setAccessible(true);
			name.setAccessible(true);
			maxActionPointsPerTurn.setAccessible(true);
			currentActionPoints.setAccessible(true);
			attackRange.setAccessible(true);
			appliedEffects.setAccessible(true);
			condition.setAccessible(true);
			location.setAccessible(true);
			currentHP.setAccessible(true);
			mana.setAccessible(true);
			speed.setAccessible(true);
			attackDamage.setAccessible(true);
			abilities.setAccessible(true);

			assertEquals("The method \"" + "apply" + "\" in class \"" + speedObject.getClass().getSimpleName()
					+ "\" should not change \"" + "maxHP" + "\".", randomMaxHP, max.get(championObject));
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + speedObject.getClass().getSimpleName()
							+ "\" should not change \"" + "name" + "\".",
					"Name_" + randomName, name.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + speedObject.getClass().getSimpleName()
							+ "\" should not change \"" + "attackRange" + "\".",
					randomAttackRange, attackRange.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + speedObject.getClass().getSimpleName()
							+ "\" should not change \"" + "appliedEffects" + "\".",
					empty, appliedEffects.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + speedObject.getClass().getSimpleName()
							+ "\" should not change \"" + "condition" + "\".",
					Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ACTIVE"), condition.get(championObject));

			assertEquals("The method \"" + "apply" + "\" in class \"" + speedObject.getClass().getSimpleName()
					+ "\" should not change \"" + "location" + "\".", null, location.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + speedObject.getClass().getSimpleName()
							+ "\" should not change \"" + "currentHP" + "\".",
					randomMaxHP, currentHP.get(championObject));
			assertEquals("The method \"" + "apply" + "\" in class \"" + speedObject.getClass().getSimpleName()
					+ "\" should not change \"" + "mana" + "\".", randomMana, mana.get(championObject));
			assertEquals("The method \"" + "apply" + "\" in class \"" + speedObject.getClass().getSimpleName()
					+ "\" should not change \"" + "abilities" + "\".", empty, abilities.get(championObject));
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + speedObject.getClass().getSimpleName()
							+ "\" should not change \"" + "attackDamage" + "\".",
					randomAttackDamage, attackDamage.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"SpeedUp\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"SpeedUp\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void applyLogicStunNoChange() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorStun;
		int randomMaxHP = (int) (Math.random() * 1000) + 100;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 1000) + 100;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 100) + 20;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 1000) + 100;
		int duration = (int) (Math.random() * 10) + 1;

		try {

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorStun = Class.forName(stunPath).getConstructor(int.class);
			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object stunObject = constructorStun.newInstance(duration);

			ArrayList<Object> empty = new ArrayList<>();

			Method apply = Class.forName(stunPath).getDeclaredMethod("apply", Class.forName(championPath));
			apply.invoke(stunObject, championObject);
			Class<?> curr = Class.forName(championPath);

			Field max = curr.getDeclaredField("maxHP");
			Field name = curr.getDeclaredField("name");
			Field maxActionPointsPerTurn = curr.getDeclaredField("maxActionPointsPerTurn");
			Field currentActionPoints = curr.getDeclaredField("currentActionPoints");
			Field attackRange = curr.getDeclaredField("attackRange");
			Field abilities = curr.getDeclaredField("abilities");
			Field appliedEffects = curr.getDeclaredField("appliedEffects");
			Field condition = curr.getDeclaredField("condition");
			Field location = curr.getDeclaredField("location");
			Field currentHP = curr.getDeclaredField("currentHP");
			Field mana = curr.getDeclaredField("mana");
			Field speed = curr.getDeclaredField("speed");
			Field attackDamage = curr.getDeclaredField("attackDamage");

			max.setAccessible(true);
			name.setAccessible(true);
			maxActionPointsPerTurn.setAccessible(true);
			currentActionPoints.setAccessible(true);
			attackRange.setAccessible(true);
			appliedEffects.setAccessible(true);
			condition.setAccessible(true);
			location.setAccessible(true);
			currentHP.setAccessible(true);
			mana.setAccessible(true);
			speed.setAccessible(true);
			attackDamage.setAccessible(true);
			abilities.setAccessible(true);

			assertEquals("The method \"" + "apply" + "\" in class \"" + stunObject.getClass().getSimpleName()
					+ "\" should not change \"" + "maxHP" + "\".", randomMaxHP, max.get(championObject));
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + stunObject.getClass().getSimpleName()
							+ "\" should not change \"" + "name" + "\".",
					"Name_" + randomName, name.get(championObject));

			assertEquals("The method \"" + "apply" + "\" in class \"" + stunObject.getClass().getSimpleName()
					+ "\" should not change \"" + "speed" + "\".", randomSpeed, speed.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + stunObject.getClass().getSimpleName()
							+ "\" should not change \"" + "maxActionPointsPerTurn" + "\".",
					randomActions, maxActionPointsPerTurn.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + stunObject.getClass().getSimpleName()
							+ "\" should not change \"" + "currentActionPoints" + "\".",
					randomActions, currentActionPoints.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + stunObject.getClass().getSimpleName()
							+ "\" should not change \"" + "attackRange" + "\".",
					randomAttackRange, attackRange.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + stunObject.getClass().getSimpleName()
							+ "\" should not change \"" + "appliedEffects" + "\".",
					empty, appliedEffects.get(championObject));

			assertEquals("The method \"" + "apply" + "\" in class \"" + stunObject.getClass().getSimpleName()
					+ "\" should not change \"" + "location" + "\".", null, location.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + stunObject.getClass().getSimpleName()
							+ "\" should not change \"" + "currentHP" + "\".",
					randomMaxHP, currentHP.get(championObject));
			assertEquals("The method \"" + "apply" + "\" in class \"" + stunObject.getClass().getSimpleName()
					+ "\" should not change \"" + "mana" + "\".", randomMana, mana.get(championObject));
			assertEquals("The method \"" + "apply" + "\" in class \"" + stunObject.getClass().getSimpleName()
					+ "\" should not change \"" + "abilities" + "\".", empty, abilities.get(championObject));
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + stunObject.getClass().getSimpleName()
							+ "\" should not change \"" + "attackDamage" + "\".",
					randomAttackDamage, attackDamage.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Stun\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Stun\" must implement the inherited abstract method Effect.apply(Champion).", false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void applyLogicEmbraceMana() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorEmbrace;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = 100;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;

		Field f = null;

		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorEmbrace = Class.forName(embracePath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object embraceObject = constructorEmbrace.newInstance(duration);
			Method apply = Class.forName(embracePath).getDeclaredMethod("apply", Class.forName(championPath));
			apply.invoke(embraceObject, championObject);
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("mana");
			f.setAccessible(true);

			int expectedValue1 = (int) (randomMana * 1.2);
			int expectedValue2 = (int) (randomMana + randomMana * 0.2);

			boolean flag = true;
			if (!(expectedValue1 == (int) f.get(championObject) || expectedValue2 == (int) f.get(championObject))) {
				flag = false;
			}

			assertTrue("The method \"" + "apply" + "\" in class " + embraceObject.getClass().getSimpleName()
					+ " should set the correct value of variable \"" + "mana" + "\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InstantiationException e) {

			assertTrue("Objects of type \"Embrace\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Embrace\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void removeLogicEmbraceMana() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorEmbrace;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = 120;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		Object expectedValue = 120;
		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorEmbrace = Class.forName(embracePath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object embraceObject = constructorEmbrace.newInstance(duration);
			Method remove = Class.forName(embracePath).getDeclaredMethod("remove", Class.forName(championPath));

			Class<?> curr = Class.forName(championPath);

			f = curr.getDeclaredField("mana");
			f.setAccessible(true);

			remove.invoke(embraceObject, championObject);
			assertEquals(
					"The method \"" + "remove" + "\" in class \"" + embraceObject.getClass().getSimpleName()
							+ "\" should not remove the \"Embrace\" effect from\"" + "mana" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Embrace\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Embrace\" must implement the inherited abstract method Effect.remove(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void removeLogicEmbraceSpeed() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorEmbrace;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = 120;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		Object expectedValue = 100;

		Field f = null;
		try {

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			constructorEmbrace = Class.forName(embracePath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object embraceObject = constructorEmbrace.newInstance(duration);
			Method remove = Class.forName(embracePath).getDeclaredMethod("remove", Class.forName(championPath));
			Class<?> curr = Class.forName(championPath);

			f = curr.getDeclaredField("speed");
			f.setAccessible(true);

			remove.invoke(embraceObject, championObject);
			assertEquals(
					"The method \"" + "remove" + "\" in class " + embraceObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "speed" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Embrace\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Embrace\" must implement the inherited abstract method Effect.remove(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void applyLogicEmbraceAttackDamage() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorEmbrace;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = 100;
		int duration = (int) (Math.random() * 10) + 1;
		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorEmbrace = Class.forName(embracePath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object embraceObject = constructorEmbrace.newInstance(duration);
			Method apply = Class.forName(embracePath).getDeclaredMethod("apply", Class.forName(championPath));
			apply.invoke(embraceObject, championObject);
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("attackDamage");
			f.setAccessible(true);

			int expectedValue1 = (int) (randomAttackDamage * 1.2);
			int expectedValue2 = (int) (randomAttackDamage + randomAttackDamage * 0.2);

			boolean flag = true;
			if (!(expectedValue1 == (int) f.get(championObject) || expectedValue2 == (int) f.get(championObject))) {
				flag = false;
			}

			assertTrue("The method \"" + "apply" + "\" in class " + embraceObject.getClass().getSimpleName()
					+ " should set the correct value of variable \"" + "attackDamage" + "\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();

		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Embrace\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Embrace\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void removeLogicEmbraceAttackDamage() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorEmbrace;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 100) + 20;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = 120;
		int duration = (int) (Math.random() * 10) + 1;
		Object expectedValue = 100;

		Field f = null;
		try {

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorEmbrace = Class.forName(embracePath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object embraceObject = constructorEmbrace.newInstance(duration);
			Method remove = Class.forName(embracePath).getDeclaredMethod("remove", Class.forName(championPath));
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("attackDamage");
			f.setAccessible(true);
			remove.invoke(embraceObject, championObject);
			assertEquals(
					"The method \"" + "remove" + "\" in class " + embraceObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "attackDamage" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Embrace\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Embrace\" must implement the inherited abstract method Effect.remove(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void applyLogicEmbraceCurrentHP() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorEmbrace;
		int randomMaxHP = 100;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		int randomCurrentHP = 10;
		Object expectedValue = 30;
		Field f = null;
		try {

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorEmbrace = Class.forName(embracePath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object embraceObject = constructorEmbrace.newInstance(duration);
			Method apply = Class.forName(embracePath).getDeclaredMethod("apply", Class.forName(championPath));
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("currentHP");
			f.setAccessible(true);
			f.set(championObject, randomCurrentHP);
			apply.invoke(embraceObject, championObject);
			assertEquals(
					"The method \"" + "apply" + "\" in class " + embraceObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "currentHP" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Embrace\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Embrace\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void removeLogicEmbraceCurrentHp() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorEmbrace;
		int randomMaxHP = (int) (Math.random() * 1000) + 200;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		int randomCurrentHP = (int) (Math.random() * 100) + 20;
		int afterApply = (int) (randomCurrentHP + (0.2 * randomCurrentHP));
		Object expectedValue = afterApply;
		Field f = null;
		try {

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorEmbrace = Class.forName(embracePath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object embraceObject = constructorEmbrace.newInstance(duration);
			Method remove = Class.forName(embracePath).getDeclaredMethod("remove", Class.forName(championPath));
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("currentHP");
			f.setAccessible(true);
			f.set(championObject, afterApply);
			remove.invoke(embraceObject, championObject);
			assertEquals(
					"The method \"" + "remove" + "\" in class \"" + embraceObject.getClass().getSimpleName()
							+ "\" should not remove the \"Embrace\" effect from\"" + "currentHP" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Embrace\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Embrace\" must implement the inherited abstract method Effect.remove(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void applyLogicSpeedUpActions() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorSpeedUP;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		Object expectedValue = (randomActions + 1);
		Field f = null;
		try {

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			constructorSpeedUP = Class.forName(speedUpPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object speedUPObject = constructorSpeedUP.newInstance(duration);
			Method apply = Class.forName(speedUpPath).getDeclaredMethod("apply", Class.forName(championPath));

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("currentActionPoints");
			f.setAccessible(true);
			f.set(championObject, randomActions);
			apply.invoke(speedUPObject, championObject);
			assertEquals(
					"The method \"" + "apply" + "\" in class " + speedUPObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "currentActionPoints" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"SpeedUp\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"SpeedUp\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void applyLogicSpeedUpMaxActions() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorSpeedUP;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		Math.random();
		Object expectedValue = (randomMaxActions + 1);
		Field f = null;
		try {

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			constructorSpeedUP = Class.forName(speedUpPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object speedUPObject = constructorSpeedUP.newInstance(duration);
			Method apply = Class.forName(speedUpPath).getDeclaredMethod("apply", Class.forName(championPath));

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("maxActionPointsPerTurn");
			f.setAccessible(true);
			apply.invoke(speedUPObject, championObject);
			assertEquals(
					"The method \"" + "apply" + "\" in class " + speedUPObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "maxActionPointsPerTurn" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"SpeedUp\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"SpeedUp\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void removeLogicSpeedUpMaxActions() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorSpeedUP;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 1000) + 200;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		Math.random();
		int afterApply = (randomMaxActions + 1);
		Object expectedValue = (afterApply - 1);
		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			constructorSpeedUP = Class.forName(speedUpPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object speedUPObject = constructorSpeedUP.newInstance(duration);
			Method remove = Class.forName(speedUpPath).getDeclaredMethod("remove", Class.forName(championPath));

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("maxActionPointsPerTurn");
			f.setAccessible(true);
			f.set(championObject, afterApply);
			remove.invoke(speedUPObject, championObject);
			assertEquals(
					"The method \"" + "remove" + "\" in class " + speedUPObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "maxActionPointsPerTurn" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"SpeedUp\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"SpeedUp\" must implement the inherited abstract method Effect.remove(Champion)",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void applyLogicSpeedUpSpeed() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorSpeedUp;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = 100;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		int expectedValue1 = (int) (randomSpeed * 1.15);
		int expectedValue2 = (int) (randomSpeed + randomSpeed * 0.15);
		Field f = null;
		try {

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorSpeedUp = Class.forName(speedUpPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object speedUPObject = constructorSpeedUp.newInstance(duration);
			Method apply = Class.forName(speedUpPath).getDeclaredMethod("apply", Class.forName(championPath));
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("speed");
			f.setAccessible(true);
			apply.invoke(speedUPObject, championObject);
			boolean flag = true;
			if (!((int) f.get(championObject) == expectedValue1 || (int) f.get(championObject) == expectedValue2)) {
				flag = false;
			}
			assertTrue("The method \"" + "apply" + "\" in class " + speedUPObject.getClass().getSimpleName()
					+ " should set the correct value of variable \"" + "speed" + "\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"SpeedUp\" can be instantiated", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"SpeedUp\" must implement the inherited abstract method Effect.apply(Champion)",
					false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void removeLogicSpeedUpSpeed() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorSpeedUp;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = 115;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		Object expectedValue = 100;
		Field f = null;
		try {

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorSpeedUp = Class.forName(speedUpPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object speedUPObject = constructorSpeedUp.newInstance(duration);
			Method remove = Class.forName(speedUpPath).getDeclaredMethod("remove", Class.forName(championPath));

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("speed");
			f.setAccessible(true);

			remove.invoke(speedUPObject, championObject);
			assertEquals(
					"The method \"" + "remove" + "\" in class " + speedUPObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "speed" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"SpeedUp\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"SpeedUp\" must implement the inherited abstract method Effect.remove(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void applyLogicShockSpeed() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorShock;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = 100;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		Field f = null;
		try {

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));

			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorShock = Class.forName(shockPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object shockObject = constructorShock.newInstance(duration);
			Method apply = Class.forName(shockPath).getDeclaredMethod("apply", Class.forName(championPath));
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("speed");
			f.setAccessible(true);
			apply.invoke(shockObject, championObject);

			int expectedValue1 = (int) (randomSpeed * 0.9);
			int expectedValue2 = (int) (randomSpeed - randomSpeed * 0.1);

			boolean flag = true;
			if (!(expectedValue1 == (int) f.get(championObject) || expectedValue2 == (int) f.get(championObject))) {
				flag = false;
			}

			assertTrue("The method \"" + "apply" + "\" in class " + shockObject.getClass().getSimpleName()
					+ " should set the correct value of variable \"" + "speed" + "\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Shock\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Shock\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}
	}

	@Test(timeout = 3000)
	public void removeLogicShockSpeed() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorShock;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = 90;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		Object expectedValue = 100;
		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			constructorShock = Class.forName(shockPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object shockObject = constructorShock.newInstance(duration);
			Method remove = Class.forName(shockPath).getDeclaredMethod("remove", Class.forName(championPath));
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("speed");
			f.setAccessible(true);
			remove.invoke(shockObject, championObject);
			assertEquals(
					"The method \"" + "remove" + "\" in class " + shockObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "speed" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Shock\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Shock\" must implement the inherited abstract method Effect.remove(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}
	}

	@Test(timeout = 3000)
	public void applyLogicShockAttackDamage() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorShock;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = 100;
		int duration = (int) (Math.random() * 10) + 1;
		Field f = null;
		try {

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorShock = Class.forName(shockPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object shockObject = constructorShock.newInstance(duration);
			Method apply = Class.forName(shockPath).getDeclaredMethod("apply", Class.forName(championPath));
			apply.invoke(shockObject, championObject);
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("attackDamage");
			f.setAccessible(true);

			int expectedValue1 = (int) (randomAttackDamage * 0.9);
			int expectedValue2 = (int) (randomAttackDamage - randomAttackDamage * 0.1);

			boolean flag = true;
			if (!(expectedValue1 == (int) f.get(championObject) || expectedValue2 == (int) f.get(championObject))) {
				flag = false;
			}

			assertTrue("The method \"" + "apply" + "\" in class " + shockObject.getClass().getSimpleName()
					+ " should set the correct value of variable \"" + "attackDamage" + "\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Shock\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Shock\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void removeLogicShockAttackDamage() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorShock;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = 90;
		int duration = (int) (Math.random() * 10) + 1;
		Object expectedValue = 100;
		Field f = null;
		try {

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			constructorShock = Class.forName(shockPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object shockObject = constructorShock.newInstance(duration);
			Method remove = Class.forName(shockPath).getDeclaredMethod("remove", Class.forName(championPath));
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("attackDamage");
			f.setAccessible(true);
			remove.invoke(shockObject, championObject);
			assertEquals(
					"The method \"" + "remove" + "\" in class " + shockObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "attackDamage" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Shock\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {

			assertTrue("The type \"Shock\" must implement the inherited abstract method Effect.remove(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void applyLogicShockActions() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorShock;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		Object expectedValue = (randomActions - 1);
		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorShock = Class.forName(shockPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object shockObject = constructorShock.newInstance(duration);
			Method apply = Class.forName(shockPath).getDeclaredMethod("apply", Class.forName(championPath));

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("currentActionPoints");
			f.setAccessible(true);
			f.set(championObject, randomActions);
			apply.invoke(shockObject, championObject);
			assertEquals(
					"The method \"" + "apply" + "\" in class " + shockObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "currentActionPoints" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Shock\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Shock\" must implement the inherited abstract method Effect.apply(Champion).",
					false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void applyLogicShockMaxActions() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorShock;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		Math.random();
		Object expectedValue = (randomMaxActions - 1);
		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorShock = Class.forName(shockPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object shockObject = constructorShock.newInstance(duration);
			Method apply = Class.forName(shockPath).getDeclaredMethod("apply", Class.forName(championPath));

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("maxActionPointsPerTurn");
			f.setAccessible(true);
			apply.invoke(shockObject, championObject);
			assertEquals(
					"The method \"" + "apply" + "\" in class " + shockObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "maxActionPointsPerTurn" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Shock\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Shock\" must implement the inherited abstract method Effect.apply(Champion).",
					false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void removeLogicShockActions() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorShock;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int afterApply = (randomActions - 1);
		Object expectedValue = (afterApply + 1);
		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorShock = Class.forName(shockPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object shockObject = constructorShock.newInstance(duration);
			Method remove = Class.forName(shockPath).getDeclaredMethod("remove", Class.forName(championPath));
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("currentActionPoints");
			f.setAccessible(true);
			f.set(championObject, afterApply);
			remove.invoke(shockObject, championObject);
			assertEquals(
					"The method \"" + "remove" + "\" in class " + shockObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "currentActionPoints" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Shock\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Shock\" must implement the inherited abstract method Effect.remove(Champion).",
					false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void removeLogicShockMaxActions() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorShock;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		Math.random();
		int afterApply = (randomMaxActions - 1);
		Object expectedValue = (afterApply + 1);
		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorShock = Class.forName(shockPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object shockObject = constructorShock.newInstance(duration);
			Method remove = Class.forName(shockPath).getDeclaredMethod("remove", Class.forName(championPath));
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("maxActionPointsPerTurn");
			f.setAccessible(true);
			f.set(championObject, afterApply);
			remove.invoke(shockObject, championObject);
			assertEquals(
					"The method \"" + "remove" + "\" in class " + shockObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "maxActionPointsPerTurn" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Shock\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Shock\" must implement the inherited abstract method Effect.remove(Champion).",
					false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicStunCondition() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorStun;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;

		Field f = null;
		try {

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorStun = Class.forName(stunPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object stunObject = constructorStun.newInstance(duration);
			Method apply = Class.forName(stunPath).getDeclaredMethod("apply", Class.forName(championPath));
			Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE");
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("condition");
			f.setAccessible(true);
			f.set(championObject, Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ROOTED"));
			apply.invoke(stunObject, championObject);
			assertEquals(
					"The method \"" + "apply" + "\" in class " + stunObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "condition" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Stun\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Stun\" must implement the inherited abstract method Effect.apply(Champion).", false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void removeLogicStunCondition() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorStun;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;

		Field f = null;
		try {

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorStun = Class.forName(stunPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object stunObject = constructorStun.newInstance(duration);
			Method remove = Class.forName(stunPath).getDeclaredMethod("remove", Class.forName(championPath));
			Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ACTIVE");
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("condition");
			f.setAccessible(true);
			f.set(championObject, Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE"));
			remove.invoke(stunObject, championObject);
			assertEquals(
					"The method \"" + "remove" + "\" in class " + stunObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "condition" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Stun\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Stun\" must implement the inherited abstract method Effect.remove(Champion).",
					false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void removeLogicStunConditionRoot() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorStun;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;

		Field f = null;
		try {

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorStun = Class.forName(stunPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Constructor<?> constructorRoot = Class.forName(rootPath).getConstructor(int.class);

			Object rootObject = constructorRoot.newInstance(duration);
			ArrayList<Object> effect = new ArrayList<>();
			effect.add(rootObject);

			Object stunObject = constructorStun.newInstance(duration);
			Method remove = Class.forName(stunPath).getDeclaredMethod("remove", Class.forName(championPath));
			Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ROOTED");
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("condition");
			f.setAccessible(true);

			f.set(championObject, Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ROOTED"));

			Field ff = curr.getDeclaredField("appliedEffects");
			ff.setAccessible(true);
			ff.set(championObject, effect);

			remove.invoke(stunObject, championObject);
			assertEquals(
					"The method \"" + "remove" + "\" in class " + stunObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "condition" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Stun\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Stun\" must implement the inherited abstract method Effect.remove(Champion).",
					false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicShieldBlockDmgAbilityDirectional() {
		String champInstance;
		try {

			Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
			Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
			int randomName1 = (int) (Math.random() * 10) + 1;
			int randomName2 = (int) (Math.random() * 10) + 1;
			Object firstPlayer = null;
			Object secondPlayer = null;
			try {
				firstPlayer = constructorFirstPlayer.newInstance("Name_" + randomName1);
				secondPlayer = constructorSecondPlayer.newInstance("Name_" + randomName2);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of \"Player\".", false);
			}

			Constructor<?> gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
					Class.forName(playerPath));
			Object createdGame = null;
			try {
				createdGame = gameConstructor.newInstance(firstPlayer, secondPlayer);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of \"Game\".", false);
			}

			ArrayList<Object> firstPlayerChamp1 = new ArrayList<>();
			ArrayList<Object> secPlayerChamp1 = new ArrayList<>();

			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;
			Constructor<?> constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class,
					int.class, int.class, int.class, int.class, int.class);
			Object champPlayer1 = null;

			try {
				try {
					champPlayer1 = constructorChampion.newInstance("ironman", 1, 5, 3, 5, 2, 6);
				} catch (InvocationTargetException e) {
					assertTrue(e.getCause() + " occurred while creating an instance of \""
							+ Class.forName(champInstance).getSimpleName() + "\".", false);
				}
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object champPlayer2 = null;

			try {
				champPlayer2 = constructorChampion.newInstance("loki", 100, 5, 3, 4, 5, 6);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \""
						+ Class.forName(champInstance).getSimpleName() + "\".", false);
			}

			Class<?> cham1 = Class.forName(championPath);
			Field location = cham1.getDeclaredField("location");
			location.setAccessible(true);
			Point p1 = new Point(2, 2);
			location.set(champPlayer1, p1);
			firstPlayerChamp1.add(champPlayer1);
			Class<?> curr = firstPlayer.getClass();
			Field f = curr.getDeclaredField("team");
			f.setAccessible(true);
			f.set(firstPlayer, firstPlayerChamp1);

			Class<?> cham2 = Class.forName(championPath);
			Field location2 = cham2.getDeclaredField("location");
			location2.setAccessible(true);
			Point p2 = new Point(2, 3);
			location.set(champPlayer2, p2);
			secPlayerChamp1.add(champPlayer2);

			curr = secondPlayer.getClass();
			f = curr.getDeclaredField("team");
			f.setAccessible(true);
			f.set(secondPlayer, secPlayerChamp1);
			Method getBoardGame = createdGame.getClass().getMethod("getBoard");
			Object[][] boardGame = null;
			try {
				boardGame = (Object[][]) getBoardGame.invoke(createdGame);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while invoking \"getBoard\" method on an instance of \"Game\".",
						false);

			}

			boardGame[2][2] = champPlayer1;

			boardGame[2][3] = champPlayer2;

			Field board = createdGame.getClass().getDeclaredField("board");
			board.setAccessible(true);
			board.set(createdGame, boardGame);

			Constructor<?> constructorShield = Class.forName(shieldPath).getConstructor(int.class);
			Object shield = null;
			try {
				shield = constructorShield.newInstance((int) (Math.random() * 10) + 1);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"Shield\" can be instantiated.", false);

			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \"Shield\".", false);

			}

			Field queue = Class.forName(gamePath).getDeclaredField("turnOrder");
			queue.setAccessible(true);
			Constructor<?> pQueueConst = Class.forName(priorityQueuePath).getConstructor(int.class);

			Object pQueue = null;
			try {
				pQueue = pQueueConst.newInstance(6);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \"PriorityQueue\".", false);

			}
			Method insert = Class.forName(priorityQueuePath).getDeclaredMethod("insert", Comparable.class);
			try {
				insert.invoke(pQueue, champPlayer1);
				insert.invoke(pQueue, champPlayer2);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"insert\" method on an instance of \"PriorityQueue\".",
						false);

			} catch (IllegalArgumentException e) {
				fail("\"insert\" in \"PriorityQueue\" class takes a \"Comparable\" object.");
			}

			queue.set(createdGame, pQueue);

			Method peek = Class.forName(priorityQueuePath).getDeclaredMethod("peekMin");
			Object target = null;
			try {
				target = peek.invoke(pQueue);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"peekMin\" method on an instance of \"PriorityQueue\".",
						false);

			}
			Method remove = Class.forName(priorityQueuePath).getDeclaredMethod("remove");
			Object enemy = null;
			try {
				remove.invoke(pQueue);
				enemy = remove.invoke(pQueue);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"remove\" method on an instance of \"PriorityQueue\".",
						false);

			}

			if (enemy.getClass().equals(Class.forName(antiHeroPath))
					|| (enemy.getClass().equals(Class.forName(heroPath)))
					|| (enemy.getClass().equals(Class.forName(villainPath)))) {
				Class<?> enemyEffect = Class.forName(championPath);
				Field appliedEffects = enemyEffect.getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				((ArrayList<Object>) appliedEffects.get(enemy)).add(shield);

			}

			Constructor<?> constructorDamagingAbility = Class.forName(dmgPath).getConstructor(String.class, int.class,
					int.class, int.class, Class.forName(areaOfEffectPath), int.class, int.class);
			Object damagingAbilityObject = null;
			try {
				damagingAbilityObject = constructorDamagingAbility.newInstance("Punch", 0, 1, 1,
						Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "DIRECTIONAL"), 1, 50);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of \"DamagingAbility\".", false);

			}

			if (target.getClass().equals(Class.forName(antiHeroPath))
					|| (target.getClass().equals(Class.forName(heroPath)))
					|| (target.getClass().equals(Class.forName(villainPath)))) {
				Class<?> enemyEffect = Class.forName(championPath);
				Field abilities = enemyEffect.getDeclaredField("abilities");
				abilities.setAccessible(true);
				((ArrayList<Object>) abilities.get(target)).add(damagingAbilityObject);

			}

			try {
				insert.invoke(pQueue, target);
				insert.invoke(pQueue, enemy);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"insert\" method on an instance of \"PriorityQueue\".",
						false);

			}

			Method m3 = createdGame.getClass().getMethod("castAbility", Class.forName(abilitiesPath),
					Class.forName(directionPath));

			Field locationTarget = Class.forName(championPath).getDeclaredField("location");
			locationTarget.setAccessible(true);
			Point locationT = (Point) locationTarget.get(target);

			Method m5 = target.getClass().getMethod("getCurrentHP");
			int before = 0;
			try {
				before = (Integer) m5.invoke(enemy);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while invoking \"getCurrentHP\" method on an instance of \""
						+ enemy.getClass().getSimpleName() + "\".", false);

			}
			try {
				if (locationT.y == 3) {
					m3.invoke(createdGame, damagingAbilityObject,
							Enum.valueOf((Class<Enum>) Class.forName(directionPath), "LEFT"));

				} else {
					m3.invoke(createdGame, damagingAbilityObject,
							Enum.valueOf((Class<Enum>) Class.forName(directionPath), "RIGHT"));
				}
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while invoking \"castAbility\" method on an instance of \"Game\".",
						false);

			}

			int after = 0;
			try {
				after = (Integer) m5.invoke(enemy);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while invoking \"getCurrentHP\" method on an instance of \""
						+ enemy.getClass().getSimpleName() + "\".", false);

			}

			assertEquals("The method \"" + "castAbility" + "\" in class " + createdGame.getClass().getSimpleName()
					+ " should set the correct value of variable \"" + "currentHP"
					+ "\". When a champion has a \"Shield\" effect, he should block the casted \"DamagingAbility\".",
					before, after);
		} catch (InstantiationException e) {
			assertTrue(e.getClass().getName() + " occurred.", false);
		}

		catch (NoSuchMethodException e) {

			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		}

		catch (ClassNotFoundException e) {

			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

		}

	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void applyLogicPowerUpDamageAmount() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorPowerUp;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		ArrayList<Object> champAbilities = new ArrayList<>();
		Field f = null;
		try {

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorPowerUp = Class.forName(powerUpPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException | InvocationTargetException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object powerUpObject = null;
			try {
				powerUpObject = constructorPowerUp.newInstance(duration);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of class PowerUp.", false);

			}
			int randomInstancesDamaging = (int) (Math.random() * 5) + 1;
			int randomInstancesHealing = (int) (Math.random() * 5) + 1;

			for (int i = 0; i < randomInstancesHealing; i++) {
				Object healingAbilityObject = createHealingAbilityInstance();
				champAbilities.add(healingAbilityObject);
			}
			for (int i = 0; i < randomInstancesDamaging; i++) {
				Object damagingAbilityObject = createDamagingAbilityInstance();
				champAbilities.add(damagingAbilityObject);
			}

			Method apply = Class.forName(powerUpPath).getDeclaredMethod("apply", Class.forName(championPath));
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("abilities");
			f.setAccessible(true);
			f.set(championObject, champAbilities);
			ArrayList<Object> expectedValue = new ArrayList<>();
			ArrayList<Object> actual = new ArrayList<>();

			for (int i = 0; i < champAbilities.size(); i++) {
				if (champAbilities.get(i).getClass().equals(Class.forName(dmgPath))) {
					Field dmg = Class.forName(dmgPath).getDeclaredField("damageAmount");
					dmg.setAccessible(true);
					dmg.get(champAbilities.get(i));
					expectedValue.add(120);

				}
			}

			try {
				apply.invoke(powerUpObject, championObject);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while invoking the method apply on an instance of class PowerUp.",
						false);

			}
			ArrayList<Object> returnedChamp = (ArrayList<Object>) f.get(championObject);
			for (int i = 0; i < returnedChamp.size(); i++) {
				if (returnedChamp.get(i).getClass().equals(Class.forName(dmgPath))) {
					Field dmg = Class.forName(dmgPath).getDeclaredField("damageAmount");
					dmg.setAccessible(true);
					actual.add((int) dmg.get(returnedChamp.get(i)));
				}

			}
			assertEquals(
					"The method \"" + "apply" + "\" in class " + powerUpObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "damageAmount" + "\".",
					expectedValue, actual);
		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InstantiationException e) {

			assertTrue("Objects of type \"PowerUp\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void removeLogicPowerUpDamageAmount() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorPowerUp;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		ArrayList<Object> champAbilities = new ArrayList<>();
		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			constructorPowerUp = Class.forName(powerUpPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException | InvocationTargetException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object powerUpObject = null;
			try {
				powerUpObject = constructorPowerUp.newInstance(duration);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of class PowerUp.", false);
			}
			int randomInstancesDamaging = (int) (Math.random() * 5) + 1;
			int randomInstancesHealing = (int) (Math.random() * 5) + 1;

			for (int i = 0; i < randomInstancesHealing; i++) {
				Object healingAbilityObject = createHealingAbilityInstance();
				champAbilities.add(healingAbilityObject);
			}
			for (int i = 0; i < randomInstancesDamaging; i++) {
				Object damagingAbilityObject = createDamagingAbilityInstance();
				champAbilities.add(damagingAbilityObject);
			}

			Method remove = Class.forName(powerUpPath).getDeclaredMethod("remove", Class.forName(championPath));
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("abilities");
			f.setAccessible(true);
			f.set(championObject, champAbilities);
			ArrayList<Object> expectedValue = new ArrayList<>();
			ArrayList<Object> actual = new ArrayList<>();

			for (int i = 0; i < champAbilities.size(); i++) {
				if (champAbilities.get(i).getClass().equals(Class.forName(dmgPath))) {
					Field dmg = Class.forName(dmgPath).getDeclaredField("damageAmount");
					dmg.setAccessible(true);
					dmg.get(champAbilities.get(i));
					int afterApply = 120;
					dmg.set(champAbilities.get(i), afterApply);
					champAbilities.add(i, champAbilities.get(i));
					champAbilities.remove(i + 1);
					expectedValue.add(100);

				}
			}
			f.set(championObject, champAbilities);

			try {
				remove.invoke(powerUpObject, championObject);
			} catch (InvocationTargetException e) {

				assertTrue(e.getCause() + " occurred while invoking the method remove on an instance of class PowerUp.",
						false);

			}
			ArrayList<Object> returnedChamp = (ArrayList<Object>) f.get(championObject);
			for (int i = 0; i < returnedChamp.size(); i++) {
				if (returnedChamp.get(i).getClass().equals(Class.forName(dmgPath))) {
					Field dmg = Class.forName(dmgPath).getDeclaredField("damageAmount");
					dmg.setAccessible(true);
					actual.add((int) dmg.get(returnedChamp.get(i)));
				}

			}
			assertEquals(
					"The method \"" + "remove" + "\" in class " + powerUpObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "damageAmount" + "\".",
					expectedValue, actual);
		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InstantiationException e) {

			assertTrue("Objects of type \"PowerUp\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void applyLogicPowerUpHealingAmount() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorPowerUp;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		ArrayList<Object> champAbilities = new ArrayList<>();
		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			constructorPowerUp = Class.forName(powerUpPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException | InvocationTargetException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object powerUpObject = null;
			try {
				powerUpObject = constructorPowerUp.newInstance(duration);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of class PowerUp.", false);

			}
			int randomInstancesDamaging = (int) (Math.random() * 5) + 1;
			int randomInstancesHealing = (int) (Math.random() * 5) + 1;

			for (int i = 0; i < randomInstancesHealing; i++) {
				Object healingAbilityObject = createHealingAbilityInstance();
				champAbilities.add(healingAbilityObject);
			}
			for (int i = 0; i < randomInstancesDamaging; i++) {
				Object damagingAbilityObject = createDamagingAbilityInstance();
				champAbilities.add(damagingAbilityObject);
			}

			Method apply = Class.forName(powerUpPath).getDeclaredMethod("apply", Class.forName(championPath));
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("abilities");
			f.setAccessible(true);
			f.set(championObject, champAbilities);
			ArrayList<Object> expectedValue = new ArrayList<>();
			ArrayList<Object> actual = new ArrayList<>();

			for (int i = 0; i < champAbilities.size(); i++) {
				if (champAbilities.get(i).getClass().equals(Class.forName(healingPath))) {
					Field dmg = Class.forName(healingPath).getDeclaredField("healAmount");
					dmg.setAccessible(true);
					dmg.get(champAbilities.get(i));
					expectedValue.add(120);

				}
			}

			try {
				apply.invoke(powerUpObject, championObject);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while invoking the method apply on an instance of class PowerUp.",
						false);

			}
			ArrayList<Object> returnedChamp = (ArrayList<Object>) f.get(championObject);
			for (int i = 0; i < returnedChamp.size(); i++) {
				if (returnedChamp.get(i).getClass().equals(Class.forName(healingPath))) {
					Field dmg = Class.forName(healingPath).getDeclaredField("healAmount");
					dmg.setAccessible(true);
					actual.add((int) dmg.get(returnedChamp.get(i)));
				}

			}

			assertEquals(
					"The method \"" + "apply" + "\" in class " + powerUpObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "healAmount" + "\".",
					expectedValue, actual);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"PowerUp\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void removeLogicPowerUpHealingAmount() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorPowerUp;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		ArrayList<Object> champAbilities = new ArrayList<>();
		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorPowerUp = Class.forName(powerUpPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException | InvocationTargetException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object powerUpObject = null;
			try {
				powerUpObject = constructorPowerUp.newInstance(duration);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of class PowerUp.", false);

			}
			int randomInstancesDamaging = (int) (Math.random() * 5) + 1;
			int randomInstancesHealing = (int) (Math.random() * 5) + 1;

			for (int i = 0; i < randomInstancesHealing; i++) {
				Object healingAbilityObject = createHealingAbilityInstance();
				champAbilities.add(healingAbilityObject);
			}
			for (int i = 0; i < randomInstancesDamaging; i++) {
				Object damagingAbilityObject = createDamagingAbilityInstance();
				champAbilities.add(damagingAbilityObject);
			}

			Method remove = Class.forName(powerUpPath).getDeclaredMethod("remove", Class.forName(championPath));
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("abilities");
			f.setAccessible(true);
			f.set(championObject, champAbilities);
			ArrayList<Object> expectedValue = new ArrayList<>();
			ArrayList<Object> actual = new ArrayList<>();

			for (int i = 0; i < champAbilities.size(); i++) {
				if (champAbilities.get(i).getClass().equals(Class.forName(healingPath))) {
					Field dmg = Class.forName(healingPath).getDeclaredField("healAmount");
					dmg.setAccessible(true);
					dmg.get(champAbilities.get(i));
					int afterApply = 120;
					dmg.set(champAbilities.get(i), afterApply);
					champAbilities.add(i, champAbilities.get(i));
					champAbilities.remove(i + 1);
					expectedValue.add(100);

				}
			}
			f.set(championObject, champAbilities);

			try {
				remove.invoke(powerUpObject, championObject);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while invoking the method remove on an instance of class PowerUp.",
						false);

			}
			ArrayList<Object> returnedChamp = (ArrayList<Object>) f.get(championObject);
			for (int i = 0; i < returnedChamp.size(); i++) {
				if (returnedChamp.get(i).getClass().equals(Class.forName(healingPath))) {
					Field dmg = Class.forName(healingPath).getDeclaredField("healAmount");
					dmg.setAccessible(true);
					actual.add((int) dmg.get(returnedChamp.get(i)));
				}

			}
			assertEquals(
					"The method \"" + "remove" + "\" in class " + powerUpObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "healAmount" + "\".",
					expectedValue, actual);
		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"PowerUp\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicDisarmAttacks() {
		String champInstance;
		try {

			Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
			Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
			int randomName1 = (int) (Math.random() * 10) + 1;
			int randomName2 = (int) (Math.random() * 10) + 1;
			Object firstPlayer = null;
			Object secondPlayer = null;
			try {
				firstPlayer = constructorFirstPlayer.newInstance("Name_" + randomName1);
				secondPlayer = constructorSecondPlayer.newInstance("Name_" + randomName2);
			} catch (InvocationTargetException | InstantiationException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of \"Player\".", false);

			}

			Constructor<?> gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
					Class.forName(playerPath));
			Object createdGame = null;
			try {
				createdGame = gameConstructor.newInstance(firstPlayer, secondPlayer);
			} catch (InstantiationException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of \"Game\".", false);

			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of \"Game\".", false);

			}

			ArrayList<Object> firstPlayerChamp1 = new ArrayList<>();
			ArrayList<Object> secPlayerChamp1 = new ArrayList<>();

			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;
			Constructor<?> constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class,
					int.class, int.class, int.class, int.class, int.class);

			Object champPlayer1 = null;

			try {
				try {
					champPlayer1 = constructorChampion.newInstance("ironman", 1, 2, 3, 5, 2, 6);
				} catch (InvocationTargetException e) {
					assertTrue(e.getCause() + " occurred while creating an instance of \""
							+ Class.forName(champInstance).getSimpleName() + "\".", false);

				}
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object champPlayer2 = null;

			try {
				try {
					champPlayer2 = constructorChampion.newInstance("loki", 100, 2, 3, 4, 5, 6);
				} catch (InvocationTargetException e) {
					assertTrue(e.getCause() + " occurred while creating an instance of \""
							+ Class.forName(champInstance).getSimpleName() + "\".", false);

				}
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Class<?> cham1 = Class.forName(championPath);
			Field location = cham1.getDeclaredField("location");
			location.setAccessible(true);
			Point p1 = new Point(2, 2);
			location.set(champPlayer1, p1);
			firstPlayerChamp1.add(champPlayer1);
			Class<?> curr = firstPlayer.getClass();
			Field f = curr.getDeclaredField("team");
			f.setAccessible(true);
			f.set(firstPlayer, firstPlayerChamp1);

			Class<?> cham2 = Class.forName(championPath);
			Field location2 = cham2.getDeclaredField("location");
			location2.setAccessible(true);
			Point p2 = new Point(2, 3);
			location.set(champPlayer2, p2);
			secPlayerChamp1.add(champPlayer2);

			curr = secondPlayer.getClass();
			f = curr.getDeclaredField("team");
			f.setAccessible(true);
			f.set(secondPlayer, secPlayerChamp1);

			Method getBoardGame = createdGame.getClass().getMethod("getBoard");
			Object[][] boardGame = null;
			try {
				boardGame = (Object[][]) getBoardGame.invoke(createdGame);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while invoking method \"getBoard\" on an instance of \"Game\".",
						false);

			}

			boardGame[2][2] = champPlayer1;

			boardGame[2][3] = champPlayer2;

			Field board = createdGame.getClass().getDeclaredField("board");
			board.setAccessible(true);
			board.set(createdGame, boardGame);

			Constructor<?> constructorDisarm = Class.forName(disarmPath).getConstructor(int.class);

			Object disarm = null;
			try {
				disarm = constructorDisarm.newInstance((int) (Math.random() * 10) + 1);
			} catch (InstantiationException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \"Disarm\".", false);

			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \"Disarm\".", false);

			}

			Field queue = Class.forName(gamePath).getDeclaredField("turnOrder");
			queue.setAccessible(true);
			Constructor<?> pQueueConst = Class.forName(priorityQueuePath).getConstructor(int.class);

			Object pQueue = null;
			try {
				pQueue = pQueueConst.newInstance(6);
			} catch (InstantiationException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \"PriorityQueue\".", false);

			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \"PriorityQueue\".", false);

			}
			Method insert = Class.forName(priorityQueuePath).getDeclaredMethod("insert", Comparable.class);
			try {
				insert.invoke(pQueue, champPlayer1);
				insert.invoke(pQueue, champPlayer2);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking method \"insert\" on an instance of \"PriorityQueue\".",
						false);

			} catch (IllegalArgumentException e) {
				fail("\"insert\" in \"PriorityQueue\" class takes a \"Comparable\" object.");
			}

			queue.set(createdGame, pQueue);

			Method peek = Class.forName(priorityQueuePath).getDeclaredMethod("peekMin");
			Object target = null;
			try {
				target = peek.invoke(pQueue);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking method \"peekMin\" on an instance of \"PriorityQueue\".",
						false);

			}
			if (target.getClass().equals(Class.forName(antiHeroPath))
					|| (target.getClass().equals(Class.forName(heroPath)))
					|| (target.getClass().equals(Class.forName(villainPath)))) {
				Class<?> targetEffect = Class.forName(championPath);
				Field appliedEffects = targetEffect.getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				((ArrayList<Object>) appliedEffects.get(target)).add(disarm);
			}

			Method remove = Class.forName(priorityQueuePath).getDeclaredMethod("remove");
			Object enemy = null;
			try {
				remove.invoke(pQueue);
				enemy = remove.invoke(pQueue);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking method \"remove\" on an instance of \"PriorityQueue\".",
						false);

			}

			Method m5 = enemy.getClass().getMethod("getCurrentHP");

			try {
				insert.invoke(pQueue, target);
				insert.invoke(pQueue, enemy);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking method \"insert\" on an instance of \"PriorityQueue\".",
						false);

			}

			Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));

			Field locationTarget = Class.forName(championPath).getDeclaredField("location");
			locationTarget.setAccessible(true);
			Point locationT = (Point) locationTarget.get(target);

			int before = 0;
			try {
				before = (Integer) m5.invoke(enemy);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while invoking method \"getCurrentHP\" on an instance of \""
						+ enemy.getClass().getSimpleName() + "\".", false);

			}
			try {
				if (locationT.y == 3) {
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "LEFT"));
					fail("Method \"attack\" in class \"Game\" should throw the exception called \"java.lang.ChampionDisarmedException\" when the champion is trying to attack while \"Disarmed\".");
				} else {
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "RIGHT"));
					fail("Method \"attack\" in class \"Game\" should throw the exception called \"java.lang.ChampionDisarmedException\" when the champion is trying to attack while \"Disarmed\".");

				}
			} catch (InvocationTargetException e) {
				if (!(Class.forName(ChampionDisarmedException).equals(e.getCause().getClass())))
					assertTrue(e.getCause() + " occurred while invoking method \"attack\" on an instance of \"Game\".",
							false);

			}
			int after = 0;
			try {
				after = (Integer) m5.invoke(enemy);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while invoking method \"getCurrentHP\" on an instance of \""
						+ enemy.getClass().getSimpleName() + "\".", false);

			}

			assertEquals("The method \"" + "attack" + "\" in class " + createdGame.getClass().getSimpleName()
					+ " should set the correct value of variable \"" + "currentHP" + "\".", before, after);

			boolean found = false;
			if (m3.getExceptionTypes().length != 0) {
				for (int i = 0; i < m3.getExceptionTypes().length; i++) {

					if (m3.getExceptionTypes()[i].getSimpleName().equals("ChampionDisarmedException")) {
						found = true;
					}
				}
				assertTrue(
						"Method \"attack\" in class \"Game\" should throw the exception called \"java.lang.ChampionDisarmedException\".",
						found);

			} else {
				assertTrue(
						"Method \"attack\" in class \"Game\" should throw the exception called \"java.lang.ChampionDisarmedException\".",
						false);
			}
		}

		catch (NoSuchMethodException e) {

			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		}

		catch (ClassNotFoundException e) {

			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicDodgeAttack() {
		String champInstance;
		try {

			Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
			Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
			int randomName1 = (int) (Math.random() * 10) + 1;
			int randomName2 = (int) (Math.random() * 10) + 1;
			Object firstPlayer = null;
			Object secondPlayer = null;
			try {
				firstPlayer = constructorFirstPlayer.newInstance("Name_" + randomName1);
				secondPlayer = constructorSecondPlayer.newInstance("Name_" + randomName2);

			} catch (InvocationTargetException e1) {
				assertTrue("Objects of type \"Player\" can be instantiated.", false);

				e1.printStackTrace();
			}
			Constructor<?> gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
					Class.forName(playerPath));
			Object createdGame = null;
			try {
				createdGame = gameConstructor.newInstance(firstPlayer, secondPlayer);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of \"Game\".", false);

				e1.printStackTrace();
			}

			ArrayList<Object> firstPlayerChamp1 = new ArrayList<>();
			ArrayList<Object> secPlayerChamp1 = new ArrayList<>();

			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;
			Constructor<?> constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class,
					int.class, int.class, int.class, int.class, int.class);

			Object champPlayer1 = null;

			try {
				champPlayer1 = constructorChampion.newInstance("ironman", 1, 5, 3, 5, 2, 6);
			} catch (InstantiationException | InvocationTargetException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object champPlayer2 = null;

			try {
				champPlayer2 = constructorChampion.newInstance("loki", 100, 5, 3, 4, 5, 6);
			} catch (InstantiationException | InvocationTargetException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Class<?> cham1 = Class.forName(championPath);
			Field location = cham1.getDeclaredField("location");
			location.setAccessible(true);
			Point p1 = new Point(2, 2);
			location.set(champPlayer1, p1);
			firstPlayerChamp1.add(champPlayer1);
			Class<?> curr = firstPlayer.getClass();
			Field f = curr.getDeclaredField("team");
			f.setAccessible(true);
			f.set(firstPlayer, firstPlayerChamp1);

			Class<?> cham2 = Class.forName(championPath);
			Field location2 = cham2.getDeclaredField("location");
			location2.setAccessible(true);
			Point p2 = new Point(2, 3);
			location.set(champPlayer2, p2);
			secPlayerChamp1.add(champPlayer2);

			curr = secondPlayer.getClass();
			f = curr.getDeclaredField("team");
			f.setAccessible(true);
			f.set(secondPlayer, secPlayerChamp1);
			Method getBoardGame = createdGame.getClass().getMethod("getBoard");
			Object[][] boardGame = null;
			try {
				boardGame = (Object[][]) getBoardGame.invoke(createdGame);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while invoking \"getBoard\" method on an instance of \"Game\".",
						false);

				e1.printStackTrace();
			}

			boardGame[2][2] = champPlayer1;

			boardGame[2][3] = champPlayer2;

			Field board = createdGame.getClass().getDeclaredField("board");
			board.setAccessible(true);
			board.set(createdGame, boardGame);
			Constructor<?> constructorDodge = Class.forName(DodgePath).getConstructor(int.class);

			Object dodge = null;
			try {
				dodge = constructorDodge.newInstance((int) (Math.random() * 10) + 1);
			} catch (InvocationTargetException e) {

				assertTrue("Objects of type \"Dodge\" can be instantiated.", false);

				e.printStackTrace();
			}

			Field queue = Class.forName(gamePath).getDeclaredField("turnOrder");
			queue.setAccessible(true);
			Constructor<?> pQueueConst = Class.forName(priorityQueuePath).getConstructor(int.class);

			Object pQueue = null;
			try {
				pQueue = pQueueConst.newInstance(6);
			} catch (InvocationTargetException e) {
				assertTrue("Objects of type \"PriorityQueue\" can be instantiated.", false);

				e.printStackTrace();
			}
			Method insert = Class.forName(priorityQueuePath).getDeclaredMethod("insert", Comparable.class);
			try {
				insert.invoke(pQueue, champPlayer1);
				insert.invoke(pQueue, champPlayer2);
				queue.set(createdGame, pQueue);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"insert\" method on an instance of \"PriorityQueue\".",
						false);

				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				fail("\"insert\" in \"PriorityQueue\" class takes a \"Comparable\" object.");
			}

			Method peek = Class.forName(priorityQueuePath).getDeclaredMethod("peekMin");
			Object target = null;
			try {
				target = peek.invoke(pQueue);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"peekMin\" method on an instance of \"PriorityQueue\".",
						false);

				e.printStackTrace();
			}
			Method remove = Class.forName(priorityQueuePath).getDeclaredMethod("remove");
			Object enemy = null;
			try {
				remove.invoke(pQueue);
				enemy = remove.invoke(pQueue);
				if (enemy.getClass().equals(Class.forName(antiHeroPath))
						|| (enemy.getClass().equals(Class.forName(heroPath)))
						|| (enemy.getClass().equals(Class.forName(villainPath)))) {
					Class<?> enemyEffect = Class.forName(championPath);
					Field appliedEffects = enemyEffect.getDeclaredField("appliedEffects");
					appliedEffects.setAccessible(true);
					((ArrayList<Object>) appliedEffects.get(enemy)).add(dodge);

				}
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"remove\" method on an instance of \"PriorityQueue\".",
						false);

				e.printStackTrace();
			}

			Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));

			target.getClass().getSimpleName();
			Field locationTarget = Class.forName(championPath).getDeclaredField("location");
			locationTarget.setAccessible(true);
			Point locationT = (Point) locationTarget.get(target);

			target.getClass().getMethod("getCurrentHP");
			Method m6 = enemy.getClass().getMethod("getCurrentHP");

			int before = 0;
			int actions = 0;
			try {
				before = (Integer) m6.invoke(enemy);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while invoking \"getCurrentHP\" method on an instance of \""
						+ enemy.getClass().getSimpleName() + "\".", false);

				e.printStackTrace();
			}
			try {
				insert.invoke(pQueue, target);
				insert.invoke(pQueue, enemy);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"insert\" method on an instance of \"PriorityQueue\".",
						false);
				e.printStackTrace();
			}
			int counter = 0;
			boolean half = true;

			int size = (int) (Math.random() * 100) + 10;
			Field HP = Class.forName(championPath).getDeclaredField("currentHP");
			Field damage = Class.forName(championPath).getDeclaredField("attackDamage");
			Field action = Class.forName(championPath).getDeclaredField("currentActionPoints");
			HP.setAccessible(true);
			damage.setAccessible(true);
			action.setAccessible(true);
			actions = (int) action.get(target);
			for (int i = 0; i < size; i++) {
				int after = 0;
				damage.get(target);

				HP.set(enemy, before);

				action.set(target, actions);

				if (locationT.y == 3) {
					try {

						m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "LEFT"));
					} catch (InvocationTargetException e) {
						assertTrue(
								e.getCause() + " occurred while invoking \"attack\" method on an instance of \"Game\".",
								false);

						e.printStackTrace();
					}

				} else {
					try {
						m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "RIGHT"));
					} catch (InvocationTargetException e) {
						assertTrue(
								e.getCause() + " occurred while invoking \"attack\" method on an instance of \"Game\".",
								false);

						e.printStackTrace();
					}
				}

				try {
					after = (Integer) m6.invoke(enemy);
				} catch (InvocationTargetException e) {
					assertTrue(e.getCause() + " occurred while invoking \"getCurrentHP\" method on an instance of \""
							+ enemy.getClass().getSimpleName() + "\".", false);

					e.printStackTrace();
				}
				if (after == before)
					counter++;

			}

			if (counter != size && counter >= 1)
				half = true;
			else
				half = false;

			assertTrue("The method \"" + "attack" + "\" in class " + createdGame.getClass().getSimpleName()
					+ " should set the correct value of variable \"" + "currentHP" + "\".", half);
		} catch (InstantiationException e) {
			assertTrue(e.getClass().getName() + " occurred.", false);
		}

		catch (NoSuchMethodException e) {

			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		}

		catch (ClassNotFoundException e) {

			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicShieldBlock() {
		String champInstance;
		try {

			Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
			Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
			int randomName1 = (int) (Math.random() * 10) + 1;
			int randomName2 = (int) (Math.random() * 10) + 1;
			Object firstPlayer = null;
			Object secondPlayer = null;
			try {
				firstPlayer = constructorFirstPlayer.newInstance("Name_" + randomName1);
				secondPlayer = constructorSecondPlayer.newInstance("Name_" + randomName2);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of \"Player\".", false);
			}

			Constructor<?> gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
					Class.forName(playerPath));
			Object createdGame = null;
			try {
				createdGame = gameConstructor.newInstance(firstPlayer, secondPlayer);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of \"Game\".", false);
			}

			ArrayList<Object> firstPlayerChamp1 = new ArrayList<>();
			ArrayList<Object> secPlayerChamp1 = new ArrayList<>();

			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;
			Constructor<?> constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class,
					int.class, int.class, int.class, int.class, int.class);
			Object champPlayer1 = null;

			try {
				try {
					champPlayer1 = constructorChampion.newInstance("ironman", 1, 5, 3, 5, 2, 6);
				} catch (InvocationTargetException e) {
					assertTrue(e.getCause() + " occurred while creating an instance of \""
							+ Class.forName(champInstance).getSimpleName() + "\".", false);
				}
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object champPlayer2 = null;

			try {
				champPlayer2 = constructorChampion.newInstance("loki", 100, 5, 3, 4, 5, 6);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \""
						+ Class.forName(champInstance).getSimpleName() + "\".", false);
			}

			Class<?> cham1 = Class.forName(championPath);
			Field location = cham1.getDeclaredField("location");
			location.setAccessible(true);
			Point p1 = new Point(2, 2);
			location.set(champPlayer1, p1);
			firstPlayerChamp1.add(champPlayer1);
			Class<?> curr = firstPlayer.getClass();
			Field f = curr.getDeclaredField("team");
			f.setAccessible(true);
			f.set(firstPlayer, firstPlayerChamp1);

			Class<?> cham2 = Class.forName(championPath);
			Field location2 = cham2.getDeclaredField("location");
			location2.setAccessible(true);
			Point p2 = new Point(2, 3);
			location.set(champPlayer2, p2);
			secPlayerChamp1.add(champPlayer2);

			curr = secondPlayer.getClass();
			f = curr.getDeclaredField("team");
			f.setAccessible(true);
			f.set(secondPlayer, secPlayerChamp1);
			Method getBoardGame = createdGame.getClass().getMethod("getBoard");
			Object[][] boardGame = null;
			try {
				boardGame = (Object[][]) getBoardGame.invoke(createdGame);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while invoking \"getBoard\" method on an instance of \"Game\".",
						false);

			}

			boardGame[2][2] = champPlayer1;

			boardGame[2][3] = champPlayer2;

			Field board = createdGame.getClass().getDeclaredField("board");
			board.setAccessible(true);
			board.set(createdGame, boardGame);

			Constructor<?> constructorShield = Class.forName(shieldPath).getConstructor(int.class);
			Object shield = null;
			try {
				shield = constructorShield.newInstance((int) (Math.random() * 10) + 1);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"Shield\" can be instantiated.", false);

			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \"Shield\".", false);

			}

			Field queue = Class.forName(gamePath).getDeclaredField("turnOrder");
			queue.setAccessible(true);
			Constructor<?> pQueueConst = Class.forName(priorityQueuePath).getConstructor(int.class);

			Object pQueue = null;
			try {
				pQueue = pQueueConst.newInstance(6);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \"PriorityQueue\".", false);

			}
			Method insert = Class.forName(priorityQueuePath).getDeclaredMethod("insert", Comparable.class);
			try {
				insert.invoke(pQueue, champPlayer1);
				insert.invoke(pQueue, champPlayer2);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"insert\" method on an instance of \"PriorityQueue\".",
						false);

			} catch (IllegalArgumentException e) {
				fail("\"insert\" in \"PriorityQueue\" class takes a \"Comparable\" object.");
			}

			queue.set(createdGame, pQueue);

			Method peek = Class.forName(priorityQueuePath).getDeclaredMethod("peekMin");
			Object target = null;
			try {
				target = peek.invoke(pQueue);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"peekMin\" method on an instance of \"PriorityQueue\".",
						false);

			}
			Method remove = Class.forName(priorityQueuePath).getDeclaredMethod("remove");
			Object enemy = null;
			try {
				remove.invoke(pQueue);
				enemy = remove.invoke(pQueue);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"remove\" method on an instance of \"PriorityQueue\".",
						false);

			}

			if (enemy.getClass().equals(Class.forName(antiHeroPath))
					|| (enemy.getClass().equals(Class.forName(heroPath)))
					|| (enemy.getClass().equals(Class.forName(villainPath)))) {
				Class<?> enemyEffect = Class.forName(championPath);
				Field appliedEffects = enemyEffect.getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				((ArrayList<Object>) appliedEffects.get(enemy)).add(shield);

			}

			try {
				insert.invoke(pQueue, target);
				insert.invoke(pQueue, enemy);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"insert\" method on an instance of \"PriorityQueue\".",
						false);

			}

			Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));

			Field locationTarget = Class.forName(championPath).getDeclaredField("location");
			locationTarget.setAccessible(true);
			Point locationT = (Point) locationTarget.get(target);

			Method m5 = target.getClass().getMethod("getCurrentHP");
			int before = 0;
			try {
				before = (Integer) m5.invoke(enemy);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while invoking \"getCurrentHP\" method on an instance of \""
						+ enemy.getClass().getSimpleName() + "\".", false);

			}
			try {
				if (locationT.y == 3) {
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "LEFT"));

				} else {
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "RIGHT"));
				}
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while invoking \"attack\" method on an instance of \"Game\".",
						false);

			}

			int after = 0;
			try {
				after = (Integer) m5.invoke(enemy);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while invoking \"getCurrentHP\" method on an instance of \""
						+ enemy.getClass().getSimpleName() + "\".", false);

			}

			assertEquals("The method \"" + "attack" + "\" in class " + createdGame.getClass().getSimpleName()
					+ " should set the correct value of variable \"" + "currentHP" + "\".", before, after);
		} catch (InstantiationException e) {
			assertTrue(e.getClass().getName() + " occurred.", false);
		}

		catch (NoSuchMethodException e) {

			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		}

		catch (ClassNotFoundException e) {

			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicShieldBlockRemove() {
		String champInstance;
		try {

			Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
			Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
			int randomName1 = (int) (Math.random() * 10) + 1;
			int randomName2 = (int) (Math.random() * 10) + 1;
			Object firstPlayer = null;
			Object secondPlayer = null;
			try {
				firstPlayer = constructorFirstPlayer.newInstance("Name_" + randomName1);
				secondPlayer = constructorSecondPlayer.newInstance("Name_" + randomName2);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of \"Player\".", false);
			}

			Constructor<?> gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
					Class.forName(playerPath));
			Object createdGame = null;
			try {
				createdGame = gameConstructor.newInstance(firstPlayer, secondPlayer);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of \"Game\".", false);
			}

			ArrayList<Object> firstPlayerChamp1 = new ArrayList<>();
			ArrayList<Object> secPlayerChamp1 = new ArrayList<>();

			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;
			Constructor<?> constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class,
					int.class, int.class, int.class, int.class, int.class);

			Object champPlayer1 = null;

			try {
				try {
					champPlayer1 = constructorChampion.newInstance("ironman", 1, 5, 3, 5, 2, 6);
				} catch (InvocationTargetException e) {
					assertTrue(e.getCause() + " occurred while creating an instance of \""
							+ Class.forName(champInstance).getSimpleName() + "\".", false);
				}
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object champPlayer2 = null;

			try {
				champPlayer2 = constructorChampion.newInstance("loki", 100, 5, 3, 4, 5, 6);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \""
						+ Class.forName(champInstance).getSimpleName() + "\".", false);
			}

			Class<?> cham1 = Class.forName(championPath);
			Field location = cham1.getDeclaredField("location");
			location.setAccessible(true);
			Point p1 = new Point(2, 2);
			location.set(champPlayer1, p1);
			firstPlayerChamp1.add(champPlayer1);
			Class<?> curr = firstPlayer.getClass();
			Field f = curr.getDeclaredField("team");
			f.setAccessible(true);
			f.set(firstPlayer, firstPlayerChamp1);

			Class<?> cham2 = Class.forName(championPath);
			Field location2 = cham2.getDeclaredField("location");
			location2.setAccessible(true);
			Point p2 = new Point(2, 3);
			location.set(champPlayer2, p2);
			secPlayerChamp1.add(champPlayer2);

			curr = secondPlayer.getClass();
			f = curr.getDeclaredField("team");
			f.setAccessible(true);
			f.set(secondPlayer, secPlayerChamp1);
			Method getBoardGame = createdGame.getClass().getMethod("getBoard");
			Object[][] boardGame = null;
			try {
				boardGame = (Object[][]) getBoardGame.invoke(createdGame);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while invoking \"getBoard\" method on an instance of \"Game\".",
						false);

			}

			boardGame[2][2] = champPlayer1;

			boardGame[2][3] = champPlayer2;

			Field board = createdGame.getClass().getDeclaredField("board");
			board.setAccessible(true);
			board.set(createdGame, boardGame);

			Constructor<?> constructorShield = Class.forName(shieldPath).getConstructor(int.class);
			Object shield = null;
			try {
				shield = constructorShield.newInstance((int) (Math.random() * 10) + 1);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"Shield\" can be instantiated.", false);

			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \"Shield\".", false);

			}

			Field queue = Class.forName(gamePath).getDeclaredField("turnOrder");
			queue.setAccessible(true);
			Constructor<?> pQueueConst = Class.forName(priorityQueuePath).getConstructor(int.class);

			Object pQueue = null;
			try {
				pQueue = pQueueConst.newInstance(6);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \"PriorityQueue\".", false);

			}
			Method insert = Class.forName(priorityQueuePath).getDeclaredMethod("insert", Comparable.class);
			try {
				insert.invoke(pQueue, champPlayer1);
				insert.invoke(pQueue, champPlayer2);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"insert\" method on an instance of \"PriorityQueue\".",
						false);

			} catch (IllegalArgumentException e) {
				fail("\"insert\" in \"PriorityQueue\" class takes a \"Comparable\" object.");
			}

			queue.set(createdGame, pQueue);

			Method peek = Class.forName(priorityQueuePath).getDeclaredMethod("peekMin");
			Object target = null;
			try {
				target = peek.invoke(pQueue);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"peekMin\" method on an instance of \"PriorityQueue\".",
						false);

			}
			Method remove = Class.forName(priorityQueuePath).getDeclaredMethod("remove");
			Object enemy = null;
			try {
				remove.invoke(pQueue);
				enemy = remove.invoke(pQueue);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"remove\" method on an instance of \"PriorityQueue\".",
						false);

			}
			if (enemy.getClass().equals(Class.forName(antiHeroPath))
					|| (enemy.getClass().equals(Class.forName(heroPath)))
					|| (enemy.getClass().equals(Class.forName(villainPath)))) {
				Class<?> enemyEffect = Class.forName(championPath);
				Field appliedEffects = enemyEffect.getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				((ArrayList<Object>) appliedEffects.get(enemy)).add(shield);

			}

			try {
				insert.invoke(pQueue, target);
				insert.invoke(pQueue, enemy);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"insert\" method on an instance of \"PriorityQueue\".",
						false);

			}

			Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));

			Field locationTarget = Class.forName(championPath).getDeclaredField("location");
			locationTarget.setAccessible(true);
			Point locationT = (Point) locationTarget.get(target);

			ArrayList<Object> expected = new ArrayList<>();

			try {
				if (locationT.y == 3) {
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "LEFT"));

				} else {
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "RIGHT"));
				}
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while invoking \"attack\" method on an instance of \"Game\".",
						false);

			}
			ArrayList<Object> after = new ArrayList<>();
			Field effect = Class.forName(championPath).getDeclaredField("appliedEffects");
			effect.setAccessible(true);
			after = (ArrayList<Object>) effect.get(enemy);

			assertEquals(
					"The method \"" + "attack" + "\" in class " + createdGame.getClass().getSimpleName()
							+ " should remove the \"Shield\" effect from the target's \"appliedEffects\" arraylist.",
					expected, after);
		} catch (InstantiationException e) {
			assertTrue(e.getClass().getName() + " occurred.", false);
		}

		catch (NoSuchMethodException e) {

			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		}

		catch (ClassNotFoundException e) {

			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

		}

	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void applyLogicShieldBlockRemove2() {
		String champInstance;
		try {

			Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
			Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
			int randomName1 = (int) (Math.random() * 10) + 1;
			int randomName2 = (int) (Math.random() * 10) + 1;
			Object firstPlayer = null;
			Object secondPlayer = null;
			try {
				firstPlayer = constructorFirstPlayer.newInstance("Name_" + randomName1);
				secondPlayer = constructorSecondPlayer.newInstance("Name_" + randomName2);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of \"Player\".", false);
			}

			Constructor<?> gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
					Class.forName(playerPath));
			Object createdGame = null;
			try {
				createdGame = gameConstructor.newInstance(firstPlayer, secondPlayer);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of \"Game\".", false);
			}

			ArrayList<Object> firstPlayerChamp1 = new ArrayList<>();
			ArrayList<Object> secPlayerChamp1 = new ArrayList<>();

			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;
			Constructor<?> constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class,
					int.class, int.class, int.class, int.class, int.class);

			Object champPlayer1 = null;

			try {
				try {
					champPlayer1 = constructorChampion.newInstance("ironman", 1, 5, 3, 5, 2, 6);
				} catch (InvocationTargetException e) {
					assertTrue(e.getCause() + " occurred while creating an instance of \""
							+ Class.forName(champInstance).getSimpleName() + "\".", false);
				}
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object champPlayer2 = null;

			try {
				champPlayer2 = constructorChampion.newInstance("loki", 100, 5, 3, 4, 5, 6);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \""
						+ Class.forName(champInstance).getSimpleName() + "\".", false);
			}

			Class<?> cham1 = Class.forName(championPath);
			Field location = cham1.getDeclaredField("location");
			location.setAccessible(true);
			Point p1 = new Point(2, 2);
			location.set(champPlayer1, p1);
			firstPlayerChamp1.add(champPlayer1);
			Class<?> curr = firstPlayer.getClass();
			Field f = curr.getDeclaredField("team");
			f.setAccessible(true);
			f.set(firstPlayer, firstPlayerChamp1);

			Class<?> cham2 = Class.forName(championPath);
			Field location2 = cham2.getDeclaredField("location");
			location2.setAccessible(true);
			Point p2 = new Point(2, 3);
			location.set(champPlayer2, p2);
			secPlayerChamp1.add(champPlayer2);

			curr = secondPlayer.getClass();
			f = curr.getDeclaredField("team");
			f.setAccessible(true);
			f.set(secondPlayer, secPlayerChamp1);

			Method getBoardGame = createdGame.getClass().getMethod("getBoard");
			Object[][] boardGame = null;
			try {
				boardGame = (Object[][]) getBoardGame.invoke(createdGame);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while invoking \"getBoard\" method on an instance of \"Game\".",
						false);

			}

			boardGame[2][2] = champPlayer1;

			boardGame[2][3] = champPlayer2;

			Field board = createdGame.getClass().getDeclaredField("board");
			board.setAccessible(true);
			board.set(createdGame, boardGame);

			Constructor<?> constructorShield = Class.forName(shieldPath).getConstructor(int.class);
			Object shield = null;
			try {
				shield = constructorShield.newInstance((int) (Math.random() * 10) + 1);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"Shield\" can be instantiated.", false);

			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \"Shield\".", false);

			}

			Field queue = Class.forName(gamePath).getDeclaredField("turnOrder");
			queue.setAccessible(true);
			Constructor<?> pQueueConst = Class.forName(priorityQueuePath).getConstructor(int.class);

			Object pQueue = null;
			try {
				pQueue = pQueueConst.newInstance(6);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \"PriorityQueue\".", false);

			}
			Method insert = Class.forName(priorityQueuePath).getDeclaredMethod("insert", Comparable.class);
			try {
				insert.invoke(pQueue, champPlayer1);
				insert.invoke(pQueue, champPlayer2);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"insert\" method on an instance of \"PriorityQueue\".",
						false);

			} catch (IllegalArgumentException e) {
				fail("\"insert\" in \"PriorityQueue\" class takes a \"Comparable\" object.");
			}

			queue.set(createdGame, pQueue);

			Method peek = Class.forName(priorityQueuePath).getDeclaredMethod("peekMin");
			Object target = null;
			try {
				target = peek.invoke(pQueue);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"peekMin\" method on an instance of \"PriorityQueue\".",
						false);

			}
			Method remove = Class.forName(priorityQueuePath).getDeclaredMethod("remove");
			Object enemy = null;
			try {
				remove.invoke(pQueue);
				enemy = remove.invoke(pQueue);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"remove\" method on an instance of \"PriorityQueue\".",
						false);

			}
			Field speed = null;
			if (enemy.getClass().equals(Class.forName(antiHeroPath))
					|| (enemy.getClass().equals(Class.forName(heroPath)))
					|| (enemy.getClass().equals(Class.forName(villainPath)))) {
				Class<?> enemyEffect = Class.forName(championPath);
				speed = enemyEffect.getDeclaredField("speed");
				speed.setAccessible(true);

				Field appliedEffects = enemyEffect.getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				((ArrayList<Object>) appliedEffects.get(enemy)).add(shield);

			}

			try {
				insert.invoke(pQueue, target);
				insert.invoke(pQueue, enemy);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"insert\" method on an instance of \"PriorityQueue\".",
						false);

			}

			Field locationTarget = Class.forName(championPath).getDeclaredField("location");
			locationTarget.setAccessible(true);
			Point locationT = (Point) locationTarget.get(target);

			new ArrayList<>();
			String dir = "";

			if (locationT.y == 3) {
				dir = "LEFT";

			} else {
				dir = "RIGHT";

			}
			removeLogicShieldSpeed(enemy, createdGame, dir);

		} catch (InstantiationException e) {
			assertTrue(e.getClass().getName() + " occurred.", false);
		}

		catch (NoSuchMethodException e) {

			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		}

		catch (ClassNotFoundException e) {

			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void removeLogicShieldSpeed(Object c, Object createdGame, String direction) {
		Field f = null;
		try {

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("speed");
			f.setAccessible(true);
			f.set(c, 102);

			Method attack = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
			attack.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), direction));

			int expectedValue1 = 100;

			assertEquals("The method \"" + "attack" + "\" in class " + createdGame.getClass().getSimpleName()
					+ " should call the \"remove\" method of \"Shield\" class after the target has used the effect. The \"remove\" method should set the correct value of \"speed\".",
					expectedValue1, f.get(c));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Embrace\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicRootMove() {
		String champInstance;
		boolean point = true;
		try {

			Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
			Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
			int randomName1 = (int) (Math.random() * 10) + 1;
			int randomName2 = (int) (Math.random() * 10) + 1;
			Object firstPlayer = null;
			Object secondPlayer = null;
			try {
				firstPlayer = constructorFirstPlayer.newInstance("Name_" + randomName1);
				secondPlayer = constructorSecondPlayer.newInstance("Name_" + randomName2);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of \"Player\".", false);

			}

			Constructor<?> gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
					Class.forName(playerPath));
			Object createdGame = null;
			try {
				createdGame = gameConstructor.newInstance(firstPlayer, secondPlayer);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of \"Game\".", false);
			}

			ArrayList<Object> firstPlayerChamp1 = new ArrayList<>();
			ArrayList<Object> secPlayerChamp1 = new ArrayList<>();

			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;
			Constructor<?> constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class,
					int.class, int.class, int.class, int.class, int.class);

			Object champPlayer1 = null;

			try {
				champPlayer1 = constructorChampion.newInstance("ironman", 1, 5, 3, 5, 2, 6);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \""
						+ Class.forName(champInstance).getSimpleName() + "\".", false);
			}

			Object champPlayer2 = null;

			try {
				champPlayer2 = constructorChampion.newInstance("loki", 100, 5, 3, 4, 5, 6);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \""
						+ Class.forName(champInstance).getSimpleName() + "\".", false);
			}

			Class<?> cham1 = Class.forName(championPath);
			Field location = cham1.getDeclaredField("location");
			location.setAccessible(true);
			Point p1 = new Point(2, 2);
			location.set(champPlayer1, p1);
			firstPlayerChamp1.add(champPlayer1);
			Class<?> curr = firstPlayer.getClass();
			Field f = curr.getDeclaredField("team");
			f.setAccessible(true);
			f.set(firstPlayer, firstPlayerChamp1);

			Class<?> cham2 = Class.forName(championPath);
			Field location2 = cham2.getDeclaredField("location");
			location2.setAccessible(true);
			Point p2 = new Point(2, 3);
			location.set(champPlayer2, p2);
			secPlayerChamp1.add(champPlayer2);

			curr = secondPlayer.getClass();
			f = curr.getDeclaredField("team");
			f.setAccessible(true);
			f.set(secondPlayer, secPlayerChamp1);
			Method getBoardGame = createdGame.getClass().getMethod("getBoard");
			Object[][] boardGame = null;
			try {
				boardGame = (Object[][]) getBoardGame.invoke(createdGame);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + "occurred while invoking \"getBoard\" method on an instance of \"Game\".",
						false);
			}

			boardGame[2][2] = champPlayer1;

			boardGame[2][3] = champPlayer2;

			Field board = createdGame.getClass().getDeclaredField("board");
			board.setAccessible(true);
			board.set(createdGame, boardGame);

			Constructor<?> constructorRoot = Class.forName(rootPath).getConstructor(int.class);

			Object root = null;
			try {
				root = constructorRoot.newInstance((int) (Math.random() * 10) + 1);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \"Root\".", false);
			}

			Field queue = Class.forName(gamePath).getDeclaredField("turnOrder");
			queue.setAccessible(true);
			Constructor<?> pQueueConst = Class.forName(priorityQueuePath).getConstructor(int.class);

			Object pQueue = null;
			try {
				pQueue = pQueueConst.newInstance(6);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \"PriorityQueue\".", false);
			}
			Method insert = Class.forName(priorityQueuePath).getDeclaredMethod("insert", Comparable.class);
			try {
				insert.invoke(pQueue, champPlayer1);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"insert\" method on an instance of \"PriorityQueue\".",
						false);

			} catch (IllegalArgumentException e) {
				fail("\"insert\" in \"PriorityQueue\" class takes a \"Comparable\" object.");
			}
			queue.set(createdGame, pQueue);

			Method peek = Class.forName(priorityQueuePath).getDeclaredMethod("peekMin");
			Object target = null;
			try {
				target = peek.invoke(pQueue);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"peekMin\" method on an instance of \"PriorityQueue\".",
						false);

			}
			if (target.getClass().equals(Class.forName(antiHeroPath))
					|| (target.getClass().equals(Class.forName(heroPath)))
					|| (target.getClass().equals(Class.forName(villainPath)))) {
				Class<?> targetEffect = Class.forName(championPath);
				Field appliedEffects = targetEffect.getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				((ArrayList<Object>) appliedEffects.get(target)).add(root);
				Field condition = targetEffect.getDeclaredField("condition");
				condition.setAccessible(true);
				condition.set(target, Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ROOTED"));
			}

			Method m3 = createdGame.getClass().getMethod("move", Class.forName(directionPath));

			Field locationTarget = Class.forName(championPath).getDeclaredField("location");
			locationTarget.setAccessible(true);
			Point locationTBefore = (Point) locationTarget.get(target);
			try {
				m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "UP"));
				fail("Trying to move while \"ROOTED\" , \"UnallowedMovementException\" should be thrown.");
			} catch (InvocationTargetException e) {
				if (!(Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
					assertTrue(e.getCause() + " occurred while invoking \"move\" method on an instance of \"Game\".",
							false);

			}

			Point locationTAfter = (Point) locationTarget.get(target);
			if (locationTAfter.x != locationTBefore.x || locationTAfter.y != locationTBefore.y)
				point = false;

			assertTrue("The method \"" + "move" + "\" in class " + createdGame.getClass().getSimpleName()
					+ " should set the correct value of variable \"" + "location" + "\".", point);

			boolean found = false;
			if (m3.getExceptionTypes().length != 0) {
				for (int i = 0; i < m3.getExceptionTypes().length; i++) {
					if (m3.getExceptionTypes()[i].getSimpleName().equals("UnallowedMovementException")) {
						found = true;
					}
				}
				assertTrue(
						"Method \"move\" in class \"Game\" should throw the exception called \"java.lang.UnallowedMovementException\".",
						found);

			} else {
				assertTrue(
						"Method \"move\" in class \"Game\" should throw the exception called \"java.lang.UnallowedMovementException\".",
						false);
			}

		} catch (InstantiationException e) {
			assertTrue(e.getClass().getName() + " occurred.", false);
		}

		catch (NoSuchMethodException e) {

			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		}

		catch (ClassNotFoundException e) {

			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();

		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicDisarmDamagingAbility() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorDisarm;
		Constructor<?> constructorDamagingAbility;

		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorDamagingAbility = Class.forName(dmgPath).getConstructor(String.class, int.class, int.class,
					int.class, Class.forName(areaOfEffectPath), int.class, int.class);
			Object damagingAbilityObject = null;
			try {
				damagingAbilityObject = constructorDamagingAbility.newInstance("Punch", 0, 1, 1,
						Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SINGLETARGET"), 1, 50);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of \"DamagingAbility\".", false);

			}

			constructorDisarm = Class.forName(disarmPath).getConstructor(int.class);
			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			Object championObject = null;

			try {
				try {
					championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
							randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
				} catch (InvocationTargetException e) {
					assertTrue(e.getCause() + " occurred while creating an instance of \"Champion\".", false);
				}
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}
			Object disarm = null;
			try {
				disarm = constructorDisarm.newInstance(duration);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \"Disarm\".", false);
			}

			ArrayList<Object> expected = new ArrayList<>();
			expected.add(damagingAbilityObject);

			Class<?> curr = Class.forName(championPath);
			Field f = curr.getDeclaredField("abilities");
			f.setAccessible(true);

			Method apply = Class.forName(disarmPath).getDeclaredMethod("apply", Class.forName(championPath));
			try {
				apply.invoke(disarm, championObject);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while calling method \"apply\" from class \"Disarm\".", false);

			}
			ArrayList<Object> actual = (ArrayList<Object>) f.get(championObject);

			boolean flag = true;
			if (actual.size() != expected.size()) {
				flag = false;
			} else {

				Object returned = actual.get(0);
				if (returned.getClass().equals(Class.forName(dmgPath))) {
					Class<?> c = Class.forName(abilityPath);
					Class<?> cc = Class.forName(dmgPath);
					Field name = c.getDeclaredField("name");
					Field manaCost = c.getDeclaredField("manaCost");
					Field baseCooldown = c.getDeclaredField("baseCooldown");
					Field castRange = c.getDeclaredField("castRange");
					Field requiredActionPoints = c.getDeclaredField("requiredActionPoints");
					Field castArea = c.getDeclaredField("castArea");
					Field damageAmount = cc.getDeclaredField("damageAmount");

					name.setAccessible(true);
					manaCost.setAccessible(true);
					baseCooldown.setAccessible(true);
					castRange.setAccessible(true);
					requiredActionPoints.setAccessible(true);
					castArea.setAccessible(true);
					damageAmount.setAccessible(true);

					String n = (String) name.get(returned);
					int mana = (int) manaCost.get(returned);
					int cool = (int) baseCooldown.get(returned);
					int range = (int) castRange.get(returned);
					int actions = (int) requiredActionPoints.get(returned);
					Object area = castArea.get(returned);

					int damage = (int) damageAmount.get(returned);

					if (!n.equals("Punch") || mana != 0 || cool != 1 || range != 1 || actions != 1 || damage != 50
							|| !area.toString().equals("SINGLETARGET")) {
						flag = false;
					}

					c.getDeclaredMethod("getName");

				}

			}

			assertTrue("The method \"" + "apply" + "\" in class \"" + disarm.getClass().getSimpleName()
					+ "\" should add the correct \"DamagingAbility\" in the arrayList \"abilities\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"DamagingAbility\" can be instantiated.", false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void removeLogicDisarmDamagingAbility() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorDisarm;
		Constructor<?> constructorDamagingAbility;

		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorDamagingAbility = Class.forName(dmgPath).getConstructor(String.class, int.class, int.class,
					int.class, Class.forName(areaOfEffectPath), int.class, int.class);
			Object damagingAbilityObject = null;
			try {
				damagingAbilityObject = constructorDamagingAbility.newInstance("Punch", 0, 1, 1,
						Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SINGLETARGET"), 1, 50);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of \"DamagingAbility\".", false);

			}

			constructorDisarm = Class.forName(disarmPath).getConstructor(int.class);
			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			Object championObject = null;

			try {
				try {
					championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
							randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
				} catch (InvocationTargetException e) {
					assertTrue(e.getCause() + " occurred while creating an instance of \"Champion\".", false);
				}
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}
			Object disarm = null;
			try {
				disarm = constructorDisarm.newInstance(duration);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \"Disarm\".", false);
			}

			ArrayList<Object> expected = new ArrayList<>();
			expected.add(damagingAbilityObject);

			Class<?> curr = Class.forName(championPath);
			Field f = curr.getDeclaredField("abilities");
			f.setAccessible(true);
			f.set(championObject, expected);

			Method remove = Class.forName(disarmPath).getDeclaredMethod("remove", Class.forName(championPath));
			try {
				remove.invoke(disarm, championObject);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while calling method \"remove\" from class \"Disarm\".", false);

			}
			ArrayList<Object> actual = (ArrayList<Object>) f.get(championObject);

			boolean flag = true;
			if (actual.size() != 0) {
				flag = false;
			}

			assertTrue("The method \"" + "remove" + "\" in class \"" + disarm.getClass().getSimpleName()
					+ "\" should remove the gained \"DamagingAbility\" object from the arrayList \"abilities\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"DamagingAbility\" can be instantiated.", false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void applyLogicShieldSpeed() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorShield;
		int randomMaxHP = (int) (Math.random() * 100) + 20;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = 100;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 1000) + 200;
		int duration = (int) (Math.random() * 10) + 1;
		Math.random();
		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorShield = Class.forName(shieldPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object shieldObject = constructorShield.newInstance(duration);
			Method apply = Class.forName(shieldPath).getDeclaredMethod("apply", Class.forName(championPath));
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("speed");
			f.setAccessible(true);
			apply.invoke(shieldObject, championObject);

			int expectedValue1 = (int) (randomSpeed * 1.02);
			int expectedValue2 = (int) (randomSpeed - randomSpeed * 0.02);

			boolean flag = true;
			if (!(expectedValue1 == (int) f.get(championObject) || expectedValue2 == (int) f.get(championObject))) {
				flag = false;
			}

			assertTrue("The method \"" + "apply" + "\" in class \"" + shieldObject.getClass().getSimpleName()
					+ "\" should set the correct value of variable \"" + "speed" + "\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Shield\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"shield\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void removeLogicShieldSpeed() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorShield;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = 102;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 1000) + 200;
		int duration = (int) (Math.random() * 10) + 1;
		Object expectedValue = 100;

		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorShield = Class.forName(shieldPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object shieldObject = constructorShield.newInstance(duration);
			Method remove = Class.forName(shieldPath).getDeclaredMethod("remove", Class.forName(championPath));
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("speed");
			f.setAccessible(true);
			remove.invoke(shieldObject, championObject);
			assertEquals(
					"The method \"" + "remove" + "\" in class \"" + shieldObject.getClass().getSimpleName()
							+ "\" should set the correct value of variable \"" + "speed" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Shield\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Shield\" must implement the inherited abstract method Effect.remove(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void applyLogicSilenceActions() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorSilence;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		Object expectedValue = (randomActions + 2);
		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			constructorSilence = Class.forName(silencePath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object silenceObject = constructorSilence.newInstance(duration);
			Method apply = Class.forName(silencePath).getDeclaredMethod("apply", Class.forName(championPath));

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("currentActionPoints");
			f.setAccessible(true);
			f.set(championObject, randomActions);
			apply.invoke(silenceObject, championObject);
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + silenceObject.getClass().getSimpleName()
							+ "\" should set the correct value of variable \"" + "currentActionPoints" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Silence\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Silence\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void applyLogicSilenceMaxActions() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorSilence;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		Math.random();
		Object expectedValue = (randomMaxActions + 2);
		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			constructorSilence = Class.forName(silencePath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object silenceObject = constructorSilence.newInstance(duration);
			Method apply = Class.forName(silencePath).getDeclaredMethod("apply", Class.forName(championPath));

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("maxActionPointsPerTurn");
			f.setAccessible(true);
			apply.invoke(silenceObject, championObject);
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + silenceObject.getClass().getSimpleName()
							+ "\" should set the correct value of variable \"" + "maxActionPointsPerTurn" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Silence\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Silence\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void removeLogicSilenceActions() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorSilence;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 1000) + 200;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 100) + 20;
		int afterApply = (randomActions + 2);
		Object expectedValue = (afterApply - 2);
		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			constructorSilence = Class.forName(silencePath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object silenceObject = constructorSilence.newInstance(duration);
			Method remove = Class.forName(silencePath).getDeclaredMethod("remove", Class.forName(championPath));

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("currentActionPoints");
			f.setAccessible(true);
			f.set(championObject, afterApply);
			remove.invoke(silenceObject, championObject);
			assertEquals(
					"The method \"" + "remove" + "\" in class \"" + silenceObject.getClass().getSimpleName()
							+ "\" should set the correct value of variable \"" + "currentActionPoints" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Silence\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Silence\" must implement the inherited abstract method Effect.remove(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void removeLogicSilenceMaxActions() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorSilence;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 1000) + 200;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		Math.random();
		int afterApply = (randomMaxActions + 2);
		Object expectedValue = (afterApply - 2);
		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			constructorSilence = Class.forName(silencePath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object silenceObject = constructorSilence.newInstance(duration);
			Method remove = Class.forName(silencePath).getDeclaredMethod("remove", Class.forName(championPath));

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("maxActionPointsPerTurn");
			f.setAccessible(true);
			f.set(championObject, afterApply);
			remove.invoke(silenceObject, championObject);
			assertEquals(
					"The method \"" + "remove" + "\" in class \"" + silenceObject.getClass().getSimpleName()
							+ "\" should set the correct value of variable \"" + "maxActionPointsPerTurn" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Silence\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Silence\" must implement the inherited abstract method Effect.remove(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicRoot() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorRoot;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;

		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorRoot = Class.forName(rootPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object rootObject = constructorRoot.newInstance(duration);
			Method apply = Class.forName(rootPath).getDeclaredMethod("apply", Class.forName(championPath));
			Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ROOTED");
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("condition");
			f.setAccessible(true);
			apply.invoke(rootObject, championObject);
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + rootObject.getClass().getSimpleName()
							+ "\" should set the correct value of variable \"" + "condition" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Root\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Root\" must implement the inherited abstract method Effect.apply(Champion).", false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicRootInactive() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorRoot;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;

		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			constructorRoot = Class.forName(rootPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object rootObject = constructorRoot.newInstance(duration);
			Method apply = Class.forName(rootPath).getDeclaredMethod("apply", Class.forName(championPath));
			Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE");
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("condition");
			f.setAccessible(true);
			f.set(championObject, Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE"));
			apply.invoke(rootObject, championObject);
			assertEquals("The method \"" + "apply" + "\" in class \"" + rootObject.getClass().getSimpleName()
					+ "\" should set the correct value of variable \"" + "condition"
					+ "\". If the champion was INACTIVE then his condition should remain INACTIVE after applying \"Root\" effect.",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Root\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Root\" must implement the inherited abstract method Effect.apply(Champion).", false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void removeLogicRoot() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorRoot;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;

		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			constructorRoot = Class.forName(rootPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object rootObject = constructorRoot.newInstance(duration);
			Method apply = Class.forName(rootPath).getDeclaredMethod("remove", Class.forName(championPath));
			Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ROOTED");
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("condition");
			f.setAccessible(true);
			f.set(championObject, Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ROOTED"));
			ArrayList<Object> effect = new ArrayList<>();
			effect.add(rootObject);
			Field ff = curr.getDeclaredField("appliedEffects");
			ff.setAccessible(true);
			ff.set(championObject, effect);

			apply.invoke(rootObject, championObject);
			assertEquals("The method \"" + "remove" + "\" in class \"" + rootObject.getClass().getSimpleName()
					+ "\" should set the correct value of variable \"" + "condition"
					+ "\". If the champion already has another ROOT effect, then his condition should remain ROOTED after removing \"Root\" effect.",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Root\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Root\" must implement the inherited abstract method Effect.remove(Champion).",
					false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void removeLogicRootInactive() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorRoot;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;

		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			constructorRoot = Class.forName(rootPath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomMaxActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object rootObject = constructorRoot.newInstance(duration);
			Method apply = Class.forName(rootPath).getDeclaredMethod("remove", Class.forName(championPath));
			Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE");
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("condition");
			f.setAccessible(true);
			f.set(championObject, Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE"));
			apply.invoke(rootObject, championObject);
			assertEquals("The method \"" + "remove" + "\" in class \"" + rootObject.getClass().getSimpleName()
					+ "\" should set the correct value of variable \"" + "condition"
					+ "\". If the champion was INACTIVE then his condition should remain INACTIVE after removing \"Root\" effect.",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Root\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Root\" must implement the inherited abstract method Effect.remove(Champion).",
					false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void applyLogicDodgeSpeed() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorDodge;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = 100;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		int expectedValue1 = (int) (randomSpeed * 1.05);
		int expectedValue2 = (int) (randomSpeed + randomSpeed * 0.05);

		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			constructorDodge = Class.forName(DodgePath).getConstructor(int.class);

			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object dodgeObject = constructorDodge.newInstance(duration);
			Method apply = Class.forName(DodgePath).getDeclaredMethod("apply", Class.forName(championPath));
			apply.invoke(dodgeObject, championObject);
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("speed");
			f.setAccessible(true);

			boolean flag = true;
			if (!(expectedValue1 == (int) f.get(championObject) || expectedValue2 == (int) f.get(championObject))) {
				flag = false;
			}

			assertTrue("The method \"" + "apply" + "\" in class \"" + dodgeObject.getClass().getSimpleName()
					+ "\" should set the correct value of variable \"" + "speed" + "\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Dodge\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Dodge\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	private void applyLogicDodgeSpeed(Object c, Object effect, Object cc) {
		Constructor<?> constructorChampion;
		Constructor<?> constructorDodge;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 100) + 20;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		boolean flag = true;
		Field f = null;
		try {

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("speed");
			f.setAccessible(true);
			int speed = (int) f.get(c);

			Object expectedValue = (int) (speed + (0.05 * speed));

			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			constructorDodge = Class.forName(DodgePath).getConstructor(int.class);

			try {
				constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
						randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			constructorDodge.newInstance(duration);
			Method execute = cc.getClass().getDeclaredMethod("execute", ArrayList.class);

			ArrayList<Object> target = new ArrayList<>();
			target.add(c);
			execute.invoke(cc, target);

			f = curr.getDeclaredField("speed");
			f.setAccessible(true);
			if (!expectedValue.equals(f.get(c))) {
				flag = false;
			}

			assertTrue("\"" + cc.getClass().getSimpleName() + "\" class has \"" + effect.getClass().getSimpleName()
					+ "\" effect that should be applied correctly for \"targets\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Dodge\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Dodge\" must implement the inherited abstract method Effect.apply(Champion)", false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void removeLogicDodgeSpeed() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorDodge;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = 105;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		Object expectedValue = 100;

		Field f = null;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			constructorDodge = Class.forName(DodgePath).getConstructor(int.class);
			Object championObject = null;

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object dodgeObject = constructorDodge.newInstance(duration);
			Method remove = Class.forName(DodgePath).getDeclaredMethod("remove", Class.forName(championPath));
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("speed");
			f.setAccessible(true);
			remove.invoke(dodgeObject, championObject);
			assertEquals(
					"The method \"" + "remove" + "\" in class \"" + dodgeObject.getClass().getSimpleName()
							+ "\" should set the correct value of variable \"" + "speed" + "\".",
					expectedValue, f.get(championObject));

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Dodge\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Dodge\" must implement the inherited abstract method Effect.remove(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicShieldBlockDmgAbilitySurround() {
		String champInstance;
		try {

			Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
			Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
			int randomName1 = (int) (Math.random() * 10) + 1;
			int randomName2 = (int) (Math.random() * 10) + 1;
			Object firstPlayer = null;
			Object secondPlayer = null;
			try {
				firstPlayer = constructorFirstPlayer.newInstance("Name_" + randomName1);
				secondPlayer = constructorSecondPlayer.newInstance("Name_" + randomName2);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of \"Player\".", false);
			}

			Constructor<?> gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
					Class.forName(playerPath));
			Object createdGame = null;
			try {
				createdGame = gameConstructor.newInstance(firstPlayer, secondPlayer);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of \"Game\".", false);
			}

			ArrayList<Object> firstPlayerChamp1 = new ArrayList<>();
			ArrayList<Object> secPlayerChamp1 = new ArrayList<>();

			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;
			Constructor<?> constructorChampion = Class.forName(champInstance).getConstructor(String.class, int.class,
					int.class, int.class, int.class, int.class, int.class);
			Object champPlayer1 = null;

			try {
				try {
					champPlayer1 = constructorChampion.newInstance("ironman", 1, 5, 3, 5, 2, 6);
				} catch (InvocationTargetException e) {
					assertTrue(e.getCause() + " occurred while creating an instance of \""
							+ Class.forName(champInstance).getSimpleName() + "\".", false);
				}
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object champPlayer2 = null;

			try {
				champPlayer2 = constructorChampion.newInstance("loki", 100, 5, 3, 4, 5, 6);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \""
						+ Class.forName(champInstance).getSimpleName() + "\".", false);
			}

			Class<?> cham1 = Class.forName(championPath);
			Field location = cham1.getDeclaredField("location");
			location.setAccessible(true);
			Point p1 = new Point(2, 2);
			location.set(champPlayer1, p1);
			firstPlayerChamp1.add(champPlayer1);
			Class<?> curr = firstPlayer.getClass();
			Field f = curr.getDeclaredField("team");
			f.setAccessible(true);
			f.set(firstPlayer, firstPlayerChamp1);

			Class<?> cham2 = Class.forName(championPath);
			Field location2 = cham2.getDeclaredField("location");
			location2.setAccessible(true);
			Point p2 = new Point(2, 3);
			location.set(champPlayer2, p2);
			secPlayerChamp1.add(champPlayer2);

			curr = secondPlayer.getClass();
			f = curr.getDeclaredField("team");
			f.setAccessible(true);
			f.set(secondPlayer, secPlayerChamp1);
			Method getBoardGame = createdGame.getClass().getMethod("getBoard");
			Object[][] boardGame = null;
			try {
				boardGame = (Object[][]) getBoardGame.invoke(createdGame);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while invoking \"getBoard\" method on an instance of \"Game\".",
						false);

			}

			boardGame[2][2] = champPlayer1;

			boardGame[2][3] = champPlayer2;

			Field board = createdGame.getClass().getDeclaredField("board");
			board.setAccessible(true);
			board.set(createdGame, boardGame);

			Constructor<?> constructorShield = Class.forName(shieldPath).getConstructor(int.class);
			Object shield = null;
			try {
				shield = constructorShield.newInstance((int) (Math.random() * 10) + 1);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"Shield\" can be instantiated.", false);

			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \"Shield\".", false);

			}

			Field queue = Class.forName(gamePath).getDeclaredField("turnOrder");
			queue.setAccessible(true);
			Constructor<?> pQueueConst = Class.forName(priorityQueuePath).getConstructor(int.class);

			Object pQueue = null;
			try {
				pQueue = pQueueConst.newInstance(6);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while creating an instance of \"PriorityQueue\".", false);

			}
			Method insert = Class.forName(priorityQueuePath).getDeclaredMethod("insert", Comparable.class);
			try {
				insert.invoke(pQueue, champPlayer1);
				insert.invoke(pQueue, champPlayer2);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"insert\" method on an instance of \"PriorityQueue\".",
						false);

			} catch (IllegalArgumentException e) {
				fail("\"insert\" in \"PriorityQueue\" class takes a \"Comparable\" object.");
			}

			queue.set(createdGame, pQueue);

			Method peek = Class.forName(priorityQueuePath).getDeclaredMethod("peekMin");
			Object target = null;
			try {
				target = peek.invoke(pQueue);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"peekMin\" method on an instance of \"PriorityQueue\".",
						false);

			}
			Method remove = Class.forName(priorityQueuePath).getDeclaredMethod("remove");
			Object enemy = null;
			try {
				remove.invoke(pQueue);
				enemy = remove.invoke(pQueue);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"remove\" method on an instance of \"PriorityQueue\".",
						false);

			}

			if (enemy.getClass().equals(Class.forName(antiHeroPath))
					|| (enemy.getClass().equals(Class.forName(heroPath)))
					|| (enemy.getClass().equals(Class.forName(villainPath)))) {
				Class<?> enemyEffect = Class.forName(championPath);
				Field appliedEffects = enemyEffect.getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				((ArrayList<Object>) appliedEffects.get(enemy)).add(shield);

			}

			Constructor<?> constructorDamagingAbility = Class.forName(dmgPath).getConstructor(String.class, int.class,
					int.class, int.class, Class.forName(areaOfEffectPath), int.class, int.class);
			Object damagingAbilityObject = null;
			try {
				damagingAbilityObject = constructorDamagingAbility.newInstance("Punch", 0, 1, 1,
						Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SURROUND"), 1, 50);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause() + " occurred while creating an instance of \"DamagingAbility\".", false);

			}

			if (target.getClass().equals(Class.forName(antiHeroPath))
					|| (target.getClass().equals(Class.forName(heroPath)))
					|| (target.getClass().equals(Class.forName(villainPath)))) {
				Class<?> enemyEffect = Class.forName(championPath);
				Field abilities = enemyEffect.getDeclaredField("abilities");
				abilities.setAccessible(true);
				((ArrayList<Object>) abilities.get(target)).add(damagingAbilityObject);

			}

			try {
				insert.invoke(pQueue, target);
				insert.invoke(pQueue, enemy);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"insert\" method on an instance of \"PriorityQueue\".",
						false);

			}

			Method m3 = createdGame.getClass().getMethod("castAbility", Class.forName(abilitiesPath));

			Field locationTarget = Class.forName(championPath).getDeclaredField("location");
			locationTarget.setAccessible(true);
			Point locationT = (Point) locationTarget.get(target);

			Method m5 = target.getClass().getMethod("getCurrentHP");
			int before = 0;
			try {
				before = (Integer) m5.invoke(enemy);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while invoking \"getCurrentHP\" method on an instance of \""
						+ enemy.getClass().getSimpleName() + "\".", false);

			}
			try {
				if (locationT.y == 3) {
					m3.invoke(createdGame, damagingAbilityObject);

				} else {
					m3.invoke(createdGame, damagingAbilityObject);
				}
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while invoking \"castAbility\" method on an instance of \"Game\".",
						false);

			}

			int after = 0;
			try {
				after = (Integer) m5.invoke(enemy);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause() + " occurred while invoking \"getCurrentHP\" method on an instance of \""
						+ enemy.getClass().getSimpleName() + "\".", false);

			}

			assertEquals("The method \"" + "castAbility" + "\" in class " + createdGame.getClass().getSimpleName()
					+ " should set the correct value of variable \"" + "currentHP"
					+ "\". When a champion has a \"Shield\" effect, he should block the casted \"DamagingAbility\".",
					before, after);
		} catch (InstantiationException e) {
			assertTrue(e.getClass().getName() + " occurred.", false);
		}

		catch (NoSuchMethodException e) {

			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		}

		catch (ClassNotFoundException e) {

			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

		}

	}

	@Test(timeout = 3000)
	public void testClassIsAbstractAbility() {
		try {
			testClassIsAbstract(Class.forName(abilityPath));
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Ability.", false);
		}
	}

	@Test(timeout = 3000)
	public void testExecuteExistsAbility() {
		Method m = null;
		try {
			m = Class.forName(abilityPath).getDeclaredMethod("execute", ArrayList.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Ability\" should contain a method called \"execute\" that takes an ArrayList of \"Damageable\" objects as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.world should contain an interface called \"Damageable\".", false);
		}
		assertTrue("Method \"execute\" in class \"Ability\" should be abstract.",
				Modifier.isAbstract(m.getModifiers()));
		assertTrue("Method \"execute\" in class \"Ability\" should be void.", m.getReturnType().equals(void.class));

	}

	@Test(timeout = 3000)
	public void testExecuteExistsInDamagingAbility() {
		try {
			Class.forName(dmgPath).getDeclaredMethod("execute", ArrayList.class);
		} catch (NoSuchMethodException e) {

			assertTrue(
					"The type \"DamagingAbility\" must implement the inherited abstract method Ability.execute(ArrayList<Damageable> targets).",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.abilities should contain a class called \"DamagingAbility\".", false);
		}

	}

	@Test(timeout = 3000)
	public void testExecuteExistsInHealingAbility() {
		try {
			Class.forName(healingPath).getDeclaredMethod("execute", ArrayList.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"The type \"HealingAbility\" must implement the inherited abstract method Ability.execute(ArrayList<Damageable> targets).",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.abilities should contain a class called \"HealingAbility\".", false);
		}

	}

	@Test(timeout = 3000)
	public void testExecuteExistsInCrowdControlAbility() {
		try {
			Method execute = Class.forName(ccAbilitiesPath).getDeclaredMethod("execute", ArrayList.class);

			boolean found = false;
			if (execute.getExceptionTypes().length != 0) {
				for (int i = 0; i < execute.getExceptionTypes().length; i++) {
					if (execute.getExceptionTypes()[i].getSimpleName().equals("CloneNotSupportedException")) {
						found = true;
					}
				}
				assertTrue(
						"Method \"execute\" in class \"CrowdControlAbility\" should throw the exception called \"java.lang.CloneNotSupportedException\".",
						found);

			} else {
				assertTrue(
						"Method \"execute\" in class \"CrowdControlAbility\" should throw the exception called \"java.lang.CloneNotSupportedException\".",
						false);
			}

		} catch (NoSuchMethodException e) {
			assertTrue(
					"The type \"CrowdControlAbility\" must implement the inherited abstract method Ability.execute(ArrayList<Damageable> targets).",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.abilities should contain a class called \"CrowdControlAbility\".", false);
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void executeLogicHealingAbility() {
		int randomCost = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomBaseCoolDown = (int) (Math.random() * 10) + 1;
		int randomCastRange = (int) (Math.random() * 100) + 20;
		int randomRequiredActions = (int) (Math.random() * 10) + 1;
		int randomHealingAmount = (int) (Math.random() * 100) + 20;
		int r2 = ((int) Math.random() * 4);
		int championsInstances = (int) (Math.random() * 10) + 1;
		Math.random();
		Object areaOfEffect = null;
		Constructor<?> constructorHealingAbility;
		ArrayList<Object> targets = new ArrayList<>();
		Field f2 = null;
		Object healingAbilityObject = null;
		String champInstance = "";
		Field dmg;

		try {
			if (r2 == 0)
				areaOfEffect = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SELFTARGET");
			else if (r2 == 1)
				areaOfEffect = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SINGLETARGET");
			else if (r2 == 2)
				areaOfEffect = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "TEAMTARGET");
			else
				areaOfEffect = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SURROUND");
			constructorHealingAbility = Class.forName(healingPath).getConstructor(String.class, int.class, int.class,
					int.class, Class.forName(areaOfEffectPath), int.class, int.class);
			healingAbilityObject = constructorHealingAbility.newInstance("Name_" + randomName, randomCost,
					randomBaseCoolDown, randomCastRange, areaOfEffect, randomRequiredActions, randomHealingAmount);

			for (int i = 0; i < championsInstances; i++) {
				int randomChampion = (int) (Math.random() * (2 + 1));
				if (randomChampion == 0)
					champInstance = heroPath;
				else if (randomChampion == 1)
					champInstance = antiHeroPath;
				else
					champInstance = villainPath;
				targets.add(createChampionInstance(champInstance));
			}

			Method execute = Class.forName(healingPath).getDeclaredMethod("execute", ArrayList.class);

			ArrayList<Object> expectedValue = new ArrayList<>();
			ArrayList<Object> actual = new ArrayList<>();

			for (int i = 0; i < targets.size(); i++) {
				dmg = Class.forName(championPath).getDeclaredField("currentHP");
				dmg.setAccessible(true);
				int old = (int) dmg.get(targets.get(i));
				f2 = Class.forName(healingPath).getDeclaredField("healAmount");
				f2.setAccessible(true);
				int healAmount = (int) f2.get(healingAbilityObject);

				expectedValue.add((int) (old + healAmount));
			}
			execute.invoke(healingAbilityObject, targets);

			for (int i = 0; i < targets.size(); i++) {
				dmg = Class.forName(championPath).getDeclaredField("currentHP");
				dmg.setAccessible(true);
				actual.add((int) dmg.get(targets.get(i)));

			}

			assertEquals(
					"The method \"" + "execute" + "\" in class \"" + healingAbilityObject.getClass().getSimpleName()
							+ "\" should set the correct value of variable \"" + "currentHP" + "\" of targets.",
					expectedValue, actual);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {

			assertTrue("Objects of type \"HealingAbility\" can be instantiated.", false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue(
					"\"Damageable\" objects must implement the inherited abstract methods Damageable.setCurrentHP(int) and Damageable.getCurrentHP().",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void executeLogicDamagingAbility() {
		int randomCost = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomBaseCoolDown = (int) (Math.random() * 10) + 1;
		int randomCastRange = (int) (Math.random() * 100) + 20;
		int randomRequiredActions = (int) (Math.random() * 10) + 1;
		int randomDamagingAmount = (int) (Math.random() * 10) + 1;
		int r2 = ((int) Math.random() * 4);
		int championsInstances = (int) (Math.random() * 10) + 1;
		int coverInstances = (int) (Math.random() * 5) + 1;
		Object areaOfEffect = null;
		Constructor<?> constructorDamagingAbility;
		ArrayList<Object> targets = new ArrayList<>();
		Field f2 = null;
		Object damagingAbilityObject = null;
		String champInstance = "";
		Field dmg;

		try {
			if (r2 == 0)
				areaOfEffect = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SELFTARGET");
			else if (r2 == 1)
				areaOfEffect = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SINGLETARGET");
			else if (r2 == 2)
				areaOfEffect = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "TEAMTARGET");
			else
				areaOfEffect = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SURROUND");
			constructorDamagingAbility = Class.forName(dmgPath).getConstructor(String.class, int.class, int.class,
					int.class, Class.forName(areaOfEffectPath), int.class, int.class);
			damagingAbilityObject = constructorDamagingAbility.newInstance("Name_" + randomName, randomCost,
					randomBaseCoolDown, randomCastRange, areaOfEffect, randomRequiredActions, randomDamagingAmount);

			for (int i = 0; i < championsInstances; i++) {
				int randomChampion = (int) (Math.random() * (2 + 1));
				if (randomChampion == 0)
					champInstance = heroPath;
				else if (randomChampion == 1)
					champInstance = antiHeroPath;
				else
					champInstance = villainPath;
				targets.add(createChampionInstance(champInstance));
			}

			for (int i = 0; i < coverInstances; i++) {
				targets.add(createCoverInstance());
			}

			Method execute = Class.forName(dmgPath).getDeclaredMethod("execute", ArrayList.class);

			ArrayList<Object> expectedValue = new ArrayList<>();
			ArrayList<Object> actual = new ArrayList<>();

			for (int i = 0; i < targets.size(); i++) {
				if ((targets.get(i).getClass().equals(Class.forName(antiHeroPath)))
						|| (targets.get(i).getClass().equals(Class.forName(heroPath)))
						|| (targets.get(i).getClass().equals(Class.forName(villainPath)))) {
					dmg = Class.forName(championPath).getDeclaredField("currentHP");
					dmg.setAccessible(true);
					int old = (int) dmg.get(targets.get(i));
					f2 = Class.forName(dmgPath).getDeclaredField("damageAmount");
					f2.setAccessible(true);
					int damageAmount = (int) f2.get(damagingAbilityObject);
					if (old - damageAmount < 0) {
						expectedValue.add(0);
					} else {
						expectedValue.add((int) (old - damageAmount));
					}

				} else if (targets.get(i).getClass().equals(Class.forName(coverPath))) {
					dmg = Class.forName(coverPath).getDeclaredField("currentHP");
					dmg.setAccessible(true);
					int old = (int) dmg.get(targets.get(i));
					f2 = Class.forName(dmgPath).getDeclaredField("damageAmount");
					f2.setAccessible(true);
					int damageAmount = (int) f2.get(damagingAbilityObject);
					int e = old - damageAmount;
					if (e < 0) {
						expectedValue.add(0);
					} else {
						expectedValue.add((int) (old - damageAmount));
					}
				}
			}
			execute.invoke(damagingAbilityObject, targets);

			for (int i = 0; i < targets.size(); i++) {
				if ((targets.get(i).getClass().equals(Class.forName(antiHeroPath)))
						|| (targets.get(i).getClass().equals(Class.forName(heroPath)))
						|| (targets.get(i).getClass().equals(Class.forName(villainPath)))) {
					dmg = Class.forName(championPath).getDeclaredField("currentHP");
					dmg.setAccessible(true);
					actual.add((int) dmg.get(targets.get(i)));
				} else if (targets.get(i).getClass().equals(Class.forName(coverPath))) {
					dmg = Class.forName(coverPath).getDeclaredField("currentHP");
					dmg.setAccessible(true);
					actual.add((int) dmg.get(targets.get(i)));
				}

			}

			assertEquals(
					"The method \"" + "execute" + "\" in class \"" + damagingAbilityObject.getClass().getSimpleName()
							+ "\" should set the correct value of variable \"" + "currentHP" + "\" of targets.",
					expectedValue, actual);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {

			assertTrue("Objects of type \"DamagingAbility\" can be instantiated.", false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue(
					"\"Damageable\" objects must implement the inherited abstract methods Damageable.setCurrentHP(int) and Damageable.getCurrentHP().",
					false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	// Tests Class Game
	@Test(timeout = 3000)
	public void testIsCastAbilityMethodExists() {
		Method[] methods = createGame().getClass().getDeclaredMethods();
		assertTrue("Class Game should contain a method named castAbility.", containsMethodName(methods, "castAbility"));
	}

	@Test(timeout = 3000)
	public void testCastAbilityInCoolDown() {
		// Add the current champ to the turnOrder
		Object game = createGame();
		Object champ = createRandomHero();
		addChampToTurnOrder(game, champ);
		Object ability = createHealingAbility("TEAMTARGET");
		clearBoard(game);
		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		Method m;
		try {
			m = ability.getClass().getMethod("setCurrentCooldown", int.class);
			m.invoke(ability, 2);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e1) {

			fail(e1.getClass() + " occurred");
		}

		try {
			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			fail("Trying to cast ability in cool down, an exception should be thrown");

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| ClassNotFoundException e) {
			fail("Trying to cast ability in cool down, an exception should be thrown");

		} catch (InvocationTargetException e) {
			try {
				if (!(Class.forName(abilityExceptionPath).equals(e.getCause().getClass())))
					fail("Trying to cast ability in cool down, an exception should be thrown");
			} catch (ClassNotFoundException e1) {

				e1.printStackTrace();
			}

		}

	}

	@SuppressWarnings("unchecked")
	@Test(timeout = 3000)
	public void testCastAbilityNotEnoughResources() {
		// Add the current champ to the turnOrder
		Object game = createGame();
		Object champ = createHero("Spiderman", 100, 0, 2, 2, 2, 2);
		addChampToTurnOrder(game, champ);
		Object ability = createHealingAbility("TEAMTARGET");
		clearBoard(game);
		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		try {
			Method m = champ.getClass().getMethod("getAbilities");
			((ArrayList<Object>) (m.invoke(champ))).add(ability);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e2) {

			e2.printStackTrace();
		}

		try {
			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			fail("Current Champion does not have enough resources for this ability, an exception should be thrown");

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| ClassNotFoundException e) {

			fail("Current Champion does not have enough resources for this ability, an exception should be thrown");
			fail(e.getCause().getClass() + " occurred");

		} catch (InvocationTargetException e) {
			try {
				if (!(Class.forName(notEnoughResourcesExceptionPath).equals(e.getCause().getClass())))
					fail("Current Champion does not have enough resources for this ability, an exception should be thrown");
			} catch (ClassNotFoundException e1) {

				e1.printStackTrace();
			}
		}

	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityChampionManaUpdatedCorrectly() {
		Object game = createGame();
		Object champ = createRandomHero();
		addChampToTurnOrder(game, champ);
		int randomCost = (int) (Math.random() * 20);

		Object ability = createDmgAbility("Dmg", randomCost, 2, 2, "SURROUND", 1, 10);
		int setMana = setRandomMana(champ);
		addAbilityToChampion(champ, ability);
		clearBoard(game);
		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			int expectedUpdatedMana = setMana - randomCost;

			m2 = champ.getClass().getMethod("getMana");
			assertEquals("Casting a damaging ability with enough mana should update the champion's mana correctly",
					expectedUpdatedMana, (int) (m2.invoke(champ)));

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| ClassNotFoundException | InvocationTargetException e) {
			fail("Trying to cast an ability but " + e.getCause().getClass() + " occurred");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCAbilityChampionManaUpdatedCorrectly() {
		Object game = createGame();
		Object champ = createRandomHero();
		addChampToTurnOrder(game, champ);
		Object effect = createSpeedUpEffect(2);
		int randomCost = (int) (Math.random() * 20);

		Object ability = createCCAbility("cc", randomCost, 2, 2, "SELFTARGET", 1, effect);
		int setMana = setRandomMana(champ);
		addAbilityToChampion(champ, ability);
		clearBoard(game);
		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			int expectedUpdatedMana = setMana - randomCost;

			m2 = champ.getClass().getMethod("getMana");
			assertEquals("Casting a crowd control ability with enough mana should update the champion's mana correctly",
					expectedUpdatedMana, (int) (m2.invoke(champ)));

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| ClassNotFoundException | InvocationTargetException e) {
			fail("Trying to cast an ability but " + e.getCause().getClass() + " occurred");

		}
	}

	// test update cool-down
	@Test(timeout = 3000)
	public void testCastAbilityCooldownUpdatedCorrectlyCCBuff() {
		Object game = createGame();
		Object champ = createRandomHero();
		addChampToTurnOrder(game, champ);
		Object effect = createSpeedUpEffect(2);
		int randomCooldown = (int) (Math.random() * 2) + 2;

		Object ability = createCCAbility("CC", 10, randomCooldown, 1, "SELFTARGET", 1, effect);
		addAbilityToChampion(champ, ability);
		clearBoard(game);
		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			m2 = ability.getClass().getMethod("getCurrentCooldown");
			assertEquals("Casting a crowd control ability should set the ability cooldown correctly", randomCooldown,
					(int) (m2.invoke(ability)));

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| ClassNotFoundException | InvocationTargetException e) {
			fail("Trying to cast an ability but " + e.getCause().getClass() + " occurred");

		}
	}

	@Test(timeout = 3000)
	public void testCastAbilityCooldownUpdatedCorrectlyHealing() {
		Object game = createGame();
		Object champ = createRandomHero();
		addChampToTurnOrder(game, champ);

		int randomCooldown = (int) (Math.random() * 2) + 2;
		Object ability = createHealingAbility("CC", 10, randomCooldown, 1, "SELFTARGET", 1, 100);
		addAbilityToChampion(champ, ability);
		clearBoard(game);
		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			m2 = ability.getClass().getMethod("getCurrentCooldown");
			assertEquals("Casting a healing ability should set the ability cooldown correctly", randomCooldown,
					(int) (m2.invoke(ability)));

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| ClassNotFoundException | InvocationTargetException e) {
			fail("Trying to cast an ability but " + e.getCause().getClass() + " occurred");

		}
	}

	// Directional
	@Test(timeout = 3000)
	public void testCastHealingAbilityDirectionalUpadteCooldown() {
		Object champ = createRandomHero();
		int randomRange = (int) Math.floor(Math.random() * (3 - 2 + 1) + 2);
		int randHealing = (int) (Math.random() * 30) + 10;
		int randomCooldown = (int) (Math.random() * 2) + 2;
		Object ability = createHealingAbility("", 10, randomCooldown, randomRange, "DIRECTIONAL", 10, randHealing);
		int max = 1;
		int min = 0;
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		ArrayList<Integer> values = new ArrayList<>();
		ArrayList<Integer> maxValues = new ArrayList<>();
		ArrayList<Point> pointsTaken = new ArrayList<>();
		// pointsTaken.add(new Point(randX, randY));
		for (int i = 0; i < myTeam.size(); i++) {

			if (!(myTeam.get(i).equals(champ))) {
				// set location of other champs
				max = randomRange + randY;
				min = randY + 1;
				int pos = (int) Math.floor(Math.random() * (max - min + 1) + min);
				while (pointsTaken.contains(new Point(randX, pos)) && pointsTaken.size() < 2) {
					pos = (int) Math.floor(Math.random() * (max - min + 1) + min);

				}
				pointsTaken.add(new Point(randX, pos));
				setLocationForObject(myTeam.get(i), randX, pos);
				addObjectToBoardGame(game, myTeam.get(i), randX, pos);

			}
			int rand = (int) (Math.random() * 30) + 60;
			setObjectHP(myTeam.get(i), rand);
			values.add(rand);
			maxValues.add(returnMaxHp(myTeam.get(i)));

		}

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnRightDirection());

			m2 = ability.getClass().getMethod("getCurrentCooldown");
			assertEquals("Casting a directional target healing ability should set the ability cooldown correctly",
					randomCooldown, (int) (m2.invoke(ability)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with right direction on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalDownUpadetCooldown() {
		Object champ = createRandomHero();
		int randomRange = (int) Math.floor(Math.random() * (3 - 2 + 1) + 2);
		Object effect = createDodgeEffect(2);
		int randomCooldown = (int) (Math.random() * 2) + 2;

		Object ability = createCCAbility("h", 10, randomCooldown, randomRange, "DIRECTIONAL", 1, effect);

		int max = 4;
		int min = 3;
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> myTeam = createFirstPlayerTeam(firstPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		ArrayList<Point> pointsTaken = new ArrayList<>();

		for (int i = 0; i < myTeam.size(); i++) {
			if (!myTeam.get(i).equals(champ)) {
				// set location of other champs
				max = randX - 1;
				min = randX - randomRange;
				int pos = (int) Math.floor(Math.random() * (max - min + 1) + min);

				while (pointsTaken.contains(new Point(pos, randY)) && pointsTaken.size() < 2) {
					pos = (int) Math.floor(Math.random() * (max - min + 1) + min);

				}
				pointsTaken.add(new Point(pos, randY));
				setLocationForObject(myTeam.get(i), pos, randY);
				addObjectToBoardGame(game, myTeam.get(i), pos, randY);
			}

		}

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnDownDirection());

			m2 = ability.getClass().getMethod("getCurrentCooldown");
			assertEquals("Casting a directional target cc ability should set the ability cooldown correctly",
					randomCooldown, (int) (m2.invoke(ability)));

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with down direction");

		}

	}

	// Single target
	@Test(timeout = 3000)
	public void testCastHealingAbilitySingleTargetUpdateCooldown() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randX = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randomRange = (int) Math.floor(Math.random() * (2 - 1 + 1) + 1);
		int randAmount = (int) (Math.random() * 30) + 10;

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, true, champ);

		Object game = createGame(firstPlayer, secPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		addChampToTurnOrder(game, champ);
		int randomCooldown = (int) (Math.random() * 2) + 2;
		Object ability = createHealingAbility("", 10, randomCooldown, randomRange, "SINGLETARGET", 10, randAmount);

		addAbilityToChampion(champ, ability);

		int max = randomRange + randX;
		int min = randX + 1;
		int rX = (int) Math.floor(Math.random() * (max - min + 1) + min);

		int randHP = (int) (Math.random() * 30) + 10;

		setObjectHP(team.get(1), randHP);
		addObjectToBoardGame(game, team.get(1), rX, randY);
		setLocationForObject(team.get(1), rX, randY);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, rX, randY);

			m2 = ability.getClass().getMethod("getCurrentCooldown");
			assertEquals("Casting a single target healing ability should set the ability cooldown correctly",
					randomCooldown, (int) (m2.invoke(ability)));

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");

		}

	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilitySingleTargetUpdateCooldown() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randX = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randomRange = (int) Math.floor(Math.random() * (2 - 1 + 1) + 1);
		int randAmount = (int) (Math.random() * 30) + 10;

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createFirstPlayerTeam(secPlayer, false, champ);

		Object game = createGame(firstPlayer, secPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		addChampToTurnOrder(game, champ);
		int randomCooldown = (int) (Math.random() * 2) + 2;
		Object ability = createDmgAbility("", 10, randomCooldown, randomRange, "SINGLETARGET", 10, randAmount);

		addAbilityToChampion(champ, ability);

		int max = randomRange + randX;
		int min = randX + 1;
		int rX = (int) Math.floor(Math.random() * (max - min + 1) + min);

		int randHP = (int) (Math.random() * 30) + 10;

		setObjectHP(team.get(1), randHP);
		addObjectToBoardGame(game, team.get(1), rX, randY);
		setLocationForObject(team.get(1), rX, randY);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, rX, randY);

			m2 = ability.getClass().getMethod("getCurrentCooldown");
			assertEquals("Casting a single target damaging ability should set the ability cooldown correctly",
					randomCooldown, (int) (m2.invoke(ability)));

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilitySingleTargetUpdateCooldown() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randX = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randomRange = (int) Math.floor(Math.random() * (2 - 1 + 1) + 1);
		Math.random();

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, true, champ);

		Object game = createGame(firstPlayer, secPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		addChampToTurnOrder(game, champ);
		int randomCooldown = (int) (Math.random() * 2) + 2;
		Object effect = createSpeedUpEffect(2);
		Object ability = createCCAbility("", 10, randomCooldown, randomRange, "SINGLETARGET", 10, effect);

		addAbilityToChampion(champ, ability);

		int max = randomRange + randX;
		int min = randX + 1;
		int rX = (int) Math.floor(Math.random() * (max - min + 1) + min);

		int randHP = (int) (Math.random() * 30) + 10;

		setObjectHP(team.get(1), randHP);
		addObjectToBoardGame(game, team.get(1), rX, randY);
		setLocationForObject(team.get(1), rX, randY);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, rX, randY);

			m2 = ability.getClass().getMethod("getCurrentCooldown");
			assertEquals("Casting a single target crowd control ability should set the ability cooldown correctly",
					randomCooldown, (int) (m2.invoke(ability)));

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");

		}

	}

//		Update MANA and Action Points
	// Directional
	@Test(timeout = 3000)
	public void testCastHealingAbilityDirectionalUpadteMana() {
		Object champ = createRandomHero();
		int randHealing = (int) (Math.random() * 30) + 10;
		int randomMana = (int) (Math.random() * 2) + 2;

		Object ability = createHealingAbility("", randomMana, 1, 1, "DIRECTIONAL", 10, randHealing);
		int max = 1;
		int min = 0;
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		addObjectToBoardGame(game, myTeam.get(1), randX, randY + 1);
		setLocationForObject(myTeam.get(1), randX, randY + 1);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			int mana = setRandomMana(champ);
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnRightDirection());

			int expected = mana - randomMana;

			m2 = champ.getClass().getMethod("getMana");
			assertEquals("Casting a directional target healing ability should update the champion's mana correctly",
					expected, (int) (m2.invoke(champ)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with right direction on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastDamgingAbilityDirectionalUpadteAP() {
		Object champ = createRandomHero();
		int randomRequiredActionPoints = (int) (Math.random() * 2) + 1;
		int setAP = setRandomActionPoints(champ);
		Object ability = createHealingAbility("", 1, 2, 2, "DIRECTIONAL", randomRequiredActionPoints, 100);

		int max = 4;
		int min = 3;
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		addObjectToBoardGame(game, myTeam.get(1), randX, randY - 1);
		setLocationForObject(myTeam.get(1), randX, randY - 1);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnLeftDirection());

			int expected = setAP - randomRequiredActionPoints;

			m2 = champ.getClass().getMethod("getCurrentActionPoints");
			assertEquals(
					"Casting a directional target healing ability should update the champion's action points correctly",
					expected, (int) (m2.invoke(champ)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with left direction on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalUpadteMana1() {
		Object champ = createRandomHero();
		int randomMana = (int) (Math.random() * 2) + 2;
		Object effect = createDisarmEffect(2);
		Object ability = createCCAbility("", randomMana, 1, 1, "DIRECTIONAL", 10, effect);
		int max = 4;
		int min = 3;
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		addObjectToBoardGame(game, myTeam.get(1), randX - 1, randY);
		setLocationForObject(myTeam.get(1), randX - 1, randY);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			int mana = setRandomMana(champ);
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnDownDirection());

			int expected = mana - randomMana;

			m2 = champ.getClass().getMethod("getMana");
			assertEquals("Casting a directional target healing ability should update the champion's mana correctly",
					expected, (int) (m2.invoke(champ)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with down direction on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalUpadteAP2() {
		Object champ = createRandomHero();
		int randomRequiredActionPoints = (int) (Math.random() * 2) + 1;
		int setAP = setRandomActionPoints(champ);
		Object effect = createPowerUpEffect(2);
		Object ability = createCCAbility("", 1, 2, 2, "DIRECTIONAL", randomRequiredActionPoints, effect);
		int max = 1;
		int min = 0;
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> myTeam = createFirstPlayerTeam(firstPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		addObjectToBoardGame(game, myTeam.get(1), randX + 1, randY);
		setLocationForObject(myTeam.get(1), randX + 1, randY);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnUpDirection());

			int expected = setAP - randomRequiredActionPoints;

			m2 = champ.getClass().getMethod("getCurrentActionPoints");
			assertEquals(
					"Casting a directional target healing ability should update the champion's action points correctly",
					expected, (int) (m2.invoke(champ)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with up direction on target");

		}

	}

	// Single target
	@Test(timeout = 3000)
	public void testCastHealingAbilitySingleTargetUpadteMana() {
		Object champ = createRandomHero();
		int randHealing = (int) (Math.random() * 30) + 10;
		int randomMana = (int) (Math.random() * 2) + 2;

		Object ability = createHealingAbility("", randomMana, 1, 1, "SINGLETARGET", 10, randHealing);
		int max = 1;
		int min = 0;
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		addObjectToBoardGame(game, myTeam.get(1), randX, randY + 1);
		setLocationForObject(myTeam.get(1), randX, randY + 1);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			int mana = setRandomMana(champ);
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, randX, randY + 1);

			int expected = mana - randomMana;

			m2 = champ.getClass().getMethod("getMana");
			assertEquals("Casting a single target healing ability should update the champion's mana correctly",
					expected, (int) (m2.invoke(champ)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast a single target ability on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastDamgingAbilitySINGLETARGETUpadteAP() {
		Object champ = createRandomHero();
		int randomRequiredActionPoints = (int) (Math.random() * 2) + 1;
		int setAP = setRandomActionPoints(champ);
		Object ability = createDmgAbility("", 1, 2, 2, "SINGLETARGET", randomRequiredActionPoints, 100);

		int max = 4;
		int min = 3;
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		addObjectToBoardGame(game, myTeam.get(1), randX, randY - 1);
		setLocationForObject(myTeam.get(1), randX, randY - 1);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, randX, randY - 1);

			int expected = setAP - randomRequiredActionPoints;

			m2 = champ.getClass().getMethod("getCurrentActionPoints");
			assertEquals("Casting a single target ability should update the champion's action points correctly",
					expected, (int) (m2.invoke(champ)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast a single target ability");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilitySINGLETARGETUpadteMana1() {
		Object champ = createRandomHero();
		int randomMana = (int) (Math.random() * 2) + 2;
		Object effect = createDisarmEffect(2);
		Object ability = createCCAbility("", randomMana, 1, 1, "SINGLETARGET", 10, effect);
		int max = 4;
		int min = 3;
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		addObjectToBoardGame(game, myTeam.get(1), randX - 1, randY);
		setLocationForObject(myTeam.get(1), randX - 1, randY);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			int mana = setRandomMana(champ);
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, randX - 1, randY);

			int expected = mana - randomMana;

			m2 = champ.getClass().getMethod("getMana");
			assertEquals("Casting a single target cc ability should update the champion's mana correctly", expected,
					(int) (m2.invoke(champ)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast a single target cc ability");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilitySINGLETARGETUpadteAP1() {
		Object champ = createRandomHero();
		int randomRequiredActionPoints = (int) (Math.random() * 2) + 1;
		int setAP = setRandomActionPoints(champ);
		Object effect = createDisarmEffect(2);
		Object ability = createCCAbility("", 1, 2, 2, "SINGLETARGET", randomRequiredActionPoints, effect);
		int max = 4;
		int min = 3;
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		addObjectToBoardGame(game, myTeam.get(1), randX - 1, randY);
		setLocationForObject(myTeam.get(1), randX - 1, randY);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, randX - 1, randY);

			int expected = setAP - randomRequiredActionPoints;

			m2 = champ.getClass().getMethod("getCurrentActionPoints");
			assertEquals("Casting a single target cc ability should update the champion's action points correctly",
					expected, (int) (m2.invoke(champ)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast a single target cc ability");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityChampionActionPointsUpdatedCorrectly() {
		Object game = createGame();
		Object champ = createRandomHero();
		addChampToTurnOrder(game, champ);
		Object effect = createEmbraceEffect(2);
		int randomCost = (int) (Math.random() * 20);
		int randomRequiredActionPoints = (int) (Math.random() * 2) + 1;
		Object ability = createCCAbility("cc", randomCost, 2, 2, "SELFTARGET", randomRequiredActionPoints, effect);
		int setAP = setRandomActionPoints(champ);

		addAbilityToChampion(champ, ability);
		clearBoard(game);
		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			int expectedUpdatedActionPoints = setAP - randomRequiredActionPoints;

			m2 = champ.getClass().getMethod("getCurrentActionPoints");
			assertEquals(
					"Casting crowd control ability with enough action points should update the champion's action points correctly",
					expectedUpdatedActionPoints, (int) (m2.invoke(champ)));

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| ClassNotFoundException | InvocationTargetException e) {
			fail("Trying to cast an ability but " + e.getCause().getClass() + " occurred");

		}
	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityChampionActionPointsUpdatedCorrectly() {
		Object game = createGame();
		Object champ = createRandomHero();
		addChampToTurnOrder(game, champ);
		int randomCost = (int) (Math.random() * 20);
		int randomRequiredActionPoints = (int) (Math.random() * 2) + 1;
		Object ability = createDmgAbility("cc", randomCost, 2, 2, "SURROUND", randomRequiredActionPoints, 10);
		int setAP = setRandomActionPoints(champ);

		addAbilityToChampion(champ, ability);
		clearBoard(game);
		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			int expectedUpdatedActionPoints = setAP - randomRequiredActionPoints;

			m2 = champ.getClass().getMethod("getCurrentActionPoints");
			assertEquals(
					"Casting damaging ability with enough action points should update the champion's action points correctly",
					expectedUpdatedActionPoints, (int) (m2.invoke(champ)));

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| ClassNotFoundException | InvocationTargetException e) {
			fail("Trying to cast an ability but " + e.getCause().getClass() + " occurred");

		}
	}

	@Test(timeout = 3000)
	public void testCastHealingAbilitySELFTARGET() {
		Object game = createGame();
		Object champ = createHero("ironMan", 100, 10, 20, 30, 40, 50);
		addChampToTurnOrder(game, champ);
		Object ability = createHealingAbility("SELFTARGET");
		addAbilityToChampion(champ, ability);
		clearBoard(game);
		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		try {
			Method m = champ.getClass().getMethod("setCurrentHP", int.class);
			int randomHp = (int) (Math.random() * 20);
			m.invoke(champ, randomHp);

			m = ability.getClass().getMethod("setHealAmount", int.class);
			int randomHealingAbility = (int) (Math.random() * 30);
			m.invoke(ability, randomHealingAbility);

			int expectedCurrentHp = randomHp + randomHealingAbility;

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			m = champ.getClass().getMethod("getCurrentHP");
			assertEquals("Casting healing ability with SELFTARGET is not applied correctly on current HP",
					expectedCurrentHp, m.invoke(champ));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting healing ability with area of effect SELFTARGET");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilitySELFTARGETEmbrace() {
		Object champ = createHero("ironMan", 100, 1000, 200, 300, 400, 500);
		Object effect = createEmbraceEffect(2);
		Object ability = createCCAbility("SELFTARGET", effect);

		addAbilityToChampion(champ, ability);
		Object game = createGame();
		clearBoard(game);
		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		addChampToTurnOrder(game, champ);
		int randomHp = (int) (Math.random() * 60);
		int randomMana = 1000;
		int randomSpeed = (int) (Math.random() * 60);
		int randomAttackDamage = (int) (Math.random() * 60);
		try {
			Method m = champ.getClass().getMethod("setCurrentHP", int.class);
			m.invoke(champ, randomHp);
			m = champ.getClass().getMethod("setMana", int.class);
			m.invoke(champ, randomMana);
			m = champ.getClass().getMethod("setSpeed", int.class);
			m.invoke(champ, randomSpeed);
			m = champ.getClass().getMethod("setAttackDamage", int.class);
			m.invoke(champ, randomAttackDamage);

			int expectedCurrentHp = (int) (randomHp + 0.2 * returnMaxHp(champ));
			m = ability.getClass().getMethod("getManaCost");
			int updatedMana = (int) (randomMana * (1 + 0.2));
			int expectedCurrentMana = (int) (randomMana * (1 + 0.2)) - (int) (m.invoke(ability));
			int expectedCurrentSpeed = (int) (randomSpeed * (1 + 0.2));
			int expectedCurrentAttack = (int) (randomAttackDamage * (1 + 0.2));

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			m = champ.getClass().getMethod("getCurrentHP");
			assertEquals(
					"Casting CrowdControlAbility with SELFTARGET is not applied correctly on current champion's HP",
					expectedCurrentHp, m.invoke(champ));

			m = champ.getClass().getMethod("getMana");
			assertFalse("Casting CrowdControlAbility with Embrace effect should update the mana first be",
					updatedMana == (int) m.invoke(champ));
			assertEquals(
					"Casting CrowdControlAbility with SELFTARGET is not applied correctly on current champion's mana",
					expectedCurrentMana, m.invoke(champ));

			m = champ.getClass().getMethod("getSpeed");
			assertEquals(
					"Casting CrowdControlAbility with SELFTARGET is not applied correctly on current champion's speed",
					expectedCurrentSpeed, m.invoke(champ));
			m = champ.getClass().getMethod("getAttackDamage");
			assertEquals(
					"Casting CrowdControlAbility with SELFTARGET is not applied correctly on current champion's attack damage",
					expectedCurrentAttack, m.invoke(champ));

		} catch (Exception e) {

			fail(e.getCause().getClass()
					+ " occurred while casting CrowdControlAbility with area of effect SELFTARGET");

		}
	}

	// Start directional
	// Cast Ability with direction

	@SuppressWarnings("unchecked")
	@Test(timeout = 3000)
	public void testCastAbilityDirectionNotEnoughResources2() {
		// Add the current champ to the turnOrder
		Object champ = createHero("Spiderman", 100, 100, 0, 2, 2, 2);
		Object game = createGame();
		clearBoard(game);

		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		addChampToTurnOrder(game, champ);
		Object ability = createHealingAbility("DIRECTIONAL");
		try {
			Method m = champ.getClass().getMethod("getAbilities");
			((ArrayList<Object>) (m.invoke(champ))).add(ability);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e2) {

			e2.printStackTrace();
		}

		try {
			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath),
					Class.forName(directionPath));
			m2.invoke(game, ability, returnDownDirection());

			fail("Current Champion does not have enough resources for this ability, an exception should be thrown");

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| ClassNotFoundException e) {

			fail("Current Champion does not have enough resources for this ability, an exception should be thrown");
			fail(e.getCause().getClass() + " occurred");

		} catch (InvocationTargetException e) {
			try {
				if (!(Class.forName(notEnoughResourcesExceptionPath).equals(e.getCause().getClass())))
					fail("Current Champion does not have enough resources for this ability, an exception should be thrown");
			} catch (ClassNotFoundException e1) {

				e1.printStackTrace();
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Test(timeout = 3000)
	public void testCastAbilityDirectionNotEnoughResources() {
		// Add the current champ to the turnOrder
		Object champ = createHero("Spiderman", 100, 0, 2, 2, 2, 2);
		Object game = createGame();
		clearBoard(game);

		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		addChampToTurnOrder(game, champ);
		Object ability = createHealingAbility("DIRECTIONAL");
		try {
			Method m = champ.getClass().getMethod("getAbilities");
			((ArrayList<Object>) (m.invoke(champ))).add(ability);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e2) {

			e2.printStackTrace();
		}

		try {
			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath),
					Class.forName(directionPath));
			m2.invoke(game, ability, returnDownDirection());

			fail("Current Champion does not have enough resources for this ability, an exception should be thrown");

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| ClassNotFoundException e) {

			fail("Current Champion does not have enough resources for this ability, an exception should be thrown");
			fail(e.getCause().getClass() + " occurred");

		} catch (InvocationTargetException e) {
			try {
				if (!(Class.forName(notEnoughResourcesExceptionPath).equals(e.getCause().getClass())))
					fail("Current Champion does not have enough resources for this ability, an exception should be thrown");
			} catch (ClassNotFoundException e1) {

				e1.printStackTrace();
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Test(timeout = 3000)
	public void testCastAbilityDIRECTIONALCurrentChampInSilence() {
		// Add the current champ to the turnOrder
		Object game = createGame();
		Object champ = createRandomHero();
		clearBoard(game);

		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		addChampToTurnOrder(game, champ);
		Object ability = createHealingAbility("DIRECTIONAL");
		addAbilityToChampion(champ, ability);
		try {
			Method m = champ.getClass().getMethod("getAppliedEffects");
			((ArrayList<Object>) (m.invoke(champ))).add(createSilenceEffect(2));
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e2) {

			e2.printStackTrace();
		}

		try {
			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath),
					Class.forName(directionPath));
			m2.invoke(game, ability, returnDownDirection());
			fail("Trying to cast ability with direction while champion has silence effect applied, an exception should be thrown");

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| ClassNotFoundException e) {

			fail("Trying to cast ability with direction while champion has silence effect applied, an exception should be thrown");
			fail(e.getCause().getClass() + " occurred");

		} catch (InvocationTargetException e) {
			try {
				if (!(Class.forName(abilityExceptionPath).equals(e.getCause().getClass())))
					fail("Trying to cast ability with direction while champion has silence effect applied, an exception should be thrown");
			} catch (ClassNotFoundException e1) {

				e1.printStackTrace();
			}

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityDIRECTIONALOutOfRangeUp() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();
		int randomRange = (int) (Math.random() * 3);
		Object ability = createHealingAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, 10);

		int randX = (int) (Math.random() * 2);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		int max = 4;
		int min = randX + randomRange + 1;
		int pos = (int) Math.floor(Math.random() * (max - min + 1) + min);
		addObjectToBoardGame(game, myTeam.get(1), pos, randY);
		setLocationForObject(myTeam.get(1), pos, randY);

		addObjectToBoardGame(game, myTeam.get(2), randX + randomRange, randY - 1);
		setLocationForObject(myTeam.get(2), randX + randomRange, randY - 1);

		ArrayList<Integer> values = new ArrayList<>();
		values.add(returnHp(champ));
		values.add(returnHp(myTeam.get(1)));
		values.add(returnHp(myTeam.get(2)));

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnUpDirection());

			for (int i = 0; i < myTeam.size(); i++) {
				assertEquals(
						"Casting up healing ability on target out of range should not change unreachable target's HP",
						(int) values.get(i), returnHp(myTeam.get(i)));
			}

		} catch (Exception e) {

			fail("Trying to cast ability with direction on target out of range");
			fail(e.getCause().getClass() + " occurred");

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityDIRECTIONALOutOfRangeRight() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();
		int randomRange = (int) (Math.random() * 2) + 1;
		Object ability = createHealingAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, 10);

		int randX = (int) Math.floor(Math.random() * (3 - 0 + 1) + 0);
		int randY = (int) (Math.random() * 2);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		int max = 4;
		int min = randY + randomRange + 1;
		int pos = (int) Math.floor(Math.random() * (max - min + 1) + min);

		addObjectToBoardGame(game, myTeam.get(1), randX + 1, randY);
		setLocationForObject(myTeam.get(1), randX + 1, randY);
		addObjectToBoardGame(game, myTeam.get(2), randX, pos);
		setLocationForObject(myTeam.get(2), randX, pos);

		ArrayList<Integer> values = new ArrayList<>();
		values.add(returnHp(champ));
		values.add(returnHp(myTeam.get(1)));
		values.add(returnHp(myTeam.get(2)));

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnRightDirection());

			for (int i = 0; i < myTeam.size(); i++) {
				assertEquals(
						"Casting right healing ability on target out of range should not change unreachable target's HP",
						(int) values.get(i), returnHp(myTeam.get(i)));
			}

		} catch (Exception e) {

			fail("Trying to cast ability with direction on target out of range");
			fail(e.getCause().getClass() + " occurred");

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityDIRECTIONALOutOfRangeLeft() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();
		int randomRange = (int) (Math.random() * 2) + 1;
		Object ability = createHealingAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, 10);

		int randX = (int) Math.floor(Math.random() * (3 - 0 + 1) + 0);
		int randY = (int) Math.floor(Math.random() * (4 - 3 + 1) + 3);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		int max = randY - randomRange - 1;
		int min = 0;
		// randY+randomRange+1;
		int pos = (int) Math.floor(Math.random() * (max - min + 1) + min);

		addObjectToBoardGame(game, myTeam.get(1), randX + 1, randY);
		setLocationForObject(myTeam.get(1), randX + 1, randY);
		addObjectToBoardGame(game, myTeam.get(2), randX, pos);
		setLocationForObject(myTeam.get(2), randX, pos);

		ArrayList<Integer> values = new ArrayList<>();
		values.add(returnHp(champ));
		values.add(returnHp(myTeam.get(1)));
		values.add(returnHp(myTeam.get(2)));

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnLeftDirection());

			for (int i = 0; i < myTeam.size(); i++) {
				assertEquals(
						"Casting left healing ability on target out of range should not change unreachable target's HP",
						(int) values.get(i), returnHp(myTeam.get(i)));
			}

		} catch (Exception e) {

			fail("Trying to cast ability with direction on target out of range");
			fail(e.getCause().getClass() + " occurred");

		}

	}

	@Test(timeout = 3000)
	public void testCastDmgAbilityDIRECTIONALOutOfRangeUp() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();
		int randomRange = (int) (Math.random() * 3);
		Object ability = createDmgAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, 10);

		int randX = (int) (Math.random() * 2);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> otherTeam = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		int max = 4;
		int min = randX + randomRange + 1;
		int pos = (int) Math.floor(Math.random() * (max - min + 1) + min);
		addObjectToBoardGame(game, otherTeam.get(1), pos, randY);
		setLocationForObject(otherTeam.get(1), pos, randY);

		addObjectToBoardGame(game, otherTeam.get(2), randX + randomRange, randY - 1);
		setLocationForObject(otherTeam.get(2), randX + randomRange, randY - 1);

		ArrayList<Integer> values = new ArrayList<>();
		values.add(returnHp(otherTeam.get(0)));
		values.add(returnHp(otherTeam.get(1)));
		values.add(returnHp(otherTeam.get(2)));

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnUpDirection());

			for (int i = 0; i < otherTeam.size(); i++) {
				assertEquals(
						"Casting up damaging ability on target out of range should not change unreachable target's HP",
						(int) values.get(i), returnHp(otherTeam.get(i)));
			}

		} catch (Exception e) {

			fail("Trying to cast ability with direction on target out of range");
			fail(e.getCause().getClass() + " occurred");

		}

	}

	@Test(timeout = 3000)
	public void testCastDmgAbilityDIRECTIONALOutOfRangeDown() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();
		int randomRange = (int) (Math.random() * 2) + 1;
		Object ability = createDmgAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, 10);

		int randX = (int) Math.floor(Math.random() * (4 - 3 + 1) + 3);
		int randY = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> otherTeam = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		int max = randX - randomRange - 1;
		int min = 0;
		int pos = (int) Math.floor(Math.random() * (max - min + 1) + min);

		addObjectToBoardGame(game, otherTeam.get(1), pos, randY);
		setLocationForObject(otherTeam.get(1), pos, randY);

		addObjectToBoardGame(game, otherTeam.get(2), randX - randomRange, randY - 1);
		setLocationForObject(otherTeam.get(2), randX - randomRange, randY - 1);

		ArrayList<Integer> values = new ArrayList<>();
		values.add(returnHp(otherTeam.get(0)));
		values.add(returnHp(otherTeam.get(1)));
		values.add(returnHp(otherTeam.get(2)));

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnDownDirection());

			for (int i = 0; i < otherTeam.size(); i++) {
				assertEquals(
						"Casting down damaging ability on target out of range should not change unreachable target's HP",
						(int) values.get(i), returnHp(otherTeam.get(i)));
			}

		} catch (Exception e) {

			fail("Trying to cast ability with direction on target out of range");
			fail(e.getCause().getClass() + " occurred");

		}

	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityDIRECTIONALOutOfRangeRight() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();
		int randomRange = (int) (Math.random() * 2) + 1;
		Object ability = createDmgAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, 10);

		int randX = (int) Math.floor(Math.random() * (3 - 0 + 1) + 0);
		int randY = (int) (Math.random() * 2);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> otherTeam = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		int max = 4;
		int min = randY + randomRange + 1;
		int pos = (int) Math.floor(Math.random() * (max - min + 1) + min);

		addObjectToBoardGame(game, otherTeam.get(1), randX + 1, randY);
		setLocationForObject(otherTeam.get(1), randX + 1, randY);
		addObjectToBoardGame(game, otherTeam.get(2), randX, pos);
		setLocationForObject(otherTeam.get(2), randX, pos);

		ArrayList<Integer> values = new ArrayList<>();
		values.add(returnHp(otherTeam.get(0)));
		values.add(returnHp(otherTeam.get(1)));
		values.add(returnHp(otherTeam.get(2)));

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnRightDirection());

			for (int i = 0; i < otherTeam.size(); i++) {
				assertEquals(
						"Casting right damaging ability on target out of range should not change unreachable target's HP",
						(int) values.get(i), returnHp(otherTeam.get(i)));
			}

		} catch (Exception e) {

			fail("Trying to cast ability with direction on target out of range");
			fail(e.getCause().getClass() + " occurred");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDIRECTIONALOutOfRangeDown() {
		Object champ = createRandomHero();
		int randomRange = (int) (Math.random() * 2) + 1;
		Object effect = createEmbraceEffect(2);
		Object ability = createCCAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, effect);

		int randX = (int) Math.floor(Math.random() * (4 - 3 + 1) + 3);
		int randY = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		int max = randX - randomRange - 1;
		int min = 0;
		int posX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		addObjectToBoardGame(game, myTeam.get(1), posX, randY);
		setLocationForObject(myTeam.get(1), posX, randY);

		addObjectToBoardGame(game, myTeam.get(2), randX, randY - 1);
		setLocationForObject(myTeam.get(2), randX, randY - 1);

		ArrayList<Integer> values = new ArrayList<>();
		values.add(returnHp(champ));
		values.add(returnHp(myTeam.get(1)));
		values.add(returnHp(myTeam.get(2)));

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnDownDirection());

			for (int i = 0; i < myTeam.size(); i++) {
				assertEquals("Casting down CC ability on target out of range should not change unreachable target's HP",
						(int) values.get(i), returnHp(myTeam.get(i)));
			}

		} catch (Exception e) {

			fail("Trying to cast ability with direction on target out of range");
			fail(e.getCause().getClass() + " occurred");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDIRECTIONALOutOfRangeRight() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();
		int randomRange = (int) (Math.random() * 2) + 1;
		Object effect = createEmbraceEffect(2);
		Object ability = createCCAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, effect);

		int randX = (int) Math.floor(Math.random() * (3 - 0 + 1) + 0);
		int randY = (int) (Math.random() * 2);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> otherTeam = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		int max = 4;
		int min = randY + randomRange + 1;
		int pos = (int) Math.floor(Math.random() * (max - min + 1) + min);

		addObjectToBoardGame(game, otherTeam.get(1), randX + 1, randY);
		setLocationForObject(otherTeam.get(1), randX + 1, randY);
		addObjectToBoardGame(game, otherTeam.get(2), randX, pos);
		setLocationForObject(otherTeam.get(2), randX, pos);

		ArrayList<Integer> values = new ArrayList<>();
		values.add(returnHp(otherTeam.get(0)));
		values.add(returnHp(otherTeam.get(1)));
		values.add(returnHp(otherTeam.get(2)));

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m, m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnUpDirection());

			for (int i = 0; i < otherTeam.size(); i++) {
				Class<?> c = Class.forName(conditionPath);

				Method valueOf = c.getMethod("valueOf", String.class);
				Object value = valueOf.invoke(null, "ACTIVE");

				m = otherTeam.get(i).getClass().getMethod("getCondition");
				assertEquals(
						"Casting up CC ability on target out of range should not change unreachable target's condition",
						value, m.invoke(otherTeam.get(i)));
			}

		} catch (Exception e) {

			fail("Trying to cast ability with direction on target out of range");
			fail(e.getCause().getClass() + " occurred");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDIRECTIONALOutOfRangeLeft() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();
		int randomRange = (int) (Math.random() * 2) + 1;
		Object effect = createEmbraceEffect(2);
		Object ability = createCCAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, effect);

		int randX = (int) Math.floor(Math.random() * (3 - 0 + 1) + 0);
		int randY = (int) Math.floor(Math.random() * (4 - 3 + 1) + 3);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> otherTeam = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		int max = randY - randomRange - 1;
		int min = 0;
		// randY+randomRange+1;
		int pos = (int) Math.floor(Math.random() * (max - min + 1) + min);

		addObjectToBoardGame(game, otherTeam.get(1), randX + 1, randY);
		setLocationForObject(otherTeam.get(1), randX + 1, randY);
		addObjectToBoardGame(game, otherTeam.get(2), randX, pos);
		setLocationForObject(otherTeam.get(2), randX, pos);

		ArrayList<Integer> values = new ArrayList<>();
		values.add(returnHp(otherTeam.get(0)));
		values.add(returnHp(otherTeam.get(1)));
		values.add(returnHp(otherTeam.get(2)));

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnLeftDirection());

			for (int i = 0; i < otherTeam.size(); i++) {
				assertEquals("Casting left CC ability on target out of range should not change unreachable target's HP",
						(int) values.get(i), returnHp(otherTeam.get(i)));
			}

		} catch (Exception e) {

			fail("Trying to cast ability with direction on target out of range");
			fail(e.getCause().getClass() + " occurred");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalUpObstcale() {
		Object champ = createRandomHero();
		int randomRange = 3;
		Object effect = createStunEffect(1);

		Object ability = createCCAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, effect);

		int randX = (int) (Math.random() * 3);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		Object cover = createCover(randX + 1, randY);
		addObjectToBoardGame(game, cover, randX + 1, randY);

		setLocationForObject(team.get(1), randX + 2, randY);
		addObjectToBoardGame(game, team.get(1), randX + 2, randY);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m, m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnUpDirection());

			Class<?> c = Class.forName(conditionPath);

			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, "ACTIVE");

			m = champ.getClass().getMethod("getCondition");
			assertEquals(
					"Casting up Stun crowd control ability is not applied correctly, should not affect the current champion's condition",
					value, m.invoke(champ));

			value = valueOf.invoke(null, "INACTIVE");

			m = team.get(1).getClass().getMethod("getCondition");
			assertEquals(
					"Casting up Stun crowd control ability is not applied correctly, should affect any target within the given direction, target's condition",
					value, m.invoke(team.get(1)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalUpBuff() {
		Object champ = createRandomHero();
		int randomRange = 2;
		int max = 1;
		int min = 0;
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		Object effect = createDodgeEffect(2);
		Object ability = createCCAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, effect);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> myTeam = createFirstPlayerTeam(firstPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		setLocationForObject(myTeam.get(1), randX + randomRange, randY);
		addObjectToBoardGame(game, myTeam.get(1), randX + randomRange, randY);

		setLocationForObject(myTeam.get(2), randX + 1, randY);
		addObjectToBoardGame(game, myTeam.get(2), randX + 1, randY);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnUpDirection());

			int i = randX + 1;
			for (; i <= randX + randomRange; i++) {
				if (i < 5 && returnGameBoard(game)[i][randY] != null) {
					Object champX = returnGameBoard(game)[i][randY];
					assertTrue(
							"Casting up dodge crowd control ability on target within range, expected to have the given effect applied on targets but it's not",
							containsEffect(champX, effect, true));
				}
			}

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalUpBuffOpponentTeam() {
		Object champ = createRandomHero();
		int randomRange = 2;
		int max = 1;
		int min = 0;
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		Object effect = createDodgeEffect(2);
		Object ability = createCCAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, effect);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> myTeam = createFirstPlayerTeam(firstPlayer, false, champ);
		createSecondPlayerTeam(secondPlayer, true, champ);
		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		setLocationForObject(myTeam.get(1), randX + randomRange, randY);
		addObjectToBoardGame(game, myTeam.get(1), randX + randomRange, randY);

		setLocationForObject(myTeam.get(2), randX + 1, randY);
		addObjectToBoardGame(game, myTeam.get(2), randX + 1, randY);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnUpDirection());

			int i = randX + 1;
			for (; i <= randX + randomRange; i++) {
				if (i < 5 && returnGameBoard(game)[i][randY] != null) {
					Object champX = returnGameBoard(game)[i][randY];
					assertFalse("Casting up Dodge crowd control ability should not affect opponent team within range",
							containsEffect(champX, effect, false));
				}
			}

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalDownObstcale() {
		Object champ = createRandomHero();
		int randomRange = 3;
		Object effect = createStunEffect(1);
		Object ability = createCCAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, effect);

		int max = 4;
		int min = 3;
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		Object cover = createCover(randX - 1, randY);
		addObjectToBoardGame(game, cover, randX - 1, randY);

		setLocationForObject(myTeam.get(1), randX - 2, randY);
		addObjectToBoardGame(game, myTeam.get(1), randX - 2, randY);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m, m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnDownDirection());

			Class<?> c = Class.forName(conditionPath);

			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, "ACTIVE");

			m = champ.getClass().getMethod("getCondition");
			assertEquals(
					"Casting down crowd control ability is not applied correctly, should not affect the current champion's condition",
					value, m.invoke(champ));

			value = valueOf.invoke(null, "INACTIVE");

			m = myTeam.get(1).getClass().getMethod("getCondition");
			assertEquals(
					"Casting down crowd control ability is not applied correctly, should affect any target within the given range, target's condition",
					value, m.invoke(myTeam.get(1)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with down direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalDown() {
		Object champ = createRandomHero();
		int randomRange = 2;
		Object effect = createStunEffect(1);
		Object ability = createCCAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, effect);

		int max = 4;
		int min = 3;
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		setLocationForObject(myTeam.get(1), randX - randomRange, randY);
		addObjectToBoardGame(game, myTeam.get(1), randX - randomRange, randY);

		setLocationForObject(myTeam.get(2), randX - 1, randY);
		addObjectToBoardGame(game, myTeam.get(2), randX - 1, randY);

		int rand1 = (int) (Math.random() * 30) + 30;
		setObjectHP(myTeam.get(1), rand1);

		int rand2 = (int) (Math.random() * 30) + 30;
		setObjectHP(myTeam.get(2), rand2);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m, m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnDownDirection());

			int i = randX - 1;
			for (; i > 0; i--) {
				for (; i > 0; i--) {
					if (i >= 0 && returnGameBoard(game)[i][randY] != null) {

						Object champX = returnGameBoard(game)[i][randY];
						Class<?> c = Class.forName(conditionPath);

						Method valueOf = c.getMethod("valueOf", String.class);
						Object value = valueOf.invoke(null, "INACTIVE");

						m = champX.getClass().getMethod("getCondition");
						assertEquals(
								"Casting down Stun crowd control ability on target within range should update target's condition",
								value, m.invoke(champX));

					}
				}

			}
		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with down direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalDownSameTeam() {
		Object champ = createRandomHero();
		int randomRange = 2;
		Object effect = createStunEffect(1);
		Object ability = createCCAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, effect);

		int max = 4;
		int min = 3;
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, false, champ);
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		setLocationForObject(myTeam.get(1), randX - randomRange, randY);
		addObjectToBoardGame(game, myTeam.get(1), randX - randomRange, randY);

		setLocationForObject(myTeam.get(2), randX - 1, randY);
		addObjectToBoardGame(game, myTeam.get(2), randX - 1, randY);

		int rand1 = (int) (Math.random() * 30) + 30;
		setObjectHP(myTeam.get(1), rand1);

		int rand2 = (int) (Math.random() * 30) + 30;
		setObjectHP(myTeam.get(2), rand2);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m, m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnDownDirection());

			int i = randX - 1;
			for (; i > 0; i--) {
				for (; i > 0; i--) {
					if (i >= 0 && returnGameBoard(game)[i][randY] != null) {

						Object champX = returnGameBoard(game)[i][randY];
						Class<?> c = Class.forName(conditionPath);

						Method valueOf = c.getMethod("valueOf", String.class);
						Object value = valueOf.invoke(null, "ACTIVE");

						m = champX.getClass().getMethod("getCondition");
						assertEquals(
								"Casting down Stun crowd control ability should not affect same team champions within range",
								value, m.invoke(champX));

					}
				}

			}
		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with down direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalDownBuff() {
		Object champ = createRandomHero();
		int randomRange = 2;
		Object effect = createDodgeEffect(2);
		Object ability = createCCAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, effect);

		int max = 4;
		int min = 3;
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> myTeam = createFirstPlayerTeam(firstPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		setLocationForObject(myTeam.get(1), randX - randomRange, randY);
		addObjectToBoardGame(game, myTeam.get(1), randX - randomRange, randY);

		setLocationForObject(myTeam.get(2), randX - 1, randY);
		addObjectToBoardGame(game, myTeam.get(2), randX - 1, randY);

		int rand1 = (int) (Math.random() * 30) + 30;
		setObjectHP(myTeam.get(1), rand1);

		int rand2 = (int) (Math.random() * 30) + 30;
		setObjectHP(myTeam.get(2), rand2);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnDownDirection());

			int i = randX - 1;
			for (; i > 0; i--) {
				for (; i > 0; i--) {
					if (i >= 0 && returnGameBoard(game)[i][randY] != null) {

						Object champX = returnGameBoard(game)[i][randY];
						assertTrue(
								"Casting down dodge crowd control ability on target within range, expected to have the given effect applied on targets within range but it's not",
								containsEffect(champX, effect, true));
					}
				}

			}
		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with down direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalLeftObstcale() {
		Object champ = createRandomHero();
		int randomRange = 2;
		int max = 4;
		int min = 3;
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		Object effect = createStunEffect(1);
		Object ability = createCCAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, effect);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		Object cover = createCover(randX, randY - 1);
		addObjectToBoardGame(game, cover, randX, randY - 1);

		setLocationForObject(myTeam.get(1), randX, randY - 2);
		addObjectToBoardGame(game, myTeam.get(1), randX, randY - 2);

		int rand = (int) (Math.random() * 30) + 60;
		setObjectHP(myTeam.get(1), rand);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m, m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnLeftDirection());

			Class<?> c = Class.forName(conditionPath);

			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, "ACTIVE");

			m = champ.getClass().getMethod("getCondition");
			assertEquals(
					"Casting left crowd control ability is not applied correctly, should not affect the current champion's condition",
					value, m.invoke(champ));

			value = valueOf.invoke(null, "INACTIVE");

			m = myTeam.get(1).getClass().getMethod("getCondition");
			assertEquals(
					"Casting left crowd control ability is not applied correctly, should affect all the targets within the given range, target's condition",
					value, m.invoke(myTeam.get(1)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with left direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalLeft() {
		Object champ = createRandomHero();
		int randomRange = 3;
		int max = 4;
		int min = 3;
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		Object effect = createStunEffect(1);
		Object ability = createCCAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, effect);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		setLocationForObject(myTeam.get(1), randX, randY - randomRange);
		addObjectToBoardGame(game, myTeam.get(1), randX, randY - randomRange);

		setLocationForObject(myTeam.get(2), randX, randY - 1);
		addObjectToBoardGame(game, myTeam.get(2), randX, randY - 1);

		int rand1 = (int) (Math.random() * 30) + 30;
		setObjectHP(myTeam.get(1), rand1);

		int rand2 = (int) (Math.random() * 30) + 30;
		setObjectHP(myTeam.get(2), rand2);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m, m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnLeftDirection());

			int i = randY - 1;
			for (; i >= 0; i--) {
				if (i >= 0 && returnGameBoard(game)[randX][i] != null) {

					Object champX = returnGameBoard(game)[randX][i];
					Class<?> c = Class.forName(conditionPath);

					Method valueOf = c.getMethod("valueOf", String.class);
					Object value = valueOf.invoke(null, "INACTIVE");

					m = champX.getClass().getMethod("getCondition");
					assertEquals(
							"Casting left Stun crowd control ability on target within range should change target's condition",
							value, m.invoke(champX));
				}
			}

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with left direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalRightBuff() {
		Object champ = createRandomHero();
		int randomRange = 3;
		int max = 1;
		int min = 0;
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);
		Object effect = createSheildEffect(2);
		Object ability = createCCAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, effect);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> myTeam = createFirstPlayerTeam(firstPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		setLocationForObject(myTeam.get(1), randX, randY + randomRange);
		addObjectToBoardGame(game, myTeam.get(1), randX, randY + randomRange);

		setLocationForObject(myTeam.get(2), randX, randY + 1);
		addObjectToBoardGame(game, myTeam.get(2), randX, randY + 1);

		int rand1 = (int) (Math.random() * 30) + 30;
		setObjectHP(myTeam.get(1), rand1);

		int rand2 = (int) (Math.random() * 30) + 30;
		setObjectHP(myTeam.get(2), rand2);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnRightDirection());

			int i = randY + 1;

			for (; i <= randY + randomRange; i++) {
				if (i < 5 && returnGameBoard(game)[randX][i] != null) {
					Object champX = returnGameBoard(game)[randX][i];
					assertTrue(
							"Casting right Sheild crowd control ability on target within range, expected to have the given effect applied on targets within range but it's not",
							containsEffect(champX, effect, true));
				}
			}

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with right direction on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityDirectionalUpObstcale() {
		Object champ = createRandomHero();
		int randomRange = 2;
		int randHealing = (int) (Math.random() * 30) + 10;
		Object ability = createHealingAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, randHealing);

		int randX = (int) (Math.random() * 3);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		ArrayList<Integer> values = new ArrayList<>();

		Object cover = createCover(randX + 1, randY);
		values.add(returnHp(cover));
		addObjectToBoardGame(game, cover, randX + 1, randY);

		setLocationForObject(myTeam.get(1), randX + 2, randY);
		addObjectToBoardGame(game, myTeam.get(1), randX + 2, randY);

		values.add(returnHp(champ));

		int rand = (int) (Math.random() * 30) + 60;
		setObjectHP(myTeam.get(1), rand);
		values.add(rand);

		values.add(returnHp(myTeam.get(2)));

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnUpDirection());

			assertEquals("Casting up healing ability is not applied correctly, should not affect covers' HP",
					(int) (values.get(0)), returnHp(cover));

			assertEquals(
					"Casting up healing ability is not applied correctly, should not affect the current champion's HP",
					(int) (values.get(1)), returnHp(champ));

			int expected = (values.get(2) + randHealing > returnMaxHp(myTeam.get(1))) ? returnMaxHp(myTeam.get(1))
					: values.get(2) + randHealing;
			assertEquals(
					"Casting up healing ability is not applied correctly, should affect all targets within range, target's HP",
					expected, returnHp(myTeam.get(1)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with up direction on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityDirectionalUp() {
		Object champ = createRandomHero();
		int randomRange = 3;
		int max = 1;
		int min = 0;
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);

		int randHealing = (int) (Math.random() * 30) + 10;
		Object ability = createHealingAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, randHealing);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		setLocationForObject(myTeam.get(1), randX + randomRange, randY);
		addObjectToBoardGame(game, myTeam.get(1), randX + randomRange, randY);

		setLocationForObject(myTeam.get(2), randX + 1, randY);
		addObjectToBoardGame(game, myTeam.get(2), randX + 1, randY);

		int rand1 = (int) (Math.random() * 30) + 30;
		setObjectHP(myTeam.get(1), rand1);

		int rand2 = (int) (Math.random() * 30) + 30;
		setObjectHP(myTeam.get(2), rand2);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnUpDirection());

			int expected = (rand1 + randHealing > returnMaxHp(myTeam.get(1))) ? returnMaxHp(myTeam.get(1))
					: rand1 + randHealing;

			assertEquals("Casting up healing ability on target within range should update target's HP", expected,
					returnHp(myTeam.get(1)));
			expected = (rand2 + randHealing > returnMaxHp(myTeam.get(2))) ? returnMaxHp(myTeam.get(2))
					: rand2 + randHealing;
			assertEquals("Casting up healing ability on target within range should update target's HP", expected,
					returnHp(myTeam.get(2)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with up direction on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityDirectionalDown() {
		Object champ = createRandomHero();
		int randomRange = 3;
		int max = 4;
		int min = 3;
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randHealing = (int) (Math.random() * 30) + 10;
		Object ability = createHealingAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, randHealing);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		setLocationForObject(myTeam.get(1), randX - randomRange, randY);
		addObjectToBoardGame(game, myTeam.get(1), randX - randomRange, randY);

		setLocationForObject(myTeam.get(2), randX - 1, randY);
		addObjectToBoardGame(game, myTeam.get(2), randX - 1, randY);

		int rand1 = (int) (Math.random() * 30) + 30;
		setObjectHP(myTeam.get(1), rand1);

		int rand2 = (int) (Math.random() * 30) + 30;
		setObjectHP(myTeam.get(2), rand2);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnDownDirection());

			int expected = (rand1 + randHealing > returnMaxHp(myTeam.get(1))) ? returnMaxHp(myTeam.get(1))
					: rand1 + randHealing;

			assertEquals("Casting down healing ability on target within range should update target's HP", expected,
					returnHp(myTeam.get(1)));
			expected = (rand2 + randHealing > returnMaxHp(myTeam.get(2))) ? returnMaxHp(myTeam.get(2))
					: rand2 + randHealing;
			assertEquals("Casting down healing ability on target within range should update target's HP", expected,
					returnHp(myTeam.get(2)));

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with down direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityDirectionalDownOpponentTeam() {
		Object champ = createRandomHero();
		int randomRange = 3;
		int max = 4;
		int min = 3;
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randHealing = (int) (Math.random() * 30) + 10;
		Object ability = createHealingAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, randHealing);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		setLocationForObject(myTeam.get(1), randX - randomRange, randY);
		addObjectToBoardGame(game, myTeam.get(1), randX - randomRange, randY);

		setLocationForObject(myTeam.get(2), randX - 1, randY);
		addObjectToBoardGame(game, myTeam.get(2), randX - 1, randY);

		int rand1 = (int) (Math.random() * 30) + 30;
		setObjectHP(myTeam.get(1), rand1);

		int rand2 = (int) (Math.random() * 30) + 30;
		setObjectHP(myTeam.get(2), rand2);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnDownDirection());

			assertEquals(
					"Casting Down healing ability should not be applied on opponent team targets within range, current HP",
					rand1, returnHp(myTeam.get(1)));
			assertEquals(
					"Casting Down healing ability should not be applied on opponent team targets within range, current HP",
					rand2, returnHp(myTeam.get(2)));

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with down direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityDirectionalLeftObstcale() {
		Object champ = createRandomHero();
		int randomRange = 2;
		int randHealing = (int) (Math.random() * 30) + 10;
		Object ability = createHealingAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, randHealing);

		int max = 4;
		int min = 2;
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		ArrayList<Integer> values = new ArrayList<>();

		Object cover = createCover(randX, randY - 1);
		addObjectToBoardGame(game, cover, randX, randY - 1);
		values.add(returnHp(cover));

		setLocationForObject(myTeam.get(1), randX, randY - 2);
		addObjectToBoardGame(game, myTeam.get(1), randX, randY - 2);

		values.add(returnHp(champ));

		int rand = (int) (Math.random() * 30) + 60;
		setObjectHP(myTeam.get(1), rand);
		values.add(rand);

		values.add(returnHp(myTeam.get(2)));

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnLeftDirection());

			assertEquals("Casting left healing ability is not applied correctly, should not affect covers' HP",
					(int) (values.get(0)), returnHp(cover));

			assertEquals(
					"Casting left healing ability is not applied correctly, should not affect the current champion's HP",
					(int) (values.get(1)), returnHp(champ));

			int expected = (values.get(2) + randHealing > returnMaxHp(myTeam.get(1))) ? returnMaxHp(myTeam.get(1))
					: values.get(2) + randHealing;
			assertEquals(
					"Casting left healing ability is not applied correctly, should affect all targets within range, target'HP",
					expected, returnHp(myTeam.get(1)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with left direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityDirectionalLeftOpponentTeam() {
		Object champ = createRandomHero();
		int randomRange = 3;
		int max = 4;
		int min = 3;
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randHealing = (int) (Math.random() * 30) + 10;
		Object ability = createHealingAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, randHealing);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);
		createFirstPlayerTeam(firstPlayer, true, champ);
		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		setLocationForObject(myTeam.get(1), randX, randY - randomRange);
		addObjectToBoardGame(game, myTeam.get(1), randX, randY - randomRange);

		setLocationForObject(myTeam.get(2), randX, randY - 1);
		addObjectToBoardGame(game, myTeam.get(2), randX, randY - 1);

		int rand1 = (int) (Math.random() * 30) + 30;
		setObjectHP(myTeam.get(1), rand1);

		int rand2 = (int) (Math.random() * 30) + 30;
		setObjectHP(myTeam.get(2), rand2);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnLeftDirection());

			assertEquals(
					"Casting Left healing ability should not be applied on opponent team targets within range, current HP",
					rand1, returnHp(myTeam.get(1)));
			assertEquals(
					"Casting Left healing ability should not be applied on opponent team targets within range, current HP",
					rand2, returnHp(myTeam.get(2)));

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with left direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityDirectionalRightObstcale() {
		Object champ = createRandomHero();
		int randomRange = 2;
		int randHealing = (int) (Math.random() * 30) + 10;
		Object ability = createHealingAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, randHealing);

		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		ArrayList<Integer> values = new ArrayList<>();

		Object cover = createCover(randX, randY + 1);
		addObjectToBoardGame(game, cover, randX, randY + 1);
		values.add(returnHp(cover));

		setLocationForObject(myTeam.get(1), randX, randY + 2);
		addObjectToBoardGame(game, myTeam.get(1), randX, randY + 2);
		values.add(returnHp(champ));

		int rand = (int) (Math.random() * 30) + 60;
		setObjectHP(myTeam.get(1), rand);
		values.add(rand);

		values.add(returnHp(myTeam.get(2)));

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnRightDirection());

			assertEquals("Casting right healing ability is not applied correctly, should not affect covers' HP",
					(int) (values.get(0)), returnHp(cover));

			assertEquals(
					"Casting right healing ability is not applied correctly, should not affect the current champion's HP",
					(int) (values.get(1)), returnHp(champ));

			int expected = (values.get(2) + randHealing > returnMaxHp(myTeam.get(1))) ? returnMaxHp(myTeam.get(1))
					: values.get(2) + randHealing;
			assertEquals(
					"Casting right healing ability is not applied correctly, should affect all targets within range, target's HP",
					expected, returnHp(myTeam.get(1)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with right direction on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityDirectionalRight() {
		Object champ = createRandomHero();
		int randomRange = 2;
		int randHealing = (int) (Math.random() * 30) + 10;
		Object ability = createHealingAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, randHealing);
		int max = 1;
		int min = 0;
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		setLocationForObject(myTeam.get(1), randX, randY + randomRange);
		addObjectToBoardGame(game, myTeam.get(1), randX, randY + randomRange);

		setLocationForObject(myTeam.get(2), randX, randY + 1);
		addObjectToBoardGame(game, myTeam.get(2), randX, randY + 1);

		int rand1 = (int) (Math.random() * 30) + 30;
		setObjectHP(myTeam.get(1), rand1);

		int rand2 = (int) (Math.random() * 30) + 30;
		setObjectHP(myTeam.get(2), rand2);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnRightDirection());

			int expected = (rand1 + randHealing > returnMaxHp(myTeam.get(1))) ? returnMaxHp(myTeam.get(1))
					: rand1 + randHealing;

			assertEquals("Casting right healing ability on target within range should update target's HP", expected,
					returnHp(myTeam.get(1)));
			expected = (rand2 + randHealing > returnMaxHp(myTeam.get(2))) ? returnMaxHp(myTeam.get(2))
					: rand2 + randHealing;
			assertEquals("Casting right healing ability on target within range should update target's HP", expected,
					returnHp(myTeam.get(2)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with right direction on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityDirectionalUpObstcale() {
		Object champ = createRandomHero();
		int randomRange = 2;
		int randAmout = (int) (Math.random() * 30) + 10;
		Object ability = createDmgAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, randAmout);

		int randX = (int) (Math.random() * 3);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);
		createFirstPlayerTeam(firstPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		ArrayList<Integer> values = new ArrayList<>();

		Object cover = createCover(randX + 1, randY);
		values.add(returnHp(cover));
		addObjectToBoardGame(game, cover, randX + 1, randY);

		setLocationForObject(myTeam.get(1), randX + 2, randY);
		addObjectToBoardGame(game, myTeam.get(1), randX + 2, randY);

		values.add(returnHp(champ));

		int rand = (int) (Math.random() * 30) + 60;
		setObjectHP(myTeam.get(1), rand);
		values.add(rand);

		values.add(returnHp(myTeam.get(2)));

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnUpDirection());

			int expected = (values.get(0) - randAmout < 0) ? 0 : values.get(0) - randAmout;

			assertEquals("Casting up damaging ability is not applied correctly, should affect covers' HP", expected,
					returnHp(cover));

			assertEquals(
					"Casting up damaging ability is not applied correctly, should not affect the current champion's HP",
					(int) (values.get(1)), returnHp(champ));

			expected = (values.get(2) - randAmout < 0) ? 0 : values.get(2) - randAmout;
			assertEquals(
					"Casting up damaging ability is not applied correctly, should affect all targets within range, target's HP",
					expected, returnHp(myTeam.get(1)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with up direction on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityDirectionalUp() {
		Object champ = createRandomHero();
		int randomRange = 3;
		int max = 1;
		int min = 0;
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);

		int randAmout = (int) (Math.random() * 30) + 10;
		Object ability = createDmgAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, randAmout);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);
		createFirstPlayerTeam(firstPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		setLocationForObject(myTeam.get(1), randX + randomRange, randY);
		addObjectToBoardGame(game, myTeam.get(1), randX + randomRange, randY);

		setLocationForObject(myTeam.get(2), randX + 1, randY);
		addObjectToBoardGame(game, myTeam.get(2), randX + 1, randY);

		int rand1 = (int) (Math.random() * 30) + 60;
		setObjectHP(myTeam.get(1), rand1);

		int rand2 = (int) (Math.random() * 30) + 60;
		setObjectHP(myTeam.get(2), rand2);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnUpDirection());

			int expected = (rand1 - randAmout < 0) ? 0 : rand1 - randAmout;

			assertEquals("Casting up damaging ability on target within range should update target's HP", expected,
					returnHp(myTeam.get(1)));
			expected = (rand2 - randAmout < 0) ? 0 : rand2 - randAmout;
			assertEquals("Casting up damaging ability on target within range should update target's HP", expected,
					returnHp(myTeam.get(2)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with up direction on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityDirectionalDownObstcale() {
		Object champ = createRandomHero();
		int randomRange = 2;
		int randAmout = (int) (Math.random() * 30) + 10;
		Object ability = createDmgAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, randAmout);

		int max = 4;
		int min = 2;
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);
		createFirstPlayerTeam(firstPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		ArrayList<Integer> values = new ArrayList<>();

		Object cover = createCover(randX - 1, randY);
		values.add(returnHp(cover));
		addObjectToBoardGame(game, cover, randX - 1, randY);

		setLocationForObject(myTeam.get(1), randX - 2, randY);
		addObjectToBoardGame(game, myTeam.get(1), randX - 2, randY);

		values.add(returnHp(champ));

		int rand = (int) (Math.random() * 30) + 60;
		setObjectHP(myTeam.get(1), rand);
		values.add(rand);

		values.add(returnHp(myTeam.get(2)));

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnDownDirection());

			int expected = (values.get(0) - randAmout < 0) ? 0 : values.get(0) - randAmout;
			assertEquals("Casting down damaging ability is not applied correctly, should affect covers'HP", expected,
					returnHp(cover));

			assertEquals(
					"Casting down damaging ability is not applied correctly, should not affect the current champion's HP",
					(int) (values.get(1)), returnHp(champ));

			expected = (values.get(2) - randAmout < 0) ? 0 : values.get(2) - randAmout;
			assertEquals(
					"Casting down damaging ability is not applied correctly, should affect all targets within range, target's HP",
					expected, returnHp(myTeam.get(1)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with down direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityDirectionalDownSameTeam() {
		Object champ = createRandomHero();
		int randomRange = 3;
		int max = 4;
		int min = 3;
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randAmout = (int) (Math.random() * 30) + 10;
		Object ability = createDmgAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, randAmout);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, false, champ);
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		setLocationForObject(myTeam.get(1), randX - randomRange, randY);
		addObjectToBoardGame(game, myTeam.get(1), randX - randomRange, randY);

		setLocationForObject(myTeam.get(2), randX - 1, randY);
		addObjectToBoardGame(game, myTeam.get(2), randX - 1, randY);

		int rand1 = (int) (Math.random() * 30) + 60;
		setObjectHP(myTeam.get(1), rand1);

		int rand2 = (int) (Math.random() * 30) + 60;
		setObjectHP(myTeam.get(2), rand2);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnDownDirection());

			assertEquals(
					"Casting Down damaging ability should not be applied on same team targets within range, current HP",
					rand1, returnHp(myTeam.get(1)));
			assertEquals(
					"Casting Down damaging ability should not be applied on same team targets within range, current HP",
					rand2, returnHp(myTeam.get(2)));

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with down direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityDirectionalLeftObstcale() {
		Object champ = createRandomHero();
		int randomRange = 2;
		int randAmout = (int) (Math.random() * 30) + 10;
		Object ability = createDmgAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, randAmout);

		int max = 4;
		int min = 2;
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);
		createFirstPlayerTeam(firstPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		ArrayList<Integer> values = new ArrayList<>();

		Object cover = createCover(randX, randY - 1);
		addObjectToBoardGame(game, cover, randX, randY - 1);
		values.add(returnHp(cover));

		setLocationForObject(myTeam.get(1), randX, randY - 2);
		addObjectToBoardGame(game, myTeam.get(1), randX, randY - 2);

		values.add(returnHp(champ));

		int rand = (int) (Math.random() * 30) + 60;
		setObjectHP(myTeam.get(1), rand);
		values.add(rand);

		values.add(returnHp(myTeam.get(2)));

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnLeftDirection());

			int expected = (values.get(0) - randAmout < 0) ? 0 : values.get(0) - randAmout;

			assertEquals("Casting left damaging ability is not applied correctly, should affect covers' HP", expected,
					returnHp(cover));

			assertEquals(
					"Casting left damaging ability is not applied correctly, should not affect the current champion's HP",
					(int) (values.get(1)), returnHp(champ));

			expected = (values.get(2) - randAmout < 0) ? 0 : values.get(2) - randAmout;
			assertEquals(
					"Casting left damaging ability is not applied correctly, should affect all targets within range, target'HP",
					expected, returnHp(myTeam.get(1)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with left direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityDirectionalLeft() {
		Object champ = createRandomHero();
		int randomRange = 3;
		int max = 4;
		int min = 3;
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randAmout = (int) (Math.random() * 30) + 10;
		Object ability = createDmgAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, randAmout);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);
		createFirstPlayerTeam(firstPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		setLocationForObject(myTeam.get(1), randX, randY - randomRange);
		addObjectToBoardGame(game, myTeam.get(1), randX, randY - randomRange);

		setLocationForObject(myTeam.get(2), randX, randY - 1);
		addObjectToBoardGame(game, myTeam.get(2), randX, randY - 1);

		int rand1 = (int) (Math.random() * 30) + 60;
		setObjectHP(myTeam.get(1), rand1);

		int rand2 = (int) (Math.random() * 30) + 60;
		setObjectHP(myTeam.get(2), rand2);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnLeftDirection());

			int expected = (rand1 - randAmout < 0) ? 0 : rand1 - randAmout;
			assertEquals("Casting left damaging ability on target within range should update target's HP", expected,
					returnHp(myTeam.get(1)));
			expected = (rand2 - randAmout < 0) ? 0 : rand2 - randAmout;
			assertEquals("Casting left damaging ability on target within range should update target's HP", expected,
					returnHp(myTeam.get(2)));

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with left direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityDirectionalRight() {
		Object champ = createRandomHero();
		int randomRange = 2;
		int randAmout = (int) (Math.random() * 30) + 10;
		Object ability = createDmgAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, randAmout);
		int max = 1;
		int min = 0;
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);
		createFirstPlayerTeam(firstPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		setLocationForObject(myTeam.get(1), randX, randY + randomRange);
		addObjectToBoardGame(game, myTeam.get(1), randX, randY + randomRange);

		setLocationForObject(myTeam.get(2), randX, randY + 1);
		addObjectToBoardGame(game, myTeam.get(2), randX, randY + 1);

		int rand1 = (int) (Math.random() * 30) + 60;
		setObjectHP(myTeam.get(1), rand1);

		int rand2 = (int) (Math.random() * 30) + 60;
		setObjectHP(myTeam.get(2), rand2);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnRightDirection());

			int expected = (rand1 - randAmout < 0) ? 0 : rand1 - randAmout;
			assertEquals("Casting right damaging ability on target within range should update target's HP", expected,
					returnHp(myTeam.get(1)));

			expected = (rand2 - randAmout < 0) ? 0 : rand2 - randAmout;
			assertEquals("Casting right damaging ability on target within range should update target's HP", expected,
					returnHp(myTeam.get(2)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with right direction on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityDirectionalRightSameTeam() {
		Object champ = createRandomHero();
		int randomRange = 2;
		int randAmout = (int) (Math.random() * 30) + 10;
		Object ability = createDmgAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, randAmout);
		int max = 1;
		int min = 0;
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, false, champ);
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		setLocationForObject(myTeam.get(1), randX, randY + randomRange);
		addObjectToBoardGame(game, myTeam.get(1), randX, randY + randomRange);

		setLocationForObject(myTeam.get(2), randX, randY + 1);
		addObjectToBoardGame(game, myTeam.get(2), randX, randY + 1);

		int rand1 = (int) (Math.random() * 30) + 60;
		setObjectHP(myTeam.get(1), rand1);

		int rand2 = (int) (Math.random() * 30) + 60;
		setObjectHP(myTeam.get(2), rand2);

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnRightDirection());

			assertEquals(
					"Casting right damaging ability should not be applied on same team targets within range, current HP",
					rand1, returnHp(myTeam.get(1)));
			assertEquals(
					"Casting right damaging ability should not be applied on same team targets within range, current HP",
					rand2, returnHp(myTeam.get(2)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with right direction on target");

		}

	}

	// Single Target tests

	@Test(timeout = 3000)
	public void testCastAbilitySingleTargetInCoolDown() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();
		Object game = createGame();
		clearBoard(game);

		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		addChampToTurnOrder(game, champ);
		Object ability = createHealingAbility("SINGLETARGET");
		Method m;
		try {
			m = ability.getClass().getMethod("setCurrentCooldown", int.class);
			m.invoke(ability, 2);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e1) {

			fail(e1.getClass() + " occurred");
		}

		try {
			int rX = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
			int rY = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
			addAbilityToChampion(champ, ability);
			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, rX, rY);
			fail("Trying to cast ability on a single target while in cool down, an exception should be thrown");

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| ClassNotFoundException e) {

			fail("Trying to cast ability on a single target while in cool down, an exception should be thrown");
			fail(e.getCause().getClass() + " occurred");

		} catch (InvocationTargetException e) {
			try {
				if (!(Class.forName(abilityExceptionPath).equals(e.getCause().getClass())))
					fail("Trying to cast ability on a single target while in cool down, an exception should be thrown");
			} catch (ClassNotFoundException e1) {

				fail(e.getCause().getClass() + " occurred");
			}

		}

	}

	@SuppressWarnings("unchecked")
	@Test(timeout = 3000)
	public void testCastAbilitySingleTargetNotEnoughResources() {
		// Add the current champ to the turnOrder
		Object champ = createHero("Spiderman", 100, 0, 2, 2, 2, 2);
		Object game = createGame();
		clearBoard(game);

		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		addChampToTurnOrder(game, champ);
		Object ability = createHealingAbility("SINGLETARGET");
		try {
			Method m = champ.getClass().getMethod("getAbilities");
			((ArrayList<Object>) (m.invoke(champ))).add(ability);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e2) {

			e2.printStackTrace();
		}

		try {
			int rX = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
			int rY = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, rX, rY);

			fail("Current Champion does not have enough resources to cast this ability on a single target, an exception should be thrown");

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| ClassNotFoundException e) {

			fail("Current Champion does not have enough resources to cast this ability on a single target, an exception should be thrown");
			fail(e.getCause().getClass() + " occurred");

		} catch (InvocationTargetException e) {
			try {
				if (!(Class.forName(notEnoughResourcesExceptionPath).equals(e.getCause().getClass())))
					fail("Current Champion does not have enough resources to cast this ability on a single target, an exception should be thrown");
			} catch (ClassNotFoundException e1) {

				e1.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Test(timeout = 3000)
	public void testCastAbilitySingleTargetCurrentChampInSilence() {
		// Add the current champ to the turnOrder
		Object game = createGame();
		Object champ = createRandomHero();
		clearBoard(game);

		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		addChampToTurnOrder(game, champ);
		Object ability = createHealingAbility("SINGLETARGET");
		addAbilityToChampion(champ, ability);
		try {
			Method m = champ.getClass().getMethod("getAppliedEffects");
			((ArrayList<Object>) (m.invoke(champ))).add(createSilenceEffect(2));
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e2) {

			e2.printStackTrace();
		}

		try {
			int rX = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
			int rY = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, rX, rY);
			fail("Trying to cast ability on a single target while champion has silence effect applied, an exception should be thrown");

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| ClassNotFoundException e) {

			fail("Trying to cast ability on a single target while champion has silence effect applied, an exception should be thrown");
			fail(e.getCause().getClass() + " occurred");

		} catch (InvocationTargetException e) {
			try {
				if (!(Class.forName(abilityExceptionPath).equals(e.getCause().getClass())))
					fail("Trying to cast ability on a single target while champion has silence effect applied, an exception should be thrown");
			} catch (ClassNotFoundException e1) {

				e1.printStackTrace();
			}

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilitySingleTargetWithinRange2() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randX = (int) Math.floor(Math.random() * (4 - 3 + 1) + 3);
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randomRange = (int) Math.floor(Math.random() * (3 - 2 + 1) + 2);
		int randAmount = (int) (Math.random() * 30) + 10;

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");

		createSecondPlayerTeam(secPlayer, true, champ);
		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, false, champ);

		Object game = createGame(firstPlayer, secPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		addChampToTurnOrder(game, champ);
		Object ability = createHealingAbility("", 10, 2, randomRange, "SINGLETARGET", 10, randAmount);
		addAbilityToChampion(champ, ability);

		int max = randomRange - 1;
		int min = randX - randomRange;
		int rX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randHP = (int) (Math.random() * 30) + 10;

		setObjectHP(team.get(1), randHP);
		addObjectToBoardGame(game, team.get(1), rX, randY);
		setLocationForObject(team.get(1), rX, randY);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, rX, randY);

			assertEquals("Casting single target healing effect should not be applied on the opponent team, target's HP",
					randHP, returnHp(team.get(1)));

		} catch (Exception e) {

			try {
				if (!e.getCause().getClass().equals(Class.forName(invalidTargetExceptionPath)))
					fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");
			} catch (ClassNotFoundException e1) {

				fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");
			}

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilitySingleTargetWithinRangeOutOfRange() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randX = (int) Math.floor(Math.random() * (4 - 3 + 1) + 3);
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randomRange = (int) Math.floor(Math.random() * (2 - 1 + 1) + 1);
		int randAmount = (int) (Math.random() * 30) + 10;

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, true, champ);

		Object game = createGame(firstPlayer, secPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		addChampToTurnOrder(game, champ);
		Object ability = createHealingAbility("", 10, 2, randomRange, "SINGLETARGET", 10, randAmount);
		addAbilityToChampion(champ, ability);

		int max = randX - randomRange - 1;
		int min = 0;
		int rX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int rY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randHP = (int) (Math.random() * 30) + 10;

		setObjectHP(team.get(1), randHP);
		addObjectToBoardGame(game, team.get(1), rX, rY);
		setLocationForObject(team.get(1), rX, rY);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, rX, rY);

			fail("Casting single target healing effect is not applied correctly on targets out of range, an exception should be thrown");

		} catch (Exception e) {

			try {
				if (!(e.getCause().getClass().equals(Class.forName(abilityExceptionPath))))
					fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");
			} catch (ClassNotFoundException e1) {

				fail(e1.getClass() + " occurred while trying to cast ability on single target");

			}

		}

	}

	@Test(timeout = 3000)
	public void testCastDmgAbilitySingleTargetWithinRange1() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randX = (int) Math.floor(Math.random() * (4 - 3 + 1) + 3);
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randomRange = 2;
		int randAmount = (int) (Math.random() * 30) + 10;

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");

		createSecondPlayerTeam(secPlayer, true, champ);
		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, false, champ);

		Object game = createGame(firstPlayer, secPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		addChampToTurnOrder(game, champ);
		Object ability = createDmgAbility("", 10, 2, randomRange, "SINGLETARGET", 1, randAmount);
		addAbilityToChampion(champ, ability);

		int max = randomRange - 1;
		int min = randX - randomRange;
		int rX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randHP = (int) (Math.random() * 30) + 60;

		setObjectHP(team.get(1), randHP);
		addObjectToBoardGame(game, team.get(1), rX, randY);
		setLocationForObject(team.get(1), rX, randY);
		Object champX = team.get(1);
		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, rX, randY);
			int expected = ((randHP - randAmount) < 0) ? 0 : (randHP - randAmount);
			assertEquals("Casting single target damaging effect is not applied correctly, target's HP", expected,
					returnHp(champX));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");

		}

	}

	@Test(timeout = 3000)
	public void testCastDmgAbilitySingleTargetWithinRangeOutOfRange() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randX = (int) Math.floor(Math.random() * (4 - 3 + 1) + 3);
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randomRange = 1;
		int randAmount = (int) (Math.random() * 30) + 10;

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secPlayer, false, champ);

		Object game = createGame(firstPlayer, secPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		addChampToTurnOrder(game, champ);
		Object ability = createDmgAbility("", 10, 2, randomRange, "SINGLETARGET", 1, randAmount);
		addAbilityToChampion(champ, ability);

		int max = randX - randomRange - 1;
		int min = 0;
		int rX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int rY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randHP = (int) (Math.random() * 30) + 10;

		setObjectHP(team.get(1), randHP);
		addObjectToBoardGame(game, team.get(1), rX, rY);
		setLocationForObject(team.get(1), rX, rY);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, rX, rY);

			fail("Casting single target damaging effect is not applied correctly on targets out of range, an exception should be thrown");

		} catch (Exception e) {

			try {
				if (!(e.getCause().getClass().equals(Class.forName(abilityExceptionPath))))
					fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");
			} catch (ClassNotFoundException e1) {

				fail(e1.getClass() + " occurred while trying to cast ability on single target");

			}

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilitySingleTargetWithinRangeBuff2() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randomRange = 2;

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secPlayer, false, champ);

		Object game = createGame(firstPlayer, secPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		addChampToTurnOrder(game, champ);
		Object effect = createDodgeEffect(2);
		Object ability = createCCAbility("", 10, 2, randomRange, "SINGLETARGET", 1, effect);
		addAbilityToChampion(champ, ability);

		addObjectToBoardGame(game, team.get(1), randX + 1, randY);
		setLocationForObject(team.get(1), randX + 1, randY);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, randX + 1, randY);

			fail("Casting single target crowd control ability with buff effect is not applied correctly, an appropriate exception should be thrown");

		} catch (Exception e) {

			try {
				if (!e.getCause().getClass().equals(Class.forName(invalidTargetExceptionPath)))
					fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");
			} catch (ClassNotFoundException e1) {

				fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");
			}

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilitySingleTargetWithinRangeBuff3() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randX = 2;
		int randY = 2;
		int randomRange = 2;

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, true, champ);

		Object game = createGame(firstPlayer, secPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		addChampToTurnOrder(game, champ);

		Object effect = createDodgeEffect(2);
		Object ability = createCCAbility("", 10, 2, randomRange, "SINGLETARGET", 1, effect);
		addAbilityToChampion(champ, ability);

		addObjectToBoardGame(game, team.get(1), 1, 0);
		setLocationForObject(team.get(1), 1, 0);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, 1, 0);

			fail("Casting single target crowd control ability with buff effect is not applied correctly, should not affect targets out of range an exception should be thrown");

		} catch (Exception e) {

			try {
				if (!(e.getCause().getClass().equals(Class.forName(abilityExceptionPath))))
					fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");
			} catch (ClassNotFoundException e1) {

				fail(e1.getClass() + " occurred while trying to cast ability on single target");

			}

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilitySingleTargetWithinRangeDeBuff1() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randomRange = 1;

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secPlayer, false, champ);

		Object game = createGame(firstPlayer, secPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		addChampToTurnOrder(game, champ);
		Object effect = createShockEffect(2);
		Object ability = createCCAbility("", 10, 2, randomRange, "SINGLETARGET", 1, effect);
		addAbilityToChampion(champ, ability);

		addObjectToBoardGame(game, team.get(1), randX + 1, randY);
		setLocationForObject(team.get(1), randX + 1, randY);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, randX + 1, randY);

			assertTrue(
					"Casting single target crowd control ability with de-buff effect is not applied correctly, expected to have the given effect applied but it's not",
					containsEffect(team.get(1), effect, true));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");

		}

	}

	// Update single target on current champ

	@Test(timeout = 3000)
	public void testCastDamagingAbilitySingleTargetOnCurrentChamp() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randomRange = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randAmount = (int) (Math.random() * 30) + 10;

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		Object game = createGame(firstPlayer, secPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		addChampToTurnOrder(game, champ);

		Object ability = createDmgAbility("", 10, 2, randomRange, "SINGLETARGET", 1, randAmount);
		addAbilityToChampion(champ, ability);

		int randHP = (int) (Math.random() * 30) + 10;
		setObjectHP(champ, randHP);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, randX, randY);

			fail("Casting single target damaging ability should not be applied on current champion, an appropriate exception should be thrown");

		} catch (Exception e) {

			try {
				if (!e.getCause().getClass().equals(Class.forName(invalidTargetExceptionPath)))
					fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");
			} catch (ClassNotFoundException e1) {

				fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");
			}

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilitySingleTargetOnCurrentChampBuff() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randomRange = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		Object game = createGame(firstPlayer, secPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		addChampToTurnOrder(game, champ);

		Object effect = createEmbraceEffect(2);
		Object ability = createCCAbility("", 10, 2, randomRange, "SINGLETARGET", 1, effect);
		addAbilityToChampion(champ, ability);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, randX, randY);

			assertTrue(
					"Casting single target Embrace crowd control ability should be applied on current champion, expected to have the given effect applied but it's not",
					containsEffect(champ, effect, true));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilitySingleTargetOnCurrentChampDeBuff() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randomRange = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		Object game = createGame(firstPlayer, secPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		addChampToTurnOrder(game, champ);

		Object effect = createRootEffect(2);
		Object ability = createCCAbility("", 10, 2, randomRange, "SINGLETARGET", 1, effect);
		addAbilityToChampion(champ, ability);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, randX, randY);

			fail("Casting single target crowd control debuff ability should not be applied on current champion, an appropriate exception should be thrown");

		} catch (Exception e) {

			try {
				if (!e.getCause().getClass().equals(Class.forName(invalidTargetExceptionPath)))
					fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");
			} catch (ClassNotFoundException e1) {

				fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");
			}

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilitySingleTargetCoverCell() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randX = 1;
		int randY = 1;
		int randomRange = 2;

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		Object game = createGame(firstPlayer, secPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		addChampToTurnOrder(game, champ);
		Object effect = createDisarmEffect(2);
		Object ability = createCCAbility("", 10, 2, randomRange, "SINGLETARGET", 1, effect);
		addAbilityToChampion(champ, ability);

		Object cover = createCover(1, 2);
		addObjectToBoardGame(game, cover, 1, 2);

		int randHP = (int) (Math.random() * 30) + 10;
		setObjectHP(cover, randHP);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, 1, 2);

			fail("Casting single target cc ability should not be applied on a cover cell, an appropriate exception should be thrown");

		} catch (Exception e) {

			try {
				if (!e.getCause().getClass().equals(Class.forName(invalidTargetExceptionPath)))
					fail(e.getCause().getClass() + " occurred while trying to cast ability on a cover cell target");
			} catch (ClassNotFoundException e1) {

				fail(e.getCause().getClass() + " occurred while trying to cast ability on a cover cell target");
			}

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilitySingleTargetCoverCell() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randX = 1;
		int randY = 1;
		int randomRange = 2;
		int randAmount = (int) (Math.random() * 30) + 10;

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		Object game = createGame(firstPlayer, secPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		addChampToTurnOrder(game, champ);

		Object ability = createHealingAbility("", 10, 2, randomRange, "SINGLETARGET", 1, randAmount);
		addAbilityToChampion(champ, ability);

		Object cover = createCover(1, 2);
		addObjectToBoardGame(game, cover, 1, 2);
		int randHP = (int) (Math.random() * 30) + 10;
		setObjectHP(cover, randHP);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, 1, 2);

			fail("Casting single target healing ability should not be applied on a cover cell, an appropriate exception should be thrown");

		} catch (Exception e) {

			try {
				if (!e.getCause().getClass().equals(Class.forName(invalidTargetExceptionPath)))
					fail(e.getCause().getClass() + " occurred while trying to cast ability on a cover cell target");
			} catch (ClassNotFoundException e1) {

				fail(e.getCause().getClass() + " occurred while trying to cast ability on a cover cell target");
			}

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilitySingleTargetEmptyCell() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randX = 1;
		int randY = 1;
		int randomRange = 1;
		int randAmount = (int) (Math.random() * 30) + 10;

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		Object game = createGame(firstPlayer, secPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		addChampToTurnOrder(game, champ);

		Object ability = createHealingAbility("", 10, 2, randomRange, "SINGLETARGET", 1, randAmount);
		addAbilityToChampion(champ, ability);

		int randHP = (int) (Math.random() * 30) + 10;
		setObjectHP(champ, randHP);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, 4, 4);

			fail("Casting single target healing ability should not be applied on an empty cell, an appropriate exception should be thrown");

		} catch (Exception e) {

			try {
				if (!e.getCause().getClass().equals(Class.forName(invalidTargetExceptionPath)))
					fail(e.getCause().getClass() + " occurred while trying to cast ability on an empty cell target");
			} catch (ClassNotFoundException e1) {

				fail(e.getCause().getClass() + " occurred while trying to cast ability on an empty cell target");
			}

		}

	}

	// TeamTargets
	// Start Healing
	@Test(timeout = 3000)
	public void testCastHealingAbilityTEAMTARGETCovers() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 1, "TEAMTARGET", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);

		Object cover1 = createCover(1, 0);
		Object cover2 = createCover(0, 1);
		addObjectToBoardGame(game, cover1, 1, 0);
		addObjectToBoardGame(game, cover2, 0, 1);
		addObjectToBoardGame(game, champ, 0, 0);
		setLocationForObject(champ, 0, 0);

		addChampToTurnOrder(game, champ);
		int randomHp = (int) (Math.random() * 20) + 20;
		setObjectHP(cover1, randomHp);
		int randomHp2 = (int) (Math.random() * 20) + 20;
		setObjectHP(cover2, randomHp2);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertEquals("Casting healing ability with TEAMTARGET should not be applied on covers, current HP",
					randomHp, returnHp(cover1));
			assertEquals("Casting healing ability with TEAMTARGET should not be applied on covers, current HP",
					randomHp2, returnHp(cover2));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting healing ability with area of effect TEAMTARGET ");

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityTeamTargetSameTeam2() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 2, "TEAMTARGET", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 0);
		setLocationForObject(champ, 0, 0);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);
		Object champ4 = createRandomAntiHero();
		team.add(champ4);
		// (0,1) (0,2) (1,1)
		addObjectToBoardGame(game, champ2, 1, 1);
		setLocationForObject(champ2, 1, 1);

		addObjectToBoardGame(game, champ3, 0, 1);
		setLocationForObject(champ3, 0, 1);

		addObjectToBoardGame(game, champ4, 0, 2);
		setLocationForObject(champ4, 0, 2);

		addChampToTurnOrder(game, champ);
		int randHp = (int) (Math.random() * 20) + 20;
		setObjectHP(champ, randHp);
		int randomHp = (int) (Math.random() * 20) + 20;
		setObjectHP(champ2, randomHp);
		int randomHp2 = (int) (Math.random() * 20) + 20;
		setObjectHP(champ3, randomHp2);

		int randomHp3 = (int) (Math.random() * 20) + 20;
		setObjectHP(champ4, randomHp3);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			int expected = ((randHp + randAmout) > returnMaxHp(champ)) ? returnMaxHp(champ) : (randHp + randAmout);
			assertEquals(
					"Casting healing ability with TEAMTARGET is not applied correctly on current champ, current HP",
					expected, returnHp(champ));

			expected = ((randomHp + randAmout) > returnMaxHp(champ2)) ? returnMaxHp(champ2) : (randomHp + randAmout);
			assertEquals(
					"Casting healing ability with TEAMTARGET is not applied correctly on team members whithin range, current HP",
					expected, returnHp(champ2));

			expected = ((randomHp2 + randAmout) > returnMaxHp(champ3)) ? returnMaxHp(champ3) : (randomHp2 + randAmout);
			assertEquals(
					"Casting healing ability with TEAMTARGET is not applied correctly on team members whithin range, current HP",
					expected, returnHp(champ3));

			expected = ((randomHp3 + randAmout) > returnMaxHp(champ4)) ? returnMaxHp(champ4) : (randomHp3 + randAmout);
			assertEquals(
					"Casting healing ability with TEAMTARGET is not applied correctly on team members whithin range, current HP",
					expected, returnHp(champ4));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting healing ability with area of effect TEAMTARGET ");

		}
	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityTeamTargetSameTeam4() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 2, "TEAMTARGET", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 2, 2);
		setLocationForObject(champ, 2, 2);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);
		// (2,1) (1,2)
		addObjectToBoardGame(game, champ2, 1, 2);
		setLocationForObject(champ2, 1, 2);
		addObjectToBoardGame(game, champ3, 2, 1);
		setLocationForObject(champ3, 2, 1);

		addChampToTurnOrder(game, champ);
		int randHp = (int) (Math.random() * 20) + 20;
		setObjectHP(champ, randHp);
		int randomHp = (int) (Math.random() * 20) + 20;
		setObjectHP(champ2, randomHp);
		int randomHp2 = (int) (Math.random() * 20) + 20;
		setObjectHP(champ3, randomHp2);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			int expected = ((randHp + randAmout) > returnMaxHp(champ)) ? returnMaxHp(champ) : (randHp + randAmout);
			assertEquals(
					"Casting healing ability with TEAMTARGET is not applied correctly on current champ, current HP",
					expected, returnHp(champ));

			expected = ((randomHp + randAmout) > returnMaxHp(champ2)) ? returnMaxHp(champ2) : (randomHp + randAmout);
			assertEquals(
					"Casting healing ability with TEAMTARGET is not applied correctly on team members whithin range, current HP",
					expected, returnHp(champ2));

			expected = ((randomHp2 + randAmout) > returnMaxHp(champ3)) ? returnMaxHp(champ3) : (randomHp2 + randAmout);
			assertEquals(
					"Casting healing ability with TEAMTARGET is not applied correctly on team members whithin range, current HP",
					expected, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting healing ability with area of effect TEAMTARGET ");

		}
	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityTeamTargetSameTeam5() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 2, "TEAMTARGET", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, false, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 2, 2);
		setLocationForObject(champ, 2, 2);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// (3,1) (3,3)
		addObjectToBoardGame(game, champ2, 3, 3);
		setLocationForObject(champ2, 3, 3);
		addObjectToBoardGame(game, champ3, 3, 1);
		setLocationForObject(champ3, 3, 1);

		addChampToTurnOrder(game, champ);
		int randHp = (int) (Math.random() * 20) + 20;
		setObjectHP(champ, randHp);
		int randomHp = (int) (Math.random() * 20) + 20;
		setObjectHP(champ2, randomHp);
		int randomHp2 = (int) (Math.random() * 20) + 20;
		setObjectHP(champ3, randomHp2);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			int expected = ((randHp + randAmout) > returnMaxHp(champ)) ? returnMaxHp(champ) : (randHp + randAmout);
			assertEquals(
					"Casting healing ability with TEAMTARGET is not applied correctly on current champ, current HP",
					expected, returnHp(champ));

			expected = ((randomHp + randAmout) > returnMaxHp(champ2)) ? returnMaxHp(champ2) : (randomHp + randAmout);
			assertEquals(
					"Casting healing ability with TEAMTARGET is not applied correctly on team members whithin range, current HP",
					expected, returnHp(champ2));

			expected = ((randomHp2 + randAmout) > returnMaxHp(champ3)) ? returnMaxHp(champ3) : (randomHp2 + randAmout);
			assertEquals(
					"Casting healing ability with TEAMTARGET is not applied correctly on team members whithin range, current HP",
					expected, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting healing ability with area of effect TEAMTARGET ");

		}
	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityTeamTargetSameTeam6() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 2, "TEAMTARGET", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 2, 2);
		setLocationForObject(champ, 2, 2);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// (1,3) (1,1)
		addObjectToBoardGame(game, champ2, 1, 3);
		setLocationForObject(champ2, 1, 3);
		addObjectToBoardGame(game, champ3, 1, 1);
		setLocationForObject(champ3, 1, 1);

		addChampToTurnOrder(game, champ);
		int randHp = (int) (Math.random() * 20) + 20;
		setObjectHP(champ, randHp);
		int randomHp = (int) (Math.random() * 20) + 20;
		setObjectHP(champ2, randomHp);
		int randomHp2 = (int) (Math.random() * 20) + 20;
		setObjectHP(champ3, randomHp2);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			int expected = ((randHp + randAmout) > returnMaxHp(champ)) ? returnMaxHp(champ) : (randHp + randAmout);
			assertEquals(
					"Casting healing ability with TEAMTARGET is not applied correctly on current champ, current HP",
					expected, returnHp(champ));

			expected = ((randomHp + randAmout) > returnMaxHp(champ2)) ? returnMaxHp(champ2) : (randomHp + randAmout);
			assertEquals(
					"Casting healing ability with TEAMTARGET is not applied correctly on team members whithin range, current HP",
					expected, returnHp(champ2));

			expected = ((randomHp2 + randAmout) > returnMaxHp(champ3)) ? returnMaxHp(champ3) : (randomHp2 + randAmout);
			assertEquals(
					"Casting healing ability with TEAMTARGET is not applied correctly on team members whithin range, current HP",
					expected, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting healing ability with area of effect TEAMTARGET ");

		}
	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityTeamTargetOpponentTeam1() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 1, "TEAMTARGET", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 0);
		setLocationForObject(champ, 0, 0);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		addObjectToBoardGame(game, champ2, 1, 0);
		setLocationForObject(champ2, 1, 0);
		addObjectToBoardGame(game, champ3, 0, 1);
		setLocationForObject(champ3, 0, 1);

		addChampToTurnOrder(game, champ);
		int randHp = (int) (Math.random() * 20) + 20;
		setObjectHP(champ, randHp);
		int randomHp = (int) (Math.random() * 20) + 20;
		setObjectHP(champ2, randomHp);
		int randomHp2 = (int) (Math.random() * 20) + 20;
		setObjectHP(champ3, randomHp2);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			int expected = ((randHp + randAmout) > returnMaxHp(champ)) ? returnMaxHp(champ) : (randHp + randAmout);
			assertEquals(
					"Casting healing ability with TEAMTARGET is not applied correctly on current champ, current HP",
					expected, returnHp(champ));

			assertEquals(
					"Casting healing ability with TEAMTARGET should not be applied on opponent team whithin range, current HP",
					randomHp, returnHp(champ2));

			assertEquals(
					"Casting healing ability with TEAMTARGET should not be applied on opponent team whithin range, current HP",
					randomHp2, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting healing ability with area of effect TEAMTARGET ");

		}
	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityTeamTargetSameTeamOutOfRange2() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 2, "TEAMTARGET", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 2, 2);
		setLocationForObject(champ, 2, 2);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// Out of range (0,4) (3,4)
		addObjectToBoardGame(game, champ2, 0, 4);
		setLocationForObject(champ2, 0, 4);
		addObjectToBoardGame(game, champ3, 3, 4);
		setLocationForObject(champ3, 3, 4);

		addChampToTurnOrder(game, champ);
		int randHp = (int) (Math.random() * 20) + 20;
		setObjectHP(champ, randHp);
		int randomHp = (int) (Math.random() * 20) + 20;
		setObjectHP(champ2, randomHp);
		int randomHp2 = (int) (Math.random() * 20) + 20;
		setObjectHP(champ3, randomHp2);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			int expected = ((randHp + randAmout) > returnMaxHp(champ)) ? returnMaxHp(champ) : (randHp + randAmout);
			assertEquals(
					"Casting healing ability with TEAMTARGET is not applied correctly on current champ, current HP",
					expected, returnHp(champ));

			assertEquals(
					"Casting healing ability with TEAMTARGET should not be applied on team members out of range, current HP",
					randomHp, returnHp(champ2));

			assertEquals(
					"Casting healing ability with TEAMTARGET should not be applied on team members out of range, current HP",
					randomHp2, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting healing ability with area of effect TEAMTARGET ");

		}
	}

	// Start Damaging
	@Test(timeout = 3000)
	public void testCastDamagingAbilityTEAMTARGETCovers() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createDmgAbility("", 1, 1, 1, "TEAMTARGET", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 0);
		setLocationForObject(champ, 4, 0);

		Object cover1 = createCover(3, 0);
		Object cover2 = createCover(4, 1);
		Object cover3 = createCover(3, 1);

		addObjectToBoardGame(game, cover1, 3, 0);
		addObjectToBoardGame(game, cover2, 4, 1);
		addObjectToBoardGame(game, cover3, 3, 1);

		addChampToTurnOrder(game, champ);
		int randomHp = (int) (Math.random() * 20) + 20;
		setObjectHP(cover1, randomHp);
		int randomHp2 = (int) (Math.random() * 20) + 20;
		setObjectHP(cover2, randomHp2);
		Math.random();
		setObjectHP(cover2, randomHp2);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertEquals("Casting damaging ability with TEAMTARGET should not be applied on cover, current HP",
					randomHp, returnHp(cover1));
			assertEquals("Casting damaging ability with TEAMTARGET should not be applied on cover, current HP",
					randomHp2, returnHp(cover2));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting damaging ability with area of effect TEAMTARGET ");

		}
	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityTEAMTARGET1() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 30) + 10;
		Object ability = createDmgAbility("", 1, 1, 1, "TEAMTARGET", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 0);
		setLocationForObject(champ, 4, 0);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		addObjectToBoardGame(game, champ1, 3, 0);
		setLocationForObject(champ1, 3, 0);

		addObjectToBoardGame(game, champ2, 3, 1);
		setLocationForObject(champ2, 3, 1);

		addObjectToBoardGame(game, champ3, 4, 2);
		setLocationForObject(champ3, 4, 2);

		addChampToTurnOrder(game, champ);
		int randomHp = (int) (Math.random() * 20) + 20;
		setObjectHP(champ1, randomHp);
		int randomHp2 = (int) (Math.random() * 20) + 20;
		setObjectHP(champ2, randomHp2);
		int randomHp3 = (int) (Math.random() * 20) + 20;
		setObjectHP(champ3, randomHp3);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			int expected = ((randomHp - randAmout) < 0) ? 0 : (randomHp - randAmout);
			assertEquals(
					"Casting damaging ability with TEAMTARGET is not applied correctly on targets within range, current HP",
					expected, returnHp(champ1));
			expected = ((randomHp2 - randAmout) < 0) ? 0 : (randomHp2 - randAmout);
			assertEquals(
					"Casting damaging ability with TEAMTARGET is not applied correctly on targets within range, current HP",
					randomHp2, returnHp(champ2));

			assertEquals(
					"Casting damaging ability with TEAMTARGET should not be applied on targets out of range, current HP",
					randomHp3, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting damaging ability with area of effect TEAMTARGET ");

		}
	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityTEAMTARGET2() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 30) + 10;
		Object ability = createDmgAbility("", 1, 1, 2, "TEAMTARGET", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 0);
		setLocationForObject(champ, 4, 0);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// (4,1) (4,2)(3,0)
		addObjectToBoardGame(game, champ1, 3, 0);
		setLocationForObject(champ1, 3, 0);

		addObjectToBoardGame(game, champ2, 4, 1);
		setLocationForObject(champ2, 4, 1);

		addObjectToBoardGame(game, champ3, 3, 0);
		setLocationForObject(champ3, 3, 0);

		addChampToTurnOrder(game, champ);
		int randomHp = (int) (Math.random() * 20) + 20;
		setObjectHP(champ1, randomHp);
		int randomHp2 = (int) (Math.random() * 20) + 20;
		setObjectHP(champ2, randomHp2);
		int randomHp3 = (int) (Math.random() * 20) + 20;
		setObjectHP(champ3, randomHp3);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			int expected = ((randomHp - randAmout) < 0) ? 0 : (randomHp - randAmout);
			assertEquals(
					"Casting damaging ability with TEAMTARGET is not applied correctly on targets within range, current HP",
					expected, returnHp(champ1));
			expected = ((randomHp2 - randAmout) < 0) ? 0 : (randomHp2 - randAmout);
			assertEquals(
					"Casting damaging ability with TEAMTARGET is not applied correctly on targets within range, current HP",
					expected, returnHp(champ2));

			expected = ((randomHp3 - randAmout) < 0) ? 0 : (randomHp3 - randAmout);
			assertEquals(
					"Casting damaging ability with TEAMTARGET is not applied correctly on targets within range, current HP",
					expected, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting damaging ability with area of effect TEAMTARGET");

		}
	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityTEAMTARGET3() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 30) + 10;
		Object ability = createDmgAbility("", 1, 1, 2, "TEAMTARGET", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, false, champ);
		createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 0);
		setLocationForObject(champ, 4, 0);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);

		// (2,0) (3,1)
		addObjectToBoardGame(game, champ1, 2, 0);
		setLocationForObject(champ1, 2, 0);

		addObjectToBoardGame(game, champ2, 3, 1);
		setLocationForObject(champ2, 3, 1);

		addChampToTurnOrder(game, champ);
		int randomHp = (int) (Math.random() * 20) + 20;
		setObjectHP(champ1, randomHp);
		int randomHp2 = (int) (Math.random() * 20) + 20;
		setObjectHP(champ2, randomHp2);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			int expected = ((randomHp - randAmout) < 0) ? 0 : (randomHp - randAmout);
			assertEquals(
					"Casting damaging ability with TEAMTARGET is not applied correctly on targets within range, current HP",
					expected, returnHp(champ1));
			expected = ((randomHp2 - randAmout) < 0) ? 0 : (randomHp2 - randAmout);
			assertEquals(
					"Casting damaging ability with TEAMTARGET is not applied correctly on targets within range, current HP",
					expected, returnHp(champ2));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting damaging ability with area of effect TEAMTARGET ");

		}
	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityTEAMTARGET4() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 30) + 10;
		Object ability = createDmgAbility("", 1, 1, 1, "TEAMTARGET", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 0);
		setLocationForObject(champ, 0, 0);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// champ at (0,0) and range 1:

		// targets at (1,0), (0,1) case13
		// not at (1,1) case14
		addObjectToBoardGame(game, champ1, 1, 0);
		setLocationForObject(champ1, 1, 0);

		addObjectToBoardGame(game, champ2, 0, 1);
		setLocationForObject(champ2, 0, 1);

		addObjectToBoardGame(game, champ3, 1, 1);
		setLocationForObject(champ3, 1, 1);

		addChampToTurnOrder(game, champ);
		int randomHp = (int) (Math.random() * 20) + 20;
		setObjectHP(champ1, randomHp);
		int randomHp2 = (int) (Math.random() * 20) + 20;
		setObjectHP(champ2, randomHp2);
		int randomHp3 = (int) (Math.random() * 20) + 20;
		setObjectHP(champ3, randomHp3);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			int expected = ((randomHp - randAmout) < 0) ? 0 : (randomHp - randAmout);
			assertEquals(
					"Casting damaging ability with TEAMTARGET is not applied correctly on targets within range, current HP",
					expected, returnHp(champ1));
			expected = ((randomHp2 - randAmout) < 0) ? 0 : (randomHp2 - randAmout);
			assertEquals(
					"Casting damaging ability with TEAMTARGET is not applied correctly on targets within range, current HP",
					expected, returnHp(champ2));

			assertEquals(
					"Casting damaging ability with TEAMTARGET should not be applied on targets out of range, current HP",
					randomHp3, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting damaging ability with area of effect TEAMTARGET ");

		}
	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityTEAMTARGETOutOfRange() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 30) + 10;
		Object ability = createDmgAbility("", 1, 1, 2, "TEAMTARGET", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 0);
		setLocationForObject(champ, 4, 0);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// (3,2) (2,1) (4,4)
		addObjectToBoardGame(game, champ1, 3, 2);
		setLocationForObject(champ1, 3, 2);

		addObjectToBoardGame(game, champ2, 2, 1);
		setLocationForObject(champ2, 2, 1);

		addObjectToBoardGame(game, champ3, 4, 4);
		setLocationForObject(champ3, 4, 4);

		addChampToTurnOrder(game, champ);
		int randomHp = (int) (Math.random() * 20) + 20;
		setObjectHP(champ1, randomHp);
		int randomHp2 = (int) (Math.random() * 20) + 20;
		setObjectHP(champ2, randomHp2);
		int randomHp3 = (int) (Math.random() * 20) + 20;
		setObjectHP(champ3, randomHp3);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			assertEquals(
					"Casting damaging ability with TEAMTARGET should not be applied on targets out of range, current HP",
					randomHp, returnHp(champ1));
			assertEquals(
					"Casting damaging ability with TEAMTARGET should not be applied on targets out of range, current HP",
					randomHp2, returnHp(champ2));
			assertEquals(
					"Casting damaging ability with TEAMTARGET should not be applied on targets out of range, current HP",
					randomHp3, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting damaging ability with area of effect TEAMTARGET ");

		}
	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityTEAMTARGETOnSameTeam() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 30) + 10;
		Object ability = createDmgAbility("", 1, 1, 2, "TEAMTARGET", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 0);
		setLocationForObject(champ, 4, 0);

		Object champ1 = team.get(1);
		Object champ2 = team.get(2);

		// (2,0) (3,1)
		addObjectToBoardGame(game, champ1, 2, 0);
		setLocationForObject(champ1, 2, 0);

		addObjectToBoardGame(game, champ2, 3, 1);
		setLocationForObject(champ2, 3, 1);

		addChampToTurnOrder(game, champ);
		int randomHp = (int) (Math.random() * 20) + 20;
		setObjectHP(champ1, randomHp);
		int randomHp2 = (int) (Math.random() * 20) + 20;
		setObjectHP(champ2, randomHp2);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			assertEquals(
					"Casting damaging ability with TEAMTARGET should not be applied on the champion's team within range, current HP",
					randomHp, returnHp(champ1));
			assertEquals(
					"Casting damaging ability with TEAMTARGET should not be applied on the champion's team within range, current HP",
					randomHp2, returnHp(champ2));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting damaging ability with area of effect TEAMTARGET ");

		}
	}

	// Start Buff CC
	@Test(timeout = 3000)
	public void testCastCCAbilityTeamTargetSameTeam1() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createPowerUpEffect(2);
		Object ability = createCCAbility("", 1, 1, 2, "TEAMTARGET", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, false, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 4);
		setLocationForObject(champ, 0, 4);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// (2,4) (1,3)
		addObjectToBoardGame(game, champ2, 2, 4);
		setLocationForObject(champ2, 2, 4);
		addObjectToBoardGame(game, champ3, 1, 3);
		setLocationForObject(champ3, 1, 3);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertTrue("Casting power up CC ability with TEAMTARGET is not applied correctly on current champ",
					containsEffect(champ, effect, true));
			assertTrue("Casting power up CC ability with TEAMTARGET is not applied correctly on targets whithin range",
					containsEffect(champ2, effect, true));
			assertTrue("Casting power up CC ability with TEAMTARGET is not applied correctly on targets whithin range",
					containsEffect(champ3, effect, true));

		} catch (Exception e) {

			fail(e.getCause().getClass()
					+ " occurred while casting power up CC ability with area of effect TEAMTARGET ");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCAbilityTeamTargetSameTeam2() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createSpeedUpEffect(2);
		Object ability = createCCAbility("", 1, 1, 2, "TEAMTARGET", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 4);
		setLocationForObject(champ, 0, 4);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// (0,2) (1,4)
		addObjectToBoardGame(game, champ2, 0, 2);
		setLocationForObject(champ2, 0, 2);
		addObjectToBoardGame(game, champ3, 1, 4);
		setLocationForObject(champ3, 1, 4);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertTrue("Casting speed up CC ability with TEAMTARGET is not applied correctly on current champ",
					containsEffect(champ, effect, true));
			assertTrue("Casting speed up CC ability with TEAMTARGET is not applied correctly on targets within range",
					containsEffect(champ2, effect, true));
			assertTrue("Casting speed up CC ability with TEAMTARGET is not applied correctly on targets within range",
					containsEffect(champ3, effect, true));

		} catch (Exception e) {

			fail(e.getCause().getClass()
					+ " occurred while casting speed up CC ability with area of effect TEAMTARGET ");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCAbilityTeamTargetSameTeam4() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createSheildEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "TEAMTARGET", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, false, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 3, 1);
		setLocationForObject(champ, 3, 1);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// (4,1) (3,0) (3,2)(2,1)
		addObjectToBoardGame(game, champ2, 4, 1);
		setLocationForObject(champ2, 4, 1);
		addObjectToBoardGame(game, champ3, 3, 0);
		setLocationForObject(champ3, 3, 0);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertTrue("Casting speed up CC ability with TEAMTARGET is not applied correctly on current champ",
					containsEffect(champ, effect, true));
			assertTrue("Casting speed up CC ability with TEAMTARGET is not applied correctly on targets within range",
					containsEffect(champ2, effect, true));
			assertTrue("Casting speed up CC ability with TEAMTARGET is not applied correctly on targets within range",
					containsEffect(champ3, effect, true));

		} catch (Exception e) {

			fail(e.getCause().getClass()
					+ " occurred while casting speed up CC ability with area of effect TEAMTARGET ");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCAbilityTeamTargetSameTeamOutOfRange() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createSpeedUpEffect(2);
		Object ability = createCCAbility("", 1, 1, 2, "TEAMTARGET", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 4);
		setLocationForObject(champ, 0, 4);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// (1,2) (2,2)
		addObjectToBoardGame(game, champ2, 1, 2);
		setLocationForObject(champ2, 1, 2);
		addObjectToBoardGame(game, champ3, 2, 2);
		setLocationForObject(champ3, 2, 2);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertTrue("Casting speed up CC ability with TEAMTARGET is not applied correctly on current champ",
					containsEffect(champ, effect, true));
			assertFalse(
					"Casting speed up CC ability with TEAMTARGET should not be applied on team members out of range",
					containsEffect(champ2, effect, false));
			assertFalse(
					"Casting speed up CC ability with TEAMTARGET should not be applied on team members out of range",
					containsEffect(champ3, effect, false));

		} catch (Exception e) {

			fail(e.getCause().getClass()
					+ " occurred while casting speed up CC ability with area of effect TEAMTARGET ");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCAbilityTeamTargetSameTeamOutOfRange2() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createSpeedUpEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "TEAMTARGET", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 3, 1);
		setLocationForObject(champ, 3, 1);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// 4,0) (2,0) (4,2)
		addObjectToBoardGame(game, champ2, 4, 0);
		setLocationForObject(champ2, 4, 0);
		addObjectToBoardGame(game, champ3, 2, 0);
		setLocationForObject(champ3, 2, 0);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertTrue("Casting speed up CC ability with TEAMTARGET is not applied correctly on current champ",
					containsEffect(champ, effect, true));
			assertFalse(
					"Casting speed up CC ability with TEAMTARGET should not be applied on team members out of range",
					containsEffect(champ2, effect, false));
			assertFalse(
					"Casting speed up CC ability with TEAMTARGET should not be applied on team members out of range",
					containsEffect(champ3, effect, false));

		} catch (Exception e) {

			fail(e.getCause().getClass()
					+ " occurred while casting speed up CC ability with area of effect TEAMTARGET ");

		}
	}

	// Start DeBuff CC
	@Test(timeout = 3000)
	public void testCastCCAbilityTeamTargetDeBuff1() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createDisarmEffect(2);
		Object ability = createCCAbility("", 1, 1, 2, "TEAMTARGET", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 4);
		setLocationForObject(champ, 4, 4);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// (4,2) (4,3) (3,4)
		addObjectToBoardGame(game, champ1, 4, 2);
		setLocationForObject(champ1, 4, 2);
		addObjectToBoardGame(game, champ2, 4, 3);
		setLocationForObject(champ2, 4, 3);

		addObjectToBoardGame(game, champ3, 3, 4);
		setLocationForObject(champ3, 3, 4);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertTrue("Casting disarm CC ability with TEAMTARGET is not applied correctly on targets within range",
					containsEffect(champ1, effect, true));
			assertTrue("Casting disarm CC ability with TEAMTARGET is not applied correctly on targets within range",
					containsEffect(champ2, effect, true));
			assertTrue("Casting disarm CC ability with TEAMTARGET is not applied correctly on targets within range",
					containsEffect(champ3, effect, true));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting disarm CC ability with area of effect TEAMTARGET ");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCAbilityTeamTargetDeBuff3() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createShockEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "TEAMTARGET", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 3, 3);
		setLocationForObject(champ, 3, 3);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		addObjectToBoardGame(game, champ1, 4, 3);
		setLocationForObject(champ1, 4, 3);
		addObjectToBoardGame(game, champ2, 2, 3);
		setLocationForObject(champ2, 2, 3);
		addObjectToBoardGame(game, champ3, 3, 4);
		setLocationForObject(champ3, 3, 4);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertTrue("Casting disarm CC ability with TEAMTARGET is not applied correctly on targets within range",
					containsEffect(champ1, effect, true));
			assertTrue("Casting disarm CC ability with TEAMTARGET is not applied correctly on targets within range",
					containsEffect(champ2, effect, true));
			assertTrue("Casting disarm CC ability with TEAMTARGET is not applied correctly on targets within range",
					containsEffect(champ3, effect, true));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting disarm CC ability with area of effect TEAMTARGET ");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCAbilityTeamTargetSameTeamDeBuff() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createDisarmEffect(2);
		Object ability = createCCAbility("", 1, 1, 2, "TEAMTARGET", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, false, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 4);
		setLocationForObject(champ, 4, 4);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// (4,2) (4,3) (3,4)
		// addObjectToBoardGame(game, champ1, 4,2);
		// setLocationForObject(champ1, 4,2);
		addObjectToBoardGame(game, champ2, 4, 3);
		setLocationForObject(champ2, 4, 3);

		addObjectToBoardGame(game, champ3, 3, 4);
		setLocationForObject(champ3, 3, 4);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertFalse("Casting disarm CC ability with TEAMTARGET should not be applied on the current champion",
					containsEffect(champ, effect, false));
			assertFalse(
					"Casting disarm CC ability with TEAMTARGET should not be applied on champion's team within range",
					containsEffect(champ2, effect, false));
			assertFalse(
					"Casting disarm CC ability with TEAMTARGET should not be applied on champion's team within range",
					containsEffect(champ3, effect, false));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting disarm CC ability with area of effect TEAMTARGET ");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCAbilityTeamTargetOutOfRange() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createDisarmEffect(2);
		Object ability = createCCAbility("", 1, 1, 2, "TEAMTARGET", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 4);
		setLocationForObject(champ, 4, 4);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// (2,3) (2,2) (3,2)
		addObjectToBoardGame(game, champ1, 2, 3);
		setLocationForObject(champ1, 2, 3);
		addObjectToBoardGame(game, champ2, 2, 2);
		setLocationForObject(champ2, 2, 2);

		addObjectToBoardGame(game, champ3, 3, 2);
		setLocationForObject(champ3, 3, 2);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertFalse("Casting disarm CC ability with TEAMTARGET should not be applied on team members out of range",
					containsEffect(champ1, effect, false));
			assertFalse("Casting disarm CC ability with TEAMTARGET should not be applied on team members out of range",
					containsEffect(champ2, effect, false));
			assertFalse("Casting disarm CC ability with TEAMTARGET should not be applied on team members out of range",
					containsEffect(champ3, effect, false));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting disarm CC ability with area of effect TEAMTARGET ");

		}
	}

	// Surround cases
	// Healing

	@Test(timeout = 3000)
	public void testCastHealingAbilitySurround1() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 0);
		setLocationForObject(champ, 0, 0);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// within (1,0), (0,1) (1,1)

		addObjectToBoardGame(game, champ2, 0, 1);
		setLocationForObject(champ2, 0, 1);

		addObjectToBoardGame(game, champ3, 1, 1);
		setLocationForObject(champ3, 1, 1);

		addChampToTurnOrder(game, champ);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ2, hp1);
		setObjectHP(champ3, hp2);

		try {

			int champHP = returnHp(champ);
			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertEquals(
					"Casting Healing ability with area of effect Surround should not be applied on the current champ, current HP",
					champHP, returnHp(champ));

			int expected = ((hp1 + randAmout) > returnMaxHp(champ2)) ? returnMaxHp(champ2) : (hp1 + randAmout);
			assertEquals(
					"Casting Healing ability should be applied on the same team champions within range, current HP",
					expected, returnHp(champ2));

			expected = ((hp2 + randAmout) > returnMaxHp(champ3)) ? returnMaxHp(champ3) : (hp2 + randAmout);
			assertEquals(
					"Casting Healing ability should be applied on the same team champions within range, current HP",
					expected, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastHealingAbilitySurroundOutOfRange1() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, false, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 0);
		setLocationForObject(champ, 0, 0);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ2, hp1);
		setObjectHP(champ3, hp2);

		// out of range (1,2) (2,1)
		addObjectToBoardGame(game, champ2, 1, 2);
		setLocationForObject(champ2, 1, 2);

		addObjectToBoardGame(game, champ3, 2, 1);
		setLocationForObject(champ3, 2, 1);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertEquals(
					"Casting Healing ability should not be applied on the same team champions out of range, current HP",
					hp1, returnHp(champ2));
			assertEquals(
					"Casting Healing ability should not be applied on the same team champions out of range, current HP",
					hp2, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastHealingAbilitySurround2() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, false, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 0);
		setLocationForObject(champ, 4, 0);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// within (3,0) (4,1) (3,1)

		addObjectToBoardGame(game, champ2, 4, 1);
		setLocationForObject(champ2, 4, 1);

		addObjectToBoardGame(game, champ3, 3, 1);
		setLocationForObject(champ3, 3, 1);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ2, hp1);
		setObjectHP(champ3, hp2);

		addChampToTurnOrder(game, champ);

		try {

			int champHP = returnHp(champ);
			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertEquals(
					"Casting Healing ability with area of effect Surround should not be applied on the current champ, current HP",
					champHP, returnHp(champ));

			int expected = ((hp1 + randAmout) > returnMaxHp(champ2)) ? returnMaxHp(champ2) : (hp1 + randAmout);
			assertEquals(
					"Casting Healing ability should be applied on the same team champions within range, current HP",
					expected, returnHp(champ2));

			expected = ((hp2 + randAmout) > returnMaxHp(champ3)) ? returnMaxHp(champ3) : (hp2 + randAmout);
			assertEquals(
					"Casting Healing ability should be applied on the same team champions within range, current HP",
					expected, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastHealingAbilitySurroundOutOfRange2() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 0);
		setLocationForObject(champ, 0, 0);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ2, hp1);
		setObjectHP(champ3, hp2);

		// out of range (2,0) (2,1) (4,2)
		addObjectToBoardGame(game, champ2, 2, 0);
		setLocationForObject(champ2, 2, 0);

		addObjectToBoardGame(game, champ3, 2, 1);
		setLocationForObject(champ3, 2, 1);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			assertEquals(
					"Casting Healing ability should not be applied on the same team champions out of range, current HP",
					hp1, returnHp(champ2));
			assertEquals(
					"Casting Healing ability should not be applied on the same team champions out of range, current HP",
					hp2, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastHealingAbilitySurround4() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, false, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 4);
		setLocationForObject(champ, 0, 4);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ2, hp1);
		setObjectHP(champ3, hp2);
		// within (0,3) (1,4) (1,3)

		addObjectToBoardGame(game, champ2, 1, 4);
		setLocationForObject(champ2, 1, 4);

		addObjectToBoardGame(game, champ3, 1, 3);
		setLocationForObject(champ3, 1, 3);

		addChampToTurnOrder(game, champ);
		try {

			int champHP = returnHp(champ);
			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertEquals(
					"Casting Healing ability with area of effect Surround should not be applied on the current champ, current HP",
					champHP, returnHp(champ));

			int expected = ((hp1 + randAmout) > returnMaxHp(champ2)) ? returnMaxHp(champ2) : (hp1 + randAmout);
			assertEquals(
					"Casting Healing ability should be applied on the same team champions within range, current HP",
					expected, returnHp(champ2));

			expected = ((hp2 + randAmout) > returnMaxHp(champ3)) ? returnMaxHp(champ3) : (hp2 + randAmout);
			assertEquals(
					"Casting Healing ability should be applied on the same team champions within range, current HP",
					expected, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastHealingAbilitySurroundOutOfRange4() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 4);
		setLocationForObject(champ, 0, 4);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ2, hp1);
		setObjectHP(champ3, hp2);

		// out of range (0,0) (0,1) (0,2) (1,0) (1,1) (1,2) (2,4)
		addObjectToBoardGame(game, champ2, 0, 2);
		setLocationForObject(champ2, 0, 2);

		addObjectToBoardGame(game, champ3, 1, 2);
		setLocationForObject(champ3, 1, 2);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			assertEquals(
					"Casting Healing ability should not be applied on the same team champions out of range, current HP",
					hp1, returnHp(champ2));
			assertEquals(
					"Casting Healing ability should not be applied on the same team champions out of range, current HP",
					hp2, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastHealingAbilitySurround5() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 1, 3);
		setLocationForObject(champ, 1, 3);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ2, hp1);
		setObjectHP(champ3, hp2);
		// within (2,2) (2,3) (2,4)

		addObjectToBoardGame(game, champ2, 2, 3);
		setLocationForObject(champ2, 2, 3);

		addObjectToBoardGame(game, champ3, 2, 4);
		setLocationForObject(champ3, 2, 4);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			int expected = ((hp1 + randAmout) > returnMaxHp(champ2)) ? returnMaxHp(champ2) : (hp1 + randAmout);
			assertEquals(
					"Casting Healing ability should be applied on the same team champions within range, current HP",
					expected, returnHp(champ2));

			expected = ((hp2 + randAmout) > returnMaxHp(champ3)) ? returnMaxHp(champ3) : (hp2 + randAmout);
			assertEquals(
					"Casting Healing ability should be applied on the same team champions within range, current HP",
					expected, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastHealingAbilitySurround6() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, false, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 1, 3);
		setLocationForObject(champ, 1, 3);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ2, hp1);
		setObjectHP(champ3, hp2);
		// within (1,2) (1,4)
		addObjectToBoardGame(game, champ2, 1, 2);
		setLocationForObject(champ2, 1, 2);

		addObjectToBoardGame(game, champ3, 1, 4);
		setLocationForObject(champ3, 1, 4);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			int expected = ((hp1 + randAmout) > returnMaxHp(champ2)) ? returnMaxHp(champ2) : (hp1 + randAmout);
			assertEquals(
					"Casting Healing ability should be applied on the same team champions within range, current HP",
					expected, returnHp(champ2));

			expected = ((hp2 + randAmout) > returnMaxHp(champ3)) ? returnMaxHp(champ3) : (hp2 + randAmout);
			assertEquals(
					"Casting Healing ability should be applied on the same team champions within range, current HP",
					expected, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastHealingAbilitySurroundOutOfRange5() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 1, 3);
		setLocationForObject(champ, 1, 3);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ2, hp1);
		setObjectHP(champ3, hp2);

		addObjectToBoardGame(game, champ2, 0, 1);
		setLocationForObject(champ2, 0, 1);

		addObjectToBoardGame(game, champ3, 1, 1);
		setLocationForObject(champ3, 1, 1);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertEquals(
					"Casting Healing ability should not be applied on the same team champions out of range, current HP",
					hp1, returnHp(champ2));
			assertEquals(
					"Casting Healing ability should not be applied on the same team champions out of range, current HP",
					hp2, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastHealingAbilitySurroundCovers1() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 1, 3);
		setLocationForObject(champ, 1, 3);

		Object cover1 = createCover(2, 3);
		Object cover2 = createCover(2, 4);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		setObjectHP(cover1, hp1);
		setObjectHP(cover2, hp2);
		// within (2,2) (2,3) (2,4)

		addObjectToBoardGame(game, cover1, 2, 3);

		addObjectToBoardGame(game, cover2, 2, 4);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertEquals("Casting Healing ability should not be applied on covers within range, current HP", hp1,
					returnHp(cover1));

			assertEquals("Casting Healing ability should not be applied on covers within range, current HP", hp2,
					returnHp(cover2));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastHealingAbilitySurroundOpponentTeam2() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 1, 3);
		setLocationForObject(champ, 1, 3);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ2, hp1);
		setObjectHP(champ3, hp2);
		// within (1,2) (1,4)
		addObjectToBoardGame(game, champ2, 1, 2);
		setLocationForObject(champ2, 1, 2);

		addObjectToBoardGame(game, champ3, 1, 4);
		setLocationForObject(champ3, 1, 4);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			assertEquals(
					"Casting Healing ability should not be applied on the opponent team champions within range, current HP",
					hp1, returnHp(champ2));

			assertEquals(
					"Casting Healing ability should be not applied on the opponent team champions within range, current HP",
					hp2, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastHealingAbilitySurroundOpponentTeam3() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, false, champ);
		createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 1, 3);
		setLocationForObject(champ, 1, 3);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ2, hp1);
		setObjectHP(champ3, hp2);
		// within (0,2) (0,3) (0,4)
		addObjectToBoardGame(game, champ2, 0, 2);
		setLocationForObject(champ2, 0, 2);

		addObjectToBoardGame(game, champ3, 0, 4);
		setLocationForObject(champ3, 0, 4);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			assertEquals(
					"Casting Healing ability should not be applied on the opponent team champions within range, current HP",
					hp1, returnHp(champ2));

			assertEquals(
					"Casting Healing ability should not be applied on the opponent team champions within range, current HP",
					hp2, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	// Damaging

	@Test(timeout = 3000)
	public void testCastDamagingAbilitySurround2() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createDmgAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 0);
		setLocationForObject(champ, 4, 0);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp1 = (int) (Math.random() * 20) + 40;
		int hp2 = (int) (Math.random() * 20) + 40;
		int hp3 = (int) (Math.random() * 20) + 40;
		setObjectHP(champ1, hp1);
		setObjectHP(champ2, hp2);
		setObjectHP(champ3, hp3);
		// within (3,0) (4,1) (3,1)
		addObjectToBoardGame(game, champ1, 3, 0);
		setLocationForObject(champ1, 3, 0);

		addObjectToBoardGame(game, champ2, 4, 1);
		setLocationForObject(champ2, 4, 1);

		addObjectToBoardGame(game, champ3, 3, 1);
		setLocationForObject(champ3, 3, 1);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			int expected = ((hp1 - randAmout) < 0) ? 0 : (hp1 - randAmout);

			assertEquals(
					"Casting damaging ability should be applied on the opponent team champions within range, current HP",
					expected, returnHp(champ1));
			expected = ((hp2 - randAmout) < 0) ? 0 : (hp2 - randAmout);
			assertEquals(
					"Casting damaging ability should be applied on the opponent team champions within range, current HP",
					expected, returnHp(champ2));

			expected = ((hp3 - randAmout) < 0) ? 0 : (hp3 - randAmout);
			assertEquals(
					"Casting damaging ability should be applied on the opponent team champions within range, current HP",
					expected, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilitySurroundOutOfRange2() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createDmgAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, false, champ);
		createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 0);
		setLocationForObject(champ, 0, 0);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp2 = (int) (Math.random() * 30) + 40;
		int hp3 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ2, hp2);
		setObjectHP(champ3, hp3);

		// out of range (2,0) (2,1) (4,2)
		addObjectToBoardGame(game, champ2, 2, 0);
		setLocationForObject(champ2, 2, 0);

		addObjectToBoardGame(game, champ3, 2, 1);
		setLocationForObject(champ3, 2, 1);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			assertEquals("Casting damaging ability should not be applied on champions out of range, current HP", hp2,
					returnHp(champ2));
			assertEquals("Casting damaging ability should not be applied on champions out of range, current HP", hp3,
					returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilitySurround3() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 30) + 20;
		Object ability = createDmgAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 4);
		setLocationForObject(champ, 4, 4);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		int hp3 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ1, hp1);
		setObjectHP(champ2, hp2);
		setObjectHP(champ3, hp3);
		// within (4,3) (3,4) (3,3)
		addObjectToBoardGame(game, champ1, 4, 3);
		setLocationForObject(champ1, 4, 3);

		addObjectToBoardGame(game, champ2, 3, 4);
		setLocationForObject(champ2, 3, 4);

		addObjectToBoardGame(game, champ3, 3, 3);
		setLocationForObject(champ3, 3, 3);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			int expected = ((hp1 - randAmout) < 0) ? 0 : (hp1 - randAmout);

			assertEquals(
					"Casting damaging ability should be applied on the opponent team champions within range, current HP",
					expected, returnHp(champ1));
			expected = ((hp2 - randAmout) < 0) ? 0 : (hp2 - randAmout);
			assertEquals(
					"Casting damaging ability should be applied on the opponent team champions within range, current HP",
					expected, returnHp(champ2));

			expected = ((hp3 - randAmout) < 0) ? 0 : (hp3 - randAmout);
			assertEquals(
					"Casting damaging ability should be applied on the opponent team champions within range, current HP",
					expected, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilitySurroundOutOfRange3() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 30) + 20;
		Object ability = createDmgAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 4);
		setLocationForObject(champ, 4, 4);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp2 = (int) (Math.random() * 30) + 40;
		int hp3 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ2, hp2);
		setObjectHP(champ3, hp3);

		// out of range (2,3) (2,4)
		addObjectToBoardGame(game, champ2, 2, 3);
		setLocationForObject(champ2, 2, 3);

		addObjectToBoardGame(game, champ3, 2, 4);
		setLocationForObject(champ3, 2, 4);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			assertEquals("Casting damaging ability should not be applied on champions out of range, current HP", hp2,
					returnHp(champ2));
			assertEquals("Casting damaging ability should not be applied on champions out of range, current HP", hp3,
					returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilitySurround4() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createDmgAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 4);
		setLocationForObject(champ, 0, 4);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		int hp3 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ1, hp1);
		setObjectHP(champ2, hp2);
		setObjectHP(champ3, hp3);
		// within (0,3) (1,4) (1,3)
		addObjectToBoardGame(game, champ1, 0, 3);
		setLocationForObject(champ1, 0, 3);

		addObjectToBoardGame(game, champ2, 1, 4);
		setLocationForObject(champ2, 1, 4);

		addObjectToBoardGame(game, champ3, 1, 3);
		setLocationForObject(champ3, 1, 3);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			int expected = ((hp1 - randAmout) < 0) ? 0 : (hp1 - randAmout);

			assertEquals(
					"Casting damaging ability should be applied on the opponent team champions within range, current HP",
					expected, returnHp(champ1));
			expected = ((hp2 - randAmout) < 0) ? 0 : (hp2 - randAmout);
			assertEquals(
					"Casting damaging ability should be applied on the opponent team champions within range, current HP",
					expected, returnHp(champ2));

			expected = ((hp3 - randAmout) < 0) ? 0 : (hp3 - randAmout);
			assertEquals(
					"Casting damaging ability should be applied on the opponent team champions within range, current HP",
					expected, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilitySurroundOutOfRange4() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createDmgAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 4);
		setLocationForObject(champ, 0, 4);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp2 = (int) (Math.random() * 30) + 40;
		int hp3 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ2, hp2);
		setObjectHP(champ3, hp3);

		// out of range (0,0) (0,1) (0,2) (1,0) (1,1) (1,2) (2,4)
		addObjectToBoardGame(game, champ2, 0, 2);
		setLocationForObject(champ2, 0, 2);

		addObjectToBoardGame(game, champ3, 1, 2);
		setLocationForObject(champ3, 1, 2);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			assertEquals("Casting damaging ability should not be applied on champions out of range, current HP", hp2,
					returnHp(champ2));
			assertEquals("Casting damaging ability should not be applied on champions out of range, current HP", hp3,
					returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilitySurround5() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createDmgAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 1, 3);
		setLocationForObject(champ, 1, 3);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		int hp3 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ1, hp1);
		setObjectHP(champ2, hp2);
		setObjectHP(champ3, hp3);
		// within (2,2) (2,3) (2,4)
		addObjectToBoardGame(game, champ1, 2, 2);
		setLocationForObject(champ1, 2, 2);

		addObjectToBoardGame(game, champ2, 2, 3);
		setLocationForObject(champ2, 2, 3);

		addObjectToBoardGame(game, champ3, 2, 4);
		setLocationForObject(champ3, 2, 4);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			int expected = ((hp1 - randAmout) < 0) ? 0 : (hp1 - randAmout);

			assertEquals(
					"Casting damaging ability should be applied on the opponent team champions within range, current HP",
					expected, returnHp(champ1));
			expected = ((hp2 - randAmout) < 0) ? 0 : (hp2 - randAmout);
			assertEquals(
					"Casting damaging ability should be applied on the opponent team champions within range, current HP",
					expected, returnHp(champ2));

			expected = ((hp3 - randAmout) < 0) ? 0 : (hp3 - randAmout);
			assertEquals(
					"Casting damaging ability should be applied on the opponent team champions within range, current HP",
					expected, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilitySurround6() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createDmgAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 1, 3);
		setLocationForObject(champ, 1, 3);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp2 = (int) (Math.random() * 30) + 40;
		int hp3 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ2, hp2);
		setObjectHP(champ3, hp3);
		// within (1,2) (1,4)
		addObjectToBoardGame(game, champ2, 1, 2);
		setLocationForObject(champ2, 1, 2);

		addObjectToBoardGame(game, champ3, 1, 4);
		setLocationForObject(champ3, 1, 4);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			int expected;
			expected = ((hp2 - randAmout) < 0) ? 0 : (hp2 - randAmout);
			assertEquals(
					"Casting damaging ability should be applied on the opponent team champions within range, current HP",
					expected, returnHp(champ2));

			expected = ((hp3 - randAmout) < 0) ? 0 : (hp3 - randAmout);
			assertEquals(
					"Casting damaging ability should be applied on the opponent team champions within range, current HP",
					expected, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilitySurround7() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createDmgAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 1, 3);
		setLocationForObject(champ, 1, 3);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		int hp3 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ1, hp1);
		setObjectHP(champ2, hp2);
		setObjectHP(champ3, hp3);
		// within (0,2) (0,3) (0,4)
		addObjectToBoardGame(game, champ2, 0, 2);
		setLocationForObject(champ2, 0, 2);

		addObjectToBoardGame(game, champ1, 0, 3);
		setLocationForObject(champ1, 0, 3);

		addObjectToBoardGame(game, champ3, 0, 4);
		setLocationForObject(champ3, 0, 4);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			int expected = ((hp1 - randAmout) < 0) ? 0 : (hp1 - randAmout);

			assertEquals(
					"Casting damaging ability should be applied on the opponent team champions within range, current HP",
					expected, returnHp(champ1));
			expected = ((hp2 - randAmout) < 0) ? 0 : (hp2 - randAmout);
			assertEquals(
					"Casting damaging ability should be applied on the opponent team champions within range, current HP",
					expected, returnHp(champ2));

			expected = ((hp3 - randAmout) < 0) ? 0 : (hp3 - randAmout);
			assertEquals(
					"Casting damaging ability should be applied on the opponent team champions within range, current HP",
					expected, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilitySurroundOutOfRange5() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createDmgAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 1, 3);
		setLocationForObject(champ, 1, 3);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp2 = (int) (Math.random() * 30) + 40;
		int hp3 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ2, hp2);
		setObjectHP(champ3, hp3);

		addObjectToBoardGame(game, champ2, 0, 1);
		setLocationForObject(champ2, 0, 1);

		addObjectToBoardGame(game, champ3, 1, 1);
		setLocationForObject(champ3, 1, 1);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			assertEquals("Casting damaging ability should not be applied on champions out of range, current HP", hp2,
					returnHp(champ2));
			assertEquals("Casting damaging ability should not be applied on champions out of range, current HP", hp3,
					returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilitySameTeamSurround2() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createDmgAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, false, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 0);
		setLocationForObject(champ, 4, 0);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp2 = (int) (Math.random() * 30) + 40;
		int hp3 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ2, hp2);
		setObjectHP(champ3, hp3);
		// within (3,0) (4,1) (3,1)

		addObjectToBoardGame(game, champ2, 4, 1);
		setLocationForObject(champ2, 4, 1);

		addObjectToBoardGame(game, champ3, 3, 1);
		setLocationForObject(champ3, 3, 1);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertEquals(
					"Casting damaging ability should not be applied on the champion's team within range, current HP",
					hp2, returnHp(champ2));
			assertEquals(
					"Casting damaging ability should not be applied on the champion's team within range, current HP",
					hp3, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityCoversSurroundOutOfRange2() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createDmgAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 0);
		setLocationForObject(champ, 0, 0);

		Object cover1 = createCover(2, 0);
		Object cover2 = createCover(2, 1);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		setObjectHP(cover1, hp1);
		setObjectHP(cover2, hp2);

		// out of range (2,0) (2,1) (4,2)
		addObjectToBoardGame(game, cover1, 2, 0);

		addObjectToBoardGame(game, cover2, 2, 1);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			assertEquals("Casting damaging ability should not be applied on covers out of range, current HP", hp1,
					returnHp(cover1));
			assertEquals("Casting damaging ability should not be applied on covers out of range, current HP", hp2,
					returnHp(cover2));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityCoversSurround3() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createDmgAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 4);
		setLocationForObject(champ, 4, 4);

		Object cover1 = createCover(4, 3);
		Object cover2 = createCover(3, 4);
		Object cover3 = createCover(3, 3);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		int hp3 = (int) (Math.random() * 30) + 40;
		setObjectHP(cover1, hp1);
		setObjectHP(cover2, hp2);
		setObjectHP(cover3, hp3);

		// within (4,3) (3,4) (3,3)
		addObjectToBoardGame(game, cover1, 4, 3);

		addObjectToBoardGame(game, cover2, 3, 4);

		addObjectToBoardGame(game, cover3, 3, 3);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			int expected = ((hp1 - randAmout) < 0) ? 0 : (hp1 - randAmout);
			assertEquals("Casting damaging ability should be applied on covers within range, current HP", expected,
					returnHp(cover1));

			expected = ((hp2 - randAmout) < 0) ? 0 : (hp2 - randAmout);
			assertEquals("Casting damaging ability should be applied on covers within range, current HP", expected,
					returnHp(cover2));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	// CC Buff
	@Test(timeout = 3000)
	public void testCastCCAbilitySurround1() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createPowerUpEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, false, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 0);
		setLocationForObject(champ, 0, 0);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// within (1,0), (0,1) (1,1)
		addObjectToBoardGame(game, champ2, 0, 1);
		setLocationForObject(champ2, 0, 1);

		addObjectToBoardGame(game, champ3, 1, 1);
		setLocationForObject(champ3, 1, 1);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertFalse(
					"Casting power up CC ability with area of effect Surround should not be applied on the current champ",
					containsEffect(champ, effect, false));

			assertTrue(
					"Casting power up CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ2, effect, true));
			assertTrue(
					"Casting power up CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ3, effect, true));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCAbilitySurroundOutOfRange1() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createPowerUpEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, false, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 0);
		setLocationForObject(champ, 0, 0);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// out of range (1,2) (2,1)
		addObjectToBoardGame(game, champ2, 1, 2);
		setLocationForObject(champ2, 1, 2);

		addObjectToBoardGame(game, champ3, 2, 1);
		setLocationForObject(champ3, 2, 1);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			assertFalse(
					"Casting power up CC ability with area of effect Surround should not be applied on targets out of range",
					containsEffect(champ2, effect, false));
			assertFalse(
					"Casting power up CC ability with area of effect Surround should not be applied on targets out of range",
					containsEffect(champ3, effect, false));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCAbilitySurround2() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createPowerUpEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 0);
		setLocationForObject(champ, 4, 0);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// within (3,0) (4,1) (3,1)

		addObjectToBoardGame(game, champ2, 4, 1);
		setLocationForObject(champ2, 4, 1);

		addObjectToBoardGame(game, champ3, 3, 1);
		setLocationForObject(champ3, 3, 1);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertTrue(
					"Casting power up CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ2, effect, true));
			assertTrue(
					"Casting power up CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ3, effect, true));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCAbilitySurroundOutOfRange2() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createPowerUpEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 0);
		setLocationForObject(champ, 0, 0);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// out of range (2,0) (2,1) (4,2)
		addObjectToBoardGame(game, champ2, 2, 0);
		setLocationForObject(champ2, 2, 0);

		addObjectToBoardGame(game, champ3, 2, 1);
		setLocationForObject(champ3, 2, 1);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			assertFalse(
					"Casting power up CC ability with area of effect Surround should not be applied on targets out of range",
					containsEffect(champ2, effect, false));
			assertFalse(
					"Casting power up CC ability with area of effect Surround should not be applied on targets out of range",
					containsEffect(champ3, effect, false));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCAbilitySurround6() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createSpeedUpEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, false, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 1, 3);
		setLocationForObject(champ, 1, 3);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// within (1,2) (1,4)
		addObjectToBoardGame(game, champ2, 1, 2);
		setLocationForObject(champ2, 1, 2);

		addObjectToBoardGame(game, champ3, 1, 4);
		setLocationForObject(champ3, 1, 4);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertTrue(
					"Casting speed up CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ2, effect, true));
			assertTrue(
					"Casting speed up CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ3, effect, true));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCAbilitySurround7() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createPowerUpEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 1, 3);
		setLocationForObject(champ, 1, 3);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// within (0,2) (0,3) (0,4)
		addObjectToBoardGame(game, champ2, 0, 2);
		setLocationForObject(champ2, 0, 2);

		addObjectToBoardGame(game, champ3, 0, 4);
		setLocationForObject(champ3, 0, 4);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			assertTrue(
					"Casting speed up CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ2, effect, true));
			assertTrue(
					"Casting speed up CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ3, effect, true));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCAbilitySurroundOutOfRange5() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createPowerUpEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, false, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 1, 3);
		setLocationForObject(champ, 1, 3);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		addObjectToBoardGame(game, champ2, 0, 1);
		setLocationForObject(champ2, 0, 1);

		addObjectToBoardGame(game, champ3, 1, 1);
		setLocationForObject(champ3, 1, 1);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertFalse(
					"Casting power up CC ability with area of effect Surround should not be applied on targets out of range",
					containsEffect(champ2, effect, false));
			assertFalse(
					"Casting power up CC ability with area of effect Surround should not be applied on targets out of range",
					containsEffect(champ3, effect, false));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	public void testCastCCAbilityOpponentTeamSurround1() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createPowerUpEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 0);
		setLocationForObject(champ, 0, 0);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// within (1,0), (0,1) (1,1)
		addObjectToBoardGame(game, champ1, 1, 0);
		setLocationForObject(champ1, 1, 0);
		addObjectToBoardGame(game, champ2, 0, 1);
		setLocationForObject(champ2, 0, 1);

		addObjectToBoardGame(game, champ3, 1, 1);
		setLocationForObject(champ3, 1, 1);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertFalse(
					"Casting power up CC ability with area of effect Surround should not be applied on the opponent's team within range",
					containsEffect(champ1, effect, false));
			assertFalse(
					"Casting power up CC ability with area of effect Surround should not be applied on the opponent's team within range",
					containsEffect(champ2, effect, false));
			assertFalse(
					"Casting power up CC ability with area of effect Surround should not be applied on the opponent's team within range",
					containsEffect(champ3, effect, false));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCAbilityOpponentTeamSurround2() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createPowerUpEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 0);
		setLocationForObject(champ, 4, 0);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// within (3,0) (4,1) (3,1)
		addObjectToBoardGame(game, champ1, 3, 0);
		setLocationForObject(champ1, 3, 0);

		addObjectToBoardGame(game, champ2, 4, 1);
		setLocationForObject(champ2, 4, 1);

		addObjectToBoardGame(game, champ3, 3, 1);
		setLocationForObject(champ3, 3, 1);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertFalse(
					"Casting power up CC ability with area of effect Surround should not be applied on the opponent's team within range",
					containsEffect(champ1, effect, false));
			assertFalse(
					"Casting power up CC ability with area of effect Surround should not be applied on the opponent's team within range",
					containsEffect(champ2, effect, false));
			assertFalse(
					"Casting power up CC ability with area of effect Surround should not be applied on the opponent's team within range",
					containsEffect(champ3, effect, false));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCAbilityCoversSurround3() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createPowerUpEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 4);
		setLocationForObject(champ, 4, 4);

		Object cover1 = createCover(4, 3);
		int hp1 = returnHp(cover1);

		Object cover2 = createCover(3, 4);
		int hp2 = returnHp(cover2);

		Object cover3 = createCover(3, 3);
		int hp3 = returnHp(cover3);

		// within (4,3) (3,4) (3,3)
		addObjectToBoardGame(game, cover1, 4, 3);

		addObjectToBoardGame(game, cover2, 3, 4);

		addObjectToBoardGame(game, cover3, 3, 3);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertTrue(
					"Casting power up CC ability with area of effect Surround should not be applied on covers within range",
					hp1 == returnHp(cover1));
			assertTrue(
					"Casting power up CC ability with area of effect Surround should not be applied on covers within range",
					hp2 == returnHp(cover2));
			assertTrue(
					"Casting power up CC ability with area of effect Surround should not be applied on covers within range",
					hp3 == returnHp(cover3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	// CC DeBuff
	@Test(timeout = 3000)
	public void testCastCCDEBUFFAbilitySurround1() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createDisarmEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 0);
		setLocationForObject(champ, 0, 0);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// within (1,0), (0,1) (1,1)
		addObjectToBoardGame(game, champ1, 1, 0);
		setLocationForObject(champ1, 1, 0);
		addObjectToBoardGame(game, champ2, 0, 1);
		setLocationForObject(champ2, 0, 1);

		addObjectToBoardGame(game, champ3, 1, 1);
		setLocationForObject(champ3, 1, 1);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertTrue(
					"Casting Disarm CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ1, effect, true));
			assertTrue(
					"Casting Disarm CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ2, effect, true));
			assertTrue(
					"Casting Disarm CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ3, effect, true));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCDEBUFFAbilitySurround2() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createDisarmEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 0);
		setLocationForObject(champ, 4, 0);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// within (3,0) (4,1) (3,1)
		addObjectToBoardGame(game, champ1, 3, 0);
		setLocationForObject(champ1, 3, 0);

		addObjectToBoardGame(game, champ2, 4, 1);
		setLocationForObject(champ2, 4, 1);

		addObjectToBoardGame(game, champ3, 3, 1);
		setLocationForObject(champ3, 3, 1);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertTrue(
					"Casting Disarm CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ1, effect, true));
			assertTrue(
					"Casting Disarm CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ2, effect, true));
			assertTrue(
					"Casting Disarm CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ3, effect, true));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCDEBUFFAbilitySurroundOutOfRange2() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createDisarmEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 0);
		setLocationForObject(champ, 0, 0);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// out of range (2,0) (2,1) (4,2)
		addObjectToBoardGame(game, champ2, 2, 0);
		setLocationForObject(champ2, 2, 0);

		addObjectToBoardGame(game, champ3, 2, 1);
		setLocationForObject(champ3, 2, 1);

		addObjectToBoardGame(game, champ1, 4, 2);
		setLocationForObject(champ1, 4, 2);

		addChampToTurnOrder(game, champ);
		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertFalse(
					"Casting Disarm CC ability with area of effect Surround should not be applied on targets out of range",
					containsEffect(champ1, effect, false));
			assertFalse(
					"Casting Disarm CC ability with area of effect Surround should not be applied on targets out of range",
					containsEffect(champ2, effect, false));
			assertFalse(
					"Casting Disarm CC ability with area of effect Surround should not be applied on targets out of range",
					containsEffect(champ3, effect, false));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCDEBUFFAbilitySurround3() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createDisarmEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, false, champ);
		createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 4);
		setLocationForObject(champ, 4, 4);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// within (4,3) (3,4) (3,3)
		addObjectToBoardGame(game, champ1, 4, 3);
		setLocationForObject(champ1, 4, 3);

		addObjectToBoardGame(game, champ2, 3, 4);
		setLocationForObject(champ2, 3, 4);

		addObjectToBoardGame(game, champ3, 3, 3);
		setLocationForObject(champ3, 3, 3);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertTrue(
					"Casting Disarm CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ1, effect, true));
			assertTrue(
					"Casting Disarm CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ2, effect, true));
			assertTrue(
					"Casting Disarm CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ3, effect, true));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCDEBUFFAbilitySurroundOutOfRange3() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createDisarmEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 4, 4);
		setLocationForObject(champ, 4, 4);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// out of range (2,3) (2,4)
		addObjectToBoardGame(game, champ2, 2, 3);
		setLocationForObject(champ2, 2, 3);

		addObjectToBoardGame(game, champ3, 2, 4);
		setLocationForObject(champ3, 2, 4);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertFalse(
					"Casting Disarm CC ability with area of effect Surround should not be applied on targets out of range",
					containsEffect(champ2, effect, false));
			assertFalse(
					"Casting Disarm CC ability with area of effect Surround should not be applied on targets out of range",
					containsEffect(champ3, effect, false));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCDEBUFFAbilitySurround4() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createDisarmEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, false, champ);
		createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 4);
		setLocationForObject(champ, 0, 4);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// within (0,3) (1,4) (1,3)
		addObjectToBoardGame(game, champ1, 0, 3);
		setLocationForObject(champ1, 0, 3);

		addObjectToBoardGame(game, champ2, 1, 4);
		setLocationForObject(champ2, 1, 4);

		addObjectToBoardGame(game, champ3, 1, 3);
		setLocationForObject(champ3, 1, 3);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			assertTrue(
					"Casting Disarm CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ1, effect, true));
			assertTrue(
					"Casting Disarm CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ2, effect, true));
			assertTrue(
					"Casting Disarm CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ3, effect, true));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCDEBUFFAbilitySurroundOutOfRange4() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createDisarmEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 4);
		setLocationForObject(champ, 0, 4);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// out of range (0,0) (0,1) (0,2) (1,0) (1,1) (1,2) (2,4)
		addObjectToBoardGame(game, champ2, 0, 2);
		setLocationForObject(champ2, 0, 2);

		addObjectToBoardGame(game, champ3, 1, 2);
		setLocationForObject(champ3, 1, 2);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertFalse(
					"Casting Disarm CC ability with area of effect Surround should not be applied on targets out of range",
					containsEffect(champ2, effect, false));
			assertFalse(
					"Casting Disarm CC ability with area of effect Surround should not be applied on targets out of range",
					containsEffect(champ3, effect, false));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCDEBUFFAbilitySurround5() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createDisarmEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 1, 3);
		setLocationForObject(champ, 1, 3);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// within (2,2) (2,3) (2,4)
		addObjectToBoardGame(game, champ1, 2, 2);
		setLocationForObject(champ1, 2, 2);

		addObjectToBoardGame(game, champ2, 2, 3);
		setLocationForObject(champ2, 2, 3);

		addObjectToBoardGame(game, champ3, 2, 4);
		setLocationForObject(champ3, 2, 4);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertTrue(
					"Casting Disarm CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ1, effect, true));
			assertTrue(
					"Casting Disarm CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ2, effect, true));
			assertTrue(
					"Casting Disarm CC ability with area of effect Surround is not applied correctly on targets within range",
					containsEffect(champ3, effect, true));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCDEBUFFAbilitySurroundOutOfRange5() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createDisarmEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 1, 3);
		setLocationForObject(champ, 1, 3);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// out of range (0,0) (0,1) (1,1)
		addObjectToBoardGame(game, champ2, 0, 1);
		setLocationForObject(champ2, 0, 1);

		addObjectToBoardGame(game, champ3, 1, 1);
		setLocationForObject(champ3, 1, 1);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertFalse(
					"Casting Disarm CC ability with area of effect Surround should not be applied on targets out of range",
					containsEffect(champ2, effect, false));
			assertFalse(
					"Casting Disarm CC ability with area of effect Surround should not be applied on targets out of range",
					containsEffect(champ3, effect, false));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	public void testCastCCDEBUFFAbilitySameTeamSurround1() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createDisarmEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, true, champ);
		createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 0, 0);
		setLocationForObject(champ, 0, 0);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// within (1,0), (0,1) (1,1)
		addObjectToBoardGame(game, champ2, 0, 1);
		setLocationForObject(champ2, 0, 1);

		addObjectToBoardGame(game, champ3, 1, 1);
		setLocationForObject(champ3, 1, 1);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			assertFalse(
					"Casting Disarm CC ability with area of effect Surround should not be applied on the current champion",
					containsEffect(champ, effect, false));

			assertFalse(
					"Casting Disarm CC ability with area of effect Surround should not be applied on the champion's team within range",
					containsEffect(champ2, effect, false));
			assertFalse(
					"Casting Disarm CC ability with area of effect Surround should not be applied on the champion's team within range",
					containsEffect(champ3, effect, false));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting an ability with area of effect SURROUND");

		}
	}

	// test targets removed when dead after Damaging ability
	@Test(timeout = 3000)
	public void testCastDmgAbilitySingleTargetRemovingDeadTarget() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randY = (int) Math.floor(Math.random() * (4 - 3 + 1) + 3);
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randomRange = 3;
		int randAmount = 20;

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");

		createSecondPlayerTeam(secPlayer, true, champ);
		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, false, champ);

		Object game = createGame(firstPlayer, secPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		addChampToTurnOrder(game, champ);
		Object ability = createDmgAbility("", 10, 2, randomRange, "SINGLETARGET", 1, randAmount);
		addAbilityToChampion(champ, ability);

		int randHP = 10;
		Object champTarget = team.get(1);
		setObjectHP(team.get(1), randHP);
		addObjectToBoardGame(game, team.get(1), randX, randY - 1);
		setLocationForObject(team.get(1), randX, randY - 1);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, randX, randY - 1);

			boolean removedFromBoard = returnGameBoard(game)[randX][randY - 1] == null;
			assertTrue(
					"After casting a damaging ability on a single target, if the target is dead it should be removed from the board",
					removedFromBoard);
			boolean removedFromTeam = !team.contains(champTarget);
			assertTrue(
					"After casting a damaging ability on a single target, if the target is dead it should be removed from team",
					removedFromTeam);

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");

		}

	}

	@Test(timeout = 3000)
	public void testCastDmgAbilityTeamTargetTargetRemovingDeadTarget() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randY = (int) Math.floor(Math.random() * (4 - 3 + 1) + 3);
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randomRange = 2;
		int randAmount = 20;

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");

		createSecondPlayerTeam(secPlayer, true, champ);
		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, false, champ);

		Object game = createGame(firstPlayer, secPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		addChampToTurnOrder(game, champ);
		Object ability = createDmgAbility("", 10, 2, randomRange, "TEAMTARGET", 1, randAmount);
		addAbilityToChampion(champ, ability);

		int randHP = 10;
		Object champTarget = team.get(1);
		setObjectHP(team.get(1), randHP);
		addObjectToBoardGame(game, team.get(1), randX, randY - 1);
		setLocationForObject(team.get(1), randX, randY - 1);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			boolean removedFromBoard = returnGameBoard(game)[randX][randY - 1] == null;
			assertTrue(
					"After casting a damaging ability on team target, if the target is dead it should be removed from the board",
					removedFromBoard);
			boolean removedFromTeam = !team.contains(champTarget);
			assertTrue(
					"After casting a damaging ability on team target, if the target is dead it should be removed from team",
					removedFromTeam);

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability on team target");

		}

	}

	@Test(timeout = 3000)
	public void testCastDmgAbilitySurroundRemovingDeadTarget() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randY = (int) Math.floor(Math.random() * (4 - 3 + 1) + 3);
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randAmount = 20;

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");

		createSecondPlayerTeam(secPlayer, true, champ);
		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, false, champ);

		Object game = createGame(firstPlayer, secPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		addChampToTurnOrder(game, champ);
		Object ability = createDmgAbility("", 10, 2, 1, "SURROUND", 1, randAmount);
		addAbilityToChampion(champ, ability);

		int randHP = 10;
		Object champTarget = team.get(1);
		setObjectHP(team.get(1), randHP);
		addObjectToBoardGame(game, team.get(1), randX, randY - 1);
		setLocationForObject(team.get(1), randX, randY - 1);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			boolean removedFromBoard = returnGameBoard(game)[randX][randY - 1] == null;
			assertTrue(
					"After casting a damaging ability surround, if the target is dead it should be removed from the board",
					removedFromBoard);
			boolean removedFromTeam = !team.contains(champTarget);
			assertTrue(
					"After casting a damaging ability surround, if the target is dead it should be removed from team",
					removedFromTeam);

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability on surround targets");

		}

	}

	@Test(timeout = 3000)
	public void testCastDmgAbilityUPRemovingDeadTarget() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();
		int randomRange = 2;
		int max = 1;
		int min = 0;
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);

		int randAmout = 20;
		Object ability = createDmgAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, randAmout);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);
		createFirstPlayerTeam(firstPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		addChampToTurnOrder(game, champ);
		addAbilityToChampion(champ, ability);

		int randHP = 10;
		Object champTarget = team.get(1);
		setObjectHP(team.get(1), randHP);
		addObjectToBoardGame(game, team.get(1), randX + randomRange, randY);
		setLocationForObject(team.get(1), randX + randomRange, randY);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnUpDirection());

			boolean removedFromBoard = returnGameBoard(game)[randX + randomRange][randY] == null;
			assertTrue("After casting a damaging ability UP, if the target is dead it should be removed from the board",
					removedFromBoard);
			boolean removedFromTeam = !team.contains(champTarget);
			assertTrue("After casting a damaging ability UP, if the target is dead it should be removed from team",
					removedFromTeam);

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability on directional target");

		}

	}

	@Test(timeout = 3000)
	public void testCastDmgAbilityDownRemovingDeadTarget() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();
		int randomRange = 2;
		int max = 4;
		int min = 3;
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);

		int randAmout = 20;
		Object ability = createDmgAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, randAmout);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> team = createSecondPlayerTeam(secondPlayer, false, champ);
		createFirstPlayerTeam(firstPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		addChampToTurnOrder(game, champ);
		addAbilityToChampion(champ, ability);

		int randHP = 10;
		Object champTarget = team.get(1);
		setObjectHP(team.get(1), randHP);
		addObjectToBoardGame(game, team.get(1), randX - randomRange, randY);
		setLocationForObject(team.get(1), randX - randomRange, randY);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnDownDirection());

			boolean removedFromBoard = returnGameBoard(game)[randX - randomRange][randY] == null;
			assertTrue(
					"After casting a damaging ability Down, if the target is dead it should be removed from the board",
					removedFromBoard);
			boolean removedFromTeam = !team.contains(champTarget);
			assertTrue("After casting a damaging ability Down, if the target is dead it should be removed from team",
					removedFromTeam);

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability on directional target");

		}

	}

	@Test(timeout = 3000)
	public void testChampionClassImplementsDamageable() throws Exception {
		@SuppressWarnings("rawtypes")
		Class[] interfaces = Class.forName(championPath).getInterfaces();
		boolean found = false;
		for (@SuppressWarnings("rawtypes")
		Class class1 : interfaces) {
			if (class1.equals(Class.forName(damageablePath))) {
				found = true;
			}
		}
		assertTrue("Champion class should implement the interface Damageable", found);

	}

	@Test(timeout = 3000)
	public void testChampionUseLeaderAbilityIsAbstract() throws Exception {
		@SuppressWarnings("rawtypes")
		Class[] args = new Class[1];
		args[0] = ArrayList.class;
		Method harvest = Class.forName(championPath).getDeclaredMethod("useLeaderAbility", args);
		assertTrue("useLeaderAbility method should be abstract in the class Champion",
				Modifier.toString(harvest.getModifiers()).contains("abstract"));
	}

	@Test(timeout = 3000)
	public void testHeroUseLeaderAbility() throws Exception {
		@SuppressWarnings("rawtypes")
		Class[] args = new Class[1];
		args[0] = ArrayList.class;
		testExistsInClass(Class.forName(heroPath), "useLeaderAbility", true, void.class, args);
	}

	@Test(timeout = 3000)
	public void testAntiHeroUseLeaderAbility() throws Exception {
		@SuppressWarnings("rawtypes")
		Class[] args = new Class[1];
		args[0] = ArrayList.class;
		testExistsInClass(Class.forName(antiHeroPath), "useLeaderAbility", true, void.class, args);
	}

	@Test(timeout = 3000)
	public void testVillainUseLeaderAbility() throws Exception {
		@SuppressWarnings("rawtypes")
		Class[] args = new Class[1];
		args[0] = ArrayList.class;
		testExistsInClass(Class.forName(villainPath), "useLeaderAbility", true, void.class, args);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testChampionCompareTo() throws Exception {
		Class c = Class.forName(heroPath);
		Class[] args = new Class[7];
		args[0] = String.class;
		args[1] = int.class;
		args[2] = int.class;
		args[3] = int.class;
		args[4] = int.class;
		args[5] = int.class;
		args[6] = int.class;
		Object h = c.getConstructor(args)
				.newInstance(new Object[] { (String) "hero2", (int) 1, (int) 2, (int) 3, (int) 4, // speed
						(int) 5, (int) 6 });

		Object h2 = c.getConstructor(args)
				.newInstance(new Object[] { (String) "hero1", (int) 1, (int) 2, (int) 3, (int) 14, // speed
						(int) 15, (int) 6 });
		Method compareTo = h.getClass().getMethod("compareTo", Object.class);
		int r = (int) compareTo.invoke(h, h2);
		assertTrue(
				"Champion compareTo Method should return a positive number when current hero is faster than specified hero",
				isPositive(r));

		Method setSpeed = h.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(h, 14);
		setSpeed.invoke(h2, 4);
		r = (int) compareTo.invoke(h, h2);
		assertFalse(
				"Champion compareTo Method should return a negative number when specified hero is faster than current hero",
				isPositive(r));

		setSpeed.invoke(h, 4);
		r = (int) compareTo.invoke(h, h2);
		assertTrue(
				"Champion compareTo Method should compare lexiographically by name if both champions have the same speed",
				isPositive(r));

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })

	@Test(timeout = 3000)
	public void testHeroUseLeaderMethod() throws Exception {
		Class c = Class.forName(heroPath);
		Class[] args = new Class[] { String.class, int.class, int.class, int.class, int.class, int.class, int.class };
		Object h = c.getConstructor(args).newInstance(
				new Object[] { (String) "hero2", (int) 1000, (int) 2, (int) 3, (int) 4, (int) 5, (int) 6 });

		Class c7 = Class.forName(heroPath);
		Class[] h1args = new Class[] { String.class, int.class, int.class, int.class, int.class, int.class, int.class };
		Object h2 = c7.getConstructor(h1args).newInstance(
				new Object[] { (String) "hero1", (int) 1000, (int) 2, (int) 3, (int) 4, (int) 5, (int) 6 });

		Class c8 = Class.forName(villainPath);
		Class[] vargs = new Class[] { String.class, int.class, int.class, int.class, int.class, int.class, int.class };
		Object v = c8.getConstructor(vargs).newInstance(
				new Object[] { (String) "Villain", (int) 1000, (int) 2, (int) 3, (int) 4, (int) 5, (int) 6 });

		Class c9 = Class.forName(antiHeroPath);
		Class[] ahargs = new Class[] { String.class, int.class, int.class, int.class, int.class, int.class, int.class };
		Object ah = c9.getConstructor(ahargs).newInstance(
				new Object[] { (String) "AntiHero", (int) 1000, (int) 2, (int) 3, (int) 4, (int) 5, (int) 6 });
		Class c2 = Class.forName(stunPath);
		Class[] efargs = new Class[] { int.class };
		Object e1 = c2.getConstructor(efargs).newInstance(new Object[] { (int) 3 });

		Class c3 = Class.forName(disarmPath);
		Class[] e2fargs = new Class[] { int.class };
		Object e2 = c3.getConstructor(e2fargs).newInstance(new Object[] { (int) 3 });

		Class c4 = Class.forName(rootPath);
		Class[] e3fargs = new Class[] { int.class };
		Object e3 = c4.getConstructor(e3fargs).newInstance(new Object[] { (int) 3 });

		Class c5 = Class.forName(shockPath);
		Class[] e4fargs = new Class[] { int.class };
		Object e4 = c5.getConstructor(e4fargs).newInstance(new Object[] { (int) 3 });

		Class c6 = Class.forName(silencePath);
		Class[] e5fargs = new Class[] { int.class };
		Object e5 = c6.getConstructor(e5fargs).newInstance(new Object[] { (int) 3 });

		Class c10 = Class.forName(powerUpPath);
		Class[] e6fargs = new Class[] { int.class };
		Object e6 = c10.getConstructor(e6fargs).newInstance(new Object[] { (int) 3 });

		Method getAppliedEffectsh2 = h2.getClass().getMethod("getAppliedEffects");
		ArrayList<Object> appliedEffectsh2 = (ArrayList<Object>) getAppliedEffectsh2.invoke(h2);

		appliedEffectsh2.add(e1);
		Method getAppliedEffectsah = ah.getClass().getMethod("getAppliedEffects");
		ArrayList<Object> appliedEffectsah = (ArrayList<Object>) getAppliedEffectsah.invoke(ah);
		appliedEffectsah.add(e2);
		appliedEffectsah.add(e1);

		Method getAppliedEffectsv = v.getClass().getMethod("getAppliedEffects");
		ArrayList<Object> appliedEffectsv = (ArrayList<Object>) getAppliedEffectsv.invoke(v);

		appliedEffectsv.add(e3);
		appliedEffectsv.add(e4);
		appliedEffectsv.add(e6);

		appliedEffectsh2.add(e5);
		appliedEffectsh2.add(e6);

		ArrayList<Object> chms = new ArrayList<Object>();
		chms.add(h2);
		chms.add(v);
		chms.add(ah);
		Method setHp = h.getClass().getMethod("setCurrentHP", int.class);
		setHp.invoke(ah, 300);
		setHp.invoke(v, 300);
		setHp.invoke(h2, 300);

		ArrayList<ArrayList> appliedEffectsBef = new ArrayList<ArrayList>();
		Method useLeaderAbility = h.getClass().getMethod("useLeaderAbility", ArrayList.class);
		for (Object champion : chms) {
			appliedEffectsBef.add(((ArrayList<Object>) getAppliedEffectsah.invoke(champion)));
		}
		useLeaderAbility.invoke(h, chms);

		boolean embrace = true;
		boolean negDebuff = false;
		boolean found = false;
		int i = 0;
		for (Object champion : chms) {
			Method getName = appliedEffectsBef.get(i).get(0).getClass().getMethod("getName");

			boolean foundembrace = false;
			appliedEffectsv = (ArrayList<Object>) getAppliedEffectsah.invoke(champion);

			for (Object eff : appliedEffectsv) {

				Method getType = eff.getClass().getMethod("getType");
				if (getType.invoke(eff) == Enum.valueOf((Class<Enum>) Class.forName(effectTypePath), "DEBUFF")) {
					negDebuff = true;
				}
				if (getName.invoke(eff).equals("PowerUp")) {

					found = true;
				}
				if (getName.invoke(eff).equals("Embrace")) {

					foundembrace = true;
					Method getDuration = eff.getClass().getMethod("getDuration");

					assertEquals("Embrace effect added by useLeaderAbility should last for 2 turns", 2,
							getDuration.invoke(eff));
					Class curr = Class.forName(championPath);
					Field f = curr.getDeclaredField("currentHP");
					f.setAccessible(true);

					assertEquals("The method useLeaderAbility should apply the effect Embrace" + "\".", 500,
							f.get(champion));
				}
			}
			if (!foundembrace) {
				embrace = false;
			}
			i++;

		}
		assertTrue("Hero useLeaderAbility method should not remove effects of type buff from the target champions",
				found);

		assertTrue("Hero useLeaderAbility method should add the effect Embrace to all targets", embrace);
		assertFalse("Hero useLeaderAbility method should remove all debuffs from the target champions", negDebuff);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testVillainUseLeaderAbilityMethod() throws Exception {
		Class c = Class.forName(heroPath);
		Class[] args = new Class[] { String.class, int.class, int.class, int.class, int.class, int.class, int.class };
		Object h = c.getConstructor(args).newInstance(
				new Object[] { (String) "hero2", (int) 1000, (int) 2, (int) 3, (int) 4, (int) 5, (int) 6 });
		Method setHp = h.getClass().getMethod("setCurrentHP", int.class);
		setHp.invoke(h, 299);

		Class c7 = Class.forName(heroPath);
		Class[] h1args = new Class[] { String.class, int.class, int.class, int.class, int.class, int.class, int.class };
		Object h2 = c7.getConstructor(h1args)
				.newInstance(new Object[] { (String) "hero1", (int) 2000, (int) 2, (int) 3, (int) 4, (int) 5,

						(int) 6 });
		setHp.invoke(h2, 1000);
		Class c8 = Class.forName(villainPath);
		Class[] vargs = new Class[] { String.class, int.class, int.class, int.class, int.class, int.class, int.class };
		Object v = c8.getConstructor(vargs)
				.newInstance(new Object[] { (String) "Villain", (int) 1, (int) 2, (int) 3, (int) 4, (int) 5, (int) 6 });

		Class c9 = Class.forName(antiHeroPath);
		Class[] ahargs = new Class[] { String.class, int.class, int.class, int.class, int.class, int.class, int.class };
		Object ah = c9.getConstructor(ahargs).newInstance(
				new Object[] { (String) "AntiHero", (int) 10000, (int) 2, (int) 3, (int) 4, (int) 5, (int) 6 });
		setHp.invoke(ah, 1000);

		ArrayList<Object> chms = new ArrayList<Object>();
		chms.add(h2);
		chms.add(h);
		chms.add(ah);

		Method useLeaderAbility = v.getClass().getMethod("useLeaderAbility", ArrayList.class);

		useLeaderAbility.invoke(v, chms);

		for (Object champion : chms) {

			Method getCuMethod = champion.getClass().getMethod("getCurrentHP");
			Method getMaxHP = champion.getClass().getMethod("getMaxHP");
			Method getCond = champion.getClass().getMethod("getCondition");

			if (((int) getCuMethod.invoke(champion) / (int) getMaxHP.invoke(champion)) < 0.3) {
				assertTrue(
						"Villain useLeaderAbility method should set the current condition of the targets to KNOCKEDOUT",
						getCond.invoke(champion) == Enum.valueOf((Class<Enum>) Class.forName(conditionPath),
								"KNOCKEDOUT"));
			} else {
				assertFalse(
						"Villain useLeaderAbility method should NOT set the current condition of the targets to KNOCKEDOUT",
						getCond.invoke(champion) == Enum.valueOf((Class<Enum>) Class.forName(conditionPath),
								"KNOCKEDOUT"));

			}

		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })

	@Test(timeout = 3000)
	public void testAntiHeroUseLeaderAbilityMethod() throws Exception {
		Class c = Class.forName(heroPath);
		Class[] args = new Class[] { String.class, int.class, int.class, int.class, int.class, int.class, int.class };
		Object h = c.getConstructor(args)
				.newInstance(new Object[] { (String) "hero2", (int) 1, (int) 2, (int) 3, (int) 4, (int) 5, (int) 6 });

		Class c7 = Class.forName(heroPath);
		Class[] h1args = new Class[] { String.class, int.class, int.class, int.class, int.class, int.class, int.class };
		Object h2 = c7.getConstructor(h1args)
				.newInstance(new Object[] { (String) "hero1", (int) 1, (int) 2, (int) 3, (int) 4, (int) 5, (int) 6 });

		Class c8 = Class.forName(villainPath);
		Class[] vargs = new Class[] { String.class, int.class, int.class, int.class, int.class, int.class, int.class };
		Object v = c8.getConstructor(vargs)
				.newInstance(new Object[] { (String) "Villain", (int) 1, (int) 2, (int) 3, (int) 4, (int) 5, (int) 6 });

		Class c9 = Class.forName(antiHeroPath);
		Class[] ahargs = new Class[] { String.class, int.class, int.class, int.class, int.class, int.class, int.class };
		Object ah = c9.getConstructor(ahargs).newInstance(
				new Object[] { (String) "AntiHero", (int) 1, (int) 2, (int) 3, (int) 4, (int) 5, (int) 6 });

		ArrayList<Object> chms = new ArrayList<Object>();
		chms.add(h2);
		chms.add(h);
		chms.add(v);
		Class curr = Class.forName(championPath);

		Field f = curr.getDeclaredField("condition");
		f.setAccessible(true);
		f.set(h2, Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ROOTED"));
		f.set(h, Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ROOTED"));
		f.set(v, Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ROOTED"));

		Method useLeaderAbility = ah.getClass().getMethod("useLeaderAbility", ArrayList.class);
		ArrayList<Integer> appliedEffectsBef = new ArrayList<Integer>();
		boolean stun = true;
		Method getAppliedEffectsah = ah.getClass().getMethod("getAppliedEffects");
		for (Object champion : chms) {
			appliedEffectsBef.add(((ArrayList<Object>) getAppliedEffectsah.invoke(champion)).size());
		}
		useLeaderAbility.invoke(ah, chms);

		int i = 0;
		for (Object champion : chms) {
			boolean foundStun = false;
			ArrayList<Object> appliedEffectsv = (ArrayList<Object>) getAppliedEffectsah.invoke(champion);
			if (appliedEffectsBef.get(i) + 1 > appliedEffectsv.size()) {
				fail("AntiHero useLeaderAbility should add one effect");
			}
			for (Object eff : (ArrayList<Object>) getAppliedEffectsah.invoke(champion)) {
				Method getName = eff.getClass().getMethod("getName");
				if (getName.invoke(eff).equals("Stun")) {

					foundStun = true;
					Method getDuration = eff.getClass().getMethod("getDuration");

					assertEquals("stun effect added by useLeaderAbility should Last for 2 turns", 2,
							getDuration.invoke(eff));

					f = curr.getDeclaredField("condition");
					f.setAccessible(true);
					assertEquals("The method useLeaderAbility in class AntiHero should Apply the stun" + "\".",
							Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE"), f.get(champion));

				}
			}
			if (!foundStun) {
				stun = false;
			}
			i++;
		}

		assertTrue("AntiHero useLeaderAbility method should add the effect Stun to all targets", stun);

	}

	@SuppressWarnings({ "rawtypes" })

	@Test(timeout = 3000)
	public void testNotleaderException() throws Exception {

		ArrayList<Object> gameObjects = createGameAndTeams();
		Object game = gameObjects.get(0);
		Method getFirstPlayer = game.getClass().getMethod("getFirstPlayer");
		Method getSecondPlayer = game.getClass().getMethod("getSecondPlayer");
		Object fp = getFirstPlayer.invoke(game);
		Object sp = getSecondPlayer.invoke(game);

		Method setLeader = fp.getClass().getMethod("setLeader", Class.forName(championPath));
		setLeader.invoke(fp, ((ArrayList) gameObjects.get(1)).get(0));
		setLeader.invoke(sp, ((ArrayList) gameObjects.get(2)).get(0));

		try {
			Method m = game.getClass().getMethod("useLeaderAbility");
			try {
				compareToCheck();
				m.invoke(game);
				fail("Trying use a leader ability on a champion that is not a leader, an exception should be thrown");
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				try {
					if (!(Class.forName(leaderNotCurrentExc).equals(e.getCause().getClass())))
						fail("Trying use a leader ability on a champion that is not a leader, an exception should be thrown");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				;

			}
		} catch (NoSuchMethodException e) {
			fail("Game class should have useLeaderAbilityMethod");
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes" })

	@Test(timeout = 3000)
	public void testLeaderAbilityUsedException() throws Exception {

		ArrayList<Object> gameObjects = createGameAndTeams();
		Object game = gameObjects.get(0);
		Method getFirstPlayer = game.getClass().getMethod("getFirstPlayer");
		Method getSecondPlayer = game.getClass().getMethod("getSecondPlayer");
		Object fp = getFirstPlayer.invoke(game);
		Object sp = getSecondPlayer.invoke(game);

		Method setLeader = fp.getClass().getMethod("setLeader", Class.forName(championPath));
		setLeader.invoke(fp, ((ArrayList) gameObjects.get(1)).get(0));
		setLeader.invoke(sp, ((ArrayList) gameObjects.get(2)).get(2));

		Field f = game.getClass().getDeclaredField("secondLeaderAbilityUsed");
		f.setAccessible(true);
		f.set(game, true);

		try {
			Method m = game.getClass().getMethod("useLeaderAbility");
			try {
				compareToCheck();
				m.invoke(game);
				fail("UseLeaderAbility method should throw an exception when Second leader has already use his ability");
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				try {
					if (!(Class.forName(leaderAbilityUsedExc).equals(e.getCause().getClass())))
						fail("UseLeaderAbility method should throw an exception when Second leader has already use his ability");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				;

			}
		} catch (NoSuchMethodException e) {
			fail("Game class should have useLeaderAbilityMethod");
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		gameObjects = createGameAndTeamsScenario2();
		game = gameObjects.get(0);
		fp = getFirstPlayer.invoke(game);
		sp = getSecondPlayer.invoke(game);

		setLeader.invoke(fp, ((ArrayList) gameObjects.get(1)).get(0));

		f.set(game, false);
		f = game.getClass().getDeclaredField("firstLeaderAbilityUsed");
		f.setAccessible(true);
		f.set(game, true);

		try {
			Method m = game.getClass().getMethod("useLeaderAbility");
			try {
				m.invoke(game);
				fail("UseLeaderAbility method should throw an exception when First leader has already use his ability");
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				try {
					if (!(Class.forName(leaderAbilityUsedExc).equals(e.getCause().getClass())))
						fail("UseLeaderAbility method should throw an exception when First leader has already use his ability");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				;

			}
		} catch (NoSuchMethodException e) {
			fail("Game class should have useLeaderAbilityMethod");
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes" })
	@Test(timeout = 3000)
	public void testUseLeaderAbilityboolean1() throws Exception {
		ArrayList<Object> gameObjects = createGameAndTeams();
		Object game = gameObjects.get(0);
		Method getFirstPlayer = game.getClass().getMethod("getFirstPlayer");
		Method getSecondPlayer = game.getClass().getMethod("getSecondPlayer");
		Object fp = getFirstPlayer.invoke(game);
		Object sp = getSecondPlayer.invoke(game);

		Method setLeader = fp.getClass().getMethod("setLeader", Class.forName(championPath));
		setLeader.invoke(fp, ((ArrayList) gameObjects.get(1)).get(0));
		setLeader.invoke(sp, ((ArrayList) gameObjects.get(2)).get(2));
		compareToCheck();

		Method m = game.getClass().getMethod("useLeaderAbility");
		m.invoke(game);
		Field f = game.getClass().getDeclaredField("secondLeaderAbilityUsed");
		f.setAccessible(true);
		assertTrue("You should set the secondLeaderAbility to true after using the leader ability",
				(boolean) f.get(game));

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testUseLeaderAbilityHeroTargets() throws Exception {
		compareToCheck();

		ArrayList<Object> gameObjects = createGameAndTeamsScenario2();
		Object game = gameObjects.get(0);
		Method getFirstPlayer = game.getClass().getMethod("getFirstPlayer");
		Method getSecondPlayer = game.getClass().getMethod("getSecondPlayer");
		Object fp = getFirstPlayer.invoke(game);
		Object sp = getSecondPlayer.invoke(game);

		Method setLeader = fp.getClass().getMethod("setLeader", Class.forName(championPath));
		setLeader.invoke(fp, ((ArrayList) gameObjects.get(1)).get(0));
		setLeader.invoke(sp, ((ArrayList) gameObjects.get(2)).get(2));

		ArrayList<Object> firstTeam = (ArrayList<Object>) gameObjects.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) gameObjects.get(2);
		Method useLead = game.getClass().getMethod("useLeaderAbility");
		useLead.invoke(game);

		boolean embrace = true;

		for (Object champion : firstTeam) {
			boolean foundembrace = false;
			Method getAppliedEffectsv = champion.getClass().getMethod("getAppliedEffects");

			ArrayList<Object> appliedEffectsv = (ArrayList<Object>) getAppliedEffectsv.invoke(champion);

			for (Object eff : appliedEffectsv) {

				Method getName = eff.getClass().getMethod("getName");

				if (getName.invoke(eff).equals("Embrace")) {

					foundembrace = true;
				}
			}
			if (!foundembrace) {
				embrace = false;
			}

		}

		assertTrue("Hero useLeaderAbility method should add the effect Embrace to all targets", embrace);

		boolean foundEmbraceOnWrongTarget = false;
		for (Object champion : secondTeam) {
			Method getAppliedEffectsv = champion.getClass().getMethod("getAppliedEffects");

			ArrayList<Object> appliedEffectsv = (ArrayList<Object>) getAppliedEffectsv.invoke(champion);

			for (Object eff : appliedEffectsv) {

				Method getName = eff.getClass().getMethod("getName");

				if (getName.invoke(eff).equals("Embrace")) {

					foundEmbraceOnWrongTarget = true;
				}
			}

			assertFalse("Hero useLeaderAbility method should add the effect Embrace to the correct targets",
					foundEmbraceOnWrongTarget);

		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testUseLeaderAbilityVillianTargets() throws Exception {

		ArrayList<Object> gameObjects = createGameAndTeamsScenario3();
		Object game = gameObjects.get(0);
		Method getFirstPlayer = game.getClass().getMethod("getFirstPlayer");
		Method getSecondPlayer = game.getClass().getMethod("getSecondPlayer");
		Object fp = getFirstPlayer.invoke(game);
		Object sp = getSecondPlayer.invoke(game);

		Method setLeader = fp.getClass().getMethod("setLeader", Class.forName(championPath));
		setLeader.invoke(fp, ((ArrayList) gameObjects.get(1)).get(2));
		setLeader.invoke(sp, ((ArrayList) gameObjects.get(2)).get(2));

		ArrayList<Object> firstTeam = (ArrayList<Object>) gameObjects.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) gameObjects.get(2);

		Method useLead = game.getClass().getMethod("useLeaderAbility");
		compareToCheck();
		ArrayList<Object> targets = new ArrayList<Object>();
		for (Object champion : secondTeam) {

			Method getCuMethod = champion.getClass().getMethod("getCurrentHP");
			Method getMaxHP = champion.getClass().getMethod("getMaxHP");
			if ((int) getCuMethod.invoke(champion) < ((int) getMaxHP.invoke(champion) * 0.3)) {
				targets.add(champion);

			}

		}

		useLead.invoke(game);
		firstTeam.addAll(secondTeam);
		for (Object champion : firstTeam) {
			if (!targets.contains(champion)) {
				Method getCuMethod = champion.getClass().getMethod("getCurrentHP");
				assertFalse("Game useLeaderAbility method should the CORRECT targets to villian useLeaderAbilitty",
						(int) getCuMethod.invoke(champion) == 0);
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testUseLeaderAbilityAntiHeroTargets() throws Exception {
		ArrayList<Object> gameObjects = createGameAndTeamsScenario4();
		Object game = gameObjects.get(0);
		Method getFirstPlayer = game.getClass().getMethod("getFirstPlayer");
		Method getSecondPlayer = game.getClass().getMethod("getSecondPlayer");
		Object fp = getFirstPlayer.invoke(game);
		Object sp = getSecondPlayer.invoke(game);

		Method setLeader = fp.getClass().getMethod("setLeader", Class.forName(championPath));
		Method getCurrentChamp = game.getClass().getMethod("getCurrentChampion");
		setLeader.invoke(fp, getCurrentChamp.invoke(game));
		setLeader.invoke(sp, ((ArrayList) gameObjects.get(2)).get(2));

		ArrayList<Object> firstTeam = (ArrayList<Object>) gameObjects.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) gameObjects.get(2);

		Method useLead = game.getClass().getMethod("useLeaderAbility");
		Method getLeader = fp.getClass().getMethod("getLeader");
		boolean stun = true;
		Method getAppliedEffectsah = getCurrentChamp.invoke(game).getClass().getMethod("getAppliedEffects");
		ArrayList<Object> targets = new ArrayList<Object>();
		ArrayList<Object> notTargets = new ArrayList<Object>();
		ArrayList<Integer> appliedEffectsBef = new ArrayList<Integer>();

		for (Object ch : firstTeam) {
			if (getLeader.invoke(fp).equals(ch)) {
				notTargets.add(ch);
			} else {
				targets.add(ch);
			}
		}
		for (Object ch : secondTeam) {
			if (getLeader.invoke(sp).equals(ch)) {
				notTargets.add(ch);
			} else {
				targets.add(ch);
			}
		}
		for (Object champion : targets) {
			appliedEffectsBef.add(((ArrayList<Object>) getAppliedEffectsah.invoke(champion)).size());
		}
		useLead.invoke(game);

		Method getAppliedEffectsv = getLeader.invoke(sp).getClass().getMethod("getAppliedEffects");

		ArrayList<Object> appliedEffectsv = (ArrayList<Object>) getAppliedEffectsv.invoke(getLeader.invoke(fp));

		for (Object eff : appliedEffectsv) {
			Method getName = eff.getClass().getMethod("getName");

			if (getName.invoke(eff).equals("Stun")) {

				Method getDuration = eff.getClass().getMethod("getDuration");
				if ((int) getDuration.invoke(eff) == 2) {
					fail("Game useLeaderAbility should not send the Leaders as a target");
				}
			}
		}
		for (Object champion : targets) {
			boolean foundStun = false;

			appliedEffectsv = (ArrayList<Object>) getAppliedEffectsv.invoke(champion);

			for (Object eff : appliedEffectsv) {
				Method getName = eff.getClass().getMethod("getName");

				if (getName.invoke(eff).equals("Stun")) {

					foundStun = true;
					Method getDuration = eff.getClass().getMethod("getDuration");

					assertEquals("Stun effect added by useLeaderAbility should Last for 2 turns", 2,
							getDuration.invoke(eff));
				}
			}
			if (!foundStun) {
				stun = false;
			}

		}

		assertTrue("AntiHero useLeaderAbility method should add the effect Stun to all targets", stun);

	}

	@Test(timeout = 3000)
	public void testGameActionExceptionAbstract() throws Exception {
		testClassIsAbstract(Class.forName(gameActionExceptionPath));
	}

	@Test(timeout = 3000)
	public void testConstructorLeaderNotCurrentExceptionConstructor1() throws Exception {
		@SuppressWarnings("rawtypes")
		Class[] inputs = {};
		testConstructorExists(Class.forName(leaderNotCurrentExc), inputs);
	}

	@Test(timeout = 3000)
	public void testClassIsSubclassLeaderNotCurrentException() throws Exception {
		testClassIsSubclass(Class.forName(leaderNotCurrentExc), Class.forName(gameActionExceptionPath));
	}

	@Test(timeout = 3000)
	public void testConstructorLeaderNotCurrentlExceptionConstructor2Initialization() throws Exception {
		Constructor<?> constructor = Class.forName(leaderNotCurrentExc).getConstructor(String.class);
		String message = "Error";
		Object myObj = constructor.newInstance(message);
		String[] names = {};
		Object[] values = {};
		testConstructorInitialization(myObj, names, values);
		assertEquals(
				"The constructor of the " + myObj.getClass().getSimpleName()
						+ " class should initialize the instance variable \"" + "message" + "\" correctly.",
				message, ((Exception) myObj).getMessage());
	}

	@Test(timeout = 3000)
	public void testConstructorInvalidTargetExceptionConstructor1Initialization() throws Exception {
		Constructor<?> constructor = Class.forName(itePath).getConstructor();

		Object myObj = constructor.newInstance();
		String[] names = {};
		Object[] values = {};
		testConstructorInitialization(myObj, names, values);
	}

	@Test(timeout = 3000)
	public void testConstructorInvalidTargetExceptionConstructor2() throws Exception {
		@SuppressWarnings("rawtypes")
		Class[] inputs = { String.class };
		testConstructorExists(Class.forName(itePath), inputs);
	}

	@Test(timeout = 3000)
	public void testConstructorInvalidTargetlExceptionConstructor2Initialization() throws Exception {
		Constructor<?> constructor = Class.forName(itePath).getConstructor(String.class);
		String message = "Error";
		Object myObj = constructor.newInstance(message);
		String[] names = {};
		Object[] values = {};
		testConstructorInitialization(myObj, names, values);
		assertEquals(
				"The constructor of the " + myObj.getClass().getSimpleName()
						+ " class should initialize the instance variable \"" + "message" + "\" correctly.",
				message, ((Exception) myObj).getMessage());
	}

	@Test(timeout = 3000)
	public void testConstructorChampionDisarmedExceptionConstructor1Initialization() throws Exception {
		Constructor<?> constructor = Class.forName(championDisarmedExceptionPath).getConstructor();

		Object myObj = constructor.newInstance();
		String[] names = {};
		Object[] values = {};
		testConstructorInitialization(myObj, names, values);
	}

	@Test(timeout = 3000)
	public void testClassIsSubclassChampionDisarmedException() throws Exception {
		testClassIsSubclass(Class.forName(championDisarmedExceptionPath), Class.forName(gameActionExceptionPath));
	}

	@Test(timeout = 3000)
	public void testGetCurrentChampionMethodExists() throws Exception {
		Method[] methods = Class.forName(gamePath).getDeclaredMethods();
		assertTrue("Class Game should contain a method named getCurrentChampion.",
				containsMethodName(methods, "getCurrentChampion"));
	}

	@SuppressWarnings({ "unchecked" })
	public void testGetCurrentChampionLogic1() throws Exception {

		// Create game
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		try {
			Method getTurnOrder = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = getTurnOrder.invoke(createdGame);

			try {
				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}
				Method insert = turnOrder.getClass().getMethod("insert", Comparable.class);
				insert.setAccessible(true);

				try {
					insert.invoke(turnOrder, firstTeam.get(0));
					insert.invoke(turnOrder, firstTeam.get(1));
					insert.invoke(turnOrder, firstTeam.get(2));
					insert.invoke(turnOrder, secondTeam.get(0));
					insert.invoke(turnOrder, secondTeam.get(1));
					insert.invoke(turnOrder, secondTeam.get(2));

				} catch (IllegalAccessException e) {
					 
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					 
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					 
					e.printStackTrace();
				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}

		try {

			Method m2 = createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);
			assertEquals("getCurrentChampion should return the champion with the highest speed", secondTeam.get(2),
					currentChamp);

		} catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testGetCurrentChampionLogic2() throws Exception {

		// Create game
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		try {
			Method setSpeed = secondTeam.get(0).getClass().getMethod("setSpeed", int.class);
			setSpeed.setAccessible(true);
			setSpeed.invoke(secondTeam.get(1), 10);

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setSpeed method.");

		}

		try {
			Method getTurnOrder = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = getTurnOrder.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method insert = turnOrder.getClass().getMethod("insert", Comparable.class);
				insert.setAccessible(true);

				try {
					insert.invoke(turnOrder, firstTeam.get(0));
					insert.invoke(turnOrder, firstTeam.get(1));
					insert.invoke(turnOrder, firstTeam.get(2));
					insert.invoke(turnOrder, secondTeam.get(0));
					insert.invoke(turnOrder, secondTeam.get(1));
					insert.invoke(turnOrder, secondTeam.get(2));

				} catch (IllegalAccessException e) {
					 
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					 
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					 
					e.printStackTrace();
				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}

		try {

			Method m2 = createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);
			assertEquals("getCurrentChampion should return the champion with the highest speed", secondTeam.get(1),
					currentChamp);

		} catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	///////////////////// checkGameOver tests ///////////////////////////

	@Test(timeout = 3000)
	public void testCheckGameOverMethodExists() throws Exception {
		Method[] methods = Class.forName(gamePath).getDeclaredMethods();
		assertTrue("Class Game should contain a method named checkGameOver.",
				containsMethodName(methods, "checkGameOver"));
	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testCheckGameOverPlayerOneWins() throws Exception {

		Object createdGame = createGameAndTeams().get(0);
		Object firstPlayer = createdGame.getClass().getMethod("getFirstPlayer").invoke(createdGame);
		Object secondPlayer = createdGame.getClass().getMethod("getSecondPlayer").invoke(createdGame);

		Method getTeam = secondPlayer.getClass().getMethod("getTeam");
		ArrayList<Object> secondTeam = (ArrayList<Object>) getTeam.invoke(secondPlayer);

		secondTeam.remove(0);
		secondTeam.remove(0);
		secondTeam.remove(0);

		try {

			Method m = createdGame.getClass().getMethod("checkGameOver");
			Object winningPlayer = m.invoke(createdGame);
			assertEquals("checkGameOver should return the winning player.", firstPlayer, winningPlayer);

		} catch (NoSuchMethodException e) {
			fail("Game class should have checkGameOver method");
		}

	}
	@Test(timeout = 3000)
	public void testCheckGameOverNoWinner() throws Exception {

		Object createdGame = createGameAndTeams().get(0);

		try {

			Method m = createdGame.getClass().getMethod("checkGameOver");
			Object winningPlayer = m.invoke(createdGame);
			assertEquals("checkGameOver should return the winning player", winningPlayer, null);

		} catch (NoSuchMethodException e) {
			fail("Game class should have checkGameOver method");
		}

	}

	@Test(timeout = 3000)
	public void testMoveExists() throws Exception {
		Method[] methods = Class.forName(gamePath).getDeclaredMethods();
		assertTrue("Class Game should contain a method named move.", containsMethodName(methods, "move"));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testInvalidBorderMoveUp() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		try {
			Method getTurnOrder = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = getTurnOrder.invoke(createdGame);

			try {
				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}
				Method insert = turnOrder.getClass().getMethod("insert", Comparable.class);
				insert.setAccessible(true);

				try {
					insert.invoke(turnOrder, firstTeam.get(0));
					insert.invoke(turnOrder, firstTeam.get(1));
					insert.invoke(turnOrder, firstTeam.get(2));
					insert.invoke(turnOrder, secondTeam.get(0));
					insert.invoke(turnOrder, secondTeam.get(1));
					insert.invoke(turnOrder, secondTeam.get(2));

				} catch (IllegalAccessException e) {
					 
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					 
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					 
					e.printStackTrace();
				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}

		try {

			Method m2 = createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);

			try {
				Method setLocation = currentChamp.getClass().getMethod("setLocation", Point.class);
				setLocation.invoke(currentChamp, new Point(4, 1));
				try {
					Method m = createdGame.getClass().getMethod("getBoard");
					Object[][] boardGame = (Object[][]) m.invoke(createdGame);
					boardGame[4][1] = currentChamp;

				} catch (NoSuchMethodException e) {
					fail("Game class should have getBoard method");

				}

			} catch (NoSuchMethodException e) {
				fail("Champion class should have setLocation method");

			}

			try {
				Method m3 = createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
				m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "UP"));
				fail("Trying to move UP beyond a border, an exception should be thrown");
				;

			} catch (NoSuchMethodException e) {
				fail("Game class should have move method");
			} catch (InvocationTargetException e) {
				try {
					if (!(Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
						fail("Trying to move beyond a border, an exception should be thrown");
					;

				} catch (ClassNotFoundException e1) {
					 
					fail("There should be an UnallowedMovementException class");
				}

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testInvalidBorderMoveDown() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		try {
			Method setSpeed = secondTeam.get(0).getClass().getMethod("setSpeed", int.class);
			setSpeed.setAccessible(true);
			setSpeed.invoke(firstTeam.get(0), 20);

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setSpeed method.");

		}

		try {
			Method getTurnOrder = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = getTurnOrder.invoke(createdGame);

			try {
				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method insert = turnOrder.getClass().getMethod("insert", Comparable.class);
				insert.setAccessible(true);

				try {
					insert.invoke(turnOrder, firstTeam.get(0));
					insert.invoke(turnOrder, firstTeam.get(1));
					insert.invoke(turnOrder, firstTeam.get(2));
					insert.invoke(turnOrder, secondTeam.get(0));
					insert.invoke(turnOrder, secondTeam.get(1));
					insert.invoke(turnOrder, secondTeam.get(2));

				} catch (IllegalAccessException e) {
					 
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					 
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					 
					e.printStackTrace();
				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}

		try {

			Method m2 = createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);

			try {
				Method setLocation = currentChamp.getClass().getMethod("setLocation", Point.class);
				setLocation.invoke(currentChamp, new Point(0, 1));
				try {
					Method m = createdGame.getClass().getMethod("getBoard");
					Object[][] boardGame = (Object[][]) m.invoke(createdGame);
					boardGame[0][1] = currentChamp;

				} catch (NoSuchMethodException e) {
					fail("Game class should have getBoard method");

				}

			} catch (NoSuchMethodException e) {
				fail("Champion class should have setLocation method");

			}

			try {
				Method m3 = createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
				m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "DOWN"));
				fail("Trying to move DOWN beyond a border, an exception should be thrown");
				;

			} catch (NoSuchMethodException e) {
				fail("Game class should have move method");
			} catch (InvocationTargetException e) {
				try {
					if (!(Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
						fail("Trying to move beyond a border, an exception should be thrown");
					;

				} catch (ClassNotFoundException e1) {
					 
					fail("There should be an UnallowedMovementException class");
				}

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testInvalidBorderMoveLeft() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		try {
			Method setSpeed = secondTeam.get(0).getClass().getMethod("setSpeed", int.class);
			setSpeed.setAccessible(true);
			setSpeed.invoke(firstTeam.get(0), 20);

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setSpeed method.");

		}

		try {
			Method getTurnOrder = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = getTurnOrder.invoke(createdGame);

			try {
				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method insert = turnOrder.getClass().getMethod("insert", Comparable.class);
				insert.setAccessible(true);

				try {
					insert.invoke(turnOrder, firstTeam.get(0));
					insert.invoke(turnOrder, firstTeam.get(1));
					insert.invoke(turnOrder, firstTeam.get(2));
					insert.invoke(turnOrder, secondTeam.get(0));
					insert.invoke(turnOrder, secondTeam.get(1));
					insert.invoke(turnOrder, secondTeam.get(2));

				} catch (IllegalAccessException e) {
					 
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					 
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					 
					e.printStackTrace();
				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}

		try {

			Method m2 = createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);

			try {
				Method setLocation = currentChamp.getClass().getMethod("setLocation", Point.class);
				setLocation.invoke(currentChamp, new Point(4, 0));

				try {
					Method m = createdGame.getClass().getMethod("getBoard");
					Object[][] boardGame = (Object[][]) m.invoke(createdGame);
					boardGame[4][0] = currentChamp;

				} catch (NoSuchMethodException e) {
					fail("Game class should have getBoard method");

				}

			} catch (NoSuchMethodException e) {
				fail("Champion class should have setLocation method");

			}

			try {
				Method m3 = createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
				m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "LEFT"));
				fail("Trying to move beyond a border, an exception should be thrown");
				;

			} catch (NoSuchMethodException e) {
				fail("Game class should have move method");
			} catch (InvocationTargetException e) {
				try {
					if (!(Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
						fail("Trying to move LEFT beyond a border, an exception should be thrown");
					;

				} catch (ClassNotFoundException e1) {
					 
					fail("There should be an UnallowedMovementException class");
				}

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testInvalidMoveRight() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		try {
			Method setSpeed = secondTeam.get(0).getClass().getMethod("setSpeed", int.class);
			setSpeed.setAccessible(true);
			setSpeed.invoke(firstTeam.get(0), 20);

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setSpeed method.");

		}

		try {
			Method getTurnOrder = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = getTurnOrder.invoke(createdGame);

			try {
				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method insert = turnOrder.getClass().getMethod("insert", Comparable.class);
				insert.setAccessible(true);

				try {
					insert.invoke(turnOrder, firstTeam.get(0));
					insert.invoke(turnOrder, firstTeam.get(1));
					insert.invoke(turnOrder, firstTeam.get(2));
					insert.invoke(turnOrder, secondTeam.get(0));
					insert.invoke(turnOrder, secondTeam.get(1));
					insert.invoke(turnOrder, secondTeam.get(2));

				} catch (IllegalAccessException e) {
					 
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					 
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					 
					e.printStackTrace();
				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}

		try {

			Method m2 = createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);

			try {
				Method setLocation = currentChamp.getClass().getMethod("setLocation", Point.class);
				setLocation.invoke(currentChamp, new Point(0, 1));
				setLocation.invoke(firstTeam.get(1), new Point(0, 2));

				try {
					Method m = createdGame.getClass().getMethod("getBoard");
					Object[][] boardGame = (Object[][]) m.invoke(createdGame);

					boardGame[0][1] = currentChamp;
					boardGame[0][2] = firstTeam.get(1);

				} catch (NoSuchMethodException e) {
					fail("Game class should have getBoard method");

				}

			} catch (NoSuchMethodException e) {
				fail("Champion class should have setLocation method");

			}

			try {
				Method m3 = createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
				m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "RIGHT"));
				fail("Trying to move RIGHT to an occupied cell, an exception should be thrown");

			} catch (NoSuchMethodException e) {
				fail("Game class should have move method");
			} catch (InvocationTargetException e) {
				try {
					if (!(Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
						fail("Trying to move to an occupied cell, an exception should be thrown");
					;

				} catch (ClassNotFoundException e1) {
					 
					fail("There should be an UnallowedMovementException class");
				}

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testInvalidMoveLeft() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		try {
			Method setSpeed = secondTeam.get(0).getClass().getMethod("setSpeed", int.class);
			setSpeed.setAccessible(true);
			setSpeed.invoke(firstTeam.get(1), 20);

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setSpeed method.");

		}

		try {
			Method getTurnOrder = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = getTurnOrder.invoke(createdGame);

			try {
				Method insert = turnOrder.getClass().getMethod("insert", Comparable.class);
				insert.setAccessible(true);

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				try {
					insert.invoke(turnOrder, firstTeam.get(1));

				} catch (IllegalAccessException e) {
					 
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					 
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					 
					e.printStackTrace();
				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}

		try {

			Method m2 = createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);

			try {
				Method setLocation = currentChamp.getClass().getMethod("setLocation", Point.class);
				setLocation.invoke(currentChamp, new Point(0, 1));
				setLocation.invoke(firstTeam.get(1), new Point(0, 2));

				try {
					Method m = createdGame.getClass().getMethod("getBoard");
					Object[][] boardGame = (Object[][]) m.invoke(createdGame);

					boardGame[0][1] = currentChamp;
					boardGame[0][2] = firstTeam.get(1);

					try {
						Field board = createdGame.getClass().getDeclaredField("board");
						board.setAccessible(true);
						board.set(createdGame, boardGame);

					} catch (NoSuchFieldException e) {
						fail("Game class should have board attribute");

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getBoard method");

				}

			} catch (NoSuchMethodException e) {
				fail("Champion class should have setLocation method");

			}

			try {
				Method m3 = createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
				m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "LEFT"));
				fail("Trying to move LEFT to an occupied cell, an exception should be thrown");

			} catch (NoSuchMethodException e) {
				fail("Game class should have move method");
			} catch (InvocationTargetException e) {
				try {
					if (!(Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
						fail("Trying to move to an occupied cell, an exception should be thrown");

				} catch (ClassNotFoundException e1) {
					 
					fail("There should be an UnallowedMovementException class");
				}

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testInvalidMoveUp() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		try {
			Method setSpeed = secondTeam.get(0).getClass().getMethod("setSpeed", int.class);
			setSpeed.setAccessible(true);
			setSpeed.invoke(firstTeam.get(0), 20);

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setSpeed method.");

		}

		try {
			Method getTurnOrder = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = getTurnOrder.invoke(createdGame);

			try {
				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method insert = turnOrder.getClass().getMethod("insert", Comparable.class);
				insert.setAccessible(true);

				try {
					insert.invoke(turnOrder, firstTeam.get(0));

				} catch (IllegalAccessException e) {
					 
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					 
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					 
					e.printStackTrace();
				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}

		try {

			Method m2 = createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);

			try {
				Method setLocation = currentChamp.getClass().getMethod("setLocation", Point.class);
				setLocation.invoke(currentChamp, new Point(0, 1));
				setLocation.invoke(firstTeam.get(1), new Point(1, 1));

				try {
					Method m = createdGame.getClass().getMethod("getBoard");
					Object[][] boardGame = (Object[][]) m.invoke(createdGame);

					boardGame[0][1] = currentChamp;
					boardGame[1][1] = firstTeam.get(1);

				} catch (NoSuchMethodException e) {
					fail("Game class should have getBoard method");

				}

			} catch (NoSuchMethodException e) {
				fail("Champion class should have setLocation method");

			}

			try {
				Method m3 = createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
				m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "UP"));
				fail("Trying to move to an occupied cell, an exception should be thrown");

			} catch (NoSuchMethodException e) {
				fail("Game class should have move method");
			} catch (InvocationTargetException e) {
				try {
					if (!(Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
						fail("Trying to move UP to an occupied cell, an exception should be thrown");

				} catch (ClassNotFoundException e1) {
					 
					fail("There should be an UnallowedMovementException class");
				}

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testInvalidMoveObstacleCoverRight() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		try {
			Method setSpeed = secondTeam.get(0).getClass().getMethod("setSpeed", int.class);
			setSpeed.setAccessible(true);
			setSpeed.invoke(firstTeam.get(1), 20);

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setSpeed method.");

		}

		try {
			Method getTurnOrder = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = getTurnOrder.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method insert = turnOrder.getClass().getMethod("insert", Comparable.class);
				insert.setAccessible(true);

				try {
					insert.invoke(turnOrder, firstTeam.get(0));
					insert.invoke(turnOrder, firstTeam.get(1));
					insert.invoke(turnOrder, firstTeam.get(2));
					insert.invoke(turnOrder, secondTeam.get(0));
					insert.invoke(turnOrder, secondTeam.get(1));
					insert.invoke(turnOrder, secondTeam.get(2));

				} catch (IllegalAccessException e) {
					 
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					 
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					 
					e.printStackTrace();
				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}

		try {

			Method m2 = createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);

			try {
				Method setLocation = currentChamp.getClass().getMethod("setLocation", Point.class);
				setLocation.invoke(currentChamp, new Point(2, 1));
				setLocation.invoke(firstTeam.get(1), new Point(2, 1));

				try {
					Method m = createdGame.getClass().getMethod("getBoard");
					Object[][] boardGame = (Object[][]) m.invoke(createdGame);

					boardGame[2][1] = currentChamp;

					Constructor<?> constructor = Class.forName(coverPath).getConstructor(int.class, int.class);
					Object cover = constructor.newInstance(2, 2);
					boardGame[2][2] = cover;

				} catch (NoSuchMethodException e) {
					fail("Game class should have getBoard method");

				}

			} catch (NoSuchMethodException e) {
				fail("Champion class should have setLocation method");

			}

			try {
				Method m3 = createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
				m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "RIGHT"));
				fail("Trying to move RIGHT to an occupied cell, an exception should be thrown");

			} catch (NoSuchMethodException e) {
				fail("Game class should have move method");
			} catch (InvocationTargetException e) {
				try {
					if (!(Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
						fail("Trying to move to an occupied cell, an exception should be thrown");

				} catch (ClassNotFoundException e1) {
					 
					fail("There should be an UnallowedMovementException class");
				}

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testInvalidMoveObstacleCoverLeft() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		try {
			Method setSpeed = secondTeam.get(0).getClass().getMethod("setSpeed", int.class);
			setSpeed.setAccessible(true);
			setSpeed.invoke(firstTeam.get(1), 20);

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setSpeed method.");

		}

		try {
			Method getTurnOrder = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = getTurnOrder.invoke(createdGame);

			try {
				Method insert = turnOrder.getClass().getMethod("insert", Comparable.class);
				insert.setAccessible(true);

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				try {
					insert.invoke(turnOrder, firstTeam.get(0));
					insert.invoke(turnOrder, firstTeam.get(1));
					insert.invoke(turnOrder, firstTeam.get(2));
					insert.invoke(turnOrder, secondTeam.get(0));
					insert.invoke(turnOrder, secondTeam.get(1));
					insert.invoke(turnOrder, secondTeam.get(2));

				} catch (IllegalAccessException e) {
					 
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					 
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					 
					e.printStackTrace();
				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}

		try {

			Method m2 = createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);

			try {
				Method setLocation = currentChamp.getClass().getMethod("setLocation", Point.class);
				setLocation.invoke(currentChamp, new Point(2, 1));
				setLocation.invoke(firstTeam.get(1), new Point(2, 1));

				try {
					Method m = createdGame.getClass().getMethod("getBoard");
					Object[][] boardGame = (Object[][]) m.invoke(createdGame);

					boardGame[2][1] = currentChamp;

					Constructor<?> constructor = Class.forName(coverPath).getConstructor(int.class, int.class);
					Object cover = constructor.newInstance(2, 0);
					boardGame[2][0] = cover;

					try {
						Field board = createdGame.getClass().getDeclaredField("board");
						board.setAccessible(true);
						board.set(createdGame, boardGame);

					} catch (NoSuchFieldException e) {
						fail("Game class should have board attribute");

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getBoard method");

				}

			} catch (NoSuchMethodException e) {
				fail("Champion class should have setLocation method");

			}

			try {
				Method m3 = createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
				m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "LEFT"));
				fail("Trying to move to an occupied cell, an exception should be thrown");

			} catch (NoSuchMethodException e) {
				fail("Game class should have move method");
			} catch (InvocationTargetException e) {
				try {
					if (!(Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
						fail("Trying to move to LEFT an occupied cell, an exception should be thrown");

				} catch (ClassNotFoundException e1) {
					 
					fail("There should be an UnallowedMovementException class");
				}

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testInvalidMoveObstacleCoverUp() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		try {
			Method setSpeed = secondTeam.get(0).getClass().getMethod("setSpeed", int.class);
			setSpeed.setAccessible(true);
			setSpeed.invoke(firstTeam.get(1), 20);

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setSpeed method.");

		}

		try {
			Method getTurnOrder = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = getTurnOrder.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method insert = turnOrder.getClass().getMethod("insert", Comparable.class);
				insert.setAccessible(true);

				try {
					insert.invoke(turnOrder, firstTeam.get(0));
					insert.invoke(turnOrder, firstTeam.get(1));
					insert.invoke(turnOrder, firstTeam.get(2));
					insert.invoke(turnOrder, secondTeam.get(0));
					insert.invoke(turnOrder, secondTeam.get(1));
					insert.invoke(turnOrder, secondTeam.get(2));

				} catch (IllegalAccessException e) {
					 
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					 
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					 
					e.printStackTrace();
				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}

		try {

			Method m2 = createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);

			try {
				Method setLocation = currentChamp.getClass().getMethod("setLocation", Point.class);
				setLocation.invoke(currentChamp, new Point(2, 1));
				setLocation.invoke(firstTeam.get(1), new Point(2, 1));

				try {
					Method m = createdGame.getClass().getMethod("getBoard");
					Object[][] boardGame = (Object[][]) m.invoke(createdGame);

					boardGame[2][1] = currentChamp;

					Constructor<?> constructor = Class.forName(coverPath).getConstructor(int.class, int.class);
					Object cover = constructor.newInstance(3, 1);
					boardGame[3][1] = cover;

				} catch (NoSuchMethodException e) {
					fail("Game class should have getBoard method");

				}

			} catch (NoSuchMethodException e) {
				fail("Champion class should have setLocation method");

			}

			try {
				Method m3 = createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
				m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "UP"));
				fail("Trying to move to an occupied cell, an exception should be thrown");

			} catch (NoSuchMethodException e) {
				fail("Game class should have move method");
			} catch (InvocationTargetException e) {
				try {
					if (!(Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
						fail("Trying to move UP to an occupied cell, an exception should be thrown");

				} catch (ClassNotFoundException e1) {
					 
					fail("There should be an UnallowedMovementException class");
				}

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testValidMoveDown() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		try {
			Method setSpeed = secondTeam.get(0).getClass().getMethod("setSpeed", int.class);
			setSpeed.setAccessible(true);
			setSpeed.invoke(firstTeam.get(1), 20);

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setSpeed method.");

		}

		try {
			Method getTurnOrder = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = getTurnOrder.invoke(createdGame);

			try {
				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method insert = turnOrder.getClass().getMethod("insert", Comparable.class);
				insert.setAccessible(true);

				try {
					insert.invoke(turnOrder, firstTeam.get(0));
					insert.invoke(turnOrder, firstTeam.get(1));
					insert.invoke(turnOrder, firstTeam.get(2));
					insert.invoke(turnOrder, secondTeam.get(0));
					insert.invoke(turnOrder, secondTeam.get(1));
					insert.invoke(turnOrder, secondTeam.get(2));

				} catch (IllegalAccessException e) {
					 
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					 
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					 
					e.printStackTrace();
				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}

		try {

			Method m2 = createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);

			try {
				Method setLocation = currentChamp.getClass().getMethod("setLocation", Point.class);
				setLocation.invoke(currentChamp, new Point(2, 1));
				setLocation.invoke(firstTeam.get(1), new Point(2, 1));

				try {
					Method m = createdGame.getClass().getMethod("getBoard");
					Object[][] boardGame = (Object[][]) m.invoke(createdGame);

					boardGame[2][1] = currentChamp;

					boardGame[1][1] = null;

				} catch (NoSuchMethodException e) {
					fail("Game class should have getBoard method");

				}

			} catch (NoSuchMethodException e) {
				fail("Champion class should have setLocation method");

			}

			try {
				Method m3 = createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
				m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "DOWN"));

				try {
					Method getLocation = currentChamp.getClass().getMethod("getLocation");
					Point location = (Point) getLocation.invoke(currentChamp);

					int updatedX = (int) location.getX();
					int updatedY = (int) location.getY();

					assertTrue("Location of champion not updated correctly after a valid move. Expected X coorditane  "
							+ 1 + " but was " + updatedX + ".", 1 == updatedX);

					assertTrue("Location of champion not updated correctly after a valid move. Expected Y coorditane  "
							+ 1 + " but was " + updatedY + ".", 1 == updatedY);

				} catch (NoSuchMethodException e) {
					fail("Champion class should have getLocation method");

				}
			} catch (NoSuchMethodException e) {
				fail("Game class should have move method");
			} catch (InvocationTargetException e) {
				try {
					if ((Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
						fail("Trying to move DOWN to an empty cell, but an exception was thrown");

				} catch (ClassNotFoundException e1) {
					 
					fail("There should be an UnallowedMovementException class");
				}

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testValidMoveUp() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		try {
			Method setSpeed = secondTeam.get(0).getClass().getMethod("setSpeed", int.class);
			setSpeed.setAccessible(true);
			setSpeed.invoke(firstTeam.get(1), 20);

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setSpeed method.");

		}

		try {
			Method getTurnOrder = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = getTurnOrder.invoke(createdGame);

			try {
				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method insert = turnOrder.getClass().getMethod("insert", Comparable.class);
				insert.setAccessible(true);

				try {
					insert.invoke(turnOrder, firstTeam.get(0));
					insert.invoke(turnOrder, firstTeam.get(1));
					insert.invoke(turnOrder, firstTeam.get(2));
					insert.invoke(turnOrder, secondTeam.get(0));
					insert.invoke(turnOrder, secondTeam.get(1));
					insert.invoke(turnOrder, secondTeam.get(2));

				} catch (IllegalAccessException e) {
					 
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					 
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					 
					e.printStackTrace();
				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}

		try {

			Method m2 = createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);

			try {
				Method setLocation = currentChamp.getClass().getMethod("setLocation", Point.class);
				setLocation.invoke(currentChamp, new Point(2, 1));
				setLocation.invoke(firstTeam.get(1), new Point(2, 1));

				try {
					Method m = createdGame.getClass().getMethod("getBoard");
					Object[][] boardGame = (Object[][]) m.invoke(createdGame);

					boardGame[2][1] = currentChamp;

					boardGame[3][1] = null;

				} catch (NoSuchMethodException e) {
					fail("Game class should have getBoard method");

				}

			} catch (NoSuchMethodException e) {
				fail("Champion class should have setLocation method");

			}

			try {
				Method m3 = createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
				m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "UP"));

				try {
					Method getLocation = currentChamp.getClass().getMethod("getLocation");
					Point location = (Point) getLocation.invoke(currentChamp);

					int updatedX = (int) location.getX();
					int updatedY = (int) location.getY();

					assertTrue("Location of champion not updated correctly after a valid move. Expected X coorditane  "
							+ 3 + " but was " + updatedX + ".", 3 == updatedX);

					assertTrue("Location of champion not updated correctly after a valid move. Expected Y coorditane  "
							+ 1 + " but was " + updatedY + ".", 1 == updatedY);

				} catch (NoSuchMethodException e) {
					fail("Champion class should have getLocation method");

				}
			} catch (NoSuchMethodException e) {
				fail("Game class should have move method");
			} catch (InvocationTargetException e) {
				try {
					if ((Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
						fail("Trying to move UP to an empty cell, but an exception was thrown");

				} catch (ClassNotFoundException e1) {
					 
					fail("There should be an UnallowedMovementException class");
				}

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testValidMoveUpBoardUpdated() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		try {
			Method setSpeed = secondTeam.get(0).getClass().getMethod("setSpeed", int.class);
			setSpeed.setAccessible(true);
			setSpeed.invoke(firstTeam.get(1), 20);

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setSpeed method.");

		}

		try {
			Method getTurnOrder = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = getTurnOrder.invoke(createdGame);

			try {
				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method insert = turnOrder.getClass().getMethod("insert", Comparable.class);
				insert.setAccessible(true);

				try {
					insert.invoke(turnOrder, firstTeam.get(0));
					insert.invoke(turnOrder, firstTeam.get(1));
					insert.invoke(turnOrder, firstTeam.get(2));
					insert.invoke(turnOrder, secondTeam.get(0));
					insert.invoke(turnOrder, secondTeam.get(1));
					insert.invoke(turnOrder, secondTeam.get(2));

				} catch (IllegalAccessException e) {
					 
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					 
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					 
					e.printStackTrace();
				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}

		try {

			Method m2 = createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);

			try {
				Method setLocation = currentChamp.getClass().getMethod("setLocation", Point.class);
				setLocation.invoke(currentChamp, new Point(2, 1));
				setLocation.invoke(firstTeam.get(1), new Point(2, 1));

				try {
					Method m = createdGame.getClass().getMethod("getBoard");
					Object[][] boardGame = (Object[][]) m.invoke(createdGame);

					boardGame[2][1] = currentChamp;

					boardGame[3][1] = null;

					try {
						Method m3 = createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
						m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "UP"));

						Object[][] boardGameUpdated = (Object[][]) m.invoke(createdGame);

						assertTrue("Board not updated correctly after champion moved UP.",
								boardGameUpdated[3][1] == currentChamp);

					} catch (NoSuchMethodException e) {
						fail("Game class should have move method");
					} catch (InvocationTargetException e) {
						try {
							if ((Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
								fail("Trying to move UP to an empty cell, but an exception was thrown");

						} catch (ClassNotFoundException e1) {
							 
							fail("There should be an UnallowedMovementException class");
						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getBoard method");

				}

			} catch (NoSuchMethodException e) {
				fail("Champion class should have setLocation method");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testValidMoveRight() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		try {
			Method setSpeed = secondTeam.get(0).getClass().getMethod("setSpeed", int.class);
			setSpeed.setAccessible(true);
			setSpeed.invoke(firstTeam.get(1), 20);

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setSpeed method.");

		}

		try {
			Method getTurnOrder = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = getTurnOrder.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method insert = turnOrder.getClass().getMethod("insert", Comparable.class);
				insert.setAccessible(true);

				try {
					insert.invoke(turnOrder, firstTeam.get(0));
					insert.invoke(turnOrder, firstTeam.get(1));
					insert.invoke(turnOrder, firstTeam.get(2));
					insert.invoke(turnOrder, secondTeam.get(0));
					insert.invoke(turnOrder, secondTeam.get(1));
					insert.invoke(turnOrder, secondTeam.get(2));

				} catch (IllegalAccessException e) {
					 
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					 
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					 
					e.printStackTrace();
				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}

		try {

			Method m2 = createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);

			try {
				Method setLocation = currentChamp.getClass().getMethod("setLocation", Point.class);
				setLocation.invoke(currentChamp, new Point(2, 1));
				setLocation.invoke(firstTeam.get(1), new Point(2, 1));

				try {
					Method m = createdGame.getClass().getMethod("getBoard");
					Object[][] boardGame = (Object[][]) m.invoke(createdGame);

					boardGame[2][1] = currentChamp;

					boardGame[2][2] = null;

				} catch (NoSuchMethodException e) {
					fail("Game class should have getBoard method");

				}

			} catch (NoSuchMethodException e) {
				fail("Champion class should have setLocation method");

			}

			try {
				Method m3 = createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
				m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "RIGHT"));

				try {
					Method getLocation = currentChamp.getClass().getMethod("getLocation");
					Point location = (Point) getLocation.invoke(currentChamp);

					int updatedX = (int) location.getX();
					int updatedY = (int) location.getY();

					assertTrue("Location of champion not updated correctly after a valid move. Expected X coorditane  "
							+ 2 + " but was " + updatedX + ".", 2 == updatedX);

					assertTrue("Location of champion not updated correctly after a valid move. Expected Y coorditane  "
							+ 2 + " but was " + updatedY + ".", 2 == updatedY);

				} catch (NoSuchMethodException e) {
					fail("Champion class should have getLocation method");

				}
			} catch (NoSuchMethodException e) {
				fail("Game class should have move method");
			} catch (InvocationTargetException e) {
				try {
					if ((Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
						fail("Trying to move RIGHT to an empty cell, but an exception was thrown");

				} catch (ClassNotFoundException e1) {
					 
					fail("There should be an UnallowedMovementException class");
				}

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testValidMoveLeft() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		try {
			Method setSpeed = secondTeam.get(0).getClass().getMethod("setSpeed", int.class);
			setSpeed.setAccessible(true);
			setSpeed.invoke(firstTeam.get(1), 20);

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setSpeed method.");

		}

		try {
			Method getTurnOrder = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = getTurnOrder.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method insert = turnOrder.getClass().getMethod("insert", Comparable.class);
				insert.setAccessible(true);

				try {
					insert.invoke(turnOrder, firstTeam.get(0));
					insert.invoke(turnOrder, firstTeam.get(1));
					insert.invoke(turnOrder, firstTeam.get(2));
					insert.invoke(turnOrder, secondTeam.get(0));
					insert.invoke(turnOrder, secondTeam.get(1));
					insert.invoke(turnOrder, secondTeam.get(2));

				} catch (IllegalAccessException e) {
					 
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					 
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					 
					e.printStackTrace();
				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}

		try {

			Method m2 = createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);

			try {
				Method setLocation = currentChamp.getClass().getMethod("setLocation", Point.class);
				setLocation.invoke(currentChamp, new Point(2, 1));
				setLocation.invoke(firstTeam.get(1), new Point(2, 1));

				try {
					Method m = createdGame.getClass().getMethod("getBoard");
					Object[][] boardGame = (Object[][]) m.invoke(createdGame);

					boardGame[2][1] = currentChamp;

					boardGame[2][0] = null;

				} catch (NoSuchMethodException e) {
					fail("Game class should have getBoard method");

				}

			} catch (NoSuchMethodException e) {
				fail("Champion class should have setLocation method");

			}

			try {
				Method m3 = createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
				m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "LEFT"));

				try {
					Method getLocation = currentChamp.getClass().getMethod("getLocation");
					Point location = (Point) getLocation.invoke(currentChamp);

					int updatedX = (int) location.getX();
					int updatedY = (int) location.getY();

					assertTrue("Location of champion not updated correctly after a valid move. Expected X coorditane  "
							+ 2 + " but was " + updatedX + ".", 2 == updatedX);

					assertTrue("Location of champion not updated correctly after a valid move. Expected Y coorditane  "
							+ 0 + " but was " + updatedY + ".", 0 == updatedY);

				} catch (NoSuchMethodException e) {
					fail("Champion class should have getLocation method");

				}
			} catch (NoSuchMethodException e) {
				fail("Game class should have move method");
			} catch (InvocationTargetException e) {
				try {
					if ((Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
						fail("Trying to move LEFT to an empty cell, but an exception was thrown");

				} catch (ClassNotFoundException e1) {
					 
					fail("There should be an UnallowedMovementException class");
				}

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testMoveNotEnoughActionPoints() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		try {
			Method setSpeed = secondTeam.get(0).getClass().getMethod("setSpeed", int.class);
			setSpeed.setAccessible(true);
			setSpeed.invoke(firstTeam.get(0), 20);

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setSpeed method.");

		}

		try {
			Method setCurrentActionPoints = secondTeam.get(0).getClass().getMethod("setCurrentActionPoints", int.class);
			setCurrentActionPoints.setAccessible(true);
			setCurrentActionPoints.invoke(firstTeam.get(0), 0);

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setCurrentActionPoints method.");

		}

		try {
			Method getTurnOrder = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = getTurnOrder.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method insert = turnOrder.getClass().getMethod("insert", Comparable.class);
				insert.setAccessible(true);

				try {
					insert.invoke(turnOrder, firstTeam.get(0));

				} catch (IllegalAccessException e) {
					 
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					 
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					 
					e.printStackTrace();
				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}

		try {

			Method setLocation = firstTeam.get(0).getClass().getMethod("setLocation", Point.class);
			setLocation.invoke(firstTeam.get(0), new Point(2, 1));

			try {
				Method m = createdGame.getClass().getMethod("getBoard");
				Object[][] boardGame = (Object[][]) m.invoke(createdGame);

				boardGame[2][1] = firstTeam.get(0);

				boardGame[3][1] = null;

				try {
					Field board = createdGame.getClass().getDeclaredField("board");
					board.setAccessible(true);
					board.set(createdGame, boardGame);

				} catch (NoSuchFieldException e) {
					fail("Game class should have board field");

				}

			} catch (NoSuchMethodException e) {
				fail("Game class should have getBoard method");

			}

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setLocation method");

		}

		try {
			Method m3 = createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
			m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "UP"));
			fail("Trying to move without enough action points, an exception should be thrown");

		} catch (NoSuchMethodException e) {
			fail("Game class should have move method");
		} catch (InvocationTargetException e) {
			try {
				if (!(Class.forName(NotEnoughResourcesException).equals(e.getCause().getClass())))
					fail("Trying to move without enough action points, an exception should be thrown");

			} catch (ClassNotFoundException e1) {
				 
				fail("There should be a NotEnoughResourcesException class");
			}

		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testValidMoveUpdatesActionPoints() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		try {
			Method setSpeed = secondTeam.get(0).getClass().getMethod("setSpeed", int.class);
			setSpeed.setAccessible(true);
			setSpeed.invoke(firstTeam.get(1), 20);

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setSpeed method.");

		}

		try {
			Method getTurnOrder = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = getTurnOrder.invoke(createdGame);

			try {
				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method insert = turnOrder.getClass().getMethod("insert", Comparable.class);
				insert.setAccessible(true);

				try {
					insert.invoke(turnOrder, firstTeam.get(0));
					insert.invoke(turnOrder, firstTeam.get(1));
					insert.invoke(turnOrder, firstTeam.get(2));
					insert.invoke(turnOrder, secondTeam.get(0));
					insert.invoke(turnOrder, secondTeam.get(1));
					insert.invoke(turnOrder, secondTeam.get(2));

				} catch (IllegalAccessException e) {
					 
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					 
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					 
					e.printStackTrace();
				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}

		try {

			Method m2 = createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);

			try {
				Method setLocation = currentChamp.getClass().getMethod("setLocation", Point.class);
				setLocation.invoke(currentChamp, new Point(2, 1));
				setLocation.invoke(firstTeam.get(1), new Point(2, 1));

				try {
					Method m = createdGame.getClass().getMethod("getBoard");
					Object[][] boardGame = (Object[][]) m.invoke(createdGame);

					boardGame[2][1] = currentChamp;

					boardGame[1][1] = null;

				} catch (NoSuchMethodException e) {
					fail("Game class should have getBoard method");

				}

			} catch (NoSuchMethodException e) {
				fail("Champion class should have setLocation method");

			}

			try {
				Method getCurrentActionPoints = currentChamp.getClass().getMethod("getCurrentActionPoints");

				int oldCurrentActionPoints = (int) getCurrentActionPoints.invoke(currentChamp);
				try {
					Method m3 = createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "DOWN"));
					int updatedCurrentActionPoints = (int) getCurrentActionPoints.invoke(currentChamp);

					assertTrue(
							"currentActionPoints of champion not updated correctly after a valid move. Expected actionPoints  "
									+ (oldCurrentActionPoints - 1) + " but was " + updatedCurrentActionPoints + ".",
							(oldCurrentActionPoints - 1) == updatedCurrentActionPoints);

				} catch (NoSuchMethodException e) {
					fail("Game class should have move method");

				}
			} catch (NoSuchMethodException e) {
				fail("Champion class should have getLocation method");
			} catch (InvocationTargetException e) {
				try {
					if ((Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
						fail("Trying to move DOWN to an empty cell, but an exception was thrown");

				} catch (ClassNotFoundException e1) {
					 
					fail("There should be an UnallowedMovementException class");
				}

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testprepareChampionTurns() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		try {

			Method m2 = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m2.invoke(createdGame);

			try {
				Method size = turnOrder.getClass().getMethod("size");

				int turnOrderSize = (int) size.invoke(turnOrder);

				try {
					Method remove = turnOrder.getClass().getMethod("remove");
					while (turnOrderSize != 0) {
						remove.invoke(turnOrder);
						turnOrderSize = (int) size.invoke(turnOrder);

					}

				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have remove method");

				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have size method");

			}

			Method m1 = createdGame.getClass().getDeclaredMethod("prepareChampionTurns");
			m1.setAccessible(true);
			m1.invoke(createdGame);

			// PriorityQueue turnOrder = (PriorityQueue) m2.invoke(createdGame);
			try {
				Method turnOrderSize = turnOrder.getClass().getMethod("size");
				int size = (Integer) turnOrderSize.invoke(turnOrder);

				boolean orderCorrect = true;

				try {
					Method removeFromTurnOrder = turnOrder.getClass().getMethod("remove");
					if (size != 6) {
						assertTrue(
								"Number of champions inside turnOrder priority queue after calling prepareChampionTurns is incorrect. Expected  "
										+ 6 + " but was " + size + ".",
								6 == size);
					}
					for (int i = 0; i < secondTeam.size(); i++) {
						Comparable champ = (Comparable) removeFromTurnOrder.invoke(turnOrder);
						if (champ.compareTo(secondTeam.get(secondTeam.size() - 1 - i)) != 0) {
							orderCorrect = false;

						}

					}

					for (int i = 0; i < firstTeam.size(); i++) {
						Comparable champ = (Comparable) removeFromTurnOrder.invoke(turnOrder);
						if (champ.compareTo(firstTeam.get(firstTeam.size() - 1 - i)) != 0) {
							orderCorrect = false;

						}

					}

					assertTrue(
							"Order of champions inside turnOrder priority queue is incorrect after calling prepareChampionTurns.",
							orderCorrect);

				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have remove method");
				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have size method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have prepareChampionTurns method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testInvalidMoveRooted() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		try {
			Method setSpeed = secondTeam.get(0).getClass().getMethod("setSpeed", int.class);
			setSpeed.setAccessible(true);
			setSpeed.invoke(firstTeam.get(1), 20);

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setSpeed method.");

		}

		try {
			Method getTurnOrder = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = getTurnOrder.invoke(createdGame);

			try {
				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method insert = turnOrder.getClass().getMethod("insert", Comparable.class);
				insert.setAccessible(true);

				try {
					insert.invoke(turnOrder, firstTeam.get(0));
					insert.invoke(turnOrder, firstTeam.get(1));
					insert.invoke(turnOrder, firstTeam.get(2));
					insert.invoke(turnOrder, secondTeam.get(0));
					insert.invoke(turnOrder, secondTeam.get(1));
					insert.invoke(turnOrder, secondTeam.get(2));

				} catch (IllegalAccessException e) {
					 
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					 
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					 
					e.printStackTrace();
				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}

		try {

			Method m2 = createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);

			try {
				Method setLocation = currentChamp.getClass().getMethod("setLocation", Point.class);
				setLocation.invoke(currentChamp, new Point(2, 1));
				setLocation.invoke(firstTeam.get(1), new Point(2, 1));

				try {
					Method m = createdGame.getClass().getMethod("getBoard");
					Object[][] boardGame = (Object[][]) m.invoke(createdGame);

					boardGame[2][1] = currentChamp;

					boardGame[1][1] = null;

					try {
						Method setCondition = currentChamp.getClass().getMethod("setCondition",
								Class.forName(conditionPath));
						setCondition.invoke(currentChamp,
								Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ROOTED"));

						try {

							Method getAppliedEffects = currentChamp.getClass().getMethod("getAppliedEffects");

							ArrayList<Object> champEffects = (ArrayList<Object>) getAppliedEffects.invoke(currentChamp);

							Constructor<?> constructor = Class.forName(rootPath).getConstructor(int.class);

							Random r = new Random();
							int durationOne = r.nextInt(10);

							Object rootEffect = constructor.newInstance(durationOne);

							champEffects.add(rootEffect);

							try {
								Field appliedEffects = currentChamp.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects.setAccessible(true);
								appliedEffects.set(currentChamp, champEffects);
							} catch (NoSuchFieldException e) {
								fail("Champion class should have appliedEffects attribute");

							}
						} catch (NoSuchMethodException e) {
							fail("Champion class should have getAppliedEffects method");

						}

					} catch (NoSuchMethodException e) {
						fail("Champion class should have setCondition method");

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getBoard method");

				}

			} catch (NoSuchMethodException e) {
				fail("Champion class should have setLocation method");

			}

			try {
				Method m3 = createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
				m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "DOWN"));
				fail("Trying to move when condition is ROOTED, an exception should be thrown");

				// try {
				// Method getLocation = currentChamp.getClass().getMethod("getLocation");
				// Point location = (Point) getLocation.invoke(currentChamp);
				//
				// int updatedX = (int) location.getX();
				// int updatedY = (int) location.getY();
				//
				// assertTrue("Champion should not move if rooted. Expected x coordinate 2 but
				// was " + updatedX ,
				// 2 == updatedX);
				//
				// assertTrue("Champion should not move if rooted. Expected y coordinate 1 but
				// was " + updatedY ,
				// 1 == updatedY);
				//
				//
				//
				// } catch(NoSuchMethodException e) {
				// fail("Champion class should have getLocation method");

				// }
			} catch (NoSuchMethodException e) {
				fail("Game class should have move method");
			} catch (InvocationTargetException e) {
				try {
					if (!(Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
						fail("Trying to move when champion's condition is ROOTED, an exception should be thrown");

				} catch (ClassNotFoundException e1) {
					 
					fail("There should be an UnallowedMovementException class");
				}

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	// //////////////////////////////attack////////////////////////////////////////////////////
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testHeroAttackHeroUp() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		Object champ1 = firstTeam.get(0);
		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1, new Point(0, 1));
		boardGame[0][1] = champ1;

		setLocation.invoke(champ6, new Point(1, 1));
		boardGame[1][1] = champ6;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(firstTeam.get(0), r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ1);
				m2.invoke(turnOrder, champ6);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ1) {
						setSpeed.invoke(champ1, 2);
						setSpeed.invoke(champ6, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ1);
							m2.invoke(turnOrder, champ6);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ6);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "UP"));
					int newHP = (Integer) m5.invoke(champ6);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");

					int attackDamage = (Integer) m4.invoke(champ1);

					int expectedHP = oldHP - attackDamage;

					assertTrue("The HP of the hero attacked by a hero is not updated correctly. Expected " + expectedHP
							+ " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testHeroAttackHeroDown() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		Object champ1 = firstTeam.get(0);
		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1, new Point(1, 1));
		boardGame[1][1] = champ1;

		setLocation.invoke(champ6, new Point(0, 1));
		boardGame[0][1] = champ6;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(firstTeam.get(0), r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ1);
				m2.invoke(turnOrder, champ6);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ1) {
						setSpeed.invoke(champ1, 2);
						setSpeed.invoke(champ6, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ1);
							m2.invoke(turnOrder, champ6);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ6);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "DOWN"));
					int newHP = (Integer) m5.invoke(champ6);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ1);

					int expectedHP = oldHP - attackDamage;

					assertTrue("The HP of the hero attacked by a hero is not updated correctly. Expected " + expectedHP
							+ " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testHeroAttackHeroRight() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		Object champ1 = firstTeam.get(0);
		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1, new Point(1, 1));
		boardGame[1][1] = champ1;

		setLocation.invoke(champ6, new Point(1, 2));
		boardGame[1][2] = champ6;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(firstTeam.get(0), r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ1);
				m2.invoke(turnOrder, champ6);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ1) {
						setSpeed.invoke(champ1, 2);
						setSpeed.invoke(champ6, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ1);
							m2.invoke(turnOrder, champ6);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ6);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "RIGHT"));
					int newHP = (Integer) m5.invoke(champ6);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ1);

					int expectedHP = oldHP - attackDamage;

					assertTrue("The HP of the hero attacked by a hero is not updated correctly. Expected " + expectedHP
							+ " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testHeroAttackAntiHeroLeft() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		Object champ5 = secondTeam.get(1);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1, new Point(1, 1));
		boardGame[1][1] = champ1;

		setLocation.invoke(champ5, new Point(1, 0));
		boardGame[1][0] = champ5;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(firstTeam.get(0), r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ1);
				m2.invoke(turnOrder, champ5);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ1) {
						setSpeed.invoke(champ1, 2);
						setSpeed.invoke(champ5, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ1);
							m2.invoke(turnOrder, champ5);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ5);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "LEFT"));
					int newHP = (Integer) m5.invoke(champ5);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ1);

					int extraDamage = (Integer) attackDamage / 2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the antihero attacked by a hero is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testHeroAttackAntiHeroDown() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		Object champ1 = firstTeam.get(0);

		Object champ5 = secondTeam.get(1);
		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1, new Point(1, 1));
		boardGame[1][1] = champ1;

		setLocation.invoke(champ5, new Point(0, 1));
		boardGame[0][1] = champ5;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(firstTeam.get(0), r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ1);
				m2.invoke(turnOrder, champ5);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ1) {
						setSpeed.invoke(champ1, 2);
						setSpeed.invoke(champ5, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ1);
							m2.invoke(turnOrder, champ5);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ5);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "DOWN"));
					int newHP = (Integer) m5.invoke(champ5);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ1);

					int extraDamage = (Integer) attackDamage / 2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of antihero attacked by a hero is not updated correctly. Expected " + expectedHP
							+ " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testHeroAttackAntiHeroUp() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		Object champ5 = secondTeam.get(1);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1, new Point(0, 1));
		boardGame[0][1] = champ1;

		setLocation.invoke(champ5, new Point(2, 1));
		boardGame[1][1] = null;
		boardGame[2][1] = champ5;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(firstTeam.get(0), r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ1);
				m2.invoke(turnOrder, champ5);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ1) {
						setSpeed.invoke(champ1, 2);
						setSpeed.invoke(champ5, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ1);
							m2.invoke(turnOrder, champ5);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ5);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "UP"));
					int newHP = (Integer) m5.invoke(champ5);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ1);

					int extraDamage = (Integer) attackDamage / 2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the antihero attacked by a hero is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testHeroAttackVillainRight() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);

		Object champ4 = secondTeam.get(0);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1, new Point(3, 2));
		boardGame[3][2] = champ1;

		setLocation.invoke(champ4, new Point(3, 4));
		boardGame[3][3] = null;
		boardGame[3][4] = champ4;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(firstTeam.get(0), r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ1);
				m2.invoke(turnOrder, champ4);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ1) {
						setSpeed.invoke(champ1, 2);
						setSpeed.invoke(champ4, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ1);
							m2.invoke(turnOrder, champ4);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ4);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "RIGHT"));
					int newHP = (Integer) m5.invoke(champ4);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ1);

					int extraDamage = (Integer) attackDamage / 2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the villain attacked by a hero is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testHeroAttackVillainLeft() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);

		Object champ4 = secondTeam.get(0);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1, new Point(3, 2));
		boardGame[3][2] = champ1;

		setLocation.invoke(champ4, new Point(3, 0));
		boardGame[3][1] = null;
		boardGame[3][0] = champ4;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(firstTeam.get(0), r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ1);
				m2.invoke(turnOrder, champ4);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ1) {
						setSpeed.invoke(champ1, 2);
						setSpeed.invoke(champ4, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ1);
							m2.invoke(turnOrder, champ4);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ4);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "LEFT"));
					int newHP = (Integer) m5.invoke(champ4);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ1);

					int extraDamage = (Integer) attackDamage / 2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the villain attacked by a hero  is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testHeroAttackVillainUp() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		Object champ1 = firstTeam.get(0);

		Object champ4 = secondTeam.get(0);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1, new Point(3, 2));
		boardGame[3][2] = champ1;

		setLocation.invoke(champ4, new Point(4, 2));
		boardGame[4][2] = champ4;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(firstTeam.get(0), r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ1);
				m2.invoke(turnOrder, champ4);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ1) {
						setSpeed.invoke(champ1, 2);
						setSpeed.invoke(champ4, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ1);
							m2.invoke(turnOrder, champ4);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ4);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "UP"));
					int newHP = (Integer) m5.invoke(champ4);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ1);

					int extraDamage = (Integer) attackDamage / 2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the villain attacked by a hero  is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testVillainAttackHeroRight() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		Object champ1 = firstTeam.get(0);
		Object champ3 = firstTeam.get(2);

		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ3, new Point(3, 2));
		boardGame[3][2] = champ3;

		setLocation.invoke(champ6, new Point(3, 4));
		boardGame[3][3] = null;
		boardGame[3][4] = champ6;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ3, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ3, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ3);
				m2.invoke(turnOrder, champ6);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ3) {
						setSpeed.invoke(champ3, 2);
						setSpeed.invoke(champ6, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ3);
							m2.invoke(turnOrder, champ6);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ6);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "RIGHT"));
					int newHP = (Integer) m5.invoke(champ6);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ3);

					int extraDamage = (Integer) attackDamage / 2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the hero attacked by a villain is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testVillainAttackHeroLeft() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		Object champ3 = firstTeam.get(2);
		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ3, new Point(3, 2));
		boardGame[3][2] = champ3;

		setLocation.invoke(champ6, new Point(3, 1));
		boardGame[3][1] = champ6;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ3, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ3, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {
				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ3);
				m2.invoke(turnOrder, champ6);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ3) {
						setSpeed.invoke(champ3, 2);
						setSpeed.invoke(champ6, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ3);
							m2.invoke(turnOrder, champ6);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ6);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "LEFT"));
					int newHP = (Integer) m5.invoke(champ6);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ3);

					int extraDamage = (Integer) attackDamage / 2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the hero attacked by a villain is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testVillainAttackHeroUp() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		Object champ1 = firstTeam.get(0);
		Object champ3 = firstTeam.get(2);

		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ3, new Point(3, 2));
		boardGame[3][2] = champ3;

		setLocation.invoke(champ6, new Point(4, 2));
		boardGame[4][2] = champ6;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ3, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ3, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ3);
				m2.invoke(turnOrder, champ6);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ3) {
						setSpeed.invoke(champ3, 2);
						setSpeed.invoke(champ6, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ3);
							m2.invoke(turnOrder, champ6);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ6);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "UP"));
					int newHP = (Integer) m5.invoke(champ6);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ3);

					int extraDamage = (Integer) attackDamage / 2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the hero attacked by a villain is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testVillainAttackVillainRight() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		Object champ3 = firstTeam.get(2);

		Object champ4 = secondTeam.get(0);
		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ3, new Point(3, 2));
		boardGame[3][2] = champ3;

		setLocation.invoke(champ4, new Point(3, 4));
		boardGame[3][3] = null;
		boardGame[3][4] = champ4;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ3, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ3, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ3);
				m2.invoke(turnOrder, champ4);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ3) {
						setSpeed.invoke(champ3, 2);
						setSpeed.invoke(champ4, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ3);
							m2.invoke(turnOrder, champ4);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ4);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "RIGHT"));
					int newHP = (Integer) m5.invoke(champ4);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ3);

					int expectedHP = oldHP - attackDamage;

					assertTrue("The HP of the villain attacked by a villain is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testVillainAttackVillainLeft() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		Object champ4 = secondTeam.get(0);
		secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ3, new Point(3, 2));
		boardGame[3][2] = champ3;

		setLocation.invoke(champ6, new Point(3, 1));
		boardGame[3][1] = champ4;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ3, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ3, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ3);
				m2.invoke(turnOrder, champ4);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ3) {
						setSpeed.invoke(champ3, 2);
						setSpeed.invoke(champ4, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ3);
							m2.invoke(turnOrder, champ4);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ4);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "LEFT"));
					int newHP = (Integer) m5.invoke(champ4);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ3);

					int expectedHP = oldHP - attackDamage;

					assertTrue("The HP of the villain attacked by a villain is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testVillainAttackVillainUp() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		Object champ4 = secondTeam.get(0);
		secondTeam.get(1);
		secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ3, new Point(3, 2));
		boardGame[3][2] = champ3;

		setLocation.invoke(champ4, new Point(4, 2));
		boardGame[4][2] = champ4;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ3, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ3, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ3);
				m2.invoke(turnOrder, champ4);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ3) {
						setSpeed.invoke(champ3, 2);
						setSpeed.invoke(champ4, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ3);
							m2.invoke(turnOrder, champ4);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ4);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "UP"));
					int newHP = (Integer) m5.invoke(champ4);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ3);

					int expectedHP = oldHP - attackDamage;

					assertTrue("The HP of the villain attacked by a villain is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testVillainAttackAntiHeroRight() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ3, new Point(3, 2));
		boardGame[3][2] = champ3;

		setLocation.invoke(champ5, new Point(3, 4));
		boardGame[3][3] = null;
		boardGame[3][4] = champ5;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ3, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ3, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {
				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ3);
				m2.invoke(turnOrder, champ5);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ3) {
						setSpeed.invoke(champ3, 2);
						setSpeed.invoke(champ5, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ3);
							m2.invoke(turnOrder, champ5);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ5);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "RIGHT"));
					int newHP = (Integer) m5.invoke(champ5);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ3);

					int extraDamage = (Integer) attackDamage / 2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the antihero attacked by a villain is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testVillainAttackAntiHeroLeft() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ3, new Point(3, 2));
		boardGame[3][2] = champ3;

		setLocation.invoke(champ6, new Point(3, 1));
		boardGame[3][1] = champ5;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ3, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ3, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ3);
				m2.invoke(turnOrder, champ5);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ3) {
						setSpeed.invoke(champ3, 2);
						setSpeed.invoke(champ5, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ3);
							m2.invoke(turnOrder, champ5);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ5);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "LEFT"));
					int newHP = (Integer) m5.invoke(champ5);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ3);

					int extraDamage = (Integer) attackDamage / 2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the antihero attacked by a villain is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testVillainAttackAntiHeroUp() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ3, new Point(3, 2));
		boardGame[3][2] = champ3;

		setLocation.invoke(champ5, new Point(4, 2));
		boardGame[4][2] = champ5;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ3, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ3, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ3);
				m2.invoke(turnOrder, champ5);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ3) {
						setSpeed.invoke(champ3, 2);
						setSpeed.invoke(champ5, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ3);
							m2.invoke(turnOrder, champ5);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ5);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "UP"));
					int newHP = (Integer) m5.invoke(champ5);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ3);

					int extraDamage = (Integer) attackDamage / 2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the antihero attacked by a villain is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testAntiHeroAttackHeroLeft() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		secondTeam.get(0);
		secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ2, new Point(3, 2));
		boardGame[3][2] = champ2;

		setLocation.invoke(champ6, new Point(3, 1));
		boardGame[3][1] = champ6;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ2, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ2);
				m2.invoke(turnOrder, champ6);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ2) {
						setSpeed.invoke(champ2, 2);
						setSpeed.invoke(champ6, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ2);
							m2.invoke(turnOrder, champ6);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ6);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "LEFT"));
					int newHP = (Integer) m5.invoke(champ6);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ2);

					int extraDamage = (Integer) attackDamage / 2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the hero attacked by an antihero is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testAntiHeroAttackHeroRight() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		secondTeam.get(0);
		secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ2, new Point(3, 2));
		boardGame[3][2] = champ2;

		setLocation.invoke(champ6, new Point(3, 3));
		boardGame[3][3] = champ6;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ2, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ2);
				m2.invoke(turnOrder, champ6);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ2) {
						setSpeed.invoke(champ2, 2);
						setSpeed.invoke(champ6, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ2);
							m2.invoke(turnOrder, champ6);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ6);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "RIGHT"));
					int newHP = (Integer) m5.invoke(champ6);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ2);

					int extraDamage = (Integer) attackDamage / 2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the hero attacked by an antihero is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testAntiHeroAttackHeroUp() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		secondTeam.get(0);
		secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ2, new Point(3, 2));
		boardGame[3][2] = champ2;

		setLocation.invoke(champ6, new Point(4, 2));
		boardGame[4][2] = champ6;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ2, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ2);
				m2.invoke(turnOrder, champ6);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ2) {
						setSpeed.invoke(champ2, 2);
						setSpeed.invoke(champ6, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ2);
							m2.invoke(turnOrder, champ6);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ6);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "UP"));
					int newHP = (Integer) m5.invoke(champ6);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ2);

					int extraDamage = (Integer) attackDamage / 2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the hero attacked by an antihero is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testAntiHeroAttackVillainLeft() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		Object champ4 = secondTeam.get(0);
		secondTeam.get(1);
		secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ2, new Point(3, 2));
		boardGame[3][2] = champ2;

		setLocation.invoke(champ4, new Point(3, 1));
		boardGame[3][1] = champ4;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ2, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ2);
				m2.invoke(turnOrder, champ4);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ2) {
						setSpeed.invoke(champ2, 2);
						setSpeed.invoke(champ4, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ2);
							m2.invoke(turnOrder, champ4);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ4);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "LEFT"));
					int newHP = (Integer) m5.invoke(champ4);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ2);

					int extraDamage = (Integer) attackDamage / 2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the villain attacked by an antihero is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testAntiHeroAttackVillainRight() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		Object champ4 = secondTeam.get(0);
		secondTeam.get(1);
		secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ2, new Point(3, 2));
		boardGame[3][2] = champ2;

		setLocation.invoke(champ4, new Point(3, 3));
		boardGame[3][3] = champ4;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ2, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ2);
				m2.invoke(turnOrder, champ4);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ2) {
						setSpeed.invoke(champ2, 2);
						setSpeed.invoke(champ4, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ2);
							m2.invoke(turnOrder, champ4);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ4);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "RIGHT"));
					int newHP = (Integer) m5.invoke(champ4);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ2);

					int extraDamage = (Integer) attackDamage / 2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the villain attacked by an antihero is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testAntiHeroAttackVillainUp() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		Object champ4 = secondTeam.get(0);
		secondTeam.get(1);
		secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ2, new Point(3, 2));
		boardGame[3][2] = champ2;

		setLocation.invoke(champ4, new Point(4, 2));
		boardGame[4][2] = champ4;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ2, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ2);
				m2.invoke(turnOrder, champ4);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ2) {
						setSpeed.invoke(champ2, 2);
						setSpeed.invoke(champ4, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ2);
							m2.invoke(turnOrder, champ4);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ4);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "UP"));
					int newHP = (Integer) m5.invoke(champ4);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ2);

					int extraDamage = (Integer) attackDamage / 2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the villain attacked by an antihero is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testAntiHeroAttackAntiHeroLeft() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ2, new Point(3, 2));
		boardGame[3][2] = champ2;

		setLocation.invoke(champ5, new Point(3, 1));
		boardGame[3][1] = champ5;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ2, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ2);
				m2.invoke(turnOrder, champ5);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ2) {
						setSpeed.invoke(champ2, 2);
						setSpeed.invoke(champ5, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ2);
							m2.invoke(turnOrder, champ5);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ5);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "LEFT"));
					int newHP = (Integer) m5.invoke(champ5);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ2);

					int expectedHP = oldHP - attackDamage;

					assertTrue("The HP of the antihero attacked by an antihero is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testAntiHeroAttackAntiHeroRight() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ2, new Point(3, 2));
		boardGame[3][2] = champ2;

		setLocation.invoke(champ5, new Point(3, 3));
		boardGame[3][3] = champ5;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ2, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ2);
				m2.invoke(turnOrder, champ5);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ2) {
						setSpeed.invoke(champ2, 2);
						setSpeed.invoke(champ5, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ2);
							m2.invoke(turnOrder, champ5);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ5);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "RIGHT"));
					int newHP = (Integer) m5.invoke(champ5);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ2);

					int expectedHP = oldHP - attackDamage;

					assertTrue("The HP of the antihero attacked by an antihero is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testAntiHeroAttackAntiHeroUp() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ2, new Point(3, 2));
		boardGame[3][2] = champ2;

		setLocation.invoke(champ5, new Point(4, 2));
		boardGame[4][2] = champ5;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ2, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ2);
				m2.invoke(turnOrder, champ5);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ2) {
						setSpeed.invoke(champ2, 2);
						setSpeed.invoke(champ5, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ2);
							m2.invoke(turnOrder, champ5);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ5);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "UP"));
					int newHP = (Integer) m5.invoke(champ5);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ2);

					int expectedHP = oldHP - attackDamage;

					assertTrue("The HP of the antihero attacked by an antihero is not updated correctly. Expected "
							+ expectedHP + " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testUpdateActionPointsAfterAttack() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ2, new Point(3, 2));
		boardGame[3][2] = champ2;

		setLocation.invoke(champ5, new Point(2, 2));
		boardGame[2][2] = champ5;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ2, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ2);

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentActionPoints");
					int oldActionPoints = (Integer) m5.invoke(champ2);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "DOWN"));
					int newActionPoints = (Integer) m5.invoke(champ2);

					int expectedActionPoints = oldActionPoints - 2;

					assertTrue(
							"The currentActionPoints of the attacking champion is not updated correctly. Expected "
									+ expectedActionPoints + " but was " + newActionPoints + ".",
							newActionPoints == expectedActionPoints);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void invalidAttackSameTeam() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		Object champ4 = secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);
		boardGame = new Object[5][5];

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ2, new Point(3, 2));
		boardGame[3][2] = champ2;

		setLocation.invoke(champ1, new Point(2, 2));
		boardGame[2][2] = champ6;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ6, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ1);
				m2.invoke(turnOrder, champ2);
				m2.invoke(turnOrder, champ3);
				m2.invoke(turnOrder, champ4);
				m2.invoke(turnOrder, champ5);
				m2.invoke(turnOrder, champ6);

				try {

					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ2);

					try {
						Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
						m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "DOWN"));

						int newHP = (Integer) m5.invoke(champ2);

						assertTrue(
								"A Champion should not attack a champion from the same team. The HP of a champion in the same team was affected.",
								newHP == oldHP);

					} catch (NoSuchMethodException e) {
						fail("Game class should have attack method");

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
					fail("Champion class should have getCurrentHP method");

				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void invalidAttackDisarmed() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		secondTeam.get(0);
		secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);
		boardGame = new Object[5][5];

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ2, new Point(3, 2));
		boardGame[3][2] = champ2;

		setLocation.invoke(champ1, new Point(2, 2));
		boardGame[2][2] = champ6;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ6, r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ2);

				try {

					Method getAppliedEffects = champ2.getClass().getMethod("getAppliedEffects");

					ArrayList<Object> champEffects = (ArrayList<Object>) getAppliedEffects.invoke(champ2);

					Constructor<?> constructor = Class.forName(disarmPath).getConstructor(int.class);

					int durationOne = r.nextInt(10);

					Object disarmEffect = constructor.newInstance(durationOne);

					champEffects.add(disarmEffect);

					try {
						Field appliedEffects = champ2.getClass().getSuperclass().getDeclaredField("appliedEffects");
						appliedEffects.setAccessible(true);
						appliedEffects.set(champ2, champEffects);
					} catch (NoSuchFieldException e) {
						fail("Champion class should have appliedEffects attribute");

					}
				} catch (NoSuchMethodException e) {
					fail("Champion class should have getAppliedEffects method");

				}

				try {
					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "DOWN"));

					fail("Trying to attack when champion has applied effect DISARM, an exception should be thrown");

				} catch (NoSuchMethodException e) {
					fail("Game class should have move method");
				} catch (InvocationTargetException e) {
					try {
						if (!(Class.forName(ChampionDisarmedException).equals(e.getCause().getClass())))
							fail("Trying to attack when champion has applied effect DISARM, an exception should be thrown");

					} catch (ClassNotFoundException e1) {
						 
						fail("There should be an ChampionDisarmedException class");
					}

				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void invalidAttackNotEnoughActionPoints() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		secondTeam.get(0);
		secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);
		boardGame = new Object[5][5];

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ2, new Point(3, 2));
		boardGame[3][2] = champ2;

		setLocation.invoke(champ1, new Point(2, 2));
		boardGame[2][2] = champ6;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ6, r.nextInt(50) + 1);

		try {
			Method setCurrentActionPoints = champ2.getClass().getMethod("setCurrentActionPoints", int.class);
			setCurrentActionPoints.setAccessible(true);
			setCurrentActionPoints.invoke(champ2, 0);

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setCurrentActionPoints method.");

		}

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ2);

				try {
					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "DOWN"));

					fail("Trying to attack without enough action points, an exception should be thrown");

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				} catch (InvocationTargetException e) {
					try {
						if (!(Class.forName(NotEnoughResourcesException).equals(e.getCause().getClass())))
							fail("Trying to move without enough action points, an exception should be thrown");

					} catch (ClassNotFoundException e1) {
						 
						fail("There should be a NotEnoughResourcesException class");
					}

				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testAttackOutsideAttackRange() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		Object champ4 = secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1, new Point(3, 3));
		boardGame[3][3] = champ1;

		setLocation.invoke(champ4, new Point(3, 0));
		boardGame[3][1] = null;
		boardGame[3][2] = null;
		boardGame[3][0] = champ4;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		setAttackDamage.invoke(firstTeam.get(0), 10);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ1);
				m2.invoke(turnOrder, champ2);
				m2.invoke(turnOrder, champ3);
				m2.invoke(turnOrder, champ4);
				m2.invoke(turnOrder, champ5);
				m2.invoke(turnOrder, champ6);

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ4);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "LEFT"));
					int newHP = (Integer) m5.invoke(champ4);

					assertTrue("The attacked champion was outside the attack range. Expected HP " + oldHP + " but was "
							+ newHP + ".", newHP == oldHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testHeroAttackCoverUp() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		firstTeam.get(2);

		secondTeam.get(0);
		secondTeam.get(1);
		secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1, new Point(0, 1));
		boardGame[0][1] = champ1;

		Constructor<?> constructor = Class.forName(coverPath).getConstructor(int.class, int.class);
		Object cover = constructor.newInstance(1, 1);
		boardGame[1][1] = cover;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(firstTeam.get(0), r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ1);

				try {
					Method m5 = cover.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(cover);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "UP"));
					int newHP = (Integer) m5.invoke(cover);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");

					int attackDamage = (Integer) m4.invoke(champ1);

					int expectedHP = oldHP - attackDamage;

					assertTrue("The HP of the attacked cover is not updated correctly. Expected " + expectedHP
							+ " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testHeroAttackCoverDown() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		firstTeam.get(2);

		secondTeam.get(0);
		secondTeam.get(1);
		secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1, new Point(1, 1));
		boardGame[1][1] = champ1;

		Constructor<?> constructor = Class.forName(coverPath).getConstructor(int.class, int.class);
		Object cover = constructor.newInstance(0, 1);
		boardGame[0][1] = cover;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(firstTeam.get(0), r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ1);

				try {
					Method m5 = cover.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(cover);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "DOWN"));
					int newHP = (Integer) m5.invoke(cover);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ1);

					int expectedHP = oldHP - attackDamage;

					assertTrue("The HP of the attacked cover is not updated correctly. Expected " + expectedHP
							+ " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testHeroAttackCoverRight() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		firstTeam.get(2);

		secondTeam.get(0);
		secondTeam.get(1);
		secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1, new Point(1, 1));
		boardGame[1][1] = champ1;

		Constructor<?> constructor = Class.forName(coverPath).getConstructor(int.class, int.class);
		Object cover = constructor.newInstance(1, 2);
		boardGame[1][2] = cover;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(firstTeam.get(0), r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ1);

				try {
					Method m5 = cover.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(cover);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "RIGHT"));
					int newHP = (Integer) m5.invoke(cover);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ1);

					int expectedHP = oldHP - attackDamage;

					assertTrue("The HP of the attacked cover is not updated correctly. Expected " + expectedHP
							+ " but was " + newHP + ".", newHP == expectedHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testRemoveCoverAfterAttack() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		firstTeam.get(2);

		secondTeam.get(0);
		secondTeam.get(1);
		secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1, new Point(1, 1));
		boardGame[1][1] = champ1;

		Constructor<?> constructor = Class.forName(coverPath).getConstructor(int.class, int.class);
		Object cover = constructor.newInstance(0, 1);
		boardGame[0][1] = cover;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		int attackDamageRandom = r.nextInt(50) + 1;
		setAttackDamage.invoke(firstTeam.get(0), attackDamageRandom);

		try {

			Method setCurrentHP = cover.getClass().getMethod("setCurrentHP", int.class);
			setCurrentHP.invoke(cover, attackDamageRandom);

		} catch (NoSuchMethodException e) {
			fail("Cover class should have setCurrentHP method");

		}

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ1);

				try {

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "DOWN"));

					Object[][] boardGameUpdated = (Object[][]) getBoardGame.invoke(createdGame);

					assertTrue("Cover should be removed after being attacked if HP reaches 0.",
							boardGameUpdated[0][1] == null);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testRemoveChampionAfterAttack() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		firstTeam.get(2);

		secondTeam.get(0);
		secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1, new Point(1, 1));
		boardGame[1][1] = champ1;

		setLocation.invoke(champ6, new Point(0, 1));
		boardGame[0][1] = champ6;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		int attackDamageRandom = r.nextInt(50) + 1;
		setAttackDamage.invoke(firstTeam.get(0), attackDamageRandom);

		try {

			Method setCurrentHP = champ6.getClass().getMethod("setCurrentHP", int.class);
			setCurrentHP.invoke(champ6, attackDamageRandom);

		} catch (NoSuchMethodException e) {
			fail("Cover class should have setCurrentHP method");

		}

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ1);
				m2.invoke(turnOrder, champ6);

				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if (currentChamp != champ1) {
						setSpeed.invoke(champ1, 2);
						setSpeed.invoke(champ6, 10);

						try {
							Method remove = turnOrder.getClass().getMethod("remove");
							remove.invoke(turnOrder);
							remove.invoke(turnOrder);
							m2.invoke(turnOrder, champ1);
							m2.invoke(turnOrder, champ6);

						} catch (NoSuchMethodException e) {
							fail("Priority Queue class should have remove method");

						}

					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have getCurrentChampion method");

				}

				try {

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "DOWN"));

					Object[][] boardGameUpdated = (Object[][]) getBoardGame.invoke(createdGame);

					assertTrue("Champion should be removed from the board after being attacked if HP reaches 0.",
							boardGameUpdated[0][1] == null);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testAttackedChampionRemovedFromQueue() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		firstTeam.get(2);

		secondTeam.get(0);
		secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1, new Point(1, 1));
		boardGame[1][1] = champ1;

		setLocation.invoke(champ6, new Point(0, 1));
		boardGame[0][1] = champ6;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		int attackDamageRandom = r.nextInt(50) + 1;
		setAttackDamage.invoke(firstTeam.get(0), attackDamageRandom);

		try {

			Method setCurrentHP = champ6.getClass().getMethod("setCurrentHP", int.class);
			setCurrentHP.invoke(champ6, attackDamageRandom);

		} catch (NoSuchMethodException e) {
			fail("Cover class should have setCurrentHP method");

		}

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {
				Method size = turnOrder.getClass().getMethod("size");

				int turnOrderSize = (int) size.invoke(turnOrder);

				try {
					Method remove = turnOrder.getClass().getMethod("remove");
					while (turnOrderSize != 0) {
						remove.invoke(turnOrder);
						turnOrderSize = (int) size.invoke(turnOrder);

					}

					try {

						Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
						m2.invoke(turnOrder, champ1);
						m2.invoke(turnOrder, champ6);

						try {

							Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
							Object currentChamp = getCurrentChampion.invoke(createdGame);
							if (currentChamp != champ1) {
								setSpeed.invoke(champ1, 2);
								setSpeed.invoke(champ6, 10);

								remove.invoke(turnOrder);
								remove.invoke(turnOrder);
								m2.invoke(turnOrder, champ1);
								m2.invoke(turnOrder, champ6);

							}

						} catch (NoSuchMethodException e) {
							fail("Game class should have getCurrentChampion method");

						}

						try {

							Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
							m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "DOWN"));

							m.invoke(createdGame);

							int turnOrderSizeUpdated = (int) size.invoke(turnOrder);

							for (int i = 0; i < turnOrderSizeUpdated; i++) {
								if (remove.invoke(turnOrder) == champ6) {
									fail("Champion should be removed from the turnOrder queue after being attacked if HP reaches 0.");
								}

							}

						} catch (NoSuchMethodException e) {
							fail("Game class should have attack method");
						}
					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have insert method");
					}

				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have remove method");

				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have size method");

			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testAttackedChampionHasShieldEffect() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		Object champ4 = secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ2, new Point(3, 2));
		boardGame[3][2] = champ2;

		setLocation.invoke(champ4, new Point(2, 2));
		boardGame[2][2] = champ4;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ2, r.nextInt(50) + 1);

		try {

			Method getAppliedEffects = champ4.getClass().getMethod("getAppliedEffects");

			ArrayList<Object> champEffects = (ArrayList<Object>) getAppliedEffects.invoke(champ4);

			Constructor<?> constructor = Class.forName(shieldPath).getConstructor(int.class);

			int durationOne = r.nextInt(10);

			Object disarmEffect = constructor.newInstance(durationOne);

			champEffects.add(disarmEffect);

			try {
				Field appliedEffects = champ2.getClass().getSuperclass().getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				appliedEffects.set(champ4, champEffects);
			} catch (NoSuchFieldException e) {
				fail("Champion class should have appliedEffects attribute");

			}
		} catch (NoSuchMethodException e) {
			fail("Champion class should have getAppliedEffects method");

		}

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ1);
				m2.invoke(turnOrder, champ2);
				m2.invoke(turnOrder, champ3);
				m2.invoke(turnOrder, champ4);
				m2.invoke(turnOrder, champ5);
				m2.invoke(turnOrder, champ6);

				try {
					Method m5 = champ1.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(champ4);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "DOWN"));
					int newHP = (Integer) m5.invoke(champ4);

					// Method m4 = champ1.getClass().getMethod("getAttackDamage");
					// int attackDamage = (Integer) m4.invoke(champ2);

					// int extraDamage = (Integer) attackDamage/2;
					// int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue(
							"The HP of the champion should not be affected after attack if the champion has a Shield effect. Expected "
									+ oldHP + " but was " + newHP + ".",
							newHP == oldHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testAttackFirstTarget() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
	
		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		Object champ4 = secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1, new Point(1, 2));
		boardGame[1][2] = champ1;

		Constructor<?> constructor = Class.forName(coverPath).getConstructor(int.class, int.class);
		Object cover = constructor.newInstance(1, 1);
		boardGame[1][1] = cover;

		Object cover2 = constructor.newInstance(1, 0);
		boardGame[1][0] = cover2;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame, boardGame);

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1, 10);

		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(firstTeam.get(0), r.nextInt(50) + 1);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ1);
				m2.invoke(turnOrder, champ2);
				m2.invoke(turnOrder, champ3);
				m2.invoke(turnOrder, champ4);
				m2.invoke(turnOrder, champ5);
				m2.invoke(turnOrder, champ6);

				try {
					Method m5 = cover.getClass().getMethod("getCurrentHP");
					int oldHP = (Integer) m5.invoke(cover2);

					Method m3 = createdGame.getClass().getMethod("attack", Class.forName(directionPath));
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath), "LEFT"));
					int newHP = (Integer) m5.invoke(cover2);

					assertTrue(
							"Only the HP of the first valid target within the attack range should be updated. Expected "
									+ oldHP + " but was " + newHP + ".",
							oldHP == newHP);

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@Test(timeout = 3000)
	public void testEndTurnMethodExists() throws Exception {
		Method[] methods = Class.forName(gamePath).getDeclaredMethods();
		assertTrue("Class Game should contain a method named endTurn.", containsMethodName(methods, "endTurn"));
	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testEndTurnUpdatesTurnOrder() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		Object champ4 = secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {
				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}
				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ1);
				m2.invoke(turnOrder, champ2);
				m2.invoke(turnOrder, champ3);
				m2.invoke(turnOrder, champ4);
				m2.invoke(turnOrder, champ5);
				m2.invoke(turnOrder, champ6);
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}
		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

		try {
			Method m3 = createdGame.getClass().getMethod("endTurn");
			m3.invoke(createdGame);

			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			Method m2 = turnOrder.getClass().getMethod("size");
			int size = (int) m2.invoke(turnOrder);

			assertTrue("The turnOrder is not updated correctly after calling endTurn. Expected size" + 5 + " but was "
					+ size + ".", size == 5);

		} catch (NoSuchMethodException e) {
			fail("Game class should have endTurn method");

		}

	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testEndTurnPreparesChampion() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		firstTeam.get(2);

		secondTeam.get(0);
		secondTeam.get(1);
		secondTeam.get(2);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}
				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ1);

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}
		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

		try {
			Method m3 = createdGame.getClass().getMethod("endTurn");
			m3.invoke(createdGame);

			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			Method m2 = turnOrder.getClass().getMethod("size");
			int size = (int) m2.invoke(turnOrder);

			assertTrue("If turnOrder becomes empty, prepareChampions should be called.", size == 6);

		} catch (NoSuchMethodException e) {
			fail("Game class should have endTurn method");

		}

	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testEndTurnUpdatedCooldown() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		firstTeam.get(2);

		secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}
				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ5);
				m2.invoke(turnOrder, champ6);

				try {
					Method setSpeed = champ5.getClass().getSuperclass().getMethod("setSpeed", int.class);
					try {
						Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
						Object currentChamp = getCurrentChampion.invoke(createdGame);
						if (currentChamp != champ6) {
							setSpeed.invoke(champ6, 2);
							setSpeed.invoke(champ5, 10);

							try {
								Method remove = turnOrder.getClass().getMethod("remove");
								remove.invoke(turnOrder);
								remove.invoke(turnOrder);
								m2.invoke(turnOrder, champ5);
								m2.invoke(turnOrder, champ6);

							} catch (NoSuchMethodException e) {
								fail("Priority Queue class should have remove method");

							}

						}

					} catch (NoSuchMethodException e) {
						fail("Game class should have getCurrentChampion method");

					}

				} catch (NoSuchMethodException e) {
					fail("Champion class should have setSpeed method");

				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}
		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

		try {

			Object healAbility = createHealingAbility("TEAMTARGET");
			Object dmgAbiliy = createDmgAbility("DIRECTIONAL");

			Field cooldown = healAbility.getClass().getSuperclass().getDeclaredField("currentCooldown");
			cooldown.setAccessible(true);

			Random r = new Random();
			int coolDownOne = r.nextInt(1) + 2;
			int coolDownTwo = r.nextInt(1) + 2;

			cooldown.set(healAbility, coolDownOne);
			cooldown.set(dmgAbiliy, coolDownTwo);

			try {
				Method getAbilities = champ1.getClass().getMethod("getAbilities");
				ArrayList<Object> abilities = (ArrayList<Object>) getAbilities.invoke(champ5);
				abilities.add(healAbility);
				abilities.add(dmgAbiliy);

				//
				// try {
				//
				// Method getCurrentChamp =
				// createdGame.getClass().getMethod("getCurrentChampion");
				//
				// Object currentChampion = getCurrentChamp.invoke(createdGame);

				try {

					Field abilitiesField = champ5.getClass().getSuperclass().getDeclaredField("abilities");
					abilitiesField.setAccessible(true);
					abilitiesField.set(champ5, abilities);

					try {
						Method m3 = createdGame.getClass().getMethod("endTurn");
						m3.invoke(createdGame);

						ArrayList<Object> abilitiesUpdated = (ArrayList<Object>) getAbilities.invoke(champ5);
						Object abiltiyOne = abilitiesUpdated.get(0);
						Object abiltiyTwo = abilitiesUpdated.get(1);

						try {

							Method getCurrentCooldown = healAbility.getClass().getMethod("getCurrentCooldown");
							int updatedCooldownOne = (int) getCurrentCooldown.invoke(abiltiyOne);
							int updatedCooldownTwo = (int) getCurrentCooldown.invoke(abiltiyTwo);

							assertTrue("endTurn should update the cooldown of the champion's abilities.",
									updatedCooldownOne == (coolDownOne - 1));

							assertTrue("endTurn should update the cooldown of the champion's abilities.",
									updatedCooldownTwo == (coolDownTwo - 1));
						} catch (NoSuchMethodException e) {

							fail("Ability class should have a getCurrentCooldown method");

						}

					} catch (NoSuchMethodException e) {
						fail("Game class should have endTurn method");

					}
				} catch (NoSuchFieldException e) {
					fail("Champion class should have abilities attribute");

				}

				// } catch (NoSuchMethodException e) {
				// fail("Game class should have getCurrentChampion method");
				//
				// }

			} catch (NoSuchMethodException e) {
				fail("Champion class should have getAbilities method");

			}

		} catch (NoSuchFieldException e) {
			fail("Ability class should have currentCoolDown attribute");

		}

	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testEndTurnUpdatedActionPoints() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		firstTeam.get(2);

		secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}
				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ5);
				m2.invoke(turnOrder, champ6);

				try {
					Method setSpeed = champ5.getClass().getSuperclass().getMethod("setSpeed", int.class);
					try {
						Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
						Object currentChamp = getCurrentChampion.invoke(createdGame);
						if (currentChamp != champ6) {
							setSpeed.invoke(champ6, 2);
							setSpeed.invoke(champ5, 10);

							try {
								Method remove = turnOrder.getClass().getMethod("remove");
								remove.invoke(turnOrder);
								remove.invoke(turnOrder);
								m2.invoke(turnOrder, champ5);
								m2.invoke(turnOrder, champ6);

							} catch (NoSuchMethodException e) {
								fail("Priority Queue class should have remove method");

							}

						}

					} catch (NoSuchMethodException e) {
						fail("Game class should have getCurrentChampion method");

					}

				} catch (NoSuchMethodException e) {
					fail("Champion class should have setSpeed method");

				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}
		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

		try {
			Method getMaxActionPointsPerTurn = champ1.getClass().getMethod("getMaxActionPointsPerTurn");
			int maxActionPoints = (int) getMaxActionPointsPerTurn.invoke(champ5);

			try {
				Method setCurrentActionPoints = champ2.getClass().getSuperclass().getMethod("setCurrentActionPoints",
						int.class);
				setCurrentActionPoints.setAccessible(true);
				setCurrentActionPoints.invoke(champ5, 1);

			} catch (NoSuchMethodException e) {
				fail("Champion class should have setCurrentActionPoints method.");

			}

			try {
				Method m3 = createdGame.getClass().getMethod("endTurn");
				m3.invoke(createdGame);

				try {
					Method getCurrentActionPoints = champ1.getClass().getMethod("getCurrentActionPoints");
					int currentActionPoints = (int) getCurrentActionPoints.invoke(champ5);

					assertTrue("endTurn should reset the currentActionPoints of the current champion.",
							currentActionPoints == maxActionPoints);

				} catch (NoSuchMethodException e) {

					fail("Ability class should have a getCurrentActionPoints method");
				}

			} catch (NoSuchMethodException e) {
				fail("Game class should have endTurn method");

			}

			// } catch (NoSuchMethodException e) {
			// fail("Game class should have getCurrentChampion method");
			//
			// }

		} catch (NoSuchMethodException e) {
			fail("Champion class should have getMaxActionPointsPerTurn method");

		}

	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testEndTurnRemovesExpiredEffects() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		firstTeam.get(2);

		secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have remove method");

					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have size method");

				}

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ5);
				m2.invoke(turnOrder, champ6);

				try {
					Method setSpeed = champ5.getClass().getSuperclass().getMethod("setSpeed", int.class);
					try {
						Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
						Object currentChamp = getCurrentChampion.invoke(createdGame);
						if (currentChamp != champ6) {
							setSpeed.invoke(champ6, 2);
							setSpeed.invoke(champ5, 10);

							try {
								Method remove = turnOrder.getClass().getMethod("remove");
								remove.invoke(turnOrder);
								remove.invoke(turnOrder);
								m2.invoke(turnOrder, champ5);
								m2.invoke(turnOrder, champ6);

							} catch (NoSuchMethodException e) {
								fail("Priority Queue class should have remove method");

							}

						}

					} catch (NoSuchMethodException e) {
						fail("Game class should have getCurrentChampion method");

					}

				} catch (NoSuchMethodException e) {
					fail("Champion class should have setSpeed method");

				}

			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}
		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

		// try {
		//
		// Method getCurrentChamp =
		// createdGame.getClass().getMethod("getCurrentChampion");
		//
		// Object currentChampion = getCurrentChamp.invoke(createdGame);

		try {
			Method getAppliedEffects = champ1.getClass().getMethod("getAppliedEffects");

			ArrayList<Object> champEffects = (ArrayList<Object>) getAppliedEffects.invoke(champ5);

			Constructor<?> constructor = Class.forName(embracePath).getConstructor(int.class);

			Random r = new Random();
			int durationOne = r.nextInt(10) + 2;
			int durationTwo = 1;
			int durationThree = r.nextInt(10) + 2;

			Object embraceEffect = constructor.newInstance(durationOne);

			constructor = Class.forName(powerUpPath).getConstructor(int.class);
			Object powerUpEffect = constructor.newInstance(durationTwo);

			constructor = Class.forName(rootPath).getConstructor(int.class);
			Object rootEffect = constructor.newInstance(durationThree);

			champEffects.add(powerUpEffect);
			champEffects.add(embraceEffect);
			champEffects.add(rootEffect);

			try {
				Field appliedEffects = champ5.getClass().getSuperclass().getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				appliedEffects.set(champ5, champEffects);

				try {

					Method endTurn = createdGame.getClass().getMethod("endTurn");
					endTurn.invoke(createdGame);

					ArrayList<Object> champEffectsUpdated = (ArrayList<Object>) getAppliedEffects.invoke(champ5);

					for (int i = 0; i < champEffectsUpdated.size(); i++) {
						if (champEffectsUpdated.get(i) == powerUpEffect) {
							fail("endTurn should remove any expired effects from the current champion's appliedEffects arraylist.");
						}
					}

				} catch (NoSuchMethodException e) {
					fail("Game class should have endTurn method");

				}

			} catch (NoSuchFieldException e) {

			}

		} catch (NoSuchMethodException e) {
			fail("Champion class should have getAppliedEffects method");

		}

		// } catch (NoSuchMethodException e) {
		// fail("Game class should have getCurrentChampion method");
		//
		// }

	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testEndTurnRemovesChampion() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		firstTeam.get(0);
		firstTeam.get(1);
		firstTeam.get(2);

		secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {
				Method size = turnOrder.getClass().getMethod("size");

				try {
					int turnOrderSize = (int) size.invoke(turnOrder);
					Method remove = turnOrder.getClass().getMethod("remove");

					try {
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

						Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
						m2.invoke(turnOrder, champ5);
						m2.invoke(turnOrder, champ6);

						try {
							Method setSpeed = champ5.getClass().getSuperclass().getMethod("setSpeed", int.class);
							try {
								Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
								Object currentChamp = getCurrentChampion.invoke(createdGame);
								if (currentChamp != champ6) {
									setSpeed.invoke(champ6, 2);
									setSpeed.invoke(champ5, 10);

									remove.invoke(turnOrder);
									remove.invoke(turnOrder);
									m2.invoke(turnOrder, champ5);
									m2.invoke(turnOrder, champ6);

								}

							} catch (NoSuchMethodException e) {
								fail("Game class should have getCurrentChampion method");

							}

						} catch (NoSuchMethodException e) {
							fail("Champion class should have setSpeed method");

						}

						try {
							Method endTurn = createdGame.getClass().getMethod("endTurn");
							endTurn.invoke(createdGame);

							turnOrderSize = (int) size.invoke(turnOrder);

							while (turnOrderSize != 0) {
								Object removedChamp = remove.invoke(turnOrder);
								if (removedChamp == champ6) {
									fail("endTurn should remove the front most champion from turnOrder queue.");

								}
								turnOrderSize = (int) size.invoke(turnOrder);

							}

						} catch (NoSuchMethodException e) {
							fail("Game class should have endTurn method");
						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have insert method");
					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have remove method");

				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have size method");

			}
		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testEndTurnRemovesStunnedChampion() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		firstTeam.get(2);

		Object champ4 = secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {
				Method size = turnOrder.getClass().getMethod("size");

				try {
					int turnOrderSize = (int) size.invoke(turnOrder);
					Method remove = turnOrder.getClass().getMethod("remove");

					try {
						while (turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						}

						try {
							Method setCondition = champ5.getClass().getMethod("setCondition",
									Class.forName(conditionPath));
							setCondition.invoke(champ5,
									Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE"));
							try {

								Method getAppliedEffects = champ5.getClass().getMethod("getAppliedEffects");

								ArrayList<Object> champEffects = (ArrayList<Object>) getAppliedEffects.invoke(champ5);

								Constructor<?> constructor = Class.forName(stunPath).getConstructor(int.class);

								Random r = new Random();
								int durationOne = r.nextInt(10);

								Object stunEffect = constructor.newInstance(durationOne);

								champEffects.add(stunEffect);

								try {
									Field appliedEffects = champ2.getClass().getSuperclass()
											.getDeclaredField("appliedEffects");
									appliedEffects.setAccessible(true);
									appliedEffects.set(champ5, champEffects);
								} catch (NoSuchFieldException e) {
									fail("Champion class should have appliedEffects attribute");

								}
							} catch (NoSuchMethodException e) {
								fail("Champion class should have getAppliedEffects method");

							}
						} catch (NoSuchMethodException e) {
							fail("Champion class should have setCondition method");

						}

						Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
						m2.invoke(turnOrder, champ4);
						m2.invoke(turnOrder, champ5);
						m2.invoke(turnOrder, champ6);

						try {
							Method endTurn = createdGame.getClass().getMethod("endTurn");
							endTurn.invoke(createdGame);

							turnOrderSize = (int) size.invoke(turnOrder);

							while (turnOrderSize != 0) {
								Object removedChamp = remove.invoke(turnOrder);
								if (removedChamp == champ5) {
									fail("endTurn should remove any stunned champions from the turnOrder queue till an active champion is found.");

								}
								turnOrderSize = (int) size.invoke(turnOrder);

							}

						} catch (NoSuchMethodException e) {
							fail("Game class should have endTurn method");
						}

					} catch (NoSuchMethodException e) {
						fail("Priority Queue class should have insert method");
					}
				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have remove method");

				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have size method");

			}
		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testEndTurnUpdatesStunnedChampion() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		firstTeam.get(2);

		Object champ4 = secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {
				Method size = turnOrder.getClass().getMethod("size");

				try {
					int turnOrderSize = (int) size.invoke(turnOrder);
					Method remove = turnOrder.getClass().getMethod("remove");

					while (turnOrderSize != 0) {
						remove.invoke(turnOrder);
						turnOrderSize = (int) size.invoke(turnOrder);

					}

					try {
						Method setCondition = champ5.getClass().getMethod("setCondition", Class.forName(conditionPath));
						setCondition.invoke(champ5,
								Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE"));
						try {

							Method getAppliedEffects = champ5.getClass().getMethod("getAppliedEffects");

							ArrayList<Object> champEffects = (ArrayList<Object>) getAppliedEffects.invoke(champ5);

							Constructor<?> constructor = Class.forName(stunPath).getConstructor(int.class);

							Random r = new Random();
							int durationOne = r.nextInt(10) + 2; 
							System.out.println("duration" + durationOne);

							Object stunEffect = constructor.newInstance(durationOne);

							champEffects.add(stunEffect);

							try {
								Field appliedEffects = champ2.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects.setAccessible(true);
								appliedEffects.set(champ5, champEffects);

								try {

									Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
									m2.invoke(turnOrder, champ4);

									m2.invoke(turnOrder, champ5);
									m2.invoke(turnOrder, champ6);

									try {
										Method getCurrentChampion = createdGame.getClass()
												.getMethod("getCurrentChampion");
										Object currentChamp = getCurrentChampion.invoke(createdGame);
										if (currentChamp != champ6) {

											try {
												Method setSpeed = champ5.getClass().getSuperclass()
														.getMethod("setSpeed", int.class);

												setSpeed.invoke(champ6, 2);
												setSpeed.invoke(champ5, 10);
												setSpeed.invoke(champ4, 20);

												remove.invoke(turnOrder);
												remove.invoke(turnOrder);
												m2.invoke(turnOrder, champ2);
												m2.invoke(turnOrder, champ4);

											} catch (NoSuchMethodException e) {
												fail("Champion class should have setSpeed method");

											}

										}

									} catch (NoSuchMethodException e) {
										fail("Game class should have getCurrentChampion method");

									}

									try {
										Method endTurn = createdGame.getClass().getMethod("endTurn");
										endTurn.invoke(createdGame);

										ArrayList<Object> champEffectsUpdated = (ArrayList<Object>) getAppliedEffects
												.invoke(champ5);

										try {
											Method getDuration = stunEffect.getClass().getMethod("getDuration");

											int updatedDurationOne = (int) getDuration
													.invoke(champEffectsUpdated.get(0));

											assertTrue(
													"endTurn should update the duration of any inactive champion's applied effects.",
													updatedDurationOne == (durationOne - 1));

										} catch (NoSuchMethodException e) {
											fail("Effect class should have getDuration method");

										}

									} catch (NoSuchMethodException e) {
										fail("Game class should have endTurn method");
									}

								} catch (NoSuchMethodException e) {
									fail("Priority Queue class should have insert method");
								}
							} catch (NoSuchFieldException e) {
								fail("Champion class should have appliedEffects attribute");

							}
						} catch (NoSuchMethodException e) {
							fail("Champion class should have getAppliedEffects method");

						}
					} catch (NoSuchMethodException e) {
						fail("Champion class should have setCondition method");

					}

				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have remove method");

				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have size method");

			}
		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testEndTurnUpdatesStunnedChampion2() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		firstTeam.get(2);

		Object champ4 = secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {
				Method size = turnOrder.getClass().getMethod("size");

				try {
					int turnOrderSize = (int) size.invoke(turnOrder);
					Method remove = turnOrder.getClass().getMethod("remove");

					while (turnOrderSize != 0) {
						remove.invoke(turnOrder);
						turnOrderSize = (int) size.invoke(turnOrder);

					}

					try {
						Method setCondition = champ5.getClass().getMethod("setCondition", Class.forName(conditionPath));
						setCondition.invoke(champ5,
								Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE"));
						try {

							Method getAppliedEffects = champ5.getClass().getMethod("getAppliedEffects");

							ArrayList<Object> champEffects = (ArrayList<Object>) getAppliedEffects.invoke(champ5);

							Constructor<?> constructor = Class.forName(stunPath).getConstructor(int.class);

							Random r = new Random();
							int durationOne = r.nextInt(10);

							Object stunEffect = constructor.newInstance(durationOne);

							champEffects.add(stunEffect);

							try {
								Field appliedEffects = champ2.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects.setAccessible(true);
								appliedEffects.set(champ5, champEffects);

								try {

									Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
									m2.invoke(turnOrder, champ4);

									m2.invoke(turnOrder, champ5);
									m2.invoke(turnOrder, champ6);

									try {
										Method getCurrentChampion = createdGame.getClass()
												.getMethod("getCurrentChampion");
										Object currentChamp = getCurrentChampion.invoke(createdGame);
										if (currentChamp != champ6) {

											try {
												Method setSpeed = champ5.getClass().getSuperclass()
														.getMethod("setSpeed", int.class);

												setSpeed.invoke(champ6, 2);
												setSpeed.invoke(champ5, 10);
												setSpeed.invoke(champ4, 20);

												remove.invoke(turnOrder);
												remove.invoke(turnOrder);
												m2.invoke(turnOrder, champ2);
												m2.invoke(turnOrder, champ4);

											} catch (NoSuchMethodException e) {
												fail("Champion class should have setSpeed method");

											}

										}

									} catch (NoSuchMethodException e) {
										fail("Game class should have getCurrentChampion method");

									}

									try {

										Object healAbility = createHealingAbility("TEAMTARGET");
										Object dmgAbiliy = createDmgAbility("DIRECTIONAL");

										Field cooldown = healAbility.getClass().getSuperclass()
												.getDeclaredField("currentCooldown");
										cooldown.setAccessible(true);

										int coolDownOne = r.nextInt(1) + 2;
										int coolDownTwo = r.nextInt(1) + 2;

										cooldown.set(healAbility, coolDownOne);
										cooldown.set(dmgAbiliy, coolDownTwo);

										try {
											Method getAbilities = champ1.getClass().getMethod("getAbilities");
											ArrayList<Object> abilities = (ArrayList<Object>) getAbilities
													.invoke(champ5);
											abilities.add(healAbility);
											abilities.add(dmgAbiliy);

											//
											// try {
											//
											// Method getCurrentChamp =
											// createdGame.getClass().getMethod("getCurrentChampion");
											//
											// Object currentChampion = getCurrentChamp.invoke(createdGame);

											try {

												Field abilitiesField = champ5.getClass().getSuperclass()
														.getDeclaredField("abilities");
												abilitiesField.setAccessible(true);
												abilitiesField.set(champ5, abilities);

												try {
													Method m3 = createdGame.getClass().getMethod("endTurn");
													m3.invoke(createdGame);

													ArrayList<Object> abilitiesUpdated = (ArrayList<Object>) getAbilities
															.invoke(champ5);
													Object abiltiyOne = abilitiesUpdated.get(0);
													Object abiltiyTwo = abilitiesUpdated.get(1);

													try {

														Method getCurrentCooldown = healAbility.getClass()
																.getMethod("getCurrentCooldown");
														int updatedCooldownOne = (int) getCurrentCooldown
																.invoke(abiltiyOne);
														int updatedCooldownTwo = (int) getCurrentCooldown
																.invoke(abiltiyTwo);

														assertTrue(
																"endTurn should update the cooldown of any stunned champion's abilities.",
																updatedCooldownOne == (coolDownOne - 1));

														assertTrue(
																"endTurn should update the cooldown of any stunned champion's abilities.",
																updatedCooldownTwo == (coolDownTwo - 1));
													} catch (NoSuchMethodException e) {

														fail("Ability class should have a getCurrentCooldown method");

													}

												} catch (NoSuchMethodException e) {
													fail("Game class should have endTurn method");

												}
											} catch (NoSuchFieldException e) {
												fail("Champion class should have abilities attribute");

											}

											// } catch (NoSuchMethodException e) {
											// fail("Game class should have getCurrentChampion method");
											//
											// }

										} catch (NoSuchMethodException e) {
											fail("Champion class should have getAbilities method");

										}

									} catch (NoSuchFieldException e) {
										fail("Ability class should have currentCoolDown attribute");

									}

								} catch (NoSuchMethodException e) {
									fail("Priority Queue class should have insert method");
								}
							} catch (NoSuchFieldException e) {
								fail("Champion class should have appliedEffects attribute");

							}
						} catch (NoSuchMethodException e) {
							fail("Champion class should have getAppliedEffects method");

						}
					} catch (NoSuchMethodException e) {
						fail("Champion class should have setCondition method");

					}

				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have remove method");

				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have size method");

			}
		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testEndTurnCallsRemoveEffect() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		firstTeam.get(2);

		secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {
				Method size = turnOrder.getClass().getMethod("size");

				try {
					int turnOrderSize = (int) size.invoke(turnOrder);
					Method remove = turnOrder.getClass().getMethod("remove");

					while (turnOrderSize != 0) {
						remove.invoke(turnOrder);
						turnOrderSize = (int) size.invoke(turnOrder);
					}

					try {
						Method setCondition = champ5.getClass().getMethod("setCondition", Class.forName(conditionPath));
						setCondition.invoke(champ5, Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ROOTED"));
						try {

							Method getAppliedEffects = champ5.getClass().getMethod("getAppliedEffects");

							ArrayList<Object> champEffects = (ArrayList<Object>) getAppliedEffects.invoke(champ5);

							Constructor<?> constructor = Class.forName(speedupPath).getConstructor(int.class);

							new Random();
							int durationOne = 1;

							Object speedUpEffect = constructor.newInstance(durationOne);

							champEffects.add(speedUpEffect);

							try {
								Field appliedEffects = champ2.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects.setAccessible(true);
								appliedEffects.set(champ5, champEffects);

								try {

									Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
									m2.invoke(turnOrder, champ5);
									m2.invoke(turnOrder, champ6);

									try {

										Method getCurrentChampion = createdGame.getClass()
												.getMethod("getCurrentChampion");
										Object currentChamp = getCurrentChampion.invoke(createdGame);
										if (currentChamp != champ6) {

											try {
												Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
												setSpeed.invoke(champ6, 2);
												setSpeed.invoke(champ5, 10);

											} catch (NoSuchMethodException e) {
												fail("Champion class should have setSpeed method");

											}

											remove.invoke(turnOrder);
											remove.invoke(turnOrder);
											m2.invoke(turnOrder, champ5);
											m2.invoke(turnOrder, champ6);

										}

									} catch (NoSuchMethodException e) {
										fail("Game class should have getCurrentChampion method");

									}

									try {
										Method getSpeed = champ5.getClass().getMethod("getSpeed");
										int speed = (int) getSpeed.invoke(champ5);

										try {
											Method getCurrentActionPoint = champ5.getClass()
													.getMethod("getCurrentActionPoints");
											int currentActionPoint = (int) getCurrentActionPoint.invoke(champ5);

											try {

												int newActionPoints = currentActionPoint + 1;

												Field currentActionPointsField = champ2.getClass().getSuperclass()
														.getDeclaredField("currentActionPoints");
												currentActionPointsField.setAccessible(true);
												currentActionPointsField.set(champ5, newActionPoints);

												try {
													Method setSpeed = champ1.getClass().getMethod("setSpeed",
															int.class);
													int newSpeed = (int) (speed * 1.15);
													setSpeed.invoke(champ5, newSpeed);

													Field speedField = champ2.getClass().getSuperclass()
															.getDeclaredField("speed");
													speedField.setAccessible(true);
													speedField.set(champ5, newSpeed);

													try {

														Method endTurn = createdGame.getClass().getMethod("endTurn");
														endTurn.invoke(createdGame);

														int updatedSpeed = (int) getSpeed.invoke(champ5);
														getCurrentActionPoint
																.invoke(champ5);

														// assertTrue("endTurn should update the duration of any
														// inactive champion's applied effects.",
														// updatedActionPoints == (newActionPoints-1));
														assertTrue(
																"endTurn should call the remove method on any expired effects. If it's already called, check the logic of the remove methods of the effects.",
																updatedSpeed == (int) (newSpeed / 1.15));

													} catch (NoSuchMethodException e) {
														fail("Game class should have endTurn method");
													}

												} catch (NoSuchMethodException e) {
													fail("Champion class should have setSpeed method");

												}

											} catch (NoSuchFieldException e) {
												fail("Champion class should have currentActionPoints field.");

											}

										} catch (NoSuchMethodException e) {
											fail("Champion class should have getCurrentActionPoints Method");

										}

									} catch (NoSuchMethodException e) {
										fail("Champion class should have getSpeed Method");

									}

								} catch (NoSuchMethodException e) {
									fail("Priority Queue class should have insert method");
								}
							} catch (NoSuchFieldException e) {
								fail("Champion class should have appliedEffects attribute");

							}
						} catch (NoSuchMethodException e) {
							fail("Champion class should have getAppliedEffects method");

						}
					} catch (NoSuchMethodException e) {
						fail("Champion class should have setCondition method");

					}

				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have remove method");

				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have size method");

			}
		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testEndTurnRemovesStunnedChampionExpiredEffects() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		Object champ1 = firstTeam.get(0);
		
		Object champ4 = secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		try {
			Method m = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {
				Method size = turnOrder.getClass().getMethod("size");

				try {
					int turnOrderSize = (int) size.invoke(turnOrder);
					Method remove = turnOrder.getClass().getMethod("remove");

					while (turnOrderSize != 0) {
						remove.invoke(turnOrder);
						turnOrderSize = (int) size.invoke(turnOrder);

					}
					
					Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
					m2.invoke(turnOrder, champ4);

					m2.invoke(turnOrder, champ5);
					m2.invoke(turnOrder, champ6);


					try {
						Method setSpeed = champ5.getClass().getSuperclass().getMethod("setSpeed", int.class);
						try {
							Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
							Object currentChamp = getCurrentChampion.invoke(createdGame);
							if(currentChamp != champ6) {
								setSpeed.invoke(champ6,2);
								setSpeed.invoke(champ5,10);
								setSpeed.invoke(champ4,50);


								remove.invoke(turnOrder);
								remove.invoke(turnOrder);
								m2.invoke(turnOrder, champ5);
								m2.invoke(turnOrder, champ6);




							}

						} catch (NoSuchMethodException e) {
							fail("Game class should have getCurrentChampion method");

						}

					} catch(NoSuchMethodException e) {
						fail("Champion class should have setSpeed method");

					}

					try {
						Method setCondition = champ5.getClass().getMethod("setCondition", Class.forName(conditionPath));
						setCondition.invoke(champ5,
								Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE"));

						try {
							Method getAppliedEffects = champ1.getClass().getMethod("getAppliedEffects");

							ArrayList<Object> champEffects = (ArrayList<Object>) getAppliedEffects.invoke(champ5);

							Constructor<?> constructor = Class.forName(embracePath).getConstructor( int.class);

							Random r = new Random();
							int durationOne = r.nextInt(10)+2;
							int durationTwo = 1;
							int durationThree = r.nextInt(10)+2;

							Object embraceEffect = constructor.newInstance(durationOne);


							constructor = Class.forName(powerUpPath).getConstructor( int.class);
							Object powerUpEffect =  constructor.newInstance(durationTwo);

							constructor = Class.forName(stunPath).getConstructor( int.class);
							Object stunEffect =  constructor.newInstance(durationThree);

							champEffects.add(powerUpEffect);
							champEffects.add(embraceEffect);
							champEffects.add(stunEffect);

							try {
								Field appliedEffects = champ5.getClass().getSuperclass().getDeclaredField("appliedEffects");
								appliedEffects.setAccessible(true);
								appliedEffects.set(champ5,champEffects);

								try {

									Method endTurn = createdGame.getClass().getMethod("endTurn");
									endTurn.invoke(createdGame);

									ArrayList<Object> champEffectsUpdated = (ArrayList<Object>) getAppliedEffects.invoke(champ5);

									for(int i = 0; i < champEffectsUpdated.size(); i++) {
										if(champEffectsUpdated.get(i) == powerUpEffect) {
											fail("endTurn should remove any expired effects from any stunned champion's appliedEffects arraylist before skipping the stunned champion's turn.");
										}
									}



								} catch(NoSuchMethodException e) {
									fail("Game class should have endTurn method");

								}

							} catch(NoSuchFieldException e) {

							}





						} catch (NoSuchMethodException e) {
							fail("Champion class should have getAppliedEffects method");

						}

					} catch (NoSuchMethodException e) {
						fail("Champion class should have setCondition method");

					}

				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have remove method");

				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have size method");

			}
		} catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 100)
	public void testEndTurnCallsRemoveEffectOnStunnedChampion() throws Exception {

		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);

		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ4 = secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		try {
			Method m= createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);


			try {
				Method size = turnOrder.getClass().getMethod("size");

				try {
					int turnOrderSize = (int) size.invoke(turnOrder);
					Method remove = turnOrder.getClass().getMethod("remove");


					while(turnOrderSize != 0) {
						remove.invoke(turnOrder);
						turnOrderSize = (int) size.invoke(turnOrder);
					} 


					try {
						Method setCondition = champ5.getClass().getMethod("setCondition", Class.forName(conditionPath));
						setCondition.invoke(champ5,  Enum.valueOf((Class<Enum>) Class.forName(conditionPath),"INACTIVE"));
						try {

							Method getAppliedEffects = champ5.getClass().getMethod("getAppliedEffects");

							ArrayList<Object> champEffects = (ArrayList<Object>) getAppliedEffects.invoke(champ5);

							Constructor<?> constructor = Class.forName(speedUpPath).getConstructor( int.class);

							int durationOne = 1;

							Object speedUpEffect = constructor.newInstance(durationOne);
							
							
							constructor = Class.forName(stunPath).getConstructor( int.class);
							Object stunEffect =  constructor.newInstance(5);


							champEffects.add(speedUpEffect);
							champEffects.add(stunEffect);




							try {
								Field appliedEffects = champ2.getClass().getSuperclass().getDeclaredField("appliedEffects");
								appliedEffects.setAccessible(true);
								appliedEffects.set(champ5,champEffects);

								try {

									Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
									m2.invoke(turnOrder, champ4);

									m2.invoke(turnOrder, champ5);
									m2.invoke(turnOrder, champ6);

									try {

										Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
										Object currentChamp = getCurrentChampion.invoke(createdGame);
										if(currentChamp != champ6) {

											try {
												Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
												setSpeed.invoke(champ6,2);
												setSpeed.invoke(champ5,10);
												setSpeed.invoke(champ4,50);


											}catch (NoSuchMethodException e) {
												fail("Champion class should have setSpeed method");

											}

											remove.invoke(turnOrder);
											remove.invoke(turnOrder);
											m2.invoke(turnOrder, champ5);
											m2.invoke(turnOrder, champ6);





										}

									} catch (NoSuchMethodException e) {
										fail("Game class should have getCurrentChampion method");

									}




									try {
										Method getSpeed = champ5.getClass().getMethod("getSpeed");
										int speed = (int) getSpeed.invoke(champ5);

										try {
											Method getCurrentActionPoint = champ5.getClass().getMethod("getCurrentActionPoints");
											int currentActionPoint = (int) getCurrentActionPoint.invoke(champ5);



											try {

												int newActionPoints = currentActionPoint +1;



												Field currentActionPointsField = champ2.getClass().getSuperclass().getDeclaredField("currentActionPoints");
												currentActionPointsField.setAccessible(true);
												currentActionPointsField.set(champ5,newActionPoints);



												try {
													Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
													int newSpeed = (int) (speed * 1.15);
													setSpeed.invoke(champ5,newSpeed);

													Field speedField = champ2.getClass().getSuperclass().getDeclaredField("speed");
													speedField.setAccessible(true);
													speedField.set(champ5,newSpeed);





													try {

														Method endTurn = createdGame.getClass().getMethod("endTurn");
														endTurn.invoke(createdGame);




														int updatedSpeed = (int) getSpeed.invoke(champ5);	
														
														assertTrue("endTurn should call the remove method on any expired effects of the stunned champion before skipping the stunned champion's turn. If it's already called, check the logic of the remove methods of the effects.",
																updatedSpeed == (int)(newSpeed/1.15));





													} catch (NoSuchMethodException e) {
														fail("Game class should have endTurn method");
													}

												}catch (NoSuchMethodException e) {
													fail("Champion class should have setSpeed method");

												}


											} catch (NoSuchFieldException e) {
												fail("Champion class should have currentActionPoints field.");

											}

										}	catch(NoSuchMethodException e) {
											fail("Champion class should have getCurrentActionPoints Method");

										}




									} catch(NoSuchMethodException e) {
										fail("Champion class should have getSpeed Method");

									}



								} catch (NoSuchMethodException e) {
									fail("Priority Queue class should have insert method");
								}	
							} catch (NoSuchFieldException e) {
								fail("Champion class should have appliedEffects attribute");

							}
						} catch (NoSuchMethodException e) {
							fail("Champion class should have getAppliedEffects method");

						} 
					}catch (NoSuchMethodException e) {
						fail("Champion class should have setCondition method");

					} 


				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have remove method");

				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have size method");


			}
		}	catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}





	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicDodgeAttackResources() {
		String champInstance;
		try {

			Constructor<?> constructorFirstPlayer = Class.forName(playerPath)
					.getConstructor(String.class);
			Constructor<?> constructorSecondPlayer = Class.forName(playerPath)
					.getConstructor(String.class);
			int randomName1 = (int) (Math.random() * 10) + 1;
			int randomName2 = (int) (Math.random() * 10) + 1;
			Object firstPlayer = null;
			Object secondPlayer = null;
			try {
				firstPlayer = constructorFirstPlayer.newInstance("Name_"
						+ randomName1);
				secondPlayer = constructorSecondPlayer.newInstance("Name_"
						+ randomName2);

			} catch (InvocationTargetException e1) {
				assertTrue("Objects of type \"Player\" can be instantiated.",
						false);

				e1.printStackTrace();
			}
			Constructor<?> gameConstructor = Class.forName(gamePath)
					.getConstructor(Class.forName(playerPath),
							Class.forName(playerPath));
			Object createdGame = null;
			try {
				createdGame = gameConstructor.newInstance(firstPlayer,
						secondPlayer);
			} catch (InvocationTargetException e1) {
				assertTrue(e1.getCause()
						+ " occurred while creating an instance of \"Game\".",
						false);

				e1.printStackTrace();
			}

			ArrayList<Object> firstPlayerChamp1 = new ArrayList<>();
			ArrayList<Object> secPlayerChamp1 = new ArrayList<>();

			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;
			Constructor<?> constructorChampion = Class.forName(champInstance)
					.getConstructor(String.class, int.class, int.class,
							int.class, int.class, int.class, int.class);

			Object champPlayer1 = null;

			try {
				champPlayer1 = constructorChampion.newInstance("ironman", 1, 5,
						3, 5, 2, 6);
			} catch (InstantiationException | InvocationTargetException e) {
				assertTrue("Objects of type \""
						+ Class.forName(champInstance).getSimpleName()
						+ "\" can be instantiated.", false);
			}

			Object champPlayer2 = null;

			try {
				champPlayer2 = constructorChampion.newInstance("loki", 100, 5,
						3, 4, 5, 6);
			} catch (InstantiationException | InvocationTargetException e) {
				assertTrue("Objects of type \""
						+ Class.forName(champInstance).getSimpleName()
						+ "\" can be instantiated.", false);
			}

			Class<?> cham1 = Class.forName(championPath);
			Field location = cham1.getDeclaredField("location");
			location.setAccessible(true);
			Point p1 = new Point(2, 2);
			location.set(champPlayer1, p1);
			firstPlayerChamp1.add(champPlayer1);
			Class<?> curr = firstPlayer.getClass();
			Field f = curr.getDeclaredField("team");
			f.setAccessible(true);
			f.set(firstPlayer, firstPlayerChamp1);

			Class<?> cham2 = Class.forName(championPath);
			Field location2 = cham2.getDeclaredField("location");
			location2.setAccessible(true);
			Point p2 = new Point(2, 3);
			location.set(champPlayer2, p2);
			secPlayerChamp1.add(champPlayer2);

			curr = secondPlayer.getClass();
			f = curr.getDeclaredField("team");
			f.setAccessible(true);
			f.set(secondPlayer, secPlayerChamp1);
			Method getBoardGame = createdGame.getClass().getMethod("getBoard");
			Object[][] boardGame = null;
			try {
				boardGame = (Object[][]) getBoardGame.invoke(createdGame);
			} catch (InvocationTargetException e1) {
				assertTrue(
						e1.getCause()
								+ " occurred while invoking \"getBoard\" method on an instance of \"Game\".",
						false);

				e1.printStackTrace();
			}

			boardGame[2][2] = champPlayer1;

			boardGame[2][3] = champPlayer2;

			Field board = createdGame.getClass().getDeclaredField("board");
			board.setAccessible(true);
			board.set(createdGame, boardGame);
			Constructor<?> constructorDodge = Class.forName(DodgePath)
					.getConstructor(int.class);

			Object dodge = null;
			try {
				dodge = constructorDodge
						.newInstance((int) (Math.random() * 10) + 1);
			} catch (InvocationTargetException e) {

				assertTrue("Objects of type \"Dodge\" can be instantiated.",
						false);

				e.printStackTrace();
			}

			Field queue = Class.forName(gamePath).getDeclaredField("turnOrder");
			queue.setAccessible(true);
			Constructor<?> pQueueConst = Class.forName(priorityQueuePath)
					.getConstructor(int.class);

			Object pQueue = null;
			try {
				pQueue = pQueueConst.newInstance(6);
			} catch (InvocationTargetException e) {
				assertTrue(
						"Objects of type \"PriorityQueue\" can be instantiated.",
						false);

				e.printStackTrace();
			}
			Method insert = Class.forName(priorityQueuePath).getDeclaredMethod(
					"insert", Comparable.class);
			try {
				insert.invoke(pQueue, champPlayer1);
				insert.invoke(pQueue, champPlayer2);
				queue.set(createdGame, pQueue);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"insert\" method on an instance of \"PriorityQueue\".",
						false);

				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				fail("\"insert\" in \"PriorityQueue\" class takes a \"Comparable\" object.");
			}

			Method peek = Class.forName(priorityQueuePath).getDeclaredMethod(
					"peekMin");
			Object target = null;
			try {
				target = peek.invoke(pQueue);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"peekMin\" method on an instance of \"PriorityQueue\".",
						false);

				e.printStackTrace();
			}
			Method remove = Class.forName(priorityQueuePath).getDeclaredMethod(
					"remove");
			Object enemy = null;
			try {
				remove.invoke(pQueue);
				enemy = remove.invoke(pQueue);
				if (enemy.getClass().equals(Class.forName(antiHeroPath))
						|| (enemy.getClass().equals(Class.forName(heroPath)))
						|| (enemy.getClass().equals(Class.forName(villainPath)))) {
					Class<?> enemyEffect = Class.forName(championPath);
					Field appliedEffects = enemyEffect
							.getDeclaredField("appliedEffects");
					appliedEffects.setAccessible(true);
					((ArrayList<Object>) appliedEffects.get(enemy)).add(dodge);

				}
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"remove\" method on an instance of \"PriorityQueue\".",
						false);

				e.printStackTrace();
			}

			Method m3 = createdGame.getClass().getMethod("attack",
					Class.forName(directionPath));

			target.getClass().getSimpleName();
			Field locationTarget = Class.forName(championPath)
					.getDeclaredField("location");
			locationTarget.setAccessible(true);
			Point locationT = (Point) locationTarget.get(target);

			target.getClass().getMethod("getCurrentHP");
			Method m6 = enemy.getClass().getMethod("getCurrentHP");

			int before = 0;
			int actions = 0;
			try {
				before = (Integer) m6.invoke(enemy);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"getCurrentHP\" method on an instance of \""
								+ enemy.getClass().getSimpleName() + "\".",
						false);

				e.printStackTrace();
			}
			try {
				insert.invoke(pQueue, target);
				insert.invoke(pQueue, enemy);
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"insert\" method on an instance of \"PriorityQueue\".",
						false);
				e.printStackTrace();
			}
			int size = (int) (Math.random() * 100) + 10;
			Field HP = Class.forName(championPath)
					.getDeclaredField("currentHP");
			Field damage = Class.forName(championPath).getDeclaredField(
					"attackDamage");
			Field action = Class.forName(championPath).getDeclaredField(
					"currentActionPoints");
			HP.setAccessible(true);
			damage.setAccessible(true);
			action.setAccessible(true);
			actions = (int) action.get(target);
			int expected = actions-2;
			
			for (int i = 0; i < size; i++) {
				int after = 0;
				damage.get(target);

				HP.set(enemy, before);

				action.set(target, actions);

				if (locationT.y == 3) {
					try {

						m3.invoke(createdGame, Enum.valueOf(
								(Class<Enum>) Class.forName(directionPath),
								"LEFT"));
					} catch (InvocationTargetException e) {
						assertTrue(
								e.getCause()
										+ " occurred while invoking \"attack\" method on an instance of \"Game\".",
								false);

						e.printStackTrace();
					}

				} else {
					try {
						m3.invoke(createdGame, Enum.valueOf(
								(Class<Enum>) Class.forName(directionPath),
								"RIGHT"));
					} catch (InvocationTargetException e) {
						assertTrue(
								e.getCause()
										+ " occurred while invoking \"attack\" method on an instance of \"Game\".",
								false);

						e.printStackTrace();
					}
				}

				try {
					after = (Integer) m6.invoke(enemy);
				} catch (InvocationTargetException e) {
					assertTrue(
							e.getCause()
									+ " occurred while invoking \"getCurrentHP\" method on an instance of \""
									+ enemy.getClass().getSimpleName() + "\".",
							false);

					e.printStackTrace();
				}
				if (after != before) {
					int actual = (int) action.get(target);
					assertEquals("The method \"" + "attack" + "\" in class "
						+ createdGame.getClass().getSimpleName()
						+ " should set the correct value of variable \""
						+ "currentActionPoints" + "\". If a champion attacks a target with a dodge effect that is successfully applied to the attack and the attack is blocked, all required resources for this attack should be deducted from the champion.", expected,actual);
				}
				else {
					int actual = (int) action.get(target);
					assertEquals("The method \"" + "attack" + "\" in class "
						+ createdGame.getClass().getSimpleName()
						+ " should set the correct value of variable \""
						+ "currentActionPoints\" after a successful attack performed on a target with a dodge effect that is not successfully applied to the attack.", expected,actual);
			
					
				}

			}

		} catch (InstantiationException e) {
			assertTrue(e.getClass().getName() + " occurred.", false);
		}

		catch (NoSuchMethodException e) {

			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}

		catch (ClassNotFoundException e) {

			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);

		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);

		}

	}


	///////////////////////////// Helpers/////////////////////////////////////////////////////////////


	private Object createDmgAbility(String areaOfEffect) {
		try {
			Constructor<?> dmgAbilityConstructor = Class.forName(dmgPath).getConstructor(String.class, int.class,
					int.class, int.class, Class.forName(areaOfEffectPath), int.class, int.class);
			Class<?> c = Class.forName(areaOfEffectPath);

			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, areaOfEffect);
			Object dmgAbility = dmgAbilityConstructor.newInstance("Shield throw", 140, 4, 2, value, 2, 150);
			return dmgAbility;

		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | InstantiationException e) {
			 
			fail(e.getClass() + " occurred");
		}

		return null;
	}

	// ----------Helper Methods-------------------

	private ArrayList<Object> createGameAndTeams() {
		try {
			Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
			Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
			Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
			Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");
			Constructor<?> gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
					Class.forName(playerPath));
			ArrayList<Object> firstPlayerChamp1 = new ArrayList<>();

			Constructor<?> constructorHero = Class.forName(heroPath).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			Constructor<?> constructorAntiHero = Class.forName(antiHeroPath).getConstructor(String.class, int.class,
					int.class, int.class, int.class, int.class, int.class);

			Constructor<?> constructorVillain = Class.forName(villainPath).getConstructor(String.class, int.class,
					int.class, int.class, int.class, int.class, int.class);

			try {
				Object champ1 = constructorHero.newInstance("ironman", 1, 2, 3, 1, 2, 6);
				Object champ2 = constructorAntiHero.newInstance("deadpool", 1, 2, 2, 2, 5, 6);
				Object champ3 = constructorVillain.newInstance("yellow jacket", 1, 2, 3, 3, 5, 6);

				firstPlayerChamp1.add(champ1);
				firstPlayerChamp1.add(champ2);
				firstPlayerChamp1.add(champ3);
				@SuppressWarnings("rawtypes")
				Class curr = firstPlayer.getClass();
				Field f = curr.getDeclaredField("team");
				f.setAccessible(true);
				f.set(firstPlayer, firstPlayerChamp1);

				// Create secondPlayer team

				ArrayList<Object> secPlayerChamp1 = new ArrayList<>();

				Object champ4 = constructorVillain.newInstance("loki", 100, 2, 3, 4, 5, 6);
				Object champ5 = constructorAntiHero.newInstance("ghost rider", 100, 2, 5, 5, 5, 6);
				Object champ6 = constructorHero.newInstance("thor", 100, 2, 3, 6, 5, 6);

				secPlayerChamp1.add(champ4);
				secPlayerChamp1.add(champ5);
				secPlayerChamp1.add(champ6);

				curr = secondPlayer.getClass();
				f = curr.getDeclaredField("team");
				f.setAccessible(true);
				f.set(secondPlayer, secPlayerChamp1);

				ArrayList<Object> returnedObjects = new ArrayList<Object>();

				Object createdGame = gameConstructor.newInstance(firstPlayer, secondPlayer);

				returnedObjects.add(createdGame);
				returnedObjects.add(firstPlayerChamp1);
				returnedObjects.add(secPlayerChamp1);
				return returnedObjects;

			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchFieldException e) {
				e.printStackTrace();
			}

		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}

	private ArrayList<Object> createGameAndTeamsScenario2() {
		try {
			Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
			Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
			Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
			Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");
			Constructor<?> gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
					Class.forName(playerPath));
			ArrayList<Object> firstPlayerChamp1 = new ArrayList<>();

			Constructor<?> constructorHero = Class.forName(heroPath).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			Constructor<?> constructorAntiHero = Class.forName(antiHeroPath).getConstructor(String.class, int.class,
					int.class, int.class, int.class, int.class, int.class);

			Constructor<?> constructorVillain = Class.forName(villainPath).getConstructor(String.class, int.class,
					int.class, int.class, int.class, int.class, int.class);

			try {
				Object champ1 = constructorHero.newInstance("ironman", 1, 2, 3, 7, 2, 6);
				Object champ2 = constructorAntiHero.newInstance("deadpool", 1, 2, 2, 2, 5, 6);
				Object champ3 = constructorVillain.newInstance("yellow jacket", 1, 2, 3, 3, 5, 6);

				firstPlayerChamp1.add(champ1);
				firstPlayerChamp1.add(champ2);
				firstPlayerChamp1.add(champ3);
				@SuppressWarnings("rawtypes")
				Class curr = firstPlayer.getClass();
				Field f = curr.getDeclaredField("team");
				f.setAccessible(true);
				f.set(firstPlayer, firstPlayerChamp1);

				// Create secondPlayer team

				ArrayList<Object> secPlayerChamp1 = new ArrayList<>();

				Object champ4 = constructorVillain.newInstance("loki", 100, 2, 3, 4, 5, 6);
				Object champ5 = constructorAntiHero.newInstance("ghost rider", 100, 2, 5, 5, 5, 6);
				Object champ6 = constructorHero.newInstance("thor", 100, 2, 3, 6, 5, 6);

				secPlayerChamp1.add(champ4);
				secPlayerChamp1.add(champ5);
				secPlayerChamp1.add(champ6);

				curr = secondPlayer.getClass();
				f = curr.getDeclaredField("team");
				f.setAccessible(true);
				f.set(secondPlayer, secPlayerChamp1);

				ArrayList<Object> returnedObjects = new ArrayList<Object>();

				Object createdGame = gameConstructor.newInstance(firstPlayer, secondPlayer);

				returnedObjects.add(createdGame);
				returnedObjects.add(firstPlayerChamp1);
				returnedObjects.add(secPlayerChamp1);
				return returnedObjects;

			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchFieldException e) {
				e.printStackTrace();
			}

		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}

	private ArrayList<Object> createGameAndTeamsScenario4() {
		try {
			Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
			Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
			Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
			Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");
			Constructor<?> gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
					Class.forName(playerPath));
			ArrayList<Object> firstPlayerChamp1 = new ArrayList<>();

			Constructor<?> constructorHero = Class.forName(heroPath).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			Constructor<?> constructorAntiHero = Class.forName(antiHeroPath).getConstructor(String.class, int.class,
					int.class, int.class, int.class, int.class, int.class);

			Constructor<?> constructorVillain = Class.forName(villainPath).getConstructor(String.class, int.class,
					int.class, int.class, int.class, int.class, int.class);

			try {
				Object champ1 = constructorAntiHero.newInstance("ironman", 1, 2, 3, 7, 2, 6);
				Object champ2 = constructorAntiHero.newInstance("deadpool", 1, 2, 2, 2, 5, 6);
				Object champ3 = constructorAntiHero.newInstance("yellow jacket", 1, 2, 3, 8, 5, 6);

				firstPlayerChamp1.add(champ1);
				firstPlayerChamp1.add(champ2);
				firstPlayerChamp1.add(champ3);
				@SuppressWarnings("rawtypes")
				Class curr = firstPlayer.getClass();
				Field f = curr.getDeclaredField("team");
				f.setAccessible(true);
				f.set(firstPlayer, firstPlayerChamp1);

				ArrayList<Object> secPlayerChamp1 = new ArrayList<>();

				Object champ4 = constructorVillain.newInstance("loki", 100, 2, 3, 4, 5, 6);
				Object champ5 = constructorAntiHero.newInstance("ghost rider", 100, 2, 5, 5, 5, 6);
				Object champ6 = constructorHero.newInstance("thor", 100, 2, 3, 6, 5, 6);

				secPlayerChamp1.add(champ4);
				secPlayerChamp1.add(champ5);
				secPlayerChamp1.add(champ6);

				curr = secondPlayer.getClass();
				f = curr.getDeclaredField("team");
				f.setAccessible(true);
				f.set(secondPlayer, secPlayerChamp1);

				ArrayList<Object> returnedObjects = new ArrayList<Object>();

				Object createdGame = gameConstructor.newInstance(firstPlayer, secondPlayer);

				returnedObjects.add(createdGame);
				returnedObjects.add(firstPlayerChamp1);
				returnedObjects.add(secPlayerChamp1);
				return returnedObjects;

			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchFieldException e) {
				e.printStackTrace();
			}

		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}

	private ArrayList<Object> createGameAndTeamsScenario3() {
		try {
			Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
			Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
			Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
			Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");
			Constructor<?> gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
					Class.forName(playerPath));
			ArrayList<Object> firstPlayerChamp1 = new ArrayList<>();

			Constructor<?> constructorHero = Class.forName(heroPath).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			Constructor<?> constructorAntiHero = Class.forName(antiHeroPath).getConstructor(String.class, int.class,
					int.class, int.class, int.class, int.class, int.class);

			Constructor<?> constructorVillain = Class.forName(villainPath).getConstructor(String.class, int.class,
					int.class, int.class, int.class, int.class, int.class);

			try {
				Object champ1 = constructorVillain.newInstance("ironman", 100, 2, 3, 7, 2, 6);
				Object champ2 = constructorVillain.newInstance("deadpool", 100, 2, 2, 2, 5, 6);
				Object champ3 = constructorVillain.newInstance("yellow jacket", 100, 2, 3, 8, 5, 6);
				Method setCurHP = champ1.getClass().getMethod("setCurrentHP", int.class);
				setCurHP.invoke(champ1, 20);

				firstPlayerChamp1.add(champ1);
				firstPlayerChamp1.add(champ2);
				firstPlayerChamp1.add(champ3);
				@SuppressWarnings("rawtypes")
				Class curr = firstPlayer.getClass();
				Field f = curr.getDeclaredField("team");
				f.setAccessible(true);
				f.set(firstPlayer, firstPlayerChamp1);

				ArrayList<Object> secPlayerChamp1 = new ArrayList<>();

				Object champ4 = constructorVillain.newInstance("loki", 100, 2, 3, 4, 5, 6);
				Object champ5 = constructorAntiHero.newInstance("ghost rider", 100, 2, 5, 5, 5, 6);
				Object champ6 = constructorHero.newInstance("thor", 100, 2, 3, 6, 5, 6);

				setCurHP.invoke(champ4, 20);
				setCurHP.invoke(champ5, 25);
				setCurHP.invoke(champ6, 31);

				secPlayerChamp1.add(champ4);
				secPlayerChamp1.add(champ5);
				secPlayerChamp1.add(champ6);

				curr = secondPlayer.getClass();
				f = curr.getDeclaredField("team");
				f.setAccessible(true);
				f.set(secondPlayer, secPlayerChamp1);

				ArrayList<Object> returnedObjects = new ArrayList<Object>();

				Object createdGame = gameConstructor.newInstance(firstPlayer, secondPlayer);

				returnedObjects.add(createdGame);
				returnedObjects.add(firstPlayerChamp1);
				returnedObjects.add(secPlayerChamp1);
				return returnedObjects;

			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchFieldException e) {
				e.printStackTrace();
			}

		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}

	private boolean isPositive(int i) {
		return i > 0 ? true : false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void testExistsInClass(Class aClass, String methodName, boolean implementedMethod, Class returnType,
			Class... inputTypes) {

		Method[] methods = aClass.getDeclaredMethods();

		if (implementedMethod) {
			assertTrue("The " + methodName + " method in class " + aClass.getSimpleName() + " should be implemented.",
					containsMethodName(methods, methodName));
		} else {
			assertFalse(
					"The " + methodName + " method in class " + aClass.getSimpleName()
							+ " should not be implemented, only inherited from super class.",
					containsMethodName(methods, methodName));
			return;
		}
		Method m = null;
		boolean found = true;
		try {
			m = aClass.getDeclaredMethod(methodName, inputTypes);
		} catch (Exception e) {
			found = false;
		}

		String inputsList = "";
		for (Class inputType : inputTypes) {
			inputsList += inputType.getSimpleName() + ", ";
		}
		if (inputsList.equals(""))
			assertTrue(
					aClass.getSimpleName() + " class should have " + methodName + " method that takes no parameters.",
					found);
		else {
			if (inputsList.charAt(inputsList.length() - 1) == ' ')
				inputsList = inputsList.substring(0, inputsList.length() - 2);
			assertTrue(aClass.getSimpleName() + " class should have " + methodName + " method that takes " + inputsList
					+ " parameter(s).", found);
		}

		assertTrue("incorrect return type for " + methodName + " method in " + aClass.getSimpleName() + ".",
				m.getReturnType().equals(returnType));

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })

	private void testConstructorExists(Class aClass, Class[] inputs) {
		boolean thrown = false;
		try {
			aClass.getConstructor(inputs);
		} catch (NoSuchMethodException e) {
			thrown = true;
		}

		if (inputs.length > 0) {
			String msg = "";
			int i = 0;
			do {
				msg += inputs[i].getSimpleName() + " and ";
				i++;
			} while (i < inputs.length);

			msg = msg.substring(0, msg.length() - 4);

			assertFalse(
					"Missing constructor with " + msg + " parameter" + (inputs.length > 1 ? "s" : "") + " in "
							+ aClass.getSimpleName() + " class.",

					thrown);
		} else
			assertFalse("Missing constructor with zero parameters in " + aClass.getSimpleName() + " class.",

					thrown);

	}

	@SuppressWarnings({ "rawtypes" })

	private void testConstructorInitialization(Object createdObject, String[] names, Object[] values)
			throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException {

		for (int i = 0; i < names.length; i++) {

			Field f = null;
			Class curr = createdObject.getClass();
			String currName = names[i];
			Object currValue = values[i];

			while (f == null) {

				if (curr == Object.class)
					fail("Class " + createdObject.getClass().getSimpleName() + " should have the instance variable \""
							+ currName + "\".");
				try {
					f = curr.getDeclaredField(currName);
				} catch (NoSuchFieldException e) {
					curr = curr.getSuperclass();
				}

			}

			f.setAccessible(true);

			assertEquals(
					"The constructor of the " + createdObject.getClass().getSimpleName()
							+ " class should initialize the instance variable \"" + currName + "\" correctly.",
					currValue, f.get(createdObject));

		}

	}

	@SuppressWarnings({ "rawtypes" })

	private void testClassIsSubclass(Class subClass, Class superClass) {
		assertEquals(subClass.getSimpleName() + " class should be a subclass from " + superClass.getSimpleName() + ".",
				superClass, subClass.getSuperclass());
	}

	private void compareToCheck() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		@SuppressWarnings("rawtypes")
		Class c = Class.forName(heroPath);
		@SuppressWarnings("rawtypes")
		Class[] args = new Class[7];
		args[0] = String.class;
		args[1] = int.class;
		args[2] = int.class;
		args[3] = int.class;
		args[4] = int.class;
		args[5] = int.class;
		args[6] = int.class;
		@SuppressWarnings("unchecked")
		Object h = c.getConstructor(args)
				.newInstance(new Object[] { (String) "hero2", (int) 1, (int) 2, (int) 3, (int) 4, // speed
						(int) 5, (int) 6 });

		@SuppressWarnings("unchecked")
		Object h2 = c.getConstructor(args)
				.newInstance(new Object[] { (String) "hero1", (int) 1, (int) 2, (int) 3, (int) 14, // speed
						(int) 15, (int) 6 });
		Method compareTo = h.getClass().getMethod("compareTo", Object.class);
		int r = (int) compareTo.invoke(h, h2);
		assertTrue(
				"Champion compareTo Method should return a positive number when current hero is faster than specified hero",
				isPositive(r));

		Method setSpeed = h.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(h, 14);
		setSpeed.invoke(h2, 4);
		r = (int) compareTo.invoke(h, h2);
		assertFalse(
				"Champion compareTo Method should return a negative number when specified hero is faster than current hero",
				isPositive(r));

		setSpeed.invoke(h, 4);
		r = (int) compareTo.invoke(h, h2);
		assertTrue(
				"Champion compareTo Method should compare lexiographically by name if both champions have the same speed",
				isPositive(r));

	}

	private int setRandomMana(Object champ) {
		Method m;

		try {
			int randomMana = (int) (Math.random() * 200) + 100;

			m = champ.getClass().getMethod("setMana", int.class);
			m.invoke(champ, randomMana);

			return randomMana;

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e1) {

			fail(e1.getClass() + " occurred while updating champion's mana");
			return 0;
		}
	}

	private int setRandomActionPoints(Object champ) {
		Method m;

		try {
			int randomMana = (int) (Math.random() * 200) + 100;

			m = champ.getClass().getMethod("setCurrentActionPoints", int.class);
			m.invoke(champ, randomMana);

			return randomMana;

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e1) {

			fail(e1.getClass() + " occurred while updating champion's mana");
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	private boolean containsEffect(Object champ, Object effect, boolean checkContains) {
		Method m, m2;
		try {
			m = champ.getClass().getMethod("getAppliedEffects");
			ArrayList<Object> effects = (ArrayList<Object>) (m.invoke(champ));
			if (effects.contains(effect))
				fail("Casting CC ability should apply a copy of the effect on the valid targets, not the effect itself.");
			boolean found = false;
			for (int i = 0; i < effects.size(); i++) {
				if (effects.get(i).getClass().equals(effect.getClass()))
					found = true;
			}
			m = effect.getClass().getMethod("getName");
			if (!found && checkContains)
				fail("Casting CC ability should apply " + m.invoke(effect)
						+ " effect on the valid targets but it's not found in the applied effects");

			boolean foundEqual = false;
			for (int i = 0; i < effects.size(); i++) {

				m = effect.getClass().getMethod("getName");
				m2 = effects.get(i).getClass().getMethod("getName");

				if (m.invoke(effect).equals(m2.invoke(effects.get(i)))) {
					m = effect.getClass().getMethod("getDuration");
					m2 = effects.get(i).getClass().getMethod("getDuration");

					if (m.invoke(effect).equals(m2.invoke(effects.get(i)))) {
						m = effect.getClass().getMethod("getType");
						m2 = effects.get(i).getClass().getMethod("getType");
						if (m.invoke(effect).equals(m2.invoke(effects.get(i)))) {
							foundEqual = true;

						}
					}
				}
			}
			return foundEqual;
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred while trying loop over applied effects arraylist");
		}
		return false;
	}

	private Object returnUpDirection() {
		Class<?> c;
		try {
			c = Class.forName(directionPath);
			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, "UP");
			return value;
		} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {

			e.printStackTrace();
			return null;
		}

	}

	private Object returnDownDirection() {
		Class<?> c;
		try {
			c = Class.forName(directionPath);
			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, "DOWN");
			return value;
		} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {

			e.printStackTrace();
			return null;
		}

	}

	private Object returnRightDirection() {
		Class<?> c;
		try {
			c = Class.forName(directionPath);
			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, "RIGHT");
			return value;
		} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {

			e.printStackTrace();
			return null;
		}

	}

	private Object returnLeftDirection() {
		Class<?> c;
		try {
			c = Class.forName(directionPath);
			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, "LEFT");
			return value;
		} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {

			e.printStackTrace();
			return null;
		}

	}

	private void setLocationForObject(Object obj, int x, int y) {
		Method m;
		try {
			m = obj.getClass().getMethod("setLocation", Point.class);
			m.invoke(obj, new Point(x, y));
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred while getting HP");
		}
	}

	@SuppressWarnings("unchecked")
	private ArrayList<Object> createFirstPlayerTeam(Object firstPlayer, boolean includCurrentChamp, Object champ) {
		Object champ2 = createRandomAntiHero();
		Object champ3 = createRandomVillain();
		Object champ4 = createRandomHero();

		Method m;
		try {
			m = firstPlayer.getClass().getMethod("getTeam");
			if (includCurrentChamp)
				((ArrayList<Object>) (m.invoke(firstPlayer))).add(champ);
			else
				((ArrayList<Object>) (m.invoke(firstPlayer))).add(champ4);
			((ArrayList<Object>) (m.invoke(firstPlayer))).add(champ2);
			((ArrayList<Object>) (m.invoke(firstPlayer))).add(champ3);

			return (ArrayList<Object>) (m.invoke(firstPlayer));
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private ArrayList<Object> createSecondPlayerTeam(Object secondPlayer, boolean includCurrentChamp, Object champ) {
		Object champ4 = createRandomAntiHero();
		Object champ5 = createRandomVillain();
		Object champ6 = createRandomHero();
		Method m;

		try {
			m = secondPlayer.getClass().getMethod("getTeam");
			if (includCurrentChamp)
				((ArrayList<Object>) (m.invoke(secondPlayer))).add(champ);
			else
				((ArrayList<Object>) (m.invoke(secondPlayer))).add(champ4);

			((ArrayList<Object>) (m.invoke(secondPlayer))).add(champ5);
			((ArrayList<Object>) (m.invoke(secondPlayer))).add(champ6);
			return (ArrayList<Object>) (m.invoke(secondPlayer));

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	private int returnHp(Object obj) {
		Method m;
		try {
			m = obj.getClass().getMethod("getCurrentHP");
			return (int) m.invoke(obj);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred while getting HP");
			return 0;
		}

	}

	private int returnMaxHp(Object obj) {
		Method m;
		try {
			m = obj.getClass().getMethod("getMaxHP");
			return (int) m.invoke(obj);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred while getting MaxHP");
			return 0;
		}

	}

	private void setObjectHP(Object obj, int newHp) {
		Method m;
		try {
			m = obj.getClass().getMethod("setCurrentHP", int.class);
			m.invoke(obj, newHp);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred while setting currentHP");
		}
	}

	private void clearBoard(Object game) {
		Class<? extends Object> curr = game.getClass();
		Field f = null;
		try {
			f = curr.getDeclaredField("board");
			f.setAccessible(true);
			f.set(game, new Object[5][5]);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {

			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	private void addAbilityToChampion(Object champ, Object ability) {
		try {
			Method m = champ.getClass().getMethod("getAbilities");
			((ArrayList<Object>) (m.invoke(champ))).add(ability);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e2) {

			e2.printStackTrace();
		}
	}

	private void addChampToTurnOrder(Object game, Object champ) {
		Field f1 = null;
		Class<? extends Object> curr1 = game.getClass();
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

		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
				| InstantiationException | InvocationTargetException | NoSuchMethodException
				| ClassNotFoundException e) {

			fail(e.getCause().getClass() + " occurred");
		}

	}

	private Object[][] returnGameBoard(Object createdGame) {

		Method m1;
		try {
			m1 = createdGame.getClass().getMethod("getBoard");
			Object[][] boardGame1 = (Object[][]) m1.invoke(createdGame);
			return boardGame1;
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred");
		}
		return null;
	}

	private void addObjectToBoardGame(Object createdGame, Object obj, int x, int y) {
		Method m1;
		try {
			m1 = createdGame.getClass().getMethod("getBoard");
			((Object[][]) m1.invoke(createdGame))[x][y] = obj;
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred");
		}
	}

	private Object createPlayer(String s) {
		try {
			Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
			Object firstPlayer = constructorFirstPlayer.newInstance(s);
			return firstPlayer;

		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException e) {

			fail(e.getCause().getClass() + " occurred");
			return null;
		} catch (InstantiationException e) {

			fail(e.getCause().getClass() + " occurred");
			return null;
		} catch (IllegalAccessException e) {

			fail(e.getCause().getClass() + " occurred");
			return null;
		} catch (IllegalArgumentException e) {

			fail(e.getCause().getClass() + " occurred");
			return null;
		} catch (InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred");
			return null;
		}

	}

	private Object createGame() {
		Constructor<?> gameConstructor;
		try {
			gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
					Class.forName(playerPath));
			Object createdGame = gameConstructor.newInstance(createPlayer("1"), createPlayer("2"));
			return createdGame;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException e) {

			fail(e.getCause().getClass() + " occurred");
		} catch (InstantiationException e) {

			fail(e.getCause().getClass() + " occurred");
		} catch (IllegalAccessException e) {

			fail(e.getCause().getClass() + " occurred");
		} catch (IllegalArgumentException e) {

			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred");
		}

		return null;
	}

	private Object createGame(Object firstPlayer, Object secondPlayer) {
		Constructor<?> gameConstructor;
		try {
			gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
					Class.forName(playerPath));
			Object createdGame = gameConstructor.newInstance(firstPlayer, secondPlayer);
			return createdGame;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException e) {

			fail(e.getCause().getClass() + " occurred");
		} catch (InstantiationException e) {

			fail(e.getCause().getClass() + " occurred");
		} catch (IllegalAccessException e) {

			fail(e.getCause().getClass() + " occurred");
		} catch (IllegalArgumentException e) {

			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred");
		}

		return null;
	}

	private Object createHero(String name, int maxHP, int mana, int actions, int speed, int attackRange,
			int attackDamage) {
		try {
			Constructor<?> constructorHeroChamp = Class.forName(heroPath).getConstructor(String.class, int.class,
					int.class, int.class, int.class, int.class, int.class);
			Object champ = constructorHeroChamp.newInstance(name, maxHP, mana, actions, speed, attackRange,
					attackDamage);
			return champ;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred");
			return null;
		}

	}

	private Object createRandomHero() {
		try {
			Constructor<?> constructorChamp = Class.forName(heroPath).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			Object champ = constructorChamp.newInstance("ironman", 100, 200, 300, 400, 500, 600);
			return champ;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred");
			return null;
		}
	}

	private Object createRandomAntiHero() {
		try {
			Constructor<?> constructorChamp = Class.forName(antiHeroPath).getConstructor(String.class, int.class,
					int.class, int.class, int.class, int.class, int.class);
			Object champ = constructorChamp.newInstance("Deadpool", 100, 200, 300, 400, 500, 600);
			return champ;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred");
			return null;
		}
	}

	private Object createRandomVillain() {
		try {
			Constructor<?> constructorChamp = Class.forName(villainPath).getConstructor(String.class, int.class,
					int.class, int.class, int.class, int.class, int.class);
			Object champ = constructorChamp.newInstance("Thanos", 100, 200, 300, 400, 500, 600);
			return champ;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred");
			return null;
		}
	}

	private Object createDisarmEffect(int duration) {
		try {
			Constructor<?> effecrConstructor = Class.forName(disarmPath).getConstructor(int.class);
			Object effect = effecrConstructor.newInstance(duration);
			return effect;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred");
		}
		return null;
	}

	private Object createDodgeEffect(int duration) {
		try {
			Constructor<?> effecrConstructor = Class.forName(DodgePath).getConstructor(int.class);
			Object effect = effecrConstructor.newInstance(duration);
			return effect;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred");
		}
		return null;
	}

	private Object createEmbraceEffect(int duration) {

		try {
			Constructor<?> embraceEffecrConstructor = Class.forName(embracePath).getConstructor(int.class);
			Object embraceEffect = embraceEffecrConstructor.newInstance(duration);
			return embraceEffect;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred");
		}
		return null;
	}

	private Object createPowerUpEffect(int duration) {
		try {
			Constructor<?> effecrConstructor = Class.forName(powerUpPath).getConstructor(int.class);
			Object effect = effecrConstructor.newInstance(duration);
			return effect;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred");
		}
		return null;
	}

	private Object createRootEffect(int duration) {
		try {
			Constructor<?> effecrConstructor = Class.forName(rootPath).getConstructor(int.class);
			Object effect = effecrConstructor.newInstance(duration);
			return effect;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred");
		}
		return null;
	}

	private Object createSheildEffect(int duration) {
		try {
			Constructor<?> effecrConstructor = Class.forName(shieldPath).getConstructor(int.class);
			Object effect = effecrConstructor.newInstance(duration);
			return effect;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred");
		}
		return null;
	}

	private Object createShockEffect(int duration) {
		try {
			Constructor<?> effecrConstructor = Class.forName(shockPath).getConstructor(int.class);
			Object effect = effecrConstructor.newInstance(duration);
			return effect;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred");
		}
		return null;
	}

	private Object createSilenceEffect(int duration) {
		try {
			Constructor<?> effecrConstructor = Class.forName(silencePath).getConstructor(int.class);
			Object effect = effecrConstructor.newInstance(duration);
			return effect;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred");
		}
		return null;
	}

	private Object createSpeedUpEffect(int duration) {
		try {
			Constructor<?> effecrConstructor = Class.forName(speedUpPath).getConstructor(int.class);
			Object effect = effecrConstructor.newInstance(duration);
			return effect;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred");
		}
		return null;
	}

	private Object createStunEffect(int duration) {
		try {
			Constructor<?> stunEffecrConstructor = Class.forName(stunPath).getConstructor(int.class);
			Object stunEffect = stunEffecrConstructor.newInstance(duration);
			return stunEffect;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

			fail(e.getCause().getClass() + " occurred");
		}
		return null;
	}

	private Object createHealingAbility(String areaOfEffect) {
		try {
			Constructor<?> healingAbilityConst = Class.forName(healingPath).getConstructor(String.class, int.class,
					int.class, int.class, Class.forName(areaOfEffectPath), int.class, int.class);
			Class<?> c = Class.forName(areaOfEffectPath);

			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, areaOfEffect);
			Object healingAbility = healingAbilityConst.newInstance("I can do this all day", 10, 3, 1, value, 2, 150);
			return healingAbility;

		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | InstantiationException e) {

			fail(e.getCause().getClass() + " occurred");
		}
		return null;
	}

	private Object createHealingAbility(String name, int cost, int baseCoolDown, int castRadius, String areaOfEffect,
			int required, int healingAmount) {
		try {
			Constructor<?> healingAbilityConst = Class.forName(healingPath).getConstructor(String.class, int.class,
					int.class, int.class, Class.forName(areaOfEffectPath), int.class, int.class);
			Class<?> c = Class.forName(areaOfEffectPath);

			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, areaOfEffect);
			Object healingAbility = healingAbilityConst.newInstance(name, cost, baseCoolDown, castRadius, value,
					required, healingAmount);
			return healingAbility;

		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | InstantiationException e) {

			fail(e.getCause().getClass() + " occurred while creating healing ability");
		}
		return null;
	}

	private Object createDmgAbility(String name, int cost, int baseCoolDown, int castRadius, String areaOfEffect,
			int required, int damageAmount) {
		try {
			Constructor<?> dmgAbilityConstructor = Class.forName(dmgPath).getConstructor(String.class, int.class,
					int.class, int.class, Class.forName(areaOfEffectPath), int.class, int.class);
			Class<?> c = Class.forName(areaOfEffectPath);

			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, areaOfEffect);
			Object dmgAbility = dmgAbilityConstructor.newInstance(name, cost, baseCoolDown, castRadius, value, required,
					damageAmount);
			return dmgAbility;

		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | InstantiationException e) {

			fail(e.getCause().getClass() + " occurred while creating damaging ability");
		}
		return null;
	}

	private Object createCCAbility(String name, int cost, int baseCoolDown, int castRadius, String areaOfEffect,
			int required, Object effect) {
		try {
			Constructor<?> ccAbilityConstructor = Class.forName(ccAbilitiesPath).getConstructor(String.class, int.class,
					int.class, int.class, Class.forName(areaOfEffectPath), int.class, Class.forName(effectPath));

			Class<?> c = Class.forName(areaOfEffectPath);

			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, areaOfEffect);
			Object ccAbility = ccAbilityConstructor.newInstance(name, cost, baseCoolDown, castRadius, value, required,
					effect);
			return ccAbility;

		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | InstantiationException e) {

			fail(e.getCause().getClass() + " occurred while creating damaging ability");
		}
		return null;
	}

	private Object createCCAbility(String areaOfEffect, Object effect) {
		try {
			Constructor<?> ccAbilityConstructor = Class.forName(ccAbilitiesPath).getConstructor(String.class, int.class,
					int.class, int.class, Class.forName(areaOfEffectPath), int.class, Class.forName(effectPath));

			Class<?> c = Class.forName(areaOfEffectPath);

			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, areaOfEffect);
			Object ccAbility = ccAbilityConstructor.newInstance("Shield Up", 90, 0, 1, value, 1, effect);
			return ccAbility;

		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | InstantiationException e) {

			fail(e.getCause().getClass() + " occurred");
		}

		return null;

	}

	private Object createCover(int x, int y) {
		try {
			Constructor<?> coverConstructor = Class.forName(coverPath).getConstructor(int.class, int.class);

			Object cover = coverConstructor.newInstance(x, y);
			return cover;

		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | InstantiationException e) {

			fail(e.getCause().getClass() + " occurred while creating new cover");
		}

		return null;
	}

	private static boolean containsMethodName(Method[] methods, String name) {
		for (Method method : methods) {
			if (method.getName().equals(name))
				return true;
		}
		return false;
	}

	private void applyLogicEmbraceMana(Object c, Object effect, Object cc) {
		boolean flag = true;
		Field f = null;
		try {
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("mana");
			f.setAccessible(true);
			int mana = (int) f.get(c);

			Method execute = cc.getClass().getDeclaredMethod("execute", ArrayList.class);

			ArrayList<Object> target = new ArrayList<>();
			target.add(c);
			execute.invoke(cc, target);

			int expectedValue1 = (int) (mana * 1.2);
			int expectedValue2 = (int) (mana + mana * 0.2);

			if (!(expectedValue1 == (int) f.get(c) || expectedValue2 == (int) f.get(c))) {
				flag = false;
			}

			assertTrue("\"" + cc.getClass().getSimpleName() + "\" class has \"" + effect.getClass().getSimpleName()
					+ "\" effect that should be applied correctly for \"targets\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Embrace\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	private void applyLogicEmbraceSpeed(Object c, Object effect, Object cc) {
		boolean flag = true;
		Field f = null;
		try {

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("speed");
			f.setAccessible(true);
			int speed = (int) f.get(c);

			Method execute = cc.getClass().getDeclaredMethod("execute", ArrayList.class);
			ArrayList<Object> target = new ArrayList<>();
			target.add(c);
			execute.invoke(cc, target);

			int expectedValue1 = (int) (speed * 1.2);
			int expectedValue2 = (int) (speed + speed * 0.2);

			if (!(expectedValue1 == (int) f.get(c) || expectedValue2 == (int) f.get(c))) {
				flag = false;
			}

			assertTrue("\"" + cc.getClass().getSimpleName() + "\" class has \"" + effect.getClass().getSimpleName()
					+ "\" effect that should be applied correctly for \"targets\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Embrace\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	private void applyLogicEmbraceAttackDamage(Object c, Object effect, Object cc) {

		Math.random();
		Math.random();
		Math.random();
		Math.random();
		Math.random();
		Math.random();
		Math.random();
		Math.random();
		boolean flag = true;
		Field f = null;
		try {
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("attackDamage");
			f.setAccessible(true);
			int attack = (int) f.get(c);

			Method execute = cc.getClass().getDeclaredMethod("execute", ArrayList.class);
			ArrayList<Object> target = new ArrayList<>();
			target.add(c);
			execute.invoke(cc, target);
			int expectedValue1 = (int) (attack * 1.2);
			int expectedValue2 = (int) (attack + attack * 0.2);

			if (!(expectedValue1 == (int) f.get(c) || expectedValue2 == (int) f.get(c))) {
				flag = false;
			}

			assertTrue("\"" + cc.getClass().getSimpleName() + "\" class has \"" + effect.getClass().getSimpleName()
					+ "\" effect that should be applied correctly for \"targets\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Embrace\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	private void applyLogicEmbraceCurrentHP(Object c, Object effect, Object cc) {

		Field f = null;
		Field ff = null;
		boolean flag = true;
		try {

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("currentHP");
			ff = curr.getDeclaredField("maxHP");
			f.setAccessible(true);
			ff.setAccessible(true);
			int current = (int) f.get(c);
			int max = (int) ff.get(c);
			Object expectedValue = (int) (current + (0.2 * max));

			Method execute = cc.getClass().getDeclaredMethod("execute", ArrayList.class);
			ArrayList<Object> target = new ArrayList<>();
			target.add(c);
			execute.invoke(cc, target);

			if (!expectedValue.equals(f.get(c))) {
				flag = false;
			}

			assertTrue("\"" + cc.getClass().getSimpleName() + "\" class has \"" + effect.getClass().getSimpleName()
					+ "\" effect that should be applied correctly for \"targets\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Embrace\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	private void applyLogicSpeedUpActions(Object c, Object effect, Object cc) {

		Field f = null;
		boolean flag = true;
		try {

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("currentActionPoints");
			f.setAccessible(true);
			int actions = (int) f.get(c);
			Object expectedValue = (int) (actions + 1);

			Method execute = cc.getClass().getDeclaredMethod("execute", ArrayList.class);
			ArrayList<Object> target = new ArrayList<>();
			target.add(c);
			execute.invoke(cc, target);

			if (!expectedValue.equals(f.get(c))) {
				flag = false;
			}
			assertTrue("\"" + cc.getClass().getSimpleName() + "\" class has \"" + effect.getClass().getSimpleName()
					+ "\" effect that should be applied correctly for \"targets\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"SpeedUp\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	private void applyLogicSpeedUpSpeed(Object c, Object effect, Object cc) {

		Field f = null;
		boolean flag = true;

		try {

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("speed");
			f.setAccessible(true);
			int speed = (int) f.get(c);

			Method execute = cc.getClass().getDeclaredMethod("execute", ArrayList.class);
			ArrayList<Object> target = new ArrayList<>();
			target.add(c);
			execute.invoke(cc, target);

			int expectedValue1 = (int) (speed * 1.15);
			int expectedValue2 = (int) (speed + speed * 0.15);

			if (!(expectedValue1 == (int) f.get(c) || expectedValue2 == (int) f.get(c))) {
				flag = false;
			}
			assertTrue("\"" + cc.getClass().getSimpleName() + "\" class has \"" + effect.getClass().getSimpleName()
					+ "\" effect that should be applied correctly for \"targets\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"SpeedUp\" must implement the inherited abstract method Effect.apply(Champion).",
					false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	private void applyLogicShockSpeed(Object c, Object effect, Object cc) {

		Field f = null;
		boolean flag = true;

		try {

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("speed");
			f.setAccessible(true);
			int speed = (int) f.get(c);

			Method execute = cc.getClass().getDeclaredMethod("execute", ArrayList.class);
			ArrayList<Object> target = new ArrayList<>();
			target.add(c);
			execute.invoke(cc, target);

			int expectedValue1 = (int) (speed * 0.9);
			int expectedValue2 = (int) (speed - speed * 0.1);

			if (!(expectedValue1 == (int) f.get(c) || expectedValue2 == (int) f.get(c))) {
				flag = false;
			}

			assertTrue("\"" + cc.getClass().getSimpleName() + "\" class has \"" + effect.getClass().getSimpleName()
					+ "\" effect that should be applied correctly for \"targets\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Shock\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}
	}

	private void applyLogicShockAttackDamage(Object c, Object effect, Object cc) {

		Field f = null;
		boolean flag = true;

		try {

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("attackDamage");
			f.setAccessible(true);
			int attack = (int) f.get(c);

			Method execute = cc.getClass().getDeclaredMethod("execute", ArrayList.class);
			ArrayList<Object> target = new ArrayList<>();
			target.add(c);
			execute.invoke(cc, target);
			int expectedValue1 = (int) (attack * 0.9);
			int expectedValue2 = (int) (attack - attack * 0.1);

			if (!(expectedValue1 == (int) f.get(c) || expectedValue2 == (int) f.get(c))) {
				flag = false;
			}

			assertTrue("\"" + cc.getClass().getSimpleName() + "\" class has \"" + effect.getClass().getSimpleName()
					+ "\" effect that should be applied correctly for \"targets\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Shock\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	private void applyLogicShockActions(Object c, Object effect, Object cc) {
		Field f = null;
		boolean flag = true;

		try {

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("currentActionPoints");
			f.setAccessible(true);
			int actions = (int) f.get(c);
			Object expectedValue = (int) actions - 1;

			Method execute = cc.getClass().getDeclaredMethod("execute", ArrayList.class);
			ArrayList<Object> target = new ArrayList<>();
			target.add(c);
			execute.invoke(cc, target);

			if (!expectedValue.equals(f.get(c))) {
				flag = false;
			}
			assertTrue("\"" + cc.getClass().getSimpleName() + "\" class has \"" + effect.getClass().getSimpleName()
					+ "\" effect that should be applied correctly for \"targets\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Shock\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void applyLogicStunCondition(Object c, Object effect, Object cc) {

		Field f = null;
		boolean flag = true;
		try {

			Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE");

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("condition");
			f.setAccessible(true);

			Method execute = cc.getClass().getDeclaredMethod("execute", ArrayList.class);
			ArrayList<Object> target = new ArrayList<>();
			target.add(c);
			execute.invoke(cc, target);

			if (!expectedValue.equals(f.get(c))) {
				flag = false;
			}
			assertTrue("\"" + cc.getClass().getSimpleName() + "\" class has \"" + effect.getClass().getSimpleName()
					+ "\" effect that should be applied correctly for \"targets\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Stun\" must implement the inherited abstract method Effect.apply(Champion).", false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked" })
	private void applyLogicPowerUpDamageAmount(Object c, Object effect, Object cc) {

		ArrayList<Object> champAbilities = new ArrayList<>();

		Field f = null;
		boolean flag = true;
		try {

			int randomInstancesDamaging = (int) (Math.random() * 5) + 1;
			int randomInstancesHealing = (int) (Math.random() * 5) + 1;

			for (int i = 0; i < randomInstancesHealing; i++) {
				Object healingAbilityObject = createHealingAbilityInstance();
				champAbilities.add(healingAbilityObject);
			}
			for (int i = 0; i < randomInstancesDamaging; i++) {
				Object damagingAbilityObject = createDamagingAbilityInstance();
				champAbilities.add(damagingAbilityObject);
			}

			Method execute = cc.getClass().getDeclaredMethod("execute", ArrayList.class);
			ArrayList<Object> target = new ArrayList<>();

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("abilities");
			f.setAccessible(true);
			f.set(c, champAbilities);

			target.add(c);

			ArrayList<Object> expectedValue = new ArrayList<>();
			ArrayList<Object> actual = new ArrayList<>();

			for (int i = 0; i < champAbilities.size(); i++) {
				if (champAbilities.get(i).getClass().equals(Class.forName(dmgPath))) {
					Field dmg = Class.forName(dmgPath).getDeclaredField("damageAmount");
					dmg.setAccessible(true);
					int old = (int) dmg.get(champAbilities.get(i));
					expectedValue.add((int) (old + (0.2 * old)));

				}
			}

			execute.invoke(cc, target);

			ArrayList<Object> returnedChamp = (ArrayList<Object>) f.get(c);
			for (int i = 0; i < returnedChamp.size(); i++) {
				if (returnedChamp.get(i).getClass().equals(Class.forName(dmgPath))) {
					Field dmg = Class.forName(dmgPath).getDeclaredField("damageAmount");
					dmg.setAccessible(true);
					actual.add((int) dmg.get(returnedChamp.get(i)));
				}

			}

			if (!expectedValue.equals(actual)) {
				flag = false;
			}
			assertTrue("\"" + cc.getClass().getSimpleName() + "\" class has \"" + effect.getClass().getSimpleName()
					+ "\" effect that should be applied correctly for \"targets\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (InvocationTargetException e) {
			assertTrue("The type \"PowerUp\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		}

	}

	@SuppressWarnings({ "unchecked" })
	private void applyLogicPowerUpHealingAmount(Object c, Object effect, Object cc) {

		ArrayList<Object> champAbilities = new ArrayList<>();

		Field f = null;
		boolean flag = true;
		try {

			int randomInstancesDamaging = (int) (Math.random() * 5) + 1;
			int randomInstancesHealing = (int) (Math.random() * 5) + 1;

			for (int i = 0; i < randomInstancesHealing; i++) {
				Object healingAbilityObject = createHealingAbilityInstance();
				champAbilities.add(healingAbilityObject);
			}
			for (int i = 0; i < randomInstancesDamaging; i++) {
				Object damagingAbilityObject = createDamagingAbilityInstance();
				champAbilities.add(damagingAbilityObject);
			}

			Method execute = cc.getClass().getDeclaredMethod("execute", ArrayList.class);
			ArrayList<Object> target = new ArrayList<>();

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("abilities");
			f.setAccessible(true);
			f.set(c, champAbilities);

			target.add(c);

			ArrayList<Object> expectedValue = new ArrayList<>();
			ArrayList<Object> actual = new ArrayList<>();

			for (int i = 0; i < champAbilities.size(); i++) {
				if (champAbilities.get(i).getClass().equals(Class.forName(healingAbilityPath))) {
					Field dmg = Class.forName(healingAbilityPath).getDeclaredField("healAmount");
					dmg.setAccessible(true);
					int old = (int) dmg.get(champAbilities.get(i));
					expectedValue.add((int) (old + (0.2 * old)));

				}
			}

			execute.invoke(cc, target);

			ArrayList<Object> returnedChamp = (ArrayList<Object>) f.get(c);
			for (int i = 0; i < returnedChamp.size(); i++) {
				if (returnedChamp.get(i).getClass().equals(Class.forName(healingAbilityPath))) {
					Field dmg = Class.forName(healingAbilityPath).getDeclaredField("healAmount");
					dmg.setAccessible(true);
					actual.add((int) dmg.get(returnedChamp.get(i)));
				}

			}

			if (!expectedValue.equals(actual)) {
				flag = false;
			}
			assertTrue("\"" + cc.getClass().getSimpleName() + "\" class has \"" + effect.getClass().getSimpleName()
					+ "\" effect that should be applied correctly for \"targets\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (InvocationTargetException e) {
			assertTrue("The type \"PowerUp\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		}
	}

	private void applyLogicShieldSpeed(Object c, Object effect, Object cc) {

		boolean flag = true;

		Field f = null;
		try {

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("speed");
			f.setAccessible(true);
			int speed = (int) f.get(c);

			Method execute = cc.getClass().getDeclaredMethod("execute", ArrayList.class);
			ArrayList<Object> target = new ArrayList<>();
			target.add(c);
			execute.invoke(cc, target);

			int expectedValue1 = (int) (speed * 1.02);
			int expectedValue2 = (int) (speed + speed * 0.02);

			if (!(expectedValue1 == (int) f.get(c) || expectedValue2 == (int) f.get(c))) {
				flag = false;
			}

			assertTrue("\"" + cc.getClass().getSimpleName() + "\" class has \"" + effect.getClass().getSimpleName()
					+ "\" effect that should be applied correctly for \"targets\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"shield\" must implement the inherited abstract method Effect.apply(Champion)",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void applyLogicRoot(Object c, Object effect, Object cc) {

		Field f = null;
		boolean flag = true;
		try {

			Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ROOTED");

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("condition");
			f.setAccessible(true);

			Method execute = cc.getClass().getDeclaredMethod("execute", ArrayList.class);
			ArrayList<Object> target = new ArrayList<>();
			target.add(c);
			execute.invoke(cc, target);

			if (!expectedValue.equals(f.get(c))) {
				flag = false;
			}
			assertTrue("\"" + cc.getClass().getSimpleName() + "\" class has \"" + effect.getClass().getSimpleName()
					+ "\" effect that should be applied correctly for \"targets\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Root\" must implement the inherited abstract method Effect.apply(Champion)", false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	private void applyLogicSilenceActions(Object c, Object effect, Object cc) {

		boolean flag = true;
		Field f = null;
		try {

			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("currentActionPoints");
			f.setAccessible(true);
			int actions = (int) f.get(c);
			Object expectedValue = (actions + 2);

			Method execute = cc.getClass().getDeclaredMethod("execute", ArrayList.class);
			ArrayList<Object> target = new ArrayList<>();
			target.add(c);
			execute.invoke(cc, target);

			if (!expectedValue.equals(f.get(c))) {
				flag = false;
			}
			assertTrue("\"" + cc.getClass().getSimpleName() + "\" class has \"" + effect.getClass().getSimpleName()
					+ "\" effect that should be applied correctly for \"targets\".", flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Silence\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void applyLogicDisarmDamagingAbility(Object championObject, Object effect, Object ccontrol) {

		Constructor<?> constructorDamagingAbility;

		try {

			constructorDamagingAbility = Class.forName(dmgPath).getConstructor(String.class, int.class, int.class,
					int.class, Class.forName(areaOfEffectPath), int.class, int.class);
			Object damagingAbilityObject = constructorDamagingAbility.newInstance("Punch", 0, 1, 1,
					Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SINGLETARGET"), 1, 50);

			ArrayList<Object> expected = new ArrayList<>();
			expected.add(damagingAbilityObject);

			Class<?> curr = Class.forName(championPath);
			Field f = curr.getDeclaredField("abilities");
			f.setAccessible(true);
			ArrayList<Object> empty = new ArrayList<>();
			f.set(championObject, empty);

			Method execute = ccontrol.getClass().getDeclaredMethod("execute", ArrayList.class);
			ArrayList<Object> target = new ArrayList<>();
			target.add(championObject);
			execute.invoke(ccontrol, target);

			ArrayList<Object> actual = (ArrayList<Object>) f.get(championObject);

			boolean flag = true;
			if (actual.size() != expected.size()) {
				flag = false;
			} else {

				Object returned = actual.get(0);
				if (returned.getClass().equals(Class.forName(dmgPath))) {
					Class<?> c = Class.forName(abilityPath);
					Class<?> cc = Class.forName(dmgPath);
					Field name = c.getDeclaredField("name");
					Field manaCost = c.getDeclaredField("manaCost");
					Field baseCooldown = c.getDeclaredField("baseCooldown");
					Field castRange = c.getDeclaredField("castRange");
					Field requiredActionPoints = c.getDeclaredField("requiredActionPoints");
					Field castArea = c.getDeclaredField("castArea");
					Field damageAmount = cc.getDeclaredField("damageAmount");

					name.setAccessible(true);
					manaCost.setAccessible(true);
					baseCooldown.setAccessible(true);
					castRange.setAccessible(true);
					requiredActionPoints.setAccessible(true);
					castArea.setAccessible(true);
					damageAmount.setAccessible(true);

					String n = (String) name.get(returned);
					int mana = (int) manaCost.get(returned);
					int cool = (int) baseCooldown.get(returned);
					int range = (int) castRange.get(returned);
					int actions = (int) requiredActionPoints.get(returned);
					Object area = castArea.get(returned);

					int damage = (int) damageAmount.get(returned);

					if (!n.equals("Punch") || mana != 0 || cool != 1 || range != 1 || actions != 1 || damage != 50
							|| !area.toString().equals("SINGLETARGET")) {
						flag = false;
					}

				}

			}

			assertTrue("\"" + ccontrol.getClass().getSimpleName() + "\" class has \""
					+ effect.getClass().getSimpleName() + "\" effect that should be applied correctly for \"targets\".",
					flag);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue(e.getClass().getName() + " occurred.", false);
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void executeLogicCrowdControl() {
		int randomCost = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomBaseCoolDown = (int) (Math.random() * 10) + 1;
		int randomCastRange = (int) (Math.random() * 100) + 20;
		int randomRequiredActions = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		int r2 = ((int) Math.random() * 4);
		int championsInstances = (int) (Math.random() * 10) + 1;
		Math.random();
		Object areaOfEffect = null;
		Constructor<?> constructorCrowdControl;
		Constructor<?> constructorRoot;
		Constructor<?> constructorDisarm;
		Constructor<?> constructorDodge;
		Constructor<?> constructorEmbrace;
		Constructor<?> constructorPowerUp;
		Constructor<?> constructorShield;
		Constructor<?> constructorShock;
		Constructor<?> constructorSilence;
		Constructor<?> constructorSpeedUp;
		Constructor<?> constructorStun;
		ArrayList<Object> targets = new ArrayList<>();
		Object crowdControlObject = null;
		String champInstance = "";
		ArrayList<Object> effects = new ArrayList<>();

		try {

			constructorRoot = Class.forName(rootPath).getConstructor(int.class);

			Object rootObject = null;
			try {
				rootObject = constructorRoot.newInstance(duration);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"Root\" can be instantiated.", false);
			}
			effects.add(rootObject);

			constructorDisarm = Class.forName(disarmPath).getConstructor(int.class);
			Object disarmObject = null;
			try {
				disarmObject = constructorDisarm.newInstance(duration);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"Disarm\" can be instantiated.", false);
			}

			effects.add(disarmObject);

			constructorDodge = Class.forName(DodgePath).getConstructor(int.class);
			Object dodgeObject = null;
			try {
				dodgeObject = constructorDodge.newInstance(duration);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"Dodge\" can be instantiated.", false);
			}
			effects.add(dodgeObject);

			constructorEmbrace = Class.forName(embracePath).getConstructor(int.class);
			Object embraceObject = null;
			try {
				embraceObject = constructorEmbrace.newInstance(duration);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"Embrace\" can be instantiated.", false);
			}
			effects.add(embraceObject);

			constructorPowerUp = Class.forName(powerUpPath).getConstructor(int.class);
			Object powerUpObject = null;
			try {
				powerUpObject = constructorPowerUp.newInstance(duration);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"PowerUp\" can be instantiated.", false);
			}
			effects.add(powerUpObject);

			constructorShield = Class.forName(shieldPath).getConstructor(int.class);
			Object shieldObject = null;
			try {
				shieldObject = constructorShield.newInstance(duration);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"Shield\" can be instantiated.", false);
			}
			effects.add(shieldObject);

			constructorShock = Class.forName(shockPath).getConstructor(int.class);
			Object shockObject = null;
			try {
				shockObject = constructorShock.newInstance(duration);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"Shock\" can be instantiated.", false);
			}
			effects.add(shockObject);

			constructorSilence = Class.forName(silencePath).getConstructor(int.class);
			Object silenceObject = null;
			try {
				silenceObject = constructorSilence.newInstance(duration);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"Silence\" can be instantiated.", false);
			}
			effects.add(silenceObject);

			constructorSpeedUp = Class.forName(speedUpPath).getConstructor(int.class);
			Object speedUpObject = null;
			try {
				speedUpObject = constructorSpeedUp.newInstance(duration);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"SpeedUp\" can be instantiated.", false);
			}
			effects.add(speedUpObject);

			constructorStun = Class.forName(stunPath).getConstructor(int.class);
			Object stunObject = null;
			try {
				stunObject = constructorStun.newInstance(duration);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"Stun\" can be instantiated.", false);
			}
			effects.add(stunObject);

			if (r2 == 0)
				areaOfEffect = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SELFTARGET");
			else if (r2 == 1)
				areaOfEffect = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SINGLETARGET");
			else if (r2 == 2)
				areaOfEffect = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "TEAMTARGET");
			else
				areaOfEffect = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SURROUND");
			constructorCrowdControl = Class.forName(ccAbilitiesPath).getConstructor(String.class, int.class, int.class,
					int.class, Class.forName(areaOfEffectPath), int.class, Class.forName(effectPath));

			for (int i = 0; i < championsInstances; i++) {
				int randomChampion = (int) (Math.random() * (2 + 1));
				if (randomChampion == 0)
					champInstance = heroPath;
				else if (randomChampion == 1)
					champInstance = antiHeroPath;
				else
					champInstance = villainPath;
				targets.add(createChampionInstance(champInstance));
			}

			Method execute = Class.forName(ccAbilitiesPath).getDeclaredMethod("execute", ArrayList.class);
			Class.forName(effectPath).getDeclaredMethod("clone");
			ArrayList<Object> expected = new ArrayList<>();
			ArrayList<Object> actual = new ArrayList<>();
			new ArrayList<>();
			boolean same = false;
			boolean flag = true;

			for (int e = 0; e < effects.size(); e++) {
				expected.clear();
				actual.clear();
				for (int i = 0; i < targets.size(); i++) {
					Field ff = Class.forName(championPath).getDeclaredField("appliedEffects");
					ff.setAccessible(true);
					((ArrayList<Object>) ff.get(targets.get(i))).clear();

				}

				crowdControlObject = constructorCrowdControl.newInstance("Name_" + randomName, randomCost,
						randomBaseCoolDown, randomCastRange, areaOfEffect, randomRequiredActions, effects.get(e));
				Field ff = Class.forName(championPath).getDeclaredField("appliedEffects");
				ff.setAccessible(true);

				for (int j = 0; j < targets.size(); j++) {
					expected.add(effects.get(e));

				}
				execute.invoke(crowdControlObject, targets);

				for (int j = 0; j < targets.size(); j++) {
					actual.addAll((ArrayList<Object>) (ff.get(targets.get(j))));

				}

				if (actual.size() != expected.size()) {
					assertTrue("The method \"execute\" in class \"" + crowdControlObject.getClass().getSimpleName()
							+ " \" should add the correct \"effect\" to each \"target\".", false);
				} else {
					for (int i = 0; i < actual.size(); i++) {
						if (!(expected.get(i).getClass().equals(actual.get(i).getClass()))) {
							flag = false;
						}

					}
					assertTrue("The method \"execute\" in class \"" + crowdControlObject.getClass().getSimpleName()
							+ " \" should add the correct \"effect\" to each \"target\".", flag);

				}

				for (int i = 0; i < actual.size(); i++) {
					if (expected.get(i) == actual.get(i))
						same = true;
				}
				assertFalse("The method \"execute\" in class \"" + crowdControlObject.getClass().getSimpleName()
						+ " \" should clone \"effect\" for each \"target\".", same);

				for (int i = 0; i < targets.size(); i++) {
					if (expected.get(i).getClass().getSimpleName().equals("Dodge")) {
						applyLogicDodgeSpeed(targets.get(i), expected.get(i), crowdControlObject);
					} else if (expected.get(i).getClass().getSimpleName().equals("Disarm")) {
						applyLogicDisarmDamagingAbility(targets.get(i), expected.get(i), crowdControlObject);
					} else if (expected.get(i).getClass().getSimpleName().equals("Embrace")) {

						applyLogicEmbraceCurrentHP(targets.get(i), expected.get(i), crowdControlObject);
						applyLogicEmbraceMana(targets.get(i), expected.get(i), crowdControlObject);
						applyLogicEmbraceSpeed(targets.get(i), expected.get(i), crowdControlObject);
						applyLogicEmbraceAttackDamage(targets.get(i), expected.get(i), crowdControlObject);

					} else if (expected.get(i).getClass().getSimpleName().equals("PowerUp")) {
						applyLogicPowerUpDamageAmount(targets.get(i), expected.get(i), crowdControlObject);
						applyLogicPowerUpHealingAmount(targets.get(i), expected.get(i), crowdControlObject);

					} else if (expected.get(i).getClass().getSimpleName().equals("Root")) {
						applyLogicRoot(targets.get(i), expected.get(i), crowdControlObject);

					} else if (expected.get(i).getClass().getSimpleName().equals("Shield")) {
						applyLogicShieldSpeed(targets.get(i), expected.get(i), crowdControlObject);

					} else if (expected.get(i).getClass().getSimpleName().equals("Shock")) {
						applyLogicShockActions(targets.get(i), expected.get(i), crowdControlObject);
						applyLogicShockAttackDamage(targets.get(i), expected.get(i), crowdControlObject);
						applyLogicShockSpeed(targets.get(i), expected.get(i), crowdControlObject);

					} else if (expected.get(i).getClass().getSimpleName().equals("Silence")) {
						applyLogicSilenceActions(targets.get(i), expected.get(i), crowdControlObject);

					} else if (expected.get(i).getClass().getSimpleName().equals("SpeedUp")) {
						applyLogicSpeedUpSpeed(targets.get(i), expected.get(i), crowdControlObject);
						applyLogicSpeedUpActions(targets.get(i), expected.get(i), crowdControlObject);

					} else {
						applyLogicStunCondition(targets.get(i), expected.get(i), crowdControlObject);

					}

				}

			}

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {

			assertTrue("Objects of type \"CrowdControlAbility\" can be instantiated.", false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	private Object createChampionInstance(String classPath) {
		int randomMaxHP = (int) (Math.random() * 5000) + 200;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 1000) + 200;
		int randomSpeed = (int) (Math.random() * 100) + 20;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int currentHP = (int) (Math.random() * 10) + 1;
		int actions = (int) (Math.random() * 100) + 10;
		Constructor<?> constructor;
		Object b = null;
		Field f = null;
		try {
			constructor = Class.forName(classPath).getConstructor(String.class, int.class, int.class, int.class,
					int.class, int.class, int.class);

			try {
				b = constructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions, randomSpeed,
						randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"" + Class.forName(classPath).getSimpleName() + "\" can be instantiated.",
						false);
			}
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("currentHP");
			f.setAccessible(true);
			f.set(b, currentHP);

			f = curr.getDeclaredField("currentActionPoints");
			f.setAccessible(true);
			f.set(b, actions);

		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue(e.getClass().getName() + " occurred.", false);

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

		return b;
	}

	private Object createCoverInstance() {
		Constructor<?> constructor;
		int randomX = (int) (Math.random() * 10) + 1;
		int randomY = (int) (Math.random() * 10) + 1;
		Math.random();
		Object b = null;
		try {
			constructor = Class.forName(coverPath).getConstructor(int.class, int.class);
			b = constructor.newInstance(randomX, randomY);
		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"Cover\" can be instantiated.", false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue(e.getClass().getName() + " occurred.", false);

			e.printStackTrace();
		}
		return b;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Object createDamagingAbilityInstance() {
		int randomCost = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomBaseCoolDown = (int) (Math.random() * 10) + 1;
		int randomCastRange = (int) (Math.random() * 100) + 20;
		int randomRequiredActions = (int) (Math.random() * 10) + 1;
		int randomDamagingAmount = 100;
		int r2 = ((int) Math.random() * 4);
		Object areaOfEffect = null;
		Constructor<?> constructorDamagingAbility;
		Object DamagingAbilityObject = null;

		try {
			if (r2 == 0)
				areaOfEffect = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SELFTARGET");
			else if (r2 == 1)
				areaOfEffect = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SINGLETARGET");
			else if (r2 == 2)
				areaOfEffect = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "TEAMTARGET");
			else
				areaOfEffect = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SURROUND");
			constructorDamagingAbility = Class.forName(dmgPath).getConstructor(String.class, int.class, int.class,
					int.class, Class.forName(areaOfEffectPath), int.class, int.class);
			DamagingAbilityObject = constructorDamagingAbility.newInstance("Name_" + randomName, randomCost,
					randomBaseCoolDown, randomCastRange, areaOfEffect, randomRequiredActions, randomDamagingAmount);
		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"DamagingAbility\" can be instantiated.", false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue(e.getClass().getName() + " occurred.", false);

			e.printStackTrace();
		}
		return DamagingAbilityObject;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Object createHealingAbilityInstance() {
		int randomCost = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomBaseCoolDown = (int) (Math.random() * 10) + 1;
		int randomCastRange = (int) (Math.random() * 100) + 20;
		int randomRequiredActions = (int) (Math.random() * 10) + 1;
		int randomHealingAmount = 100;
		int r2 = ((int) Math.random() * 4);
		Object areaOfEffect = null;
		Constructor<?> constructorHealingAbility;
		Object healingAbilityObject = null;

		try {
			if (r2 == 0)
				areaOfEffect = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SELFTARGET");
			else if (r2 == 1)
				areaOfEffect = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SINGLETARGET");
			else if (r2 == 2)
				areaOfEffect = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "TEAMTARGET");
			else
				areaOfEffect = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SURROUND");
			constructorHealingAbility = Class.forName(healingPath).getConstructor(String.class, int.class, int.class,
					int.class, Class.forName(areaOfEffectPath), int.class, int.class);
			healingAbilityObject = constructorHealingAbility.newInstance("Name_" + randomName, randomCost,
					randomBaseCoolDown, randomCastRange, areaOfEffect, randomRequiredActions, randomHealingAmount);
		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue("Objects of type \"HealingAbility\" can be instantiated.", false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue(e.getClass().getName() + " occurred.", false);

			e.printStackTrace();
		}
		return healingAbilityObject;
	}

	private void testClassImplementsInterface(Class<?> aClass, Class<?> iClass) {
		assertTrue("Class \"" + aClass.getSimpleName() + "\" should implement \"" + iClass.getSimpleName()
				+ "\" interface.", iClass.isAssignableFrom(aClass));
	}

	private void testClassIsAbstract(Class<?> aClass) {
		assertTrue("You should not be able to create new instances from " + aClass.getSimpleName() + " class.",
				Modifier.isAbstract(aClass.getModifiers()));

	}

	private void testIsInterface(Class<?> aClass) {
		assertTrue("\"" + aClass.getSimpleName() + "\" is an interface.", Modifier.isInterface(aClass.getModifiers()));

	}

}
