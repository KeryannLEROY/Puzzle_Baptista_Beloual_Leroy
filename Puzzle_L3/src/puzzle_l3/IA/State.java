/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3.IA;

import java.util.ArrayList;

/**
 *
 * @author kerya
 */
public abstract class State {

    /**
     *
     */
    protected float cost;

    /**
     *
     */
    protected float heuristic;

    /**
     *
     */
    protected ArrayList<State> children;

    /**
     *
     */
    protected State parent;

    /**
     *
     */
    protected AStar root;
    
    /**
     *  Les class filles doivent calculer l'heuristique dans la redéfinition de ce constructeur.
     * @param root
     */
    public State(AStar root){
        this.root=root;
        parent=null;
        cost=0;
    }
    
    /**
     *  Les class filles doivent calculer l'heuristique et le cout dans la redéfinition de ce constructeur.
     * @param parent
     */
    public State(State parent){
        this.parent=parent;
        this.root=parent.getRoot(); 
    }

    /**
     *
     * @return
     */
    public float getCost() {
        return cost;
    }

    /**
     *
     * @return
     */
    public float getHeuristic() {
        return heuristic;
    }

    /**
     *
     * @return
     */
    public State getParent() {
        return parent;
    }

    /**
     *
     * @return
     */
    public AStar getRoot() {
        return root;
    }

    /**
     *
     * @return
     */
    public ArrayList<State> getChildren() {
        return new ArrayList<State>( children);
    }

    /**
     *
     * @return
     */
    public ArrayList<Integer> getPath()
    {
        ArrayList<Integer> path= new ArrayList<>();
        path.addAll(parent.getPath());
        path.add(parent.getChildren().indexOf(this));
        return path;
    }

    /**
     *
     */
    public abstract void setChildren();

    /**
     *
     * @return
     */
    public abstract float computeHeuristic();

    /**
     *
     * @return
     */
    public abstract float computeCost();

    /**
     *
     * @return
     */
    public abstract boolean isFinalState();

    @Override
    public abstract boolean equals(Object obj) ;
        

    
    
    
}
