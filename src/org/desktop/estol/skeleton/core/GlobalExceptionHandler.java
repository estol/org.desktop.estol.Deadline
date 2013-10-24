package org.desktop.estol.skeleton.core;

import java.lang.Thread.UncaughtExceptionHandler;
import org.desktop.estol.skeleton.commons.ObjectStreamWriter;

/**
 *
 * @author estol
 */
public class GlobalExceptionHandler implements UncaughtExceptionHandler
{
    /**
     * FIXME reading the dump doesn't work yet.
     * @param t
     * @param e 
     */
    @Override
    public void uncaughtException(Thread t, Throwable e)
    {
        long epoch = System.currentTimeMillis() / 1000L;
        String dumpFileName = Long.toString(epoch) + "DUMP.object";
        new Thread(new ObjectStreamWriter(new dumpObject(t, e), dumpFileName)).start();
        System.exit(1);
    }
}
