import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullets extends Actor
{
    /**
     * Act - do whatever the Bullets wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    /*
     * this check if the bullets is touching bugs, 
     * and if so it delete both bugs getting hit and the bullet
     */
    public void hit()
    {
        if(isTouching(Bugs.class))
        {
            removeTouching(Bugs.class);
            /*
             * need to remove both bugs and the bullets.
             */
            
            
            
        }
    }
}
