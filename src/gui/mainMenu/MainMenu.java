package gui.mainMenu;

import javax.swing.*;

import static resources.Constants.*;

public class MainMenu {

    private final JFrame frame;
    private JPanel rootPanel;

    public MainMenu(JFrame frame) {
        this.frame = frame;
        frame.setTitle(MAIN_MENU_TITLE);
        rootPanel.setPreferredSize(SIZE_X_LARGE);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
