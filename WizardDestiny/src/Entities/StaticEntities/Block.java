package Entities.StaticEntities;

import java.awt.image.BufferedImage;

/**
 *
 * @author Silvio Maria Amato
 */
public class Block extends StaticEntity{
    
    private BufferedImage img;

    public Block(int posX, int posY) {
        super(posX, posY);
        
        this.setHeight(30);
        this.setWidth(30);
    }
    
    public void setImage(BufferedImage img){
        this.img = img;
    }
}
