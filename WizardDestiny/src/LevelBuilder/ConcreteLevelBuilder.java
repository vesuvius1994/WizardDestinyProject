/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LevelBuilder;

import Entities.DynamicEntities.Enemy;
import Entities.StaticEntities.Diamond;
import Entities.StaticEntities.Block;
import Level.Background;
import Level.Level;
import Sprite.DiamondSprite;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author letga
 */
public class ConcreteLevelBuilder implements LevelBuilder {

    protected Level level;
    
    protected ArrayList staticEntities;
    protected ArrayList staticTiles;
    protected ArrayList dynamicTiles;
    protected ArrayList dynamicEntities;

    protected Background bg;
    
    protected int levelEnd;

    public ConcreteLevelBuilder(){
        this.dynamicTiles = new ArrayList();
        this.staticTiles = new ArrayList();
        this.dynamicEntities = new ArrayList();
        this.staticEntities = new ArrayList();
    }
    
    @Override
    public void buildEnemy(int posX, int posY, BufferedImage img) {
        this.dynamicEntities.add(new Enemy(posX, posY));
        this.dynamicTiles.add(img);
        
    }

    @Override
    public void buildDiamond(int posX, int posY) {
        this.staticEntities.add(new Diamond(posX, posY));
        this.staticTiles.add(new DiamondSprite().getSprites());
        
    }

    @Override
    public void buildPlatform(int posX, int posY, BufferedImage img) {
        this.staticEntities.add(new Block(posX, posY));
        this.staticTiles.add(img);
    }

    @Override
    public void buildBackground(String backgroundPath) {
        this.bg = new Background(backgroundPath);
    }
    
    @Override
    public void buildLevelEnd(int levelEnd){
        this.levelEnd = levelEnd;
    }
    
    @Override
    public Level getResult() {
        this.level = new Level(this.dynamicEntities, this.staticEntities,
        this.dynamicTiles, this.staticTiles, this.bg, this.levelEnd);
        
        return level;
    }
}
