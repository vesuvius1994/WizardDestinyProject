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
 *This class represents the controllable DynamicEntity Main Character.
 * @author Crazy Monkey Software House
 */
public class MainCharacter extends DynamicEntity{
    
    // Character commands
    private SourceCommand command;
    private List<Attack> Attacks;
    protected Energy energy;
    
    /**
     * Main Character class constructor.
     * It initializes the Main Character initial position with
     * two ints given as inputs.
     * It also instantiates SourceCommand, List and Energy objects.
     * 
     * @param posX int
     * @param posY int
     */
    public MainCharacter(int posX, int posY) {
        super(posX, posY);
        
        this.Attacks = new ArrayList();
        this.command = new SourceCommand();
        this.health = new MainCharacterHealth(this.initializeHealth());
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

    /**
     * It returns the SourceCommand object.
     * @return SourceCommand
     */
    public SourceCommand getCommand() {
        return command;
    }
    
    /**
     * It manages the Special Attack Event.
     */
    public void specialAttack(){
        if(this.energy.isReducible()){
            this.Attacks.add(new SpecialAttack(this.getPosX(), this.getPosY()));
            this.energy.reduceEnergy();
        }
    }
    
    /**
     * It invokes the drawEnergy method on the Energy object.
     * @param g2D Graphics2D
     */
    public void drawEnergy(Graphics2D g2D){
        this.energy.drawEnergy(g2D);
    }
    
    /**
     * It invokes the draw method on the Energy object.
     * @param g2D Graphics2D
     */
    public void drawHealth(Graphics2D g2D){
        this.health.draw(g2D);
    }

    /**
     * It returns the List object containing Attack Entities.
     * @return 
     */
    public List<Attack> getAttacks() {
        return Attacks;
    }
    
    @Override
    public void attack() {
        this.Attacks.add(new BasicAttack(this.getPosX(), this.getPosY())); 
    }

    @Override
    protected int initializeHealth() {
        return 5;
    }
}
