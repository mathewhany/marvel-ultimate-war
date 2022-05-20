package model.world;

import utils.Utils;

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

        throw new IllegalArgumentException("Direction not supported");
    }

    /**
     * Takes a point and returns the a new point after translating
     * the given point in this direction.
     */
    public Point translatePoint(Point point) {
        return Utils.addPoints(point, toVector());
    }
}
