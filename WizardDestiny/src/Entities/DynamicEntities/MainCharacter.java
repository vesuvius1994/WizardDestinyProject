/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities;

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
        
        this.command = new DefaultCommand();
        //invocare i metodi per acquisire file dei comandi
        this.setHeight(45);
        this.setWidth(45);
    }

    public SourceCommand getCommand() {
        return command;
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
