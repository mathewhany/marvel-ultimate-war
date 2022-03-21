package exceptions;

public class AbilityUseException extends GameActionException{
	public AbilityUseException() {
		super();
	}

	public AbilityUseException(String s) {
		super(s);
	}
}
