package Entities.DynamicEntities.Health;

import java.awt.Graphics2D;

/**
 *This class represents the health system of an Entity.
 * @author Crazy Monkey Software House
 */
public abstract class Health {

    /*Current health value.*/
    private int health;

    /**
     * Health class constructor.
     * It initializes the health variable with a given int input.
     * @param health int
     */
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

    /**
     * It uses a Graphics2D object to draw the current health value
     * on a Component.
     * @param g2d Graphics2D
     */
    public abstract void draw(Graphics2D g2d);

}
