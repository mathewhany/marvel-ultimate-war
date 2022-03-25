package exceptions;

public class UnrecognizedChampionTypeException extends CsvException {
    public UnrecognizedChampionTypeException(String championType) {
        super("The champion type `" + championType + "` is not recognized.");
    }
}
