package com.kupal.skypeCommand.command.impl;

import com.kupal.skypeCommand.command.SkypeCommand;
import com.kupal.skypeCommand.command.CommandHolder;
import com.kupal.skypeCommand.exception.CommandException;
import com.kupal.skypeCommand.response.CommandResponse;
import com.kupal.skypeCommand.request.CommandRequest;
import com.kupal.skypeCommand.request.impl.HelpRequest;
import com.kupal.skypeCommand.annotations.*;
import com.kupal.skypeCommand.util.StringUtils;
import com.kupal.skypeCommand.util.ClassUtil;

import java.util.Map;
import java.lang.reflect.Field;

/**
 * @author Kupal 3kb
 */
@Command(name = "HELP_CMD")
@Description("Retrieve list of registered command(s) with info")
@Request(requestClass = HelpRequest.class)
public class HelpCommand extends SkypeCommand {

    public CommandResponse execute(CommandRequest request) throws CommandException {
        HelpRequest helpRequest = (HelpRequest)request;
        CommandResponse response = helpRequest.getResponse();
        StringBuilder responseText = new StringBuilder();

        Map<String,Class<? extends SkypeCommand>> commands = CommandHolder.getRegisteredCommands();
        String cmdName = helpRequest.getCmd();

        if(StringUtils.isNotEmpty(cmdName)) {
            Class<? extends SkypeCommand> commandClass = commands.get(cmdName);
            String commandInfo = getCommandInfo(commandClass, cmdName);

            if(StringUtils.isEmpty(commandInfo))
                throw new CommandException("Command <" + cmdName + "> does not exist");

            responseText.append(commandInfo);
        } else {
            for (String commandName : commands.keySet()) {
                String commandInfo = getCommandInfo(commands.get(commandName), commandName);
                responseText.append(commandInfo);
            }
        }

        response.setResponseText(responseText.toString());
        
        return response;
    }

    private String getCommandInfo(Class<? extends SkypeCommand> commandClass, String commandName) {
        if(commandClass.equals(ErrorCommand.class))
            return "";

        StringBuilder info = new StringBuilder("\n====================");
        StringBuilder eg   = new StringBuilder("\ne.g. ");

        eg.append(SkypeCommand.CMD_FIRST_TOKEN);
        eg.append(commandName);

        info.append("\nName: ");
        info.append(commandName);

        if(AnnotationUtil.hasDescription(commandClass)) {
            info.append("\n");
            info.append(AnnotationUtil.getAnnotation(Description.class, commandClass, true).value());
        }

        Class<? extends CommandRequest> commandRequestClass = AnnotationUtil.getAnnotation(Request.class, commandClass, true).requestClass();
        Field[] declaredFields = ClassUtil.getAnnotatedDeclaredFields(commandRequestClass, CmdParam.class, true);

        if(declaredFields.length > 0) {
            info.append("\nParameters:");
        }

        for (Field field : declaredFields) {

            CmdParam annotation = field.getAnnotation(CmdParam.class);

            info.append("\n");

            String paramName = annotation.name();
            boolean required = annotation.required();
            Class<?> type    = field.getType();

            if(StringUtils.isEmpty(paramName)) {
                paramName = field.getName();
            }

            info.append(paramName);
            info.append(" (");
            info.append(required ? "" : "not ").append("required ");
            info.append(type.getSimpleName());
            info.append(")");

            if(AnnotationUtil.hasDescription(field)) {
                info.append(" - ");
                info.append(field.getAnnotation(Description.class).value());
            }

            eg.append(" ");
            eg.append(paramName);
            eg.append(SkypeCommand.KEY_VALUE_SEPARATOR);
            eg.append("value");
        }

        info.append(eg.toString());
        return info.toString();
    }
}
