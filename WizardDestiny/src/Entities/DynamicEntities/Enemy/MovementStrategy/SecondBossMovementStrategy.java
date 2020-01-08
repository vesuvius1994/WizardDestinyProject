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
public class SecondBossMovementStrategy implements MovementStrategy{
    
    private boolean backward;
    
    public SecondBossMovementStrategy(){
        this.backward = true;
    }

    @Override
    public void execute(Enemy enemy) {
        Boss b = (Boss) enemy;
        
        if(!backward && b.getPosX() < b.getRightBound()){
            b.setPosX(b.getPosX() + 2);
        } else if(!backward && b.getPosX() >= b.getRightBound()){
            backward = true;
            b.setPosX(b.getPosX() - 2);
        } else if(backward && b.getPosX() > b.getLeftBound()){
            b.setPosX(b.getPosX() - 2);
        } else if(backward && b.getPosX() <= b.getLeftBound()){
            backward = false;
            b.setPosX(b.getPosX() + 2);
        }
    }
    
    
}
