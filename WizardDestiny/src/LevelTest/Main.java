/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LevelTest;

import Level.DemoLevel;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author letga
 */
public class Main {
    public static void main(String[] args) throws InterruptedException{
        
        DemoLevel demoLevel = new DemoLevel();        
        demoLevel.setPreferredSize(new Dimension(630, 480));
        
        EnemyMovementTest cmd = new EnemyMovementTest(demoLevel);
        cmd.setEnemy(demoLevel.getEnemy());
        
        JFrame testFrame = new JFrame("Demo Level");
        testFrame.setSize(630, 508);
	testFrame.setVisible(true);
        testFrame.setResizable(false);
	testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testFrame.add(demoLevel);
        cmd.startListener();
    }
}
