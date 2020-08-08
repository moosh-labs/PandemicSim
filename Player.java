import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;



public class Player extends Globalpositioning
{
    private ImageIcon icon;
    private double xMultiplier;
    private double yMultiplier;
    private int status;
    private String age;
    private int speed;

    public Player(double x, double y){
        super(x, y);
        String MAINCHAR = "/myimage.png";
        icon = new ImageIcon(getClass().getResource(MAINCHAR));
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
        if (Math.random()<0.5)
            xMultiplier *= -1;
        if (Math.random()<0.5)
            yMultiplier *= -1;
    }

    public void update(){
        if (y > 980)
            {
                yMultiplier = -1*(Math.random()*2+1);
                xMultiplier = Math.random()*4-2;
            }
        else if (y<0)
            {
                yMultiplier = 1*(Math.random()*2+1);
                xMultiplier = Math.random()*4-2;
            }
        if (x > 1820)
            {
                xMultiplier = -1*(Math.random()*2+1);
                yMultiplier = Math.random()*4-2;
            }
        else if (x<0)
            {
                xMultiplier = 1*(Math.random()*2+1);
                yMultiplier = Math.random()*4-2;
            }
        x = x + xMultiplier;
        y = y + yMultiplier;
    }

    public void setStatus()
    {
        status = 1;
    }
    
    public int getStatus()
    {
        return status;
    }
    
    public double getX()
    {
        return x;
    }
    
    public double getY()
    {
        return y;
    }
    
    public Image getJFrame()
    {
        
    }
    
    public void draw(Graphics2D carrot2d)
    {
        carrot2d.drawImage(getPlayerImage(), (int)x, (int)y, null);
    }

    public Image getPlayerImage(){
        
        return icon.getImage();
    }
    
}
