package com.integrator.withparams;

import com.kupal.skypeCommand.annotations.Request;
import com.kupal.skypeCommand.command.SkypeCommand;
import com.kupal.skypeCommand.exception.CommandException;
import com.kupal.skypeCommand.response.CommandResponse;
import com.kupal.skypeCommand.annotations.Command;

import java.io.File;
import java.io.IOException;

@Command(name = "START_SERVER", authorizedOnly = true)
@Request(requestClass = StartServerRequest.class)
public class StartServerCommand extends SkypeCommand<StartServerRequest> {

    public CommandResponse execute(StartServerRequest request) throws CommandException {
        ServerType type = request.getType();

        String serverHome = type.getHomeDir();
        String lineCommand = serverHome + File.separator + "bin" + File.separator + type.getExecFile();
        try {
            ProcessBuilder builder = new ProcessBuilder(lineCommand);
            builder.start();
        } catch (IOException e) {
            throw new CommandException("Failed start server", e);
        }

        CommandResponse response = request.getResponse();
        response.setResponseText("Server start successfully");
        return response;
    }
}
