import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jet extends Actor
{
    /**
     * Act - do whatever the Jet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       fly();
    }
    public void fly()
    {
         if(Greenfoot.isKeyDown("left"))
         {
             move(-5);
         }
         else if(Greenfoot.isKeyDown("right"))
         {
             move(5);
         }
    }
}
