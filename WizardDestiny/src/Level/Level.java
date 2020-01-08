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
 * In addition, it also manages the scrolling feature
 * and the entities representations.
 *
 * 
 * NOTE: Coupling with Builder must be implemented.
 * 
 * @author Crazy Monkey Software House
 */
public class Level extends JPanel{
    
    /*Instance of the Class Main Character.*/
    protected MainCharacter mc;
    
    /*Instance of the Class Score*/
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
    
    /*This variable identifies the Game Over event.*/
    protected boolean gameOver;
    
    protected boolean gameWin;
    
    /**
     * Class Level Constructor.
     *It instantiates the background of the level,
     *creates the entities map of the level
     *and draws their relative tiles.
     *Also, it instantiates the Main Character tiles manager.
     * @param dynamicEntities ArrayList containing all level dynamic entities.
     * @param staticEntities ArrayList containing all level static entities.
     * @param dynamicTiles ArrayList containing all dynamic entities tiles.
     * @param staticTiles ArrayList containing all static entities tiles.
     * @param background Background object related to the level.
     * @param levelEnd Integer representing the last pixel of the level.
     */
    
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
        
        this.gameOver = false;
        
        this.gameWin = false;
    }
    
    /**
     * This method returns the MainCharacter istance of the level.
     * @return 
     */
    public MainCharacter getMainCharacter(){
        return this.mc;
    }
    
    /**
     *It draws all level tiles on the panel
     *and invokes "scrolling" method.
     *In addition, it draws Main Character sprite 
     *and manages the Game over event.
     * @param g It is used to draw elements on the Panel component.
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D) g;
        
        background.draw(g2d);
        
        scrolling();
        
        drawTiles(g2d);
        drawSprite(g2d);
        drawAttacks(g2d);
        drawGameOver(g2d);
        
        this.score.draw(g2d);
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    /**
     * It returns the value of gameOver variable.
     * @return gameOver
     */
    public boolean isGameOver(){
        return this.gameOver;
    }
    
    /**
     *When it is invoked, it calls all updating position methods
     *each time the Main Character position is going to be 
     *greater than the HALF_PANEL value.
     *Finally, the Main character position is setted to HALF_PANEL.
     */
    protected void scrolling(){
        if(mc.getPosX() > HALF_PANEL && (levelEnd - scrolledPixels ) > (HALF_PANEL * 2)){
            dxEntity = 2;
            scrolledPixels += 2;
            if(scrolledPixels % 4 == 0){
                background.update();
            }
            this.updateEntitiesPosition();
            mc.setPosX(HALF_PANEL);
        } else if(mc.getPosX() < 0)
            mc.setPosX(0);
        
    }
    
    /**
     * It updates all level entities position 
     * by invoking their scrollingPosX method.
     */
    protected void updateEntitiesPosition(){
        
        for(int i = 0; i < this.staticEntities.size(); i++){
            Entity e = (Entity) this.staticEntities.get(i);
            e.scrollingPosX(this.dxEntity);
        }
        
        for(int i = 0; i < this.dynamicEntities.size(); i++){
            Entity e = (Entity) this.dynamicEntities.get(i);
            e.scrollingPosX(this.dxEntity);
        }
    }
    
    /**
     * This method draws Attack entities.
     * @param g2d It is used to draw Attack Entities.
     */
    protected void drawAttacks(Graphics2D g2d){
        for(Attack a : mc.getAttacks()){
            g2d.drawImage(a.getImg(),a.getPosX(),a.getPosY(),a.getWidth(),a.getHeight(),null);
        }
    }
    
    /**
     * This method draws Main Character sprites.
     * @param g2d It is used to draw Attack Entities.
     */
    protected void drawSprite(Graphics2D g2d){
        mc.drawHealth(g2d);
        mc.drawEnergy(g2d);
        BufferedImage[] action=mcs.getSprites(mc.getState());
        for(int i=0;i<action.length;i++)
            g2d.drawImage(action[i],mc.getPosX(),mc.getPosY(),mc.getWidth(),mc.getHeight(),null);
    }
    
    /**
     * This method draws all tiles of level entities.
     * @param g2d It is used to draw all entities tiles.
     */
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
    
    /**
     * It returns the instance of the ArrayList staticEntities.
     * @return  ArrayList
     */
    public ArrayList<Entity> getStaticEntities(){
        return this.staticEntities;
    }
    
    /**
     * It returns the instance of the ArrayList dynamicEntities.
     * @return ArrayList
     */
    public ArrayList<Entity> getDynamicEntities(){
        return this.dynamicEntities;
    }
    
    /**
     * It increments the value contained inside of the object Score.
     * @param value integer value.
     */
    public void incrementScore(int value){
        this.score.setScore(score.getScore() + value);
    }
    
    /**
     * It removes a tile from the ArrayList dynamicTiles.
     * @param index integer
     */
    public void removeTile(int index){
        this.dynamicTiles.remove(index);
    }
    
    /**
     * This method draws the Game Over notification 
     * and reports the final player's score.
     * @param g2d Graphics2D
     */
    protected void drawGameOver(Graphics2D g2d){
        if (mc.getHealth() <= 0 || this.gameWin) {
            g2d.setFont(new Font("Papyrus", Font.BOLD, 80));
            g2d.setColor(Color.white);
            mc.setState(Entity.States.DEAD);
            if(!gameWin)
                g2d.drawString("Game Over", 100, 230);
            else
                g2d.drawString("You Win!", 100, 230);
            g2d.setFont(new Font("Papyrus", Font.BOLD, 40));
            g2d.drawString("Score :"+String.valueOf(this.score.getScore()), 250, 280);
            this.gameOver = true;
        }
    }

    /**
     * 
     * @param gameWin 
     */
    public void setGameWin(boolean gameWin) {
        this.gameWin = gameWin;
    }
    
}
