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
    //
    private int score;
    private Timer timer;
    private Board board;

    /**
     *
     * @param board grille 
     * @param timer chronomètre de  la partie
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
     *permet d'accéder au score
     * @return
     */
    public int getScore()
    {
        return score;
          
    }

    /**
     *permet d'accéder à la grille
     * @return
     */
    public Board getBoard() {
        return board;
    }

    /**
     *permet la mise à jour du score
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     *permet la mise à jour de la grille
     * @param board
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     *permet d'accéder au chronomètre
     * @return
     */
    public Timer getTimer() {
        return timer;
    }

    /**
     *permet de mettre à jour le chronometre
     * @param timer
     */
    public void setTimer(Timer timer) {
        this.timer = timer;
    }
    
    
    
}
