package views;

import controllers.BaseController;
import engine.Game;
import engine.Player;
import javafx.animation.*;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.abilities.Ability;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.effects.Effect;
import model.world.Champion;
import model.world.Cover;
import model.world.Damageable;
import model.world.Direction;

import java.util.*;
import java.util.stream.Collectors;

public class GameView extends BaseView {
    private Listener listener;
    private ArrayList<String> messages = new ArrayList<>();
    private boolean hasError = false;

    private HashSet<Animation> animations = new HashSet<>();
    private HashMap<Damageable, Pane> damageablePanes = new HashMap<>();
    private HashMap<Champion, Pane> championPanes = new HashMap<>();
    private ScaleTransition currentChampionAnimation;

    public GameView(Listener listener) {
        super();
        this.listener = listener;
    }

    @Override
    public Pane createContent() {
        Pane board = createBoard();
        Pane playersInfo = createPlayersInfoPanel();
        Pane turnOrder = createTurnOrderPanel();
        Pane currentChampion = createCurrentChampionPanel();
        Pane messagePanel = createMessagePanel();
        Pane abilitiesPanel = createAbilitiesPanel();

        VBox leftPane = new VBox(playersInfo, turnOrder);
        leftPane.setId("left-pane");

        VBox centerPane = new VBox(board);
        centerPane.setId("center-pane");

        VBox rightPane1 = new VBox(currentChampion, messagePanel);

        HBox mainContainer = new HBox(leftPane, centerPane, rightPane1, abilitiesPanel);
        mainContainer.setId("game-view");

        return mainContainer;
    }

    public GridPane createBoard() {
        damageablePanes.clear();
        GridPane grid = new GridPane();
        grid.setId("board");

        for (int i = 0; i < Game.getBoardheight(); i++) {
            for (int j = 0; j < Game.getBoardwidth(); j++) {
                final int x = i;
                final int y = j;

                Damageable cell = BaseController.game.getCell(i, j);

                BorderPane championPanel = new BorderPane();
                championPanel.getStyleClass().add("cell");

                championPanel.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                    listener.onChampionClicked(x, y);
                });


                if (cell == null) {
                    championPanel.setCenter(new Text(" "));
                    championPanel.getStyleClass().add("empty");
                } else {
                    damageablePanes.put(cell, championPanel);
                    championPanel.getStyleClass().add("damageable");
                    Pane hpBar = ViewHelper.progressBarWithText("HP", cell.getCurrentHP(), cell.getMaxHP());
                    hpBar.getStyleClass().add("hp-bar");
                    championPanel.setTop(hpBar);

                    if (cell instanceof Champion) {
                        Champion champion = (Champion) cell;

                        Tooltip.install(championPanel, createTooltipForChampion(champion));

                        if (BaseController.firstPlayer == BaseController.game.getPlayerForChampion(champion)) {
                            championPanel.getStyleClass().add("first-player");
                        } else {
                            championPanel.getStyleClass().add("second-player");
                        }

                        if (BaseController.game.getCurrentChampion().equals(champion)) {
                            championPanel.getStyleClass().add("current-champion");

                            currentChampionAnimation = new ScaleTransition(Duration.millis(1000), championPanel);
                            currentChampionAnimation.setToX(1.1);
                            currentChampionAnimation.setToY(1.1);
                            currentChampionAnimation.setCycleCount(Animation.INDEFINITE);
                            currentChampionAnimation.setAutoReverse(true);
                            currentChampionAnimation.setOnFinished(e -> {
                                currentChampionAnimation.playFromStart();
                            });

                            currentChampionAnimation.play();
                        }

                        if (BaseController.firstPlayer.isLeader(champion) || BaseController.secondPlayer.isLeader(champion)) {
                            championPanel.getStyleClass().add("leader");
                        }

                        championPanel.setCenter(ViewHelper.boxWithIcon("/images/icons/" + champion.getName() + ".png", champion.getName()));

                        Pane effectsContainer = createEffectsContainer(champion);

                        championPanel.setBottom(effectsContainer);

                    } else if (cell instanceof Cover) {
                        championPanel.getStyleClass().add("cover");
                    }
                }


                grid.add(championPanel, j, Game.getBoardheight() - i - 1);
            }
        }

        return grid;
    }

    private Pane createPlayersInfoPanel() {
        championPanes.clear();

        Pane firstPlayerPane = createPanelForPlayer(BaseController.firstPlayer);
        Pane secondPlayerPane = createPanelForPlayer(BaseController.secondPlayer);

        Pane playersInfoPanel = new VBox(firstPlayerPane, secondPlayerPane);
        playersInfoPanel.setId("players-info");

        return playersInfoPanel;
    }

    private Pane createTurnOrderPanel() {
        Pane container = new VBox();
        container.setId("turn-order-container");

        for (Champion champion : BaseController.game.getTurnOrder().toArrayList()) {
            ImageView icon = new ImageView("/images/icons/" + champion.getName() + ".png");
            icon.setPreserveRatio(true);
            icon.setFitWidth(50);

            Label name = new Label(champion.getName());

            HBox item = new HBox(icon, name);
            item.getStyleClass().add("turn-order-item");
            container.getChildren().add(item);
        }

        Pane box = ViewHelper.boxWithTitle("Turn Order", container);
        box.getStyleClass().add("turn-order-box");
        return box;
    }

    public Pane createCurrentChampionPanel() {
        Champion champion = BaseController.game.getCurrentChampion();

        Pane nameAndIcon = ViewHelper.boxWithIcon("/images/icons/" + champion.getName() + ".png", champion.getName());

        Pane healthBar = ViewHelper.progressBarWithText("HP", champion.getCurrentHP(), champion.getMaxHP());
        healthBar.getStyleClass().add("hp-bar");

        Pane manaBar = ViewHelper.progressBarWithText("Mana", champion.getMana(), champion.getMaxMana());
        manaBar.getStyleClass().add("mana-bar");

        Pane actionPointsBar = ViewHelper.progressBarWithText("Action Points", champion.getCurrentActionPoints(), champion.getMaxActionPointsPerTurn());
        actionPointsBar.getStyleClass().add("action-points-bar");

        Pane effectsContainer = createEffectsContainer(champion);

        HashMap<String, Object> stats = new LinkedHashMap<>();
        stats.put("Type", champion.getType());
        stats.put("Damage", champion.getAttackDamage());
        stats.put("Range", champion.getAttackRange());
        stats.put("Speed", champion.getSpeed());
        stats.put("Condition", champion.getCondition());
        Pane statsGrid = ViewHelper.statsBox(stats);

        Pane championStats = new VBox(nameAndIcon, healthBar, manaBar, actionPointsBar, effectsContainer, statsGrid);
        championStats.setId("current-champion-stats");

        Pane championBox = ViewHelper.boxWithTitle("Current Champion", championStats);
        championBox.setId("current-champion-box");

        return championBox;
    }

    private Pane createMessagePanel() {
        VBox messagePanel = new VBox();
        messagePanel.setId("messages-panel");

        for (String message : messages) {
            Label label = new Label(message);
            label.setWrapText(true);
            label.getStyleClass().add("message");
            messagePanel.getChildren().add(label);
        }

        return messagePanel;
    }

    public Pane createAbilitiesPanel() {
        Champion champion = BaseController.game.getCurrentChampion();
        VBox abilitiesPanel = new VBox();
        abilitiesPanel.setId("abilities-box");

        int i = 0;
        char[] abilityKeys = {'Q', 'W', 'E', 'T'};
        for (Ability ability : champion.getAbilities()) {
            abilitiesPanel.getChildren().add(createPanelForAbility(ability, abilityKeys[i]));
            i++;
        }
        return abilitiesPanel;
    }

    private Tooltip createTooltipForChampion(Champion champion) {
        Player player = BaseController.game.getPlayerForChampion(champion);

        HashMap<String, Object> properties = new LinkedHashMap<>();
        properties.put("Name", champion.getName());
        properties.put("Type", champion.getType());
        properties.put("Leader", player.isLeader(champion) ? "Yes" : "No");
        properties.put("Current", champion.equals(BaseController.game.getCurrentChampion()) ? "Yes" : "No");
        properties.put("Player", player.getName());
        properties.put("HP", champion.getCurrentHP());
        properties.put("Max HP", champion.getMaxHP());
        properties.put("Mana", champion.getMana());
        properties.put("Action Points", champion.getCurrentActionPoints());
        properties.put("Max Action Points", champion.getMaxActionPointsPerTurn());
        properties.put("Speed", champion.getSpeed());
        properties.put("Damage", champion.getAttackDamage());
        properties.put("Range", champion.getAttackRange());
        properties.put("Abilities", champion.getAbilities().stream().map(Ability::getName).collect(Collectors.joining(", ")));
        properties.put("Effects", champion.getAppliedEffects().stream().map(e -> e.getName() + " (" + e.getDuration() + ")").collect(Collectors.joining(", ")));

        String statsString = "";
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            statsString += entry.getKey() + ": " + entry.getValue() + "\n";
        }

        Tooltip tooltip = new Tooltip();
        tooltip.setShowDelay(Duration.millis(500));
        tooltip.setHideDelay(Duration.millis(500));
        tooltip.setText(statsString);
        return tooltip;
    }

    private Pane createEffectsContainer(Champion champion) {
        Pane effectsContainer = new HBox();
        effectsContainer.getStyleClass().add("effects-container");

        for (Effect effect : champion.getAppliedEffects()) {
            ImageView icon = new ImageView("/images/icons/Ironman.png");
            icon.getStyleClass().add("icon");
            icon.setFitHeight(17);
            icon.setFitWidth(17);

            ProgressIndicator duration = new ProgressIndicator(effect.getDuration() * 1.0 / effect.getStartDuration());
            StackPane effectBox = new StackPane(duration, icon);
            Tooltip tooltip = new Tooltip("Name: " + effect.getName() + "\nDuration: " + effect.getDuration());
            tooltip.setShowDelay(Duration.millis(200));
            Tooltip.install(effectBox, tooltip);

            effectBox.getStyleClass().add("effect");
            effectsContainer.getChildren().add(effectBox);
        }

        return effectsContainer;
    }

    private Pane createPanelForPlayer(Player player) {
        Pane container = new HBox();
        container.getStyleClass().add("champions-container");

        for (Champion champion : player.getTeam()) {
            Pane panel = createChampionItemForPlayerInfo(champion);
            championPanes.put(champion, panel);
            container.getChildren().add(panel);
        }

        Pane panel = ViewHelper.boxWithTitle(player.getName(), container);
        panel.getStyleClass().add("player-info-box");

        if (BaseController.game.getCurrentPlayer().equals(player)) {
            panel.getStyleClass().add("current-player");
        }

        return panel;
    }

    public Pane createPanelForAbility(Ability ability, char key) {
        HashMap<String, Object> abilityDetails = new LinkedHashMap<>();
        abilityDetails.put("Keyboard Shortcut", key);
        abilityDetails.put("Type", ability.getType());

        if (ability instanceof DamagingAbility) {
            abilityDetails.put("Damage", ((DamagingAbility) ability).getDamageAmount());
        } else if (ability instanceof HealingAbility) {
            abilityDetails.put("Heal", ((HealingAbility) ability).getHealAmount());
        } else if (ability instanceof CrowdControlAbility) {
            CrowdControlAbility cc = (CrowdControlAbility) ability;
            abilityDetails.put("Effect", cc.getEffect().getName());
            abilityDetails.put("Effect Type", cc.getEffect().getType());
            abilityDetails.put("Duration", cc.getEffect().getDuration());
        }

        abilityDetails.put("Action Points", ability.getRequiredActionPoints());
        abilityDetails.put("Cast Area", ability.getCastArea());
        abilityDetails.put("Cast Range", ability.getCastRange());
        abilityDetails.put("Mana Cost", ability.getManaCost());

        Pane cooldownProgress = ViewHelper.progressBarWithText("Cooldown", ability.getBaseCooldown() - ability.getCurrentCooldown(), ability.getBaseCooldown());
        cooldownProgress.getStyleClass().add("cooldown-bar");

        Pane abilityStats = ViewHelper.statsBox(abilityDetails);

        Pane abilityStatsContainer = new VBox(cooldownProgress, abilityStats);

        Pane abilityBox = ViewHelper.boxWithTitle(ability.getName(), abilityStatsContainer);

        return abilityBox;
    }

    private Pane createChampionItemForPlayerInfo(Champion champion) {
        Pane nameAndIcon = ViewHelper.boxWithIcon("/images/icons/" + champion.getName() + ".png", champion.getName());

        Pane healthBar = ViewHelper.progressBarWithText("HP", champion.getCurrentHP(), champion.getMaxHP());
        healthBar.getStyleClass().add("hp-bar");

        Pane manaBar = ViewHelper.progressBarWithText("Mana", champion.getMana(), champion.getMaxMana());
        manaBar.getStyleClass().add("mana-bar");

        Pane actionPointsBar = ViewHelper.progressBarWithText("Action Points", champion.getCurrentActionPoints(), champion.getMaxActionPointsPerTurn());
        actionPointsBar.getStyleClass().add("action-points-bar");

        Pane effectsContainer = createEffectsContainer(champion);

        Pane container = new VBox(nameAndIcon, healthBar, manaBar, actionPointsBar, effectsContainer);
        container.getStyleClass().add("champion");

        Tooltip.install(container, createTooltipForChampion(champion));

        if (BaseController.game.getCurrentChampion().equals(champion)) {
            container.getStyleClass().add("current-champion");
        }

        if (BaseController.firstPlayer.isLeader(champion) || BaseController.secondPlayer.isLeader(champion)) {
            container.getStyleClass().add("leader");
        }

        return container;
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public void clearMessages() {
        messages.clear();
        this.hasError = false;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public boolean hasError() {
        return this.hasError;
    }

    public void playAttackAnimation(Damageable damageable, Direction direction) {
        Pane pane = damageablePanes.get(damageable);
//        Pane currentPane = championPanes.get(BaseController.game.getCurrentChampion());

        if (pane != null) {
            ScaleTransition scale = new ScaleTransition(Duration.millis(100));
            scale.setToX(1.05);
            scale.setToY(1.05);

            TranslateTransition translate = new TranslateTransition(Duration.millis(100));
            translate.setToX(direction.toVector().y * 15);
            translate.setToY(direction.toVector().x * -15);

            ParallelTransition animation = new ParallelTransition(scale, translate);
            animation.setNode(pane);
            animation.setAutoReverse(true);
            animation.setCycleCount(2);

            addAnimation(animation);
        }
    }

    public void addAnimation(Animation animation) {
        animations.add(animation);
        animation.setOnFinished(e -> {
            animations.remove(animation);
            rerender();
        });
        animation.play();
    }

    @Override
    public void rerender() {
        if (this.animations.isEmpty()) {
            super.rerender();
        }
    }

    public void playMoveAnimation(Champion champion, Direction direction) {
        Pane pane = damageablePanes.get(champion);

        if (pane != null) {
            currentChampionAnimation.jumpTo(Duration.ZERO);
            currentChampionAnimation.stop();
            TranslateTransition animation = new TranslateTransition(Duration.millis(100), pane);
            animation.setToX(direction.toVector().y * 135);
            animation.setToY(direction.toVector().x * -165);
            addAnimation(animation);
        }
    }

    public void animateProgressBar(Damageable damageable, String property, double newPercent) {
        Pane pane = damageablePanes.get(damageable);

        ArrayList<ProgressBar> bars = new ArrayList<>();

        String className = "." + property + "-bar .progress-bar";
        ProgressBar onBoardBar = (ProgressBar) pane.lookup(className);

        if (onBoardBar != null) {
            bars.add(onBoardBar);
        }

        if (damageable instanceof Champion) {
            Champion champion = (Champion) damageable;

            bars.add((ProgressBar) championPanes.get(champion).lookup(className));

            if (champion.equals(BaseController.game.getCurrentChampion())) {
                bars.add((ProgressBar) getContainer().lookup("#current-champion-box " + className));
            }
        }

        for (ProgressBar bar : bars) {
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(bar.progressProperty(), bar.getProgress())),
                    new KeyFrame(Duration.millis(200), new KeyValue(bar.progressProperty(), newPercent))
            );

            addAnimation(timeline);
        }
    }

    public interface Listener {
        void onChampionClicked(int x, int y);
    }
}
