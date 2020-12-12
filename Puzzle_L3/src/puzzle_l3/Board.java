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
        tabTiles=new Tile[w][h];
        vecTiles=new Tile[w*h];
        for(int j=0;j<height;j++){
            for(int k=0;k<width;k++){
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
        for (int i=0; i<(width*height) && completed;i++){
            completed &= vecTiles[i].checkPlacementAbsolute();
        }
        return completed;
       
    }
    
    
    
    
    /*Méthode our permettre l'échange avec une case qui a la possiblité de bouger
    et la case vide.
    */ 
    public void swapTiles(PosInt p1,PosInt p2){
        /*
        Tile temp = t1;
        t1 = t2;
        t2= temp; 
*/
        Tile temp = this.getTile(p1);
        this.tabTiles[p1.getX()][p1.getY()]=this.tabTiles[p2.getX()][p2.getY()];
        this.tabTiles[p2.getX()][p2.getY()]=temp;
        this.getTile(p1).setPos(p1);
        this.getTile(p2).setPos(p2);
    }
    
    
    public void shuffle(int n){
        Random rand = new Random(Instant.now().getEpochSecond());
        for (int i=0;i<n;i++) {
            try {
                switch(rand.nextInt()%4){
                    case 0:((CaseVide)vecTiles[0]).move(DIRECTION.UP);
                        break;
                    case 1:((CaseVide)vecTiles[0]).move(DIRECTION.RIGHT);
                        break;
                    case 2:((CaseVide)vecTiles[0]).move(DIRECTION.DOWN);
                        break;
                    case 3:((CaseVide)vecTiles[0]).move(DIRECTION.LEFT);
                        break;
                }
          
            } catch(ClassCastException e){
                System.out.println(e.getMessage());
            }
        }
        
    }
    
    public Tile getTile(int x,int y)
    {
        return this.tabTiles[x][y];
    }
    
    public Tile getTile(PosInt p1)
    {
        return getTile(p1.getX(),p1.getY());
    }
    
    public Tile getTile(int num)throws IndexOutOfBoundsException
    {
        return vecTiles[num];
    }
    
    public void draw(GraphicsContext context){
        
    }
    @Override
    public String toString(){
        String buffer= new String();
        for( int y=0;y<getWidth();++y)
        {
            for( int x=0;x<getHeight();++x)
            {
                buffer+=' ';
                buffer+=this.getTile(x, y);
                buffer+=' ';
            }
            buffer+='\n';
        }
        return buffer;
    }

    
}