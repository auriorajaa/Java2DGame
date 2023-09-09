package main;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {
    // MAIN METHOD

    public static JFrame window;

    public static void main(String[] args) {
        window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Close (X) button
        window.setResizable(false); // User unable to resize the window
        window.setTitle("2D Adventure"); // Title of the Apps

        // Call GamePanel
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        gamePanel.config.loadConfig();
        if (gamePanel.fullScreenOn == true) {
            window.setUndecorated(true);
        }

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}
