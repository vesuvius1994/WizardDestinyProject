/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testClasses.CommandsListenerTest;

import Commands.CommandsListener;
import Commands.DefaultCommand;
import Commands.SourceCommand;
import Entities.DynamicEntities.MainCharacter;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author letga
 */
public class Main {
    
    public static void main(String[] args){
        JFrame testFrame = new JFrame("CommandsListener Test");
        testFrame.setSize(630, 480);
	testFrame.setVisible(true);
	testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        TestLevel testLevel = new TestLevel();
        testFrame.add(testLevel);
        
        MainCharacter mc = new MainCharacter(100,200);
        testLevel.setMainCharacter(mc);
                
        //CommandsListener cmd = new CommandsListener(mc, testLevel);
    }
    
}
