/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities;

import Commands.*;
import Entities.DynamicEntities.Attacks.*;
import Entities.DynamicEntities.Health.MainCharacterHealth;
import java.awt.Graphics2D;
import java.io.IOException;
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
    protected MainCharacterHealth health;
    protected Energy energy;
    
    public MainCharacter(int posX, int posY) {
        super(posX, posY);
        
        this.Attacks = new ArrayList();
        this.command = new SourceCommand();
        this.health = new MainCharacterHealth(5);
        this.energy = new Energy();
        
        this.setHeight(45);
        this.setWidth(45);
        
        try{
        if(this.command.getTypeCommand()){ //Verify if exists a file with a presonalizzable command.
            PersonalizableCommand p = new PersonalizableCommand(0,0,0,0,0);
            p = this.command.getPersonalizzable();
            this.command = p;
        }
        else{
             this.command=new DefaultCommand();
        }
        }catch(IOException e){
            this.command = new DefaultCommand(); // In case of Exception, it instantiates the default command 
        }
    }

    public SourceCommand getCommand() {
        return command;
    }
    
    public void specialAttack(){
        if(this.energy.isReducible()){
            this.Attacks.add(new SpecialAttack(this.getPosX(), this.getPosY()));
            this.energy.reduceEnergy();
        }
    }
    
    public void drawEnergy(Graphics2D g2D){
        this.energy.drawEnergy(g2D);
    }
    
    public MainCharacterHealth getHealth() {
        return health;
    }
    
    public void decreaseHealth(int damage){
        int newHealth = this.health.getHealth() - damage;
        this.health.setHealth(newHealth);
    }

    public List<Attack> getAttacks() {
        return Attacks;
    }
    
    @Override
    public void attack() {
        this.Attacks.add(new BasicAttack(this.getPosX(), this.getPosY())); 
    }
}
