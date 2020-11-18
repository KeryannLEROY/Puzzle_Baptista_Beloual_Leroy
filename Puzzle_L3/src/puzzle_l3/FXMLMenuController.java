/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Mehdi
 */
public class FXMLMenuController{
    
    private Board b;
    
    
    
    
    @FXML
    private Button mButton;
    
    @FXML
    private TextField xdim;
    
    @FXML
    private TextField ydim;
    
    @FXML
    private void submitPuzzleSize(ActionEvent event){
        System.out.println("aa");
        
        System.out.println(xdim.getText());
        String lol = xdim.getText();
        System.out.println(lol);
        int loln = Integer.parseInt((String) lol);
        System.out.println("hm "+loln);
        
        System.out.println(ydim.getText());
        String lol2 = ydim.getText();
        System.out.println(lol2);
        int loln2 = Integer.parseInt((String) lol2);
        System.out.println("hm2 "+loln2);
        
        
        
       }
    
    
    
    @FXML
    public void jouer(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("ABC");
        stage.setScene(new Scene(root1));  
        stage.show();
    }
    
    
    

    
    
    
     
    
}
