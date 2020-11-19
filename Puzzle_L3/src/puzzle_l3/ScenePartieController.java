/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author kerya
 */
public class ScenePartieController implements Initializable {
    
    //variable de substitution ( à remplacer par des variables globale)
    int nbCol=4;
    int nbLine=4;
    int tileSize=100;
    String gameType="solo";
    //fin variable de substitution
    
    
    Board board;
    View view;
    
    @FXML
    Canvas canvasPuzzle;
    
    @FXML
    Text scoreValueText;
    
    @FXML
    Text timeValueText;
    

    
    @FXML
    void onKeyTyped(KeyEvent event) {
        System.out.println("hello!");
        
        String s =event.getCharacter();
        System.out.println(s);
        if(!board.isCompleted())
        {
            switch(s)
            {
                case "z":((CaseVide)board.getTile(0)).move(DIRECTION.DOWN);
                        break;
                case "q":((CaseVide)board.getTile(0)).move(DIRECTION.RIGHT);
                        break;
                case "s":((CaseVide)board.getTile(0)).move(DIRECTION.UP);
                        break;
                case "d":((CaseVide)board.getTile(0)).move(DIRECTION.LEFT);
                        break;
            }
        }
         
        
    }
    
    @FXML
    void onCanvasClicked(MouseEvent event)
    {
        //nbCol nbLine
        PosInt posClick= new PosInt((int)(event.getX()*nbCol/canvasPuzzle.getWidth()),(int)(event.getY()*nbLine/canvasPuzzle.getHeight()));
        try{

            ((CasePleine)board.getTile(posClick)).move();

        }catch(ClassCastException e){
            
            
        }
        
        
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO initilization de la partie à partir des variables globales
        canvasPuzzle.setHeight(nbLine*tileSize);
        canvasPuzzle.setWidth(nbCol*tileSize);
        
        
        view=new View(this);
        
        
        
        switch(gameType)
        {
            case "solo":initSolo();
            break;
        }
        
        
        view.start();
        
    }   
    
    private void initSolo()
    {
        board=new Board(nbCol,nbLine,tileSize);
        board.shuffle(1000);
    }
    
    
    public void clearCanvas()
    {
        canvasPuzzle.getGraphicsContext2D().setFill(new Color(1,1,1,1));
        canvasPuzzle.getGraphicsContext2D().fillRect(0,0,canvasPuzzle.getWidth(), canvasPuzzle.getHeight());
    }
    
    public void displayScore(int score)
    {
        scoreValueText.setText(""+score);
    }
    
    public void displayTime(int time)
    {
        timeValueText.setText((time/60)+":"+(time%60));
    }
    
    
    private class OnKeyTypedEvent implements EventHandler<KeyEvent>{

        @Override
        public void handle(KeyEvent event) {
            System.out.println("hello!");
            String s =event.getCharacter();
            System.out.println(s);
            if(!board.isCompleted())
            {
                switch(s)
                {
                    case "z":((CaseVide)board.getTile(0)).move(DIRECTION.DOWN);
                            break;
                    case "q":((CaseVide)board.getTile(0)).move(DIRECTION.RIGHT);
                            break;
                    case "s":((CaseVide)board.getTile(0)).move(DIRECTION.UP);
                            break;
                    case "d":((CaseVide)board.getTile(0)).move(DIRECTION.LEFT);
                            break;
                }
            }
            
        }
    
    }
}


