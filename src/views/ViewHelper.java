package views;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Map;

public class ViewHelper {
    public static Pane boxWithIcon(String iconPath, String text, int size) {
        Label label = new Label(text);
        ImageView icon = new ImageView(iconPath);
        icon.setFitWidth(size);
        icon.setFitHeight(size);

        Pane box = new VBox(label, icon);
        box.getStyleClass().add("box-with-icon");

        return box;
    }

    public static Pane boxWithIcon(String iconPath, String text) {
        return boxWithIcon(iconPath, text, 50);
    }

    public static Pane progressBarWithText(String labelText, int current, int max) {
        Label label = new Label(labelText + ": " + current + "/" + max);
        ProgressBar progressBar = new ProgressBar(current * 1.0 / max);

        Pane stackPane = new StackPane(progressBar, label);
        stackPane.getStyleClass().add("progress-bar-container");

        return stackPane;
    }

    public static Pane statsBox(HashMap<String, Object> details) {
        GridPane grid = new GridPane();
        grid.getStyleClass().add("details-box-grid");

        int i = 0;
        for (Map.Entry<String, Object> entry : details.entrySet()) {
            Label labelLabel = new Label(entry.getKey());
            labelLabel.getStyleClass().add("details-box-label");

            Label valueLabel = new Label(entry.getValue().toString());
            valueLabel.getStyleClass().add("details-box-value");

            grid.add(labelLabel, 0, i);
            grid.add(valueLabel, 1, i);
            i++;
        }

        return grid;
    }

    public static Pane detailsBox(String title, HashMap<String, Object> details) {
        Pane grid = statsBox(details);
        Pane box = boxWithTitle(title, grid);
        box.getStyleClass().add("details-box");

        return box;
    }

    public static Pane boxWithTitle(String title, Pane content) {
        VBox container = new VBox();
        container.getStyleClass().add("box");

        Label titleLabel = new Label(title);
        StackPane titleBox = new StackPane(titleLabel);
        container.getChildren().add(titleBox);
        titleBox.getStyleClass().add("box-title");

        content.getStyleClass().add("box-content");
        container.getChildren().add(content);

        return container;
    }
}
