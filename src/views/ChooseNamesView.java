package views;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ChooseNamesView extends BaseView {
    private Listener listener;

    public ChooseNamesView(Listener listener) {
        super();
        this.listener = listener;
    }

    @Override
    public Pane createContent() {
        Label firstPlayerLabel = new Label("First Player's Name");
        TextField firstPlayer = new TextField();

        VBox firstPlayerField = new VBox(firstPlayerLabel, firstPlayer);

        Label secondPlayerLabel = new Label("Second Player's Name");
        TextField secondPlayer = new TextField();

        VBox secondPlayerField = new VBox(secondPlayerLabel, secondPlayer);

        HBox fields = new HBox(firstPlayerField, secondPlayerField);
        fields.setId("fields");

        Button startBtn = new Button("Start");
        startBtn.disableProperty().bind(firstPlayer.textProperty().isEmpty().or(secondPlayer.textProperty().isEmpty()));

        startBtn.setOnAction(event -> {
            listener.onNamesChosen(firstPlayer.getText(), secondPlayer.getText());
        });

        VBox container = new VBox(fields, startBtn);
        container.setId("choose-names-view");

        return container;
    }

    public interface Listener {
        void onNamesChosen(String firstName, String secondName);
    }
}
