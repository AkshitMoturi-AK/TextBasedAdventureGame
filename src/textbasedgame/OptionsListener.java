package textbasedgame;

/**
 * 
 * This interface has methods related to Paths, options and conversations.
 *
 */
public interface OptionsListener {

    /**
     * This method is used to create the choices and corresponding conversations of
     * the current scenario
     * 
     * @param optionsAndConversations It contains the set of options and
     *                                conversations that user can select to proceed
     *                                further.
     */
    public void createChoicesAndConversations(String[][] optionsAndConversations);

    /**
     * It sets the current number of choices and calculates the total no of choices
     * <br>
     * The repeated choices are not considered to be new choices
     * 
     * @param noOfChoices The no of options for a user to make at a point of time.
     * @param uniqueKey   The unique key that represent a path
     */
    public void setNoOfchoices(int noOfChoices, String uniqueKey);

    /**
     * Displays the current scenario choices to the user
     */
    public void displayChoicesToPlayer();

    /**
     * Depending on the choice user have selected respective conversation is
     * returned
     * 
     * @return id corresponding to the conversation is returned.
     */
    public int readTheChoiceandDisplaytheConversation();

}