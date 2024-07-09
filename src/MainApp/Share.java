package MainApp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Share extends JFrame {

    private JTextArea SharingBox;
    private JButton shareButton;
    private JButton backButton;
    private ClimateAction action;

    public Share(ClimateAction action) {
        this.action = action;

        setTitle("Share your experience");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 300);
        setLocation(450, 220);
        setLayout(null);

        JLabel label = new JLabel("Leave your experience here:");
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setBounds(100, 10, 230, 25);
        add(label);
        
        SharingBox = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(SharingBox);
        scrollPane.setBounds(50, 40, 300, 100);
        add(scrollPane);

        shareButton = new JButton("Share");
        shareButton.setBounds(110,170,80,30);
        backButton = new JButton("Back");
        backButton.setBounds(200,170,80,30);
        
        shareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String experience = SharingBox.getText();
                if (experience.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(Share.this, "Please enter your comments.",
                            "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    
                    JOptionPane.showMessageDialog(Share.this, "Thank you for your feedback!", 
                            "Info", JOptionPane.INFORMATION_MESSAGE);
                    SharingBox.setText("");
                }
            }
        });
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Share.this.dispose();
            }
        });
        
        add(shareButton);
        add(backButton);
        setVisible(true);
    }
}
