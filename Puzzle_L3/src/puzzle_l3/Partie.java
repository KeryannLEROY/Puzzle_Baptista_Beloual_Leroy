/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

/**
 *
 * @author kelly
 */
public class Partie  implements java.io.Serializable{
    int score;
    int temps;
    Board board;

    public Partie(int score, int temps, Board board) {
        this.score = score;
        this.temps = temps;
        this.board = board;
    }

    Partie() {
        this.score = 0;
        this.temps = 0;
        this.board = new Board(4,4);
    }
    
    

  
    public int getScore()
    {
        return score;
          
    }

    public int getTemps() {
        return temps;
    }

   
    public Board getBoard() {
        return board;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    
    
    
}
