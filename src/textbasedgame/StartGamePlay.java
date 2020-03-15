package textbasedgame;

/**
 * This is the main class from where the game begins.
 * 
 * @author Afshan Jabeen - 1992483
 * @author Samudrala Saikrishna - 1992537
 * @author Akshit Moturi - 1992548
 */
public class StartGamePlay {

    /**
     * This is main method from where the execution starts
     * 
     * @param args runtime arguments
     */
    public static void main(String[] args) {

        PlayerProfile playerProfileObj = new PlayerProfile();
        AdventureToCastle gamePlayObj = new AdventureToCastle();
        playerProfileObj.createPlayerProfile();
        gamePlayObj.startAdventureToCastle();
    }
}