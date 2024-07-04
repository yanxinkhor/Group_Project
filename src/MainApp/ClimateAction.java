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
    Profile profileWindow;
    User UserProfile;

    public ClimateAction(boolean isAdmin, ArrayList<User> users, User UserProfile) {
        this.users = users;
        this.UserProfile = UserProfile;

        frame = new JFrame("Climate Action");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(897, 545);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setLocation(150, 100);
        frame.setVisible(true);

        sidebtn = new JPanel();
        sidebtn.setLayout(new GridLayout(0, 1));
        sidebtn.setPreferredSize(new Dimension(180, 0));

        imageIcon = new ImageIcon(getClass().getResource("/Images/SDG_13.jpg"));

        imageLabel = new JLabel(imageIcon);
        frame.add(imageLabel, BorderLayout.CENTER);

        String[] buttons;

        buttons = new String[]{
            "DASHBOARD", "VIEW",
            "REAL-TIME DATA", "PROFILE", "LOGOUT"
        };

        for (String Allbutton : buttons) {
            JButton button = new JButton(Allbutton);
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

            if (profileWindow != null) {
                profileWindow.dispose();
                profileWindow = null;
            }

            switch (action) {
                case "DASHBOARD":
                    imageLabel.setVisible(true);

                    break;
                case "SEARCH":
                    break;
                case "VIEW":
                    frame.dispose();
                    View ViewFrame = new View(UserProfile, ClimateAction.this);
                    ViewFrame.setVisible(true);
                    break;

                case "REAL-TIME DATA":
                    break;

                case "PROFILE":
                    if (UserProfile != null) {
                        profileWindow = new Profile(UserProfile, ClimateAction.this);
                    }
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
    
    public JFrame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        new LoginFrame(users);
    }

}
