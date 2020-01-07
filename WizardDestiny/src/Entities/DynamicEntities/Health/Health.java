package Entities.DynamicEntities.Health;

import java.awt.Graphics2D;

/**
 *
 * @author Silvio Maria Amato
 */
public abstract class Health {

    private int health = 0;

    public Health(int health) {
        this.health = health;
    }

    /**
     * Get the value of health
     *
     * @return the value of health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Set the value of health
     *
     * @param health new value of health
     */
    public void setHealth(int health) {
        if(health >= 0)
            this.health = health;
    }

    public abstract void draw(Graphics2D g2d);

}
