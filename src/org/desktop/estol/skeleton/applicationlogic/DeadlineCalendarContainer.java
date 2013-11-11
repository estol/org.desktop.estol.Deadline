package org.desktop.estol.skeleton.applicationlogic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The DeadlineCalendarContainer class represents a basic datastructure
 * for containing DeadlineCalendar objects.
 * 
 * @author estol
 */
public class DeadlineCalendarContainer implements Serializable
{
    private static final long serialVersionUID = 5800435840L;
    
    private ArrayList<DeadlineCalendar> eventList = new ArrayList(); // list of DeadlineCalendar objects represented by this container
    
    /**
     * To avoid some complication I needed an empty constructor
     */
    public DeadlineCalendarContainer() {}
    
    /**
     * Adds a DeadlineCalendar type object to the ArrayList
     * @param dc 
     */
    public void addEvent(DeadlineCalendar dc)
    {
        eventList.add(dc);
    }
    
    /**
     * Returns one DeadlineCalendar object, based on it's index in the arraylist.
     * ONLY EXISTS FOR TESTING REASONS, DO NOT REMOVE YET!!!
     * 
     * @param index
     * @return 
     */
    @Deprecated
    public DeadlineCalendar getEvent(int index)
    {
        return eventList.get(index);
    }
    
    /**
     * Returns a copy of the reference to the ArrayList containing the dc objects.
     * highly inefficient.
     * 
     * @return 
     */
    public ArrayList<DeadlineCalendar> getEvents()
    {
        return eventList;
    }
    
    /**
     * Overwrites the eventList ArrayList with the ArrayList from the parameter dcc
     * @param dcc 
     */
    public void setEvents(ArrayList<DeadlineCalendar> dcc)
    {
        eventList = dcc;
    }
}
