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
public abstract class Tile {
    
    protected PosInt pos;
    protected  int numero;
    protected  Board board;
    
    public Tile(int x,int y,int num,Board board)
    {
        this.pos = new PosInt(x,y);
        this.numero = num;
        this.board=board;
    }
    
    public PosInt getPos()
    {
        return (PosInt) pos.clone();
    }
    
    public void setPos(int x,int y) 
    {
        this.pos.setX(x);
        this.pos.setY(y);
    }
    
    public void setPos(PosInt nPos)
    {
        setPos(nPos.getX(),nPos.getY());
    }
    
    public int getNum()
    {
        return numero;
    }
    
    public Board getBoard()
    {
        return this.board;
    }
    
    public boolean checkPlacementAbsolute()
    {
        return pos.getX() ==  (numero-1+getBoard().getWidth()) % getBoard().getWidth() && pos.getY() == (int)((numero-1+(getBoard().getWidth()*getBoard().getHeight()))%(getBoard().getWidth()*getBoard().getHeight()) /getBoard().getWidth());
    }
    
    public int checkPlacementRelative()
    {
        int nbValid=0;
        if((pos.getX()==0 && (numero-1)%getBoard().getWidth()==0)
            || getBoard().getTile(pos.getX()-1,pos.getY()).getNum()==numero-1) ++nbValid;
        if((pos.getY()==0 && (int)((numero-1)/getBoard().getWidth())==0)
            || getBoard().getTile(pos.getX(),pos.getY()-1).getNum()==numero-getBoard().getWidth()) ++nbValid;
        
        if((pos.getX()==getBoard().getWidth() && (numero-1)%getBoard().getWidth()==getBoard().getWidth()-1)
            || getBoard().getTile(pos.getX()+1,pos.getY()).getNum()==numero+1) ++nbValid;
        if((pos.getY()==getBoard().getHeight() && (int)((numero-1)/getBoard().getWidth())==getBoard().getHeight()-1)
            || getBoard().getTile(pos.getX(),pos.getY()+1).getNum()==numero+getBoard().getWidth()) ++nbValid;
        
        return nbValid;
    }
    
    abstract public void draw(GraphicsContext context);
    abstract public void animate(double deltaT);
    @Override
    public String toString()
    {
        return String.format("%02d",this.numero);
    }
    
    
    
}
