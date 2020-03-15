package textbasedgame;

/**
 * 
 * This class deals with moves and score of the player.
 *
 */
public class CalculateScoresAndMoves implements MovesListener, ScoresListener {

    /**
     * This variable has player score
     */
	private static int score = 0;
	/**
	 * This is a constant that has the score to increase for every correct move.
	 */
    private final int SCORE_PER_MOVE = 15;
    /**
     * No of moves made by player
     */
    private static int noOfMoves = 0;

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public int getNoOfMoves() {
        return noOfMoves;
    }

    @Override
    public void setScore(int score) {
        CalculateScoresAndMoves.score = score;
    }

    @Override
    public void setNoOfMoves(int noOfMoves) {
        CalculateScoresAndMoves.noOfMoves = noOfMoves;
    }

    @Override
    public void incrementPlayerMoves() {
        noOfMoves += 1;
    }

    @Override
    public void calculateScore() {
        score += SCORE_PER_MOVE;
    }

    /**
     * This methods resets player score and moves to default
     */
    public void resetMovesAndScore() {
        setScore(0);
        setNoOfMoves(0);
    }
}