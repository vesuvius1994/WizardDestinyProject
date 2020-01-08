/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testClasses.ObjectTestEnvironment;

import Entities.DynamicEntities.Enemy.Spider;
import javax.swing.JFrame;

/**
 *
 * @author letga
 */
public class Main {
    
    public static void main(String[] args) throws InterruptedException{
        long count = 0;
        boolean toScroll = false;
        
        Spider spider = new Spider(500, 70);
        
        ObjectPainter painter = new ObjectPainter(spider, toScroll);
        
        JFrame testFrame = new JFrame("Object Test Environment");
        testFrame.setSize(630, 508);
	testFrame.setVisible(true);
        testFrame.setResizable(false);
	testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        painter.setSize(630, 508);
        testFrame.add(painter);
        
        while(true){
            count += 10;
            
            spider.movement();
            painter.repaint();
            
            Thread.sleep(10);
            
            if(count == 2000){
                count = 0;
                toScroll = !toScroll;
                painter.toScroll(toScroll);
            }
        }
    }
}
