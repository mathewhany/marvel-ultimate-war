package exceptions;

public class UnrecognizedAbilityTypeException extends CsvException {
    public UnrecognizedAbilityTypeException(String type) {
        super("The ability type `" + type + "` is not recognized.");
    }
}
