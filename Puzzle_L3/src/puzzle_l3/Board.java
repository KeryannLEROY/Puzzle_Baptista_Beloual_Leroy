/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

/**
 *
 * @author Mehdi
 */
public class Board {
    int width;
    int height;
    Tile tabTiles [][];
    Tile vecTiles [];
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public boolean isCompleted(){
        boolean completed=true;
        for (int i; i<(width*height);i++){
            //while (boolean completed){
           //tile tab.checkpla
        }
       
        
    }
    
    
    
    
    /*Méthode our permettre l'échange avec une case qui a la possiblité de bouger
    et la case vide.
    */ 
    public void swapTiles(Tile t1,Tile t2){
        Tile temp = t1;
        t1 = t2;
        t2= temp; 
    }
    
    public void shuffle(Board b){
        
        
    }
    
    public void draw(){
        
    }
    
    /*constructeur */
    
    
}
