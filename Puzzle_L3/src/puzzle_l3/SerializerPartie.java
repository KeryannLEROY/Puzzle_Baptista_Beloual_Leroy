/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/**
 *
 * @author kelly
 */
public class SerializerPartie {
   
    /**
     *permet de sauvegarder les données de la partie
     * @param partie
     */
    public static void serialize(Partie partie) {
       //
        ObjectOutputStream oos = null;
        try {
            final FileOutputStream fichier = new FileOutputStream("partie.ser");
           
            oos = new ObjectOutputStream(fichier);
           
            oos.writeObject(partie);
            
            oos.flush();
            
            } 
        catch (final java.io.IOException e) {}
        finally {
            try {
                if (oos != null) {
                oos.flush();
                oos.close();
                }
            } 
        catch (final IOException ex) {}
        }
    }
}
    

