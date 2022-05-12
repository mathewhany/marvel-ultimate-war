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

        c.setSpeed((int) (c.getSpeed() * 1.2));
        c.setAttackDamage((int) (c.getAttackDamage() * 1.2));
    }

    public void remove(Champion c) {
        c.setSpeed((int) (c.getSpeed() / 1.2));
        c.setAttackDamage((int) (c.getAttackDamage() / 1.2));
    }
}
