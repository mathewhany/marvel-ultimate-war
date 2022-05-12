package engine;

import engine.csv.CsvLoader;
import exceptions.ChampionDisarmedException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.Ability;
import model.effects.Disarm;
import model.effects.Dodge;
import model.effects.Effect;
import model.effects.Shield;
import model.world.*;
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

        this.prepareChampionTurns();

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

    public Champion getCurrentChampion() {
        return (Champion) turnOrder.peekMin();
    }

    public Player checkGameOver() {
        return null;
    }

    public void move(Direction d) throws UnallowedMovementException, NotEnoughResourcesException {
        Champion champion = getCurrentChampion();

        if (champion.getCurrentActionPoints() < 1) {
            throw new NotEnoughResourcesException();
        }

        if (champion.getCondition() == Condition.ACTIVE) {
            champion.setCurrentActionPoints(champion.getCurrentActionPoints() - 1);
            Point oldLocation = champion.getLocation();
            Point newLocation = null;

            if (d == Direction.UP && oldLocation.y != BOARDHEIGHT - 1) {
                newLocation = new Point(oldLocation.x, oldLocation.y + 1);
            } else if (d == Direction.DOWN && oldLocation.y != 0) {
                newLocation = new Point(oldLocation.x, oldLocation.y - 1);
            } else if (d == Direction.RIGHT && oldLocation.x != BOARDWIDTH - 1) {
                newLocation = new Point(oldLocation.x + 1, oldLocation.y);
            } else if (d == Direction.LEFT && oldLocation.x != 0) {
                newLocation = new Point(oldLocation.x - 1, oldLocation.y);
            }

            if (newLocation != null && isTileEmpty(newLocation)) {
                champion.setLocation(newLocation);
            } else {
                throw new UnallowedMovementException();
            }
        } else {
            throw new UnallowedMovementException();
        }
    }

    public void attack(Direction d) throws NotEnoughResourcesException, ChampionDisarmedException {
        Champion champion = getCurrentChampion();
        int damage = champion.getAttackDamage();

        if (champion.getCurrentActionPoints() < 2) {
            throw new NotEnoughResourcesException();
        }

        if (champion.hasEffect(Disarm.EFFECT_NAME)) {
            throw new ChampionDisarmedException();
        }

        if (champion.getCondition() == Condition.INACTIVE || champion.getCondition() == Condition.KNOCKEDOUT) {
            // TODO: Handle Stun, maybe throw an exception
        }

        Point location = champion.getLocation();
        int range = champion.getAttackRange();

        int dx = 0;
        int dy = 0;

        if (d == Direction.UP) {
            dy = 1;
        } else if (d == Direction.DOWN) {
            dy = -1;
        } else if (d == Direction.RIGHT) {
            dx = 1;
        } else if (d == Direction.LEFT) {
            dx = -1;
        }

        int x = location.x + dx;
        int y = location.y + dy;
        int i = 1;

        while (i <= range && isInsideBoard(x, y)) {
            if (!isTileEmpty(new Point(x, y))) {
                Damageable damageable = (Damageable) board[y][x];
                boolean shouldDamage = true;

                if (damageable instanceof Champion) {
                    Champion target = (Champion) damageable;

                    if (isInSameTeam(champion, target)) {
                        shouldDamage = false;
                        System.out.println("Same team");
                    } else {

                        if (target.hasEffect(Dodge.EFFECT_NAME)) {
                            shouldDamage = Utils.getRandomBoolean();
                        }

                        if (target.hasEffect(Shield.EFFECT_NAME)) {
                            shouldDamage = false;
                            Shield shield = (Shield) target.getLatestEffect(Shield.EFFECT_NAME);
                            shield.remove(target);
                            target.getAppliedEffects().remove(shield);
                        }

                        System.out.println("Outside");
                        if (isExtraDamage(champion, target)) {
                            System.out.println("Extra");
                            damage = (int) (damage * 1.5);
                        }
                    }
                }

                if (shouldDamage) {
                    int currentHP = damageable.getCurrentHP();
                    int newHP = currentHP - damage;
                    damageable.setCurrentHP(newHP);
                    champion.setCurrentActionPoints(champion.getCurrentActionPoints() - 2);
                    break;
                }
            }
            x += dx;
            y += dy;
        }
    }

    private boolean isExtraDamage(Champion c1, Champion c2) {
        boolean hero = c1 instanceof Hero && c2 instanceof Villain;
        boolean villain = c1 instanceof Villain && c2 instanceof Hero;
        boolean antiHero = c1 instanceof AntiHero && !(c2 instanceof AntiHero);

        return hero || villain || antiHero;
    }

    private boolean isInSameTeam(Champion c1, Champion c2) {
        boolean inFirstTeam = firstPlayer.getTeam().contains(c1) && firstPlayer.getTeam().contains(c2);
        boolean inSecondTeam = secondPlayer.getTeam().contains(c1) && secondPlayer.getTeam().contains(c2);

        return inFirstTeam || inSecondTeam;
    }

    private boolean isInsideBoard(int x, int y) {
        return x >= 0 && x < BOARDWIDTH && y >= 0 && y < BOARDHEIGHT;
    }

    public void castAbility(Ability a) {

    }

    public void castAbility(Ability a, Direction d) {}

    public void castAbility(Ability a, int x, int y) {}

    public void useLeaderAbility() {}

    public void endTurn() {
        turnOrder.remove();
    }

    private void prepareChampionTurns() {
        // TODO: Clear turnOrder

        ArrayList<Champion> allChampions = new ArrayList<>();
        allChampions.addAll(firstPlayer.getTeam());
        allChampions.addAll(secondPlayer.getTeam());

        for (Champion c : allChampions) {
            if (c.getCondition() != Condition.KNOCKEDOUT) {
                turnOrder.insert(c);
            }
        }
    }
}
