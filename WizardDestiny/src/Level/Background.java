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
 *This class contains all elements used to show the background of the level.
 * @author Crazy Monkey Software House
 */
public class Background {
    
    /*Background image file.*/
    private BufferedImage image;
    
    /*Background position on the axys X.*/
    private int posX;
    
    private int nextReprint;

    /**
     *It initializes the BufferedImage image object.
     *
     * @param s String
     */
    public Background(String s) {

        try {
            image = ImageIO.read(getClass().getResourceAsStream(s));
        } catch (IOException e) {
            System.out.println("sto in errore");
        }
        
        posX = 0;
    }
    
    /**
     * It returns the width of background image file.
     * @return int
     */
    public int getWidth() {
        return image.getWidth();
    }

    /**
     * It draws the background image file by using a Graphics2D object.
     * @param g2D Graohics2D
     */
    public void draw(Graphics2D g2D) {
        g2D.drawImage(image, posX, 0, null);
        if(posX + image.getWidth() < 1240){ //da sistemare
            g2D.drawImage(image, posX + image.getWidth(), 0, null);
        }
    }
   
    /**
     * It decreases the position of the background on axys X by 1.
     */
    public void update(){
       posX -= 1;
    }
    
}