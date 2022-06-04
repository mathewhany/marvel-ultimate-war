package views;

import engine.Player;
import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.world.Champion;
import controllers.BaseController;

public class ChooseLeadersView extends BaseView {
    private Listener listener;

    public ChooseLeadersView(Listener listener) {
        super();
        this.listener = listener;
    }

    private Pane createPanelForPlayer(Player player) {
        HBox championsList = new HBox();
        championsList.setAlignment(Pos.CENTER);
        championsList.setSpacing(10);

        for (Champion champion : player.getTeam()) {
            Button selectBtn = new Button(champion.getName());
            selectBtn.setGraphic(new ImageView("/images/icons/" + champion.getName() + ".png"));

            if (champion.equals(player.getLeader())) {
                ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(500), selectBtn);
                scaleTransition.setToX(1.025);
                scaleTransition.setToY(1.025);
                scaleTransition.setCycleCount(Animation.INDEFINITE);
                scaleTransition.setAutoReverse(true);
                scaleTransition.setOnFinished(e -> { scaleTransition.playFromStart(); });
                scaleTransition.play();
            }

            selectBtn.setDisable(player.getLeader() != null && !player.isLeader(champion));

            selectBtn.setOnAction(e -> {
                listener.onLeaderSelected(player, champion);
            });

            championsList.getChildren().add(selectBtn);
        }

        return ViewHelper.boxWithTitle(player.getName() + "'s Leader", championsList);
    }

    @Override
    public Pane createContent() {
        Pane firstPlayerPanel = createPanelForPlayer(BaseController.firstPlayer);
        Pane secondPlayerPanel = createPanelForPlayer(BaseController.secondPlayer);

        Button startBtn = new Button("Start Game");
        startBtn.setDisable(BaseController.firstPlayer.getLeader() == null || BaseController.secondPlayer.getLeader() == null);

        startBtn.setOnAction(e -> {
            listener.onLeadersSelectionFinish();
        });

        VBox container = new VBox(firstPlayerPanel, secondPlayerPanel, startBtn);
        container.setId("container");

        StackPane mainPanel = new StackPane(container);
        mainPanel.setId("choose-leaders-view");

        return mainPanel;
    }

    public interface Listener {
        void onLeaderSelected(Player player, Champion leader);
        void onLeadersSelectionFinish();
    }
}
