/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainGame;

import Commands.LevelManager;
import Level.Level;
import LevelBuilder.Director;
import java.util.logging.Logger;
import javax.swing.JFrame;
import GUI.MainGame;
import GameSound.Sound;

/**
 *
 * @author ludovicorusso
 */
public class GameOverThread implements Runnable{
    private Level level;
    private JFrame frame;
    private Director dir;
    private Sound sound;
    public GameOverThread(Level level, JFrame frame,Sound sound) {
        this.level = level;
        this.frame = frame;
        this.dir=new Director();
        this.sound=sound;
    }

    
    @Override
    public void run() {
        try {
            
            while(true){
                if(level.isGameOver()){
                   frame.setVisible(false);
                   this.level=dir.getLevel();
                   this.sound.stopClip();
                   MainGame.main(null);
                }
                Thread.sleep(5000);
                
            }
        } catch (InterruptedException ex) {
            
        }
    }
    
}
