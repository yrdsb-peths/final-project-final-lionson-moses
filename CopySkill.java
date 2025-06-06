import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * CopySkill.
 * 
 * @Moses and Lionson 
 * @v1.0
 */
public class CopySkill extends Actor
{
    //same as origin skill
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
