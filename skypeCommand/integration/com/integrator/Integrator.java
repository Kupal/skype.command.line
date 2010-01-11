package com.integrator;

import com.integrator.withoutparams.StartTomcatCommand;
import com.integrator.withparams.StartServerCommand;
import com.kupal.skypeCommand.command.CommandHolder;
import com.kupal.skypeCommand.exception.AnnotationValidationException;
import com.kupal.skypeCommand.skype.SkypeServer;

public class Integrator {

    public static void main(String[] args) {
        SkypeServer.start();
        try {
            CommandHolder.registerCommand(StartServerCommand.class);
            CommandHolder.registerCommand(StartTomcatCommand.class);
        } catch (AnnotationValidationException e) {
            e.printStackTrace();
        }
    }
}
