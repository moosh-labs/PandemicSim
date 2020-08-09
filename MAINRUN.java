
import java.applet.*;
import java.awt.*;
import java.util.*;
import javax.swing.JFrame;
import java.lang.*;
public class MAINRUN{

    public static void main(String args[])
    {
        JFrame frame = new JFrame();
        frame.pack();
        frame.setSize(1920,1080);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis()-start<2000){}
        frame.add(new Games(50, 10, true, 80, true));
        frame.setVisible(true);
    }
}