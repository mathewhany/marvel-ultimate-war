package exceptions;

public class LeaderAbilityAlreadyUsedException extends GameActionException {
    public LeaderAbilityAlreadyUsedException() {
        super();
    }

    public LeaderAbilityAlreadyUsedException(String s) {
        super(s);
    }
}
