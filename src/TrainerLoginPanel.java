import javax.swing.*;
import com.itextpdf.text.Jpeg2000.ColorSpecBox;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainerLoginPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JFrame frame;

    private static final String URL = "jdbc:mysql://localhost:3306/GYM";  
    private static final String USER = "root";  
    private static final String PASSWORD = "123456";  
    private JTextField usernameField;
    private JPasswordField passwordField;

     class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            try {
                backgroundImage = new ImageIcon(getClass().getResource("/TRAINERLOGIN.png")).getImage();
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

    public TrainerLoginPanel(CardLayout cardLayout, JPanel cardPanel, JFrame frame) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        this.frame = frame;

        BackgroundPanel backgroundPanel = new BackgroundPanel("C:\\Users\\OM\\OneDrive\\Desktop\\GYM 2.0(1)\\src\\TRAINERLOGIN.png");
        backgroundPanel.setLayout(new GridBagLayout()); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false); 
        JLabel usernameLabel = createStyledLabel("Username:");
        usernameField = new JTextField(15);
        usernameLabel.setForeground(Color.WHITE);
        

        JLabel passwordLabel = createStyledLabel("Password:");
        passwordField = new JPasswordField(15);
        passwordLabel.setForeground(Color.WHITE);

        JButton loginButton = createStyledButton("Login", new Color(0x48C9B0));
        JButton backButton = createStyledButton("Back", new Color(0x48C9B0));

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(usernameLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(loginButton, gbc);

        gbc.gridy = 3;
        formPanel.add(backButton, gbc);

        backgroundPanel.add(formPanel, gbc);

        setLayout(new BorderLayout());
        add(backgroundPanel, BorderLayout.CENTER);

        loginButton.addActionListener(e -> authenticateTrainer());
        backButton.addActionListener(e -> cardLayout.show(cardPanel, "Main"));
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private void authenticateTrainer() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username or password cannot be empty.", "Login Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM trainers WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);  
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(frame, "Login successful.", "Login", JOptionPane.INFORMATION_MESSAGE);
                clearLoginFields();

                Trainer trainer = getTrainerDetails(rs);
                TrainerDashboard trainerDashboard = new TrainerDashboard(trainer);
                trainerDashboard.setVisible(true);
                frame.dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error accessing trainer data.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Trainer getTrainerDetails(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        String gender = rs.getString("gender");
        int experience = rs.getInt("experience");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        String address = rs.getString("address");

        String specialization = "Fitness"; 
        return new Trainer(id, name, specialization, experience, experience, phone, specialization, specialization);
            }

    private void clearLoginFields() {
        usernameField.setText("");
        passwordField.setText("");
    }

    private JButton createStyledButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setBackground(backgroundColor);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        return button;
    }

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.DARK_GRAY);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        return label;
    }
}
