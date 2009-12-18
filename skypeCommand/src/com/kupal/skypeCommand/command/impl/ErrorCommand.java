package com.kupal.skypeCommand.command.impl;

import com.kupal.skypeCommand.command.SkypeCommand;
import com.kupal.skypeCommand.command.Status;
import com.kupal.skypeCommand.response.CommandResponse;
import com.kupal.skypeCommand.request.CommandRequest;
import com.kupal.skypeCommand.annotations.Command;

/**
 * @author Kupal 3kb
 */
@Command(name = "ErrorCommand")
public class ErrorCommand extends SkypeCommand {

    public CommandResponse execute(CommandRequest request) {
        CommandResponse response = request.getResponse();
        response.setStatus(Status.FAILURE);
        response.setResponseText("unknown command. Type /HELP_CMD to get list of valid commands");
        return response;
    }
}
