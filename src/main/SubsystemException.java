package main;

public class SubsystemException extends RuntimeException {
    public SubsystemException(String message, Throwable cause) {
        super(message, cause);
    }
}