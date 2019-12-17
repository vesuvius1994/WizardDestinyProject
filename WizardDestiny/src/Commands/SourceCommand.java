/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ludovicorusso
 */
public class SourceCommand {
    private int jump;
    private int dx;
    private int sx;
    private int attackB;
    private int attackS;

    public int getAttackB() {
        return attackB;
    }

    public void setAttackB(int attackB) {
        this.attackB = attackB;
    }

    public int getAttackS() {
        return attackS;
    }

    public void setAttackS(int attackS) {
        this.attackS = attackS;
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

    public PersonalizableCommand getPersonalizzable() throws IOException{
        File Command=new File("src/Resources/personalizzablecommand.dat");
        SerializzatoreCommand cmd =new SerializzatoreCommand();
        if (Command.exists())
                try {
                    return cmd.load();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SourceCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public DefaultCommand getDefault() throws IOException{
        return new DefaultCommand();
    }
    public boolean getTypeCommand() throws IOException{
        File Command=new File("src/Resources/personalizzablecommand.dat");
        SerializzatoreCommand cmd =new SerializzatoreCommand();
        return Command.exists();
    }
}
