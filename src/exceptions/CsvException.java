package exceptions;

public class CsvException extends Exception {
    public CsvException() {
    }

    public CsvException(String message) {
        super(message);
    }
}
