package MainApp;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupFrame implements ActionListener {

    JFrame frame;
    JTextField usernameField;
    JTextField emailField;
    JTextField phoneNumberField;
    JLabel usernameLabel;
    JLabel emailLabel;
    JLabel passwordLabel;
    JPasswordField passwordField;
    JButton signupButton;
    JLabel phoneNumberLabel;
    JButton BackButton;

    ArrayList<User> users;

    public SignupFrame(ArrayList<User> users) {
        frame = new JFrame("Signup");
        this.users = users;

        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        emailLabel = new JLabel("Email:");
        phoneNumberLabel = new JLabel("Phone No:");
        usernameField = new JTextField();
        emailField = new JTextField();
        phoneNumberField = new JTextField();
        passwordField = new JPasswordField();
        signupButton = new JButton("SIGNUP");
        BackButton = new JButton("BACK");

        usernameLabel.setBounds(200, 100, 75, 25);
        emailLabel.setBounds(200, 150, 75, 25);
        phoneNumberLabel.setBounds(200, 200, 75, 25);
        passwordLabel.setBounds(200, 250, 75, 25);

        usernameField.setBounds(300, 100, 220, 25);
        emailField.setBounds(300, 150, 220, 25);
        phoneNumberField.setBounds(300, 200, 220, 25);
        passwordField.setBounds(300, 250, 220, 25);

        signupButton.setBounds(300, 300, 100, 25);
        signupButton.addActionListener(this);

        BackButton.setBounds(410, 300, 100, 25);
        BackButton.addActionListener(this);

        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(phoneNumberLabel);
        frame.add(phoneNumberField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(passwordLabel);
        frame.add(passwordField);

        frame.add(signupButton);
        frame.add(BackButton);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 450);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupButton) {
            String username = usernameField.getText();
            String email = emailField.getText();
            String phoneNumber = phoneNumberField.getText();
            String password = String.valueOf(passwordField.getPassword());

            if (username.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields.");

            } else {
                boolean userExists = false;
                for (User user : users) {
                    if (user.getUsername().equals(username) || user.getEmail().equals(email)) {
                        userExists = true;
                        JOptionPane.showMessageDialog(null, "User already exist,please try another");
                    }
                }

                if (!userExists) {
                    JOptionPane.showMessageDialog(null, "Sign Up Successfully");
                    users.add(new User(username, email, phoneNumber, password));
                    frame.dispose();
                    new LoginFrame(users);
                }
            }

        } else if (e.getSource() == BackButton) {
            frame.dispose();
            new LoginFrame(users);
        }
    }

}
