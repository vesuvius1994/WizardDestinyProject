/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LevelTest;

import Commands.CommandsListener;
import Level.DemoLevel;
import Level.Level;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author letga
 */
public class Main {
    public static void main(String[] args) throws InterruptedException{
        
        Level demoLevel = new DemoLevel();        
        demoLevel.setPreferredSize(new Dimension(630, 480));
        
        CommandsListener cmd = new CommandsListener(demoLevel);
        cmd.startListener();
        
        JFrame testFrame = new JFrame("Demo Level");
        testFrame.setSize(630, 518);
	testFrame.setVisible(true);
	testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testFrame.add(demoLevel);
    }
}
