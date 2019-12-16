/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testClasses.CommandsListenerTest;

import Entities.DynamicEntities.MainCharacter;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author letga
 */
public class TestLevel extends JPanel{
    
    private MainCharacter mc;
    
    public void setMainCharacter(MainCharacter mc){
        this.mc = mc;
    }
    
    public boolean canMoveForward(){
        return true;
    }
    
    public boolean canMoveBackward(){
        return true;
    }
    
    public boolean canJump(){
        return true;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D) g;
        
        collisionDetection();
        //draw main character
        g2d.fillRect(mc.getPosX(), mc.getPosY(), mc.getWidth(), mc.getHeight());
        g2d.fillRect(0, 230, 300, 20); //draw ground
    }
    
    private void collisionDetection(){
        if((mc.getPosY() + mc.getHeight()) > 230 
                && mc.getPosX() <= 300){
            mc.setPosY(230 - mc.getHeight());
        }
    }
}
