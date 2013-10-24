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
    private WavePlayer wavePlayer;
    
    public Notification(String notificationName, String notificationDescription)
    {
        this.notificationName = notificationName;
        this.notificationDescription = notificationDescription;
        wavePlayer = new WavePlayer();
    }
    
    public String getNotificationName()
    {
        return notificationName;
    }
    
    public String getNotificationDescription()
    {
        return notificationDescription;
    }
    
    public void Notify(mainLogic ml)
    {
        trayNotification();
        audioNotification(ml);
    }
    
    private void trayNotification()
    {
        NotificationIcon.displayMessage(getNotificationName(), getNotificationDescription(), TrayIcon.MessageType.INFO);
    }
    
    private void audioNotification(mainLogic ml)
    {
        // TODO get this from the settings
        wavePlayer.playSound(ml.getNotificationSoundPath());
    }
}
