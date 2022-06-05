package controllers;

import engine.Player;

import views.GameOverView;
import views.GameOverView.Listener;
import engine.Player;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import views.WelcomeView;

public class GameOverController extends BaseController<GameOverView> implements Listener {
	private Player winner;
	
	public GameOverController(Player winner) {
		this.winner = winner;
	}
	
	public GameOverController() {
		this(game.checkGameOver());
	}
	
	public GameOverView createView() {
		return new GameOverView(this, winner);
	}

	@Override
	public void onExit() {
		Platform.exit();
	}

	@Override
	public void onCredits() {
		switchTo(new CreditsController());
	}

}
