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
    private String dccPath = "dcc.bin";
    private String notificationSoundPath = "Sounds" + System.getProperty("file.separator") + "ping2.wav";
    private DefaultListModel clm;
    private DefaultListModel plm;
    private Heartbeat hb;
    
    public mainLogic(DefaultListModel clm, DefaultListModel plm)
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
            if (new File(settings.getDccPath()).exists())
            {
                dcc = (DeadlineCalendarContainer) new ObjectStreamReader(settings.getDccPath()).read();
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
            settings.addNotificationSoundPath(notificationSoundPath);
            settings.addDccPath(dccPath);
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
        dcc.addEvent(dcEvent);
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
        new Thread(new ObjectStreamWriter(dcc, settings.getDccPath())).start();
    }
    
    private void loadDcc()
    {
        dcc = (DeadlineCalendarContainer) new ObjectStreamReader(settings.getDccPath()).read();
    }
    
    protected void fillPastEventList(DeadlineCalendar dc)
    {
        plm.addElement(dc.generateListFriendlyName());
    }
    
    protected void filCurrentlEventList()
    {
        clm.clear();
        ArrayList<DeadlineCalendar> eventList = dcc.getEvents();
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

    protected String getNotificationSoundPath()
    {
        return notificationSoundPath;
    }
    
}
