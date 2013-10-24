package org.desktop.estol.skeleton.applicationlogic;

import java.awt.TrayIcon;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import org.desktop.estol.skeleton.commons.NotificationIcon;
import org.desktop.estol.skeleton.debug.DebugUtilities;

/**
 *
 * @author estol
 */

public class mainLogic
{
    private JSpinner s; // the panel containing the controls
    
    public mainLogic(JSpinner s)
    {
        /*
        JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "H:m:s");
        
        JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "d. M. y");
        
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(new Date());
        timeSpinner.setSize(120, 20);
        
        dateSpinner.setEditor(dateEditor);
        dateSpinner.setValue(new Date());
        dateSpinner.setSize(120, 20);
        
        p.add(timeSpinner);
        p.add(dateSpinner);
        */
        this.s = s;
        DebugUtilities.addDebugMessage(getDate().toString());
        // change so there is something to commit
    }
    
    public final Date getDate()
    {
        return (Date) s.getValue();
    }
}
