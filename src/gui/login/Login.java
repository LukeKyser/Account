package gui;

import logic.AccountLogic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import static gui.MainGUI.*;
import static resources.Constants.*;

public class Login {

    private JPanel rootPanel;
    private JLabel titleLabel;
    private JLabel descriptionLabel;
    private JPanel loginPanel;
    private JPanel fieldPanel;
    private JPanel buttonPanel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JTextField emailAddressTextField;
    private JPasswordField passwordPasswordField;
    private JButton accountSetupButton;
    private JButton loginButton;
    private JLabel emailAddressWarningLabel;
    private JLabel passwordWarningLabel;

    private AccountLogic accountLogic;

    public Login() {
        rootPanel.setPreferredSize(SIZE_MEDIUM);
        accountLogic = new AccountLogic();

        accountSetupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                disposeFrame();
                createAccountSetupGUI(accountLogic);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(verifyEmail()) {
                    emailAddressWarningLabel.setText("");
                    if(verifyPassword()) {
                        disposeFrame();
                        createAccountEditGUI();
                    }
                }
            }
        });
    }

    private boolean verifyEmail() {
        boolean exists = false;

        if(!Objects.equals(emailAddressTextField.getText(), "") && emailAddressTextField.getText().indexOf('@') != -1) {
            if(accountLogic.getAccountByEmail(emailAddressTextField.getText())) {
                exists = true;
            } else {
                emailAddressWarningLabel.setText(INPUT_ERROR_SYMBOL);
                JOptionPane.showMessageDialog(null, NO_ACCOUNT_ERROR);
            }
        } else {
            emailAddressWarningLabel.setText(INPUT_ERROR_SYMBOL);
            JOptionPane.showMessageDialog(null, EMAIL_INPUT_ERROR);
        }

        return exists;
    }

    private boolean verifyPassword() {
        boolean match = false;

        if(!Objects.equals(passwordPasswordField.getText(), "")) {
            if (accountLogic.passwordMatch(passwordPasswordField.getText())) {
                match = true;
            } else {
                passwordWarningLabel.setText(INPUT_ERROR_SYMBOL);
                JOptionPane.showMessageDialog(null, WRONG_PASSWORD_ERROR);
            }
        } else {
            passwordWarningLabel.setText(INPUT_ERROR_SYMBOL);
            JOptionPane.showMessageDialog(null, BLANK_PASSWORD_ERROR);
        }

        return match;
    }

    /**
     * Access Login's rootPanel field
     *
     * @return JPanel rootPanel
     */
    public JPanel getRootPanel(String email) {
        emailAddressTextField.setText(email);
        return rootPanel;
    }

}
