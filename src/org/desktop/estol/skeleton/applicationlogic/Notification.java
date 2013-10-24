package org.desktop.estol.skeleton.applicationlogic;

import java.awt.TrayIcon;
import org.desktop.estol.skeleton.commons.NotificationIcon;

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
    
    public void Notify()
    {
        trayNotification();
        audioNotification();
    }
    
    private void trayNotification()
    {
        NotificationIcon.displayMessage(getNotificationName(), getNotificationDescription(), TrayIcon.MessageType.INFO);
    }
    
    private void audioNotification()
    {
        // NYI
        // TODO implement this function
    }
}
