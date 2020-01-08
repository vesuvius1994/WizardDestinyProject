/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities.Enemy;

import Entities.DynamicEntities.Enemy.MovementStrategy.BatMovementStrategy;

/**
 *This class represents the Dynamic Entity Enemy Bat.
 * @author Crazy Monkey Software House
 */
public class Bat extends Enemy{
    
    /*Movement range bounds on axys X.*/
    private int rightBound;
    private int leftBound;
    
    /*Movement range bounds on axys Y.*/
    private int upBound;
    private int bottomBound;
    

    public Bat(int posX, int posY) {
        super(posX, posY);
        
        this.setWidth(30);
        this.setHeight(30);
        
        rightBound = posX + 50;
        leftBound = posX - 50;
        upBound = posY;
        bottomBound = posY + 25;
    }
    
    /**
     * It returns the right bound on axis X.
     * @return int
     */
    public int getRightBound() {
        return rightBound;
    }

    /**
     * It returns the left bound on axis X.
     * @return int
     */
    public int getLeftBound() {
        return leftBound;
    }

    /**
     * It returns the up bound on axis Y.
     * @return int
     */
    public int getUpBound() {
        return upBound;
    }

    /**
     * It returns the bottom bound on axis Y.
     * @return int
     */
    public int getBottomBound() {
        return bottomBound;
    }
    
    @Override
    public void attack() {
        ;
    }

    @Override
    protected int initializeHealth() {
        return 1;
    }

    @Override
    protected void setStrategy() {
        this.context.setStrategy(new BatMovementStrategy());
    }
    
    @Override
    public void scrollingPosX(int delta){
        super.scrollingPosX(delta);
        
        this.rightBound -= delta;
        this.leftBound -= delta;
    }
}
