/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sprite;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author Antonio Dello Russo <a.dellorusso11@studenti.unisa.it>
 */
public class DiamondSprite {
    private BufferedImage sprite;
    
    public DiamondSprite() {
        try {
            sprite = ImageIO.read(
                    getClass().getResourceAsStream(
                            "/Resources/Diamond.png"
                    )
            );
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public BufferedImage getSprites() {
        return sprite;
    }
    
}
