/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities;

import java.awt.image.BufferedImage;

/**
 *
 * @author Gaetano Maffucci
 */
public class Enemy extends DynamicEntity{
    
    private BufferedImage img; 
    private int deltax = 80;
    private int spawnx;
    private boolean rightbound;
    private boolean leftbound;
    private int deltaxright= deltax + 450;
    private int deltaxleft= 450 - deltax;

    public Enemy(int posX, int posY) {
        super(posX, posY);
        this.setHeight(30);
        this.setWidth(30);
        this.leftbound=false;
        this.rightbound=false;
        
        this.spawnx= 450;
    }

    @Override
    public void attack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setSprite(BufferedImage img) {
        this.img = img;
    }

    @Override
    public void movement() {
//       while(true){
            System.out.println("Posizione del lupo:" + this.getPosX());
            System.out.println("Spawnx:" + this.spawnx);
            System.out.println("rightbound:" + deltaxright);
            System.out.println("leftbound:" + deltaxleft/*(this.spawnx - this.deltax)*/);
        
        if(this.getPosX() == deltaxright/*this.spawnx + deltax*/){
            this.leftbound = false;
            this.rightbound = true;
        }
        if(this.getPosX() == deltaxleft/*this.spawnx - deltax*/){
            this.leftbound = true;
            this.rightbound = false;
        }
        if((this.rightbound == false) && (this.getPosX()< deltaxright/*this.spawnx + deltax*/)){
            super.setPosX( this.getPosX() + 1);
        }
        if((this.rightbound == true && this.leftbound==false)){
            System.out.println("Decremento" + this.getPosX());
            super.setPosX( this.getPosX() - 1);
        }
     
//            try {
//                Thread.sleep(20);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Enemy.class.getName()).log(Level.SEVERE, null, ex);
//            }
   // }
//    }
    }
    
    
    
}
    
