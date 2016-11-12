package swing;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author pablo
 */
public class Basics {
    
    private JFrame frame;
    
    /**
     * Launch the application
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Basics window = new Basics();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the aṕplication.
     */
    public Basics() {
        initialize();
    }
    
    /**
     * Initialize the contents of the frame
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
