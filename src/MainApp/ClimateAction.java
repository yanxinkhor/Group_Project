package MainApp;

import javax.swing.*;
import java.awt.*;

public class ClimateAction {

    JFrame frame;
    JPanel sidebtn;
    ImageIcon imageIcon;
    JLabel imageLabel;
    

    public ClimateAction() {
        frame = new JFrame("Climate Action");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 450);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        sidebtn = new JPanel();
        sidebtn.setBackground(new Color(0xff769c));
        sidebtn.setLayout(new GridLayout(0, 1));
        sidebtn.setPreferredSize(new Dimension(180,0));
        
        imageIcon = new ImageIcon(getClass().getResource("/Images/SDG13.1.gif"));
        
        imageLabel = new JLabel(imageIcon);
        frame.add(imageLabel, BorderLayout.CENTER);
        
        String[] buttons = {
            "SEARCH","VIEW","ADD ACTION",
            "DELETE ACTION","UPDATE ACTION","NOTIFICATION",
            "REAL-TIME DATA","PROFILE","LOGOUT"
        };
        
        for (String buttonText : buttons) {
            JButton button = new JButton(buttonText);
            button.setForeground(Color.WHITE);
            button.setBackground(new Color(0x2E2B5F));
            button.setFocusPainted(false);
            button.setBorderPainted(false);
            sidebtn.add(button);
        }
        
        frame.add(sidebtn, BorderLayout.WEST);
        
    }
}
