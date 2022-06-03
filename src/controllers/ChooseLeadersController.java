package controllers;

import engine.Player;
import model.world.Champion;
import views.ChooseLeadersView;

public class ChooseLeadersController extends BaseController<ChooseLeadersView> implements ChooseLeadersView.Listener, Player.Listener {
    public ChooseLeadersController() {
        firstPlayer.setListener(this);
        secondPlayer.setListener(this);
    }

    @Override
    public ChooseLeadersView createView() {
        return new ChooseLeadersView(this);
    }

    @Override
    public void onLeaderSelected(Player player, Champion leader) {
        if (player.getLeader() != null) {
            player.setLeader(null);
            return;
        }

        player.setLeader(leader);
    }

    @Override
    public void onLeadersSelectionFinish() {
        switchTo(new KeyboardShortcutGuideController());
    }

    @Override
    public void onPlayerTeamChanged() {
        getView().rerender();
    }
}
