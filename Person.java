
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Person
{
    private int status;
    private String age;
    private Position position; //figure out how to do this correctly
    private double speed;
    public Person()
    {
        status = 0;
        age = "Normal";
        speed();
    }
    
    public Person(int status)
    {
        this.status = status;
        age = "Normal";
        speed();
    }
    
    public Person(int status, String age)
    {
        this.status = status;
        this.age = age;
        speed();
    }
    
    public Person(String age)
    {
        status = 0;
        this.age = age;
        speed();
    }
    
    public void speed()
    {
        if (age.equals("kid"))
            speed = 6;
        else if (age.equals("Normal"))
            speed = 4;
        else if (age.equals("Old"))
            speed = 3;
    }
    
    public void updateStatus()
    {
        /**add the position function to see if there are 2 people close to each other */
        if (status != 1)
            status = 1;
        
    }
    
    public double returnSpeed()
    {
        return speed;
    }
    
    public int returnStatus()
    {
        return status;
    }
    
    public String returnAge()
    {
        return age;
    }
}
