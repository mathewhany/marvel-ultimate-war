package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Point;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.junit.Test;

public class Quiz2V2 {

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

	// test enemy champions (in range) were damaged by SpeedUp attack of inactive
	// champion
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testSpeedUpAttackValidTarget_InRange() throws Exception {

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

		Method setSpeed = champ4.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);
		setSpeed.invoke(champ1, 8); // sped up inactive champ

		Method setDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		int randomDmg = (int) (Math.random() * 40) + 5;
		setDamage.invoke(champ1, randomDmg);

		setLocationForObject(champ1, 1, 1);
		setLocationForObject(champ4, 2, 1);
		setLocationForObject(champ5, 1, 2);
		setLocationForObject(champ6, 0, 1);

		try {
			Field attackRange = champ1.getClass().getSuperclass().getDeclaredField("attackRange");
			attackRange.setAccessible(true);
			attackRange.set(champ1, 3);

		} catch (NoSuchFieldException e) {
			fail("Champion class should have attackRange attribute");
		}

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
							Method getAppliedEffects = champ1.getClass().getMethod("getAppliedEffects");

							ArrayList<Object> effectsOfSpedUpChamp = (ArrayList<Object>) getAppliedEffects
									.invoke(champ1);

							Object speedUpEffect = createSpeedUpEffect(2);
							Object stunEffect = createStunEffect(3);

							effectsOfSpedUpChamp.add(stunEffect);
							effectsOfSpedUpChamp.add(speedUpEffect);
							Field condition = champ1.getClass().getSuperclass().getDeclaredField("condition");
							condition.setAccessible(true);
							Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE");
							condition.set(champ1, expectedValue);

							try {
								Field appliedEffects = champ1.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects.setAccessible(true);
								appliedEffects.set(champ1, effectsOfSpedUpChamp);

							} catch (NoSuchFieldException e) {
								fail("Champion class should have appliedEffects attribute");
							}
						} catch (NoSuchMethodException e) {
							fail("Champion class should have getAppliedEffects method");

						}

						Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
						m2.invoke(turnOrder, champ1); // has the speedUp and stun effects
						m2.invoke(turnOrder, champ2);
						m2.invoke(turnOrder, champ3);
						m2.invoke(turnOrder, champ4);
						m2.invoke(turnOrder, champ5);
						m2.invoke(turnOrder, champ6);

						setObjectHP(champ4, 100);
						setObjectHP(champ5, 100);
						setObjectHP(champ6, 100);

						try {
							Method m5 = champ4.getClass().getMethod("getCurrentHP");
							int oldHP = (Integer) m5.invoke(champ4);

							try {

								Method m4 = champ1.getClass().getMethod("getAttackDamage");
								int berserkDamage = (Integer) m4.invoke(champ1);

								int expectedHp = oldHP - berserkDamage;
								if (expectedHp < 0)
									expectedHp = 0;

								Method endTurn = createdGame.getClass().getMethod("endTurn");
								endTurn.invoke(createdGame);

								int newHP4 = (Integer) m5.invoke(champ4);
								int newHP5 = (Integer) m5.invoke(champ5);
								int newHP6 = (Integer) m5.invoke(champ6);

								assertTrue(
										"An inactive Champion with a SpeedUp effect should deal his attack damage to  all enemy champions. "
												+ "Expected currentHP " + expectedHp + " but was " + newHP4,
										newHP4 == expectedHp);
								assertTrue(
										"An inactive Champion with a SpeedUp effect should deal his attack damage to all enemy champions. "
												+ "Expected currentHP " + expectedHp + " but was " + newHP5,
										newHP5 == expectedHp);
								assertTrue(
										"An inactive Champion with a SpeedUp effect should deal his attack damage to all enemy champions. "
												+ "Expected currentHP " + expectedHp + " but was " + newHP6,
										newHP6 == expectedHp);
							} catch (NoSuchMethodException e) {
								fail("Game class should have endTurn method");
							}

						} catch (NoSuchMethodException e) {
							fail("Champion class should have getCurrentHP method");
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

	@SuppressWarnings("unchecked")
	@Test(timeout = 3000)
	public void testSpeedUpExpiredDoesntAffectValidTarget_InRange() throws Exception {

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

		Method setSpeed = champ4.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);
		setSpeed.invoke(champ1, 8); // sped up inactive champ

		Method setDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		int randomDmg = (int) (Math.random() * 40) + 5;
		setDamage.invoke(champ1, randomDmg);

		setLocationForObject(champ1, 1, 1);
		setLocationForObject(champ4, 2, 1);
		setLocationForObject(champ5, 1, 2);
		setLocationForObject(champ6, 0, 1);

		try {
			Field attackRange = champ1.getClass().getSuperclass().getDeclaredField("attackRange");
			attackRange.setAccessible(true);
			attackRange.set(champ1, 3);

		} catch (NoSuchFieldException e) {
			fail("Champion class should have attackRange attribute");
		}

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
							Method getAppliedEffects = champ1.getClass().getMethod("getAppliedEffects");

							ArrayList<Object> effectsOfSpedUpChamp = (ArrayList<Object>) getAppliedEffects
									.invoke(champ1);

							Object speedUpEffect = createSpeedUpEffect(1);
							Object stunEffect = createStunEffect(3);

							effectsOfSpedUpChamp.add(stunEffect);
							effectsOfSpedUpChamp.add(speedUpEffect);
							Field condition = champ1.getClass().getSuperclass().getDeclaredField("condition");
							condition.setAccessible(true);
							Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE");
							condition.set(champ1, expectedValue);

							try {
								Field appliedEffects = champ1.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects.setAccessible(true);
								appliedEffects.set(champ1, effectsOfSpedUpChamp);

							} catch (NoSuchFieldException e) {
								fail("Champion class should have appliedEffects attribute");
							}
						} catch (NoSuchMethodException e) {
							fail("Champion class should have getAppliedEffects method");

						}

						Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
						m2.invoke(turnOrder, champ1); // has the speedUp and stun effects
						m2.invoke(turnOrder, champ2);
						m2.invoke(turnOrder, champ3);
						m2.invoke(turnOrder, champ4);
						m2.invoke(turnOrder, champ5);
						m2.invoke(turnOrder, champ6);

						setObjectHP(champ4, 100);
						setObjectHP(champ5, 100);
						setObjectHP(champ6, 100);

						try {
							Method m5 = champ4.getClass().getMethod("getCurrentHP");
							int oldHP = (Integer) m5.invoke(champ4);

							try {

								Method m4 = champ1.getClass().getMethod("getAttackDamage");
								Method endTurn = createdGame.getClass().getMethod("endTurn");
								endTurn.invoke(createdGame);

								int newHP4 = (Integer) m5.invoke(champ4);
								int newHP5 = (Integer) m5.invoke(champ5);
								int newHP6 = (Integer) m5.invoke(champ6);

								assertTrue(
										"If an Inactive champion had aSpeedUp effect that expired, he should not deal his attack damage to enemy champions therefore, their currentHP should not be changed. "
												+ "Expected currentHP " + oldHP + " but was " + newHP4,
										newHP4 == oldHP);
								assertTrue(
										"If an Inactive champion had aSpeedUp effect that expired, he should not deal his attack damage to enemy champions therefore, their currentHP should not be changed. "
												+ "Expected currentHP " + oldHP + " but was " + newHP5,
										newHP5 == oldHP);
								assertTrue(
										"If an Inactive champion had aSpeedUp effect that expired, he should not deal his attack damage to enemy champions therefore, their currentHP should not be changed."
												+ "Expected currentHP " + oldHP + " but was " + newHP6,
										newHP6 == oldHP);
							} catch (NoSuchMethodException e) {
								fail("Game class should have endTurn method");
							}

						} catch (NoSuchMethodException e) {
							fail("Champion class should have getCurrentHP method");
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
	// test enemy champions (out of range) were damaged by SpeedUp attack of
	// inactive champion
	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testSpeedUpAttackValidTarget_OutOfRange() throws Exception {

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

		Method setSpeed = champ4.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);
		setSpeed.invoke(champ1, 8); // sped up inactive champ

		Method setDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		int randomDmg = (int) (Math.random() * 40) + 5;
		setDamage.invoke(champ1, randomDmg);

		setLocationForObject(champ1, 1, 1);
		setLocationForObject(champ4, 4, 1);
		setLocationForObject(champ5, 4, 2);
		setLocationForObject(champ6, 4, 0);

		try {
			Field attackRange = champ1.getClass().getSuperclass().getDeclaredField("attackRange");
			attackRange.setAccessible(true);
			attackRange.set(champ1, 1);

		} catch (NoSuchFieldException e) {
			fail("Champion class should have attackRange attribute");
		}

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
							Method getAppliedEffects = champ1.getClass().getMethod("getAppliedEffects");

							ArrayList<Object> effectsOfSpedUpChamp = (ArrayList<Object>) getAppliedEffects
									.invoke(champ1);

							Object speedUpEffect = createSpeedUpEffect(2);
							Object stunEffect = createStunEffect(3);

							effectsOfSpedUpChamp.add(stunEffect);
							effectsOfSpedUpChamp.add(speedUpEffect);
							Field condition = champ1.getClass().getSuperclass().getDeclaredField("condition");
							condition.setAccessible(true);
							Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE");
							condition.set(champ1, expectedValue);

							try {
								Field appliedEffects = champ1.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects.setAccessible(true);
								appliedEffects.set(champ1, effectsOfSpedUpChamp);

							} catch (NoSuchFieldException e) {
								fail("Champion class should have appliedEffects attribute");
							}
						} catch (NoSuchMethodException e) {
							fail("Champion class should have getAppliedEffects method");

						}

						Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
						m2.invoke(turnOrder, champ1); // has the speedUp and stun effects
						m2.invoke(turnOrder, champ2);
						m2.invoke(turnOrder, champ3);
						m2.invoke(turnOrder, champ4);
						m2.invoke(turnOrder, champ5);
						m2.invoke(turnOrder, champ6);

						setObjectHP(champ4, 100);
						setObjectHP(champ5, 100);
						setObjectHP(champ6, 100);

						try {
							Method m5 = champ4.getClass().getMethod("getCurrentHP");
							int oldHP = (Integer) m5.invoke(champ4);

							try {

								Method m4 = champ1.getClass().getMethod("getAttackDamage");
								int berserkDamage = (Integer) m4.invoke(champ1);

								int expectedHp = oldHP - berserkDamage;
								if (expectedHp < 0)
									expectedHp = 0;

								Method endTurn = createdGame.getClass().getMethod("endTurn");
								endTurn.invoke(createdGame);

								int newHP4 = (Integer) m5.invoke(champ4);
								int newHP5 = (Integer) m5.invoke(champ5);
								int newHP6 = (Integer) m5.invoke(champ6);

								assertTrue(
										"An inactive Champion with a SpeedUp effect should deal his attack damage to  all enemy champions even if they are out of his attack range "
												+ "Expected currentHP " + expectedHp + " but was " + newHP4,
										newHP4 == expectedHp);
								assertTrue(
										"An inactive Champion with a SpeedUp effect should deal his attack damage to  all enemy champions even if they are out of his attack range "
												+ "Expected currentHP " + expectedHp + " but was " + newHP5,
										newHP5 == expectedHp);
								assertTrue(
										"An inactive Champion with a SpeedUp effect should deal his attack damage to  all enemy champions even if they are out of his attack range "
												+ "Expected currentHP " + expectedHp + " but was " + newHP6,
										newHP6 == expectedHp);
							} catch (NoSuchMethodException e) {
								fail("Game class should have endTurn method");
							}

						} catch (NoSuchMethodException e) {
							fail("Champion class should have getCurrentHP method");
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
	public void testSpeedUpAttackValidTargetDoesnotConsumeResources() throws Exception {

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

		Method setSpeed = champ4.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);
		setSpeed.invoke(champ1, 8); // sped up inactive champ

		Method setDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		int randomDmg = (int) (Math.random() * 40) + 5;
		setDamage.invoke(champ1, randomDmg);

		setLocationForObject(champ1, 1, 1);
		setLocationForObject(champ4, 2, 1);
		setLocationForObject(champ5, 1, 2);
		setLocationForObject(champ6, 0, 1);

		try {
			Field attackRange = champ1.getClass().getSuperclass().getDeclaredField("attackRange");
			attackRange.setAccessible(true);
			attackRange.set(champ1, 3);

		} catch (NoSuchFieldException e) {
			fail("Champion class should have attackRange attribute");
		}

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
							Method getAppliedEffects = champ1.getClass().getMethod("getAppliedEffects");

							ArrayList<Object> effectsOfSpedUpChamp = (ArrayList<Object>) getAppliedEffects
									.invoke(champ1);

							Object speedUpEffect = createSpeedUpEffect(2);
							Object stunEffect = createStunEffect(3);

							effectsOfSpedUpChamp.add(stunEffect);
							effectsOfSpedUpChamp.add(speedUpEffect);
							Field condition = champ1.getClass().getSuperclass().getDeclaredField("condition");
							condition.setAccessible(true);
							Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE");
							condition.set(champ1, expectedValue);

							try {
								Field appliedEffects = champ1.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects.setAccessible(true);
								appliedEffects.set(champ1, effectsOfSpedUpChamp);

							} catch (NoSuchFieldException e) {
								fail("Champion class should have appliedEffects attribute");
							}
						} catch (NoSuchMethodException e) {
							fail("Champion class should have getAppliedEffects method");

						}

						Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
						m2.invoke(turnOrder, champ1); // has the speedUp and stun effects
						m2.invoke(turnOrder, champ2);
						m2.invoke(turnOrder, champ3);
						m2.invoke(turnOrder, champ4);
						m2.invoke(turnOrder, champ5);
						m2.invoke(turnOrder, champ6);

						setObjectHP(champ4, 100);
						setObjectHP(champ5, 100);
						setObjectHP(champ6, 100);

						try {
							Method m5 = champ4.getClass().getMethod("getCurrentHP");
							try {

								Method m4 = champ1.getClass().getMethod("getAttackDamage");
								Method actionPoints = champ1.getClass().getSuperclass()
										.getDeclaredMethod("getCurrentActionPoints");
								actionPoints.setAccessible(true);
								int actionPointsBefore = (int) actionPoints.invoke(champ1);

								Method mana = champ1.getClass().getSuperclass().getDeclaredMethod("getMana");
								
								int manaBefore = (int) mana.invoke(champ1);
								Method endTurn = createdGame.getClass().getMethod("endTurn");
								endTurn.invoke(createdGame);
								int actionPointsAfter = (int) actionPoints.invoke(champ1);
								int manaAfter =(int) mana.invoke(champ1);

								assertTrue(
										"When an inactive Champion with a SpeedUp effect deals his attack damage to all enemy champions. he does not lose any action points "
												+ "Expected currentActionPoints " + actionPointsBefore + " but was "
												+ actionPointsAfter,
										actionPointsBefore == actionPointsAfter);

								assertTrue(
										"When an inactive Champion with a SpeedUp effect deals his attack damage to all enemy champions. his mana should increase by 30"
												+ " Expected mana " + manaBefore + " but was " + manaAfter,
										 manaAfter==manaBefore+30);
							} catch (NoSuchMethodException e) {
								fail("Game class should have endTurn method");
							}

						} catch (NoSuchMethodException e) {
							fail("Champion class should have getCurrentHP method");
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

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void InactivetestSpeedUpDoesNotAffectFriendlyChampions() throws Exception {

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

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);
		setSpeed.invoke(champ1, 9); // sped up inactive champ

		Method setDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		int randomDmg = (int) (Math.random() * 40) + 5;
		setDamage.invoke(champ1, randomDmg);

		setLocationForObject(champ1, 1, 1); // speed champ and also target !
		setLocationForObject(champ2, 4, 4);
		setLocationForObject(champ3, 1, 2);

		setObjectHP(champ1, 100);
		setObjectHP(champ2, 100);
		setObjectHP(champ3, 100);

		try {
			Field attackRange = champ1.getClass().getSuperclass().getDeclaredField("attackRange");
			attackRange.setAccessible(true);
			attackRange.set(champ1, 2);

		} catch (NoSuchFieldException e) {
			fail("Champion class should have attackRange attribute");
		}

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
							Method getAppliedEffects = champ1.getClass().getMethod("getAppliedEffects");

							ArrayList<Object> effectsOfSpedUpChamp = (ArrayList<Object>) getAppliedEffects
									.invoke(champ1);

							Object speedUpEffect = createSpeedUpEffect(2);
							Object stunEffect = createStunEffect(3);

							effectsOfSpedUpChamp.add(stunEffect);
							effectsOfSpedUpChamp.add(speedUpEffect);
							Field condition = champ1.getClass().getSuperclass().getDeclaredField("condition");
							condition.setAccessible(true);
							Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE");
							condition.set(champ1, expectedValue);

							try {
								Field appliedEffects = champ1.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects.setAccessible(true);
								appliedEffects.set(champ1, effectsOfSpedUpChamp);

							} catch (NoSuchFieldException e) {
								fail("Champion class should have appliedEffects attribute");
							}
						} catch (NoSuchMethodException e) {
							fail("Champion class should have getAppliedEffects method");

						}

						Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
						m2.invoke(turnOrder, champ1); // has the speedUp and stun effects
						m2.invoke(turnOrder, champ2);
						m2.invoke(turnOrder, champ3);
						m2.invoke(turnOrder, champ4);
						m2.invoke(turnOrder, champ5);
						m2.invoke(turnOrder, champ6);

						try {
							Method m5 = champ1.getClass().getMethod("getCurrentHP");
							int oldHP = (Integer) m5.invoke(champ2);

							try {

								Method m4 = champ1.getClass().getMethod("getAttackDamage");
								int berserkDamage = (Integer) m4.invoke(champ1);

								Method endTurn = createdGame.getClass().getMethod("endTurn");
								endTurn.invoke(createdGame);

								int newHP1 = (Integer) m5.invoke(champ1);
								int newHP2 = (Integer) m5.invoke(champ2);
								int newHP3 = (Integer) m5.invoke(champ3);

								assertTrue(
										"An inactive Champion with a SpeedUp effect shouldn't deal his attack damage to friendly champions. "
												+ "Expected currentHP " + oldHP + " but was " + newHP1,
										newHP1 == oldHP);
								assertTrue(
										"An inactive Champion with a SpeedUp effect shouldn'shouldn't deal his attack damage to friendly champions. "
												+ "Expected currentHP " + oldHP + " but was " + newHP2,
										newHP2 == oldHP);
								assertTrue(
										"An inactive Champion with a SpeedUp effect shouldn't deal his attack damage to friendly champions. "
												+ "Expected currentHP " + oldHP + " but was " + newHP3,
										newHP3 == oldHP);
							} catch (NoSuchMethodException e) {
								fail("Game class should have endTurn method");
							}

						} catch (NoSuchMethodException e) {
							fail("Champion class should have getCurrentHP method");
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

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testInactiveChampWithoutSpeedUP() throws Exception {

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

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);
		setSpeed.invoke(champ4, 9); // inactive champ

		Method setDamage = champ4.getClass().getMethod("setAttackDamage", int.class);
		int randomDmg = (int) (Math.random() * 40) + 5;
		setDamage.invoke(champ4, randomDmg);

		setLocationForObject(champ4, 1, 1);
		setLocationForObject(champ1, 2, 1);
		setLocationForObject(champ2, 1, 2);
		setLocationForObject(champ3, 0, 1);

		try {
			Field attackRange = champ4.getClass().getSuperclass().getDeclaredField("attackRange");
			attackRange.setAccessible(true);
			attackRange.set(champ4, 3);

		} catch (NoSuchFieldException e) {
			fail("Champion class should have attackRange attribute");
		}

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
							Method getAppliedEffects = champ4.getClass().getMethod("getAppliedEffects");

							ArrayList<Object> effectsOfStunnedChamp = (ArrayList<Object>) getAppliedEffects
									.invoke(champ4);

							Object stunEffect = createStunEffect(2);
							effectsOfStunnedChamp.add(stunEffect);

							try {
								Field appliedEffects = champ4.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects.setAccessible(true);
								appliedEffects.set(champ4, effectsOfStunnedChamp);
								Field condition = champ1.getClass().getSuperclass().getDeclaredField("condition");
								condition.setAccessible(true);
								Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath),
										"INACTIVE");
								condition.set(champ4, expectedValue);

							} catch (NoSuchFieldException e) {
								fail("Champion class should have appliedEffects attribute");
							}
						} catch (NoSuchMethodException e) {
							fail("Champion class should have getAppliedEffects method");

						}

						Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
						m2.invoke(turnOrder, champ1);
						m2.invoke(turnOrder, champ2);
						m2.invoke(turnOrder, champ3);
						m2.invoke(turnOrder, champ4); // has the stun effect, no speedup
						m2.invoke(turnOrder, champ5);
						m2.invoke(turnOrder, champ6);

						int randomHP = (int) (Math.random() * 100) + 1;
						setObjectHP(champ4, randomHP);
						setObjectHP(champ1, 100);
						setObjectHP(champ2, 100);
						setObjectHP(champ3, 100);

						try {
							Method m5 = champ4.getClass().getMethod("getCurrentHP");
							int oldHP = (Integer) m5.invoke(champ4);

							try {

								Method m4 = champ4.getClass().getMethod("getAttackDamage");
								int expectedHp = oldHP + 10;
								if (expectedHp > returnMaxHp(champ4))
									expectedHp = returnMaxHp(champ4);

								Method endTurn = createdGame.getClass().getMethod("endTurn");
								endTurn.invoke(createdGame);

								int newHP = (Integer) m5.invoke(champ4);

								assertTrue(
										"An inactive champion without a SpeedUp effect should has his currentHP increased by 10. "
												+ "Expected hp " + expectedHp + " but was " + newHP,
										newHP == expectedHp);

							} catch (NoSuchMethodException e) {
								fail("Game class should have endTurn method");
							}

						} catch (NoSuchMethodException e) {
							fail("Champion class should have getCurrentHP method");
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

	// test that any champion killed by the speedUp damage was cleared off the board
	// (in range)
	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testBoardCleanUpAfterSpeedUpAttackInRange() throws Exception {

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

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);
		setSpeed.invoke(champ1, 8); // sped up inactive champ

		Method setDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		int randomDmg = (int) (Math.random() * 40) + 5;
		setDamage.invoke(champ1, randomDmg);

		setLocationForObject(champ1, 1, 1);
		setLocationForObject(champ4, 2, 1);
		setLocationForObject(champ5, 1, 2);
		setLocationForObject(champ6, 0, 1);

		try {
			Field attackRange = champ1.getClass().getSuperclass().getDeclaredField("attackRange");
			attackRange.setAccessible(true);
			attackRange.set(champ1, 3);

		} catch (NoSuchFieldException e) {
			fail("Champion class should have attackRange attribute");
		}

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);
		boardGame[2][1] = champ1;

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
							Method getAppliedEffects = champ1.getClass().getMethod("getAppliedEffects");

							ArrayList<Object> effectsOfSpedUpChamp = (ArrayList<Object>) getAppliedEffects
									.invoke(champ1);

							Object speedUpEffect = createSpeedUpEffect(2);
							Object stunEffect = createStunEffect(3);

							effectsOfSpedUpChamp.add(stunEffect);
							effectsOfSpedUpChamp.add(speedUpEffect);
							Field condition = champ1.getClass().getSuperclass().getDeclaredField("condition");
							condition.setAccessible(true);
							Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE");
							condition.set(champ1, expectedValue);

							try {
								Field appliedEffects = champ1.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects.setAccessible(true);
								appliedEffects.set(champ1, effectsOfSpedUpChamp);

							} catch (NoSuchFieldException e) {
								fail("Champion class should have appliedEffects attribute");
							}
						} catch (NoSuchMethodException e) {
							fail("Champion class should have getAppliedEffects method");

						}

						Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
						m2.invoke(turnOrder, champ1); // has the speedUp and stun effects
						m2.invoke(turnOrder, champ2);
						m2.invoke(turnOrder, champ3);
						m2.invoke(turnOrder, champ4);
						m2.invoke(turnOrder, champ5);
						m2.invoke(turnOrder, champ6);

						// int randomHP = (int) (Math.random() * 100) + 1;
						setObjectHP(champ4, 5);
						setObjectHP(champ5, 5);
						setObjectHP(champ6, 5);

						try {
							Method m5 = champ5.getClass().getMethod("getCurrentHP");
							int oldHP4 = (Integer) m5.invoke(champ4);
							int oldHP5 = (Integer) m5.invoke(champ5);
							int oldHP6 = (Integer) m5.invoke(champ6);

							try {

								Method m4 = champ1.getClass().getMethod("getAttackDamage");
								int berserkDamage = (Integer) m4.invoke(champ1);

								int expectedHp4 = oldHP4 - berserkDamage;
								int expectedHp5 = oldHP5 - berserkDamage;
								int expectedHp6 = oldHP6 - berserkDamage;

								if (expectedHp4 < 0)
									expectedHp4 = 0;
								if (expectedHp5 < 0)
									expectedHp5 = 0;
								if (expectedHp6 < 0)
									expectedHp6 = 0;

								Method endTurn = createdGame.getClass().getMethod("endTurn");
								endTurn.invoke(createdGame);

								Object[][] boardGameUpdated = (Object[][]) getBoardGame.invoke(createdGame);

								assertTrue(
										"if an INACTIVE champion with a SpeedUp effect killed an enemey champion  with his attack damage while being in his attack range, the dead champion should be removed from the board. ",
										boardGameUpdated[2][1] == null);
								assertTrue(
										"if an INACTIVE champion with a SpeedUp effect killed an enemey champion with his attack damage while being in his attack range, the dead champion should be removed from the board. ",
										boardGameUpdated[1][2] == null);
								assertTrue(
										"if an INACTIVE champion with a SpeedUp effect killed an enemey champion with his attack damage while being in his attack range, the dead champion should be removed from the board. ",
										boardGameUpdated[0][1] == null);

							} catch (NoSuchMethodException e) {
								fail("Game class should have endTurn method");
							}

						} catch (NoSuchMethodException e) {
							fail("Champion class should have getCurrentHP method");
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

	// test that any champion killed by the speedUp damage was cleared off the board
	// (out of range)
	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testBoardCleanUpAfterSpeedUpAttackOutOfRange() throws Exception {

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

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);
		setSpeed.invoke(champ6, 8); // sped up inactive champ

		Method setDamage = champ6.getClass().getMethod("setAttackDamage", int.class);
		int randomDmg = (int) (Math.random() * 40) + 5;
		setDamage.invoke(champ6, randomDmg);

		setLocationForObject(champ6, 1, 1);
		setLocationForObject(champ1, 4, 1);
		setLocationForObject(champ2, 4, 2);
		setLocationForObject(champ3, 4, 0);

		Method getBoardGame = createdGame.getClass().getMethod("getBoard");
		Object[][] boardGame = (Object[][]) getBoardGame.invoke(createdGame);
		boardGame[4][2] = champ2;

		try {
			Field attackRange = champ1.getClass().getSuperclass().getDeclaredField("attackRange");
			attackRange.setAccessible(true);
			attackRange.set(champ6, 1);

		} catch (NoSuchFieldException e) {
			fail("Champion class should have attackRange attribute");
		}

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
							Method getAppliedEffects = champ6.getClass().getMethod("getAppliedEffects");

							ArrayList<Object> effectsOfSpedUpChamp = (ArrayList<Object>) getAppliedEffects
									.invoke(champ6);

							Object speedUpEffect = createSpeedUpEffect(2);
							Object stunEffect = createStunEffect(3);

							effectsOfSpedUpChamp.add(stunEffect);
							effectsOfSpedUpChamp.add(speedUpEffect);

							Field condition = champ1.getClass().getSuperclass().getDeclaredField("condition");
							condition.setAccessible(true);
							Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE");
							condition.set(champ6, expectedValue);

							try {
								Field appliedEffects = champ1.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects.setAccessible(true);
								appliedEffects.set(champ6, effectsOfSpedUpChamp);

							} catch (NoSuchFieldException e) {
								fail("Champion class should have appliedEffects attribute");
							}
						} catch (NoSuchMethodException e) {
							fail("Champion class should have getAppliedEffects method");

						}

						Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
						m2.invoke(turnOrder, champ1);
						m2.invoke(turnOrder, champ2);
						m2.invoke(turnOrder, champ3);
						m2.invoke(turnOrder, champ4);
						m2.invoke(turnOrder, champ5);
						m2.invoke(turnOrder, champ6); // has the speedUp and stun effects

						setObjectHP(champ1, 5);
						setObjectHP(champ2, 5);
						setObjectHP(champ3, 5);

						try {
							Method m5 = champ2.getClass().getMethod("getCurrentHP");
							int oldHP1 = (Integer) m5.invoke(champ1);
							int oldHP2 = (Integer) m5.invoke(champ2);
							int oldHP3 = (Integer) m5.invoke(champ3);

							try {

								Method m4 = champ6.getClass().getMethod("getAttackDamage");
								int berserkDamage = (Integer) m4.invoke(champ6);

								int expectedHp1 = oldHP1 - berserkDamage;
								int expectedHp2 = oldHP2 - berserkDamage;
								int expectedHp3 = oldHP3 - berserkDamage;

								if (expectedHp1 < 0)
									expectedHp1 = 0;
								if (expectedHp2 < 0)
									expectedHp2 = 0;
								if (expectedHp3 < 0)
									expectedHp3 = 0;

								Method endTurn = createdGame.getClass().getMethod("endTurn");
								endTurn.invoke(createdGame);

								Object[][] boardGameUpdated = (Object[][]) getBoardGame.invoke(createdGame);

								assertTrue(
										"if an INACTIVE champion with a SpeedUp effect killed an enemey champion  with his attack damage while being in his attack range, the dead champion should be removed from the board. ",
										boardGameUpdated[4][1] == null);
								assertTrue(
										"if an INACTIVE champion with a SpeedUp effect killed an enemey champion with his attack damage while being in his attack range, the dead champion should be removed from the board. ",
										boardGameUpdated[4][2] == null);
								assertTrue(
										"if an INACTIVE champion with a SpeedUp effect killed an enemey champion with his attack damage while being in his attack range, the dead champion should be removed from the board. ",
										boardGameUpdated[4][0] == null);
							} catch (NoSuchMethodException e) {
								fail("Game class should have endTurn method");
							}

						} catch (NoSuchMethodException e) {
							fail("Champion class should have getCurrentHP method");
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

	// test applied SpeedUp attack if enemy has shield
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testSpeedUpAttackOnValidChampWithShield_SameHP() throws Exception {

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

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);
		setSpeed.invoke(champ1, 8); // sped up inactive champ

		Method setDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		int randomDmg = (int) (Math.random() * 40) + 5;
		setDamage.invoke(champ1, randomDmg);

		setLocationForObject(champ1, 1, 1);
		setLocationForObject(champ4, 2, 1);
		setLocationForObject(champ5, 1, 2);
		setLocationForObject(champ6, 0, 1);

		try {
			Field attackRange = champ1.getClass().getSuperclass().getDeclaredField("attackRange");
			attackRange.setAccessible(true);
			attackRange.set(champ1, 3);

		} catch (NoSuchFieldException e) {
			fail("Champion class should have attackRange attribute");
		}

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
							Method getAppliedEffects = champ1.getClass().getMethod("getAppliedEffects");

							ArrayList<Object> effectsOfSpedUpChamp = (ArrayList<Object>) getAppliedEffects
									.invoke(champ1);

							Object speedUpEffect = createSpeedUpEffect(2);
							Object stunEffect = createStunEffect(3);

							effectsOfSpedUpChamp.add(stunEffect);
							effectsOfSpedUpChamp.add(speedUpEffect);
							Field condition = champ1.getClass().getSuperclass().getDeclaredField("condition");
							condition.setAccessible(true);
							Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE");
							condition.set(champ1, expectedValue);

							ArrayList<Object> effectsOfShieldedEnemy = (ArrayList<Object>) getAppliedEffects
									.invoke(champ5);

							Object shieldEffect = createSheildEffect(3);
							effectsOfShieldedEnemy.add(shieldEffect);

							try {
								Field appliedEffects1 = champ1.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects1.setAccessible(true);
								appliedEffects1.set(champ1, effectsOfSpedUpChamp);

								Field appliedEffects2 = champ5.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects2.setAccessible(true);
								appliedEffects2.set(champ5, effectsOfShieldedEnemy);

							} catch (NoSuchFieldException e) {
								fail("Champion class should have appliedEffects attribute");
							}
						} catch (NoSuchMethodException e) {
							fail("Champion class should have getAppliedEffects method");

						}

						Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
						m2.invoke(turnOrder, champ1); // has the speedUp and stun effects
						m2.invoke(turnOrder, champ2);
						m2.invoke(turnOrder, champ3);
						m2.invoke(turnOrder, champ4);
						m2.invoke(turnOrder, champ5); // has a shield
						m2.invoke(turnOrder, champ6);

						setObjectHP(champ4, 100);
						setObjectHP(champ5, 100);
						setObjectHP(champ6, 100);

						try {
							Method m5 = champ5.getClass().getMethod("getCurrentHP");
							int oldHP = (Integer) m5.invoke(champ5);

							try {

								Method m4 = champ1.getClass().getMethod("getAttackDamage");
								int berserkDamage = (Integer) m4.invoke(champ1);

								int expectedHp = oldHP - berserkDamage;
								if (expectedHp < 0)
									expectedHp = 0;

								Method endTurn = createdGame.getClass().getMethod("endTurn");
								endTurn.invoke(createdGame);

								int newHP4 = (Integer) m5.invoke(champ4);
								int newHP5 = (Integer) m5.invoke(champ5);
								int newHP6 = (Integer) m5.invoke(champ6);

								assertTrue(
										"If an INACTIVE champion with SpeedUp effect is dealing his attack damage to an enemy champion who has a shield effect, the enemy chamion's currentHP should not be affected. "
												+ "Expected currentHP " + oldHP + " but was " + newHP5,
										newHP5 == oldHP);

							} catch (NoSuchMethodException e) {
								fail("Game class should have endTurn method");
							}

						} catch (NoSuchMethodException e) {
							fail("Champion class should have getCurrentHP method");
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

	// having a comp check in a test case, increases their chances of losing grades

	/*
	 * // speedUp damage on target with shield, hp updated && shield removed
	 * 
	 * @SuppressWarnings({ "unchecked", "rawtypes" })
	 * 
	 * @Test(timeout = 3000) public void
	 * testSpeedUpAttackOnValidChampWithShield_ShieldRemovedCombo() throws Exception
	 * { ArrayList<Object> newGame = (ArrayList<Object>) createGameAndTeams();
	 * Object createdGame = newGame.get(0); ArrayList<Object> firstTeam =
	 * (ArrayList<Object>) newGame.get(1); ArrayList<Object> secondTeam =
	 * (ArrayList<Object>) newGame.get(2);
	 * 
	 * Object champ1 = firstTeam.get(0); Object champ2 = firstTeam.get(1); Object
	 * champ3 = firstTeam.get(2);
	 * 
	 * Object champ4 = secondTeam.get(0); Object champ5 = secondTeam.get(1); Object
	 * champ6 = secondTeam.get(2);
	 * 
	 * Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
	 * setSpeed.invoke(champ2,10); setSpeed.invoke(champ1,8); //sped up inactive
	 * champ
	 * 
	 * Method setDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
	 * int randomDmg = (int) (Math.random() * 40) + 5; setDamage.invoke(champ1,
	 * randomDmg);
	 * 
	 * setLocationForObject(champ1, 1, 1); setLocationForObject(champ4, 2, 1);
	 * setLocationForObject(champ5, 1, 2); setLocationForObject(champ6, 0, 1);
	 * 
	 * try { Field attackRange = champ1.getClass().getSuperclass()
	 * .getDeclaredField("attackRange"); attackRange.setAccessible(true);
	 * attackRange.set(champ1, 3);
	 * 
	 * } catch (NoSuchFieldException e) {
	 * fail("Champion class should have attackRange attribute"); }
	 * 
	 * 
	 * try { Method m = createdGame.getClass().getMethod("getTurnOrder"); Object
	 * turnOrder = m.invoke(createdGame);
	 * 
	 * try { Method size = turnOrder.getClass().getMethod("size");
	 * 
	 * try { int turnOrderSize = (int) size.invoke(turnOrder); Method remove =
	 * turnOrder.getClass().getMethod("remove");
	 * 
	 * try { while (turnOrderSize != 0) { remove.invoke(turnOrder); turnOrderSize =
	 * (int) size.invoke(turnOrder);
	 * 
	 * }
	 * 
	 * try { Method getAppliedEffects =
	 * champ1.getClass().getMethod("getAppliedEffects");
	 * 
	 * ArrayList<Object> effectsOfSpedUpChamp = (ArrayList<Object>)
	 * getAppliedEffects.invoke(champ1);
	 * 
	 * Object speedUpEffect = createSpeedUpEffect(2); Object stunEffect =
	 * createStunEffect(3);
	 * 
	 * effectsOfSpedUpChamp.add(stunEffect);
	 * effectsOfSpedUpChamp.add(speedUpEffect);
	 * 
	 * ArrayList<Object> effectsOfShieldedEnemy = (ArrayList<Object>)
	 * getAppliedEffects.invoke(champ5);
	 * 
	 * Object shieldEffect = createSheildEffect(3);
	 * effectsOfShieldedEnemy.add(shieldEffect);
	 * 
	 * try { Field appliedEffects1 = champ1.getClass().getSuperclass()
	 * .getDeclaredField("appliedEffects"); appliedEffects1.setAccessible(true);
	 * appliedEffects1.set(champ1, effectsOfSpedUpChamp);
	 * 
	 * Field appliedEffects2 = champ5.getClass().getSuperclass()
	 * .getDeclaredField("appliedEffects"); appliedEffects2.setAccessible(true);
	 * appliedEffects2.set(champ5, effectsOfShieldedEnemy);
	 * 
	 * } catch (NoSuchFieldException e) {
	 * fail("Champion class should have appliedEffects attribute"); } } catch
	 * (NoSuchMethodException e) {
	 * fail("Champion class should have getAppliedEffects method");
	 * 
	 * }
	 * 
	 * 
	 * 
	 * Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
	 * m2.invoke(turnOrder, champ1); //has the speedUp and stun effects
	 * m2.invoke(turnOrder, champ2); m2.invoke(turnOrder, champ3);
	 * m2.invoke(turnOrder, champ4); m2.invoke(turnOrder, champ5); //has a shield
	 * m2.invoke(turnOrder, champ6);
	 * 
	 * setObjectHP(champ4, 100); setObjectHP(champ5, 100); setObjectHP(champ6, 100);
	 * 
	 * try { Method m5 = champ5.getClass().getMethod("getCurrentHP"); int oldHP =
	 * (Integer) m5.invoke(champ5);
	 * 
	 * try {
	 * 
	 * Method m4 = champ1.getClass().getMethod("getAttackDamage"); int berserkDamage
	 * = (Integer) m4.invoke(champ1);
	 * 
	 * int expectedHp = oldHP - berserkDamage; if(expectedHp < 0) expectedHp = 0;
	 * 
	 * Method endTurn = createdGame.getClass().getMethod("endTurn");
	 * endTurn.invoke(createdGame);
	 * 
	 * ArrayList<Object> expectedEffectsAfterAttack = new ArrayList<>();
	 * 
	 * Method getAppliedEffects = champ5.getClass().getMethod("getAppliedEffects");
	 * ArrayList<Object> effectsAfterAttack = (ArrayList<Object>)
	 * getAppliedEffects.invoke(champ5);
	 * 
	 * 
	 * int newHP4 = (Integer) m5.invoke(champ4); int newHP5 = (Integer)
	 * m5.invoke(champ5); int newHP6 = (Integer) m5.invoke(champ6);
	 * 
	 * assertTrue("An inactive champion with a SpeedUp effect should attack all enemy champions. "
	 * + "Expected currentHP " + expectedHp + " but was " + newHP4 , ((newHP4 ==
	 * expectedHp) && (newHP6 == expectedHp)) );
	 * 
	 * assertTrue("A champion with a Shield effect should be able to avoid the attack of the SpeedUp effect. "
	 * + "Expected currentHP " + oldHP + " but was " + newHP5 , newHP5 == oldHP);
	 * 
	 * assertTrue("A Shield effect should be removed from the target's appliedEffects after blocking the attack of the SpeedUp effect. "
	 * , effectsAfterAttack.equals(expectedEffectsAfterAttack));
	 * 
	 * 
	 * } catch (NoSuchMethodException e) {
	 * fail("Game class should have endTurn method"); }
	 * 
	 * } catch (NoSuchMethodException e) {
	 * fail("Champion class should have getCurrentHP method"); }
	 * 
	 * } catch (NoSuchMethodException e) {
	 * fail("Priority Queue class should have insert method"); } } catch
	 * (NoSuchMethodException e) {
	 * fail("Priority Queue class should have remove method");
	 * 
	 * } } catch (NoSuchMethodException e) {
	 * fail("Priority Queue class should have size method");
	 * 
	 * } } catch (NoSuchMethodException e) {
	 * fail("Game class should have getTurnOrder method"); }
	 * 
	 * }
	 * 
	 * 
	 */

	// test speedUp damage on target with a shield, check if shield was removed
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testSpeedUpAttackOnValidChampWithShield_ShieldRemovedFromAppliedEffects() throws Exception {
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

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);
		setSpeed.invoke(champ1, 8); // sped up inactive champ

		Method setDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		int randomDmg = (int) (Math.random() * 40) + 5;
		setDamage.invoke(champ1, randomDmg);

		setLocationForObject(champ1, 1, 1);
		setLocationForObject(champ4, 2, 1);
		setLocationForObject(champ5, 1, 2);
		setLocationForObject(champ6, 0, 1);

		try {
			Field attackRange = champ1.getClass().getSuperclass().getDeclaredField("attackRange");
			attackRange.setAccessible(true);
			attackRange.set(champ1, 3);

		} catch (NoSuchFieldException e) {
			fail("Champion class should have attackRange attribute");
		}

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
							Method getAppliedEffects = champ1.getClass().getMethod("getAppliedEffects");

							ArrayList<Object> effectsOfSpedUpChamp = (ArrayList<Object>) getAppliedEffects
									.invoke(champ1);

							Object speedUpEffect = createSpeedUpEffect(2);
							Object stunEffect = createStunEffect(3);

							effectsOfSpedUpChamp.add(stunEffect);
							effectsOfSpedUpChamp.add(speedUpEffect);

							Field condition = champ1.getClass().getSuperclass().getDeclaredField("condition");
							condition.setAccessible(true);
							Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE");
							condition.set(champ1, expectedValue);
							ArrayList<Object> effectsOfShieldedEnemy = (ArrayList<Object>) getAppliedEffects
									.invoke(champ5);

							Object shieldEffect = createSheildEffect(3);
							effectsOfShieldedEnemy.add(shieldEffect);

							try {
								Field appliedEffects1 = champ1.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects1.setAccessible(true);
								appliedEffects1.set(champ1, effectsOfSpedUpChamp);

								Field appliedEffects2 = champ5.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects2.setAccessible(true);
								appliedEffects2.set(champ5, effectsOfShieldedEnemy);

							} catch (NoSuchFieldException e) {
								fail("Champion class should have appliedEffects attribute");
							}
						} catch (NoSuchMethodException e) {
							fail("Champion class should have getAppliedEffects method");

						}

						Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
						m2.invoke(turnOrder, champ1); // has the speedUp and stun effects
						m2.invoke(turnOrder, champ2);
						m2.invoke(turnOrder, champ3);
						m2.invoke(turnOrder, champ4);
						m2.invoke(turnOrder, champ5); // has a shield
						m2.invoke(turnOrder, champ6);

						setObjectHP(champ4, 100);
						setObjectHP(champ5, 100);
						setObjectHP(champ6, 100);

						try {

							Method endTurn = createdGame.getClass().getMethod("endTurn");
							endTurn.invoke(createdGame);

							ArrayList<Object> expectedEffectsAfterAttack = new ArrayList<>();

							Method getAppliedEffects = champ5.getClass().getMethod("getAppliedEffects");
							ArrayList<Object> effectsAfterAttack = (ArrayList<Object>) getAppliedEffects.invoke(champ5);

							assertTrue(
									"If an INACTIVE champion with SpeedUp effect is dealing his attack damage to an enemy champion who has a shield effect, his shield effect should be removed from his applied effects",
									effectsAfterAttack.equals(expectedEffectsAfterAttack));

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
	public void testSpeedUpAttackOnValidChampWithShield_ShieldLogicRemoved() throws Exception {
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

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);
		setSpeed.invoke(champ1, 8); // sped up inactive champ

		Method setDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		int randomDmg = (int) (Math.random() * 40) + 5;
		setDamage.invoke(champ1, randomDmg);

		setLocationForObject(champ1, 1, 1);
		setLocationForObject(champ4, 2, 1);
		setLocationForObject(champ5, 1, 2);
		setLocationForObject(champ6, 0, 1);

		try {
			Field attackRange = champ1.getClass().getSuperclass().getDeclaredField("attackRange");
			attackRange.setAccessible(true);
			attackRange.set(champ1, 3);

		} catch (NoSuchFieldException e) {
			fail("Champion class should have attackRange attribute");
		}

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
							Method getAppliedEffects = champ1.getClass().getMethod("getAppliedEffects");

							ArrayList<Object> effectsOfSpedUpChamp = (ArrayList<Object>) getAppliedEffects
									.invoke(champ1);

							Object speedUpEffect = createSpeedUpEffect(2);
							Object stunEffect = createStunEffect(3);

							effectsOfSpedUpChamp.add(stunEffect);
							effectsOfSpedUpChamp.add(speedUpEffect);

							Field condition = champ1.getClass().getSuperclass().getDeclaredField("condition");
							condition.setAccessible(true);
							Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE");
							condition.set(champ1, expectedValue);
							ArrayList<Object> effectsOfShieldedEnemy = (ArrayList<Object>) getAppliedEffects
									.invoke(champ5);

							Object shieldEffect = createSheildEffect(3);
							effectsOfShieldedEnemy.add(shieldEffect);

							try {
								Field appliedEffects1 = champ1.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects1.setAccessible(true);
								appliedEffects1.set(champ1, effectsOfSpedUpChamp);

								Field appliedEffects2 = champ5.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects2.setAccessible(true);
								appliedEffects2.set(champ5, effectsOfShieldedEnemy);

							} catch (NoSuchFieldException e) {
								fail("Champion class should have appliedEffects attribute");
							}
						} catch (NoSuchMethodException e) {
							fail("Champion class should have getAppliedEffects method");

						}

						Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
						m2.invoke(turnOrder, champ1); // has the speedUp and stun effects
						m2.invoke(turnOrder, champ2);
						m2.invoke(turnOrder, champ3);
						m2.invoke(turnOrder, champ4);
						m2.invoke(turnOrder, champ5); // has a shield
						m2.invoke(turnOrder, champ6);

						setObjectHP(champ4, 100);
						setObjectHP(champ5, 100);
						setObjectHP(champ6, 100);

						try {
							Field speed = champ5.getClass().getSuperclass().getDeclaredField("speed");
							speed.setAccessible(true);
							speed.set(champ5, 102);
							Method endTurn = createdGame.getClass().getMethod("endTurn");
							endTurn.invoke(createdGame);

							int speedAfter = (int) speed.get(champ5);

							assertTrue(
									"If an INACTIVE champion with SpeedUp effect is dealing his attack damage to an enemy champion who has a shield effect, his shield effect logic should be undone. ",
									speedAfter == 100);

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

	// check speedUp damage applied on target with dodge
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 3000)
	public void testSpeedUpAttackOnValidChampWithDodge_UpdateHP() throws Exception {

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

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ2, 10);
		setSpeed.invoke(champ1, 8); // sped up inactive champ

		Method setDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		int randomDmg = (int) (Math.random() * 40) + 5;
		setDamage.invoke(champ1, randomDmg);

		setLocationForObject(champ1, 1, 1);
		setLocationForObject(champ4, 2, 1);
		setLocationForObject(champ5, 1, 2);
		setLocationForObject(champ6, 0, 1);

		try {
			Field attackRange = champ1.getClass().getSuperclass().getDeclaredField("attackRange");
			attackRange.setAccessible(true);
			attackRange.set(champ1, 3);

		} catch (NoSuchFieldException e) {
			fail("Champion class should have attackRange attribute");
		}

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
							Method getAppliedEffects = champ1.getClass().getMethod("getAppliedEffects");

							ArrayList<Object> effectsOfSpedUpChamp = (ArrayList<Object>) getAppliedEffects
									.invoke(champ1);

							Object speedUpEffect = createSpeedUpEffect(2);
							Object stunEffect = createStunEffect(3);

							effectsOfSpedUpChamp.add(stunEffect);
							effectsOfSpedUpChamp.add(speedUpEffect);
							Field condition = champ1.getClass().getSuperclass().getDeclaredField("condition");
							condition.setAccessible(true);
							Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE");
							condition.set(champ1, expectedValue);
							ArrayList<Object> effectsOfEnemy = (ArrayList<Object>) getAppliedEffects.invoke(champ5);

							Object dodgeEffect = createDodgeEffect(3);
							effectsOfEnemy.add(dodgeEffect);

							try {
								Field appliedEffects1 = champ1.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects1.setAccessible(true);
								appliedEffects1.set(champ1, effectsOfSpedUpChamp);

								Field appliedEffects2 = champ5.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects2.setAccessible(true);
								appliedEffects2.set(champ5, effectsOfEnemy);

							} catch (NoSuchFieldException e) {
								fail("Champion class should have appliedEffects attribute");
							}
						} catch (NoSuchMethodException e) {
							fail("Champion class should have getAppliedEffects method");

						}

						Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
						m2.invoke(turnOrder, champ1); // has the speedUp and stun effects
						m2.invoke(turnOrder, champ2);
						m2.invoke(turnOrder, champ3);
						m2.invoke(turnOrder, champ4);
						m2.invoke(turnOrder, champ5); // has a dodge
						m2.invoke(turnOrder, champ6);

						int randomHP = (int) (Math.random() * 100) + 1;
						setObjectHP(champ4, randomHP);
						setObjectHP(champ5, randomHP);
						setObjectHP(champ6, randomHP);

						try {
							Method m5 = champ5.getClass().getMethod("getCurrentHP");
							int oldHP = (Integer) m5.invoke(champ5);

							try {

								Method m4 = champ1.getClass().getMethod("getAttackDamage");
								int berserkDamage = (Integer) m4.invoke(champ1);

								int expectedHp = oldHP - berserkDamage;
								if (expectedHp < 0)
									expectedHp = 0;

								Method endTurn = createdGame.getClass().getMethod("endTurn");
								endTurn.invoke(createdGame);

								int newHP4 = (Integer) m5.invoke(champ4);
								int newHP5 = (Integer) m5.invoke(champ5);
								int newHP6 = (Integer) m5.invoke(champ6);

								assertTrue(
										"An inactive champion with a SpeedUp effect should deal his damage to all enemy champions. "
												+ "Expected currentHP " + expectedHp + " but was " + newHP4,
										((newHP4 == expectedHp) && (newHP6 == expectedHp)));

								assertTrue(
										"An inactive champion with a SpeedUp effect should deal his damage to all enemy champions even if the enemy champion has a dodge effect. "
												+ "Expected currentHP " + expectedHp + " but was " + newHP5,
										newHP5 == expectedHp);

							} catch (NoSuchMethodException e) {
								fail("Game class should have endTurn method");
							}

						} catch (NoSuchMethodException e) {
							fail("Champion class should have getCurrentHP method");
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

	@SuppressWarnings({ "unchecked" })
	@Test(timeout = 3000)
	public void testSpeedUpAttackDoesNotAffectFriendlyWithShield() throws Exception {

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

		Method setSpeed = champ1.getClass().getMethod("setSpeed", int.class);
		setSpeed.invoke(champ5, 10);
		setSpeed.invoke(champ1, 8); // sped up inactive champ

		Method setDamage = champ1.getClass().getMethod("setAttackDamage", int.class);
		int randomDmg = (int) (Math.random() * 40) + 5;
		setDamage.invoke(champ1, randomDmg);

		setLocationForObject(champ1, 1, 1);
		setLocationForObject(champ2, 1, 2);
		setLocationForObject(champ3, 0, 1);

		try {
			Field attackRange = champ1.getClass().getSuperclass().getDeclaredField("attackRange");
			attackRange.setAccessible(true);
			attackRange.set(champ1, 3);

		} catch (NoSuchFieldException e) {
			fail("Champion class should have attackRange attribute");
		}

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
							Method getAppliedEffects = champ1.getClass().getMethod("getAppliedEffects");

							ArrayList<Object> effectsOfSpedUpChamp = (ArrayList<Object>) getAppliedEffects
									.invoke(champ1);

							Object speedUpEffect = createSpeedUpEffect(2);
							Object stunEffect = createStunEffect(3);

							effectsOfSpedUpChamp.add(stunEffect);
							effectsOfSpedUpChamp.add(speedUpEffect);
							Field condition = champ1.getClass().getSuperclass().getDeclaredField("condition");
							condition.setAccessible(true);
							Object expectedValue = Enum.valueOf((Class<Enum>) Class.forName(conditionPath), "INACTIVE");
							condition.set(champ1, expectedValue);
							ArrayList<Object> effectsOfShieldedEnemy = (ArrayList<Object>) getAppliedEffects
									.invoke(champ3);

							Object shieldEffect = createSheildEffect(3);
							effectsOfShieldedEnemy.add(shieldEffect);

							try {
								Field appliedEffects1 = champ1.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects1.setAccessible(true);
								appliedEffects1.set(champ1, effectsOfSpedUpChamp);

								Field appliedEffects2 = champ5.getClass().getSuperclass()
										.getDeclaredField("appliedEffects");
								appliedEffects2.setAccessible(true);
								appliedEffects2.set(champ3, effectsOfShieldedEnemy);

							} catch (NoSuchFieldException e) {
								fail("Champion class should have appliedEffects attribute");
							}
						} catch (NoSuchMethodException e) {
							fail("Champion class should have getAppliedEffects method");

						}

						Method m2 = turnOrder.getClass().getMethod("insert", Comparable.class);
						m2.invoke(turnOrder, champ1); // has the speedUp and stun effects
						m2.invoke(turnOrder, champ2);
						m2.invoke(turnOrder, champ3); // has a shield, also invalid target
						m2.invoke(turnOrder, champ4);
						m2.invoke(turnOrder, champ5);
						m2.invoke(turnOrder, champ6);

						setObjectHP(champ1, 100);
						setObjectHP(champ2, 100);
						setObjectHP(champ3, 100);

						try {
							Method m5 = champ3.getClass().getMethod("getCurrentHP");
							int oldHP = (Integer) m5.invoke(champ2);

							try {

								Method m4 = champ1.getClass().getMethod("getAttackDamage");
								int berserkDamage = (Integer) m4.invoke(champ1);

								int expectedHp = oldHP;
								if (expectedHp < 0)
									expectedHp = 0;

								Method endTurn = createdGame.getClass().getMethod("endTurn");
								endTurn.invoke(createdGame);

								int newHP1 = (Integer) m5.invoke(champ1);
								int newHP2 = (Integer) m5.invoke(champ2);
								int newHP3 = (Integer) m5.invoke(champ3);

								assertTrue(
										"An inactive Champion with a SpeedUp effect shouldn't affect friendly champions with shield effects. "
												+ "Expected currentHP " + expectedHp + " but was " + newHP1,
										newHP1 == expectedHp);
								assertTrue(
										"An inactive Champion with a SpeedUp effect shouldn't attack friendly champions with shield effects. "
												+ "Expected currentHP " + expectedHp + " but was " + newHP2,
										newHP2 == expectedHp);
								assertTrue(
										"An inactive Champion with a SpeedUp effect shouldn't attack friendly champions with shield effects. "
												+ "Expected currentHP " + expectedHp + " but was " + newHP3,
										newHP3 == expectedHp);
							} catch (NoSuchMethodException e) {
								fail("Game class should have endTurn method");
							}

						} catch (NoSuchMethodException e) {
							fail("Champion class should have getCurrentHP method");
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
	public void testOriginalLogicUnchanged() {
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
		// Object expectedValue = (randomActions + 1);
		int expectedValue1 = (int) (randomSpeed * 1.15);
		int expectedValue2 = (int) (randomSpeed + randomSpeed * 0.15);

		int afterApply = (randomActions + 1);
		Object expectedValueAfter = (afterApply - 1);
		int expectedValue1After = (int) (expectedValue1 / 1.15);

		Field fCurrActions = null;
		Field fMaxActions = null;
		Field fSpeed = null;
		Field fMana = null;
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
			// test logic applied correctly
			Class<?> curr = Class.forName(championPath);

			Object speedUPObject;
			speedUPObject = constructorSpeedUP.newInstance(duration);

			try {

				Method apply = Class.forName(speedUpPath).getDeclaredMethod("apply", Class.forName(championPath));

				try {
					fCurrActions = curr.getDeclaredField("currentActionPoints");
					fCurrActions.setAccessible(true);
					fCurrActions.set(championObject, randomActions);
					apply.invoke(speedUPObject, championObject);
					assertEquals(
							"The method \"" + "apply" + "\" in class " + speedUPObject.getClass().getSimpleName()
									+ " should set the correct value of variable \"" + "currentActionPoints" + "\".",
							afterApply, fCurrActions.get(championObject));
				} catch (NoSuchFieldException e) {
					assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
					e.printStackTrace();
				}
				try {
					fMaxActions = curr.getDeclaredField("maxActionPointsPerTurn");
					fMaxActions.setAccessible(true);
					fMaxActions.set(championObject, randomActions);
					apply.invoke(speedUPObject, championObject);
					assertEquals(
							"The method \"" + "apply" + "\" in class " + speedUPObject.getClass().getSimpleName()
									+ " should set the correct value of variable \"" + "maxActionPointsPerTurn" + "\".",
							afterApply, fMaxActions.get(championObject));
				} catch (NoSuchFieldException e) {
					assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
					e.printStackTrace();
				}
				try {
					fSpeed = curr.getDeclaredField("speed");
					fSpeed.setAccessible(true);
					fSpeed.set(championObject, randomSpeed);
					apply.invoke(speedUPObject, championObject);
					boolean flag = true;
					if (!((int) fSpeed.get(championObject) == expectedValue1
							|| (int) fSpeed.get(championObject) == expectedValue2)) {
						flag = false;
					}
					assertTrue("The method \"" + "apply" + "\" in class " + speedUPObject.getClass().getSimpleName()
							+ " should set the correct value of variable \"" + "speed" + "\".", flag);
				} catch (NoSuchFieldException e) {
					assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
					e.printStackTrace();
				}
				try {
					fMana = curr.getDeclaredField("mana");
					fMana.setAccessible(true);
					fMana.set(championObject, randomMana);
					apply.invoke(speedUPObject, championObject);
					assertEquals(
							"The method \"" + "apply" + "\" in class " + speedUPObject.getClass().getSimpleName()
									+ " shouldn't change the value of variable \"" + "mana" + "\".",
							randomMana, fMana.get(championObject));
				} catch (NoSuchFieldException e) {
					assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
					e.printStackTrace();
				}
			} catch (InvocationTargetException e) {
				assertTrue("The type \"SpeedUp\" must implement the inherited abstract method Effect.apply(Champion).",
						false);
			}

			// test logic removed correctly //after
			fCurrActions.set(championObject, expectedValueAfter);
			fMaxActions.set(championObject, expectedValueAfter);
			fSpeed.set(championObject, expectedValue1);

			try {

				Method remove = Class.forName(speedUpPath).getDeclaredMethod("remove", Class.forName(championPath));

				try {

					fCurrActions = curr.getDeclaredField("currentActionPoints");
					fCurrActions.setAccessible(true);
					fCurrActions.set(championObject, afterApply);
					remove.invoke(speedUPObject, championObject);

					assertEquals(
							"The method \"" + "remove" + "\" in class " + speedUPObject.getClass().getSimpleName()
									+ " should set the correct value of variable \"" + "currentActionPoints" + "\".",
							expectedValueAfter, fCurrActions.get(championObject));
				} catch (NoSuchFieldException e) {
					assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
					e.printStackTrace();
				}

				try {

					fMaxActions = curr.getDeclaredField("maxActionPointsPerTurn");
					fMaxActions.setAccessible(true);
					fMaxActions.set(championObject, afterApply);
					remove.invoke(speedUPObject, championObject);

					assertEquals(
							"The method \"" + "remove" + "\" in class " + speedUPObject.getClass().getSimpleName()
									+ " should set the correct value of variable \"" + "maxActionPointsPerTurn" + "\".",
							expectedValueAfter, fMaxActions.get(championObject));
				} catch (NoSuchFieldException e) {
					assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
					e.printStackTrace();
				}
				try {

					fSpeed = curr.getDeclaredField("speed");
					fSpeed.setAccessible(true);
					fSpeed.set(championObject, expectedValue1);
					remove.invoke(speedUPObject, championObject);

					assertEquals(
							"The method \"" + "remove" + "\" in class " + speedUPObject.getClass().getSimpleName()
									+ " should set the correct value of variable \"" + "speed" + "\".",
							expectedValue1After, fSpeed.get(championObject));
				} catch (NoSuchFieldException e) {
					assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
					e.printStackTrace();
				}
				try {
					fMana = curr.getDeclaredField("mana");
					fMana.setAccessible(true);
					fMana.set(championObject, randomMana);
					remove.invoke(speedUPObject, championObject);
					assertEquals(
							"The method \"" + "remove" + "\" in class " + speedUPObject.getClass().getSimpleName()
									+ " shouldn't change the value of variable \"" + "mana" + "\".",
							randomMana, fMana.get(championObject));
				} catch (NoSuchFieldException e) {
					assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(), false);
					e.printStackTrace();
				}
			} catch (InvocationTargetException e) {
				assertTrue("The type \"SpeedUp\" must implement the inherited abstract method Effect.remove(Champion)",
						false);
			}
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
		}

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
				Object champ1 = constructorHero.newInstance("ironman", 100, 2, 3, 1, 2, 6);
				Object champ2 = constructorAntiHero.newInstance("deadpool", 100, 2, 2, 2, 5, 6);
				Object champ3 = constructorVillain.newInstance("yellow jacket", 100, 2, 3, 3, 5, 6);

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

	private boolean isPositive(int i) {
		return i > 0 ? true : false;
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

	private static boolean containsMethodName(Method[] methods, String name) {
		for (Method method : methods) {
			if (method.getName().equals(name))
				return true;
		}
		return false;
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

}
