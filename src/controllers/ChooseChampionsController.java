package controllers;

import java.util.ArrayList;

import engine.Game;
import jdk.internal.icu.text.UnicodeSet;
import model.*;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.effects.Disarm;
import model.effects.Root;
import engine.Player;
import model.world.Champion;
import model.world.Villain;
import utils.SoundUtils;
import views.ChooseChampionsView;

public class ChooseChampionsController extends controllers.BaseController<ChooseChampionsView> implements ChooseChampionsView.Listener, Player.Listener {
    private boolean isFirstPlayer;

    public ChooseChampionsController() {
        this.isFirstPlayer = true;
        addThanosEasterEgg();
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

    /**
     * This is a classified method, read on your own risk. :3
     */
    private void addThanosEasterEgg() {
        ArrayList<String> admins = new ArrayList<>();
        admins.add("M@th3w");
        admins.add("R@f33k");

        firstPlayer.setListener(this);
        secondPlayer.setListener(this);
        Champion thanos = new Villain("Thanos" , 9999 , 9999 , 9999 , 999 , 9 , 999);
        Ability A1 = new CrowdControlAbility("Drop your weapons",400 ,5,9,AreaOfEffect.TEAMTARGET,500,new Disarm(99));
        Ability A2 = new CrowdControlAbility("Stay there" ,500,5,9,AreaOfEffect.TEAMTARGET,500,new Root(99));
        Ability A3 = new DamagingAbility("Snap" , 500 , 50 , 9 , AreaOfEffect.TEAMTARGET , 9999 , 9999);
        thanos.addAbility(A1);
        thanos.addAbility(A2);
        thanos.addAbility(A3);

        if(admins.contains(firstPlayer.getName()) || admins.contains(secondPlayer.getName())){
            Game.getAvailableChampions().add(thanos);
            SoundUtils.playSound("/sound-effects/thanos.mp3");
        }
    }
}
