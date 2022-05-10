package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Point;
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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Condition;

import org.junit.Test;

@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
public class M1PrivateTests {
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

	@Test(timeout = 1000)
	public void testClassIsEnumEffectType() throws Exception {
		testIsEnum(Class.forName(effectTypePath));
	}

	@Test(timeout = 1000)
	public void testEnumValuesEffectType() {
		String[] inputs = { "BUFF", "DEBUFF" };
		testEnumValues("EffectType", effectTypePath, inputs);
	}

	@Test(timeout = 100)
	public void testEnumDirectionValues() throws ClassNotFoundException {
		try {
			Enum.valueOf((Class<Enum>) Class.forName(directionPath), "LEFT");
		} catch (IllegalArgumentException e) {
			fail("Direction enum can be LEFT");
		}
	}

	@Test(timeout = 1000)
	public void testEffectIsSuperClassOfStun() throws Exception {
		testClassIsSubclass(Class.forName(stunPath), Class.forName(effectPath));
	}

	@Test(timeout = 1000)
	public void testEffectIsSuperClassOfSpeedUp() throws Exception {
		testClassIsSubclass(Class.forName(speedUpPath), Class.forName(effectPath));
	}

	@Test(timeout = 1000)
	public void testEffectIsSuperClassOfRoot() throws Exception {
		testClassIsSubclass(Class.forName(rootPath), Class.forName(effectPath));
	}

	@Test(timeout = 1000)
	public void testEffectIsSuperClassOfDodge() throws Exception {
		testClassIsSubclass(Class.forName(DodgePath), Class.forName(effectPath));
	}

	@Test(timeout = 1000)
	public void testEffectIsSuperClassOfSilence() throws Exception {
		testClassIsSubclass(Class.forName(silencePath), Class.forName(effectPath));
	}

	@Test(timeout = 1000)
	public void testAbilityIsSuperClassOfCrowdControlAbility() throws Exception {
		testClassIsSubclass(Class.forName(crowdControlAbilityPath), Class.forName(abilityPath));
	}

	@Test(timeout = 1000)
	public void testConstructor0PowerUp() throws Exception {
		Class[] inputs = { int.class };
		testConstructorExists(Class.forName(powerUpPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructor0Embrace() throws Exception {
		Class[] inputs = { int.class };
		testConstructorExists(Class.forName(embracePath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructor0Disarm() throws Exception {
		Class[] inputs = { int.class };
		testConstructorExists(Class.forName(disarmPath), inputs);
	}

	@Test(timeout = 1000)
	public void testInvalidConstructor0Embrace() throws Exception {
		Class[] inputs = { String.class, int.class, Class.forName(effectTypePath) };
		testConstructorDoesnotExist(Class.forName(embracePath), inputs);
	}

	@Test(timeout = 1000)
	public void testInvalidConstructor0Root() throws Exception {
		Class[] inputs = { String.class, int.class, Class.forName(effectTypePath) };
		testConstructorDoesnotExist(Class.forName(rootPath), inputs);
	}

	@Test(timeout = 1000)
	public void testInvalidConstructor0Shock() throws Exception {
		Class[] inputs = { String.class, int.class, Class.forName(effectTypePath) };
		testConstructorDoesnotExist(Class.forName(shockPath), inputs);
	}

	@Test(timeout = 1000)
	public void testInvalidConstructor0Dodge() throws Exception {
		Class[] inputs = { String.class, int.class, Class.forName(effectTypePath) };
		testConstructorDoesnotExist(Class.forName(DodgePath), inputs);
	}

	@Test(timeout = 1000)
	public void testInvalidConstructor0Stun() throws Exception {
		Class[] inputs = { String.class, int.class, Class.forName(effectTypePath) };
		testConstructorDoesnotExist(Class.forName(stunPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructor0DamagingAbility() throws Exception {
		Class[] inputs = { String.class, int.class, int.class, int.class, Class.forName(areaOfEffectPath), int.class,
				int.class };
		testConstructorExists(Class.forName(damagingAbilityPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorInitialization1800Shield() throws Exception {
		int r = (int)( Math.random() * 500);
		int int40 = 40 + r;
		Object shield00 = Class.forName(shieldPath).getConstructor(int.class).newInstance(int40);

		String shieldString = "Shield";
		Object effectType00 = Enum.valueOf((Class<Enum>) Class.forName(effectTypePath), "BUFF");
		String[] names = { "name", "duration", "type" };
		Object[] values = { shieldString, int40, effectType00 };

		testConstructorInitialization(shield00, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorInitialization1900PowerUp() throws Exception {
		int r = (int)( Math.random() * 500);
		int int00 = 0 + r;
		Object powerUp00 = Class.forName(powerUpPath).getConstructor(int.class).newInstance(int00);

		String powerUpString = "PowerUp";
		Object effectType00 = Enum.valueOf((Class<Enum>) Class.forName(effectTypePath), "BUFF");
		String[] names = { "name", "duration", "type" };
		Object[] values = { powerUpString, int00, effectType00 };

		testConstructorInitialization(powerUp00, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorInitialization2000Embrace() throws Exception {
		int r = (int)( Math.random() * 500);
		int int90 = 90 + r;
		Object embrace00 = Class.forName(embracePath).getConstructor(int.class).newInstance(int90);

		String embraceString = "Embrace";
		Object effectType00 = Enum.valueOf((Class<Enum>) Class.forName(effectTypePath), "BUFF");
		String[] names = { "name", "duration", "type" };
		Object[] values = { embraceString, int90, effectType00 };

		testConstructorInitialization(embrace00, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorInitialization2100Disarm() throws Exception {
		int r = (int) (Math.random() * 500);
		int int16 = 16 + r;
		Object disarm00 = Class.forName(disarmPath).getConstructor(int.class).newInstance(int16);

		String disarmString = "Disarm";
		Object effectType01 = Enum.valueOf((Class<Enum>) Class.forName(effectTypePath), "DEBUFF");
		String[] names = { "name", "duration", "type" };
		Object[] values = { disarmString, int16, effectType01 };

		testConstructorInitialization(disarm00, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorInitialization2200Ability() throws Exception {
		int r = (int)( Math.random() * 500);
		String string00 = "wq8" + r;
		int int78 = 78 + r;
		int int71 = 7 + r;
		int int11 = 11 + r;
		int r2 = ((int) (Math.random() * 4));
		Object areaOfEffect00 = null;
		if (r2 == 0)
			areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SELFTARGET");
		else if (r2 == 1)
			areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SINGLETARGET");
		else if (r2 == 2)
			areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "TEAMTARGET");
		else
			areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SURROUND");
		int int88 = 88 + r;
		Object ability00 = Class
				.forName(abilityPath).getConstructor(String.class, int.class, int.class, int.class,
						Class.forName(areaOfEffectPath), int.class)
				.newInstance(string00, int78, int71, int11, areaOfEffect00, int88);

		int int00 = 0 ;
		String[] names = { "name", "manaCost", "baseCooldown", "currentCooldown", "castRange", "requiredActionPoints",
				"castArea" };
		Object[] values = { string00, int78, int71, int00, int11, int88, areaOfEffect00 };

		testConstructorInitialization(ability00, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorInitialization2300HealingAbility() throws Exception {
		int r = (int)( Math.random() * 500);
		String string02 = "ocpze" + r;
		int int10 = 10 + r;
		int int55 = 55 + r;
		int int16 = 16 + r;
		int r2 = (int) (Math.random() * 4);
		Object areaOfEffect00 = null;
		if (r2 == 0)
			areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SELFTARGET");
		else if (r2 == 1)
			areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SINGLETARGET");
		else if (r2 == 2)
			areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "TEAMTARGET");
		else
			areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SURROUND");
		int int50 = 50 + r;
		int int85 = 85 + r;
		Object healingAbility00 = Class
				.forName(healingAbilityPath).getConstructor(String.class, int.class, int.class, int.class,
						Class.forName(areaOfEffectPath), int.class, int.class)
				.newInstance(string02, int10, int55, int16, areaOfEffect00, int50, int85);

		int int00 = 0 ;
		String[] names = { "healAmount", "name", "manaCost", "baseCooldown", "currentCooldown", "castRange",
				"requiredActionPoints", "castArea" };
		Object[] values = { int85, string02, int10, int55, int00, int16, int50, areaOfEffect00 };

		testConstructorInitialization(healingAbility00, names, values);
	}

	@Test(timeout = 1000)
	public void testInstanceVariableDamageAmountIsPresentInClassDamagingAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(damagingAbilityPath), "damageAmount", true);
	}

	@Test(timeout = 1000)
	public void testInstanceVariableEffectIsPresentInClassCrowdControlAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(crowdControlAbilityPath), "effect", true);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableNameIsNotPresentInClassStun() throws Exception {
		testInstanceVariableIsPresent(Class.forName(stunPath), "name", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableNameIsNotPresentInClassSpeedUp() throws Exception {
		testInstanceVariableIsPresent(Class.forName(speedUpPath), "name", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableNameIsNotPresentInClassDodge() throws Exception {
		testInstanceVariableIsPresent(Class.forName(DodgePath), "name", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableNameIsNotPresentInClassSilence() throws Exception {
		testInstanceVariableIsPresent(Class.forName(silencePath), "name", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableNameIsNotPresentInClassShock() throws Exception {
		testInstanceVariableIsPresent(Class.forName(shockPath), "name", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableNameIsNotPresentInClassHealingAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(healingAbilityPath), "name", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableNameIsNotPresentInClassDamagingAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(damagingAbilityPath), "name", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableNameIsNotPresentInClassCrowdControlAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(crowdControlAbilityPath), "name", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableCastRangeIsNotPresentInClassHealingAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(healingAbilityPath), "castRange", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableCastRangeIsNotPresentInClassDamagingAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(damagingAbilityPath), "castRange", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableCastRangeIsNotPresentInClassCrowdControlAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(crowdControlAbilityPath), "castRange", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableRequiredActionPointsIsNotPresentInClassHealingAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(healingAbilityPath), "requiredActionPoints", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableRequiredActionPointsIsNotPresentInClassDamagingAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(damagingAbilityPath), "requiredActionPoints", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableRequiredActionPointsIsNotPresentInClassCrowdControlAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(crowdControlAbilityPath), "requiredActionPoints", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableCastAreaIsNotPresentInClassHealingAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(healingAbilityPath), "castArea", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableCastAreaIsNotPresentInClassDamagingAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(damagingAbilityPath), "castArea", false);
	}

	@Test(timeout = 10000)
	public void testInstanceVariableCastAreaIsNotPresentInClassCrowdControlAbility() throws Exception {
		testInstanceVariableIsPresent(Class.forName(crowdControlAbilityPath), "castArea", false);
	}

	@Test(timeout = 1000)
	public void testInstanceVariableTypeIsPrivateInClassEffect() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(effectPath), "type");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableRequiredActionPointsIsPrivateInClassAbility() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(abilityPath), "requiredActionPoints");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableCastAreaIsPrivateInClassAbility() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(abilityPath), "castArea");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableEffectIsPrivateInClassCrowdControlAbility() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(crowdControlAbilityPath), "effect");
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableTypeExistsInClassEffect() throws Exception {
		testGetterMethodExistsInClass(Class.forName(effectPath), "getType", Class.forName(effectTypePath), true);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableRequiredActionPointsExistsInClassAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(abilityPath), "getRequiredActionPoints", int.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableCastAreaExistsInClassAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(abilityPath), "getCastArea", Class.forName(areaOfEffectPath), true);
	}

	@Test(timeout = 1000)
	public void testSetterForInstanceVariablNameExistsInClassEffect() throws Exception {
		testSetterMethodExistsInClass(Class.forName(abilityPath), "setName", String.class, false);
	}

	@Test(timeout = 1000)
	public void testSetterForInstanceVariableCurrentCastRangeInClassAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(abilityPath), "setCastRange", int.class, false);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableDamageAmountExistsInClassDamagingAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(damagingAbilityPath), "getDamageAmount", int.class, true);
	}

	@Test(timeout = 1000)
	public void testSetterForInstanceVariableHealAmountExistsInClassDamagingAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(healingAbilityPath), "setHealAmount", int.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableEffectExistsInClassCrowdControlAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(crowdControlAbilityPath), "getEffect", Class.forName(effectPath),
				true);
	}

	@Test(timeout = 1000)
	public void testSetterForInstanceVariableEffectExistsInClassCrowdControlAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(crowdControlAbilityPath), "setEffect", Class.forName(effectPath),
				false);
	}

	@Test(timeout = 1000)
	public void testSetterForInstanceVariableRequiredActionPointsExistsInClassAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(abilityPath), "setRequiredActionPoints", int.class, false);
	}

	@Test(timeout = 1000)
	public void testSetterForInstanceVariableCastAreaExistsInClassAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(abilityPath), "setCastArea", Class.forName(areaOfEffectPath),
				false);
	}

	@Test(timeout = 1000)
	public void testGetterLogicForInstanceVariableNameeffect00string00InClassEffect() throws Exception {
		int r = (int) (Math.random() * 500);
		String string00 = "wq8" + r;
		int int26 = 26 + r;
		Object effectType01 = Enum.valueOf((Class<Enum>) Class.forName(effectTypePath), "DEBUFF");
		Object effect00 = Class.forName(effectPath)
				.getConstructor(String.class, int.class, Class.forName(effectTypePath))
				.newInstance(string00, int26, effectType01);

		testGetterLogic(effect00, "name", string00);
	}

	@Test(timeout = 1000)
	public void testGetterLogicForInstanceVariableManaCostability00int78InClassAbility() throws Exception {
		int r = (int) (Math.random() * 500);
		String string00 = "wq8" + r;
		int int78 = 78 + r;
		int int71 = 71 + r;
		int int11 = 11 + r;
		Object areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SELFTARGET");
		int int88 = 88 + r;
		Object ability00 = Class
				.forName(abilityPath).getConstructor(String.class, int.class, int.class, int.class,
						Class.forName(areaOfEffectPath), int.class)
				.newInstance(string00, int78, int71, int11, areaOfEffect00, int88);

		testGetterLogic(ability00, "manaCost", int78);
	}

	@Test(timeout = 1000)
	public void testGetterLogicForInstanceVariableBaseCooldownability00int71InClassAbility() throws Exception {
		int r = (int) (Math.random() * 500);
		String string00 = "wq8" + r;
		int int78 = 78 + r;
		int int71 = 71 + r;
		int int11 = 11 + r;
		Object areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SELFTARGET");
		int int88 = 88 + r;
		Object ability00 = Class
				.forName(abilityPath).getConstructor(String.class, int.class, int.class, int.class,
						Class.forName(areaOfEffectPath), int.class)
				.newInstance(string00, int78, int71, int11, areaOfEffect00, int88);
		testGetterLogic(ability00, "baseCooldown", int71);
	}

	@Test(timeout = 1000)
	public void testGetterLogicForInstanceVariableCurrentCooldownability00int00InClassAbility() throws Exception {
		int r = (int) (Math.random() * 500);
		String string00 = "wq8" + r;
		int int78 = 78 + r;
		int int71 = 71 + r;
		int int11 = 11 + r;
		Object areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SELFTARGET");
		int int88 = 88 + r;
		Object ability00 = Class
				.forName(abilityPath).getConstructor(String.class, int.class, int.class, int.class,
						Class.forName(areaOfEffectPath), int.class)
				.newInstance(string00, int78, int71, int11, areaOfEffect00, int88);
		int int00 = 0 + r;

		testGetterLogic(ability00, "currentCooldown", int00);
	}

	@Test(timeout = 1000)
	public void testGetterLogicForInstanceVariableCastRangeability00int11InClassAbility() throws Exception {
		int r = (int) (Math.random() * 500);
		String string00 = "wq8" + r;
		int int78 = 78 + r;
		int int71 = 71 + r;
		int int11 = 11 + r;
		Object areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SELFTARGET");
		int int88 = 88 + r;
		Object ability00 = Class
				.forName(abilityPath).getConstructor(String.class, int.class, int.class, int.class,
						Class.forName(areaOfEffectPath), int.class)
				.newInstance(string00, int78, int71, int11, areaOfEffect00, int88);

		testGetterLogic(ability00, "castRange", int11);
	}

	@Test(timeout = 1000)
	public void testGetterLogicForInstanceVariableRequiredActionPointsability00int88InClassAbility() throws Exception {
		int r = (int) (Math.random() * 500);
		String string00 = "wq8" + r;
		int int78 = 78 + r;
		int int71 = 71 + r;
		int int11 = 11 + r;
		Object areaOfEffect00 = Enum.valueOf((Class<Enum>) Class.forName(areaOfEffectPath), "SELFTARGET");
		int int88 = 88 + r;
		Object ability00 = Class
				.forName(abilityPath).getConstructor(String.class, int.class, int.class, int.class,
						Class.forName(areaOfEffectPath), int.class)
				.newInstance(string00, int78, int71, int11, areaOfEffect00, int88);

		testGetterLogic(ability00, "requiredActionPoints", int88);
	}

	@Test(timeout = 1000)
	public void testGetterLogicForInstanceVariableCastAreaability00areaOfEffect00InClassAbility() throws Exception {
		int r = (int) (Math.random() * 500);
		String string00 = "wq8" + r;
		int int78 = 78 + r;
		int int71 = 71 + r;
		int int11 = 11 + r;
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
		int int88 = 88 + r;
		Object ability00 = Class
				.forName(abilityPath).getConstructor(String.class, int.class, int.class, int.class,
						Class.forName(areaOfEffectPath), int.class)
				.newInstance(string00, int78, int71, int11, areaOfEffect00, int88);

		testGetterLogic(ability00, "castArea", areaOfEffect00);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableCurrentCooldownability00int88InClassAbility() throws Exception {
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

		testSetterLogic(ability00, "currentCooldown", int71 + r, int71, int.class);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableCurrentCooldownaUpperBound00int88InClassAbility() throws Exception {
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

		testSetterLogic(ability00, "currentCooldown", int71 + r, int71, int.class);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableNameExistsInClassPowerUp() throws Exception {
		testSetterMethodExistsInClass(Class.forName(powerUpPath), "setName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableNameExistsInClassEmbrace() throws Exception {
		testSetterMethodExistsInClass(Class.forName(embracePath), "setName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableNameExistsInClassDisarm() throws Exception {
		testSetterMethodExistsInClass(Class.forName(disarmPath), "setName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableDurationExistsInClassStun() throws Exception {
		testSetterMethodExistsInClass(Class.forName(stunPath), "setDuration", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableDurationExistsInClassSpeedUp() throws Exception {
		testSetterMethodExistsInClass(Class.forName(speedUpPath), "setDuration", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableDurationExistsInClassDodge() throws Exception {
		testSetterMethodExistsInClass(Class.forName(DodgePath), "setDuration", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableDurationExistsInClassSilence() throws Exception {
		testSetterMethodExistsInClass(Class.forName(silencePath), "setDuration", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableDurationExistsInClassShock() throws Exception {
		testSetterMethodExistsInClass(Class.forName(shockPath), "setDuration", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableDurationExistsInClassShield() throws Exception {
		testSetterMethodExistsInClass(Class.forName(shieldPath), "setDuration", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableTypeExistsInClassDodge() throws Exception {
		testSetterMethodExistsInClass(Class.forName(DodgePath), "setType", Class.forName(effectTypePath), false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableTypeExistsInClassSilence() throws Exception {
		testSetterMethodExistsInClass(Class.forName(silencePath), "setType", Class.forName(effectTypePath), false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableTypeExistsInClassShock() throws Exception {
		testSetterMethodExistsInClass(Class.forName(shockPath), "setType", Class.forName(effectTypePath), false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableTypeExistsInClassShield() throws Exception {
		testSetterMethodExistsInClass(Class.forName(shieldPath), "setType", Class.forName(effectTypePath), false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableTypeExistsInClassPowerUp() throws Exception {
		testSetterMethodExistsInClass(Class.forName(powerUpPath), "setType", Class.forName(effectTypePath), false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableTypeExistsInClassEmbrace() throws Exception {
		testSetterMethodExistsInClass(Class.forName(embracePath), "setType", Class.forName(effectTypePath), false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableNameExistsInClassCrowdControlAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(crowdControlAbilityPath), "setName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableManaCostExistsInClassHealingAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(healingAbilityPath), "setManaCost", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableManaCostExistsInClassDamagingAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(damagingAbilityPath), "setManaCost", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableBaseCooldownExistsInClassCrowdControlAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(crowdControlAbilityPath), "setBaseCooldown", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableCurrentCooldownExistsInClassHealingAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(healingAbilityPath), "setCurrentCooldown", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableCurrentCooldownExistsInClassDamagingAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(damagingAbilityPath), "setCurrentCooldown", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableCastRangeExistsInClassCrowdControlAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(crowdControlAbilityPath), "setCastRange", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableRequiredActionPointsExistsInClassHealingAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(healingAbilityPath), "setRequiredActionPoints", int.class, false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableCastAreaExistsInClassDamagingAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(damagingAbilityPath), "setCastArea",
				Class.forName(areaOfEffectPath), false);
	}

	@Test(timeout = 10000)
	public void testSetterForInstanceVariableCastAreaExistsInClassCrowdControlAbility() throws Exception {
		testSetterMethodExistsInClass(Class.forName(crowdControlAbilityPath), "setCastArea",
				Class.forName(areaOfEffectPath), false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableNameExistsInClassStun() throws Exception {
		testGetterMethodExistsInClass(Class.forName(stunPath), "getName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableNameExistsInClassSpeedUp() throws Exception {
		testGetterMethodExistsInClass(Class.forName(speedUpPath), "getName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableDurationExistsInClassSlipperiness() throws Exception {
		testGetterMethodExistsInClass(Class.forName(DodgePath), "getDuration", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableDurationExistsInClassSilence() throws Exception {
		testGetterMethodExistsInClass(Class.forName(silencePath), "getDuration", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableDurationExistsInClassShock() throws Exception {
		testGetterMethodExistsInClass(Class.forName(shockPath), "getDuration", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableDurationExistsInClassShield() throws Exception {
		testGetterMethodExistsInClass(Class.forName(shieldPath), "getDuration", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableDurationExistsInClassPowerUp() throws Exception {
		testGetterMethodExistsInClass(Class.forName(powerUpPath), "getDuration", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableTypeExistsInClassEmbrace() throws Exception {
		testGetterMethodExistsInClass(Class.forName(embracePath), "getType", Class.forName(effectTypePath), false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableTypeExistsInClassDisarm() throws Exception {
		testGetterMethodExistsInClass(Class.forName(disarmPath), "getType", Class.forName(effectTypePath), false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableNameExistsInClassHealingAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(healingAbilityPath), "getName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableNameExistsInClassDamagingAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(damagingAbilityPath), "getName", String.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableManaCostExistsInClassCrowdControlAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(crowdControlAbilityPath), "getManaCost", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableBaseCooldownExistsInClassHealingAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(healingAbilityPath), "getBaseCooldown", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableBaseCooldownExistsInClassDamagingAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(damagingAbilityPath), "getBaseCooldown", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableBaseCooldownExistsInClassCrowdControlAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(crowdControlAbilityPath), "getBaseCooldown", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableCurrentCooldownExistsInClassHealingAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(healingAbilityPath), "getCurrentCooldown", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableCurrentCooldownExistsInClassDamagingAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(damagingAbilityPath), "getCurrentCooldown", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableCurrentCooldownExistsInClassCrowdControlAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(crowdControlAbilityPath), "getCurrentCooldown", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableCastRangeExistsInClassCrowdControlAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(crowdControlAbilityPath), "getCastRange", int.class, false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableRequiredActionPointsExistsInClassCrowdControlAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(crowdControlAbilityPath), "getRequiredActionPoints", int.class,
				false);
	}

	@Test(timeout = 10000)
	public void testGetterForInstanceVariableCastAreaExistsInClassHealingAbility() throws Exception {
		testGetterMethodExistsInClass(Class.forName(healingAbilityPath), "getCastArea", Class.forName(areaOfEffectPath),
				false);
	}

	@Test(timeout = 100)
	public void testEnumConditionValues() throws ClassNotFoundException {

		try {
			Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "KNOCKEDOUT");
		} catch (IllegalArgumentException e) {
			fail("Status enum can be KNOCKEDOUT");
		}
	}

	@Test(timeout = 100)
	public void testCoverInstanceVariableCurrentHPPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(coverPath), "currentHP", true);

	}

	@Test(timeout = 100)
	public void testCoverInstanceVariableCurrentHPPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(coverPath), "currentHP");

	}

	@Test(timeout = 100)
	public void testCoverInstanceVariableCurrentHPType() throws Exception {
		testInstanceVariableOfType(Class.forName(coverPath), "currentHP", int.class);

	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionMaxHPPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(championPath), "maxHP", true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionMaxHPPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(championPath), "maxHP");
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionMaxHPType() throws Exception {
		testInstanceVariableOfType(Class.forName(championPath), "maxHP", int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionCurrentActionPointsPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(championPath), "currentActionPoints", true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionCurrentActionPointsPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(championPath), "currentActionPoints");
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionCurrentActionPointsType() throws Exception {
		testInstanceVariableOfType(Class.forName(championPath), "currentActionPoints", int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAbilitiesPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(championPath), "abilities", true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAbilitiesPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(championPath), "abilities");
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAbilitiesType() throws Exception {
		testInstanceVariableOfType(Class.forName(championPath), "abilities", ArrayList.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionLocationPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(championPath), "location", true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionLocationPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(championPath), "location");
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionLocationType() throws Exception {
		testInstanceVariableOfType(Class.forName(championPath), "location", Point.class);
	}

	@Test(timeout = 100)
	public void testCoverCurrentHPSetterLogicZero() throws Exception {
		Constructor<?> constructor = Class.forName(coverPath).getConstructor(int.class, int.class);
		int randomX = (int) (Math.random() * 10) + 1;
		int randomY = (int) (Math.random() * 10) + 1;
		Object b = constructor.newInstance(randomX, randomY);
		testSetterLogicCover(b, "currentHP", -1, 0, int.class);
	}

	@Test(timeout = 100)
	public void testConstructorChampion() throws ClassNotFoundException {

		Class[] inputs = { String.class, int.class, int.class, int.class, int.class, int.class, int.class };
		testConstructorExists(Class.forName(championPath), inputs);
	}

	@Test(timeout = 100)
	public void testConstructorChampionInitialization() throws Exception {
		Constructor<?> constructor = Class.forName(championPath).getConstructor(String.class, int.class, int.class,
				int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		Object b = constructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions, randomSpeed,
				randomAttackRange, randomAttackDamage);
		String[] varNames = { "name", "maxHP", "currentHP", "mana", "maxActionPointsPerTurn", "currentActionPoints",
				"attackRange", "attackDamage", "speed", "abilities", "appliedEffects", "condition", "location" };
		Object[] varValues = { "Name_" + randomName, randomMaxHP, randomMaxHP, randomMana, randomActions, randomActions,
				randomAttackRange, randomAttackDamage, randomSpeed, new ArrayList<Object>(), new ArrayList<Object>(),
				Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "ACTIVE"), null };
		testConstructorInitialization(b, varNames, varValues);
	}

	public void testConstructorHero() throws ClassNotFoundException {
		Class[] inputs = { String.class, int.class, int.class, int.class, int.class, int.class, int.class };
		testConstructorExists(Class.forName(heroPath), inputs);
	}

	@Test(timeout = 100)
	public void testConstructorHeroInitialization() throws Exception {
		Constructor<?> constructor = Class.forName(heroPath).getConstructor(String.class, int.class, int.class,
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
	public void testClassIsSubclassAntiHero() throws Exception {
		testClassIsSubclass(Class.forName(antiHeroPath), Class.forName(championPath));
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroName() throws Exception {
		testInstanceVariableIsPresent(Class.forName(antiHeroPath), "name", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroNameGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(antiHeroPath), "getName", String.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroNameSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(antiHeroPath), "setName", String.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroMaxHP() throws Exception {
		testInstanceVariableIsPresent(Class.forName(antiHeroPath), "maxHP", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroMaxHPGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(antiHeroPath), "getMaxHP", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroMaxHPSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(antiHeroPath), "setMaxHP", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroCurrentHP() throws Exception {
		testInstanceVariableIsPresent(Class.forName(antiHeroPath), "currentHP", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroCurrentHPGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(antiHeroPath), "getCurrentHP", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroCurrentHPSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(antiHeroPath), "setCurrentHP", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroMana() throws Exception {
		testInstanceVariableIsPresent(Class.forName(antiHeroPath), "mana", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroManaGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(antiHeroPath), "getMana", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroManaSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(antiHeroPath), "setMana", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroMaxActionPointsPerTurn() throws Exception {
		testInstanceVariableIsPresent(Class.forName(antiHeroPath), "maxActionPointsPerTurn", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroMaxActionPointsPerTurnGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(antiHeroPath), "getMaxActionPointsPerTurn", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroMaxActionPointsPerTurnSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(antiHeroPath), "setMaxActionPointsPerTurn", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroCurrentActionPoints() throws Exception {
		testInstanceVariableIsPresent(Class.forName(antiHeroPath), "currentActionPoints", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroCurrentActionPointsGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(antiHeroPath), "getCurrentActionPoints", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroCurrentActionPointsSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(antiHeroPath), "setCurrentActionPoints", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroAttackRange() throws Exception {
		testInstanceVariableIsPresent(Class.forName(antiHeroPath), "attackRange", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroAttackRangeGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(antiHeroPath), "getAttackRange", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroAttackRangeSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(antiHeroPath), "setAttackRange", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroAttackDamage() throws Exception {
		testInstanceVariableIsPresent(Class.forName(antiHeroPath), "attackDamage", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroAttackDamageGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(antiHeroPath), "getAttackDamage", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroAttackDamageSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(antiHeroPath), "setAttackDamage", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroSpeed() throws Exception {
		testInstanceVariableIsPresent(Class.forName(antiHeroPath), "speed", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroSpeedGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(antiHeroPath), "getSpeed", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroSpeedSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(antiHeroPath), "setSpeed", int.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroAbilities() throws Exception {
		testInstanceVariableIsPresent(Class.forName(antiHeroPath), "abilities", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroAbilitiesGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(antiHeroPath), "getAbilities", ArrayList.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroAbilitiesSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(antiHeroPath), "setAbilities", ArrayList.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroAppliedEffects() throws Exception {
		testInstanceVariableIsPresent(Class.forName(antiHeroPath), "appliedEffects", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroAppliedEffectsGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(antiHeroPath), "getAppliedEffects", ArrayList.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroAppliedEffectsSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(antiHeroPath), "setAppliedEffects", ArrayList.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroCondition() throws Exception {
		testInstanceVariableIsPresent(Class.forName(antiHeroPath), "condition", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroConditionGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(antiHeroPath), "getCondition", Condition.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroConditionSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(antiHeroPath), "setCondition", Condition.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroLocation() throws Exception {
		testInstanceVariableIsPresent(Class.forName(antiHeroPath), "location", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroLocationGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(antiHeroPath), "getLocation", Point.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAntiHeroLocationSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(antiHeroPath), "setLocation", Point.class, false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionManaSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(championPath), "setMana", int.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionManaSetterLogic() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 10) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomMana2 = (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		testSetterLogic(c, "mana", randomMana2, randomMana2, int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionLocationSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(championPath), "setLocation", Point.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionLocationSetterLogic() throws Exception {
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
		int randomX = (int) (Math.random() * 10);
		int randomY = (int) (Math.random() * 10);
		Point p = new Point(randomX, randomY);
		testSetterLogic(c, "location", p, p, Point.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAppliedEffectsGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(championPath), "getAppliedEffects", ArrayList.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionAppliedEffectsGetterLogic() throws Exception {
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
		testGetterLogic(c, "appliedEffects", value);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionCurrentActionPointsSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(championPath), "setCurrentActionPoints", int.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionCurrentActionPointsSetterLogicMax() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 1000) + 1;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomActions2 = randomActions + (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		testSetterLogic(c, "currentActionPoints", randomActions2, randomActions, int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionCurrentActionPointsSetterLogicZero() throws Exception {
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
		testSetterLogic(c, "currentActionPoints", -1, 0, int.class);

	}

	@Test(timeout = 100)
	public void testInstanceVariableChampionCurrentActionPointsSetterLogic() throws Exception {
		Constructor<?> championConstructor = Class.forName(championPath).getConstructor(String.class, int.class,
				int.class, int.class, int.class, int.class, int.class);
		int randomMaxHP = (int) (Math.random() * 10) + 1;
		int randomMana = (int) (Math.random() * 10) + 1;
		int randomActions = (int) (Math.random() * 50) + 11;
		int randomSpeed = (int) (Math.random() * 10) + 1;
		int randomAttackRange = (int) (Math.random() * 10) + 1;
		int randomAttackDamage = (int) (Math.random() * 10) + 1;
		int randomName = (int) (Math.random() * 10) + 1;
		int randomActions2 = (int) (Math.random() * 10) + 1;
		Object c = championConstructor.newInstance("Name_" + randomName, randomMaxHP, randomMana, randomActions,
				randomSpeed, randomAttackRange, randomAttackDamage);
		testSetterLogic(c, "currentActionPoints", randomActions2, randomActions2, int.class);

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

	@Test(timeout = 100)
	public void testInstanceVariableFirstPlayerInGame() throws Exception {
		testInstanceVariableIsPresent(Class.forName(gamePath), "firstPlayer", true);
		testInstanceVariableIsPrivate(Class.forName(gamePath), "firstPlayer");
		testInstanceVariableOfType(Class.forName(gamePath), "firstPlayer", Class.forName(playerPath));
	}

	@Test(timeout = 100)
	public void testGameFirstPlayerSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(gamePath), "setFirstPlayer", Class.forName(playerPath), false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableSecondLeaderAbilityUsedInGame() throws Exception {
		testInstanceVariableIsPresent(Class.forName(gamePath), "secondLeaderAbilityUsed", true);
		testInstanceVariableIsPrivate(Class.forName(gamePath), "secondLeaderAbilityUsed");
		testInstanceVariableOfType(Class.forName(gamePath), "secondLeaderAbilityUsed", boolean.class);
	}

	@Test(timeout = 800)
	public void testGameBoardWidthStatic() throws NoSuchFieldException, SecurityException, ClassNotFoundException {
		Field f = Class.forName(gamePath).getDeclaredField("BOARDWIDTH");
		int modifiers = f.getModifiers();
		assertTrue(f.getName() + " variable in calss Game should be static", (Modifier.isStatic(modifiers)));
	}

	@Test(timeout = 100)
	public void testInstanceVariableBoardInGame() throws Exception {
		testInstanceVariableIsPresent(Class.forName(gamePath), "board", true);
		testInstanceVariableIsPrivate(Class.forName(gamePath), "board");
		testInstanceVariableOfType(Class.forName(gamePath), "board", Object[][].class);
	}

	@Test(timeout = 800)
	public void testGameBoardWidthFinal() throws NoSuchFieldException, SecurityException, ClassNotFoundException {
		Field f = Class.forName(gamePath).getDeclaredField("BOARDWIDTH");
		int modifiers = f.getModifiers();
		assertTrue(f.getName() + " variable in calss Game should be private", (Modifier.isPrivate(modifiers)));
		assertTrue(f.getName() + " variable in calss Game should be final", (Modifier.isFinal(modifiers)));
	}

	@Test(timeout = 100)
	public void testInstanceVariableAvailableAbilitiesInGame() throws Exception {
		testInstanceVariableIsPresent(Class.forName(gamePath), "availableAbilities", true);
		testStaticVariableIsPrivate(Class.forName(gamePath), "availableAbilities");
		testInstanceVariableOfType(Class.forName(gamePath), "availableAbilities", ArrayList.class);

	}

	@Test(timeout = 100)
	public void testInstanceVariableGameAvailableChampionsGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(gamePath), "getAvailableChampions", ArrayList.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableGameSecondLeaderAbilityUsedGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(gamePath), "isSecondLeaderAbilityUsed", boolean.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableGameFirstLeaderAbilityUsedGetterLogic() throws Exception {

		Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
		Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
		Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
		Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");

		Constructor<?> constructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
				Class.forName(playerPath));
		Object myObj = constructor.newInstance(firstPlayer, secondPlayer);

		testGetterLogic(myObj, "firstLeaderAbilityUsed", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableGameAvailableChampionsGetterLogic() throws Exception {

		Constructor<?> constructorFirstPlayer = Class.forName(playerPath).getConstructor(String.class);
		Constructor<?> constructorSecondPlayer = Class.forName(playerPath).getConstructor(String.class);
		Object firstPlayer = constructorFirstPlayer.newInstance("RDJ");
		Object secondPlayer = constructorSecondPlayer.newInstance("Chris Evans");

		Constructor<?> constructor = Class.forName(gamePath).getConstructor(Class.forName(playerPath),
				Class.forName(playerPath));
		Object myObj = constructor.newInstance(firstPlayer, secondPlayer);

		testGetterLogic(myObj, "availableChampions", new ArrayList<>());
	}

	@Test(timeout = 100)
	public void testGameSecondPlayerSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(gamePath), "setSecondPlayer", Class.forName(playerPath), false);
	}

	@Test(timeout = 100)
	public void testGameFirstLeaderAbilityUsedSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(gamePath), "setFirstLeaderAbilityUsed", boolean.class, false);
	}

	@Test(timeout = 100)
	public void testConstructorGameConstructor() throws ClassNotFoundException {

		Class[] inputs = { Class.forName(playerPath), Class.forName(playerPath) };
		testConstructorExists(Class.forName(gamePath), inputs);
	}

	@Test(timeout = 100)
	public void testChampionsSameName()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateChampionsArrayListsFromCSV();
		ArrayList<Object> champions = arrayList.get(0);
		ArrayList<Object> actualChampions = arrayList.get(1);

		if (champions.size() != actualChampions.size()) {
			assertEquals("Size of champions ArrayList is incorrect ", champions.size(), actualChampions.size());

		}
		boolean sameName = true;

		Field f1 = Class.forName(champPath).getDeclaredField("name");
		f1.setAccessible(true);

		if (champions != null && actualChampions != null) {
			for (int i = 0; i < champions.size(); i++) {
				Object d1f = (Object) f1.get(champions.get(i));
				Object d2f = (Object) f1.get(actualChampions.get(i));
				if (!d1f.equals(d2f)) {
					sameName = false;
				}
			}
		}

		assertTrue("The champions name is loaded incorrectly", sameName);

	}

	@Test(timeout = 100)
	public void testChampionsSameMaxActions()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateChampionsArrayListsFromCSV();
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
	public void testChampionsSameNameDynamic()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateChampionsArrayList();
		ArrayList<Object> champions = arrayList.get(0);
		ArrayList<Object> actualChampions = arrayList.get(1);

		if (champions.size() != actualChampions.size()) {
			assertEquals("Size of champions ArrayList is incorrect ", champions.size(), actualChampions.size());

		}
		boolean sameName = true;

		Field f1 = Class.forName(champPath).getDeclaredField("name");
		f1.setAccessible(true);

		if (champions != null && actualChampions != null) {
			for (int i = 0; i < champions.size(); i++) {
				Object d1f = (Object) f1.get(champions.get(i));
				Object d2f = (Object) f1.get(actualChampions.get(i));
				if (!d1f.equals(d2f)) {
					sameName = false;
				}
			}
		}

		assertTrue("The champions name is loaded incorrectly", sameName);

	}

	@Test(timeout = 100)
	public void testChampionsAttackDamageDynamic()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateChampionsArrayList();
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
	public void testAbilitiesSameCost()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateAbilitiesArrayListsFromCSV();
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
	public void testAbilitiesSameHealingOrDamageAmount()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateAbilitiesArrayListsFromCSV();
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
	public void testAbilitiesSameCastRangeDynamic()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException {
		ArrayList<ArrayList<Object>> arrayList = generateAbilitiesArrayLists();
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
	public void testSecondPlayerChampionsLocationAfterPlaceChampions()
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

		for (int i = 0; i < secPlayerChamp.size(); i++) {
			Object champ = secPlayerChamp.get(i);
			Method methodGetLocation = champ.getClass().getMethod("getLocation");
			Point point = (Point) methodGetLocation.invoke(champ);

			boolean condition = point != null;
			assertTrue("Location of second player's champions should be updated", condition);
			condition = point.equals(new Point(boardHeight - 1, i + 1));
			assertTrue("Location of second player's champions should be updated correctly", condition);
		}

	}

	@Test(timeout = 100)
	public void testConstructorPlayerConstructor() throws ClassNotFoundException {

		Class[] inputs = { String.class };
		testConstructorExists(Class.forName(playerPath), inputs);
	}

	@Test(timeout = 100)
	public void testInstanceVariablePlayerteam() throws Exception {
		testInstanceVariableIsPresent(Class.forName(playerPath), "team", true);
		testInstanceVariableIsPrivate(Class.forName(playerPath), "team");
		testInstanceVariableOfType(Class.forName(playerPath), "team", ArrayList.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariablePlayerNameGetter() throws ClassNotFoundException {
		testGetterMethodExistsInClass(Class.forName(playerPath), "getName", String.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariablePlayerNameSetter() throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(playerPath), "setName", String.class, false);
	}

	@Test(timeout = 100)
	public void testEmptyConstructorLeaderAbilityAlreadyUsedException() throws Exception {

		Class[] inputs = {};
		testConstructorExists(Class.forName(leaderAbilityAlreadyUsedExceptionPath), inputs);
	}

	@Test(timeout = 100)
	public void testConstructorUnallowedMovementException() throws Exception {

		Class[] inputs = { String.class };
		testConstructorExists(Class.forName(unallowedMovementExceptionPath), inputs);
	}

	public void testConstructorUnallowedMovementExceptionInitialization() throws Exception {
		Constructor<?> constructor = Class.forName(unallowedMovementExceptionPath).getConstructor(int.class);
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

	public void testConstructorLeaderAbilityAlreadyUsedExceptionInitialization() throws Exception {
		Constructor<?> constructor = Class.forName(leaderAbilityAlreadyUsedExceptionPath).getConstructor(int.class);
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

	@Test(timeout = 1000)
	public void testClassIsSubclassLeaderAbilityAlreadyUsedException() throws Exception {
		testClassIsSubclass(Class.forName(leaderAbilityAlreadyUsedExceptionPath), Class.forName(gameExceptionPath));
	}

	@Test(timeout = 100)
	public void testInstanceVariablePlayerNameGetterLogic() throws Exception {
		Constructor<?> constructor = Class.forName(playerPath).getConstructor(String.class);
		int random = (int) (Math.random() * 50);
		String name = "name" + random;
		Object myObj = constructor.newInstance(name);
		testGetterLogic(myObj, "name", name);
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

	private ArrayList<ArrayList<Object>> generateAbilitiesArrayLists()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, IOException, NoSuchFieldException {

		PrintWriter csvWriter = new PrintWriter("test_abilities.csv");
		int random = (int) (Math.random() * 50);
		int cost = random;
		random = (int) (Math.random() * 50);
		int castRange = random;
		random = (int) (Math.random() * 50);
		int baseCoolDown = random;
		random = (int) (Math.random() * 4);
		int area = random;

		random = (int) (Math.random() * 50);
		int required = random;
		random = (int) (Math.random() * 50);
		int damageAmount = random;
		random = (int) (Math.random() * 50);

		Class<?> areaOfEffect = Class.forName(areaOfEffectPath);

		csvWriter.println("DMG,Shield throw," + cost + "," + castRange + "," + baseCoolDown + ","
				+ areaOfEffect.getEnumConstants()[area] + "," + required + "," + damageAmount + ",");

		random = (int) (Math.random() * 50);
		int cost1 = random;
		random = (int) (Math.random() * 50);
		int castRange1 = random;
		random = (int) (Math.random() * 50);
		int baseCoolDown1 = random;
		random = (int) (Math.random() * 4);
		int area1 = random;

		random = (int) (Math.random() * 50);
		int required1 = random;
		random = (int) (Math.random() * 50);
		int healAmount = random;
		random = (int) (Math.random() * 50);

		csvWriter.println("HEL,I can do this all day," + cost1 + "," + castRange1 + "," + baseCoolDown1 + ","
				+ areaOfEffect.getEnumConstants()[area1] + "," + required1 + "," + healAmount + ",");

		random = (int) (Math.random() * 50);
		int cost2 = random;
		random = (int) (Math.random() * 50);
		int castRange2 = random;
		random = (int) (Math.random() * 50);
		int baseCoolDown2 = random;
		random = (int) (Math.random() * 4);
		int area2 = random;
		random = (int) (Math.random() * 50);
		int required2 = random;
		random = (int) (Math.random() * 50);
		int effectDuration = random;
		random = (int) (Math.random() * 50);

		csvWriter.println("CC,Shield Up," + cost2 + "," + castRange2 + "," + baseCoolDown2 + ","
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

		item = dmgAbilityConstructor.newInstance("Shield throw", cost, baseCoolDown, castRange,
				areaOfEffect.getEnumConstants()[area], required, damageAmount);
		abilities.add(item);
		item = healingAbilityConstructor.newInstance("I can do this all day", cost1, baseCoolDown1, castRange1,
				areaOfEffect.getEnumConstants()[area1], required1, healAmount);
		abilities.add(item);
		Object shield00 = Class.forName(shieldPath).getConstructor(int.class).newInstance(effectDuration);
		item = ccAbilityConstructor.newInstance("Shield Up", cost2, baseCoolDown2, castRange2,
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

		Field f4 = Class.forName(abilitiesPath).getDeclaredField("baseCoolDown");
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

	private void testSetterLogic(Object createdObject, String name, Object valueIn, Object valueOut, Class type)
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
		m.invoke(createdObject, valueIn);
		assertEquals(
				"The method \"" + methodName + "\" in class " + createdObject.getClass().getSimpleName()
						+ " should set the correct value of variable \"" + name + "\".",
				valueOut, f.get(createdObject));
	}

}
