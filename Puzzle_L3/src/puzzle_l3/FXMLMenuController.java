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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *Fonctions liées aux boutons du menu principal
 * @author Mehdi
 */
public class FXMLMenuController{
    
    
    
    
    
    
    @FXML
    private Button mButton;
    
    @FXML
    private TextField xydim;
    
    @FXML
    private TextField erreur;
    
    
    /**
     *Envoi de la nouvelle dimension vers la variable globale pour la modification des dimensions du puzzle
     * @param event - Lorsque l'utilisateur clique sur le bouton "Options"
     * Enclenchement d'une erreur avec un trycatch si la valeur entrée est inférieure à 2 ou si elle n'est pas un nombre.
     */
    @FXML
    private void submitPuzzleSize(ActionEvent event) {
        try {
            
            String x = xydim.getText();
            int x_num = Integer.parseInt((String) x);
            if (x_num<2) {
                int error=0/0;
            }
            Puzzle_L3.weight_board=x_num;
            
        
            String y = xydim.getText();
            int y_num = Integer.parseInt((String) y);
            Puzzle_L3.height_board=y_num;
            
            Alert errorAlert = new Alert(AlertType.INFORMATION);
            errorAlert.setHeaderText("Modification de la dimension");
            errorAlert.setContentText("La modification de la dimension du puzzle s'est correctement effectuée.");
            errorAlert.showAndWait();
            
        }
        catch(Exception e) {
            System.out.println("Vous devez entrer un nombre (supérieur à 2)");
            
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Erreur d'entrée");
            errorAlert.setContentText("Veuillez entrer un nombre pour les 2 dimensions (supérieur à 2)");
            errorAlert.showAndWait();
        }   
    }
        
    /**
     *Ouverture du fichier FXMLDocument pour le lancement du jeu
     * @param event - Lorsque l'utilisateur clique sur le bouton "Jouer"
     * @throws IOException
     */
    @FXML
    public void jouer(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage2 = new Stage();
        stage2.setScene(new Scene(root1));
        stage2.show();
    }
    
    
    
    
    

    
    
    
     
    
}
