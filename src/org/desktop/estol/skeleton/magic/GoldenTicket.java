package org.desktop.estol.skeleton.magic;

import org.desktop.estol.skeleton.magic.GameScenarios.Scenario;

/**
 * 'Cause I've got a golden ticket
 * I've got a golden twinkle in my eye
 * 
 * @author estol
 */
public enum GoldenTicket
{
    GoldenTicket;
    
    public final static String introMessage = "You have stumbled upon a secret, wanderer.\nDo you dare to continue?";
    private static final String gameOver = "You have been defeated!";
    private static final String victory = "Congratulations you have beaten the scenario!";
    
    private static String playerName;
    
    
    public Scenario loadScenario(String path)
    {
        return new Scenario();
    }
}
