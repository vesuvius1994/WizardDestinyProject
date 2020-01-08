/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sprite;

import Entities.Entity;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.*;

/**
 *This class manages the Main Character Sprites.
 * @author Crazy Monkey Software
 */
public class MainCharacterSprite {
    
    private ArrayList<BufferedImage[]> sprites;
    private Map<Enum,BufferedImage[]> sprite2;
    private final int[] numFrames = {2, 4, 4, 3, 4, 3, 4, 3};
    private enum State{
            STOPPOSITION,
            WALKING,
            RUNNING,
            JUMPING,
            IDLE,
            HUNT,
            DEAD,
            ATTACK
        }
    private Enum states[];
        
    public MainCharacterSprite(){
        
        try {
            BufferedImage spritesheet = 
                ImageIO.read(getClass().getResourceAsStream("/Resources/playersprites.gif"));		
            sprites = new ArrayList<BufferedImage[]>();
            for(int i = 0; i < 7; i++) {
                BufferedImage[] bi = new BufferedImage[numFrames[i]];
		for(int j = 0; j < numFrames[i]; j++) {
                    bi[j] = spritesheet.getSubimage(j*30, i *30, 30, 30);
		}
		sprites.add(bi);
            }
	} catch(Exception e) {
		e.printStackTrace();
	}
       //Try to implement a Map Fuction to enumerate
        try{
            BufferedImage spritesheet = 
                ImageIO.read(getClass().getResourceAsStream("/Resources/playersprites.gif"));
            sprite2=new HashMap<>();
            states=Entity.States.values();
	    for(int i = 0; i < 7; i++) {
		BufferedImage[] bi = new BufferedImage[numFrames[i]];
		for(int j = 0; j < numFrames[i]; j++) {
                    bi[j] = spritesheet.getSubimage(j*30, i *30, 30, 30);
		}
                sprite2.put(states[i], bi);
            }
        } catch(Exception e){
           e.printStackTrace();
        }
    }

    public ArrayList<BufferedImage[]> getSprites() {
        return sprites;
    }
    public BufferedImage[] getSprites(Enum State){
        return sprite2.get(State);      //this method return a BufferdImmage array associated to sprite files.
    }
}
