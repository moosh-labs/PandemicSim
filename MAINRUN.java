import java.applet.*;
import java.awt.*;
import java.awt.*;
import java.util.*;
import javax.swing.JFrame;
public class MAINRUN{

    public static void main(String args[])
    {
        JFrame frame = new JFrame();
        frame.pack();
        frame.setSize(1920,1080);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Games(10000, 2));
        frame.setVisible(true);
    }
}
