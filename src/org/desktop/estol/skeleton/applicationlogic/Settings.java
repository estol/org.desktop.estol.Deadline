package org.desktop.estol.skeleton.applicationlogic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.desktop.estol.skeleton.magic.GameScenarios.Scenario;

/**
 *
 * @author estol
 */
public class Settings implements Serializable
 {
     private static final long serialVersionUID = 2859210570L;
     
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
     
     /*
     public void addScenario(String name, Scenario scenario)
     {
         settings.put(name, scenario);
     }
     
     public Scenario getScenario(String name)
     {
         return (Scenario) settings.get(name);
     }
     
     public HashMap<String, Scenario> getAllScenario()
     {
         Iterator iterator = settings.entrySet().iterator();
         HashMap<String, Scenario> scenarios = new HashMap();
         
         while (iterator.hasNext())
         {
             Map.Entry<String, Scenario> scenario = (Map.Entry) iterator.next();
             if (scenario.getValue() instanceof Scenario)
             {
                 scenarios.put(scenario.getKey(), scenario.getValue());
             }
         }
         
         return scenarios;
     }
     */
 }
