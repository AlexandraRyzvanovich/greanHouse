package exception;

public class ValidatorException extends RuntimeException {

    public ValidatorException(String message, Throwable cause) {
        super(message, cause);
    }
}
