/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

import java.time.Instant;
import java.util.Random;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Mehdi
 */
public class Board {
    int width;
    int height;
    Tile tabTiles [][];
    Tile vecTiles [];
    
    public Board(int w, int h){
        width=w;
        height=h;
        for(int j;j<height;j++){
            for(int k;k<width;k++){
                if (k==w-1 && j==h-1) {
                    tabTiles[k][j] = new CaseVide(k, j, 0, this);
                    vecTiles[0] = tabTiles[k][j];
                    
                } else {
                    tabTiles[k][j] = new CasePleine(k, j, (k+(j*w))+1, this);
                    vecTiles[(k+(j*w))+1] = tabTiles[k][j];
                }
                
            }
        }
        
        
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public boolean isCompleted(){
        boolean completed=true;
        for (int i; i<(width*height) && completed;i++){
                completed &= vecTiles[i].checkPlacementAbsolute();
        }
        return completed;
       
    }
    
    
    
    
    /*Méthode our permettre l'échange avec une case qui a la possiblité de bouger
    et la case vide.
    */ 
    public void swapTiles(Tile t1,Tile t2){
        Tile temp = t1;
        t1 = t2;
        t2= temp; 
    }
    
    
    public void shuffle(int n){
        Random rand = new Random(Instant.now().getEpochSecond());
        for (int i=0;i<n;i++) {
            try {
            ((CaseVide)vecTiles[0]).move(rand.nextInt()%4);
            } catch(ClassCastException e){
                System.out.println(e.getMessage());
            }
        }
        
    }
    
    public void draw(GraphicsContext context){
        
    }

    
}