package com.kupal.skypeCommand;

import com.kupal.skypeCommand.skype.SkypeServer;
import com.kupal.skypeCommand.command.CommandHolder;
import com.kupal.skypeCommand.validator.AnnotationValidationException;
import com.kupal.skypeCommand.command.TestCommand;

/**
 * @author Kupal 3kb
 */
public class Integrator {

    public static void main(String[] args) {
        SkypeServer.start();
        try {
            CommandHolder.registerCommand(TestCommand.class);
        } catch (AnnotationValidationException e) {
            e.printStackTrace();
        }
    }
}
