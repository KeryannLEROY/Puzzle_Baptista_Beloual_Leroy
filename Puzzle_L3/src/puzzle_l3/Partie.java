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

    /**
     *
     * @param board
     * @param timer
     */
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
    
    /**
     *
     * @return
     */
    public int getScore()
    {
        return score;
          
    }

    /**
     *
     * @return
     */
    public Board getBoard() {
        return board;
    }

    /**
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     *
     * @param board
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     *
     * @return
     */
    public Timer getTimer() {
        return timer;
    }

    /**
     *
     * @param timer
     */
    public void setTimer(Timer timer) {
        this.timer = timer;
    }
    
    
    
}
