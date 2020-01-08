/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testClasses.ObjectTestEnvironment;

import Entities.DynamicEntities.Enemy.Spider;
import Entities.DynamicEntities.Enemy.Werewolf;
import javax.swing.JFrame;

/**
 *
 * @author letga
 */
public class WerewolfTestMain {
    
    public static void main(String[] args) throws InterruptedException{
        long count = 0;
        boolean toScroll = false;
        
        Werewolf werewolf = new Werewolf(500, 70);
        
        ObjectPainter painter = new ObjectPainter(werewolf, toScroll);
        
        JFrame testFrame = new JFrame("Object Test Environment");
        testFrame.setSize(630, 508);
	testFrame.setVisible(true);
        testFrame.setResizable(false);
	testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        painter.setSize(630, 508);
        testFrame.add(painter);
        
        while(true){
            count += 10;
            
            werewolf.movement();
            painter.repaint();
            System.out.println(werewolf.getPosX());
            
            Thread.sleep(10);
            
            if(count == 1500){
                count = 0;
                toScroll = !toScroll;
                painter.toScroll(toScroll);
                System.out.println("Scrolling:" + toScroll);
            }
        }
    }
    
}
