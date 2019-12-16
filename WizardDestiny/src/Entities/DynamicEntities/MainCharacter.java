/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities;

import Commands.*;
import Entities.DynamicEntities.Attacks.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan De Maio <j.demaio1@studenti.unisa.it>
 */
public class MainCharacter extends DynamicEntity{
    
    // Character commands
    private SourceCommand command;
    private List<Attack> Attacks;

    public MainCharacter(int posX, int posY) {
        super(posX, posY);
        
        this.Attacks = new ArrayList();
        this.command = new DefaultCommand();
        //invocare i metodi per acquisire file dei comandi
        this.setHeight(45);
        this.setWidth(45);
    }

    public SourceCommand getCommand() {
        return command;
    }
    
    public void specialAttack(){
        this.Attacks.add(new SpecialAttack(this.getPosX(), this.getPosY())); 
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

    public List<Attack> getAttacks() {
        return Attacks;
    }
    
    @Override
    public void attack() {
        this.Attacks.add(new BasicAttack(this.getPosX(), this.getPosY())); 
    }
}
