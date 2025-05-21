import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gift here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gift extends Actor
{
    public void act()
    {
        
        setLocation(getX() , getY() + 2);
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Jet.class))
        {
            world.energy++;
            world.removeObject(this);
        }
    }
}
