/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities;

import Entities.DynamicEntities.Health.Health;
import Entities.Entity;

/**
 *This class represents a common interface of all no-static game entities.
 * It also contains all common codes shared between the previous mentioned
 * kind of entity.
 * 
 * @author Crazy Monkey Software House
 */
public abstract class DynamicEntity extends Entity{

    // acceleration
    private int dx = 0;
    private int dy = 3;
    
    // dinamyc entity health
    protected Health health;
    
    public DynamicEntity(int posX, int posY) {
        super(posX, posY);
    }
    
    /**
     * Handles Entity's attack
     */
    public abstract void attack();
    
    /**
     * It updates the dynamic entity position by certain acceleration..
     */
    public void movement() {
        //template method
        
        // add increment to DinamycEntity's Position
        this.setPosX( this.getPosX() + dx );
        this.setPosY( this.getPosY() + dy );
  
    }

    /**
     * It returns the entity accelaration on the axis X.
     * @return 
     */
    public int getDx() {
        return dx;
    }

    /**
     * It sets the amount of accelarion on the axis X
     * by a given amount.
     * @param dx int
     */
    public void setDx(int dx) {
        this.dx = dx;
    }

    /**
     * It returns the entity accelaration on the axis Y.
     * @return 
     */
    public int getDy() {
        return dy;
    }

    /**
     * It sets the amount of accelarion on the axis Y
     * by a given amount.
     * @param dy int
     */
    public void setDy(int dy) {
        this.dy = dy;
    }
    
    /**
     * It returns an integer representing the current amount of health
     * of the entity.
     * @return int
     */
    public int getHealth() {
        return health.getHealth();
    }
    
    /**
     * It decreases the health of the entity by a given amount.
     * @param damage int
     */
    public void decreaseHealth(int damage){
        int newHealth = this.health.getHealth() - damage;
        this.health.setHealth(newHealth);
    }

    /**
     * It instantiates a Health class by a given integer amount.
     * @return 
     */
    protected abstract int initializeHealth(); // hook method

}
