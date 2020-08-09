import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.*;

public class Games extends JPanel implements ActionListener{

    private static final long serialVersionUID = 1L;

    private String background = "/map.png";
    ImageIcon backgr;
    private int numOfInfected;
    Timer gametimer;    
    List <Player> protag;

    public Games(int numOfPeople, int numOfInfected){
        setFocusable(true);
        gametimer = new Timer(10, this);
        gametimer.start();
        protag = new ArrayList();
        this.numOfInfected = numOfInfected;
        this.backgr = new ImageIcon(getClass().getResource(background));
        addPeople(numOfPeople);
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
        {
            protag.get(i).update();
        }
        for(int i = 0; i<protag.size(); i++)
        {
            for(int j = 0; i<protag.size(); i++)
            {
                if (protag.get(i).getStatus() == 1)
                    break;
                else 
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
