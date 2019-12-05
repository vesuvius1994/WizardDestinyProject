/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author ludovicorusso
 */
public class DefaultCommand extends SourceCommand{
    
    public DefaultCommand(){
        super.setAttackB(KeyEvent.VK_A);
        super.setAttackS(KeyEvent.VK_D);
        super.setJump(KeyEvent.VK_UP);
        super.setDx(KeyEvent.VK_RIGHT);
        super.setSx(KeyEvent.VK_LEFT);
    }

    @Override
    public boolean getTypeCommand() {
        return super.getTypeCommand(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSx() {
        return super.getSx(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDx() {
        return super.getDx(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getJump() {
        return super.getJump(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAttackS() {
        return super.getAttackS(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAttackB() {
        return super.getAttackB(); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
