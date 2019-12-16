/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Level;

/**
 *THIS CLASS IS ONLY FOR TEST PURPOSE.
 * @author letga
 */
public class DemoLevel extends Level{

    /*Objects coordinates*/
    private int platformX = 0;
    private int platformY = 450;
    private int platformLength = 540;
    
   
    
    @Override
    protected void collisionDetection(){
        if((mc.getPosY() + mc.getHeight()) > platformY 
                && mc.getPosX() <= (720 + dx)){
            mc.setPosY(platformY - mc.getHeight());
        }
        if(mc.getPosX() < 0){
            mc.setPosX(0);
        }
    }
    
    @Override
    protected void scrolling(){
        if(mc.getPosX() > 240){
            dx -= 2;
            //bg.update();
            mc.setPosX(240);
        }
    }
    
    /*Useless methods, since these operations are handled by Level itself.*/
//    public void setMainCharacter(MainCharacter mc){
//        this.mc = mc;
//    }
//    
//    public boolean canMoveForward(){
//        return true;
//    }
//    
//    public boolean canMoveBackward(){
//        return true;
//    }
//    
//    public boolean canJump(){
//        return true;
//    }

    @Override
    protected void setPaths() {
        this.mapLevelPath = "/Resources/level_1.map";
        this.backgroundPath = "/Resources/bg.png";
        this.tileMatrixPath = "/Resources/tileMatrix.png";
    }
}
