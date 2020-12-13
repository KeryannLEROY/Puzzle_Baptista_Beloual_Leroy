/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

import java.time.Instant;
import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author Mehdi
 */
public class Board  implements java.io.Serializable{
    //
    int width;
    int height;
    int tileSize=10;
    Tile tabTiles [][];
    Tile vecTiles [];
    Image image;
    
    /**
     *
     * @param w
     * @param h
     */
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

    Board(String width, String height, String tabTiles, String vecTiles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param w
     * @param h
     * @param tileSize
     */
    public Board(int w, int h,int tileSize){
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
        this.tileSize=tileSize;
        
    }
    
    /**
     *
     * @param w
     * @param h
     * @param tileSize
     * @param image
     */
    public Board(int w, int h,int tileSize,Image image){
        this(w,h,tileSize);
        this.image=image;
        
    }
    
    /**
     *
     * @return
     */
    public int getWidth(){
        return width;
    }
    
    /**
     *
     * @return
     */
    public int getHeight(){
        return height;
    }
    
    /**
     *
     * @return
     */
    public boolean isCompleted(){
        boolean completed=true;
        for (int i=0; i<(width*height) && completed;i++){
            completed &= vecTiles[i].checkPlacementAbsolute();
        }
        return completed;
       
    }

    /**
     *
     * @return
     */
    public Image getImage() {
        return image;
    }

    /**
     *
     * @param image
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     *
     * @return
     */
    public int getTileSize() {
        return tileSize;
    }

    /**
     *
     * @param tileSize
     */
    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }
    
    
    
    
    /*Méthode our permettre l'échange avec une case qui a la possiblité de bouger
    et la case vide.
    */ 

    /**
     *
     * @param p1
     * @param p2
     */
 
    public void swapTiles(PosInt p1,PosInt p2){
        Tile temp = this.getTile(p1);
        this.tabTiles[p1.getX()][p1.getY()]=this.getTile(p2);
        this.tabTiles[p2.getX()][p2.getY()]=temp;
        
        this.getTile(p1).setPos(p1);

        this.getTile(p2).setPos(p2);

    }
    
    /**
     *
     * @param n
     */
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
    
    /**
     *
     * @param x
     * @param y
     * @return
     * @throws IndexOutOfBoundsException
     */
    public Tile getTile(int x,int y)throws IndexOutOfBoundsException
    {
        return this.tabTiles[x][y];
    }
    
    /**
     *
     * @param p1
     * @return
     * @throws IndexOutOfBoundsException
     */
    public Tile getTile(PosInt p1)throws IndexOutOfBoundsException
    {
        return getTile(p1.getX(),p1.getY());
    }
    
    /**
     *
     * @param num
     * @return
     * @throws IndexOutOfBoundsException
     */
    public Tile getTile(int num)throws IndexOutOfBoundsException
    {
        return vecTiles[num];
    }
    
    /**
     *
     * @param context
     */
    public void draw(GraphicsContext context){
        if (!isCompleted())
        {
            for(int i=0;i<width*height;++i)
            {
                vecTiles[i].draw(context);
            }
        }else{
            context.drawImage(image,0, 0, width*tileSize, height*tileSize);
        }
        
    }

    /**
     *
     * @param deltaT
     */
    public void animate(double deltaT){
        
        for(int i=0;i<width*height;++i)
        {
            vecTiles[i].animate(deltaT);
        }
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

    String getWight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
