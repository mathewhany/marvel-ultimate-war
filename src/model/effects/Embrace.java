package model.effects;

import model.world.Champion;

public class Embrace extends Effect {
    public static final String EFFECT_NAME = "Embrace";

    private int gainedSpeed;
    private int gainedDamage;

    public Embrace(int duration) {
        super(EFFECT_NAME, duration, EffectType.BUFF);
    }

    public void apply(Champion c) {
        c.setCurrentHP(c.getCurrentHP() + (int) (c.getMaxHP() * 0.2));
        c.setMana((int) (c.getMana() * 1.2));

        gainedSpeed = (int) (c.getSpeed() * 0.2);
        gainedDamage = (int) (c.getAttackDamage() * 0.2);

        c.setSpeed(c.getSpeed() + gainedSpeed);
        c.setAttackDamage(c.getAttackDamage() + gainedDamage);
    }

    public void remove(Champion c) {
        c.setSpeed(c.getSpeed() - gainedSpeed);
        c.setAttackDamage(c.getAttackDamage() - gainedDamage);
    }
}
