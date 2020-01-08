/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities.Enemy;

import Entities.DynamicEntities.Enemy.MovementStrategy.FirstBossMovementStrategy;
import Entities.DynamicEntities.Enemy.MovementStrategy.SecondBossMovementStrategy;

/**
 *
 * @author M
 */
public class Boss extends Enemy {

    private int rightBound;
    private int leftBound;
    private int bottomBound;
    private int upBound;
    
    private boolean changeStrategy = false;
        
    public Boss(int posX, int posY) {
        super(posX, posY);
        this.bottomBound = posY;
        this.upBound = posY - 210;
        
        rightBound = posX;
        leftBound = posX - 300;
        
        this.setWidth(90);
        this.setHeight(30);

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
    protected void setStrategy() {
        if(!changeStrategy){
            this.context.setStrategy(new FirstBossMovementStrategy());
        } else {
            this.context.setStrategy(new SecondBossMovementStrategy());
        }
    }
    
    
    @Override 
    public void movement(){
        int chargeRate = (int) (Math.random() * 25);
        
        if(!changeStrategy && this.getHealth() <= 20 && chargeRate == 1
                && this.getPosX() == this.rightBound){
            this.changeStrategy = true;
            this.setStrategy();
        } else if(changeStrategy && this.getPosX() == this.rightBound){
            changeStrategy = false;
            this.setStrategy();
        }
        
        super.movement();
    }
    
    @Override
    public void attack() {
        ;
    }

    @Override
    protected int initializeHealth() {
        return 30;
    }
    
    @Override
    public void scrollingPosX(int delta){
        super.scrollingPosX(delta);
        
        this.rightBound -= delta;
        this.leftBound -= delta;
    }

}
