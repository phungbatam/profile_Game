package src.mainGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class runComponentMainGame extends JPanel implements Runnable {

    private final keyHanld key = new keyHanld();

    int FPS = 100;

    Thread Athread;

    // set Player's Default Coding
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public runComponentMainGame() {
        this.addKeyListener(key);
        this.setFocusable(true);
        Athread = new Thread(this);
        Athread.start();
    }

    @Override
    public void run() {

        double drawInteval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInteval;

        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        long Timer = 0;
        int drawCownt = 0;

        while (Athread != null) {

            try {
                currentTime = System.nanoTime();

                double remainningTime = nextDrawTime - System.nanoTime();
                remainningTime /= 100000000;

                delta += (currentTime - lastTime) / drawInteval;
                Timer += (currentTime - lastTime);

                lastTime = currentTime;

                if (delta >= 1) {
                    update();
                    repaint();
                    delta--;
                    drawCownt++;
                }

                if(Timer >= 1000000000){
                    System.out.println("FPS: " + drawCownt);
                    drawCownt = 0;
                    Timer = 0;
                }

                Thread.sleep((long) remainningTime);

                nextDrawTime += drawInteval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void update() {
        if (key.upPressed == true) {
            playerY -= playerSpeed;
        } else if (key.downPressed == true) {
            playerY += playerSpeed;
        } else if (key.leftPressed == true) {
            playerX -= playerSpeed;
        } else if (key.rightPressed == true) {
            playerX += playerSpeed;
        } else {
            // ...
        }
    }

    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        Graphics2D graph = (Graphics2D) gr;
        graph.setColor(Color.WHITE);
        setBounds(playerX, playerY, 100, 100);
        graph.fillRect(playerX, playerY, 1, 1);
        gr.dispose();
    }

}
