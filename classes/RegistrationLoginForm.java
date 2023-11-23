package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationLoginForm extends JFrame {
    private JPanel registrationPanel, loginPanel;
    private JTextField emailField;
    private JPasswordField passwordField;


    public RegistrationLoginForm() {
        setTitle("Registration and Login Form");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a main panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        // mainPanel.setBackground(Color.WHITE);

        // Create registration and login forms
        JPanel registrationFormPanel = createRegistrationFormPanel();
        JPanel loginFormPanel = createLoginFormPanel();

        // Add the registration and login forms to the main panel
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weighty = 1.0; // Set weighty to 1.0 to fill the entire height
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        mainPanel.add(registrationFormPanel, constraints);

        constraints.gridx = 1;
        mainPanel.add(loginFormPanel, constraints);

        // Add the main panel to the content pane
        add(mainPanel);

        setVisible(true);
        ;
    }

    private JPanel createRegistrationFormPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(222, 55, 89));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 50, 5, 50);
        constraints.anchor = GridBagConstraints.WEST;

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

        return panel;
    }

    /**
     * @return
     */
    private JPanel createLoginFormPanel() {
        

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(196, 139, 225));

        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 50, 5, 50);
        constraints.anchor = GridBagConstraints.WEST;

        // Create a panel for the "Sign In" label
        JPanel signInLabelPanel = new JPanel();
        signInLabelPanel.setLayout(new BoxLayout(signInLabelPanel, BoxLayout.Y_AXIS));
        signInLabelPanel.setBackground(new Color(196, 139, 225));
        // signInLabelPanel.setBackground(new Color(89, 144, 222));

        JLabel signInLabel = new JLabel("Log In");
        signInLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        signInLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        signInLabelPanel.setBorder(BorderFactory.createEmptyBorder(70, 0, 0, 0));
        signInLabelPanel.add(signInLabel);

        // Add a "Welcome back" label
        JLabel welcomeBackLabel = new JLabel("Welcome back");
        welcomeBackLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        welcomeBackLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomeBackLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        signInLabelPanel.add(welcomeBackLabel);

        final JLabel logInText = new JLabel("Please enter your personal details");
        logInText.setFont(new Font("Didot", Font.BOLD, 12));
        logInText.setAlignmentX(Component.CENTER_ALIGNMENT);
        logInText.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        signInLabelPanel.add(logInText);

        constraints.anchor = GridBagConstraints.CENTER;
        mainPanel.add(signInLabelPanel, constraints);

        constraints.anchor = GridBagConstraints.CENTER;
        mainPanel.add(signInLabelPanel, constraints);

        // Create a panel for the login components
        JPanel loginComponentsPanel = new JPanel(new GridBagLayout());
        loginComponentsPanel.setBackground(new Color(196, 139, 225));
        loginComponentsPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 150, 0));
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));

        JTextField loginEmailField = new JTextField(10);
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        JPasswordField loginPasswordField = new JPasswordField(10);
        JButton loginButton = createStyledButton("Log In");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        constraints.anchor = GridBagConstraints.WEST;
        loginComponentsPanel.add(emailLabel, constraints);

        constraints.gridy = 2;
        loginComponentsPanel.add(loginEmailField, constraints);

        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.WEST;
        loginComponentsPanel.add(passwordLabel, constraints);

        constraints.gridy = 4;
        loginComponentsPanel.add(loginPasswordField, constraints);

        constraints.gridy = 5;
        loginComponentsPanel.add(loginButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weighty = 0.9;
        mainPanel.add(loginComponentsPanel, constraints);
       

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUser(loginEmailField.getText(), new String(loginPasswordField.getPassword()));
            }
        });

        return mainPanel;
    }

    private static JButton createStyledButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isArmed()) {
                    g.setColor(new Color(152, 66, 238)); // Pressed background color
                } else {
                    g.setColor(new Color(190, 124, 255)); // Default background color
                }

                g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30); // Round rectangle shape

                super.paintComponent(g);
            }

            @Override
            protected void paintBorder(Graphics g) {
                g.setColor(new Color(80, 0, 160)); // Border color
                g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30); // Round rectangle border
            }
        };

        button.setFont(new Font("Times New Roman", Font.BOLD, 15));
        // button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false); // Make content area transparent

        return button;
    }

    private void loginUser(String email, String password) {
        // Login logic
        // Add your login logic here using the provided email and password
        System.out.println("Login user: " + email);
    }

    private void registerUser() {
        String email = emailField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);
        if (isValidEmail(email)) {
            // Create a User object to hold the registration data
            User user = new User(email, password);

            // Serialize the User object to a file
            saveUserData(user);
            emailField.setBackground(Color.GREEN);
        } else {
            emailField.setBackground(Color.RED);
        }

    };

    private static void saveUserData(User user) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("userdata.ser"))) {
            oos.writeObject(user);
            System.out.println("User data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static User loadUserData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("userdata.ser"))) {
            return (User) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
