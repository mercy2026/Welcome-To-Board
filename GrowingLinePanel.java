import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;

import javax.swing.JPanel;

class GrowingLinePanel extends JPanel {
	
	 private int currentWidth = 56; // Initial width of the line
	 private final int lineHeight = 5;
	
	public GrowingLinePanel() {
        setSize(currentWidth, lineHeight);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK); // Set the line color to black
        g.fillRect(0, 0, currentWidth, lineHeight); // Horizontal line
    }
    
    public void increaseWidth(int increment) {
        currentWidth += increment;
        setSize(currentWidth, lineHeight);
        repaint();
    }
    
    public void resetLine() {
    	currentWidth = 56;//113
    	setSize(currentWidth, this.lineHeight);
    	repaint();
    	setVisible(false);
    }
}
