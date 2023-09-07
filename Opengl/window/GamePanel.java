package window;

import java.awt.Color;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
    
    private Thread gameThread;

    public GamePanel() {

        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);    

    }

    public void startGameThread() {
        gameThread = new Thread();
        gameThread.start();
    }

}
