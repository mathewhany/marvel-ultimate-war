package model.world;

import utils.Utils;

import java.awt.Point;

public class Cover {
    private int currentHP;
    private Point location;

    private static final int MIN_HP = 100;
    private static final int MAX_HP = 999;

    public Cover(int x, int y) {
        currentHP = generateRandomHP();
        location = new Point(x, y);
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public Point getLocation() {
        return location;
    }

    private int generateRandomHP() {
        return Utils.randomNumber(MIN_HP, MAX_HP + 1);
    }
}
