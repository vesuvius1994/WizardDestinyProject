/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import java.io.File;
import java.util.*;

/**
 *
 * @author ludovicorusso
 */
public class SourceCommand {
    private int jump;
    private int dx;
    private int sx;
    private int attack_b;
    private int attack_s;

    public int getAttackB() {
        return attack_b;
    }

    public void setAttackB(int attack_b) {
        this.attack_b = attack_b;
    }

    public int getAttackS() {
        return attack_s;
    }

    public void setAttackS(int attack_s) {
        this.attack_s = attack_s;
    }
    
    
    public int getJump() {
        return jump;
    }

    public void setJump(int jump) {
        this.jump = jump;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getSx() {
        return sx;
    }

    public void setSx(int sx) {
        this.sx = sx;
    }

    

    
    public boolean getTypeCommand(){
        File Command = new File("/src/PersonalizableComand/");
        if (Command.exists())
                return true;
        return false;
    }
}
