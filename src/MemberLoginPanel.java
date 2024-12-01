import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileOutputStream;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MemberLoginPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JPanel loginPanel;
    private JPanel registrationPanel;
    private JTextField daysPerWeekField; 
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField heightField;

    public MemberLoginPanel(MainInterface mainInterface) {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        loginPanel = createLoginPanel(mainInterface);
        registrationPanel = createRegistrationPanel();

        mainPanel.add(loginPanel, "Login");
        mainPanel.add(registrationPanel, "Register");

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        cardLayout.show(mainPanel, "Login");
    }
    public Connection getConnection() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/GYM"; 
            String user = "root";  
            String password = "123456"; 

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to MySQL established successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to connect to database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }
class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        try {
            backgroundImage = new ImageIcon("src/images/memberloginpanel.png").getImage();

        } catch (Exception e) {
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
class BackgroundPanel1 extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel1(String imagePath) {
        try {
            backgroundImage = new ImageIcon("src/images/MEMBERREGISTER.png").getImage();

        } catch (Exception e) {
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
private JPanel createLoginPanel(MainInterface mainInterface) {
    BackgroundPanel panel = new BackgroundPanel("src/images/memberloginpanel.png");
    panel.setLayout(new GridBagLayout());
    
    JPanel loginComponentsPanel = new JPanel(new GridBagLayout());
    loginComponentsPanel.setBackground(new Color(240, 240, 240, 0)); 
    loginComponentsPanel.setForeground(Color.black);
    loginComponentsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    JLabel usernameLabel = new JLabel("Username:");
    usernameLabel.setForeground(Color.white);
    usernameField = new JTextField(15);
    JLabel passwordLabel = new JLabel("Password:");
    passwordLabel.setForeground(Color.white);
    passwordField = new JPasswordField(15);

    // Buttons
    
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");
    JButton backButton = new JButton("Back");

    // Styling (keep your existing styling code)
    Color buttonColor = (new Color(0x48C9B0));
    Color textColor = Color.black;
    Font buttonFont = new Font("Arial", Font.BOLD, 14);
    Font labelFont = new Font("Arial", Font.BOLD, 14);

    // Style components as in your original code
    loginButton.setBackground(buttonColor);
    loginButton.setForeground(textColor);
    loginButton.setFont(buttonFont);
    registerButton.setBackground(buttonColor);
    registerButton.setForeground(textColor);
    registerButton.setFont(buttonFont);
    backButton.setBackground(buttonColor);
    backButton.setForeground(textColor);
    backButton.setFont(buttonFont);


    usernameLabel.setFont(labelFont);
    passwordLabel.setFont(labelFont);

    gbc.gridx = 0;
    gbc.gridy = 0;
    loginComponentsPanel.add(usernameLabel, gbc);
    gbc.gridx = 1;
    loginComponentsPanel.add(usernameField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    loginComponentsPanel.add(passwordLabel, gbc);
    gbc.gridx = 1;
    loginComponentsPanel.add(passwordField, gbc);

    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.anchor = GridBagConstraints.CENTER;
    loginComponentsPanel.add(loginButton, gbc);

    gbc.gridy = 3;
    loginComponentsPanel.add(registerButton, gbc);

    gbc.gridy = 4;
    loginComponentsPanel.add(backButton, gbc);

    panel.add(loginComponentsPanel);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
        
            try (Connection conn = getConnection()) {
                String sql = "SELECT * FROM members WHERE username = ? AND password = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
        
                ResultSet rs = pstmt.executeQuery();
        
                if (rs.next()) {
                    JOptionPane.showMessageDialog(mainInterface.getFrame(), "Member Login Successful", "Login", JOptionPane.INFORMATION_MESSAGE);

                    clearLoginFields();
        
                    MemberDashboard memberDashboard = new MemberDashboard(mainInterface.getFrame(), mainInterface, username);
                    mainInterface.getCardPanel().add(memberDashboard, "MemberDashboard");
                    
                    CardLayout cardLayout = mainInterface.getCardLayout();
                    cardLayout.show(mainInterface.getCardPanel(), "MemberDashboard");  
                    
                } else {
                    JOptionPane.showMessageDialog(mainInterface.getFrame(), "Invalid username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error accessing member data.", "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        registerButton.addActionListener(e -> cardLayout.show(mainPanel, "Register"));

        backButton.addActionListener(e -> mainInterface.showMainPanel());

        return panel;
    }


private JTextField regUsernameField, nameField, ageField, weightField, addressField, phoneField, emailField, feetField;
private JLabel infoLabel; 
    private JPasswordField regPasswordField;
    private JComboBox<String> genderBox, goalBox, timingBox, inchesBox, membershipDropdown;

    public JPanel createRegistrationPanel() {
        BackgroundPanel1 panel2 = new BackgroundPanel1("src/images/MEMBERREGISTER.png");
        panel2.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        regUsernameField = new JTextField(15);
        regPasswordField = new JPasswordField(15);
        nameField = new JTextField(15);
        ageField = new JTextField(15);
        genderBox = new JComboBox<>(new String[]{"Male", "Female"});
        weightField = new JTextField(15);
        addressField = new JTextField(15);
        phoneField = new JTextField(15);
        emailField = new JTextField(15);
        feetField = new JTextField(5);
        infoLabel = new JLabel("");

       
    JComboBox<String> paymentModeDropdown = new JComboBox<>(new String[]{"Select a payment mode", "Pay Via UPI", "Cash"});
    addToPanel(panel2, gbc, 14, "Payment Mode", paymentModeDropdown);
        membershipDropdown = new JComboBox<>();
        populateMembershipDropdown();
        
        membershipDropdown.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value != null) {
                    String selectedPlan = value.toString();
                    String planName = selectedPlan.split(" - ")[0]; 
                    String tooltip = getTooltipForPlan(planName); 
                    setToolTipText(tooltip);
                }
                return this;
            }
        
            private String getTooltipForPlan(String planName) {
                String tooltip = "No additional information available."; 
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GYM", "root", "123456")) {
                    String query = "SELECT free_classes, consultations, additional_benefits FROM Membership WHERE plan_name = ?";
                    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                        pstmt.setString(1, planName);
                        ResultSet rs = pstmt.executeQuery();
        
                        if (rs.next()) {
                            int freeClasses = rs.getInt("free_classes");
                            int consultations = rs.getInt("consultations");
                            String additionalBenefits = rs.getString("additional_benefits");
        
                            tooltip = "Free Classes: " + (freeClasses == -1 ? "Unlimited" : freeClasses) +
                                      "\nConsultations: " + consultations +
                                      "\nBenefits: " + additionalBenefits;
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return tooltip; 
            }
        });
        
    
        membershipDropdown.addActionListener(e -> {
            String selectedPlan = (String) membershipDropdown.getSelectedItem();
            
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GYM", "root", "123456");
                String query = "SELECT free_classes, consultations, discount_percent, additional_benefits FROM Membership WHERE plan_name = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, selectedPlan.split(" ")[0]); 
                ResultSet rs = pstmt.executeQuery();
    
                if (rs.next()) {
                    int freeClasses = rs.getInt("free_classes");
                    int consultations = rs.getInt("consultations");
                    double discount = rs.getDouble("discount_percent");
                    String additionalBenefits = rs.getString("additional_benefits");
    
                    String details = "Free Classes: " + (freeClasses == -1 ? "Unlimited" : freeClasses) + 
                                     "\nConsultations: " + consultations +
                                     "\nDiscount: " + discount + "%" +
                                     "\nBenefits: " + additionalBenefits;
                    infoLabel.setText(details); 
                }
    
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        goalBox = new JComboBox<>(new String[]{
                "SELECT A GOAL", 
                "General Workout", 
                "Weight Loss", 
                "Muscle Gain", 
                "Improve Endurance", 
                "Enhanced Flexibility"
        });

        timingBox = new JComboBox<>(new String[]{
                "Select a timing", 
                "6:00 AM - 10:00 AM", 
                "10:00 AM - 2:00 PM", 
                "2:00 PM - 6:00 PM", 
                "6:00 PM - 10:00 PM"
        });
        inchesBox = new JComboBox<>(new String[]{
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"
        });

        JLabel daysPerWeekLabel = new JLabel("Days Per Week (4-6):");
        SpinnerModel daysPerWeekModel = new SpinnerNumberModel(4, 4, 6, 1);
        JSpinner daysPerWeekSpinner = new JSpinner(daysPerWeekModel);

        addToPanel(panel2, gbc, 0, "Create Username", regUsernameField);
        addToPanel(panel2, gbc, 1, "Create Password", regPasswordField);
        addToPanel(panel2, gbc, 2, "Name", nameField);
        addToPanel(panel2, gbc, 3, "Age", ageField);
        addToPanel(panel2, gbc, 4, "Gender", genderBox);
        addToPanel(panel2, gbc, 5, "Goal", goalBox);
        addToPanel(panel2, gbc, 6, "Weight (kg)", weightField);
        addToPanel(panel2, gbc, 7, "Timing", timingBox);
        addToPanel(panel2, gbc, 8, "Membership Plan", membershipDropdown);

        gbc.gridx = 0;
        gbc.gridy = 9;
        JLabel heightLabel = new JLabel("Height");
heightLabel.setForeground(Color.WHITE);  
panel2.add(heightLabel, gbc);
        
        gbc.gridx = 1;
        panel2.add(feetField, gbc);
        gbc.gridx = 2;
        JLabel ftLabel = new JLabel("ft");
ftLabel.setForeground(Color.WHITE);  
panel2.add(ftLabel, gbc);
        
        gbc.gridx = 3;
        panel2.add(inchesBox, gbc);
        gbc.gridx = 4;
        JLabel inLabel = new JLabel("in");
inLabel.setForeground(Color.WHITE);  
panel2.add(inLabel, gbc);

        addToPanel(panel2, gbc, 10, "Address", addressField);
        addToPanel(panel2, gbc, 11, "Phone No.", phoneField);
        addToPanel(panel2, gbc, 12, "Email", emailField);
        gbc.gridx = 0;
        gbc.gridy = 13;
        daysPerWeekLabel.setForeground(Color.WHITE);
        panel2.add(daysPerWeekLabel, gbc);
        gbc.gridx = 1;
        panel2.add(daysPerWeekSpinner, gbc);

        JButton registerButton = new JButton("Register");
        Color registerButtonColor = new Color(0x48C9B0);
        Color backButtonColor = new Color(0x48C9B0);
        JButton backButton = new JButton("Back");
        registerButton.setBackground(registerButtonColor);
        backButton.setBackground(backButtonColor);

        gbc.gridy = 15;
        gbc.anchor = GridBagConstraints.CENTER;
        panel2.add(registerButton, gbc);

        gbc.gridy = 16;
        panel2.add(backButton, gbc);

        registerButton.addActionListener(e -> registerMember(goalBox, timingBox, daysPerWeekSpinner, paymentModeDropdown));
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Login"));

        return panel2;
    }

    private void addToPanel(JPanel panel, GridBagConstraints gbc, int row, String labelText, JComponent field) {
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel label = new JLabel(labelText);
        label.setForeground(Color.WHITE);  
        panel.add(label, gbc);
        
        gbc.gridx = 1;
        panel.add(field, gbc);
    }

    private void populateMembershipDropdown() {
        try {
        
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GYM", "root", "123456");
            String query = "SELECT plan_name, price, duration_months FROM Membership";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String planName = rs.getString("plan_name");
                double price = rs.getDouble("price");
                int duration = rs.getInt("duration_months");
                
                membershipDropdown.addItem(planName + " - ₹" + price + " (" + duration + " months)");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void registerMember(JComboBox<String> goalBox, JComboBox<String> timingBox, JSpinner daysPerWeekSpinner, JComboBox<String> paymentModeDropdown) {
        String username = regUsernameField.getText();
        String password = new String(regPasswordField.getPassword());
        String name = nameField.getText();
        String age = ageField.getText();
        String gender = (String) genderBox.getSelectedItem();
        String goal = (String) goalBox.getSelectedItem();
        String timing = (String) timingBox.getSelectedItem();
        String weight = weightField.getText();
        String address = addressField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String selectedMembership = (String) membershipDropdown.getSelectedItem();

String price = selectedMembership.split("₹")[1].split(" ")[0];

double amountPaid = Double.parseDouble(price);
System.out.println(amountPaid);

        String paymentMode = (String) paymentModeDropdown.getSelectedItem();
        String paymentDetails = "";
        
        if (username.isEmpty() || password.isEmpty() || name.isEmpty() || age.isEmpty() ||
        goal.equals("SELECT A GOAL") || weight.isEmpty() || address.isEmpty() ||
        phone.isEmpty() || email.isEmpty() || timing.equals("Select a timing") ||
        paymentMode.equals("Select a payment mode")) {
        JOptionPane.showMessageDialog(this, "All fields must be filled correctly.", "Registration Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
        int heightFt;
        try {
            heightFt = Integer.parseInt(feetField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Height in feet must be a valid integer.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int heightInch = Integer.parseInt((String) inchesBox.getSelectedItem());
        int daysPerWeek = (int) daysPerWeekSpinner.getValue();
    
        try (Connection conn = getConnection()) {
            String sql = "INSERT INTO members (username, password, name, age, gender, goal, weight, height_ft, height_inch, address, phone, email, daysperweek, timing, membership_plan) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                pstmt.setString(3, name);
                pstmt.setString(4, age);
                pstmt.setString(5, gender);
                pstmt.setString(6, goal);
                pstmt.setString(7, weight);
                pstmt.setInt(8, heightFt);
                pstmt.setInt(9, heightInch);
                pstmt.setString(10, address);
                pstmt.setString(11, phone);
                pstmt.setString(12, email);
                pstmt.setInt(13, daysPerWeek);
                pstmt.setString(14, timing);
                pstmt.setString(15, selectedMembership);
    
                pstmt.executeUpdate();
                if (paymentMode.equals("Pay Via UPI")) {
                    paymentDetails = processUPIPayment();
                    
                    if (paymentDetails != null) {
                        try {
                            PDFGenerator.generatePaymentReceipt(paymentDetails, amountPaid);
                            JOptionPane.showMessageDialog(this, "Payment receipt PDF has been generated.", "PDF Generated", JOptionPane.INFORMATION_MESSAGE);
                        } catch (Exception e) {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(this, "Failed to generate PDF receipt: " + e.getMessage(), "PDF Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        return; 
                    }
                }
                TrainerAllotment allotment = new TrainerAllotment();
        allotment.allocateTrainerToMembers();
                JOptionPane.showMessageDialog(this, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                clearFields();
                cardLayout.show(mainPanel, "Login");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Registration failed. Please try again.", "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
        }
    }
    private String processUPIPayment() {
        JTextField nameField = new JTextField();
        JTextField upiIdField = new JTextField();
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setMinSelectableDate(new Date()); 
    
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("UPI ID:"));
        panel.add(upiIdField);
        panel.add(new JLabel("Date of Payment:"));
        panel.add(dateChooser);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "UPI Payment Details",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String upiId = upiIdField.getText();
            Date paymentDate = dateChooser.getDate();
    
            if (name.isEmpty() || upiId.isEmpty() || paymentDate == null) {
                JOptionPane.showMessageDialog(this, "All fields must be filled.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
    
            int confirm = JOptionPane.showConfirmDialog(this, "Confirm payment details?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "Payment successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                return name + "," + upiId + "," + sdf.format(paymentDate);
            } else {
                return null;
            }
        }
        return null;
    }
   
    private void clearLoginFields() {
        usernameField.setText("");
        passwordField.setText("");
    }

private void clearFields() {
        regUsernameField.setText("");
        regPasswordField.setText("");
        nameField.setText("");
        ageField.setText("");
        weightField.setText("");
        addressField.setText("");
        phoneField.setText("");
        emailField.setText("");
        feetField.setText("");
        genderBox.setSelectedIndex(0);
        goalBox.setSelectedIndex(0);
        timingBox.setSelectedIndex(0);
        membershipDropdown.setSelectedIndex(0);
        inchesBox.setSelectedIndex(0);
    }
}