package MainApp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Share extends JFrame {

    private JTextArea SharingBox;
    private JTextField requestResource;
    private JButton shareButton;
    private JButton backButton;
    private ClimateAction action;

    public Share(ClimateAction action) {
        this.action = action;

        setTitle("Share your experience");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel label = new JLabel("Share your emergencies with us");
        label.setFont(new Font("Poppin", Font.BOLD, 16));
        label.setBounds(50, 10, 250, 25);
        add(label);

        SharingBox = new JTextArea();
        SharingBox.setLineWrap(true);
        SharingBox.setWrapStyleWord(true);
        SharingBox.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(SharingBox);
        scrollPane.setBounds(50, 40, 300, 100);
        add(scrollPane);

        JLabel requestLabel = new JLabel("Resource needed");
        requestLabel.setFont(new Font("Poppins", Font.BOLD, 16));
        requestLabel.setBounds(50, 150, 300, 30);
        add(requestLabel);

        requestResource = new JTextField();
        requestResource.setBounds(50, 180, 300, 30);
        add(requestResource);

        shareButton = new JButton("Share");
        shareButton.setBounds(120, 220, 80, 30);
        backButton = new JButton("Back");
        backButton.setBounds(200, 220, 80, 30);

        shareButton.addActionListener(new Sharebtn());
        backButton.addActionListener(new BackBtn());

        add(shareButton);
        add(backButton);
        setVisible(true);
    }

    private class Sharebtn implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String experience = SharingBox.getText();
            String resource = requestResource.getText();
            if (experience.trim().isEmpty() && resource.trim().isEmpty()) {
                JOptionPane.showMessageDialog(Share.this, "Please enter the description and resource request.",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (experience.trim().isEmpty()) {
                JOptionPane.showMessageDialog(Share.this, "Please enter your emergency.",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (resource.trim().isEmpty()) {
                JOptionPane.showMessageDialog(Share.this, "Please enter your resource request.",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(Share.this, "Thank you for your request!",
                        "Info", JOptionPane.INFORMATION_MESSAGE);
                SharingBox.setText("");
                requestResource.setText("");
            }
        }
    }

    private class BackBtn implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Share.this.dispose();
        }
    }
}
