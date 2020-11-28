/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

import javafx.animation.AnimationTimer;

/**
 *
 * @author kerya
 */
public class ViewPartie extends AnimationTimer {
    
    ScenePartieController controler;
    long previousNow;
    double deltaT;
    
    public ViewPartie(ScenePartieController controler)
    {
        super();
        this.controler=controler;
    }
     
    @Override
    public void handle(long now) {
        /*
        deltaT = (now-previousNow)*Math.pow(10,-9);
        deltaT=deltaT>1?0:deltaT;
        previousNow=now;
        controler.board.animate(deltaT);*/
        
        controler.clearCanvas();
        controler.partie.getBoard().draw(controler.canvasPuzzle.getGraphicsContext2D());
        
        controler.displayTime((int)(controler.partie.getTimer().getChrono()));
        //System.out.println(controler.board);
        
        
        
    }

}
