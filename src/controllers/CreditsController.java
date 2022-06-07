package controllers;
import engine.Player;
import views.CreditsView;
import views.GameOverView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class CreditsController extends BaseController<CreditsView> {
	Player player = new Player("");
	public CreditsController() {
	}

	public CreditsView createView() {
		return new CreditsView();
	}

	public void onKeyPress() {
		if (keys.contains(KeyCode.SPACE)) {
			switchTo(new GameOverController());
		}
	}
}
