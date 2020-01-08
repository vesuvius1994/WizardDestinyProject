/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities.Enemy;

import Entities.DynamicEntities.Enemy.MovementStrategy.WerewolfMovementStrategy;

/**
 *This class represents the Enemy DynamicEntity Werewolf.
 * @author Crazy Monkey SOftware House
 */
public class Werewolf extends Enemy {
    
    /*Movement range bounds on the axys X.*/
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
    
    /**
     * It returns the right bound on the axys X.
     * @return int
     */
    public int getRightBound(){
        return this.rightBound;
    }
    
    /**
     * It returns the left bound on the axys X.
     * @return int
     */
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
