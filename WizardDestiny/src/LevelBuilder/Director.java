/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LevelBuilder;

import Entities.DynamicEntities.Enemy.EnemyFactory.*;
import Entities.StaticEntities.ObjectFactory.*;
import Level.Level;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author letga
 */
public class Director {
    
    /*Enemies Factories*/
    private WerewolfFactory werewolfFactory;
    private BatFactory batFactory;
    private SpiderFactory spiderFactory;
    private BossFactory bossFactory;
    
    /*Objects Factories*/
    private BlockFactory blockFactory;
    private DiamondFactory diamondFactory;
    
    public static final int COLTILEMATRIX=7;
    public static final int ROWTILEMATRIX=7;
    
    protected Level level;
    
    /*Map attributes*/
    protected int map[][];
    protected int numCols;
    protected int numRows;
    protected int numRowsMatrix;
    protected int numColsMatrix;
    
    /*Attributes to read more caracter from matrix*/
    protected Scanner scan;
    protected String str;
    
    /*Tileset attributes*/
    protected BufferedImage tileset;
    protected BufferedImage[][] tiles;
    protected final int tileSize = 30;
    protected BufferedImage bossTile;
    
    /*Strings containing the pathname of files ".map"
    *and ".png", respectively*/
    protected String mapLevelPath;
    protected String tileMatrixPath;
    protected String backgroundPath;
    protected String bossTilePath;
    
    protected LevelBuilder builder;
    
    public Director(){
        builder = new ConcreteLevelBuilder();
        
        this.mapLevelPath = "/Resources/level_1.map";
        this.backgroundPath = "/Resources/bg_double.png";
        this.tileMatrixPath = "/Resources/tileMap.png";
        this.bossTilePath = "/Resources/dragon_LEFT.png";
        
        this.batFactory = new BatFactory();
        this.spiderFactory = new SpiderFactory();
        this.werewolfFactory = new WerewolfFactory();
        this.bossFactory = new BossFactory();
        
        this.blockFactory = new BlockFactory();
        this.diamondFactory = new DiamondFactory();
        
        this.loadBossTile();
        this.loadMap(this.mapLevelPath);
        this.loadTile(this.tileMatrixPath);
        this.createLevel();
    }
    
    public void loadBossTile(){
        try {
            this.bossTile = ImageIO.read(getClass().getResourceAsStream(this.bossTilePath));
        } catch (IOException e) {
            System.out.println("sto in errore");
        }
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
    protected void createLevel() {
        
        this.builder.buildBackground(backgroundPath);
        
        for (int i = 0; i < numRowsMatrix; i++) {
            for (int j = 0; j < numColsMatrix; j++) {
                int rc = map[i][j];
                int r = rc / COLTILEMATRIX;
                int c = rc % COLTILEMATRIX;
                int x = (int) (j * tileSize);
                int y = (int) (i * tileSize);
                
                if(r == 0 && c == 6){
                    this.builder.buildEnemy(this.werewolfFactory, x, y, tiles[r][c]);
                } else if(r == 1 && c == 5){
                    this.builder.buildEnemy(batFactory, x, y, tiles[r][c]);
                } else if(r == 1 && c == 6){
                    this.builder.buildEnemy(this.spiderFactory, x, y, tiles[r][c]);
                } else if(r == 1 && c == 4){
                    this.builder.buildObject(this.diamondFactory, x, y, tiles[r][c]);
                } else if(rc == 20){
                    System.out.println("entro");
                    this.builder.buildEnemy(bossFactory, x, y, this.bossTile);
                } else if(c != 5){
                    this.builder.buildObject(blockFactory, x, y, tiles[r][c]);
                }
            }
        }
        this.builder.buildLevelEnd((this.numColsMatrix * this.tileSize) + 30);
        this.level = this.builder.getResult();
    }
    
    public Level getLevel(){
        return level;
    }
}
