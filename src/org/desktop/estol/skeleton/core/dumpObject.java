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

    Thread t;
    Throwable e;

    dumpObject(Thread t, Throwable e)
    {
        this.t = t;
        this.e = e;
    }

    String getThreadName()
    {
        return t.getName();
    }

    String getErrorMessage()
    {
        return e.getMessage();
    }
}
    
