/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Level;

import Entities.DynamicEntities.MainCharacter;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author letga
 */
public class Background {
    
    private BufferedImage image;
    
    private int WIDTH = 630;
    private int tileSize = 30;
    private int numCols = 107;
    private final MainCharacter mc;
    private int X;

    /**
     *
     * Constructor.
     *
     * @param s
     */
    public Background(String s, MainCharacter mc) {

        try {
            image = ImageIO.read(getClass().getResourceAsStream(s));
        } catch (IOException e) {
            System.out.println("sto in errore");
        }
        this.mc = mc;
        this.X = mc.getPosX();
    }
    
    public int getWidth() {
        return image.getWidth();
    }

    public void draw(Graphics2D g2D) {
        
        X+=mc.getDx();
        int offsetX = (WIDTH/2) - X - tileSize;
        offsetX = Math.min (offsetX, 0);
        offsetX = Math.max (offsetX, WIDTH - (tileSize * numCols));
        
        int backgroundX = (offsetX * (WIDTH - getWidth()) / (WIDTH - (tileSize * numCols)));
        g2D.drawImage(image, backgroundX, 0, null);
    
    }
   
    /*public void update(){
       posX -= 1;
    }*/
    
}