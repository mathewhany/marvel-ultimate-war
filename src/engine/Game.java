package engine;

import engine.csv.CsvLoader;
import exceptions.*;
import model.abilities.*;
import model.effects.*;
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

    private boolean isCellEmpty(Point point) {
        return board[point.x][point.y] == null;
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
        if (firstPlayer.getTeam().size() == 0) {
            return secondPlayer;
        } else if (secondPlayer.getTeam().size() == 0) {
            return firstPlayer;
        } else {
            return null;
        }
    }

    public void move(Direction d) throws UnallowedMovementException, NotEnoughResourcesException {
        Champion champion = getCurrentChampion();

        if (champion.getCurrentActionPoints() < 1) {
            throw new NotEnoughResourcesException();
        }

        if (champion.getCondition() != Condition.ACTIVE) {
            throw new UnallowedMovementException();
        }

        champion.setCurrentActionPoints(champion.getCurrentActionPoints() - 1);

        Point directionVector = d.toVector();

        int dx = directionVector.x;
        int dy = directionVector.y;

        Point oldLocation = champion.getLocation();
        int x = oldLocation.x + dx;
        int y = oldLocation.y + dy;
        Point newLocation = new Point(x, y);

        if (isInsideBoard(x, y) && isCellEmpty(newLocation)) {
            clearCellAt(oldLocation);
            addChampionAt(newLocation, champion);
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

        champion.setCurrentActionPoints(champion.getCurrentActionPoints() - 2);

        Point location = champion.getLocation();
        int range = champion.getAttackRange();

        ArrayList<Damageable> possibleTargets = getTargetsInDirection(d, location, range);
        ArrayList<Damageable> enemiesAndCovers = getEnemiesAndCovers(possibleTargets);

        if (!enemiesAndCovers.isEmpty()) {
            Damageable damageable = enemiesAndCovers.get(0);
            Point targetLocation = getLocationOf(damageable);
            boolean shouldDamage = true;

            if (damageable instanceof Champion) {
                Champion target = (Champion) damageable;

                if (isInSameTeam(champion, target)) {
                    shouldDamage = false;
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

                    if (isExtraDamage(champion, target)) {
                        damage = (int) (damage * 1.5);
                    }
                }
            }

            if (shouldDamage) {
                int currentHP = damageable.getCurrentHP();
                int newHP = currentHP - damage;
                damageable.setCurrentHP(newHP);
                ArrayList<Damageable> targets = new ArrayList<>();
                targets.add(damageable);
                removeDeadTargets(targets);
            }
        }
    }

    public static boolean isExtraDamage(Champion c1, Champion c2) {
        boolean hero = c1 instanceof Hero && !(c2 instanceof Hero);
        boolean villain = c1 instanceof Villain && !(c2 instanceof Villain);
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

    private ArrayList<Damageable> getTargetsInDirection(Direction d, Point location, int range) {
        ArrayList<Damageable> targets = new ArrayList<>();

        Point directionVector = d.toVector();

        int dx = directionVector.x;
        int dy = directionVector.y;

        int x = location.x + dx;
        int y = location.y + dy;
        int i = 1;

        while (i <= range && isInsideBoard(x, y)) {
            if (!isCellEmpty(x, y)) {
                Damageable target = (Damageable) board[x][y];
                targets.add(target);
            }
            x += dx;
            y += dy;
            i++;
        }

        return targets;
    }

    private boolean isCellEmpty(int x, int y) {
        return isCellEmpty(new Point(x, y));
    }

    private Point getLocationOf(Damageable damageable) {
        if (damageable instanceof Cover) {
            Cover cover = (Cover) damageable;
            return cover.getLocation();
        } else if (damageable instanceof Champion) {
            Champion champion = (Champion) damageable;
            return champion.getLocation();
        } else {
            return null;
        }
    }

    private ArrayList<Damageable> getAllies(ArrayList<Damageable> targets) {
        ArrayList<Damageable> allies = new ArrayList<>();
        Champion currentChampion = getCurrentChampion();
        for (Damageable target : targets) {
            if (target instanceof Champion) {
                Champion targetChampion = (Champion) target;

                if (isInSameTeam(currentChampion, targetChampion)) {
                    allies.add(targetChampion);
                }
            }
        }

        return allies;
    }
    private ArrayList<Damageable> getEnemies(ArrayList<Damageable> targets) {
        ArrayList<Damageable> enemies = new ArrayList<>();
        Champion currentChampion = getCurrentChampion();
        for (Damageable target : targets) {
            if (target instanceof Champion) {
                Champion targetChampion = (Champion) target;

                if (!isInSameTeam(currentChampion, targetChampion)) {
                    enemies.add(targetChampion);
                }
            }
        }

        return enemies;
    }
    private ArrayList<Damageable> getEnemiesAndCovers(ArrayList<Damageable> targets) {
        ArrayList<Damageable> enemiesAndCovers = new ArrayList<>();
        Champion currentChampion = getCurrentChampion();
        for (Damageable target : targets) {
            if (target instanceof Champion) {
                Champion targetChampion = (Champion) target;

                if (!isInSameTeam(currentChampion, targetChampion)) {
                    enemiesAndCovers.add(targetChampion);
                }
            } else if (target instanceof Cover) {
                enemiesAndCovers.add(target);
            }
        }

        return enemiesAndCovers;
    }


    public void castAbility(Ability a) throws CloneNotSupportedException, NotEnoughResourcesException, AbilityUseException {
        ensureAbilityCanBeCasted(a);

        Champion champion = getCurrentChampion();
        Point championLocation = champion.getLocation();

        ArrayList<Damageable> targets = new ArrayList<>();
        ArrayList<Damageable> possibleTargets = new ArrayList<>();

        switch (a.getCastArea()) {
            case SELFTARGET:
                targets.add(champion);
                break;
            case TEAMTARGET:
                int range = a.getCastRange();
                possibleTargets = getTargetsInCircle(championLocation, range);
                break;
            case SURROUND:
                possibleTargets = getSurroundingTargets(championLocation);
                break;
        }


        targets.addAll(getTargetsForAbility(a, possibleTargets));

        a.execute(targets);

        removeDeadTargets(targets);
        deductAbilityResources(a);
    }

    private void removeDeadTargets(ArrayList<Damageable> targets) {
        for (Damageable target : targets) {
            if (target.getCurrentHP() == 0) {
                clearCellAt(target.getLocation());

                if (target instanceof Champion) {
                    turnOrder.remove(target);
                    firstPlayer.getTeam().remove(target);
                    secondPlayer.getTeam().remove(target);
                }
            }
        }
    }

    private ArrayList<Damageable> getSurroundingTargets(Point center) {
        ArrayList<Damageable> targets = new ArrayList<>();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;

                int x = center.x + i;
                int y = center.y + j;

                if (isInsideBoard(x, y) && !isCellEmpty(x, y)) {
                    Damageable target = (Damageable) board[x][y];
                    targets.add(target);
                }
            }
        }

        return targets;
    }

    private ArrayList<Damageable> getTargetsInCircle(Point center, int radius) {
        ArrayList<Damageable> targets = new ArrayList<>();

        for (Champion champion : getAllChampions()) {
            int distance = getDistanceBetween(center, champion.getLocation());
            if (distance <= radius) {
                targets.add(champion);
            }
        }

        return targets;
    }

    public void castAbility(Ability a, Direction d) throws NotEnoughResourcesException, CloneNotSupportedException, AbilityUseException {
        if (a.getCastArea() != AreaOfEffect.DIRECTIONAL) {
            // TODO: Throw exception
            return;
        }
        ensureAbilityCanBeCasted(a);
        Champion champion = getCurrentChampion();
        Point location = champion.getLocation();

        int range = a.getCastRange();
        ArrayList<Damageable> possibleTargets = getTargetsInDirection(d, location, range);
        ArrayList<Damageable> targets = getTargetsForAbility(a, possibleTargets);

        a.execute(targets);

        removeDeadTargets(targets);
        deductAbilityResources(a);
    }

    private ArrayList<Damageable> getTargetsForAbility(Ability a, ArrayList<Damageable> possibleTargets) {
        ArrayList<Damageable> targets = new ArrayList<>();

        if (a instanceof HealingAbility) {
            targets = getAllies(possibleTargets);
        } else if (a instanceof DamagingAbility) {
            targets = getEnemiesAndCovers(possibleTargets);
        } else if (a instanceof CrowdControlAbility) {
            CrowdControlAbility ccAbility = (CrowdControlAbility) a;
            EffectType type = ccAbility.getEffect().getType();

            if (type == EffectType.BUFF) {
                targets = getAllies(possibleTargets);
            } else if (type == EffectType.DEBUFF) {
                targets = getEnemies(possibleTargets);
            }
        }

        return targets;
    }

    public void castAbility(Ability ability, int x, int y) throws NotEnoughResourcesException, CloneNotSupportedException, AbilityUseException, InvalidTargetException {
        if (ability.getCastArea() != AreaOfEffect.SINGLETARGET) {
            // TODO: Throw exception
            return;
        }

        ensureAbilityCanBeCasted(ability);
        Champion champion = getCurrentChampion();
        int range = ability.getCastRange();
        int distance = getDistanceBetween(champion.getLocation(), new Point(x, y));
        ArrayList<Damageable> possibleTargets = new ArrayList<>();

        if (isCellEmpty(x, y)) {
            throw new InvalidTargetException();
        }

        if (distance <= range) {
            Damageable target = (Damageable) board[x][y];
            possibleTargets.add(target);
        } else {
            throw new AbilityUseException();
        }

        ArrayList<Damageable> targets = getTargetsForAbility(ability, possibleTargets);

        if (targets.isEmpty()) {
            throw new InvalidTargetException();
        }

        ability.execute(targets);

        removeDeadTargets(targets);
        deductAbilityResources(ability);
    }

    private void deductAbilityResources(Ability a) {
        Champion champion = getCurrentChampion();
        int cost = a.getManaCost();
        int mana = champion.getMana();
        int currentActionsPoints = champion.getCurrentActionPoints();
        int requiredActionPoints = a.getRequiredActionPoints();

        champion.setMana(mana - cost);
        champion.setCurrentActionPoints(currentActionsPoints - requiredActionPoints);
        a.setCurrentCooldown(a.getBaseCooldown());
    }

    private void ensureAbilityCanBeCasted(Ability a) throws NotEnoughResourcesException, AbilityUseException {
        Champion champion = getCurrentChampion();
        int cost = a.getManaCost();
        int mana = champion.getMana();
        int coolDown = a.getCurrentCooldown();
        int currentActionsPoints = champion.getCurrentActionPoints();
        int requiredActionPoints = a.getRequiredActionPoints();

        if (mana < cost) {
            throw new NotEnoughResourcesException();
        }

        if (coolDown != 0) {
            throw new AbilityUseException();
        }

        if (currentActionsPoints < requiredActionPoints) {
            throw new NotEnoughResourcesException();
        }

        if (champion.hasEffect(Silence.EFFECT_NAME)) {
            throw new AbilityUseException();
        }
    }

    private int getDistanceBetween(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    public void useLeaderAbility() throws LeaderNotCurrentException, LeaderAbilityAlreadyUsedException {
        Champion currentChampion = getCurrentChampion();
        Player player = getPlayerForChampion(currentChampion);
        Player opposingPlayer = getOpposingPlayer(player);
        Champion leader = player.getLeader();
        Champion opposingLeader = opposingPlayer.getLeader();

        if (!currentChampion.equals(leader)) {
            throw new LeaderNotCurrentException();
        }

        if (firstPlayer.equals(player) && firstLeaderAbilityUsed) {
            throw new LeaderAbilityAlreadyUsedException();
        }

        if (secondPlayer.equals(player) && secondLeaderAbilityUsed) {
            throw new LeaderAbilityAlreadyUsedException();
        }

        ArrayList<Champion> targets = new ArrayList<>();

        if (leader instanceof Hero) {
            targets.addAll(player.getTeam());
        } else if (leader instanceof Villain) {
            for (Champion enemy : opposingPlayer.getTeam()) {
                if (enemy.getCurrentHP() < enemy.getMaxHP() * 0.3) {
                    targets.add(enemy);
                }
            }
        } else if (leader instanceof AntiHero) {
            for (Champion champion : getAllChampions()) {
                if (!champion.equals(leader) && !champion.equals(opposingLeader)) {
                    targets.add(champion);
                }
            }
        }

        if (firstPlayer.equals(player)) {
            firstLeaderAbilityUsed = true;
        } else if (secondPlayer.equals(player)) {
            secondLeaderAbilityUsed = true;
        }

        currentChampion.useLeaderAbility(targets);
    }

    private Player getPlayerForChampion(Champion champion) {
        if (firstPlayer.getTeam().contains(champion)) {
            return firstPlayer;
        } else if (secondPlayer.getTeam().contains(champion)) {
            return secondPlayer;
        } else {
            return null;
        }
    }

    private Player getOpposingPlayer(Player player) {
        if (player.equals(firstPlayer)) {
            return secondPlayer;
        } else if (player.equals(secondPlayer)) {
            return firstPlayer;
        } else {
            return null;
        }
    }

    public void endTurn() {
        turnOrder.remove();

        if (turnOrder.isEmpty()) {
            prepareChampionTurns();
        }

        Champion champion = getCurrentChampion();

        ArrayList<Effect> effectsToBeRemoved = new ArrayList<>();

        for (Effect effect : champion.getAppliedEffects()) {
            effect.setDuration(effect.getDuration() - 1);
            if (effect.getDuration() == 0) {
                effectsToBeRemoved.add(effect);
            }
        }

        for (Effect effect : effectsToBeRemoved) {
            effect.remove(champion);
            champion.getAppliedEffects().remove(effect);
        }

        champion.setCurrentActionPoints(champion.getMaxActionPointsPerTurn());

        for (Ability ability : champion.getAbilities()) {
            ability.setCurrentCooldown(ability.getCurrentCooldown() - 1);
        }

        if (champion.getCondition() == Condition.INACTIVE) {
            endTurn();
        }
    }

    private void prepareChampionTurns() {
        // TODO: Clear turnOrder
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
