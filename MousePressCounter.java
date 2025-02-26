import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Displays a count of the number of times the mouse has been pressed in the window.
 * Reset button to make the counter 0.
 * 
 * @author Nick Zica & Donato Venditti
 * @version Spring 2025
 */
public class MousePressCounter extends MouseAdapter implements Runnable, ActionListener {
    private int clicks;
    JLabel clickCount = new JLabel("Number of Clicks: " + clicks);
    private int counter;
    JButton reset = new JButton("reset");

    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("MouseDemo");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // construct an anonymous class that extends JPanel,
        // for which we override the paintComponent method
        JPanel panel = new JPanel(new GridLayout(2, 1)) {
            @Override
            public void paintComponent(Graphics g) {

                super.paintComponent(g);

                //FontMetrics fm = g.getFontMetrics();

                // String toDisplay = "Click and See!";
                // int stringWidth = fm.stringWidth(toDisplay);
                // int stringAscent = fm.getAscent();

                // int xStart = getWidth() / 2 - stringWidth / 2;
                // int yStart = getHeight() / 2 + stringAscent / 2;

                // g.drawString(toDisplay, xStart, yStart);
            }
        };
        frame.add(panel);
        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);
        panel.addMouseWheelListener(this);

        Font big = new Font("Arial", Font.PLAIN, 40);
        clickCount.setFont(big);
        panel.add(clickCount);

        panel.add(reset);
        reset.addActionListener(this);

        // display the window we've created
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        counter = counter + e.getButton();
        clickCount.setText("Number of Clicks: " + counter);
    }

    public interface ActionListener {
        public void actionPerformed(ActionEvent e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reset) {
            counter = 0;
            clickCount.setText("Number of Clicks: " + counter);
        }
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new MousePressCounter());
    }
}
