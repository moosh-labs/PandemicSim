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
    private String badpeep = "/infected.png";


    public Player(double x, double y){
        super(x, y);
        String MAINCHAR = "/myimage.png";
        String Smallchar = "/Childsim.png";
        String Bigchar = "/Adultsim.png";
        String Oldchar = "/Eldersim.png";



        icon = new ImageIcon(getClass().getResource(MAINCHAR));
        xMultiplier = Math.random()*2;
        yMultiplier = Math.random()*2;
        status = 0;
        int z = (int)(Math.random()*3);
        if (z == 0)
        {
            age = "Normal";
            icon = new ImageIcon(getClass().getResource(Bigchar));
        }
        else { if (z == 1){
        
            age = "Kid";
            icon = new ImageIcon(getClass().getResource(Smallchar));
        }
        else { if (z == 2)
        {
            age = "Old";
            icon = new ImageIcon(getClass().getResource(Oldchar));
        }}}
        speed();
    }
    
    
    
    public void speed()
    {
        double num = Math.random();
        if (num<0.25){
            xMultiplier *= -1;
            yMultiplier *= 1;
        }
        else if (num<0.5){
            yMultiplier *= -1;
            xMultiplier *= -1;
        }
        else if (num<0.75){
            yMultiplier *= 1;
            xMultiplier *= -1;
        }
        else {
            yMultiplier *= 1;
            xMultiplier *= 1;
        }
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
        if (xMultiplier<0 && xMultiplier>-1)
            xMultiplier = -1;
        else if (xMultiplier > 0 && xMultiplier<1)
            xMultiplier = 1;
        if (yMultiplier<0 && yMultiplier>-1)
            yMultiplier = -1;
        else if (yMultiplier > 0 && yMultiplier<1)
            yMultiplier = 1;
        x = x + xMultiplier;
        y = y + yMultiplier;
    }
    
    public void update(int bounce){
        

        if (bounce == 0)
            {
                yMultiplier = -1*(Math.random()*2+1);
                xMultiplier = Math.random()*4-2;
            }
        else{ if (bounce == 1)
            {
                yMultiplier = 1*(Math.random()*2+1);
                xMultiplier = Math.random()*4-2;
            }
        else{ if (bounce == 2)
            {
                xMultiplier = -1*(Math.random()*2+1);
                yMultiplier = Math.random()*4-2;
            }
        else{ if (bounce == 3)
            {
                xMultiplier = 1*(Math.random()*2+1);
                yMultiplier = Math.random()*4-2;
            }}}}
        x = x + xMultiplier;
        y = y + yMultiplier;
    }

    public void setStatus()
    {
        status = 1;
        icon = new ImageIcon(getClass().getResource(badpeep));
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
    
    public void draw(Graphics2D carrot2d){
        
        carrot2d.drawImage(getPlayerImage(), (int)x, (int)y, null);
    }

    public Image getPlayerImage(){
        
        return icon.getImage();
    }
    
}
