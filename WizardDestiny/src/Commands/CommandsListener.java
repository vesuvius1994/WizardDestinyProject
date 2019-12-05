/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;

import Entities.DynamicEntities.*;
import Entities.Entity;
/**
 *
 * @author letga
 */
public class CommandsListener implements ActionListener{
    
    private MainCharacter mc;
    private JPanel level;
    private Timer timer;
    
    CommandsListener(MainCharacter mc, JPanel level){
        this.mc = mc;
        this.level = level;
        this.level.addKeyListener(new EventKeyHandler());
        
        this.timer = new Timer(10, this);
        this.timer.start();
    }

    /*Quando l'utente preme un tasto,
    *questo metodo si occupa di invocare
    *il metodo move dell'oggetto MainCharacter.
    *Inoltre, aggiorna il JPanel attuale
    *invocando il metodo repaint
    *dell'oggetto level.*/
    @Override
    public void actionPerformed(ActionEvent e) {
        this.mc.movement();
        this.level.repaint();
        //refresh tile of Main Character
    }
    
    /*Gestisce il tipo di azione in base
    *al tasto che è stato premuto dall'utente.
    *Questa funzione suppone che move incrementa
    *l'ascissa e l'ordinata in base ai loro 
    *rispettivi delta.
    *Inoltre, gestisce gli stati in base all'azione da compiere.
    **/
    private class EventKeyHandler implements KeyListener{
        
        @Override
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            
            if(key == mc.getMoveForwardKey() && level.canMoveForward()){
                mc.setDx(1);
                mc.setState(Entity.States.WALKING);
            } else if(key == mc.getMoveBackwardKey() 
                    && level.canMoveBackward()){
                mc.setDx(-1);
                mc.setState(Entity.States.WALKING);
            } else if(key == mc.getJumpKey() && mc.getState() != Entity.States.JUMPING 
                    && level.canJump()){
                mc.setDy(2);
                mc.setState(Entity.States.JUMPING);
            } else if(key == mc.getBasicAttackKey()){
                mc.attack();
                mc.setState(Entity.States.ATTACKING);
            } else if(key == mc.getSpecialAttackKey() && mc.getEnergy() > 0){
                mc.specialAttack();
                mc.decreaseEnergy();
                mc.setState(Entity.States.S_ATTACKING);
            }
            
        }

        @Override
        @SuppressWarnings("empty-statement")
        public void keyTyped(KeyEvent e) {
            ;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            
            if(key == mc.getMoveForwardKey() 
                    || key == mc.getMoveBackwardKey()){
                mc.setDx(0);
            } else if(key == mc.getJumpKey()){
                mc.setDy(0);
            }
            mc.setState(Entity.States.IDLE);
        }
    }
}
