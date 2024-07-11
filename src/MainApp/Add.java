package MainApp;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add {

    private String country;
    private int numOfDeaths;
    private int numOfInjured;
    private int missingPerson;
    private int totalAffected;
    private String disasterType;

    public Add(String country, int numOfDeaths, int numOfInjured, int missingPerson, String disasterType) {
        this.country = country;
        this.numOfDeaths = numOfDeaths;
        this.numOfInjured = numOfInjured;
        this.missingPerson = missingPerson;
        this.totalAffected = numOfDeaths + numOfInjured + missingPerson;
        this.disasterType = disasterType;

    }

    public String getCountry() {
        return country;
    }

    public int getNumOfDeaths() {
        return numOfDeaths;
    }

    public int getNumOfInjured() {
        return numOfInjured;
    }

    public int getMissingPerson() {
        return missingPerson;
    }

    public int getTotalAffected() {
        return totalAffected;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static Add searchCountryInfo(ArrayList<Add> countryList, String countryName) {
        for (Add addInfo : countryList) {
            String country = addInfo.getCountry();
            if (country != null && country.equalsIgnoreCase(countryName)) {
                return addInfo;
            }
        }
        return null;
    }

    public void addInfoToCountryList(ArrayList<Add> countryList) {
        countryList.add(this);
    }
    
    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType;
    }

    public void setNumOfDeaths(int numOfDeaths) {
        this.numOfDeaths = numOfDeaths;
    }

    public void setNumOfInjured(int numOfInjured) {
        this.numOfInjured = numOfInjured;
    }

    public void setMissingPerson(int missingPerson) {
        this.missingPerson = missingPerson;
    }


    public static Add showAddInfoPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel countryLabel = new JLabel("Country Name:");
        countryLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField countryField = new JTextField();
        countryField.setFont(new Font("Arial", Font.PLAIN, 16));

        panel.add(countryLabel);
        panel.add(countryField);

        JLabel disasterTypeLabel = new JLabel("Disaster Type:");
        disasterTypeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        String[] disasterTypes = {"Select Disaster Type", "Earthquake", "Flood",
            "Hurricane", "Wildfire", "Tornado",
            "Tsunami", "Volcanic Eruption", "Landslide", "Drought"};

        JComboBox<String> disasterTypeDropdown = new JComboBox<>(disasterTypes);
        disasterTypeDropdown.setFont(new Font("Arial", Font.PLAIN, 16));

        panel.add(disasterTypeLabel);
        panel.add(disasterTypeDropdown);

        JLabel numOfDeathsLabel = new JLabel("Deaths: ");
        numOfDeathsLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField numOfDeathsField = new JTextField();
        numOfDeathsField.setFont(new Font("Arial", Font.PLAIN, 16));

        panel.add(numOfDeathsLabel);
        panel.add(numOfDeathsField);

        JLabel numOfInjuredLabel = new JLabel("Injured: ");
        numOfInjuredLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField numOfInjuredField = new JTextField();
        numOfInjuredField.setFont(new Font("Arial", Font.PLAIN, 16));

        panel.add(numOfInjuredLabel);
        panel.add(numOfInjuredField);

        JLabel missingPersonLabel = new JLabel("Missing: ");
        missingPersonLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField missingPersonField = new JTextField();
        missingPersonField.setFont(new Font("Arial", Font.PLAIN, 16));

        panel.add(missingPersonLabel);
        panel.add(missingPersonField);

        int option = JOptionPane.showConfirmDialog(null, panel, "Enter Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            String country = countryField.getText().trim();
            String numOfDeathsStr = numOfDeathsField.getText().trim();
            String numOfInjuredStr = numOfInjuredField.getText().trim();
            String missingPersonStr = missingPersonField.getText().trim();
            String disasterType = (String) disasterTypeDropdown.getSelectedItem();

            if (country.isEmpty() || disasterType.equals("Select Disaster Type") || numOfDeathsStr.isEmpty() || numOfInjuredStr.isEmpty() || missingPersonStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields must be filled", "Input Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            try {
                int numOfDeaths = Integer.parseInt(numOfDeathsStr);
                int numOfInjured = Integer.parseInt(numOfInjuredStr);
                int missingPerson = Integer.parseInt(missingPersonStr);

                return new Add(country, numOfDeaths, numOfInjured, missingPerson, disasterType);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers for deaths, injured, and missing persons", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }

    public static void showCountryInfoPanel(Add countryInfo) {
        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel countryLabel = new JLabel("Country Name: ");
        JTextField countryField = new JTextField(countryInfo.getCountry());
        countryField.setEditable(false);
        panel.add(countryLabel);
        panel.add(countryField);

        JLabel disasterTypeLabel = new JLabel("Disaster Type: ");
        JTextField typeField = new JTextField(countryInfo.getDisasterType());
        typeField.setEditable(false);
        panel.add(disasterTypeLabel);
        panel.add(typeField);

        JLabel numOfDeathsLabel = new JLabel("Number of Deaths: ");
        JTextField numOfDeathField = new JTextField(String.valueOf(countryInfo.getNumOfDeaths()));
        numOfDeathField.setEditable(false);
        panel.add(numOfDeathsLabel);
        panel.add(numOfDeathField);

        JLabel numOfInjuredLabel = new JLabel("Number of Injured: ");
        JTextField numOfInjuredField = new JTextField(String.valueOf(countryInfo.getNumOfInjured()));
        numOfInjuredField.setEditable(false);
        panel.add(numOfInjuredLabel);
        panel.add(numOfInjuredField);

        JLabel missingPersonLabel = new JLabel("Number of Missing: ");
        JTextField missingPersonField = new JTextField(String.valueOf(countryInfo.getMissingPerson()));
        missingPersonField.setEditable(false);
        panel.add(missingPersonLabel);
        panel.add(missingPersonField);

        JLabel totalAffectedLabel = new JLabel("Total Affected: ");
        JTextField totalAffectedField = new JTextField(String.valueOf(countryInfo.getTotalAffected()));
        totalAffectedField.setEditable(false);
        panel.add(totalAffectedLabel);
        panel.add(totalAffectedField);

        JButton edit = new JButton("Edit");
        edit.setBounds(12, 30, 80, 30);
        JButton update = new JButton("Update");
        update.setBounds(12, 30, 80, 30);

        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countryField.setEditable(true);
                typeField.setEditable(true);
                numOfDeathField.setEditable(true);
                numOfInjuredField.setEditable(true);
                missingPersonField.setEditable(true);
                totalAffectedField.setEditable(false);
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String country = countryField.getText().trim();
                    String disasterType = typeField.getText().trim();
                    int numOfDeaths = Integer.parseInt(numOfDeathField.getText().trim());
                    int numOfInjured = Integer.parseInt(numOfInjuredField.getText().trim());
                    int missingPerson = Integer.parseInt(missingPersonField.getText().trim());
                    int totalAffected = numOfDeaths + numOfInjured + missingPerson;

                    // Update the countryInfo object
                    countryInfo.setCountry(country);
                    countryInfo.setDisasterType(disasterType);
                    countryInfo.setNumOfDeaths(numOfDeaths);
                    countryInfo.setNumOfInjured(numOfInjured);
                    countryInfo.setMissingPerson(missingPerson);

                    // Update the total affected field
                    totalAffectedField.setText(String.valueOf(totalAffected));

                    JOptionPane.showMessageDialog(null, "Information updated successfully", "Update Successful", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers for deaths, injured, and missing persons", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(edit);
        panel.add(update);

        JOptionPane.showMessageDialog(null, panel, "Country Information", JOptionPane.INFORMATION_MESSAGE);
    }

}
