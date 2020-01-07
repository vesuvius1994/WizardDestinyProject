package LevelBuilder;


import Entities.DynamicEntities.Enemy.EnemyFactory.EnemyAbstractFactory;
import Entities.StaticEntities.ObjectFactory.ObjectFactory;
import Level.Level;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author letga
 */
public interface LevelBuilder {
    
    public abstract void buildEnemy(EnemyAbstractFactory enemyFactory, int posX, int posY, BufferedImage img);
    
    public abstract void buildBoss(int posX, int posY, ArrayList<BufferedImage> img);
        
    public abstract void buildObject(ObjectFactory objectFactory, int posX, int posY, BufferedImage img);
    
    public abstract void buildBackground(String backgroundPathName);
    
    public abstract void buildLevelEnd(int levelEnd);
    
    public abstract Level getResult();
}
