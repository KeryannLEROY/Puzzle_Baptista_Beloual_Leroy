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
    private int score;
    private Timer timer;
    private Board board;

    public Partie( Board board, Timer timer) {
        this.score = 0;
        this.timer=timer;
        this.board = board;
    }

    Partie() {
        this.score = 0;
        this.timer= new Timer();
        this.board = new Board(4,4);
    }
    
    

  
    public int getScore()
    {
        return score;
          
    }

    

   
    public Board getBoard() {
        return board;
    }

    public void setScore(int score) {
        this.score = score;
    }

    

    public void setBoard(Board board) {
        this.board = board;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
    
    
    
}
