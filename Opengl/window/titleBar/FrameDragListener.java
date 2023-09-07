package window.titleBar;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class FrameDragListener extends MouseAdapter{
    
    private final JFrame frameDrag;
    private Point mouseDragCoords = null;

    public FrameDragListener(JFrame frameDrag) {
        this.frameDrag = frameDrag;
    }

    public void mouseReleased(MouseEvent e) {
        mouseDragCoords = null;
    }

    public void mousePressed(MouseEvent e) {
        mouseDragCoords = e.getPoint();
    }

    public void mouseDragged(MouseEvent e) {
        Point currentCoords = e.getLocationOnScreen();
        frameDrag.setLocation(currentCoords.x - mouseDragCoords.x, currentCoords.y - mouseDragCoords.y);
    }

}
