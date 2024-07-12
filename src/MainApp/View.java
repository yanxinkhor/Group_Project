package MainApp;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class View extends javax.swing.JFrame {

    private User userProfile;
    private ClimateAction climateAction;
    private ArrayList<Add> countryList = new ArrayList<>();

    public View(User userProfile, ClimateAction action, ArrayList<Add> countryList) {
        this.userProfile = userProfile;
        this.climateAction = action;
        this.countryList = countryList;

        initComponents();
        loadContentIntoTextArea("src/textfiles/jTextArea1.txt", jTextArea1);
        loadContentIntoTextArea("src/textfiles/jTextArea2.txt", jTextArea2);
        loadContentIntoTextArea("src/textfiles/jTextArea3.txt", jTextArea3);
        loadContentIntoTextArea("src/textfiles/jTextArea4.txt", jTextArea4);
        loadContentIntoTextArea("src/textfiles/jTextArea5.txt", jTextArea5);
        loadContentIntoTextArea("src/textfiles/jTextArea6.txt", jTextArea6);
        loadContentIntoTextArea("src/textfiles/jTextArea7.txt", jTextArea7);
        loadContentIntoTextArea("src/textfiles/jTextArea8.txt", jTextArea8);
        loadContentIntoTextArea("src/textfiles/jTextArea9.txt", jTextArea9);
        loadContentIntoTextArea("src/textfiles/jTextArea10.txt", jTextArea10);
        loadContentIntoTextArea("src/textfiles/jTextArea11.txt", jTextArea11);
        loadContentIntoTextArea("src/textfiles/jTextArea12.txt", jTextArea12);
        loadContentIntoTextArea("src/textfiles/jTextArea13.txt", jTextArea13);
        loadContentIntoTextArea("src/textfiles/jTextArea14.txt", jTextArea14);
        loadContentIntoTextArea("src/textfiles/jTextArea15.txt", jTextArea15);
        setupUIBasedOnUserRole();

        ButtonSave.setEnabled(false);
        NewsSave.setEnabled(false);
        SaveNo.setEnabled(false);
        SaveText.setEnabled(false);
        SaveText2.setEnabled(false);
        SaveText3.setEnabled(false);

        searchinfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String country = JOptionPane.showInputDialog("Enter Country Name: ");

                if (country == null) {
                    JOptionPane.showMessageDialog(null, "You've cancelled the action.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                } else if (!country.isEmpty()) {
                    Add result = Add.searchCountryInfo(countryList, country);
                    if (result != null) {
                        Add.showCountryInfoPanel(result,userProfile);
                    } else {
                        JOptionPane.showMessageDialog(null, "No information found for country: " + country,
                                "Search Result", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid country name.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        AddInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Add info = Add.showAddInfoPanel();
                if (info != null) {
                    info.addInfoToCountryList(countryList);
                    JOptionPane.showMessageDialog(null, "Information added successfully");
                }
            }
        });

        EditText2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jTextArea10.setEditable(true);
                SaveText2.setEnabled(true);
            }
        });

        SaveText2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String editedText10 = jTextArea10.getText();
                jTextArea10.setText(editedText10);
                saveContentToFile("src/textfiles/jTextArea10.txt", jTextArea10);
                SaveText2.setEnabled(false);
                JOptionPane.showMessageDialog(View.this, "Changes saved.");
            }
        });

        EditText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jTextArea9.setEditable(true);
                jTextArea14.setEditable(true);
                SaveText.setEnabled(true);
            }
        });

        SaveText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String editedText9 = jTextArea9.getText();
                jTextArea9.setText(editedText9);
                jTextArea9.setEditable(false);
                String editedText14 = jTextArea14.getText();
                jTextArea14.setText(editedText14);
                jTextArea14.setEditable(false);
                saveContentToFile("src/textfiles/jTextArea9.txt", jTextArea9);
                saveContentToFile("src/textfiles/jTextArea14.txt", jTextArea14);
                SaveText.setEnabled(false);
                JOptionPane.showMessageDialog(View.this, "Changes saved.");
            }
        });

        EditText3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jTextArea11.setEditable(true);
                jTextArea15.setEditable(true);
                SaveText3.setEnabled(true);
            }
        });

        SaveText3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String editedText11 = jTextArea11.getText();
                jTextArea11.setText(editedText11);
                jTextArea11.setEditable(false);
                String editedText15 = jTextArea15.getText();
                jTextArea15.setText(editedText15);
                jTextArea15.setEditable(false);
                saveContentToFile("src/textfiles/jTextArea11.txt", jTextArea11);
                saveContentToFile("src/textfiles/jTextArea15.txt", jTextArea15);
                SaveText3.setEnabled(false);
                JOptionPane.showMessageDialog(View.this, "Changes saved.");
            }
        });

        EditNo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jTextArea2.setEditable(true);
                jTextArea6.setEditable(true);
                jTextArea7.setEditable(true);
                jTextArea8.setEditable(true);
                jTextArea13.setEditable(true);
                SaveNo.setEnabled(true);
            }
        });
        SaveNo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String editedText2 = jTextArea2.getText();
                jTextArea2.setText(editedText2);
                jTextArea2.setEditable(false);
                String editedText6 = jTextArea6.getText();
                jTextArea6.setText(editedText6);
                jTextArea6.setEditable(false);
                String editedText7 = jTextArea7.getText();
                jTextArea7.setText(editedText7);
                jTextArea7.setEditable(false);
                String editedText8 = jTextArea8.getText();
                jTextArea8.setText(editedText8);
                jTextArea8.setEditable(false);
                String editedText13 = jTextArea13.getText();
                jTextArea13.setText(editedText13);
                jTextArea13.setEditable(false);
                saveContentToFile("src/textfiles/jTextArea2.txt", jTextArea2);
                saveContentToFile("src/textfiles/jTextArea6.txt", jTextArea6);
                saveContentToFile("src/textfiles/jTextArea7.txt", jTextArea7);
                saveContentToFile("src/textfiles/jTextArea8.txt", jTextArea8);
                saveContentToFile("src/textfiles/jTextArea13.txt", jTextArea13);
                SaveNo.setEnabled(false);
                JOptionPane.showMessageDialog(View.this, "Changes saved.");
            }
        });

        NewsEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jTextArea1.setEditable(true);
                jTextArea4.setEditable(true);
                jTextArea5.setEditable(true);
                jTextArea3.setEditable(true);
                NewsSave.setEnabled(true);
            }
        });
        NewsSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String editedText1 = jTextArea1.getText();
                jTextArea1.setText(editedText1);
                jTextArea1.setEditable(false);
                String editedText4 = jTextArea4.getText();
                jTextArea4.setEditable(false);
                jTextArea4.setText(editedText4);
                String editedText5 = jTextArea5.getText();
                jTextArea5.setEditable(false);
                jTextArea5.setText(editedText5);
                String editedText3 = jTextArea3.getText();
                jTextArea3.setEditable(false);
                jTextArea3.setText(editedText3);
                saveContentToFile("src/textfiles/jTextArea1.txt", jTextArea1);
                saveContentToFile("src/textfiles/jTextArea4.txt", jTextArea4);
                saveContentToFile("src/textfiles/jTextArea5.txt", jTextArea5);
                saveContentToFile("src/textfiles/jTextArea3.txt", jTextArea3);
                NewsSave.setEnabled(false);
                JOptionPane.showMessageDialog(View.this, "Changes saved.");
            }
        });

        ButtonEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea12.setEditable(true);
                ButtonSave.setEnabled(true);
            }
        });

        ButtonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String editedText = jTextArea12.getText();
                jTextArea12.setText(editedText);
                jTextArea12.setEditable(false);
                ButtonSave.setEnabled(false);
                saveContentToFile("src/textfiles/jTextArea12.txt", jTextArea12);
                JOptionPane.showMessageDialog(View.this, "Changes saved.");
            }
        });

    }

    private void setupUIBasedOnUserRole() {
        if (userProfile != null) {
            boolean isAdmin = userProfile.getisAdmin();
            if (!isAdmin) {
                ButtonEdit.setVisible(false);
                ButtonSave.setVisible(false);
                NewsEdit.setVisible(false);
                NewsSave.setVisible(false);
                EditNo.setVisible(false);
                SaveNo.setVisible(false);
                EditText.setVisible(false);
                SaveText.setVisible(false);
                EditText2.setVisible(false);
                SaveText2.setVisible(false);
                EditText3.setVisible(false);
                SaveText3.setVisible(false);
                AddInfo.setVisible(false);
            }
        }
    }

    public static void loadContentIntoTextArea(String filePath, JTextArea textArea) {
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String newText = fileContent.toString().trim();
        String currentText = textArea.getText().trim();

        if (!newText.equals(currentText)) {
            textArea.setText(newText);
        }
    }

    public static void saveContentToFile(String filePath, JTextArea textArea) {
        String contentToSave = textArea.getText();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(contentToSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BackArrow = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextArea12 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jPanel14 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        ButtonEdit = new javax.swing.JButton();
        ButtonSave = new javax.swing.JButton();
        NewsEdit = new javax.swing.JButton();
        NewsSave = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jPanel18 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTextArea13 = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel17 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea8 = new javax.swing.JTextArea();
        jPanel13 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        EditNo = new javax.swing.JButton();
        SaveNo = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        try {
            AddInfo =(javax.swing.JButton)java.beans.Beans.instantiate(getClass().getClassLoader(), "MainApp.View_AddInfo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        searchinfo = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextArea10 = new javax.swing.JTextArea();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        EditText2 = new javax.swing.JButton();
        SaveText2 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea9 = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        EditText = new javax.swing.JButton();
        SaveText = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea14 = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextArea11 = new javax.swing.JTextArea();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextArea15 = new javax.swing.JTextArea();
        EditText3 = new javax.swing.JButton();
        SaveText3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(700, 450));
        setResizable(false);
        setSize(new java.awt.Dimension(1199, 811));

        jPanel1.setBackground(new java.awt.Color(72, 119, 62));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("13.1");

        jPanel2.setBackground(new java.awt.Color(72, 119, 62));
        jPanel2.setPreferredSize(new java.awt.Dimension(30, 30));

        BackArrow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BackArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back arrow.png"))); // NOI18N
        BackArrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackArrowMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackArrowMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackArrowMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackArrow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackArrow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GOAL13TARGET131e.png"))); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(72, 119, 62));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("The goal is to Strengthen resilience and adaptive capacity to climate-related hazards and natural disasters in all countries");

        jTabbedPane1.setBackground(new java.awt.Color(72, 119, 62));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(72, 119, 62), 2));

        jTextArea12.setEditable(false);
        jTextArea12.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea12.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea12.setTabSize(0);
        jTextArea12.setText("Climate change is a real and undeniable threat to our entire civilization.The effects are already visible and will be catastrophic \nunless we act now. Through education, innovation and adherence to our climate commitments, we can make the necessary\nchanges to protect the planet. These changes also provide huge opportunities to modernize our infrastructure which \nwill create new jobs and promote greater prosperity across the globe.");
        jTextArea12.setAutoscrolls(false);
        jScrollPane12.setViewportView(jTextArea12);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(72, 119, 62));
        jLabel1.setText("NEWS");

        jPanel3.setBackground(new java.awt.Color(220, 217, 217));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.setMaximumSize(new java.awt.Dimension(167, 239));
        jPanel3.setMinimumSize(new java.awt.Dimension(167, 239));
        jPanel3.setPreferredSize(new java.awt.Dimension(167, 239));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Bees.png"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(72, 119, 62), 2));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(220, 217, 217));
        jTextArea1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setText("WHY BEES AND OTHER \nPOLLINATORS MIGHT\nBE THE MOST....");
        jScrollPane1.setViewportView(jTextArea1);

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("May 20, 2024");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        jPanel15.setBackground(new java.awt.Color(220, 217, 217));
        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel15.setMaximumSize(new java.awt.Dimension(167, 239));
        jPanel15.setMinimumSize(new java.awt.Dimension(167, 239));
        jPanel15.setPreferredSize(new java.awt.Dimension(167, 239));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/2024--scaled.jpg"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(72, 119, 62), 2));

        jTextArea4.setEditable(false);
        jTextArea4.setBackground(new java.awt.Color(220, 217, 217));
        jTextArea4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        jTextArea4.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea4.setText("2023: A YEAR IN REVIEW\nFOR THE GLOBAL GOALS");
        jScrollPane4.setViewportView(jTextArea4);

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("December 14, 2023");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap())
        );

        jPanel16.setBackground(new java.awt.Color(220, 217, 217));
        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel16.setMaximumSize(new java.awt.Dimension(167, 239));
        jPanel16.setMinimumSize(new java.awt.Dimension(167, 239));
        jPanel16.setPreferredSize(new java.awt.Dimension(167, 239));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/HQCR_presenting.jpg"))); // NOI18N
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(72, 119, 62), 2));

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("February 11, 2023");

        jTextArea5.setEditable(false);
        jTextArea5.setBackground(new java.awt.Color(220, 217, 217));
        jTextArea5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        jTextArea5.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea5.setText("FROM ANTS TO ECO-\nSYSTEMS: ONE WOMAN'S\nLIFE IN SCIENCE");
        jScrollPane5.setViewportView(jTextArea5);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(jLabel13)
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(220, 217, 217));
        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel14.setMaximumSize(new java.awt.Dimension(167, 239));
        jPanel14.setMinimumSize(new java.awt.Dimension(167, 239));
        jPanel14.setPreferredSize(new java.awt.Dimension(167, 239));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/85A9878-scaled.jpg"))); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(72, 119, 62), 2));

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("December 31, 2022");

        jTextArea3.setEditable(false);
        jTextArea3.setBackground(new java.awt.Color(220, 217, 217));
        jTextArea3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        jTextArea3.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea3.setText("WORLD MAYORS GATHER\nIN BUENOS AIRES TO\nANNOUNCE...");
        jScrollPane3.setViewportView(jTextArea3);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        ButtonEdit.setBackground(new java.awt.Color(72, 119, 62));
        ButtonEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonEdit.setForeground(new java.awt.Color(255, 255, 255));
        ButtonEdit.setText("Edit");

        ButtonSave.setBackground(new java.awt.Color(72, 119, 62));
        ButtonSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonSave.setForeground(new java.awt.Color(255, 255, 255));
        ButtonSave.setText("Save");

        NewsEdit.setBackground(new java.awt.Color(72, 119, 62));
        NewsEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pencil icon 2.png"))); // NOI18N

        NewsSave.setBackground(new java.awt.Color(72, 119, 62));
        NewsSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NewsSave.setForeground(new java.awt.Color(255, 255, 255));
        NewsSave.setText("Save");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NewsSave)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NewsEdit)))
                                .addGap(50, 50, 50)
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ButtonEdit)
                .addGap(18, 18, 18)
                .addComponent(ButtonSave)
                .addGap(23, 23, 23))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonEdit)
                    .addComponent(ButtonSave))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NewsEdit)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NewsSave)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Introduction", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(72, 119, 62), 2));

        jPanel12.setBackground(new java.awt.Color(72, 119, 62));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel12.setMaximumSize(new java.awt.Dimension(127, 169));
        jPanel12.setMinimumSize(new java.awt.Dimension(127, 169));
        jPanel12.setPreferredSize(new java.awt.Dimension(127, 169));

        jLabel15.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Lithuania");

        jTextArea6.setEditable(false);
        jTextArea6.setBackground(new java.awt.Color(72, 119, 62));
        jTextArea6.setFont(new java.awt.Font("Impact", 0, 45)); // NOI18N
        jTextArea6.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea6.setText("251");
        jTextArea6.setPreferredSize(new java.awt.Dimension(85, 60));
        jScrollPane6.setViewportView(jTextArea6);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(23, 23, 23))
        );

        jPanel18.setBackground(new java.awt.Color(72, 119, 62));
        jPanel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel18.setMaximumSize(new java.awt.Dimension(127, 169));
        jPanel18.setMinimumSize(new java.awt.Dimension(127, 169));
        jPanel18.setPreferredSize(new java.awt.Dimension(127, 169));

        jLabel18.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Slovenia");

        jTextArea13.setEditable(false);
        jTextArea13.setBackground(new java.awt.Color(72, 119, 62));
        jTextArea13.setFont(new java.awt.Font("Impact", 0, 45)); // NOI18N
        jTextArea13.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea13.setText("145");
        jTextArea13.setPreferredSize(new java.awt.Dimension(85, 60));
        jScrollPane13.setViewportView(jTextArea13);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addGap(23, 23, 23))
        );

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(72, 119, 62));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Number of deaths, missing persons and directly affected persons attributed to disasters, per 100,000 population");

        jPanel11.setBackground(new java.awt.Color(72, 119, 62));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel11.setMaximumSize(new java.awt.Dimension(127, 169));
        jPanel11.setMinimumSize(new java.awt.Dimension(127, 169));

        jLabel14.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Georgia");

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(72, 119, 62));
        jTextArea2.setFont(new java.awt.Font("Impact", 0, 45)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea2.setText("330");
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(23, 23, 23))
        );

        jPanel17.setBackground(new java.awt.Color(72, 119, 62));
        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel17.setMaximumSize(new java.awt.Dimension(127, 169));
        jPanel17.setMinimumSize(new java.awt.Dimension(127, 169));
        jPanel17.setPreferredSize(new java.awt.Dimension(127, 169));

        jLabel17.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Ukraine");

        jTextArea8.setEditable(false);
        jTextArea8.setBackground(new java.awt.Color(72, 119, 62));
        jTextArea8.setFont(new java.awt.Font("Impact", 0, 45)); // NOI18N
        jTextArea8.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea8.setText("177");
        jTextArea8.setPreferredSize(new java.awt.Dimension(85, 60));
        jScrollPane8.setViewportView(jTextArea8);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane8))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(23, 23, 23))
        );

        jPanel13.setBackground(new java.awt.Color(72, 119, 62));
        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel13.setMaximumSize(new java.awt.Dimension(127, 169));
        jPanel13.setMinimumSize(new java.awt.Dimension(127, 169));
        jPanel13.setPreferredSize(new java.awt.Dimension(127, 169));

        jLabel16.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Amenia");

        jTextArea7.setEditable(false);
        jTextArea7.setBackground(new java.awt.Color(72, 119, 62));
        jTextArea7.setFont(new java.awt.Font("Impact", 0, 45)); // NOI18N
        jTextArea7.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea7.setText("199");
        jTextArea7.setPreferredSize(new java.awt.Dimension(85, 60));
        jScrollPane7.setViewportView(jTextArea7);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(23, 23, 23))
        );

        jLabel20.setBackground(new java.awt.Color(72, 119, 62));
        jLabel20.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(72, 119, 62));
        jLabel20.setText("TOP 5 COUNTRIES AFFECTED");

        EditNo.setBackground(new java.awt.Color(72, 119, 62));
        EditNo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditNo.setForeground(new java.awt.Color(255, 255, 255));
        EditNo.setText("Edit");

        SaveNo.setBackground(new java.awt.Color(72, 119, 62));
        SaveNo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SaveNo.setForeground(new java.awt.Color(255, 255, 255));
        SaveNo.setText("Save");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/graph.png"))); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(72, 119, 62), 2));

        jLabel21.setBackground(new java.awt.Color(72, 119, 62));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/map.jpg"))); // NOI18N
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(72, 119, 62), 2));

        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Graph from 2009-2021");

        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Map of most affected areas");

        searchinfo.setBackground(new java.awt.Color(72, 119, 62));
        searchinfo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchinfo.setForeground(new java.awt.Color(255, 255, 255));
        searchinfo.setText("Search");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel22)))
                .addGap(31, 31, 31)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addGap(162, 162, 162))))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EditNo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SaveNo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchinfo)
                        .addGap(31, 31, 31))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(373, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EditNo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SaveNo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22))
                .addGap(9, 9, 9))
        );

        jTabbedPane1.addTab("13.1.1", jPanel8);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(72, 119, 62), 2));

        jTextArea10.setEditable(false);
        jTextArea10.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea10.setColumns(20);
        jTextArea10.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTextArea10.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea10.setRows(5);
        jTextArea10.setText("The Sendai Framework for Disaster Risk Reduction 2015-2030 (Sendai Framework) was the first major  agreement of the post-2015 development agenda \nand provides Member States with concrete actions to protect development gains from the risk of disaster.\n\nEndorsed by the UN General Assembly following the 2015 Third UN World Conference on Disaster Risk Reduction (WCDRR), the Sendai Framework\nadvocates for:\n\n- The substantial reduction of disaster risk and losses in lives, livelihoods and health and in the economic, physical, social, cultural and environmental \nassets of persons, businesses, communities and countries.\n\n- It recognizes that the State has the primary role to reduce disaster risk but that responsibility should be shared with other stakeholders including local \ngovernment, the private sector and other stakeholders.\n");
        jScrollPane10.setViewportView(jTextArea10);

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(72, 119, 62));
        jLabel30.setText("Sedai Framework");

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/map3.png"))); // NOI18N
        jLabel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(72, 119, 62), 2));

        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Countries using Sendai Framework");

        EditText2.setBackground(new java.awt.Color(72, 119, 62));
        EditText2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditText2.setForeground(new java.awt.Color(255, 255, 255));
        EditText2.setText("Edit");

        SaveText2.setBackground(new java.awt.Color(72, 119, 62));
        SaveText2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SaveText2.setForeground(new java.awt.Color(255, 255, 255));
        SaveText2.setText("Save");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(EditText2)
                                .addGap(18, 18, 18)
                                .addComponent(SaveText2)
                                .addGap(23, 23, 23))
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(jLabel29))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel32)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(EditText2)
                    .addComponent(SaveText2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addGap(703, 703, 703))
        );

        jTabbedPane1.addTab("13.1.2", jPanel10);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(72, 119, 62), 2));

        jTextArea9.setEditable(false);
        jTextArea9.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea9.setColumns(20);
        jTextArea9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea9.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea9.setRows(5);
        jTextArea9.setText("Increasing the proportion of local governments that adopt and implement local disaster risk reduction strategies, which the \nSendai Framework calls for, will contribute to sustainable development and strengthen economic, social, health and environmental\nresilience. Their economic, environmental and social perspectives would include poverty eradication, urban resilience, and \nclimate change adaptation.");
        jScrollPane9.setViewportView(jTextArea9);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(72, 119, 62));
        jLabel24.setText("Proportion of local governments that adopt and implement local disaster");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(72, 119, 62));
        jLabel25.setText(" risk reduction strategies in line with national disaster risk reduction strategies, (%)");

        EditText.setBackground(new java.awt.Color(72, 119, 62));
        EditText.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditText.setForeground(new java.awt.Color(255, 255, 255));
        EditText.setText("Edit");

        SaveText.setBackground(new java.awt.Color(72, 119, 62));
        SaveText.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SaveText.setForeground(new java.awt.Color(255, 255, 255));
        SaveText.setText("Save");

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/map2.jpg"))); // NOI18N
        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(72, 119, 62), 2));

        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Countries using local disaster risk reduction strategies");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Disaster Risk Reduction");

        jTextArea14.setBackground(new java.awt.Color(100, 149, 90));
        jTextArea14.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea14.setText("Disaster risk reduction is aimed at\n preventing new and reducing existing\n disaster risk and managing residual \nrisk, all of which contribute to\n strengthening resilience and therefore\n to the achievementof sustainable \ndevelopment.");
        jTextArea14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 48, 5)));
        jScrollPane14.setViewportView(jTextArea14);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EditText)
                        .addGap(18, 18, 18)
                        .addComponent(SaveText)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 10, Short.MAX_VALUE))))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jLabel26)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(EditText)
                    .addComponent(SaveText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("13.1.3", jPanel9);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(72, 119, 62), 2));

        jTextArea11.setEditable(false);
        jTextArea11.setBackground(new java.awt.Color(100, 149, 90));
        jTextArea11.setColumns(20);
        jTextArea11.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea11.setRows(5);
        jTextArea11.setText("Disaster Mitigation is the cornerstone of emergency management. It’s the ongoing effort to lessen the impact disasters have on people and property. \nMitigation involves keeping homes away from floodplains, engineering bridges to withstand earthquakes, creating and enforcing effective building \ncodes to protect property from hurricanes, and more.\n\nMitigation is defined as “sustained action that reduces or eliminates long-term risk to people and property from natural hazards and their effects.” \nIt describes the ongoing effort at the federal, state, local and individual levels to lessen the impact of disasters upon our families, homes, communities \nand economy.");
        jTextArea11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 48, 5)));
        jScrollPane11.setViewportView(jTextArea11);

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(72, 119, 62));
        jLabel31.setText("Disaster Mitigation");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(72, 119, 62));
        jLabel33.setText("Mitigation Actions");

        jTextArea15.setEditable(false);
        jTextArea15.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea15.setColumns(20);
        jTextArea15.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea15.setRows(5);
        jTextArea15.setText(" \n - Promoting sound land use planning based on known hazards\n - Buying flood insurance to protect your belongings\n - Relocating or elevating structures out of the floodplains\n - Securing shelves and water heaters to nearby walls.\n - Having hurricane straps installed to more securely attach a structure’s roof to its walls and foundation.\n - Developing, adopting, and enforcing effective building codes and standards\n - Engineering roads and bridges to withstand earthquakes\n - Using fire-retardant materials in new construction\n - Developing and implementing a plan in your business or community to reduce your susceptibility to hazards");
        jTextArea15.setBorder(null);
        jScrollPane15.setViewportView(jTextArea15);

        EditText3.setBackground(new java.awt.Color(72, 119, 62));
        EditText3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditText3.setForeground(new java.awt.Color(255, 255, 255));
        EditText3.setText("Edit");

        SaveText3.setBackground(new java.awt.Color(72, 119, 62));
        SaveText3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SaveText3.setForeground(new java.awt.Color(255, 255, 255));
        SaveText3.setText("Save");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(10, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EditText3)
                        .addGap(18, 18, 18)
                        .addComponent(SaveText3)
                        .addGap(62, 62, 62))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EditText3)
                        .addComponent(SaveText3)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Disaster Mitigation", jPanel6);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(379, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1174, 710));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void changecolor(JPanel hover, Color rand) {
        hover.setBackground(rand);
    }

    private void BackArrowMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackArrowMouseEntered
        changecolor(jPanel2, new Color(84, 140, 72));
    }//GEN-LAST:event_BackArrowMouseEntered

    private void BackArrowMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackArrowMouseExited
        changecolor(jPanel2, new Color(72, 119, 62));
    }//GEN-LAST:event_BackArrowMouseExited

    private void BackArrowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackArrowMouseClicked
        this.dispose();
        climateAction.getFrame().setVisible(true);
    }//GEN-LAST:event_BackArrowMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked


    }//GEN-LAST:event_jTabbedPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddInfo;
    private javax.swing.JLabel BackArrow;
    private javax.swing.JButton ButtonEdit;
    private javax.swing.JButton ButtonSave;
    private javax.swing.JButton EditNo;
    private javax.swing.JButton EditText;
    private javax.swing.JButton EditText2;
    private javax.swing.JButton EditText3;
    private javax.swing.JButton NewsEdit;
    private javax.swing.JButton NewsSave;
    private javax.swing.JButton SaveNo;
    private javax.swing.JButton SaveText;
    private javax.swing.JButton SaveText2;
    private javax.swing.JButton SaveText3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea10;
    private javax.swing.JTextArea jTextArea11;
    private javax.swing.JTextArea jTextArea12;
    private javax.swing.JTextArea jTextArea13;
    private javax.swing.JTextArea jTextArea14;
    private javax.swing.JTextArea jTextArea15;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextArea jTextArea9;
    private javax.swing.JButton searchinfo;
    // End of variables declaration//GEN-END:variables
}
