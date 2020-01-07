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
 *
 * @author letga
 */
public abstract class Enemy extends DynamicEntity{
    
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
    
    protected abstract void setStrategy();
    
}
