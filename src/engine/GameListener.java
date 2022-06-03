package engine;

import model.abilities.Ability;
import model.world.Champion;
import model.world.Damageable;
import model.world.Direction;

import java.util.ArrayList;

public interface GameListener {
    void onGameChanged();

    void onMove(Direction direction);

    void onAttack(Damageable target);

    void onCastAbility(Ability ability, ArrayList<Damageable> targets);

    void onTargetDead(Damageable target);

    void onUseLeaderAbility(Player currentPlayer, ArrayList<Champion> targets);

    void onEndTurn(Champion champion);

    void onDodge(Champion champion);

    void onShieldUsed(Champion champion);
}
