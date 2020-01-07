/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities;

import Entities.DynamicEntities.Health.EnemyHealth;

/**
 *
 * @author letga
 */
public class Spider extends DynamicEntity {
    
    private EnemyHealth health;
    private int spawnY;

    public Spider(int posX, int posY) {
        super(posX, posY);
        
        this.spawnY = posY;
        
        this.setHeight(30);
        this.setWidth(30);
        
        this.setDy(2);
        
        this.health = new EnemyHealth(1);
    }
    

    @Override
    public void attack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void movement(){
        super.movement();
        
        if(this.getPosY() - this.spawnY >= 90){
            this.setDy(-2);
        } else if(this.getPosY() <= this.spawnY){
            this.setDy(2);
        }
    }
    
}
