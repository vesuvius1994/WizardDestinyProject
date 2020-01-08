/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * This class contains all energy information of the Main Character.
 *
 * @author Crazy Monkey Software House
 */
public class Energy {
    
    /*Energy logo*/
    private BufferedImage image;
    
    /*Constants*/
    private final int ENERGY_CONSUMPTION = 3;
    private final int MAX_ENERGY = 15;
    
    /*Energy actual value*/
    private int actualEnergy;
    
    /**
     * It initializes the amount of energy with the max available quantity.
     * It also opens the reading image stream 
     * in order to initialize the variable image.
     */
    public Energy(){
        this.actualEnergy = MAX_ENERGY;
        
        this.readImage();
    }

    /**
     * It returns the constant value ENERGY_CONSUMPTION.
     * @return int
     */
    public int getEnergyConsumption() {
        return ENERGY_CONSUMPTION;
    }

    /**
     * It returns the constant value MAX_ENERGY.
     * @return int
     */
    public int getMaxEnergy() {
        return MAX_ENERGY;
    }

    /**
     * It returns the actual energy value.
     * @return int
     */
    public int getActualEnergy() {
        return actualEnergy;
    }
    
    /**
     * It returns true if it is possible to reduce actualEnergy value.
     * Otherwise, it returns false.
     * @return boolean
     */
    public boolean isReducible(){
        return actualEnergy >= ENERGY_CONSUMPTION;
    }
    
    /**
     * It reduces the actualEnergy value by the constant ENERGY_CONSUMPTION.
     * It initializes and runs an EnergyIncreaser Thread.
     */
    public void reduceEnergy(){
        if(this.isReducible()){
        actualEnergy -= ENERGY_CONSUMPTION;
        new Thread(new EnergyIncreaser()).start();
        }
    }
    
    /**
     * It increases the actualEnergy value by the constant ENERGY_CONSUMPTION.
     */
    protected void increaseEnergy(){
        this.actualEnergy += ENERGY_CONSUMPTION;
    }
    
    /**
     * This method draws the energy logo contained in the BufferedImage instance.
     * @param g2D Graphics2D used to draw the Energy logo.
     */
    public void drawEnergy(Graphics2D g2D){
        g2D.drawImage(image, 20, 40, 20, 20, null);
        g2D.setFont(new Font("Papyrus", Font.BOLD, 22));
        g2D.setColor(Color.white);
        g2D.drawString(String.valueOf(this.getActualEnergy()), 40, 60);
    }
    
    /**
     * This method opens an Image read stream 
     * and initializes the BufferedImage image.
     */
    private void readImage(){
        try{
            this.image = ImageIO.read(getClass().getResourceAsStream("/Resources/fireball.png"));
        }catch(IOException e){
        System.out.println("Errore durante lettura immagine: energy.png");
        }
    }
    
    /**
     * This Thread runs once and invokes the increaseEnergy method
     * of the class Energy.
     */
    private class EnergyIncreaser implements Runnable{

        /**
         * Thread run method.
         */
        @Override
        public void run() {
            try {
                Thread.sleep(10000);
                increaseEnergy();
            } catch (InterruptedException ex) {
                Logger.getLogger(Energy.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
}
