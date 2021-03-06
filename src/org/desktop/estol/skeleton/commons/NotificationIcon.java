package org.desktop.estol.skeleton.commons;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.desktop.estol.skeleton.applicationlogic.MainLogic;
import org.desktop.estol.skeleton.debug.DebugUtilities;
import org.desktop.estol.skeleton.system.exceptions.InternalErrorException;
import org.desktop.estol.skeleton.system.windowloader.LoadWindow;
import org.desktop.estol.skeleton.windows.AddEventWindow;

/**
 * A little explanation on the enum type here: we need to GUARANTEE that at any
 * time, in the program's runtime there will be only ONE icon - generated by 
 * this code - on the system's notification area.
 * 
 * @author estol
 */
public enum NotificationIcon
{
    NotificationIcon;
    
    private static PopupMenu systrayIconMenu = new PopupMenu();
    private static TrayIcon icon;
    private static final SystemTray tray = SystemTray.getSystemTray();
    
    private static boolean started = false;
    
    private static AddEventWindow aew;
    
    public static void initSystrayIcon()
    {
        try
        {
            if (!SystemTray.isSupported())
            {
                DebugUtilities.addDebugMessage
                        ("Systray icon is not supported on this platform!");
            }
            icon = new TrayIcon(CommonUtilities.createImage("TrayIcon.gif", "Tray icon", NotificationIcon.getClass()));
            icon.setImageAutoSize(true);
            icon.setToolTip("org.desktop.estol.sekleton");
            
            MenuItem exitItem = new MenuItem();
            exitItem.setLabel("Exit");
            exitItem.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    LoadWindow.Terminate();
                }
            });
            
            MenuItem addEventItem = new MenuItem();
            addEventItem.setLabel("Create a new event");
            addEventItem.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if (aew != null && aew.isVisible()) {
                        aew.setVisible(false);
                    } else {
                        if (aew == null) {
                            try {
                                aew = new AddEventWindow(MainLogic.getInstance());
                            } catch (InternalErrorException ex) {
                                DebugUtilities.addDebugMessage(ex.getMessage());
                            }
                        }
                        new LoadWindow(aew);
                    }
                }
            });
            
            systrayIconMenu.add(addEventItem);
            systrayIconMenu.addSeparator();
            systrayIconMenu.add(exitItem);
            
            icon.setPopupMenu(systrayIconMenu);
            tray.add(icon);
        }
        catch (Throwable t)
        {
            StringBuilder sb = new StringBuilder();
            sb.append("Exception caught in application logic: ");
            sb.append(t.getMessage());
            DebugUtilities.addDebugMessage(sb.toString());
        }
        started = true;
    }

    public static void removeSystrayIcon()
    {
        if (started) {
            tray.remove(icon);
            started = false;
        }
    }
    
    public boolean isStarted()
    {
        return started;
    }
    
    public static void displayMessage(String caption,
            String message,
            MessageType msgType)
    {
        icon.displayMessage(caption, message, msgType);
    }
}
