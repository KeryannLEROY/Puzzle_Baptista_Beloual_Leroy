/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3.IA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 *
 * @author kerya
 */
public abstract class AStar {

    /**
     *
     */
    protected State firstChild;

    /**
     *
     */
    protected ArrayList<State> toBeCompute;

    /**
     *
     */
    protected HashSet<State> computed;
    private boolean isFinish;
    private State finalState;
    
    /**
     *
     */
    public AStar(){
        isFinish=false;
        computed=new HashSet<State>();
        
    }

    /**
     *
     * @param firstChild
     */
    protected void setFirstChild(State firstChild) {
        this.firstChild = firstChild;
        toBeCompute=new ArrayList<>(0);
        toBeCompute.add(firstChild);
    }
    
    /**
     *
     * @return
     */
    public State getFirstChild() {
        return firstChild;
    }

    /**
     *
     * @return
     */
    public boolean isFinish() {
        return isFinish;
    }

    /**
     *
     * @return
     */
    public State getFinalState() {
        return finalState;
    }
    
    /**
     *
     * @return
     */
    public boolean computingStep(){

        Collections.sort(toBeCompute,new StateComparator() );
        State currentState;
        do{
            currentState=toBeCompute.remove(0);
            System.out.println(computed.contains(currentState));
        }while(computed.contains(currentState));


        if(currentState.isFinalState()){
            isFinish=true;
            return true;
        }
        currentState.setChildren();
        ArrayList<State>currentChildren=currentState.getChildren();

        toBeCompute.addAll(currentChildren);
        computed.add(currentState);

        return false;
    }
    
    private class StateComparator implements Comparator<State>{

        @Override
        public int compare(State o1, State o2) {
            if(o1.getHeuristic()<o2.getHeuristic()){
                return 1;
            }
            
            if(o1.getHeuristic()==o2.getHeuristic()){
                return 0;
            }
            return -1;
            
        }

        @Override
        public Comparator<State> reversed() {
            return Comparator.super.reversed(); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Comparator<State> thenComparing(Comparator<? super State> other) {
            return Comparator.super.thenComparing(other); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public <U> Comparator<State> thenComparing(Function<? super State, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
            return Comparator.super.thenComparing(keyExtractor, keyComparator); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public <U extends Comparable<? super U>> Comparator<State> thenComparing(Function<? super State, ? extends U> keyExtractor) {
            return Comparator.super.thenComparing(keyExtractor); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Comparator<State> thenComparingInt(ToIntFunction<? super State> keyExtractor) {
            return Comparator.super.thenComparingInt(keyExtractor); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Comparator<State> thenComparingLong(ToLongFunction<? super State> keyExtractor) {
            return Comparator.super.thenComparingLong(keyExtractor); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Comparator<State> thenComparingDouble(ToDoubleFunction<? super State> keyExtractor) {
            return Comparator.super.thenComparingDouble(keyExtractor); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
}
