package views;

import controllers.BaseController;
import controllers.CreditsController;
import engine.Player;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class GameOverView extends BaseView {
	private Player winner;
	private Listener listener;

	public GameOverView(Listener listener, Player winner) {
		this.winner = winner;
		this.listener = listener;
	}

	@Override
	public Pane createContent() {
		Button exitBtn = new Button("Exit");
		Button credits = new Button("Credits");
		exitBtn.setOnAction((ActionEvent event) -> {
			listener.onExit();
		});
		credits.setOnAction((ActionEvent event) -> {
			listener.onCredits();
		});
		Label gameOver = new Label(winner.getName().toUpperCase() + " WINS THE BATTLE");
		VBox container = new VBox(gameOver, credits, exitBtn);
		container.setId("game-over-view");

		return container;
	}

	public interface Listener {
		void onExit();

		void onCredits();

	}
}
