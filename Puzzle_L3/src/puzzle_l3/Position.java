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
     * Calcule la distance entre les deux position.
     * @param pos 
     * @return distance
     */
    abstract public double getDistance(Position pos);

    /**
     * Calcule un vecteur de norme égale 1 correspondant à la direction dans laquelle se situe le parametre pos par rapport à this.
     * @param pos
     * @return 
     */
    abstract public PosDouble getDirection(Position pos);
    
}
