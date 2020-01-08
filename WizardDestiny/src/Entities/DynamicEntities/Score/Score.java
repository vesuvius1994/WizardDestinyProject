/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities.Score;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *This class contains the player's score information.
 * @author Crazy Monkey Software House
 */
public class Score {

    /*Current value of the player's score.*/
    protected int score;

    /**
     * Score class constructor.
     * It initializes the score variable with a given int input.
     * @param score int
     */
    public Score(int score) {
        this.score = score;
    }

    /**
     * Get the value of score
     *
     * @return the value of score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Set the value of score
     *
     * @param score new value of score
     */
    public void setScore(int score) {
        this.score = score;
    }


    /**
     * It draws the actual player's score value on a Componet
     * by using a Graphics2D object.
     * @param g2d Graphics2D
     */
    public void draw(Graphics2D g2d) {
        g2d.setFont(new Font("Papyrus", Font.BOLD, 22));
        g2d.setColor(Color.white);
        g2d.drawString("Score: " + String.valueOf(this.score), 470, 30);
    }    
}
