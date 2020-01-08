/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities.Enemy;

import Entities.DynamicEntities.DynamicEntity;
import Entities.DynamicEntities.Enemy.MovementStrategy.MovementContext;
import Entities.DynamicEntities.Health.EnemyHealth;

/**
 *This class represents a common interface for all dynamic entities Enemy.
 * It also contains common code blocks used by all entity Enemy.
 * @author Crazy Monkey Software House
 */
public abstract class Enemy extends DynamicEntity{
    
    /*MovementContext instance.*/
    protected MovementContext context;

    public Enemy(int posX, int posY) {
        super(posX, posY);
        
        this.health = new EnemyHealth(this.initializeHealth());
        this.context = new MovementContext();
        this.setStrategy();
    }
    
    @Override
    public void movement(){
        this.context.makeMeMove(this);
    }
    
    /**
     * It passes a MovementStrategy object to the MovementContext instance.
     */
    protected abstract void setStrategy();
    
}
