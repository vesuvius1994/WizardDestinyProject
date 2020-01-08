/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameSound;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.*;

/**
 *This class manages all gameplay sounds.
 * @author Crazy Monkey Software House
 */
public class Sound {
    
    /*Clip instance containing the background music.*/
    private Clip clip;
    private URL url;
    
    /**
     * It reads from an audio stream an audio file from a given input path
     * and uses it to instantiates a Clip object.
     * Finally, it invokes the start method on the Clip object.
     * @param path String pathname of an audio file.
     */
    public void playClip(String path){
        try {
            url = getClass().getResource(path);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            this.clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            audioInputStream.close();
        } catch (UnsupportedAudioFileException e) {
           e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        } catch (LineUnavailableException e) {
          e.printStackTrace();
        }
        clip.start();
   }
   
    /**
     * It invokes the stop method on the Clip object.
     */
   public void stopClip(){
       clip.stop();
   }
   
   /**
    * It invokes the loop method on the Clip object 
    * in order to play it in loop.
    */
   public void loop(){
       clip.loop(Clip.LOOP_CONTINUOUSLY);
   }
}
