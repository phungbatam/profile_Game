package src;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import src.mainGame.winMainGame;

public class Windows extends JFrame {

    private JButton btnLand;

    private ImageIcon imgBackground = new ImageIcon(
            "D:\\Project\\Game engine Soladtion Adventure\\library\\Image\\windowForBackground.jpg");

    private JLabel addImagebackground;

    protected Windows() {
        this.setTitle("Game");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        addImagebackground = new JLabel("", imgBackground, JLabel.CENTER);
        addImagebackground.setBounds(0, 0, 1200, 700);
        this.add(addImagebackground);
        this.add(BtnPlay());
        this.setSize(1200, 700);
        this.setLayout(null);
        this.setVisible(true);
    }

    private JButton BtnPlay() {
        btnLand = new JButton(getName(), null);
        btnLand.setText("Land");
        btnLand.setBackground(new Color(135,192,236));
        btnLand.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        btnLand.setForeground(Color.BLACK);

        btnLand.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dispose();
                    new winMainGame().setVisible(true);
                } catch(Exception ex){
                    ex.printStackTrace();
                }

            }
        
        });

        btnLand.setSize(135, 45);
        btnLand.setLocation(1000, 570);
        return btnLand;
    }

}
