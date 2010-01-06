/**
 *
 * Last modified by: $Author: skrauchenia
 * $Revision: 117 $    $Date: 2009-03-17 13:28:15 +0200 (Tue, 17 Mar 2009) $
 */
package com.kupal.skypeCommand.command;

import com.kupal.skypeCommand.command.impl.HelpCommand;
import com.kupal.skypeCommand.command.impl.ErrorCommand;
import com.kupal.skypeCommand.util.CommandAnnotationsUtil;
import com.kupal.skypeCommand.util.ClassUtil;
import com.kupal.skypeCommand.util.StringUtils;
import com.kupal.skypeCommand.exception.AnnotationValidationException;
import com.kupal.skypeCommand.annotations.Command;
import com.kupal.skypeCommand.annotations.Request;
import com.kupal.skypeCommand.annotations.Response;
import com.kupal.skypeCommand.annotations.AnnotationUtil;
import com.kupal.skypeCommand.request.CommandRequest;
import com.kupal.skypeCommand.response.CommandResponse;
import com.kupal.skypeCommand.validator.ValidatorHolder;
import com.kupal.skypeCommand.validator.annotation.AnnotationValidator;

import java.util.Map;
import java.util.HashMap;

public class CommandHolder {

    private static final Map<String, Class<? extends SkypeCommand>> registeredCommands = new HashMap<String, Class<? extends SkypeCommand>>();

    static {
        try {
            registerCommand(HelpCommand.class);
            registerCommand(ErrorCommand.class);
        } catch (AnnotationValidationException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Class<? extends SkypeCommand>> getRegisteredCommands() {
        return registeredCommands;
    }

    public static void registerCommand(Class<? extends SkypeCommand> command) throws AnnotationValidationException {
        String commandName = CommandAnnotationsUtil.getCommandName(command);

        prt("==============================");
        prt("Register command:");
        prt("Name: " + commandName);
        prt("Class: " + command.getName());

        Class<? extends CommandRequest> commandRequestClass = AnnotationUtil.getAnnotation(Request.class, command, true).requestClass();
        Class<? extends CommandResponse> commandResponseClass = AnnotationUtil.getAnnotation(Response.class, command, true).responseClass();

        AnnotationValidator commandValidator = (AnnotationValidator)ValidatorHolder.getValidator(Command.class);
        AnnotationValidator requestValidator = (AnnotationValidator)ValidatorHolder.getValidator(Request.class);
        AnnotationValidator responseValidator = (AnnotationValidator)ValidatorHolder.getValidator(Response.class);

        commandValidator.validate(command);
        prt("Validation SUCCESS: " + command.getName());
        requestValidator.validate(commandRequestClass);
        prt("Validation SUCCESS: " + commandRequestClass.getName());
        responseValidator.validate(commandResponseClass);
        prt("Validation SUCCESS: " + commandResponseClass.getName());
        prt("Command " + commandName + " registered successfully");
        registeredCommands.put(commandName.toUpperCase(), command);
    }

    public static SkypeCommand getCommand(String commandName) {
        Class<? extends SkypeCommand> registered = ErrorCommand.class;

        if(StringUtils.isNotEmpty(commandName))
            registered = registeredCommands.get(commandName.toUpperCase());

        if(registered == null)
            registered = ErrorCommand.class;
        
        return ClassUtil.getInstance(registered);
    }

    public static SkypeCommand getErrorCommand() {
        return getCommand("ErrorCommand");
    }

    private static void prt(String s) {
        System.out.println(s);
    }
}
