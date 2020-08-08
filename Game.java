
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionListener;
public class Game extends JPanel implements ActionListener
{
    private static final long serialVersionUID = 1L;
    Timer gameLoopTimer;
    public Game()
    {
        setFocusable(true);
        gameLoopTimer = new Timer(10, this);
        gameLoopTimer.start();
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        
    }
}
