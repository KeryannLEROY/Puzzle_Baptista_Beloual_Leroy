/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3.IA;

import puzzle_l3.Board;

/**
 *
 * @author kerya
 */
public class AStarBoard extends AStar {
    
    /**
     *
     * @param board
     */
    public AStarBoard(Board board) {
        super();
        setFirstChild(new StateBoard(this, board));
    }
    
}
