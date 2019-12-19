/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LevelBuilder;

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
    
    public static final int COLTILEMATRIX=6;
    public static final int ROWTILEMATRIX=6;
    
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
    
    /*Strings containing the pathname of files ".map"
    *and ".png", respectively*/
    protected String mapLevelPath;
    protected String tileMatrixPath;
    protected String backgroundPath;
    
    protected LevelBuilder builder;
    
    public Director(){
        builder = new ConcreteLevelBuilder();
        
        this.mapLevelPath = "/Resources/level_1.map";
        this.backgroundPath = "/Resources/bg_double.png";
        this.tileMatrixPath = "/Resources/tileMap.png";
        
        this.loadMap(this.mapLevelPath);
        this.loadTile(this.tileMatrixPath);
        this.createLevel();
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
                
                if(r == 1 && c == 1){
                    this.builder.buildEnemy(x, y, tiles[r][c]);
                } else if(r == 1 && c == 5){
                    this.builder.buildDiamond(x, y);
                } else if(c != 5){
                    this.builder.buildPlatform(x, y, tiles[r][c]);
                }
            }
        }
        this.builder.buildLevelEnd((this.numColsMatrix * this.tileSize));
        this.level = this.builder.getResult();
    }
    
    public Level getLevel(){
        return level;
    }
}
