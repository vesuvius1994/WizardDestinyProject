/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities.Enemy.MovementStrategy;

import Entities.DynamicEntities.Enemy.Enemy;
import Entities.DynamicEntities.Enemy.Werewolf;

/**
 *
 * @author letga
 */
public class WerewolfMovementStrategy implements MovementStrategy{
    
    private boolean backward;
    
    public WerewolfMovementStrategy(){
        this.backward = true;
    }

    @Override
    public void execute(Enemy enemy) {
        
        Werewolf w = (Werewolf) enemy;
       
        if(!backward && w.getPosX() < w.getRightBound()){
            w.setPosX(w.getPosX() + 2);
        } else if(!backward && w.getPosX() >= w.getRightBound()){
            backward = true;
            w.setPosX(w.getPosX() - 2);
        } else if(backward && w.getPosX() > w.getLeftBound()){
            w.setPosX(w.getPosX() - 2);
        } else if(backward && w.getPosX() <= w.getLeftBound()){
            backward = false;
            w.setPosX(w.getPosX() + 2);
        }
    }
    
    
}
