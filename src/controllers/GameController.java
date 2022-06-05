package controllers;

import engine.Game;
import engine.GameListener;
import engine.Player;
import exceptions.AbilityUseException;
import exceptions.NotEnoughResourcesException;
import javafx.scene.input.KeyCode;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.effects.Effect;
import model.world.Champion;
import model.world.Cover;
import model.world.Damageable;
import model.world.Direction;
import utils.SoundUtils;
import views.GameOverView;
import views.GameView;

import java.util.ArrayList;
import java.util.HashMap;

public class GameController extends BaseController<GameView> implements GameView.Listener, GameListener, Champion.Listener, Cover.Listener {
    public GameController() {
        game = new Game(firstPlayer, secondPlayer);
        game.setListener(this);
        game.addChampionListener(this);
        game.addCoverListener(this);
    }

    @Override
    public void onKeyPress() {
        try {
            if (keys.contains(KeyCode.R)) {
                game.useLeaderAbility();
                return;
            }

            Ability ability = getAbility();

            if (ability != null) {
                castAbility(ability);
                return;
            }

            Direction direction = getDirectionFromKeys();

            if (direction != null) {
                if (keys.contains(KeyCode.SHIFT)) {
                    game.attack(direction);
                } else {
                    game.move(direction);
                }
                return;
            }

            if (keys.contains(KeyCode.X)) {
                game.endTurn();
                return;
            }
        } catch (Exception ex) {
            handleException(ex.getMessage());
        }
    }

    @Override
    public void onChampionClicked(int x, int y) {
        Ability ability = getAbility();

        try {
            if (ability != null) {
                if (ability.getCastArea() == AreaOfEffect.SINGLETARGET) {
                    game.castAbility(ability, x, y);
                }
            }
        } catch (Exception ex) {
            handleException(ex.getMessage());
        }
    }

    private void handleException(String message) {
        getView().clearMessages();
        getView().addMessage(message);
        getView().rerender();
    }

    public Ability getAbility() {
        HashMap<KeyCode, Integer> abilityKeys = new HashMap<>();

        abilityKeys.put(KeyCode.Q, 0);
        abilityKeys.put(KeyCode.W, 1);
        abilityKeys.put(KeyCode.E, 2);
        abilityKeys.put(KeyCode.T, 3);

        for (KeyCode key : keys) {
            if (abilityKeys.containsKey(key)) {
                return game.getCurrentChampion().getAbilities().get(abilityKeys.get(key));
            }
        }

        return null;
    }

    private void castAbility(Ability ability) throws AbilityUseException, NotEnoughResourcesException, CloneNotSupportedException {
        if (ability.getCastArea() == AreaOfEffect.SINGLETARGET) {
            return;
        } else if (ability.getCastArea() == AreaOfEffect.DIRECTIONAL) {
            Direction direction = getDirectionFromKeys();

            if (direction != null) {
                game.castAbility(ability, direction);
            }
        } else {
            game.castAbility(ability);
        }
    }

    private Direction getDirectionFromKeys() {
        if (keys.contains(KeyCode.UP)) {
            return Direction.UP;
        } else if (keys.contains(KeyCode.DOWN)) {
            return Direction.DOWN;
        } else if (keys.contains(KeyCode.LEFT)) {
            return Direction.LEFT;
        } else if (keys.contains(KeyCode.RIGHT)) {
            return Direction.RIGHT;
        }

        return null;
    }

    public GameView createView() {
        return new GameView(this);
    }

    @Override
    public void onGameChanged() {
        Player winner = game.checkGameOver();

        if (winner != null) {
            switchTo(new GameOverController());
        }

//        getView().rerender();
    }

    @Override
    public void onMove(Direction direction) {
        getView().clearMessages();
        getView().addMessage(game.getCurrentChampion().getName() + " moved " + direction.toString().toLowerCase());
        getView().setHasError(true);

        SoundUtils.playSound("/move.mp3");
        getView().playMoveAnimation(game.getCurrentChampion(), direction);
    }

    @Override
    public void onAttack(Damageable target, Direction direction) {
        getView().clearMessages();

        if (target == null) {
            getView().addMessage("No one was effected, you wasn't your attack.");
            getView().rerender();
            return;
        }

        SoundUtils.playSound("/attack.mp3");

        if (target instanceof Cover) {
            getView().addMessage(game.getCurrentChampion().getName() + " attacked a cover.");
        } else {
            getView().addMessage(game.getCurrentChampion().getName() + " attacked " + ((Champion) target).getName());
        }

        getView().playAttackAnimation(target, direction);
    }

    @Override
    public void onCastAbility(Ability ability, ArrayList<Damageable> targets) {
        getView().clearMessages();

        String type = "";
        if (ability instanceof DamagingAbility) {
            type = "damaging";
        } else if (ability instanceof HealingAbility) {
            type = "healing";
        } else {
            type = "crowd control";
        }

        getView().addMessage(game.getCurrentChampion().getName() + " casted a " + type + " ability (" + ability.getName() + ")");

//        SoundUtils.playSound("/attack.mp3");

        if (targets.isEmpty()) {
            getView().addMessage("No targets were effected.");
        }

        for (Damageable target : targets) {
            if (target instanceof Cover) {
                getView().addMessage("A cover was effected.");
            } else {
                getView().addMessage(((Champion) target).getName() + " was effected.");
            }
//            getView().playAttackAnimation(target);
        }

        getView().rerender();
    }

    @Override
    public void onTargetDead(Damageable target) {
        if (getView().hasError()) {
            getView().clearMessages();
        }

        if (target instanceof Champion) {
            getView().addMessage(game.getCurrentChampion().getName() + " killed " + ((Champion) target).getName());
        } else if (target instanceof Cover) {
            getView().addMessage(game.getCurrentChampion().getName() + " killed a cover.");
        }

        getView().rerender();
    }

    @Override
    public void onUseLeaderAbility(Player currentPlayer, ArrayList<Champion> targets) {
        getView().clearMessages();

        getView().addMessage(currentPlayer.getName() + " used his leader ability.");

        if (targets.isEmpty()) {
            getView().addMessage("No targets were effected.");
        }

        for (Damageable target : targets) {
            if (target instanceof Cover) {
                getView().addMessage("A cover was effected.");
            } else {
                getView().addMessage(((Champion) target).getName() + " was effected.");
            }
        }

        getView().rerender();
    }

    @Override
    public void onEndTurn(Champion champion) {
        getView().clearMessages();
        getView().addMessage(champion.getName() + " ended his turn.");
        getView().rerender();
    }

    @Override
    public void onDodge(Champion champion) {
        getView().addMessage(champion.getName() + " dodged an attack from " + game.getCurrentChampion().getName());
        getView().rerender();
    }

    @Override
    public void onShieldUsed(Champion champion) {
        getView().addMessage(champion.getName() + " used his shield to block " + game.getCurrentChampion().getName() + "'s attack.");
        getView().rerender();
    }


    @Override
    public void onChampionChange(Champion champion) {

    }

    @Override
    public void onDamage(Champion champion) {
        getView().animateProgressBar(champion, "hp", champion.getHpPercent());
    }

    @Override
    public void onHeal(Champion champion) {
        getView().animateProgressBar(champion, "hp", champion.getHpPercent());
    }

    @Override
    public void onManaChange(Champion champion) {
        getView().animateProgressBar(champion, "mana", champion.getManaPercent());
    }

    @Override
    public void onActionPointsChange(Champion champion) {
        getView().animateProgressBar(champion, "action-points", champion.getActionPointsPercent());
    }

    @Override
    public void onEffectApplied(Champion champion, Effect effect) {

    }

    @Override
    public void onEffectRemoved(Champion champion, Effect effect) {

    }

    @Override
    public void onCoverDestroyed(Cover cover) {

    }

    @Override
    public void onCoverDamaged(Cover cover, int oldHp, int newHp) {
        getView().animateProgressBar(cover, "hp", cover.getHpPercent());
    }
}
