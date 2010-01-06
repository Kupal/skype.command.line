package com.kupal.skypeCommand.validator.annotation.impl;

import com.kupal.skypeCommand.annotations.Command;
import com.kupal.skypeCommand.exception.AnnotationValidationException;
import com.kupal.skypeCommand.validator.annotation.AnnotationValidator;
import com.kupal.skypeCommand.command.SkypeCommand;

/**
 * @author Kupal 3kb
 */
public class CommandValidator implements AnnotationValidator<Class<SkypeCommand>> {

    public void validate(Class<SkypeCommand> skypeCommandClass) throws AnnotationValidationException {
        boolean isCommand = skypeCommandClass.isAnnotationPresent(Command.class);

        if(!isCommand)
            throw new AnnotationValidationException(skypeCommandClass.getName() + " should be annotated by " + Command.class.getName());
    }
}
