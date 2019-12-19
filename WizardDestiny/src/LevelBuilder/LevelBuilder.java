package LevelBuilder;


import Level.Level;
import java.awt.image.BufferedImage;

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
    
    public abstract void buildEnemy(int posX, int posY, BufferedImage img);
    
    public abstract void buildDiamond(int posX, int posY);
    
    public abstract void buildPlatform(int posX, int posY, BufferedImage img);
    
    public abstract void buildBackground(String backgroundPathName);
    
    public abstract void buildLevelEnd(int levelEnd);
    
    public abstract Level getResult();
}
