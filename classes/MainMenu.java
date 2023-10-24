package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MainMenu extends JFrame{
    public MainMenu() {
        setTitle("Main Menu");
        
        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 50, 5, 50);
        constraints.anchor = GridBagConstraints.CENTER;
        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("LogIn");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(registerButton, constraints);

        constraints.gridy = 1;
        panel.add(loginButton, constraints);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRegistrationForm();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openLoginForm();
            }
        });

        add(panel);
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void openRegistrationForm(){
        new RegistrationForm();
    }
    private void openLoginForm(){
        new LogInForm();
    }
}

