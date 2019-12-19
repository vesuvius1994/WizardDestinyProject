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
 *
 * @author Jonathan De Maio <j.demaio1@studenti.unisa.it>
 */
public class Score {

    protected int score = 0;

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


    public void draw(Graphics2D g2d) {
        g2d.setFont(new Font("Papyrus", Font.BOLD, 22));
        g2d.setColor(Color.white);
        g2d.drawString("Score: " + String.valueOf(this.score), 470, 30);
    }    
}
