/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DirectorTest;

import Commands.LevelManager;
import Level.Level;
import LevelBuilder.Director;
import javax.swing.JFrame;
import GameSound.Sound;
/**
 *
 * @author letga
 */
public class Main extends Thread{
    
    
    public static void main(String[] args) throws InterruptedException{
        Director dir = new Director();
        Level level = null;
        
        do{ 
            level = dir.getLevel();
            System.out.println(level);
            
        }while(level == null);
        
        JFrame testFrame = new JFrame("Builder and Level Test");
        testFrame.setSize(630, 508);
	testFrame.setVisible(true);
        testFrame.setResizable(false);
	testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        level.setSize(630, 508);
        testFrame.add(level);
        LevelManager mng = new LevelManager(level);
        mng.startListener();
        Sound sound=new Sound();
        sound.playClip("src/Resources/SoundPack/sfx_gameloop.wav");
        Thread test = new Thread(new ThreadTest(level,testFrame,sound));
        test.start();
        
        
    }

 
} 


