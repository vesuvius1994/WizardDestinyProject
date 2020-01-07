/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Level;

import Entities.DynamicEntities.Enemy;
import Entities.DynamicEntities.Enemy.Werewolf;
import Entities.Entity;
import Entities.StaticEntities.Diamond;
import Sprite.DiamondSprite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *THIS CLASS IS ONLY FOR TEST PURPOSE.
 * @author letga
 */
public class DemoLevel extends Level{

    /*Objects coordinates*/
    private int platformX = 0;
    private int platformY = 450;
    private int platformLength = 540;
    private DiamondSprite dms;
    private BufferedImage diamondImage;
    
    public DemoLevel(ArrayList dynamicEntities, ArrayList staticEntities, 
            ArrayList dynamicTiles, ArrayList staticTiles, 
            Background background, int levelEnd){
        super(dynamicEntities, staticEntities, dynamicTiles, staticTiles, 
                background, levelEnd);
    }
    
    @Override
    protected void collisionDetection(){
        if((mc.getPosY() + mc.getHeight()) > platformY 
                && mc.getPosX() <= (720 + this.dxEntity)){
            mc.setPosY(platformY - mc.getHeight());
        }
        if(mc.getPosX() < 0){
            mc.setPosX(0);
        }
    }
}
