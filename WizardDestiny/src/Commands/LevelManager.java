/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import java.awt.event.*;
import javax.swing.Timer;

import Entities.DynamicEntities.*;
import Entities.DynamicEntities.Attacks.Attack;
import Entities.Entity;
import Entities.StaticEntities.Block;
import Entities.StaticEntities.Diamond;
import Level.Level;
import java.util.ArrayList;
import java.util.List;


/**
 * This Class manages controls input given by the Player.
 * It handles all events related to pressed keys.
 *
 * N.B. Bisogna gestire il ritorno dallo stato ATTACK 
 * a quello di IDLE.
 * @author letga
 */
public class LevelManager implements ActionListener{
    
    private MainCharacter mc;
    protected Level level;
    
    /*It is used to manage the ActionListener Thread.*/
    private Timer timer;
    
    /*Variables used to manage Main Character jump action.*/
    private long jumpingTime;
    private boolean isJumping;
    
    /**
     * Constructor of the Class.It takes the Main Character and Level objects as input.
     * It instantiates EventListener and Timer objects.
     * @param level
     */
    public LevelManager(Level level){
        this.level = level;
        this.mc = this.level.getMainCharacter();
        this.level.addKeyListener(new EventKeyHandler());
        this.level.setFocusable(true);
        this.jumpingTime = 400;
        this.isJumping = false;
    }
    
    /**
     * It instantiates a Timer object.
    */
    public void startListener(){
        this.timer = new Timer(10, this);
        this.timer.start();
    }
    
    /**
     * It updates the Main Character position
     * and Level Panel.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //move all entities
        this.mc.movement();
        updateAttacks();
        this.collisionDetection(this.level.getDynamicEntities(), 
                this.level.getStaticEntities());
        this.level.repaint();
        //refresh tile of Main Character
    }
    
    /**
     * Update Main Character attacks
     */
    private void updateAttacks(){
        List<Attack> Attacks = mc.getAttacks();
        for(Attack a : Attacks){
            if(a.isVisible()){
                a.movement();
                this.attackCollisionDetection(this.level.getDynamicEntities(), this.level.getStaticEntities(), a);
            }
            else
                Attacks.remove(a);
        }
    }
    
    private void attackCollisionDetection(ArrayList<Entity> dynamicEntities,
            ArrayList<Entity> staticEntities, Attack attack){
        
        for(int i = 0; i < dynamicEntities.size(); i++){
            Enemy enemy = (Enemy) dynamicEntities.get(i);
            if(enemy.getBounds().intersects(attack.getBounds())){
            if ((attack.getPosX() + attack.getWidth()) >= enemy.getPosX() &&
                    attack.getPosX() < enemy.getPosX() &&
                     attack.getPosY() <= (enemy.getPosY() + 30) 
                    & attack.getPosY() > enemy.getPosY()) {
                //non posso andare a destra
                attack.setPosY(-100);
                enemy.setPosX(-10);
            }
        }
        }
        
        for(int i = 0; i < staticEntities.size(); i++){
            if (staticEntities.get(i) instanceof Block 
                && staticEntities.get(i).getBounds().intersects(attack.getBounds())) {
                Block block = (Block) staticEntities.get(i);
                if ((attack.getPosX() + attack.getWidth()) >= block.getPosX() &&
                    attack.getPosX() < block.getPosX() &&
                     attack.getPosY() <= (block.getPosY() + 30) 
                    & attack.getPosY() > block.getPosY()) {
                //non posso andare a destra
                attack.setPosY(-100);
            }
            }
        }
    }
    private void collisionDetection(ArrayList<Entity> dynamicEntities, 
            ArrayList<Entity> staticEntities){
        
        for(int i = 0; i < staticEntities.size(); i++){
             /*Intersazione lato destro di un blocco*/ 
        if (staticEntities.get(i) instanceof Block 
                && staticEntities.get(i).getBounds().intersects(this.mc.getBounds())) {
            //sto intersecando il lato sinistro della tile
            Block block = (Block) staticEntities.get(i);
            if ((mc.getPosX() + mc.getWidth()) >= block.getPosX() &&
                    mc.getPosX() < block.getPosX() &&
                    mc.getPosY() <= (block.getPosY() + 30) &&
                    mc.getPosY() > block.getPosY()) {
                //non posso andare a destra
                mc.setPosX(block.getPosX() - mc.getWidth());
            }
            //sto intersecando il lato inferiore della tile
            else if ((mc.getPosX() + mc.getWidth()) < (block.getPosX() + 30) 
                    & (mc.getPosX() + mc.getWidth()) > block.getPosX() 
                    & mc.getPosY() < (block.getPosY() + block.getHeight())) {
                //stop jumping
                mc.setPosY(block.getPosY() + block.getHeight());
            } 
            //sto intersecando il lato destro della tile
            else if (mc.getPosX() <= (block.getPosX() + 30) &&
                    (mc.getPosX() + mc.getWidth()) > (block.getPosX() + block.getWidth())
                    & mc.getPosY() <= (block.getPosY() + 30) 
                    & mc.getPosY() > block.getPosY()) {
                //non posso andare a sinistra
                mc.setPosX(block.getPosX() + block.getWidth());
            }
            //sto intersecando il lato superiore della tile
            else {
                //stop falling
                mc.setPosY(block.getPosY() - mc.getHeight());
            }
        } else if (staticEntities.get(i) instanceof Diamond 
                && staticEntities.get(i).getBounds().intersects(this.mc.getBounds())) {
            this.level.incrementScore();
            staticEntities.get(i).setPosX(-10);
       }
    }
    //collision between main character and enemies
        for (int i = 0; i < dynamicEntities.size(); i++) {
            if (dynamicEntities.get(i) instanceof Enemy
                    && dynamicEntities.get(i).getBounds().intersects(this.mc.getBounds())) {
                Enemy enemy = (Enemy) dynamicEntities.get(i);
                if(mc.getHealth().getHealth() > 0 &&
                        (mc.getPosX() + mc.getWidth()) >= enemy.getPosX() &&
                        mc.getPosX() < enemy.getPosX() &&
                        !((mc.getPosY() + mc.getHeight()) < enemy.getPosY())){
                    mc.setPosX(mc.getPosX() - 40);
                    mc.getHealth().setHealth(mc.getHealth().getHealth() - 1);
                }
            }

        }
}
    
    /**
     * It handles all inputs given by the Player.
     */
    private class EventKeyHandler implements KeyListener{
        
        @Override
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            
            if(key == mc.getCommand().getDx()){
                mc.setDx(2);
                mc.setState(Entity.States.WALKING);
            } else if(key == mc.getCommand().getSx()){
                mc.setDx(-2);
                mc.setState(Entity.States.WALKING);
            } else if(key == mc.getCommand().getJump() && !isJumping){
                new Thread(new JumpManagementThread()).start();
            } else if(key == mc.getCommand().getAttackB()){
                mc.setState(Entity.States.ATTACKING);
                mc.attack();
            } else if(key == mc.getCommand().getAttackS() && mc.getEnergy() > 0){
                mc.setState(Entity.States.S_ATTACKING);
                mc.specialAttack();
                mc.decreaseEnergy();
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
            
            if(key == mc.getCommand().getDx()
                    || key == mc.getCommand().getSx()){
                mc.setDx(0);
                mc.setState(Entity.States.IDLE);
            }
            if(key == mc.getCommand().getAttackS() 
                    || key == mc.getCommand().getAttackB()){
                mc.setState(Entity.States.IDLE);
            }
        }
    }
    
    /**
     * This Thread manages the Main Character Jump Action.
     */
    private class JumpManagementThread implements Runnable{

        @Override
        public void run() {
            try{
                isJumping = true;
                mc.setState(Entity.States.JUMPING);
                mc.setDy(-3);
                Thread.sleep(jumpingTime);
                mc.setDy(3);
                Thread.sleep(jumpingTime);
                //mc.setDy(0);
                isJumping = false;
                mc.setState(Entity.States.IDLE);
            }catch(InterruptedException e){
                System.exit(0);
            }
        }
        
    }
}
