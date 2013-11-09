package org.desktop.estol.skeleton.applicationlogic;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.desktop.estol.skeleton.debug.DebugUtilities;
/**
 *
 * @author estol
 */
public class WavePlayer implements Runnable
{
    private final int BUFFER_SIZE = 192000;
    private File soundFile;
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceLine;
    private FloatControl gainControl;
    private String file;
    private boolean looped = false;
    
    private void startPlayback()
    {        
        try
        {
            soundFile = new File(file);
            audioStream = AudioSystem.getAudioInputStream(soundFile);
            audioFormat = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);
            sourceLine.start();
            gainControl = (FloatControl) sourceLine.getControl(FloatControl.Type.MASTER_GAIN);
            
            int nBytesRead = 0;
            byte[] abData = new byte[BUFFER_SIZE];
            while (nBytesRead != -1)
            {
                nBytesRead = audioStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0)
                {
                    sourceLine.write(abData, 0, nBytesRead);
                }
            }
            sourceLine.drain();
            sourceLine.close();
            if (looped)
            {
                startPlayback();
            }
        }
        catch (NullPointerException | UnsupportedAudioFileException | IOException | LineUnavailableException e)
        {
            DebugUtilities.addDebugMessage(e.getMessage());
            return;
        }
    }

    
    
    /**
     * 6.0206 max
     * -80.0 min
     * @param gain 
     */
    public void setVolume(float gain)
    {
        // linear scalar value of gain is 10^gain/20.0
        // measured in dB
        gainControl.setValue(gain); // also has a getter
    }
    
    public float getVolume()
    {
        return gainControl.getValue();
    }
    
    public void stopPlayback()
    {
        disableLooping();
        sourceLine.stop();
        sourceLine.flush();
        sourceLine.close();
    }
    
    public void setLooping()
    {
        looped = true;
    }
    
    public void disableLooping()
    {
        looped = false;
    }
    
    public void playSound(String filename)
    {
        file = filename;
        new Thread(this).start();
    }
    
    @Override
    public void run() {
        Thread.currentThread().setName("Wave player for " + file);
        startPlayback();
    }
}
