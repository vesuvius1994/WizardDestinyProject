/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testClasses.ObjectTestEnvironment;

import Entities.Entity;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author letga
 */
public class ObjectPainter extends JPanel{
    
    private Entity object;
    private boolean isScrolling;
    
    public ObjectPainter(Entity object, boolean isScrolling){
        this.object = object;
        this.isScrolling = isScrolling;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2D = (Graphics2D) g;
        
        if(isScrolling){
            scroll();
        }
        
        g2D.fillRect(object.getPosX(), object.getPosY(), object.getWidth(), object.getHeight());
    }
    
    private void scroll(){
        object.scrollingPosX(1);
    }
    
    public void toScroll(boolean isScrolling){
        this.isScrolling = isScrolling;
    }
}
