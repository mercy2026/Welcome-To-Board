import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

class CirclePanels extends JPanel {
	 
	private final Point point;

    public CirclePanels(Point point) {
        this.point = point;
        setOpaque(false);
        setBounds(0, 0, 1000, 800); // Adjust as needed
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        g.drawOval(point.x, point.y, 20, 20); // Hollow circle
    }
	
    /*public CirclePanels() {
        setOpaque(false);
        setSize(20, 20);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawOval(0, 0, 15, 15);
    }*/
}