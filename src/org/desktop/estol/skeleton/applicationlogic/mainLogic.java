package org.desktop.estol.skeleton.applicationlogic;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import org.desktop.estol.skeleton.commons.ObjectStreamReader;
import org.desktop.estol.skeleton.commons.ObjectStreamWriter;


/**
 *
 * @author estol
 */

public class mainLogic
{    
    private Settings settings;
    private boolean existsFlag = false;
    private static DeadlineCalendarContainer dcc;
    
    public mainLogic(DefaultListModel lm)
    {
        initialize();
        if (existsFlag)
        {
            loadDcc(lm);
        }
    }
    
    public void shutdown()
    {
        saveSettings();
        saveDcc();
    }
    
    private void initialize()
    {
        loadSettings();
    }
    
    private void loadSettings()
    {
        if (new File("settings.bin").exists())
        {
            existsFlag = true;
            settings = (Settings) new ObjectStreamReader("settings.bin").read();
            dcc = (DeadlineCalendarContainer) new ObjectStreamReader(settings.getPath()).read();
        }
        else
        {
            settings = new Settings();
            settings.addPath("dcc.bin");
            dcc = new DeadlineCalendarContainer();
            saveSettings();
        }
    }
    
    public void addDeadlineCalendarEvent(Date d, String notificationName, String notificationDescription, boolean recurring)
    {
        DeadlineCalendar dcEvent = new DeadlineCalendar(d, notificationName, notificationDescription, recurring);
        dcc.addEvent(dcEvent);
    }
    
    public DeadlineCalendarContainer getDcc()
    {
        return dcc;
    }
    
    private void saveSettings()
    {
        new Thread(new ObjectStreamWriter(settings, "settings.bin")).start();
    }
    
    public void saveDcc()
    {
        new Thread(new ObjectStreamWriter(dcc, settings.getPath())).start();
    }
    
    public final void loadDcc(DefaultListModel lm)
    {
        dcc = (DeadlineCalendarContainer) new ObjectStreamReader(settings.getPath()).read();
        ArrayList<DeadlineCalendar> eventList = dcc.getEvents();
        Iterator<DeadlineCalendar> iterator = eventList.iterator();
        while(iterator.hasNext())
        {
            lm.addElement(iterator.next().getName());
        }
    }
}
