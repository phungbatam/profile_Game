package window.titleBar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class Button extends JButton {

    private boolean Over;

    private Color color, colorOver, colorClick, borderColor;

    private int radius = 0;

    public Button() {

        setColor(Color.WHITE);
        colorOver = new Color(200, 0, 0);
        colorClick = new Color(0,0,0);
        color = Color.decode("#0000000");
        borderColor = new Color(0,0,0);

        setContentAreaFilled(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(colorOver);
                Over = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(color);
                Over = true;

            }

            @Override
            public void mousePressed(MouseEvent me) {
                setBackground(colorClick);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (Over) {
                    setBackground(colorOver);
                } else {
                    setBackground(color);
                }
            }
        });

    }

    public boolean isOver() {
        return Over;
    }

    public void setOver(boolean over) {
        Over = over;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public Color getColorOver() {
        return colorOver;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    protected void paintComponent(Graphics g) {

        Color text;
        text = Color.decode("#ffffff");

        Graphics2D graph2 = (Graphics2D) g;

        graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graph2.setColor(borderColor);
        graph2.fillRoundRect(0, 0, 500, 400, radius, radius);
        graph2.setColor(getBackground());

        graph2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);

        setForeground(text);
        super.paintComponent(g);
    }

}
