/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 *
 * @author keryann
 */
public class CasePleine extends Tile{
    //
    
    private PosDouble posGraphic;

    private Image image;
    private Color highlight;
    private boolean isHighlighted;

    /**
     * constructeur de la classe CasePleine.
     * @param x coordonnée x de la case(entier).
     * @param y coordonnée Y de la case(entier).
     * @param num numero identifiant.
     * @param board Board dans lequel la case est contenu.
     */
    public CasePleine(int x,int y,int num,Board board)
    {
        super(x,y,num,board);

        posGraphic = new PosDouble(x, y);
    }

    /**
     * Modificateur de l'image de la case
     * @param image
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     *  
     * @param highlight
     */
    public void setHighlight(Color highlight) {
        this.highlight = highlight;
    }

    /**
     * 
     * @return
     */
    public PosDouble getPosGraphic(){
        return (PosDouble) posGraphic.clone();
    }

    /**
     * Accesseur de la position de l'image de la case
     * @return
     */
    public Image getImage() {
        return  image;
    }

    /**
     *
     * @return
     */
    public Color getHighlight() {
        return highlight;
    }

    /**
     *
     * @return
     */
    public boolean isIsHighlighted() {
        return isHighlighted;
    }

    /**
     * Gere les déplacement de la case. Si le depacement ne peut pas être executé renvoie faux.
     * @return booléen
     */
    public boolean move()
    {
        ArrayList<Tile> voisins=new ArrayList<Tile>(4);
        try{
            voisins.add(getBoard().getTile(pos.getX()-1,pos.getY()));
        }catch(IndexOutOfBoundsException e)
        {
            //System.out.println(e.getCause());
        }
        try{
            voisins.add(getBoard().getTile(pos.getX(),pos.getY()-1));
        }catch(IndexOutOfBoundsException e)
        {
            //System.out.println(e.getCause());
        }
        try{
            voisins.add(getBoard().getTile(pos.getX()+1,pos.getY()));
        }catch(IndexOutOfBoundsException e)
        {
            //System.out.println(e.getCause());
        }
        try{
            voisins.add(getBoard().getTile(pos.getX(),pos.getY()+1));
        }catch(IndexOutOfBoundsException e)
        {
            //System.out.println(e.getCause());
        }
        for(int i=0;i<voisins.size();++i)
        {
            
            if(voisins.get(i) instanceof CaseVide)
            {

                
                getBoard().swapTiles(((Tile)voisins.get(i)).getPos(),this.getPos());
                
                
                return true;
            }
        }
        return false;
    }
    
    
    /**
     *
     * @param toggled
     */
    public void toggleHighlight(boolean toggled)
    {
        isHighlighted=toggled;
    }
    
    @Override
    public void draw(GraphicsContext context)
    {
        
        if(this.getBoard().getImage()==null)
        {
            context.setFill(new Color(numero /(float)(board.getHeight()*board.getWidth()),this.checkPlacementAbsolute()?0.5:0,this.checkPlacementAbsolute()?0:0.5,1));
            context.fillRoundRect(posGraphic.getX()*this.board.getTileSize(), posGraphic.getY()*this.board.getTileSize(), this.board.getTileSize(), this.board.getTileSize(),this.board.getTileSize()/10, this.board.getTileSize()/10);
        }else{
            //System.out.println(this.getBoard().getImage().getWidth()/this.getBoard().getWidth()*pos.getX()+"    "+this.getBoard().getImage().getWidth()+" "+this.getBoard().getWidth()+" "+pos.getX());
            context.drawImage(this.getBoard().getImage(), 
                    this.getBoard().getImage().getWidth()/this.getBoard().getWidth()*posInit.getX(),
                    this.getBoard().getImage().getHeight()/this.getBoard().getHeight()*posInit.getY(),
                    this.getBoard().getImage().getWidth()/this.getBoard().getWidth(),
                    this.getBoard().getImage().getHeight()/this.getBoard().getHeight(),
                    posGraphic.getX()*this.board.getTileSize(), posGraphic.getY()*this.board.getTileSize(), this.board.getTileSize(), this.board.getTileSize());
            
            context.setFill(new Color(0,1,0,this.checkPlacementAbsolute()?0.5:0));
            context.fillRoundRect(posGraphic.getX()*this.board.getTileSize(), posGraphic.getY()*this.board.getTileSize(), this.board.getTileSize(), this.board.getTileSize(),this.board.getTileSize()/10, this.board.getTileSize()/10);
            
        }
        
    }

    @Override
    public void animate(double deltaT) {
        if(posGraphic.getDistance(pos)<0.01)
        {
            posGraphic.setX(pos.getX());
            posGraphic.setY(pos.getY());
        }
        else
        {
            PosDouble dir = posGraphic.getDirection(pos);
            double dist = posGraphic.getDistance(pos);
            posGraphic.setX(posGraphic.getX()+dir.getX()*deltaT*dist*10);
            posGraphic.setY(posGraphic.getY()+dir.getY()*deltaT*dist*10);
        }
    }
    
}
