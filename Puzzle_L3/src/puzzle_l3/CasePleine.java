s/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 *
 * @author keryann
 */
public class CasePleine extends Tile{
    
    
    private PosDouble posGraphic;

    private Image image;
    private Color highlight;
    private boolean isHighlighted;

    public CasePleine(int x,int y,int num,Board board)
    {
        super(x,y,num,board);
    }
        
    public boolean move()
    {
        List voisins;
        try{
            voisins.add(getBoard().getTile(pos.getX()-1),pos.getX())
        }catch(IndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
        try{
            voisins.add(getBoard().getTile(pos.getX()),pos.getX()-1)
        }catch(IndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
        try{
            voisins.add(getBoard().getTile(pos.getX()+1),pos.getX())
        }catch(IndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
        try{
            voisins.add(getBoard().getTile(pos.getX()),pos.getX()+1)
        }catch(IndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
        for(int i=0;i<voisins.size();++i)
        {
            if(voisins.get(i) instanceof CaseVide)
            {
                getBoard().swapTiles(voisins.get(i).getPos(),this.getPos());
                return true;
            }
        }
        return false;
    }
    
    public void setHighlightColor(Color col)
    {
        highlight=col;
    }
    
    public void toggleHighlight(boolean toggled)
    {
        isHighlighted=toggled;
    }
    
    @Override
    public void draw(GraphicsContext context)
    {
        
    }
}
