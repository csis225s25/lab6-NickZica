import java.awt.*;
import javax.swing.*;

/**
 * Art Project
 * 
 * @author Nick Zica & Donato Venditti
 * @version Spring 2025
 */

// a class that extends JPanel to override the paintComponent method,
// allowing us to interact with Java's graphics system
class GraphicsPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {

        // first, we should call the paintComponent method we are
        // overriding in JPanel
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillRect(20,20,200,200);
        g.setColor(Color.GREEN);
        g.fillArc(150, 200, 900, 500, 20, 400);
        g.setColor(Color.magenta);
        g.fillOval(300, 20, 200, 100);
        g.setColor(Color.orange);
        g.drawLine(0,500, 500, 0);
        g.setColor(Color.pink);
        g.fillOval(0,400, 140, 200);

        String str = "Nick Zica & Donato Venditti";
        Font newFont = new Font("Sylfaen", Font.PLAIN, 15);
        g.setColor(Color.yellow);
        g.setFont(newFont);


        int width = g.getFontMetrics().stringWidth(str)/2;
        int height = g.getFontMetrics().getAscent();


        // the Graphics object passed to this method has many methods
        // we can use to draw in the area of the panel, one of which
        // allows us to draw a String at a given x,y position
        
        g.drawString(str, getWidth()/2 - width - 140, getHeight()/2 - height + 50);
    }
}

public class ArtProject implements Runnable {

    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {

        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Art Project");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // construct JPanel with a custom paintComponent method
        JPanel panel = new GraphicsPanel();
        panel.setBackground(Color.blue);
        frame.add(panel);

        // display the window we've created
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new ArtProject());
    }
}
