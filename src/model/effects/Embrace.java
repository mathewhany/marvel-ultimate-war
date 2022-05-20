package model.effects;

import model.world.Champion;

public class Embrace extends Effect {
    public static final String EFFECT_NAME = "Embrace";

    public static final double GAIN_HP = 0.2;
    public static final double GAIN_MANA = 0.2;
    public static final double SPEED_GAIN = 0.2;
    public static final double ATTACK_DAMAGE_GAIN = 0.2;

    public Embrace(int duration) {
        super(EFFECT_NAME, duration, EffectType.BUFF);
    }

    public void apply(Champion c) {
        // Permanent
        c.setCurrentHP(c.getCurrentHP() + (int) (c.getMaxHP() * GAIN_HP));
        c.setMana((int) (c.getMana() * (1 + GAIN_MANA)));

        // Temporary
        c.setSpeed((int) (c.getSpeed() * (1 + SPEED_GAIN)));
        c.setAttackDamage((int) (c.getAttackDamage() * (1 + ATTACK_DAMAGE_GAIN)));
    }

    public void remove(Champion c) {
        c.setSpeed((int) (c.getSpeed() / (1 + SPEED_GAIN)));
        c.setAttackDamage((int) (c.getAttackDamage() / (1 + ATTACK_DAMAGE_GAIN)));
    }
}
