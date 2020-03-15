package textbasedgame;

/**
 * 
 * This is a class used to create obstacles in second part of the game and make
 * it more adventurous.
 *
 */
public class AdventureAtCastle {

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
    private DelayedTasks delayedTasksInstance = DelayedTasks.getInstance();
    /**
     * Object of class AdventureToCastle
     */
    private AdventureToCastle adventureToCastleObj = new AdventureToCastle();

    /**
     * This method starts adventure at the castle
     */
    public void startAdventureAtCastle() {
        delayedTasksInstance.printWithSentenceAndCharacterDelay(Messages.getString("AdventureAtCastle.teleportMessage"));
        delayedTasksInstance.printWithSentenceAndCharacterDelay(Messages.getString("AdventureAtCastle.castleInfo"));
        delayedTasksInstance.printWithSentenceAndCharacterDelay(Messages.getString("AdventureAtCastle.scenarioAtCastleMessage"));
        proceedToDragonOrAngel();
    }

    /**
     * This method creates an obstacle in player's game
     */
    private void proceedToDragonOrAngel() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(new String[][] {
            {
                Messages.getString("AdventureAtCastle.proceedToDragonOrAngel.choice_1"),
                Messages.getString("AdventureAtCastle.proceedToDragonOrAngel.conversation_1")
            }, {
                Messages.getString("AdventureAtCastle.proceedToDragonOrAngel.choice_2"),
                Messages.getString("AdventureAtCastle.proceedToDragonOrAngel.conversation_2")
            }
        });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();

        if (playerChoice == 1) {
            fightTheDragonOrGetBack();
        } else if (playerChoice == 2) {
            scoresAndMovesObject.calculateScore();
            talkToAngel();
        }
    }

    /**
     * This method creates an obstacle in player's game
     */
    private void fightTheDragonOrGetBack() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(new String[][] {
            {
                Messages.getString("AdventureAtCastle.fightTheDragonOrGetBack.choice_1"),
                Messages.getString("AdventureAtCastle.fightTheDragonOrGetBack.conversation_1")
            }, {
                Messages.getString("AdventureAtCastle.fightTheDragonOrGetBack.choice_2"),
                Messages.getString("AdventureAtCastle.fightTheDragonOrGetBack.conversation_2")
            }
        });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        if (playerChoice == 1) {
            proceedToDragonOrAngel();
        } else if (playerChoice == 2) {
            adventureToCastleObj.exitGame();
        }
    }

    /**
     * This method creates an obstacle in player's game
     */
    private void talkToAngel() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(new String[][] {
            {
                Messages.getString("AdventureAtCastle.talkToAngel.choice_1"),
                Messages.getString("AdventureAtCastle.talkToAngel.conversation_1")
            }, {
                Messages.getString("AdventureAtCastle.talkToAngel.choice_2"),
                Messages.getString("AdventureAtCastle.talkToAngel.conversation_2")
            }
        });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        if (playerChoice == 1) {
            adventureToCastleObj.exitGame();
        } else if (playerChoice == 2) {
            scoresAndMovesObject.calculateScore();
            findTheWayIntoCastle();
        }
    }

    /**
     * This method creates an obstacle in player's game
     */
    private void findTheWayIntoCastle() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(new String[][] {
            {
                Messages.getString("AdventureAtCastle.findTheWayIntoCastle.choice_1"),
                Messages.getString("AdventureAtCastle.findTheWayIntoCastle.conversation_1")
            }, {
                Messages.getString("AdventureAtCastle.findTheWayIntoCastle.choice_2"),
                Messages.getString("AdventureAtCastle.findTheWayIntoCastle.conversation_2")
            }
        });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        if (playerChoice == 1) {
            searchForSecretTunnel();
        } else if (playerChoice == 2) {
            scoresAndMovesObject.calculateScore();
            getIntoTheCastle();
        }
    }

    /**
     * This method creates an obstacle in player's game
     */
    private void getIntoTheCastle() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(new String[][] {
            {
                Messages.getString("AdventureAtCastle.getIntoTheCastle.choice_1"),
                Messages.getString("AdventureAtCastle.getIntoTheCastle.conversation_1")
            }, {
                Messages.getString("AdventureAtCastle.getIntoTheCastle.choice_2"),
                Messages.getString("AdventureAtCastle.getIntoTheCastle.conversation_2")
            }
        });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        if (playerChoice == 1) {
            scoresAndMovesObject.calculateScore();
            proceedToWestFromDoor();
        } else if (playerChoice == 2) {
            proceedToEastFromDoor();
        }
    }

    /**
     * This method creates an obstacle in player's game
     */
    private void proceedToEastFromDoor() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(new String[][] {
            {
                Messages.getString("AdventureAtCastle.proceedToEastFromDoor.choice_1"),
                Messages.getString("AdventureAtCastle.proceedToEastFromDoor.conversation_1")
            }, {
                Messages.getString("AdventureAtCastle.proceedToEastFromDoor.choice_2"),
                Messages.getString("AdventureAtCastle.proceedToEastFromDoor.conversation_2")
            }
        });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        if (playerChoice == 1) {
            investigateThePhotos();
        } else if (playerChoice == 2) {
            adventureToCastleObj.exitGame();
        }
    }

    /**
     * 
     */
    private void investigateThePhotos() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(
            new String[][] {
                {
                    Messages.getString("AdventureAtCastle.investigateThePhotos.choice_1"),
                    Messages.getString("AdventureAtCastle.investigateThePhotos.conversation_1")
                }, {
                    Messages.getString("AdventureAtCastle.investigateThePhotos.choice_2"),
                    Messages.getString("AdventureAtCastle.investigateThePhotos.conversation_2")
                }
            });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        if (playerChoice == 1) {
            adventureToCastleObj.exitGame();
        } else if (playerChoice == 2) {
            getIntoTheCastle();
        }
    }

    /**
     * 
     */
    private void proceedToWestFromDoor() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(new String[][] {
            {
                Messages.getString("AdventureAtCastle.proceedToWestFromDoor.choice_1"),
                Messages.getString("AdventureAtCastle.proceedToWestFromDoor.conversation_1")
            }, {
                Messages.getString("AdventureAtCastle.proceedToWestFromDoor.choice_2"),
                Messages.getString("AdventureAtCastle.proceedToWestFromDoor.conversation_2")
            }
        });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        if (playerChoice == 1) {
            scoresAndMovesObject.calculateScore();
            crossTheBridge();
        } else if (playerChoice == 2) {
            adventureToCastleObj.exitGame();
        }
    }

    /**
     * This method creates an obstacle in player's game
     */
    private void crossTheBridge() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(new String[][] {
            {
                Messages.getString("AdventureAtCastle.crossTheBridge.choice_1"),
                Messages.getString("AdventureAtCastle.crossTheBridge.conversation_1")
            }, {
                Messages.getString("AdventureAtCastle.crossTheBridge.choice_2"),
                Messages.getString("AdventureAtCastle.crossTheBridge.conversation_2")
            }
        });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        if (playerChoice == 1) {
            scoresAndMovesObject.calculateScore();
            proceedInDarknerssWithItems();
        } else if (playerChoice == 2) {
            adventureToCastleObj.exitGame();
        }
    }

    /**
     * This method creates an obstacle in player's game
     */
    private void proceedInDarknerssWithItems() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(new String[][] {
            {
                Messages.getString("AdventureAtCastle.proceedInDarknerssWithItems.choice_1"),
                Messages.getString("AdventureAtCastle.proceedInDarknerssWithItems.conversation_1")
            }, {
                Messages.getString("AdventureAtCastle.proceedInDarknerssWithItems.choice_2"),
                Messages.getString("AdventureAtCastle.proceedInDarknerssWithItems.conversation_2")
            }
        });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        if (playerChoice == 1) {
            scoresAndMovesObject.calculateScore();
            crossThePathCarefully();
        } else if (playerChoice == 2) {
            adventureToCastleObj.exitGame();
        }
    }

    /**
     * This method creates an obstacle in player's game
     */
    private void crossThePathCarefully() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(new String[][] {
            {
                Messages.getString("AdventureAtCastle.crossThePathCarefully.choice_1"),
                Messages.getString("AdventureAtCastle.crossThePathCarefully.conversation_1")
            }, {
                Messages.getString("AdventureAtCastle.crossThePathCarefully.choice_2"),
                Messages.getString("AdventureAtCastle.crossThePathCarefully.conversation_2")
            }
        });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        if (playerChoice == 1) {
            crossThePathCarefully();
        } else if (playerChoice == 2) {
            scoresAndMovesObject.calculateScore();
            proceedToWestAfterCrossingPath();
        }
    }

    /**
     * This method creates an obstacle in player's game
     */
    private void proceedToWestAfterCrossingPath() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(new String[][] {
            {
                Messages.getString("AdventureAtCastle.proceedToWestAfterCrossingPath.choice_1"),
                Messages.getString("AdventureAtCastle.proceedToWestAfterCrossingPath.conversation_1")
            }, {
                Messages.getString("AdventureAtCastle.proceedToWestAfterCrossingPath.choice_2"),
                Messages.getString("AdventureAtCastle.proceedToWestAfterCrossingPath.conversation_2")
            }
        });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        if (playerChoice == 1) {
            scoresAndMovesObject.calculateScore();
            openTheBox();
        } else if (playerChoice == 2) {
            breakTheLock();
        }
    }
    
    
    /**
     * This method creates an obstacle in player's game
     */
    private void openTheBox() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(new String[][] {
            {
                Messages.getString("AdventureAtCastle.openTheBox.choice_1"),
                Messages.getString("AdventureAtCastle.openTheBox.conversation_1")
            }, {
                Messages.getString("AdventureAtCastle.openTheBox.choice_2"),
                Messages.getString("AdventureAtCastle.openTheBox.conversation_2")
            }
        });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        if (playerChoice == 1) {
            scoresAndMovesObject.calculateScore();
            saveScaryWoman();
        } else if (playerChoice == 2) {
            adventureToCastleObj.exitGame();
        }
    }

    /**
     * This method creates an obstacle in player's game
     */
    private void saveScaryWoman() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(new String[][] {
            {
                Messages.getString("AdventureAtCastle.saveScaryWoman.choice_1"),
                Messages.getString("AdventureAtCastle.saveScaryWoman.conversation_1")
            }, {
                Messages.getString("AdventureAtCastle.saveScaryWoman.choice_2"),
                Messages.getString("AdventureAtCastle.saveScaryWoman.conversation_2")
            }
        });
        optionAndConversationObject.displayChoicesToPlayer();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        adventureToCastleObj.exitGame();
    }

    /**
     * This method creates an obstacle in player's game
     */
    private void breakTheLock() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(new String[][] {
                {
                    Messages.getString("AdventureAtCastle.breakTheLock.choice_1"),
                    Messages.getString("AdventureAtCastle.breakTheLock.conversation_1")
                }, {
                    Messages.getString("AdventureAtCastle.breakTheLock.choice_2"),
                    Messages.getString("AdventureAtCastle.breakTheLock.conversation_2")
                }
            });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        proceedToWestAfterCrossingPath();
    }

    /**
     * This method creates an obstacle in player's game
     */
    private void searchForSecretTunnel() {
        optionAndConversationObject.setNoOfchoices(2, getUniqueKey());
        optionAndConversationObject.createChoicesAndConversations(new String[][] {
                {
                    Messages.getString("AdventureAtCastle.searchForSecretTunnel.choice_1"),
                    Messages.getString("AdventureAtCastle.searchForSecretTunnel.conversation_1")
                }, {
                    Messages.getString("AdventureAtCastle.searchForSecretTunnel.choice_2"),
                    Messages.getString("AdventureAtCastle.searchForSecretTunnel.conversation_2")
                }
            });
        optionAndConversationObject.displayChoicesToPlayer();
        optionAndConversationObject.displayChoicesAndMovesAndScore();
        playerChoice = optionAndConversationObject.readTheChoiceandDisplaytheConversation();
        if (playerChoice == 1) {
            findTheWayIntoCastle();
        } else if (playerChoice == 2) {
            adventureToCastleObj.exitGame();
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