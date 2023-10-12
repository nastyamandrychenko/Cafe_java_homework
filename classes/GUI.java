package classes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegistrationForm registrationForm = new RegistrationForm();
        });
    }
}
