package com.integrator.withoutparams;

import com.kupal.skypeCommand.command.SkypeCommand;
import com.kupal.skypeCommand.exception.CommandException;
import com.kupal.skypeCommand.response.CommandResponse;
import com.kupal.skypeCommand.request.CommandRequest;
import com.kupal.skypeCommand.annotations.Command;

import java.io.File;
import java.io.IOException;

@Command(name = "START_TOMCAT")
public class StartTomcatCommand extends SkypeCommand {

    public CommandResponse execute(CommandRequest request) throws CommandException {
        String tomcatHome = System.getProperty("tomcat.home");
        String lineCommand = tomcatHome + File.separator + "bin" + File.separator + "Tomcat6.0";
        try {
            ProcessBuilder builder = new ProcessBuilder(lineCommand);
            builder.start();
        } catch (IOException e) {
            throw new CommandException("Failed start tomcat", e);
        }

        CommandResponse response = request.getResponse();
        response.setResponseText("Server start successfully");
        return response;
    }
}
