/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Level;

import Entities.DynamicEntities.Attacks.Attack;
import Entities.DynamicEntities.MainCharacter;
import Entities.Entity;
import Sprite.MainCharacterSprite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javax.imageio.ImageIO;
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
public abstract class Level extends JPanel{
    
    /*Instance of the Class Main Character.*/
    protected MainCharacter mc;
    
    /*ArrayList containing all entities of the current Level.*/
    protected ArrayList entities;
    
    /*Variable used for the "scrolling" operation.*/
    protected int dx = 0;
    
    /*Value of the center position of the panel.*/
    protected final int HALF_PANEL = 240;
    
    /*Map attributes*/
    protected int map[][];
    protected int numCols;
    protected int numRows;
    protected Background bg;
    protected int numRowsMatrix;
    protected int numColsMatrix;
    
    /*Attributes to read more caracter from matrix*/
    protected Scanner scan;
    protected String str;

    
    
    /*Strings containing the pathname of files ".map"
    *and ".png", respectively*/
    protected String mapLevelPath;
    protected String tileMatrixPath;
    protected String backgroundPath;
    
    /*Tileset attributes*/
    protected BufferedImage tileset;
    protected BufferedImage[][] tiles;
    protected final int tileSize = 30;
    
    /*Main Character Sprites*/
    protected MainCharacterSprite mcs;
    protected ArrayList<BufferedImage[]> sprite;
    
    /*Class Level Constructor.
    *It instantiates the background of the level,
    *creates the entities map of the level
    *and draws their relative tiles.
    *Also, it instantiates the Main Character tiles manager.
    **/
    public Level(){
        this.setPaths();
        
        /**
         * Only for test purpose. 
         * To be deleted once a builder is defined.
        */
        this.mc = new MainCharacter(10, 10);
        
        createBackground();
        setMap();
        this.mcs = new MainCharacterSprite();
        this.sprite = mcs.getSprites();
    }
    
    /**
     * This method returns the MainCharacter istance of the level.
     * @return 
     */
    public MainCharacter getMainCharacter(){
        return this.mc;
    }
    
    protected abstract void setPaths();
    
    /*It invokes private methods "loadMap" and "loadTile"*/
    protected void setMap(){
        this.loadMap(this.mapLevelPath);
        this.loadTile(this.tileMatrixPath);
    }
    
    /*It instantiates an object "Background" by providing
    *the pathname of the ".png" file related to the level.*/
    protected void createBackground(){
        bg = new Background(this.backgroundPath);
    }
    
    /*It takes the pathname of a file ".map" as input
    *in order to fill the object "map"
    *with information about the level entities
    *and their tiles.*/
    protected void loadMap(String s) {

        int temp = 0;

        try {
            InputStream in = getClass().getResourceAsStream(s);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            numRowsMatrix = Integer.parseInt(br.readLine());
            numColsMatrix = Integer.parseInt(br.readLine());
            map = new int[numRowsMatrix][numColsMatrix];

            for (int i = 0; i < numRowsMatrix; i++) {
                str = br.readLine();
                scan = new Scanner(str);
                for (int j = 0; j < numColsMatrix; j++) {
                    temp = scan.nextInt();
                        if(temp!=-1){
                            map[i][j] = temp;
                        }
                }
            }
        } catch (IOException e) {
            System.out.print("sto in errore sulla matrice");
        }
    }
    
    /*It takes the pathname of a file ".png."
    *containing all level tiles.
    *It reads tiles information from the file
    *in order to fill the BufferedImage object "tiles".*/
    protected void loadTile(String s) {

        try {
            tileset = ImageIO.read(getClass().getResourceAsStream(s));
            numCols = tileset.getWidth() / tileSize;
            numRows = tileset.getHeight() / tileSize;
            tiles = new BufferedImage[numRows][numCols];

            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    tiles[i][j] = tileset.getSubimage(j * tileSize, i * tileSize, tileSize, tileSize);
                }
            }
        } catch (IOException e) {
            System.out.print("Error during loadTile operation.\n");
        }

    }
    
    /*It takes a Graphics2D object as input
    *in order to draws all entities tiles
    *on the screen by using objects "map"
    *and "tiles".*/
    protected void drawMap(Graphics2D g) {

        for (int i = 0; i < numRowsMatrix; i++) {
            for (int j = 0; j < numColsMatrix; j++) {
                int rc = map[i][j];
                int r = rc / 5;
                int c = rc % 5;
                int x = (int) (j * tileSize);
                int y = (int) (i * tileSize);
                g.drawImage(tiles[r][c], x + dx, y, null);
            }
        }
    }
    
    
    /*It draws all level tiles on the panel
    *and invokes "collisionDetection" and "scrolling" methods.
    *In addition, it draws Main Character sprite.*/
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D) g;
        
        collisionDetection();
        
        Iterator itr=sprite.iterator();
        BufferedImage[] img=(BufferedImage[])itr.next();
        
        scrolling();
        
        /*draw background: MUST be managed inside 
        *CommandsListener.actionPerformed*/
        if(bg != null){
            bg.draw(g2d);
        }
        if(map != null){
            this.drawMap(g2d);
        }
        
        g2d.drawImage(img[0],mc.getPosX(),mc.getPosY(),mc.getWidth(),mc.getHeight(),null);
        drawAttacks(g2d);
        drawSprite(g2d);
        Toolkit.getDefaultToolkit().sync();
        //mettere ciclo for per disegnare TUTTE le tile di tutte le entity.
    }
    
    protected void collisionDetection(){
        /*TO BE IMPLEMENTED*/
    }
    
    /*When it is invoked, it calls all updating position methods
    *each time the Main Character position is going to be 
    *greater than the HALF_PANEL value.
    *Finally, the Main character position is setted to HALF_PANEL.*/
    protected void scrolling(){
        if(mc.getPosX() > HALF_PANEL){
            dx -= 2;
            bg.update();
            this.updateEntitiesPosition();
            mc.setPosX(HALF_PANEL);
        } else if(mc.getPosX() < 0){
            mc.setPosX(0);
        }
        /**
         * Mettere condizione per fine livello.
         */ 
    }
    
    /*It updates all level entities position.*/
    protected void updateEntitiesPosition(){
        if(this.entities != null){
            Iterator<Entity> it = this.entities.iterator();

            while(it.hasNext()){
                Entity e = it.next();
                e.setPosX(e.getPosX() + dx);
            }
        }
    }
    
    protected void drawAttacks(Graphics2D g2d){
        for(Attack a : mc.getAttacks()){
            g2d.drawImage(a.getImg(),a.getPosX(),a.getPosY(),a.getWidth(),a.getHeight(),null);
        }
    }
    
    protected void drawSprite(Graphics2D g2d){
        BufferedImage[] action=mcs.getSprites(mc.getState());
        for(int i=0;i<action.length;i++)
            g2d.drawImage(action[i],mc.getPosX(),mc.getPosY(),mc.getWidth(),mc.getHeight(),null);
        //g2d.drawImage(action[0],mc.getPosX(),mc.getPosY(),mc.getWidth(),mc.getHeight(),null);
    }
}
