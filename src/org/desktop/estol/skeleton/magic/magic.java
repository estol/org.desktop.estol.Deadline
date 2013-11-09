package org.desktop.estol.skeleton.magic;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.desktop.estol.skeleton.magic.GameScenarios.Scenario;

/**
 * You asked if anyone was creating a game. Nobody answered yes.
 * In such a short notice, I could only make up a text based rogue rpg.
 * 
 * Enjoy!
 * 
 * @author estol
 */
public class magic implements Runnable
{
    private JTextArea tale;
    private JTextField input;
    
    private GoldenTicket state;
    
    public magic(JTextArea taleArea, JTextField braveActionInput)
    {
        tale = taleArea;
        input = braveActionInput;
        tale.setEditable(false);
    }
    
    /**
     * I intialize the game here:
     * 1. get a name from the user,
     * 2. get the scenario of choice selected,
     * 3. finally, start up the game object, with the selected scenario
     * and exit the thread.
     * 
     */
    public void initializeGame()
    {
        tale.setText("");
        state = GoldenTicket.INITIALIZE;
        tale.setText(GoldenTicket.askForName);
        GoldenTicket.playerName = parseInput();
        state = GoldenTicket.SCENARIO_SELECTION;
        tale.setText(GoldenTicket.THE + GoldenTicket.playerName + GoldenTicket.askForScenario);
    }
    
    private String loadScenarioNames()
    {
        return "";
    }
    
    private String parseInput()
    {
        String command = input.getText();
        String parsed;
        
        switch(state)
        {
            case INITIALIZE:
                parsed = command;
                break;

            default:
                parsed = command;
        }
        return parsed;
    }
    
    @Override
    public void run()
    {
        
    }
}
