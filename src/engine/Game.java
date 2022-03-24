package engine;

import model.abilities.Ability;
import model.world.Champion;
import model.world.Cover;
import utils.Utils;

import java.awt.*;
import java.util.ArrayList;

public class Game {
    private Player firstPlayer;
    private Player secondPlayer;
    private boolean firstLeaderAbilityUsed;
    private boolean secondLeaderAbilityUsed;
    private Object[][] board;
    private static ArrayList<Champion> availableChampions;
    private static ArrayList<Ability> availableAbilities;
    private PriorityQueue turnOrder;

    private static final int BOARDHEIGHT = 5;
    private static final int BOARDWIDTH = 5;

    private static final int NUM_CHAMPIONS_FOR_PLAYER = 3;
    private static final int NUM_COVERS = 5;

    public Game(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.firstLeaderAbilityUsed = false;
        this.secondLeaderAbilityUsed = false;
        this.board = new Object[BOARDHEIGHT][BOARDWIDTH];
        this.placeChampions();
        this.placeCovers();
        // this.turnOrder = new PriorityQueue();
    }

    private void placeChampions() {
        // Calculate where the first champion will be placed on each row so that the champions are centered.
        int startPosition = (BOARDWIDTH - NUM_CHAMPIONS_FOR_PLAYER) / 2; // (5 - 3) / 2 = 1

        for (int i = 0; i < NUM_CHAMPIONS_FOR_PLAYER; i++) {
            // Place the first player's champions in the center of the bottom row adjacent to each other.
            board[BOARDHEIGHT - 1][startPosition + i] = firstPlayer.getTeam().get(i);

            // Place the second player's champions in the center of the bottom row adjacent to each other.
            board[0][startPosition + i] = secondPlayer.getTeam().get(i);
        }
    }

    private void placeCovers() {
        for (int i = 0; i < NUM_COVERS; i++) {
            placeCoverAtRandomPoint();
        }
    }

    private void placeCoverAtRandomPoint() {
        Point point = getRandomNotCorneredEmptyPoint();
        Cover cover = new Cover(point.x, point.y);
        board[point.x][point.y] = cover;
    }

    private Point getRandomNotCorneredEmptyPoint() {
        Point point;
        do {
            point = getRandomPoint();
        } while (isCornerPoint(point) && isTileEmpty(point));
        return point;
    }

    private boolean isTileEmpty(Point point) {
        return board[point.x][point.y] == null;
    }

    private boolean isCornerPoint(Point point) {
        boolean topLeftCorner = point.x == 0 && point.y == 0;
        boolean topRightCorner = point.x == BOARDWIDTH - 1 && point.y == 0;
        boolean bottomLeftCorner = point.x == 0 && point.y == BOARDHEIGHT - 1;
        boolean bottomRightCorner = point.x == BOARDWIDTH - 1 && point.y == BOARDHEIGHT - 1;

        return topLeftCorner || topRightCorner || bottomLeftCorner || bottomRightCorner;
    }

    private Point getRandomPoint() {
        int x = Utils.randomNumber(0, BOARDWIDTH - 1);
        int y = Utils.randomNumber(0, BOARDHEIGHT - 1);

        return new Point(x, y);
    }

    public static void loadAbilities(String filePath) throws Exception {
        ArrayList<String[]> fileRows = Utils.loadCsvFile(filePath);

        for (String[] row : fileRows) {
            availableAbilities.add(Ability.fromCsvRow(row));
        }
    }

    public static void loadChampions(String filePath) {
        // TODO: Load champions from CSV
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public boolean isFirstLeaderAbilityUsed() {
        return firstLeaderAbilityUsed;
    }

    public boolean isSecondLeaderAbilityUsed() {
        return secondLeaderAbilityUsed;
    }

    public Object[][] getBoard() {
        return board;
    }

    public static ArrayList<Champion> getAvailableChampions() {
        return availableChampions;
    }

    public static ArrayList<Ability> getAvailableAbilities() {
        return availableAbilities;
    }

    public PriorityQueue getTurnOrder() {
        return turnOrder;
    }
}
