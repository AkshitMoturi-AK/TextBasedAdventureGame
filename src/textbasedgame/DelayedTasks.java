package textbasedgame;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * This class deals with tasks that needs some delay
 *
 */
public class DelayedTasks {

	/**
	 * This variable is used to store instance of DelayedTasks
	 */
    private static DelayedTasks instance;
    /**
     * To create logs
     */
    private static final Logger LOGGER = Logger.getLogger(DelayedTasks.class.getName());

    private DelayedTasks() {}

    /**
     * returns the existing instance of this class if already present else creates
     * the instance and returns it
     * 
     * @return Returns the instance of this class
     */
    public static synchronized DelayedTasks getInstance() {
        if (instance == null) {
            instance = new DelayedTasks();
        }
        return instance;
    }

    /**
     * This method prints the the message with delay before it starts printing
     * @param messageToPrint Message to be printed to console
     */
    public void printWithSentenceDelay(String messageToPrint) {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Exception occured", e.getMessage());
        }
        System.out.println(messageToPrint);
    }

    /**
     * This method prints the the message with delay between each character
     * @param messageToPrint Message to be printed to console
     */
    public void printWithCharacterDelay(String messageToPrint) {
        try {
            for (char ch: messageToPrint.toCharArray()) {
                System.out.print(ch);
                TimeUnit.MILLISECONDS.sleep(50);
            }
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Exception occured", e.getMessage());
        }
        System.out.println();
    }

    /**
     * This method prints the the message with delay before it starts printing and
     * also between each character
     * @param messageToPrint Message to be printed to console
     */
    public void printWithSentenceAndCharacterDelay(String messageToPrint) {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
            for (char ch: messageToPrint.toCharArray()) {
                System.out.print(ch);
                TimeUnit.MILLISECONDS.sleep(40);

            }
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Exception occurred", e.getMessage());
        }
        System.out.println();
    }
}