package textbasedgame;

/**
 * 
 * This interface has methods related to scores
 *
 */
public interface ScoresListener {
	/**
	 * Used to get the current score of the player
	 * 
	 * @return score It contains the integer value of current player's score
	 */
	public int getScore();

	/**
	 * Used to set the score of the player
	 * 
	 * @param score It should contain the player score
	 */
	public void setScore(int score);

	/**
	 * Used to calculate the score of the player.
	 */
	public void calculateScore();

}
