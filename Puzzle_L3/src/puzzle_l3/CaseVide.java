/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author kerya
 */
public class CaseVide extends Tile{ 
    
    public boolean move(DIRECTION dir)
    {
        boolean valid=false;
        switch(dir)
        {
            case DIRECTION.UP:
                if(getPos().getY()!=0)
                {
                    getBoard().swapTiles(pos,new PosInt(pos.getX(),pos.getY()-1));
                    valid=true;
                }
                break;
            case DIRECTION.RIGHT:
                if(getPos().getX()!=getBoard().getWidth()-1)
                {
                    getBoard().swapTiles(pos,new PosInt(pos.getX()+1,pos.getY()));
                    valid=true;
                }
                break;
            case DIRECTION.DOWN:
                if(getPos().getY()!=getBoard().getHeight()-1)
                {
                    getBoard().swapTiles(pos,new PosInt(pos.getX(),pos.getY()+1));
                    valid=true;
                }
                break;
            case DIRECTION.LEFT:
                if(getPos().getX()!=0)
                {
                    getBoard().swapTiles(pos,new PosInt(pos.getX()-1,pos.getY()));
                    valid=true;
                }
                break;
        }
        return valid;
    }
    
    public void draw(GraphicsContext context)
    {
        
    }
}
