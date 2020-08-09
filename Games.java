
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Games extends JPanel implements ActionListener{

    private static final long serialVersionUID = 1L;

    private String background = "/Pancity1.png";
    ImageIcon backgr;
    private int numOfInfected;
    Timer gametimer;    
    List <Player> protag;
    private boolean social;
    private TimeUnit time;
    private int tim;
    public Games(int numOfPeople, int numOfInfected, boolean social){
        setFocusable(true);
        gametimer = new Timer(50, this);
        gametimer.start();
        this.social = social;
        protag = new ArrayList();
        this.numOfInfected = numOfInfected;
        this.backgr = new ImageIcon(getClass().getResource(background));
        addPeople(numOfPeople);
        tim = 0;
    }

    public void addPeople(int num)
    {
        for(int i = 0; i<num; i++)
        {
            int x = (int)(Math.random()*1810+5);
            int y = (int)(Math.random()*970+5);
            protag.add(new Player(x,y));
            /** can make 2 separate lists, one with healthy, one with infected, 
             */
        }
        if(numOfInfected !=0)
        for (int a = 0; a<numOfInfected; a++)
        {
            int b = (int)(Math.random()*protag.size());
            if (protag.get(b).getStatus() == 1)
                a--;
            else {protag.get(b).setStatus();
            
            }
        }
        
        
    }

    public void getInfected1()
    {

    }

    public void paint(Graphics carrot){
        super.paint(carrot);

        Graphics2D carrot2d = (Graphics2D) carrot;

        carrot2d.drawImage(getBackgroundImage(),0,0,null);

        for(int i = 0; i<protag.size(); i++)
        {
            protag.get(i).draw(carrot2d);
        }
        
    }

    public Image getBackgroundImage(){
        return backgr.getImage();
    }

    
    
    
    public void actionPerformed(ActionEvent e){
        for(int i = 0; i<protag.size(); i++)
            protag.get(i).update();
            
        
        for(int i = 0; i<protag.size(); i++)
        {
            for(int j = 0; i<protag.size(); i++)
            {
                if (protag.get(i).getStatus() == 1)
                    break;
                else if (protag.get(j).getStatus() == 1)
                {
                    double z = Math.random();//this is the likelihood of getting infected, depends on virsu, edit later
                    if (Math.abs(protag.get(i).getX()-protag.get(j).getX())<15) //3 should change depending on the virus, edit later
                    {
                        if (z<0.4)
                            protag.get(i).setStatus();
                    }
                    else if (Math.abs(protag.get(i).getX()-protag.get(j).getX())<30) //3 should change depending on the virus, edit later
                    {
                        if (z<0.3)
                            protag.get(i).setStatus();
                    }
                    else if (Math.abs(protag.get(i).getX()-protag.get(j).getX())<45) //3 should change depending on the virus, edit later
                    {
                        if (z<0.2)
                            protag.get(i).setStatus();
                    }
                    if (Math.abs(protag.get(i).getY()-protag.get(j).getY())<15) //3 should change depending on the virus, edit later
                    {
                        if (z<0.4)
                            protag.get(i).setStatus();
                    }
                    else if (Math.abs(protag.get(i).getY()-protag.get(j).getY())<30) //3 should change depending on the virus, edit later
                    {
                        if (z<0.3)
                            protag.get(i).setStatus();
                    }
                    else if (Math.abs(protag.get(i).getY()-protag.get(j).getY())<45) //3 should change depending on the virus, edit later
                    {
                        if (z<0.2)
                            protag.get(i).setStatus();
                    }
                }
                
            }
        }

        repaint();
    }
}
