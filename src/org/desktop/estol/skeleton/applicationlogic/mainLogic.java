package org.desktop.estol.skeleton.applicationlogic;

import java.util.Date;
import javax.swing.JSpinner;


/**
 *
 * @author estol
 */

public class mainLogic
{
    private JSpinner s; // the panel containing the controls
    
    public mainLogic(JSpinner s)
    {
        this.s = s;
    }
    
    public Date getDate()
    {
        return (Date) s.getValue();
    }
}
