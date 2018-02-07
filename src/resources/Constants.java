package resources;

import java.awt.*;

public class Constants {
    // Error Messages
    public static final String INPUT_ERROR_SYMBOL = "*";
    public static final String CONFIRM_PASSWORD_ERROR = "\"Password\" and \"Confirm Password\" do not match";
    public static final String NO_ACCOUNT_ERROR = "Account not found. Try another e-mail address.";
    public static final String EMAIL_INPUT_ERROR = "You must enter a valid email address like:      \n                janedoe@website.com";
    public static final String WRONG_PASSWORD_ERROR = "Password Incorrect";
    public static final String BLANK_PASSWORD_ERROR = "You must enter a password";

    // Titles
    public static final String SOUND_PLAYER_TITLE = "Sound Player";
    public static final String ACCOUNT_SETUP_TITLE = "Account Setup";
    public static final String ACCOUNT_EDIT_TITLE = "Edit Account";
    public static final String MAIN_MENU_TITLE = "Main Menu";
    public static final String LOGIN_TITLE = "Login Menu";

    // Panel Sizes
    public static final Dimension SIZE_MEDIUM = new Dimension(450, 300);
    public static final Dimension SIZE_LARGE = new Dimension(650, 450);
    public static final Dimension SIZE_X_LARGE = new Dimension(900, 750);

    // Database Connection
    public static final String DB_SERVER = "***************";
    public static final String DATABASE = "*************";
    public static final String DB_USERNAME = "******************";
    public static final String DB_PASSWORD = "******************";
    public static final String DB_CONNECTION = "jdbc:jtds:sqlserver://"
            + DB_SERVER + "/" + DATABASE + ";user=" + DB_USERNAME + ";password=" + DB_PASSWORD;
}
