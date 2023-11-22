package classes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // MainMenu mainMenu = new MainMenu();
            new RegistrationLoginForm().setVisible(true);
        });
    }
}
