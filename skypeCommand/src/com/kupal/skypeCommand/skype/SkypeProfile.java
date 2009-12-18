package com.kupal.skypeCommand.skype;

/**
 * Class which contain information for {@link SkypeServer </code>skype server<code>} initialization
 * 
 * @author Kupal 3kb
 */
public interface SkypeProfile {

    /**
     * retrieve CommandMessageListener property
     *
     * @return CommandMessageListener
     */
    CommandMessageListener getCommandMessageListener();

    /**
     * set CommandMessageListener property
     *
     * @param listener - CommandMessageListener implementation
     */
    void setCommandMessageListener(CommandMessageListener listener);

    /**
     * retrieve appName property
     *
     * @return appName
     */
    String getAppName();

    /**
     * set appName property
     *
     * @param appName - application name
     */
    void setAppName(String appName);
}
