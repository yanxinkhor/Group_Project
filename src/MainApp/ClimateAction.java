package MainApp;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClimateAction {

    JFrame frame;
    JPanel sidebtn;
    ImageIcon imageIcon;
    JLabel imageLabel;
    ArrayList<User> users;

    public ClimateAction(boolean isAdmin, ArrayList<User> users) {
        this.users = users;
        
        frame = new JFrame("Climate Action");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 450);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setVisible(true);
        
        sidebtn = new JPanel();
        sidebtn.setBackground(new Color(0xff769c));
        sidebtn.setLayout(new GridLayout(0, 1));
        sidebtn.setPreferredSize(new Dimension(180,0));
        
        imageIcon = new ImageIcon(getClass().getResource("/Images/SDG_13.jpg"));
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(520, 420, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(resizedImage);
        
        imageLabel = new JLabel(imageIcon);
        frame.add(imageLabel, BorderLayout.CENTER);
        
        String[] buttons;
        if (isAdmin) {
            buttons = new String[]{
                "DASHBOARD","SEARCH", "VIEW", "ADD ACTION",
                "DELETE ACTION", "UPDATE ACTION", 
                "REAL-TIME DATA", "PROFILE", "LOGOUT"
            };
        } else {
            buttons = new String[]{
                "DASHBOARD", "SEARCH", "VIEW","NOTIFICATION", 
                "REAL-TIME DATA", "PROFILE", "LOGOUT"
            };
        }
        
        for (String buttonText : buttons) {
            JButton button = new JButton(buttonText);
            button.setForeground(Color.WHITE);
            button.setBackground(new Color(0x2E2B5F));
            button.setFocusPainted(false);
            button.setBorderPainted(false);
            button.addActionListener(new ButtonAction());
            sidebtn.add(button);
        }
        
        frame.add(sidebtn, BorderLayout.WEST);
        
    }
    
      private class ButtonAction implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String action = source.getText();
            switch (action) {
                case "DASHBOARD":
                    imageLabel.setVisible(true);
                    break;
                case "SEARCH":
                    break;
                case "VIEW":
                    imageLabel.setVisible(false);
                    break;
                case "ADD ACTION":
                    break;
                case "DELETE ACTION":
                    break;
                case "UPDATE ACTION":
                    break;
                case "REAL-TIME DATA":
                    break;
                case "PROFILE":
                    break;
                case "LOGOUT":
                   frame.dispose();
                   new LoginFrame(users);
                   break;

                default:
                    
                    break;
            }
        }
    }
}


