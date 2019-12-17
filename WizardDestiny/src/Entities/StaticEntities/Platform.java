package Entities.StaticEntities;

import java.awt.image.BufferedImage;

/**
 *
 * @author Silvio Maria Amato
 */
public class Platform extends StaticEntity{
    
    private BufferedImage img;

    public Platform(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void movement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setImage(BufferedImage img){
        this.img = img;
    }
}
