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

public class MainLogic
{    
    private Settings settings;
    private boolean existsFlag = false;
    private static DeadlineCalendarContainer dcc;
    private static final String defaultDccPath = "dcc.bin";
    private String currentDccPath = null;
    private String notificationSoundPath = "Sounds" + System.getProperty("file.separator") + "ping2.wav";
    private DefaultListModel clm;
    private DefaultListModel plm;
    private Heartbeat hb;
    protected static ArrayList<DeadlineCalendar> eventList;
    
    public MainLogic(DefaultListModel clm, DefaultListModel plm)
    {
        initialize();
        this.clm = clm;
        this.plm = plm;
        if (existsFlag)
        {
            loadDcc();
            filCurrentlEventList();
        }
    }
    
    public void deleteEvent(int index)
    {
        if (eventList.size() != 0)
        {
            eventList.remove(index);
            hb.triggerUpdate();
        }
        else
        {
            clm.clear();
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
            currentDccPath = settings.getSetting("dccPath");
            if (new File(currentDccPath).exists())
            {
                dcc = (DeadlineCalendarContainer) new ObjectStreamReader(currentDccPath).read();
            }
            else
            {
                dcc = new DeadlineCalendarContainer();
                saveDcc();
            }
        }
        else
        {
            settings = new Settings();
            settings.addSetting("notificationSoundPath", notificationSoundPath);
            settings.addSetting("dccPath", defaultDccPath);
            currentDccPath = defaultDccPath;
            dcc = new DeadlineCalendarContainer();
            saveSettings();
            saveDcc();
            if (hb != null && !hb.isRunning())
            {
                startHeartbeat();
            }
            //LoadWindow.getWindow("Main Window").setEnabled(false);
        }
    }
    
    public void addDeadlineCalendarEvent(Date d, String notificationName, String notificationDescription, boolean recurring)
    {
        DeadlineCalendar dcEvent = new DeadlineCalendar(d, notificationName, notificationDescription, recurring);
        eventList.add(dcEvent);
        dcc.setEvents(eventList);
        saveDcc();
        filCurrentlEventList();
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
    
    public static void saveSettings(Settings s)
    {
        new Thread(new ObjectStreamWriter(s, "settings.bin")).start();
    }
    
    public void saveDcc()
    {
        dcc.setEvents(eventList);
        // (currentDccPath == null) ? settings.getSetting("dccPath") : defaultDccPath TERNARY AS PARAMETER?!?!?!?!?!?! GAMECHANGER!
        new Thread(new ObjectStreamWriter(dcc, currentDccPath)).start();
    }
    
    private void loadDcc()
    {
        dcc = (DeadlineCalendarContainer) new ObjectStreamReader(currentDccPath).read();
        eventList = (dcc.getEvents() == null) ? new ArrayList() : dcc.getEvents();
    }
    
    protected void fillPastEventList(DeadlineCalendar dc)
    {
        plm.addElement(dc.generateListFriendlyName());
    }
    
    protected final void filCurrentlEventList()
    {
        if (eventList.size() > 0)
        {
            clm.clear();
            Iterator<DeadlineCalendar> iterator = eventList.iterator();
            while(iterator.hasNext())
            {
                clm.addElement(iterator.next().generateListFriendlyName());
            }
            if (hb != null && !hb.isRunning())
            {
                startHeartbeat();
            }
        }
            
    }

    protected String getNotificationSoundPath()
    {
        return notificationSoundPath;
    }
    
}
