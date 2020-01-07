/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities.Attacks;

/**
 *
 * @author Jonathan De Maio <j.demaio1@studenti.unisa.it>
 */
public class BasicAttack extends Attack{

    public BasicAttack(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public String attackFileName() {
        return "/Resources/basicAttack.png";
    }

    @Override
    public int attackSpeed() {
        return 3;
    }

    @Override
    public int setStrength() {
        return 1;
    }
    
    
}
