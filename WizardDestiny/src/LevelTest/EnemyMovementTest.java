/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LevelTest;

import Commands.LevelManager;
import Entities.DynamicEntities.Werewolf;
import Level.Level;
import java.awt.event.ActionEvent;

/**
 *
 * @author letga
 */
public class EnemyMovementTest extends LevelManager {
    
    private Werewolf enemy;
    
    public EnemyMovementTest(Level level) {
        super(level);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        super.actionPerformed(e);
        enemy.movement();
    }
    
    public void setEnemy(Werewolf e){
        this.enemy = e;
    }
}
