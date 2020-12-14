/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

import javafx.scene.canvas.GraphicsContext;

/**
 *  Classe représentant une case du puzzle
 * @author keryann
 */
public abstract class Tile  implements java.io.Serializable{
    //
    /**
     *  Position de la case dans la grille du puzzle.
     */
    protected PosInt pos;

    /**
     *  Position de la case dans la grille du puzzle.
     */
    protected PosInt posInit;

    /**
     *  Identifiant de la case.
     */
    protected  int numero;

    /**
     *  Board dans lequel la case est contenu.
     */
    protected  Board board;
    
    /**
     *  Constructeur de la classe Tile.
     * @param x coordonnée x de la case(entier).
     * @param y coordonnée Y de la case(entier).
     * @param num numero identifiant.
     * @param board Board dans lequel la case est contenu.
     */
    public Tile(int x,int y,int num,Board board)
    {
        this.pos = new PosInt(x,y);
        this.posInit=(PosInt)pos.clone();
        this.numero = num;
        this.board=board;
    }

    
    /**
     *  Accesseur à l'attribut position.
     * @return Position de la case(Posint)
     */
    public PosInt getPos()
    {
        return (PosInt) pos.clone();
    }
    
    /**
     *  Modificateur à l'attribut position.
     * @param x nouvelle coordonnée x
     * @param y nouvelle coordonnée y
     */
    public void setPos(int x,int y) 
    {
        this.pos.setX(x);
        this.pos.setY(y);
    }
    
    /**
     *  Modificateur à l'attribut position.
     * @param nPos nouvelle position de la case.
     */
    public void setPos(PosInt nPos)
    {
        setPos(nPos.getX(),nPos.getY());
    }
    
    /**
     *  Accesseur à l'attribut Numero.
     * @return numero de la case(entier)
     */
    public int getNum()
    {
        return numero;
    }
    
    /**
     *  Accesseur au Board dans lequel la case est contenu.
     * 
     * @return conteneur de la case
     */
    public Board getBoard()
    {
        return this.board;
    }

    /**
     *  Accesseur à l'attribut position initiale.
     * @return position Initiale(PosInt)
     */
    public PosInt getPosInit() {
        return (PosInt) posInit.clone();
    }



    
    /**
     *  Verifie si la case est à sa position Initiale. Renvoie true si c'est le cas, sinon false. 
     * @return booléen
     */
    public boolean checkPlacementAbsolute()
    {
        return pos.getX() ==  posInit.getX() && pos.getY() == posInit.getY();
    }
    
    /**
     *  Compte le nombre de case voisine correctement placée par rapport à la case.
     * @return nombre de voisins correct.
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
     *  Dessine la case dans le Context fourni.
     * @param context 
     */
    abstract public void draw(GraphicsContext context);

    /**
     *  Gestion de du mouvement des élément Graphique.
     * @param deltaT increment de temps.
     */
    abstract public void animate(double deltaT);
    @Override
    public String toString()
    {
        return String.format("%02d",this.numero);
    }


    
    
    
}
