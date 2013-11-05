package org.desktop.estol.skeleton.applicationlogic;

import java.io.Serializable;

/**
 *
 * @author estol
 */
public class Settings implements Serializable
 {
     private static final long serialVersionUID = 2829210570L;

     private String dccPath;
     private String notificationSoundPath;

     public void addDccPath(String path)
     {
         dccPath = path;
     }

     public void removeDccPath()
     {
         dccPath = "";
     }

     public String getDccPath()
     {
         return dccPath;
     }
     
     public void addNotificationSoundPath(String path)
     {
         notificationSoundPath = path;
     }
     
     public void removeNotificationSoundPath()
     {
         notificationSoundPath = "";
     }
     
     public String getNotificationSoundPath()
     {
         return notificationSoundPath;
     }
 }
