package com.suglob.transport.exception;


public class NotSuchComfortLevelException extends Throwable {
    public NotSuchComfortLevelException(String message){
        super(message);
    }

    public NotSuchComfortLevelException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSuchComfortLevelException(Throwable cause) {
        super(cause);
    }
}
