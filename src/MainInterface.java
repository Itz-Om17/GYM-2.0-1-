import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainInterface {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private BufferedImage bgImage;

    public MainInterface() {
        try {
            // Load the background image
            bgImage = ImageIO.read(new File("C:\\Users\\OM\\OneDrive\\Desktop\\GYM 2.0(1)\\src\\MAIN INTERFACE 2.0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame = new JFrame("Gym Management System");
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Add panels to the card layout
        cardPanel.add(createMainPanel(), "Main");
        cardPanel.add(createAdminLoginPanel(), "AdminLogin");
        cardPanel.add(new TrainerLoginPanel(cardLayout, cardPanel, frame), "TrainerLogin");  // Trainer Login Panel
        cardPanel.add(new MemberLoginPanel(this), "MemberLogin");  // Member Login Panel
        cardPanel.add(new MemberDashboard(frame, this, ""), "MemberDashboard");
        cardPanel.add(new aboutus(this), "AboutUs");  // Pass 'this' reference to AboutUs

        frame.add(cardPanel);

        // Set the size of the frame
        frame.setSize(800, 600);  

        // Set the window to maximized state
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  

        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  
        frame.setVisible(true);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getCardPanel() {
        return cardPanel;
    }

    public JFrame getFrame() {
        return frame;
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);  
            }
        };
        panel.setLayout(new BorderLayout()); 

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 20));  // Align to top-right
        buttonPanel.setOpaque(false); 

        Color textColor = Color.WHITE;
        Font buttonFont = new Font("Arial", Font.BOLD, 16); 

        // Create buttons with modern design (transparent background)
        JButton memberButton = createStyledButton("Member", textColor, textColor, buttonFont);
        JButton trainerButton = createStyledButton("Trainer", textColor, textColor, buttonFont);
        JButton adminButton = createStyledButton("Admin", textColor, textColor, buttonFont);
        JButton aboutButton = createStyledButton("About Us", textColor, textColor, buttonFont);

        ImageIcon exitIcon = new ImageIcon("C:\\Users\\OM\\OneDrive\\Desktop\\GYM 2.0(1)\\src\\exit logo.png");
        Image exitImage = exitIcon.getImage();  
        Image scaledExitImage = exitImage.getScaledInstance(40, 30, Image.SCALE_SMOOTH);  // Resize to match button size
        exitIcon = new ImageIcon(scaledExitImage);

        JButton exitButton = new JButton(exitIcon);
        exitButton.setPreferredSize(new Dimension(95, 30));  
        styleAsTextButton(exitButton);

        styleAsTextButton(memberButton);
        styleAsTextButton(trainerButton);
        styleAsTextButton(adminButton);
        styleAsTextButton(aboutButton);
        styleAsTextButton(exitButton);

        // Add buttons to the panel
        buttonPanel.add(memberButton);
        buttonPanel.add(trainerButton);
        buttonPanel.add(adminButton);
        buttonPanel.add(aboutButton);
        buttonPanel.add(exitButton);

        panel.add(buttonPanel, BorderLayout.NORTH);  

        // Center logo or title
        JLabel titleLabel = new JLabel("", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 60));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel, BorderLayout.CENTER);  

        // Action Listeners for buttons
        adminButton.addActionListener(e -> cardLayout.show(cardPanel, "AdminLogin"));
        trainerButton.addActionListener(e -> cardLayout.show(cardPanel, "TrainerLogin")); // Show Trainer Login Panel
        memberButton.addActionListener(e -> cardLayout.show(cardPanel, "MemberLogin")); // Show Member Login Panel
        exitButton.addActionListener(e -> System.exit(0));
        aboutButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "AboutUs");
            cardPanel.requestFocusInWindow(); 
        });

        return panel;
    }

    private JButton createStyledButton(String text, Color textColor, Color bgColor, Font font) {
        JButton button = new JButton(text);
        button.setForeground(textColor);
        button.setBackground(bgColor);  
        button.setFont(font);button.setFocusPainted(false);  
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));  
        return button;
    }

    private void styleAsTextButton(JButton button) {
        button.setContentAreaFilled(false); 
        button.setBorderPainted(false);  
        button.setFocusPainted(false);  
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));  
    }
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;
    
        public BackgroundPanel(String imagePath) {
            try {
                backgroundImage = new ImageIcon(getClass().getResource("/ADMINLOGIN.png")).getImage();
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
    private JPanel createAdminLoginPanel() {
        BackgroundPanel panel = new BackgroundPanel("C:\\Users\\OM\\OneDrive\\Desktop\\GYM 2.0(1)\\src\\ADMINLOGIN.png");
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel usernameLabel = createStyledLabel("Username:", Color.DARK_GRAY);
        JTextField usernameField = new JTextField(15);
        JLabel passwordLabel = createStyledLabel("Password:", Color.DARK_GRAY);
        JPasswordField passwordField = new JPasswordField(15);

        JButton proceedButton = createStyledButton("Login", Color.BLACK, new Color(0x48C9B0), new Font("Arial", Font.BOLD, 15));
        JButton cancelButton = createStyledButton("Cancel", Color.black, new Color(0x48C9B0), new Font("Arial", Font.BOLD, 15));

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(proceedButton, gbc);

        gbc.gridy = 3;
        panel.add(cancelButton, gbc);

        // Action listeners
        proceedButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("Admin") && password.equals("admin@123")) {
                new AdminDashboard(this).setVisible(true);
                frame.dispose();  
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> cardLayout.show(cardPanel, "Main"));

        return panel;
    }

    private JLabel createStyledLabel(String text, Color color) {
        JLabel label = new JLabel(text);
        label.setForeground(color);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        return label;
    }

    public void showMainPanel() {
        frame.setVisible(true);  
        cardLayout.show(cardPanel, "Main");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainInterface::new);
    }
}