/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testClasses.BuilderTester;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author letga
 */
public class BufferedSpriter {
    
    private BufferedImage sprite;
    
    public BufferedImage createImage(String path){
        
        try {
            sprite = ImageIO.read(getClass().getResourceAsStream(path));
        } catch(IOException e) {
            System.out.println("Sto in errore in BufferedSpriter");
        }
        
        return sprite;
    }
}
