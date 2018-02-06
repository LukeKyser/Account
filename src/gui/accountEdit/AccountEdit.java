package gui.accountEdit;

import javax.swing.*;

import static resources.Constants.*;

public class AccountEdit {

    private final JFrame frame;
    private JPanel rootPanel;

    public AccountEdit(JFrame frame) {
        this.frame = frame;
        frame.setTitle(ACCOUNT_EDIT_TITLE);
        rootPanel.setPreferredSize(SIZE_X_LARGE);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
