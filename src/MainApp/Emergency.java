package MainApp;

import javax.swing.*;
import java.awt.*;

public class Emergency extends JFrame {

    JPanel panel;
    JLabel policeAmbulanceLabel;
    JLabel fireBrigadeLabel;
    JLabel civilDefenseLabel;
    JLabel hospitalLabel;
    JLabel covid19Label;
    JLabel marineSearchAndRescueLabel;
    JLabel gasEmergencyLabel;
    JLabel electricityEmergencyLabel;
    JLabel waterEmergencyLabel;
    JLabel disasterReliefLabel;

    public Emergency() {
        setTitle("Emergency Hotlines");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(450, 220);

        panel = new JPanel(new GridLayout(8, 1, 10, 5));

        policeAmbulanceLabel = new JLabel("Police and Ambulance: 999");
        fireBrigadeLabel = new JLabel("Fire Brigade: 994");
        civilDefenseLabel = new JLabel("Civil Defense: 991");
        hospitalLabel = new JLabel("Hospital: 999");
        marineSearchAndRescueLabel = new JLabel("Marine Search and Rescue: +60 3167 0530");
        gasEmergencyLabel = new JLabel("Gas Emergency: 1-800-88-9119");
        waterEmergencyLabel = new JLabel("Water Emergency: 15300");
        disasterReliefLabel = new JLabel("Disaster Relief: 15999");

        Font font = new Font("Poppin", Font.PLAIN, 16);
        policeAmbulanceLabel.setFont(font);
        fireBrigadeLabel.setFont(font);
        civilDefenseLabel.setFont(font);
        hospitalLabel.setFont(font);
        marineSearchAndRescueLabel.setFont(font);
        gasEmergencyLabel.setFont(font);
        waterEmergencyLabel.setFont(font);
        disasterReliefLabel.setFont(font);

        panel.add(policeAmbulanceLabel);
        panel.add(fireBrigadeLabel);
        panel.add(civilDefenseLabel);
        panel.add(hospitalLabel);
        panel.add(marineSearchAndRescueLabel);
        panel.add(gasEmergencyLabel);
        panel.add(waterEmergencyLabel);
        panel.add(disasterReliefLabel);

        getContentPane().add(panel);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
