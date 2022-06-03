package views;

import controllers.BaseController;
import engine.Game;
import engine.Player;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class GameView extends BaseView {
    private Listener listener;
    private ArrayList<String> messages = new ArrayList<>();
    private boolean hasError = false;

    private HashSet<Transition> transitions = new HashSet<>();

    private HashMap<Damageable, Pane> damageablePanes = new HashMap<>();

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

        VBox centerPane = new VBox(board, messagePanel);
        centerPane.setId("center-pane");

        HBox mainContainer = new HBox(leftPane, centerPane, abilitiesPanel, currentChampion);
        mainContainer.setId("game-view");

        return mainContainer;
    }

    private Pane createMessagePanel() {
        VBox messagePanel = new VBox();
        messagePanel.setId("messages-panel");

        for (String message : messages) {
            Label label = new Label(message);
            label.getStyleClass().add("message");
            messagePanel.getChildren().add(label);
        }

        return messagePanel;
    }

    private Pane createPlayersInfoPanel() {
        Pane firstPlayerPane = createPanelForPlayer(BaseController.firstPlayer);
        Pane secondPlayerPane = createPanelForPlayer(BaseController.secondPlayer);

        Pane playersInfoPanel = new VBox(firstPlayerPane, secondPlayerPane);
        playersInfoPanel.setId("players-info");

        return playersInfoPanel;
    }

    private Pane createPanelForPlayer(Player player) {
        Pane container = new HBox();
        container.getStyleClass().add("champions-container");

        for (Champion champion : player.getTeam()) {
            container.getChildren().add(createChampionItemForPlayerInfo(champion));
        }

        Pane panel = ViewHelper.boxWithTitle(player.getName(), container);
        panel.getStyleClass().add("player-info-box");

        return panel;
    }

    private Pane createChampionItemForPlayerInfo(Champion champion) {
        Pane nameAndIcon = ViewHelper.boxWithIcon("/images/icons/" + champion.getName() + ".png", champion.getName());

        Pane healthBar = ViewHelper.progressBarWithText("HP", champion.getCurrentHP(), champion.getMaxHP());
        healthBar.getStyleClass().add("hp-bar");

        Pane manaBar = ViewHelper.progressBarWithText("Mana", champion.getMana(), champion.getMaxMana());
        manaBar.getStyleClass().add("mana-bar");

        Pane actionPointsBar = ViewHelper.progressBarWithText("Action Points", champion.getCurrentActionPoints(), champion.getMaxActionPointsPerTurn());
        actionPointsBar.getStyleClass().add("action-points-bar");

        Pane effectsContainer = new HBox();
        effectsContainer.getStyleClass().add("effects-container");

        for (Effect effect : champion.getAppliedEffects()) {
            effectsContainer.getChildren().add(ViewHelper.boxWithIcon("/images/icons/Hulk.png", effect.getName()));
        }


        Pane container = new VBox(nameAndIcon, healthBar, manaBar, actionPointsBar, effectsContainer);
        container.getStyleClass().add("champion");

        return container;
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


    public GridPane createBoard() {
        damageablePanes.clear();
        GridPane grid = new GridPane();
        grid.setId("board");

        for (int i = 0; i < Game.getBoardheight(); i++) {
            for (int j = 0; j < Game.getBoardwidth(); j++) {
                final int x = i;
                final int y = j;

                Damageable cell = BaseController.game.getCell(i, j);

                VBox championPanel = new VBox();
                championPanel.getStyleClass().add("cell");

                championPanel.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                    listener.onChampionClicked(x, y);
                });


                if (cell == null) {
                    championPanel.getChildren().add(new Text(" "));
                } else {
                    damageablePanes.put(cell, championPanel);
                    if (cell instanceof Champion) {
                        Champion champion = (Champion) cell;

                        if (BaseController.firstPlayer == BaseController.game.getPlayerForChampion(champion)) {
                            championPanel.getStyleClass().add("first-player");
                        } else {
                            championPanel.getStyleClass().add("second-player");
                        }

                        if (BaseController.game.getCurrentChampion().equals(champion)) {
                            championPanel.getStyleClass().add("current-champion");
                        }

                        if (BaseController.firstPlayer.isLeader(champion) || BaseController.secondPlayer.isLeader(champion)) {
                            championPanel.getStyleClass().add("leader");
                        }

                        championPanel.getChildren().add(ViewHelper.boxWithIcon("/images/icons/" + champion.getName() + ".png", champion.getName()));

                        HBox effectsContainer = new HBox();
                        for (Effect effect : champion.getAppliedEffects()) {
                            effectsContainer.getChildren().add(ViewHelper.boxWithIcon("/images/icons/Hulk.png", effect.getName(), 24));
                        }
                        championPanel.getChildren().add(effectsContainer);

                    } else if (cell instanceof Cover) {
                        championPanel.getStyleClass().add("cover");
                    }

                    Pane hpBar = ViewHelper.progressBarWithText("HP", cell.getCurrentHP(), cell.getMaxHP());
                    hpBar.getStyleClass().add("hp-bar");

                    championPanel.getChildren().add(hpBar);
                }


                grid.add(championPanel, j, Game.getBoardheight() - i - 1);
            }
        }

        return grid;
    }

    public Pane createAbilitiesPanel() {
        Champion champion = BaseController.game.getCurrentChampion();
        VBox abilitiesPanel = new VBox();
        abilitiesPanel.setId("abilities-box");

        int i = 0;
        char[] abilityKeys = {'Q', 'W', 'E'};
        for (Ability ability : champion.getAbilities()) {
            abilitiesPanel.getChildren().add(createPanelForAbility(ability, abilityKeys[i]));
            i++;
        }
        return abilitiesPanel;
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

        Pane effectsContainer = new HBox();
        effectsContainer.getStyleClass().add("effects-container");

        for (Effect effect : champion.getAppliedEffects()) {
            effectsContainer.getChildren().add(ViewHelper.boxWithIcon("/images/icons/Hulk.png", effect.getName()));
        }

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

    public void shakeCell(Damageable damageable, EventHandler<ActionEvent> onFinished) {
        Pane pane = damageablePanes.get(damageable);

        if (pane != null) {
            RotateTransition rotate = new RotateTransition(Duration.millis(100), pane);
            rotate.setToAngle(10);
            rotate.setCycleCount(2);
            rotate.setAutoReverse(true);
            transitions.add(rotate);
            rotate.setOnFinished(e -> {
                transitions.remove(rotate);
                onFinished.handle(e);
            });
            rotate.play();
        }
    }

    public void moveAnimation(Champion champion, Direction direction, EventHandler<ActionEvent> onFinished) {
        Pane pane = damageablePanes.get(champion);

        if (pane != null) {
            TranslateTransition animation = new TranslateTransition(Duration.millis(100), pane);
            animation.setToX(direction.toVector().getY() * 120);
            animation.setToY(direction.toVector().getX() * -120);
            transitions.add(animation);
            animation.setOnFinished(e -> {
                transitions.remove(animation);
                onFinished.handle(e);
            });
            animation.play();
        }
    }

    @Override
    public void rerender() {
        if (this.transitions.isEmpty()) {
            super.rerender();
        }
    }

    public interface Listener {
        void onChampionClicked(int x, int y);
    }
}
