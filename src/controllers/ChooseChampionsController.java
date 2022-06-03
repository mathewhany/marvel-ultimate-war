package controllers;

import engine.Player;
import model.world.Champion;
import views.ChooseChampionsView;

public class ChooseChampionsController extends controllers.BaseController<ChooseChampionsView> implements ChooseChampionsView.Listener, Player.Listener {
    private boolean isFirstPlayer;

    public ChooseChampionsController() {
        this.isFirstPlayer = true;

        firstPlayer.setListener(this);
        secondPlayer.setListener(this);
    }

    @Override
    public void onChampionConfirmed() {
        Champion selectedChampion = getView().getSelectedChampion();
        if (selectedChampion == null) return;

        getCurrentPlayer().addChampion(selectedChampion);
        isFirstPlayer = !isFirstPlayer;
        getView().setCurrentPlayer(getCurrentPlayer());
        getView().setSelectedChampion(null);
        getView().rerender();
    }

    @Override
    public void onChampionSelected(Champion champion) {
        getView().setSelectedChampion(champion);
        getView().rerender();
    }

    private Player getCurrentPlayer() {
        return isFirstPlayer ? firstPlayer : secondPlayer;
    }

    @Override
    public void onPlayerTeamChanged() {
        if (firstPlayer.getTeam().size() == 3 && secondPlayer.getTeam().size() == 3) {
            switchTo(new ChooseLeadersController());
        }
    }

    @Override
    public ChooseChampionsView createView() {
        return new ChooseChampionsView(  firstPlayer, this);
    }
}
