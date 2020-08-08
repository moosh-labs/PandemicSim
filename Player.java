import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Player extends Globalpositioning
{
    private String MAINCHAR = "/MAINCHAR.png";
    private int xMultiplier;
    private int yMultiplier;
    
    public Player(int x, int y){
        super(x, y);
        xMultiplier = 1;
        yMultiplier = 1;
    }
    
    public void update(){
        if (y == 480 || y==0)
            yMultiplier *= -1;
        if (x==640 || x==0)
            xMultiplier *= -1;
        x = x + 2 * xMultiplier;
        y = y + 2 * yMultiplier;
    }
    
    public void draw(Graphics2D carrot2d){
        carrot2d.drawImage(getPlayerImage(), x, y, null);
    }
    
    public Image getPlayerImage(){
        ImageIcon pla = new ImageIcon(getClass().getResource(MAINCHAR));
        return pla.getImage();
    }
    
}
