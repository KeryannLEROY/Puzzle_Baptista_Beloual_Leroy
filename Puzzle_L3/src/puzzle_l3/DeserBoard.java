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
public class DeserBoard {
    public static void main(String[] args) {
Board board;
ObjectOutputStream oos = null;
ObjectInputStream ois = null;
try {
final FileInputStream fichierIn = new FileInputStream("board.ser");
ois = new ObjectInputStream(fichierIn);
board = (Board) ois.readObject();
System.out.println("Board : ");
System.out.println("wight : " + board.getWight());
} catch (final java.io.IOException | ClassNotFoundException e) {
} finally {
try {
if (ois != null) {
ois.close();
}
} catch (final IOException e) {
}}}}
    

