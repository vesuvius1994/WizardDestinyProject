/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.awt.Rectangle;

/**
 *
 * @author Jonathan De Maio <j.demaio1@studenti.unisa.it>
 */
public abstract class Entity {
    
    /**
     * Enumeration containing all possible states for an entity
     */
    public static enum States {
        IDLE,
        WALKING,
        JUMPING,
        FALLING,
        ATTACKING,
        S_ATTACKING,
        DEAD
    };
    
    // entity position on x and y axes
    private int posX;
    private int posY;
    
    // entity dimensions
    private int height;
    private int width;
    
    // entity state
    private States state;

    /** 
     * Entity's contructur. It takes Entity's position on x and y axes and set State to IDLE. 
     * 
     * @param posX - Entity's position on x axis
     * @param posY - Entity's position on y axis
     * @author Jonathan De Maio <j.demaio1@studenti.unisa.it>
     */
    public Entity(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.state = States.IDLE;
    }
    
    /** 
     * Get entity's position on x axis
     * 
     * @return Entity's position on x axis
     * @author Jonathan De Maio <j.demaio1@studenti.unisa.it>
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Set entity's position on x axis
     * 
     * @param posX - Position on x axis
     * @author Jonathan De Maio <j.demaio1@studenti.unisa.it>
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /** 
     * Get entity's position on y axis
     * 
     * @return Entity's position on y axis
     * @author Jonathan De Maio <j.demaio1@studenti.unisa.it>
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Set entity's position on y axis
     * 
     * @param posY - Position on y axis
     * @author Jonathan De Maio <j.demaio1@studenti.unisa.it>
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Get enity's Height
     * 
     * @return  Entity's Height
     * @author Jonathan De Maio <j.demaio1@studenti.unisa.it>
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set entity's Height
     * 
     * @param height - Entity's Height
     * @author Jonathan De Maio <j.demaio1@studenti.unisa.it>
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Get entity's Width
     * 
     * @return Entity's Width
     * @author Jonathan De Maio <j.demaio1@studenti.unisa.it>
     */
    public int getWidth() {
        return width;
    }

    /**
     * Set entity's Width
     * 
     * @param width - Entity's Width
     * @author Jonathan De Maio <j.demaio1@studenti.unisa.it>
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Get Entity's State
     * 
     * @return Entity's State
     * @author Jonathan De Maio <j.demaio1@studenti.unisa.it>
     */
    public States getState() {
        return state;
    }

    /**
     * Set Entity's State
     * 
     * @param state - Entity's State
     * @author Jonathan De Maio <j.demaio1@studenti.unisa.it>
     */
    public void setState(States state) {
        this.state = state;
    }
    
    /**
     * Set Entity's Position 
     * 
     * @param x - Position to set on x axis
     * @param y - Poistion to set on y axis
     * @author Jonathan De Maio <j.demaio1@studenti.unisa.it>
     */
    public void setPosition(int x, int y){
        this.posX = x;
        this.posY = y;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(this.posX, this.posY, this.getHeight(), this.getWidth());
    }
    
    public void scrollingPosX(int delta){
        this.setPosX(this.getPosX() - delta);
    }
}
