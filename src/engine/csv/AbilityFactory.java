package engine.csv;

import exceptions.UnrecognizedAbilityTypeException;
import exceptions.UnrecognizedEffectException;
import model.abilities.*;
import model.effects.Effect;

public class AbilityFactory {
    private static final int CSV_TYPE = 0;
    private static final int CSV_NAME = 1;
    private static final int CSV_MANA_COST = 2;
    private static final int CSV_CAST_RANGE = 3;
    private static final int CSV_BASE_COOLDOWN = 4;
    private static final int CSV_AREA_OF_EFFECT = 5;
    private static final int CSV_REQUIRED_ACTIONS_PER_TURN = 6;
    private static final int CSV_DAMAGE_AMOUNT = 7;
    private static final int CSV_HEAL_AMOUNT = 7;
    private static final int CSV_EFFECT_NAME = 7;
    private static final int CSV_EFFECT_DURATION = 8;
    private static final String CSV_ABILITY_TYPE_CROWD_CONTROL = "CC";
    private static final String CSV_ABILITY_TYPE_DAMAGING = "DMG";
    private static final String ABILITY_TYPE_HEALING = "HEL";

    public static Ability fromCsvRow(String[] row) throws UnrecognizedAbilityTypeException, UnrecognizedEffectException {
        String type = row[CSV_TYPE];
        String name = row[CSV_NAME];
        int manaCost = Integer.parseInt(row[CSV_MANA_COST]);
        int castRange = Integer.parseInt(row[CSV_CAST_RANGE]);
        int baseCooldown = Integer.parseInt(row[CSV_BASE_COOLDOWN]);
        AreaOfEffect areaOfEffect = AreaOfEffect.valueOf(row[CSV_AREA_OF_EFFECT]);
        int requiredActionsPerTurn = Integer.parseInt(row[CSV_REQUIRED_ACTIONS_PER_TURN]);

        switch (type) {
            case ABILITY_TYPE_HEALING:
                int healAmount = Integer.parseInt(row[CSV_HEAL_AMOUNT]);
                return new HealingAbility(name, manaCost, baseCooldown, castRange, areaOfEffect, requiredActionsPerTurn, healAmount);
            case CSV_ABILITY_TYPE_DAMAGING:
                int damageAmount = Integer.parseInt(row[CSV_DAMAGE_AMOUNT]);
                return new DamagingAbility(name, manaCost, baseCooldown, castRange, areaOfEffect, requiredActionsPerTurn, damageAmount);
            case CSV_ABILITY_TYPE_CROWD_CONTROL:
                String effectName = row[CSV_EFFECT_NAME];
                int effectDuration = Integer.parseInt(row[CSV_EFFECT_DURATION]);
                Effect effect = Effect.fromName(effectName, effectDuration);
                return new CrowdControlAbility(name, manaCost, baseCooldown, castRange, areaOfEffect, requiredActionsPerTurn, effect);
            default:
                throw new UnrecognizedAbilityTypeException(type);
        }
    }
}
