package com.kupal.skypeCommand.exception;

/**
 * @author Kupal 3kb
 */
public class CommandException extends Exception {

    public CommandException() {
        super();
    }

    public CommandException(String message) {
        super(message);
    }

    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandException(Throwable cause) {
        super(cause);
    }
}
