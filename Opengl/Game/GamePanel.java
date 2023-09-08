package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    private boolean openGamePanel = true;

    protected final static int originalTitleSize = 16;
    protected final static int scale = 3;

    protected final static int titleSize = originalTitleSize * scale;
    protected final static int maxScreenCol = 16;
    protected final static int maxScreenRow = 12;
    protected final static int screenWidth = titleSize * maxScreenCol;
    protected final static int screenHeight = titleSize * maxScreenRow;

    // FPS
    int FPS = 60;

    static KeyHanld KeyH = new KeyHanld();

    Thread gameThread;

    // Set Player is default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {

        if (!openGamePanel) {
            this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        }
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(KeyH);
        this.setFocusable(true);
        startGameThread();
        // System.out.println("Hello World");d

    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime();

        while (gameThread != null) {
            // System.out.println("Game loop");

            // 1 UPDATE: update information such as character position

            update();

            // 2 DRAW: draw the screen with the updated information

            repaint();

            try {

                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 10000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public void update() {
        if (KeyH.upPressed == true) {
            playerY -= playerSpeed;
        } else if (KeyH.downPressed == true) {
            playerY += playerSpeed;
        } else if (KeyH.leftPressed == true) {
            playerX -= playerSpeed;
        } else if (KeyH.rightPressed == true) {
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);

        g2.fillRect(playerX, playerY, titleSize, titleSize);

        g2.dispose();

    }

}
