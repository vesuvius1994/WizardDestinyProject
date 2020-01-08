/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities.Enemy.MovementStrategy;

import Entities.DynamicEntities.Enemy.Enemy;

/**
 *
 * @author letga
 */
public class MovementContext {
    
    private MovementStrategy strategy;
    
    public void setStrategy(MovementStrategy strategy){
        this.strategy = strategy;
    }
    
    public void makeMeMove(Enemy enemy){
        this.strategy.execute(enemy);
    }
}
