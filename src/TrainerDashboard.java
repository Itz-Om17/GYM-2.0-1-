import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Member;
import java.sql.*;

public class TrainerDashboard extends JFrame {
    
    private Trainer trainer;
    private JDialog profileDialog;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/GYM";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123456";
    

    public TrainerDashboard(Trainer trainer) {
        this.trainer = trainer;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setTitle("Trainer Dashboard");
        setSize(screenSize.width, screenSize.height);
        setLocationRelativeTo(null); 
        setBackground(new Color(240, 240, 240));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.add(createMainPanel(), "MainDashboard");
        cardPanel.add(createSchedulePanel(), "SchedulePanel");
        getContentPane().add(cardPanel);
        cardLayout.show(cardPanel, "MainDashboard");
        setVisible(true); 
    }
    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 240, 240));
    
        JLabel welcomeLabel = new JLabel("Welcome, " + trainer.getName() + "!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 28));
        welcomeLabel.setForeground(new Color(58, 134, 255));
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);
    
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(240, 240, 240));
    
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        actionPanel.setBackground(new Color(240, 240, 240));
    
        JButton viewProfileButton = createStyledButton("View Profile", new Color(58, 134, 255));
        viewProfileButton.addActionListener(e -> showProfileDetails());
        actionPanel.add(viewProfileButton);
    
        JButton viewScheduleButton = createStyledButton("View Schedule", new Color(0, 153, 76));
        viewScheduleButton.addActionListener(e -> cardLayout.show(cardPanel, "SchedulePanel"));
        actionPanel.add(viewScheduleButton);
    
        JButton manageMembersButton = createStyledButton("Manage Members", new Color(255, 165, 0));
        manageMembersButton.addActionListener(e -> manageMembers());
        actionPanel.add(manageMembersButton);
    
        JButton logoutButton = createStyledButton("Logout", new Color(204, 0, 0));
        logoutButton.addActionListener(e -> {
            new MainInterface().showMainPanel();
            dispose();
        });
        actionPanel.add(logoutButton);
    
        centerPanel.add(actionPanel, BorderLayout.NORTH);
    
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
    
        mainPanel.add(centerPanel, BorderLayout.CENTER);
    
        JLabel footerLabel = new JLabel("Gym Management System - Trainer Dashboard", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        footerLabel.setForeground(Color.GRAY);
        mainPanel.add(footerLabel, BorderLayout.SOUTH);
    
        return mainPanel;
    }

    private JPanel createSchedulePanel() {
        JPanel schedulePanel = new JPanel(new BorderLayout());
    
        JPanel totalCountPanel = new JPanel(new BorderLayout());
        totalCountPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        totalCountPanel.setBackground(new Color(230, 230, 250));
    
        JLabel totalCountLabel = new JLabel("Total number of members allotted", JLabel.CENTER);
        totalCountLabel.setFont(new Font("Arial", Font.BOLD, 18));
        totalCountLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
    
        JLabel totalCountValue = new JLabel(getTotalAllottedMembers() + "");
        totalCountValue.setFont(new Font("Arial", Font.BOLD, 24));
        totalCountValue.setForeground(Color.BLUE);
        totalCountValue.setHorizontalAlignment(JLabel.CENTER);
        totalCountValue.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        totalCountPanel.add(totalCountLabel, BorderLayout.NORTH);
        totalCountPanel.add(totalCountValue, BorderLayout.CENTER);
    
        schedulePanel.add(totalCountPanel, BorderLayout.NORTH);
    
        JPanel dayWisePanel = new JPanel(new GridLayout(1, 6, 10, 10));
        dayWisePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
    
        for (int i = 1; i <= 6; i++) {
            JPanel dayPanel = new JPanel(new BorderLayout());
            dayPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        
            JLabel dayLabel = new JLabel("DAY " + i, JLabel.CENTER);
            dayLabel.setFont(new Font("Arial", Font.BOLD, 16));
            dayLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
            JTextArea memberList = new JTextArea(getMembersAllottedOnDay(i));
            memberList.setEditable(false);
            memberList.setFont(new Font("Arial", Font.PLAIN, 14));
            memberList.setBackground(new Color(240, 240, 240));
            memberList.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            
            final int selectedDay = i; 
            memberList.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    try {
                        int index = memberList.getLineOfOffset(memberList.viewToModel(evt.getPoint()));
                        String[] lines = memberList.getText().split("\n");
        
                        if (index < lines.length) {
                            String memberName = lines[index].trim().replaceAll("[^a-zA-Z0-9 ]", "");
                            if (!memberName.isEmpty()) {
                                System.out.println("Selected member: " + memberName + " for day: " + selectedDay); 
                                showExercisesForMember(memberName, selectedDay);  
                            }
                        } else {
                            System.out.println("No valid member selected");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        
            dayPanel.add(dayLabel, BorderLayout.NORTH);
            dayPanel.add(new JScrollPane(memberList), BorderLayout.CENTER);
        
            dayWisePanel.add(dayPanel);
        }
        
    
        schedulePanel.add(dayWisePanel, BorderLayout.CENTER);
    
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> cardLayout.show(cardPanel, "MainDashboard"));
        schedulePanel.add(backButton, BorderLayout.SOUTH);
    
        return schedulePanel;
    }
    
    private void showExercisesForMember(String memberName, int day) {
        System.out.println("Fetching exercises for member: " + memberName + " for day: " + day); 
    
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            Member member = fetchMemberDetails(memberName, conn);
            System.out.println("Fetched member: " + member.getGoal() + ", Age: " + member.getAge()); 
            String[][] exercises = fetchExercisesForMember(member, conn);
    
            if (exercises.length == 0) {
                System.out.println("No exercises found for member: " + memberName); 
            } else {
                String[] selectedDayExercise = exercises[day - 1]; 
                
                JPanel exercisesPanel = new JPanel(new BorderLayout());
                
                String[][] dayExercise = new String[][] { { selectedDayExercise[0], selectedDayExercise[1] } };  
    
                JTable exercisesTable = new JTable(dayExercise, new String[]{"Day", "Exercises"});
                exercisesTable.setDefaultRenderer(Object.class, new HtmlTableCellRenderer());
                
                for (int row = 0; row < exercisesTable.getRowCount(); row++) {
                    int rowHeight = exercisesTable.getRowHeight();
                    for (int column = 0; column < exercisesTable.getColumnCount(); column++) {
                        Component comp = exercisesTable.prepareRenderer(exercisesTable.getCellRenderer(row, column), row, column);
                        rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
                    }
    
                    exercisesTable.setRowHeight(row, rowHeight);
                }
    
                JScrollPane scrollPane = new JScrollPane(exercisesTable);
                exercisesPanel.add(scrollPane, BorderLayout.CENTER);
    
                JButton backButton = new JButton("Back");
                backButton.addActionListener(e -> cardLayout.show(cardPanel, "SchedulePanel"));
                exercisesPanel.add(backButton, BorderLayout.SOUTH);
    
                cardPanel.add(exercisesPanel, "ExercisesPanel");
                cardLayout.show(cardPanel, "ExercisesPanel");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
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
    
    private String[][] fetchExercisesForMember(Member member, Connection conn) {
        String ageRange;
        int age = member.getAge();
    
        if (age >= 16 && age <= 30) {
            ageRange = "16-30";
        } else if (age >= 31 && age <= 45) {
            ageRange = "31-45";
        } else if (age >= 46 && age <= 60) {
            ageRange = "46-60";
        } else {
            ageRange = "Above 60";
        }
    
        System.out.println("Fetching exercises for member with goal: " + member.getGoal() + ", age range: " + ageRange + ", days per week: " + member.getDaysPerWeek());
    
        String queryPlan = "SELECT day1_exercises, day2_exercises, day3_exercises, " +
                "day4_exercises, day5_exercises, day6_exercises FROM workout_plans WHERE goal = ? AND age_range = ? AND days_per_week = ?";
    
        try (PreparedStatement planStmt = conn.prepareStatement(queryPlan)) {
            planStmt.setString(1, member.getGoal());
            planStmt.setString(2, ageRange);
            planStmt.setInt(3, member.getDaysPerWeek());
    
            ResultSet planRs = planStmt.executeQuery();
            if (planRs.next()) {
                System.out.println("Exercises found for member");
                String[][] exercises = new String[7][2];
                exercises[0] = new String[]{"Day 1", planRs.getString("day1_exercises") != null ? planRs.getString("day1_exercises") : ""};
                exercises[1] = new String[]{"Day 2", planRs.getString("day2_exercises") != null ? planRs.getString("day2_exercises") : ""};
                exercises[2] = new String[]{"Day 3", planRs.getString("day3_exercises") != null ? planRs.getString("day3_exercises") : ""};
                exercises[3] = new String[]{"Day 4", planRs.getString("day4_exercises") != null ? planRs.getString("day4_exercises") : ""};
                exercises[4] = new String[]{"Day 5", planRs.getString("day5_exercises") != null ? planRs.getString("day5_exercises") : ""};
                exercises[5] = new String[]{"Day 6", planRs.getString("day6_exercises") != null ? planRs.getString("day6_exercises") : ""};
                exercises[6] = new String[]{"Day 7", "Recovery Day!"};
                return exercises;
            } else {
                System.out.println("No exercises found for this member");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new String[0][0]; 
    }
    
    
    private Member fetchMemberDetails(String memberName, Connection conn) {
        System.out.println("Fetching member details for: '" + memberName.trim() + "'");
        String queryMember = "SELECT age, goal, daysperweek FROM members WHERE name = ?";
        try (PreparedStatement memberStmt = conn.prepareStatement(queryMember)) {
            memberStmt.setString(1, memberName.trim()); 
            ResultSet memberRs = memberStmt.executeQuery();
            if (memberRs.next()) {
                Member member = new Member();
                member.setAge(memberRs.getInt("age"));
                member.setGoal(memberRs.getString("goal"));
                member.setDaysPerWeek(memberRs.getInt("daysperweek"));
                System.out.println("Member found: " + memberName + " | Goal: " + member.getGoal() + ", Age: " + member.getAge());
                return member;
            } else {
                System.out.println("No member found with username: " + memberName.trim());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Member();
    }
    
    

public class Member {
    private int age;
    private String goal;
    private int daysPerWeek;

    public Member() {}

    public Member(int age, String goal, int daysPerWeek) {
        this.age = age;
        this.goal = goal;
        this.daysPerWeek = daysPerWeek;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public int getDaysPerWeek() {
        return daysPerWeek;
    }

    public void setDaysPerWeek(int daysPerWeek) {
        this.daysPerWeek = daysPerWeek;
    }
}

    private JButton createStyledButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setContentAreaFilled(true);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(button.getBackground().darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(backgroundColor);
            }
        });

        return button;
    }

    private int getTotalAllottedMembers() {
        int totalCount = 0;
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT COUNT(*) AS total FROM sessions WHERE TrainerID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, trainer.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalCount = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalCount;
    }

    private String getMembersAllottedOnDay(int day) {
        StringBuilder members = new StringBuilder();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT m.name FROM sessions s JOIN members m ON s.MemberID = m.id WHERE s.TrainerID = ? AND m.daysperweek >= ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, trainer.getId());
            stmt.setInt(2, day);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                members.append("\u2022 ").append(rs.getString("name")).append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members.toString();
    }

    private void showProfileDetails() {
        SwingUtilities.invokeLater(() -> {
            String[][] profileData = fetchProfileDetails();
            if (profileData != null) {
                if (profileDialog != null && profileDialog.isVisible()) {
                    profileDialog.dispose();
                }

                String[] columnNames = {"Field", "Value"};
                JTable profileTable = new JTable(profileData, columnNames);
                profileTable.setFillsViewportHeight(true);
                profileTable.setBackground(new Color(240, 240, 240));
                profileTable.setFont(new Font("Arial", Font.PLAIN, 14));

                JScrollPane scrollPane = new JScrollPane(profileTable);
                JPanel dialogButtonPanel = new JPanel(new FlowLayout());

                JButton closeButton = new JButton("Close");
                closeButton.addActionListener(e -> {
                    if (profileDialog != null && profileDialog.isVisible()) {
                        profileDialog.dispose();
                    }
                });
                dialogButtonPanel.add(closeButton);

                JButton editButton = new JButton("Edit Profile");
                editButton.addActionListener(e -> openEditProfileDialog());
                dialogButtonPanel.add(editButton);

                profileDialog = new JDialog(this, "Profile Details", true);
                profileDialog.setLayout(new BorderLayout());
                profileDialog.add(scrollPane, BorderLayout.CENTER);
                profileDialog.add(dialogButtonPanel, BorderLayout.SOUTH);
                profileDialog.setSize(400, 300);
                profileDialog.setLocationRelativeTo(this);
                profileDialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Error retrieving profile details.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void openEditProfileDialog() {
        SwingUtilities.invokeLater(() -> {
            JDialog editDialog = new JDialog(this, "Edit Profile", true);
            editDialog.setLayout(new GridLayout(0, 2, 10, 10));
    
            String[][] profileData = fetchProfileDetails();
            if (profileData == null) {
                JOptionPane.showMessageDialog(editDialog, "Error retrieving profile details for editing.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            JTextField[] fields = new JTextField[profileData.length - 1]; 
            for (int i = 1; i < profileData.length; i++) {
                editDialog.add(new JLabel(profileData[i][0] + ":"));
                fields[i - 1] = new JTextField(profileData[i][1]);
                editDialog.add(fields[i - 1]);
            }
    
            JButton saveButton = new JButton("Save Changes");
            JButton backButton = new JButton("Back");
            saveButton.addActionListener(e -> {
                trainer.setName(fields[0].getText());
                trainer.setAge(Integer.parseInt(fields[1].getText()));
                trainer.setGender(fields[2].getText());
                trainer.setExperience(Integer.parseInt(fields[3].getText()));
                trainer.setPhone(fields[4].getText());
                trainer.setEmail(fields[5].getText());
                trainer.setAddress(fields[6].getText());
    
                updateProfile(trainer.getId(), trainer.getName(), trainer.getAge(), trainer.getGender(), trainer.getExperience(), trainer.getPhone(), trainer.getEmail(), trainer.getAddress());
                
                showProfileDetails();
    
                editDialog.dispose();
            });
            backButton.addActionListener(e -> editDialog.dispose());
            editDialog.add(saveButton);
            editDialog.add(backButton);
    
            editDialog.setSize(400, 300);
            editDialog.setLocationRelativeTo(this);
            editDialog.setVisible(true);
        });
    }

    private void updateProfile(int id, String name, int age, String gender, int experience, String phone, String email, String address) {
        String url = "jdbc:mysql://localhost:3306/GYM";
        String user = "root";
        String password = "123456";

        String query = "UPDATE trainers SET name = ?, age = ?, gender = ?, experience = ?, phone = ?, email = ?, address = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, gender);
            stmt.setInt(4, experience);
            stmt.setString(5, phone);
            stmt.setString(6, email);
            stmt.setString(7, address);
            stmt.setInt(8, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Profile updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Error updating profile.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String[][] fetchProfileDetails() {
        String url = "jdbc:mysql://localhost:3306/GYM";
        String user = "root";
        String password = "123456";

        String query = "SELECT id, name, age, gender, experience, phone, email, address FROM trainers WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, trainer.getId());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String[][] profileData = {
                        {"Trainer ID", rs.getString("id")},
                        {"Name", rs.getString("name")},
                        {"Age", rs.getString("age")},
                        {"Gender", rs.getString("gender")},
                        {"Experience (years)", rs.getString("experience")},
                        {"Phone", rs.getString("phone")},
                        {"Email", rs.getString("email")},
                        {"Address", rs.getString("address")}
                };
                return profileData;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; 
    }

     

    private void manageMembers() {
        JOptionPane.showMessageDialog(this, "Feature to manage members will be implemented soon."); 
    }
}
