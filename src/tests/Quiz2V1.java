package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;
import org.junit.Test;

public class Quiz2V1 {
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
	String championPath = "model.world.Champion";
	String antiHeroPath = "model.world.AntiHero";
	String heroPath = "model.world.Hero";
	String villainPath = "model.world.Villain";
	String conditionPath = "model.world.Condition";
	String directionPath = "model.world.Direction";

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

	@Test(timeout = 3000)
	public void testApplyLogicShockSpeed() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorShock;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = ((int) (Math.random() * 10) + 1) * 100;
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

			int expectedValue1 = (int) (randomSpeed * 0.7);
			int expectedValue2 = (int) (randomSpeed - randomSpeed * 0.3);

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
	public void testRemoveLogicShockSpeed() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorShock;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 100) + 20;
		int randomSpeed = ((int) (Math.random() * 10) + 1) * 100;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		int expectedValue = (int) (randomSpeed / 0.7);
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
	public void testApplyLogicShockAttackDamage() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorShock;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = ((int) (Math.random() * 10) + 1) * 100;
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

			int expectedValue1 = (int) (randomAttackDamage * 0.85);
			int expectedValue2 = (int) (randomAttackDamage - randomAttackDamage * 0.15);

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
	public void testRemoveLogicShockAttackDamage() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorShock;
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = ((int) (Math.random() * 10) + 1) * 100;
		;
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
			Method remove = Class.forName(shockPath).getDeclaredMethod("remove", Class.forName(championPath));
			remove.invoke(shockObject, championObject);
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("attackDamage");
			f.setAccessible(true);

			assertEquals(
					"The method \"" + "remove" + "\" in class " + shockObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "attackDamage" + "\".",
					(int) (randomAttackDamage / 0.85), f.get(championObject));

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
	public void testApplyLogicShockMana() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorShock;
		int randomMaxHP = 100;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 20) + 20;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int duration = (int) (Math.random() * 10) + 1;
		Object expectedValue = randomMana - 20;
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
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("mana");
			f.setAccessible(true);
			f.set(championObject, randomMana);
			apply.invoke(shockObject, championObject);
			assertEquals(
					"The method \"" + "apply" + "\" in class " + shockObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "mana" + "\".",
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
		} catch (NoSuchFieldException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
			e.printStackTrace();
		}

	}

	@Test(timeout = 3000)
	public void testRemoveLogicShockMana() {
		Constructor<?> constructorChampion;
		Constructor<?> constructorShock;
		int randomMaxHP = 100;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 20) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = 85;
		int expected = randomMana;
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
			Method apply = Class.forName(shockPath).getDeclaredMethod("remove", Class.forName(championPath));
			Class<?> curr = Class.forName(championPath);
			f = curr.getDeclaredField("mana");
			f.setAccessible(true);
			f.set(championObject, randomMana);
			apply.invoke(shockObject, championObject);
			assertEquals(
					"The mana deduction in the Shock apply effect is permanent. It should not be increased back when the effect is removed",
					expected, f.get(championObject));
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

	@SuppressWarnings("rawtypes")
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
				Class curr = firstPlayer.getClass();
				Field f = curr.getDeclaredField("team");
				f.setAccessible(true);
				f.set(firstPlayer, firstPlayerChamp1);

				// Create secondPlayer team

				ArrayList<Object> secPlayerChamp1 = new ArrayList<>();

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
				f.set(secondPlayer, secPlayerChamp1);

				ArrayList<Object> returnedObjects = new ArrayList<Object>();

				Object createdGame = gameConstructor.newInstance(firstPlayer, secondPlayer);

				returnedObjects.add(createdGame);
				returnedObjects.add(firstPlayerChamp1);
				returnedObjects.add(secPlayerChamp1);
				return returnedObjects;

			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testCurrentChampionHasShockExpiredSpeedUnchanged() throws Exception {
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
			Method getAppliedEffects = champ1.getClass().getMethod("getAppliedEffects");

			ArrayList<Object> champEffects = (ArrayList<Object>) getAppliedEffects.invoke(champ5);

			Constructor<?> constructor = Class.forName(shockPath).getConstructor(int.class);

			Random r = new Random();
			int durationOne = 1;
			int durationTwo = 1;
			int durationThree = r.nextInt(10) + 2;

			Object shockEffect = constructor.newInstance(durationOne);

			constructor = Class.forName(powerUpPath).getConstructor(int.class);
			Object powerUpEffect = constructor.newInstance(durationTwo);

			constructor = Class.forName(rootPath).getConstructor(int.class);
			Object rootEffect = constructor.newInstance(durationThree);

			champEffects.add(powerUpEffect);
			champEffects.add(shockEffect);
			champEffects.add(rootEffect);

			try {
				Field appliedEffects = champ5.getClass().getSuperclass().getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				appliedEffects.set(champ5, champEffects);

				try {
					Field speedField = champ5.getClass().getSuperclass().getDeclaredField("speed");
					speedField.setAccessible(true);
					int randomSpeed = ((int) (Math.random() * 10) + 1) * 100;
					speedField.set(champ5, randomSpeed);

					Method endTurn = createdGame.getClass().getMethod("endTurn");
					endTurn.invoke(createdGame);
					int speedAfter = speedField.getInt(champ5);
					int expectedSpeed = (int) (randomSpeed / 0.7);
					assertEquals(
							"If the current champion has a Shock effect that expired, the logic of the shock effect should not be applied on him therefore, his speed should not be changed",
							expectedSpeed, speedAfter);

				} catch (NoSuchMethodException e) {
					fail("Game class should have endTurn method");

				}

			} catch (NoSuchFieldException e) {

			}

		} catch (NoSuchMethodException e) {
			fail("Champion class should have getAppliedEffects method");

		}

	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testCurrentChampionHasShockExpiredManaUnchanged() throws Exception {
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
			Method getAppliedEffects = champ1.getClass().getMethod("getAppliedEffects");

			ArrayList<Object> champEffects = (ArrayList<Object>) getAppliedEffects.invoke(champ5);

			Constructor<?> constructor = Class.forName(shockPath).getConstructor(int.class);

			Random r = new Random();
			int durationOne = 1;
			int durationTwo = 1;
			int durationThree = r.nextInt(10) + 2;

			Object shockEffect = constructor.newInstance(durationOne);

			constructor = Class.forName(powerUpPath).getConstructor(int.class);
			Object powerUpEffect = constructor.newInstance(durationTwo);

			constructor = Class.forName(rootPath).getConstructor(int.class);
			Object rootEffect = constructor.newInstance(durationThree);

			champEffects.add(powerUpEffect);
			champEffects.add(shockEffect);
			champEffects.add(rootEffect);

			try {
				Field appliedEffects = champ5.getClass().getSuperclass().getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				appliedEffects.set(champ5, champEffects);

				try {
					Field manaField = champ5.getClass().getSuperclass().getDeclaredField("mana");
					manaField.setAccessible(true);
					int randomMana = (int) (Math.random() * 20) + 20;
					manaField.set(champ5, randomMana);

					Method endTurn = createdGame.getClass().getMethod("endTurn");
					endTurn.invoke(createdGame);
					int manaAfter = (int) manaField.get(champ5);
					assertEquals(
							"If the current champion has a Shock effect that expired, the logic of the effect should not be applied on him therefore, his mana should not be changed",
							randomMana, manaAfter);

				} catch (NoSuchMethodException e) {
					fail("Game class should have endTurn method");

				}

			} catch (NoSuchFieldException e) {

			}

		} catch (NoSuchMethodException e) {
			fail("Champion class should have getAppliedEffects method");

		}

	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testCurrentChampionHasShockExpiredAttackDamageUnchanged() throws Exception {
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
			Method getAppliedEffects = champ1.getClass().getMethod("getAppliedEffects");

			ArrayList<Object> champEffects = (ArrayList<Object>) getAppliedEffects.invoke(champ5);

			Constructor<?> constructor = Class.forName(shockPath).getConstructor(int.class);

			Random r = new Random();
			int durationOne = 1;
			int durationTwo = 1;
			int durationThree = r.nextInt(10) + 2;

			Object shockEffect = constructor.newInstance(durationOne);

			constructor = Class.forName(powerUpPath).getConstructor(int.class);
			Object powerUpEffect = constructor.newInstance(durationTwo);

			constructor = Class.forName(rootPath).getConstructor(int.class);
			Object rootEffect = constructor.newInstance(durationThree);

			champEffects.add(powerUpEffect);
			champEffects.add(shockEffect);
			champEffects.add(rootEffect);

			try {
				Field appliedEffects = champ5.getClass().getSuperclass().getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				appliedEffects.set(champ5, champEffects);

				try {
					Field damageField = champ5.getClass().getSuperclass().getDeclaredField("attackDamage");
					damageField.setAccessible(true);
					int randomAttackDamage = ((int) (Math.random() * 10) + 1) * 100;
					damageField.set(champ5, randomAttackDamage);

					Method endTurn = createdGame.getClass().getMethod("endTurn");
					endTurn.invoke(createdGame);
					int expectedDamage = (int) (randomAttackDamage / 0.85);
					int damageAfter = (int) damageField.get(champ5);

					assertEquals(
							"If the current champion has a Shock effect that expired, the logic of the shock effect should be not applied on him therefore, his attack damage should  not be changed",
							expectedDamage,damageAfter);

				} catch (NoSuchMethodException e) {
					fail("Game class should have endTurn method");

				}

			} catch (NoSuchFieldException e) {

			}

		} catch (NoSuchMethodException e) {
			fail("Champion class should have getAppliedEffects method");

		}

	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testCurrentChampionHasShockAppliedSpeedChanged() throws Exception {
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
			Method getAppliedEffects = champ1.getClass().getMethod("getAppliedEffects");

			ArrayList<Object> champEffects = (ArrayList<Object>) getAppliedEffects.invoke(champ5);

			Constructor<?> constructor = Class.forName(shockPath).getConstructor(int.class);

			Random r = new Random();
			int durationOne = 3;
			int durationTwo = 1;
			int durationThree = r.nextInt(10) + 2;

			Object shockEffect = constructor.newInstance(durationOne);

			constructor = Class.forName(powerUpPath).getConstructor(int.class);
			Object powerUpEffect = constructor.newInstance(durationTwo);

			constructor = Class.forName(rootPath).getConstructor(int.class);
			Object rootEffect = constructor.newInstance(durationThree);

			champEffects.add(powerUpEffect);
			champEffects.add(shockEffect);
			champEffects.add(rootEffect);

			try {
				Field appliedEffects = champ5.getClass().getSuperclass().getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				appliedEffects.set(champ5, champEffects);

				try {
					Field speedField = champ5.getClass().getSuperclass().getDeclaredField("speed");
					speedField.setAccessible(true);
					int randomSpeed = ((int) (Math.random() * 10) + 1) * 100;
					speedField.set(champ5, randomSpeed);

					Method endTurn = createdGame.getClass().getMethod("endTurn");
					endTurn.invoke(createdGame);
					int expectedValue1 = (int) (randomSpeed * 0.7);
					int expectedValue2 = (int) (randomSpeed - randomSpeed * 0.3);

					boolean flag = true;
					if (!(expectedValue1 == (int) speedField.get(champ5)
							|| expectedValue2 == (int) speedField.get(champ5))) {
						flag = false;
					}

					assertTrue(
							"If the current champion has a Shock effect that did not expire, the logic of the shock effect should be applied on him therefore, his speed should be updated correctly",
							flag);

				} catch (NoSuchMethodException e) {
					fail("Game class should have endTurn method");

				}

			} catch (NoSuchFieldException e) {

			}

		} catch (NoSuchMethodException e) {
			fail("Champion class should have getAppliedEffects method");

		}

	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testCurrentChampionHasShockAppliedManaChanged() throws Exception {
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
			Method getAppliedEffects = champ1.getClass().getMethod("getAppliedEffects");

			ArrayList<Object> champEffects = (ArrayList<Object>) getAppliedEffects.invoke(champ5);

			Constructor<?> constructor = Class.forName(shockPath).getConstructor(int.class);

			Random r = new Random();
			int durationOne = 3;
			int durationTwo = 1;
			int durationThree = r.nextInt(10) + 2;

			Object shockEffect = constructor.newInstance(durationOne);

			constructor = Class.forName(powerUpPath).getConstructor(int.class);
			Object powerUpEffect = constructor.newInstance(durationTwo);

			constructor = Class.forName(rootPath).getConstructor(int.class);
			Object rootEffect = constructor.newInstance(durationThree);

			champEffects.add(powerUpEffect);
			champEffects.add(shockEffect);
			champEffects.add(rootEffect);

			try {
				Field appliedEffects = champ5.getClass().getSuperclass().getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				appliedEffects.set(champ5, champEffects);

				try {
					Field manaField = champ5.getClass().getSuperclass().getDeclaredField("mana");
					manaField.setAccessible(true);
					int randomMana = (int) (Math.random() * 20) + 20;
					manaField.set(champ5, randomMana);

					Method endTurn = createdGame.getClass().getMethod("endTurn");
					endTurn.invoke(createdGame);
					int manaAfter = (int) manaField.get(champ5);
					assertEquals(
							"If the current champion has a Shock effect that did not expire, the logic of the effect should be applied on him therefore, his mana should be updated correctly",
							randomMana - 20, manaAfter);

				} catch (NoSuchMethodException e) {
					fail("Game class should have endTurn method");

				}

			} catch (NoSuchFieldException e) {

			}

		} catch (NoSuchMethodException e) {
			fail("Champion class should have getAppliedEffects method");

		}

	}

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testCurrentChampionHasShockAppliedAttackDamageChanged() throws Exception {
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
			Method getAppliedEffects = champ1.getClass().getMethod("getAppliedEffects");

			ArrayList<Object> champEffects = (ArrayList<Object>) getAppliedEffects.invoke(champ5);

			Constructor<?> constructor = Class.forName(shockPath).getConstructor(int.class);

			Random r = new Random();
			int durationOne = 3;
			int durationTwo = 1;
			int durationThree = r.nextInt(10) + 2;

			Object shockEffect = constructor.newInstance(durationOne);

			constructor = Class.forName(powerUpPath).getConstructor(int.class);
			Object powerUpEffect = constructor.newInstance(durationTwo);

			constructor = Class.forName(rootPath).getConstructor(int.class);
			Object rootEffect = constructor.newInstance(durationThree);

			champEffects.add(powerUpEffect);
			champEffects.add(shockEffect);
			champEffects.add(rootEffect);

			try {
				Field appliedEffects = champ5.getClass().getSuperclass().getDeclaredField("appliedEffects");
				appliedEffects.setAccessible(true);
				appliedEffects.set(champ5, champEffects);

				try {
					Field damageField = champ5.getClass().getSuperclass().getDeclaredField("attackDamage");
					damageField.setAccessible(true);
					int randomAttackDamage = ((int) (Math.random() * 10) + 1) * 100;
					damageField.set(champ5, randomAttackDamage);

					Method endTurn = createdGame.getClass().getMethod("endTurn");
					endTurn.invoke(createdGame);
					int expectedValue1 = (int) (randomAttackDamage * 0.85);
					int expectedValue2 = (int) (randomAttackDamage - randomAttackDamage * 0.15);
					boolean flag = true;
					if (!(expectedValue1 == (int) damageField.get(champ5)
							|| expectedValue2 == (int) damageField.get(champ5))) {
						flag = false;
					}

					assertTrue(
							"If the current champion has a Shock effect that did not expire, the logic of the shock effect should be applied on him therefore, his attack damage should be updated correctly",
							flag);

				} catch (NoSuchMethodException e) {
					fail("Game class should have endTurn method");

				}

			} catch (NoSuchFieldException e) {

			}

		} catch (NoSuchMethodException e) {
			fail("Champion class should have getAppliedEffects method");

		}

	}

}
