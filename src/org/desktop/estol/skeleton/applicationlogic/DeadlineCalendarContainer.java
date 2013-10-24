package org.desktop.estol.skeleton.applicationlogic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author estol
 */
public class DeadlineCalendarContainer implements Serializable
{
    private static final long serialVersionUID = 5800435840L;
    
    private ArrayList<DeadlineCalendar> eventList = new ArrayList();
    
    public DeadlineCalendarContainer() {}
    
    public void addEvent(DeadlineCalendar dc)
    {
        eventList.add(dc);
    }
    
    public DeadlineCalendar getEvent(int index)
    {
        return eventList.get(index);
    }
    
    public ArrayList<DeadlineCalendar> getEvents()
    {
        return eventList;
    }
}
