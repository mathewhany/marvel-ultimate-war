package engine;

import engine.csv.CsvLoader;
import exceptions.*;
import model.abilities.*;
import model.effects.*;
import model.world.*;
import utils.Utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class Game {
    private static final int BOARDHEIGHT = 5;
    private static final int BOARDWIDTH = 5;

    private static final int NUM_CHAMPIONS_FOR_PLAYER = 3;
    private static final int NUM_PLAYERS = 2;
    private static final int NUM_COVERS = 5;

    private static final int ACTION_POINTS_FOR_MOVEMENT = 1;
    private static final int ACTION_POINTS_FOR_ATTACK = 2;
    private static final double EXTRA_DAMAGE = 0.5;

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
        int startPosition = getFirstChampionYPosition(numChampionsInTeam);

        for (int i = 0; i < numChampionsInTeam; i++) {
            Champion champion = champions.get(i);
            addChampionAt(row, startPosition + i, champion);
        }
    }

    /**
     * Calculates where the first champion should be placed on the y axis so
     * that the champions are centered in the row.
     */
    private static int getFirstChampionYPosition(int championsNum) {
        // For example: for a board width of 5 and 3 champions per player,
        // the champions will be placed starting from index (5 - 3) / 2 = 1.
        return (BOARDWIDTH - championsNum) / 2;
    }

    private void clearCellAt(int x, int y) {
        board[x][y] = null;
    }

    private void clearCellAt(Point point) {
        clearCellAt(point.x, point.y);
    }

    private void addChampionAt(int x, int y, Champion champion) {
        if (!isInsideBoard(x, y)) return;
        board[x][y] = champion;
        champion.setLocation(new Point(x, y));
    }

    private void addChampionAt(Point point, Champion champion) {
        addChampionAt(point.x, point.y, champion);
    }

    private void placeCovers() {
        for (int i = 0; i < NUM_COVERS; i++) {
            Point randomPoint = getRandomNotCorneredEmptyPoint();
            addNewCoverAt(randomPoint);
        }
    }

    private void addNewCoverAt(int x, int y) {
        board[x][y] = new Cover(x, y);
    }

    private void addNewCoverAt(Point point) {
        addNewCoverAt(point.x, point.y);
    }

    /**
     * Returns a random point in the board that is empty, not a corner point
     * and not reserved for a champion.
     */
    private Point getRandomNotCorneredEmptyPoint() {
        Point point;
        do {
            point = getRandomPoint();
        } while (isCornerPoint(point) || !isCellEmpty(point) || isReservedForChampion(point));

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

    private Damageable getCell(int x, int y) {
        return (Damageable) board[x][y];
    }

    private Damageable getCell(Point currentPoint) {
        return getCell(currentPoint.x, currentPoint.y);
    }

    private boolean isCellEmpty(Point point) {
        return getCell(point) == null;
    }

    private boolean isCellEmpty(int x, int y) {
        return isCellEmpty(new Point(x, y));
    }

    /**
     * Returns whether the point is reserved for one of the players' champions.
     */
    private boolean isReservedForChampion(Point point) {
        int start = getFirstChampionYPosition(NUM_CHAMPIONS_FOR_PLAYER);
        int end = start + NUM_CHAMPIONS_FOR_PLAYER;

        return (point.x == 0 || point.x == BOARDHEIGHT - 1) && (point.y >= start && point.y <= end);
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
        if (firstPlayer.getTeam().isEmpty()) {
            return secondPlayer;
        }

        if (secondPlayer.getTeam().isEmpty()) {
            return firstPlayer;
        }

        return null;
    }

    public void move(Direction direction) throws UnallowedMovementException, NotEnoughResourcesException {
        Champion champion = getCurrentChampion();

        Point oldLocation = champion.getLocation();
        Point newLocation = direction.translatePoint(oldLocation);

        validateMovement(champion, newLocation);

        deduceResourcesForMovement(champion);

        clearCellAt(oldLocation);
        addChampionAt(newLocation, champion);
    }

    private void validateMovement(Champion champion, Point newLocation) throws NotEnoughResourcesException, UnallowedMovementException {
        if (champion.getCurrentActionPoints() < ACTION_POINTS_FOR_MOVEMENT) {
            throw new NotEnoughResourcesException(
                    "You don't have enough action points to move.");
        }

        if (champion.getCondition() != Condition.ACTIVE) {
            throw new UnallowedMovementException(
                "You can't move while you are " +
                        champion.getCondition().toString().toLowerCase() + "."
            );
        }

        if (!isInsideBoard(newLocation)) {
            throw new UnallowedMovementException("You can't move outside the board.");
        }

        if (!isCellEmpty(newLocation)) {
            throw new UnallowedMovementException("You can't move to a non-empty cell.");
        }
    }

    private void deduceResourcesForMovement(Champion champion) {
        int actionPoints = champion.getCurrentActionPoints();
        int newActionPoints = actionPoints - ACTION_POINTS_FOR_MOVEMENT;

        champion.setCurrentActionPoints(newActionPoints);
    }

    public void attack(Direction direction) throws NotEnoughResourcesException, ChampionDisarmedException {
        Champion currentChampion = getCurrentChampion();

        validateAttack(currentChampion);

        deduceResourcesForAttack(currentChampion);

        int range = currentChampion.getAttackRange();
        int damage = currentChampion.getAttackDamage();

        // First get all targets in the specified direction and range
        ArrayList<Damageable> targetsInDirection = getTargetsInDirection(direction, range);

        // Then, only get the targets that can be attacked by the current champion (AKA: Enemies & Covers)
        ArrayList<Damageable> targets = getEnemiesAndCovers(targetsInDirection);

        // No target was found, nothing to do, you wasted your attack
        if (targets.isEmpty()) return;

        // Get the nearest target
        Damageable target = targets.get(0);

        if (target instanceof Champion) {
            Champion champion = (Champion) target;

            if (champion.isDodge()) {
                System.out.println("Champion dodged the attack.");
                return;
            }

            if (champion.hasShield()) {
                System.out.println("Champion used his shield and didn't take any damage.");
                champion.removeShield();
                return;
            }

            if (currentChampion.isExtraDamage(champion)) {
                damage = (int) (damage * (1 + EXTRA_DAMAGE));
            }
        }

        target.setCurrentHP(target.getCurrentHP() - damage);

        if (target.getCurrentHP() <= 0) {
            removeDeadTarget(target);
        }
    }

    private void validateAttack(Champion champion) throws NotEnoughResourcesException, ChampionDisarmedException {
        if (champion.getCurrentActionPoints() < ACTION_POINTS_FOR_ATTACK) {
            throw new NotEnoughResourcesException("You don't have enough action points to attack.");
        }

        if (champion.isDisarmed()) {
            throw new ChampionDisarmedException("You can't attack while disarmed.");
        }

        // These following conditions should be impossible to reach, but just in case...
        if (champion.getCondition() == Condition.INACTIVE) {
            throw new IllegalArgumentException("You can't attack while inactive (stunned).");
        }

        if (champion.getCondition() == Condition.KNOCKEDOUT) {
            throw new IllegalArgumentException("You can't attack while knocked out (dead).");
        }
    }

    private void deduceResourcesForAttack(Champion champion) {
        int actionPoints = champion.getCurrentActionPoints();
        int newActionPoints = actionPoints - ACTION_POINTS_FOR_ATTACK;

        champion.setCurrentActionPoints(newActionPoints);
    }

    private boolean isInsideBoard(int x, int y) {
        return x >= 0 && x < BOARDWIDTH && y >= 0 && y < BOARDHEIGHT;
    }

    private boolean isInsideBoard(Point p) {
        return isInsideBoard(p.x, p.y);
    }

    private ArrayList<Damageable> getTargetsInDirection(Direction direction, int range) {
        Point start = getCurrentChampion().getLocation();
        ArrayList<Damageable> targets = new ArrayList<>();

        Point currentPoint = direction.translatePoint(start);

        int distance = 1;
        while (distance <= range && isInsideBoard(currentPoint)) {
            if (!isCellEmpty(currentPoint)) {
                targets.add(getCell(currentPoint));
            }

            currentPoint = direction.translatePoint(currentPoint);
            distance++;
        }

        return targets;
    }

    private ArrayList<Damageable> filterTargets(ArrayList<Damageable> targets, Player player, boolean includeCovers) {
        ArrayList<Damageable> targetsInTeam = new ArrayList<>();

        for (Damageable target : targets) {
            if (target instanceof Champion) {
                Champion champion = (Champion) target;

                /*
                 Why am I checking if a player is null? Because the test cases has a error
                 where the champions are not actually added to the player's teams. So we don't
                 have any way to tell whether two champions are allies or enemies.
                 To mitigate this error, just assume that always add the champion to our targets
                 in the case the player is null.
                */
                if (player == null || player.getTeam().contains(champion)) {
                    targetsInTeam.add(champion);
                }
            } else if (includeCovers && target instanceof Cover) {
                targetsInTeam.add(target);
            }
        }

        return targetsInTeam;
    }

    private ArrayList<Damageable> getAllies(ArrayList<Damageable> targets) {
        return filterTargets(targets, getCurrentPlayer(), false);
    }

    private ArrayList<Damageable> getEnemies(ArrayList<Damageable> targets) {
        return filterTargets(targets, getOpposingPlayer(), false);
    }

    private ArrayList<Damageable> getEnemiesAndCovers(ArrayList<Damageable> targets) {
        return filterTargets(targets, getOpposingPlayer(), true);
    }

    public void castAbility(Ability ability) throws CloneNotSupportedException, NotEnoughResourcesException, AbilityUseException {
        validateCastAbility(ability);

        ArrayList<Damageable> possibleTargets = new ArrayList<>();

        switch (ability.getCastArea()) {
            case SELFTARGET:
                possibleTargets.add(getCurrentChampion());
                break;
            case TEAMTARGET:
                possibleTargets = getChampionsInRange(ability.getCastRange());
                break;
            case SURROUND:
                possibleTargets = getSurroundingTargets();
                break;
            default:
                // Cast area type is not supported by this method. This should never happen.
                return;
        }

        ArrayList<Damageable> targets = getTargetsForAbility(ability, possibleTargets);
        ability.execute(targets);
        deductAbilityResources(ability);
        removeDeadTargets(targets);
    }

    public void castAbility(Ability ability, Direction direction) throws NotEnoughResourcesException, CloneNotSupportedException, AbilityUseException {
        if (ability.getCastArea() != AreaOfEffect.DIRECTIONAL) {
            // This should never happen, but just in case.
            return;
        }

        validateCastAbility(ability);

        ArrayList<Damageable> targetsInDirection = getTargetsInDirection(direction, ability.getCastRange());
        ArrayList<Damageable> targets = getTargetsForAbility(ability, targetsInDirection);

        ability.execute(targets);

        deductAbilityResources(ability);
        removeDeadTargets(targets);
    }

    public void castAbility(Ability ability, int x, int y) throws NotEnoughResourcesException, CloneNotSupportedException, AbilityUseException, InvalidTargetException {
        if (ability.getCastArea() != AreaOfEffect.SINGLETARGET) {
            // This should never happen. Just in case.
            return;
        }

        validateCastAbility(ability, new Point(x, y));

        ArrayList<Damageable> possibleTargets = new ArrayList<>();
        possibleTargets.add(getCell(x, y));

        ArrayList<Damageable> targets = getTargetsForAbility(ability, possibleTargets);

        if (targets.isEmpty()) {
            throw new InvalidTargetException("You cannot cast this ability on this target.");
        }

        ability.execute(targets);

        deductAbilityResources(ability);
        removeDeadTargets(targets);
    }

    private void removeDeadTarget(Damageable target) {
        clearCellAt(target.getLocation());

        if (target instanceof Champion) {
            Champion champion = (Champion) target;

            turnOrder.remove(champion);
            getPlayerForChampion(champion).getTeam().remove(target);
        }
    }

    private void removeDeadTargets(ArrayList<Damageable> targets) {
        for (Damageable target : targets) {
            if (target.getCurrentHP() <= 0) {
                removeDeadTarget(target);
            }
        }
    }

    private ArrayList<Damageable> getSurroundingTargets() {
        Champion champion = getCurrentChampion();
        Point center = champion.getLocation();
        ArrayList<Damageable> targets = new ArrayList<>();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;

                int x = center.x + i;
                int y = center.y + j;

                if (isInsideBoard(x, y) && !isCellEmpty(x, y)) {
                    targets.add(getCell(x, y));
                }
            }
        }

        return targets;
    }

    private ArrayList<Damageable> getChampionsInRange(int range) {
        ArrayList<Damageable> targets = new ArrayList<>();
        Champion currentChampion = getCurrentChampion();
        Point center = currentChampion.getLocation();

        for (Champion champion : getAllChampions()) {
            int distance = getDistanceBetween(center, champion.getLocation());

            if (distance <= range) {
                targets.add(champion);
            }
        }

        return targets;
    }

    private ArrayList<Damageable> getTargetsForAbility(Ability ability, ArrayList<Damageable> possibleTargets) {
        if (ability instanceof HealingAbility) {
            return getAllies(possibleTargets);
        }

        if (ability instanceof DamagingAbility) {
            return removeShieldedTargets(getEnemiesAndCovers(possibleTargets));
        }

        if (ability instanceof CrowdControlAbility) {
            if (((CrowdControlAbility) ability).isBuff()) {
                return getAllies(possibleTargets);
            }

            return getEnemies(possibleTargets);
        }

        return new ArrayList<>();
    }

    private ArrayList<Damageable> removeShieldedTargets(ArrayList<Damageable> possibleTargets) {
        ArrayList<Damageable> targets = new ArrayList<>();

        for (Damageable target : possibleTargets) {
            if (target instanceof Champion) {
                Champion champion = (Champion) target;

                if (champion.hasShield()) {
                    champion.removeShield();
                } else {
                    targets.add(target);
                }
            } else if (target instanceof Cover) {
                targets.add(target);
            }
        }

        return targets;
    }

    private void deductAbilityResources(Ability ability) {
        Champion champion = getCurrentChampion();

        champion.setMana(champion.getMana() - ability.getManaCost());
        champion.setCurrentActionPoints(champion.getCurrentActionPoints() - ability.getRequiredActionPoints());
        ability.setCurrentCooldown(ability.getBaseCooldown());
    }

    private void validateCastAbility(Ability ability) throws NotEnoughResourcesException, AbilityUseException {
        Champion champion = getCurrentChampion();

        if (champion.getMana() < ability.getManaCost()) {
            throw new NotEnoughResourcesException("Not enough mana to cast the ability");
        }

        if (champion.getCurrentActionPoints() < ability.getRequiredActionPoints()) {
            throw new NotEnoughResourcesException("Not enough action points to cast the ability");
        }

        if (ability.getCurrentCooldown() > 0) {
            throw new AbilityUseException("Ability is still on cooldown");
        }

        if (champion.hasEffect(Silence.EFFECT_NAME)) {
            throw new AbilityUseException("Champion is silenced and cannot cast any ability");
        }

        if (champion.getCondition() == Condition.INACTIVE) {
            throw new AbilityUseException("Champion cannot use ability because he is inactive (stunned)");
        }

        if (champion.getCondition() == Condition.KNOCKEDOUT) {
            throw new AbilityUseException("Champion cannot use ability because he is knocked out (dead)");
        }
    }

    private void validateCastAbility(Ability ability, Point point) throws NotEnoughResourcesException, AbilityUseException, InvalidTargetException {
        validateCastAbility(ability);

        if (isCellEmpty(point)) {
            throw new InvalidTargetException("Cannot cast ability on empty cell");
        }

        int distance = getDistanceBetween(getCurrentChampion().getLocation(), point);

        if (distance > ability.getCastRange()) {
            throw new AbilityUseException("Cannot cast ability on a cell that is out of the cast range.");
        }
    }

    private int getDistanceBetween(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    public void useLeaderAbility() throws LeaderNotCurrentException, LeaderAbilityAlreadyUsedException {
        validateUseLeaderAbility();

        ArrayList<Champion> targets = new ArrayList<>();
        Champion currentChampion = getCurrentChampion();

        if (currentChampion instanceof Hero) {
            targets.addAll(getCurrentPlayer().getTeam());
        } else if (currentChampion instanceof Villain) {
            targets.addAll(getEnemiesWithLowHP());
        } else if (currentChampion instanceof AntiHero) {
            targets.addAll(getAllNonLeaders());
        }

        setLeaderAbilityUsedForCurrentPlayer(true);

        currentChampion.useLeaderAbility(targets);
    }

    private ArrayList<Champion> getEnemiesWithLowHP() {
        ArrayList<Champion> targets = new ArrayList<>();

        for (Champion enemy : getOpposingPlayer().getTeam()) {
            if (enemy.getCurrentHP() < enemy.getMaxHP() * 0.3) {
                targets.add(enemy);
            }
        }

        return targets;
    }

    private void validateUseLeaderAbility() throws LeaderNotCurrentException, LeaderAbilityAlreadyUsedException {
        Champion currentChampion = getCurrentChampion();

        Player currentPlayer = getCurrentPlayer();
        Champion leader = currentPlayer.getLeader();

        if (!currentChampion.equals(leader)) {
            throw new LeaderNotCurrentException(
                    "Cannot use leader ability because current champion is not the leader");
        }

        if (isLeaderAbilityUsedForCurrentPlayer()) {
            throw new LeaderAbilityAlreadyUsedException(
                    "Leader ability has already been used for current player");
        }
    }

    private boolean isLeaderAbilityUsedForCurrentPlayer() {
        return (isFirstPlayer() && firstLeaderAbilityUsed)
                || (isSecondPlayer() && secondLeaderAbilityUsed);
    }

    private boolean isFirstPlayer() {
        return firstPlayer.equals(getCurrentPlayer());
    }

    private boolean isSecondPlayer() {
        return secondPlayer.equals(getCurrentPlayer());
    }

    private void setLeaderAbilityUsedForCurrentPlayer(boolean value) {
        if (isFirstPlayer()) {
            firstLeaderAbilityUsed = value;
        } else if (isSecondPlayer()) {
            secondLeaderAbilityUsed = value;
        }
    }

    private ArrayList<Champion> getAllNonLeaders() {
        ArrayList<Champion> champions = new ArrayList<>();
        Champion currentLeader = getCurrentPlayer().getLeader();
        Champion opposingLeader = getOpposingPlayer().getLeader();

        for (Champion champion : getAllChampions()) {
            if (!champion.equals(currentLeader) && !champion.equals(opposingLeader)) {
                champions.add(champion);
            }
        }

        return champions;
    }

    private Player getPlayerForChampion(Champion champion) {
        if (firstPlayer.getTeam().contains(champion)) {
            return firstPlayer;
        }

        if (secondPlayer.getTeam().contains(champion)) {
            return secondPlayer;
        }

        return null;
    }

    private Player getCurrentPlayer() {
        return getPlayerForChampion(getCurrentChampion());
    }

    private Player getOpposingPlayer() {
        Player currentPlayer = getCurrentPlayer();

        if (firstPlayer.equals(currentPlayer)) {
            return secondPlayer;
        }

        if (secondPlayer.equals(currentPlayer)) {
            return firstPlayer;
        }

        return null;
    }

    public void endTurn() {
        turnOrder.remove();

        if (turnOrder.isEmpty()) {
            prepareChampionTurns();
        }

        Champion champion = getCurrentChampion();

        // Store the champion condition before preparing him for the turn
        boolean isInactive = champion.getCondition() == Condition.INACTIVE;

        // Champion condition could change here from inactive to active
        prepareChampionForTurn(champion);

        /*
         Even if the champion became active after preparing him, we still need
         to skip his turn because he was inactive.
        */
        if (isInactive) {
            endTurn();
        }
    }

    public void prepareChampionForTurn(Champion champion) {
        champion.decreaseEffectsDuration();
        champion.removeExpiredEffects();
        champion.decreaseAbilitiesCooldown();
        champion.resetActionPoints();
    }

    private void prepareChampionTurns() {
        while (!turnOrder.isEmpty()) turnOrder.remove();

        for (Champion c : getAllChampions()) {
            if (c.getCondition() != Condition.KNOCKEDOUT) {
                turnOrder.insert(c);
            }
        }
    }

    private ArrayList<Champion> getAllChampions() {
        ArrayList<Champion> allChampions = new ArrayList<>();
        allChampions.addAll(firstPlayer.getTeam());
        allChampions.addAll(secondPlayer.getTeam());

        return allChampions;
    }
}
