/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Level;

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
    
    private int posX;
    private int nextReprint;

    /**
     *
     * Constructor.
     *
     * @param s
     */
    public Background(String s) {

        try {
            image = ImageIO.read(getClass().getResourceAsStream(s));
        } catch (IOException e) {
            System.out.println("sto in errore");
        }
        
        posX = 0;
    }
    
    public int getWidth() {
        return image.getWidth();
    }

    public void draw(Graphics2D g2D) {
        g2D.drawImage(image, posX, 0, null);
        if(posX + image.getWidth() < 1240){ //da sistemare
            g2D.drawImage(image, posX + image.getWidth(), 0, null);
        }
    }
   
    public void update(){
       posX -= 1;
    }
    
}