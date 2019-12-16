/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import testClasses.MainCharacterRepresentationTest.TestPanel;
import Entities.DynamicEntities.MainCharacter;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author letga
 */
public class CommandsListenerTest {
    
    JFrame testFrame;
    TestPanel testLevel;
    
    public CommandsListenerTest() {
        testFrame = new JFrame("Test Frame");
        testFrame.setSize(630, 380);
	testFrame.setVisible(true);
	testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        testLevel = new TestPanel();
        testLevel.setMainCharacter(new MainCharacter(0, 0));
        
        testFrame.add(testLevel);
    }

    /**
     * Test of actionPerformed method, of class CommandsListener.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        CommandsListener instance = null;
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
