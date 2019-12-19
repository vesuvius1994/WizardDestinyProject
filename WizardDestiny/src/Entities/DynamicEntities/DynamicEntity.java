/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities;

import Entities.Entity;

/**
 *
 * @author Jonathan De Maio <j.demaio1@studenti.unisa.it>
 */
public abstract class DynamicEntity extends Entity{

    // acceleration
    private int dx = 0;
    private int dy = 3;
    
    public DynamicEntity(int posX, int posY) {
        super(posX, posY);
    }
    
    /**
     * Handles Entity's attack
     */
    public abstract void attack();
    
    public void movement() {
        //template method
        
        // add increment to DinamycEntity's Position
        this.setPosX( this.getPosX() + dx );
        this.setPosY( this.getPosY() + dy );
  
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

}
