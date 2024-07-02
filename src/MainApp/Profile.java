/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Profile extends JFrame {
    
    private User user;
    JLabel usernameLabel;
    JLabel emailLabel;
    JLabel phoneLabel;
    JLabel roleLabel;
    JTextField usernameField;
    JTextField emailField;
    JTextField phoneField;
    JTextField roleField;
    ClimateAction action;
    JButton edit;
    JButton update;

   public Profile(User user,ClimateAction action) {
        this.user = user;
        this.action = action;
        
        setSize(400,250);
        setLocation(450,220);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        
        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(10, 10, 125, 25);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 16)); 
        
        usernameField = new JTextField(user.getUsername());
        usernameField.setBounds(150, 10, 200, 25);
        usernameField.setEditable(false);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 16));
        
        add(usernameLabel);
        add(usernameField);
        
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 50, 125, 25);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        emailField = new JTextField(user.getEmail());
        emailField.setBounds(150, 50, 200, 25);
        emailField.setEditable(false);
        emailField.setFont(new Font("Arial", Font.PLAIN, 16));
        
        add(emailLabel);
        add(emailField);
        
        phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(10, 90, 125, 25);
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        phoneField = new JTextField(user.getPhoneNumber());
        phoneField.setBounds(150, 90, 200, 25);
        phoneField.setEditable(false);
        phoneField.setFont(new Font("Arial", Font.PLAIN, 16));
        
        add(phoneLabel);
        add(phoneField);
        
        roleLabel = new JLabel("Role:");
        roleLabel.setBounds(10, 130, 125, 25);
        roleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        roleField = new JTextField(user.getisAdmin() ? "Admin" : "Normal User");
        roleField.setEditable(false);
        roleField.setBounds(150, 130, 200, 25);
        roleField.setFont(new Font("Arial", Font.PLAIN, 16)); 
        add(roleLabel);
        add(roleField);
        setVisible(true);
        
        edit = new JButton("Edit");
        edit.setBounds(150,170,80,30);
        edit.addActionListener(new editAction());
        add(edit);
        
        update = new JButton("Update");
        update.setBounds(250, 170, 80, 30);
        update.addActionListener(new updateAction());
        update.setEnabled(false);  // Initially disabled
        add(update);
   
   }
   private class editAction implements ActionListener{
       public void actionPerformed(ActionEvent e) {
            usernameField.setEditable(true);
            emailField.setEditable(true);
            phoneField.setEditable(true);
            
            update.setEnabled(true);
       }
   }
   
   private class updateAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            user.setUsername(usernameField.getText());
            user.setEmail(emailField.getText());
            user.setPhoneNumber(phoneField.getText());
            JOptionPane.showMessageDialog(Profile.this, "Profile updated successfully");
            
            usernameField.setEditable(false);
            emailField.setEditable(false);
            phoneField.setEditable(false);
            update.setEnabled(false);
        }
   }
       public boolean isAdmin() {
        return user.isAdmin();
    }
   
}
