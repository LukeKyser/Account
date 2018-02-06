package gui;

import gui.accountEdit.AccountEdit;
import gui.accountSetup.AccountSetup;
import logic.AccountLogic;

import javax.swing.*;

import static resources.Constants.LOGIN_TITLE;

public class MainGUI {

    private static JFrame frame = new JFrame();
    private static String emailAddress = "";

    /**
     * Main Method of Project
     *
     * @param args arguments passed into Main
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(MainGUI::createLoginGUI);
    }

    public static void createLoginGUI() {
        frame = new JFrame(LOGIN_TITLE);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new gui.Login().getRootPanel(emailAddress));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void createAccountSetupGUI(AccountLogic accountLogic) {
        frame = new JFrame();
        AccountSetup accountSetup = new AccountSetup(frame, accountLogic);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(accountSetup.getRootPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void createAccountEditGUI() {
        frame = new JFrame();
        AccountEdit accountEdit = new AccountEdit(frame);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(accountEdit.getRootPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void setEmail(String email) {
        emailAddress = email;
    }

    public static void disposeFrame() {
        frame.dispose();
    }
}
