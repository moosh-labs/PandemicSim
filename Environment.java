
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
    private int potato;
    
    public Environment(int size)
    {
    this.size = size;
    virus = "Covid19";
    infected = 0;
    infected = (int) (Math.random() * 10 + 1);
    }
    public Environment(int size, String virus)
    {
    this.size = size;
    this.virus = virus;
    infected = 0;
    infected = (int) (Math.random() * 10 + 1);
    }
    public Environment(int size, String virus, int infected)
    {
    this.size = size;
    this.virus = virus;
    this.infected = infected;
    }
}
