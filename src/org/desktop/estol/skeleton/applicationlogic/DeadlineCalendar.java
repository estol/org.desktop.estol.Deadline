package org.desktop.estol.skeleton.applicationlogic;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author estol
 */
public class DeadlineCalendar implements Serializable
{
    /**
     * DeadlineCalendar class contains the data structure behind the program
     * each individual file is serializable, and should be cascaded into a
     * DeadlineCalendarContainer, which is also serializable, and is written
     * to the disk.
     */
    private static final long serialVersionUID = 6575471230L;
    
    private Date d;
    private String createdTimeStamp;
    private String notificationName;
    private String notificationDescription;
    private boolean recurring;
    
    public DeadlineCalendar(Date d, String notificationName, String notificationDescription, boolean recurring)
    {
        setDate(d);
        setNotificationName(notificationName);
        setNotificationDescription(notificationDescription);
        setRecurring(recurring);
        createdTimeStamp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime());
    }
    
    private void setDate(Date d)
    {
        this.d = d;
    }
    
    private void setNotificationName(String notificationName)
    {
        this.notificationName = notificationName;
    }
    
    private void setNotificationDescription(String notificationDescription)
    {
        this.notificationDescription = notificationDescription;
    }
    
    private void setRecurring(boolean recurring)
    {
        this.recurring = recurring;
    }
    
    public Date getDate()
    {
        return d;
    }
    
    public String getName()
    {
        return notificationName;
    }
    
    public String getDescription()
    {
        return notificationDescription;
    }
    
    public String getCreatedTimeStamp()
    {
        return createdTimeStamp;
    }
    
    public String generateListFriendlyName()
    {
        return getDate().toString() + " - " + getName();
    }
    
    public Notification generateNotification()
    {
        return new Notification(notificationName, notificationDescription);
    }
}
