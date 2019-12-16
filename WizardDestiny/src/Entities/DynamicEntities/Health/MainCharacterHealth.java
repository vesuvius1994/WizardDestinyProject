package Entities.DynamicEntities.Health;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author Silvio Maria Amato
 */
public class MainCharacterHealth extends Health{
    JPanel healthPanel;
    JProgressBar healthBar;

    public MainCharacterHealth(int DEFAULT_HEALTH) {
        super(DEFAULT_HEALTH);
        
        healthPanel = new JPanel();
        healthPanel.setBounds(100, 15, 200, 30);
        healthPanel.setBackground(Color.red);
        
        /**
         * to add the panel of the health-bar to the parent panel 
         */
        
        healthBar = new JProgressBar (0, DEFAULT_HEALTH);
        healthBar.setPreferredSize(new Dimension(200,30));
        healthBar.setBackground(Color.red);
        healthBar.setForeground(Color.green);
        healthPanel.add(healthBar);
    }

    @Override
    public void hurt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void die() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
