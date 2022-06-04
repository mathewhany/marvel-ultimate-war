package views;

import controllers.BaseController;
import engine.Game;
import engine.Player;
import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.Duration;
import model.abilities.Ability;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.effects.Effect;
import model.world.Champion;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ChooseChampionsView extends BaseView {
    private Player currentPlayer;
    private Listener listener;

    private Champion selectedChampion;

    public ChooseChampionsView(Player currentPlayer, Listener listener) {
        this.currentPlayer = currentPlayer;
        this.listener = listener;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public Pane createContent() {
        Pane grid = createGrid();
        Pane playersInfoPanel = createPlayersInfoPanel();
        Pane detailsPanel = createDetailsPanel();

        HBox mainPanel = new HBox(playersInfoPanel, grid, detailsPanel);
        mainPanel.setId("choose-champions-view");

        return mainPanel;
    }

    private Pane createPlayersInfoPanel() {
        Pane firstPlayerPane = createPanelForPlayer(BaseController.firstPlayer);
        Pane secondPlayerPane = createPanelForPlayer(BaseController.secondPlayer);

        Pane playersInfoPanel = new VBox(firstPlayerPane, secondPlayerPane);
        playersInfoPanel.setId("players-info");

        return playersInfoPanel;
    }

    private Pane createDetailsPanel() {
        if (selectedChampion != null) {
            return createDetailsPanelForChampion(selectedChampion);
        }

        Label label = new Label("Please select a champion");
        label.getStyleClass().add("box-content");

        StackPane container = new StackPane(label);
        container.getStyleClass().add("no-champion-selected");
        container.setId("details-panel");

        return container;
    }

    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setId("grid");

        int i = 0;
        int j = 0;

        for (Champion champion : Game.getAvailableChampions()) {
            Button button = new Button();
            button.getStyleClass().add("champion-btn");

            button.setDisable(BaseController.firstPlayer.hasChampion(champion) || BaseController.secondPlayer.hasChampion(champion));
            button.setGraphic(new ImageView("/images/icons/" + champion.getName() + ".png"));

            if (champion.equals(selectedChampion)) {
                button.getStyleClass().add("selected-champion");

                ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(500), button);
                scaleTransition.setToX(1.025);
                scaleTransition.setToY(1.025);
                scaleTransition.setCycleCount(Animation.INDEFINITE);
                scaleTransition.setAutoReverse(true);
                scaleTransition.setOnFinished(e -> { scaleTransition.playFromStart(); });
                scaleTransition.play();
            }

            button.setOnAction(e -> {
                listener.onChampionSelected(champion);
            });

            if (j >= 4) {
                j = 0;
                i++;
            }

            grid.add(button, j, i);
            j++;
        }

        return grid;
    }

    private Pane createPanelForPlayer(Player player) {
        Pane panel = new HBox();
        panel.getStyleClass().add("champions-container");

        if (player.getTeam().isEmpty()) {
            panel.getChildren().add(new Label("No champions selected yet!"));
        }

        for (Champion champion : player.getTeam()) {
            Pane championBox = ViewHelper.boxWithIcon("/images/icons/" + champion.getName() + ".png", champion.getName());
            championBox.getStyleClass().add("champion-container");

            panel.getChildren().add(championBox);
        }

        Pane box = ViewHelper.boxWithTitle(player.getName() + " (" + player.getTeam().size() + " / 3)", panel);
        box.getStyleClass().add("player-panel");

        if (player.equals(currentPlayer)) {
            box.getStyleClass().add("current-player");

            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(500), box);
            scaleTransition.setToX(1.025);
            scaleTransition.setToY(1.025);
            scaleTransition.setCycleCount(Animation.INDEFINITE);
            scaleTransition.setAutoReverse(true);
            scaleTransition.setOnFinished(e -> { scaleTransition.playFromStart(); });
            scaleTransition.play();
        }

        return box;
    }

    private VBox createDetailsPanelForChampion(Champion champion) {
        VBox panel = new VBox();
        panel.setId("details-panel");

        HashMap<String, Object> championDetails = new LinkedHashMap<>();

        championDetails.put("Type", champion.getType());
        championDetails.put("Max HP", champion.getMaxHP());
        championDetails.put("Attack Damage", champion.getAttackDamage());
        championDetails.put("Speed", champion.getSpeed());
        championDetails.put("Mana", champion.getMana());
        championDetails.put("Max Action Points", champion.getMaxActionPointsPerTurn());
        championDetails.put("Attack Range", champion.getAttackRange());

        panel.getChildren().add(ViewHelper.detailsBox(champion.getName(), championDetails));

        Pane abilitiesBox = new VBox();
        abilitiesBox.setId("abilities-box");

        for (Ability ability : champion.getAbilities()) {
            Pane abilityBox = createAbilityDetailsBox(ability);
            abilitiesBox.getChildren().add(abilityBox);
        }

        Button selectChampionBtn = new Button("Select");
        selectChampionBtn.setId("select-champion-btn");

        selectChampionBtn.setOnAction(e -> {
            listener.onChampionConfirmed();
        });

        panel.getChildren().addAll(abilitiesBox, selectChampionBtn);

        return panel;
    }

    private Pane createAbilityDetailsBox(Ability ability) {
        VBox container = new VBox();
        container.getStyleClass().add("ability-details-box");

        HashMap<String, Object> abilityDetails = new LinkedHashMap<>();

        abilityDetails.put("Action Points", ability.getRequiredActionPoints());
        abilityDetails.put("Base Cooldown", ability.getBaseCooldown());
        abilityDetails.put("Cast Range", ability.getCastRange());
        abilityDetails.put("Damage", ability.getBaseCooldown());
        abilityDetails.put("Mana Cost", ability.getManaCost());
        abilityDetails.put("Cast Area", ability.getCastArea());

        if (ability instanceof DamagingAbility) {
            container.getStyleClass().add("damaging-ability");
            DamagingAbility damagingAbility = (DamagingAbility) ability;
            abilityDetails.put("Type", "Damaging");
            abilityDetails.put("Damage Amount", damagingAbility.getDamageAmount());
        } else if (ability instanceof HealingAbility) {
            container.getStyleClass().add("healing-ability");
            HealingAbility healingAbility = (HealingAbility) ability;
            abilityDetails.put("Type", "Healing");
            abilityDetails.put("Heal Amount", healingAbility.getHealAmount());
        } else if (ability instanceof CrowdControlAbility) {
            container.getStyleClass().add("cc-ability");
            abilityDetails.put("Type", "Crowd Control");
            CrowdControlAbility ccAbility = (CrowdControlAbility) ability;
            Effect effect = ccAbility.getEffect();
            abilityDetails.put("Effect", effect.getName());
            abilityDetails.put("Effect Duration", effect.getDuration());
        }

        container.getChildren().add(ViewHelper.detailsBox(ability.getName(), abilityDetails));

        return container;
    }

    public Champion getSelectedChampion() {
        return selectedChampion;
    }

    public void setSelectedChampion(Champion selectedChampion) {
        this.selectedChampion = selectedChampion;
    }

    public interface Listener {
        void onChampionConfirmed();

        void onChampionSelected(Champion champion);
    }
}
