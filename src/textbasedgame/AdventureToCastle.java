package textbasedgame;

/**
 * 
 * This is a class used to create obstacles in first part of the game and make
 * it more adventurous.
 *
 */
public class AdventureToCastle {

    /**
     * Object of class OptionAndConversation
     */
    private OptionAndConversation optionAndConversationObject = new OptionAndConversation();
    /**
     * Object of class CalculateScoresAndMoves
     */
    private CalculateScoresAndMoves scoresAndMovesObject = new CalculateScoresAndMoves();
    /**
     * This variable stores the player selection of path at a point of time.
     */
    private int playerChoice = 0;
    /**
     * Instance of class DelayedTasks
     */
    private DelayedTasks delayedTaskInstance = DelayedTasks.getInstance();

    /**
     * This method is used to start the adventure until you reach a castle.
     */
    public void startAdventureToCastle() {
        delayedTaskInstance.printWithSentenceAndCharacterDelay(Messages.getString("AdventureToCastle.startTheGame"));
        delayedTaskInstance.printWithSentenceAndCharacterDelay(
            Messages.getString("AdventureToCastle.simpleGameScenario"));
        startInDesert();
    }

    /**
     * This method exits the current game and starts a new game on player's
     * confirmation.
     */
    public void exitGame() {
        delayedTaskInstance.printWithSentenceAndCharacterDelay(Messages.getString("AdventureToCastle.gameEndMessage"));
        delayedTaskInstance.printWithSentenceAndCharacterDelay(
            Messages.getString("AdventureToCastle.totalChoicesMessage") + OptionAndConversation.totalNoOfChoices);
        delayedTaskInstance.printWithSentenceAndCharacterDelay(
            Messages.getString("AdventureToCastle.totalMovesMessage") + scoresAndMovesObject.getNoOfMoves());
        delayedTaskInstance
            .printWithSentenceAndCharacterDelay(Messages.getString("AdventureToCastle.totalScoreMessage") + scoresAndMovesObject.getScore());
        delayedTaskInstance.printWithSentenceAndCharacterDelay(Messages.getString("AdventureToCastle.thankYouMessage"));
        replay();
    }

    /**
     * This method asks for player decision to play a game again or exit the game.
     */
    private void replay() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(new String[][] {
            {
                Messages.getString("AdventureToCastle.replayMessage"),
                Messages.getString("AdventureToCastle.welcomeBackmessage")
            }, {
                Messages.getString("AdventureToCastle.exitGameMessage"),
                Messages.getString("AdventureToCastle.thanksForTimeMessage")
            }
        });
        optionAndConversationObject.displayChoicesToPlayer();
        System.out.println();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        if (playerChoice == 1) {
            scoresAndMovesObject.resetMovesAndScore();
            optionAndConversationObject.resetTotalNoOfchoices();
            startAdventureToCastle();
        } else if (playerChoice == 2) {
            System.exit(0);
        }
    }

    /**
     * This method creates an obstacle in player's game
     */
    private void startInDesert() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(new String[][] {
            {
                Messages.getString("AdventureToCastle.startInDesert.choice_1"),
                Messages.getString("AdventureToCastle.startInDesert.conversation_1")
            }, {
                Messages.getString("AdventureToCastle.startInDesert.choice_2"),
                Messages.getString("AdventureToCastle.startInDesert.conversation_2")
            }
        });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        if (playerChoice == 1) {
            waitAtStartPoint();
        } else if (playerChoice == 2) {
            scoresAndMovesObject.calculateScore();
            startAdventureAtWayboard();
        }
    }

    /**
     * This method creates an obstacle in player's game
     */
    private void waitAtStartPoint() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(
            new String[][] {
                {
                    Messages.getString("AdventureToCastle.waitAtStartPoint.choice_1"),
                    Messages.getString("AdventureToCastle.waitAtStartPoint.conversation_1")
                }, {
                    Messages.getString("AdventureToCastle.waitAtStartPoint.choice_2"),
                    Messages.getString("AdventureToCastle.waitAtStartPoint.conversation_2")
                }
            });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        if (playerChoice == 1) {
            exitGame();
        } else if (playerChoice == 2) {
            scoresAndMovesObject.calculateScore();
            startAdventureAtWayboard();
        }
    }

    /**
     * This method creates an obstacle in player's game
     */
    private void startAdventureAtWayboard() {
        optionAndConversationObject.setNoOfchoices(3, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(new String[][] {
            {
                Messages.getString("AdventureToCastle.startAdventureAtWayboard.choice_1"),
                Messages.getString("AdventureToCastle.startAdventureAtWayboard.conversation_1")
            }, {
                Messages.getString("AdventureToCastle.startAdventureAtWayboard.choice_2"),
                Messages.getString("AdventureToCastle.startAdventureAtWayboard.conversation_2")
            }, {
                Messages.getString("AdventureToCastle.startAdventureAtWayboard.choice_3"),
                Messages.getString("AdventureToCastle.startAdventureAtWayboard.conversation_3")
            }
        });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        if (playerChoice == 1) {
            scoresAndMovesObject.calculateScore();
            new AdventureAtCastle().startAdventureAtCastle();

        } else if (playerChoice == 2) {
            proceedToEastFromWayBoard();
        } else if (playerChoice == 3) {
            proceedToWestFromWayboard();
        }
    }

    /**
     * This method creates an obstacle in player's game
     */
    private void proceedToWestFromWayboard() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(new String[][] {
            {
                Messages.getString("AdventureToCastle.proceedToWestFromWayboard.choice_1"),
                Messages.getString("AdventureToCastle.proceedToWestFromWayboard.conversation_1")
            }, {
                Messages.getString("AdventureToCastle.proceedToWestFromWayboard.choice_2"),
                Messages.getString("AdventureToCastle.proceedToWestFromWayboard.conversation_2")
            }
        });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        if (playerChoice == 1) {
            stayOnWestOfWayBoard();
        } else if (playerChoice == 2) {
            startAdventureAtWayboard();
        }
    }

    /**
     * This method creates an obstacle in player's game
     */
    private void stayOnWestOfWayBoard() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(
            new String[][] {
                {
                    Messages.getString("AdventureToCastle.stayOnWestOfWayBoard.choice_1"),
                    Messages.getString("AdventureToCastle.stayOnWestOfWayBoard.conversation_1")
                }, {
                    Messages.getString("AdventureToCastle.stayOnWestOfWayBoard.choice_2"),
                    Messages.getString("AdventureToCastle.stayOnWestOfWayBoard.conversation_2")
                }
            });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        if (playerChoice == 1) {
            exitGame();
        } else if (playerChoice == 2) {
            startAdventureAtWayboard();
        }
    }

    /**
     * This method creates an obstacle in player's game
     */
    private void proceedToEastFromWayBoard() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(new String[][] {
            {
                Messages.getString("AdventureToCastle.proceedToEastFromWayBoard.choice_1"),
                Messages.getString("AdventureToCastle.proceedToEastFromWayBoard.conversation_1")
            }, {
                Messages.getString("AdventureToCastle.proceedToEastFromWayBoard.choice_2"),
                Messages.getString("AdventureToCastle.proceedToEastFromWayBoard.conversation_2")
            }
        });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        if (playerChoice == 1) {
            exitGame();
        } else if (playerChoice == 2) {
            startAdventureAtWayboard();
        }
    }

    /**
     * @return uniqueKey that represents a specific path
     */
    private String getUniqueKey() {
        String uniqueKey = new Throwable().getStackTrace()[1].getMethodName() + this.getClass().getName();
        return uniqueKey;
    }

}