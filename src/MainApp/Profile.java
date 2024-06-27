/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainApp;

import javax.swing.*;
import java.awt.*;


public class Profile extends JFrame {
    
    private User user;
    JPanel panel;
    JLabel usernameLabel;
    JLabel emailLabel;
    JLabel phoneLabel;
    JLabel roleLabel;
    JTextField usernameField;
    JTextField emailField;
    JTextField phoneField;
    JTextField roleField;
    ClimateAction action;

   public Profile(User user,ClimateAction action) {
        this.user = user;
        this.action = action;
        
        setSize(400,250);
        setLocation(200,100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 16)); 
        
        usernameField = new JTextField(user.getUsername());
        usernameField.setEditable(false);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 16));
        
        panel.add(usernameLabel);
        panel.add(usernameField);
        
        emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        emailField = new JTextField(user.getEmail());
        emailField.setEditable(false);
        emailField.setFont(new Font("Arial", Font.PLAIN, 16));
        
        panel.add(emailLabel);
        panel.add(emailField);
        
        phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        phoneField = new JTextField(user.getPhoneNumber());
        phoneField.setEditable(false);
        phoneField.setFont(new Font("Arial", Font.PLAIN, 16));
        
        panel.add(phoneLabel);
        panel.add(phoneField);
        
        roleLabel = new JLabel("Role:");
        roleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        roleField = new JTextField(user.getisAdmin() ? "Admin" : "Normal User");
        roleField.setEditable(false);
        roleField.setFont(new Font("Arial", Font.PLAIN, 16)); 
        panel.add(roleLabel);
        panel.add(roleField);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
   
   }
}
