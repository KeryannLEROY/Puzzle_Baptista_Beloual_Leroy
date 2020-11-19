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
public class SerializerBoard {
    
     public static void main(String[] args){
        final Board board;
         board = new Board("width","height","tabTiles","vecTiles");
        ObjectOutputStream oos = null;
        try {
        final FileOutputStream fichier = new FileOutputStream("board.ser");
        oos = new ObjectOutputStream(fichier);
        oos.writeObject(board);
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
    

