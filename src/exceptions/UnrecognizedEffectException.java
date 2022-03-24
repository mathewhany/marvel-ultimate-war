package exceptions;

public class UnrecognizedEffectException extends CsvException {
    public UnrecognizedEffectException(String effectName) {
        super("The effect `" + effectName + "` is not recognized.");
    }
}
