import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Bullets extends Actor
{
    public Bullets()
    {
        setImage("bulletImage.jpg");
    }
    /**
     * Act - do whatever the Bullets wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX() , getY() - 7);
        MyWorld world = (MyWorld) getWorld();
        if(getY() <= 0 )
        {
            world.removeObject(this);
        }
    }
}
