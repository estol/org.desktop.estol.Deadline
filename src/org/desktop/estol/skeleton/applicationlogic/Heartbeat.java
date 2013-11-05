package org.desktop.estol.skeleton.applicationlogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.desktop.estol.skeleton.commons.NumericUtilities;
import org.desktop.estol.skeleton.commons.ThreadedUtility;
import org.desktop.estol.skeleton.debug.DebugUtilities;

/**
 * Defines a Heartbeat to the program. Once the thread started it can only be stopped
 * by the method shutdown, which changes the condition of the loop the thread is 
 * running in to false, therefore causing the thread to reach the end of the loop,
 * effectively ending the execution of the thread.
 * 
 * The Heartbeat checks the DeadlineCalendar objects contained in a
 * DeadlineCalendarContainer if they have expired (in a three second window around the
 * exact date) if it did, a Notification is triggered, the event is removed from the
 * list of active events, and added to the list of expired events
 * 
 * @author estol
 */
public class Heartbeat implements ThreadedUtility, Runnable
{

    private boolean runFlag = false;
    private boolean updateFlag = true;
    private MainLogic ml;
    
    /**
     * This thread makes sure the lists on the GUI are refreshed, so we need
     * a reference of the mainLogic object.
     * @param ml 
     */
    public Heartbeat(MainLogic ml)
    {
        this.ml = ml;
    }
    /**
     * One of the marks of poor design in ThreadedUtility interface. The method
     * cannot be used in all ThreadedUtility, but in some it is crucial.
     */
    @Override
    public void display()
    {
        // Not Used!
    }

    /**
     * flags the thread to end execution
     */
    @Override
    public void shutdown()
    {
        runFlag = false;
    }

    /**
     * Checks if the runFlag is still true. if it is, and the thread has been
     * started, there is a good chance the thread is running.
     * @return 
     */
    @Override
    public boolean isRunning()
    {
        return runFlag;
    }

    /**
     * Called from outside the Heartbeat object, to indicate if the initial 
     * parameters should be refreshed.
     */
    public void triggerUpdate()
    {
        updateFlag = true;
    }
    
    /**
     * the big loop
     */
    @Override
    public void run()
    {
        Thread.currentThread().setName("Heartbeat");
        runFlag = true;
        while (runFlag)
        {
            try {
                //DebugUtilities.addDebugMessage("Heartbeat thread running!");
                Iterator<DeadlineCalendar> iterator = ml.eventList.iterator();
                while(iterator.hasNext())
                {
                    DeadlineCalendar dc = iterator.next();
                    if (new Date().after(dc.getDate()))
                    {
                        dc.generateNotification().Notify(ml);
                        ml.fillPastEventList(dc);
                        iterator.remove();
                        ml.filCurrentlEventList();
                        ml.saveDcc();
                    }
                }
                Thread.sleep(NumericUtilities.ONE_SECOND * 3L);
            }
            catch (InterruptedException e)
            {
                DebugUtilities.addDebugMessage(e.getMessage());
            }
        }
    }
    
}
