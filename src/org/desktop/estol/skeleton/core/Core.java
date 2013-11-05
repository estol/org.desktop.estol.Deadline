package org.desktop.estol.skeleton.core;

/*
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;*/
import org.desktop.estol.skeleton.magic.GoldenTicket;
import org.desktop.estol.skeleton.system.windowloader.LoadWindow;
import org.desktop.estol.skeleton.windows.MainWindow;

/**
 * Entry point, loads the main window
 * 
 * @author estol
 */
public class Core {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler()); // see GlobalExceptionHandler.java
        /*
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher()
        {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e)
            {
                
            }
        });*/
        //GoldenTicket.init();
        new LoadWindow(new MainWindow());
    }
}
