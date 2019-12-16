/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testClasses.MainCharacterRepresentationTest;
import Entities.DynamicEntities.MainCharacter;
import javax.swing.JFrame;
/**
 *
 * @author letga
 */
public class RepresentationTest {
    
    
    public static void main(String[] args){
        JFrame testFrame;
        TestPanel testLevel;
        MainCharacter mc;
        testFrame = new JFrame("Test Frame");
        testFrame.setSize(630, 380);
	testFrame.setVisible(true);
	testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mc = new MainCharacter(0,0);
        
        testLevel = new TestPanel();
        testLevel.setMainCharacter(mc);
        
        testFrame.add(testLevel);
        testLevel.repaint();
    }
}
