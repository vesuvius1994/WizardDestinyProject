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
import Entities.DynamicEntities.Enemy.Boss;
import Entities.DynamicEntities.Enemy.Enemy;
import Entities.Entity;
import Entities.StaticEntities.Block;
import Entities.StaticEntities.Diamond;
import GameSound.Sound;
import Level.Level;
import java.util.ArrayList;
import java.util.List;


/**
 * This Class manages controls input given by the Player.
 * It handles all gameplay events.
 *
 * @author Crazy Monkey Software House
 */
public class LevelManager implements ActionListener{
    
    
    private final MainCharacter mc;
    
    protected Level level;
    
    /*It is used to manage the ActionListener Thread.*/
    private Timer timer;
    
    /*Variables used to track Main Character states.*/
    private final long jumpingTime;
    private boolean isJumping;
    private boolean isWalkingRight;
    private boolean isWalkingLeft;
    private boolean isAttacking;
    private boolean isFalling;
    private boolean isIdle;
    
    /*Instance of the class Sound.*/
    private Sound sound;

        
    /**
     *It instantiates all class attributes.
     * 
     * @param level
     */
    public LevelManager(Level level){
        this.level = level;
        this.mc = this.level.getMainCharacter();
        this.level.addKeyListener(new EventKeyHandler());
        this.level.setFocusable(true);
        this.jumpingTime = 400;
        this.isJumping = false;
        this.isWalkingRight = false;
        this.isWalkingLeft = false;
        this.isAttacking = false;
        this.isFalling = true;
        this.isIdle = true;
        
        this.sound = new Sound();
        
    }
    
    /**
     * It instantiates and starts a Timer object.
    */
    public void startListener(){
        this.timer = new Timer(10, this);
        this.timer.start();
    }
    
    /**
     * It enables all level entities to move
     * and controls all their possible interactions.
     * Finally, it updates the Panel state.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //move all entities
        this.mc.movement();
        this.moveDynamicEntities(this.level.getDynamicEntities());
        
        updateAttacks();
        
        this.collisionDetection(this.level.getDynamicEntities(), 
                this.level.getStaticEntities());
                
        this.level.repaint();
        //refresh tile of Main Character
    }
    
    /**
     * It invokes the movement method of level dynamic entities.
     * @param dynamicEntities 
     */
    private void moveDynamicEntities(ArrayList<Entity> dynamicEntities){
    
        for(int i = 0; i < dynamicEntities.size(); i++){
            Enemy e = (Enemy) dynamicEntities.get(i);
            e.movement();
        }
    }
    
    /**
     * It updates the Attack entities positions.
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
    
    /**
     * It checks and manages all collision between an Attack entity
     * and all other level entities.
     * 
     * @param dynamicEntities
     * @param staticEntities
     * @param attack 
     */
    private void attackCollisionDetection(ArrayList<Entity> dynamicEntities,
            ArrayList<Entity> staticEntities, Attack attack){
        int i = 0;
        while(i < dynamicEntities.size()){
            Enemy enemy = (Enemy) dynamicEntities.get(i);
            
            if(enemy.getBounds().intersects(attack.getBounds())){
                
                if (attack.getPosX() < (enemy.getPosX() + enemy.getWidth()) &&
                    attack.getPosX() >= enemy.getPosX() &&
                    !((attack.getPosY() + attack.getHeight()) < enemy.getPosY())) {
                    
                    attack.setPosY(-100);
                    if(enemy.getHealth() - attack.getStrength() <= 0){
                        dynamicEntities.remove(i);
                        this.level.removeTile(i);
                        this.level.incrementScore(3);
                        if(enemy instanceof Boss){
                            this.level.setGameWin(true);
                            this.level.incrementScore(100);
                        }
                        
                    }
                    else{
                        enemy.decreaseHealth(attack.getStrength());
                        i++;
                    }
                }
                i++;
            } else {
                i++;
            }
        }
        
        for(i = 0; i < staticEntities.size(); i++){
            if (staticEntities.get(i) instanceof Block 
                && staticEntities.get(i).getBounds().intersects(attack.getBounds())) {
                Block block = (Block) staticEntities.get(i);
                
                if ((attack.getPosX() + attack.getWidth()) >= block.getPosX() &&
                    attack.getPosX() < block.getPosX() &&
                     attack.getPosY() <= (block.getPosY() + block.getHeight()) 
                    & attack.getPosY() > block.getPosY()) {
                    
                    attack.setPosY(-100);
                }
            }
        }
    }
    
    /**
     * It checks and manages all interactions between the Main Character
     * and all other level entities.
     * 
     * @param dynamicEntities
     * @param staticEntities 
     */
    private void collisionDetection(ArrayList<Entity> dynamicEntities,
            ArrayList<Entity> staticEntities){
        
        for(int i = 0; i < staticEntities.size(); i++){
            if(staticEntities.get(i) instanceof Block && 
                    staticEntities.get(i).getBounds().intersects(mc.getBounds())){
                Block block = (Block) staticEntities.get(i);
                
             if((mc.getPosY() + mc.getHeight()) > block.getPosY() &&
                     mc.getPosY() < block.getPosY()){
                 mc.setPosY(block.getPosY() - mc.getHeight());
                 isFalling = false;
                 isJumping = false;
            } else if(isJumping && 
                        mc.getPosY() < (block.getPosY() + block.getHeight())){
                    mc.setPosY(block.getPosY() + block.getHeight() + 3);
                    mc.setDy(3);
                    mc.setState(Entity.States.FALLING);
                    sound.playClip("/Resources/SoundPack/sfx_impact.wav");
                    isFalling = true;
                    isJumping = false;
                } else if(isWalkingRight &&
                        (mc.getPosX() + mc.getWidth()) > block.getPosX()){
                    mc.setPosX(block.getPosX() - mc.getWidth());
                    mc.setDx(0);
                    isWalkingRight = false;
                    sound.playClip("/Resources/SoundPack/sfx_impact.wav");
                    mc.setState(Entity.States.IDLE);
                } else if(isWalkingLeft &&
                        mc.getPosX() < (block.getPosX() + block.getWidth())){
                    mc.setPosX(block.getPosX() + block.getWidth());
                    mc.setDx(0);
                    isWalkingLeft = false;
                    sound.playClip("/Resources/SoundPack/sfx_impact.wav");
                    mc.setState(Entity.States.IDLE);
                }
            } else if(staticEntities.get(i) instanceof Diamond && 
                    staticEntities.get(i).getBounds().intersects(mc.getBounds())){
                this.level.incrementScore(5);
                staticEntities.get(i).setPosX(-200);
                sound.playClip("/Resources/SoundPack/sfx_diamond.wav");
                
            }
            
        }
        
        for(int i = 0; i < dynamicEntities.size(); i++){
            Enemy enemy = (Enemy) dynamicEntities.get(i);
            
            if(enemy.getBounds().intersects(mc.getBounds())){
                mc.decreaseHealth(1);
                sound.playClip("/Resources/SoundPack/sfx_impact.wav");
                if(isWalkingRight || isIdle ||
                        (isJumping &&
                         mc.getPosX() < enemy.getPosX() &&
                        (mc.getPosX() + mc.getWidth() > enemy.getPosX()))){
                    mc.setPosX(enemy.getPosX() - (mc.getWidth() * 2) - enemy.getWidth());
                    mc.setDx(0);
                    mc.setState(Entity.States.IDLE);
                    isWalkingRight = false;
                } else if(isWalkingLeft ||
                        (isJumping &&
                        mc.getPosX() < (enemy.getPosX() + enemy.getWidth()) &&
                        (mc.getPosX() + mc.getWidth()) > 
                        (enemy.getPosX() + enemy.getWidth()))){
                    mc.setPosX(enemy.getPosX() + enemy.getWidth() + (mc.getWidth() * 2));
                    mc.setDx(0);
                    mc.setState(Entity.States.IDLE);
                    isWalkingLeft = false;
                } 
            }
        }
        
        if(mc.getPosY() > 530){
            mc.decreaseHealth(mc.getHealth());
        }
        
    }

    /**
     * It handles all inputs given by the Player.
     */
    private class EventKeyHandler implements KeyListener{
        
        @Override
        public void keyPressed(KeyEvent e){
              if(mc.getState() != Entity.States.DEAD){
                int key = e.getKeyCode();
              
                if(key == mc.getCommand().getDx()){
                    mc.setDx(2);
                    mc.setState(Entity.States.WALKING);
                    isWalkingRight = true;
                } else if(key == mc.getCommand().getSx()){
                    mc.setDx(-2);
                    mc.setState(Entity.States.WALKING);
                    isWalkingLeft = true;
                } else if(key == mc.getCommand().getJump() && !isJumping && !isFalling){
                    new Thread(new JumpManagementThread()).start();
                    sound.playClip("/Resources/SoundPack/sfx_movement_jump.wav");
                } else if(!isAttacking && key == mc.getCommand().getAttackB()){
                    isAttacking = true;
                    mc.setState(Entity.States.ATTACKING);
                    mc.attack();
                    sound.playClip("/Resources/SoundPack/sfx_basicattack.wav");
                } else if(!isAttacking && key == mc.getCommand().getAttackS()){
                    isAttacking = true;
                    mc.setState(Entity.States.S_ATTACKING);
                    mc.specialAttack();
                    sound.playClip("/Resources/SoundPack/sfx_specialattack.wav");
                }
              }else{
                  timer.stop();
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
                isWalkingRight = false;
                isWalkingLeft = false;
            }
            if(key == mc.getCommand().getAttackS() 
                    || key == mc.getCommand().getAttackB()){
                isAttacking = false;
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
                mc.setState(Entity.States.FALLING);
                isFalling = true;
                Thread.sleep(jumpingTime);
                isJumping = false;
                mc.setState(Entity.States.IDLE);
                sound.playClip("/Resources/SoundPack/sfx_movement_jump_landing.wav");
            }catch(InterruptedException e){
                System.exit(0);
            }
        }   
    }
}
