/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities;

/**
 *
 * @author Jonathan De Maio <j.demaio1@studenti.unisa.it>
 */
public class MainCharacter extends DynamicEntity{
    
    // Character commands
    private SourceCommand command;
    
    public MainCharacter(int posX, int posY) {
        super(posX, posY);
    }

    
    
    @Override
    public void attack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
