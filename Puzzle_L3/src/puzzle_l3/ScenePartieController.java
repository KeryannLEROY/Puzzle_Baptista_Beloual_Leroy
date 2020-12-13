/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import puzzle_l3.IA.AStarBoard;
import puzzle_l3.IA.StateBoard;

/**
 * FXML Controller class
 *
 * @author kerya
 */
public class ScenePartieController implements CloseableController {
    
    //variable de substitution ( à remplacer par des variables globale)
    int nbCol=4;
    int nbLine=4;
    int tileSize=100;
    String gameType="soloIA";
    DIRECTION[] cheminIA;
    //fin variable de substitution
    
    
    Partie partie;
    
    ViewPartie view;
    
    @FXML
    Canvas canvasPuzzle;
    
    @FXML
    Text scoreValueText;
    
    @FXML
    Text timeValueText;
    

    
    @FXML
    void onKeyTyped(KeyEvent event) {

        
        String s =event.getCharacter();

        if(!partie.getBoard().isCompleted())
        {
            switch(s)
            {
                case "z":((CaseVide)partie.getBoard().getTile(0)).move(DIRECTION.DOWN);
                        break;
                case "q":((CaseVide)partie.getBoard().getTile(0)).move(DIRECTION.RIGHT);
                        break;
                case "s":((CaseVide)partie.getBoard().getTile(0)).move(DIRECTION.UP);
                        break;
                case "d":((CaseVide)partie.getBoard().getTile(0)).move(DIRECTION.LEFT);
                        break;
            }
        }
         
        
    }
    
    @FXML
    void onCanvasClicked(MouseEvent event)
    {
        if(!partie.getBoard().isCompleted())
        {
            PosInt posClick= new PosInt((int)(event.getX()*nbCol/canvasPuzzle.getWidth()),(int)(event.getY()*nbLine/canvasPuzzle.getHeight()));
            try{

                ((CasePleine)partie.getBoard().getTile(posClick)).move();

            }catch(ClassCastException e){


            }
        }
        
    }

    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO initilization de la partie à partir des variables globales
        canvasPuzzle.setHeight(nbLine*tileSize);
        canvasPuzzle.setWidth(nbCol*tileSize);
        partie=new Partie();
        
        view=new ViewPartie(this);
        switch(gameType)
        {
            case "solo":initSolo();
            break;
            case "soloIA":initSoloIA();
            break;
        }
        Image image = null;
        try{
            image=new Image(new FileInputStream("autumn-landscape.jpg"));
        } catch (FileNotFoundException ex) {
            
        }
        partie.getBoard().setImage(image);
        
        
        
        setupTimerBehavior();
        view.start();
        
    }   
    
    private void setupTimerBehavior()
    {
        partie.setTimer(new Timer(10));
        
        partie.getTimer().addToBehavior(partie.getBoard(), "animate");
        System.out.println(partie.getTimer().isRunning());
        partie.getTimer().unPause();
        System.out.println(partie.getTimer().isRunning());
    }
    
    private void initSolo()
    {
        partie.setBoard(new Board(nbCol,nbLine,tileSize));
        partie.getBoard().shuffle(1000);
    }
    private void initSoloIA()
    {
        partie.setBoard(new Board(3,3,tileSize));
        partie.getBoard().shuffle(1000);
        
        AStarBoard aStar=new AStarBoard(partie.getBoard()); 
        while(!aStar.isFinish())
        {
            aStar.computingStep();
        }
        
    }
    
    /**
     *
     */
    public void clearCanvas()
    {
        canvasPuzzle.getGraphicsContext2D().setFill(new Color(1,1,1,1));
        canvasPuzzle.getGraphicsContext2D().fillRect(0,0,canvasPuzzle.getWidth(), canvasPuzzle.getHeight());
    }
    
    /**
     *
     * @param score
     */
    public void displayScore(int score)
    {
        scoreValueText.setText(""+score);
    }
    
    /**
     *
     * @param time
     */
    public void displayTime(int time)
    {
        timeValueText.setText((time/60)+":"+(String.format("%02d",time%60)));
    }
    
    /**
     *
     */
    public void close() {
        System.out.println("closing partie controler");
        partie.getTimer().pause();
        System.out.println("partie controler closed");
    }
    
}


