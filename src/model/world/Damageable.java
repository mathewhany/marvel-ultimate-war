package model.world;

import java.awt.Point;

public interface Damageable {
    Point getLocation();
    int getCurrentHP();
    void setCurrentHP(int hp);
}
