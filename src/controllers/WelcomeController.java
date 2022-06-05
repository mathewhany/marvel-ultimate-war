package controllers;

import engine.Game;
import engine.Player;
import javafx.scene.input.KeyCode;
import model.world.Champion;
import views.WelcomeView;

import java.util.ArrayList;

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

        if (keys.contains(KeyCode.DIGIT1) && keys.contains(KeyCode.DIGIT3)) {
            skipToGame();
        }
    }

    private void skipToGame() {
        firstPlayer = new Player("Player 1");
        secondPlayer = new Player("Player 2");

        ArrayList<Champion> champions = Game.getAvailableChampions();

        int count = 0;

        while (count < 6) {
            int randomIndex = (int) (Math.random() * champions.size());
            Champion champion = champions.get(randomIndex);

            if (firstPlayer.getTeam().contains(champion) || secondPlayer.getTeam().contains(champion)) {
                continue;
            }

            if (count < 3) {
                firstPlayer.addChampion(champion);
            } else {
                secondPlayer.addChampion(champion);
            }

            count++;
        }

        int firstLeaderIndex = (int) (Math.random() * firstPlayer.getTeam().size());
        int secondLeaderIndex = (int) (Math.random() * secondPlayer.getTeam().size());

        firstPlayer.setLeader(firstPlayer.getTeam().get(firstLeaderIndex));
        secondPlayer.setLeader(secondPlayer.getTeam().get(secondLeaderIndex));

        switchTo(new GameController());
    }
}
