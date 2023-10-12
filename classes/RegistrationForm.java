package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public RegistrationForm() {
        setTitle("Registration Form");

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 50, 5, 50);
        constraints.anchor = GridBagConstraints.CENTER;

        JLabel usernameLabel = new JLabel("Username");
        usernameField = new JTextField(10);
        JLabel passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField(10);
        JButton registerButton = new JButton("Register");

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(usernameLabel, constraints);

        constraints.gridy = 1;
        panel.add(usernameField, constraints);

        constraints.gridy = 2;
        panel.add(passwordLabel, constraints);

        constraints.gridy = 3;
        panel.add(passwordField, constraints);

        constraints.gridy = 4;
        panel.add(registerButton, constraints);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
        }
    });

    add(panel);
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}