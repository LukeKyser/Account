package gui.accountSetup;

import logic.AccountLogic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

import static gui.MainGUI.*;
import static resources.Constants.*;

public class AccountSetup {

    private final JFrame frame;
    private JPanel rootPanel;
    private JLabel titleLabel;
    private JLabel descriptionLabel;
    private JPanel setupPanel;
    private JTextField firstNameTextField;
    private JPasswordField passwordPasswordField;
    private JPasswordField confirmPasswordPasswordField;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel emailLabel;
    private JLabel streetAddressLabel;
    private JLabel cityLabel;
    private JLabel stateLabel;
    private JLabel zipCodeLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JTextField lastNameTextField;
    private JTextField emailAddressTextField;
    private JTextField streetAddressTextField;
    private JTextField cityTextField;
    private JTextField provinceTextField;
    private JTextField zipCodeTextField;
    private JButton submitButton;
    private JLabel firstNameWarningLabel;
    private JLabel lastNameWarningLabel;
    private JLabel emailAddressWarningLabel;
    private JLabel streetAddressWarningLabel;
    private JLabel cityWarningLabel;
    private JLabel provinceWarningLabel;
    private JLabel zipCodeWarningLabel;
    private JLabel passwordWarningLabel;
    private JLabel confirmPasswordWarningLabel;

    private ArrayList<JTextField> fields = new ArrayList<>();
    private ArrayList<JLabel> warningLabels = new ArrayList<>();

    private AccountLogic accountLogic;

    public AccountSetup(JFrame frame, AccountLogic accountLogic) {
        this.frame = frame;
        this.accountLogic = accountLogic;
        frame.setTitle(ACCOUNT_SETUP_TITLE);
        rootPanel.setPreferredSize(SIZE_LARGE);
        addFieldsToArray();
        addWarningLabelsToArray();

        // Action Listeners
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> input = getInput();
                if(input != null) {
                    setEmail(emailAddressTextField.getText());
                    accountLogic.createAccount(input);
                    clearInput();
                    accountLogic.submit();
                    disposeFrame();
                    createLoginGUI();
                }
            }
        });
    }

    private ArrayList<String> getInput() {
        ArrayList<String> input = null;
        if(verifyPassword() && verifyInput()){
            input = new ArrayList<>();
            for (int i = 0; i < fields.size() - 1; i++) {
                input.add(fields.get(i).getText());
            }
        }
        return input;
    }

    private void clearInput() {
        for (int i = 0; i < fields.size(); i++) {
            fields.get(i).setText("");
        }
    }

    private boolean verifyInput() {
        boolean complete = true;

        for (int i = 0; i < fields.size(); i++) {
            if(Objects.equals(fields.get(i).getText(), "")) {
                warningLabels.get(i).setText(INPUT_ERROR_SYMBOL);
                complete = false;
            } else {
                warningLabels.get(i).setText("");
            }
        }
        return complete;
    }

    private boolean verifyPassword() {
        boolean match = true;

        if(!Objects.equals(passwordPasswordField.getText(), confirmPasswordPasswordField.getText())) {
            passwordWarningLabel.setText(INPUT_ERROR_SYMBOL);
            confirmPasswordWarningLabel.setText(INPUT_ERROR_SYMBOL);
            JOptionPane.showMessageDialog(null, CONFIRM_PASSWORD_ERROR);
            match = false;
        }
        return match;
    }

    private void addFieldsToArray() {
        fields.add(firstNameTextField);
        fields.add(lastNameTextField);
        fields.add(emailAddressTextField);
        fields.add(streetAddressTextField);
        fields.add(cityTextField);
        fields.add(provinceTextField);
        fields.add(zipCodeTextField);
        fields.add(passwordPasswordField);
        fields.add(confirmPasswordPasswordField);
    }

    private void addWarningLabelsToArray() {
        warningLabels.add(firstNameWarningLabel);
        warningLabels.add(lastNameWarningLabel);
        warningLabels.add(emailAddressWarningLabel);
        warningLabels.add(streetAddressWarningLabel);
        warningLabels.add(cityWarningLabel);
        warningLabels.add(provinceWarningLabel);
        warningLabels.add(zipCodeWarningLabel);
        warningLabels.add(passwordWarningLabel);
        warningLabels.add(confirmPasswordWarningLabel);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
