package com.kupal.skypeCommand.command;

import com.kupal.skypeCommand.exception.CommandException;
import com.kupal.skypeCommand.exception.ValidationException;
import com.kupal.skypeCommand.request.CommandRequest;
import com.kupal.skypeCommand.request.RequestFactory;
import com.kupal.skypeCommand.response.CommandResponse;
import com.kupal.skypeCommand.response.ResponseFactory;
import com.kupal.skypeCommand.util.StringUtils;
import com.kupal.skypeCommand.annotations.Request;
import com.kupal.skypeCommand.annotations.AnnotationUtil;
import com.kupal.skypeCommand.annotations.Command;
import com.kupal.skypeCommand.annotations.process.Processor;
import com.kupal.skypeCommand.annotations.process.ProcessorHolder;
import com.kupal.skypeCommand.exception.AnnotationProcessorException;
import com.kupal.skypeCommand.skype.SkypeServer;
import com.skype.User;

/**
 * @author Kupal 3kb
 */
public class CommandRunner {

    /**
     * Executing command with specified params in <code>commandLine</code>
     *
     * @param sender - sender of command
     * @param commandLine - direct command line
     * @return response
     */
    public static CommandResponse execute(User sender, String commandLine) {
        SkypeCommand command    = getCommand(commandLine);
        Class<? extends CommandRequest> requestClass = AnnotationUtil.getAnnotation(Request.class, command.getClass(), true).requestClass();
        Processor processor     = ProcessorHolder.getProcessor(Request.class);
        CommandResponse response;
        try {
            validate(sender, command);

            CommandRequest request = RequestFactory.create(requestClass, commandLine);
            request.setSender(sender);
            processor.process(request);
            response = command.execute(request);
        } catch (AnnotationProcessorException e) {
            response = ResponseFactory.create(e);
        } catch (ValidationException e) {
            response = ResponseFactory.create(e);
        } catch (CommandException e) {
            response = ResponseFactory.create(e);
        } catch (Exception e) {
            response = ResponseFactory.create(e);
        }
        
        return response;
    }

    private static SkypeCommand getCommand(String commandLine) {
        if(StringUtils.isEmpty(commandLine) || !commandLine.startsWith(SkypeCommand.CMD_FIRST_TOKEN))
            return CommandHolder.getErrorCommand();

        String commandName = commandLine.split(" ")[0].replace(SkypeCommand.CMD_FIRST_TOKEN, "");
        return CommandHolder.getCommand(commandName);
    }

    private static void validate(User sender, SkypeCommand command) {
        Command commandAnnotation = AnnotationUtil.getAnnotation(Command.class, command.getClass(), true);
            boolean authorizedOnly = commandAnnotation.authorizedOnly();

            if(authorizedOnly && !SkypeServer.isAuthorized(sender))
                throw new SecurityException("Command " + commandAnnotation.name() + " can be called only by authorized user");
    }
}
