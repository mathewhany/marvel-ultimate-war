package model.world;

import utils.Utils;

import java.awt.Point;

public class Cover implements Damageable {
    private int currentHP;
    private Point location;
    private int maxHP;

    private static final int MIN_HP = 100;
    private static final int MAX_HP = 999;

    private Listener listener;

    public Cover(int x, int y) {
        maxHP = generateRandomHP();
        currentHP = maxHP;
        location = new Point(x, y);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        int oldHP = this.currentHP;
        int newHp = Utils.aboveZero(currentHP);

        this.currentHP = newHp;

        if (newHp == 0) {
            listener.onCoverDestroyed(this);
        } else {
            listener.onCoverDamaged(this, oldHP, newHp);
        }
    }

    public Point getLocation() {
        return location;
    }

    private int generateRandomHP() {
        return Utils.randomNumber(MIN_HP, MAX_HP + 1);
    }

    public int getMaxHP() {
        return maxHP;
    }

    public double getHpPercent() {
        return currentHP * 1.0 / maxHP;
    }

    public interface Listener {
        void onCoverDestroyed(Cover cover);
        void onCoverDamaged(Cover cover, int oldHp, int newHp);
    }
}
