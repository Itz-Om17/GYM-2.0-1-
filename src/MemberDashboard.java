import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MemberDashboard extends JPanel {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/GYM";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123456";
    private JFrame frame;
    private MainInterface mainInterface;
    private String username;
    private JDialog profileDialog;
    private ExecutorService executorService;
        private Image backgroundImage;
    
        class BackgroundPanel extends JPanel {
            private Image backgroundImage;
        
            public BackgroundPanel(String imagePath) {
                try {
                    File imageFile = new File(imagePath);
                    if (!imageFile.exists()) {
                        System.err.println("Image file does not exist: " + imagePath);
                        return;
                    }
                    backgroundImage = ImageIO.read(imageFile);
                    if (backgroundImage == null) {
                        System.err.println("Failed to load image: " + imagePath);
                    }
                } catch (IOException e) {
                    System.err.println("Error loading background image: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    Graphics2D g2d = (Graphics2D) g.create();
                    g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                    g2d.dispose();
                }
            }
        }
        
    

        public MemberDashboard(JFrame frame, MainInterface mainInterface, String username) {
            this.frame = frame;
            this.mainInterface = mainInterface;
            this.username = username;
            this.executorService = Executors.newCachedThreadPool();
        
            BackgroundPanel backgroundPanel = new BackgroundPanel("C:\\Users\\OM\\OneDrive\\Desktop\\GYM 2.0(1)\\src\\memberdashboard.jpg");
            backgroundPanel.setLayout(new BorderLayout());
            
            
            setLayout(new BorderLayout());
            add(backgroundPanel, BorderLayout.CENTER);
        
            JLabel welcomeLabel = new JLabel("Welcome " + this.username + " to your dashboard!");
            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
            welcomeLabel.setForeground(new Color(0x333333));
            welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            backgroundPanel.add(welcomeLabel, BorderLayout.NORTH);
        
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 35));
            buttonPanel.setOpaque(false); 
        
            JButton viewProfileButton = new JButton("View Profile");
            styleButton(viewProfileButton);
            buttonPanel.add(viewProfileButton);

            JButton viewScheduleButton = new JButton("View Schedule");
            styleButton(viewScheduleButton);
            buttonPanel.add(viewScheduleButton);

            JButton viewNotificationsButton = new JButton("View Notifications");
            styleButton(viewNotificationsButton);
            buttonPanel.add(viewNotificationsButton);

            JButton viewResourcesButton = new JButton("View Resources");
            styleButton(viewResourcesButton);
            buttonPanel.add(viewResourcesButton);

            JButton logoutButton = new JButton("Logout");
            styleButton(logoutButton);
            buttonPanel.add(logoutButton);

            viewProfileButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    executorService.submit(() -> showProfileDetails());
                }
            });

            logoutButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    mainInterface.showMainPanel();
                }
            });

            viewScheduleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    openScheduleDialog();
                }
            });

            viewNotificationsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "View Notifications clicked!");
                }
            });

            viewResourcesButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "View Resources clicked!");
                }
            });
        
            backgroundPanel.add(buttonPanel, BorderLayout.CENTER);
        }

        private void styleButton(JButton button) {
            // Set button to be non-opaque
            button.setOpaque(false);
            button.setContentAreaFilled(false); 
            button.setForeground(Color.WHITE); 
            button.setFont(new Font("Arial", Font.BOLD, 14));
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder());
        
            // Add hover effect without full transparency issues
            button.addMouseListener(new java.awt.event.MouseAdapter() {
                
        
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button.setContentAreaFilled(false); 
                    button.setBackground(new Color(0, 0, 0, 0)); 
                }
            });
        }
        

    private void showProfileDetails() {
        SwingUtilities.invokeLater(() -> {
            String[][] profileData = fetchProfileDetails();
            if (profileData != null) {
                if (profileDialog != null && profileDialog.isVisible()) {
                    profileDialog.dispose();
                }
                double weight = Double.parseDouble(profileData[3][1]); 
                int heightFt = Integer.parseInt(profileData[4][1]); 
                int heightInch = Integer.parseInt(profileData[5][1]); 
    
                double heightInMeters = convertHeightToMeters(heightFt, heightInch);
                double bmi = calculateBMI(weight, heightInMeters);
                String bmiClassification = classifyBMI(bmi);
    
                String[][] extendedProfileData = new String[profileData.length + 1][2]; 
                System.arraycopy(profileData, 0, extendedProfileData, 0, profileData.length);
                extendedProfileData[profileData.length] = new String[]{"BMI", String.format("%.2f (%s)", bmi, bmiClassification)};
    
                String[] columnNames = {"Field", "Value"};
                JTable profileTable = new JTable(extendedProfileData, columnNames);
                profileTable.setFillsViewportHeight(true);
    
                JScrollPane scrollPane = new JScrollPane(profileTable);
    
                JPanel dialogButtonPanel = new JPanel(new FlowLayout());
    
                JButton editButton = new JButton("Edit Details");
                editButton.addActionListener(e -> openEditProfileDialog());
    
                JButton closeButton = new JButton("Close");
                closeButton.addActionListener(e -> {
                    if (profileDialog != null && profileDialog.isVisible()) {
                        profileDialog.dispose();
                    }
                });
    
                dialogButtonPanel.add(editButton);
                dialogButtonPanel.add(closeButton);
    
                profileDialog = new JDialog(frame, "Profile Details", true);
                profileDialog.setLayout(new BorderLayout());
                profileDialog.add(scrollPane, BorderLayout.CENTER);
                profileDialog.add(dialogButtonPanel, BorderLayout.SOUTH);
                profileDialog.setSize(500, 400);
                profileDialog.setLocationRelativeTo(frame);
                profileDialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(MemberDashboard.this,
                        "Error retrieving profile details.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
private double convertHeightToMeters(int heightFt, int heightInch) {
    int totalInches = (heightFt * 12) + heightInch;
    return totalInches * 0.0254; 
}
    
    private double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }
    
    private String classifyBMI(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }
    

    private String[][] fetchProfileDetails() {
        String query = "SELECT m.name, m.age, m.gender, m.weight, m.height_ft, m.height_inch, m.address, m.phone, m.email, m.goal, m.daysperweek, m.timing, " +
                       "t.name AS trainer_name " +
                       "FROM members m " +
                       "LEFT JOIN sessions s ON m.id = s.MemberID " + // Join with Sessions table
                       "LEFT JOIN trainers t ON s.TrainerID = t.id " + // Join with Trainers table based on Session
                       "WHERE m.username = ? " +
                       "ORDER BY s.SessionDate DESC " + // Get the most recent session
                       "LIMIT 1";  // Limit to the most recent session
        
        String[][] profileData = null;
    
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
    
            if (rs.next()) {
                profileData = new String[][]{
                    {"Name", rs.getString("name")},
                    {"Age", Integer.toString(rs.getInt("age"))},
                    {"Gender", rs.getString("gender")},
                    {"Weight", rs.getString("weight")},
                    {"Height (ft)", Integer.toString(rs.getInt("height_ft"))},
                    {"Height (in)", Integer.toString(rs.getInt("height_inch"))},
                    {"Address", rs.getString("address")},
                    {"Phone", rs.getString("phone")},
                    {"Email", rs.getString("email")},
                    {"Goal", rs.getString("goal")},
                    {"Days per Week", Integer.toString(rs.getInt("daysperweek"))}, 
                    {"Timing", rs.getString("timing")},
                    {"Trainer Allotted", rs.getString("trainer_name") != null ? rs.getString("trainer_name") : "No Trainer Allotted"} // Add 
                };
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    
        return profileData;
    }
    
    
    private void openEditProfileDialog() {
        SwingUtilities.invokeLater(() -> {
            JDialog editDialog = new JDialog(frame, "Edit Profile", true);
            editDialog.setSize(500, 500);
            editDialog.setLocationRelativeTo(frame);
    
            String[][] profileData = fetchProfileDetails();
            if (profileData == null) {
                JOptionPane.showMessageDialog(editDialog, "Error retrieving profile details for editing.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            JPanel editPanel = new JPanel(new GridLayout(0, 2));
            editPanel.setBackground(new Color(0xE0E0E0));
    
            // Fields for editing
            JTextField nameField = new JTextField(profileData[0][1]);
            JTextField ageField = new JTextField(profileData[1][1]);
            JTextField weightField = new JTextField(profileData[3][1]);
            JTextField addressField = new JTextField(profileData[6][1]);
            JTextField phoneField = new JTextField(profileData[7][1]);
            JTextField emailField = new JTextField(profileData[8][1]);
            String originalGoal = profileData[9][1]; 
            String originalTiming = profileData[11][1];
            // Adding labels and fields
            editPanel.add(new JLabel("Name:"));
            editPanel.add(nameField);
    
            editPanel.add(new JLabel("Age:"));
            editPanel.add(ageField);
    
            editPanel.add(new JLabel("Gender:"));
            JTextField genderField = new JTextField(profileData[2][1]);
            genderField.setEditable(false);  
            editPanel.add(genderField);
    
            editPanel.add(new JLabel("Weight:"));
            editPanel.add(weightField);
    
            editPanel.add(new JLabel("Address:"));
            editPanel.add(addressField);
    
            editPanel.add(new JLabel("Phone:"));
            editPanel.add(phoneField);
    
            editPanel.add(new JLabel("Email:"));
            editPanel.add(emailField);
    
            editPanel.add(new JLabel("Height (ft):"));
            JTextField heightFtField = new JTextField(profileData[4][1]);
            editPanel.add(heightFtField);
    
            editPanel.add(new JLabel("Height (in):"));
            JComboBox<Integer> heightInchComboBox = new JComboBox<>();
            for (int i = 0; i <= 11; i++) {
                heightInchComboBox.addItem(i);  
            }
            heightInchComboBox.setSelectedItem(Integer.parseInt(profileData[5][1]));  
            editPanel.add(heightInchComboBox);
    
            editPanel.add(new JLabel("Goal:"));
            String[] goals = {"General Workout", "Weight Loss", "Muscle Gain", "Improve Endurance", "Enhanced Flexibility"};
            JComboBox<String> goalComboBox = new JComboBox<>(goals);
            goalComboBox.setSelectedItem(profileData[9][1]);
            editPanel.add(goalComboBox);
    
            editPanel.add(new JLabel("Days per Week:"));
            JTextField daysPerWeekField = new JTextField(profileData[10][1]);
            editPanel.add(daysPerWeekField);
    
            editPanel.add(new JLabel("Timing"));
            String[] timingOptions = {"Select a timing", 
            "6:00 AM - 10:00 AM", 
            "10:00 AM - 2:00 PM", 
            "2:00 PM - 6:00 PM", 
            "6:00 PM - 10:00 PM"};
            JComboBox<String> timingComboBox = new JComboBox<>(timingOptions);
            timingComboBox.setSelectedItem(profileData[11][1]);
            timingComboBox.setSelectedItem(profileData[11][1]);

            

            editPanel.add(timingComboBox);
            
            
            JPanel buttonPanel = new JPanel(new FlowLayout());
    
            JButton saveButton = new JButton("Save Changes");
            saveButton.addActionListener(e -> {
                executorService.submit(() -> {
                    // Collect data from fields
                    String name = nameField.getText();
                    String age = ageField.getText();
                    String gender = profileData[2][1];  
                    String weight = weightField.getText();
                    String heightFt = heightFtField.getText();
                    String heightInch = heightInchComboBox.getSelectedItem().toString();
                    String address = addressField.getText();
                    String phone = phoneField.getText();
                    String email = emailField.getText();
                    String goal = (String) goalComboBox.getSelectedItem();
                    String daysPerWeek = daysPerWeekField.getText();
                    String timing = (String) timingComboBox.getSelectedItem();
    
                    try {
                        int days = Integer.parseInt(daysPerWeek);
                        if (days < 4 || days > 6) {
                            throw new NumberFormatException("Days per week must be between  and 6.");
                        }
                        if(timing == "Select a timing"){
                            JOptionPane.showMessageDialog(editDialog, "Please enter a valid timing");
                        }
                        else{
                        editDialog.dispose();
                        updateProfile(name, age, gender, weight, heightFt, heightInch, address, phone, email, goal, daysPerWeek,timing);
                        
                        }
                        System.out.printf(goal);
                        System.out.println(timing);
                        if (!originalTiming.equals(timing) || !originalGoal.equals(goal)) {
                            
                            TrainerAllotment allotment = new TrainerAllotment();
                            
                          
                            allotment.allocateTrainerToMembers();
                            
                       
                            System.out.println("Timing or Goal changed, reallocating trainers...");
                            executorService.submit(this::showProfileDetails);
                        }
                        else{
                     
                        executorService.submit(this::showProfileDetails);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(editDialog, "Invalid input for days per week. Please enter a value between 4 and 6.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    }
                });
            });

            JButton backButton = new JButton("Back");
            backButton.addActionListener(e -> {
                editDialog.dispose();
                executorService.submit(this::showProfileDetails);
            });
    
            buttonPanel.add(saveButton);
            buttonPanel.add(backButton);
    
            editPanel.add(buttonPanel);
            editDialog.add(editPanel);
            editDialog.setVisible(true);
        });
    }
    
    
    private void updateProfile(String name, String age, String gender, String weight, String heightFt, String heightInch, String address, String phone, String email, String goal, String daysPerWeek, String timing) {
        String updateQuery = "UPDATE members SET name = ?, age = ?, gender = ?, weight = ?, height_ft = ?, height_inch = ?, address = ?, phone = ?, email = ?, goal = ?, daysperweek = ?, timing = ? WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(updateQuery)) {
    
            stmt.setString(1, name);  
            stmt.setString(2, age);   
            stmt.setString(3, gender);  
            stmt.setString(4, weight);  
            stmt.setInt(5, Integer.parseInt(heightFt));  
            stmt.setInt(6, Integer.parseInt(heightInch));  
            stmt.setString(7, address);  
            stmt.setString(8, phone); 
            stmt.setString(9, email);  
            stmt.setString(10, goal); 
            stmt.setInt(11, Integer.parseInt(daysPerWeek));  
            stmt.setString(12, timing);
            stmt.setString(13, username);  // username (where clause)
    
            
            int rowsAffected = stmt.executeUpdate();
    
            if (rowsAffected > 0) {
                SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(MemberDashboard.this,
                        "Profile updated successfully!", "Update Success", JOptionPane.INFORMATION_MESSAGE));
            } else {
                SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(MemberDashboard.this,
                        "Error updating profile.", "Update Error", JOptionPane.ERROR_MESSAGE));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void openScheduleDialog() {
        JDialog scheduleDialog = new JDialog();
        scheduleDialog.setSize(800, 600);
        scheduleDialog.setTitle("Workout Schedule");
    
        // Schedule panel initialization
        JPanel schedulePanel = new JPanel(new BorderLayout());
        String[] columnNames = {"DAY1", "DAY2", "DAY3", "DAY4", "DAY5", "DAY6", "DAY7"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable scheduleTable = new JTable(tableModel);
    
        scheduleTable.setRowHeight(100); 
        scheduleTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    
        class HtmlTableCellRenderer extends DefaultTableCellRenderer {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                if (value instanceof String) {
                    String text = (String) value;
                    text = "<html><body style='width: 150px;'>" + text.replace("\n", "<br>") + "</body></html>";
                    value = text;
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        }
    
        for (int i = 0; i < scheduleTable.getColumnCount(); i++) {
            scheduleTable.getColumnModel().getColumn(i).setCellRenderer(new HtmlTableCellRenderer());
        }
    
        JScrollPane scrollPane = new JScrollPane(scheduleTable);
        schedulePanel.add(scrollPane, BorderLayout.CENTER);
    
        ArrayList<String[]> fullExerciseDetails = new ArrayList<>();
    
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    
            String queryMember = "SELECT age, goal, daysperweek FROM members WHERE username = ?";
            PreparedStatement memberStmt = conn.prepareStatement(queryMember);
            memberStmt.setString(1, username); 
            ResultSet memberRs = memberStmt.executeQuery();
            if (memberRs.next()) {
                int age = memberRs.getInt("age");
                String goal = memberRs.getString("goal");
                int daysPerWeek = memberRs.getInt("daysperweek");
    
                String ageRange;
                if (age >= 16 && age <= 30) {
                    ageRange = "16-30";
                } else if (age >= 31 && age <= 45) {
                    ageRange = "31-45";
                } else if (age >= 46 && age <= 60) {
                    ageRange = "46-60";
                } else {
                    ageRange = "Above 60";
                }
    
                String queryPlan = "SELECT day1_exercises, day2_exercises, day3_exercises, day4_exercises, day5_exercises, day6_exercises FROM workout_plans WHERE goal = ? AND age_range = ? AND days_per_week = ?";
                PreparedStatement planStmt = conn.prepareStatement(queryPlan);
                planStmt.setString(1, goal);
                planStmt.setString(2, ageRange);
                planStmt.setInt(3, daysPerWeek);
    
                ResultSet planRs = planStmt.executeQuery();
                if (planRs.next()) {
                    String day1 = planRs.getString("day1_exercises");
                    String day2 = planRs.getString("day2_exercises");
                    String day3 = planRs.getString("day3_exercises");
                    String day4 = planRs.getString("day4_exercises");
                    String day5 = planRs.getString("day5_exercises");
                    String day6 = planRs.getString("day6_exercises");
                    String day7 = "Recovery Day!";
                    tableModel.addRow(new String[]{
                        getFirstThreeWords(day1),
                        getFirstThreeWords(day2),
                        getFirstThreeWords(day3),
                        getFirstThreeWords(day4),
                        getFirstThreeWords(day5),
                        getFirstThreeWords(day6),
                        day7
                    });
                    fullExerciseDetails.add(new String[]{
                        day1 != null ? day1 : "",
                        day2 != null ? day2 : "",
                        day3 != null ? day3 : "",
                        day4 != null ? day4 : "",
                        day5 != null ? day5 : "",
                        day6 != null ? day6 : "",
                        day7
                    });
                } else {
                    JOptionPane.showMessageDialog(this, "No matching workout plan found for your profile.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                planRs.close();
                planStmt.close();
            }
            memberRs.close();
            memberStmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching workout plan.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    
        
        adjustColumnWidths(scheduleTable);
    
        scheduleTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = scheduleTable.rowAtPoint(e.getPoint());
                int col = scheduleTable.columnAtPoint(e.getPoint());
    
                String[] fullDetails = fullExerciseDetails.get(0); 
    
                if (col == 6) {
                    JOptionPane.showMessageDialog(scheduleDialog, "Rest Day!", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JDialog exerciseDialog = new JDialog(scheduleDialog, "Exercise Details", true);
                    exerciseDialog.setSize(600, 600);
                    exerciseDialog.setLocationRelativeTo(scheduleDialog);
    
                    String fullExerciseData = fullDetails[col]; 
                    String formattedExerciseData = fullExerciseData.replace("\n", "<br>");
                    JLabel exerciseLabel = new JLabel("<html><body style='width: 350px;'>" + formattedExerciseData + "</body></html>");
                    exerciseLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    JButton closeButton = new JButton("Close");
                    closeButton.addActionListener(e1 -> exerciseDialog.dispose());
    
                    JPanel dialogPanel = new JPanel(new BorderLayout());
                    dialogPanel.add(exerciseLabel, BorderLayout.CENTER);
                    dialogPanel.add(closeButton, BorderLayout.SOUTH);
    
                    exerciseDialog.add(dialogPanel);
                    exerciseDialog.setVisible(true);
                }
            }
        });
    
        JButton backButton = new JButton("Close");
        backButton.addActionListener(e -> scheduleDialog.dispose());
        schedulePanel.add(backButton, BorderLayout.SOUTH);
    
        scheduleDialog.add(schedulePanel);
        
        scheduleDialog.setLocationRelativeTo(this);
        scheduleDialog.setVisible(true);
    }
    private String getFirstThreeWords(String exercise) {
        if (exercise == null || exercise.isEmpty()) {
            return "";
        }
        String[] words = exercise.split("\\s+"); 
        if (words.length <= 3) {
            return exercise; 
        }
        return String.join(" ", words[0], words[1], words[2]); 
    }
    private void adjustColumnWidths(JTable table) {
        for (int columnIndex = 0; columnIndex < table.getColumnCount(); columnIndex++) {
            int width = 0;
            TableColumn column = table.getColumnModel().getColumn(columnIndex);
    
            // Calculate the preferred width of the column
            for (int rowIndex = 0; rowIndex < table.getRowCount(); rowIndex++) {
                TableCellRenderer renderer = table.getCellRenderer(rowIndex, columnIndex);
                Component comp = table.prepareRenderer(renderer, rowIndex, columnIndex);
                width = Math.max(comp.getPreferredSize().width, width);
            }
    
            column.setPreferredWidth(width + 20);
        }
    }
} 