import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoubleBulletsAbility here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoubleBulletsAbility extends Actor
{
    /**
     * Act - do whatever the DoubleBulletsAbility wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public DoubleBulletsAbility()
    {
        setImage("DoubleBullets.jpg");
    }
    
    public void act()
    {
        isHit();
    }
    public boolean isHit()
    {
        setLocation(getX() , getY() + 1);
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Jet.class))
        {
            Greenfoot.playSound("gaingift.mp3");
            //world.removeObject(this);
            return true ;
        }
        else
        {
            return false ;
        }
       
    }
    
}
