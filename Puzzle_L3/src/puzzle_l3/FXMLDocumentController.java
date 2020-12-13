/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author 
 */
public class FXMLDocumentController implements Initializable {
    
    private Board b;
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        b.shuffle(100);
        System.out.println(b);
    }
    
    @FXML
    private void keyTypedHandler(KeyEvent event) {
        String s =event.getCharacter();
        
        if(!b.isCompleted())
        {
            switch(s)
            {
                case "z":((CaseVide)b.getTile(0)).move(DIRECTION.DOWN);
                        break;
                case "q":((CaseVide)b.getTile(0)).move(DIRECTION.RIGHT);
                        break;
                case "s":((CaseVide)b.getTile(0)).move(DIRECTION.UP);
                        break;
                case "d":((CaseVide)b.getTile(0)).move(DIRECTION.LEFT);
                        break;
            }
        }
        
        System.out.println(b);
        
        if(b.isCompleted())
        {
            System.out.println( "                                           ▄█\n" +
"  ▄▄█▀▀▀█▄█                              ▄█▀\n" +
"▄██▀     ▀█                              ▀\n" +
"██▀       ▀ ▄█▀██▄  ▄█▀█████████████▄   ▄▄█▀██\n" +
"██         ██   ██ ▄██  ██   ██    ██  ▄█▀   ██\n" +
"██▄    ▀████▄█████ ▀█████▀   ██    ██  ██▀▀▀▀▀▀\n" +
"▀██▄     ████   ██ ██        ██    ██  ██▄    ▄\n" +
"  ▀▀███████▀████▀██▄███████▄████  ████▄ ▀█████▀\n" +
"                   █▀     ██\n" +
"                   ██████▀");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        b= new Board(Puzzle_L3.width_board,Puzzle_L3.height_board);
        b.shuffle(100);
        System.out.println(b);
    }    
    
}
