package tests;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
public class M1PublicTests {

	String directionPath = "model.world.Direction";
	String conditionPath = "model.world.Condition";
	String coverPath = "model.world.Cover";
	String championPath = "model.world.Champion";
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
	String disarmPath = "model.effects.Disarm";
	String effectPath = "model.effects.Effect";
	String effectTypePath = "model.effects.EffectType";
	String embracePath = "model.effects.Embrace";
	String powerUpPath = "model.effects.PowerUp";
	String shieldPath = "model.effects.Shield";
	String rootPath = "model.effects.Root";
	String shockPath = "model.effects.Shock";
	String silencePath = "model.effects.Silence";
	String DodgePath = "model.effects.Dodge";
	String speedUpPath = "model.effects.SpeedUp";
	String stunPath = "model.effects.Stun";

	@Test(timeout = 100)
	public void testEnumDirection() throws ClassNotFoundException {
		testIsEnum(Class.forName(directionPath));
	}

	@Test(timeout = 1000)
	public void testClassIsEnumAreaOfEffect() throws Exception {
		testIsEnum(Class.forName(areaOfEffectPath));
	}

	@Test(timeout = 1000)
	public void testEnumValuesAreaOfEffect() {
		String[] inputs = { "SELFTARGET", "SINGLETARGET", "TEAMTARGET", "DIRECTIONAL", "SURROUND" };
		testEnumValues("AreaOfEffect", areaOfEffectPath, inputs);
	}

	@Test(timeout = 100)
	public void testEnumDirectionValues() throws ClassNotFoundException {
		try {
			Enum.valueOf((Class<Enum>) Class.forName(directionPath), "RIGHT");
		} catch (IllegalArgumentException e) {
			fail("Direction enum can be RIGHT");
		}

		try {
			Enum.valueOf((Class<Enum>) Class.forName(directionPath), "UP");
		} catch (IllegalArgumentException e) {
			fail("Direction enum can be UP");
		}

		try {
			Enum.valueOf((Class<Enum>) Class.forName(directionPath), "DOWN");
		} catch (IllegalArgumentException e) {
			fail("Direction enum can be DOWN");
		}
	}

	@Test(timeout = 100)
	public void testEnumCondition() throws ClassNotFoundException {
		testIsEnum(Class.forName(conditionPath));
	}

	@Test(timeout = 100)
	public void testEnumConditionValues() throws ClassNotFoundException {
		try {
			Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ACTIVE");
		} catch (IllegalArgumentException e) {
			fail("Condition enum can be ACTIVE");
		}

		try {
			Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE");
		} catch (IllegalArgumentException e) {
			fail("Condition enum can be INACTIVE");
		}
		try {
			Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ROOTED");
		} catch (IllegalArgumentException e) {
			fail("Condition enum can be ROOTED");
		}
		try {
			Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ROOTED");
		} catch (IllegalArgumentException e) {
			fail("Condition enum can be KNOCKEDOUT");
		}
	}

	@Test(timeout = 1000)
	public void testEffectIsSuperClassOfShock() throws Exception {
		testClassIsSubclass(Class.forName(shockPath), Class.forName(effectPath));
	}

	@Test(timeout = 1000)
	public void testEffectIsSuperClassOfShield() throws Exception {
		testClassIsSubclass(Class.forName(shieldPath), Class.forName(effectPath));
	}

	@Test(timeout = 1000)
	public void testEffectIsSuperClassOfPowerUp() throws Exception {
		testClassIsSubclass(Class.forName(powerUpPath), Class.forName(effectPath));
	}

	@Test(timeout = 1000)
	public void testEffectIsSuperClassOfEmbrace() throws Exception {
		testClassIsSubclass(Class.forName(embracePath), Class.forName(effectPath));
	}

	@Test(timeout = 1000)
	public void testEffectIsSuperClassOfDisarm() throws Exception {
		testClassIsSubclass(Class.forName(disarmPath), Class.forName(effectPath));
	}

	@Test(timeout = 1000)
	public void testAbilityIsSuperClassOfHealingAbility() throws Exception {
		testClassIsSubclass(Class.forName(healingAbilityPath), Class.forName(abilityPath));
	}

	@Test(timeout = 1000)
	public void testAbilityIsSuperClassOfDamagingAbility() throws Exception {
		testClassIsSubclass(Class.forName(damagingAbilityPath), Class.forName(abilityPath));
	}

	@Test(timeout = 1000)
	public void testConstructor0Effect() throws Exception {
		Class[] inputs = { String.class, int.class, Class.forName(effectTypePath) };
		testConstructorExists(Class.forName(effectPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructor0Stun() throws Exception {
		Class[] inputs = { int.class };
		testConstructorExists(Class.forName(stunPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructor0SpeedUp() throws Exception {
		Class[] inputs = { int.class };
		testConstructorExists(Class.forName(speedUpPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructor0Dodge() throws Exception {
		Class[] inputs = { int.class };
		testConstructorExists(Class.forName(DodgePath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructor0Silence() throws Exception {
		Class[] inputs = { int.class };
		testConstructorExists(Class.forName(silencePath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructor0Shock() throws Exception {
		Class[] inputs = { int.class };
		testConstructorExists(Class.forName(shockPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructor0Shield() throws Exception {
		Class[] inputs = { int.class };
		testConstructorExists(Class.forName(shieldPath), inputs);
	}

	@Test(timeout = 1000)
	public void testInvalidConstructor0Disarm() throws Exception {
		Class[] inputs = { String.class, int.class, Class.forName(effectTypePath) };
		testConstructorDoesnotExist(Class.forName(disarmPath), inputs);
	}

	@Test(timeout = 1000)
	public void testInvalidConstructor0DamagingAbility() throws Exception {
		Class[] inputs = { String.class, int.class, int.class, int.class, Class.forName(areaOfEffectPath), int.class };
		testConstructorDoesnotExist(Class.forName(damagingAbilityPath), inputs);
	}

	@Test(timeout = 1000)
	public void testInvalidConstructor0HealingAbility() throws Exception {
		Class[] inputs = { String.class, int.class, int.class, int.class, Class.forName(areaOfEffectPath), int.class };
		testConstructorDoesnotExist(Class.forName(healingAbilityPath), inputs);
	}

	@Test(timeout = 1000)
	public void testInvalidConstructor0CrowdControlAbility() throws Exception {
		Class[] inputs = { String.class, int.class, int.class, int.class, Class.forName(areaOfEffectPath), int.class };
		testConstructorDoesnotExist(Class.forName(crowdControlAbilityPath), inputs);
	}

	@Test(timeout = 1000)
	public void testInvalidConstructor0PowerUp() throws Exception {
		Class[] inputs = { String.class, int.class, Class.forName(effectTypePath) };
		testConstructorDoesnotExist(Class.forName(powerUpPath), inputs);
	}

	@Test(timeout = 1000)
	public void testInvalidConstructor0Shield() throws Exception {
		Class[] inputs = { String.class, int.class, Class.forName(effectTypePath) };
		testConstructorDoesnotExist(Class.forName(shieldPath), inputs);
	}

	@Test(timeout = 1000)
	public void testInvalidConstructor0Silence() throws Exception {
		Class[] inputs = { String.class, int.class, Class.forName(effectTypePath) };
		testConstructorDoesnotExist(Class.forName(silencePath), inputs);
	}

	@Test(timeout = 1000)
	public void testInvalidConstructor0SpeedUp() throws Exception {
		Class[] inputs = { String.class, int.class, Class.forName(effectTypePath) };
		testConstructorDoesnotExist(Class.forName(speedUpPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructor0Ability() throws Exception {
		Class[] inputs = { String.class, int.class, int.class, int.class, Class.forName(areaOfEffectPath), int.class };
		testConstructorExists(Class.forName(abilityPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructor0HealingAbility() throws Exception {
		Class[] inputs = { String.class, int.class, int.class, int.class, Class.forName(areaOfEffectPath), int.class,
				int.class };
		testConstructorExists(Class.forName(healingAbilityPath), inputs);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableTypeExistsInClassEffect() throws Exception {
		testSetterMethodExistsInClass(Class.forName(effectPath), "setType", Class.forName(effectTypePath), false);
	}

	@Test(timeout = 1000)
	public void testConstructor0CrowdControlAbility() throws Exception {
		Class[] inputs = { String.class, int.class, int.class, int.class, Class.forName(areaOfEffectPath), int.class,
				Class.forName(effectPath) };
		testConstructorExists(Class.forName(crowdControlAbilityPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorInitialization1200Effect() throws Exception {
		int r = (int) Math.random() * 500;
		String string00 = "wq8" + r;
		int int26 = 26 + r;
		int r2 = (int) (Math.random() * 2);
		Object effectType01 = null;
		if (r2 == 0)
			effectType01 = Enum.valueOf((Class<Enum>) Class.forName(effectTypePath), "DEBUFF");
		else
			effectType01 = Enum.valueOf((Class<Enum>) Class.forName(effectTypePath), "BUFF");

		Object effect00 = Class.forName(effectPath)
				.getConstructor(String.class, int.class, Class.forName(effectTypePath))
				.newInstance(string00, int26, effectType01);

		String[] names = { "name", "duration", "type" };
		Object[] values = { string00, int26, effectType01 };

		testConstructorInitialization(effect00, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorInitialization1300Stun() throws Exception {
		int r = (int) Math.random() * 500;
		int int83 = 83 + r;
		Object stun00 = Class.forName(stunPath).getConstructor(int.class).newInstance(int83);

		String stunString = "Stun";
		Object effectType01 = Enum.valueOf((Class<Enum>) Class.forName(effectTypePath), "DEBUFF");
		String[] names = { "name", "duration", "type" };
		Object[] values = { stunString, int83, effectType01 };

		testConstructorInitialization(stun00, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorInitialization1400SpeedUp() throws Exception {
		int r = (int) Math.random() * 500;
		int int13 = 13 + r;
		Object speedUp00 = Class.forName(speedUpPath).getConstructor(int.class).newInstance(int13);

		String speedUpString = "SpeedUp";
		Object effectType00 = Enum.valueOf((Class<Enum>) Class.forName(effectTypePath), "BUFF");
		String[] names = { "name", "duration", "type" };
		Object[] values = { speedUpString, int13, effectType00 };

		testConstructorInitialization(speedUp00, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorInitialization1400Root() throws Exception {
		int r = (int) Math.random() * 500;
		int int13 = 13 + r;
		Object speedUp00 = Class.forName(rootPath).getConstructor(int.class).newInstance(int13);

		String rootString = "Root";
		Object effectType00 = Enum.valueOf((Class<Enum>) Class.forName(effectTypePath), "DEBUFF");
		String[] names = { "name", "duration", "type" };
		Object[] values = { rootString, int13, effectType00 };

		testConstructorInitialization(speedUp00, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorInitialization1500Dodge() throws Exception {
		int r = (int) Math.random() * 500;
		int int06 = 6 + r;
		Object dodge00 = Class.forName(DodgePath).getConstructor(int.class).newInstance(int06);

		String dodgeString = "Dodge";
		Object effectType01 = Enum.valueOf((Class<Enum>) Class.forName(effectTypePath), "BUFF");
		String[] names = { "name", "duration", "type" };
		Object[] values = { dodgeString, int06, effectType01 };

		testConstructorInitialization(dodge00, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorInitialization1600Silence() throws Exception {
		int r = (int) Math.random() * 500;
		int int03 = 3 + r;
		Object silence00 = Class.forName(silencePath).getConstructor(int.class).newInstance(int03);

		String silenceString = "Silence";
		Object effectType01 = Enum.valueOf((Class<Enum>) Class.forName(effectTypePath), "DEBUFF");
		String[] names = { "name", "duration", "type" };
		Object[] values = { silenceString, int03, effectType01 };

		testConstructorInitialization(silence00, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorInitialization1700Shock() throws Exception {
		int r = (int) Math.random() * 500;
		int int65 = 65 + r;
		Object shock00 = Class.forName(shockPath).getConstructor(int.class).newInstance(int65);

		String shockString = "Shock";
		Object effectType01 = Enum.valueOf((Class<Enum>) Class.forName(effectTypePath), "DEBUFF");
		String[] names = { "name", "duration", "type" };
		Object[] values = { shockString, int65, effectType01 };

		testConstructorInitialization(shock00, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorInitialization2400DamagingAbility() throws Exception {
		int r = (int) Math.random() * 500;
		String string01 = "s9x0q" + r;
		int int36 = 36 + r;
		int int93 = 93 + r;
		int int49 = 49 + r;
		int r2 = ((int) Math.random() * 4);
		Object areaOfEffect00 = null;
		if (r2 == 0)
			areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SELFTARGET");
		else if (r2 == 1)
			areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SINGLETARGET");
		else if (r2 == 2)
			areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "TEAMTARGET");
		else
			areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SURROUND");
		int int12 = 12 + r;
		int int90 = 90 + r;
		Object damagingAbility00 = Class
				.forName(damagingAbilityPath).getConstructor(String.class, int.class, int.class, int.class,
						Class.forName(areaOfEffectPath), int.class, int.class)
				.newInstance(string01, int36, int93, int49, areaOfEffect00, int12, int90);

		int int00 = 0;
		String[] names = { "damageAmount", "name", "manaCost", "baseCooldown", "currentCooldown", "castRange",
				"requiredActionPoints", "castArea" };
		Object[] values = { int90, string01, int36, int93, int00, int49, int12, areaOfEffect00 };

		testConstructorInitialization(damagingAbility00, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorInitialization2500CrowdControlAbility() throws Exception {
		int r = (int) Math.random() * 500;
		String string00 = "wq8" + r;
		int int51 = 51 + r;
		int int19 = 19 + r;
		int int42 = 42 + r;
		int r2 = ((int) Math.random() * 4);
		Object areaOfEffect00 = null;
		if (r2 == 0)
			areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SELFTARGET");
		else if (r2 == 1)
			areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SINGLETARGET");
		else if (r2 == 2)
			areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "TEAMTARGET");
		else
			areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SURROUND");
		int int45 = 45;
		String string01 = "s9x0q" + r;
		int int82 = 82;
		Object effectType00 = Enum.valueOf((Class<Enum>) Class.forName(effectTypePath), "BUFF");
		Object effect02 = Class.forName(effectPath)
				.getConstructor(String.class, int.class, Class.forName(effectTypePath))
				.newInstance(string01, int82, effectType00);

		Object crowdControlAbility00 = Class.forName(crowdControlAbilityPath)
				.getConstructor(String.class, int.class, int.class, int.class, Class.forName(areaOfEffectPath),
						int.class, Class.forName(effectPath))
				.newInstance(string00, int51, int19, int42, areaOfEffect00, int45, effect02);

		int int00 = 0;
		String[] names = { "effect", "name", "manaCost", "baseCooldown", "currentCooldown", "castRange",
				"requiredActionPoints", "castArea" };
		Object[] values = { effect02, string00, int51, int19, int00, int42, int45, areaOfEffect00 };

		testConstructorInitialization(crowdControlAbility00, names, values);
	}

	@Test(timeout = 1000)
	public void testInstanceVariableNameIsPresentInClassEffect() throws Exception {
		testInstanceVariableIsPresent(Class.forName(effectPath), "name", true);
	}

	@Test(timeout = 1000)
	public void testInstanceVariableDurationIsPresentInClassEffect() throws Exception {
		testInstanceVariableIsPresent(Class.forName(effectPath), "duration", true);
	}

	@Test(timeout = 1000)
	public void testInstanceVariableTypeIsPresentInClassEffect() throws Exception {
		testInstanceVariableIsPresent(Class.forName(effectPath), "type", true);
	}

	@Test(timeout = 1000)
	public void testInstanceVariableNameIsPresentInClassAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(abilityPath), "name", true);
	}

	@Test(timeout = 1000)
	public void testInstanceVariableManaCostIsPresentInClassAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(abilityPath), "manaCost", true);
	}

	@Test(timeout = 1000)
	public void testInstanceVariableBaseCooldownIsPresentInClassAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(abilityPath), "baseCooldown", true);
	}

	@Test(timeout = 1000)
	public void testInstanceVariableCurrentCooldownIsPresentInClassAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(abilityPath), "currentCooldown", true);
	}

	@Test(timeout = 1000)
	public void testInstanceVariableCastRangeIsPresentInClassAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(abilityPath), "castRange", true);
	}

	@Test(timeout = 1000)
	public void testInstanceVariableRequiredActionPointsIsPresentInClassAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(abilityPath), "requiredActionPoints", true);
	}

	@Test(timeout = 1000)
	public void testInstanceVariableCastAreaIsPresentInClassAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(abilityPath), "castArea", true);
	}

	@Test(timeout = 1000)
	public void testInstanceVariableHealingAmountIsPresentInClassHealingAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(healingAbilityPath), "healAmount", true);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableNameIsNotPresentInClassShield() throws Exception {
		testInstanceVariableIsPresent(Class.forName(shieldPath), "name", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableNameIsNotPresentInClassPowerUp() throws Exception {
		testInstanceVariableIsPresent(Class.forName(powerUpPath), "name", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableNameIsNotPresentInClassEmbrace() throws Exception {
		testInstanceVariableIsPresent(Class.forName(embracePath), "name", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableNameIsNotPresentInClassDisarm() throws Exception {
		testInstanceVariableIsPresent(Class.forName(disarmPath), "name", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableNameIsNotPresentInClassRoot() throws Exception {
		testInstanceVariableIsPresent(Class.forName(rootPath), "name", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableDurationIsNotPresentInClassStun() throws Exception {
		testInstanceVariableIsPresent(Class.forName(stunPath), "duration", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableDurationIsNotPresentInClassSpeedUp() throws Exception {
		testInstanceVariableIsPresent(Class.forName(speedUpPath), "duration", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableDurationIsNotPresentInClassDodge() throws Exception {
		testInstanceVariableIsPresent(Class.forName(DodgePath), "duration", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableDurationIsNotPresentInClassSilence() throws Exception {
		testInstanceVariableIsPresent(Class.forName(silencePath), "duration", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableDurationIsNotPresentInClassShock() throws Exception {
		testInstanceVariableIsPresent(Class.forName(shockPath), "duration", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableDurationIsNotPresentInClassShield() throws Exception {
		testInstanceVariableIsPresent(Class.forName(shieldPath), "duration", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableDurationIsNotPresentInClassPowerUp() throws Exception {
		testInstanceVariableIsPresent(Class.forName(powerUpPath), "duration", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableDurationIsNotPresentInClassEmbrace() throws Exception {
		testInstanceVariableIsPresent(Class.forName(embracePath), "duration", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableDurationIsNotPresentInClassDisarm() throws Exception {
		testInstanceVariableIsPresent(Class.forName(disarmPath), "duration", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableDurationIsNotPresentInClassRoot() throws Exception {
		testInstanceVariableIsPresent(Class.forName(rootPath), "duration", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableTypeIsNotPresentInClassStun() throws Exception {
		testInstanceVariableIsPresent(Class.forName(stunPath), "type", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableTypeIsNotPresentInClassSpeedUp() throws Exception {
		testInstanceVariableIsPresent(Class.forName(speedUpPath), "type", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableTypeIsNotPresentInClassDodge() throws Exception {
		testInstanceVariableIsPresent(Class.forName(DodgePath), "type", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableTypeIsNotPresentInClassSilence() throws Exception {
		testInstanceVariableIsPresent(Class.forName(silencePath), "type", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableTypeIsNotPresentInClassShock() throws Exception {
		testInstanceVariableIsPresent(Class.forName(shockPath), "type", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableTypeIsNotPresentInClassShield() throws Exception {
		testInstanceVariableIsPresent(Class.forName(shieldPath), "type", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableTypeIsNotPresentInClassPowerUp() throws Exception {
		testInstanceVariableIsPresent(Class.forName(powerUpPath), "type", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableTypeIsNotPresentInClassEmbrace() throws Exception {
		testInstanceVariableIsPresent(Class.forName(embracePath), "type", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableTypeIsNotPresentInClassDisarm() throws Exception {
		testInstanceVariableIsPresent(Class.forName(disarmPath), "type", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableTypeIsNotPresentInClassRoot() throws Exception {
		testInstanceVariableIsPresent(Class.forName(rootPath), "type", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableManaCostIsNotPresentInClassHealingAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(healingAbilityPath), "manaCost", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableManaCostIsNotPresentInClassDamagingAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(damagingAbilityPath), "manaCost", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableManaCostIsNotPresentInClassCrowdControlAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(crowdControlAbilityPath), "manaCost", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableBaseCooldownIsNotPresentInClassHealingAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(healingAbilityPath), "baseCooldown", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableBaseCooldownIsNotPresentInClassDamagingAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(damagingAbilityPath), "baseCooldown", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableBaseCooldownIsNotPresentInClassCrowdControlAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(crowdControlAbilityPath), "baseCooldown", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableCurrentCooldownIsNotPresentInClassHealingAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(healingAbilityPath), "currentCooldown", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableCurrentCooldownIsNotPresentInClassDamagingAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(damagingAbilityPath), "currentCooldown", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableCurrentCooldownIsNotPresentInClassCrowdControlAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(crowdControlAbilityPath), "currentCooldown", false);
	}

	@Test(timeout = 1000)
	public void testInstanceVariableNameIsPrivateInClassEffect() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(effectPath), "name");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableDurationIsPrivateInClassEffect() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(effectPath), "duration");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableNameIsPrivateInClassAbility() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(abilityPath), "name");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableManaCostIsPrivateInClassAbility() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(abilityPath), "manaCost");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableBaseCooldownIsPrivateInClassAbility() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(abilityPath), "baseCooldown");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableCurrentCooldownIsPrivateInClassAbility() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(abilityPath), "currentCooldown");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableCastRangeIsPrivateInClassAbility() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(abilityPath), "castRange");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableHealingAmountIsPrivateInClassHealingAbility() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(healingAbilityPath), "healAmount");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableDamageAmountIsPrivateInClassDamagingAbility() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(damagingAbilityPath), "damageAmount");
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableNameExistsInClassEffect() throws Exception {
		testGetterMethodExistsInClass(Class.forName(effectPath), "getName", String.class, true);
	}

	@Test(timeout = 1000)
	public void testSetterForInstanceVariableNameExistsInClassEffect() throws Exception {
		testSetterMethodExistsInClass(Class.forName(effectPath), "setName", String.class, false);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableDurationExistsInClassEffect() throws Exception {
		testGetterMethodExistsInClass(Class.forName(effectPath), "getDuration", int.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableNameExistsInClassAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(abilityPath), "getName", String.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableManaCostExistsInClassAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(abilityPath), "getManaCost", int.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableBaseCooldownExistsInClassAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(abilityPath), "getBaseCooldown", int.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableCurrentCooldownExistsInClassAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(abilityPath), "getCurrentCooldown", int.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableCastRangeExistsInClassAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(abilityPath), "getCastRange", int.class, true);
	}

	@Test(timeout = 1000)
	public void testSetterForInstanceVariableDurationExistsInClassEffect() throws Exception {
		testSetterMethodExistsInClass(Class.forName(effectPath), "setDuration", int.class, true);
	}

	@Test(timeout = 1000)
	public void testSetterForInstanceVariableCurrentCooldownExistsInClassAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(abilityPath), "setCurrentCooldown", int.class, true);
	}

	@Test(timeout = 1000)
	public void testSetterForInstanceVariableManaCostExistsInClassAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(abilityPath), "setManaCost", int.class, false);
	}

	@Test(timeout = 1000)
	public void testSetterForInstanceVariableBaseCooldownExistsInClassAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(abilityPath), "setBaseCooldown", int.class, false);
	}

	@Test(timeout = 1000)
	public void testSetterForInstanceVariableDamageAmountExistsInClassDamagingAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(damagingAbilityPath), "setDamageAmount", int.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableHealAmountExistsInClassHealingAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(healingAbilityPath), "getHealAmount", int.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterLogicForInstanceVariableDurationeffect00int26InClassEffect() throws Exception {
		int r = (int) (Math.random() * 500);
		String string00 = "wq8" + r;
		int int26 = 26 + r;
		Object effectType01 = Enum.valueOf((Class<Enum>) Class.forName(effectTypePath), "DEBUFF");
		Object effect00 = Class.forName(effectPath)
				.getConstructor(String.class, int.class, Class.forName(effectTypePath))
				.newInstance(string00, int26, effectType01);

		testGetterLogic(effect00, "duration", int26);
	}

	@Test(timeout = 1000)
	public void testGetterLogicForInstanceVariableTypeeffect00effectType01InClassEffect() throws Exception {
		int r = (int) (Math.random() * 500);
		String string00 = "wq8" + r;
		int int26 = 26;
		int r2 = (int) (Math.random() * 2);
		Object effectType01 = null;
		if (r2 == 0)
			effectType01 = Enum.valueOf((Class<Enum>) Class.forName(effectTypePath), "DEBUFF");
		else
			effectType01 = Enum.valueOf((Class<Enum>) Class.forName(effectTypePath), "BUFF");

		Object effect00 = Class.forName(effectPath)
				.getConstructor(String.class, int.class, Class.forName(effectTypePath))
				.newInstance(string00, int26, effectType01);

		testGetterLogic(effect00, "type", effectType01);
	}

	@Test(timeout = 1000)
	public void testGetterLogicForInstanceVariableNameability00string00InClassAbility() throws Exception {
		int r = (int) (Math.random() * 500);
		String string00 = "wq8" + r;
		int int78 = 78;
		int int71 = 71;
		int int11 = 11;
		Object areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SELFTARGET");
		int int88 = 88;
		Object ability00 = Class
				.forName(abilityPath).getConstructor(String.class, int.class, int.class, int.class,
						Class.forName(areaOfEffectPath), int.class)
				.newInstance(string00, int78, int71, int11, areaOfEffect00, int88);

		testGetterLogic(ability00, "name", string00);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableDurationeffect00int70InClassEffect() throws Exception {
		int r = (int) (Math.random() * 500);
		String string00 = "wq8" + r;
		int int26 = 26 + r;
		Object effectType01 = Enum.valueOf((Class<Enum>) Class.forName(effectTypePath), "DEBUFF");
		Object effect00 = Class.forName(effectPath)
				.getConstructor(String.class, int.class, Class.forName(effectTypePath))
				.newInstance(string00, int26, effectType01);

		int int70 = 70 + r;

		testSetterLogic(effect00, "duration", int70, int70, int.class);
	}

	public void testSetterLogicForInstanceVariableCurrentCooldownLowerBound00int88InClassAbility() throws Exception {
		int r = (int) (Math.random() * 500);
		String string00 = "wq8";
		int int78 = 78 + r;
		int int71 = 71 + r;
		int int11 = 11 + r;
		Object areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SELFTARGET");
		int int88 = 88 + r;
		Object ability00 = Class
				.forName(abilityPath).getConstructor(String.class, int.class, int.class, int.class,
						Class.forName(areaOfEffectPath), int.class)
				.newInstance(string00, int78, int71, int11, areaOfEffect00, int88);

		testSetterLogic(ability00, "currentCooldown", -1 * r, 0, int.class);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableNameExistsInClassStun() throws Exception {
		testSetterMethodExistsInClass(Class.forName(stunPath), "setName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableNameExistsInClassSpeedUp() throws Exception {
		testSetterMethodExistsInClass(Class.forName(speedUpPath), "setName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableNameExistsInClassSlipperiness() throws Exception {
		testSetterMethodExistsInClass(Class.forName(DodgePath), "setName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableNameExistsInClassSilence() throws Exception {
		testSetterMethodExistsInClass(Class.forName(silencePath), "setName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableNameExistsInClassShock() throws Exception {
		testSetterMethodExistsInClass(Class.forName(shockPath), "setName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableNameExistsInClassShield() throws Exception {
		testSetterMethodExistsInClass(Class.forName(shieldPath), "setName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableDurationExistsInClassPowerUp() throws Exception {
		testSetterMethodExistsInClass(Class.forName(powerUpPath), "setDuration", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableDurationExistsInClassEmbrace() throws Exception {
		testSetterMethodExistsInClass(Class.forName(embracePath), "setDuration", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableDurationExistsInClassDisarm() throws Exception {
		testSetterMethodExistsInClass(Class.forName(disarmPath), "setDuration", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableTypeExistsInClassStun() throws Exception {
		testSetterMethodExistsInClass(Class.forName(stunPath), "setType", Class.forName(effectTypePath), false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableTypeExistsInClassSpeedUp() throws Exception {
		testSetterMethodExistsInClass(Class.forName(speedUpPath), "setType", Class.forName(effectTypePath), false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableTypeExistsInClassDisarm() throws Exception {
		testSetterMethodExistsInClass(Class.forName(disarmPath), "setType", Class.forName(effectTypePath), false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableNameExistsInClassHealingAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(healingAbilityPath), "setName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableNameExistsInClassDamagingAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(damagingAbilityPath), "setName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableManaCostExistsInClassCrowdControlAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(crowdControlAbilityPath), "setManaCost", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableBaseCooldownExistsInClassHealingAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(healingAbilityPath), "setBaseCooldown", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableBaseCooldownExistsInClassDamagingAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(damagingAbilityPath), "setBaseCooldown", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableCurrentCooldownExistsInClassCrowdControlAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(crowdControlAbilityPath), "setCurrentCooldown", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableCastRangeExistsInClassHealingAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(healingAbilityPath), "setCastRange", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableCastRangeExistsInClassDamagingAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(damagingAbilityPath), "setCastRange", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableRequiredActionPointsExistsInClassDamagingAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(damagingAbilityPath), "setRequiredActionPoints", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableRequiredActionPointsExistsInClassCrowdControlAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(crowdControlAbilityPath), "setRequiredActionPoints", int.class,
				false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableCastAreaExistsInClassHealingAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(healingAbilityPath), "setCastArea", Class.forName(areaOfEffectPath),
				false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableNameExistsInClassSlipperiness() throws Exception {
		testGetterMethodExistsInClass(Class.forName(DodgePath), "getName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableNameExistsInClassSilence() throws Exception {
		testGetterMethodExistsInClass(Class.forName(silencePath), "getName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableNameExistsInClassShock() throws Exception {
		testGetterMethodExistsInClass(Class.forName(shockPath), "getName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableNameExistsInClassShield() throws Exception {
		testGetterMethodExistsInClass(Class.forName(shieldPath), "getName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableNameExistsInClassPowerUp() throws Exception {
		testGetterMethodExistsInClass(Class.forName(powerUpPath), "getName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableNameExistsInClassEmbrace() throws Exception {
		testGetterMethodExistsInClass(Class.forName(embracePath), "getName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableNameExistsInClassDisarm() throws Exception {
		testGetterMethodExistsInClass(Class.forName(disarmPath), "getName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableDurationExistsInClassStun() throws Exception {
		testGetterMethodExistsInClass(Class.forName(stunPath), "getDuration", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableDurationExistsInClassSpeedUp() throws Exception {
		testGetterMethodExistsInClass(Class.forName(speedUpPath), "getDuration", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableDurationExistsInClassEmbrace() throws Exception {
		testGetterMethodExistsInClass(Class.forName(embracePath), "getDuration", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableDurationExistsInClassDisarm() throws Exception {
		testGetterMethodExistsInClass(Class.forName(disarmPath), "getDuration", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableTypeExistsInClassStun() throws Exception {
		testGetterMethodExistsInClass(Class.forName(stunPath), "getType", Class.forName(effectTypePath), false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableTypeExistsInClassSpeedUp() throws Exception {
		testGetterMethodExistsInClass(Class.forName(speedUpPath), "getType", Class.forName(effectTypePath), false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableTypeExistsInClassSlipperiness() throws Exception {
		testGetterMethodExistsInClass(Class.forName(DodgePath), "getType", Class.forName(effectTypePath), false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableTypeExistsInClassSilence() throws Exception {
		testGetterMethodExistsInClass(Class.forName(silencePath), "getType", Class.forName(effectTypePath), false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableTypeExistsInClassShock() throws Exception {
		testGetterMethodExistsInClass(Class.forName(shockPath), "getType", Class.forName(effectTypePath), false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableTypeExistsInClassShield() throws Exception {
		testGetterMethodExistsInClass(Class.forName(shieldPath), "getType", Class.forName(effectTypePath), false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableTypeExistsInClassPowerUp() throws Exception {
		testGetterMethodExistsInClass(Class.forName(powerUpPath), "getType", Class.forName(effectTypePath), false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableNameExistsInClassCrowdControlAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(crowdControlAbilityPath), "getName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableManaCostExistsInClassHealingAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(healingAbilityPath), "getManaCost", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableManaCostExistsInClassDamagingAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(damagingAbilityPath), "getManaCost", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableCastRangeExistsInClassHealingAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(healingAbilityPath), "getCastRange", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableCastRangeExistsInClassDamagingAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(damagingAbilityPath), "getCastRange", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableRequiredActionPointsExistsInClassHealingAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(healingAbilityPath), "getRequiredActionPoints", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableRequiredActionPointsExistsInClassDamagingAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(damagingAbilityPath), "getRequiredActionPoints", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableCastAreaExistsInClassDamagingAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(damagingAbilityPath), "getCastArea",
				Class.forName(areaOfEffectPath), false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableCastAreaExistsInClassCrowdControlAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(crowdControlAbilityPath), "getCastArea",
				Class.forName(areaOfEffectPath), false);
	}

	@Test(timeout = 100)
	public void testConstructorCover() throws ClassNotFoundException {
		Class[] inputs = { int.class, int.class };
		testConstructorExists(Class.forName(coverPath), inputs);
	}

	@Test(timeout = 100)
	public void testConstructorCoverInitialization() throws Exception {
		Constructor<?> constructor = Class.forName(coverPath).getConstructor(int.class, int.class);
		int randomX = (int) (Math.random() * 10) + 1;
		int randomY = (int) (Math.random() * 10) + 1;
		int randomHP = (int) (Math.random() * 1000) + 100;
		String[] varNames = { "location", "currentHP" };
		Object[] varValues = { new Point(randomX, randomY), randomHP };
		Object[] createdObjects = new Object[200];
		for (int i = 0; i < 200; i++) {
			Object b = constructor.newInstance(randomX, randomY);
			createdObjects[i] = b;
		}
		testConstructorInitializationCover(createdObjects, varNames, varValues);
	}

	@Test(timeout = 100)
	public void testCoverInstanceVariableLocationPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(coverPath), "location", true);
	}

	@Test(timeout = 100)
	public void testCoverInstanceVariableLocationPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(coverPath), "location");
	}

	@Test(timeout = 100)
	public void testCoverInstanceVariableLocationType() throws Exception {
		testInstanceVariableOfType(Class.forName(coverPath), "location", Point.class);
	}

	@Test(timeout = 100)
	public void testCoverCurrentHPGetter() throws Exception {
		testGetterMethodExistsInClass(Class.forName(coverPath), "getCurrentHP", int.class, true);

	}

	@Test(timeout = 100)
	public void testCoverCurrentHPGetterLogic() throws Exception {
		Constructor<?> constructor = Class.forName(coverPath).getConstructor(int.class, int.class);
		int randomX = (int) (Math.random() * 10) + 1;
		int randomY = (int) (Math.random() * 10) + 1;
		Object b = constructor.newInstance(randomX, randomY);
		int randomHP = (int) (Math.random() * 1000) + 100;
		testGetterLogic(b, "currentHP", randomHP);
	}

	@Test(timeout = 100)
	public void testCoverCurrentHPSetter() throws Exception {
		testSetterMethodExistsInClass(Class.forName(coverPath), "setCurrentHP", int.class, true);

	}

	@Test(timeout = 100)
	public void testCoverCurrentHPSetterLogicGeneral() throws Exception {
		Constructor<?> constructor = Class.forName(coverPath).getConstructor(int.class, int.class);
		int randomX = (int) (Math.random() * 10) + 1;
		int randomY = (int) (Math.random() * 10) + 1;
		Object b = constructor.newInstance(randomX, randomY);
		int randomHP = (int) (Math.random() * 1000) + 100;
		testSetterLogicCover(b, "currentHP", randomHP, randomHP, int.class);
	}

	@Test(timeout = 100)
	public void testCoverLocationGetter() throws Exception {
		testGetterMethodExistsInClass(Class.forName(coverPath), "getLocation", Point.class, true);

	}

	@Test(timeout = 100)
	public void testCoverLocationGetterLogic() throws Exception {
		Constructor<?> constructor = Class.forName(coverPath).getConstructor(int.class, int.class);
		int randomX = (int) (Math.random() * 10) + 1;
		int randomY = (int) (Math.random() * 10) + 1;
		Object b = constructor.newInstance(randomX, randomY);
		testGetterLogic(b, "location", new Point(randomX, randomY));

	}

	@Test(timeout = 100)
	public void testCoverLocationSetter() throws Exception {
		testSetterMethodExistsInClass(Class.forName(coverPath), "setLocation", Point.class, false);

	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionNamePresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(championPath), "name", true);

	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionNamePrivate() throws Exception {
		testInstanceVariableOfType(Class.forName(championPath), "name", String.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionNameType() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(championPath), "name");
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionNameGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(championPath), "getName", String.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionNameGetterLogic() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		testGetterLogic(c, "name", "Name_" + randomName);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionNameSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(championPath), "setName", String.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionMaxHPGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(championPath), "getMaxHP", int.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionMaxHPGetterLogic() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		testGetterLogic(c, "maxHP", randomMaxHP);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionMaxHPSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(championPath), "setMaxHP", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionCurrentHPPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(championPath), "currentHP", true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionCurrentHPPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(championPath), "currentHP");
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionCurrentHPType() throws Exception {
		testInstanceVariableOfType(Class.forName(championPath), "currentHP", int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionCurrentHPGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(championPath), "getCurrentHP", int.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionCurrentHPGetterLogic() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		testGetterLogic(c, "currentHP", randomMaxHP);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionCurrentHPSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(championPath), "setCurrentHP", int.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionCurrentHPSetterLogicMax() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 1000) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomCurrentHP = randomMaxHP + (int) (Math.random() * 50) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		testSetterLogic(c, "currentHP", randomCurrentHP, randomMaxHP, int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionCurrentHPSetterLogicZero() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 1000) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		testSetterLogic(c, "currentHP", -1, 0, int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionCurrentHPSetterLogic() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 50) + 11;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomCurrentHP = (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		testSetterLogic(c, "currentHP", randomCurrentHP, randomCurrentHP, int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionManaPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(championPath), "mana", true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionManaPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(championPath), "mana");
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionManaType() throws Exception {
		testInstanceVariableOfType(Class.forName(championPath), "mana", int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionManaGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(championPath), "getMana", int.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionManaGetterLogic() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		testGetterLogic(c, "mana", randomMana);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionMaxActionPointsPerTurnPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(championPath), "maxActionPointsPerTurn", true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionMaxActionPointsPerTurnPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(championPath), "maxActionPointsPerTurn");
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionMaxActionPointsPerTurnType() throws Exception {
		testInstanceVariableOfType(Class.forName(championPath), "maxActionPointsPerTurn", int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionMaxActionPointsPerTurnGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(championPath), "getMaxActionPointsPerTurn", int.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionMaxActionPointsPerTurnGetterLogic() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomMaxActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		testGetterLogic(c, "maxActionPointsPerTurn", randomMaxActions);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionMaxActionPointsPerTurnSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(championPath), "setMaxActionPointsPerTurn", int.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionMaxActionPointsPerTurnSetterLogic() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMaxActions = (int) (Math.random() * 10) + 1;
		int randomMaxActions2 = (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomMaxActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		testSetterLogic(c, "maxActionPointsPerTurn", randomMaxActions2, randomMaxActions2, int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionCurrentActionPointsGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(championPath), "getCurrentActionPoints", int.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionCurrentActionPointsGetterLogic() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		testGetterLogic(c, "currentActionPoints", randomActions + (int) (Math.random() * 10) + 1);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAttackRangePresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(championPath), "attackRange", true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAttackRangePrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(championPath), "attackRange");
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAttackRangeType() throws Exception {
		testInstanceVariableOfType(Class.forName(championPath), "attackRange", int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAttackRangeGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(championPath), "getAttackRange", int.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAttackRangeGetterLogic() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		testGetterLogic(c, "attackRange", randomAttackRange);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAttackRangeSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(championPath), "setAttackRange", int.class, false);
		String[] subClasses = { antiHeroPath, heroPath, villainPath };
		testSetterAbsentInSubclasses("attackRange", subClasses);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAttackDamagePresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(championPath), "attackDamage", true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAttackDamagePrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(championPath), "attackDamage");
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAttackDamageType() throws Exception {
		testInstanceVariableOfType(Class.forName(championPath), "attackDamage", int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAttackDamageGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(championPath), "getAttackDamage", int.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAttackDamageGetterLogic() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		testGetterLogic(c, "attackDamage", randomAttackDamage);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAttackDamageSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(championPath), "setAttackDamage", int.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAttackDamageSetterLogic() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomAttackDamage2 = (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		testSetterLogic(c, "attackDamage", randomAttackDamage2, randomAttackDamage2, int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionSpeedPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(championPath), "speed", true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionSpeedPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(championPath), "speed");
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionSpeedType() throws Exception {
		testInstanceVariableOfType(Class.forName(championPath), "speed", int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionSpeedGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(championPath), "getSpeed", int.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionSpeedGetterLogic() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		testGetterLogic(c, "speed", randomSpeed);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionSpeedSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(championPath), "setSpeed", int.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionSpeedSetterLogic() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomSpeed2 = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		testSetterLogic(c, "speed", randomSpeed2, randomSpeed2, int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAbilitiesGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(championPath), "getAbilities", ArrayList.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAbilitiesGetterLogic() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		ArrayList<?> value = new ArrayList<Object>();
		testGetterLogic(c, "abilities", value);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAbilitiesSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(championPath), "setAbilities", ArrayList.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAppliedEffectsPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(championPath), "appliedEffects", true);
	}

	public void testInstanceVariableChampionAppliedEffectsPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(championPath), "appliedEffects");
	}

	public void testInstanceVariableChampionAppliedEffectsType() throws Exception {
		testInstanceVariableOfType(Class.forName(championPath), "appliedEffects", ArrayList.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAppliedEffectsSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(championPath), "setAppliedEffects", ArrayList.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionConditionPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(championPath), "condition", true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionConditionPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(championPath), "condition");
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionConditionType() throws Exception {
		testInstanceVariableOfType(Class.forName(championPath), "condition", Class.forName(conditionPath));
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionConditionGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(championPath), "getCondition", Class.forName(conditionPath), true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionConditionGetterLogic() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		Object s = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ACTIVE");
		testGetterLogic(c, "condition", s);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionConditionSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(championPath), "setCondition", Class.forName(conditionPath), true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionConditionSetterLogic() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		Object s = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE");
		testSetterLogic(c, "condition", s, s, Class.forName(conditionPath));
	}

	@Test(timeout = 100)
	public void testInstanceVariableLocationGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(championPath), "getLocation", Point.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionLocationGetterLogic() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		Point p = new Point(0, 0);
		testGetterLogic(c, "location", p);
	}

	public void testConstructorAntiHero() throws ClassNotFoundException {
		Class[] inputs = { String.class, int.class, int.class, int.class, int.class, int.class, int.class };
		testConstructorExists(Class.forName(antiHeroPath), inputs);
	}

	@Test(timeout = 100)
	public void testConstructorAntiHeroInitialization() throws Exception {
		Constructor<?> constructor = Class.forName(antiHeroPath).getConstructor(String.class, int.class, int.class,
				int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		Object b = constructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions, randomSpeed,
				randomAttackRange, randomAttackDamage);
		String[] varNames = { "name", "maxHP", "currentHP", "mana", "maxActionPointsPerTurn", "currentActionPoints",
				"attackRange", "attackDamage", "speed", "abilities", "appliedEffects", "condition", "location" };
		Object[] varValues = { "Name_" + randomName, randomMaxHP, randomMaxHP, randomMana, randomActions, randomActions,
				randomAttackRange, randomAttackDamage, randomSpeed, new ArrayList<Object>(), new ArrayList<Object>(),
				Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ACTIVE"), null };
		testConstructorInitialization(b, varNames, varValues);
	}

	@Test(timeout = 100)
	public void testClassIsSubclassHero() throws Exception {
		testClassIsSubclass(Class.forName(heroPath), Class.forName(championPath));
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroName() throws Exception {
		testInstanceVariableIsPresent(Class.forName(heroPath), "name", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroNameGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(heroPath), "getName", String.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroNameSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(heroPath), "setName", String.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroMaxHP() throws Exception {
		testInstanceVariableIsPresent(Class.forName(heroPath), "maxHP", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroMaxHPGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(heroPath), "getMaxHP", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroMaxHPSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(heroPath), "setMaxHP", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroCurrentHP() throws Exception {
		testInstanceVariableIsPresent(Class.forName(heroPath), "currentHP", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroCurrentHPGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(heroPath), "getCurrentHP", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroCurrentHPSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(heroPath), "setCurrentHP", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroMana() throws Exception {
		testInstanceVariableIsPresent(Class.forName(heroPath), "mana", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroManaGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(heroPath), "getMana", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroManaSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(heroPath), "setMana", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroMaxActionPointsPerTurn() throws Exception {
		testInstanceVariableIsPresent(Class.forName(heroPath), "maxActionPointsPerTurn", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroMaxActionPointsPerTurnGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(heroPath), "getMaxActionPointsPerTurn", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroMaxActionPointsPerTurnSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(heroPath), "setMaxActionPointsPerTurn", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroCurrentActionPoints() throws Exception {
		testInstanceVariableIsPresent(Class.forName(heroPath), "currentActionPoints", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroCurrentActionPointsGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(heroPath), "getCurrentActionPoints", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroCurrentActionPointsSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(heroPath), "setCurrentActionPoints", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroAttackRange() throws Exception {
		testInstanceVariableIsPresent(Class.forName(heroPath), "attackRange", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroAttackRangeGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(heroPath), "getAttackRange", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroAttackRangeSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(heroPath), "setAttackRange", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroAttackDamage() throws Exception {
		testInstanceVariableIsPresent(Class.forName(heroPath), "attackDamage", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroAttackDamageGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(heroPath), "getAttackDamage", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroAttackDamageSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(heroPath), "setAttackDamage", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroSpeed() throws Exception {
		testInstanceVariableIsPresent(Class.forName(heroPath), "speed", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroSpeedGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(heroPath), "getSpeed", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroSpeedSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(heroPath), "setSpeed", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroAbilities() throws Exception {
		testInstanceVariableIsPresent(Class.forName(heroPath), "abilities", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroAbilitiesGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(heroPath), "getAbilities", ArrayList.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroAbilitiesSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(heroPath), "setAbilities", ArrayList.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroAppliedEffects() throws Exception {
		testInstanceVariableIsPresent(Class.forName(heroPath), "appliedEffects", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroAppliedEffectsGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(heroPath), "getAppliedEffects", ArrayList.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroAppliedEffectsSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(heroPath), "setAppliedEffects", ArrayList.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroCondition() throws Exception {
		testInstanceVariableIsPresent(Class.forName(heroPath), "condition", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroConditionGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(heroPath), "getCondition", Condition.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroConditionSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(heroPath), "setCondition", Condition.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroLocation() throws Exception {
		testInstanceVariableIsPresent(Class.forName(heroPath), "location", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroLocationGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(heroPath), "getLocation", Point.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableHeroLocationSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(heroPath), "setLocation", Point.class, false);
	}

	@Test(timeout = 100)
	public void testClassIsSubclassVillain() throws Exception {
		testClassIsSubclass(Class.forName(villainPath), Class.forName(championPath));
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainName() throws Exception {
		testInstanceVariableIsPresent(Class.forName(villainPath), "name", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainNameGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(villainPath), "getName", String.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainNameSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(villainPath), "setName", String.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainMaxHP() throws Exception {
		testInstanceVariableIsPresent(Class.forName(villainPath), "maxHP", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainMaxHPGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(villainPath), "getMaxHP", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainMaxHPSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(villainPath), "setMaxHP", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainCurrentHP() throws Exception {
		testInstanceVariableIsPresent(Class.forName(villainPath), "currentHP", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainCurrentHPGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(villainPath), "getCurrentHP", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainCurrentHPSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(villainPath), "setCurrentHP", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainMana() throws Exception {
		testInstanceVariableIsPresent(Class.forName(villainPath), "mana", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainManaGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(villainPath), "getMana", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainManaSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(villainPath), "setMana", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainMaxActionPointsPerTurn() throws Exception {
		testInstanceVariableIsPresent(Class.forName(villainPath), "maxActionPointsPerTurn", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainMaxActionPointsPerTurnGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(villainPath), "getMaxActionPointsPerTurn", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainMaxActionPointsPerTurnSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(villainPath), "setMaxActionPointsPerTurn", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainCurrentActionPoints() throws Exception {
		testInstanceVariableIsPresent(Class.forName(villainPath), "currentActionPoints", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainCurrentActionPointsGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(villainPath), "getCurrentActionPoints", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainCurrentActionPointsSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(villainPath), "setCurrentActionPoints", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainAttackRange() throws Exception {
		testInstanceVariableIsPresent(Class.forName(villainPath), "attackRange", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainAttackRangeGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(villainPath), "getAttackRange", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainAttackRangeSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(villainPath), "setAttackRange", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainAttackDamage() throws Exception {
		testInstanceVariableIsPresent(Class.forName(villainPath), "attackDamage", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainAttackDamageGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(villainPath), "getAttackDamage", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainAttackDamageSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(villainPath), "setAttackDamage", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainSpeed() throws Exception {
		testInstanceVariableIsPresent(Class.forName(villainPath), "speed", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainSpeedGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(villainPath), "getSpeed", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainSpeedSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(villainPath), "setSpeed", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainAbilities() throws Exception {
		testInstanceVariableIsPresent(Class.forName(villainPath), "abilities", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainAbilitiesGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(villainPath), "getAbilities", ArrayList.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainAbilitiesSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(villainPath), "setAbilities", ArrayList.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainAppliedEffects() throws Exception {
		testInstanceVariableIsPresent(Class.forName(villainPath), "appliedEffects", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainAppliedEffectsGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(villainPath), "getAppliedEffects", ArrayList.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainAppliedEffectsSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(villainPath), "setAppliedEffects", ArrayList.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainCondition() throws Exception {
		testInstanceVariableIsPresent(Class.forName(villainPath), "condition", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainConditionGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(villainPath), "getCondition", Condition.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainConditionSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(villainPath), "setCondition", Condition.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainLocation() throws Exception {
		testInstanceVariableIsPresent(Class.forName(villainPath), "location", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainLocationGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(villainPath), "getLocation", Point.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableVillainLocationSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(villainPath), "setLocation", Point.class, false);
	}

	public void testConstructorVillain() throws ClassNotFoundException {
		Class[] inputs = { String.class, int.class, int.class, int.class, int.class, int.class, int.class };
		testConstructorExists(Class.forName(villainPath), inputs);
	}

	@Test(timeout = 100)
	public void testConstructorVillainInitialization() throws Exception {
		Constructor<?> constructor = Class.forName(villainPath).getConstructor(String.class, int.class, int.class,
				int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		Object b = constructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions, randomSpeed,
				randomAttackRange, randomAttackDamage);
		String[] varNames = { "name", "maxHP", "currentHP", "mana", "maxActionPointsPerTurn", "currentActionPoints",
				"attackRange", "attackDamage", "speed", "abilities", "appliedEffects", "condition", "location" };
		Object[] varValues = { "Name_" + randomName, randomMaxHP, randomMaxHP, randomMana, randomActions, randomActions,
				randomAttackRange, randomAttackDamage, randomSpeed, new ArrayList<Object>(), new ArrayList<Object>(),
				Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ACTIVE"), null };
		testConstructorInitialization(b, varNames, varValues);
	}

	@Test(timeout = 100)
	public void testInstanceVariableSecondPlayerInGame() throws Exception {
		testInstanceVariableIsPresent(Class.forName(gamePath), "secondPlayer", true);
		testInstanceVariableIsPrivate(Class.forName(gamePath), "secondPlayer");
		testInstanceVariableOfType(Class.forName(gamePath), "secondPlayer", Class.forName(playerPath));
	}

	@Test(timeout = 100)
	public void testInstanceVariableFirstLeaderAbilityUsedInGame() throws Exception {
		testInstanceVariableIsPresent(Class.forName(gamePath), "firstLeaderAbilityUsed", true);
		testInstanceVariableIsPrivate(Class.forName(gamePath), "firstLeaderAbilityUsed");
		testInstanceVariableOfType(Class.forName(gamePath), "firstLeaderAbilityUsed", boolean.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAvailableChampionsInGame() throws Exception {
		testInstanceVariableIsPresent(Class.forName(gamePath), "availableChampions", true);
		testStaticVariableIsPrivate(Class.forName(gamePath), "availableChampions");

		testInstanceVariableOfType(Class.forName(gamePath), "availableChampions", ArrayList.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableTurnOrderInGame() throws Exception {
		testInstanceVariableIsPresent(Class.forName(gamePath), "turnOrder", true);
		testInstanceVariableIsPrivate(Class.forName(gamePath), "turnOrder");
		testInstanceVariableOfType(Class.forName(gamePath), "turnOrder", Class.forName(priorityQueuePath));
	}

	@Test(timeout = 100)
	public void testInstanceVariableBoardHightInGame() throws Exception {
		testInstanceVariableIsPresent(Class.forName(gamePath), "BOARDHEIGHT", true);
		testStaticVariableIsPrivate(Class.forName(gamePath), "BOARDHEIGHT");
		testInstanceVariableOfType(Class.forName(gamePath), "BOARDHEIGHT", int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableBoardWidthInGame() throws Exception {
		testInstanceVariableIsPresent(Class.forName(gamePath), "BOARDWIDTH", true);
		testStaticVariableIsPrivate(Class.forName(gamePath), "BOARDWIDTH");
		testInstanceVariableOfType(Class.forName(gamePath), "BOARDWIDTH", int.class);
	}

	@Test(timeout = 800)
	public void testGameBoardHeightFinal() throws NoSuchFieldException, SecurityException, ClassNotFoundException {
		Field f = Class.forName(gamePath).getDeclaredField("BOARDHEIGHT");
		int modifiers = f.getModifiers();
		assertTrue(f.getName() + " variable in calss Game should be private", (Modifier.isPrivate(modifiers)));
		assertTrue(f.getName() + " variable in calss Game should be final", (Modifier.isFinal(modifiers)));
	}

	@Test(timeout = 800)
	public void testGameBoardHeightStatic() throws NoSuchFieldException, SecurityException, ClassNotFoundException {
		Field f = Class.forName(gamePath).getDeclaredField("BOARDHEIGHT");
		int modifiers = f.getModifiers();
		assertTrue(f.getName() + " variable in calss Game should be static", (Modifier.isStatic(modifiers)));
	}

	@Test(timeout = 100)
	public void testInstanceVariableGameFirstPlayerGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(gamePath), "getFirstPlayer", Class.forName(playerPath), true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableGameSecondPlayerGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(gamePath), "getSecondPlayer", Class.forName(playerPath), true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableGameFirstLeaderAbilityUsedGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(gamePath), "isFirstLeaderAbilityUsed", boolean.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableGameBoardGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(gamePath), "getBoard", Object[][].class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableGameAvailableAbilitiesGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(gamePath), "getAvailableAbilities", ArrayList.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableGameTurnOrderGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(gamePath), "getTurnOrder", Class.forName(priorityQueuePath), true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableGameBOARDHEIGHTGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(gamePath), "getBoardheight", int.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableGameBOARDWIDTHGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(gamePath), "getBoardwidth", int.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableGameFirstPlayerGetterLogic() throws Exception {

		Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
		Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
		Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
		Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");

		Constructor<?> constructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
				Class.forName(playerPath));
		Object myObj = constructor.newInstance(firstPlayer, secondPlayer);

		testGetterLogic(myObj, "firstPlayer", firstPlayer);
	}

	@Test(timeout = 100)
	public void testInstanceVariableGameSecondPlayerGetterLogic() throws Exception {

		Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
		Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
		Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
		Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");

		Constructor<?> constructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
				Class.forName(playerPath));
		Object myObj = constructor.newInstance(firstPlayer, secondPlayer);

		testGetterLogic(myObj, "secondPlayer", secondPlayer);
	}

	@Test(timeout = 100)
	public void testInstanceVariableGameSecondLeaderAbilityUsedGetterLogic() throws Exception {

		Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
		Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
		Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
		Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");

		Constructor<?> constructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
				Class.forName(playerPath));
		Object myObj = constructor.newInstance(firstPlayer, secondPlayer);

		testGetterLogic(myObj, "secondLeaderAbilityUsed", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableGameBoardGetterLogic() throws Exception {

		Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
		Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
		Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
		Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");

		Constructor<?> constructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
				Class.forName(playerPath));
		Object myObj = constructor.newInstance(firstPlayer, secondPlayer);

		testGetterLogic(myObj, "board", new Object[5][5]);
	}

	@Test(timeout = 100)
	public void testInstanceVariableGameTurnOrderGetterLogic() throws Exception {

		Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
		Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
		Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
		Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");

		Constructor<?> constructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
				Class.forName(playerPath));
		Object myObj = constructor.newInstance(firstPlayer, secondPlayer);

		Constructor<?> constructorPriorityQueue = Class.forName(priorityQueuePath).getConstructor(int.class);
		Object pq = constructorPriorityQueue.newInstance(6);
		testGetterLogic(myObj, "turnOrder", pq);
	}

	@Test(timeout = 100)
	public void testInstanceVariableGameAvailableAbilitiesGetterLogic() throws Exception {

		Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
		Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
		Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
		Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");

		Constructor<?> constructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
				Class.forName(playerPath));
		Object myObj = constructor.newInstance(firstPlayer, secondPlayer);

		testGetterLogic(myObj, "availableAbilities", new ArrayList<>());
	}

	@Test(timeout = 100)
	public void testGameSecondLeaderAbilityUsedSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(gamePath), "setSecondLeaderAbilityUsed", boolean.class, false);
	}

	@Test(timeout = 100)
	public void testGameBoardSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(gamePath), "setBoard", Object[][].class, false);
	}

	@Test(timeout = 100)
	public void testGameAvailableChampionsSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(gamePath), "setAvailableChampions", ArrayList.class, false);
	}

	@Test(timeout = 100)
	public void testGameAvailableAbilitiesSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(gamePath), "setAvailableAbilities", ArrayList.class, false);
	}

	@Test(timeout = 100)
	public void testGameTurnOrderSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(gamePath), "setTurnOrder", Class.forName(priorityQueuePath), false);
	}

	@Test(timeout = 100)
	public void testGameBOARDHEIGHTSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(gamePath), "setBoardHeight", int.class, false);
	}

	@Test(timeout = 100)
	public void testGameBOARDWIDTHSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(gamePath), "setBoardWidth", int.class, false);
	}

	@Test(timeout = 100)
	public void testConstructorGameConstructorInitialization() throws Exception {

		Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
		Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
		Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
		Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");
		ArrayList<Object> firstPlayerChamp1 = new ArrayList<>();

		Constructor<?> constructorChamp = Class.forName(champPath).getConstructor(String.class, int.class, int.class,
				int.class, int.class, int.class, int.class);

		firstPlayerChamp1.add(constructorChamp.newInstance("ironman", 1, 2, 3, 4, 5, 6));
		firstPlayerChamp1.add(constructorChamp.newInstance("sipderman", 1, 2, 3, 4, 5, 6));
		firstPlayerChamp1.add(constructorChamp.newInstance("drstrange", 1, 2, 3, 4, 5, 6));

		Class curr = firstPlayer.getClass();
		Field f = curr.getDeclaredField("team");
		f.setAccessible(true);
		f.set(firstPlayer, firstPlayerChamp1);

		ArrayList<Object> secPlayerChamp1 = new ArrayList<>();
		secPlayerChamp1.add(constructorChamp.newInstance("loki", 1, 2, 3, 4, 5, 6));
		secPlayerChamp1.add(constructorChamp.newInstance("wanda", 1, 2, 3, 4, 5, 6));
		secPlayerChamp1.add(constructorChamp.newInstance("thor", 1, 2, 3, 4, 5, 6));

		curr = secondPlayer.getClass();
		f = curr.getDeclaredField("team");
		f.setAccessible(true);
		f.set(secondPlayer, secPlayerChamp1);
		Constructor<?> gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
				Class.forName(playerPath));
		Object createdGame = gameConstructor.newInstance(firstPlayer, secondPlayer);

		String[] names = { "firstPlayer", "secondPlayer", "firstLeaderAbilityUsed", "secondLeaderAbilityUsed",
				"BOARDWIDTH", "BOARDHEIGHT", "availableChampions", "availableAbilities" };
		Object[] values = { firstPlayer, secondPlayer, false, false, 5, 5, new ArrayList<>(), new ArrayList<>() };

		f = null;
		curr = createdGame.getClass();
		f = curr.getDeclaredField("board");
		f.setAccessible(true);
		assertTrue("Game constructor should initialize the board properly", f.get(createdGame) != null);
		int count = 0;
		int countChamps = 0;
		Object[][] boardGame = ((Object[][]) f.get(createdGame));
		for (int i = 0; i < boardGame.length; i++) {

			for (int j = 0; j < boardGame[i].length; j++) {
				if (((boardGame[i][j] != null)) && (boardGame[i][j].getClass().equals(Class.forName(coverPath)))) {
					count++;
				}
				if (((boardGame[i][j] != null)) && (boardGame[i][j].getClass().equals(Class.forName(champPath)))) {
					countChamps++;
				}
			}
		}

		assertTrue("The Game constructor should place the covers correctly", count > 0);
		assertTrue("The Game constructor should place the champions correctly", countChamps > 0);

		f = curr.getDeclaredField("turnOrder");
		f.setAccessible(true);
		assertTrue("Game constructor should initialize the turn order properly", f.get(createdGame) != null);

		Field f1 = null;

		Class curr1 = f.get(createdGame).getClass();

		f1 = curr1.getDeclaredField("maxSize");
		f1.setAccessible(true);
		int size = (int) f1.get(f.get(createdGame));
		assertTrue("Game constructor should initialize the turn order with 6", size == 6);

		testConstructorInitialization(createdGame, names, values);
	}

	private ArrayList<ArrayList<Object>> generateAbilitiesArrayLists()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, IOException, NoSuchFieldException {

		PrintWriter csvWriter = new PrintWriter("test_abilities.csv");
		int random = (int) (Math.random() * 50);
		int cost = random;
		random = (int) (Math.random() * 50);
		int castRange = random;
		random = (int) (Math.random() * 50);
		int baseCooldown = random;
		random = (int) (Math.random() * 4);
		int area = random;

		random = (int) (Math.random() * 50);
		int required = random;
		random = (int) (Math.random() * 50);
		int damageAmount = random;
		random = (int) (Math.random() * 50);

		Class<?> areaOfEffect = Class.forName(areaOfEffectPath);

		csvWriter.println("DMG,Shield throw," + cost + "," + castRange + "," + baseCooldown + ","
				+ areaOfEffect.getEnumConstants()[area] + "," + required + "," + damageAmount + ",");

		random = (int) (Math.random() * 50);
		int cost1 = random;
		random = (int) (Math.random() * 50);
		int castRange1 = random;
		random = (int) (Math.random() * 50);
		int baseCooldown1 = random;
		random = (int) (Math.random() * 4);
		int area1 = random;

		random = (int) (Math.random() * 50);
		int required1 = random;
		random = (int) (Math.random() * 50);
		int healAmount = random;
		random = (int) (Math.random() * 50);

		csvWriter.println("HEL,I can do this all day," + cost1 + "," + castRange1 + "," + baseCooldown1 + ","
				+ areaOfEffect.getEnumConstants()[area1] + "," + required1 + "," + healAmount + ",");

		random = (int) (Math.random() * 50);
		int cost2 = random;
		random = (int) (Math.random() * 50);
		int castRange2 = random;
		random = (int) (Math.random() * 50);
		int baseCooldown2 = random;
		random = (int) (Math.random() * 4);
		int area2 = random;
		random = (int) (Math.random() * 50);
		int required2 = random;
		random = (int) (Math.random() * 50);
		int effectDuration = random;
		random = (int) (Math.random() * 50);

		csvWriter.println("CC,Shield Up," + cost2 + "," + castRange2 + "," + baseCooldown2 + ","
				+ areaOfEffect.getEnumConstants()[area2] + "," + required2 + ",Shield," + effectDuration);

		csvWriter.flush();
		csvWriter.close();

		Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
		Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
		Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
		Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");
		Constructor<?> gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
				Class.forName(playerPath));
		Object createdGame = gameConstructor.newInstance(firstPlayer, secondPlayer);

		Method m = createdGame.getClass().getMethod("loadAbilities", String.class);
		m.invoke(createdGame, "test_abilities.csv");

		ArrayList<Object> abilities = new ArrayList<Object>();
		Constructor<?> dmgAbilityConstructor = Class.forName(dmgPath).getConstructor(String.class, int.class, int.class,
				int.class, Class.forName(areaOfEffectPath), int.class, int.class);
		Constructor<?> healingAbilityConstructor = Class.forName(healingPath).getConstructor(String.class, int.class,
				int.class, int.class, Class.forName(areaOfEffectPath), int.class, int.class);
		Constructor<?> ccAbilityConstructor = Class.forName(ccAbilitiesPath).getConstructor(String.class, int.class,
				int.class, int.class, Class.forName(areaOfEffectPath), int.class, Class.forName(effectPath));

		Object item = null;

		item = dmgAbilityConstructor.newInstance("Shield throw", cost, baseCooldown, castRange,
				areaOfEffect.getEnumConstants()[area], required, damageAmount);
		abilities.add(item);
		item = healingAbilityConstructor.newInstance("I can do this all day", cost1, baseCooldown1, castRange1,
				areaOfEffect.getEnumConstants()[area1], required1, healAmount);
		abilities.add(item);
		Object shield00 = Class.forName(shieldPath).getConstructor(int.class).newInstance(effectDuration);
		item = ccAbilityConstructor.newInstance("Shield Up", cost2, baseCooldown2, castRange2,
				areaOfEffect.getEnumConstants()[area2], required2, shield00);
		abilities.add(item);

		Field fd = Class.forName(gamePath).getDeclaredField("availableAbilities");
		fd.setAccessible(true);
		ArrayList<Object> actualAbilites = (ArrayList<Object>) fd.get(createdGame);
		ArrayList<ArrayList<Object>> abilitiesArrayList = new ArrayList<ArrayList<Object>>();
		abilitiesArrayList.add(abilities);
		abilitiesArrayList.add(actualAbilites);
		return abilitiesArrayList;

	}

	private ArrayList<ArrayList<Object>> generateAbilitiesArrayListsFromCSV()

			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, IOException, NoSuchFieldException {

		ArrayList<Object> abilities = new ArrayList<Object>();

		Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
		Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
		Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
		Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");

		Constructor<?> gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
				Class.forName(playerPath));
		Object createdGame = gameConstructor.newInstance(firstPlayer, secondPlayer);

		Method m = createdGame.getClass().getMethod("loadAbilities", String.class);
		m.invoke(createdGame, "Abilities.csv");

		Constructor<?> dmgAbilityConstructor = Class.forName(dmgPath).getConstructor(String.class, int.class, int.class,
				int.class, Class.forName(areaOfEffectPath), int.class, int.class);
		Constructor<?> healingAbilityConstructor = Class.forName(healingPath).getConstructor(String.class, int.class,
				int.class, int.class, Class.forName(areaOfEffectPath), int.class, int.class);
		Constructor<?> ccAbilityConstructor = Class.forName(ccAbilitiesPath).getConstructor(String.class, int.class,
				int.class, int.class, Class.forName(areaOfEffectPath), int.class, Class.forName(effectPath));

		String line = "";

		BufferedReader br = new BufferedReader(new FileReader("Abilities.csv"));
		while ((line = br.readLine()) != null) {
			String[] row = line.split(",");
			Object item = null;

			Class<?> c = Class.forName(areaOfEffectPath);

			Method valueOf = c.getMethod("valueOf", String.class);
			Object value = valueOf.invoke(null, row[5]);

			if (row[0].equals("CC")) {
				Class<?> cls = Class.forName("model.effects." + row[7]);
				Constructor<?> cons = cls.getConstructor(int.class);

				Object effect = cons.newInstance(Integer.parseInt(row[8]));

				item = ccAbilityConstructor.newInstance(row[1], Integer.parseInt(row[2]), Integer.parseInt(row[4]),
						Integer.parseInt(row[3]), value, Integer.parseInt(row[6]), effect);

			} else if (row[0].equals("DMG")) {
				item = dmgAbilityConstructor.newInstance(row[1], Integer.parseInt(row[2]), Integer.parseInt(row[4]),
						Integer.parseInt(row[3]), value, Integer.parseInt(row[6]), Integer.parseInt(row[7]));

			} else if (row[0].equals("HEL")) {
				item = healingAbilityConstructor.newInstance(row[1], Integer.parseInt(row[2]), Integer.parseInt(row[4]),
						Integer.parseInt(row[3]), value, Integer.parseInt(row[6]), Integer.parseInt(row[7]));
			}
			abilities.add(item);

		}
		br.close();
		Field fd = Class.forName(gamePath).getDeclaredField("availableAbilities");
		fd.setAccessible(true);
		ArrayList<Object> actualAbilites = (ArrayList<Object>) fd.get(createdGame);
		ArrayList<ArrayList<Object>> abilitiesArrayList = new ArrayList<ArrayList<Object>>();
		abilitiesArrayList.add(abilities);
		abilitiesArrayList.add(actualAbilites);

		return abilitiesArrayList;

	}

	private ArrayList<ArrayList<Object>> generateChampionsArrayList()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, IOException, NoSuchFieldException {
		PrintWriter csvWriter = new PrintWriter("test_champions.csv");

		int random = (int) (Math.random() * 50);
		int maxHP = random;
		random = (int) (Math.random() * 50);
		int mana = random;
		random = (int) (Math.random() * 50);
		int actions = random;
		random = (int) (Math.random() * 50);
		int speed = random;
		random = (int) (Math.random() * 50);
		int attackRange = random;
		random = (int) (Math.random() * 50);
		int attackDamage = random;

		csvWriter.println("H,Dr Strange," + maxHP + "," + mana + "," + actions + "," + speed + "," + attackRange + ","
				+ attackDamage + "," + "The eye of agamotto,Thousand Hand,Mirror Dimension");

		random = (int) (Math.random() * 50);
		int maxHP2 = random;
		random = (int) (Math.random() * 50);
		int mana2 = random;
		random = (int) (Math.random() * 50);
		int actions2 = random;
		random = (int) (Math.random() * 50);
		int speed2 = random;
		random = (int) (Math.random() * 50);
		int attackRange2 = random;
		random = (int) (Math.random() * 50);
		int attackDamage2 = random;

		csvWriter.println("V,Electro," + maxHP2 + "," + mana2 + "," + actions2 + "," + speed2 + "," + attackRange2 + ","
				+ attackDamage2 + "," + "Fully Charged,EMP,Lightning Strike");

		random = (int) (Math.random() * 50);
		int maxHP3 = random;
		random = (int) (Math.random() * 50);
		int mana3 = random;
		random = (int) (Math.random() * 50);
		int actions3 = random;
		random = (int) (Math.random() * 50);
		int speed3 = random;
		random = (int) (Math.random() * 50);
		int attackRange3 = random;
		random = (int) (Math.random() * 50);
		int attackDamage3 = random;

		csvWriter.println("A,Ghost Rider," + maxHP3 + "," + mana3 + "," + actions3 + "," + speed3 + "," + attackRange3
				+ "," + attackDamage3 + "," + "Death stare,Fire Breath,Chain Whip");

		csvWriter.flush();
		csvWriter.close();

		Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
		Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
		Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
		Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");

		Constructor<?> gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
				Class.forName(playerPath));
		Object createdGame = gameConstructor.newInstance(firstPlayer, secondPlayer);

		Method m = createdGame.getClass().getMethod("loadAbilities", String.class);
		m.invoke(createdGame, "Abilities.csv");

		Method m2 = createdGame.getClass().getMethod("loadChampions", String.class);
		m2.invoke(createdGame, "test_champions.csv");

		Field field = Class.forName(gamePath).getDeclaredField("availableAbilities");
		field.setAccessible(true);
		ArrayList<Object> availableAbilities = (ArrayList<Object>) field.get(createdGame);

		ArrayList<Object> champions = new ArrayList<Object>();

		Constructor<?> antiHeroConstructor = Class.forName(antiHeroPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);

		Constructor<?> HeroConstructor = Class.forName(heroPath).getConstructor(String.class, int.class, int.class,
				int.class, int.class, int.class, int.class);

		Constructor<?> VillainConstructor = Class.forName(villainPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);

		Object item = null;

		item = HeroConstructor.newInstance("Dr Strange", maxHP, mana, actions, speed, attackRange, attackDamage);
		champions.add(item);

		Method m3 = null;
		ArrayList<Object> champAbilities = null;
		Object firstAbility = null;
		Object secondAbility = null;
		Object thirdAbility = null;

		m3 = item.getClass().getMethod("getAbilities");
		champAbilities = (ArrayList<Object>) m3.invoke(item);

		firstAbility = retrieveAbility(availableAbilities, "The eye of agamotto");
		secondAbility = retrieveAbility(availableAbilities, "Thousand Hand");
		thirdAbility = retrieveAbility(availableAbilities, "Mirror Dimension");

		if (firstAbility != null)
			((ArrayList<Object>) m3.invoke(item)).add(firstAbility);
		if (secondAbility != null)
			((ArrayList<Object>) m3.invoke(item)).add(secondAbility);
		if (thirdAbility != null)
			((ArrayList<Object>) m3.invoke(item)).add(thirdAbility);

		item = VillainConstructor.newInstance("Electro", maxHP2, mana2, actions2, speed2, attackRange2, attackDamage2);
		champions.add(item);

		m3 = item.getClass().getMethod("getAbilities");
		champAbilities = (ArrayList<Object>) m3.invoke(item);
		firstAbility = retrieveAbility(availableAbilities, "Fully Charged");
		secondAbility = retrieveAbility(availableAbilities, "EMP");
		thirdAbility = retrieveAbility(availableAbilities, "Lightning Strike");

		if (firstAbility != null)
			((ArrayList<Object>) m3.invoke(item)).add(firstAbility);
		if (secondAbility != null)
			((ArrayList<Object>) m3.invoke(item)).add(secondAbility);
		if (thirdAbility != null)
			((ArrayList<Object>) m3.invoke(item)).add(thirdAbility);

		item = antiHeroConstructor.newInstance("Ghost Rider", maxHP3, mana3, actions3, speed3, attackRange3,
				attackDamage3);
		champions.add(item);

		m3 = item.getClass().getMethod("getAbilities");
		champAbilities = (ArrayList<Object>) m3.invoke(item);
		firstAbility = retrieveAbility(availableAbilities, "Death stare");
		secondAbility = retrieveAbility(availableAbilities, "Fire Breath");
		thirdAbility = retrieveAbility(availableAbilities, "Chain Whip");

		if (firstAbility != null)
			((ArrayList<Object>) m3.invoke(item)).add(firstAbility);
		if (secondAbility != null)
			((ArrayList<Object>) m3.invoke(item)).add(secondAbility);
		if (thirdAbility != null)
			((ArrayList<Object>) m3.invoke(item)).add(thirdAbility);

		champAbilities = (ArrayList<Object>) m3.invoke(item);

		Field fd = Class.forName(gamePath).getDeclaredField("availableChampions");
		fd.setAccessible(true);
		ArrayList<Object> actualChampions = (ArrayList<Object>) fd.get(createdGame);
		ArrayList<ArrayList<Object>> arrayList = new ArrayList<ArrayList<Object>>();

		arrayList.add(champions);
		arrayList.add(actualChampions);

		return arrayList;

	}

	private ArrayList<ArrayList<Object>> generateChampionsArrayListsFromCSV()

			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, IOException, NoSuchFieldException {

		Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
		Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
		Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
		Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");

		Constructor<?> gameConstructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
				Class.forName(playerPath));
		Object createdGame = gameConstructor.newInstance(firstPlayer, secondPlayer);

		Method m = createdGame.getClass().getMethod("loadAbilities", String.class);
		m.invoke(createdGame, "Abilities.csv");
		Field field = Class.forName(gamePath).getDeclaredField("availableAbilities");
		field.setAccessible(true);
		ArrayList<Object> availableAbilities = (ArrayList<Object>) field.get(createdGame);

		Method m2 = createdGame.getClass().getMethod("loadChampions", String.class);
		m2.invoke(createdGame, "Champions.csv");

		ArrayList<Object> champions = new ArrayList<Object>();

		Constructor<?> antiHeroConstructor = Class.forName(antiHeroPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);

		Constructor<?> HeroConstructor = Class.forName(heroPath).getConstructor(String.class, int.class, int.class,
				int.class, int.class, int.class, int.class);

		Constructor<?> VillainConstructor = Class.forName(villainPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);

		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("Champions.csv"));
			while ((line = br.readLine()) != null) {
				String[] row = line.split(",");

				Object firstAbility = retrieveAbility(availableAbilities, row[8]);
				Object secondAbility = retrieveAbility(availableAbilities, row[9]);

				Object thirdAbility = retrieveAbility(availableAbilities, row[10]);

				if (row[0].equals("H")) {
					Object hero = HeroConstructor.newInstance(row[1], Integer.parseInt(row[2]),
							Integer.parseInt(row[3]), Integer.parseInt(row[4]), Integer.parseInt(row[5]),
							Integer.parseInt(row[6]), Integer.parseInt(row[7]));
					Method getAbilities = hero.getClass().getMethod("getAbilities");
					ArrayList<Object> abilities = (ArrayList<Object>) getAbilities.invoke(hero);
					abilities.add(firstAbility);
					abilities.add(secondAbility);
					abilities.add(thirdAbility);

					champions.add(hero);

				} else if (row[0].equals("A")) {
					Object antiHero = antiHeroConstructor.newInstance(row[1], Integer.parseInt(row[2]),
							Integer.parseInt(row[3]), Integer.parseInt(row[4]), Integer.parseInt(row[5]),
							Integer.parseInt(row[6]), Integer.parseInt(row[7]));
					Method getAbilities = antiHero.getClass().getMethod("getAbilities");
					ArrayList<Object> abilities = (ArrayList<Object>) getAbilities.invoke(antiHero);
					abilities.add(firstAbility);
					abilities.add(secondAbility);
					abilities.add(thirdAbility);

					champions.add(antiHero);

				} else if (row[0].equals("V")) {
					Object villain = VillainConstructor.newInstance(row[1], Integer.parseInt(row[2]),
							Integer.parseInt(row[3]), Integer.parseInt(row[4]), Integer.parseInt(row[5]),
							Integer.parseInt(row[6]), Integer.parseInt(row[7]));
					Method getAbilities = villain.getClass().getMethod("getAbilities");
					ArrayList<Object> abilities = (ArrayList<Object>) getAbilities.invoke(villain);
					abilities.add(firstAbility);
					abilities.add(secondAbility);
					abilities.add(thirdAbility);

					champions.add(villain);
				}

			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Field fd = Class.forName(gamePath).getDeclaredField("availableChampions");
		fd.setAccessible(true);
		ArrayList<Object> actualChampions = (ArrayList<Object>) fd.get(createdGame);

		ArrayList<ArrayList<Object>> arrayList = new ArrayList<ArrayList<Object>>();
		arrayList.add(champions);
		arrayList.add(actualChampions);
		return arrayList;

	}

	@Test(timeout = 100)
	public void testChampionsSameClass()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateChampionsArrayListsFromCSV();
		ArrayList<Object> champions = arrayList.get(0);
		ArrayList<Object> actualChampions = arrayList.get(1);

		if (champions.size() != actualChampions.size()) {
			assertEquals("Size of champions ArrayList is incorrect ", champions.size(), actualChampions.size());

		}
		boolean sameClass = true;
		if (champions != null && actualChampions != null) {
			for (int i = 0; i < champions.size(); i++) {
				if (!champions.get(i).getClass().equals(actualChampions.get(i).getClass())) {
					sameClass = false;
				}
			}
		}

		assertTrue("The champions type is loaded incorrectly", sameClass);

	}

	@Test(timeout = 100)
	public void testChampionsSameMaxHP()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateChampionsArrayListsFromCSV();
		ArrayList<Object> champions = arrayList.get(0);
		ArrayList<Object> actualChampions = arrayList.get(1);

		if (champions.size() != actualChampions.size()) {
			assertEquals("Size of champions ArrayList is incorrect ", champions.size(), actualChampions.size());

		}
		boolean sameHP = true;

		Field f1 = Class.forName(champPath).getDeclaredField("maxHP");
		f1.setAccessible(true);

		if (champions != null && actualChampions != null) {
			for (int i = 0; i < champions.size(); i++) {
				Object d1f = (Object) f1.get(champions.get(i));
				Object d2f = (Object) f1.get(actualChampions.get(i));
				if (!d1f.equals(d2f)) {
					sameHP = false;
				}
			}
		}

		assertTrue("The champions maxHP is loaded incorrectly", sameHP);

	}

	@Test(timeout = 100)
	public void testChampionsSameMana()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateChampionsArrayListsFromCSV();
		ArrayList<Object> champions = arrayList.get(0);
		ArrayList<Object> actualChampions = arrayList.get(1);

		if (champions.size() != actualChampions.size()) {
			assertEquals("Size of champions ArrayList is incorrect ", champions.size(), actualChampions.size());

		}
		boolean sameMana = true;

		Field f1 = Class.forName(champPath).getDeclaredField("mana");
		f1.setAccessible(true);

		if (champions != null && actualChampions != null) {
			for (int i = 0; i < champions.size(); i++) {
				Object d1f = (Object) f1.get(champions.get(i));
				Object d2f = (Object) f1.get(actualChampions.get(i));
				if (!d1f.equals(d2f)) {
					sameMana = false;
				}
			}
		}

		assertTrue("The champions mana is loaded incorrectly", sameMana);

	}

	@Test(timeout = 100)
	public void testChampionsAttackRange()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateChampionsArrayListsFromCSV();
		ArrayList<Object> champions = arrayList.get(0);
		ArrayList<Object> actualChampions = arrayList.get(1);

		if (champions.size() != actualChampions.size()) {
			assertEquals("Size of champions ArrayList is incorrect ", champions.size(), actualChampions.size());

		}
		boolean sameAttackRange = true;

		Field f1 = Class.forName(champPath).getDeclaredField("attackRange");
		f1.setAccessible(true);

		if (champions != null && actualChampions != null) {
			for (int i = 0; i < champions.size(); i++) {
				Object d1f = (Object) f1.get(champions.get(i));
				Object d2f = (Object) f1.get(actualChampions.get(i));
				if (!d1f.equals(d2f)) {
					sameAttackRange = false;
				}
			}
		}

		assertTrue("The champions attackRange is loaded incorrectly", sameAttackRange);

	}

	@Test(timeout = 100)
	public void testChampionsAttackDamage()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateChampionsArrayListsFromCSV();
		ArrayList<Object> champions = arrayList.get(0);
		ArrayList<Object> actualChampions = arrayList.get(1);

		if (champions.size() != actualChampions.size()) {
			assertEquals("Size of champions ArrayList is incorrect ", champions.size(), actualChampions.size());

		}
		boolean sameAttackDamage = true;

		Field f1 = Class.forName(champPath).getDeclaredField("attackDamage");
		f1.setAccessible(true);

		if (champions != null && actualChampions != null) {
			for (int i = 0; i < champions.size(); i++) {
				Object d1f = (Object) f1.get(champions.get(i));
				Object d2f = (Object) f1.get(actualChampions.get(i));
				if (!d1f.equals(d2f)) {
					sameAttackDamage = false;
				}
			}
		}

		assertTrue("The champions attackDamage is loaded incorrectly", sameAttackDamage);

	}

	@Test(timeout = 100)
	public void testChampionsAbilities() throws Exception {
		ArrayList<ArrayList<Object>> arrayList = generateChampionsArrayListsFromCSV();
		ArrayList<Object> champions = arrayList.get(0);
		ArrayList<Object> actualChampions = arrayList.get(1);

		if (champions.size() != actualChampions.size()) {
			assertEquals("Size of champions ArrayList is incorrect ", champions.size(), actualChampions.size());

		}
		boolean sameAbilities = true;

		Field f1 = Class.forName(champPath).getDeclaredField("abilities");
		f1.setAccessible(true);

		if (champions != null && actualChampions != null) {
			for (int i = 0; i < champions.size(); i++) {
				ArrayList<Object> d15f = (ArrayList<Object>) f1.get(champions.get(i));
				ArrayList<Object> d16f = (ArrayList<Object>) f1.get(actualChampions.get(i));

				assertEquals("Size of abilities ArrayList of champion is incorrect ", d15f.size(), d16f.size());

				for (int j = 0; j < d15f.size(); j++) {
					assertTrue("The champions abilities is loaded incorrectly", d15f.get(j) != null);
					assertTrue("The champions abilities is loaded incorrectly", d16f.get(j) != null);

					assertTrue("The champions abilities is loaded incorrectly",
							checkAbilitiesEqual(d15f.get(j), d16f.get(j)));

				}
			}

		}
		assertTrue("The champions abilities is loaded incorrectly", sameAbilities);
	}

	@Test(timeout = 100)
	public void testChampionsSameClassDynamic()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateChampionsArrayList();
		ArrayList<Object> champions = arrayList.get(0);
		ArrayList<Object> actualChampions = arrayList.get(1);

		if (champions.size() != actualChampions.size()) {
			assertEquals("Size of champions ArrayList is incorrect ", champions.size(), actualChampions.size());

		}
		boolean sameClass = true;
		if (champions != null && actualChampions != null) {
			for (int i = 0; i < champions.size(); i++) {
				if (!champions.get(i).getClass().equals(actualChampions.get(i).getClass())) {
					sameClass = false;
				}
			}
		}

		assertTrue("The champions type is loaded incorrectly", sameClass);

	}

	@Test(timeout = 100)
	public void testChampionsSameMaxHPDynamic()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateChampionsArrayList();
		ArrayList<Object> champions = arrayList.get(0);
		ArrayList<Object> actualChampions = arrayList.get(1);

		if (champions.size() != actualChampions.size()) {
			assertEquals("Size of champions ArrayList is incorrect ", champions.size(), actualChampions.size());

		}
		boolean sameHP = true;

		Field f1 = Class.forName(champPath).getDeclaredField("maxHP");
		f1.setAccessible(true);

		if (champions != null && actualChampions != null) {
			for (int i = 0; i < champions.size(); i++) {
				Object d1f = (Object) f1.get(champions.get(i));
				Object d2f = (Object) f1.get(actualChampions.get(i));
				if (!d1f.equals(d2f)) {
					sameHP = false;
				}
			}
		}

		assertTrue("The champions maxHP is loaded incorrectly", sameHP);

	}

	@Test(timeout = 100)
	public void testChampionsSpeed()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateChampionsArrayListsFromCSV();
		ArrayList<Object> champions = arrayList.get(0);
		ArrayList<Object> actualChampions = arrayList.get(1);

		if (champions.size() != actualChampions.size()) {
			assertEquals("Size of champions ArrayList is incorrect ", champions.size(), actualChampions.size());

		}
		boolean sameSpeed = true;

		Field f1 = Class.forName(champPath).getDeclaredField("speed");
		f1.setAccessible(true);

		if (champions != null && actualChampions != null) {
			for (int i = 0; i < champions.size(); i++) {
				Object d1f = (Object) f1.get(champions.get(i));
				Object d2f = (Object) f1.get(actualChampions.get(i));
				if (!d1f.equals(d2f)) {
					sameSpeed = false;
				}
			}
		}

		assertTrue("The champions speed is loaded incorrectly", sameSpeed);

	}

	@Test(timeout = 100)
	public void testChampionsSameManaDynamic()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateChampionsArrayList();
		ArrayList<Object> champions = arrayList.get(0);
		ArrayList<Object> actualChampions = arrayList.get(1);

		if (champions.size() != actualChampions.size()) {
			assertEquals("Size of champions ArrayList is incorrect ", champions.size(), actualChampions.size());

		}
		boolean sameMana = true;

		Field f1 = Class.forName(champPath).getDeclaredField("mana");
		f1.setAccessible(true);

		if (champions != null && actualChampions != null) {
			for (int i = 0; i < champions.size(); i++) {
				Object d1f = (Object) f1.get(champions.get(i));
				Object d2f = (Object) f1.get(actualChampions.get(i));
				if (!d1f.equals(d2f)) {
					sameMana = false;
				}
			}
		}

		assertTrue("The champions mana is loaded incorrectly", sameMana);

	}

	@Test(timeout = 100)
	public void testChampionsSameMaxActionsDynamic()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateChampionsArrayList();
		ArrayList<Object> champions = arrayList.get(0);
		ArrayList<Object> actualChampions = arrayList.get(1);

		if (champions.size() != actualChampions.size()) {
			assertEquals("Size of champions ArrayList is incorrect ", champions.size(), actualChampions.size());

		}
		boolean sameMaxActionPointsPerTurn = true;

		Field f1 = Class.forName(champPath).getDeclaredField("maxActionPointsPerTurn");
		f1.setAccessible(true);

		if (champions != null && actualChampions != null) {
			for (int i = 0; i < champions.size(); i++) {
				Object d1f = (Object) f1.get(champions.get(i));
				Object d2f = (Object) f1.get(actualChampions.get(i));
				if (!d1f.equals(d2f)) {
					sameMaxActionPointsPerTurn = false;
				}
			}
		}

		assertTrue("The champions maxActionPointsPerTurn is loaded incorrectly", sameMaxActionPointsPerTurn);

	}

	@Test(timeout = 100)
	public void testChampionsSpeedDynamic()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateChampionsArrayList();
		ArrayList<Object> champions = arrayList.get(0);
		ArrayList<Object> actualChampions = arrayList.get(1);

		if (champions.size() != actualChampions.size()) {
			assertEquals("Size of champions ArrayList is incorrect ", champions.size(), actualChampions.size());

		}
		boolean sameSpeed = true;

		Field f1 = Class.forName(champPath).getDeclaredField("speed");
		f1.setAccessible(true);

		if (champions != null && actualChampions != null) {
			for (int i = 0; i < champions.size(); i++) {
				Object d1f = (Object) f1.get(champions.get(i));
				Object d2f = (Object) f1.get(actualChampions.get(i));
				if (!d1f.equals(d2f)) {
					sameSpeed = false;
				}
			}
		}

		assertTrue("The champions speed is loaded incorrectly", sameSpeed);

	}

	@Test(timeout = 100)
	public void testChampionsAttackRangeDynamic()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateChampionsArrayList();
		ArrayList<Object> champions = arrayList.get(0);
		ArrayList<Object> actualChampions = arrayList.get(1);

		if (champions.size() != actualChampions.size()) {
			assertEquals("Size of champions ArrayList is incorrect ", champions.size(), actualChampions.size());

		}
		boolean sameAttackRange = true;

		Field f1 = Class.forName(champPath).getDeclaredField("attackRange");
		f1.setAccessible(true);

		if (champions != null && actualChampions != null) {
			for (int i = 0; i < champions.size(); i++) {
				Object d1f = (Object) f1.get(champions.get(i));
				Object d2f = (Object) f1.get(actualChampions.get(i));
				if (!d1f.equals(d2f)) {
					sameAttackRange = false;
				}
			}
		}

		assertTrue("The champions attackRange is loaded incorrectly", sameAttackRange);

	}

	@Test(timeout = 100)
	public void testChampionsAbilitiesDynamic() throws Exception {
		ArrayList<ArrayList<Object>> arrayList = generateChampionsArrayList();
		ArrayList<Object> champions = arrayList.get(0);
		ArrayList<Object> actualChampions = arrayList.get(1);

		if (champions.size() != actualChampions.size()) {
			assertEquals("Size of champions ArrayList is incorrect ", champions.size(), actualChampions.size());

		}
		boolean sameAbilities = true;

		Field f1 = Class.forName(champPath).getDeclaredField("abilities");
		f1.setAccessible(true);

		if (champions != null && actualChampions != null) {
			for (int i = 0; i < champions.size(); i++) {
				ArrayList<Object> d15f = (ArrayList<Object>) f1.get(champions.get(i));
				ArrayList<Object> d16f = (ArrayList<Object>) f1.get(actualChampions.get(i));

				assertEquals("Size of abilities ArrayList of champion is incorrect ", d15f.size(), d16f.size());

				for (int j = 0; j < d15f.size(); j++) {
					assertTrue("The champions abilities is loaded incorrectly", d15f.get(j) != null);
					assertTrue("The champions abilities is loaded incorrectly", d16f.get(j) != null);

					assertTrue("The champions abilities is loaded incorrectly",
							checkAbilitiesEqual(d15f.get(j), d16f.get(j)));

				}
			}

		}
		assertTrue("The champions abilities is loaded incorrectly", sameAbilities);
	}

	@Test(timeout = 100)
	public void testAbilitiesSameClass()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateAbilitiesArrayListsFromCSV();
		ArrayList<Object> abilities = arrayList.get(0);
		ArrayList<Object> actualAbilities = arrayList.get(1);

		if (abilities.size() != actualAbilities.size()) {
			assertEquals("Size of abilities ArrayList is incorrect ", abilities.size(), actualAbilities.size());

		}
		boolean sameClass = true;
		if (abilities != null && actualAbilities != null) {
			for (int i = 0; i < abilities.size(); i++) {
				if (!abilities.get(i).getClass().equals(actualAbilities.get(i).getClass())) {
					sameClass = false;
				}
			}
		}

		assertTrue("The abilities type are loaded incorrectly", sameClass);

	}

	@Test(timeout = 100)
	public void testAbilitiesSameName()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateAbilitiesArrayListsFromCSV();
		ArrayList<Object> abilities = arrayList.get(0);
		ArrayList<Object> actualAbilities = arrayList.get(1);

		if (abilities.size() != actualAbilities.size()) {
			assertEquals("Size of abilities ArrayList is incorrect ", abilities.size(), actualAbilities.size());

		}
		boolean sameName = true;

		Field f1 = Class.forName(abilitiesPath).getDeclaredField("name");
		f1.setAccessible(true);

		if (abilities != null && actualAbilities != null) {
			for (int i = 0; i < abilities.size(); i++) {
				Object d1f = (Object) f1.get(abilities.get(i));
				Object d2f = (Object) f1.get(actualAbilities.get(i));
				if (!d1f.equals(d2f)) {
					sameName = false;
				}
			}
		}

		assertTrue("The abilities name is loaded incorrectly", sameName);

	}

	@Test(timeout = 100)
	public void testAbilitiesSameCastRange()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateAbilitiesArrayListsFromCSV();
		ArrayList<Object> abilities = arrayList.get(0);
		ArrayList<Object> actualAbilities = arrayList.get(1);
		boolean sameCastRange = true;

		if (abilities.size() != actualAbilities.size()) {
			assertEquals("Size of abilities ArrayList is incorrect ", abilities.size(), actualAbilities.size());

		}

		Field f1 = Class.forName(abilitiesPath).getDeclaredField("castRange");
		f1.setAccessible(true);

		if (abilities != null && actualAbilities != null) {
			for (int i = 0; i < abilities.size(); i++) {
				Object d1f = (Object) f1.get(abilities.get(i));
				Object d2f = (Object) f1.get(actualAbilities.get(i));

				if (!d1f.equals(d2f)) {
					sameCastRange = false;
				}
			}
		}

		assertTrue("The abilities cast range is loaded incorrectly", sameCastRange);

	}

	@Test(timeout = 100)
	public void testAbilitiesSameBaseCoolDown()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateAbilitiesArrayListsFromCSV();
		ArrayList<Object> abilities = arrayList.get(0);
		ArrayList<Object> actualAbilities = arrayList.get(1);

		if (abilities.size() != actualAbilities.size()) {
			assertEquals("Size of abilities ArrayList is incorrect ", abilities.size(), actualAbilities.size());

		}

		boolean sameBaseCoolDown = true;

		Field f1 = Class.forName(abilitiesPath).getDeclaredField("baseCooldown");
		f1.setAccessible(true);

		if (abilities != null && actualAbilities != null) {
			for (int i = 0; i < abilities.size(); i++) {
				Object d1f = (Object) f1.get(abilities.get(i));
				Object d2f = (Object) f1.get(actualAbilities.get(i));

				if (!d1f.equals(d2f)) {
					sameBaseCoolDown = false;
				}
			}
		}

		assertTrue("The abilities baseCooldown is loaded incorrectly", sameBaseCoolDown);

	}

	@Test(timeout = 100)
	public void testAbilitiesAreaOfEffect()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateAbilitiesArrayListsFromCSV();

		ArrayList<Object> abilities = arrayList.get(0);
		ArrayList<Object> actualAbilities = arrayList.get(1);

		if (abilities.size() != actualAbilities.size()) {
			assertEquals("Size of abilities ArrayList is incorrect ", abilities.size(), actualAbilities.size());

		}

		boolean sameCastArea = true;

		Field f1 = Class.forName(abilitiesPath).getDeclaredField("castArea");
		f1.setAccessible(true);

		if (abilities != null && actualAbilities != null) {
			for (int i = 0; i < abilities.size(); i++) {
				Object d1f = (Object) f1.get(abilities.get(i));
				Object d2f = (Object) f1.get(actualAbilities.get(i));

				if (!d1f.equals(d2f)) {
					sameCastArea = false;
				}
			}
		}

		assertTrue("The abilities castArea is loaded incorrectly", sameCastArea);

	}

	@Test(timeout = 100)
	public void testAbilitiesRequiredActionPoints()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateAbilitiesArrayListsFromCSV();
		ArrayList<Object> abilities = arrayList.get(0);
		ArrayList<Object> actualAbilities = arrayList.get(1);

		if (abilities.size() != actualAbilities.size()) {
			assertEquals("Size of abilities ArrayList is incorrect ", abilities.size(), actualAbilities.size());

		}

		boolean sameRequiredActionPoints = true;

		Field f1 = Class.forName(abilitiesPath).getDeclaredField("requiredActionPoints");
		f1.setAccessible(true);

		if (abilities != null && actualAbilities != null) {
			for (int i = 0; i < abilities.size(); i++) {
				Object d1f = (Object) f1.get(abilities.get(i));
				Object d2f = (Object) f1.get(actualAbilities.get(i));

				if (!d1f.equals(d2f)) {
					sameRequiredActionPoints = false;
				}
			}
		}

		assertTrue("The abilities requiredActionPoints is loaded incorrectly", sameRequiredActionPoints);

	}

	@Test(timeout = 100)
	public void testAbilitiesSameEffect()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateAbilitiesArrayListsFromCSV();
		ArrayList<Object> abilities = arrayList.get(0);
		ArrayList<Object> actualAbilities = arrayList.get(1);

		if (abilities.size() != actualAbilities.size()) {
			assertEquals("Size of abilities ArrayList is incorrect ", abilities.size(), actualAbilities.size());

		}

		if (abilities != null && actualAbilities != null) {
			for (int i = 0; i < abilities.size(); i++) {
				Object d1f = abilities.get(i);
				Object d2f = actualAbilities.get(i);

				if (d1f.getClass().equals(Class.forName(ccAbilitiesPath))) {

					Field f6 = Class.forName(ccAbilitiesPath).getDeclaredField("effect");
					f6.setAccessible(true);
					Object d11f = (Object) f6.get(d1f);
					Object d12f = (Object) f6.get(d2f);

					boolean sameClassTwo = d11f.getClass().equals(d12f.getClass());

					assertTrue("The effect is not initalized using the correct subclass", sameClassTwo);

					Field f8 = Class.forName(effectPath).getDeclaredField("name");
					Field f9 = Class.forName(effectPath).getDeclaredField("type");
					Field f10 = Class.forName(effectPath).getDeclaredField("duration");

					f8.setAccessible(true);
					Object d15f = (Object) f8.get(d11f);
					Object d16f = (Object) f8.get(d12f);

					boolean sameEffectName = d15f.equals(d16f);

					assertTrue("The effect name is loaded incorrectly", sameEffectName);

					f9.setAccessible(true);
					Object d17f = (Object) f9.get(d11f);
					Object d18f = (Object) f9.get(d12f);

					boolean sameEffectType = d17f.equals(d18f);

					assertTrue("The EffectType is loaded incorrectly", sameEffectType);

					f10.setAccessible(true);
					Object d19f = (Object) f10.get(d11f);
					Object d20f = (Object) f10.get(d12f);

					boolean sameEffectDuration = d19f.equals(d20f);

					assertTrue("The effect duratuon is loaded incorrectly", sameEffectDuration);

				}

			}
		}

	}

	@Test(timeout = 100)
	public void testAbilitiesSameClassDynamic()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateAbilitiesArrayLists();
		ArrayList<Object> abilities = arrayList.get(0);
		ArrayList<Object> actualAbilities = arrayList.get(1);

		if (abilities.size() != actualAbilities.size()) {
			assertEquals("Size of abilities ArrayList is incorrect ", abilities.size(), actualAbilities.size());

		}
		boolean sameClass = true;
		if (abilities != null && actualAbilities != null) {
			for (int i = 0; i < abilities.size(); i++) {
				if (!abilities.get(i).getClass().equals(actualAbilities.get(i).getClass())) {
					sameClass = false;
				}
			}
		}

		assertTrue("The abilities type are loaded incorrectly", sameClass);

	}

	@Test(timeout = 100)
	public void testAbilitiesSameNameDynamic()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateAbilitiesArrayLists();
		ArrayList<Object> abilities = arrayList.get(0);
		ArrayList<Object> actualAbilities = arrayList.get(1);

		if (abilities.size() != actualAbilities.size()) {
			assertEquals("Size of abilities ArrayList is incorrect ", abilities.size(), actualAbilities.size());

		}
		boolean sameName = true;

		Field f1 = Class.forName(abilitiesPath).getDeclaredField("name");
		f1.setAccessible(true);

		if (abilities != null && actualAbilities != null) {
			for (int i = 0; i < abilities.size(); i++) {
				Object d1f = (Object) f1.get(abilities.get(i));
				Object d2f = (Object) f1.get(actualAbilities.get(i));
				if (!d1f.equals(d2f)) {
					sameName = false;
				}
			}
		}

		assertTrue("The abilities name is loaded incorrectly", sameName);

	}

	@Test(timeout = 100)
	public void testAbilitiesSameCostDynamic()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateAbilitiesArrayLists();
		ArrayList<Object> abilities = arrayList.get(0);
		ArrayList<Object> actualAbilities = arrayList.get(1);

		if (abilities.size() != actualAbilities.size()) {
			assertEquals("Size of abilities ArrayList is incorrect ", abilities.size(), actualAbilities.size());

		}
		boolean sameCost = true;

		Field f1 = Class.forName(abilitiesPath).getDeclaredField("manaCost");
		f1.setAccessible(true);

		if (abilities != null && actualAbilities != null) {
			for (int i = 0; i < abilities.size(); i++) {
				Object d1f = (Object) f1.get(abilities.get(i));
				Object d2f = (Object) f1.get(actualAbilities.get(i));

				if (!d1f.equals(d2f)) {
					sameCost = false;
				}
			}
		}

		assertTrue("The abilities cost is loaded incorrectly", sameCost);

	}

	@Test(timeout = 100)
	public void testAbilitiesSameBaseCoolDownDynamic()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateAbilitiesArrayLists();
		ArrayList<Object> abilities = arrayList.get(0);
		ArrayList<Object> actualAbilities = arrayList.get(1);

		if (abilities.size() != actualAbilities.size()) {
			assertEquals("Size of abilities ArrayList is incorrect ", abilities.size(), actualAbilities.size());

		}

		boolean sameBaseCoolDown = true;

		Field f1 = Class.forName(abilitiesPath).getDeclaredField("baseCooldown");
		f1.setAccessible(true);

		if (abilities != null && actualAbilities != null) {
			for (int i = 0; i < abilities.size(); i++) {
				Object d1f = (Object) f1.get(abilities.get(i));
				Object d2f = (Object) f1.get(actualAbilities.get(i));

				if (!d1f.equals(d2f)) {
					sameBaseCoolDown = false;
				}
			}
		}

		assertTrue("The abilities baseCooldown is loaded incorrectly", sameBaseCoolDown);

	}

	@Test(timeout = 100)
	public void testAbilitiesAreaOfEffectDynamic()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateAbilitiesArrayLists();
		ArrayList<Object> abilities = arrayList.get(0);
		ArrayList<Object> actualAbilities = arrayList.get(1);

		if (abilities.size() != actualAbilities.size()) {
			assertEquals("Size of abilities ArrayList is incorrect ", abilities.size(), actualAbilities.size());

		}

		boolean sameCastArea = true;

		Field f1 = Class.forName(abilitiesPath).getDeclaredField("castArea");
		f1.setAccessible(true);

		if (abilities != null && actualAbilities != null) {
			for (int i = 0; i < abilities.size(); i++) {
				Object d1f = (Object) f1.get(abilities.get(i));
				Object d2f = (Object) f1.get(actualAbilities.get(i));

				if (!d1f.equals(d2f)) {
					sameCastArea = false;
				}
			}
		}

		assertTrue("The abilities castArea is loaded incorrectly", sameCastArea);

	}

	@Test(timeout = 100)
	public void testAbilitiesRequiredActionPointsDynamic()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateAbilitiesArrayLists();
		ArrayList<Object> abilities = arrayList.get(0);
		ArrayList<Object> actualAbilities = arrayList.get(1);

		if (abilities.size() != actualAbilities.size()) {
			assertEquals("Size of abilities ArrayList is incorrect ", abilities.size(), actualAbilities.size());

		}

		boolean sameRequiredActionPoints = true;

		Field f1 = Class.forName(abilitiesPath).getDeclaredField("requiredActionPoints");
		f1.setAccessible(true);

		if (abilities != null && actualAbilities != null) {
			for (int i = 0; i < abilities.size(); i++) {
				Object d1f = (Object) f1.get(abilities.get(i));
				Object d2f = (Object) f1.get(actualAbilities.get(i));

				if (!d1f.equals(d2f)) {
					sameRequiredActionPoints = false;
				}
			}
		}

		assertTrue("The abilities requiredActionPoints is loaded incorrectly", sameRequiredActionPoints);

	}

	@Test(timeout = 100)
	public void testAbilitiesSameHealingOrDamageAmountDynamic()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateAbilitiesArrayLists();
		ArrayList<Object> abilities = arrayList.get(0);
		ArrayList<Object> actualAbilities = arrayList.get(1);

		if (abilities.size() != actualAbilities.size()) {
			assertEquals("Size of abilities ArrayList is incorrect ", abilities.size(), actualAbilities.size());

		}

		boolean sameAmount = true;

		if (abilities != null && actualAbilities != null) {
			for (int i = 0; i < abilities.size(); i++) {
				Object d1f = abilities.get(i);
				Object d2f = actualAbilities.get(i);

				if (d1f.getClass().equals(Class.forName(dmgPath))) {
					Field f6 = Class.forName(dmgPath).getDeclaredField("damageAmount");
					f6.setAccessible(true);
					Object d11f = (Object) f6.get(d1f);
					Object d12f = (Object) f6.get(d2f);
					if (!d11f.equals(d12f)) {
						sameAmount = false;
					}

				} else if (d1f.getClass().equals(Class.forName(healingPath))) {
					Field f6 = Class.forName(healingPath).getDeclaredField("healAmount");
					f6.setAccessible(true);
					Object d11f = (Object) f6.get(d1f);
					Object d12f = (Object) f6.get(d2f);
					if (!d11f.equals(d12f)) {
						sameAmount = false;
					}
				}

			}
		}

		assertTrue("The abilities damage/healing amount is loaded incorrectly", sameAmount);

	}

	@Test(timeout = 100)
	public void testAbilitiesSameEffectDynamic()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateAbilitiesArrayLists();
		ArrayList<Object> abilities = arrayList.get(0);
		ArrayList<Object> actualAbilities = arrayList.get(1);

		if (abilities.size() != actualAbilities.size()) {
			assertEquals("Size of abilities ArrayList is incorrect ", abilities.size(), actualAbilities.size());

		}

		if (abilities != null && actualAbilities != null) {
			for (int i = 0; i < abilities.size(); i++) {
				Object d1f = abilities.get(i);
				Object d2f = actualAbilities.get(i);

				if (d1f.getClass().equals(Class.forName(ccAbilitiesPath))) {

					Field f6 = Class.forName(ccAbilitiesPath).getDeclaredField("effect");
					f6.setAccessible(true);
					Object d11f = (Object) f6.get(d1f);
					Object d12f = (Object) f6.get(d2f);

					boolean sameClassTwo = d11f.getClass().equals(d12f.getClass());

					assertTrue("The effect is not initalized using the correct subclass", sameClassTwo);

					Field f8 = Class.forName(effectPath).getDeclaredField("name");
					Field f9 = Class.forName(effectPath).getDeclaredField("type");
					Field f10 = Class.forName(effectPath).getDeclaredField("duration");

					f8.setAccessible(true);
					Object d15f = (Object) f8.get(d11f);
					Object d16f = (Object) f8.get(d12f);

					boolean sameEffectName = d15f.equals(d16f);

					assertTrue("The effect name is loaded incorrectly", sameEffectName);

					f9.setAccessible(true);
					Object d17f = (Object) f9.get(d11f);
					Object d18f = (Object) f9.get(d12f);

					boolean sameEffectType = d17f.equals(d18f);

					assertTrue("The EffectType is loaded incorrectly", sameEffectType);

					f10.setAccessible(true);
					Object d19f = (Object) f10.get(d11f);
					Object d20f = (Object) f10.get(d12f);

					boolean sameEffectDuration = d19f.equals(d20f);

					assertTrue("The effect duratuon is loaded incorrectly", sameEffectDuration);

				}

			}
		}

	}

	private boolean checkAbilitiesEqual(Object a1, Object a2) throws Exception {
		boolean sameClass = a1.getClass().equals(a2.getClass());
		if (!sameClass)
			return false;

		Field f1 = Class.forName(abilitiesPath).getDeclaredField("name");
		f1.setAccessible(true);
		Object d1f = (Object) f1.get(a1);
		Object d2f = (Object) f1.get(a2);
		if (!d1f.equals(d2f)) {
			return false;
		}
		Field f2 = Class.forName(abilitiesPath).getDeclaredField("manaCost");
		f2.setAccessible(true);
		Object d3f = (Object) f2.get(a1);
		Object d4f = (Object) f2.get(a2);
		if (!d3f.equals(d4f)) {
			return false;
		}

		Field f3 = Class.forName(abilitiesPath).getDeclaredField("castRange");
		f3.setAccessible(true);
		Object d5f = (Object) f3.get(a1);
		Object d6f = (Object) f3.get(a2);
		if (!d5f.equals(d6f)) {
			return false;
		}

		Field f4 = Class.forName(abilitiesPath).getDeclaredField("baseCooldown");
		f4.setAccessible(true);
		Object d7f = (Object) f4.get(a1);
		Object d8f = (Object) f4.get(a2);
		if (!d7f.equals(d8f)) {
			return false;
		}

		Field f5 = Class.forName(abilitiesPath).getDeclaredField("requiredActionPoints");
		f5.setAccessible(true);
		Object d9f = (Object) f5.get(a1);
		Object d10f = (Object) f5.get(a2);
		if (!d9f.equals(d10f)) {

			return false;
		}

		if (a1.getClass().equals(Class.forName(dmgPath))) {
			Field f6 = Class.forName(dmgPath).getDeclaredField("damageAmount");
			f6.setAccessible(true);
			Object d11f = (Object) f6.get(a1);
			Object d12f = (Object) f6.get(a2);
			if (!d11f.equals(d12f)) {
				return false;
			}

		} else if (a1.getClass().equals(Class.forName(healingPath))) {
			Field f6 = Class.forName(healingPath).getDeclaredField("healAmount");
			f6.setAccessible(true);
			Object d11f = (Object) f6.get(a1);
			Object d12f = (Object) f6.get(a2);
			if (!d11f.equals(d12f)) {
				return false;
			}

		} else if (a1.getClass().equals(Class.forName(ccAbilitiesPath))) {

			Field f6 = Class.forName(ccAbilitiesPath).getDeclaredField("effect");
			f6.setAccessible(true);
			Object d11f = (Object) f6.get(a1);
			Object d12f = (Object) f6.get(a2);

			boolean sameClassTwo = d11f.getClass().equals(d12f.getClass());
			if (!sameClassTwo)
				return false;

			Field f8 = Class.forName(effectPath).getDeclaredField("name");
			Field f9 = Class.forName(effectPath).getDeclaredField("type");
			Field f10 = Class.forName(effectPath).getDeclaredField("duration");

			f8.setAccessible(true);
			Object d15f = (Object) f8.get(d11f);
			Object d16f = (Object) f8.get(d12f);
			if (!d15f.equals(d16f)) {
				return false;
			}

			f9.setAccessible(true);
			Object d17f = (Object) f9.get(d11f);
			Object d18f = (Object) f9.get(d12f);
			if (!d17f.equals(d18f)) {
				return false;
			}

			f10.setAccessible(true);
			Object d19f = (Object) f10.get(d11f);
			Object d20f = (Object) f10.get(d12f);
			if (!d19f.equals(d20f)) {
				return false;
			}

		}

		Field f7 = Class.forName(abilitiesPath).getDeclaredField("castArea");
		f7.setAccessible(true);
		Object d13f = (Object) f7.get(a1);
		Object d14f = (Object) f7.get(a2);
		if (!d13f.equals(d14f)) {
			return false;
		}

		return true;

	}

	private Object retrieveAbility(ArrayList<Object> availableAbilities, String abilityName)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException,
			NoSuchMethodException, SecurityException {
		for (int i = 0; i < availableAbilities.size(); i++) {
			Method m = availableAbilities.get(i).getClass().getMethod("getName");
			String name = (String) m.invoke(availableAbilities.get(i));
			if (name.equals(abilityName)) {
				return availableAbilities.get(i);
			}
		}
		return null;
	}

	@Test(timeout = 1000)
	public void testPlaceFirstPlayerChampionsMethod()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, IOException, NoSuchFieldException {

		Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
		Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
		Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
		Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");

		ArrayList<Object> firstPlayerChamp1 = new ArrayList<>();

		Constructor<?> constructorChamp = Class.forName(champPath).getConstructor(String.class, int.class, int.class,
				int.class, int.class, int.class, int.class);

		firstPlayerChamp1.add(constructorChamp.newInstance("ironman", 1, 2, 3, 4, 5, 6));
		firstPlayerChamp1.add(constructorChamp.newInstance("sipderman", 1, 2, 3, 4, 5, 6));
		firstPlayerChamp1.add(constructorChamp.newInstance("drstrange", 1, 2, 3, 4, 5, 6));

		Class curr = firstPlayer.getClass();
		Field f = curr.getDeclaredField("team");
		f.setAccessible(true);
		f.set(firstPlayer, firstPlayerChamp1);

		ArrayList<Object> secPlayerChamp1 = new ArrayList<>();
		secPlayerChamp1.add(constructorChamp.newInstance("loki", 1, 2, 3, 4, 5, 6));
		secPlayerChamp1.add(constructorChamp.newInstance("wanda", 1, 2, 3, 4, 5, 6));
		secPlayerChamp1.add(constructorChamp.newInstance("thor", 1, 2, 3, 4, 5, 6));

		curr = secondPlayer.getClass();
		f = curr.getDeclaredField("team");
		f.setAccessible(true);
		f.set(secondPlayer, secPlayerChamp1);

		Constructor<?> constructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
				Class.forName(playerPath));
		Object createdGame = constructor.newInstance(firstPlayer, secondPlayer);

		Field f1 = null;
		Class curr1 = createdGame.getClass();
		f1 = curr1.getDeclaredField("board");

		f1.setAccessible(true);
		f1.set(createdGame, new Object[5][5]);

		Method method = Class.forName(gamePath).getDeclaredMethod("placeChampions");
		method.setAccessible(true);

		method.invoke(createdGame);

		Method m1 = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame1 = (Object[][]) m1.invoke(createdGame);

		Method mFP = firstPlayer.getClass().getMethod("getTeam");
		ArrayList<Object> firstPlayerChamp = (ArrayList<Object>) mFP.invoke(firstPlayer);

		Method mSP = secondPlayer.getClass().getMethod("getTeam");
		ArrayList<Object> secPlayerChamp = (ArrayList<Object>) mSP.invoke(secondPlayer);

		Method m2 = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) m2.invoke(createdGame);

		int boardWidth = boardGame.length;
		int boardHeight = boardGame[0].length;

		ArrayList<Object> champsPlacedAlready = new ArrayList<>();

		for (int i = 1; i < boardGame1[0].length - 1; i++) {
			assertTrue("Cell [" + i + "][" + 0 + "] should contain one of the first player's team",
					firstPlayerChamp.contains(boardGame1[0][i]));
			assertFalse("Champion placed twice", champsPlacedAlready.contains(boardGame1[0][i]));
			champsPlacedAlready.add(boardGame1[0][i]);
		}

	}

	@Test(timeout = 1000)
	public void testPlaceSecondPlayerChampionsMethod()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, IOException, NoSuchFieldException {

		Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
		Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
		Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
		Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");

		ArrayList<Object> firstPlayerChamp1 = new ArrayList<>();

		Constructor<?> constructorChamp = Class.forName(champPath).getConstructor(String.class, int.class, int.class,
				int.class, int.class, int.class, int.class);

		firstPlayerChamp1.add(constructorChamp.newInstance("ironman", 1, 2, 3, 4, 5, 6));
		firstPlayerChamp1.add(constructorChamp.newInstance("sipderman", 1, 2, 3, 4, 5, 6));
		firstPlayerChamp1.add(constructorChamp.newInstance("drstrange", 1, 2, 3, 4, 5, 6));

		Class curr = firstPlayer.getClass();
		Field f = curr.getDeclaredField("team");
		f.setAccessible(true);
		f.set(firstPlayer, firstPlayerChamp1);

		ArrayList<Object> secPlayerChamp1 = new ArrayList<>();
		secPlayerChamp1.add(constructorChamp.newInstance("loki", 1, 2, 3, 4, 5, 6));
		secPlayerChamp1.add(constructorChamp.newInstance("wanda", 1, 2, 3, 4, 5, 6));
		secPlayerChamp1.add(constructorChamp.newInstance("thor", 1, 2, 3, 4, 5, 6));

		curr = secondPlayer.getClass();
		f = curr.getDeclaredField("team");
		f.setAccessible(true);
		f.set(secondPlayer, secPlayerChamp1);

		Constructor<?> constructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
				Class.forName(playerPath));
		Object createdGame = constructor.newInstance(firstPlayer, secondPlayer);

		Field f1 = null;
		Class curr1 = createdGame.getClass();
		f1 = curr1.getDeclaredField("board");

		f1.setAccessible(true);
		f1.set(createdGame, new Object[5][5]);

		Method method = Class.forName(gamePath).getDeclaredMethod("placeChampions");
		method.setAccessible(true);

		method.invoke(createdGame);

		Method m1 = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame1 = (Object[][]) m1.invoke(createdGame);

		Method mFP = firstPlayer.getClass().getMethod("getTeam");
		ArrayList<Object> firstPlayerChamp = (ArrayList<Object>) mFP.invoke(firstPlayer);

		Method mSP = secondPlayer.getClass().getMethod("getTeam");
		ArrayList<Object> secPlayerChamp = (ArrayList<Object>) mSP.invoke(secondPlayer);

		Method m2 = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) m2.invoke(createdGame);

		int boardWidth = boardGame.length;
		int boardHeight = boardGame[0].length;

		ArrayList<Object> champsPlacedAlready = new ArrayList<>();

		for (int i = 1; i < boardGame1[boardHeight - 1].length - 1; i++) {
			assertTrue("Cell [4][" + i + "] should contain one of the second player's team",
					secPlayerChamp.contains(boardGame1[boardHeight - 1][i]));
			assertFalse("Champion placed twice", champsPlacedAlready.contains(boardGame1[boardHeight - 1][i]));
			champsPlacedAlready.add(boardGame1[boardHeight - 1][i]);
		}

	}

	@Test(timeout = 1000)
	public void testplaceCoversMethod()
			throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
		Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
		Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
		Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");

		Constructor<?> constructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
				Class.forName(playerPath));
		Object createdGame = constructor.newInstance(firstPlayer, secondPlayer);
		Field f = null;
		Class curr = createdGame.getClass();
		f = curr.getDeclaredField("BOARDWIDTH");
		f.setAccessible(true);

		int boardWidth = (int) f.get(createdGame);
		f = curr.getDeclaredField("BOARDHEIGHT");
		f.setAccessible(true);
		int boardHeight = (int) f.get(createdGame);

		f = curr.getDeclaredField("board");

		f.setAccessible(true);
		f.set(createdGame, new Object[boardHeight][boardWidth]);

		Method method = Class.forName(gamePath).getDeclaredMethod("placeCovers");
		method.setAccessible(true);

		method.invoke(createdGame);

		Method m2 = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) m2.invoke(createdGame);

		int counter = 0;
		for (int i = 0; i < boardGame.length; i++) {
			for (int j = 0; j < boardGame[i].length; j++) {

				if (((boardGame[i][j] != null)) && (boardGame[i][j].getClass().equals(Class.forName(coverPath))))
					counter++;
			}
		}
		assertEquals("The Number of placed covers should be 5 but was " + counter, counter, 5);

		boolean condition = (((boardGame[0][0] != null))
				&& (boardGame[0][0].getClass().equals(Class.forName(coverPath))))

				|| (((boardGame[0][boardHeight - 1] != null))
						&& (boardGame[0][boardHeight - 1].getClass().equals(Class.forName(coverPath))))

				|| (((boardGame[boardWidth - 1][0] != null))
						&& (boardGame[boardWidth - 1][0].getClass().equals(Class.forName(coverPath))))

				|| (((boardGame[boardWidth - 1][boardHeight - 1] != null))
						&& (boardGame[boardWidth - 1][boardHeight - 1].getClass().equals(Class.forName(coverPath))));

		assertFalse("No cover should be placed on any of the four corners of the board", condition);

		for (int i = 1; i < boardGame[0].length - 1; i++) {

			assertFalse("A cover was placed in a cell that should contain a champion of first player's team",
					(boardGame[0][i] != null) && (boardGame[0][i].getClass().equals(Class.forName(coverPath))));
		}

		for (int i = 1; i < boardGame[boardWidth - 1].length - 1; i++) {
			assertFalse("A cover was placed in a cell that should contain a champion of second player's team",
					(boardGame[boardWidth - 1][i] != null)
							&& (boardGame[boardWidth - 1][i].getClass().equals(Class.forName(coverPath))));
		}
		assertTrue("Covers should be randomly placed", checkRandomPlaces());

	}

	@Test(timeout = 100)
	public void testFirstPlayerChampionsLocationAfterPlaceChampions()
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {

		Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
		Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
		Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
		Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");

		ArrayList<Object> firstPlayerChamp1 = new ArrayList<>();

		Constructor<?> constructorChamp = Class.forName(champPath).getConstructor(String.class, int.class, int.class,
				int.class, int.class, int.class, int.class);

		firstPlayerChamp1.add(constructorChamp.newInstance("ironman", 1, 2, 3, 4, 5, 6));
		firstPlayerChamp1.add(constructorChamp.newInstance("sipderman", 1, 2, 3, 4, 5, 6));
		firstPlayerChamp1.add(constructorChamp.newInstance("drstrange", 1, 2, 3, 4, 5, 6));

		Class curr = firstPlayer.getClass();
		Field f = curr.getDeclaredField("team");
		f.setAccessible(true);
		f.set(firstPlayer, firstPlayerChamp1);

		ArrayList<Object> secPlayerChamp1 = new ArrayList<>();
		secPlayerChamp1.add(constructorChamp.newInstance("loki", 1, 2, 3, 4, 5, 6));
		secPlayerChamp1.add(constructorChamp.newInstance("wanda", 1, 2, 3, 4, 5, 6));
		secPlayerChamp1.add(constructorChamp.newInstance("thor", 1, 2, 3, 4, 5, 6));

		curr = secondPlayer.getClass();
		f = curr.getDeclaredField("team");
		f.setAccessible(true);
		f.set(secondPlayer, secPlayerChamp1);

		Constructor<?> constructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
				Class.forName(playerPath));
		Object createdGame = constructor.newInstance(firstPlayer, secondPlayer);

		Method mFP = firstPlayer.getClass().getMethod("getTeam");
		ArrayList<Object> firstPlayerChamp = (ArrayList<Object>) mFP.invoke(firstPlayer);

		Method mSP = secondPlayer.getClass().getMethod("getTeam");
		ArrayList<Object> secPlayerChamp = (ArrayList<Object>) mSP.invoke(secondPlayer);

		Method m2 = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) m2.invoke(createdGame);

		int boardWidth = boardGame.length;
		int boardHeight = boardGame[0].length;

		for (int i = 0; i < firstPlayerChamp.size(); i++) {
			Object champ = firstPlayerChamp.get(i);
			Method methodGetLocation = champ.getClass().getMethod("getLocation");
			Point point = (Point) methodGetLocation.invoke(champ);

			boolean condition = point != null;
			assertTrue("Location of first player's champions should be updated", condition);
			condition = point.equals(new Point(0, i + 1));
			assertTrue("Location of first player's champions should be updated correctly", condition);
		}

	}

	@Test(timeout = 100)
	public void testConstructorPlayerConstructorInitialization() throws Exception {
		Constructor<?> constructor = Class.forName(playerPath).getConstructor(String.class);
		int random = (int) (Math.random() * 50);
		String name = "name" + random;
		ArrayList<Object> team = new ArrayList<>();
		Object myObj = constructor.newInstance(name);
		String[] names = { "name", "team" };
		Object[] values = { name, team };
		testConstructorInitialization(myObj, names, values);

	}

	@Test(timeout = 100)
	public void testInstanceVariablePlayerName() throws Exception {
		testInstanceVariableIsPresent(Class.forName(playerPath), "name", true);
		testInstanceVariableIsPrivate(Class.forName(playerPath), "name");
		testInstanceVariableOfType(Class.forName(playerPath), "name", String.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariablePlayerLeader() throws Exception {
		testInstanceVariableIsPresent(Class.forName(playerPath), "leader", true);
		testInstanceVariableIsPrivate(Class.forName(playerPath), "leader");
		testInstanceVariableOfType(Class.forName(playerPath), "leader", Class.forName(champPath));
	}

	@Test(timeout = 100)
	public void testInstanceVariablePlayerTeamGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(playerPath), "getTeam", ArrayList.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariablePlayerLeaderGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(playerPath), "getLeader", Class.forName(champPath), true);
	}

	@Test(timeout = 100)
	public void testInstanceVariablePlayerTeamGetterLogic() throws Exception {
		Constructor<?> constructor = Class.forName(playerPath).getConstructor(String.class);
		int random = (int) (Math.random() * 50);
		String name = "name" + random;
		Object myObj = constructor.newInstance(name);
		ArrayList<Object> team = new ArrayList<>();
		testGetterLogic(myObj, "team", team);
	}

	@Test(timeout = 100)
	public void testInstanceVariablePlayerLeaderGetterLogic() throws Exception {
		Constructor<?> constructor = Class.forName(playerPath).getConstructor(String.class);
		int random = (int) (Math.random() * 50);
		String name = "name" + random;
		Object myObj = constructor.newInstance(name);

		Constructor<?> constructorChamp = Class.forName(champPath).getConstructor(String.class, int.class, int.class,
				int.class, int.class, int.class, int.class);
		Object leader = constructorChamp.newInstance(null, 0, 0, 0, 0, 0, 0);
		testGetterLogic(myObj, "leader", leader);
	}

	@Test(timeout = 100)
	public void testInstanceVariablePlayerLeaderSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(playerPath), "setLeader", Class.forName(champPath), true);
	}

	@Test(timeout = 100)
	public void testInstanceVariablePlayerLeaderSetterLogic() throws Exception {
		Constructor<?> constructor = Class.forName(playerPath).getConstructor(String.class);
		int random = (int) (Math.random() * 50);
		String name = "name" + random;
		Object myObj = constructor.newInstance(name);
		Constructor<?> constructorChamp = Class.forName(champPath).getConstructor(String.class, int.class, int.class,
				int.class, int.class, int.class, int.class);
		Object champ = constructorChamp.newInstance("champ" + (int) (Math.random() * 5), (int) (Math.random() * 50),
				(int) (Math.random() * 50), (int) (Math.random() * 50), (int) (Math.random() * 50),
				(int) (Math.random() * 50), (int) (Math.random() * 50));
		testSetterLogic(myObj, "leader", champ, champ, Class.forName(champPath));
	}

	@Test(timeout = 100)
	public void testInstanceVariablePlayerTeamSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(playerPath), "setTeam", ArrayList.class, false);
	}

	@Test
	public void testPriorityQueueClassExists() {
		try {
			Class.forName(priorityQueuePath);
		} catch (ClassNotFoundException e) {
			Assert.fail("Should create a class called 'Car'.");
		}
	}

	@Test(timeout = 100)
	public void testConstructorGameActionException() throws Exception {

		Class[] inputs = { String.class };
		testConstructorExists(Class.forName(gameExceptionPath), inputs);
	}

	@Test(timeout = 100)
	public void testEmptyConstructorGameActionException() throws Exception {

		Class[] inputs = {};
		testConstructorExists(Class.forName(gameExceptionPath), inputs);
	}

	@Test(timeout = 1000)
	public void testClassIsSubclassGameActionException() throws Exception {
		testClassIsSubclass(Class.forName(gameExceptionPath), Exception.class);
	}

	@Test(timeout = 100)
	public void testConstructorAbilityUseException() throws Exception {

		Class[] inputs = { String.class };
		testConstructorExists(Class.forName(abilityExceptionPath), inputs);
	}

	@Test(timeout = 100)
	public void testEmptyConstructorAbilityUseException() throws Exception {

		Class[] inputs = {};
		testConstructorExists(Class.forName(abilityExceptionPath), inputs);
	}

	@Test(timeout = 1000)
	public void testClassIsSubclassAbilityUseException() throws Exception {
		testClassIsSubclass(Class.forName(abilityExceptionPath), Class.forName(gameExceptionPath));
	}

	public void testConstructorAbilityUseExceptionInitialization() throws Exception {
		Constructor<?> constructor = Class.forName(abilityExceptionPath).getConstructor(int.class);
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

	@Test(timeout = 100)
	public void testConstructorLeaderAbilityAlreadyUsedException() throws Exception {

		Class[] inputs = { String.class };
		testConstructorExists(Class.forName(leaderAbilityAlreadyUsedExceptionPath), inputs);
	}

	@Test(timeout = 100)
	public void testEmptyConstructorUnallowedMovementException() throws Exception {

		Class[] inputs = {};
		testConstructorExists(Class.forName(unallowedMovementExceptionPath), inputs);
	}

	@Test(timeout = 1000)
	public void testClassIsSubclassUnallowedMovementException() throws Exception {
		testClassIsSubclass(Class.forName(unallowedMovementExceptionPath), Class.forName(gameExceptionPath));
	}

	private boolean checkRandomPlaces() throws NoSuchMethodException, SecurityException, ClassNotFoundException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		boolean check = true;

		int countTrue = 0;

		ArrayList<String> allStrings = new ArrayList<>();
		for (int i = 0; i < 25; i++) {
			allStrings.add(helperBoard());
		}
		for (int i = 0; i < allStrings.size(); i++) {
			String s1 = allStrings.get(i);
			for (int j = 0; j < allStrings.size(); j++) {
				String s2 = allStrings.get(j);
				if (arePermutation(s1, s2))
					countTrue++;

			}
		}
		if (countTrue / 625 > 0.3)
			check = false;
		return check;
	}

	private String helperBoard() throws NoSuchMethodException, SecurityException, ClassNotFoundException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
		Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
		Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
		Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");

		Constructor<?> constructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
				Class.forName(playerPath));

		Object createdGame = constructor.newInstance(firstPlayer, secondPlayer);

		Method method = Class.forName(gamePath).getDeclaredMethod("placeCovers");
		method.setAccessible(true);

		method.invoke(createdGame);

		Method m2 = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) m2.invoke(createdGame);
		String s = "";
		for (int i = 0; i < boardGame.length; i++) {
			for (int j = 0; j < boardGame[i].length; j++) {
				if (((boardGame[i][j] != null)) && (boardGame[i][j].getClass().equals(Class.forName(coverPath)))) {
					s += i + "" + j;
				}

			}
		}
		return s;
	}

	private static boolean arePermutation(String str1, String str2) {

		int n1 = str1.length();
		int n2 = str2.length();

		if (n1 != n2)
			return false;
		char ch1[] = str1.toCharArray();
		char ch2[] = str2.toCharArray();

		Arrays.sort(ch1);
		Arrays.sort(ch2);

		for (int i = 0; i < n1; i++)
			if (ch1[i] != ch2[i])
				return false;

		return true;
	}

	private void testConstructorDoesnotExist(Class aClass, Class[] inputs) {
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
			assertTrue("There should not be a  constructor with " + msg + " parameter" + (inputs.length > 1 ? "s" : "")
					+ " in " + aClass.getSimpleName() + " class.", thrown);
		} else
			assertFalse("Missing constructor with zero parameters in " + aClass.getSimpleName() + " class.", thrown);
	}

	private static void testEnumValues(String name, String path, String[] value) {

		try {
			Class aClass = Class.forName(path);
			for (int i = 0; i < value.length; i++) {
				try {
					Enum.valueOf((Class<Enum>) aClass, value[i]);
				} catch (IllegalArgumentException e) {
					fail(aClass.getSimpleName() + " enum can be " + value[i]);
				}
			}
		} catch (ClassNotFoundException e1) {

			fail("There should be an enum called " + name + "in package " + path);
		}

	}

	private void testInstanceVariableIsPresent(Class aClass, String varName, boolean implementedVar)
			throws SecurityException {
		boolean thrown = false;
		try {
			aClass.getDeclaredField(varName);
		} catch (NoSuchFieldException e) {
			thrown = true;
		}
		if (implementedVar) {
			assertFalse(
					"There should be \"" + varName + "\" instance variable in class " + aClass.getSimpleName() + ".",
					thrown);
		} else {
			assertTrue("The instance variable \"" + varName + "\" should not be declared in class "
					+ aClass.getSimpleName() + ".", thrown);
		}
	}

	private void testInstanceVariableOfType(Class aClass, String varName, Class expectedType) {
		Field f = null;
		boolean b = true;
		try {
			f = aClass.getDeclaredField(varName);
		} catch (NoSuchFieldException e) {
			b = false;
		}
		if (b) {
			Class varType = f.getType();
			assertEquals("The attribute " + varType.getSimpleName() + " of instance variable: " + varName
					+ " should be of the type " + expectedType.getSimpleName(), expectedType, varType);
		} else {
			assertTrue("The instance variable \"" + varName + "\" should be declared in class " + aClass.getSimpleName()
					+ ".", false);
		}

	}

	private void testInstanceVariableIsPrivate(Class aClass, String varName)
			throws NoSuchFieldException, SecurityException {
		Field f = aClass.getDeclaredField(varName);
		boolean b = 2 == f.getModifiers();
		assertTrue("The \"" + varName + "\" instance variable in class " + aClass.getSimpleName()
				+ " should not be accessed outside that class.", b);
	}

	private void testGetterMethodExistsInClass(Class aClass, String methodName, Class returnedType,
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
		Class curr = createdObject.getClass();

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

	private void testSetterMethodExistsInClass(Class aClass, String methodName, Class inputType,
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

	private void testSetterLogic(Object createdObject, String name, Object setValue, Object expectedValue, Class type)
			throws Exception {

		Field f = null;
		Class curr = createdObject.getClass();

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
			Class type) throws Exception {

		Field f = null;
		Class curr = createdObject.getClass();

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
		if (name.equals("currentActionPoints") || name.equals("currentHP")) {
			if ((int) setValue > (int) expectedValue) {
				assertEquals("The method \"" + methodName + "\" in class " + createdObject.getClass().getSimpleName()
						+ " should set the correct value of variable \"" + name
						+ "\". It should not exceed the maximum value.", expectedValue, f.get(createdObject));
			} else if ((int) setValue == -1 && (int) expectedValue == 0) {
				assertEquals("The method \"" + methodName + "\" in class " + createdObject.getClass().getSimpleName()
						+ " should set the correct value of variable \"" + name
						+ "\". It should not be less than zero.", expectedValue, f.get(createdObject));
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

	}

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
			if (currName.equals("currentHP") || currName.equals("currentActionPoints")) {

				assertEquals(
						"The constructor of the " + createdObject.getClass().getSimpleName()
								+ " class should initialize the instance variable \"" + currName
								+ "\" correctly. It should be equals to the max initially.",
						currValue, f.get(createdObject));
			} else {
				assertEquals(
						"The constructor of the " + createdObject.getClass().getSimpleName()
								+ " class should initialize the instance variable \"" + currName + "\" correctly.",
						currValue, f.get(createdObject));
			}
		}

	}

	private void testConstructorInitializationCover(Object[] createdObject, String[] names, Object[] values)
			throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException {

		Integer[] currentHPValues = new Integer[createdObject.length];
		for (int j = 0; j < createdObject.length; j++) {
			for (int i = 0; i < names.length; i++) {
				Field f = null;
				Class curr = createdObject[j].getClass();
				String currName = names[i];
				Object currValue = values[i];

				while (f == null) {

					if (curr == Object.class)
						fail("Class " + createdObject[j].getClass().getSimpleName()
								+ " should have the instance variable \"" + currName + "\".");
					try {
						f = curr.getDeclaredField(currName);
					} catch (NoSuchFieldException e) {
						curr = curr.getSuperclass();
					}

				}
				f.setAccessible(true);
				if (!names[i].equals("currentHP")) {
					assertEquals(
							"The constructor of the " + createdObject[j].getClass().getSimpleName()
									+ " class should initialize the instance variable \"" + currName + "\" correctly.",
							currValue, f.get(createdObject[j]));
				}
				if (names[i].equals("currentHP")) {
					currentHPValues[j] = (int) f.get(createdObject[j]);
					int num = (int) f.get(createdObject[j]);
					if (!(num >= 100 && num < 1000)) {
						assertEquals("The constructor of the " + createdObject[j].getClass().getSimpleName()
								+ " class should initialize the instance variable \"" + currName
								+ "\" correctly. It should be a random number between 100(inclusive) and 1000(exclusive).",
								currValue, num);

					}
				}
			}

		}

		String expected = "{";
		for (int i = 0; i < 3; i++) {
			expected = expected + ((int) (Math.random() * 1000) + 100) + ", ";
		}
		expected = expected + "...}";
		Set<Integer> s = new HashSet<Integer>(Arrays.asList(currentHPValues));
		String tmp = "{";
		for (int i = 0; i < 3; i++) {
			tmp = tmp + currentHPValues[i] + ", ";
		}
		tmp = tmp + "...}";
		if (!((s.size() <= currentHPValues.length && s.size() >= currentHPValues.length * 0.2))) {
			assertEquals("The constructor of the " + createdObject[0].getClass().getSimpleName()
					+ " class should initialize the instance variable \"" + "currentHP"
					+ "\" correctly. It should be a random number not a constant.", expected, tmp);

		}

	}

	private void testClassIsSubclass(Class subClass, Class superClass) {
		assertEquals(subClass.getSimpleName() + " class should be a subclass from " + superClass.getSimpleName() + ".",
				superClass, subClass.getSuperclass());
	}

	private void testSetterAbsentInSubclasses(String varName, String[] subclasses)
			throws SecurityException, ClassNotFoundException {
		String methodName = "set" + varName.substring(0, 1).toUpperCase() + varName.substring(1);
		boolean methodIsInSubclasses = false;
		for (String subclass : subclasses) {
			Method[] methods = Class.forName(subclass).getDeclaredMethods();
			methodIsInSubclasses = methodIsInSubclasses || containsMethodName(methods, methodName);

		}
		assertFalse("The " + methodName + " method should not be implemented in a subclasses.", methodIsInSubclasses);
	}

	private void testGetterAbsentInSubclasses(String varName, String[] subclasses, Class type)
			throws SecurityException, ClassNotFoundException {
		String methodName = "get" + varName.substring(0, 1).toUpperCase() + varName.substring(1);
		if (type == boolean.class) {
			methodName = "is" + varName.substring(0, 1).toUpperCase() + varName.substring(1);
		}
		boolean methodIsInSubclasses = false;
		for (String subclass : subclasses) {
			Method[] methods = Class.forName(subclass).getDeclaredMethods();
			methodIsInSubclasses = methodIsInSubclasses || containsMethodName(methods, methodName);

		}
		assertFalse("The " + methodName + " method should not be implemented in subclasses.", methodIsInSubclasses);
	}

	private void testIsEnum(Class aClass) {

		assertEquals(aClass.getName() + " should be an Enum", true, aClass.isEnum());

	}

	private void testStaticVariableIsPrivate(Class aClass, String varName)
			throws NoSuchFieldException, SecurityException {
		Field f = aClass.getDeclaredField(varName);
		int modifiers = f.getModifiers();
		assertTrue(f.getName() + " variable in calss Game should be private", (Modifier.isPrivate(modifiers)));

	}
}
