import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class aboutus extends JPanel {
    private JLabel imageLabel;
    private BufferedImage[] originalImages;
    private ImageIcon[] scaledImages;
    private int currentImageIndex = 0;
    private JButton backButton;
    private MainInterface mainInterface;
    private JLayeredPane layeredPane;
    private JProgressBar loadingProgress;
    private ExecutorService imageLoader;
    private final AtomicBoolean isLoading = new AtomicBoolean(true);
    
    private ImageIcon nextScaledImage;
    private ImageIcon previousScaledImage;

    private JButton nextButton;
    private JButton prevButton;

    public aboutus(MainInterface mainInterface) {
        this.mainInterface = mainInterface;
        setLayout(new BorderLayout());
        imageLoader = Executors.newFixedThreadPool(2);

        layeredPane = new JLayeredPane();
        add(layeredPane, BorderLayout.CENTER);

        setupComponents();
        setupKeyBindings();
        loadImagesAsync();

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeComponents();
            }
        });

        resizeComponents();
    }

    private void setupComponents() {
        setupImageLabel();

        loadingProgress = new JProgressBar(0, 100);
        loadingProgress.setStringPainted(true);
        loadingProgress.setString("Loading images...");
        loadingProgress.setForeground(new Color(255, 69, 0));
        loadingProgress.setBackground(new Color(0, 0, 0, 80));
        loadingProgress.setBorderPainted(false);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> mainInterface.getCardLayout().show(mainInterface.getCardPanel(), "Main"));
        styleButton(backButton);

        nextButton = new JButton("→");
        prevButton = new JButton("←");
        styleNavigationButton(nextButton);
        styleNavigationButton(prevButton);
        
        nextButton.addActionListener(e -> showNextImage());
        prevButton.addActionListener(e -> showPreviousImage());

        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(loadingProgress, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(backButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(nextButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(prevButton, JLayeredPane.PALETTE_LAYER);
    }

    private void setupImageLabel() {
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        imageLabel.setBorder(null);
    }

    private void styleButton(JButton button) {
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0, 0, 0, 0));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFont(new Font("Arial", Font.BOLD, 16));
        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(new Color(255, 255, 255, 200));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(Color.WHITE);
            }
        });
    }

    private void styleNavigationButton(JButton button) {
        button.setForeground(new Color(255, 255, 255, 150));
        button.setBackground(new Color(0, 0, 0, 0));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFont(new Font("Arial", Font.BOLD, 48));
        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(new Color(255, 255, 255, 255));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(new Color(255, 255, 255, 150));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                button.setForeground(new Color(255, 255, 255, 100));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setForeground(new Color(255, 255, 255, 150));
            }
        });
    }
    
    private void setupKeyBindings() {
        InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "nextImage");
        actionMap.put("nextImage", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextImage();
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "previousImage");
        actionMap.put("previousImage", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPreviousImage();
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "back");
        actionMap.put("back", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainInterface.getCardLayout().show(mainInterface.getCardPanel(), "Main");
            }
        });
    }

    private void loadImagesAsync() {
        String[] imagePaths = {
    "src/images/1.png",
    "src/images/2.png",
    "src/images/3.png",
    "src/images/4.png",
    "src/images/5.png",
    "src/images/6.png",
    "src/images/7.png",
    "src/images/8.png",
    "src/images/9.png"
};


        originalImages = new BufferedImage[imagePaths.length];
        scaledImages = new ImageIcon[imagePaths.length];

        CompletableFuture.supplyAsync(() -> {
            for (int i = 0; i < imagePaths.length; i++) {
                final int index = i;
                try {
                    File file = new File(imagePaths[i]);
                    if (!file.exists()) {
                        System.err.println("File does not exist: " + imagePaths[i]);
                        continue;
                    }
                    originalImages[i] = ImageIO.read(file);
                    
                    final int progress = (int) ((i + 1) * 100.0 / imagePaths.length);
                    SwingUtilities.invokeLater(() -> {
                        loadingProgress.setValue(progress);
                        loadingProgress.setString("Loading images... " + progress + "%");
                    });
                    
                } catch (IOException e) {
                    System.err.println("Error loading image: " + imagePaths[i]);
                    System.err.println("Error details: " + e.getMessage());
                }
            }
            return true;
        }, imageLoader).thenAcceptAsync(completed -> {
            resizeImagesToFitPanel();
            isLoading.set(false);
            SwingUtilities.invokeLater(() -> {
                loadingProgress.setVisible(false);
                nextButton.setVisible(true);
                prevButton.setVisible(true);
                updateImage();
                preloadAdjacentImages();
            });
        }, imageLoader);

        nextButton.setVisible(false);
        prevButton.setVisible(false);
    }

    private void resizeImagesToFitPanel() {
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        
        if (panelWidth <= 0 || panelHeight <= 0 || originalImages == null) return;

        for (int i = 0; i < originalImages.length; i++) {
            if (originalImages[i] != null) {
                final int imageIndex = i;
                imageLoader.submit(() -> {
                    BufferedImage resized = createScaledImage(originalImages[imageIndex], panelWidth, panelHeight);
                    scaledImages[imageIndex] = new ImageIcon(resized);
                    if (imageIndex == currentImageIndex) {
                        SwingUtilities.invokeLater(this::updateImage);
                    }
                });
            }
        }
    }

    private BufferedImage createScaledImage(BufferedImage original, int width, int height) {
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, width, height);
        
        double panelRatio = (double) width / height;
        double imageRatio = (double) original.getWidth() / original.getHeight();
        
        int targetWidth, targetHeight;
        int x = 0, y = 0;
        
        if (panelRatio > imageRatio) {
            targetWidth = width;
            targetHeight = (int) (width / imageRatio);
            y = (height - targetHeight) / 2;
        } else {
            targetHeight = height;
            targetWidth = (int) (height * imageRatio);
            x = (width - targetWidth) / 2;
        }
        
        g2d.drawImage(original, x, y, targetWidth, targetHeight, null);
        g2d.dispose();
        
        return resized;
    }

    private void preloadAdjacentImages() {
        if (scaledImages == null || scaledImages.length <= 1) return;

        int nextIndex = (currentImageIndex + 1) % scaledImages.length;
        int prevIndex = (currentImageIndex - 1 + scaledImages.length) % scaledImages.length;

        imageLoader.submit(() -> {
            nextScaledImage = scaledImages[nextIndex];
            previousScaledImage = scaledImages[prevIndex];
        });
    }

    private void showNextImage() {
        if (scaledImages != null && scaledImages.length > 0 && !isLoading.get()) {
            currentImageIndex = (currentImageIndex + 1) % scaledImages.length;
            updateImage();
            preloadAdjacentImages();
        }
    }

    private void showPreviousImage() {
        if (scaledImages != null && scaledImages.length > 0 && !isLoading.get()) {
            currentImageIndex = (currentImageIndex - 1 + scaledImages.length) % scaledImages.length;
            updateImage();
            preloadAdjacentImages();
        }
    }

    private void updateImage() {
        if (scaledImages != null && scaledImages.length > 0 && currentImageIndex < scaledImages.length) {
            ImageIcon currentImage = scaledImages[currentImageIndex];
            if (currentImage != null) {
                imageLabel.setIcon(currentImage);
            }
        }
    }

    private void resizeComponents() {
        int width = getWidth();
        int height = getHeight();
        
        layeredPane.setBounds(0, 0, width, height);
        imageLabel.setBounds(0, 0, width, height);
        
        backButton.setBounds(20, 20, 100, 30);
        
        int navButtonWidth = 60;
        int navButtonHeight = 100;
        nextButton.setBounds(width - navButtonWidth - 20, 
                           (height - navButtonHeight) / 2,
                           navButtonWidth, navButtonHeight);
        prevButton.setBounds(20, 
                           (height - navButtonHeight) / 2,
                           navButtonWidth, navButtonHeight);
        
        int progressWidth = 200;
        int progressHeight = 20;
        loadingProgress.setBounds((width - progressWidth) / 2, 
                                (height - progressHeight) / 2,
                                progressWidth, progressHeight);
        
        if (!isLoading.get()) {
            resizeImagesToFitPanel();
        }
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        resizeComponents();
    }

    public void cleanup() {
        imageLoader.shutdown();
        try {
            if (!imageLoader.awaitTermination(500, TimeUnit.MILLISECONDS)) {
                imageLoader.shutdownNow();
            }
        } catch (InterruptedException e) {
            imageLoader.shutdownNow();
        }
    }
}