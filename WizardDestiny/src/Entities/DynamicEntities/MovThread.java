/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities;

/**
 *
 * @author Gumo
 */
public class MovThread implements Runnable{
    
    private Enemy wolf;

    public MovThread(Enemy en) {
        this.wolf=en;
    }
    
    
    public void run() { 
    try
        { 
            Thread.sleep(5000);
            // Displaying the thread that is running 
            System.out.println ("Thread " + 
                  " is running"); 
            wolf.movement();
  
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
     
    }
    
}

