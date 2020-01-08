/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities.Enemy;

import Entities.DynamicEntities.Enemy.MovementStrategy.SpiderMovementStrategy;

/**
 * This class represents the Enemy DynamicEntity Spider.
 * @author Crazy Monkey Software House
 */
public class Spider extends Enemy {
    
    /*Initial position on axys Y.*/
    private int spawnY;

    public Spider(int posX, int posY) {
        super(posX, posY);
        
        this.spawnY = posY;
        
        this.setHeight(30);
        this.setWidth(30);        
    }
    
    @Override
    public void attack() {
        ;
    }

    @Override
    protected int initializeHealth() {
        return 5;
    }

    @Override
    protected void setStrategy() {
        this.context.setStrategy(new SpiderMovementStrategy());
    }
    
    /**
     * It returns the spawn position on the axys Y.
     * @return int
     */
    public int getSpawnY(){
        return this.spawnY;
    }
    
}
