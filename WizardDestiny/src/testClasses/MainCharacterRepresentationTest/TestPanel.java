/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testClasses.MainCharacterRepresentationTest;

import Entities.DynamicEntities.MainCharacter;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author letga
 */
public class TestPanel extends JPanel{
    
    private MainCharacter mc;
    
    public void setMainCharacter(MainCharacter mc){
        this.mc = mc;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRect(mc.getPosX(), mc.getPosY(), mc.getWidth(), mc.getHeight());
    }
}
