package com.kupal.skypeCommand.request;

import com.kupal.skypeCommand.request.impl.CommonCommandRequest;

/**
 * @author Kupal 3kb
 */
public final class RequestFactory {

    public static CommandRequest create() {
        return new CommonCommandRequest();
    }

    public static CommandRequest create(String commandName) {
        CommandRequest request = create();
        request.setCommandName(commandName);

        return request;
    }
}
