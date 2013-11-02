package org.desktop.estol.skeleton.system.windowloader;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import org.desktop.estol.skeleton.commons.NotificationIcon;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import org.desktop.estol.skeleton.debug.DebugUtilities;
/**
 * FIXME: sometimes window reference count goes up without actually creating a window on Windows 8
 * Probably not a Swing/Java issue, because wxWidgets and Qt behaves like this sometimes. Heisenbug?
 * 
 * Runs the passed JFrame type, with threading in mind
 */
public class LoadWindow
{
    private static List<JFrame> windows = new ArrayList();
    
    private static class runnableWindow implements Runnable
    {
        volatile javax.swing.JFrame window = null;
        static int WindowCount = 0;

        /**
         * sets the windows position to the position I think is best for it:
         * the center of the first window.
         * 
         * 2013 11 02 2056
         */
        private void setWindowPosition()
        {
            GraphicsConfiguration gc = window.getGraphicsConfiguration();
            GraphicsDevice mainScreen = gc.getDevice();
            GraphicsConfiguration screenConfig = mainScreen.getDefaultConfiguration();
            window.setLocation((screenConfig.getBounds().x - window.getWidth()) / 2 , (screenConfig.getBounds().y - window.getHeight()) / 2);
            DebugUtilities.addDebugMessage(screenConfig.getBounds().x +" , " + screenConfig.getBounds().y);
        }
        
        public runnableWindow(javax.swing.JFrame window) {
            this.window = window;
        }

        @Override
        public void run() {
            WindowCount++;
            Thread.currentThread().setName("Window " + WindowCount);
            setWindowPosition();
            window.setVisible(true);
        }

        public static int getWindowCount() {
            return WindowCount;
        }

        public static void windowDestroyed() {
            WindowCount--;
        }
    }

    private static class windowManager
    {
        synchronized void showWindow(Runnable window) {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Metal".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                DebugUtilities.addDebugMessage(ex.getMessage());
            } catch (InstantiationException ex) {
                DebugUtilities.addDebugMessage(ex.getMessage());
            } catch (IllegalAccessException ex) {
                DebugUtilities.addDebugMessage(ex.getMessage());
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                DebugUtilities.addDebugMessage(ex.getMessage());
            }
            java.awt.EventQueue.invokeLater(window);
        }
    }
    
    public static int getWindowCount() {
        return runnableWindow.getWindowCount();
    }

    public static void windowDestroyed() {
        runnableWindow.windowDestroyed();
    }

    final runnableWindow runnableWindowWrapper(javax.swing.JFrame w) {
        return new runnableWindow(w);
    }

    final void windowManagerWrapper(Runnable w) {
        new windowManager().showWindow(w);
    }

    public static JFrame getWindow(String title)
    {
        JFrame theWindow = null;
                
        for (JFrame w : windows)
        {
            if (title.equals(w.getTitle()))
            {
                theWindow = w;
                break;
            }
        }
        
        return theWindow;
    }
    
    public static void Terminate()
    {
        for (JFrame w : windows)
        {
            w.dispose();
        }
        NotificationIcon.removeSystrayIcon();
        System.exit(0);
    }
    
    public LoadWindow(JFrame w) {
        windows.add(w);
        DebugUtilities.headlessDebugConsoleThread();
        DebugUtilities.addDebugMessage("Loading window: " + w.getTitle());
        windowManagerWrapper(runnableWindowWrapper(w));
    }
}