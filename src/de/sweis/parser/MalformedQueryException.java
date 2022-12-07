package de.sweis.parser;

public class MalformedQueryException extends RuntimeException {
    public MalformedQueryException(String errorMessage) {
        super(errorMessage);
    }
}
