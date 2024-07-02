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
    JRadioButton AdminButton;
    JRadioButton UserButton;
    JLabel roleLabel;
    JCheckBox showPassword;

    ArrayList<User> users;

    public SignupFrame(ArrayList<User> users) {
        frame = new JFrame("Signup");
        this.users = users;

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(200, 100, 75, 25);
        usernameField = new JTextField();
        usernameField.setBounds(300, 100, 220, 25);
        frame.add(usernameLabel);
        frame.add(usernameField);
        
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(200, 150, 75, 25);
        emailField = new JTextField();
        emailField.setBounds(300, 150, 220, 25);
        frame.add(emailLabel);
        frame.add(emailField);
        
        phoneNumberLabel = new JLabel("Phone No:");
        phoneNumberLabel.setBounds(200, 200, 75, 25);
        phoneNumberField = new JTextField();
        phoneNumberField.setBounds(300, 200, 220, 25);
        frame.add(phoneNumberLabel);
        frame.add(phoneNumberField);
        
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(200, 250, 75, 25);
        passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
        passwordField.setBounds(300, 250, 220, 25);
        frame.add(passwordLabel);
        frame.add(passwordField);emailLabel = new JLabel("Email:");
        
        showPassword = new JCheckBox();
        showPassword.setBounds(520, 250, 150, 25);
        showPassword.addActionListener(this);
        frame.add(showPassword);
       
        AdminButton = new JRadioButton("Admin");
        AdminButton.setBounds(325, 300, 100, 25);
        frame.add(AdminButton);

        UserButton = new JRadioButton("User");
        UserButton.setBounds(425, 300, 100, 25);
        frame.add(UserButton);
        
        roleLabel = new JLabel("Roles");
        roleLabel.setBounds(200,300,75,25);
        ButtonGroup group = new ButtonGroup();
        group.add(AdminButton);
        group.add(UserButton);
        frame.add(roleLabel);
        
        signupButton = new JButton("SIGNUP");
        signupButton.setBounds(300, 350, 100, 25);
        signupButton.addActionListener(this);
        frame.add(signupButton);
        
        BackButton = new JButton("BACK");
        BackButton.setBounds(410, 350, 100, 25);
        BackButton.addActionListener(this);
        frame.add(BackButton);
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 450);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocation(280,150);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupButton) {
            String username = usernameField.getText();
            String email = emailField.getText();
            String phoneNumber = phoneNumberField.getText();
            String password = String.valueOf(passwordField.getPassword());
            boolean isAdmin = AdminButton.isSelected();

            if (username.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || password.isEmpty()
                ||(!AdminButton.isSelected()&& !UserButton.isSelected())) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields.");

            } else {
                boolean userExists = false;
                for (User user : users) {
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                        userExists = true;
                        JOptionPane.showMessageDialog(null, "User already exist,please try another");
                    }
                }

                if (!userExists) {
                    
                    User user;
                    if(isAdmin){
                         Admin admin = new Admin(username, email, phoneNumber, password);
                         users.add(admin);  
                    }else{
                        NormalUser normalUser = new NormalUser(username, email, phoneNumber, password);
                        users.add(normalUser);
                    }
                    JOptionPane.showMessageDialog(null, "Sign Up Successfully");
                    new LoginFrame(users);
                    frame.dispose();
                }
            }

        } else if(e.getSource() == showPassword){
            
            if(showPassword.isSelected()){
                passwordField.setEchoChar((char) 0);
            }else{
                passwordField.setEchoChar('*');
            }
            
        }else if (e.getSource() == BackButton) {
            frame.dispose();
            new LoginFrame(users);
        }
    }

}
