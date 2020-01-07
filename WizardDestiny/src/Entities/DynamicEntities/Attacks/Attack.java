/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities.Attacks;

import Entities.DynamicEntities.DynamicEntity;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Jonathan De Maio <j.demaio1@studenti.unisa.it>
 */
public abstract class Attack extends DynamicEntity {

    private Image img;
    private boolean visible;
    private int strength;
    
    public Attack(int posX, int posY) {
        super(posX, posY);
        this.setHeight(45);
        this.setWidth(45);
        this.attack();
        this.strength = setStrength();
        this.visible = true;
        
    }

    @Override
    public final void attack() {
        // template method
        try {
            img = ImageIO.read(getClass().getResourceAsStream(this.attackFileName()));
        } catch (IOException e) {
            System.out.println("sto in errore");
        }
    }

    public Image getImg() {
        return img;
    }

    public boolean isVisible(){
        return this.visible;
    }
    
    @Override
    public void movement() {
        this.setPosX( this.getPosX() + attackSpeed() );
        if(this.getDx()>630)
            this.visible = false;
    }

    public int getStrength() {
        return strength;
    }

    public abstract String attackFileName(); // hook method, implement it to introduce new type of attack
    public abstract int attackSpeed();   // hook method to set attack speed
    public abstract int setStrength(); //hook method to set attack type
}
