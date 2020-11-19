/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javafx.scene.canvas.GraphicsContext;
/**
 *
 * @author kelly
 */
public class SerializerTile {
    
 public static void main(String[] args) {
final Tile tile = new Tile("image", "highlight", "isHighlighted") {
    @Override
    void draw(GraphicsContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
};
ObjectOutputStream oos = null;
try {
final FileOutputStream fichier = new FileOutputStream("tile.ser");
oos = new ObjectOutputStream(fichier);
oos.writeObject(tile);
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