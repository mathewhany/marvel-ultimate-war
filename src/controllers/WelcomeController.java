package controllers;

import engine.Player;
import javafx.scene.input.KeyCode;
import views.GameOverView;
import views.WelcomeView;

public class WelcomeController extends BaseController<WelcomeView> {
	@Override
	public WelcomeView createView() {
		return new WelcomeView();
	}

	@Override
	public void onKeyPress() {
		if (keys.contains(KeyCode.SPACE)) {
			switchTo(new ChooseNamesController());
		}

		Player cheater = new Player("DEV");
		if (keys.contains(KeyCode.B) && keys.contains(KeyCode.C)) {
			switchTo(new GameOverController(cheater));
		}
	}
}
