package org.desktop.estol.skeleton.applicationlogic;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author estol
 */
public class Settings implements Serializable
 {
     private static final long serialVersionUID = 2829210570L;
     
     private HashMap settings = new HashMap();

     public void addSetting(String name, String value)
     {
         settings.put(name, value);
     }
     
     public String getSetting(String name)
     {
         return (String) settings.get(name);
     }
     
     public boolean isSettingSet(String name)
     {
         return settings.containsKey(name);
     }
 }
