package controllers;

import engine.Player;
import views.BaseView;
import views.ChooseNamesView;

public class ChooseNamesController extends BaseController<ChooseNamesView> implements ChooseNamesView.Listener {
    @Override
    public ChooseNamesView createView() {
        return new ChooseNamesView(this);
    }

    @Override
    public void onNamesChosen(String firstName, String secondName) {
        firstPlayer = new Player(firstName);
        secondPlayer = new Player(secondName);

        firstPlayer.setColor("#FAFAFA");
        secondPlayer.setColor("#AFAFAF");

        switchTo(new ChooseChampionsController());
    }
    public void onCheatActivated() {
    	//switchTo(new GameOverController());
    }
}
