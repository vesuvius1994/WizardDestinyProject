/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities.Enemy.EnemyFactory;

import Entities.DynamicEntities.Enemy.Enemy;
import Entities.DynamicEntities.Enemy.Spider;

/**
 *
 * @author letga
 */
public class SpiderFactory implements EnemyAbstractFactory{

    @Override
    public Enemy createEnemy(int posX, int posY) {
        return new Spider(posX, posY);
    }
    
}
