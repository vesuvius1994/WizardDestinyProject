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
public interface MovementStrategy {
    
    public abstract void execute(Enemy enemy);
}
