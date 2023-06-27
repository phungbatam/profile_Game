package src.mainGame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class winMainGame extends JFrame {

    private Image imgWinDown = Toolkit.getDefaultToolkit().getImage("D:\\Project\\Game engine Soladtion Adventure\\library\\Image\\logoWin.jpg");

    public winMainGame() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setIconImage(imgWinDown);
        this.getContentPane().setBackground(new Color(0, 0, 0));
        this.add(packWinMain());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
         this.setSize(screenWidth, screenHeight);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
    }
    
    private Component packWinMain() {
        runComponentMainGame mainGame = new runComponentMainGame();
        this.add(mainGame);
        pack();
        return mainGame;
    }


}
