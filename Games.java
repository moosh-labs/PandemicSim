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

    private final long serialVersionUID = 1L;

    private String background;
    ImageIcon backgr;
    private int totalNumOfInfected;
    Timer gametimer;    
    List <Player> protag;
    private boolean social;
    private TimeUnit time;
    private double percento;
    private int kidsInfected;
    private int adultsInfected;
    private int oldInfected;
    private int totalHealthy;
    private int kidsHealthy;
    private int adultsHealthy;
    private int oldHealthy;

    private int totalDead;
    private int kidsDead;
    private int adultsDead;
    private int oldDead;
    private boolean map;
    private int numPoor;
    private int numRich;
    
    public Games(int numOfPeople, int totalNumOfInfected, boolean social, double percento, boolean map){
        setFocusable(true);
        gametimer = new Timer(10, this);
        gametimer.start();
        this.social = social;
        protag = new ArrayList();
        if (map)
            background =  "/Pansim_city_2_FORREAL.png";
        else background = "/PANCITYHD.png";
        this.backgr = new ImageIcon(getClass().getResource(background));
        this.percento = percento;
        kidsInfected = 0;
        adultsInfected = 0;
        oldInfected = 0;
        kidsHealthy = 0;
        adultsHealthy = 0;
        oldHealthy = 0;
        kidsDead = 0;
        adultsDead = 0;
        oldDead = 0;
        this.map = map;
        numPoor = (int)(numOfPeople*.66666) + 1;
        numRich = (int)(numOfPeople*.33333);
        totalHealthy = numOfPeople - totalNumOfInfected;
        this.totalNumOfInfected = totalNumOfInfected;
        totalDead = 0;
        addPeople(numOfPeople);
    }

    public void addPeople(int num)
    {
        int r = 0;
        for(int i = 0; i<numPoor; i++)
        {
            int x = (int)(Math.random()*700+5);
            
            int y = (int)(Math.random()*350+600);
            protag.add(new Player(x,y));
        }
        for (int j = 0; j<numRich; j++)
        {
            int x = (int)(Math.random()*700+700);
            
            int y = (int)(Math.random()*350);
            protag.add(new Player(x,y));
        }
        if(totalNumOfInfected != 0)
        {
            for (int a = 0; a<totalNumOfInfected; a++)
            {
                int b = (int)(Math.random()*protag.size());
                if (protag.get(b).getStatus() == 1 || protag.get(b).getStatus() == 2)
                    a--;
                else  {protag.get(b).setStatus();
                    if (protag.get(b).getAge().equals("Kid"))
                        kidsInfected++;
                    else if (protag.get(b).getAge().equals("Normal"))
                        adultsInfected++;
                    else if (protag.get(b).getAge().equals("Old"))
                        oldInfected++;
                }
            }
        }

    }

    public void getInfected1()
    {

    }

    public int getTotalSick()
    {
        return totalNumOfInfected;
    }
    public int getTotalHealthy()
    {
        return totalHealthy;
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

    public void distancesocial(){

        if (!social)
        {
            for(int i = 0; i<protag.size(); i++)
            {
                protag.get(i).update(map);
            }
        }

        else {
            for(int i = 0; i<protag.size(); i++)
            {
                for(int j = 0; j<protag.size(); j++)
                {
                    if(j != i){
                        if ((protag.get(i).getX()-protag.get(j).getX())<2&&(protag.get(i).getX()-protag.get(j).getX())>0)
                        {
                            protag.get(i).update(3);
                            protag.get(j).update(2);
                        }
                        else{
                            if (protag.get(i).getX()-protag.get(j).getX()>-2&&protag.get(i).getX()-protag.get(j).getX()<0)
                            {
                                protag.get(i).update(2);
                                protag.get(j).update(3);
                            }
                            else{
                                if (protag.get(i).getY()-protag.get(j).getY()<2&&protag.get(i).getY()-protag.get(j).getY()>0)
                                {
                                    protag.get(i).update(1);
                                    protag.get(j).update(0);
                                }
                                else{
                                    if (protag.get(i).getY()-protag.get(j).getY()>-2&&protag.get(i).getY()-protag.get(j).getY()<0)
                                    {
                                        protag.get(i).update(0);
                                        protag.get(j).update(1);
                                    }
                                    protag.get(i).update(map);
                                }
                            }
                        }
                    }
                }
            } 
            for (int e = (int)(protag.size()*(percento/100)); e<protag.size(); e++)
            {
                protag.get(e).update();
            }
        }
    }

    public void actionPerformed(ActionEvent e){
        distancesocial();
        int tempKid = 0;
        int tempAdult = 0;
        int tempOld = 0;
        int tempHealthy = 0;

        for(int i = 0; i<protag.size(); i++)
        {
            for(int j = 0; j<protag.size(); j++)
            {
                if (protag.get(i).getStatus() == 1)
                    break;
                else if (protag.get(j).getStatus() == 1)
                {
                    double z = Math.random();//this is the likelihood of getting infected, depends on virus, edit later
                    if (Math.abs(protag.get(i).getX()-protag.get(j).getX())<5) //3 should change depending on the virus, edit later
                    {
                        if (z<0.004)
                        {
                            protag.get(i).setStatus();
                            totalNumOfInfected++;
                            if (protag.get(i).getAge().equals("Kid"))
                                kidsInfected++;
                            else if (protag.get(i).getAge().equals("Normal"))
                                adultsInfected++;
                            else if (protag.get(i).getAge().equals("Old"))
                                oldInfected++;
                        }
                    }
                    else if (Math.abs(protag.get(i).getX()-protag.get(j).getX())<10) //3 should change depending on the virus, edit later
                    {
                        if (z<0.003)
                        {
                            protag.get(i).setStatus();
                            totalNumOfInfected++;
                            if (protag.get(i).getAge().equals("Kid"))
                                kidsInfected++;
                            else if (protag.get(i).getAge().equals("Normal"))
                                adultsInfected++;
                            else if (protag.get(i).getAge().equals("Old"))
                                oldInfected++;
                        }
                    }
                    else if (Math.abs(protag.get(i).getX()-protag.get(j).getX())<20) //3 should change depending on the virus, edit later
                    {
                        if (z<0.002)
                        {
                            protag.get(i).setStatus();
                            totalNumOfInfected++;
                            if (protag.get(i).getAge().equals("Kid"))
                                kidsInfected++;
                            else if (protag.get(i).getAge().equals("Normal"))
                                adultsInfected++;
                            else if (protag.get(i).getAge().equals("Old"))
                                oldInfected++;
                        }
                    }
                    if (Math.abs(protag.get(i).getY()-protag.get(j).getY())<5) //3 should change depending on the virus, edit later
                    {
                        if (z<0.004)
                        {
                            protag.get(i).setStatus();
                            totalNumOfInfected++;
                            if (protag.get(i).getAge().equals("Kid"))
                                kidsInfected++;
                            else if (protag.get(i).getAge().equals("Normal"))
                                adultsInfected++;
                            else if (protag.get(i).getAge().equals("Old"))
                                oldInfected++;
                        }
                    }
                    else if (Math.abs(protag.get(i).getY()-protag.get(j).getY())<10) //3 should change depending on the virus, edit later
                    {
                        if (z<0.003)
                        {
                            protag.get(i).setStatus();
                            totalNumOfInfected++;
                            if (protag.get(i).getAge().equals("Kid"))
                                kidsInfected++;
                            else if (protag.get(i).getAge().equals("Normal"))
                                adultsInfected++;
                            else if (protag.get(i).getAge().equals("Old"))
                                oldInfected++;
                        }
                    }
                    else if (Math.abs(protag.get(i).getY()-protag.get(j).getY())<20) //3 should change depending on the virus, edit later
                    {
                        if (z<0.002)
                        {
                            protag.get(i).setStatus();
                            totalNumOfInfected++;
                            if (protag.get(i).getAge().equals("Kid"))
                                kidsInfected++;
                            else if (protag.get(i).getAge().equals("Normal"))
                                adultsInfected++;
                            else if (protag.get(i).getAge().equals("Old"))
                                oldInfected++;
                        }
                    }
                }

            }
            if(protag.get(i).getStatus() == 1){
                if (protag.get(i).death())
                {totalNumOfInfected--;
                    if (protag.get(i).getAge().equals("Kid"))
                    {
                        kidsInfected--;
                        kidsDead++;
                    }
                    else if (protag.get(i).getAge().equals("Normal"))
                    {
                        adultsInfected--;
                        adultsDead++;
                    }
                    else if (protag.get(i).getAge().equals("Old"))
                    {
                        oldInfected--;
                        oldDead++;
                    }
                    totalDead++;
                }
            }
        }
        
        
        for (int i = 0; i<protag.size(); i++)
        {
            if (protag.get(i).getStatus() == 0)
            {
                if (protag.get(i).getAge().equals("Kid"))
                    tempKid++;
                else if (protag.get(i).getAge().equals("Normal"))
                    tempAdult++;
                else if (protag.get(i).getAge().equals("Old"))
                    tempOld++;
                tempHealthy++;
            }

        }
        kidsHealthy = tempKid;
        adultsHealthy = tempAdult;
        oldHealthy = tempOld;
        totalHealthy = tempHealthy;

        repaint();
    }
}