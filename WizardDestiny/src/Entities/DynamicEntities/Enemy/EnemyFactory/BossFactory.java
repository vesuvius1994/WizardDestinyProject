/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities.Enemy.EnemyFactory;

import Entities.DynamicEntities.Enemy.Boss;
import Entities.DynamicEntities.Enemy.Enemy;

/**
 *
 * @author letga
 */
public class BossFactory implements EnemyAbstractFactory{

    @Override
    public Enemy createEnemy(int posX, int posY) {
        return new Boss(posX, posY);
    }
    
}
