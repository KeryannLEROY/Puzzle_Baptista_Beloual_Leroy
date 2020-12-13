/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *
 * @author kelly
 */
public class DeserPartie {
    //

    /**
     *
     * @return
     */
    public static Partie deserialize() {
        Partie partie = new Partie();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            final FileInputStream fichierIn = new FileInputStream("partie.ser");
            
            ois = new ObjectInputStream(fichierIn);
            
           
        
            partie = (Partie) ois.readObject();
            System.out.println("Partie : ");
            System.out.println(partie.getBoard());
        } 
        catch (final java.io.IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
       
        finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } 
        catch (final IOException ex){}
        }
    return partie;
    }   
}
    

