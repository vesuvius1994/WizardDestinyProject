/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities.Enemy.MovementStrategy;

import Entities.DynamicEntities.Enemy.Boss;
import Entities.DynamicEntities.Enemy.Enemy;

/**
 *
 * @author letga
 */
public class FirstBossMovementStrategy implements MovementStrategy{

    private boolean goingDown;
    
    public FirstBossMovementStrategy(){
        this.goingDown = true;
    }
    
    @Override
    public void execute(Enemy enemy) {
        Boss b = (Boss) enemy;
        
        b.setPosY(b.getPosY() + b.getDy());
        
        if(goingDown && b.getPosY() < b.getBottomBound()){
            b.setDy(2);
        } else if(b.getPosY() >= b.getBottomBound()){
            this.goingDown = false;
            b.setDy(-2);
        } else if(!goingDown && b.getPosY() > b.getUpBound()){
            b.setDy(-2);
        } else if(!goingDown && b.getPosY() <= b.getUpBound()){
            b.setDy(2);
            this.goingDown = true;
        }
    }
    
}
