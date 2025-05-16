import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bugs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bugs extends Actor
{
    /**
     * Act - do whatever the Bugs wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
    /*
     * this method check if there's any remain bugs exists
     * if so then nothing happen, else it will creat another wave
     * of bugs.
     */
    public void spawn()
    {
        if (getWorld().getObjects(Bugs.class) == null )
        {
            MyWorld world = (MyWorld) getWorld();
            world.creatBugs();
        }
    }
    
    public void creatBugs()
    {
        
    }
        
    }
}
