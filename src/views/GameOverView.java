package views;

import engine.Player;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class GameOverView extends BaseView {
    private Player winner;

    public GameOverView(Player winner) {
        this.winner = winner;
    }

    @Override
    public Pane createContent() {
        return new StackPane(new Text(this.winner.getName()));
    }
}
