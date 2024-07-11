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
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel label = new JLabel("Share your experience with us");
        label.setFont(new Font("Poppin", Font.BOLD, 16));
        label.setBounds(90, 10, 250, 25);
        add(label);

        SharingBox = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(SharingBox);
        scrollPane.setBounds(50, 60, 300, 120);
        add(scrollPane);

        shareButton = new JButton("Share");
        shareButton.setBounds(120, 200, 80, 30);
        backButton = new JButton("Back");
        backButton.setBounds(200, 200, 80, 30);

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
            if (experience.trim().isEmpty()) {
                JOptionPane.showMessageDialog(Share.this, "Please enter your comments.",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(Share.this, "Thank you for your feedback!",
                        "Info", JOptionPane.INFORMATION_MESSAGE);
                SharingBox.setText("");
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
