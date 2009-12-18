package com.kupal.skypeCommand.skype.impl;

import com.kupal.skypeCommand.skype.CommandMessageListener;
import com.kupal.skypeCommand.skype.SkypeProfile;

/**
 * @author Kupal 3kb
 */
class CommonSkypeProfile implements SkypeProfile {

    private CommandMessageListener commandMessageListener;
    private String appName;

    public CommandMessageListener getCommandMessageListener() {
        return commandMessageListener;
    }

    public void setCommandMessageListener(CommandMessageListener commandMessageListener) {
        this.commandMessageListener = commandMessageListener;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
