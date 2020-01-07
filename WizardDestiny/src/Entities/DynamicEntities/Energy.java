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
 *
 * @author letga
 */
public class Energy {
    private BufferedImage image;
    
    private final int ENERGY_CONSUMPTION = 3;
    private final int MAX_ENERGY = 15;
    
    private int actualEnergy;
    
    public Energy(){
        this.actualEnergy = MAX_ENERGY;
        
        this.readImage();
    }

    public int getEnergyConsumption() {
        return ENERGY_CONSUMPTION;
    }

    public int getMaxEnergy() {
        return MAX_ENERGY;
    }

    public int getActualEnergy() {
        return actualEnergy;
    }
    
    public boolean isReducible(){
        return actualEnergy >= ENERGY_CONSUMPTION;
    }
    
    public void reduceEnergy(){
        if(this.isReducible()){
        actualEnergy -= ENERGY_CONSUMPTION;
        new Thread(new EnergyIncreaser()).start();
        }
    }
    
    protected void increaseEnergy(){
        this.actualEnergy += ENERGY_CONSUMPTION;
    }
    
    public void drawEnergy(Graphics2D g2D){
        g2D.drawImage(image, 20, 40, 20, 20, null);
        g2D.setFont(new Font("Papyrus", Font.BOLD, 22));
        g2D.setColor(Color.white);
        g2D.drawString(String.valueOf(this.getActualEnergy()), 40, 60);
    }
    
    private void readImage(){
        try{
            this.image = ImageIO.read(getClass().getResourceAsStream("/Resources/fireball.png"));
        }catch(IOException e){
        System.out.println("Errore durante lettura immagine: energy.png");
        }
    }
    
    private class EnergyIncreaser implements Runnable{

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
