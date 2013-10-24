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
    private DefaultListModel lm;
    private Heartbeat hb;
    
    public mainLogic(DefaultListModel lm)
    {
        initialize();
        this.lm = lm;
        if (existsFlag)
        {
            loadDcc();
            fillEventList();
        }
    }
    
    public void shutdown()
    {
        if (hb.isRunning())
        {
            hb.shutdown();
        }
        saveSettings();
        saveDcc();
    }
    
    private void initialize()
    {
        loadSettings();
        hb = new Heartbeat(this);
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
            if (!hb.isRunning())
            {
            startHeartbeat();
            }
        }
    }
    
    public void addDeadlineCalendarEvent(Date d, String notificationName, String notificationDescription, boolean recurring)
    {
        DeadlineCalendar dcEvent = new DeadlineCalendar(d, notificationName, notificationDescription, recurring);
        dcc.addEvent(dcEvent);
        saveDcc();
        fillEventList();
        hb.triggerUpdate();
    }
    
    public DeadlineCalendarContainer getDcc()
    {
        return dcc;
    }
    
    private void startHeartbeat()
    {
        new Thread(hb).start();
    }
    
    private void saveSettings()
    {
        new Thread(new ObjectStreamWriter(settings, "settings.bin")).start();
    }
    
    public void saveDcc()
    {
        new Thread(new ObjectStreamWriter(dcc, settings.getPath())).start();
    }
    
    private void loadDcc()
    {
        dcc = (DeadlineCalendarContainer) new ObjectStreamReader(settings.getPath()).read();
    }
    
    private void fillEventList()
    {
        lm.clear();
        ArrayList<DeadlineCalendar> eventList = dcc.getEvents();
        Iterator<DeadlineCalendar> iterator = eventList.iterator();
        while(iterator.hasNext())
        {
            lm.addElement(iterator.next().generateListFriendlyName());
        }
        if (!hb.isRunning())
        {
            startHeartbeat();
        }
    }
    
}
