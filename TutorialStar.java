import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialStar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialStar extends Actor
{
    /**
     * Act - do whatever the TutorialStar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TutorialStar()
    {
        setImage("red-draught.png");
    }
    public void act()
    {
        hit();
    }
    public boolean hit()
    {
        if(isTouching(Jet.class) || isTouching( CopyBullets.class ))
        {
            getWorld().removeObject(this) ;
            return true ;
        }
        else
        {
            return false ;
        }
    }
}
