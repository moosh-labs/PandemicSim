
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Games extends JPanel implements ActionListener{

private static final long serialVersionUID = 1L;

    private String background = "/map.png";

    Timer gametimer;    
    Player protag;
    
    public Games(){
        setFocusable(true);
        
        gametimer = new Timer(10, this);
        gametimer.start();
        
        protag = new Player(300,100);
    }
    
    public void paint(Graphics carrot){
        super.paint(carrot);
        
        Graphics2D carrot2d = (Graphics2D) carrot;
        
        carrot2d.drawImage(getBackgroundImage(),0,0,null);
        
        protag.draw(carrot2d);
        
        
    }
    
    public Image getBackgroundImage(){
        ImageIcon backgr = new ImageIcon(getClass().getResource(background));
        return backgr.getImage();
    }
    
    public void actionPerformed(ActionEvent e){
        protag.update();
        repaint();
    }
}
