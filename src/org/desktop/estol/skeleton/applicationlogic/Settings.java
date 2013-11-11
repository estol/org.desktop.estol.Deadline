package org.desktop.estol.skeleton.applicationlogic;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author estol
 */
public class Settings implements Serializable
 {
     private static final long serialVersionUID = 2859210570L;
     
     private HashMap settings = new HashMap();

     /**
      * puts the parameters into a HashMap datastructure, with the name parameter as key
      * and the value parameter as value
      * @param name
      * @param value 
      */
     public void addSetting(String name, String value)
     {
         settings.put(name, value);
     }
     
     /**
      * returns the value associated with the name parameter.
      * if there is no such parameter, it returns null.
      * @param name
      * @return 
      */
     public String getSetting(String name)
     {
         return (String) settings.get(name);
     }
     
     /**
      * true if there is a key -> value with the key set to name,
      * false otherwise
      * @param name
      * @return 
      */
     public boolean isSettingSet(String name)
     {
         return settings.containsKey(name);
     }
     
     /* //unused currently, used for my easter eggs.
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
