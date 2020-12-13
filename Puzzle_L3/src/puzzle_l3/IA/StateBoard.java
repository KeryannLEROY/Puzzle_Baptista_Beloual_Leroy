/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3.IA;

import java.util.ArrayList;
import puzzle_l3.Board;
import puzzle_l3.CaseVide;
import puzzle_l3.DIRECTION;

/**
 *
 * @author kerya
 */
public class StateBoard extends State{

    /**
     *
     */
    protected Board board;

    /**
     *
     * @param root
     * @param board
     */
    public StateBoard(AStar root,Board board) {
        
        super(root);
        this.board=board;
        this.computeHeuristic();
    }

    /**
     *
     * @param parent
     * @param board
     */
    public StateBoard(State parent,Board board) {
        super(parent);
        this.board=board;
        this.computeHeuristic();
        this.computeCost();
    }
    
    /**
     *
     */
    @Override
    public void setChildren() {
        DIRECTION[] dirs={DIRECTION.UP,DIRECTION.RIGHT,DIRECTION.DOWN,DIRECTION.LEFT};
        this.children=new ArrayList<>();
        for(int i = 0;i<4;++i)
        {   
            
            Board b=new Board(board);
            
            if(((CaseVide)board.getTile(0)).move(dirs[i])) children.add(new StateBoard(this,b));

        }
        
    }

    /**
     *
     * @return
     */
    @Override
    public float computeHeuristic() {
        this.heuristic=board.sumAbsolutePlacement();
        return heuristic;
    }

    /**
     *
     * @return
     */
    @Override
    public float computeCost() {
        this.cost=parent.getCost()+1;
        return cost;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isFinalState() {
        return board.isCompleted();
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println(((StateBoard)obj).getBoard());
        System.out.println(board);
        System.out.println(((StateBoard)obj).getBoard().equals(board));
        return ((StateBoard)obj).getBoard().equals(board);
    }
    
}
