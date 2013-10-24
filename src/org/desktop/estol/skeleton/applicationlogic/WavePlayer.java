package org.desktop.estol.skeleton.applicationlogic;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
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
    private String file;
    
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
        }
        catch (NullPointerException | UnsupportedAudioFileException | IOException | LineUnavailableException e)
        {
            DebugUtilities.addDebugMessage(e.getMessage());
            return;
        }
    }

    public void playSound(String filename)
    {
        file = filename;
        new Thread(this).start();
    }
    
    @Override
    public void run() {
        startPlayback();
    }
}
