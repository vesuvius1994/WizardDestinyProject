package Entities.DynamicEntities.Health;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author Silvio Maria Amato
 */
public class MainCharacterHealth extends Health {
    
    public MainCharacterHealth(int health) {
        super(health);

    }

    @Override
    public void draw(Graphics2D g2d) {
        Image img;
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/Resources/heart.png"));
            g2d.drawImage(img, 15, 15, 20, 20, null);
            g2d.setFont(new Font("Papyrus", Font.BOLD, 22));
            g2d.setColor(Color.white);
            g2d.drawString(String.valueOf(this.getHealth()), 40, 30);
            
            
                
        } catch (IOException e) {
            System.out.println("sto in errore");
        }
    }

}