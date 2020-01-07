/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities.Enemy.MovementStrategy;

import Entities.DynamicEntities.Enemy.Bat;
import Entities.DynamicEntities.Enemy.Enemy;

/**
 *
 * @author letga
 */
public class BatMovementStrategy implements MovementStrategy{
    
    private boolean backward;
    private boolean goingDown;
    private boolean goingUp;
    
    public BatMovementStrategy(){
        this.backward = false;
        this.goingDown = false;
        this.goingUp = false;
    }

    @Override
    public void execute(Enemy enemy) {
        
        Bat b = (Bat) enemy;
        
        if(goingDown && b.getPosY() < b.getBottomBound()){
            b.setPosY(b.getPosY() + 1);
        } else if(goingDown && b.getPosY() >= b.getBottomBound()){
            goingDown = false;
            backward = true;
        } else if(goingUp && b.getPosY() > b.getUpBound()){
            b.setPosY(b.getPosY() - 1);
        } else if(goingUp && b.getPosY() <= b.getUpBound()){
            goingUp = false;
            backward = false;
        } else if(!backward && b.getPosX() > b.getLeftBound()){
            b.setPosX(b.getPosX() - 2);
        } else if(!backward && b.getPosX() <= b.getLeftBound()){
            goingDown = true;
        } else if(backward && b.getPosX() < b.getRightBound()){
            b.setPosX(b.getPosX() + 2);
        } else if(backward && b.getPosX() >= b.getRightBound()){
            goingUp = true;
        }
    }
    
}
