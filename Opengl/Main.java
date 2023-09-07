import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import window.windows;
import window.titleBar.FrameDragListener;
import window.titleBar.Button;

public class Main {

    private static boolean canProceed = true;

    public static void main(String[] args) throws InterruptedException {

        Random randLoadTime = new Random();

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                int randDomApp = (int) (randLoadTime.nextInt(2000) + (Math.tan(90) / Math.sin(589) / Math.sinh(50)));

                System.out.println("Time: " + randDomApp);

                try {
                    Thread.sleep(randDomApp);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
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

                        Border emtyBorder = BorderFactory.createEmptyBorder();
                        close.setBorder(emtyBorder);
                        minimize.setBorder(emtyBorder);

                        // openWindow.pack();
                        JPanel JP_Bar = new JPanel();
                        JLabel taskBar = new JLabel();
                        taskBar.setBounds(0, 0, 1280, 20);
                        taskBar.setOpaque(true);
                        taskBar.setBackground(new Color(0, 0, 0));
                        // taskBar.setToolTipText("task bar");
                        taskBar.add(close);
                        taskBar.add(minimize);
                        JP_Bar.setBounds(0, 0, 1000, 100);
                        JP_Bar.setLayout(null);
                        JP_Bar.add(taskBar);

                        openWindow.setUndecorated(true);

                        openWindow.setContentPane(JP_Bar);

                        openWindow.addMouseListener(drag);
                        openWindow.addMouseMotionListener(drag);
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