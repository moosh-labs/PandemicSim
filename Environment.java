
/**
 * Write a description of class Environment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Environment
{
    private String virus;
    private int size;
    private int infected;
    
    public Environment(int size)
    {
        this.size = size;
        virus = "Covid19";
        infected = (int) (Math.random() * 10 + 1);
    }
    
    public Environment(int size, String virus)
    {
        this.size = size;
        this.virus = virus;
        infected = (int) (Math.random() * 10 + 1);
    }
    
    public Environment(int size, String virus, int infected)
    {
        this.size = size;
        this.virus = virus;
        this.infected = infected;
    }
    
    public String returnVirus()
    {
        return virus;
    }
    
    public int size()
    {
        return size;
    }
    
    public int returnInfected()
    {
        return infected;
    }
}
