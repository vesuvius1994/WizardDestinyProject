/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Level;

import Entities.*;
import Entities.DynamicEntities.*;
import java.util.ArrayList;

/**
 *
 * @author letga
 */
public class LevelBuilder {
    
    private ArrayList entities;
    
    public LevelBuilder(){
        this.entities = new ArrayList<Entity>();
    }
    
    public void createMainCharacter(int x, int y){
        this.entities.add(new MainCharacter(x, y));
    }
    
    public void createEnemy(){
        //TO BE IMPLEMENTED
    }
    
    public void createStaticEntity(){
        //TO BE IMPLEMENTED
    }
}
