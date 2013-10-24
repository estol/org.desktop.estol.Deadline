package org.desktop.estol.skeleton.applicationlogic;

/**
 *
 * @author estol
 */
public class Notification
{
    private String notificationName;
    private String notificationDescription;
    
    public Notification(String notificationName, String notificationDescription)
    {
        this.notificationName = notificationName;
        this.notificationDescription = notificationDescription;
    }
    
    public String getNotificationName()
    {
        return notificationName;
    }
    
    public String getNotificationDescription()
    {
        return notificationDescription;
    }
}
