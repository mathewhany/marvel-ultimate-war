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
    private static final int NUM_COVERS = 5;

//    private static final String CSV_FOLDER = "csv";
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

    public Game(Player firstPlayer, Player secondPlayer) throws Exception {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.firstLeaderAbilityUsed = false;
        this.secondLeaderAbilityUsed = false;
        this.board = new Object[BOARDHEIGHT][BOARDWIDTH];
        this.turnOrder = new PriorityQueue(NUM_CHAMPIONS_FOR_PLAYER * 2);

        // Since availableAbilities and availableChampions are static variables, they must be
        // cleared everytime a new Game is created, so that each Game instance starts clean.
        availableAbilities.clear();
        availableChampions.clear();

        this.placeChampions();
        this.placeCovers();
    }

    private void placeChampions() {
        // If the players haven't chosen their champions yet, there
        // are no champions to place, so just do nothing.
        if (firstPlayer.getTeam().size() < NUM_CHAMPIONS_FOR_PLAYER || secondPlayer.getTeam().size() < NUM_CHAMPIONS_FOR_PLAYER) {
            return;
        }

        int startPosition = getFirstChampionXPosition();

        for (int i = 0; i < NUM_CHAMPIONS_FOR_PLAYER; i++) {
            Champion firstPlayerChampion = firstPlayer.getTeam().get(i);
            Champion secondPlayerChampion = secondPlayer.getTeam().get(i);
            addChampionAt(startPosition + i, 0, firstPlayerChampion);
            addChampionAt(startPosition + i, BOARDHEIGHT - 1, secondPlayerChampion);
        }
    }

    private void placeCovers() {
        for (int i = 0; i < NUM_COVERS; i++) {
            placeCoverAtRandomPoint();
        }
    }

    /**
     * Calculates where the first champion should be placed on the x axis so
     * that the champions are centered in the row.
     */
    private static int getFirstChampionXPosition() {
        // For example: for a board width of 5 and 3 champions per player,
        // the champions will be placed starting from index (5 - 3) / 2 = 1.
        return (BOARDWIDTH - NUM_CHAMPIONS_FOR_PLAYER) / 2;
    }

    private void addChampionAt(int x, int y, Champion champion) {
        board[y][x] = champion;

        // I know this should be new Point(x, y), because the Point
        // constructor takes the horizontal coordinate first, and then the
        // vertical coordinate. but for some reason the tests assume it to take
        // the vertical coordinate first.
        champion.setLocation(new Point(y, x));
    }

    private void placeCoverAtRandomPoint() {
        Point point = getRandomNotCorneredEmptyPoint();
        Cover cover = new Cover(point.x, point.y);
        board[point.y][point.x] = cover;
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
    private static boolean isReservedForChampion(Point point) {
        int start = getFirstChampionXPosition();
        int end = start + NUM_CHAMPIONS_FOR_PLAYER;

        return (point.y == 0 || point.y == BOARDHEIGHT - 1) && (point.x >= start && point.x <= end);
    }

    /**
     * Loads abilities from a CSV file into the availableAbilities variable.
     *
     * @param filePath The absolute path of the CSV file to load abilities from.
     */
    public static void loadAbilities(String filePath) throws Exception {
        CsvLoader.loadAbilities(filePath);
    }

    /**
     * Loads champions from a CSV file into the availableChampion variable.
     *
     * @param filePath The absolute path of the CSV file to load champions from.
     */
    public static void loadChampions(String filePath) throws Exception {
        CsvLoader.loadChampions(filePath);
    }

    /**
     * Search for an ability in the available abilities by name or null
     * if the ability is not found.
     */
    public static Ability getAbilityByName(String name) {
        for (Ability ability : availableAbilities) {
            if (ability.getName().equals(name)) {
                return ability;
            }
        }

        return null;
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

    public static void addAbility(Ability ability) {
        availableAbilities.add(ability);
    }

    public static void addChampion(Champion champion) {
        availableChampions.add(champion);
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
