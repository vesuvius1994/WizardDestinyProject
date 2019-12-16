/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sprite;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.*;

/**
 *
 * @author ludovicorusso
 */
public class MainCharaterSprite {
        private ArrayList<BufferedImage[]> sprites;
	private final int[] numFrames = {
		2, 4, 4, 3, 4, 3, 4, 3
	};
        
        
    public MainCharaterSprite() {
       try {
			
			BufferedImage spritesheet = ImageIO.read(
				getClass().getResourceAsStream(
					"/Resources/playersprites.gif"
				)
			);
			
			sprites = new ArrayList<BufferedImage[]>();
			for(int i = 0; i < 7; i++) {
				
				BufferedImage[] bi =
					new BufferedImage[numFrames[i]];
				
				for(int j = 0; j < numFrames[i]; j++) {
					
					
						bi[j] = spritesheet.getSubimage(
								j*30,
								i *30,
                                                                  30,
								30
						);
					
				}
				
				sprites.add(bi);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    }

    public ArrayList<BufferedImage[]> getSprites() {
        return sprites;
    }
    
    
    
}
