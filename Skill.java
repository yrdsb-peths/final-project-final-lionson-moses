import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Skill of Jet, spend energy for a huge bullet
 * 
 * @Lionson and Moses
 * @v2.0
 */
public class Skill extends Actor
{
    public Skill()
    {
        setImage("bulletImage.png");
    }
    //moving
    public void act()
    {
        setLocation(getX() , getY() - 3);
        MyWorld world = (MyWorld) getWorld();
        
        if(getY() <= 0  )
        {
            world.removeObject(this);
        }
        
    }
    
}
