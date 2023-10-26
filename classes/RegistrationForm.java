package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationForm extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private MainMenu mainMenu;// Store a reference to the main menu
    public RegistrationForm(MainMenu mainMenu) {
        setTitle("Registration Form");
        this.mainMenu = mainMenu; // Store the reference to the main menu
        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 50, 5, 50);
        constraints.anchor = GridBagConstraints.CENTER;

        JLabel emailLabel = new JLabel("Email");
        emailField = new JTextField(10);
        JLabel passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField(10);
        JButton registerButton = new JButton("Register");

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(emailLabel, constraints);

        constraints.gridy = 1;
        panel.add(emailField, constraints);

        constraints.gridy = 2;
        panel.add(passwordLabel, constraints);

        constraints.gridy = 3;
        panel.add(passwordField, constraints);

        constraints.gridy = 4;
        panel.add(registerButton, constraints);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

        add(panel);
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void registerUser() {
        String email = emailField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);
        if (isValidEmail(email)) {
            // Create a User object to hold the registration data
            User user = new User(email, password);

            // Serialize the User object to a file
            try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("user.ser", true))) {
                outputStream.writeObject(user);
                JOptionPane.showMessageDialog(this, "User registered and data saved.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error occurred while saving user data.");
            }
            emailField.setBackground(Color.WHITE);
        }else{
            emailField.setBackground(Color.RED);
        }

    };

    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}