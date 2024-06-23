package MainApp;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame implements ActionListener {

    private ArrayList<User> users;

    JFrame frame;
    JButton LoginBtn;
    JButton SignupBtn;
    JTextField username;
    JPasswordField password;
    JLabel usernameLabel;
    JLabel passwordLabel;
    JLabel messageLabel;
    JPanel panel;
    JRadioButton AdminBtn;
    JRadioButton UserBtn;
    

    public LoginFrame(ArrayList<User> users) {

        this.users = users;
        frame = new JFrame();

        LoginBtn = new JButton("Login");
        SignupBtn = new JButton("Signup");
        username = new JTextField();
        password = new JPasswordField();
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        messageLabel = new JLabel("WELCOME");

        panel = new JPanel();
        AdminBtn = new JRadioButton("Admin");
        UserBtn = new JRadioButton("Normal User");

        panel.setBackground(new Color(0xff769c));
        panel.setBounds(0, 0, 300, 400);

        usernameLabel.setBounds(350, 100, 75, 25);
        passwordLabel.setBounds(350, 150, 75, 25);
        
        messageLabel.setBounds(70, 50, 350, 25);
        messageLabel.setFont(new Font("Poppins", Font.BOLD, 30));
        messageLabel.setForeground(Color.WHITE);

        username.setBounds(425, 100, 200, 25);
        password.setBounds(425, 150, 200, 25);

        AdminBtn.setBounds(425, 180, 100, 25);
        UserBtn.setBounds(525, 180, 150, 25);
        ButtonGroup group = new ButtonGroup();
        group.add(AdminBtn);
        group.add(UserBtn);

        LoginBtn.setBounds(420, 220, 100, 25);
        LoginBtn.addActionListener(this);

        SignupBtn.setBounds(525, 220, 100, 25);
        SignupBtn.addActionListener(this);
        
        frame.add(messageLabel);
        frame.add(usernameLabel);
        frame.add(username);
        frame.add(passwordLabel);
        frame.add(password);
        frame.add(AdminBtn);
        frame.add(UserBtn);
        frame.add(LoginBtn);
        frame.add(SignupBtn);
        
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(700, 450);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == LoginBtn) {
            String usernameField = username.getText();
            String passwordField = String.valueOf(password.getPassword());

            if (usernameField.isEmpty() || passwordField.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter your credential.");
                return;
            }

            boolean found = false;

            for (User user : users) {
                if (user.getUsername().equals(usernameField) && user.getPassword().equals(passwordField)) {
                    found = true;
                    JOptionPane.showMessageDialog(null, "Login successfully");
                    new ClimateAction();
                    frame.setVisible(false);
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(null, "Invalid login");
            }
        } else if (e.getSource() == SignupBtn) {
            new SignupFrame(users);
            frame.setVisible(false);

        }
    }

}