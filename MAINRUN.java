
/**
 * Write a description of class MAINRUN here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import javax.swing.JFrame;
public class MAINRUN{

    public static void main(String args[])
    {
        JFrame frame = new JFrame();
        frame.pack();
        frame.setSize(640,480);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Games(5));
        frame.setVisible(true);
    }
}
