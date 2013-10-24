package org.desktop.estol.skeleton.applicationlogic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author estol
 */
public class DeadlineCalendarContainer implements Serializable
{
    private long _id = 5800435840L;
    
    private ArrayList<DeadlineCalendar> eventList = new ArrayList();
    private String directory;
    private String filename;
    
    public DeadlineCalendarContainer(String directory, String filename)
    {
            this.directory = directory;
            this.filename = filename;
    }
    
    public void addEvent(DeadlineCalendar dc)
    {
        
    }
}
