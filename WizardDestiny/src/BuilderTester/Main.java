/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuilderTester;

import Commands.LevelManager;
import Level.Level;
import LevelBuilder.ConcreteLevelBuilder;
import LevelBuilder.LevelBuilder;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author letga
 */
public class Main {
    
    public static void main(String[] args){
        LevelBuilder builder = new ConcreteLevelBuilder();
        
        BufferedSpriter imageCreator = new BufferedSpriter();
        
        BufferedImage enemySprite = imageCreator.createImage("/Resources/wolf.png");
        BufferedImage diamondTile = imageCreator.createImage("/Resources/Diamond.png");
        BufferedImage platform = imageCreator.createImage("/Resources/tile.jpeg");

        builder.buildEnemy(100, 80, enemySprite);
        builder.buildDiamond(50, 50);
        builder.buildBackground("/Resources/bg_double.png");
        builder.buildPlatform(120, 35, platform);
        builder.buildLevelEnd(8000);
        
        Level lev = builder.getResult();
        
        JFrame testFrame = new JFrame("Builder and Level Test");
        testFrame.setSize(630, 508);
	testFrame.setVisible(true);
        testFrame.setResizable(false);
	testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        testFrame.add(lev);
        
        LevelManager levelManager = new LevelManager(lev);
        levelManager.startListener();
    }
    
}
