import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Player extends Globalpositioning
{
    private String MAINCHAR = "/MAINCHAR.png";
    private int xMultiplier;
    private int yMultiplier;
    private int status;
    private String age;
    private int speed;
    
    public Player(int x, int y){
        super(x, y);
        xMultiplier = 1;
        yMultiplier = 1;
        status = 0;
        int z = (int)(Math.random()*3);
        if (z == 0)
            age = "Normal";
        else if (z == 1)
            age = "Kid";
        else if (z == 2)
            age = "Old";
        speed();
    }
    
    public void speed()
    {
        if (age.equals("Kid"))
            speed = 6;
        else if (age.equals("Normal"))
            speed = 4;
        else if (age.equals("Old"))
            speed = 3;
    }
    
    public void update(){
        if (y > 1080 || y<0)
            yMultiplier *= -1;
        if (x>1920 || x<0)
            xMultiplier *= -1;
        x = x + speed * xMultiplier;
        y = y + speed * yMultiplier;
    }
    
    public void draw(Graphics2D carrot2d){
        carrot2d.drawImage(getPlayerImage(), x, y, null);
    }
    
    public Image getPlayerImage(){
        ImageIcon pla = new ImageIcon(getClass().getResource(MAINCHAR));
        return pla.getImage();
    }
    
}
