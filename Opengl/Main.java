import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import window.windows;
import window.titleBar.FrameDragListener;
import window.titleBar.Button;

public class Main {

    private static boolean canProceed = true;

    private static ImageIcon iconPeach_Blossom = new ImageIcon("D:\\NONE\\C++\\Opengl\\resource\\peach_blossom.png");

    public static void main(String[] args) throws InterruptedException {

        Random randLoadTime = new Random();
        Cursor cursorHanld = new Cursor(Cursor.HAND_CURSOR);

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                int randDomApp = (int) (randLoadTime.nextInt(2000) + (Math.tan(90) / Math.sin(589) / Math.sinh(50)));

                System.out.println("Time: " + randDomApp);

                try {
                    Thread.sleep(randDomApp);
                    for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch(ClassNotFoundException ex){
                    java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }

                try {
                    if (canProceed) {
                        JFrame openWindow = new JFrame();

                        FrameDragListener drag = new FrameDragListener(openWindow);

                        Button close = new Button();
                        close.setText("X");
                        close.setFocusable(false);
                        close.setToolTipText("Close");
                        close.setBackground(Color.decode("#0000000"));
                        // close.setCursor(cursorHanld);
                        close.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                openWindow.dispose();
                            }

                        });
                        close.setBounds(0, 0, 30, 20);
                        // close.setRadius(5);

                        Button minimize = new Button();
                        minimize.setText("-");
                        minimize.setFocusable(false);;
                        minimize.setToolTipText("minimize");
                        minimize.setBackground(Color.decode("#0000000"));
                        minimize.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                openWindow.setExtendedState(JFrame.ICONIFIED);
                            }

                        });

                        minimize.setBounds(30, 0,30, 20);
                        
                        // Button peach_blossom = new Button();
                        // peach_blossom.setFocusable(false);
                        // peach_blossom.setIcon(iconPeach_Blossom);
                        // peach_blossom.setBackground(Color.decode("#00000000"));
                        // peach_blossom.setBounds(60, 0, 30, 20);
                         

                        Border emtyBorder = BorderFactory.createEmptyBorder();
                        close.setBorder(emtyBorder);
                        minimize.setBorder(emtyBorder);
                        // peach_blossom.setBorder(emtyBorder);

                        // openWindow.pack();
                        JPanel JP_Bar = new JPanel();

                        JLabel taskBar = new JLabel("",iconPeach_Blossom,JLabel.RIGHT);
           
                        taskBar.setBounds(0, 0, 1280, 20);
                        taskBar.setOpaque(true);
                        taskBar.setBackground(new Color(0, 0, 0));
                        taskBar.add(close);
                        taskBar.add(minimize);
                        // taskBar.add(peach_blossom);

                        JP_Bar.setBounds(0, 0, 1000, 100);
                        JP_Bar.setLayout(null);
                        JP_Bar.add(taskBar);

                        openWindow.setUndecorated(true);
                        openWindow.setContentPane(JP_Bar);
                        openWindow.addMouseListener(drag);
                        openWindow.addMouseMotionListener(drag);
                        openWindow.setLayout(null);
                        openWindow.setUndecorated(true);
                        openWindow.setVisible(true);

                        new windows(openWindow, 1280, 680, "Super Coder");
                    }
                } catch (InternalError ex) {
                    ex.printStackTrace();
                } catch (Exception err) {
                    err.printStackTrace();
                }

            }

        });

    }
}
