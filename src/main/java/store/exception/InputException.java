package store.exception;

public class InputException extends RuntimeException {
    public InputException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
    }
}
