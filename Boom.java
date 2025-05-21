import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boom extends Actor
{
    public Boom()
    {
        setImage("bulletImage.png");
    }
    public void act()
    {
        setLocation(getX() , getY() - 3);
        MyWorld world = (MyWorld) getWorld();
        if(getY() <= 0 )
        {
            world.removeObject(this);
        }
    }
}
