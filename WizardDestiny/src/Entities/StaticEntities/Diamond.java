/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.StaticEntities;

/**
 *
 * @author Antonio Dello Russo <a.dellorusso11@studenti.unisa.it>
 */
public class Diamond extends StaticEntity{
    // Represents the value of a diamond which will be added in the score while picked 
    protected int value;
    
    public Diamond(int posX, int posY) {
        super(posX, posY);
        this.value = 100;
        this.setHeight(30);
        this.setWidth(30);
    }

    public int getValue() {
        return value;
    }
}
