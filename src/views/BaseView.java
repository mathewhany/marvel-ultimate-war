package views;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public abstract class BaseView {
    private final StackPane container;

    public BaseView() {
        this.container = new StackPane();
    }

    public abstract Pane createContent();

    public void rerender() {
        container.getChildren().setAll(createContent());
    }

    public Pane getContainer() {
        return this.container;
    }
}
