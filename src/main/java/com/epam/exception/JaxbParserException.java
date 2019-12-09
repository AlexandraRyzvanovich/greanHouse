package com.epam.exception;

public class JaxbParserException extends RuntimeException {
    public JaxbParserException(String message) {
        super(message);
    }

    public JaxbParserException(String message, Throwable cause) {
        super(message, cause);
    }
}
