/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    
    
    
    
    
    
    @FXML
    private Button mButton;
    
    @FXML
    private TextField xdim;
    
    @FXML
    private TextField ydim;
    
    @FXML
    private void submitPuzzleSize(ActionEvent event) {
        String x = xdim.getText();
        int x_num = Integer.parseInt((String) x);
        System.out.println("X= "+x_num);
        Puzzle_L3.weight_board=x_num;
        
        String y = ydim.getText();
        int y_num = Integer.parseInt((String) y);
        System.out.println("Y= "+y_num);
        Puzzle_L3.height_board=y_num;
        
        
        
        
    }
        
       
    
    
    
    @FXML
    public void jouer(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage2 = new Stage();
        stage2.setScene(new Scene(root1));
        stage2.show();
        /*Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("ABC");
        stage.setScene(new Scene(root1));  
        stage.show();*/
    }
    
    /**
     *
     */
    
    
    

    
    
    
     
    
}
