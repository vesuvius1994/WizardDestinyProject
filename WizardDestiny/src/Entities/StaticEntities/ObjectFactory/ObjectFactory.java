/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.StaticEntities.ObjectFactory;

import Entities.StaticEntities.StaticEntity;

/**
 *
 * @author letga
 */
public interface ObjectFactory {
    
    public abstract StaticEntity createObject(int posX, int posY);
    
}
