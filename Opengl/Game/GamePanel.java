package Game;

import Game.Entity.Player;
import Game.Tile.TileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    private boolean openGamePanel = true;

    // Screen Size
    public final static int originalTitleSize = 16;
    public final static int scale = 3;
    public final static int titleSize = originalTitleSize * scale;
    public final static int maxScreenCol = 16;
    public final static int maxScreenRow = 12;
    public final static int screenWidth = titleSize * maxScreenCol;
    public final static int screenHeight = titleSize * maxScreenRow;

    // World Size
    public final static int maxWorldCol = 50;
    public final static int maxWorldRow = 50;
    public final int worldHeight = maxWorldRow * titleSize;
    public final int worldWidth = maxWorldCol * titleSize;

    // FPS
    int FPS = 60;

    TileManager tileM = new TileManager(this);
    static KeyHanld KeyH = new KeyHanld();

    Thread gameThread;

    // class player
    Player player = new Player(this, KeyH);

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

    // Run FPS
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
                remainingTime = remainingTime / 100000000;

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

    // Update Key Hanld
    public void update() {
        player.update();
    }

    // Function paint Component
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2);
        player.draw(g2);

        g2.dispose();

    }

}
