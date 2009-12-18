package com.kupal.skypeCommand.util;

import com.kupal.skypeCommand.annotations.Command;
import com.kupal.skypeCommand.command.SkypeCommand;

/**
 * @author Kupal 3kb
 */
public class CommandAnnotationsUtil {

    public static String getCommandName(Class<? extends SkypeCommand> clazz) {
        String name = null;
        boolean isCommand = clazz.isAnnotationPresent(Command.class);

        if(isCommand) {
            Command commandAnnotation = clazz.getAnnotation(Command.class);
            name = commandAnnotation.name();
        }

        return name;
    }

    public static boolean isCommand(Class<? extends SkypeCommand> clazz) {
        return clazz.isAnnotationPresent(Command.class);
    }
}
