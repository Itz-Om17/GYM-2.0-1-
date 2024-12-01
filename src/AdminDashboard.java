import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class AdminDashboard extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private DefaultTableModel trainerTableModel;
    private DefaultTableModel memberTableModel;
    private MainInterface mainInterface;
    private Connection connection;
    private String newTiming;
    public AdminDashboard(MainInterface mainInterface) {
        this.mainInterface = mainInterface;
        setTitle("Admin Dashboard");
        setSize(1920, 1200);  
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        establishConnection(); 
        initializeDashboard();
        add(cardPanel);
    }
    private void establishConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GYM", "root", "123456");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    private void initializeDashboard() {
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BoxLayout(dashboardPanel, BoxLayout.Y_AXIS));
        initializeMemberTable(dashboardPanel);
        initializeTrainerTable(dashboardPanel);
        JButton backButton = new JButton("Logout");
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backButton.addActionListener(e -> {
            mainInterface.showMainPanel();
            dispose();
        });
        JPanel backPanel = new JPanel();
        backPanel.add(backButton);
        dashboardPanel.add(backPanel);
        cardPanel.add(dashboardPanel, "Dashboard");
        cardLayout.show(cardPanel, "Dashboard");
    }
    private void initializeMemberTable(JPanel parentPanel) {
        JPanel memberPanel = new JPanel(new BorderLayout());
        JLabel memberLabel = new JLabel("Members");
        memberLabel.setFont(new Font("Arial", Font.BOLD, 16));
        memberLabel.setHorizontalAlignment(JLabel.CENTER);
        memberPanel.add(memberLabel, BorderLayout.NORTH);
    String[] memberColumns = {
    "Member ID", "Username", "Password", "Name", "Age", "Gender", 
    "Weight", "Feet", "Inches", "Address", "Phone No.", "Email", "Goal", "Days Per Week", "Timing"
};
        memberTableModel = new DefaultTableModel(memberColumns, 0);
        JTable memberTable = new JTable(memberTableModel);
        JScrollPane scrollPane = new JScrollPane(memberTable);
        add(scrollPane, BorderLayout.CENTER);
        fetchMembers();
        styleTable(memberTable);
        JScrollPane memberScrollPane = new JScrollPane(memberTable);
        memberPanel.add(memberScrollPane, BorderLayout.CENTER);
        JPanel memberButtonPanel = new JPanel();
        JButton editMemberButton = new JButton("Edit Member");
        JButton deleteMemberButton = new JButton("Delete Member");
        JButton addMemberButton = new JButton("Add Member");
        styleButton(editMemberButton);
        styleButton(deleteMemberButton);
        styleButton(addMemberButton);
        memberButtonPanel.add(editMemberButton);
        memberButtonPanel.add(deleteMemberButton);
        memberButtonPanel.add(addMemberButton);
        memberPanel.add(memberButtonPanel, BorderLayout.SOUTH);
        addMemberButton.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddMemberForm(); 
            }
        });
        editMemberButton.addActionListener(e -> {
            int selectedRow = memberTable.getSelectedRow();
            if (selectedRow != -1) {
                showEditMemberForm(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a member to edit.", "Selection Error", JOptionPane.WARNING_MESSAGE);
            }
        });
        deleteMemberButton.addActionListener(e -> deleteMember(memberTable));
        parentPanel.add(memberPanel);
    }
private void fetchMembers() {
    String query = "SELECT id, username, password, name, age, gender, weight, height_ft, height_inch, address, phone, email, goal, daysperweek,timing FROM members";
    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
        ResultSet rs = pstmt.executeQuery();
        memberTableModel.setRowCount(0);
        while (rs.next()) {
            memberTableModel.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("name"),
                rs.getInt("age"),
                rs.getString("gender"),
                rs.getDouble("weight"),
                rs.getInt("height_ft"), 
                rs.getInt("height_inch"), 
                rs.getString("address"),
                rs.getString("phone"),
                rs.getString("email"),
                rs.getString("goal"),
                rs.getInt("daysperweek"),
                rs.getString("timing")
            });
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
private JTextField usernameField;
private JTextField passwordField;
private JTextField nameField;
private JTextField ageField;
private JComboBox<String> genderComboBox;
private JTextField weightField;
private JTextField addressField;
private JTextField phoneField;
private JTextField emailField;
private JTextField goalField;
private void showAddMemberForm() {
    JPanel formPanel = new JPanel(new GridBagLayout());
    formPanel.setBackground(new Color(0xF0F0F0));
    formPanel.setBorder(BorderFactory.createTitledBorder("Add Member"));
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    JTextField usernameField = new JTextField(15);
    JPasswordField passwordField = new JPasswordField(15);
    JTextField nameField = new JTextField(15);
    JTextField ageField = new JTextField(15);
    JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"Male", "Female"});
    JTextField weightField = new JTextField(15);
    JTextField addressField = new JTextField(15);
    JTextField phoneField = new JTextField(15);
    JTextField emailField = new JTextField(15);

    JTextField heightFeetField = new JTextField(5);
    JComboBox<String> heightInchComboBox = new JComboBox<>(generateInchOptions());

    String[] goalOptions = {"SELECT A GOAL", "General Workout", "Weight Loss", "Muscle Gain", "Improve Endurance", "Enhanced Flexibility"};
    String[] timingOptions = {"Select a timing", 
            "6:00 AM - 10:00 AM", 
            "10:00 AM - 2:00 PM", 
            "2:00 PM - 6:00 PM", 
            "6:00 PM - 10:00 PM"};
    JComboBox<String> timingComboBox= new JComboBox<>(timingOptions);
    JComboBox<String> goalComboBox = new JComboBox<>(goalOptions);
    JSpinner daysPerWeekSpinner = new JSpinner(new SpinnerNumberModel(4, 4, 6, 1));

    gbc.gridx = 0; gbc.gridy = 0;
    formPanel.add(new JLabel("Username:"), gbc);
    gbc.gridx = 1; 
    formPanel.add(usernameField, gbc);

    gbc.gridx = 0; gbc.gridy = 1;
    formPanel.add(new JLabel("Password:"), gbc);
    gbc.gridx = 1; 
    formPanel.add(passwordField, gbc);

    gbc.gridx = 0; gbc.gridy = 2;
    formPanel.add(new JLabel("Name:"), gbc);
    gbc.gridx = 1; 
    formPanel.add(nameField, gbc);

    gbc.gridx = 0; gbc.gridy = 3;
    formPanel.add(new JLabel("Age:"), gbc);
    gbc.gridx = 1; 
    formPanel.add(ageField, gbc);

    gbc.gridx = 0; gbc.gridy = 4;
    formPanel.add(new JLabel("Gender:"), gbc);
    gbc.gridx = 1; 
    formPanel.add(genderComboBox, gbc);

    gbc.gridx = 0; gbc.gridy = 5;
    formPanel.add(new JLabel("Weight (kg):"), gbc);
    gbc.gridx = 1; 
    formPanel.add(weightField, gbc);

    gbc.gridx = 0; gbc.gridy = 6;
    formPanel.add(new JLabel("Height (Feet):"), gbc);
    gbc.gridx = 1; 
    formPanel.add(heightFeetField, gbc);

    gbc.gridx = 0; gbc.gridy = 7;
    formPanel.add(new JLabel("Height (Inches):"), gbc);
    gbc.gridx = 1; 
    formPanel.add(heightInchComboBox, gbc);

    gbc.gridx = 0; gbc.gridy = 8;
    formPanel.add(new JLabel("Address:"), gbc);
    gbc.gridx = 1; 
    formPanel.add(addressField, gbc);

    gbc.gridx = 0; gbc.gridy = 9;
    formPanel.add(new JLabel("Phone No.:"), gbc);
    gbc.gridx = 1; 
    formPanel.add(phoneField, gbc);

    gbc.gridx = 0; gbc.gridy = 10;
    formPanel.add(new JLabel("Email:"), gbc);
    gbc.gridx = 1; 
    formPanel.add(emailField, gbc);

    gbc.gridx = 0; gbc.gridy = 11;
    formPanel.add(new JLabel("Goal:"), gbc);
    gbc.gridx = 1; 
    formPanel.add(goalComboBox, gbc);

    gbc.gridx = 0; gbc.gridy = 12;
    formPanel.add(new JLabel("daysperweek:"), gbc);
    gbc.gridx = 1; 
    formPanel.add(daysPerWeekSpinner, gbc);

    gbc.gridx = 0; gbc.gridy = 13;
    formPanel.add(new JLabel("Timing"),gbc);
    gbc.gridx = 1;
    formPanel.add(timingComboBox,gbc);
    
    int result = JOptionPane.showConfirmDialog(this, formPanel, "Add Member", JOptionPane.OK_CANCEL_OPTION);
    if (result == JOptionPane.OK_OPTION) {
        try {
            int heightFeet = Integer.parseInt(heightFeetField.getText());
            int heightInch = Integer.parseInt(heightInchComboBox.getSelectedItem().toString());
            String goal = (String) goalComboBox.getSelectedItem();
            String timing = (String) timingComboBox.getSelectedItem();

            int daysPerWeek = (int) daysPerWeekSpinner.getValue();

            addMember(usernameField.getText(), new String(passwordField.getPassword()), nameField.getText(), 
                Integer.parseInt(ageField.getText()), genderComboBox.getSelectedItem().toString(), 
                Double.parseDouble(weightField.getText()), heightFeet, heightInch, 
                addressField.getText(), phoneField.getText(), emailField.getText(), goal, daysPerWeek, timingComboBox.getSelectedItem().toString()); 
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for age, weight, and height.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

private String[] generateInchOptions() {
    String[] inches = new String[12];
    for (int i = 0; i < 12; i++) {
        inches[i] = String.valueOf(i);
    }
    return inches;
}
private void showEditMemberForm(int selectedRow) {
    JPanel formPanel = new JPanel(new GridLayout(0, 2, 10, 10));

    String originalUsername = memberTableModel.getValueAt(selectedRow, 1).toString();
    String originalPassword = memberTableModel.getValueAt(selectedRow, 2).toString();
    String originalName = memberTableModel.getValueAt(selectedRow, 3).toString();
    String originalAge = memberTableModel.getValueAt(selectedRow, 4).toString();
    String originalGender = memberTableModel.getValueAt(selectedRow, 5).toString();
    String originalWeight = memberTableModel.getValueAt(selectedRow, 6).toString();
    String originalHeightFeet = memberTableModel.getValueAt(selectedRow, 7).toString();
    String originalHeightInch = memberTableModel.getValueAt(selectedRow, 8).toString();
    String originalPhone = memberTableModel.getValueAt(selectedRow, 9).toString();
    String originalEmail = memberTableModel.getValueAt(selectedRow, 10).toString();
    String originalAddress = memberTableModel.getValueAt(selectedRow, 11).toString();
    String originalGoal = memberTableModel.getValueAt(selectedRow, 12).toString();
    String originalTiming = memberTableModel.getValueAt(selectedRow, 14).toString();
    String originalDaysPerWeek = memberTableModel.getValueAt(selectedRow, 13).toString(); 
    System.out.println(originalTiming);

    JTextField usernameField = new JTextField(originalUsername); 
    JTextField passwordField = new JTextField(originalPassword); 
    JTextField nameField = new JTextField(originalName); 
    JTextField ageField = new JTextField(originalAge); 
    JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"Male", "Female", "Other"}); 
    genderComboBox.setSelectedItem(originalGender);
    JTextField weightField = new JTextField(originalWeight); 
    JTextField heightFeetField = new JTextField(originalHeightFeet); 
    JComboBox<String> heightInchComboBox = new JComboBox<>(generateInchOptions());
    heightInchComboBox.setSelectedItem(originalHeightInch); 
    JTextField phoneField = new JTextField(originalPhone); 
    JTextField emailField = new JTextField(originalEmail); 
    JTextField addressField = new JTextField(originalAddress); 
    JComboBox<String> goalComboBox = new JComboBox<>(new String[]{"General Workout", "Weight Loss", "Muscle Gain", "Improve Endurance", "Enhanced Flexibility"});
    JComboBox timingComboBox = new JComboBox<>(new String[]{"Select a timing", 
            "6:00 AM - 10:00 AM", 
            "10:00 AM - 2:00 PM", 
            "2:00 PM - 6:00 PM", 
            "6:00 PM - 10:00 PM"});
timingComboBox.setSelectedItem(originalTiming);
    goalComboBox.setSelectedItem(originalGoal); 
    JSpinner daysPerWeekSpinner = new JSpinner(new SpinnerNumberModel(Integer.parseInt(originalDaysPerWeek), 4, 6, 1)); 

    formPanel.add(new JLabel("Username:"));
    formPanel.add(usernameField);
    formPanel.add(new JLabel("Password:"));
    formPanel.add(passwordField);
    formPanel.add(new JLabel("Name:"));
    formPanel.add(nameField);
    formPanel.add(new JLabel("Age:"));
    formPanel.add(ageField);
    formPanel.add(new JLabel("Gender:"));
    formPanel.add(genderComboBox);
    formPanel.add(new JLabel("Weight:"));
    formPanel.add(weightField);
    formPanel.add(new JLabel("Height (Feet):"));
    formPanel.add(heightFeetField);
    formPanel.add(new JLabel("Height (Inches):"));
    formPanel.add(heightInchComboBox);
    formPanel.add(new JLabel("Phone:"));
    formPanel.add(phoneField);
    formPanel.add(new JLabel("Email:"));
    formPanel.add(emailField);
    formPanel.add(new JLabel("Address:"));
    formPanel.add(addressField);
    formPanel.add(new JLabel("Goal:"));
    formPanel.add(goalComboBox);
    formPanel.add(new JLabel("daysPerWeek")); 
    formPanel.add(daysPerWeekSpinner); 
    formPanel.add(new JLabel("Timing"));
    formPanel.add(timingComboBox);

    int memberId = (int) memberTableModel.getValueAt(selectedRow, 0); 

    int result = JOptionPane.showConfirmDialog(this, formPanel, "Edit Member", JOptionPane.OK_CANCEL_OPTION);
    if (result == JOptionPane.OK_OPTION) {
        try {
            boolean isUpdated = false;
    
            String usernameText = usernameField.getText().trim();
            if (!usernameText.equals(originalUsername)) isUpdated = true;
    
            String passwordText = passwordField.getText().trim();
            if (!passwordText.equals(originalPassword)) isUpdated = true;
    
            String nameText = nameField.getText().trim();
            if (!nameText.equals(originalName)) isUpdated = true;
    
            String ageText = ageField.getText().trim();
            if (!ageText.equals(originalAge)) {
                int age = Integer.parseInt(ageText); 
                isUpdated = true;
            }
    
            String genderText = genderComboBox.getSelectedItem().toString();
            if (!genderText.equals(originalGender)) isUpdated = true;
    
            String weightText = weightField.getText().trim();
            if (!weightText.equals(originalWeight)) {
                double weight = Double.parseDouble(weightText); 
                isUpdated = true;
            }
    
            String heightFeetText = heightFeetField.getText().trim();
            String heightInchText = heightInchComboBox.getSelectedItem().toString().trim();
            if (!heightFeetText.equals(originalHeightFeet) || !heightInchText.equals(originalHeightInch)) {
                int heightFeet = Integer.parseInt(heightFeetText);
                int heightInch = Integer.parseInt(heightInchText); 
                isUpdated = true;
            }
    
            String phoneText = phoneField.getText().trim();
            if (!phoneText.equals(originalPhone)) isUpdated = true;
    
            String emailText = emailField.getText().trim();
            if (!emailText.equals(originalEmail)) isUpdated = true;
    
            String addressText = addressField.getText().trim();
            if (!addressText.equals(originalAddress)) isUpdated = true;
    
            String goalText = goalComboBox.getSelectedItem().toString();
            String timingText = timingComboBox.getSelectedItem().toString();
    
            if (!timingText.equals(originalTiming) || !goalText.equals(originalGoal)) {
                isUpdated = true;
    
                
            }
    
            int daysPerWeek = (int) daysPerWeekSpinner.getValue();
            if (daysPerWeek != Integer.parseInt(originalDaysPerWeek)) isUpdated = true;
    
            if (isUpdated) {
                updateMember(memberId, usernameText, passwordText, nameText, 
                    Integer.parseInt(ageField.getText().trim()), genderText, 
                    Double.parseDouble(weightField.getText().trim()), Integer.parseInt(heightFeetField.getText().trim()),
                    Integer.parseInt(heightInchComboBox.getSelectedItem().toString().trim()), 
                    addressText, phoneText, emailText, goalText, daysPerWeek, timingText); 
                TrainerAllotment allotment = new TrainerAllotment();
                
                allotment.allocateTrainerToMembers();
                
                System.out.println("Timing or goal changed, reallocating trainers...");
            } else {
                JOptionPane.showMessageDialog(this, "No changes were made.", "Update", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for age, weight, and height.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}







    private void initializeTrainerTable(JPanel parentPanel) {
        JPanel trainerPanel = new JPanel(new BorderLayout());
        JLabel trainerLabel = new JLabel("Trainers");
        trainerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        trainerLabel.setHorizontalAlignment(JLabel.CENTER);
        trainerPanel.add(trainerLabel, BorderLayout.NORTH);
        String[] trainerColumns = {"Trainer ID", "Username", "Password", "Name", "Age", "Gender", "Experience", "Phone No.", "Email", "Address" , "Specialization" , "Work Hours"};
        trainerTableModel = new DefaultTableModel(trainerColumns, 0);
        JTable trainerTable = new JTable(trainerTableModel);
        fetchTrainers();
        styleTable(trainerTable);
        JScrollPane trainerScrollPane = new JScrollPane(trainerTable);
        trainerPanel.add(trainerScrollPane, BorderLayout.CENTER);
        JPanel trainerButtonPanel = new JPanel();
        JButton editTrainerButton = new JButton("Edit Trainer");
        JButton deleteTrainerButton = new JButton("Delete Trainer");
        JButton addTrainerButton = new JButton("Add Trainer");
        styleButton(editTrainerButton);
        styleButton(deleteTrainerButton);
        styleButton(addTrainerButton);
        trainerButtonPanel.add(addTrainerButton);
        trainerButtonPanel.add(editTrainerButton);
        trainerButtonPanel.add(deleteTrainerButton);
        trainerPanel.add(trainerButtonPanel, BorderLayout.SOUTH);
        // Add action listeners to trainer buttons
        addTrainerButton.addActionListener(e -> showTrainerForm(trainerTable, -1));
        editTrainerButton.addActionListener(e -> editTrainer(trainerTable));
        deleteTrainerButton.addActionListener(e -> deleteTrainer(trainerTable));

        parentPanel.add(trainerPanel);
    }
    private void fetchTrainers() {
        String query = "SELECT * FROM trainers";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int trainerId = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                int experience = rs.getInt("experience");
                String phoneNo = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String specialization = rs.getString("specialization");
                String shiftHours = rs.getString("shift_timing");
                trainerTableModel.addRow(new Object[]{
                        trainerId,
                        username,
                        password,
                        name,
                        age,
                        gender,
                        experience,
                        phoneNo,
                        email,
                        address,
                        specialization,
                        shiftHours
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to fetch trainers: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Method to style the JTable
    private void styleTable(JTable table) {
        // Set fonts for the table content
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(30);  // Increase row height for better readability
        // Set column widths (optional, based on your preference)
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(150);
        }
        // Style the table header
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBackground(Color.LIGHT_GRAY);
        header.setForeground(Color.BLACK);
    }
    // Method to style buttons
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(Color.DARK_GRAY);
        button.setForeground(Color.WHITE);
    }
    // Show member form
    private void showMemberForm(JTable memberTable, int row) {
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        SpinnerModel daysPerWeekModel = new SpinnerNumberModel(2, 4, 6, 1); // Min = 4, Max = 6, Step = 1
        JSpinner daysPerWeekSpinner = new JSpinner(daysPerWeekModel);
        // Initialize fields
        JTextField usernameField = new JTextField();
        JTextField passwordField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        String[] genderOptions = {"Select a gender", "Male", "Female"};
        JComboBox<String> genderComboBox = new JComboBox<>(genderOptions);
        String[] timingOptions = {"Select a timing", 
            "6:00 AM - 10:00 AM", 
            "10:00 AM - 2:00 PM", 
            "2:00 PM - 6:00 PM", 
            "6:00 PM - 10:00 PM"};
        JComboBox<String> timingComboBox = new JComboBox<>(timingOptions);
        JTextField weightField = new JTextField();
        // Height fields
        JTextField heightFeetField = new JTextField();
        JComboBox<String> heightInchComboBox = new JComboBox<>(generateInchOptions());
        JTextField phoneNoField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField addressField = new JTextField();
        // Goal dropdown options
        String[] goalOptions = {"SELECT A SPECIALIZATION", "General workout", "Weight loss", "Muscle gain", "Improve endurance", "Enhanced flexibility"};
        JComboBox<String> goalComboBox = new JComboBox<>(goalOptions);
        goalComboBox.setSelectedIndex(0);
        // Add labels and fields to formPanel
        formPanel.add(new JLabel("Username:"));
        formPanel.add(usernameField);
        formPanel.add(new JLabel("Password:"));
        formPanel.add(passwordField);
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Age:"));
        formPanel.add(ageField);
        formPanel.add(new JLabel("Gender:"));
        formPanel.add(genderComboBox);
        formPanel.add(new JLabel("Weight:"));
        formPanel.add(weightField);
        formPanel.add(new JLabel("Height (Feet):"));
        formPanel.add(heightFeetField);
        formPanel.add(new JLabel("Height (Inches):"));
        formPanel.add(heightInchComboBox);
        formPanel.add(new JLabel("Phone No:"));
        formPanel.add(phoneNoField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
        formPanel.add(new JLabel("Address:"));
        formPanel.add(addressField);
        formPanel.add(new JLabel("Goal:"));
        formPanel.add(goalComboBox);
        formPanel.add(new JLabel("daysperweek:"));
        formPanel.add(daysPerWeekSpinner);
        formPanel.add(new JLabel("Timing:"));
        formPanel.add(timingComboBox);
        // Populate fields if editing
        if (row != -1) {
            usernameField.setText(memberTable.getValueAt(row, 1).toString());
            passwordField.setText(memberTable.getValueAt(row, 2).toString());
            nameField.setText(memberTable.getValueAt(row, 3).toString());
            ageField.setText(memberTable.getValueAt(row, 4).toString());
            genderComboBox.setSelectedItem(memberTable.getValueAt(row, 5).toString());
            weightField.setText(memberTable.getValueAt(row, 6).toString());
            heightFeetField.setText(memberTable.getValueAt(row, 7).toString()); // Assuming column 7 for feet
            heightInchComboBox.setSelectedItem(memberTable.getValueAt(row, 8).toString()); // Assuming column 8 for inches
            phoneNoField.setText(memberTable.getValueAt(row, 9).toString());
            emailField.setText(memberTable.getValueAt(row, 10).toString());
            addressField.setText(memberTable.getValueAt(row, 11).toString());
            goalComboBox.setSelectedItem(memberTable.getValueAt(row, 12).toString());
            daysPerWeekSpinner.setValue(Integer.parseInt(memberTable.getValueAt(row, 13).toString()));
            timingComboBox.setSelectedItem(memberTable.getValueAt(row, 14)); 
        }    
        int option;
boolean allFieldsFilled = false; // Initialize to false
do {
    option = JOptionPane.showConfirmDialog(this, formPanel, row == -1 ? "Add Member" : "Edit Member", JOptionPane.OK_CANCEL_OPTION);
    if (option == JOptionPane.OK_OPTION) {
        // Validate input fields
        allFieldsFilled = !usernameField.getText().trim().isEmpty() &&
                !passwordField.getText().trim().isEmpty() &&
                !nameField.getText().trim().isEmpty() &&
                !ageField.getText().trim().isEmpty() &&
                genderComboBox.getSelectedIndex() != 0 &&
                !weightField.getText().trim().isEmpty() &&
                !heightFeetField.getText().trim().isEmpty() &&
                heightInchComboBox.getSelectedIndex() != -1 &&
                !phoneNoField.getText().trim().isEmpty() &&
                !emailField.getText().trim().isEmpty() &&
                !addressField.getText().trim().isEmpty() &&
                goalComboBox.getSelectedIndex() != -1 &&
                daysPerWeekSpinner.getValue() != null &&
                timingComboBox.getSelectedIndex()!=-1;
        if (!allFieldsFilled) {
            JOptionPane.showMessageDialog(this, "Please fill all fields and select a valid option.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
} while (option == JOptionPane.OK_OPTION && !allFieldsFilled);
        if (option == JOptionPane.OK_OPTION) {
            try {
                int age = Integer.parseInt(ageField.getText().trim());
                double weight = Double.parseDouble(weightField.getText().trim());
                int heightFeet = Integer.parseInt(heightFeetField.getText().trim());
                int heightInch = Integer.parseInt(heightInchComboBox.getSelectedItem().toString());
                int daysPerWeek = (int) daysPerWeekSpinner.getValue();

    
                if (row == -1) { // Add
                    addMember(usernameField.getText().trim(), passwordField.getText().trim(), nameField.getText().trim(), age,
                            genderComboBox.getSelectedItem().toString(), weight, heightFeet, heightInch, 
                            addressField.getText().trim(), phoneNoField.getText().trim(), emailField.getText().trim(), 
                            goalComboBox.getSelectedItem().toString(), daysPerWeek, timingComboBox.getSelectedItem().toString());
                } else { // Edit
                    int memberId = (int) memberTableModel.getValueAt(row, 0);
                    String timingText = timingComboBox.getSelectedItem().toString();
                    String goalText = goalComboBox.getSelectedItem().toString();
                    
                    updateMember(memberId, usernameField.getText().trim(), passwordField.getText().trim(), nameField.getText().trim(),
                            age, genderComboBox.getSelectedItem().toString(), weight, heightFeet, heightInch, 
                            addressField.getText().trim(), phoneNoField.getText().trim(), emailField.getText().trim(), 
                            goalComboBox.getSelectedItem().toString(), daysPerWeek, timingComboBox.getSelectedItem().toString());
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter valid numerical values for age, weight, and height.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void addMember(String username, String password, String name, int age, String gender,
                       double weight, int heightFeet, int heightInch, String address, String phoneNo, String email, String goal, int daysPerWeek, String timing) {
    String query = "INSERT INTO members (username, password, name, age, gender, weight, height_ft, height_inch, address, phone, email, goal, daysperweek, timing) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        pstmt.setString(3, name);
        pstmt.setInt(4, age);
        pstmt.setString(5, gender);
        pstmt.setDouble(6, weight);
        pstmt.setInt(7, heightFeet); // Store feet
        pstmt.setInt(8, heightInch); // Store inches
        pstmt.setString(9, address);
        pstmt.setString(10, phoneNo);
        pstmt.setString(11, email);
        pstmt.setString(12, goal);
        pstmt.setInt(13, daysPerWeek);
        pstmt.setString(14, timing);

        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int memberId = generatedKeys.getInt(1); // Get the newly added member's ID

                    // Add the new member to the table model
                    memberTableModel.addRow(new Object[]{
                        memberId,
                        username,
                        password,
                        name,
                        age,
                        gender,
                        weight,
                        heightFeet, // + "'" ,
                        heightInch,
                        address,
                        phoneNo,
                        email,
                        goal,
                        daysPerWeek,
                        timing
                    });

                    // Call TrainerAllotment logic to assign a trainer to the new member
                    TrainerAllotment allotment = new TrainerAllotment();
                    allotment.allocateTrainerToNewMember(memberId); // Assign a trainer to the new member
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Failed to add member: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void updateMember(int memberId, String username, String password, String name, int age, String gender,
                          double weight, int heightFeet, int heightInch, String address, String phoneNo, String email, String goal, int daysperweek, String timing) {
    String query = "UPDATE members SET username = ?, password = ?, name = ?, age = ?, gender = ?, "
            + "weight = ?, height_ft = ?, height_inch = ?, address = ?, phone = ?, email = ?, goal = ?, daysperweek = ?, timing = ? WHERE id = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        pstmt.setString(3, name);
        pstmt.setInt(4, age);
        pstmt.setString(5, gender);
        pstmt.setDouble(6, weight);
        pstmt.setInt(7, heightFeet); // Update feet
        pstmt.setInt(8, heightInch); // Update inches
        pstmt.setString(9, address);
        pstmt.setString(10, phoneNo);
        pstmt.setString(11, email);
        pstmt.setString(12, goal); 
        pstmt.setInt(13, daysperweek);
        pstmt.setString(14, timing);
        pstmt.setInt(15, memberId);
        int affectedRows = pstmt.executeUpdate();
        
        if (affectedRows > 0) {
            refreshMemberTable(); // Ensure the table is refreshed after update
        } else {
            JOptionPane.showMessageDialog(this, "No member updated.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Failed to update member: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    private void refreshMemberTable() {
        memberTableModel.setRowCount(0); // Clear the table
        fetchMembers(); // Re-fetch data from the database
    }
    // Delete member method
    private void deleteMember(JTable memberTable) {
        int selectedRow = memberTable.getSelectedRow();
        if (selectedRow != -1) {
            int memberId = (int) memberTableModel.getValueAt(selectedRow, 0);

            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this member?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                deleteMember(memberId);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a member to delete.");
        }
    }
    private void deleteMember(int memberId) {
        String deleteQuery = "DELETE FROM members WHERE id = ?";
        
        try (PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery)) {
            // Set the member ID to delete
            deleteStmt.setInt(1, memberId);
    
            // Execute the deletion
            int affectedRows = deleteStmt.executeUpdate();
    
            if (affectedRows > 0) {
                // Refresh the table model to reflect changes
                refreshMemberTable();
            } else {
                JOptionPane.showMessageDialog(this, "No member deleted.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to delete member: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Show trainer form
    private void showTrainerForm(JTable trainerTable, int row) {
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        // Initialize fields
        JTextField usernameField = new JTextField();
        JTextField passwordField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        String[] genderOptions = {"Select a gender", "Male", "Female"};
        String[] specializationOptions = {"Select a Specialization", "General Workout", "Weight Loss", "Muscle Gain", "Improve Endurance", "Enhanced Flexibility"};
        String[] shiftHoursOptions = {"Select a timing", "6:00 AM - 10:00 AM", "10:00 AM - 2:00 PM", "2:00 PM - 6:00 PM", "6:00 PM - 10:00 PM"};
        JComboBox<String> genderComboBox = new JComboBox<>(genderOptions);
        JComboBox<String> specializationComboBox = new JComboBox<>(specializationOptions);
        JComboBox<String> shiftHoursComboBox = new JComboBox<>(shiftHoursOptions);
        JTextField experienceField = new JTextField();
        JTextField phoneNoField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField addressField = new JTextField();
    
        // Add labels and fields to formPanel
        formPanel.add(new JLabel("Username:"));
        formPanel.add(usernameField);
        formPanel.add(new JLabel("Password:"));
        formPanel.add(passwordField);
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Age:"));
        formPanel.add(ageField);
        formPanel.add(new JLabel("Gender:"));
        formPanel.add(genderComboBox);
        formPanel.add(new JLabel("Experience:"));
        formPanel.add(experienceField);
        formPanel.add(new JLabel("Phone No:"));
        formPanel.add(phoneNoField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
        formPanel.add(new JLabel("Address:"));
        formPanel.add(addressField);
        formPanel.add(new JLabel("Specialization:"));
        formPanel.add(specializationComboBox);
        formPanel.add(new JLabel("Shift Hours:"));
        formPanel.add(shiftHoursComboBox);
    
        // Populate fields if editing
        if (row != -1) {
            usernameField.setText(trainerTable.getValueAt(row, 1).toString());
            passwordField.setText(trainerTable.getValueAt(row, 2).toString());
            nameField.setText(trainerTable.getValueAt(row, 3).toString());
            ageField.setText(trainerTable.getValueAt(row, 4).toString());
            genderComboBox.setSelectedItem(trainerTable.getValueAt(row, 5).toString());
            experienceField.setText(trainerTable.getValueAt(row, 6).toString());
            phoneNoField.setText(trainerTable.getValueAt(row, 7).toString());
            emailField.setText(trainerTable.getValueAt(row, 8).toString());
            addressField.setText(trainerTable.getValueAt(row, 9).toString());
            specializationComboBox.setSelectedItem(trainerTable.getValueAt(row, 10).toString());
            shiftHoursComboBox.setSelectedItem(trainerTable.getValueAt(row, 11).toString());
        }
    
        int option;
        boolean allFieldsFilled = false;
        do {
            option = JOptionPane.showConfirmDialog(this, formPanel, row == -1 ? "Add Trainer" : "Edit Trainer", JOptionPane.OK_CANCEL_OPTION);
    
            if (option == JOptionPane.OK_OPTION) {
                // Validate input fields
                allFieldsFilled = !usernameField.getText().trim().isEmpty() &&
                        !passwordField.getText().trim().isEmpty() &&
                        !nameField.getText().trim().isEmpty() &&
                        !ageField.getText().trim().isEmpty() &&
                        genderComboBox.getSelectedIndex() != 0 &&
                        !experienceField.getText().trim().isEmpty() &&
                        !phoneNoField.getText().trim().isEmpty() &&
                        !emailField.getText().trim().isEmpty() &&
                        !addressField.getText().trim().isEmpty() &&
                        specializationComboBox.getSelectedIndex() != 0 &&
                        shiftHoursComboBox.getSelectedIndex() != 0;
    
                // Additional validation for dropdowns
                StringBuilder errorMessage = new StringBuilder("Please fill all fields and select valid options for:\n");
                boolean hasError = false;
    
                if (genderComboBox.getSelectedIndex() == 0) {
                    errorMessage.append("- Gender\n");
                    hasError = true;
                }
                if (specializationComboBox.getSelectedIndex() == 0) {
                    errorMessage.append("- Specialization\n");
                    hasError = true;
                }
                if (shiftHoursComboBox.getSelectedIndex() == 0) {
                    errorMessage.append("- Shift Timing\n");
                    hasError = true;
                }
    
                if (!allFieldsFilled || hasError) {
                    JOptionPane.showMessageDialog(this, errorMessage.toString(), "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } while (option == JOptionPane.OK_OPTION && !allFieldsFilled);
    
        if (option == JOptionPane.OK_OPTION) {
            try {
                int age = Integer.parseInt(ageField.getText().trim());
                int experience = Integer.parseInt(experienceField.getText().trim());
    
                if (row == -1) { // Add
                    addTrainer(usernameField.getText().trim(), passwordField.getText().trim(), nameField.getText().trim(), age,
                            genderComboBox.getSelectedItem().toString(), experience, phoneNoField.getText().trim(),
                            emailField.getText().trim(), addressField.getText().trim(), specializationComboBox.getSelectedItem().toString(), shiftHoursComboBox.getSelectedItem().toString());
                } else { // Edit
                    int trainerId = (int) trainerTableModel.getValueAt(row, 0);
                    updateTrainer(trainerId, usernameField.getText().trim(), passwordField.getText().trim(), nameField.getText().trim(), age,
                            genderComboBox.getSelectedItem().toString(), experience, phoneNoField.getText().trim(),
                            emailField.getText().trim(), addressField.getText().trim(), specializationComboBox.getSelectedItem().toString(), shiftHoursComboBox.getSelectedItem().toString());
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric values for age and experience.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void addTrainer(String username, String password, String name, int age, String gender,
                            int experience, String phoneNo, String email, String address, String specialization, String shiftHours) {
        String query = "INSERT INTO trainers (username, password, name, age, gender, experience, phone, email, address, specialization, shift_timing) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, name);
            pstmt.setInt(4, age);
            pstmt.setString(5, gender);
            pstmt.setInt(6, experience);
            pstmt.setString(7, phoneNo);
            pstmt.setString(8, email);
            pstmt.setString(9, address);
            pstmt.setString(10, specialization);
            pstmt.setString(11, shiftHours);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                // Get the generated trainer ID
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int trainerId = generatedKeys.getInt(1);

                        // Add to table model
                        trainerTableModel.addRow(new Object[]{
                                trainerId,
                                username,
                                password,
                                name,
                                age,
                                gender,
                                experience,
                                phoneNo,
                                email,
                                address,
                                specialization,
                                shiftHours
                        });
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to add trainer: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void updateTrainer(int trainerId, String username, String password, String name, int age, String gender,
                               int experience, String phoneNo, String email, String address, String specialization, String shiftHours) {
        String query = "UPDATE trainers SET username = ?, password = ?, name = ?, age = ?, gender = ?, "
                + "experience = ?, phone = ?, email = ?, address = ?, specialization = ?, shift_timing = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, name);
            pstmt.setInt(4, age);
            pstmt.setString(5, gender);
            pstmt.setInt(6, experience);
            pstmt.setString(7, phoneNo);
            pstmt.setString(8, email);
            pstmt.setString(9, address);
            pstmt.setString(10, specialization);
            pstmt.setString(11, shiftHours);
            pstmt.setInt(12, trainerId);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                // Update the table model
                refreshTrainerTable();
            } else {
                JOptionPane.showMessageDialog(this, "No trainer updated.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to update trainer: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void refreshTrainerTable() {
        trainerTableModel.setRowCount(0); // Clear the table
        fetchTrainers(); // Re-fetch data from the database
    }
    // Edit trainer method
    private void editTrainer(JTable trainerTable) {
        int selectedRow = trainerTable.getSelectedRow();
        if (selectedRow != -1) {
            showTrainerForm(trainerTable, selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a trainer to edit.");
        }
    }
    // Delete trainer method
    private void deleteTrainer(JTable trainerTable) {
        int selectedRow = trainerTable.getSelectedRow();
        if (selectedRow != -1) {
            int trainerId = (int) trainerTableModel.getValueAt(selectedRow, 0);

            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this trainer?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                deleteTrainer(trainerId);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a trainer to delete.");
        }
    }
    private void deleteTrainer(int trainerId) {
        String query = "DELETE FROM trainers WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, trainerId);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                // Remove from table model
                refreshTrainerTable();
            } else {
                JOptionPane.showMessageDialog(this, "No trainer deleted.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to delete trainer: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Main method for testing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainInterface mainInterface = new MainInterface(); // Mock object for testing
            AdminDashboard adminDashboard = new AdminDashboard(mainInterface);
            adminDashboard.setVisible(true);
        });
    }
}
