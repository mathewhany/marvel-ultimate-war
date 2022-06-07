package views;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CreditsView extends BaseView {
    public Pane createContent() {
        BorderPane container = new BorderPane();
        container.setId("credits-view");

        HashMap<String, String[]> map = new LinkedHashMap<>();
        map.put("Developers", new String[]{"Rafeek Bassem", "Mathew Hany", "Nariman Ismail"});
        map.put("Special Thanks", new String[]{"StackOverflow", "Photoshop", "Coffee", "StackOverflow (again)"});

        int count = 0;

        SequentialTransition animations = new SequentialTransition(new PauseTransition(Duration.seconds(1)));

        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            String title = entry.getKey();
            String[] body = entry.getValue();

            Label titleLabel = new Label(title);
            titleLabel.getStyleClass().add("title");

            FadeTransition titleFade = new FadeTransition(Duration.seconds(2), titleLabel);
            titleFade.setFromValue(0);
            titleFade.setToValue(1);
            animations.getChildren().add(titleFade);

            VBox sectionBox = new VBox(titleLabel);
            sectionBox.getStyleClass().add("credits-box");

            for (String text : body) {
                Label nameLabel = new Label(text);
                nameLabel.getStyleClass().add("item");
                sectionBox.getChildren().add(nameLabel);


                FadeTransition itemFade = new FadeTransition(Duration.millis(500), nameLabel);
                itemFade.setFromValue(0);
                itemFade.setToValue(1);
                animations.getChildren().add(itemFade);
            }

            if (count % 2 == 0) {
                container.setLeft(sectionBox);
            } else {
                container.setRight(sectionBox);
            }

            count++;
        }

        StackPane label = new StackPane(new Label("Press space to skip ..."));
        label.setId("skip");
        container.setBottom(label);

        animations.play();

        return container;
    }
}

