package com.kupal.skypeCommand.command;

/**
 * @author Kupal 3kb
 */
public class SecurityCommandException extends CommandException {

    public SecurityCommandException() {
        super();
    }

    public SecurityCommandException(String message) {
        super(message);
    }

    public SecurityCommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public SecurityCommandException(Throwable cause) {
        super(cause);
    }
}
