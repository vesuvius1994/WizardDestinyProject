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

/**
 *
 * @author letga
 */
public class Main {
    public static void main(String[] args){
        
        Director dir = new Director();
        System.out.println(dir);
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
        
    }
}
