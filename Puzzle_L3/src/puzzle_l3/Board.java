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
 *Classe "Board" pour la grille du Taquin
 * @author Mehdi
 */
public class Board  implements java.io.Serializable{
    //Initialisations de valeurs utilisées dans la classe Board
    private int width;
    private int height;
    private int tileSize=10;
    private Tile tabTiles [][];
    private Tile vecTiles [];
    private Image image;
    
    /**
     *Initialisation de la grille en tant que tableau à 2 dimensions
     * @param w - Désigne le nombre de colonne
     * @param h - Désigne le nombre de ligne
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
     *Accesseur à l'attribut width
     * @return width (int)
     */
    public int getWidth(){
        return width;
    }
    
    /**
     *Accesseur à l'attribut height
     * @return height (entier)
     */
    public int getHeight(){
        return height;
    }
    
    /**
     *Fonction isCompleted pour la condition de victoire du puzzle
     * @return completed (boolean)
     */
    public boolean isCompleted(){
        boolean completed=true;
        for (int i=0; i<(width*height) && completed;i++){
            completed &= vecTiles[i].checkPlacementAbsolute();
        }
        return completed;
       
    }

    /**
     *Accesseur à l'attribut image
     * @return image (Image)
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
    
    
    
    
    

    /**
     *Méthode our permettre l'échange avec une case qui a la possiblité de bouger
    et la case vide.
     * @param p1 Position de la case 1 (PosInt)
     * @param p2 Position de la case 2 (PosInt)
     */
 
    public void swapTiles(PosInt p1,PosInt p2){
        Tile temp = this.getTile(p1);
        this.tabTiles[p1.getX()][p1.getY()]=this.getTile(p2);
        this.tabTiles[p2.getX()][p2.getY()]=temp;
        
        this.getTile(p1).setPos(p1);

        this.getTile(p2).setPos(p2);

    }
    
    /**
     *Méthode permettant le mélange des cases du puzzle
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
     *Accesseur à un attribut Tile du tableau tabTiles en fonction de ses coordonnées (Tile)
     * @param x coordonnée x en colonne (int)
     * @param y coordonnée y en ligne (int)
     * @return this.tabTiles[x][y] (Tile)
     * @throws IndexOutOfBoundsException
     */
    public Tile getTile(int x,int y)throws IndexOutOfBoundsException
    {
        return this.tabTiles[x][y];
    }
    
    /**
     *Accesseur à un attribut Tile du tableau tabTiles en fonction de sa position (Tile)
     * @param p1 position de la case Tile recherché (int)
     * @return getTile(p1.getX(),p1.getY()) (Tile)
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
    
    /**
     *
     * @return
     */
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
