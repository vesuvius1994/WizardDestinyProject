/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameSound;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.*;

/**
 *
 * @author ludovicorusso
 */
public class Sound {
    private Clip clip;
    
   public void playClip(String path){
        try {
            File fileSuono = new File(path);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(fileSuono);
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
   public void stopClip(){
       clip.stop();
   }
}
