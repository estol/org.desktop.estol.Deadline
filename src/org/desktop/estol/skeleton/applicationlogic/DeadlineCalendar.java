package org.desktop.estol.skeleton.applicationlogic;

import java.io.Serializable;
import java.util.Date;

/**
 * DeadlineCalendar class contains the data structure behind the program
 * each individual object is serializable, and should be cascaded into a
 * DeadlineCalendarContainer, which is also serializable, and is written
 * to the disk.
 * 
 * @author estol
 */
public class DeadlineCalendar implements Serializable
{
    private static final long serialVersionUID = 6575471230L;
    
    private Date d;
    private String notificationName;
    private String notificationDescription;
    private boolean recurring;
    
    /**
     * Creates a new DeadlineCalendar object
     * 
     * @param d the exact date and time this object will trigger a notification
     * @param notificationName the name of the notification triggered by this object
     * @param notificationDescription the description of the notification triggered by this object
     * @param recurring  flags if the event is recurring, this is NotYetImplemented #TODO implement recurring events
     */
    public DeadlineCalendar(Date d, String notificationName, String notificationDescription, boolean recurring)
    {
        setDate(d);
        setNotificationName(notificationName);
        setNotificationDescription(notificationDescription);
        setRecurring(recurring);
    }
    
    /**
     * private setter for date property
     * @param d 
     */
    private void setDate(Date d)
    {
        this.d = d;
    }
    
    /**
     * private setter for name property
     * @param notificationName 
     */
    private void setNotificationName(String notificationName)
    {
        this.notificationName = notificationName;
    }
    
    /**
     * private setter for description property
     * @param notificationDescription 
     */
    private void setNotificationDescription(String notificationDescription)
    {
        this.notificationDescription = notificationDescription;
    }
    
    /**
     * private setter for recurring property
     * @param recurring 
     */
    private void setRecurring(boolean recurring)
    {
        this.recurring = recurring;
    }
    
    /**
     * public getter for the recurring property
     * @return 
     */
    public boolean getRecurring()
    {
        return recurring;
    }
    
    /**
     * public getter for the date property
     * @return 
     */
    public Date getDate()
    {
        return d;
    }
    
    /**
     * public getter for the name property
     * @return 
     */
    public String getName()
    {
        return notificationName;
    }
    
    /**
     * public getter for the description property
     * @return 
     */
    public String getDescription()
    {
        return notificationDescription;
    }
    
    /**
     * human friendly String type,
     * containing the name and the date of the event
     * @return 
     */
    public String generateListFriendlyName()
    {
        return getDate().toString() + " - " + getName();
    }
    
    /**
     * Returns a Notification object, which is specialized to trigger
     * a notification.
     * 
     * @return 
     */
    public Notification generateNotification()
    {
        return new Notification(notificationName, notificationDescription);
    }
}
