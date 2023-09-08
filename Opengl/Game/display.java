package Game;

import javax.swing.JFrame;

public class display {

    private JFrame JF_display;

    public display() {
        
        openWindow();

    }

    public JFrame openWindow() {

        JF_display = new JFrame();
        
        JF_display.setTitle("2D Adventure");

        JF_display.setSize(GamePanel.screenWidth, GamePanel.screenHeight);

        GamePanel game = new GamePanel();
        JF_display.add(game);
        // JF_display.addKeyListener(GamePanel);
        JF_display.setResizable(false);
        JF_display.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JF_display.setLocationRelativeTo(null);
        JF_display.setVisible(true);
        return JF_display;
    }

}
