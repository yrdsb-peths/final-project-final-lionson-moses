import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CopyBullets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CopyBullets extends Actor
{
    /**
     * Act - do whatever the CopyBullets wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CopyBullets()
    {
        GreenfootImage image = new GreenfootImage("bulletImage.png");
        image.scale(30 , 50);
        setImage(image);
    }
    // speed and optimization of bullet
    public void act()
    {
        setLocation(getX() , getY() - 7);
        Instruction world = (Instruction) getWorld();
        if(getY() <= 0 )
        {
            world.removeObject(this);
        }
    }
}
