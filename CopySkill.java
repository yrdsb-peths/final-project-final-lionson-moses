import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CopySkill here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CopySkill extends Actor
{
    /**
     * Act - do whatever the CopySkill wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CopySkill()
    {
        setImage("bulletImage.png");
    }
    //moving
    public void act()
    {
        setLocation(getX() , getY() - 3);
        Instruction world = (Instruction) getWorld();
        
        if(getY() <= 0  )
        {
            world.removeObject(this);
        }
        
    }
}
