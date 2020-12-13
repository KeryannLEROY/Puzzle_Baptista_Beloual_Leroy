/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author 
 */
public class Puzzle_L3 extends Application {
    //
    
    public static int width_board = 4;
    public static int height_board = 4;
    public static int tileSize=100;
    public static String gameType="solo";
    public static Stage stage;
    public static FXMLLoader fxmlLoader;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Puzzle_L3.stage=stage;
        fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("FXMLMenu.fxml").openStream());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.println("closing...");
                try{
                    ((CloseableController)fxmlLoader.getController()).close();
                }catch(NullPointerException e)
                {
                    
                }
                
            }

            
        });
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
   
    
}
