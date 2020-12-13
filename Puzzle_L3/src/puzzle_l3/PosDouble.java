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
    private double x;
    private double y;

    /**
     *
     * @param x
     * @param y
     */
    public PosDouble(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return
     */
    public double getX(){
        return this.x;
    }

    /**
     *
     * @return
     */
    public double getY(){
        return this.y;
    }

    /**
     *
     * @param x
     */
    public void setX(double x){
        this.x = x;
    }

    /**
     *
     * @param y
     */
    public void setY(double y){
        this.y = y;
    }

    /**
     *
     * @param pos
     * @return
     */
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

    /**
     *
     * @param pos
     * @return
     */
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
