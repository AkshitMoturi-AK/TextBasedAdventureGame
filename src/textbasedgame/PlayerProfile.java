package textbasedgame;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * This class has information about player.
 *
 */
public class PlayerProfile {
    /**
     * The name of the player
     */
    String name;
    /**
     * The gender of the player
     */
    String gender;
    /**
     * The salutation of the player depending on the gender
     */
    String salutation;
    /**
     * The age of the player in years
     */
    int age;
    /**
     * The date of birth of the player
     */
    String dateOfBirth;
    /**
     * Scanner object to read input from player.
     */
    private Scanner scannerObject;
    /**
     * Instance of class DelayedTasks
     */
    private DelayedTasks delayedTasksInstance = DelayedTasks.getInstance();

    /**
     * This method creates the player profile. player profile include Name, gender,
     * Age, Date of birth.
     */
    public void createPlayerProfile() {

        scannerObject = new Scanner(System.in);
        delayedTasksInstance.printWithSentenceAndCharacterDelay(Messages.getString("PlayerProfile.welcomeMessage"));
        delayedTasksInstance.printWithSentenceAndCharacterDelay(Messages.getString("PlayerProfile.askPlayerName"));
        name = scannerObject.nextLine();
        askPlayerGender();
        askPlayerAge();
        askPlayerDOB();
        delayedTasksInstance.printWithSentenceAndCharacterDelay(Messages.getString("PlayerProfile.helloMessage") + salutation + name);
    }

    /**
     * This method takes the gender as input from the player.
     * @exception InputMismatchException catches the wrong input given by user
     */
    private void askPlayerGender() {
        int responseForGender;
        scannerObject = new Scanner(System.in);
        try {
            delayedTasksInstance
                .printWithSentenceAndCharacterDelay(Messages.getString("PlayerProfile.askForPlayerGender"));
            delayedTasksInstance
                .printWithSentenceAndCharacterDelay(Messages.getString("PlayerProfile.playerGenderOptions"));
            responseForGender = scannerObject.nextInt();
            if (responseForGender == 1) {
                gender = Messages.getString("PlayerProfile.male");
                salutation = Messages.getString("PlayerProfile.maleSalutation");
            } else if (responseForGender == 2) {
                gender = Messages.getString("PlayerProfile.female");
                salutation = Messages.getString("PlayerProfile.femaleSalutation");
            } else if (responseForGender == 3) {
                gender = Messages.getString("PlayerProfile.otherGender");
                salutation = "";
            } else {
                throw new InputMismatchException(Messages.getString("PlayerProfile.wrongGenderMessage"));
            }
        } catch (InputMismatchException e) {
            delayedTasksInstance
                .printWithSentenceAndCharacterDelay(Messages.getString("PlayerProfile.wrongGenderMessage"));
            askPlayerGender();
        } catch (Exception e) {
            delayedTasksInstance.printWithSentenceAndCharacterDelay(Messages.getString("Common.exceptionMessage"));
            askPlayerGender();
        }
    }

    /**
     * This method takes the age as input from the player.
     * @exception InputMismatchException catches the wrong input given by user
     */
    private void askPlayerAge() {
        scannerObject = new Scanner(System.in);
        try {
            delayedTasksInstance
                .printWithSentenceAndCharacterDelay(Messages.getString("PlayerProfile.askForPlayerAge"));
            age = scannerObject.nextInt();
            if (age <= 0) {
                throw new InputMismatchException(Messages.getString("PlayerProfile.wrongAgeMessage"));
            }
        } catch (InputMismatchException e) {
            delayedTasksInstance
                .printWithSentenceAndCharacterDelay(Messages.getString("PlayerProfile.wrongAgeMessage"));
            askPlayerAge();
        } catch (Exception e) {
            delayedTasksInstance.printWithSentenceAndCharacterDelay(Messages.getString("Common.exceptionMessage"));
            askPlayerAge();
        }
    }

    /**
     * This method takes the Date of birth as input from the player. The format
     * followed is MM/DD/YYYY
     * @exception InputMismatchException catches the wrong input given by user
     */
    private void askPlayerDOB() {
        scannerObject = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat(Messages.getString("PlayerProfile.dateFormat"));
        Date checkDate = null;

        try {
            delayedTasksInstance.printWithSentenceAndCharacterDelay(Messages.getString("PlayerProfile.askUserForDOB"));
            dateOfBirth = scannerObject.next();
            checkDate = df.parse(dateOfBirth);
            Date today = new Date();
            if (!df.format(checkDate).equals(dateOfBirth) || today.after(checkDate) == false) {
                throw new InputMismatchException(Messages.getString("PlayerProfile.wrongDateMessage"));
            }
        } catch (InputMismatchException e) {
            delayedTasksInstance
                .printWithSentenceAndCharacterDelay(Messages.getString("PlayerProfile.wrongDateMessage"));
            dateOfBirth = "";
            askPlayerDOB();
        } catch (Exception e) {
            delayedTasksInstance.printWithSentenceAndCharacterDelay(Messages.getString("Common.exceptionMessage"));
            dateOfBirth = "";
            askPlayerDOB();
        }
    }
}