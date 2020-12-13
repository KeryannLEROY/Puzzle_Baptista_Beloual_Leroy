/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author keryann
 */
public class CaseVide extends Tile{ 
    //
    public CaseVide(int x,int y,int num,Board board)
    {
        super(x,y,num,board);
    }
    
    public boolean move(DIRECTION dir)
    {
        boolean valid=false;
        switch(dir)
        {
            case UP:
                if(getPos().getY()!=0)
                {
                    getBoard().swapTiles(pos,new PosInt(pos.getX(),pos.getY()-1));
                    valid=true;
                }
                break;
            case RIGHT:
                if(getPos().getX()!=getBoard().getWidth()-1)
                {
                    getBoard().swapTiles(pos,new PosInt(pos.getX()+1,pos.getY()));
                    valid=true;
                }
                break;
            case DOWN:
                if(getPos().getY()!=getBoard().getHeight()-1)
                {
                    getBoard().swapTiles(pos,new PosInt(pos.getX(),pos.getY()+1));
                    valid=true;
                }
                break;
            case LEFT:
                if(getPos().getX()!=0)
                {
                    getBoard().swapTiles(pos,new PosInt(pos.getX()-1,pos.getY()));
                    valid=true;
                }
                break;
        }
        return valid;
    }
    
    @Override
    public void draw(GraphicsContext context)
    {
        
    }

    @Override
    public void animate(double deltaT) {
        
    }
    
    
    
    @Override
    public String toString()
    {
        return new String("  ");
    }
}
