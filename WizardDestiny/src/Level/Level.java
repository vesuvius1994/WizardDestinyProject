/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Level;

import Entities.DynamicEntities.Attacks.Attack;
import Entities.DynamicEntities.MainCharacter;
import Entities.DynamicEntities.Score.Score;
import Entities.Entity;
import Sprite.MainCharacterSprite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *This class represents the general level of the game.
 * It extends the JPanel class in order to manage all representative
 * elements of the gameplay.
 * In addition, it also manages the update of level entities
 * and their interactions.
 * 
 * NOTE: Coupling with Builder must be implemented.
 * 
 * @author letga
 */
public class Level extends JPanel{
    
    /*Instance of the Class Main Character.*/
    protected MainCharacter mc;
    
    protected Score score;
    
    /*ArrayLists containing all entities of the current Level.*/
    protected ArrayList dynamicEntities;
    protected ArrayList staticEntities;
    
    /*ArrayLists containing all tiles of level entities*/
    protected ArrayList dynamicTiles;
    protected ArrayList staticTiles;
    
    /*Level Background*/
    protected Background background;
    
    /*Variable used for the "scrolling" operation.*/
    protected int dxEntity = 0;
    protected int scrolledPixels = 0;
    protected final int levelEnd;
    
    /*Value of the center position of the panel.*/
    protected final int HALF_PANEL;
    
    /*Main Character Sprites*/
    protected MainCharacterSprite mcs;
    protected ArrayList<BufferedImage[]> sprite;
    
    /*Class Level Constructor.
    *It instantiates the background of the level,
    *creates the entities map of the level
    *and draws their relative tiles.
    *Also, it instantiates the Main Character tiles manager.
    **/
    public Level(ArrayList dynamicEntities, ArrayList staticEntities, 
            ArrayList dynamicTiles, ArrayList staticTiles, 
            Background background, int levelEnd){
        
        this.dynamicEntities = dynamicEntities;
        this.staticEntities = staticEntities;
        
        this.staticTiles = staticTiles;
        this.dynamicTiles = dynamicTiles;
        
        this.mc = new MainCharacter(10, 10);
        this.mcs = new MainCharacterSprite();
        this.sprite = mcs.getSprites();
        
        this.score = new Score(0);
        
        this.HALF_PANEL = 315;
        
        this.background = background;
        
        this.levelEnd = levelEnd;
    }
    
    /**
     * This method returns the MainCharacter istance of the level.
     * @return 
     */
    public MainCharacter getMainCharacter(){
        return this.mc;
    }
    
    /*It draws all level tiles on the panel
    *and invokes "collisionDetection" and "scrolling" methods.
    *In addition, it draws Main Character sprite.*/
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D) g;
        
        background.draw(g2d);
        
        scrolling();
        
        drawTiles(g2d);
        drawSprite(g2d);
        drawAttacks(g2d);
        if (mc.getHealth().getHealth() <= 0) {
            g2d.setFont(new Font("Papyrus", Font.BOLD, 80));
            g2d.setColor(Color.white);
            g2d.drawString("Game Over", 100, 230);
        }
        this.score.draw(g2d);
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    protected void collisionDetection(){
        /*TO BE IMPLEMENTED*/
    }
    
    /*When it is invoked, it calls all updating position methods
    *each time the Main Character position is going to be 
    *greater than the HALF_PANEL value.
    *Finally, the Main character position is setted to HALF_PANEL.*/
    protected void scrolling(){
        if(mc.getPosX() > HALF_PANEL && (levelEnd - scrolledPixels ) > (HALF_PANEL * 2)){
            dxEntity = -2;
            scrolledPixels += 2;
            if(scrolledPixels % 4 == 0){
                background.update();
            }
            this.updateEntitiesPosition();
            mc.setPosX(HALF_PANEL);
        } else if(mc.getPosX() < 0)
            mc.setPosX(0);
        
    }
    
    /*It updates all level entities position.*/
    protected void updateEntitiesPosition(){
        for(int i = 0; i < this.staticEntities.size(); i++){
            Entity e = (Entity) this.staticEntities.get(i);
            e.setPosX(e.getPosX() + this.dxEntity);
        }
        
        for(int i = 0; i < this.dynamicEntities.size(); i++){
            Entity e = (Entity) this.dynamicEntities.get(i);
            e.setPosX(e.getPosX() + this.dxEntity);
        }
    }
    
    protected void drawAttacks(Graphics2D g2d){
        for(Attack a : mc.getAttacks()){
            g2d.drawImage(a.getImg(),a.getPosX(),a.getPosY(),a.getWidth(),a.getHeight(),null);
        }
    }
    
    protected void drawSprite(Graphics2D g2d){
        mc.getHealth().draw(g2d);
        mc.drawEnergy(g2d);
        BufferedImage[] action=mcs.getSprites(mc.getState());
        for(int i=0;i<action.length;i++)
            g2d.drawImage(action[i],mc.getPosX(),mc.getPosY(),mc.getWidth(),mc.getHeight(),null);
    }
    
    protected void drawTiles(Graphics2D g2d){
        
        for(int i = 0; i < this.dynamicTiles.size(); i++){
            Entity e = (Entity) this.dynamicEntities.get(i);
            BufferedImage img = (BufferedImage) this.dynamicTiles.get(i);
            
            g2d.drawImage(img, e.getPosX(), e.getPosY(), null);
        }
        
        for(int i = 0; i < this.staticTiles.size(); i++){
            Entity e = (Entity) this.staticEntities.get(i);
            BufferedImage img = (BufferedImage) this.staticTiles.get(i);
            
            g2d.drawImage(img, e.getPosX(), e.getPosY(), null);
        }
    }
    
    public ArrayList<Entity> getStaticEntities(){
        return this.staticEntities;
    }
    
    public ArrayList<Entity> getDynamicEntities(){
        return this.dynamicEntities;
    }
    
    public void incrementScore(){
        this.score.setScore(score.getScore() + 5);
    }
}
