package com.kupal.skypeCommand.skype;

import com.kupal.skypeCommand.skype.impl.SkypeProfileFactory;
import com.skype.Skype;
import com.skype.SkypeException;

/**
 * Skype server
 * 
 * @author Kupal 3kb
 */
public final class SkypeServer {

    private static String profileId;
    private static boolean skypeServerStarted;

    /**
     * Starting skype server
     *
     * @param profile - profile of skype server
     */
    public static void start(SkypeProfile profile) {
        try {
            Skype.addApplication(profile.getAppName());
            Skype.setDeamon(false);
            Skype.addChatMessageListener(profile.getCommandMessageListener());
            skypeServerStarted = true;
            profileId = Skype.getProfile().getId();
        } catch (SkypeException e) {
            e.printStackTrace();
            skypeServerStarted = false;
        }
    }

    public static void start() {
        start(SkypeProfileFactory.create());
    }

    public static String getProfileId() {
        return profileId;
    }

    public static boolean isSkypeServerStarted() {
        return skypeServerStarted;
    }
}
