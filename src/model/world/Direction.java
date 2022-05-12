package model.world;

import java.awt.*;

public enum Direction {
    RIGHT, LEFT, UP, DOWN;

    public Point toVector() {
        switch (this) {
            case UP:
                return new Point(1, 0);
            case DOWN:
                return new Point(-1, 0);
            case RIGHT:
                return new Point(0, 1);
            case LEFT:
                return new Point(0, -1);
        }

        return null;
    }
}
