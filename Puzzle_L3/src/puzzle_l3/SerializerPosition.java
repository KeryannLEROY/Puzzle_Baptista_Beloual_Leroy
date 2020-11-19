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
public class SerializerPosition {
    
 public static void main(String[] args) {
final Position position = new Position("Dupond", "Jean", 175) {
    @Override
    public double getDistance(Position pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PosDouble getDirection(Position pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
};
ObjectOutputStream oos = null;
try {
final FileOutputStream fichier = new FileOutputStream("position.ser");
oos = new ObjectOutputStream(fichier);
oos.writeObject(position);
oos.flush();
} catch (final java.io.IOException e) {
} finally {
try {
if (oos != null) {
oos.flush();
oos.close();
}
} catch (final IOException ex) {
}}}}