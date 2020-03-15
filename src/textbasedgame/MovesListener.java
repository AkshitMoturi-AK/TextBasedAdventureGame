package textbasedgame;

/**
 * 
 * This interface has methods related to moves player played.
 *
 */
public interface MovesListener {

    /**
     * used to get no of moves player played
     * @return it returns an integer value which is no of moves player played.
     */
    public int getNoOfMoves();

    /**
     * used to set no of moves
     * @param noOfMoves should contain an integer value to set as no of moves of player.
     */
    public void setNoOfMoves(int noOfMoves);

    /**
     * used to increment player moves by 1
     */
    public void incrementPlayerMoves();

}