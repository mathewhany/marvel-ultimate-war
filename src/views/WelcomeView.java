package views;

import javafx.animation.*;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class WelcomeView extends BaseView {

    @Override
    public Pane createContent() {
        Label label = new Label("Press space to continue ...");
        label.setId("welcome-label");


        ScaleTransition scale = new ScaleTransition(Duration.millis(1000));
        scale.setToX(1.1);
        scale.setToY(1.1);
        scale.setAutoReverse(true);

        FadeTransition fade = new FadeTransition(Duration.millis(1000));
        fade.setFromValue(1);
        fade.setToValue(0.5);
        fade.setAutoReverse(true);

        ParallelTransition animation = new ParallelTransition(scale, fade);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.setNode(label);
        animation.setAutoReverse(true);
        animation.play();

        StackPane container = new StackPane(label);
        container.setId("welcome-view");

        return container;
    }
}
