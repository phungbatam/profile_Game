package window;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Game.display;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class windows extends GamePanel {

    private int WIDTH, HEIGHT;

    private String TITLE;

    private ImageIcon iamgeBackGround = new ImageIcon("D:\\NONE\\C++\\Opengl\\resource\\Anime_1.jpg");
    private JLabel laAddBackground = new JLabel("", iamgeBackGround, JLabel.CENTER);

    private JFrame openWindow;

    private Cursor cursorHanld = new Cursor(Cursor.HAND_CURSOR);

    public windows(JFrame openWindow, final int width, final int height, final String TITLE) {

        this.openWindow = openWindow;
        this.WIDTH = width;
        this.HEIGHT = height;
        this.TITLE = TITLE;

        openWindow.setTitle(TITLE);

        openWindow.setLocationRelativeTo(null);
        openWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        openWindow.setResizable(false);
        openWindow.setLocationRelativeTo(null);
        openWindow.setAlwaysOnTop(false);
        openWindow.setSize(width, height);

        laAddBackground.setBounds(0, 0, width, height);

        JButton JB_Play = new JButton();
        JB_Play.setBounds(1000, 590, 200, 50);
        JB_Play.setFocusable(false);
        JB_Play.setText("Play");
        JB_Play.setForeground(Color.decode("#0000000"));
        JB_Play.setFont(new Font("Arial", Font.PLAIN, 16));
        JB_Play.setBackground(Color.decode("#4edf86"));
        JB_Play.setCursor(cursorHanld);
        JB_Play.setToolTipText("Play Game");
        JB_Play.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                openWindow.dispose();
                display winGame = new display();
                winGame.openWindow().setVisible(true);;
            }

        });
        openWindow.add(JB_Play);
        openWindow.getContentPane().add(laAddBackground);

        openWindow.setLayout(null);
        GamePanel game = new GamePanel();

        openWindow.add(game);
        openWindow.setLayout(null);
        screenCenter();


        openWindow.setLayout(null);

    }

    private void screenCenter() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int frameWidth = getWIDTH();
        int frameHeight = getHEIGHT();

        int x = ((screenWidth - frameWidth) / 2);
        int y = ((screenHeight - frameHeight) / 2);

        openWindow.setLocation(x, y);
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

}
