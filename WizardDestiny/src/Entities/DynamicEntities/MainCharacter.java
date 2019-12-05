/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities;

import Entities.Entity;
import Commands.*;

/**
 *
 * @author Jonathan De Maio <j.demaio1@studenti.unisa.it>
 */
public class MainCharacter extends DynamicEntity{
    
    // Character commands
    private SourceCommand command;
    
    public MainCharacter(int posX, int posY) {
        super(posX, posY);
        
        this.command = new SourceCommand();
        //invocare i metodi per acquisire file dei comandi
        this.setHeight(30);
        this.setWidth(30);
    }
    
    public int getMoveForwardKey(){
        return this.command.getDx();
    }
    
    public int getMoveBackwardKey(){
        return this.command.getSx();
    }
    
    public int getJumpKey(){
        return this.command.getJump();
    }
    
    public int getBasicAttackKey(){
        return this.command.getAttackB();
    }
    
    public int getSpecialAttackKey(){
        return this.command.getAttackS();
    }

    public void specialAttack(){
        System.out.print("\n************Special Attack***********\n");
    }
    
    /****DA IMPLEMENTARE***/
    /*Restituisce il valore attuale dell'energia
    *dell'attacco speciale.
    **/
    public int getEnergy(){
        return 10;
    }
    
    public void decreaseEnergy(){
        System.out.print("\n----Energy decreased----\n");
    }
    
    @Override
    public void attack() {
        System.out.print("\n-----------Basic attack------------\n");
    }
}
