import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Player extends Globalpositioning
{
    private String MAINCHAR = "/MAINCHAR.png";
    
    public Player(int x, int y){
        super(x, y);
    }
    
    public void update(){
        y+=2;
        x+=1;
    }
    
    public void draw(Graphics2D carrot2d){
        carrot2d.drawImage(getPlayerImage(), x, y, null);
    }
    
    public Image getPlayerImage(){
        ImageIcon pla = new ImageIcon(getClass().getResource(MAINCHAR));
        return pla.getImage();
    }
    
}
