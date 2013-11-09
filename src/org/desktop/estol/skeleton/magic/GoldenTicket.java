package org.desktop.estol.skeleton.magic;

import java.util.ArrayList;
import org.desktop.estol.skeleton.applicationlogic.Settings;
import org.desktop.estol.skeleton.magic.GameScenarios.Scenario;

/**
 * 'Cause I've got a golden ticket
 * I've got a golden twinkle in my eye
 * 
 * @author estol
 */
public enum GoldenTicket
{
    GoldenTicket,
    
    INITIALIZE,
    SCENARIO_SELECTION,
    GAME_STATE,
    STATE_VICTORY,
    STATE_DEFEAT,
    RESTART;
    
    public final static String THE = "The ";
    
    public final static String stumbleUponMessage = "You have stumbled upon a secret, wanderer.\nDo you dare to continue?";
    public static final String gameOver = "You have been defeated!";
    public static final String victory = "Congratulations you have beaten the scenario!";
    public static final String askForName = "Hail to the Stranger, who stumbled upon, our hidden realm!\nWhat do you call yourself?\n";
    public static final String askForScenario = "?!\nI've heard tales about your adventures.\nCare to tell one?\n";
    
    private static ArrayList<Scenario> scenarios = new ArrayList();
    
    public static final String gameThemeMusic  = "Sounds" + System.getProperty("file.separator") + "gameMusic" + System.getProperty("file.separator") + "LamentOfTheHighborn.wav";
    public static final String gameGameOverSFX = "Sounds" + System.getProperty("file.separator") + "gameMusic" + System.getProperty("file.separator") + "gameOver.wav";
    public static final String gameVictorySFX  = "Sounds" + System.getProperty("file.separator") + "gameMusic" + System.getProperty("file.separator") + "victory.wav";
    
    public static boolean globalSoundsToggle = true;
    
    public static String playerName = null;
    
    private Scenario scenario = null;
    
    
    public Scenario loadScenario()
    {
        return new Scenario();
    }
    
    public void setPlayerName(String name)
    {
        playerName = name;
    }
    
    
}
