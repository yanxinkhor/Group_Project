package MainApp;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame implements ActionListener {

    private User UserProfile;
    private ArrayList<User> users;

    JFrame frame;
    JButton LoginBtn;
    JButton SignupBtn;
    JTextField username;
    JPasswordField password;
    JLabel usernameLabel;
    JLabel passwordLabel;
    ImageIcon imageIcon;
    JLabel imgLabel;
    JRadioButton AdminBtn;
    JRadioButton UserBtn;
    JCheckBox showPassword;

    public LoginFrame(ArrayList<User> users) {

        this.users = users;
        frame = new JFrame();

        LoginBtn = new JButton("Login");
        SignupBtn = new JButton("Signup");
        username = new JTextField();
        password = new JPasswordField();
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        imageIcon = new ImageIcon(getClass().getResource("/Images/user.png"));
        AdminBtn = new JRadioButton("Admin");
        UserBtn = new JRadioButton("Normal User");

        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);

        imgLabel = new JLabel(imageIcon);
        imgLabel.setBounds(60, 80, 200, 200);
        frame.add(imgLabel);

        usernameLabel.setBounds(350, 100, 75, 25);
        frame.add(usernameLabel);
        username.setBounds(425, 100, 200, 25);
        frame.add(username);

        passwordLabel.setBounds(350, 150, 75, 25);
        frame.add(passwordLabel);
        password.setBounds(425, 150, 200, 25);
        password.setEchoChar('*');
        frame.add(password);

        showPassword = new JCheckBox();
        showPassword.setBounds(625, 150, 150, 25);
        showPassword.addActionListener(this);
        frame.add(showPassword);

        AdminBtn.setBounds(425, 180, 100, 25);
        UserBtn.setBounds(525, 180, 150, 25);
        ButtonGroup group = new ButtonGroup();
        group.add(AdminBtn);
        group.add(UserBtn);
        frame.add(AdminBtn);
        frame.add(UserBtn);

        LoginBtn.setBounds(420, 220, 100, 25);
        LoginBtn.addActionListener(this);
        frame.add(LoginBtn);

        SignupBtn.setBounds(525, 220, 100, 25);
        SignupBtn.addActionListener(this);
        frame.add(SignupBtn);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(700, 450);
        frame.setLayout(null);
        frame.setLocation(280, 150);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == LoginBtn) {
            String usernameField = username.getText();
            String passwordField = String.valueOf(password.getPassword());

            if (!AdminBtn.isSelected() && !UserBtn.isSelected()) {
                JOptionPane.showMessageDialog(frame, "Please select Admin or User");
                return;
            }

            if (usernameField.isEmpty() || passwordField.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter your credential.");
                return;
            }

            boolean found = false;

            for (User user : users) {
                if (user.getUsername().equals(usernameField) && user.getPassword().equals(passwordField)) {
                    if (AdminBtn.isSelected() && user.getisAdmin()) {
                        found = true;
                        UserProfile = user;
                        JOptionPane.showMessageDialog(null, "Welcome Admin:" + user.getUsername());
                        new ClimateAction(true, users, UserProfile);
                        frame.dispose();
                        break;
                    } else if (UserBtn.isSelected() && !user.getisAdmin()) {
                        found = true;
                        UserProfile = user;
                        JOptionPane.showMessageDialog(null, "Welcome User:" + user.getUsername());
                        new ClimateAction(false, users, UserProfile);
                        frame.dispose();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "The role is mismatch");
                        return;
                    }
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(null, "Invalid login");
            }
        } else if (e.getSource() == showPassword) {

            if (showPassword.isSelected()) {
                password.setEchoChar((char) 0);
            } else {
                password.setEchoChar('*');
            }

        } else if (e.getSource() == SignupBtn) {
            new SignupFrame(users);
            frame.dispose();
        }
    }

}
