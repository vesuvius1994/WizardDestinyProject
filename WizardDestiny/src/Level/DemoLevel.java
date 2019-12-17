/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Level;

import Entities.DynamicEntities.Enemy;
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
    
    public DemoLevel(){
        super();
        
        this.entities = new ArrayList<Entity>();
        this.setEntity();
    }
    
    @Override
    protected void collisionDetection(){
        if((mc.getPosY() + mc.getHeight()) > platformY 
                && mc.getPosX() <= (720 + dxTile)){
            mc.setPosY(platformY - mc.getHeight());
        }
        if(mc.getPosX() < 0){
            mc.setPosX(0);
        }
    }

    @Override
    protected void setPaths() {
        this.mapLevelPath = "/Resources/level_1.map";
        this.backgroundPath = "/Resources/bg.png";
        this.tileMatrixPath = "/Resources/tileMatrix.png";
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D) g;
        Enemy e = (Enemy) this.entities.get(0);
        Diamond d = (Diamond) this.entities.get(1);
        g2d.drawImage(e.getS_image(), e.getPosX(), e.getPosY(), e.getWidth(), e.getHeight(), null);
        g2d.drawImage(diamondImage, d.getPosX(), d.getPosY(), d.getWidth(), d.getHeight(), null);
    }
    
    public void setEntity(){
        this.entities.add(new Enemy(450, 370, "/Resources/wolf.png"));
        this.entities.add(new Diamond(300, 420));
        this.dms = new DiamondSprite();
        this.diamondImage = dms.getSprites();
    }
    
    public Enemy getEnemy(){
        return (Enemy) this.entities.get(0);
    }
}
