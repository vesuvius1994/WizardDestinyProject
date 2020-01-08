package Entities.StaticEntities;

import java.awt.image.BufferedImage;

/**
 *
 * @author Silvio Maria Amato
 */
public class Block extends StaticEntity{
    
    public Block(int posX, int posY) {
        super(posX, posY);
        
        this.setHeight(30);
        this.setWidth(30);
    }
}
