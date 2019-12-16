package Entities.DynamicEntities.Health;

/**
 *
 * @author Silvio Maria Amato
 */
public class EnemyHealth extends Health{

    public EnemyHealth(int DEFAULT_HEALTH) {
        super(DEFAULT_HEALTH);
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
