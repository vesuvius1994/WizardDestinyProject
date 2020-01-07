/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities;

import Entities.DynamicEntities.Health.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author letga
 */
public class Werewolf extends DynamicEntity {
    
    private final String SPRITEPATH = "/Resources/wolf.png";
    private int rightBound;
    private int leftBound;
    private boolean backward = false;
    private BufferedImage img;
    private Health health;

    public Werewolf(int posX, int posY) {
        super(posX, posY);
        
        rightBound = posX + 15;
        leftBound = posX - 15;
        
        try {
            img = ImageIO.read(getClass().getResourceAsStream(SPRITEPATH));
            System.out.println(img == null);
        } catch (IOException e) {
            System.out.println("sto in errore");
        }
        
        health = new EnemyHealth(2);
        
        this.setWidth(45);
        this.setHeight(45);
    }

    
    
    @Override
    public void movement(){
        this.rightBound += this.getDx();
        this.leftBound += this.getDx();
        
        if(!backward && this.getPosX() < this.rightBound){
            this.setPosX(this.getPosX() + 1);
        } else if(backward && this.getPosX() == this.leftBound){
            backward = false;
        } else {
            this.setPosX(this.getPosX() - 1);
        }
        
    }
    
    @Override
    public void attack() {
        System.out.println("Enemy's attack.");
    }
    
    public BufferedImage getSprite(){
        return img;
    }
    
}
