/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities.Enemy.MovementStrategy;

import Entities.DynamicEntities.Enemy.Enemy;
import Entities.DynamicEntities.Enemy.Spider;

/**
 *
 * @author letga
 */
public class SpiderMovementStrategy implements MovementStrategy {

    @Override
    public void execute(Enemy enemy) {
        Spider s = (Spider) enemy;
        
        s.setPosY(s.getPosY() + s.getDy());
        
        if(s.getPosY() - s.getSpawnY() >= 90){
            s.setDy(-2);
        } else if(s.getPosY() <= s.getSpawnY()){
            s.setDy(2);
        }
    }
    
}
