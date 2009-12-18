package com.kupal.skypeCommand.annotations.validator.impl;

import com.kupal.skypeCommand.annotations.Command;
import com.kupal.skypeCommand.annotations.validator.AnnotationValidationException;
import com.kupal.skypeCommand.annotations.validator.Validator;
import com.kupal.skypeCommand.command.SkypeCommand;

/**
 * @author Kupal 3kb
 */
public class CommandValidator implements Validator<Class<SkypeCommand>> {

    public boolean validate(Class<SkypeCommand> skypeCommandClass) throws AnnotationValidationException {
        boolean isCommand = skypeCommandClass.isAnnotationPresent(Command.class);

        if(!isCommand)
            throw new AnnotationValidationException(skypeCommandClass.getName() + " should be annotated by " + Command.class.getName());

        return true;
    }
}
