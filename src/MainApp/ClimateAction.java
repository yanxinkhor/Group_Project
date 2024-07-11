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
    Profile profile;
    User UserProfile;
    ArrayList<Add> countryList;
    

    public ClimateAction(boolean isAdmin, ArrayList<User> users, User UserProfile,ArrayList<Add> countryList ) {
        this.users = users;
        this.UserProfile = UserProfile;
        this.countryList = countryList;

        frame = new JFrame("Climate Action");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(897, 545);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        sidebtn = new JPanel();
        sidebtn.setBackground(new Color(0xff769c));
        sidebtn.setLayout(new GridLayout(0, 1));
        sidebtn.setPreferredSize(new Dimension(180, 0));

        imageIcon = new ImageIcon(getClass().getResource("/Images/SDG_13.jpg"));

        imageLabel = new JLabel(imageIcon);
        frame.add(imageLabel, BorderLayout.CENTER);

        String[] buttons;

        if (isAdmin) {
            buttons = new String[]{
                "DASHBOARD", "VIEW",
                "EMERGENCY HOTLINE", "USER FEEDBACK", "PROFILE", "LOGOUT"
            };
        } else {
            buttons = new String[]{
                "DASHBOARD", "VIEW",
                "EMERGENCY HOTLINE", "PROFILE", "SHARE", "LOGOUT"
            };
        }

        for (String btn : buttons) {
            JButton button = new JButton(btn);
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

            if (profile != null) {
                profile.dispose();
                profile= null;
            }

            switch (action) {

                case "VIEW":
                    frame.dispose();
                    View ViewFrame = new View(UserProfile, ClimateAction.this, countryList);
                    ViewFrame.setVisible(true);
                    break;

                case "EMERGENCY HOTLINE":
                    new Emergency();
                    break;

                case "PROFILE":
                    if (UserProfile != null) {
                        profile = new Profile(UserProfile, ClimateAction.this);
                    }
                    break;
                case "USER FEEDBACK":
                    break;
                case "SHARE":
                    new Share(ClimateAction.this);
                    break;

                case "LOGOUT":
                    frame.setVisible(false);
                    new LoginFrame(users,countryList);
                    break;

            }
        }
    }

    public JFrame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Add> countryList = new ArrayList<>();
        
        new LoginFrame(users, countryList);

    }

}
