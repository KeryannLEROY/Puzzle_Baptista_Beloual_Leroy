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

/**
 * FXML Controller class
 *
 * @author kerya
 */
public class ScenePartieController implements CloseableController {
    //
    //variable de substitution ( à remplacer par des variables globale)


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
                partie.setScore(partie.getScore()+1);
                        break;
                case "q":((CaseVide)partie.getBoard().getTile(0)).move(DIRECTION.RIGHT);
                partie.setScore(partie.getScore()+1);
                        break;
                case "s":((CaseVide)partie.getBoard().getTile(0)).move(DIRECTION.UP);
                partie.setScore(partie.getScore()+1);
                        break;
                case "d":((CaseVide)partie.getBoard().getTile(0)).move(DIRECTION.LEFT);
                partie.setScore(partie.getScore()+1);
                        break;
            }
        }
        
        
    }
    
    @FXML
    void onCanvasClicked(MouseEvent event)
    {
        if(!partie.getBoard().isCompleted())
        {
            PosInt posClick= new PosInt((int)(event.getX()*Puzzle_L3.width_board/canvasPuzzle.getWidth()),(int)(event.getY()*Puzzle_L3.height_board/canvasPuzzle.getHeight()));
            try{

                ((CasePleine)partie.getBoard().getTile(posClick)).move();
                partie.setScore(partie.getScore()+1);

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
        canvasPuzzle.setHeight(Puzzle_L3.height_board*Puzzle_L3.tileSize);
        canvasPuzzle.setWidth(Puzzle_L3.width_board*Puzzle_L3.tileSize);
        partie=new Partie();
        
        view=new ViewPartie(this);
        switch(Puzzle_L3.gameType)
        {
            case "solo":initSolo();
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
        partie.setBoard(new Board(Puzzle_L3.width_board,Puzzle_L3.height_board,Puzzle_L3.tileSize));
        partie.getBoard().shuffle(1000);
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


