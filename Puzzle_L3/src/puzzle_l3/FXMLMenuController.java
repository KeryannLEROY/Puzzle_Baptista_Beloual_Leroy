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
import puzzle_l3.Puzzle_L3.Globals;

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
        
        String y = ydim.getText();
        int y_num = Integer.parseInt((String) y);
        System.out.println("Y= "+y_num);
        
        
        
        
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
    
    /**
     *
     */
    public class UsesGlobals{
        private final Globals globals;
        public UsesGlobals(Globals globals, int x_num, int y_num) {
            this.globals = globals;
            globals.w = x_num;
            globals.h = y_num;
        }
    }
    

    
    
    
     
    
}