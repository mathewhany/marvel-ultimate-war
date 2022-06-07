package controllers;

import engine.Player;

import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import controllers.BaseController;

import views.GameOverView;
import views.GameOverView.Listener;
import engine.Player;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import views.WelcomeView;

public class GameOverController extends BaseController<GameOverView> implements Listener {
	public static final Media endingTheme = new Media(BaseController.class.getResource("/handmade-soundtrack.mp3").toExternalForm());
	private Player winner;
	public static final MediaPlayer newPlayer = new MediaPlayer(endingTheme);
	public GameOverController() {
		if (game == null) {
			winner = new Player("Cheater");
		} else {
			winner = game.checkGameOver();
		}
		player.stop();
		newPlayer.play();
		newPlayer.setOnEndOfMedia(() -> {
            newPlayer.seek(Duration.ZERO);
            newPlayer.play();
        });
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
	
	public void onPlayAgain() {
		newPlayer.stop();
		player.play();
		switchTo(new WelcomeController());
	}
	

}
