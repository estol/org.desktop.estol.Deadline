package org.desktop.estol.skeleton.applicationlogic;

import java.io.Serializable;

/**
 *
 * @author estol
 */
public class Settings implements Serializable
 {
     private static final long serialVersionUID = 2829210970L;

     private String dccPath;

     public void addPath(String path)
     {
         dccPath = path;
     }

     public void removePath()
     {
         dccPath = "";
     }

     public String getPath()
     {
         return dccPath;
     }
 }
