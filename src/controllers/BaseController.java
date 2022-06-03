package controllers;

import engine.Game;
import engine.Player;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import views.BaseView;

import java.io.File;
import java.util.HashSet;

public class BaseController<T extends BaseView> extends Application implements EventHandler<KeyEvent> {
    public static final Media media = new Media(BaseController.class.getResource("/soundtrack.mp3").toExternalForm());
    public static final MediaPlayer player = new MediaPlayer(media);
    public static Player firstPlayer;
    public static Player secondPlayer;
    public static Game game;
    public static Stage primaryStage;
    public HashSet<KeyCode> keys = new HashSet<>();
    private T view;

    public static void main(String[] args) {
        try {
            Game.loadAbilities(Game.CSV_FILE_ABILITIES);
            Game.loadChampions(Game.CSV_FILE_CHAMPIONS);
        } catch (Exception e) {
            System.out.println("Error");
        }

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;

        player.play();
        player.setOnEndOfMedia(() -> {
            player.seek(Duration.ZERO);
            player.play();
        });

        Scene scene = new Scene(new StackPane());
        scene.setCursor(new ImageCursor(new Image("/cursor.png")));
        scene.getStylesheets().add("styles.css");
        stage.setScene(scene);

        switchTo(new WelcomeController());

        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();
    }

    public void switchTo(BaseController controller) {
        primaryStage.getScene().addEventFilter(KeyEvent.KEY_PRESSED, controller);
        primaryStage.getScene().addEventFilter(KeyEvent.KEY_RELEASED, controller);
        switchTo(controller.getView());
        controller.onSceneReady();
    }

    public void switchTo(BaseView view) {
        view.rerender();
        keys.clear();
        primaryStage.getScene().removeEventFilter(KeyEvent.KEY_PRESSED, this);
        primaryStage.getScene().removeEventFilter(KeyEvent.KEY_RELEASED, this);

        BaseView oldView = this.getView();

        if (oldView != null) {
            Pane oldContainer = oldView.getContainer();
            FadeTransition transition1 = new FadeTransition(Duration.millis(1000), oldContainer);
            transition1.setFromValue(1);
            transition1.setToValue(0);
            transition1.play();

            Pane container = view.getContainer();
            FadeTransition transition2 = new FadeTransition(Duration.millis(1000), container);
            transition2.setFromValue(0);
            transition2.setToValue(1);
            transition2.play();

            ParallelTransition animation = new ParallelTransition(transition1, transition2);

            StackPane containers = new StackPane(container, oldContainer);
            primaryStage.getScene().setRoot(containers);
            animation.play();

            animation.setOnFinished(e -> {
                containers.getChildren().setAll(new StackPane());
                primaryStage.getScene().setRoot(container);
            });
        } else {
            primaryStage.getScene().setRoot(view.getContainer());
        }
    }

    public T getView() {
        if (this.view == null) {
            this.view = createView();
        }

        return this.view;
    }

    public void onSceneReady() {
        primaryStage.getScene().addEventFilter(WindowEvent.WINDOW_HIDDEN, e -> {
            keys.clear();
        });
    }

    public T createView() {
        return null;
    }

    public void handle(KeyEvent e) {
        if (e.getEventType() == KeyEvent.KEY_PRESSED) {
            keys.add(e.getCode());
            onKeyPress();
        } else {
            keys.remove(e.getCode());
        }
    }

    public void onKeyPress() {
    }
}
