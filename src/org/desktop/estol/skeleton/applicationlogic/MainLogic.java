package org.desktop.estol.skeleton.applicationlogic;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import org.desktop.estol.skeleton.commons.ObjectStreamReader;
import org.desktop.estol.skeleton.commons.ObjectStreamWriter;
import org.desktop.estol.skeleton.system.exceptions.InternalErrorException;


/**
 * Defines the main logic of the application.
 * In this particular case, it defines the reading of a settings file, or creating one
 * if it doesn't exist, then the reading of a calendar file containing the events,
 * or creating an empty if it doesn't exist.
 * Makes sure the events are listed in the eventList
 * And last but not least, makes sure the Heartbeat thread is running if there is an event
 * 
 * Poor design choice: this class should be a singleton at least, or it would even qualify as
 * enum, with some added states to it.
 * I like it stateless more, but stateful is closer to the OOP.
 * 
 * 
 * @author estol
 */

public class MainLogic
{    
    
    private static final String defaultNotificationSoundPath = "Sounds" + System.getProperty("file.separator") + "ping2.wav";
    private static final String defaultDccPath = "dcc.bin";
    
    private Settings settings;
    private boolean existsFlag = false;
    private static DeadlineCalendarContainer dcc;
    private String currentDccPath = null;
    private String currentNotificationSoundPath = null;
    private DefaultListModel clm;
    private DefaultListModel plm;
    private Heartbeat hb = null;
    protected static ArrayList<DeadlineCalendar> eventList;
    
    /**
     * in case someone wants to add an event from the tray icon, I keel one instance of itself contained.
     */
    private static MainLogic instance = null; // looks like a singleton but it is not, object oriented design abomination is what this is.
    
    public void setInstance(MainLogic instance)
    {
        MainLogic.instance = instance;
    }
    
    /**
     * Returns the instance of MainLogic.
     * Very poor design choice, not making this an enum...
     * 
     * @return
     * @throws InternalErrorException 
     */
    public static MainLogic getInstance() throws InternalErrorException
    {
        if (instance == null)
        {
            throw new InternalErrorException("MainLogic object weren't initialized!");
        }
        return instance;
    }
    
    /**
     * creates a new instance, but there should be only one, so "mind the gap"
     * requires the ListModel of the current events, and the passed events.
     * @param clm
     * @param plm 
     */
    public MainLogic(DefaultListModel clm, DefaultListModel plm)
    {
        initialize();
        this.clm = clm;
        this.plm = plm;
        if (existsFlag)
        {
            loadDcc();
            fillCurrentEventList();
        }
    }
    
    /**
     * Deletes the event with the specified index from the eventList ArrayList
     * @param index 
     */
    public void deleteEvent(int index)
    {
        if (eventList.size() != 0)
        {
            fillPastEventList(eventList.get(index));
            eventList.remove(index);
            fillCurrentEventList();
            saveDcc();
        }
        else
        {
            clm.clear();
        }
    }
    
    /**
     * makes sure, the Heartbeat thread stops.
     * also saves the calendar object with the current eventList,
     * so the program can retain its working state when shut down
     */
    public void shutdown()
    {
        if (hb.isRunning())
        {
            hb.shutdown();
        }
        //saveSettings();
        saveDcc();
    }
    
    /**
     * private member, initializes the logic by
     * - instantiating the Heartbeat class, so a thread can run, and
     * - loads the settings via loadSettings private member, which starts a Heartbeat
     * thread, if it is required.
     */
    private void initialize()
    {
        hb = new Heartbeat(this);
        loadSettings();
    }
    
    /**
     * checks if settings.bin exists. In case it does, we read it, to a settings object
     * and try to get the path of the notification sound, and the path of the calendar
     * container from it.
     * in case it doesn't, it will try to create a new file.
     */
    private void loadSettings()
    {
        if (new File("settings.bin").exists())
        {
            existsFlag = true;
            settings = (Settings) new ObjectStreamReader("settings.bin").read();
            currentDccPath = settings.getSetting("dccPath");
            currentNotificationSoundPath = settings.getSetting("notificationSoundPath");
            if (new File(currentDccPath).exists())
            {
                //dcc = (DeadlineCalendarContainer) new ObjectStreamReader(currentDccPath).read();
                loadDcc();
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
            settings.addSetting("notificationSoundPath", defaultNotificationSoundPath);
            settings.addSetting("dccPath", defaultDccPath);
            currentDccPath = defaultDccPath;
            currentNotificationSoundPath = defaultNotificationSoundPath;
            dcc = new DeadlineCalendarContainer();
            eventList = dcc.getEvents();
            saveSettings();
            saveDcc();
            if (hb != null && !hb.isRunning())
            {
                startHeartbeat();
            }
        }
    }
    /**
     * Adds an event to the list.
     * 
     * @param d the date of the event
     * @param notificationName the name of the event
     * @param notificationDescription the description of the event
     * @param recurring NOT YET IMPLEMENTED flags the event as recurring, making it persistent in the dcc and occuring on a specified interval
     */
    public void addDeadlineCalendarEvent(Date d, String notificationName, String notificationDescription, boolean recurring)
    {
        DeadlineCalendar dcEvent = new DeadlineCalendar(d, notificationName, notificationDescription, recurring);
        eventList.add(dcEvent);
        dcc.setEvents(eventList);
        saveDcc();
        fillCurrentEventList();
        //hb.triggerUpdate();
    }
    
    /**
     * returns the deadline calendar container object, which is written to the disk
     * @return
     */
    public DeadlineCalendarContainer getDcc()
    {
        return dcc;
    }
    
    /**
     * spawns a new thread, for the Heartbeat instance we already have set up in this object
     */
    private void startHeartbeat()
    {
        new Thread(hb).start();
    }
    
    /**
     * saves the settings object from MainLogic to settings.bin
     */
    private void saveSettings()
    {
        new Thread(new ObjectStreamWriter(settings, "settings.bin")).start();
    }
    
    /**
     * saves a foreign (ie not instantiated by MainLogic) settings object to settings.bin
     * @param s 
     */
    public void saveSettings(Settings s)
    {
        if (!s.isSettingSet("dccPath"))
        {
            s.addSetting("dccPath", defaultDccPath);
        }
        currentNotificationSoundPath = s.getSetting("notificationSoundPath");
        new Thread(new ObjectStreamWriter(s, "settings.bin")).start();
    }
    
    /**
     * saves the Deadline Calendar Container to the path currently set for dcc by the active Settings object of MainLogic
     */
    public void saveDcc()
    {
        dcc.setEvents(eventList);
        // (currentDccPath == null) ? settings.getSetting("dccPath") : defaultDccPath TERNARY AS PARAMETER?!?!?!?!?!?! GAMECHANGER!
        new Thread(new ObjectStreamWriter(dcc, currentDccPath)).start();
    }
    
    /**
     * Reads the Deadline Calendar Container and sets the eventlist to a new ArrayList instance,
     * or the ArrayList from the dcc we just have read.
     */
    private void loadDcc()
    {
        dcc = (DeadlineCalendarContainer) new ObjectStreamReader(currentDccPath).read();
        eventList = (dcc.getEvents() == null) ? new ArrayList() : dcc.getEvents();
    }
    
    /**
     * adds a DeadlineCalendar instance to the list of events passed.
     * @param dc 
     */
    protected void fillPastEventList(DeadlineCalendar dc)
    {
        plm.addElement(dc.generateListFriendlyName());
    }
    
    /**
     * fills up the actual event's list on the gui with events from the eventList
     * ArrayList.
     * 
     * Yes, I know the Iterator is the slowest form of looping through a pile of data,
     * but the difference is not that big, and the code looks more elegant.
     */
    protected final void fillCurrentEventList()
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
        else
        {
            clm.clear();
            hb.shutdown();
        }
            
    }
    
    /**
     * returns the path to the notification sounds
     * @return 
     */
    protected String getNotificationSoundPath()
    {
        return currentNotificationSoundPath;
    }
    
}
