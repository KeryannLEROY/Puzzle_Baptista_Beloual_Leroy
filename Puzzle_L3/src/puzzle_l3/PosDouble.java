/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

/**
 *
 * @author kelly
 */
public class PosDouble extends Position{
    //
    private double x;
    private double y;

    /**
     * Constructeur de la classe PosDouble.
     * @param x coordonnée x de la case (entier)
     * @param y coordonnée x de la case (entier)
     */
    public PosDouble(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Permet d'accéder à la coordonnée x de la case 
     * @return
     */
    public double getX(){
        return this.x;
    }

    /**
     * Permet d'accéder à la coordonnée y de la case 
     * @return
     */
    public double getY(){
        return this.y;
    }

    /**
     * Permet de modifier la coordonnée x
     * @param x
     */
    public void setX(double x){
        this.x = x;
    }

    /**
     * Permet de modifier la coordonnée y
     * @param y
     */
    public void setY(double y){
        this.y = y;
    }


    @Override
    public double getDistance(Position pos) {
        double distance = 0;
        if (pos.getClass()!= this.getClass() )
        {
            PosInt p = (PosInt) pos;
            distance = Math.sqrt(Math.pow(p.getX()- this.x, 2)+ Math.pow(p.getY()- this.y, 2) );
        }
        else {
            PosDouble p = (PosDouble) pos;
            distance = Math.sqrt(Math.pow(p.getX()- this.x, 2)+ Math.pow(p.getY()- this.y, 2) );
            
        }
        return distance;
    }


    @Override
    public PosDouble getDirection(Position pos) {
         PosDouble direction;
         double distance = this.getDistance(pos);
        if (pos.getClass()!= this.getClass() )
        {
            PosInt p = (PosInt) pos;
            direction = new PosDouble ((p.getX()- this.x)/distance,(p.getY()- this.y)/distance);
                   
        }
        else {
            PosDouble p = (PosDouble) pos;
            direction = new PosDouble ((p.getX()- this.x)/distance,(p.getY()- this.y)/distance);
            
        }
        return direction;
        
    }
    
    @Override
    public String toString()
    {
        return x+";"+y;
    }

    @Override
    protected Object clone() {
        return new PosDouble(x, y);
    }
    
    
}
