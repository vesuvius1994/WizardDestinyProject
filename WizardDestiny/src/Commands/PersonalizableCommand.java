/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import java.io.*;

/**
 *
 * @author ludovicorusso
 */
public class PersonalizableCommand extends SourceCommand implements Serializable{
    
    public PersonalizableCommand(int jump,int dx,int sx,int attackB,int attackS) {
        super.setJump(jump);
        super.setDx(dx);
        super.setSx(sx);
        super.setAttackB(attackB);
        super.setAttackS(attackS);
    }
    
    public void setAttack_b(int attackB){
        super.setAttackB(attackB);
    }
     public void setAttack_s(int attackS){
        super.setAttackS(attackS);
    }
    public void setDx(int dx){
        super.setDx(dx);
    }
    public void setSx(int sx){
        super.setSx(sx);
    }
    public void setJump(int jump){
        super.setJump(jump);
    }
    
    public String toString(){
        return "Attack_s "+super.getAttackS()+"Attack_b: "+super.getAttackB()+"Jump:"+super.getJump();
    } 
}
