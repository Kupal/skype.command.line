package com.kupal.skypeCommand.command;

import com.kupal.skypeCommand.request.CommandRequest;
import com.kupal.skypeCommand.response.CommandResponse;
import com.kupal.skypeCommand.response.ResponseFactory;
import com.kupal.skypeCommand.util.StringUtils;
import com.kupal.skypeCommand.util.ClassUtil;
import com.kupal.skypeCommand.annotations.Request;
import com.kupal.skypeCommand.annotations.AnnotationUtil;
import com.kupal.skypeCommand.annotations.process.Processor;
import com.kupal.skypeCommand.annotations.process.ProcessorHolder;
import com.kupal.skypeCommand.annotations.process.AnnotationProcessorException;

/**
 * @author Kupal 3kb
 */
public class CommandRunner {

    public static CommandResponse execute(String commandLine) {
        SkypeCommand command    = getCommand(commandLine);
        Class<? extends CommandRequest> requestClass = AnnotationUtil.getAnnotation(Request.class, command.getClass(), true).requestClass();
        Processor processor     = ProcessorHolder.getProcessor(Request.class);
        CommandRequest request  = ClassUtil.getInstance(requestClass);
        CommandResponse response;
        try {
            request.addParam(CommandRequest.COMMAND_LINE_PARAM, commandLine);
            processor.process(request);
            response = command.execute(request);
        } catch (AnnotationProcessorException e) {
            response = ResponseFactory.create(e);
        } catch (CommandException e) {
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
}
