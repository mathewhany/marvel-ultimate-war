package exceptions;

public class UnrecognizedAbilityException extends CsvException {
    public UnrecognizedAbilityException(String abilityName) {
        super("Unrecognized ability `" + abilityName + "`.");
    }
}
