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
public abstract class Position  implements java.io.Serializable {
    //

    /**
     *
     * @param pos
     * @return
     */
    abstract public double getDistance(Position pos);

    /**
     *
     * @param pos
     * @return
     */
    abstract public PosDouble getDirection(Position pos);
    
}
