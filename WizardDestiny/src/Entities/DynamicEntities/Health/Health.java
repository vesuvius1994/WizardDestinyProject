package Entities.DynamicEntities.Health;

/**
 *
 * @author Silvio Maria Amato
 */
public abstract class Health {
    
    private int health = 0;

    
    public Health(int DEFAULT_HEALTH ) {
        health = DEFAULT_HEALTH;
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
        this.health = health;
    }

    public abstract void hurt();
    
    public abstract void die();
}
