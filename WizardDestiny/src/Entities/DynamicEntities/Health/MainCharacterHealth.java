package Entities.DynamicEntities.Health;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author Silvio Maria Amato
 */
public class MainCharacterHealth extends Health {

    JPanel healthPanel;
    JProgressBar healthBar;

    public MainCharacterHealth(int DEFAULT_HEALTH) {
        super(DEFAULT_HEALTH);

    }

    @Override
    public void draw(JPanel panel) {

        healthPanel = new JPanel();
        healthPanel.setBounds(100, 15, 200, 30);
        healthPanel.setBackground(Color.red);
        panel.add(healthPanel);

        healthBar = new JProgressBar(0, super.getHealth());
        healthBar.setPreferredSize(new Dimension(200, 30));
        healthBar.setBackground(Color.red);
        healthBar.setForeground(Color.green);
        healthPanel.add(healthBar);

    }

}