package window;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Toolkit;

public class windows extends GamePanel {

    private int WIDTH, HEIGHT;

    private String TITLE;

    private ImageIcon iamgeBackGround = new ImageIcon("D:\\NONE\\C++\\Opengl\\resource\\Anime_1.jpg");

    private JLabel laAddBackground = new JLabel("", iamgeBackGround, JLabel.CENTER);

    private JButton btnLand;

    private JFrame openWindow;

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

        openWindow.getContentPane().add(laAddBackground);


        openWindow.setLayout(null);
        GamePanel game = new GamePanel();

        openWindow.add(game);

        screenCenter();

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
