package textbasedgame;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 
 * This class deals with options and conversations related to each option.
 *
 */
public class OptionAndConversation implements OptionsListener {

    /**
     * Contains current no of choices given to player
     */
    private int noOfChoices = 0;
    /**
     * Contains total no of choices given to player.
     */
    static int totalNoOfChoices = 0;
    /**
     * Object of class CalculateScoresAndMoves
     */
    private CalculateScoresAndMoves calculateScoresAndMovesObject = new CalculateScoresAndMoves();
    /**
     * This hash-map contains uniqueKey of all the paths already traversed
     */
    private static HashMap < String, Boolean > traveresedPaths = new HashMap < String, Boolean > ();
    /**
     * This hash-map has choices given to the player.
     */
    HashMap < Integer, String[] > optionsForCurrentPath = new HashMap < Integer, String[] > ();
    /**
     * Scanner object to read input from player.
     */
    private Scanner scannerObject;
    /**
     * Instance of class DelayedTasks
     */
    private DelayedTasks delayedTasksInstance = DelayedTasks.getInstance();

    @Override
    public void createChoicesAndConversations(String[][] optionsAndConversations) {
        optionsForCurrentPath.clear();
        for (int i = 0; i < noOfChoices; i++) {
            optionsForCurrentPath.put(i + 1, optionsAndConversations[i]);
        }
    }

    @Override
    public void displayChoicesToPlayer() {
        Iterator < Entry < Integer, String[] >> optionsIterator = optionsForCurrentPath.entrySet().iterator();
        while (optionsIterator.hasNext()) {
            Map.Entry < Integer, String[] > option = (Map.Entry < Integer, String[] > ) optionsIterator.next();
            delayedTasksInstance.printWithSentenceAndCharacterDelay(
                option.getKey() + Messages.getString("OptionAndConversation.0") + option.getValue()[0]);
        }
        System.out.print(Messages.getString("OptionAndConversation.makeSelectionMessage"));
    }

    @Override
    public int readTheChoiceandDisplaytheConversation() {
        int playerChoice = 0;
        try {
            scannerObject = new Scanner(System.in);
            playerChoice = scannerObject.nextInt();
            if (playerChoice < 1 || playerChoice > noOfChoices) {
                throw new InputMismatchException(Messages.getString("OptionAndConversation.invalidChoiceMessage"));
            } else {
                String[] conversation = optionsForCurrentPath.get(playerChoice);
                delayedTasksInstance.printWithSentenceAndCharacterDelay(conversation[1]);
            }
            calculateScoresAndMovesObject.incrementPlayerMoves();

        } catch (InputMismatchException e) {
            delayedTasksInstance.printWithSentenceAndCharacterDelay(
                Messages.getString("OptionAndConversation.invalidChoiceMessage"));
            return readTheChoiceandDisplaytheConversation();

        } catch (Exception e) {
            delayedTasksInstance.printWithSentenceAndCharacterDelay(Messages.getString("Common.exceptionMessage"));
            return readTheChoiceandDisplaytheConversation();

        }
        return playerChoice;
    }

    @Override
    public void setNoOfchoices(int noOfChoices, String uniqueKey) {
        this.noOfChoices = noOfChoices;
        if (traveresedPaths.get(uniqueKey) == null || traveresedPaths.get(uniqueKey) == false) {
            totalNoOfChoices += noOfChoices;
            traveresedPaths.put(uniqueKey, true);
        }
    }

    /**
     * Resets total choices given to player
     */
    public void resetTotalNoOfchoices() {
        OptionAndConversation.totalNoOfChoices = 0;
    }

    /**
     * Displays the total choices given to player, no of times player made a choice,
     * total points a player scored
     */
    public void displayChoicesAndMovesAndScore() {
        delayedTasksInstance.printWithSentenceAndCharacterDelay(Messages.getString("OptionAndConversation.totalChoices") + totalNoOfChoices +
            Messages.getString("OptionAndConversation.playerMovesMessage") +
            calculateScoresAndMovesObject.getNoOfMoves() +
            Messages.getString("OptionAndConversation.PlayerPointsMessage") +
            calculateScoresAndMovesObject.getScore() + ")");
    }
}