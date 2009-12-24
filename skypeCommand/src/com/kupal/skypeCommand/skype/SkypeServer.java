package com.kupal.skypeCommand.skype;

import com.kupal.skypeCommand.skype.impl.SkypeProfileFactory;
import com.skype.*;

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

    public static void sendMessage(String userId, String text) {
        User user = getUser(userId);
        try {
            user.send(text);
        } catch (SkypeException e) {
            e.printStackTrace();
        }
    }

    public static User getUser(String userId) {
        User user = null;
        try {
            ContactList contactList = Skype.getContactList();
            user = contactList.getFriend(userId);

            if(user == null) {
                Friend[] notAuthorized = contactList.getAllUserWaitingForAuthorization();
                for (Friend friend : notAuthorized) {
                    if(friend.getId().equals(userId))
                        user = friend;
                }
            }
        } catch (SkypeException e) {
            e.printStackTrace();
            return user;
        }

        return user;
    }

    public static Friend[] getAllUserWaitingForAuthorization() {
        Friend[] notAuthorized = new Friend[0];

        try {
            notAuthorized = Skype.getContactList().getAllUserWaitingForAuthorization();
        } catch (SkypeException e) {
            e.printStackTrace();
        }

        return notAuthorized;
    }

    public static String getProfileId() {
        return profileId;
    }

    public static boolean isSkypeServerStarted() {
        return skypeServerStarted;
    }

    public static boolean isAuthorized(User user) {
        try {
            return user.isAuthorized();
        } catch (Exception e) {
            return false;
        }
    }
}
