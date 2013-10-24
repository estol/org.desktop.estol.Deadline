package org.desktop.estol.skeleton.applicationlogic;

import java.awt.TrayIcon;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.desktop.estol.skeleton.commons.NotificationIcon;
import org.desktop.estol.skeleton.commons.NumericUtilities;
import org.desktop.estol.skeleton.commons.ThreadedUtility;
import org.desktop.estol.skeleton.debug.DebugUtilities;

/**
 *
 * @author estol
 */
public class Heartbeat implements ThreadedUtility, Runnable
{

    private boolean runFlag = false;
    private boolean updateFlag = true;
    private mainLogic ml;
    
    public Heartbeat(mainLogic ml)
    {
        this.ml = ml;
    }
    
    @Override
    public void display() {
        // NYI
    }

    @Override
    public void shutdown() {
        runFlag = false;
    }

    @Override
    public boolean isRunning() {
        return runFlag;
    }

    public void triggerUpdate()
    {
        updateFlag = true;
    }
    
    @Override
    public void run() {
        Thread.currentThread().setName("Heartbeat");
        runFlag = true;
        DeadlineCalendarContainer dcc = ml.getDcc();
        ArrayList<DeadlineCalendar> eventList = dcc.getEvents();
        while (runFlag)
        {
            try {
                if (updateFlag)
                {
                    dcc = ml.getDcc();
                    eventList = dcc.getEvents();
                }
                //DebugUtilities.addDebugMessage("Heartbeat thread running!");
                Iterator<DeadlineCalendar> iterator = eventList.iterator();
                while(iterator.hasNext())
                {
                    DeadlineCalendar dc = iterator.next();
                    if (new Date().after(dc.getDate()))
                    {
                        Notification notification = dc.generateNotification();
                        NotificationIcon.displayMessage(notification.getNotificationName(), notification.getNotificationDescription(), TrayIcon.MessageType.INFO);
                        iterator.remove();
                    }
                }
                Thread.sleep(NumericUtilities.ONE_SECOND);
            }
            catch (InterruptedException e)
            {
                DebugUtilities.addDebugMessage(e.getMessage());
            }
        }
    }
    
}
