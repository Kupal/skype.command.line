package com.kupal.skypeCommand.skype.impl;

import com.kupal.skypeCommand.skype.CommandMessageListener;
import com.kupal.skypeCommand.skype.SkypeProfile;

/**
 * @author Kupal 3kb
 */
public class SkypeProfileFactory {
    private static final String DEFAUL_APPLICATION_NAME = "SkypeServer";

    public static SkypeProfile create() {
        return create(new CommonMessageListener(), DEFAUL_APPLICATION_NAME);
    }

    public static SkypeProfile create(CommandMessageListener commandMessageListener) {
        return create(commandMessageListener, DEFAUL_APPLICATION_NAME);
    }

    public static SkypeProfile create(String appName) {
        return create(new CommonMessageListener(), appName);
    }

    public static SkypeProfile create(CommandMessageListener commandMessageListener, String appName) {
        SkypeProfile skypeProfile = new CommonSkypeProfile();
        skypeProfile.setAppName(appName);
        skypeProfile.setCommandMessageListener(commandMessageListener);

        return skypeProfile;
    }
}
