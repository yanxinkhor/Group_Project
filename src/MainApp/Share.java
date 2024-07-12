package MainApp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Share extends JFrame {

    JTextField SharingBox;
    JTextField requestResource;
    JButton shareButton;
    JButton ViewButton;
    ArrayList<String> emergencyList;
    ArrayList<String> resourceList;
    ClimateAction action;
    User user;

    public Share(boolean isAdmin, ClimateAction action, User user, ArrayList<String> emergencyList, ArrayList<String> resourceList) {
        this.action = action;
        this.user = user;
        this.emergencyList = emergencyList;
        this.resourceList = resourceList;

        setTitle("Share your experience");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        JLabel label = new JLabel("Share your emergencies with us");
        label.setFont(new Font("Poppin", Font.BOLD, 16));
        label.setBounds(50, 10, 250, 25);
        add(label);

        SharingBox = new JTextField();
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
        shareButton.setBounds(160, 220, 80, 30);
        ViewButton = new JButton("View");
        ViewButton.setBounds(160, 220, 80, 30);

        shareButton.addActionListener(new Sharebtn());
        ViewButton.addActionListener(new ViewBtn());

        if (isAdmin) {
            SharingBox.setEnabled(false);
            requestResource.setEnabled(false);
            shareButton.setVisible(false);
        } else {
            ViewButton.setVisible(false);
        }

        add(shareButton);
        add(ViewButton);
        setVisible(true);
    }

    private class Sharebtn implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String experience = SharingBox.getText();
            String resource = requestResource.getText();
        

            if (!experience.trim().isEmpty() && !resource.trim().isEmpty()) {
                String username = "Username: " + user.getUsername();
                String emergency = "Emergency: " + experience;
                String resourceNeed = "Resource Needed: " + resource;
                emergencyList.add(username +"\n"+emergency);
                resourceList.add(resourceNeed);
              

                JOptionPane.showMessageDialog(Share.this, "Your request has been submitted",
                        "Info", JOptionPane.INFORMATION_MESSAGE);
                SharingBox.setText("");
                requestResource.setText("");
            } else {
                JOptionPane.showMessageDialog(Share.this, "Please enter both the description and resource request.",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            }

        }

    }

    private class ViewBtn implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Share.this.setVisible(false);

            JFrame frame = new JFrame();
            frame.setResizable(false);
            frame.setSize(450, 300);
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            JPanel itemsPanel = new JPanel();
            itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));
            StringBuilder displayText = new StringBuilder();

            for (int i = 0; i < emergencyList.size(); i++) {
                String emergency = emergencyList.get(i);
                String resource = resourceList.get(i);

                displayText.append(emergency).append("\n")
                        .append(resource).append("\n\n");
            }

            JTextArea displayArea = new JTextArea(displayText.toString());
            displayArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(displayArea);
            itemsPanel.add(scrollPane);

            JScrollPane scroll = new JScrollPane(itemsPanel);
            frame.add(scroll, BorderLayout.CENTER);

            JButton backButton = new JButton("Back");
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    Share.this.setVisible(true);
                }
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(backButton);
            frame.add(buttonPanel, BorderLayout.SOUTH);
            frame.add(itemsPanel, BorderLayout.CENTER);

            frame.setVisible(true);
        }
    }

}
