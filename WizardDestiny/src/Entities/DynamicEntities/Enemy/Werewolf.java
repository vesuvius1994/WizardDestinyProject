/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities.Enemy;

import Entities.DynamicEntities.Enemy.MovementStrategy.WerewolfMovementStrategy;

/**
 *
 * @author letga
 */
public class Werewolf extends Enemy {
    
    private int rightBound;
    private int leftBound;
    
    public Werewolf(int posX, int posY) {
        super(posX, posY);
        
        rightBound = posX + 30;
        leftBound = posX - 30;
                
        this.setWidth(30);
        this.setHeight(30);
    }
    
    @Override
    public void scrollingPosX(int delta){
        super.scrollingPosX(delta);
        
        this.rightBound -= delta;
        this.leftBound -= delta;
    }
    
    public int getRightBound(){
        return this.rightBound;
    }
    
    public int getLeftBound(){
        return this.leftBound;
    }
    
    @Override
    public void attack() {
        System.out.println("Enemy's attack.");
    }

    @Override
    protected int initializeHealth() {
        return 4;
    }

    @Override
    protected void setStrategy() {
        this.context.setStrategy(new WerewolfMovementStrategy());
    }
    
}
