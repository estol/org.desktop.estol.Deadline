/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.desktop.estol.skeleton.core;

import java.io.Serializable;

/**
 *
 * @author estol
 */
public class dumpObject implements Serializable
{
    private static final long serialVersionUID = 8525574231L;

    String threadName;
    StackTraceElement[] ste;
    Throwable e;

    public dumpObject(Thread t, Throwable e)
    {
        threadName = t.getName();
        ste = t.getStackTrace();
        this.e = e;
    }

    public String getThreadName()
    {
        return threadName;
    }

    public StackTraceElement[] getStackTrace()
    {
        return ste;
    }
    
    public String getErrorMessage()
    {
        return e.getMessage();
    }
}
    
