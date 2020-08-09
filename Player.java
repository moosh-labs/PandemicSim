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
    private String infectold = "/infectedelder.png";
    private String infectadult = "/infectedadult.png";
    private String infectchild = "/infectedchild.png"; 
    private String dead = "/deaded.png";

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
            if(status != 1)
            icon = new ImageIcon(getClass().getResource(Bigchar));
            else icon = new ImageIcon(getClass().getResource(infectadult));
        }
        else { if (z == 1){
        
            age = "Kid";
            if(status != 1)
            icon = new ImageIcon(getClass().getResource(Smallchar));
            else icon = new ImageIcon(getClass().getResource(infectchild));
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
                yMultiplier = -0.5*(Math.random());
                xMultiplier = Math.random()*2-1.;
            }
        else if (y<0)
            {
                yMultiplier = 0.5*(Math.random());
                xMultiplier = Math.random()*2-1;
            }
        if (x > 1820)
            {
                xMultiplier = -0.5*(Math.random());
                yMultiplier = Math.random()*2-1;
            }
        else if (x<0)
            {
                xMultiplier = 0.5*(Math.random());
                yMultiplier = Math.random()*2-1;
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
                yMultiplier = -0.5*(Math.random());
                xMultiplier = Math.random()*2-1;
            }
        else{ if (bounce == 1)
            {
                yMultiplier = 0.5*(Math.random());
                xMultiplier = Math.random()*2-1;
            }
        else{ if (bounce == 2)
            {
                xMultiplier = -0.5*(Math.random());
                yMultiplier = Math.random()*2-1;
            }
        else{ if (bounce == 3)
            {
                xMultiplier = 0.5*(Math.random());
                yMultiplier = Math.random()*2-1;
            }}}}
        x = x + xMultiplier;
        y = y + yMultiplier;
    }

    public void setStatus()
    {
        status = 1;
        if(age == "Normal")
        icon = new ImageIcon(getClass().getResource(infectold));
        else{ if(age == "Kid")
        {
            icon = new ImageIcon(getClass().getResource(infectchild));
        }
        else{ if(age == "Old")
        {
            icon = new ImageIcon(getClass().getResource(infectadult));
        }
    }
    }
    }
    
    public boolean death(){
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis()-start<1000){
            if(status == 1){
                if(age == "Old"){
                   if(Math.random() < 0.000000010){
                    icon = new ImageIcon(getClass().getResource(dead));
                    xMultiplier = 0;
                    yMultiplier = 0;
                    status = 2;
                    return true;
                   }
                }
                if(age == "Normal"){
                   if(Math.random() < 0.000000005){
                    icon = new ImageIcon(getClass().getResource(dead));
                    xMultiplier = 0;
                    yMultiplier = 0;
                    status = 2;
                    return true;
                    }
                }
                if(age == "Kid"){
                   if(Math.random() < 0.000000002){
                    icon = new ImageIcon(getClass().getResource(dead));
                    xMultiplier = 0;
                    yMultiplier = 0;
                    status = 2;
                    return true;
                    }
                }
            }
        }
        return false;
    }

    public String getAge()
    {
        return age;
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
