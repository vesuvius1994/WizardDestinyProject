package Entities.DynamicEntities.Health;

import java.awt.Graphics2D;

/**
 *This class represents the health system of Enemy Entity.
 * @author Crazy Monkey Software House
 */
public class EnemyHealth extends Health{

    public EnemyHealth(int health) {
        super(health);
    }

    @Override
    public void draw(Graphics2D g2d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
