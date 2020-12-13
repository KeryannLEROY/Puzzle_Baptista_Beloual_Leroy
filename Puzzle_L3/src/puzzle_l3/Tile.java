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
public abstract class Tile  implements java.io.Serializable{
    
    /**
     *
     */
    protected PosInt pos;

    /**
     *
     */
    protected PosInt posInit;

    /**
     *
     */
    protected  int numero;

    /**
     *
     */
    protected  Board board;
    
    /**
     *
     * @param x
     * @param y
     * @param num
     * @param board
     */
    public Tile(int x,int y,int num,Board board)
    {
        this.pos = new PosInt(x,y);
        this.posInit=(PosInt)pos.clone();
        this.numero = num;
        this.board=board;
    }

    
    /**
     *
     * @return
     */
    public PosInt getPos()
    {
        return (PosInt) pos.clone();
    }
    
    /**
     *
     * @param x
     * @param y
     */
    public void setPos(int x,int y) 
    {
        this.pos.setX(x);
        this.pos.setY(y);
    }
    
    /**
     *
     * @param nPos
     */
    public void setPos(PosInt nPos)
    {
        setPos(nPos.getX(),nPos.getY());
    }
    
    /**
     *
     * @return
     */
    public int getNum()
    {
        return numero;
    }
    
    /**
     *  
     * 
     * @return
     */
    public Board getBoard()
    {
        return this.board;
    }

    /**
     *
     * @return
     */
    public PosInt getPosInit() {
        return (PosInt) posInit.clone();
    }

    /**
     *
     * @return
     */
    public int getNumero() {
        return numero;
    }
    
    /**
     *
     * @return
     */
    public boolean checkPlacementAbsolute()
    {
        return pos.getX() ==  posInit.getX() && pos.getY() == posInit.getY();
    }
    
    /**
     *
     * @return
     */
    public int checkPlacementRelative()
    {
        int nbValid=0;
        PosInt [] voisins={
            new PosInt(pos.getX()-1, pos.getY()),
            new PosInt(pos.getX(), pos.getY()-1),
            new PosInt(pos.getX()+1, pos.getY()),
            new PosInt(pos.getX(), pos.getY()+1)
        };
        for (PosInt p:voisins)
        {
            try{
               if( pos.getX()-p.getX()==posInit.getX()-getBoard().getTile(p).getPosInit().getX() && pos.getY()-p.getY()==posInit.getY()-getBoard().getTile(p).getPosInit().getY())
                   nbValid++;
            }catch(IndexOutOfBoundsException e){
                
            }
            
        }
        
        return nbValid;
    }
    
    /**
     *
     * @param context
     */
    abstract public void draw(GraphicsContext context);

    /**
     *
     * @param deltaT
     */
    abstract public void animate(double deltaT);
    @Override
    public String toString()
    {
        return String.format("%02d",this.numero);
    }


    
    
    
}
