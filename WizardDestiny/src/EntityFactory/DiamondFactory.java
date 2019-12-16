/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityFactory;

import Entities.StaticEntities.Diamond;
import Entities.Entity;

/**
 *
 * @author Antonio Dello Russo <a.dellorusso11@studenti.unisa.it>
 */
public class DiamondFactory implements EntityAbstractFactory {

    @Override
    public Entity createEntity(int posX, int posY) {
        return new Diamond(posX, posY);
    }
    
}
