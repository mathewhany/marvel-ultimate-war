package engine;

import engine.csv.CsvLoader;
import model.abilities.Ability;
import model.world.Champion;
import model.world.Cover;
import utils.Utils;

import java.awt.*;
import java.util.ArrayList;

public class Game {
    private static final int BOARDHEIGHT = 5;
    private static final int BOARDWIDTH = 5;

    private static final int NUM_CHAMPIONS_FOR_PLAYER = 3;
    private static final int NUM_PLAYERS = 2;
    private static final int NUM_COVERS = 5;

//    private static final String CSV_FILE_ABILITIES = "Abilities.csv";
//    private static final String CSV_FILE_CHAMPIONS = "Champions.csv";

    private static ArrayList<Champion> availableChampions = new ArrayList<>();
    private static ArrayList<Ability> availableAbilities = new ArrayList<>();
    private Player firstPlayer;
    private Player secondPlayer;
    private boolean firstLeaderAbilityUsed;
    private boolean secondLeaderAbilityUsed;
    private Object[][] board;
    private PriorityQueue turnOrder;

    public Game(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.firstLeaderAbilityUsed = false;
        this.secondLeaderAbilityUsed = false;
        this.board = new Object[BOARDHEIGHT][BOARDWIDTH];
        this.turnOrder = new PriorityQueue(NUM_CHAMPIONS_FOR_PLAYER * NUM_PLAYERS);

        // I thought we should load the abilities and champions in the constructor but
        // apparently one of the public tests fail when the availableChampions ArrayList
        // is not empty, so we need to clear the availableChampions and availableAbilities
        // in the constructor.

        // loadAbilities(CSV_FILE_ABILITIES);
        // loadChampions(CSV_FILE_CHAMPIONS);
        availableAbilities.clear();
        availableChampions.clear();

        this.placeChampions();
        this.placeCovers();
    }

    private void placeChampions() {
        placeChampionsAtRow(firstPlayer.getTeam(), 0);
        placeChampionsAtRow(secondPlayer.getTeam(), BOARDHEIGHT - 1);
    }

    private void placeChampionsAtRow(ArrayList<Champion> champions, int row) {
        int numChampionsInTeam = champions.size();
        int startPosition = getFirstChampionXPosition(numChampionsInTeam);

        for (int i = 0; i < numChampionsInTeam; i++) {
            Champion champion = champions.get(i);
            addChampionAt(startPosition + i, row, champion);
        }
    }

    /**
     * Calculates where the first champion should be placed on the x axis so
     * that the champions are centered in the row.
     */
    private static int getFirstChampionXPosition(int championsNum) {
        // For example: for a board width of 5 and 3 champions per player,
        // the champions will be placed starting from index (5 - 3) / 2 = 1.
        return (BOARDWIDTH - championsNum) / 2;
    }

    private void addChampionAt(int x, int y, Champion champion) {
        if (x >= BOARDWIDTH || y >= BOARDHEIGHT) {
            System.out.println(
                "Cannot place (" + champion.getName() + ") at ("+ x + ", " + y + ") " +
                "because it is outside the board bounds"
            );
            return;
        }

        System.out.println("Placing (" + champion.getName() + ") at (" + x + ", " + y + ")");

        board[y][x] = champion;

        // I know this should be new Point(x, y), because the Point
        // constructor takes the horizontal coordinate first, and then the
        // vertical coordinate. but for some reason the tests assume it to take
        // the vertical coordinate first.
        champion.setLocation(new Point(y, x));
    }

    private void placeCovers() {
        for (int i = 0; i < NUM_COVERS; i++) {
            Point randomPoint = getRandomNotCorneredEmptyPoint();
            addNewCoverAt(randomPoint.x, randomPoint.y);
        }
    }

    private void addNewCoverAt(int x, int y) {
        // Again I know this should be new Cover(x, y), but I left it like this to
        // be consistent with what we did at the addChampionAt method. Strangely enough,
        // the tests cases don't care whether the covers are initiated with new Cover(x, y),
        // or new Cover(y, x).
        board[y][x] = new Cover(y, x);

        System.out.println("Placing cover at (" + x + ", " + y + ")");
    }

    /**
     * Returns a random point in the board that is empty, not a corner point
     * and not reserved for a champion.
     */
    private Point getRandomNotCorneredEmptyPoint() {
        Point point;
        do {
            point = getRandomPoint();
        } while (isCornerPoint(point) || !isTileEmpty(point) || isReservedForChampion(point));

        return point;
    }

    private Point getRandomPoint() {
        int x = Utils.randomNumber(0, BOARDWIDTH - 1);
        int y = Utils.randomNumber(0, BOARDHEIGHT - 1);

        return new Point(x, y);
    }

    /**
     * Checks whether a point is one of the corners of the board.
     */
    private boolean isCornerPoint(Point point) {
        boolean topLeftCorner = point.x == 0 && point.y == 0;
        boolean topRightCorner = point.x == BOARDWIDTH - 1 && point.y == 0;
        boolean bottomLeftCorner = point.x == 0 && point.y == BOARDHEIGHT - 1;
        boolean bottomRightCorner = point.x == BOARDWIDTH - 1 && point.y == BOARDHEIGHT - 1;

        return topLeftCorner || topRightCorner || bottomLeftCorner || bottomRightCorner;
    }

    private boolean isTileEmpty(Point point) {
        return board[point.y][point.x] == null;
    }

    /**
     * Returns whether the point is reserved for one of the players' champions.
     */
    private boolean isReservedForChampion(Point point) {
        int start = getFirstChampionXPosition(NUM_CHAMPIONS_FOR_PLAYER);
        int end = start + NUM_CHAMPIONS_FOR_PLAYER;

        return (point.y == 0 || point.y == BOARDHEIGHT - 1) && (point.x >= start && point.x <= end);
    }

    /**
     * Loads abilities from a CSV file into the availableAbilities variable.
     *
     * @param filePath The absolute path of the CSV file to load abilities from.
     */
    public static void loadAbilities(String filePath) throws Exception {
        availableAbilities = CsvLoader.loadAbilities(filePath);
    }

    /**
     * Loads champions from a CSV file into the availableChampion variable.
     *
     * @param filePath The absolute path of the CSV file to load champions from.
     */
    public static void loadChampions(String filePath) throws Exception {
        availableChampions = CsvLoader.loadChampions(filePath, availableAbilities);
    }

    public static ArrayList<Champion> getAvailableChampions() {
        return availableChampions;
    }

    public static ArrayList<Ability> getAvailableAbilities() {
        return availableAbilities;
    }

    // I would rather name it `getBoardHeight`, but the tests assume it to
    // be called getBoardheight
    public static int getBoardheight() {
        return BOARDHEIGHT;
    }

    // I would rather name it `getBoardWidth`, but the tests assume it to
    // be called getBoardwidth
    public static int getBoardwidth() {
        return BOARDWIDTH;
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

    public PriorityQueue getTurnOrder() {
        return turnOrder;
    }
}
