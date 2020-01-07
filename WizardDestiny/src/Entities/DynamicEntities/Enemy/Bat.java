/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities.Enemy;

import Entities.DynamicEntities.Enemy.MovementStrategy.BatMovementStrategy;

/**
 *
 * @author letga
 */
public class Bat extends Enemy{
    
    private boolean backward;
    private int rightBound;
    private int leftBound;
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
    
    public int getRightBound() {
        return rightBound;
    }

    public int getLeftBound() {
        return leftBound;
    }

    public int getUpBound() {
        return upBound;
    }

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
