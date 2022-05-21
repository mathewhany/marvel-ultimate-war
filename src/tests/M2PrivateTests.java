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
import java.util.Random;

import org.junit.Test;

public class M2PrivateTests {

	String championPath = "model.world.Champion";

	String abilityPath = "model.abilities.Ability";
	String crowdControlAbilityPath = "model.abilities.CrowdControlAbility";
	String damagingAbilityPath = "model.abilities.DamagingAbility";
	String healingAbilityPath = "model.abilities.HealingAbility";
	String damageablePath = "model.world.Damageable";
	String UnallowedMovementException = "exceptions.UnallowedMovementException";
	String ChampionDisarmedException = "exceptions.ChampionDisarmedException";
//	Exceptions Path
	String abilityExceptionPath = "exceptions.AbilityUseException";
	String gameExceptionPath = "exceptions.GameActionException";
	String notYourTurnExceptionPath = "exceptions.NotYourTurnException";
	String leaderAbilityAlreadyUsedExceptionPath = "exceptions.LeaderAbilityAlreadyUsedException";
	String unallowedMovementExceptionPath = "exceptions.UnallowedMovementException";
	String notEnoughResourcesExceptionPath = "exceptions.NotEnoughResourcesException";
	String invalidTargetExceptionPath = "exceptions.InvalidTargetException";

	// Engine Path
	String gamePath = "engine.Game";
	String playerPath = "engine.Player";
	String priorityQueuePath = "engine.PriorityQueue";

	// Abilities Path
	String healingPath = "model.abilities.HealingAbility";
	String dmgPath = "model.abilities.DamagingAbility";
	String abilitiesPath = "model.abilities.Ability";
	String ccAbilitiesPath = "model.abilities.CrowdControlAbility";
	String areaOfEffectPath = "model.abilities.AreaOfEffect";

	String shieldPath = "model.effects.Shield";
	String coverPath = "model.world.Cover";
	String effectPath = "model.effects.Effect";
	// Champion Path
	String champPath = "model.world.Champion";
	String directionPath = "model.world.Direction";

	String DodgePath = "model.effects.Dodge";
	String speedUpPath = "model.effects.SpeedUp";

	String disarmPath = "model.effects.Disarm";
	String dodgePath = "model.effects.Disarm";
	String embracePath = "model.effects.Embrace";
	String powerUpPath = "model.effects.PowerUp";
	String rootPath = "model.effects.Root";
	String silencePath = "model.effects.Silence";
	String stunPath = "model.effects.Stun";
	String heroPath = "model.world.Hero";
	String antiHeroPath = "model.world.AntiHero";
	String villainPath = "model.world.Villain";
	String shockPath = "model.effects" + ".Shock";
	String conditionPath = "model.world.Condition";
	String effectTypePath = "model.effects.EffectType";
	String leaderNotCurrentExc = "exceptions.LeaderNotCurrentException";
	String leaderAbilityUsedExc = "exceptions.LeaderAbilityAlreadyUsedException";
	String gameActionExceptionPath = "exceptions.GameActionException";
	String itePath = "exceptions.InvalidTargetException";
	String leaderAbilityUsedExceptionPath = "exceptions.LeaderAbilityAlreadyUsedException";
	String championDisarmedExceptionPath = "exceptions.ChampionDisarmedException";
//	Engine Path
	String invalidTargetException = "exceptions.InvalidTargetException";
	String NotEnoughResourcesException = "exceptions.NotEnoughResourcesException";


	@Test(timeout = 3000)
	public void testInstanceVariableChampionCurrentHPGetter() {
		try {
			testGetterMethodExistsInClass(Class.forName(championPath), "getCurrentHP", int.class, true);
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}
	}

	@Test(timeout = 3000)
	public void testInstanceVariableChampionCurrentHPGetterLogic() {
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		Constructor<?> championConstructor;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			championConstructor = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			Object c = null;

			try {
				c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
						randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			testGetterLogic(c, "currentHP", randomMaxHP);
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
			assertTrue("The type \"Champion\" must implement the inherited abstract method Damageable.getCurrentHP().",
					false);
			e.printStackTrace();
		} catch (Exception e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void testInstanceVariableChampionCurrentHPSetter() {
		try {
			testSetterMethodExistsInClass(Class.forName(championPath), "setCurrentHP", int.class, true);
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}
	}

	@Test(timeout = 3000)
	public void testInstanceVariableChampionCurrentHPSetterLogicMax() {
		Constructor<?> championConstructor;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 1000) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomCurrentHP = randomMaxHP + (int) (Math.random() * 50) + 1;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			championConstructor = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			Object c = null;

			try {
				c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
						randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			testSetterLogic(c, "currentHP", randomCurrentHP, randomMaxHP, int.class);
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

			assertTrue(
					"The type \"Champion\" must implement the inherited abstract method Damageable.setCurrentHP(int).",
					false);

			e.printStackTrace();
		} catch (Exception e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void testInstanceVariableChampionCurrentHPSetterLogicZero() {
		Constructor<?> championConstructor;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 1000) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			championConstructor = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			Object c = null;

			try {
				c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
						randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			testSetterLogic(c, "currentHP", -1, 0, int.class);
		}

		catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InstantiationException e) {
			assertTrue(e.getClass().getName() + " occurred.", false);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue(
					"The type \"Champion\" must implement the inherited abstract method Damageable.setCurrentHP(int).",
					false);

			e.printStackTrace();
		} catch (Exception e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void testInstanceVariableChampionCurrentHPSetterLogic() {
		Constructor<?> championConstructor;
		int randomMaxHP = (int) (Math.random() * 50) + 11;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomCurrentHP = (int) (Math.random() * 10) + 1;

		try {
			String champInstance;
			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			championConstructor = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);

			Object c = null;

			try {
				c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
						randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}
			testSetterLogic(c, "currentHP", randomCurrentHP, randomCurrentHP, int.class);
		}

		catch (NoSuchMethodException e) {
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

			assertTrue(
					"The type \"Champion\" must implement the inherited abstract method Damageable.setCurrentHP(int).",
					false);

			e.printStackTrace();
		} catch (Exception e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}
	}

	@Test(timeout = 3000)
	public void testInstanceVariableLocationGetter() {
		try {
			testGetterMethodExistsInClass(Class.forName(championPath), "getLocation", Point.class, true);
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}
	}

	@Test(timeout = 3000)
	public void testInstanceVariableChampionLocationGetterLogic() {
		Constructor<?> championConstructor;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		String champInstance;
		try {

			int randomChampion = (int) (Math.random() * (2 + 1));
			if (randomChampion == 0)
				champInstance = heroPath;
			else if (randomChampion == 1)
				champInstance = antiHeroPath;
			else
				champInstance = villainPath;

			championConstructor = Class.forName(champInstance).getConstructor(String.class, int.class, int.class,
					int.class, int.class, int.class, int.class);
			Object c = null;

			try {
				c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
						randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Point p = new Point(0, 0);
			testGetterLogic(c, "location", p);
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
			assertTrue(e.getClass().getName() + " occurred.", false);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {

			assertTrue("The type \"Champion\" must implement the inherited abstract method Damageable.getLocation().",
					false);
			e.printStackTrace();
		} catch (Exception e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void testCoverImplementsDamageable() {
		try {
			testClassImplementsInterface(Class.forName(coverPath), Class.forName(damageablePath));
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		}
	}

	@Test(timeout = 3000)
	public void testCoverLocationGetter() {
		try {
			testGetterMethodExistsInClass(Class.forName(coverPath), "getLocation", Point.class, true);
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void testCoverLocationGetterLogic() {
		Constructor<?> constructor;
		int randomX = (int) (Math.random() * 10) + 1;
		int randomY = (int) (Math.random() * 10) + 1;
		try {
			constructor = Class.forName(coverPath).getConstructor(int.class, int.class);
			Object b = constructor.newInstance(randomX, randomY);
			testGetterLogic(b, "location", new Point(randomX, randomY));
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException e) {
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
			assertTrue("The type \"Cover\" must implement the inherited abstract method Damageable.getLocation().",
					false);
			e.printStackTrace();
		} catch (Exception e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void testCoverCurrentHPGetter() {
		try {
			testGetterMethodExistsInClass(Class.forName(coverPath), "getCurrentHP", int.class, true);
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void testCoverCurrentHPGetterLogic() {
		Constructor<?> constructor;
		int randomX = (int) (Math.random() * 10) + 1;
		int randomY = (int) (Math.random() * 10) + 1;

		int randomHP = (int) (Math.random() * 1000) + 100;

		try {
			constructor = Class.forName(coverPath).getConstructor(int.class, int.class);
			Object b = constructor.newInstance(randomX, randomY);
			testGetterLogic(b, "currentHP", randomHP);
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
			assertTrue("The type \"Cover\" must implement the inherited abstract method Damageable.getCurrentHP().",
					false);
			e.printStackTrace();
		} catch (Exception e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void testCoverCurrentHPSetter() {
		try {
			testSetterMethodExistsInClass(Class.forName(coverPath), "setCurrentHP", int.class, true);
		} catch (ClassNotFoundException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void testCoverCurrentHPSetterLogicGeneral() {
		Constructor<?> constructor;
		int randomX = (int) (Math.random() * 10) + 1;
		int randomY = (int) (Math.random() * 10) + 1;

		int randomHP = (int) (Math.random() * 1000) + 100;

		try {
			constructor = Class.forName(coverPath).getConstructor(int.class, int.class);
			Object b = constructor.newInstance(randomX, randomY);
			testSetterLogicCover(b, "currentHP", randomHP, randomHP, int.class);

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
			assertTrue("The type \"Cover\" must implement the inherited abstract method Damageable.setCurrentHP(int).",
					false);
			e.printStackTrace();
		} catch (Exception e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}
	}

	@Test(timeout = 3000)
	public void testCoverCurrentHPSetterLogicZero() {
		Constructor<?> constructor;
		int randomX = (int) (Math.random() * 10) + 1;
		int randomY = (int) (Math.random() * 10) + 1;

		try {
			constructor = Class.forName(coverPath).getConstructor(int.class, int.class);
			Object b = constructor.newInstance(randomX, randomY);
			testSetterLogicCover(b, "currentHP", -1, 0, int.class);

		}

		catch (NoSuchMethodException e) {
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
			assertTrue("The type \"Cover\" must implement the inherited abstract method Damageable.setCurrentHP(int).",
					false);
			e.printStackTrace();
		} catch (Exception e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void testClassIsAbstractEffect() {
		try {
			testClassIsAbstract(Class.forName(effectPath));
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Effect.", false);
		}
	}

	@Test(timeout = 3000)
	public void testApplyExistsInEmbrace() {
		try {
			Class.forName(embracePath).getDeclaredMethod("apply", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Embrace\" should implement the method called \"apply\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Embrace.", false);
		}

	}

	@Test(timeout = 3000)
	public void testApplyExistsInPowerUp() {
		try {
			Class.forName(powerUpPath).getDeclaredMethod("apply", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"PowerUp\" should implement the method called \"apply\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called PowerUp.", false);
		}
	}

	@Test(timeout = 3000)
	public void testApplyExistsInDodge() {
		try {
			Class.forName(DodgePath).getDeclaredMethod("apply", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Dodge\" should implement the method called \"apply\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Dodge.", false);
		}
	}

	@Test(timeout = 3000)
	public void testApplyExistsInSpeedUp() {
		try {
			Class.forName(speedUpPath).getDeclaredMethod("apply", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"SpeedUp\" should implement the method called \"apply\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called SpeedUp.", false);
		}
	}

	@Test(timeout = 3000)
	public void testApplyExistsInDisarm() {
		try {
			Class.forName(disarmPath).getDeclaredMethod("apply", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Disarm\" should implement the method called \"apply\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Disarm.", false);
		}
	}

	@Test(timeout = 3000)
	public void testRemoveExistsInShield() {
		try {
			Class.forName(shieldPath).getDeclaredMethod("remove", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Shield\" should implement the method called \"remove\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Shield.", false);
		}
	}

	@Test(timeout = 3000)
	public void testRemoveExistsInSilence() {
		try {
			Class.forName(silencePath).getDeclaredMethod("remove", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Silence\" should implement the method called \"remove\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Silence.", false);
		}
	}

	@Test(timeout = 3000)
	public void testRemoveExistsInRoot() {

		try {
			Class.forName(rootPath).getDeclaredMethod("remove", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Root\" should implement the method called \"remove\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Root.", false);
		}
	}

	@Test(timeout = 3000)
	public void testRemoveExistsInShock() {
		try {
			Class.forName(shockPath).getDeclaredMethod("remove", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Shock\" should implement the method called \"remove\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Shock.", false);
		}
	}

	@Test(timeout = 3000)
	public void testRemoveExistsInStun() {
		try {
			Class.forName(stunPath).getDeclaredMethod("remove", Class.forName(championPath));
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Stun\" should implement the method called \"remove\" that takes a Champion as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
		} catch (ClassNotFoundException e) {
			assertTrue("Package model.effects should contain a class called Stun.", false);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicEmbraceNoChange() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorEmbrace;
		int randomMaxHP = (int) (Math.random() * 1000) + 10;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 1000) + 100;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 1000) + 100;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 1000) + 10;
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

			ArrayList<Object> empty = new ArrayList<>();

			Method apply = Class.forName(embracePath).getDeclaredMethod("apply", Class.forName(championPath));
			apply.invoke(embraceObject, championObject);
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

			max.setAccessible(true);
			name.setAccessible(true);
			maxActionPointsPerTurn.setAccessible(true);
			currentActionPoints.setAccessible(true);
			attackRange.setAccessible(true);
			appliedEffects.setAccessible(true);
			abilities.setAccessible(true);
			condition.setAccessible(true);
			location.setAccessible(true);

			assertEquals("The method \"" + "apply" + "\" in class \"" + embraceObject.getClass().getSimpleName()
					+ "\" should not change \"" + "maxHP" + "\".", randomMaxHP, max.get(championObject));
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + embraceObject.getClass().getSimpleName()
							+ "\" should not change \"" + "name" + "\".",
					"Name_" + randomName, name.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + embraceObject.getClass().getSimpleName()
							+ "\" should not change \"" + "maxActionPointsPerTurn" + "\".",
					randomActions, maxActionPointsPerTurn.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + embraceObject.getClass().getSimpleName()
							+ "\" should not change \"" + "currentActionPoints" + "\".",
					randomActions, currentActionPoints.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + embraceObject.getClass().getSimpleName()
							+ "\" should not change \"" + "attackRange" + "\".",
					randomAttackRange, attackRange.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + embraceObject.getClass().getSimpleName()
							+ "\" should not change \"" + "appliedEffects" + "\".",
					empty, appliedEffects.get(championObject));
			assertEquals("The method \"" + "apply" + "\" in class \"" + embraceObject.getClass().getSimpleName()
					+ "\" should not change \"" + "abilities" + "\".", empty, abilities.get(championObject));
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + embraceObject.getClass().getSimpleName()
							+ "\" should not change \"" + "condition" + "\".",
					Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ACTIVE"), condition.get(championObject));

			assertEquals("The method \"" + "apply" + "\" in class \"" + embraceObject.getClass().getSimpleName()
					+ "\" should not change \"" + "location" + "\".", null, location.get(championObject));

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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicDisarmNoChange() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorDisarm;
		int randomMaxHP = (int) (Math.random() * 1000) + 100;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 1000) + 100;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 1000) + 100;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 1000) + 100;
		int duration = (int) (Math.random() * 10) + 1;
		Object championObject = null;

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

			constructorDisarm = Class.forName(disarmPath).getConstructor(int.class);

			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object disarmObject = constructorDisarm.newInstance(duration);

			ArrayList<Object> empty = new ArrayList<>();

			Method apply = Class.forName(disarmPath).getDeclaredMethod("apply", Class.forName(championPath));
			apply.invoke(disarmObject, championObject);
			Class<?> curr = Class.forName(championPath);

			Field max = curr.getDeclaredField("maxHP");
			Field name = curr.getDeclaredField("name");
			Field maxActionPointsPerTurn = curr.getDeclaredField("maxActionPointsPerTurn");
			Field currentActionPoints = curr.getDeclaredField("currentActionPoints");
			Field attackRange = curr.getDeclaredField("attackRange");
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

			assertEquals("The method \"" + "apply" + "\" in class \"" + disarmObject.getClass().getSimpleName()
					+ "\" should not change \"" + "maxHP" + "\".", randomMaxHP, max.get(championObject));
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + disarmObject.getClass().getSimpleName()
							+ "\" should not change \"" + "name" + "\".",
					"Name_" + randomName, name.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + disarmObject.getClass().getSimpleName()
							+ "\" should not change \"" + "maxActionPointsPerTurn" + "\".",
					randomActions, maxActionPointsPerTurn.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + disarmObject.getClass().getSimpleName()
							+ "\" should not change \"" + "currentActionPoints" + "\".",
					randomActions, currentActionPoints.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + disarmObject.getClass().getSimpleName()
							+ "\" should not change \"" + "attackRange" + "\".",
					randomAttackRange, attackRange.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + disarmObject.getClass().getSimpleName()
							+ "\" should not change \"" + "appliedEffects" + "\".",
					empty, appliedEffects.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + disarmObject.getClass().getSimpleName()
							+ "\" should not change \"" + "condition" + "\".",
					Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ACTIVE"), condition.get(championObject));

			assertEquals("The method \"" + "apply" + "\" in class \"" + disarmObject.getClass().getSimpleName()
					+ "\" should not change \"" + "location" + "\".", null, location.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + disarmObject.getClass().getSimpleName()
							+ "\" should not change \"" + "currentHP" + "\".",
					randomMaxHP, currentHP.get(championObject));
			assertEquals("The method \"" + "apply" + "\" in class \"" + disarmObject.getClass().getSimpleName()
					+ "\" should not change \"" + "mana" + "\".", randomMana, mana.get(championObject));
			assertEquals("The method \"" + "apply" + "\" in class \"" + disarmObject.getClass().getSimpleName()
					+ "\" should not change \"" + "speed" + "\".", randomSpeed, speed.get(championObject));
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + disarmObject.getClass().getSimpleName()
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
			assertTrue("Objects of type \"Disarm\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Disarm\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicDodgeNoChange() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorDodge;
		int randomMaxHP = (int) (Math.random() * 1000) + 100;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 1000) + 100;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 1000) + 100;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 1000) + 100;
		int duration = (int) (Math.random() * 10) + 1;
		Object championObject = null;
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
			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object dodgeObject = constructorDodge.newInstance(duration);

			ArrayList<Object> empty = new ArrayList<>();

			Method apply = Class.forName(DodgePath).getDeclaredMethod("apply", Class.forName(championPath));
			apply.invoke(dodgeObject, championObject);
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

			assertEquals("The method \"" + "apply" + "\" in class \"" + dodgeObject.getClass().getSimpleName()
					+ "\" should not change \"" + "maxHP" + "\".", randomMaxHP, max.get(championObject));
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + dodgeObject.getClass().getSimpleName()
							+ "\" should not change \"" + "name" + "\".",
					"Name_" + randomName, name.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + dodgeObject.getClass().getSimpleName()
							+ "\" should not change \"" + "maxActionPointsPerTurn" + "\".",
					randomActions, maxActionPointsPerTurn.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + dodgeObject.getClass().getSimpleName()
							+ "\" should not change \"" + "currentActionPoints" + "\".",
					randomActions, currentActionPoints.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + dodgeObject.getClass().getSimpleName()
							+ "\" should not change \"" + "attackRange" + "\".",
					randomAttackRange, attackRange.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + dodgeObject.getClass().getSimpleName()
							+ "\" should not change \"" + "appliedEffects" + "\".",
					empty, appliedEffects.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + dodgeObject.getClass().getSimpleName()
							+ "\" should not change \"" + "condition" + "\".",
					Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ACTIVE"), condition.get(championObject));

			assertEquals("The method \"" + "apply" + "\" in class \"" + dodgeObject.getClass().getSimpleName()
					+ "\" should not change \"" + "location" + "\".", null, location.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + dodgeObject.getClass().getSimpleName()
							+ "\" should not change \"" + "currentHP" + "\".",
					randomMaxHP, currentHP.get(championObject));
			assertEquals("The method \"" + "apply" + "\" in class \"" + dodgeObject.getClass().getSimpleName()
					+ "\" should not change \"" + "mana" + "\".", randomMana, mana.get(championObject));
			assertEquals("The method \"" + "apply" + "\" in class \"" + dodgeObject.getClass().getSimpleName()
					+ "\" should not change \"" + "abilities" + "\".", empty, abilities.get(championObject));
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + dodgeObject.getClass().getSimpleName()
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicPowerUpNoChange() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorPower;
		int randomMaxHP = (int) (Math.random() * 1000) + 100;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 1000) + 100;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 1000) + 100;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 1000) + 100;
		int duration = (int) (Math.random() * 10) + 1;
		Object championObject = null;
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

			constructorPower = Class.forName(powerUpPath).getConstructor(int.class);
			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object powerObject = constructorPower.newInstance(duration);

			ArrayList<Object> empty = new ArrayList<>();

			Method apply = Class.forName(powerUpPath).getDeclaredMethod("apply", Class.forName(championPath));
			apply.invoke(powerObject, championObject);
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

			assertEquals("The method \"" + "apply" + "\" in class \"" + powerObject.getClass().getSimpleName()
					+ "\" should not change \"" + "maxHP" + "\".", randomMaxHP, max.get(championObject));
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + powerObject.getClass().getSimpleName()
							+ "\" should not change \"" + "name" + "\".",
					"Name_" + randomName, name.get(championObject));

			assertEquals("The method \"" + "apply" + "\" in class \"" + powerObject.getClass().getSimpleName()
					+ "\" should not change \"" + "speed" + "\".", randomSpeed, speed.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + powerObject.getClass().getSimpleName()
							+ "\" should not change \"" + "maxActionPointsPerTurn" + "\".",
					randomActions, maxActionPointsPerTurn.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + powerObject.getClass().getSimpleName()
							+ "\" should not change \"" + "currentActionPoints" + "\".",
					randomActions, currentActionPoints.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + powerObject.getClass().getSimpleName()
							+ "\" should not change \"" + "attackRange" + "\".",
					randomAttackRange, attackRange.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + powerObject.getClass().getSimpleName()
							+ "\" should not change \"" + "appliedEffects" + "\".",
					empty, appliedEffects.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + powerObject.getClass().getSimpleName()
							+ "\" should not change \"" + "condition" + "\".",
					Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ACTIVE"), condition.get(championObject));

			assertEquals("The method \"" + "apply" + "\" in class \"" + powerObject.getClass().getSimpleName()
					+ "\" should not change \"" + "location" + "\".", null, location.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + powerObject.getClass().getSimpleName()
							+ "\" should not change \"" + "currentHP" + "\".",
					randomMaxHP, currentHP.get(championObject));
			assertEquals("The method \"" + "apply" + "\" in class \"" + powerObject.getClass().getSimpleName()
					+ "\" should not change \"" + "mana" + "\".", randomMana, mana.get(championObject));
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + powerObject.getClass().getSimpleName()
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
			assertTrue("Objects of type \"PowerUp\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"PowerUp\" must implement the inherited abstract method Effect.apply(Champion).",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void applyLogicRootNoChange() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorRoot;
		int randomMaxHP = (int) (Math.random() * 1000) + 100;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 1000) + 100;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 1000) + 100;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 1000) + 100;
		int duration = (int) (Math.random() * 10) + 1;
		Object championObject = null;
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
			try {
				championObject = constructorChampion.newInstance("Name_" + randomName, randomMaxHP, randomMana,
						randomActions, randomSpeed, randomAttackRange, randomAttackDamage);
			} catch (InstantiationException e) {
				assertTrue(
						"Objects of type \"" + Class.forName(champInstance).getSimpleName() + "\" can be instantiated.",
						false);
			}

			Object rootObject = constructorRoot.newInstance(duration);

			ArrayList<Object> empty = new ArrayList<>();

			Method apply = Class.forName(rootPath).getDeclaredMethod("apply", Class.forName(championPath));
			apply.invoke(rootObject, championObject);
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

			assertEquals("The method \"" + "apply" + "\" in class \"" + rootObject.getClass().getSimpleName()
					+ "\" should not change \"" + "maxHP" + "\".", randomMaxHP, max.get(championObject));
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + rootObject.getClass().getSimpleName()
							+ "\" should not change \"" + "name" + "\".",
					"Name_" + randomName, name.get(championObject));

			assertEquals("The method \"" + "apply" + "\" in class \"" + rootObject.getClass().getSimpleName()
					+ "\" should not change \"" + "speed" + "\".", randomSpeed, speed.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + rootObject.getClass().getSimpleName()
							+ "\" should not change \"" + "maxActionPointsPerTurn" + "\".",
					randomActions, maxActionPointsPerTurn.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + rootObject.getClass().getSimpleName()
							+ "\" should not change \"" + "currentActionPoints" + "\".",
					randomActions, currentActionPoints.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + rootObject.getClass().getSimpleName()
							+ "\" should not change \"" + "attackRange" + "\".",
					randomAttackRange, attackRange.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + rootObject.getClass().getSimpleName()
							+ "\" should not change \"" + "appliedEffects" + "\".",
					empty, appliedEffects.get(championObject));

			assertEquals("The method \"" + "apply" + "\" in class \"" + rootObject.getClass().getSimpleName()
					+ "\" should not change \"" + "location" + "\".", null, location.get(championObject));

			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + rootObject.getClass().getSimpleName()
							+ "\" should not change \"" + "currentHP" + "\".",
					randomMaxHP, currentHP.get(championObject));
			assertEquals("The method \"" + "apply" + "\" in class \"" + rootObject.getClass().getSimpleName()
					+ "\" should not change \"" + "mana" + "\".", randomMana, mana.get(championObject));
			assertEquals("The method \"" + "apply" + "\" in class \"" + rootObject.getClass().getSimpleName()
					+ "\" should not change \"" + "abilities" + "\".", empty, abilities.get(championObject));
			assertEquals(
					"The method \"" + "apply" + "\" in class \"" + rootObject.getClass().getSimpleName()
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
			assertTrue("Objects of type \"Root\" can be instantiated.", false);
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue("The type \"Root\" must implement the inherited abstract method Effect.apply(Champion).", false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicShieldBlockDmgAbilitySingleTarget() {
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
						Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SINGLETARGET"), 1, 50);
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

			Method m3 = createdGame.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class,
					int.class);

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
					m3.invoke(createdGame, damagingAbilityObject, 2, 2);

				} else {
					m3.invoke(createdGame, damagingAbilityObject, 2, 3);
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
	public void applyLogicEmbraceSpeed() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorEmbrace;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
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
			f = curr.getDeclaredField("speed");
			f.setAccessible(true);

			int expectedValue1 = (int) (randomSpeed * 1.2);
			int expectedValue2 = (int) (randomSpeed + randomSpeed * 0.2);

			boolean flag = true;
			if (!(expectedValue1 == (int) f.get(championObject) || expectedValue2 == (int) f.get(championObject))) {
				flag = false;
			}

			assertTrue("The method \"" + "apply" + "\" in class " + embraceObject.getClass().getSimpleName()
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
	public void removeLogicSpeedUpActions() {
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
		int randomActions = (int) (Math.random() * 100) + 20;
		int afterApply = (randomActions + 1);
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
			f = curr.getDeclaredField("currentActionPoints");
			f.setAccessible(true);
			f.set(championObject, afterApply);
			remove.invoke(speedUPObject, championObject);
			assertEquals(
					"The method \"" + "remove" + "\" in class " + speedUPObject.getClass().getSimpleName()
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
			assertTrue("The type \"SpeedUp\" must implement the inherited abstract method Effect.remove(Champion)",
					false);
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityDirectionalLeftSameTeam() {
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
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);
		createFirstPlayerTeam(firstPlayer, false, champ);
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

			assertEquals(
					"Casting Left damaging ability should not be applied on same team targets within range, current HP",
					rand1, returnHp(myTeam.get(1)));
			assertEquals(
					"Casting Left damaging ability should not be applied on same team targets within range, current HP",
					rand2, returnHp(myTeam.get(2)));

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with left direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityDirectionalRightObstcale() {
		Object champ = createRandomHero();
		int randomRange = 2;
		int randAmout = (int) (Math.random() * 30) + 10;
		Object ability = createDmgAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, randAmout);

		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);
		createFirstPlayerTeam(firstPlayer, true, champ);

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

			int expected = (values.get(0) - randAmout < 0) ? 0 : values.get(0) - randAmout;
			assertEquals("Casting right damaging ability is not applied correctly, should affect covers' HP", expected,
					returnHp(cover));

			assertEquals(
					"Casting right damaging ability is not applied correctly, should not affect the current champion's HP",
					(int) (values.get(1)), returnHp(champ));

			expected = (values.get(2) - randAmout < 0) ? 0 : values.get(2) - randAmout;
			assertEquals(
					"Casting right damaging ability is not applied correctly, should affect all targets within range, target's HP",
					expected, returnHp(myTeam.get(1)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with right direction on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityDirectionalDown() {
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
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);
		createFirstPlayerTeam(firstPlayer, true, champ);

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

			int expected = (rand1 - randAmout < 0) ? 0 : rand1 - randAmout;

			assertEquals("Casting down damaging ability on target within range should update target's HP", expected,
					returnHp(myTeam.get(1)));
			expected = (rand2 - randAmout < 0) ? 0 : rand2 - randAmout;
			assertEquals("Casting down damaging ability on target within range should update target's HP", expected,
					returnHp(myTeam.get(2)));

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with down direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityDirectionalUpSameTeam() {
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
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);
		createFirstPlayerTeam(firstPlayer, false, champ);

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

			assertEquals(
					"Casting UP damaging ability should not be applied on same team targets within range, current HP",
					rand1, returnHp(myTeam.get(1)));
			assertEquals(
					"Casting UP damaging ability should not be applied on same team targets within range, current HP",
					rand2, returnHp(myTeam.get(2)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with up direction on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityDirectionalUpOpponentTeam() {
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

			assertEquals(
					"Casting UP healing ability should not be applied on opponent team targets within range, current HP",
					rand1, returnHp(myTeam.get(1)));
			assertEquals(
					"Casting UP healing ability should not be applied on opponent team targets within range, current HP",
					rand2, returnHp(myTeam.get(2)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with up direction on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityDirectionalDownObstcale() {
		Object champ = createRandomHero();
		int randomRange = 2;
		int randHealing = (int) (Math.random() * 30) + 10;
		Object ability = createHealingAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, randHealing);

		int max = 4;
		int min = 2;
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);

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

			assertEquals("Casting down healing ability is not applied correctly, should not affect covers'HP",
					(int) (values.get(0)), returnHp(cover));

			assertEquals(
					"Casting down healing ability is not applied correctly, should not affect the current champion's HP",
					(int) (values.get(1)), returnHp(champ));

			int expected = (values.get(2) + randHealing > returnMaxHp(myTeam.get(1))) ? returnMaxHp(myTeam.get(1))
					: values.get(2) + randHealing;
			assertEquals(
					"Casting down healing ability is not applied correctly, should affect all targets within range, target's HP",
					expected, returnHp(myTeam.get(1)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with down direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityDirectionalLeft() {
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
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);

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

			int expected = (rand1 + randHealing > returnMaxHp(myTeam.get(1))) ? returnMaxHp(myTeam.get(1))
					: rand1 + randHealing;

			assertEquals("Casting left healing ability on target within range should update target's HP", expected,
					returnHp(myTeam.get(1)));
			expected = (rand2 + randHealing > returnMaxHp(myTeam.get(2))) ? returnMaxHp(myTeam.get(2))
					: rand2 + randHealing;
			assertEquals("Casting left healing ability on target within range should update target's HP", expected,
					returnHp(myTeam.get(2)));

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with left direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityDirectionalRightOpponentTeam() {
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
		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);

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

			assertEquals(
					"Casting right healing ability should not be applied on opponent team targets within range, current HP",
					rand1, returnHp(myTeam.get(1)));
			assertEquals(
					"Casting right healing ability should not be applied on opponent team targets within range, current HP",
					rand2, returnHp(myTeam.get(2)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with right direction on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalLeftBuff() {
		Object champ = createRandomHero();
		int randomRange = 3;
		int max = 4;
		int min = 3;
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		Object effect = createSheildEffect(2);
		Object ability = createCCAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, effect);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> myTeam = createFirstPlayerTeam(firstPlayer, true, champ);

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

			int i = randY - 1;
			for (; i >= 0; i--) {
				if (i >= 0 && returnGameBoard(game)[randX][i] != null) {

					Object champX = returnGameBoard(game)[randX][i];
					assertTrue(
							"Casting left Sheild crowd control ability on target within range, expected to have the given effect applied on targets within range but it's not",
							containsEffect(champX, effect, true));
				}
			}

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with left direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalLeftBuffOpponentTeam() {
		Object champ = createRandomHero();
		int randomRange = 3;
		int max = 4;
		int min = 3;
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		Object effect = createSheildEffect(2);
		Object ability = createCCAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, effect);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> myTeam = createFirstPlayerTeam(firstPlayer, false, champ);
		createSecondPlayerTeam(secondPlayer, true, champ);
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

			int i = randY - 1;
			for (; i >= 0; i--) {
				if (i >= 0 && returnGameBoard(game)[randX][i] != null) {
					Object champX = returnGameBoard(game)[randX][i];
					assertFalse(
							"Casting left Sheild crowd control ability should not affect opponent team within range",
							containsEffect(champX, effect, false));
				}
			}

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with left direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalRightObstcale() {
		Object champ = createRandomHero();
		int randomRange = 2;
		Object effect = createStunEffect(1);
		Object ability = createCCAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, effect);

		int randX = (int) (Math.random() * 3);
		int randY = (int) Math.floor(Math.random() * (2 - 1 + 1) + 1);
		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		ArrayList<Integer> values = new ArrayList<>();

		Object cover = createCover(randX, randY + 1);
		values.add(returnHp(cover));
		addObjectToBoardGame(game, cover, randX, randY + 1);

		setLocationForObject(myTeam.get(1), randX, randY + 2);
		addObjectToBoardGame(game, myTeam.get(1), randX, randY + 2);

		values.add(returnHp(champ));

		int rand = (int) (Math.random() * 30) + 60;
		setObjectHP(myTeam.get(1), rand);
		values.add(rand);

		values.add(returnHp(myTeam.get(2)));

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m, m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnRightDirection());

			Class<?> c = Class.forName(conditionPath);

			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, "ACTIVE");

			m = champ.getClass().getMethod("getCondition");
			assertEquals(
					"Casting right crowd control ability is not applied correctly, should not affect the current champion's condition",
					value, m.invoke(champ));

			value = valueOf.invoke(null, "INACTIVE");

			m = myTeam.get(1).getClass().getMethod("getCondition");
			assertEquals(
					"Casting right crowd control ability is not applied correctly, should affect all the targets within the given range, target's condition",
					value, m.invoke(myTeam.get(1)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with right direction on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalRight() {
		Object champ = createRandomHero();
		int randomRange = 3;
		int max = 1;
		int min = 0;
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);
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

		Method m, m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnRightDirection());

			int i = randY + 1;
			for (; i <= randY + randomRange; i++) {
				if (i < 5 && returnGameBoard(game)[randX][i] != null) {
					Object champX = returnGameBoard(game)[randX][i];
					Class<?> c = Class.forName(conditionPath);

					Method valueOf = c.getMethod("valueOf", String.class);
					Object value = valueOf.invoke(null, "INACTIVE");

					m = champX.getClass().getMethod("getCondition");
					assertEquals(
							"Casting right Stun crowd control ability on target within range should change target's condition",
							value, m.invoke(champX));

				}
			}

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with right direction on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalUp() {
		Object champ = createRandomHero();
		int randomRange = 2;
		int max = 1;
		int min = 0;
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
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

		Method m, m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnUpDirection());

			int i = randX + 1;
			for (; i <= randX + randomRange; i++) {
				if (i < 5 && returnGameBoard(game)[i][randY] != null) {
					Object champX = returnGameBoard(game)[i][randY];
					Class<?> c = Class.forName(conditionPath);

					Method valueOf = c.getMethod("valueOf", String.class);
					Object value = valueOf.invoke(null, "INACTIVE");

					m = champX.getClass().getMethod("getCondition");
					assertEquals(
							"Casting up Stun crowd control ability on targets within range, should update target's condition",
							value, m.invoke(champX));

				}
			}

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalUpSameTeam() {
		Object champ = createRandomHero();
		int randomRange = 2;
		int max = 1;
		int min = 0;
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		Object effect = createStunEffect(1);
		Object ability = createCCAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, effect);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, false, champ);
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

		Method m, m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnUpDirection());

			int i = randX + 1;
			for (; i <= randX + randomRange; i++) {
				if (i < 5 && returnGameBoard(game)[i][randY] != null) {
					Object champX = returnGameBoard(game)[i][randY];
					Class<?> c = Class.forName(conditionPath);

					Method valueOf = c.getMethod("valueOf", String.class);
					Object value = valueOf.invoke(null, "ACTIVE");

					m = champX.getClass().getMethod("getCondition");
					assertEquals(
							"Casting up Stun crowd control ability should not affect same team champions within range",
							value, m.invoke(champX));

				}
			}

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDIRECTIONALOutOfRangeUp() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();
		int randomRange = (int) (Math.random() * 3);
		Object effect = createStunEffect(2);
		Object ability = createCCAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, effect);

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
	public void testCastDamagingAbilityDIRECTIONALOutOfRangeLeft() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();
		int randomRange = (int) (Math.random() * 2) + 1;
		Object ability = createDmgAbility("h", 10, 2, randomRange, "DIRECTIONAL", 1, 10);

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
				assertEquals(
						"Casting left damaging ability on target out of range should not change unreachable target's HP",
						(int) values.get(i), returnHp(otherTeam.get(i)));
			}

		} catch (Exception e) {

			fail("Trying to cast ability with direction on target out of range");
			fail(e.getCause().getClass() + " occurred");

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityDIRECTIONALOutOfRangeDown() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();
		int randomRange = (int) (Math.random() * 2) + 1;
		Object ability = createHealingAbility("h", 10, 2, randomRange, "DIRECTIONAL", 10, 10);

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
				assertEquals(
						"Casting down healing ability on target out of range should not change unreachable target's HP",
						(int) values.get(i), returnHp(myTeam.get(i)));
			}

		} catch (Exception e) {

			fail("Trying to cast ability with direction on target out of range");
			fail(e.getCause().getClass() + " occurred");

		}

	}

	@SuppressWarnings("unchecked")
	@Test(timeout = 3000)
	public void testCastAbilityCurrentChampInSilence() {
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
		try {
			Method m = champ.getClass().getMethod("getAppliedEffects");
			((ArrayList<Object>) (m.invoke(champ))).add(createSilenceEffect(2));
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e2) {

			e2.printStackTrace();
		}

		try {
			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			fail("Trying to cast ability while champion has silence effect applied, an exception should be thrown");

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| ClassNotFoundException e) {

			fail("Trying to cast ability while champion has silence effect applied, an exception should be thrown");
			fail(e.getCause().getClass() + " occurred");

		} catch (InvocationTargetException e) {
			try {
				if (!(Class.forName(abilityExceptionPath).equals(e.getCause().getClass())))
					fail("Trying to cast ability while champion has silence effect applied, an exception should be thrown");
			} catch (ClassNotFoundException e1) {

				e1.printStackTrace();
			}

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityChampionManaUpdatedCorrectly() {
		Object game = createGame();
		Object champ = createRandomHero();
		addChampToTurnOrder(game, champ);
		int randomCost = (int) (Math.random() * 20);
		clearBoard(game);
		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		Object ability = createHealingAbility("healing", randomCost, 2, 2, "TEAMTARGET", 10, 10);
		int setMana = setRandomMana(champ);
		addAbilityToChampion(champ, ability);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);
			int expectedUpdatedMana = setMana - randomCost;

			m2 = champ.getClass().getMethod("getMana");
			assertEquals("Casting a healing ability with enough mana should update the champion's mana correctly",
					expectedUpdatedMana, (int) (m2.invoke(champ)));

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| ClassNotFoundException | InvocationTargetException e) {
			fail("Trying to cast an ability but " + e.getCause().getClass() + " occurred");

		}

	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityDirectionalLeftUpadateCooldown() {
		Object champ = createRandomHero();
		int randomRange = (int) Math.floor(Math.random() * (3 - 2 + 1) + 2);
		int max = 4;
		int min = 3;
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randAmount = (int) (Math.random() * 30) + 10;
		int randomCooldown = (int) (Math.random() * 2) + 2;
		Object ability = createDmgAbility("h", 10, randomCooldown, randomRange, "DIRECTIONAL", 1, randAmount);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		createFirstPlayerTeam(firstPlayer, true, champ);
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, false, champ);

		Object game = createGame(firstPlayer, secondPlayer);
		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		ArrayList<Integer> values = new ArrayList<>();
		ArrayList<Integer> maxValues = new ArrayList<>();
		ArrayList<Point> pointsTaken = new ArrayList<>();

		for (int i = 0; i < myTeam.size(); i++) {
			if (!myTeam.get(i).equals(champ)) {
				// set location of other champs

				max = randY - 1;
				min = randY - randomRange;

				int pos = (int) Math.floor(Math.random() * (max - min + 1) + min);
				while (pointsTaken.contains(new Point(randX, pos)) && pointsTaken.size() < 2) {
					pos = (int) Math.floor(Math.random() * (max - min + 1) + min);

				}
				pointsTaken.add(new Point(randX, pos));
				setLocationForObject(myTeam.get(i), randX, pos);
				addObjectToBoardGame(game, myTeam.get(i), randX, pos);

			}
			int rand = (int) (Math.random() * 30) + 30;
			setObjectHP(myTeam.get(i), rand);
			values.add(rand);
			maxValues.add(returnMaxHp(myTeam.get(i)));

		}

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnLeftDirection());

			m2 = ability.getClass().getMethod("getCurrentCooldown");
			assertEquals("Casting a directional target damaging ability should set the ability cooldown correctly",
					randomCooldown, (int) (m2.invoke(ability)));

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with left direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalUpUpdateCooldown() {
		Object champ = createRandomHero();
		int randomRange = (int) Math.floor(Math.random() * (3 - 2 + 1) + 2);
		int max = 1;
		int min = 0;
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		Object effect = createDodgeEffect(2);
		int randomCooldown = (int) (Math.random() * 2) + 2;
		Object ability = createCCAbility("h", 10, randomCooldown, randomRange, "DIRECTIONAL", 1, effect);

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
				max = randomRange + randX;
				min = randX + 1;
				int pos = (int) Math.floor(Math.random() * (max - min + 1) + min);
				while (pointsTaken.contains(new Point(pos, randY)) && pointsTaken.size() < 2)
					pos = (int) Math.floor(Math.random() * (max - min + 1) + min);
				pointsTaken.add(new Point(pos, randY));
				setLocationForObject(myTeam.get(i), pos, randY);
				addObjectToBoardGame(game, myTeam.get(i), pos, randY);

			}
			int rand = (int) (Math.random() * 30) + 60;
			setObjectHP(myTeam.get(i), rand);

		}

		addChampToTurnOrder(game, champ);

		addAbilityToChampion(champ, ability);

		Method m2;
		try {
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnUpDirection());

			m2 = ability.getClass().getMethod("getCurrentCooldown");
			assertEquals("Casting a directional target cc ability should set the ability cooldown correctly",
					randomCooldown, (int) (m2.invoke(ability)));

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability with direction");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilitySINGLETARGETUpadteMana2() {
		Object champ = createRandomHero();
		int randomMana = (int) (Math.random() * 2) + 2;
		Object effect = createPowerUpEffect(2);
		Object ability = createCCAbility("", randomMana, 1, 1, "SINGLETARGET", 10, effect);
		int max = 1;
		int min = 0;
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);

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
			int mana = setRandomMana(champ);
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, randX + 1, randY);

			int expected = mana - randomMana;

			m2 = champ.getClass().getMethod("getMana");
			assertEquals("Casting a single target cc ability should update the champion's mana correctly", expected,
					(int) (m2.invoke(champ)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast a single target cc ability ");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilitySINGLETARGETUpadteAP2() {
		Object champ = createRandomHero();
		int randomRequiredActionPoints = (int) (Math.random() * 2) + 1;
		int setAP = setRandomActionPoints(champ);
		Object effect = createPowerUpEffect(2);
		Object ability = createCCAbility("", 1, 2, 2, "SINGLETARGET", randomRequiredActionPoints, effect);
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
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, randX + 1, randY);

			int expected = setAP - randomRequiredActionPoints;

			m2 = champ.getClass().getMethod("getCurrentActionPoints");
			assertEquals("Casting a single target cc ability should update the champion's action points correctly",
					expected, (int) (m2.invoke(champ)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast a single target cc ability");

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilitySINGLETARGETUpadteAP() {
		Object champ = createRandomHero();
		int randomRequiredActionPoints = (int) (Math.random() * 2) + 1;
		int setAP = setRandomActionPoints(champ);
		Object ability = createHealingAbility("", 1, 2, 2, "SINGLETARGET", randomRequiredActionPoints, 100);

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
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, randX, randY + 1);

			int expected = setAP - randomRequiredActionPoints;

			m2 = champ.getClass().getMethod("getCurrentActionPoints");
			assertEquals("Casting a single target healing ability should update the champion's action points correctly",
					expected, (int) (m2.invoke(champ)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast a single target ability");

		}

	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilitySINGLETARGETUpadteMana() {
		Object champ = createRandomHero();
		int randomMana = (int) (Math.random() * 2) + 2;

		Object ability = createDmgAbility("", randomMana, 1, 1, "SINGLETARGET", 10, 100);
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
			int mana = setRandomMana(champ);
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, randX, randY - 1);

			int expected = mana - randomMana;

			m2 = champ.getClass().getMethod("getMana");
			assertEquals("Casting a single target damaging ability should update the champion's mana correctly",
					expected, (int) (m2.invoke(champ)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast a single target ability");

		}

	}

	@Test(timeout = 3000)
	public void testCastAbilityDirectionInCoolDown() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();
		Object game = createGame();
		clearBoard(game);

		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);

		addChampToTurnOrder(game, champ);
		Object ability = createHealingAbility("DIRECTIONAL");
		addAbilityToChampion(champ, ability);
		Method m;
		try {
			m = ability.getClass().getMethod("setCurrentCooldown", int.class);
			m.invoke(ability, 2);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e1) {

			fail(e1.getClass() + " occurred");
		}

		try {
			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath),
					Class.forName(directionPath));
			m2.invoke(game, ability, returnDownDirection());
			fail("Trying to cast ability with direction in cool down, an exception should be thrown");

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| ClassNotFoundException e) {

			fail("Trying to cast ability with direction in cool down, an exception should be thrown");
			fail(e.getCause().getClass() + " occurred");

		} catch (InvocationTargetException e) {
			try {
				if (!(Class.forName(abilityExceptionPath).equals(e.getCause().getClass())))
					fail("Trying to cast ability with direction in cool down, an exception should be thrown");
			} catch (ClassNotFoundException e1) {

				fail(e.getCause().getClass() + " occurred");
			}

		}

	}

	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	@Test(timeout = 3000)
	public void testCastCCAbilitySELFTARGETBUFFPowerUp() {
		Object champ = createHero("ironMan", 100, 1000, 200, 300, 400, 500);
		Object effect = createPowerUpEffect(2);
		Object ability = createCCAbility("SELFTARGET", effect);

		addAbilityToChampion(champ, ability);
		Object game = createGame();
		addChampToTurnOrder(game, champ);
		clearBoard(game);
		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		try {
			Method m, m2;
			m = champ.getClass().getMethod("getAbilities");
			((ArrayList<Object>) m.invoke(champ)).add(createDmgAbility("SELFTARGET"));
			((ArrayList<Object>) m.invoke(champ)).add(createHealingAbility("SELFTARGET"));
			((ArrayList<Object>) m.invoke(champ)).add(createHealingAbility("SELFTARGET"));
			((ArrayList<Object>) m.invoke(champ)).add(createDmgAbility("SELFTARGET"));
			ArrayList<Integer> values = new ArrayList<>();

			for (int i = 1; i < ((ArrayList<Object>) m.invoke(champ)).size(); i++) {
				int randomAmout = (int) (Math.random() * 60);

				if (((ArrayList<Object>) m.invoke(champ)).get(i).getClass().equals(Class.forName(healingPath)))
					m2 = ((ArrayList<Object>) m.invoke(champ)).get(i).getClass().getMethod("setHealAmount", int.class);
				else if (((ArrayList<Object>) m.invoke(champ)).get(i).getClass().equals(Class.forName(dmgPath)))
					m2 = ((ArrayList<Object>) m.invoke(champ)).get(i).getClass().getMethod("setDamageAmount",
							int.class);
				else {
					m2 = null;
				}
				m2.invoke(((ArrayList<Object>) m.invoke(champ)).get(i), randomAmout);
				values.add(randomAmout);
			}

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			m = champ.getClass().getMethod("getAbilities");
			for (int i = 1; i < ((ArrayList<Object>) m.invoke(champ)).size(); i++) {
				Math.random();
				if (((ArrayList<Object>) m.invoke(champ)).get(i).getClass().equals(healingPath)) {
					m2 = ((ArrayList<Object>) m.invoke(champ)).get(i).getClass().getMethod("getHealAmount");
					int expected = (int) (values.get(i) * (1 + 0.2));

					assertEquals(
							"Casting PowerUp effect CrowdControlAbility with SELFTARGET is not applied correctly over healing abilities, the healing amount",
							expected, m2.invoke(((ArrayList<Object>) m.invoke(champ)).get(i)));
				} else if (((ArrayList<Object>) m.invoke(champ)).get(i).getClass().equals(dmgPath)) {
					m2 = ((ArrayList<Object>) m.invoke(champ)).get(i).getClass().getMethod("getDamageAmount");
					int expected = (int) (values.get(i) * (1 + 0.2));
					assertEquals(
							"Casting PowerUp effect CrowdControlAbility with SELFTARGET is not applied correctly over damaging abilities, the damaging amount",
							expected, m2.invoke(((ArrayList<Object>) m.invoke(champ)).get(i)));
				}

			}

		} catch (Exception e) {
			fail(e.getCause().getClass()
					+ " occurred while casting CrowdControlAbility with area of effect SELFTARGET");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCAbilitySELFTARGETBUFFSpeedUp() {
		Object champ = createHero("ironMan", 100, 1000, 200, 300, 400, 500);
		Object effect = createSpeedUpEffect(2);
		int randomRequiredPoints = (int) (Math.random() * 2) + 1;
		Object ability = createCCAbility("", randomRequiredPoints, 2, 2, "SELFTARGET", randomRequiredPoints, effect);

		addAbilityToChampion(champ, ability);
		Object game = createGame();
		clearBoard(game);
		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		addChampToTurnOrder(game, champ);
		int randomSpeed = (int) (Math.random() * 60);
		int randomActions = (int) (Math.random() * 6) + 3;
		try {
			Method m;
			m = champ.getClass().getMethod("setSpeed", int.class);
			m.invoke(champ, randomSpeed);
			m = champ.getClass().getMethod("setCurrentActionPoints", int.class);
			m.invoke(champ, randomActions);

			int expectedCurrentSpeed = (int) (randomSpeed * (1 + 0.15));
			int expectedCurrentActions = randomActions + 1 - randomRequiredPoints;

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertTrue(
					"Casting BUFF CrowdControlAbility with SELFTARGET is not applied correctly on the current champ, expected to have the given effect applied but it's not",
					containsEffect(champ, effect, true));

			m = champ.getClass().getMethod("getSpeed");
			assertEquals(
					"Casting CrowdControlAbility with SELFTARGET is not applied correctly on current champion's speed",
					expectedCurrentSpeed, m.invoke(champ));
			m = champ.getClass().getMethod("getCurrentActionPoints");
			assertEquals(
					"Casting CrowdControlAbility with SELFTARGET is not applied correctly on current champion's action points",
					expectedCurrentActions, m.invoke(champ));

		} catch (Exception e) {

			fail(e.getCause().getClass()
					+ " occurred while casting CrowdControlAbility with area of effect SELFTARGET");

		}
	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityChampionActionPointsUpdatedCorrectly() {
		Object game = createGame();
		Object champ = createRandomHero();
		addChampToTurnOrder(game, champ);
		int randomCost = (int) (Math.random() * 20);
		int randomRequiredActionPoints = (int) (Math.random() * 2) + 1;
		Object ability = createHealingAbility("cc", randomCost, 2, 2, "TEAMTARGET", randomRequiredActionPoints, 100);
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
					"Casting healing ability with enough action points should update the champion's action points correctly",
					expectedUpdatedActionPoints, (int) (m2.invoke(champ)));

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| ClassNotFoundException | InvocationTargetException e) {
			fail("Trying to cast an ability but " + e.getCause().getClass() + " occurred");

		}
	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityDirectionalUpadteAP() {
		Object champ = createRandomHero();
		int randomRequiredActionPoints = (int) (Math.random() * 2) + 1;
		int setAP = setRandomActionPoints(champ);
		Object ability = createHealingAbility("", 1, 2, 2, "DIRECTIONAL", randomRequiredActionPoints, 100);

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
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnRightDirection());

			int expected = setAP - randomRequiredActionPoints;

			m2 = champ.getClass().getMethod("getCurrentActionPoints");
			assertEquals(
					"Casting a directional target healing ability should update the champion's action points correctly",
					expected, (int) (m2.invoke(champ)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with right direction on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilityDirectionalUpadteMana() {
		Object champ = createRandomHero();
		int randomMana = (int) (Math.random() * 2) + 2;

		Object ability = createDmgAbility("", randomMana, 1, 1, "DIRECTIONAL", 10, 100);
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
			int mana = setRandomMana(champ);
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnLeftDirection());

			int expected = mana - randomMana;

			m2 = champ.getClass().getMethod("getMana");
			assertEquals("Casting a directional target healing ability should update the champion's mana correctly",
					expected, (int) (m2.invoke(champ)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with left direction on target");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilityDirectionalUpadteAP1() {
		Object champ = createRandomHero();
		int randomRequiredActionPoints = (int) (Math.random() * 2) + 1;
		int setAP = setRandomActionPoints(champ);
		Object effect = createDisarmEffect(2);
		Object ability = createCCAbility("", 1, 2, 2, "DIRECTIONAL", randomRequiredActionPoints, effect);
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
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnDownDirection());

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
	public void testCastCCAbilityDirectionalUpadteMana2() {
		Object champ = createRandomHero();
		int randomMana = (int) (Math.random() * 2) + 2;
		Object effect = createPowerUpEffect(2);
		Object ability = createCCAbility("", randomMana, 1, 1, "DIRECTIONAL", 10, effect);
		int max = 1;
		int min = 0;
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randX = (int) Math.floor(Math.random() * (max - min + 1) + min);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");
		ArrayList<Object> myTeam = createSecondPlayerTeam(secondPlayer, true, champ);

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
			int mana = setRandomMana(champ);
			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnUpDirection());

			int expected = mana - randomMana;

			m2 = champ.getClass().getMethod("getMana");
			assertEquals("Casting a directional target healing ability should update the champion's mana correctly",
					expected, (int) (m2.invoke(champ)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability with up direction on target");

		}

	}

	@SuppressWarnings("unchecked")
	@Test(timeout = 3000)
	public void testCastAbilityNotEnoughResources2() {
		// Add the current champ to the turnOrder
		Object game = createGame();
		Object champ = createHero("Spiderman", 100, 100, 0, 2, 2, 2);
		addChampToTurnOrder(game, champ);

		Object ability = createHealingAbility("healing", 1, 2, 2, "TEAMTARGET", 10, 10);
		// createFirstPlayerTeam(firstPlayer, includCurrentChamp, champ)
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

			fail(e.getCause().getClass()
					+ " occurred while trying to cast an ability, current Champion does not have enough action points for this ability, an exception should be thrown");
			// fail(e.getCause().getClass() +" occurred");

		} catch (InvocationTargetException e) {
			try {
				if (!(Class.forName(notEnoughResourcesExceptionPath).equals(e.getCause().getClass())))
					fail("Current Champion does not have enough action points for this ability, an exception should be thrown");
			} catch (ClassNotFoundException e1) {

				fail(e.getCause().getClass() + " occurred while trying to cast an ability");
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Test(timeout = 3000)
	public void testCastAbilitySingleTargetNotEnoughResources2() {
		// Add the current champ to the turnOrder
		Object champ = createHero("Spiderman", 100, 100, 0, 2, 2, 2);
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

	@Test(timeout = 3000)
	public void testCastHealingAbilitySingleTargetWithinRange1() {
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

		Object ability = createHealingAbility("", 10, 2, randomRange, "SINGLETARGET", 10, randAmount);
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

			int expected = ((randHP + randAmount) > returnMaxHp(team.get(1))) ? returnMaxHp(team.get(1))
					: (randHP + randAmount);

			assertEquals("Casting single target healing effect is not applied correctly, target's HP", expected,
					returnHp(team.get(1)));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilitySingleTargetWithinRangeOutOfRange2() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randX = (int) Math.floor(Math.random() * (4 - 3 + 1) + 3);
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randomRange = 1;
		int randAmount = (int) (Math.random() * 30) + 10;

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");

		ArrayList<Object> team = createSecondPlayerTeam(secPlayer, true, champ);

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
	public void testCastCCAbilitySingleTargetWithinRangeBuff1() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randX = 2;
		int randY = 2;
		int randomRange = (int) Math.floor(Math.random() * (3 - 2 + 1) + 2);

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

		addObjectToBoardGame(game, team.get(1), 1, 1);
		setLocationForObject(team.get(1), 1, 1);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, 1, 1);

			assertTrue(
					"Casting single target crowd control ability with buff effect is not applied correctly, expected to have the given effect applied but it's not",
					containsEffect(team.get(1), effect, true));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");

		}

	}

	@Test(timeout = 3000)
	public void testCastCCAbilitySingleTargetWithinRangeDeBuff2() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randX = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randY = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randomRange = 1;

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, true, champ);

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

			assertFalse(
					"Casting single target crowd control ability with de-buff effect should not be applied on the same team",
					containsEffect(team.get(1), effect, false));

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
	public void testCastDmgAbilitySingleTargetWithinRange2() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randY = (int) Math.floor(Math.random() * (4 - 3 + 1) + 3);
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
		int randomRange = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
		int randAmount = (int) (Math.random() * 30) + 10;

		Object firstPlayer = createPlayer("1");
		Object secPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, true, champ);

		Object game = createGame(firstPlayer, secPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, randX, randY);
		setLocationForObject(champ, randX, randY);
		addChampToTurnOrder(game, champ);
		Object ability = createDmgAbility("", 10, 2, randomRange, "SINGLETARGET", 1, randAmount);
		addAbilityToChampion(champ, ability);

		int max = randY - 1;
		int min = randY - randomRange;
		int rY = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randHP = (int) (Math.random() * 30) + 60;

		setObjectHP(team.get(1), randHP);
		addObjectToBoardGame(game, team.get(1), randX, rY);
		setLocationForObject(team.get(1), randX, rY);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, randX, rY);

			fail("Casting single target damaging ability should not be applied on the current champions team, an appropriate exception should be thrown");

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
	public void testCastCCAbilitySingleTargetEmptyCell() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();

		int randX = 1;
		int randY = 1;
		int randomRange = 1;

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

		int randHP = (int) (Math.random() * 30) + 10;
		setObjectHP(champ, randHP);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, 4, 4);

			fail("Casting single target cc ability should not be applied on an empty cell, an appropriate exception should be thrown");

		} catch (Exception e) {

			try {
				if (!e.getCause().getClass().equals(Class.forName(invalidTargetExceptionPath)))
					fail(e.getCause().getClass() + " occurred while trying to cast ability on an empty cell target");
			} catch (ClassNotFoundException e1) {

				fail(e.getCause().getClass() + " occurred while trying to cast ability on an empty cell target");
			}

		}

	}

	@Test(timeout = 3000)
	public void testCastDamagingAbilitySingleTargetEmptyCell() {
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

		Object ability = createDmgAbility("", 10, 2, randomRange, "SINGLETARGET", 1, randAmount);
		addAbilityToChampion(champ, ability);

		int randHP = (int) (Math.random() * 30) + 10;
		setObjectHP(champ, randHP);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, 4, 4);

			fail("Casting single target damaging ability should not be applied on an empty cell, an appropriate exception should be thrown");

		} catch (Exception e) {

			try {
				if (!e.getCause().getClass().equals(Class.forName(invalidTargetExceptionPath)))
					fail(e.getCause().getClass() + " occurred while trying to cast ability on an empty cell target");
			} catch (ClassNotFoundException e1) {

				fail(e.getCause().getClass() + " occurred while trying to cast ability on an empty cell target");
			}

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilitySingleTargetOnCurrentChamp() {
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

		Object ability = createHealingAbility("", 10, 2, randomRange, "SINGLETARGET", 10, randAmount);
		addAbilityToChampion(champ, ability);

		int randHP = (int) (Math.random() * 30) + 10;
		setObjectHP(champ, randHP);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), int.class, int.class);
			m2.invoke(game, ability, randX, randY);

			int expected = ((randHP + randAmount) > returnMaxHp(champ)) ? returnMaxHp(champ) : (randHP + randAmount);

			assertEquals("Casting single target healing ability should be applied on current champion's HP", expected,
					returnHp(champ));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while trying to cast ability on single target");

		}

	}

	@Test(timeout = 3000)
	public void testCastHealingAbilityTeamTargetSameTeam7() {
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

		// (4,2) (2,4)
		addObjectToBoardGame(game, champ2, 4, 2);
		setLocationForObject(champ2, 4, 2);
		addObjectToBoardGame(game, champ3, 2, 4);
		setLocationForObject(champ3, 2, 4);

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
	public void testCastHealingAbilityTeamTargetSameTeam1() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 1, "TEAMTARGET", 1, randAmout);
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
	public void testCastHealingAbilityTeamTargetSameTeam3() {
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
		// (3,2) (2,3)
		addObjectToBoardGame(game, champ2, 3, 2);
		setLocationForObject(champ2, 3, 2);
		addObjectToBoardGame(game, champ3, 2, 3);
		setLocationForObject(champ3, 2, 3);

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
	public void testCastHealingAbilityTeamTargetSameTeam8() {
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

		// (2,0) (0,2)
		addObjectToBoardGame(game, champ2, 2, 0);
		setLocationForObject(champ2, 2, 0);
		addObjectToBoardGame(game, champ3, 0, 2);
		setLocationForObject(champ3, 0, 2);

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
	public void testCastHealingAbilityTeamTargetSameTeamOutOfRange() {
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

		// Out of range (0,0) (1,0)
		addObjectToBoardGame(game, champ2, 0, 0);
		setLocationForObject(champ2, 0, 0);
		addObjectToBoardGame(game, champ3, 1, 0);
		setLocationForObject(champ3, 1, 0);

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
					"Casting healing ability with TEAMTARGET should not be applied correctly on team members out of range, current HP",
					randomHp2, returnHp(champ3));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting healing ability with area of effect TEAMTARGET");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCAbilityTeamTargetSameTeam3() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createSpeedUpEffect(2);
		Object ability = createCCAbility("", 1, 1, 2, "TEAMTARGET", 1, effect);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		ArrayList<Object> team = createFirstPlayerTeam(firstPlayer, false, champ);
		createSecondPlayerTeam(secondPlayer, true, champ);

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
			assertFalse(
					"Casting speed up CC ability with TEAMTARGET should not be applied on the opponent team whithin range",
					containsEffect(champ2, effect, false));
			assertFalse(
					"Casting speed up CC ability with TEAMTARGET should not be applied on the opponent team whithin range",
					containsEffect(champ3, effect, false));

		} catch (Exception e) {

			fail(e.getCause().getClass()
					+ " occurred while casting speed up CC ability with area of effect TEAMTARGET ");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCAbilityTeamTargetSameTeam5() {
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

		// (3,2)(2,1)
		addObjectToBoardGame(game, champ2, 3, 2);
		setLocationForObject(champ2, 3, 2);
		addObjectToBoardGame(game, champ3, 2, 1);
		setLocationForObject(champ3, 2, 1);

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
	public void testCastCCAbilityTeamTargetDeBuff2() {
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

		// (2,4) (3,3)
		addObjectToBoardGame(game, champ1, 2, 4);
		setLocationForObject(champ1, 2, 4);
		addObjectToBoardGame(game, champ2, 3, 3);
		setLocationForObject(champ2, 3, 3);

		addChampToTurnOrder(game, champ);

		try {

			Method m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath));
			m2.invoke(game, ability);

			assertTrue("Casting disarm CC ability with TEAMTARGET is not applied correctly on targets within range",
					containsEffect(champ1, effect, true));
			assertTrue("Casting disarm CC ability with TEAMTARGET is not applied correctly on targets within range",
					containsEffect(champ2, effect, true));

		} catch (Exception e) {

			fail(e.getCause().getClass() + " occurred while casting disarm CC ability with area of effect TEAMTARGET ");

		}
	}

	@Test(timeout = 3000)
	public void testCastCCAbilityTeamTargetOutOfRange2() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createDisarmEffect(2);
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

		/*
		 * 
		 * champ at (3,3) at: (4,3) (2,3)(3,4) (3,2) not: (2,4) (2,2) (4,2)
		 */

		addObjectToBoardGame(game, champ1, 2, 4);
		setLocationForObject(champ1, 2, 4);

		addObjectToBoardGame(game, champ2, 2, 2);
		setLocationForObject(champ2, 2, 2);

		addObjectToBoardGame(game, champ3, 4, 2);
		setLocationForObject(champ3, 4, 2);

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

	@Test(timeout = 3000)
	public void testCastHealingAbilitySurroundCovers2() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createHealingAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
		addAbilityToChampion(champ, ability);

		Object firstPlayer = createPlayer("1");
		Object secondPlayer = createPlayer("2");

		createFirstPlayerTeam(firstPlayer, false, champ);
		createSecondPlayerTeam(secondPlayer, true, champ);

		Object game = createGame(firstPlayer, secondPlayer);

		clearBoard(game);
		addObjectToBoardGame(game, champ, 1, 3);
		setLocationForObject(champ, 1, 3);

		Object cover1 = createCover(1, 2);
		Object cover2 = createCover(1, 4);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		setObjectHP(cover1, hp1);
		setObjectHP(cover2, hp2);
		// within (1,2) (1,4)
		addObjectToBoardGame(game, cover1, 1, 2);

		addObjectToBoardGame(game, cover2, 1, 4);

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
	public void testCastHealingAbilitySurroundOpponentTeam1() {
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
		// within (2,2) (2,3) (2,4)

		addObjectToBoardGame(game, champ2, 2, 3);
		setLocationForObject(champ2, 2, 3);

		addObjectToBoardGame(game, champ3, 2, 4);
		setLocationForObject(champ3, 2, 4);

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

	@Test(timeout = 3000)
	public void testCastHealingAbilitySurround3() {
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
		addObjectToBoardGame(game, champ, 4, 4);
		setLocationForObject(champ, 4, 4);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ2, hp1);
		setObjectHP(champ3, hp2);
		// within (4,3) (3,4) (3,3)

		addObjectToBoardGame(game, champ2, 3, 4);
		setLocationForObject(champ2, 3, 4);

		addObjectToBoardGame(game, champ3, 3, 3);
		setLocationForObject(champ3, 3, 3);

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
	public void testCastHealingAbilitySurroundOutOfRange3() {
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
		addObjectToBoardGame(game, champ, 4, 4);
		setLocationForObject(champ, 4, 4);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp1 = (int) (Math.random() * 30) + 40;
		int hp2 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ2, hp1);
		setObjectHP(champ3, hp2);

		// out of range (2,3) (2,4)
		addObjectToBoardGame(game, champ2, 2, 3);
		setLocationForObject(champ2, 2, 3);

		addObjectToBoardGame(game, champ3, 2, 4);
		setLocationForObject(champ3, 2, 4);

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
	public void testCastHealingAbilitySurround7() {
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
		// within (0,2) (0,3) (0,4)
		addObjectToBoardGame(game, champ2, 0, 2);
		setLocationForObject(champ2, 0, 2);

		addObjectToBoardGame(game, champ3, 0, 4);
		setLocationForObject(champ3, 0, 4);

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
	public void testCastCCAbilitySurround3() {
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
		addObjectToBoardGame(game, champ, 4, 4);
		setLocationForObject(champ, 4, 4);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// within (4,3) (3,4) (3,3)

		addObjectToBoardGame(game, champ2, 3, 4);
		setLocationForObject(champ2, 3, 4);

		addObjectToBoardGame(game, champ3, 3, 3);
		setLocationForObject(champ3, 3, 3);

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
	public void testCastCCAbilitySurroundOutOfRange3() {
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
	public void testCastCCAbilitySurround5() {
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

		// within (2,2) (2,3) (2,4)

		addObjectToBoardGame(game, champ2, 2, 3);
		setLocationForObject(champ2, 2, 3);

		addObjectToBoardGame(game, champ3, 2, 4);
		setLocationForObject(champ3, 2, 4);

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
	public void testCastDamagingAbilitySurround1() {
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
		addObjectToBoardGame(game, champ, 0, 0);
		setLocationForObject(champ, 0, 0);

		Object champ1 = team.get(0);
		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp1 = (int) (Math.random() * 20) + 40;
		int hp2 = (int) (Math.random() * 20) + 40;
		int hp3 = (int) (Math.random() * 20) + 40;
		setObjectHP(champ1, hp1);
		setObjectHP(champ2, hp2);
		setObjectHP(champ3, hp3);
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
	public void testCastDamagingAbilitySurroundOutOfRange1() {
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
		addObjectToBoardGame(game, champ, 0, 0);
		setLocationForObject(champ, 0, 0);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		int hp2 = (int) (Math.random() * 20) + 40;
		int hp3 = (int) (Math.random() * 20) + 40;
		setObjectHP(champ2, hp2);
		setObjectHP(champ3, hp3);

		// out of range (1,2) (2,1)
		addObjectToBoardGame(game, champ2, 1, 2);
		setLocationForObject(champ2, 1, 2);

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

	public void testCastDamagingAbilitySameTeamSurround1() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		int randAmout = (int) (Math.random() * 20) + 20;
		Object ability = createDmgAbility("", 1, 1, 1, "SURROUND", 1, randAmout);
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

		Math.random();
		int hp2 = (int) (Math.random() * 30) + 40;
		int hp3 = (int) (Math.random() * 30) + 40;
		setObjectHP(champ2, hp2);
		setObjectHP(champ3, hp3);
		// within (1,0), (0,1) (1,1)
		addObjectToBoardGame(game, champ2, 0, 1);
		setLocationForObject(champ2, 0, 1);

		addObjectToBoardGame(game, champ3, 1, 1);
		setLocationForObject(champ3, 1, 1);

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
	public void testCastCCAbilitySurround4() {
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
		addObjectToBoardGame(game, champ, 0, 4);
		setLocationForObject(champ, 0, 4);

		Object champ2 = team.get(1);
		Object champ3 = team.get(2);

		// within (0,3) (1,4) (1,3)

		addObjectToBoardGame(game, champ2, 1, 4);
		setLocationForObject(champ2, 1, 4);

		addObjectToBoardGame(game, champ3, 1, 3);
		setLocationForObject(champ3, 1, 3);

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
	public void testCastCCAbilitySurroundOutOfRange4() {
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
	public void testCastCCDEBUFFAbilitySameTeamSurround2() {
		Object champ = createHero("ironMan", 100, 10, 20, 3000, 40, 50);
		Object effect = createDisarmEffect(2);
		Object ability = createCCAbility("", 1, 1, 1, "SURROUND", 1, effect);
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

	@Test(timeout = 3000)
	public void testCastCCDEBUFFAbilitySurroundOutOfRange1() {
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
	public void testCastCCDEBUFFAbilitySurround6() {
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
	public void testCastCCDEBUFFAbilitySurround7() {
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
	public void testCastDmgAbilityLeftRemovingDeadTarget() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();
		int randomRange = 2;
		int max = 4;
		int min = 3;
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);

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
		addObjectToBoardGame(game, team.get(1), randX, randY - randomRange);
		setLocationForObject(team.get(1), randX, randY - randomRange);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnLeftDirection());

			boolean removedFromBoard = returnGameBoard(game)[randX][randY - randomRange] == null;
			assertTrue(
					"After casting a damaging ability Left, if the target is dead it should be removed from the board",
					removedFromBoard);
			boolean removedFromTeam = !team.contains(champTarget);
			assertTrue("After casting a damaging ability Left, if the target is dead it should be removed from team",
					removedFromTeam);

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability on directional target");

		}

	}

	@Test(timeout = 3000)
	public void testCastDmgAbilityRightRemovingDeadTarget() {
		// Add the current champ to the turnOrder
		Object champ = createRandomHero();
		int randomRange = 2;
		int max = 1;
		int min = 0;
		int randY = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int randX = (int) Math.floor(Math.random() * (4 - 0 + 1) + 0);

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
		addObjectToBoardGame(game, team.get(1), randX, randY + randomRange);
		setLocationForObject(team.get(1), randX, randY + randomRange);

		Method m2;
		try {

			m2 = game.getClass().getMethod("castAbility", Class.forName(abilitiesPath), Class.forName(directionPath));
			m2.invoke(game, ability, returnRightDirection());

			boolean removedFromBoard = returnGameBoard(game)[randX][randY + randomRange] == null;
			assertTrue(
					"After casting a damaging ability Right, if the target is dead it should be removed from the board",
					removedFromBoard);
			boolean removedFromTeam = !team.contains(champTarget);
			assertTrue("After casting a damaging ability Right, if the target is dead it should be removed from team",
					removedFromTeam);

		} catch (Exception e) {
			fail(e.getCause().getClass() + " occurred while trying to cast ability on directional target");

		}

	}

	@Test(timeout = 3000)
	public void testConstructorLeaderNotCurrentExceptionConstructor1Initialization() throws Exception {
		Constructor<?> constructor = Class.forName(leaderNotCurrentExc).getConstructor();

		Object myObj = constructor.newInstance();
		String[] names = {};
		Object[] values = {};
		testConstructorInitialization(myObj, names, values);
	}

	@Test(timeout = 3000)
	public void testChampionClassImplementsComparable() throws Exception {
		@SuppressWarnings("rawtypes")
		Class[] interfaces = Class.forName(championPath).getInterfaces();
		boolean found = false;
		for (@SuppressWarnings("rawtypes")
		Class class1 : interfaces) {
			if (class1.equals(Comparable.class)) {
				found = true;
			}
		}
		assertTrue("Champion class should implement the interface Comparable", found);

	}

	@Test(timeout = 3000)
	public void testConstructorInvalidTargetExceptionConstructor1() throws Exception {
		@SuppressWarnings("rawtypes")
		Class[] inputs = {};
		testConstructorExists(Class.forName(itePath), inputs);
	}

	@Test(timeout = 3000)
	public void testConstructorLeaderNotCurrentExceptionConstructor2() throws Exception {
		@SuppressWarnings("rawtypes")
		Class[] inputs = { String.class };
		testConstructorExists(Class.forName(leaderNotCurrentExc), inputs);
	}

	@Test(timeout = 3000)
	public void testClassIsSubclassInvalidTargetException() throws Exception {
		testClassIsSubclass(Class.forName(itePath), Class.forName(gameActionExceptionPath));
	}

	@Test(timeout = 3000)
	public void testConstructorChampionDisarmedExceptionConstructor1() throws Exception {
		@SuppressWarnings("rawtypes")
		Class[] inputs = {};
		testConstructorExists(Class.forName(championDisarmedExceptionPath), inputs);
	}

	@Test(timeout = 3000)
	public void testConstructorChampionDisarmedExceptionConstructor2() throws Exception {
		@SuppressWarnings("rawtypes")
		Class[] inputs = { String.class };
		testConstructorExists(Class.forName(championDisarmedExceptionPath), inputs);
	}

	@Test(timeout = 3000)
	public void testConstructorChampionDisarmedlExceptionConstructor2Initialization() throws Exception {
		Constructor<?> constructor = Class.forName(championDisarmedExceptionPath).getConstructor(String.class);
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

	@SuppressWarnings({ "rawtypes" })
	@Test(timeout = 3000)
	public void testUseLeaderAbilityboolean2() throws Exception {
		ArrayList<Object> gameObjects = createGameAndTeamsScenario2();
		Object game = gameObjects.get(0);
		Method getFirstPlayer = game.getClass().getMethod("getFirstPlayer");
		Object fp = getFirstPlayer.invoke(game);
		Method setLeader = fp.getClass().getMethod("setLeader", Class.forName(championPath));
		setLeader.invoke(fp, ((ArrayList) gameObjects.get(1)).get(0));

		Method m = game.getClass().getMethod("useLeaderAbility");
		compareToCheck();
		m.invoke(game);
		Field f = game.getClass().getDeclaredField("firstLeaderAbilityUsed");
		f.setAccessible(true);
		assertTrue("You should set the secondLeaderAbility to true after using the leader ability",
				(boolean) f.get(game));

	}

	/////////////////////////////////////////////

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

		// Create firstPlayer team

		return null;
	}

	@Test(timeout = 3000)
	public void testClassIsAbstractChampion() throws Exception {
		testClassIsAbstract(Class.forName(championPath));
	}

	@SuppressWarnings("rawtypes")
	private ArrayList<Object> createGameAndTeams() {
		try {
			Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
			Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
			Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
			Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");
			Constructor<?> gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),Class.forName(playerPath));
			ArrayList<Object>firstPlayerChamp1= new ArrayList<>();

			Constructor<?> constructorHero = Class.forName(heroPath).getConstructor(String.class, int.class, int.class, int.class,
					int.class, int.class, int.class);

			Constructor<?> constructorAntiHero = Class.forName(antiHeroPath).getConstructor(String.class, int.class, int.class, int.class,
					int.class, int.class, int.class);

			Constructor<?> constructorVillain= Class.forName(villainPath).getConstructor(String.class, int.class, int.class, int.class,
					int.class, int.class, int.class);


			try {
				Object champ1 = constructorHero.newInstance("ironman", 1, 2, 3, 1, 2, 6);
				Object champ2 = constructorAntiHero.newInstance("deadpool", 1, 2, 2, 2, 5, 6);
				Object champ3 = constructorVillain.newInstance("yellow jacket", 1, 2, 3, 3, 5, 6);

				firstPlayerChamp1.add(champ1);
				firstPlayerChamp1.add(champ2);
				firstPlayerChamp1.add(champ3);
				Class curr = firstPlayer.getClass();
				Field	f= curr.getDeclaredField("team");
				f.setAccessible(true);
				f.set(firstPlayer,firstPlayerChamp1);

				// Create secondPlayer team

				ArrayList<Object>secPlayerChamp1= new ArrayList<>();

				Object champ4 = constructorVillain.newInstance("loki", 100, 2, 3, 4, 5, 6);
				Object champ5 = constructorAntiHero.newInstance("ghost rider", 100, 2, 5, 5, 5, 6);
				Object champ6 = constructorHero.newInstance("thor", 100, 2, 3, 6, 5, 6);

				//				System.out.println("champ 6 original" + champ6);
				secPlayerChamp1.add(champ4);
				secPlayerChamp1.add(champ5);
				secPlayerChamp1.add(champ6);

				curr = secondPlayer.getClass();
				f = curr.getDeclaredField("team");
				f.setAccessible(true);
				f.set(secondPlayer,secPlayerChamp1);

				ArrayList<Object> returnedObjects = new ArrayList<Object>();

				Object createdGame = gameConstructor.newInstance(firstPlayer,secondPlayer);

				returnedObjects.add(createdGame);
				returnedObjects.add(firstPlayerChamp1);
				returnedObjects.add(secPlayerChamp1);
				return returnedObjects;

			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchFieldException e) {
				 
				e.printStackTrace();
			}




		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			 
			e.printStackTrace();
		}

		// Create firstPlayer team

		return null;
	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testGetCurrentChampionLogic3() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		newGame.get(2);

		try {
			Method getTurnOrder = createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = getTurnOrder.invoke(createdGame);



			try {
				Method size = turnOrder.getClass().getMethod("size");

				int turnOrderSize = (int) size.invoke(turnOrder);

				try {
					Method remove = turnOrder.getClass().getMethod("remove");
					while(turnOrderSize != 0) {
						remove.invoke(turnOrder);
						turnOrderSize = (int) size.invoke(turnOrder);

					} 
					try {
						Method insert = turnOrder.getClass().getMethod("insert", Comparable.class);
						insert.setAccessible(true);

						try {
							insert.invoke(turnOrder, firstTeam.get(0));
							insert.invoke(turnOrder, firstTeam.get(1));
							try {

								Method m2= createdGame.getClass().getMethod("getCurrentChampion");
								m2.invoke(createdGame);
								int turnOrderSizeAfter = (int) size.invoke(turnOrder);
								assertEquals("getCurrentChampion should not remove the current champion from the turnOrder", 2, turnOrderSizeAfter);

							}  catch (NoSuchMethodException e) {
								fail("Game class should have getCurrentChampion method");
							}



						} catch (IllegalAccessException e) {
							 
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							 
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							 
							e.printStackTrace();
						}

					} catch(NoSuchMethodException e) {
						fail("Priority Queue class should have insert method");

					}

				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have remove method");

				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have size method");


			}




		} catch(NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}


	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testCheckGameOverPlayerTwoWins() throws Exception {


		Object createdGame = createGameAndTeams().get(0);
		Object firstPlayer = createdGame.getClass().getMethod("getFirstPlayer").invoke(createdGame);
		Object secondPlayer = createdGame.getClass().getMethod("getSecondPlayer").invoke(createdGame);

		Method getTeam = secondPlayer.getClass().getMethod("getTeam");
		ArrayList<Object> firstTeam = (ArrayList<Object>) getTeam.invoke(firstPlayer);


		firstTeam .remove(0);
		firstTeam .remove(0);
		firstTeam .remove(0);

		try {

			Method m= createdGame.getClass().getMethod("checkGameOver");
			Object winningPlayer = m.invoke(createdGame);	
			assertEquals("checkGameOver should return the winning player.", secondPlayer, winningPlayer );

		} catch (NoSuchMethodException e) {
			fail("Game class should have checkGameOver method");
		}




	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testInvalidBorderMoveRight() throws Exception {

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
						while(turnOrderSize != 0) {
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

			} catch(NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch(NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}



		try {

			Method m2= createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);

			try {
				Method setLocation = currentChamp.getClass().getMethod("setLocation", Point.class);
				setLocation.invoke(currentChamp,new Point(1,4));	
				try {
					Method m = createdGame.getClass().getMethod("getBoard");
					Object[][] boardGame=(Object[][])m.invoke(createdGame);

					boardGame[1][4] = currentChamp;


				} catch(NoSuchMethodException e) {
					fail("Game class should have getBoard method");

				}


			} catch(NoSuchMethodException e) {
				fail("Champion class should have setLocation method");

			}


			try {
				Method m3= createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
				m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath),"RIGHT"));
				fail("Trying to move beyond a border, an exception should be thrown");;

			} catch (NoSuchMethodException e) {
				fail("Game class should have move method");
			} 	catch(InvocationTargetException e) {
				try {
					if(!(Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
						fail("Trying to move RIGHT beyond a border, an exception should be thrown");;

				} catch (ClassNotFoundException e1) {
					 
					fail("There should be an UnallowedMovementException class");
				}

			}



		}  catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testInvalidMoveDown() throws Exception {

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
						while(turnOrderSize != 0) {
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

			} catch(NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch(NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}



		try {

			Method m2= createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);

			try {
				Method setLocation = currentChamp.getClass().getMethod("setLocation", Point.class);
				setLocation.invoke(currentChamp,new Point(0,1));	
				setLocation.invoke(firstTeam.get(1),new Point(1,1));	

				try {
					Method m = createdGame.getClass().getMethod("getBoard");
					Object[][] boardGame=(Object[][])m.invoke(createdGame);

					boardGame[0][1] = currentChamp;
					boardGame[1][1] = firstTeam.get(1);



				} catch(NoSuchMethodException e) {
					fail("Game class should have getBoard method");

				}


			} catch(NoSuchMethodException e) {
				fail("Champion class should have setLocation method");

			}


			try {
				Method m3= createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
				m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath),"DOWN"));
				fail("Trying to move DOWN to an occupied cell, an exception should be thrown");

			} catch (NoSuchMethodException e) {
				fail("Game class should have move method");
			} 	catch(InvocationTargetException e) {
				try {
					if(!(Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
						fail("Trying to move to an occupied cell, an exception should be thrown");

				} catch (ClassNotFoundException e1) {
					 
					fail("There should be an UnallowedMovementException class");
				}

			}



		}  catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testInvalidMoveObstacleCoverDown() throws Exception {

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
						while(turnOrderSize != 0) {
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

			} catch(NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch(NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}



		try {

			Method m2= createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);

			try {
				Method setLocation = currentChamp.getClass().getMethod("setLocation", Point.class);
				setLocation.invoke(currentChamp,new Point(2,1));	
				setLocation.invoke(firstTeam.get(1),new Point(2,1));	

				try {
					Method m = createdGame.getClass().getMethod("getBoard");
					Object[][] boardGame=(Object[][])m.invoke(createdGame);

					boardGame[2][1] = currentChamp;

					Constructor<?> constructor = Class.forName(coverPath).getConstructor( int.class, int.class);
					Object cover = constructor.newInstance(1,1);
					boardGame[1][1] = cover;



				} catch(NoSuchMethodException e) {
					fail("Game class should have getBoard method");

				}


			} catch(NoSuchMethodException e) {
				fail("Champion class should have setLocation method");

			}


			try {
				Method m3= createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
				m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath),"DOWN"));
				fail("Trying to move to an occupied cell, an exception should be thrown");

			} catch (NoSuchMethodException e) {
				fail("Game class should have move method");
			} 	catch(InvocationTargetException e) {
				try {
					if(!(Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
						fail("Trying to move DOWN to an occupied cell, an exception should be thrown");

				} catch (ClassNotFoundException e1) {
					 
					fail("There should be an UnallowedMovementException class");
				}

			}



		}  catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testValidMoveUpBoardUpdated2() throws Exception {

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
						while(turnOrderSize != 0) {
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

			} catch(NoSuchMethodException e) {
				fail("Priority Queue class should have insert method.");

			}

		} catch(NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method.");
		}



		try {

			Method m2= createdGame.getClass().getMethod("getCurrentChampion");
			Object currentChamp = m2.invoke(createdGame);

			try {
				Method setLocation = currentChamp.getClass().getMethod("setLocation", Point.class);
				setLocation.invoke(currentChamp,new Point(2,1));	
				setLocation.invoke(firstTeam.get(1),new Point(2,1));	

				try {
					Method m = createdGame.getClass().getMethod("getBoard");
					Object[][] boardGame=(Object[][])m.invoke(createdGame);

					boardGame[2][1] = currentChamp;

					boardGame[3][1] = null;

					try {
						Method m3= createdGame.getClass().getDeclaredMethod("move", Class.forName(directionPath));
						m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath),"UP"));

						Object[][] boardGameUpdated=(Object[][])m.invoke(createdGame);

						assertTrue("Board not updated correctly after champion moved UP.",
								boardGameUpdated[2][1] == null);



					} catch (NoSuchMethodException e) {
						fail("Game class should have move method");
					} 	catch(InvocationTargetException e) {
						try {
							if((Class.forName(UnallowedMovementException).equals(e.getCause().getClass())))
								fail("Trying to move UP to an empty cell, but an exception was thrown");

						} catch (ClassNotFoundException e1) {
							 
							fail("There should be an UnallowedMovementException class");
						}

					}



				} catch(NoSuchMethodException e) {
					fail("Game class should have getBoard method");

				}


			} catch(NoSuchMethodException e) {
				fail("Champion class should have setLocation method");

			}





		}  catch (NoSuchMethodException e) {
			fail("Game class should have getCurrentChampion method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testprepareChampionTurns2() throws Exception {
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);


		Method setSpeed = secondTeam.get(0).getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(firstTeam.get(0),8);
		setSpeed.invoke(firstTeam.get(1),9);
		setSpeed.invoke(firstTeam.get(2),10);

		Object firstPlayer = createdGame.getClass().getMethod("getFirstPlayer").invoke(createdGame);
		Class curr = firstPlayer.getClass();
		Field	f= curr.getDeclaredField("team");
		f.setAccessible(true);
		f.set(firstPlayer,firstTeam);



		try {
			Method m2= createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m2.invoke(createdGame);

			try {
				Method size = turnOrder.getClass().getMethod("size");

				int turnOrderSize = (int) size.invoke(turnOrder);

				try {
					Method remove = turnOrder.getClass().getMethod("remove");
					while(turnOrderSize != 0) {
						remove.invoke(turnOrder);
						turnOrderSize = (int) size.invoke(turnOrder);

					} 

				} catch (NoSuchMethodException e) {
					fail("Priority Queue class should have remove method");

				}
			} catch (NoSuchMethodException e) {
				fail("Priority Queue class should have size method");


			}

			Method m1= createdGame.getClass().getDeclaredMethod("prepareChampionTurns");
			m1.setAccessible(true);
			m1.invoke(createdGame);


			//			PriorityQueue turnOrder = (PriorityQueue) m2.invoke(createdGame);
			try {
				Method turnOrderSize = turnOrder.getClass().getMethod("size");
				int size = (Integer) turnOrderSize.invoke(turnOrder);

				boolean orderCorrect = true;

				try {
					Method removeFromTurnOrder =  turnOrder.getClass().getMethod("remove");
					if(size != 6) {
						assertTrue("Number of champions inside turnOrder priority queue after calling prepareChampionTurns is incorrect. Expected  "  + 6 + " but was " + size+ ".",
								6 == size);
					}

					for(int i = 0; i < firstTeam.size(); i++) {
						Comparable champ = (Comparable) removeFromTurnOrder.invoke(turnOrder);
						if(champ.compareTo(firstTeam.get(firstTeam.size()-1-i))!=0) {
							System.out.println(champ.toString());

							orderCorrect = false;

						}

					}

					for(int i = 0; i < secondTeam.size(); i++) {
						Comparable champ = (Comparable) removeFromTurnOrder.invoke(turnOrder);
						if(champ.compareTo(secondTeam.get(secondTeam.size()-1-i))!=0) {
							orderCorrect = false;

						}

					}


					assertTrue("Order of champions inside turnOrder priority queue is incorrect after calling prepareChampionTurns.",
							orderCorrect);

				}	catch (NoSuchMethodException e) {
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
	public void testHeroAttackHeroLeft() throws Exception {
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
		Object[][] boardGame=(Object[][])getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1,new Point(1,1));	
		boardGame[1][1] = champ1;

		setLocation.invoke(champ6,new Point(1,0));	
		boardGame[1][0] = champ6;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame,boardGame);


		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1,10);	


		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(firstTeam.get(0),r.nextInt(50) + 1);



		try {
			Method m= createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while(turnOrderSize != 0) {
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
					if(currentChamp != champ1) {
						setSpeed.invoke(champ1,2);
						setSpeed.invoke(champ6,10);

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
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath),"LEFT"));
					int newHP = (Integer) m5.invoke(champ6);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ1);

					int expectedHP = oldHP - attackDamage;

					assertTrue("The HP of the hero attacked by a hero is not updated correctly. Expected "  + expectedHP + " but was " + newHP+ ".",
							newHP == expectedHP);




				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			}	catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		}	catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}


	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testHeroAttackAntiHeroRight() throws Exception {
		ArrayList<Object> created=createGameAndTeams();
		Object createdGame = created.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) created.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) created.get(2);

		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		firstTeam.get(2);

		secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame=(Object[][])getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1,new Point(3,2));	
		boardGame[3][2] = champ1;

		setLocation.invoke(champ5,new Point(3,4));	
		boardGame[3][3] = null;
		boardGame[3][4] = champ5;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame,boardGame);


		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1,10);	


		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(firstTeam.get(0),r.nextInt(50) + 1);



		try {
			Method m= createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while(turnOrderSize != 0) {
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
					if(currentChamp != champ1) {
						setSpeed.invoke(champ1,2);
						setSpeed.invoke(champ5,10);

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
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath),"RIGHT"));
					int newHP = (Integer) m5.invoke(champ5);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ1);

					int extraDamage = (Integer) attackDamage/2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the antihero attacked by a hero is not updated correctly. Expected "  + expectedHP + " but was " + newHP+ ".",
							newHP == expectedHP);




				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			}	catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		}	catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}


	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testHeroAttackVillainDown() throws Exception {
		ArrayList<Object> created=createGameAndTeams();
		Object createdGame = created.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) created.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) created.get(2);

		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		firstTeam.get(2);

		Object champ4 = secondTeam.get(0);
		secondTeam.get(1);
		secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame=(Object[][])getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1,new Point(3,2));	
		boardGame[3][2] = champ1;

		setLocation.invoke(champ4,new Point(2,2));	
		boardGame[2][2] = champ4;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame,boardGame);


		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1,10);	


		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(firstTeam.get(0),r.nextInt(50) + 1);



		try {
			Method m= createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while(turnOrderSize != 0) {
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
					if(currentChamp != champ1) {
						setSpeed.invoke(champ1,2);
						setSpeed.invoke(champ4,10);

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
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath),"DOWN"));
					int newHP = (Integer) m5.invoke(champ4);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ1);

					int extraDamage = (Integer) attackDamage/2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the villain attacked by a hero  is not updated correctly. Expected "  + expectedHP + " but was " + newHP+ ".",
							newHP == expectedHP);




				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			}	catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		}	catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}


	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testVillainAttackHeroDown() throws Exception {
		ArrayList<Object> created= createGameAndTeams();
		Object createdGame = created.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) created.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) created.get(2);

		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		secondTeam.get(0);
		secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame=(Object[][])getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ3,new Point(3,2));	
		boardGame[3][2] = champ3;

		setLocation.invoke(champ6,new Point(2,2));	
		boardGame[2][2] = champ6;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame,boardGame);


		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ3,10);	


		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ3,r.nextInt(50) + 1);



		try {
			Method m= createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while(turnOrderSize != 0) {
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
					if(currentChamp != champ3) {
						setSpeed.invoke(champ3,2);
						setSpeed.invoke(champ6,10);
						
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
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath),"DOWN"));
					int newHP = (Integer) m5.invoke(champ6);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ3);

					int extraDamage = (Integer) attackDamage/2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the hero attacked by a villain is not updated correctly. Expected "  + expectedHP + " but was " + newHP+ ".",
							newHP == expectedHP);




				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			}	catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		}	catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}


	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testVillainAttackVillainDown() throws Exception {
		ArrayList<Object> created= createGameAndTeams();
		Object createdGame = created.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) created.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) created.get(2);

		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		Object champ4 = secondTeam.get(0);
		secondTeam.get(1);
		secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame=(Object[][])getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ3,new Point(3,2));	
		boardGame[3][2] = champ3;

		setLocation.invoke(champ4,new Point(2,2));	
		boardGame[2][2] = champ4;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame,boardGame);


		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ3,10);	


		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ3,r.nextInt(50) + 1);



		try {
			Method m= createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while(turnOrderSize != 0) {
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
					if(currentChamp != champ3) {
						setSpeed.invoke(champ3,2);
						setSpeed.invoke(champ4,10);
						
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
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath),"DOWN"));
					int newHP = (Integer) m5.invoke(champ4);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ3);

					int expectedHP = oldHP - attackDamage;

					assertTrue("The HP of the villain attacked by a villain is not updated correctly. Expected "  + expectedHP + " but was " + newHP+ ".",
							newHP == expectedHP);




				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			}	catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		}	catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}


	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testVillainAttackAntiHeroDown() throws Exception {
		ArrayList<Object> created= createGameAndTeams();
		Object createdGame = created.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) created.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) created.get(2);

		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame=(Object[][])getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ3,new Point(3,2));	
		boardGame[3][2] = champ3;

		setLocation.invoke(champ5,new Point(2,2));	
		boardGame[2][2] = champ5;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame,boardGame);


		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ3,10);	


		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ3,r.nextInt(50) + 1);



		try {
			Method m= createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while(turnOrderSize != 0) {
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
					if(currentChamp != champ3) {
						setSpeed.invoke(champ3,2);
						setSpeed.invoke(champ5,10);
						
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
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath),"DOWN"));
					int newHP = (Integer) m5.invoke(champ5);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ3);

					int extraDamage = (Integer) attackDamage/2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the antihero attacked by a villain is not updated correctly. Expected "  + expectedHP + " but was " + newHP+ ".",
							newHP == expectedHP);




				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			}	catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		}	catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}


	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testAntiHeroAttackHeroDown() throws Exception {
		ArrayList<Object> created= createGameAndTeams();
		Object createdGame = created.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) created.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) created.get(2);

		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		secondTeam.get(0);
		secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame=(Object[][])getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ2,new Point(3,2));	
		boardGame[3][2] = champ2;

		setLocation.invoke(champ6,new Point(2,2));	
		boardGame[2][2] = champ6;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame,boardGame);


		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2,10);	


		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ2,r.nextInt(50) + 1);



		try {
			Method m= createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while(turnOrderSize != 0) {
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
					if(currentChamp != champ2) {
						setSpeed.invoke(champ2,2);
						setSpeed.invoke(champ6,10);
						
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
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath),"DOWN"));
					int newHP = (Integer) m5.invoke(champ6);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ2);

					int extraDamage = (Integer) attackDamage/2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the hero attacked by an antihero is not updated correctly. Expected "  + expectedHP + " but was " + newHP+ ".",
							newHP == expectedHP);




				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			}	catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		}	catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}


	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testAntiHeroAttackVillainDown() throws Exception {
		ArrayList<Object> created= createGameAndTeams();
		Object createdGame = created.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) created.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) created.get(2);

		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		Object champ4 = secondTeam.get(0);
		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame=(Object[][])getBoardGame.invoke(createdGame);

		
		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ2,new Point(3,2));	
		boardGame[3][2] = champ2;

		setLocation.invoke(champ4,new Point(2,2));	
		boardGame[2][2] = champ4;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame,boardGame);


		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2,10);	


		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ2,r.nextInt(50) + 1);



		try {
			Method m= createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);


			try {
				Method size = turnOrder.getClass().getMethod("size");

				int turnOrderSize = (int) size.invoke(turnOrder);

				try {
					Method remove = turnOrder.getClass().getMethod("remove");
					while(turnOrderSize != 0) {
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

				Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
				m2.invoke(turnOrder, champ2);
				m2.invoke(turnOrder, champ4);
				
				
				try {
					Method getCurrentChampion = createdGame.getClass().getMethod("getCurrentChampion");
					Object currentChamp = getCurrentChampion.invoke(createdGame);
					if(currentChamp != champ2) {
						setSpeed.invoke(champ2,2);
						setSpeed.invoke(champ4,10);
						
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
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath),"DOWN"));
					int newHP = (Integer) m5.invoke(champ4);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ2);

					int extraDamage = (Integer) attackDamage/2;
					int expectedHP = oldHP - (attackDamage + extraDamage);

					assertTrue("The HP of the  villain attacked by an antihero is not updated correctly. Expected "  + expectedHP + " but was " + newHP+ ".",
							newHP == expectedHP);




				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			}	catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		}	catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}


	} 
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testAntiHeroAttackAntiHeroDown() throws Exception {
		ArrayList<Object> created= createGameAndTeams();
		Object createdGame = created.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) created.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) created.get(2);

		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		secondTeam.get(0);
		Object champ5 = secondTeam.get(1);
		secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame=(Object[][])getBoardGame.invoke(createdGame);

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ2,new Point(3,2));	
		boardGame[3][2] = champ2;

		setLocation.invoke(champ5,new Point(2,2));	
		boardGame[2][2] = champ5;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame,boardGame);


		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2,10);	


		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ2,r.nextInt(50) + 1);



		try {
			Method m= createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while(turnOrderSize != 0) {
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
					if(currentChamp != champ2) {
						setSpeed.invoke(champ2,2);
						setSpeed.invoke(champ5,10);
						
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
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath),"DOWN"));
					int newHP = (Integer) m5.invoke(champ5);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ2);

					int expectedHP = oldHP - attackDamage;

					assertTrue("The HP of the antihero attacked by an antihero is not updated correctly. Expected "  + expectedHP + " but was " + newHP+ ".",
							newHP == expectedHP);




				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			}	catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		}	catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}


	} 
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000) 
	public void invalidAttackNotEnoughActionPoints2() throws Exception{
		ArrayList<Object> created= createGameAndTeams();
		Object createdGame = createGameAndTeams().get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) created.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) created.get(2);

		Object champ1 = firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

		secondTeam.get(0);
		secondTeam.get(1);
		Object champ6 = secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame=(Object[][])getBoardGame.invoke(createdGame);
		boardGame = new Object[5][5];

		Method setLocation = champ3.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ2,new Point(3,2));	
		boardGame[3][2] = champ2;

		setLocation.invoke(champ1,new Point(2,2));	
		boardGame[2][2] = champ6;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame,boardGame);


		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2,10);	


		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(champ6,r.nextInt(50) + 1);


		try {
			Method setCurrentActionPoints = champ2.getClass().getMethod("setCurrentActionPoints", int.class);
			setCurrentActionPoints.setAccessible(true);
			setCurrentActionPoints.invoke(champ2, 1);

		} catch (NoSuchMethodException e) {
			fail("Champion class should have setCurrentActionPoints method.");

		}

		try {
			Method m= createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while(turnOrderSize != 0) {
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
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath),"DOWN"));

					fail("Trying to attack without enough action points, an exception should be thrown");

				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				} 	catch(InvocationTargetException e) {
					try {
						if(!(Class.forName(NotEnoughResourcesException).equals(e.getCause().getClass())))
							fail("Trying to move without enough action points, an exception should be thrown");

					} catch (ClassNotFoundException e1) {
						 
						fail("There should be a NotEnoughResourcesException class");
					}

				}



			}	catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		}	catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testHeroAttackCoverLeft() throws Exception {
		ArrayList<Object> created= createGameAndTeams();
		Object createdGame = createGameAndTeams().get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) created.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) created.get(2);

		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		firstTeam.get(2);

		secondTeam.get(0);
		secondTeam.get(1);
		secondTeam.get(2);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame=(Object[][])getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1,new Point(1,1));	
		boardGame[1][1] = champ1;

		Constructor<?> constructor = Class.forName(coverPath).getConstructor( int.class, int.class);
		Object cover = constructor.newInstance(1,0);
		boardGame[1][0] = cover;

		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame,boardGame);


		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1,10);	


		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		setAttackDamage.invoke(firstTeam.get(0),r.nextInt(50) + 1);



		try {
			Method m= createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while(turnOrderSize != 0) {
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
					m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath),"LEFT"));
					int newHP = (Integer) m5.invoke(cover);

					Method m4 = champ1.getClass().getMethod("getAttackDamage");
					int attackDamage = (Integer) m4.invoke(champ1);

					int expectedHP = oldHP - attackDamage;

					assertTrue("The HP of the attacked cover is not updated correctly. Expected "  + expectedHP + " but was " + newHP+ ".",
							newHP == expectedHP);




				} catch (NoSuchMethodException e) {
					fail("Game class should have attack method");
				}
			}	catch (NoSuchMethodException e) {
				fail("Priority Queue class should have insert method");
			}

		}	catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}


	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testAttackedChampionRemovedFromTeam() throws Exception {
		ArrayList<Object> createdGameAndTeams = createGameAndTeams();
		Object createdGame = createdGameAndTeams.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) createdGameAndTeams.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) createdGameAndTeams.get(2);

		Object champ1 = firstTeam.get(0);
		firstTeam.get(1);
		firstTeam.get(2);

		secondTeam.get(0);
		secondTeam.get(1);
		Object champ6 = secondTeam.get(2);
		
//		System.out.println("Champ 6" + champ6);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame=(Object[][])getBoardGame.invoke(createdGame);

		Method setLocation = champ1.getClass().getMethod("setLocation", Point.class);
		setLocation.invoke(champ1,new Point(1,1));	
		boardGame[1][1] = champ1;

		setLocation.invoke(champ6,new Point(0,1));	
		boardGame[0][1] = champ6;


		Field board = createdGame.getClass().getDeclaredField("board");
		board.setAccessible(true);
		board.set(createdGame,boardGame);


		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ1,10);	


		Method setAttackDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		Random r = new Random();
		int attackDamageRandom = r.nextInt(50) + 1;
		setAttackDamage.invoke(firstTeam.get(0), attackDamageRandom);
		
		
		try {
			
			Method setCurrentHP = champ6.getClass().getMethod("setCurrentHP", int.class);
			setCurrentHP.invoke(champ6,attackDamageRandom);	

		} catch(NoSuchMethodException e) {
			fail("Champion class should have setCurrentHP method");

		}
		
		
		
	



		try {
			Method m= createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);



			try {
				Method size = turnOrder.getClass().getMethod("size");

				int turnOrderSize = (int) size.invoke(turnOrder);

				try {
					Method remove = turnOrder.getClass().getMethod("remove");
					while(turnOrderSize != 0) {
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
							if(currentChamp != champ1) {
								setSpeed.invoke(champ1,2);
								setSpeed.invoke(champ6,10);

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
							m3.invoke(createdGame, Enum.valueOf((Class<Enum>) Class.forName(directionPath),"DOWN"));

							try {
								Method getSecondPlayer = createdGame.getClass().getMethod("getSecondPlayer");
								Object secondPlayer = getSecondPlayer.invoke(createdGame);
								try {
									Method getsecondPlayerTeam = secondPlayer.getClass().getMethod("getTeam");
									ArrayList<Object> secondPlayerTeam = (ArrayList<Object>) getsecondPlayerTeam.invoke(secondPlayer);
									
									

									for(int i = 0; i < secondPlayerTeam.size(); i++) {
//										System.out.println(champ1);
//										System.out.println(champ6);
//										System.out.println("Here" + secondPlayerTeam.get(i));
//										System.out.println("Champ 6 removed" + champ6);

										if(secondPlayerTeam.get(i).equals(champ6)) {
											fail("Champion should be removed from his player's team after being attacked if HP reaches 0.");
										}
									}


								} catch(NoSuchMethodException e) {
									fail("Player class should have getTeam method");

								}
							} catch(NoSuchMethodException e) {
								fail("Game class should have getSecondPlayer method");
							}




						} catch (NoSuchMethodException e) {
							fail("Game class should have attack method");
						}
					}	catch (NoSuchMethodException e) {
						fail("Priority Queue class should have insert method");
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
	
	
	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testEndTurnUpdatedDuration() throws Exception {
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
			Method m= createdGame.getClass().getMethod("getTurnOrder");
			Object turnOrder = m.invoke(createdGame);

			try {

				try {
					Method size = turnOrder.getClass().getMethod("size");

					int turnOrderSize = (int) size.invoke(turnOrder);

					try {
						Method remove = turnOrder.getClass().getMethod("remove");
						while(turnOrderSize != 0) {
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
		}	catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}

		//		try {
		//
		//			Method getCurrentChamp = createdGame.getClass().getMethod("getCurrentChampion");
		//
		//			Object currentChampion = getCurrentChamp.invoke(createdGame);

		try {
			Method getAppliedEffects = champ1.getClass().getMethod("getAppliedEffects");

			ArrayList<Object> champEffects = (ArrayList<Object>) getAppliedEffects.invoke(champ5);

			Constructor<?> constructor = Class.forName(embracePath).getConstructor( int.class);

			Random r = new Random();
			int durationOne = r.nextInt(10);
			int durationTwo = r.nextInt(10);
			int durationThree = r.nextInt(10);

			Object embraceEffect = constructor.newInstance(durationOne);


			constructor = Class.forName(powerUpPath).getConstructor( int.class);
			Object powerUpEffect =  constructor.newInstance(durationTwo);

			constructor = Class.forName(rootPath).getConstructor( int.class);
			Object rootEffect =  constructor.newInstance(durationThree);

			champEffects.add(powerUpEffect);
			champEffects.add(embraceEffect);
			champEffects.add(rootEffect);

			try {
				Field appliedEffects = champ5.getClass().getField("appliedEffects");
				appliedEffects.setAccessible(true);
				appliedEffects.set(champ5,champEffects);

				try {

					Method endTurn = createdGame.getClass().getMethod("endTurn");
					endTurn.invoke(createdGame);

					ArrayList<Object> champEffectsUpdated = (ArrayList<Object>) getAppliedEffects.invoke(champ5);

					try {
						Method getDuration = powerUpEffect.getClass().getMethod("getDuration");

						int updatedDurationOne = (int) getDuration.invoke(champEffectsUpdated.get(0));						
						int updatedDurationTwo = (int) getDuration.invoke(champEffectsUpdated.get(1));
						int updatedDurationThree = (int) getDuration.invoke(champEffectsUpdated.get(2));


						assertTrue("endTurn should update the duration of the champion's applied effects.",
								updatedDurationOne == (durationOne-1));
						assertTrue("endTurn should update the duration of the champion's applied effects.",
								updatedDurationTwo == (durationTwo-1));						
						assertTrue("endTurn should update the duration of the champion's applied effects.",
								updatedDurationThree == (durationThree-1));


					} catch(NoSuchMethodException e) {
						fail("Effect class should have getDuration method");

					}



				} catch(NoSuchMethodException e) {
					fail("Game class should have endTurn method");

				}

			} catch(NoSuchFieldException e) {

			}





		} catch (NoSuchMethodException e) {
			fail("Champion class should have getAppliedEffects method");

		}


		//		} catch (NoSuchMethodException e) {
		//			fail("Game class should have getCurrentChampion method");
		//
		//		}


	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testEndTurnRemovesStunnedChampion2() throws Exception {
		
		ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
		Object createdGame = newGame.get(0);
		ArrayList<Object> firstTeam = (ArrayList<Object>) newGame.get(1);
		ArrayList<Object> secondTeam = (ArrayList<Object>) newGame.get(2);
		
		firstTeam.get(0);
		Object champ2 = firstTeam.get(1);
		Object champ3 = firstTeam.get(2);

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

					try {
						while(turnOrderSize != 0) {
							remove.invoke(turnOrder);
							turnOrderSize = (int) size.invoke(turnOrder);

						} 


						try {
							Method setCondition = champ5.getClass().getMethod("setCondition", Class.forName(conditionPath));
							setCondition.invoke(champ5,  Enum.valueOf((Class<Enum>) Class.forName(conditionPath),"INACTIVE"));
							setCondition.invoke(champ4,  Enum.valueOf((Class<Enum>) Class.forName(conditionPath),"INACTIVE"));

							try {

								Method getAppliedEffects = champ4.getClass().getMethod("getAppliedEffects");

								ArrayList<Object> champEffects = (ArrayList<Object>) getAppliedEffects.invoke(champ4);

								Constructor<?> constructor = Class.forName(stunPath).getConstructor( int.class);

								int durationOne = 3;

								Object stunEffect = constructor.newInstance(durationOne);

								champEffects.add(stunEffect);
								




								try {
									Field appliedEffects = champ2.getClass().getSuperclass().getDeclaredField("appliedEffects");
									appliedEffects.setAccessible(true);
									appliedEffects.set(champ5,champEffects);
									appliedEffects.set(champ4,champEffects);

								} catch (NoSuchFieldException e) {
									fail("Champion class should have appliedEffects attribute");

								}
							} catch (NoSuchMethodException e) {
								fail("Champion class should have getAppliedEffects method");

							} 
						}catch (NoSuchMethodException e) {
							fail("Champion class should have setCondition method");

						} 


						Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
						m2.invoke(turnOrder, champ3);
						m2.invoke(turnOrder, champ4);
						m2.invoke(turnOrder, champ5);
						m2.invoke(turnOrder, champ6);
						
						try {
							Method endTurn = createdGame.getClass().getMethod("endTurn");
							endTurn.invoke(createdGame);
							
							turnOrderSize = (int) size.invoke(turnOrder);

							while(turnOrderSize != 0) {
								Object removedChamp = remove.invoke(turnOrder);
								if(removedChamp == champ5 || removedChamp == champ4) {
									fail("endTurn should remove any inactive champions from the turnOrder queue till an active champion is found.");
								
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
		}	catch (NoSuchMethodException e) {
			fail("Game class should have getTurnOrder method");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicShieldBlockResources() {
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

			Field action = Class.forName(championPath).getDeclaredField("currentActionPoints");

			action.setAccessible(true);
			int actions = (int) action.get(target);
			int expected = actions - 2;
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

			int actual = (int) action.get(target);
			assertEquals("The method \"" + "attack" + "\" in class " + createdGame.getClass().getSimpleName()
					+ " should set the correct value of variable \"" + "currentActionPoints"
					+ "\". If a champion attacks a target with a Shield effect and the attack is blocked, all required resources for this attack should be deducted from the champion.",
					expected, actual);

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
	public void applyLogicShieldBlockDmgAbilityDirectionalResourcesActions() {
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
				assertTrue(
						e1.getCause()
								+ " occurred while creating an instance of \"Player\".",
						false);
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
				try {
					champPlayer1 = constructorChampion.newInstance("ironman",
							1, 5, 3, 5, 2, 6);
				} catch (InvocationTargetException e) {
					assertTrue(e.getCause()
							+ " occurred while creating an instance of \""
							+ Class.forName(champInstance).getSimpleName()
							+ "\".", false);
				}
			} catch (InstantiationException e) {
				assertTrue("Objects of type \""
						+ Class.forName(champInstance).getSimpleName()
						+ "\" can be instantiated.", false);
			}

			Object champPlayer2 = null;

			try {
				champPlayer2 = constructorChampion.newInstance("loki", 100, 5,
						3, 4, 5, 6);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \""
						+ Class.forName(champInstance).getSimpleName()
						+ "\" can be instantiated.", false);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause()
						+ " occurred while creating an instance of \""
						+ Class.forName(champInstance).getSimpleName() + "\".",
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
				assertTrue(
						e1.getCause()
								+ " occurred while invoking \"getBoard\" method on an instance of \"Game\".",
						false);

			}

			boardGame[2][2] = champPlayer1;

			boardGame[2][3] = champPlayer2;

			Field board = createdGame.getClass().getDeclaredField("board");
			board.setAccessible(true);
			board.set(createdGame, boardGame);

			Constructor<?> constructorShield = Class.forName(shieldPath)
					.getConstructor(int.class);
			Object shield = null;
			try {
				shield = constructorShield
						.newInstance((int) (Math.random() * 10) + 1);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"Shield\" can be instantiated.",
						false);

			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while creating an instance of \"Shield\".",
						false);

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
						e.getCause()
								+ " occurred while creating an instance of \"PriorityQueue\".",
						false);

			}
			Method insert = Class.forName(priorityQueuePath).getDeclaredMethod(
					"insert", Comparable.class);
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

			}
			Method remove = Class.forName(priorityQueuePath).getDeclaredMethod(
					"remove");
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
				Field appliedEffects = enemyEffect
						.getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				((ArrayList<Object>) appliedEffects.get(enemy)).add(shield);

			}
			
			
			Constructor<?> constructorDamagingAbility = Class.forName(dmgPath).getConstructor(
					String.class, int.class, int.class, int.class,
					Class.forName(areaOfEffectPath), int.class, int.class);
			Object damagingAbilityObject = null;
			try {
				damagingAbilityObject = constructorDamagingAbility.newInstance(
						"Punch", 0, 1, 1, Enum.valueOf(
								(Class<Enum>) Class.forName(areaOfEffectPath),
								"DIRECTIONAL"), 1, 50);
			} catch (InvocationTargetException e1) {
				assertTrue(
						e1.getCause()
								+ " occurred while creating an instance of \"DamagingAbility\".",
						false);

			}
			
			if (target.getClass().equals(Class.forName(antiHeroPath))
					|| (target.getClass().equals(Class.forName(heroPath)))
					|| (target.getClass().equals(Class.forName(villainPath)))) {
				Class<?> enemyEffect = Class.forName(championPath);
				Field abilities = enemyEffect
						.getDeclaredField("abilities");
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

			Method m3 = createdGame.getClass().getMethod("castAbility",
					Class.forName(abilitiesPath),Class.forName(directionPath));

			Field locationTarget = Class.forName(championPath)
					.getDeclaredField("location");
			locationTarget.setAccessible(true);
			Point locationT = (Point) locationTarget.get(target);

			Field action = Class.forName(championPath).getDeclaredField(
					"currentActionPoints");

			action.setAccessible(true);
			int actions = (int) action.get(target);

			int expected = actions-1;
			
			
		

			try {
				if (locationT.y == 3) {
					m3.invoke(createdGame,damagingAbilityObject ,Enum.valueOf(
							(Class<Enum>) Class.forName(directionPath), "LEFT"));

				} else {
					m3.invoke(createdGame,damagingAbilityObject,
							Enum.valueOf(
									(Class<Enum>) Class.forName(directionPath),
									"RIGHT"));
				}
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"castAbility\" method on an instance of \"Game\".",
						false);

			}
			
			
			int actual = (int) action.get(target);
			assertEquals("The method \"" + "castAbility" + "\" in class "
				+ createdGame.getClass().getSimpleName()
				+ " should set the correct value of variable \""
				+ "currentActionPoints" + "\". If a champion casts a damaging ability on a target with a Shield effect and the ability is blocked, all required resources for this ability should be deducted from the champion.", expected,actual);


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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicShieldBlockDmgAbilitySurroundResourcesActions() {
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
				assertTrue(
						e1.getCause()
								+ " occurred while creating an instance of \"Player\".",
						false);
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
				try {
					champPlayer1 = constructorChampion.newInstance("ironman",
							1, 5, 3, 5, 2, 6);
				} catch (InvocationTargetException e) {
					assertTrue(e.getCause()
							+ " occurred while creating an instance of \""
							+ Class.forName(champInstance).getSimpleName()
							+ "\".", false);
				}
			} catch (InstantiationException e) {
				assertTrue("Objects of type \""
						+ Class.forName(champInstance).getSimpleName()
						+ "\" can be instantiated.", false);
			}

			Object champPlayer2 = null;

			try {
				champPlayer2 = constructorChampion.newInstance("loki", 100, 5,
						3, 4, 5, 6);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \""
						+ Class.forName(champInstance).getSimpleName()
						+ "\" can be instantiated.", false);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause()
						+ " occurred while creating an instance of \""
						+ Class.forName(champInstance).getSimpleName() + "\".",
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
				assertTrue(
						e1.getCause()
								+ " occurred while invoking \"getBoard\" method on an instance of \"Game\".",
						false);

			}

			boardGame[2][2] = champPlayer1;

			boardGame[2][3] = champPlayer2;

			Field board = createdGame.getClass().getDeclaredField("board");
			board.setAccessible(true);
			board.set(createdGame, boardGame);

			Constructor<?> constructorShield = Class.forName(shieldPath)
					.getConstructor(int.class);
			Object shield = null;
			try {
				shield = constructorShield
						.newInstance((int) (Math.random() * 10) + 1);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"Shield\" can be instantiated.",
						false);

			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while creating an instance of \"Shield\".",
						false);

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
						e.getCause()
								+ " occurred while creating an instance of \"PriorityQueue\".",
						false);

			}
			Method insert = Class.forName(priorityQueuePath).getDeclaredMethod(
					"insert", Comparable.class);
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

			}
			Method remove = Class.forName(priorityQueuePath).getDeclaredMethod(
					"remove");
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
				Field appliedEffects = enemyEffect
						.getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				((ArrayList<Object>) appliedEffects.get(enemy)).add(shield);

			}
			
			
			Constructor<?> constructorDamagingAbility = Class.forName(dmgPath).getConstructor(
					String.class, int.class, int.class, int.class,
					Class.forName(areaOfEffectPath), int.class, int.class);
			Object damagingAbilityObject = null;
			try {
				damagingAbilityObject = constructorDamagingAbility.newInstance(
						"Punch", 0, 1, 1, Enum.valueOf(
								(Class<Enum>) Class.forName(areaOfEffectPath),
								"SURROUND"), 1, 50);
			} catch (InvocationTargetException e1) {
				assertTrue(
						e1.getCause()
								+ " occurred while creating an instance of \"DamagingAbility\".",
						false);

			}
			
			if (target.getClass().equals(Class.forName(antiHeroPath))
					|| (target.getClass().equals(Class.forName(heroPath)))
					|| (target.getClass().equals(Class.forName(villainPath)))) {
				Class<?> enemyEffect = Class.forName(championPath);
				Field abilities = enemyEffect
						.getDeclaredField("abilities");
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

			Method m3 = createdGame.getClass().getMethod("castAbility",
					Class.forName(abilitiesPath));

			Field locationTarget = Class.forName(championPath)
					.getDeclaredField("location");
			locationTarget.setAccessible(true);
			Point locationT = (Point) locationTarget.get(target);
			Field action = Class.forName(championPath).getDeclaredField(
					"currentActionPoints");

			action.setAccessible(true);
			int actions = (int) action.get(target);

			int expected = actions-1;

			try {
				if (locationT.y == 3) {
					m3.invoke(createdGame,damagingAbilityObject);

				} else {
					m3.invoke(createdGame,damagingAbilityObject);
				}
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"castAbility\" method on an instance of \"Game\".",
						false);

			}

			

			
			
			int actual = (int) action.get(target);
			assertEquals("The method \"" + "castAbility" + "\" in class "
				+ createdGame.getClass().getSimpleName()
				+ " should set the correct value of variable \""
				+ "currentActionPoints" + "\". If a champion casts a damaging ability on a target with a Shield effect and the ability is blocked, all required resources for this ability should be deducted from the champion.", expected,actual);




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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicShieldBlockDmgAbilitySingleTargetResourcesActions() {
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
				assertTrue(
						e1.getCause()
								+ " occurred while creating an instance of \"Player\".",
						false);
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
				try {
					champPlayer1 = constructorChampion.newInstance("ironman",
							1, 5, 3, 5, 2, 6);
				} catch (InvocationTargetException e) {
					assertTrue(e.getCause()
							+ " occurred while creating an instance of \""
							+ Class.forName(champInstance).getSimpleName()
							+ "\".", false);
				}
			} catch (InstantiationException e) {
				assertTrue("Objects of type \""
						+ Class.forName(champInstance).getSimpleName()
						+ "\" can be instantiated.", false);
			}

			Object champPlayer2 = null;

			try {
				champPlayer2 = constructorChampion.newInstance("loki", 100, 5,
						3, 4, 5, 6);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \""
						+ Class.forName(champInstance).getSimpleName()
						+ "\" can be instantiated.", false);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause()
						+ " occurred while creating an instance of \""
						+ Class.forName(champInstance).getSimpleName() + "\".",
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
				assertTrue(
						e1.getCause()
								+ " occurred while invoking \"getBoard\" method on an instance of \"Game\".",
						false);

			}

			boardGame[2][2] = champPlayer1;

			boardGame[2][3] = champPlayer2;

			Field board = createdGame.getClass().getDeclaredField("board");
			board.setAccessible(true);
			board.set(createdGame, boardGame);

			Constructor<?> constructorShield = Class.forName(shieldPath)
					.getConstructor(int.class);
			Object shield = null;
			try {
				shield = constructorShield
						.newInstance((int) (Math.random() * 10) + 1);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"Shield\" can be instantiated.",
						false);

			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while creating an instance of \"Shield\".",
						false);

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
						e.getCause()
								+ " occurred while creating an instance of \"PriorityQueue\".",
						false);

			}
			Method insert = Class.forName(priorityQueuePath).getDeclaredMethod(
					"insert", Comparable.class);
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

			}
			Method remove = Class.forName(priorityQueuePath).getDeclaredMethod(
					"remove");
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
				Field appliedEffects = enemyEffect
						.getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				((ArrayList<Object>) appliedEffects.get(enemy)).add(shield);

			}
			
			
			Constructor<?> constructorDamagingAbility = Class.forName(dmgPath).getConstructor(
					String.class, int.class, int.class, int.class,
					Class.forName(areaOfEffectPath), int.class, int.class);
			Object damagingAbilityObject = null;
			try {
				damagingAbilityObject = constructorDamagingAbility.newInstance(
						"Punch", 0, 1, 1, Enum.valueOf(
								(Class<Enum>) Class.forName(areaOfEffectPath),
								"SINGLETARGET"), 1, 50);
			} catch (InvocationTargetException e1) {
				assertTrue(
						e1.getCause()
								+ " occurred while creating an instance of \"DamagingAbility\".",
						false);

			}
			
			if (target.getClass().equals(Class.forName(antiHeroPath))
					|| (target.getClass().equals(Class.forName(heroPath)))
					|| (target.getClass().equals(Class.forName(villainPath)))) {
				Class<?> enemyEffect = Class.forName(championPath);
				Field abilities = enemyEffect
						.getDeclaredField("abilities");
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

			Method m3 = createdGame.getClass().getMethod("castAbility",
					Class.forName(abilitiesPath),int.class,int.class);

			Field locationTarget = Class.forName(championPath)
					.getDeclaredField("location");
			locationTarget.setAccessible(true);
			Point locationT = (Point) locationTarget.get(target);

			Field action = Class.forName(championPath).getDeclaredField(
					"currentActionPoints");

			action.setAccessible(true);
			int actions = (int) action.get(target);

			int expected = actions-1;

			try {
				if (locationT.y == 3) {
					m3.invoke(createdGame,damagingAbilityObject,2,2);

				} else {
					m3.invoke(createdGame,damagingAbilityObject,2,3);
				}
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"castAbility\" method on an instance of \"Game\".",
						false);

			}



			
			int actual = (int) action.get(target);
			assertEquals("The method \"" + "castAbility" + "\" in class "
				+ createdGame.getClass().getSimpleName()
				+ " should set the correct value of variable \""
				+ "currentActionPoints" + "\". If a champion casts a damaging ability on a target with a Shield effect and the ability is blocked, all required resources for this ability should be deducted from the champion.", expected,actual);


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

	}@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicShieldBlockDmgAbilityDirectionalResourcesMana() {
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
				assertTrue(
						e1.getCause()
								+ " occurred while creating an instance of \"Player\".",
						false);
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
				try {
					champPlayer1 = constructorChampion.newInstance("ironman",
							1, 5, 3, 5, 2, 6);
				} catch (InvocationTargetException e) {
					assertTrue(e.getCause()
							+ " occurred while creating an instance of \""
							+ Class.forName(champInstance).getSimpleName()
							+ "\".", false);
				}
			} catch (InstantiationException e) {
				assertTrue("Objects of type \""
						+ Class.forName(champInstance).getSimpleName()
						+ "\" can be instantiated.", false);
			}

			Object champPlayer2 = null;

			try {
				champPlayer2 = constructorChampion.newInstance("loki", 100, 5,
						3, 4, 5, 6);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \""
						+ Class.forName(champInstance).getSimpleName()
						+ "\" can be instantiated.", false);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause()
						+ " occurred while creating an instance of \""
						+ Class.forName(champInstance).getSimpleName() + "\".",
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
				assertTrue(
						e1.getCause()
								+ " occurred while invoking \"getBoard\" method on an instance of \"Game\".",
						false);

			}

			boardGame[2][2] = champPlayer1;

			boardGame[2][3] = champPlayer2;

			Field board = createdGame.getClass().getDeclaredField("board");
			board.setAccessible(true);
			board.set(createdGame, boardGame);

			Constructor<?> constructorShield = Class.forName(shieldPath)
					.getConstructor(int.class);
			Object shield = null;
			try {
				shield = constructorShield
						.newInstance((int) (Math.random() * 10) + 1);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"Shield\" can be instantiated.",
						false);

			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while creating an instance of \"Shield\".",
						false);

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
						e.getCause()
								+ " occurred while creating an instance of \"PriorityQueue\".",
						false);

			}
			Method insert = Class.forName(priorityQueuePath).getDeclaredMethod(
					"insert", Comparable.class);
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

			}
			Method remove = Class.forName(priorityQueuePath).getDeclaredMethod(
					"remove");
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
				Field appliedEffects = enemyEffect
						.getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				((ArrayList<Object>) appliedEffects.get(enemy)).add(shield);

			}
			
			
			Constructor<?> constructorDamagingAbility = Class.forName(dmgPath).getConstructor(
					String.class, int.class, int.class, int.class,
					Class.forName(areaOfEffectPath), int.class, int.class);
			Object damagingAbilityObject = null;
			try {
				damagingAbilityObject = constructorDamagingAbility.newInstance(
						"Punch", 20, 1, 1, Enum.valueOf(
								(Class<Enum>) Class.forName(areaOfEffectPath),
								"DIRECTIONAL"), 1, 50);
			} catch (InvocationTargetException e1) {
				assertTrue(
						e1.getCause()
								+ " occurred while creating an instance of \"DamagingAbility\".",
						false);

			}
			
			if (target.getClass().equals(Class.forName(antiHeroPath))
					|| (target.getClass().equals(Class.forName(heroPath)))
					|| (target.getClass().equals(Class.forName(villainPath)))) {
				Class<?> enemyEffect = Class.forName(championPath);
				Field abilities = enemyEffect
						.getDeclaredField("abilities");
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

			Method m3 = createdGame.getClass().getMethod("castAbility",
					Class.forName(abilitiesPath),Class.forName(directionPath));

			Field locationTarget = Class.forName(championPath)
					.getDeclaredField("location");
			locationTarget.setAccessible(true);
			Point locationT = (Point) locationTarget.get(target);

			Field mana = Class.forName(championPath).getDeclaredField(
					"mana");

			mana.setAccessible(true);
			mana.set(target, 100);

			int expected = 80;
			
			
		

			try {
				if (locationT.y == 3) {
					m3.invoke(createdGame,damagingAbilityObject ,Enum.valueOf(
							(Class<Enum>) Class.forName(directionPath), "LEFT"));

				} else {
					m3.invoke(createdGame,damagingAbilityObject,
							Enum.valueOf(
									(Class<Enum>) Class.forName(directionPath),
									"RIGHT"));
				}
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"castAbility\" method on an instance of \"Game\".",
						false);

			}
			
			
			int actual = (int) mana.get(target);
			assertEquals("The method \"" + "castAbility" + "\" in class "
				+ createdGame.getClass().getSimpleName()
				+ " should set the correct value of variable \""
				+ "mana" + "\". If a champion casts a damaging ability on a target with a Shield effect and the ability is blocked, all required resources for this ability should be deducted from the champion.", expected,actual);


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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicShieldBlockDmgAbilitySurroundResourcesMana() {
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
				assertTrue(
						e1.getCause()
								+ " occurred while creating an instance of \"Player\".",
						false);
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
				try {
					champPlayer1 = constructorChampion.newInstance("ironman",
							1, 5, 3, 5, 2, 6);
				} catch (InvocationTargetException e) {
					assertTrue(e.getCause()
							+ " occurred while creating an instance of \""
							+ Class.forName(champInstance).getSimpleName()
							+ "\".", false);
				}
			} catch (InstantiationException e) {
				assertTrue("Objects of type \""
						+ Class.forName(champInstance).getSimpleName()
						+ "\" can be instantiated.", false);
			}

			Object champPlayer2 = null;

			try {
				champPlayer2 = constructorChampion.newInstance("loki", 100, 5,
						3, 4, 5, 6);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \""
						+ Class.forName(champInstance).getSimpleName()
						+ "\" can be instantiated.", false);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause()
						+ " occurred while creating an instance of \""
						+ Class.forName(champInstance).getSimpleName() + "\".",
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
				assertTrue(
						e1.getCause()
								+ " occurred while invoking \"getBoard\" method on an instance of \"Game\".",
						false);

			}

			boardGame[2][2] = champPlayer1;

			boardGame[2][3] = champPlayer2;

			Field board = createdGame.getClass().getDeclaredField("board");
			board.setAccessible(true);
			board.set(createdGame, boardGame);

			Constructor<?> constructorShield = Class.forName(shieldPath)
					.getConstructor(int.class);
			Object shield = null;
			try {
				shield = constructorShield
						.newInstance((int) (Math.random() * 10) + 1);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"Shield\" can be instantiated.",
						false);

			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while creating an instance of \"Shield\".",
						false);

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
						e.getCause()
								+ " occurred while creating an instance of \"PriorityQueue\".",
						false);

			}
			Method insert = Class.forName(priorityQueuePath).getDeclaredMethod(
					"insert", Comparable.class);
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

			}
			Method remove = Class.forName(priorityQueuePath).getDeclaredMethod(
					"remove");
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
				Field appliedEffects = enemyEffect
						.getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				((ArrayList<Object>) appliedEffects.get(enemy)).add(shield);

			}
			
			
			Constructor<?> constructorDamagingAbility = Class.forName(dmgPath).getConstructor(
					String.class, int.class, int.class, int.class,
					Class.forName(areaOfEffectPath), int.class, int.class);
			Object damagingAbilityObject = null;
			try {
				damagingAbilityObject = constructorDamagingAbility.newInstance(
						"Punch", 20, 1, 1, Enum.valueOf(
								(Class<Enum>) Class.forName(areaOfEffectPath),
								"SURROUND"), 1, 50);
			} catch (InvocationTargetException e1) {
				assertTrue(
						e1.getCause()
								+ " occurred while creating an instance of \"DamagingAbility\".",
						false);

			}
			
			if (target.getClass().equals(Class.forName(antiHeroPath))
					|| (target.getClass().equals(Class.forName(heroPath)))
					|| (target.getClass().equals(Class.forName(villainPath)))) {
				Class<?> enemyEffect = Class.forName(championPath);
				Field abilities = enemyEffect
						.getDeclaredField("abilities");
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

			Method m3 = createdGame.getClass().getMethod("castAbility",
					Class.forName(abilitiesPath));

			Field locationTarget = Class.forName(championPath)
					.getDeclaredField("location");
			locationTarget.setAccessible(true);
			Point locationT = (Point) locationTarget.get(target);
			Field mana = Class.forName(championPath).getDeclaredField(
					"mana");

			mana.setAccessible(true);
			mana.set(target, 100);

			int expected = 80;

			try {
				if (locationT.y == 3) {
					m3.invoke(createdGame,damagingAbilityObject);

				} else {
					m3.invoke(createdGame,damagingAbilityObject);
				}
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"castAbility\" method on an instance of \"Game\".",
						false);

			}

			

			
			
			int actual = (int) mana.get(target);
			assertEquals("The method \"" + "castAbility" + "\" in class "
				+ createdGame.getClass().getSimpleName()
				+ " should set the correct value of variable \""
				+ "mana" + "\". If a champion casts a damaging ability on a target with a Shield effect and the ability is blocked, all required resources for this ability should be deducted from the champion.", expected,actual);




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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void applyLogicShieldBlockDmgAbilitySingleTargetResourcesMana() {
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
				assertTrue(
						e1.getCause()
								+ " occurred while creating an instance of \"Player\".",
						false);
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
				try {
					champPlayer1 = constructorChampion.newInstance("ironman",
							1, 5, 3, 5, 2, 6);
				} catch (InvocationTargetException e) {
					assertTrue(e.getCause()
							+ " occurred while creating an instance of \""
							+ Class.forName(champInstance).getSimpleName()
							+ "\".", false);
				}
			} catch (InstantiationException e) {
				assertTrue("Objects of type \""
						+ Class.forName(champInstance).getSimpleName()
						+ "\" can be instantiated.", false);
			}

			Object champPlayer2 = null;

			try {
				champPlayer2 = constructorChampion.newInstance("loki", 100, 5,
						3, 4, 5, 6);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \""
						+ Class.forName(champInstance).getSimpleName()
						+ "\" can be instantiated.", false);
			} catch (InvocationTargetException e) {
				assertTrue(e.getCause()
						+ " occurred while creating an instance of \""
						+ Class.forName(champInstance).getSimpleName() + "\".",
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
				assertTrue(
						e1.getCause()
								+ " occurred while invoking \"getBoard\" method on an instance of \"Game\".",
						false);

			}

			boardGame[2][2] = champPlayer1;

			boardGame[2][3] = champPlayer2;

			Field board = createdGame.getClass().getDeclaredField("board");
			board.setAccessible(true);
			board.set(createdGame, boardGame);

			Constructor<?> constructorShield = Class.forName(shieldPath)
					.getConstructor(int.class);
			Object shield = null;
			try {
				shield = constructorShield
						.newInstance((int) (Math.random() * 10) + 1);
			} catch (InstantiationException e) {
				assertTrue("Objects of type \"Shield\" can be instantiated.",
						false);

			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while creating an instance of \"Shield\".",
						false);

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
						e.getCause()
								+ " occurred while creating an instance of \"PriorityQueue\".",
						false);

			}
			Method insert = Class.forName(priorityQueuePath).getDeclaredMethod(
					"insert", Comparable.class);
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

			}
			Method remove = Class.forName(priorityQueuePath).getDeclaredMethod(
					"remove");
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
				Field appliedEffects = enemyEffect
						.getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				((ArrayList<Object>) appliedEffects.get(enemy)).add(shield);

			}
			
			
			Constructor<?> constructorDamagingAbility = Class.forName(dmgPath).getConstructor(
					String.class, int.class, int.class, int.class,
					Class.forName(areaOfEffectPath), int.class, int.class);
			Object damagingAbilityObject = null;
			try {
				damagingAbilityObject = constructorDamagingAbility.newInstance(
						"Punch", 20, 1, 1, Enum.valueOf(
								(Class<Enum>) Class.forName(areaOfEffectPath),
								"SINGLETARGET"), 1, 50);
			} catch (InvocationTargetException e1) {
				assertTrue(
						e1.getCause()
								+ " occurred while creating an instance of \"DamagingAbility\".",
						false);

			}
			
			if (target.getClass().equals(Class.forName(antiHeroPath))
					|| (target.getClass().equals(Class.forName(heroPath)))
					|| (target.getClass().equals(Class.forName(villainPath)))) {
				Class<?> enemyEffect = Class.forName(championPath);
				Field abilities = enemyEffect
						.getDeclaredField("abilities");
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

			Method m3 = createdGame.getClass().getMethod("castAbility",
					Class.forName(abilitiesPath),int.class,int.class);

			Field locationTarget = Class.forName(championPath)
					.getDeclaredField("location");
			locationTarget.setAccessible(true);
			Point locationT = (Point) locationTarget.get(target);

			Field mana = Class.forName(championPath).getDeclaredField(
					"mana");

			mana.setAccessible(true);
			mana.set(target, 100);

			int expected = 80;

			try {
				if (locationT.y == 3) {
					m3.invoke(createdGame,damagingAbilityObject,2,2);

				} else {
					m3.invoke(createdGame,damagingAbilityObject,2,3);
				}
			} catch (InvocationTargetException e) {
				assertTrue(
						e.getCause()
								+ " occurred while invoking \"castAbility\" method on an instance of \"Game\".",
						false);

			}



			
			int actual = (int) mana.get(target);
			assertEquals("The method \"" + "castAbility" + "\" in class "
				+ createdGame.getClass().getSimpleName()
				+ " should set the correct value of variable \""
				+ "mana" + "\". If a champion casts a damaging ability on a target with a Shield effect and the ability is blocked, all required resources for this ability should be deducted from the champion.", expected,actual);


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

	private boolean isPositive(int i) {
		return i > 0 ? true : false;
	}

	@SuppressWarnings("rawtypes")
	private void testClassIsAbstract(Class aClass) {
		assertTrue("You should not be able to create new instances from " + aClass.getSimpleName() + " class.",
				Modifier.isAbstract(aClass.getModifiers()));
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

	private Object createDmgAbility(String areaOfEffect) {
		try {
			Constructor<?> dmgAbilityConstructor = Class.forName(dmgPath).getConstructor(String.class, int.class,
					int.class, int.class, Class.forName(areaOfEffectPath), int.class, int.class);
			Class<?> c = Class.forName(areaOfEffectPath);

			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, areaOfEffect);
			Object dmgAbility = dmgAbilityConstructor.newInstance("Shield throw", 140, 4, 1, value, 1, 150);
			return dmgAbility;

		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | InstantiationException e) {

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

	private void testClassImplementsInterface(Class<?> aClass, Class<?> iClass) {
		assertTrue("Class \"" + aClass.getSimpleName() + "\" should implement \"" + iClass.getSimpleName()
				+ "\" interface.", iClass.isAssignableFrom(aClass));
	}

	private void testGetterMethodExistsInClass(Class<?> aClass, String methodName, Class<?> returnedType,
			boolean readvariable) {
		Method m = null;
		boolean found = true;
		try {
			m = aClass.getDeclaredMethod(methodName);
		} catch (NoSuchMethodException e) {
			found = false;
		}

		String varName = "";
		if (returnedType == boolean.class)
			varName = methodName.substring(2, 3).toLowerCase() + methodName.substring(3);
		else
			varName = methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
		if (readvariable) {
			assertTrue("The \"" + varName + "\" instance variable in class " + aClass.getSimpleName()
					+ " is a READ variable.", found);
			assertTrue("Incorrect return type for " + methodName + " method in " + aClass.getSimpleName() + " class.",
					m.getReturnType().isAssignableFrom(returnedType));
		} else {
			assertFalse("The \"" + varName + "\" instance variable in class " + aClass.getSimpleName()
					+ " is not a READ variable.", found);
		}

	}

	private void testGetterLogic(Object createdObject, String name, Object value) throws Exception {

		Field f = null;
		Class<?> curr = createdObject.getClass();

		while (f == null) {

			if (curr == Object.class)
				fail("Class " + createdObject.getClass().getSimpleName() + " should have the instance variable \""
						+ name + "\".");
			try {
				f = curr.getDeclaredField(name);
			} catch (NoSuchFieldException e) {
				curr = curr.getSuperclass();
			}

		}

		f.setAccessible(true);
		f.set(createdObject, value);

		Character c = name.charAt(0);

		String methodName = "get" + Character.toUpperCase(c) + name.substring(1, name.length());

		if (value.getClass().equals(Boolean.class))
			methodName = "is" + Character.toUpperCase(c) + name.substring(1, name.length());

		Method m = createdObject.getClass().getMethod(methodName);
		assertEquals(
				"The method \"" + methodName + "\" in class " + createdObject.getClass().getSimpleName()
						+ " should return the correct value of variable \"" + name + "\".",
				value, m.invoke(createdObject));

	}

	private static boolean containsMethodName(Method[] methods, String name) {
		for (Method method : methods) {
			if (method.getName().equals(name))
				return true;
		}
		return false;
	}

	private void testSetterMethodExistsInClass(Class<?> aClass, String methodName, Class<?> inputType,
			boolean writeVariable) {

		Method[] methods = aClass.getDeclaredMethods();
		String varName = methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
		if (writeVariable) {
			assertTrue("The \"" + varName + "\" instance variable in class " + aClass.getSimpleName()
					+ " is a WRITE variable.", containsMethodName(methods, methodName));
		} else {
			assertFalse("The \"" + varName + "\" instance variable in class " + aClass.getSimpleName()
					+ " is not a WRITE variable.", containsMethodName(methods, methodName));
			return;
		}
		Method m = null;
		boolean found = true;
		try {
			m = aClass.getDeclaredMethod(methodName, inputType);
		} catch (NoSuchMethodException e) {
			found = false;
		}

		assertTrue(aClass.getSimpleName() + " class should have " + methodName + " method that takes one "
				+ inputType.getSimpleName() + " parameter.", found);

		assertTrue("Incorrect return type for " + methodName + " method in " + aClass.getSimpleName() + ".",
				m.getReturnType().equals(Void.TYPE));

	}

	private void testSetterLogic(Object createdObject, String name, Object setValue, Object expectedValue,
			Class<?> type) throws Exception {

		Field f = null;
		Class<?> curr = createdObject.getClass();

		while (f == null) {

			if (curr == Object.class)
				fail("Class " + createdObject.getClass().getSimpleName() + " should have the instance variable \""
						+ name + "\".");
			try {
				f = curr.getDeclaredField(name);
			} catch (NoSuchFieldException e) {
				curr = curr.getSuperclass();
			}

		}

		f.setAccessible(true);

		Character c = name.charAt(0);
		String methodName = "set" + Character.toUpperCase(c) + name.substring(1, name.length());
		Method m = createdObject.getClass().getMethod(methodName, type);
		m.invoke(createdObject, setValue);

		assertEquals(
				"The method \"" + methodName + "\" in class " + createdObject.getClass().getSimpleName()
						+ " should set the correct value of variable \"" + name + "\".",
				expectedValue, f.get(createdObject));

	}

	private void testSetterLogicCover(Object createdObject, String name, Object setValue, Object expectedValue,
			Class<?> type) {

		Field f = null;
		Class<?> curr = createdObject.getClass();

		while (f == null) {

			if (curr == Object.class)
				fail("Class " + createdObject.getClass().getSimpleName() + " should have the instance variable \""
						+ name + "\".");
			try {
				f = curr.getDeclaredField(name);
			} catch (NoSuchFieldException e) {
				curr = curr.getSuperclass();
			}

		}

		f.setAccessible(true);

		Character c = name.charAt(0);
		String methodName = "set" + Character.toUpperCase(c) + name.substring(1, name.length());
		Method m;
		try {
			m = createdObject.getClass().getMethod(methodName, type);
			m.invoke(createdObject, setValue);
			if (name.equals("currentActionPoints") || name.equals("currentHP")) {
				if ((int) setValue > (int) expectedValue) {
					assertEquals(
							"The method \"" + methodName + "\" in class " + createdObject.getClass().getSimpleName()
									+ " should set the correct value of variable \"" + name
									+ "\". It should not exceed the maximum value.",
							expectedValue, f.get(createdObject));
				} else if ((int) setValue == -1 && (int) expectedValue == 0) {
					assertEquals("The method \"" + methodName + "\" in class "
							+ createdObject.getClass().getSimpleName() + " should set the correct value of variable \""
							+ name + "\". It should not be less than zero.", expectedValue, f.get(createdObject));
				} else {
					assertEquals(
							"The method \"" + methodName + "\" in class " + createdObject.getClass().getSimpleName()
									+ " should set the correct value of variable \"" + name + "\".",
							expectedValue, f.get(createdObject));
				}
			} else {
				assertEquals(
						"The method \"" + methodName + "\" in class " + createdObject.getClass().getSimpleName()
								+ " should set the correct value of variable \"" + name + "\".",
						expectedValue, f.get(createdObject));
			}
		} catch (NoSuchMethodException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			assertTrue(
					"The type \"" + createdObject.getClass().getSimpleName()
							+ "\" must implement the inherited abstract method Damageable." + methodName + "(int)",
					false);

			e.printStackTrace();
		}

	}

}
