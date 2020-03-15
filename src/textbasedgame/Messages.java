package textbasedgame;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * 
 * this class deals with properties file
 *
 */
public class Messages {
    private static final String BUNDLE_NAME = "textbasedgame.messages";

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private Messages() {}

    /**
     * used to get the value from properties file
     * 
     * @param key this is the key present in properties file
     * @return returns the value corresponding to key provided.
     */
    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}