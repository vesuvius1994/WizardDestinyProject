/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityFactory;

import Entities.Entity;

/**
 *
 * @author letga
 */
public interface EntityAbstractFactory {
    
    public Entity createEntity(int posX, int posY);
}
