package org.desktop.estol.skeleton.magic.GameScenarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.desktop.estol.skeleton.magic.GoldenTicket;

/**
 *
 * @author estol
 */
public class Scenario
{
    //private Table gameEvents;
    
    private static class Table implements Iterable
    {
        scenarioTableIterator iterator = new scenarioTableIterator();
        
        /*
        ArrayList<String> adventureText = new ArrayList();
        ArrayList<String[]> choices     = new ArrayList();
        ArrayList<GoldenTicket> states  = new ArrayList();
        */
        
        HashMap<String, HashMap<String[], GoldenTicket[]>> adventure = new HashMap();
        String ScenarioName;
        
        Table(String scenarioName)
        {
            ScenarioName = scenarioName;
        }
        
        public void addAdventure(String s, String[] choices, GoldenTicket[] states) throws IllegalArgumentException
        {
            HashMap <String[], GoldenTicket[]> choicesState = new HashMap();
            if (choices.length != states.length)
            {
                throw new IllegalArgumentException("Not enough state for choices, or vice versa!");
            }
            
            choicesState.put(choices, states);
            adventure.put(s, choicesState);
        }
        
        public HashMap<String, HashMap<String[], GoldenTicket[]>> getAdventure()
        {
            return adventure;
        }
        
        @Override
        public scenarioTableIterator iterator()
        {
            return iterator;
        }
    
    }
    
    private static class scenarioTableIterator implements Iterator
    {

        @Override
        public boolean hasNext()
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object next()
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    public Scenario()
    {
        
    }
}
